package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.a.j;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect = new RectF();
    private RectF mBarShadowRectBuffer = new RectF();
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(j.E0);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.mBarBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i2 = 0; i2 < barData.getDataSetCount(); i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i2);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
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
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
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
            int i5 = i4 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i5])) {
                if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i4])) {
                    if (!z) {
                        this.mRenderPaint.setColor(iBarDataSet.getColor(i4 / 4));
                    }
                    float[] fArr = barBuffer.buffer;
                    int i6 = i4 + 1;
                    int i7 = i4 + 3;
                    canvas.drawRect(fArr[i4], fArr[i6], fArr[i5], fArr[i7], this.mRenderPaint);
                    if (z2) {
                        float[] fArr2 = barBuffer.buffer;
                        canvas.drawRect(fArr2[i4], fArr2[i6], fArr2[i5], fArr2[i7], this.mBarBorderPaint);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f2;
        float f3;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (!(highlight.getStackIndex() >= 0 && barEntry.isStacked())) {
                        f3 = barEntry.getY();
                        f2 = Utils.FLOAT_EPSILON;
                    } else if (this.mChart.isHighlightFullBarEnabled()) {
                        float positiveSum = barEntry.getPositiveSum();
                        f2 = -barEntry.getNegativeSum();
                        f3 = positiveSum;
                    } else {
                        Range range = barEntry.getRanges()[highlight.getStackIndex()];
                        f3 = range.from;
                        f2 = range.to;
                    }
                    prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f2;
        boolean z;
        List list;
        MPPointF mPPointF;
        int i2;
        float f3;
        boolean z2;
        Transformer transformer;
        float[] fArr;
        float f4;
        int i3;
        float[] fArr2;
        int i4;
        float f5;
        float f6;
        float f7;
        int i5;
        List list2;
        MPPointF mPPointF2;
        BarBuffer barBuffer;
        float f8;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (!shouldDrawValues(iBarDataSet)) {
                    list = dataSets;
                    f2 = convertDpToPixel;
                    z = isDrawValueAboveBarEnabled;
                } else {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, "8");
                    float f9 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f10 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f9 = (-f9) - calcTextHeight;
                        f10 = (-f10) - calcTextHeight;
                    }
                    BarBuffer barBuffer2 = this.mBarBuffers[i6];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF instance = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    if (!iBarDataSet.isStacked()) {
                        int i7 = 0;
                        while (((float) i7) < ((float) barBuffer2.buffer.length) * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer2.buffer;
                            float f11 = (fArr3[i7] + fArr3[i7 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f11)) {
                                break;
                            }
                            int i8 = i7 + 1;
                            if (!this.mViewPortHandler.isInBoundsY(barBuffer2.buffer[i8]) || !this.mViewPortHandler.isInBoundsLeft(f11)) {
                                i5 = i7;
                                mPPointF2 = instance;
                                list2 = dataSets;
                                barBuffer = barBuffer2;
                            } else {
                                int i9 = i7 / 4;
                                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i9);
                                float y = barEntry.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    f8 = f11;
                                    i5 = i7;
                                    mPPointF2 = instance;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                    drawValue(canvas, iBarDataSet.getValueFormatter(), y, barEntry, i6, f8, y >= Utils.FLOAT_EPSILON ? barBuffer2.buffer[i8] + f9 : barBuffer2.buffer[i7 + 3] + f10, iBarDataSet.getValueTextColor(i9));
                                } else {
                                    f8 = f11;
                                    i5 = i7;
                                    mPPointF2 = instance;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (f8 + mPPointF2.x), (int) ((y >= Utils.FLOAT_EPSILON ? barBuffer.buffer[i8] + f9 : barBuffer.buffer[i5 + 3] + f10) + mPPointF2.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                            i7 = i5 + 4;
                            barBuffer2 = barBuffer;
                            instance = mPPointF2;
                            dataSets = list2;
                        }
                        mPPointF = instance;
                        list = dataSets;
                    } else {
                        mPPointF = instance;
                        list = dataSets;
                        Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i10 = 0;
                        int i11 = 0;
                        while (((float) i10) < ((float) iBarDataSet.getEntryCount()) * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i10);
                            float[] yVals = barEntry2.getYVals();
                            float[] fArr4 = barBuffer2.buffer;
                            float f12 = (fArr4[i11] + fArr4[i11 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i10);
                            if (yVals != null) {
                                i2 = i10;
                                f3 = convertDpToPixel;
                                z2 = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f13 = f12;
                                int length = fArr.length * 2;
                                float[] fArr5 = new float[length];
                                float f14 = -barEntry2.getNegativeSum();
                                int i12 = 0;
                                int i13 = 0;
                                float f15 = Utils.FLOAT_EPSILON;
                                while (i12 < length) {
                                    float f16 = fArr[i13];
                                    if (f16 == Utils.FLOAT_EPSILON && (f15 == Utils.FLOAT_EPSILON || f14 == Utils.FLOAT_EPSILON)) {
                                        f14 = f16;
                                        f6 = f14;
                                    } else if (f16 >= Utils.FLOAT_EPSILON) {
                                        f15 += f16;
                                        f6 = f14;
                                        f14 = f15;
                                    } else {
                                        f6 = f14 - f16;
                                    }
                                    fArr5[i12 + 1] = f14 * phaseY;
                                    i12 += 2;
                                    i13++;
                                    f14 = f6;
                                }
                                transformer.pointValuesToPixel(fArr5);
                                int i14 = 0;
                                while (i14 < length) {
                                    int i15 = i14 / 2;
                                    float f17 = fArr[i15];
                                    float f18 = fArr5[i14 + 1] + (((f17 > Utils.FLOAT_EPSILON ? 1 : (f17 == Utils.FLOAT_EPSILON ? 0 : -1)) == 0 && (f14 > Utils.FLOAT_EPSILON ? 1 : (f14 == Utils.FLOAT_EPSILON ? 0 : -1)) == 0 && (f15 > Utils.FLOAT_EPSILON ? 1 : (f15 == Utils.FLOAT_EPSILON ? 0 : -1)) > 0) || (f17 > Utils.FLOAT_EPSILON ? 1 : (f17 == Utils.FLOAT_EPSILON ? 0 : -1)) < 0 ? f10 : f9);
                                    if (!this.mViewPortHandler.isInBoundsRight(f13)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsY(f18) || !this.mViewPortHandler.isInBoundsLeft(f13)) {
                                        i4 = i14;
                                        fArr2 = fArr5;
                                        i3 = length;
                                        f4 = f13;
                                    } else {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f5 = f18;
                                            i4 = i14;
                                            fArr2 = fArr5;
                                            i3 = length;
                                            f4 = f13;
                                            drawValue(canvas, iBarDataSet.getValueFormatter(), fArr[i15], barEntry2, i6, f13, f5, valueTextColor);
                                        } else {
                                            f5 = f18;
                                            i4 = i14;
                                            fArr2 = fArr5;
                                            i3 = length;
                                            f4 = f13;
                                        }
                                        if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry2.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f4 + mPPointF.x), (int) (f5 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    }
                                    i14 = i4 + 2;
                                    fArr5 = fArr2;
                                    length = i3;
                                    f13 = f4;
                                }
                            } else if (!this.mViewPortHandler.isInBoundsRight(f12)) {
                                break;
                            } else {
                                int i16 = i11 + 1;
                                if (!this.mViewPortHandler.isInBoundsY(barBuffer2.buffer[i16]) || !this.mViewPortHandler.isInBoundsLeft(f12)) {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i10 = i10;
                                } else {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f7 = f12;
                                        f3 = convertDpToPixel;
                                        fArr = yVals;
                                        i2 = i10;
                                        z2 = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(canvas, iBarDataSet.getValueFormatter(), barEntry2.getY(), barEntry2, i6, f7, barBuffer2.buffer[i16] + (barEntry2.getY() >= Utils.FLOAT_EPSILON ? f9 : f10), valueTextColor);
                                    } else {
                                        f7 = f12;
                                        i2 = i10;
                                        f3 = convertDpToPixel;
                                        z2 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon3 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon3, (int) (f7 + mPPointF.x), (int) (barBuffer2.buffer[i16] + (barEntry2.getY() >= Utils.FLOAT_EPSILON ? f9 : f10) + mPPointF.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (fArr == null) {
                                i11 += 4;
                            } else {
                                i11 += fArr.length * 4;
                            }
                            i10 = i2 + 1;
                            transformer2 = transformer;
                            isDrawValueAboveBarEnabled = z2;
                            convertDpToPixel = f3;
                        }
                    }
                    f2 = convertDpToPixel;
                    z = isDrawValueAboveBarEnabled;
                    MPPointF.recycleInstance(mPPointF);
                }
                i6++;
                dataSets = list;
                isDrawValueAboveBarEnabled = z;
                convertDpToPixel = f2;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i2 = 0; i2 < this.mBarBuffers.length; i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i2);
            this.mBarBuffers[i2] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.mBarRect.set(f2 - f5, f3, f2 + f5, f4);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* access modifiers changed from: protected */
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
