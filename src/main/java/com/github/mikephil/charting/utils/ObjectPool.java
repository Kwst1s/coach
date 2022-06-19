package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        /* access modifiers changed from: protected */
        public abstract Poolable instantiate();
    }

    private ObjectPool(int i2, T t) {
        if (i2 > 0) {
            this.desiredCapacity = i2;
            this.objects = new Object[i2];
            this.objectsPointer = 0;
            this.modelObject = t;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool create(int i2, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i2, poolable);
            int i3 = ids;
            objectPool.poolId = i3;
            ids = i3 + 1;
        }
        return objectPool;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void resizePool() {
        int i2 = this.desiredCapacity;
        int i3 = i2 * 2;
        this.desiredCapacity = i3;
        Object[] objArr = new Object[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            objArr[i4] = this.objects[i4];
        }
        this.objects = objArr;
    }

    public synchronized T get() {
        T t;
        if (this.objectsPointer == -1 && this.replenishPercentage > Utils.FLOAT_EPSILON) {
            refillPool();
        }
        Object[] objArr = this.objects;
        int i2 = this.objectsPointer;
        t = (T) ((Poolable) objArr[i2]);
        t.currentOwnerId = Poolable.NO_OWNER;
        this.objectsPointer = i2 - 1;
        return t;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }

    public int getPoolId() {
        return this.poolId;
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    public synchronized void recycle(T t) {
        int i2 = t.currentOwnerId;
        if (i2 == Poolable.NO_OWNER) {
            int i3 = this.objectsPointer + 1;
            this.objectsPointer = i3;
            if (i3 >= this.objects.length) {
                resizePool();
            }
            t.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer] = t;
        } else if (i2 == this.poolId) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }

    public void setReplenishPercentage(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < Utils.FLOAT_EPSILON) {
            f2 = Utils.FLOAT_EPSILON;
        }
        this.replenishPercentage = f2;
    }

    private void refillPool(float f2) {
        int i2 = this.desiredCapacity;
        int i3 = (int) (((float) i2) * f2);
        if (i3 < 1) {
            i2 = 1;
        } else if (i3 <= i2) {
            i2 = i3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.objects[i4] = this.modelObject.instantiate();
        }
        this.objectsPointer = i2 - 1;
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            resizePool();
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            int i3 = t.currentOwnerId;
            if (i3 == Poolable.NO_OWNER) {
                t.currentOwnerId = this.poolId;
                this.objects[this.objectsPointer + 1 + i2] = t;
            } else if (i3 == this.poolId) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.objectsPointer += size;
    }
}
