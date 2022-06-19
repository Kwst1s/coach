package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Utils;

public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i2, int i3, boolean z) {
        super(i2, i3, z);
    }

    @Override // com.github.mikephil.charting.buffer.BarBuffer
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
                    addBar(f2, f8, y, f7);
                } else {
                    float f10 = -barEntry.getNegativeSum();
                    int i3 = 0;
                    float f11 = Utils.FLOAT_EPSILON;
                    while (i3 < yVals.length) {
                        float f12 = yVals[i3];
                        if (f12 >= Utils.FLOAT_EPSILON) {
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
                        addBar(f5 * f16, f14, f10 * f16, f13);
                        i3++;
                        f10 = f4;
                    }
                }
            }
        }
        reset();
    }
}
