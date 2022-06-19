package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import b.a.j;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Path mDrawDataSetSurfacePathBuffer = new Path();
    protected Path mDrawHighlightCirclePathBuffer = new Path();
    protected Paint mHighlightCirclePaint;
    protected Paint mWebPaint;

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = radarChart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, (int) j.z0));
        Paint paint2 = new Paint(1);
        this.mWebPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mHighlightCirclePaint = new Paint(1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        RadarData radarData = (RadarData) this.mChart.getData();
        int entryCount = ((IRadarDataSet) radarData.getMaxEntryCountSet()).getEntryCount();
        for (IRadarDataSet iRadarDataSet : radarData.getDataSets()) {
            if (iRadarDataSet.isVisible()) {
                drawDataSet(canvas, iRadarDataSet, entryCount);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IRadarDataSet iRadarDataSet, int i2) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        Path path = this.mDrawDataSetSurfacePathBuffer;
        path.reset();
        boolean z = false;
        for (int i3 = 0; i3 < iRadarDataSet.getEntryCount(); i3++) {
            this.mRenderPaint.setColor(iRadarDataSet.getColor(i3));
            Utils.getPosition(centerOffsets, (((RadarEntry) iRadarDataSet.getEntryForIndex(i3)).getY() - this.mChart.getYChartMin()) * factor * phaseY, (((float) i3) * sliceAngle * phaseX) + this.mChart.getRotationAngle(), instance);
            if (!Float.isNaN(instance.x)) {
                if (!z) {
                    path.moveTo(instance.x, instance.y);
                    z = true;
                } else {
                    path.lineTo(instance.x, instance.y);
                }
            }
        }
        if (iRadarDataSet.getEntryCount() > i2) {
            path.lineTo(centerOffsets.x, centerOffsets.y);
        }
        path.close();
        if (iRadarDataSet.isDrawFilledEnabled()) {
            Drawable fillDrawable = iRadarDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iRadarDataSet.getFillColor(), iRadarDataSet.getFillAlpha());
            }
        }
        this.mRenderPaint.setStrokeWidth(iRadarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.isDrawFilledEnabled() || iRadarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(instance);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    public void drawHighlightCircle(Canvas canvas, MPPointF mPPointF, float f2, float f3, int i2, int i3, float f4) {
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(f3);
        float convertDpToPixel2 = Utils.convertDpToPixel(f2);
        if (i2 != 1122867) {
            Path path = this.mDrawHighlightCirclePathBuffer;
            path.reset();
            path.addCircle(mPPointF.x, mPPointF.y, convertDpToPixel, Path.Direction.CW);
            if (convertDpToPixel2 > Utils.FLOAT_EPSILON) {
                path.addCircle(mPPointF.x, mPPointF.y, convertDpToPixel2, Path.Direction.CCW);
            }
            this.mHighlightCirclePaint.setColor(i2);
            this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.mHighlightCirclePaint);
        }
        if (i3 != 1122867) {
            this.mHighlightCirclePaint.setColor(i3);
            this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
            this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(f4));
            canvas.drawCircle(mPPointF.x, mPPointF.y, convertDpToPixel, this.mHighlightCirclePaint);
        }
        canvas.restore();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i2;
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        RadarData radarData = (RadarData) this.mChart.getData();
        int length = highlightArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            Highlight highlight = highlightArr[i4];
            IRadarDataSet iRadarDataSet = (IRadarDataSet) radarData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iRadarDataSet != null && iRadarDataSet.isHighlightEnabled()) {
                Entry entry = (RadarEntry) iRadarDataSet.getEntryForIndex((int) highlight.getX());
                if (isInBoundsX(entry, iRadarDataSet)) {
                    Utils.getPosition(centerOffsets, (entry.getY() - this.mChart.getYChartMin()) * factor * this.mAnimator.getPhaseY(), (highlight.getX() * sliceAngle * this.mAnimator.getPhaseX()) + this.mChart.getRotationAngle(), instance);
                    highlight.setDraw(instance.x, instance.y);
                    drawHighlightLines(canvas, instance.x, instance.y, iRadarDataSet);
                    if (iRadarDataSet.isDrawHighlightCircleEnabled() && !Float.isNaN(instance.x) && !Float.isNaN(instance.y)) {
                        int highlightCircleStrokeColor = iRadarDataSet.getHighlightCircleStrokeColor();
                        if (highlightCircleStrokeColor == 1122867) {
                            highlightCircleStrokeColor = iRadarDataSet.getColor(i3);
                        }
                        if (iRadarDataSet.getHighlightCircleStrokeAlpha() < 255) {
                            highlightCircleStrokeColor = ColorTemplate.colorWithAlpha(highlightCircleStrokeColor, iRadarDataSet.getHighlightCircleStrokeAlpha());
                        }
                        i2 = i4;
                        drawHighlightCircle(canvas, instance, iRadarDataSet.getHighlightCircleInnerRadius(), iRadarDataSet.getHighlightCircleOuterRadius(), iRadarDataSet.getHighlightCircleFillColor(), highlightCircleStrokeColor, iRadarDataSet.getHighlightCircleStrokeWidth());
                        i4 = i2 + 1;
                        i3 = 0;
                    }
                }
            }
            i2 = i4;
            i4 = i2 + 1;
            i3 = 0;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(instance);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f2;
        int i2;
        float f3;
        MPPointF mPPointF;
        IRadarDataSet iRadarDataSet;
        float f4;
        int i3;
        int i4;
        float f5;
        MPPointF mPPointF2;
        MPPointF mPPointF3;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        MPPointF instance2 = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i5 = 0;
        while (i5 < ((RadarData) this.mChart.getData()).getDataSetCount()) {
            IRadarDataSet iRadarDataSet2 = (IRadarDataSet) ((RadarData) this.mChart.getData()).getDataSetByIndex(i5);
            if (!shouldDrawValues(iRadarDataSet2)) {
                i2 = i5;
                f2 = phaseX;
                f3 = sliceAngle;
                mPPointF = instance2;
            } else {
                applyValueTextStyle(iRadarDataSet2);
                MPPointF instance3 = MPPointF.getInstance(iRadarDataSet2.getIconsOffset());
                instance3.x = Utils.convertDpToPixel(instance3.x);
                instance3.y = Utils.convertDpToPixel(instance3.y);
                int i6 = 0;
                while (i6 < iRadarDataSet2.getEntryCount()) {
                    RadarEntry radarEntry = (RadarEntry) iRadarDataSet2.getEntryForIndex(i6);
                    float f6 = ((float) i6) * sliceAngle * phaseX;
                    Utils.getPosition(centerOffsets, (radarEntry.getY() - this.mChart.getYChartMin()) * factor * phaseY, f6 + this.mChart.getRotationAngle(), instance);
                    if (iRadarDataSet2.isDrawValuesEnabled()) {
                        i3 = i6;
                        f4 = phaseX;
                        mPPointF3 = instance3;
                        iRadarDataSet = iRadarDataSet2;
                        i4 = i5;
                        f5 = sliceAngle;
                        mPPointF2 = instance2;
                        drawValue(canvas, iRadarDataSet2.getValueFormatter(), radarEntry.getY(), radarEntry, i5, instance.x, instance.y - convertDpToPixel, iRadarDataSet2.getValueTextColor(i6));
                    } else {
                        i3 = i6;
                        iRadarDataSet = iRadarDataSet2;
                        i4 = i5;
                        f4 = phaseX;
                        f5 = sliceAngle;
                        mPPointF3 = instance3;
                        mPPointF2 = instance2;
                    }
                    if (radarEntry.getIcon() != null && iRadarDataSet.isDrawIconsEnabled()) {
                        Drawable icon = radarEntry.getIcon();
                        Utils.getPosition(centerOffsets, (radarEntry.getY() * factor * phaseY) + mPPointF3.y, f6 + this.mChart.getRotationAngle(), mPPointF2);
                        float f7 = mPPointF2.y + mPPointF3.x;
                        mPPointF2.y = f7;
                        Utils.drawImage(canvas, icon, (int) mPPointF2.x, (int) f7, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i6 = i3 + 1;
                    instance3 = mPPointF3;
                    instance2 = mPPointF2;
                    sliceAngle = f5;
                    i5 = i4;
                    phaseX = f4;
                    iRadarDataSet2 = iRadarDataSet;
                }
                i2 = i5;
                f2 = phaseX;
                f3 = sliceAngle;
                mPPointF = instance2;
                MPPointF.recycleInstance(instance3);
            }
            i5 = i2 + 1;
            instance2 = mPPointF;
            sliceAngle = f3;
            phaseX = f2;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(instance);
        MPPointF.recycleInstance(instance2);
    }

    /* access modifiers changed from: protected */
    public void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int skipWebLineCount = this.mChart.getSkipWebLineCount() + 1;
        int entryCount = ((IRadarDataSet) ((RadarData) this.mChart.getData()).getMaxEntryCountSet()).getEntryCount();
        MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        for (int i2 = 0; i2 < entryCount; i2 += skipWebLineCount) {
            Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (((float) i2) * sliceAngle) + rotationAngle, instance);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, instance.x, instance.y, this.mWebPaint);
        }
        MPPointF.recycleInstance(instance);
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i3 = this.mChart.getYAxis().mEntryCount;
        MPPointF instance2 = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        MPPointF instance3 = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            while (i5 < ((RadarData) this.mChart.getData()).getEntryCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i4] - this.mChart.getYChartMin()) * factor;
                Utils.getPosition(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, instance2);
                i5++;
                Utils.getPosition(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, instance3);
                canvas.drawLine(instance2.x, instance2.y, instance3.x, instance3.y, this.mWebPaint);
            }
        }
        MPPointF.recycleInstance(instance2);
        MPPointF.recycleInstance(instance3);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
