package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR = new Parcelable.Creator<MPPointF>() {
        /* class com.github.mikephil.charting.utils.MPPointF.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            mPPointF.my_readFromParcel(parcel);
            return mPPointF;
        }

        @Override // android.os.Parcelable.Creator
        public MPPointF[] newArray(int i2) {
            return new MPPointF[i2];
        }
    };
    private static ObjectPool<MPPointF> pool;
    public float x;
    public float y;

    static {
        ObjectPool<MPPointF> create = ObjectPool.create(32, new MPPointF(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public MPPointF() {
    }

    public static MPPointF getInstance(float f2, float f3) {
        MPPointF mPPointF = pool.get();
        mPPointF.x = f2;
        mPPointF.y = f3;
        return mPPointF;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        pool.recycle(mPPointF);
    }

    public static void recycleInstances(List<MPPointF> list) {
        pool.recycle(list);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public ObjectPool.Poolable instantiate() {
        return new MPPointF(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    }

    public void my_readFromParcel(Parcel parcel) {
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
    }

    public MPPointF(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public static MPPointF getInstance() {
        return pool.get();
    }

    public static MPPointF getInstance(MPPointF mPPointF) {
        MPPointF mPPointF2 = pool.get();
        mPPointF2.x = mPPointF.x;
        mPPointF2.y = mPPointF.y;
        return mPPointF2;
    }
}
