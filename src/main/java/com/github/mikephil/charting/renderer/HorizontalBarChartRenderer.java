package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer = new RectF();

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i2) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = true;
        boolean z2 = iBarDataSet.getBarBorderWidth() > Utils.FLOAT_EPSILON;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) iBarDataSet.getEntryCount()) * phaseX)), iBarDataSet.getEntryCount());
            for (int i3 = 0; i3 < min; i3++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i3)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i2];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i2);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        if (iBarDataSet.getColors().size() != 1) {
            z = false;
        }
        if (z) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i4 = 0; i4 < barBuffer.size(); i4 += 4) {
            int i5 = i4 + 3;
            if (this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i5])) {
                int i6 = i4 + 1;
                if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i6])) {
                    if (!z) {
                        this.mRenderPaint.setColor(iBarDataSet.getColor(i4 / 4));
                    }
                    float[] fArr = barBuffer.buffer;
                    int i7 = i4 + 2;
                    canvas.drawRect(fArr[i4], fArr[i6], fArr[i7], fArr[i5], this.mRenderPaint);
                    if (z2) {
                        float[] fArr2 = barBuffer.buffer;
                        canvas.drawRect(fArr2[i4], fArr2[i6], fArr2[i7], fArr2[i5], this.mBarBorderPaint);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i2) {
        this.mValuePaint.setColor(i2);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer, com.github.mikephil.charting.renderer.BarChartRenderer
    public void drawValues(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        int i2;
        float[] fArr;
        float[] fArr2;
        int i3;
        float f2;
        float f3;
        float f4;
        BarEntry barEntry;
        boolean z;
        List list2;
        int i4;
        float f5;
        BarBuffer barBuffer;
        IValueFormatter iValueFormatter;
        MPPointF mPPointF2;
        float f6;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (!shouldDrawValues(iBarDataSet)) {
                    list = dataSets;
                } else {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f7 = 2.0f;
                    float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "10")) / 2.0f;
                    IValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF instance = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    if (!iBarDataSet.isStacked()) {
                        int i6 = 0;
                        while (((float) i6) < ((float) barBuffer2.buffer.length) * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer2.buffer;
                            int i7 = i6 + 1;
                            float f8 = (fArr3[i7] + fArr3[i6 + 3]) / f7;
                            if (!this.mViewPortHandler.isInBoundsTop(fArr3[i7])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i6]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i7])) {
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i6 / 4);
                                float y = barEntry2.getY();
                                String formattedValue = valueFormatter.getFormattedValue(y, barEntry2, i5, this.mViewPortHandler);
                                float calcTextWidth = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue);
                                float f9 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                float f10 = isDrawValueAboveBarEnabled ? -(calcTextWidth + convertDpToPixel) : convertDpToPixel;
                                if (isInverted) {
                                    f9 = (-f9) - calcTextWidth;
                                    f10 = (-f10) - calcTextWidth;
                                }
                                float f11 = f9;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    f6 = y;
                                    i4 = i6;
                                    list2 = dataSets;
                                    mPPointF2 = instance;
                                    f5 = calcTextHeight;
                                    barBuffer = barBuffer2;
                                    z = isInverted;
                                    iValueFormatter = valueFormatter;
                                    drawValue(canvas, formattedValue, (y >= Utils.FLOAT_EPSILON ? f11 : f10) + barBuffer2.buffer[i6 + 2], f8 + calcTextHeight, iBarDataSet.getValueTextColor(i6 / 2));
                                } else {
                                    f6 = y;
                                    i4 = i6;
                                    list2 = dataSets;
                                    z = isInverted;
                                    mPPointF2 = instance;
                                    iValueFormatter = valueFormatter;
                                    f5 = calcTextHeight;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f12 = barBuffer.buffer[i4 + 2];
                                    if (f6 < Utils.FLOAT_EPSILON) {
                                        f11 = f10;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f12 + f11 + mPPointF2.x), (int) (f8 + mPPointF2.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i6;
                                list2 = dataSets;
                                z = isInverted;
                                f5 = calcTextHeight;
                                mPPointF2 = instance;
                                barBuffer = barBuffer2;
                                iValueFormatter = valueFormatter;
                            }
                            i6 = i4 + 4;
                            instance = mPPointF2;
                            valueFormatter = iValueFormatter;
                            barBuffer2 = barBuffer;
                            calcTextHeight = f5;
                            dataSets = list2;
                            isInverted = z;
                            f7 = 2.0f;
                        }
                        list = dataSets;
                        mPPointF = instance;
                    } else {
                        list = dataSets;
                        mPPointF = instance;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i8 = 0;
                        int i9 = 0;
                        while (((float) i8) < ((float) iBarDataSet.getEntryCount()) * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i8);
                            int valueTextColor = iBarDataSet.getValueTextColor(i8);
                            float[] yVals = barEntry3.getYVals();
                            if (yVals != null) {
                                i2 = i8;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f13 = -barEntry3.getNegativeSum();
                                int i10 = 0;
                                int i11 = 0;
                                float f14 = Utils.FLOAT_EPSILON;
                                while (i10 < length) {
                                    float f15 = fArr[i11];
                                    if (f15 == Utils.FLOAT_EPSILON && (f14 == Utils.FLOAT_EPSILON || f13 == Utils.FLOAT_EPSILON)) {
                                        f13 = f15;
                                        f4 = f13;
                                    } else if (f15 >= Utils.FLOAT_EPSILON) {
                                        f14 += f15;
                                        f4 = f13;
                                        f13 = f14;
                                    } else {
                                        f4 = f13 - f15;
                                    }
                                    fArr4[i10] = f13 * phaseY;
                                    i10 += 2;
                                    i11++;
                                    f13 = f4;
                                }
                                transformer.pointValuesToPixel(fArr4);
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= length) {
                                        break;
                                    }
                                    float f16 = fArr[i12 / 2];
                                    String formattedValue2 = valueFormatter.getFormattedValue(f16, barEntry3, i5, this.mViewPortHandler);
                                    float calcTextWidth2 = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue2);
                                    float f17 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth2 + convertDpToPixel);
                                    float f18 = isDrawValueAboveBarEnabled ? -(calcTextWidth2 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f17 = (-f17) - calcTextWidth2;
                                        f18 = (-f18) - calcTextWidth2;
                                    }
                                    boolean z2 = (f16 == Utils.FLOAT_EPSILON && f13 == Utils.FLOAT_EPSILON && f14 > Utils.FLOAT_EPSILON) || f16 < Utils.FLOAT_EPSILON;
                                    float f19 = fArr4[i12];
                                    if (z2) {
                                        f17 = f18;
                                    }
                                    float f20 = f19 + f17;
                                    float[] fArr5 = barBuffer2.buffer;
                                    float f21 = (fArr5[i9 + 1] + fArr5[i9 + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f21)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f20) && this.mViewPortHandler.isInBoundsBottom(f21)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f2 = f21;
                                            i3 = i12;
                                            fArr2 = fArr4;
                                            f3 = f20;
                                            drawValue(canvas, formattedValue2, f20, f21 + calcTextHeight, valueTextColor);
                                        } else {
                                            f2 = f21;
                                            i3 = i12;
                                            fArr2 = fArr4;
                                            f3 = f20;
                                        }
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f3 + mPPointF.x), (int) (f2 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i12;
                                        fArr2 = fArr4;
                                    }
                                    i12 = i3 + 2;
                                    length = length;
                                    fArr4 = fArr2;
                                }
                            } else {
                                int i13 = i9 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i13])) {
                                    break;
                                } else if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i9]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i13])) {
                                    String formattedValue3 = valueFormatter.getFormattedValue(barEntry3.getY(), barEntry3, i5, this.mViewPortHandler);
                                    float calcTextWidth3 = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue3);
                                    float f22 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                    float f23 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f22 = (-f22) - calcTextWidth3;
                                        f23 = (-f23) - calcTextWidth3;
                                    }
                                    float f24 = f22;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        i2 = i8;
                                        fArr = yVals;
                                        barEntry = barEntry3;
                                        drawValue(canvas, formattedValue3, barBuffer2.buffer[i9 + 2] + (barEntry3.getY() >= Utils.FLOAT_EPSILON ? f24 : f23), barBuffer2.buffer[i13] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry3;
                                        i2 = i8;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon3 = barEntry.getIcon();
                                        float f25 = barBuffer2.buffer[i9 + 2];
                                        if (barEntry.getY() < Utils.FLOAT_EPSILON) {
                                            f24 = f23;
                                        }
                                        Utils.drawImage(canvas, icon3, (int) (f25 + f24 + mPPointF.x), (int) (barBuffer2.buffer[i13] + mPPointF.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (fArr == null) {
                                i9 += 4;
                            } else {
                                i9 += fArr.length * 4;
                            }
                            i8 = i2 + 1;
                        }
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i5++;
                dataSets = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer, com.github.mikephil.charting.renderer.BarChartRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i2 = 0; i2 < this.mBarBuffers.length; i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i2);
            this.mBarBuffers[i2] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.mBarRect.set(f3, f2 - f5, f4, f2 + f5);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
