package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Utils;

public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth = 1.0f;
    protected boolean mContainsStacks = false;
    protected int mDataSetCount = 1;
    protected int mDataSetIndex = 0;
    protected boolean mInverted = false;

    public BarBuffer(int i2, int i3, boolean z) {
        super(i2);
        this.mDataSetCount = i3;
        this.mContainsStacks = z;
    }

    /* access modifiers changed from: protected */
    public void addBar(float f2, float f3, float f4, float f5) {
        float[] fArr = this.buffer;
        int i2 = this.index;
        int i3 = i2 + 1;
        this.index = i3;
        fArr[i2] = f2;
        int i4 = i3 + 1;
        this.index = i4;
        fArr[i3] = f3;
        int i5 = i4 + 1;
        this.index = i5;
        fArr[i4] = f4;
        this.index = i5 + 1;
        fArr[i5] = f5;
    }

    public void setBarWidth(float f2) {
        this.mBarWidth = f2;
    }

    public void setDataSet(int i2) {
        this.mDataSetIndex = i2;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public void feed(IBarDataSet iBarDataSet) {
        float f2;
        float f3;
        float f4;
        float f5;
        float entryCount = ((float) iBarDataSet.getEntryCount()) * this.phaseX;
        float f6 = this.mBarWidth / 2.0f;
        for (int i2 = 0; ((float) i2) < entryCount; i2++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i2);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f7 = x - f6;
                    float f8 = x + f6;
                    if (this.mInverted) {
                        f2 = y >= Utils.FLOAT_EPSILON ? y : Utils.FLOAT_EPSILON;
                        if (y > Utils.FLOAT_EPSILON) {
                            y = Utils.FLOAT_EPSILON;
                        }
                    } else {
                        float f9 = y >= Utils.FLOAT_EPSILON ? y : Utils.FLOAT_EPSILON;
                        if (y > Utils.FLOAT_EPSILON) {
                            y = Utils.FLOAT_EPSILON;
                        }
                        y = f9;
                        f2 = y;
                    }
                    if (y > Utils.FLOAT_EPSILON) {
                        y *= this.phaseY;
                    } else {
                        f2 *= this.phaseY;
                    }
                    addBar(f7, y, f8, f2);
                } else {
                    float f10 = -barEntry.getNegativeSum();
                    int i3 = 0;
                    float f11 = Utils.FLOAT_EPSILON;
                    while (i3 < yVals.length) {
                        float f12 = yVals[i3];
                        if (f12 == Utils.FLOAT_EPSILON && (f11 == Utils.FLOAT_EPSILON || f10 == Utils.FLOAT_EPSILON)) {
                            f3 = f12;
                            f4 = f10;
                            f10 = f3;
                        } else if (f12 >= Utils.FLOAT_EPSILON) {
                            f3 = f12 + f11;
                            f4 = f10;
                            f10 = f11;
                            f11 = f3;
                        } else {
                            f3 = Math.abs(f12) + f10;
                            f4 = Math.abs(f12) + f10;
                        }
                        float f13 = x - f6;
                        float f14 = x + f6;
                        if (this.mInverted) {
                            f5 = f10 >= f3 ? f10 : f3;
                            if (f10 > f3) {
                                f10 = f3;
                            }
                        } else {
                            float f15 = f10 >= f3 ? f10 : f3;
                            if (f10 > f3) {
                                f10 = f3;
                            }
                            f10 = f15;
                            f5 = f10;
                        }
                        float f16 = this.phaseY;
                        addBar(f13, f10 * f16, f14, f5 * f16);
                        i3++;
                        f10 = f4;
                    }
                }
            }
        }
        reset();
    }
}
