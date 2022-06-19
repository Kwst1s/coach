package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.utils.Utils;

@SuppressLint({"ParcelCreator"})
public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private Range[] mRanges;
    private float[] mYVals;

    public BarEntry(float f2, float f3) {
        super(f2, f3);
    }

    private void calcPosNegSum() {
        float[] fArr = this.mYVals;
        if (fArr == null) {
            this.mNegativeSum = Utils.FLOAT_EPSILON;
            this.mPositiveSum = Utils.FLOAT_EPSILON;
            return;
        }
        float f2 = Utils.FLOAT_EPSILON;
        float f3 = Utils.FLOAT_EPSILON;
        for (float f4 : fArr) {
            if (f4 <= Utils.FLOAT_EPSILON) {
                f2 += Math.abs(f4);
            } else {
                f3 += f4;
            }
        }
        this.mNegativeSum = f2;
        this.mPositiveSum = f3;
    }

    private static float calcSum(float[] fArr) {
        float f2 = Utils.FLOAT_EPSILON;
        if (fArr == null) {
            return Utils.FLOAT_EPSILON;
        }
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public void calcRanges() {
        float[] yVals = getYVals();
        if (yVals != null && yVals.length != 0) {
            this.mRanges = new Range[yVals.length];
            float f2 = -getNegativeSum();
            int i2 = 0;
            float f3 = Utils.FLOAT_EPSILON;
            while (true) {
                Range[] rangeArr = this.mRanges;
                if (i2 < rangeArr.length) {
                    float f4 = yVals[i2];
                    if (f4 < Utils.FLOAT_EPSILON) {
                        float f5 = f2 - f4;
                        rangeArr[i2] = new Range(f2, f5);
                        f2 = f5;
                    } else {
                        float f6 = f4 + f3;
                        rangeArr[i2] = new Range(f3, f6);
                        f3 = f6;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    @Deprecated
    public float getBelowSum(int i2) {
        return getSumBelow(i2);
    }

    public float getNegativeSum() {
        return this.mNegativeSum;
    }

    public float getPositiveSum() {
        return this.mPositiveSum;
    }

    public Range[] getRanges() {
        return this.mRanges;
    }

    public float getSumBelow(int i2) {
        float[] fArr = this.mYVals;
        float f2 = Utils.FLOAT_EPSILON;
        if (fArr == null) {
            return Utils.FLOAT_EPSILON;
        }
        int length = fArr.length - 1;
        while (length > i2 && length >= 0) {
            f2 += this.mYVals[length];
            length--;
        }
        return f2;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public float[] getYVals() {
        return this.mYVals;
    }

    public boolean isStacked() {
        return this.mYVals != null;
    }

    public void setVals(float[] fArr) {
        setY(calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f2, float f3, Object obj) {
        super(f2, f3, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.mYVals);
        return barEntry;
    }

    public BarEntry(float f2, float f3, Drawable drawable) {
        super(f2, f3, drawable);
    }

    public BarEntry(float f2, float f3, Drawable drawable, Object obj) {
        super(f2, f3, drawable, obj);
    }

    public BarEntry(float f2, float[] fArr) {
        super(f2, calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f2, float[] fArr, Object obj) {
        super(f2, calcSum(fArr), obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f2, float[] fArr, Drawable drawable) {
        super(f2, calcSum(fArr), drawable);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f2, float[] fArr, Drawable drawable, Object obj) {
        super(f2, calcSum(fArr), drawable, obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }
}
