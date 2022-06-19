package com.github.mikephil.charting.buffer;

public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected int index;
    protected int mFrom;
    protected int mTo;
    protected float phaseX;
    protected float phaseY;

    public AbstractBuffer(int i2) {
        this.index = 0;
        this.phaseX = 1.0f;
        this.phaseY = 1.0f;
        this.mFrom = 0;
        this.mTo = 0;
        this.index = 0;
        this.buffer = new float[i2];
    }

    public abstract void feed(T t);

    public void limitFrom(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.mFrom = i2;
    }

    public void limitTo(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.mTo = i2;
    }

    public void reset() {
        this.index = 0;
    }

    public void setPhases(float f2, float f3) {
        this.phaseX = f2;
        this.phaseY = f3;
    }

    public int size() {
        return this.buffer.length;
    }
}
