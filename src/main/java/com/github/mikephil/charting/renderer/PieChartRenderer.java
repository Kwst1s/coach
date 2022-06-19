package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.constraintlayout.widget.i;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds = new RectF();
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer = new Path();
    protected RectF mDrawHighlightedRectF = new RectF();
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath = new Path();
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer = new RectF();
    private Path mPathBuffer = new Path();
    private RectF[] mRectBuffer = {new RectF(), new RectF(), new RectF()};
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(i.F0);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f2, float f3, float f4, float f5, float f6, float f7) {
        double d2 = (double) ((f6 + f7) * 0.017453292f);
        float cos = mPPointF.x + (((float) Math.cos(d2)) * f2);
        float sin = mPPointF.y + (((float) Math.sin(d2)) * f2);
        double d3 = (double) ((f6 + (f7 / 2.0f)) * 0.017453292f);
        float cos2 = mPPointF.x + (((float) Math.cos(d3)) * f2);
        float sin2 = mPPointF.y + (((float) Math.sin(d3)) * f2);
        double d4 = (double) f3;
        Double.isNaN(d4);
        double sqrt = (double) (f2 - ((float) ((Math.sqrt(Math.pow((double) (cos - f4), 2.0d) + Math.pow((double) (sin - f5), 2.0d)) / 2.0d) * Math.tan(((180.0d - d4) / 2.0d) * 0.017453292519943295d))));
        double sqrt2 = Math.sqrt(Math.pow((double) (cos2 - ((cos + f4) / 2.0f)), 2.0d) + Math.pow((double) (sin2 - ((sin + f5) / 2.0f)), 2.0d));
        Double.isNaN(sqrt);
        return (float) (sqrt - sqrt2);
    }

    /* access modifiers changed from: protected */
    public void drawCenterText(Canvas canvas) {
        float f2;
        MPPointF mPPointF;
        CharSequence centerText = this.mChart.getCenterText();
        if (this.mChart.isDrawCenterTextEnabled() && centerText != null) {
            MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
            MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
            float f3 = centerCircleBox.x + centerTextOffset.x;
            float f4 = centerCircleBox.y + centerTextOffset.y;
            if (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) {
                f2 = this.mChart.getRadius();
            } else {
                f2 = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
            }
            RectF[] rectFArr = this.mRectBuffer;
            RectF rectF = rectFArr[0];
            rectF.left = f3 - f2;
            rectF.top = f4 - f2;
            rectF.right = f3 + f2;
            rectF.bottom = f4 + f2;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > Utils.DOUBLE_EPSILON) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
                this.mCenterTextLastBounds.set(rectF2);
                this.mCenterTextLastValue = centerText;
                mPPointF = centerTextOffset;
                this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil((double) this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, Utils.FLOAT_EPSILON, false);
            } else {
                mPPointF = centerTextOffset;
            }
            float height = (float) this.mCenterTextLayout.getHeight();
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                Path path = this.mDrawCenterTextPathBuffer;
                path.reset();
                path.addOval(rectF, Path.Direction.CW);
                canvas.clipPath(path);
            }
            canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.mCenterTextLayout.draw(canvas);
            canvas.restore();
            MPPointF.recycleInstance(centerCircleBox);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (!(weakReference != null && weakReference.get().getWidth() == chartWidth && this.mDrawBitmap.get().getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444));
                this.mBitmapCanvas = new Canvas(this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        this.mDrawBitmap.get().eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f2;
        float f3;
        float f4;
        float f5;
        float[] fArr;
        int i2;
        int i3;
        RectF rectF;
        float f6;
        int i4;
        MPPointF mPPointF;
        float f7;
        float f8;
        float f9;
        MPPointF mPPointF2;
        int i5;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        RectF circleBox = pieChartRenderer.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        boolean z = pieChartRenderer.mChart.isDrawHoleEnabled() && !pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (pieChartRenderer.mChart.getHoleRadius() / 100.0f) * radius : Utils.FLOAT_EPSILON;
        int i6 = 0;
        for (int i7 = 0; i7 < entryCount; i7++) {
            if (Math.abs(((PieEntry) iPieDataSet2.getEntryForIndex(i7)).getY()) > Utils.FLOAT_EPSILON) {
                i6++;
            }
        }
        if (i6 <= 1) {
            f2 = Utils.FLOAT_EPSILON;
        } else {
            f2 = pieChartRenderer.getSliceSpace(iPieDataSet2);
        }
        int i8 = 0;
        float f10 = Utils.FLOAT_EPSILON;
        while (i8 < entryCount) {
            float f11 = drawAngles[i8];
            float abs = Math.abs(iPieDataSet2.getEntryForIndex(i8).getY());
            float f12 = Utils.FLOAT_EPSILON;
            if (abs <= f12 || pieChartRenderer.mChart.needsHighlight(i8)) {
                i3 = i8;
                f4 = radius;
                f3 = rotationAngle;
                f5 = phaseX;
                rectF = circleBox;
                i2 = entryCount;
                fArr = drawAngles;
                i4 = i6;
                f6 = holeRadius;
                mPPointF = centerCircleBox;
            } else {
                boolean z2 = f2 > Utils.FLOAT_EPSILON && f11 <= 180.0f;
                pieChartRenderer.mRenderPaint.setColor(iPieDataSet2.getColor(i8));
                float f13 = i6 == 1 ? Utils.FLOAT_EPSILON : f2 / (radius * 0.017453292f);
                float f14 = rotationAngle + ((f10 + (f13 / 2.0f)) * phaseY);
                float f15 = (f11 - f13) * phaseY;
                if (f15 < Utils.FLOAT_EPSILON) {
                    f15 = Utils.FLOAT_EPSILON;
                }
                pieChartRenderer.mPathBuffer.reset();
                double d2 = (double) (f14 * 0.017453292f);
                i2 = entryCount;
                fArr = drawAngles;
                float cos = centerCircleBox.x + (((float) Math.cos(d2)) * radius);
                float sin = centerCircleBox.y + (((float) Math.sin(d2)) * radius);
                if (f15 < 360.0f || f15 % 360.0f > f12) {
                    f5 = phaseX;
                    pieChartRenderer.mPathBuffer.moveTo(cos, sin);
                    pieChartRenderer.mPathBuffer.arcTo(circleBox, f14, f15);
                } else {
                    f5 = phaseX;
                    pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                }
                RectF rectF2 = pieChartRenderer.mInnerRectBuffer;
                float f16 = centerCircleBox.x;
                float f17 = centerCircleBox.y;
                rectF2.set(f16 - holeRadius, f17 - holeRadius, f16 + holeRadius, f17 + holeRadius);
                if (!z) {
                    f6 = holeRadius;
                    f3 = rotationAngle;
                    f7 = f15;
                    f4 = radius;
                    mPPointF = centerCircleBox;
                    rectF = circleBox;
                    i4 = i6;
                    i3 = i8;
                    f8 = 360.0f;
                } else if (holeRadius > Utils.FLOAT_EPSILON || z2) {
                    if (z2) {
                        f9 = f15;
                        rectF = circleBox;
                        i4 = i6;
                        i3 = i8;
                        f6 = holeRadius;
                        i5 = 1;
                        f4 = radius;
                        mPPointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f11 * phaseY, cos, sin, f14, f9);
                        if (calculateMinimumRadiusForSpacedSlice < Utils.FLOAT_EPSILON) {
                            calculateMinimumRadiusForSpacedSlice = -calculateMinimumRadiusForSpacedSlice;
                        }
                        holeRadius = Math.max(f6, calculateMinimumRadiusForSpacedSlice);
                    } else {
                        f6 = holeRadius;
                        mPPointF2 = centerCircleBox;
                        f9 = f15;
                        i5 = 1;
                        f4 = radius;
                        rectF = circleBox;
                        i4 = i6;
                        i3 = i8;
                    }
                    float f18 = (i4 == i5 || holeRadius == Utils.FLOAT_EPSILON) ? Utils.FLOAT_EPSILON : f2 / (holeRadius * 0.017453292f);
                    float f19 = ((f10 + (f18 / 2.0f)) * phaseY) + rotationAngle;
                    float f20 = (f11 - f18) * phaseY;
                    if (f20 < Utils.FLOAT_EPSILON) {
                        f20 = Utils.FLOAT_EPSILON;
                    }
                    float f21 = f19 + f20;
                    if (f9 < 360.0f || f9 % 360.0f > f12) {
                        pieChartRenderer = this;
                        double d3 = (double) (f21 * 0.017453292f);
                        f3 = rotationAngle;
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF2.x + (((float) Math.cos(d3)) * holeRadius), mPPointF2.y + (holeRadius * ((float) Math.sin(d3))));
                        pieChartRenderer.mPathBuffer.arcTo(pieChartRenderer.mInnerRectBuffer, f21, -f20);
                    } else {
                        pieChartRenderer = this;
                        pieChartRenderer.mPathBuffer.addCircle(mPPointF2.x, mPPointF2.y, holeRadius, Path.Direction.CCW);
                        f3 = rotationAngle;
                    }
                    mPPointF = mPPointF2;
                    pieChartRenderer.mPathBuffer.close();
                    pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
                } else {
                    f6 = holeRadius;
                    f3 = rotationAngle;
                    f7 = f15;
                    f8 = 360.0f;
                    f4 = radius;
                    mPPointF = centerCircleBox;
                    rectF = circleBox;
                    i4 = i6;
                    i3 = i8;
                }
                if (f7 % f8 > f12) {
                    if (z2) {
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f4, f11 * phaseY, cos, sin, f14, f7);
                        double d4 = (double) ((f14 + (f7 / 2.0f)) * 0.017453292f);
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d4)) * calculateMinimumRadiusForSpacedSlice2), mPPointF.y + (calculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d4))));
                    } else {
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF.x, mPPointF.y);
                    }
                }
                pieChartRenderer.mPathBuffer.close();
                pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
            }
            f10 += f11 * f5;
            i8 = i3 + 1;
            iPieDataSet2 = iPieDataSet;
            centerCircleBox = mPPointF;
            i6 = i4;
            holeRadius = f6;
            circleBox = rectF;
            entryCount = i2;
            drawAngles = fArr;
            phaseX = f5;
            radius = f4;
            rotationAngle = f3;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* access modifiers changed from: protected */
    public void drawEntryLabel(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2, f3, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (Paint) null);
        drawCenterText(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        RectF rectF;
        float[] fArr;
        float[] fArr2;
        float f2;
        int i2;
        float f3;
        IPieDataSet dataSetByIndex;
        float f4;
        int i3;
        float f5;
        float f6;
        float f7;
        float f8;
        int i4;
        int i5;
        float f9;
        float f10;
        Highlight[] highlightArr2 = highlightArr;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : Utils.FLOAT_EPSILON;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        int i6 = 0;
        while (i6 < highlightArr2.length) {
            int x = (int) highlightArr2[i6].getX();
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i6].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i7 = 0;
                for (int i8 = 0; i8 < entryCount; i8++) {
                    if (Math.abs(((PieEntry) dataSetByIndex.getEntryForIndex(i8)).getY()) > Utils.FLOAT_EPSILON) {
                        i7++;
                    }
                }
                if (x == 0) {
                    i3 = 1;
                    f4 = Utils.FLOAT_EPSILON;
                } else {
                    f4 = absoluteAngles[x - 1] * phaseX;
                    i3 = 1;
                }
                if (i7 <= i3) {
                    f5 = Utils.FLOAT_EPSILON;
                } else {
                    f5 = dataSetByIndex.getSliceSpace();
                }
                float f11 = drawAngles[x];
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f12 = radius + selectionShift;
                rectF2.set(this.mChart.getCircleBox());
                float f13 = -selectionShift;
                rectF2.inset(f13, f13);
                boolean z2 = f5 > Utils.FLOAT_EPSILON && f11 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f14 = i7 == 1 ? Utils.FLOAT_EPSILON : f5 / (radius * 0.017453292f);
                float f15 = i7 == 1 ? Utils.FLOAT_EPSILON : f5 / (f12 * 0.017453292f);
                float f16 = rotationAngle + ((f4 + (f14 / 2.0f)) * phaseY);
                float f17 = (f11 - f14) * phaseY;
                float f18 = f17 < Utils.FLOAT_EPSILON ? Utils.FLOAT_EPSILON : f17;
                float f19 = ((f4 + (f15 / 2.0f)) * phaseY) + rotationAngle;
                float f20 = (f11 - f15) * phaseY;
                if (f20 < Utils.FLOAT_EPSILON) {
                    f20 = Utils.FLOAT_EPSILON;
                }
                this.mPathBuffer.reset();
                if (f18 < 360.0f || f18 % 360.0f > Utils.FLOAT_EPSILON) {
                    f6 = holeRadius;
                    f2 = phaseX;
                    double d2 = (double) (f19 * 0.017453292f);
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d2)) * f12), centerCircleBox.y + (f12 * ((float) Math.sin(d2))));
                    this.mPathBuffer.arcTo(rectF2, f19, f20);
                } else {
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f12, Path.Direction.CW);
                    f6 = holeRadius;
                    f2 = phaseX;
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                }
                if (z2) {
                    float f21 = centerCircleBox.x;
                    double d3 = (double) (f16 * 0.017453292f);
                    i2 = i6;
                    f8 = f6;
                    f7 = Utils.FLOAT_EPSILON;
                    i5 = i7;
                    rectF = rectF2;
                    i4 = 1;
                    f9 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f11 * phaseY, (((float) Math.cos(d3)) * radius) + f21, centerCircleBox.y + (((float) Math.sin(d3)) * radius), f16, f18);
                } else {
                    f8 = f6;
                    rectF = rectF2;
                    i5 = i7;
                    i2 = i6;
                    i4 = 1;
                    f7 = Utils.FLOAT_EPSILON;
                    f9 = Utils.FLOAT_EPSILON;
                }
                RectF rectF3 = this.mInnerRectBuffer;
                float f22 = centerCircleBox.x;
                float f23 = centerCircleBox.y;
                rectF3.set(f22 - f8, f23 - f8, f22 + f8, f23 + f8);
                if (!z || (f8 <= f7 && !z2)) {
                    f3 = f8;
                    if (f18 % 360.0f > Utils.FLOAT_EPSILON) {
                        if (z2) {
                            double d4 = (double) ((f16 + (f18 / 2.0f)) * 0.017453292f);
                            this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d4)) * f9), centerCircleBox.y + (f9 * ((float) Math.sin(d4))));
                        } else {
                            this.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                        }
                    }
                } else {
                    if (z2) {
                        if (f9 < f7) {
                            f9 = -f9;
                        }
                        f10 = Math.max(f8, f9);
                    } else {
                        f10 = f8;
                    }
                    float f24 = (i5 == i4 || f10 == f7) ? Utils.FLOAT_EPSILON : f5 / (f10 * 0.017453292f);
                    float f25 = rotationAngle + ((f4 + (f24 / 2.0f)) * phaseY);
                    float f26 = (f11 - f24) * phaseY;
                    if (f26 < f7) {
                        f26 = Utils.FLOAT_EPSILON;
                    }
                    float f27 = f25 + f26;
                    if (f18 < 360.0f || f18 % 360.0f > Utils.FLOAT_EPSILON) {
                        double d5 = (double) (f27 * 0.017453292f);
                        f3 = f8;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d5)) * f10), centerCircleBox.y + (f10 * ((float) Math.sin(d5))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f27, -f26);
                    } else {
                        this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f10, Path.Direction.CCW);
                        f3 = f8;
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i2 = i6;
                rectF = rectF2;
                f3 = holeRadius;
                f2 = phaseX;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
            }
            i6 = i2 + 1;
            rectF2 = rectF;
            highlightArr2 = highlightArr;
            holeRadius = f3;
            phaseX = f2;
            drawAngles = fArr2;
            absoluteAngles = fArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* access modifiers changed from: protected */
    public void drawHole(Canvas canvas) {
        if (this.mChart.isDrawHoleEnabled() && this.mBitmapCanvas != null) {
            float radius = this.mChart.getRadius();
            float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
            MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (Color.alpha(this.mHolePaint.getColor()) > 0) {
                this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
            }
            if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
                int alpha = this.mTransparentCirclePaint.getAlpha();
                float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
                this.mTransparentCirclePaint.setAlpha((int) (((float) alpha) * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
                this.mHoleCirclePath.reset();
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
                this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
                this.mTransparentCirclePaint.setAlpha(alpha);
            }
            MPPointF.recycleInstance(centerCircleBox);
        }
    }

    /* access modifiers changed from: protected */
    public void drawRoundedSlices(Canvas canvas) {
        float f2;
        float f3;
        float[] fArr;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i2 = 0;
                while (i2 < dataSet.getEntryCount()) {
                    float f4 = drawAngles[i2];
                    if (Math.abs(dataSet.getEntryForIndex(i2).getY()) > Utils.FLOAT_EPSILON) {
                        double d2 = (double) (radius - holeRadius);
                        double d3 = (double) ((rotationAngle + f4) * phaseY);
                        double cos = Math.cos(Math.toRadians(d3));
                        Double.isNaN(d2);
                        f2 = phaseY;
                        fArr = drawAngles;
                        f3 = rotationAngle;
                        double d4 = (double) centerCircleBox.x;
                        Double.isNaN(d4);
                        float f5 = (float) (d4 + (cos * d2));
                        double sin = Math.sin(Math.toRadians(d3));
                        Double.isNaN(d2);
                        double d5 = d2 * sin;
                        double d6 = (double) centerCircleBox.y;
                        Double.isNaN(d6);
                        this.mRenderPaint.setColor(dataSet.getColor(i2));
                        this.mBitmapCanvas.drawCircle(f5, (float) (d5 + d6), holeRadius, this.mRenderPaint);
                    } else {
                        f2 = phaseY;
                        fArr = drawAngles;
                        f3 = rotationAngle;
                    }
                    rotationAngle = f3 + (f4 * phaseX);
                    i2++;
                    phaseY = f2;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        float[] fArr;
        float f2;
        int i2;
        float[] fArr2;
        float f3;
        float f4;
        float f5;
        PieDataSet.ValuePosition valuePosition;
        PieDataSet.ValuePosition valuePosition2;
        int i3;
        List list2;
        float f6;
        float[] fArr3;
        float f7;
        int i4;
        IPieDataSet iPieDataSet;
        MPPointF mPPointF;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        IPieDataSet iPieDataSet2;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float holeRadius = this.mChart.getHoleRadius() / 100.0f;
        float f13 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f13 = (radius - (radius * holeRadius)) / 2.0f;
        }
        float f14 = radius - f13;
        PieData pieData = (PieData) this.mChart.getData();
        List dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean isDrawEntryLabelsEnabled = this.mChart.isDrawEntryLabelsEnabled();
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i5 = 0;
        int i6 = 0;
        while (i6 < dataSets.size()) {
            IPieDataSet iPieDataSet3 = (IPieDataSet) dataSets.get(i6);
            boolean isDrawValuesEnabled = iPieDataSet3.isDrawValuesEnabled();
            if (isDrawValuesEnabled || isDrawEntryLabelsEnabled) {
                PieDataSet.ValuePosition xValuePosition = iPieDataSet3.getXValuePosition();
                PieDataSet.ValuePosition yValuePosition = iPieDataSet3.getYValuePosition();
                applyValueTextStyle(iPieDataSet3);
                float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "Q")) + Utils.convertDpToPixel(4.0f);
                IValueFormatter valueFormatter = iPieDataSet3.getValueFormatter();
                int entryCount = iPieDataSet3.getEntryCount();
                this.mValueLinePaint.setColor(iPieDataSet3.getValueLineColor());
                this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(iPieDataSet3.getValueLineWidth()));
                float sliceSpace = getSliceSpace(iPieDataSet3);
                MPPointF instance = MPPointF.getInstance(iPieDataSet3.getIconsOffset());
                instance.x = Utils.convertDpToPixel(instance.x);
                instance.y = Utils.convertDpToPixel(instance.y);
                int i7 = i5;
                int i8 = 0;
                while (i8 < entryCount) {
                    PieEntry pieEntry = (PieEntry) iPieDataSet3.getEntryForIndex(i8);
                    if (i7 == 0) {
                        f4 = Utils.FLOAT_EPSILON;
                    } else {
                        f4 = absoluteAngles[i7 - 1] * phaseX;
                    }
                    float f15 = ((f4 + ((drawAngles[i7] - ((sliceSpace / (f14 * 0.017453292f)) / 2.0f)) / 2.0f)) * phaseY) + rotationAngle;
                    if (this.mChart.isUsePercentValuesEnabled()) {
                        f5 = (pieEntry.getY() / yValueSum) * 100.0f;
                    } else {
                        f5 = pieEntry.getY();
                    }
                    double d2 = (double) (f15 * 0.017453292f);
                    float cos = (float) Math.cos(d2);
                    float sin = (float) Math.sin(d2);
                    boolean z = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z2 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z3 = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    boolean z4 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z || z2) {
                        float valueLinePart1Length = iPieDataSet3.getValueLinePart1Length();
                        float valueLinePart2Length = iPieDataSet3.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iPieDataSet3.getValueLinePart1OffsetPercentage() / 100.0f;
                        valuePosition2 = yValuePosition;
                        if (this.mChart.isDrawHoleEnabled()) {
                            float f16 = radius * holeRadius;
                            f9 = ((radius - f16) * valueLinePart1OffsetPercentage) + f16;
                        } else {
                            f9 = radius * valueLinePart1OffsetPercentage;
                        }
                        float abs = iPieDataSet3.isValueLineVariableLength() ? valueLinePart2Length * f14 * ((float) Math.abs(Math.sin(d2))) : valueLinePart2Length * f14;
                        float f17 = centerCircleBox.x;
                        float f18 = (f9 * cos) + f17;
                        float f19 = centerCircleBox.y;
                        float f20 = (f9 * sin) + f19;
                        float f21 = (valueLinePart1Length + 1.0f) * f14;
                        float f22 = (f21 * cos) + f17;
                        float f23 = (f21 * sin) + f19;
                        double d3 = (double) f15;
                        Double.isNaN(d3);
                        double d4 = d3 % 360.0d;
                        if (d4 < 90.0d || d4 > 270.0d) {
                            f10 = f22 + abs;
                            this.mValuePaint.setTextAlign(Paint.Align.LEFT);
                            if (z) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
                            }
                            f11 = f10 + convertDpToPixel;
                        } else {
                            float f24 = f22 - abs;
                            this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
                            if (z) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
                            }
                            f10 = f24;
                            f11 = f24 - convertDpToPixel;
                        }
                        if (iPieDataSet3.getValueLineColor() != 1122867) {
                            f7 = radius;
                            mPPointF = instance;
                            fArr3 = absoluteAngles;
                            i4 = i8;
                            i3 = entryCount;
                            f12 = f11;
                            valuePosition = xValuePosition;
                            canvas.drawLine(f18, f20, f22, f23, this.mValueLinePaint);
                            canvas.drawLine(f22, f23, f10, f23, this.mValueLinePaint);
                        } else {
                            f12 = f11;
                            valuePosition = xValuePosition;
                            i3 = entryCount;
                            f7 = radius;
                            mPPointF = instance;
                            fArr3 = absoluteAngles;
                            i4 = i8;
                        }
                        if (!z || !z2) {
                            iPieDataSet2 = iPieDataSet3;
                            list2 = dataSets;
                            f6 = cos;
                            if (z) {
                                if (i4 < pieData.getEntryCount() && pieEntry.getLabel() != null) {
                                    drawEntryLabel(canvas, pieEntry.getLabel(), f12, f23 + (calcTextHeight / 2.0f));
                                }
                            } else if (z2) {
                                iPieDataSet = iPieDataSet2;
                                drawValue(canvas, valueFormatter, f5, pieEntry, 0, f12, f23 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i4));
                            }
                        } else {
                            iPieDataSet2 = iPieDataSet3;
                            list2 = dataSets;
                            f6 = cos;
                            drawValue(canvas, valueFormatter, f5, pieEntry, 0, f12, f23, iPieDataSet3.getValueTextColor(i4));
                            if (i4 < pieData.getEntryCount() && pieEntry.getLabel() != null) {
                                drawEntryLabel(canvas, pieEntry.getLabel(), f12, f23 + calcTextHeight);
                            }
                        }
                        iPieDataSet = iPieDataSet2;
                    } else {
                        valuePosition2 = yValuePosition;
                        valuePosition = xValuePosition;
                        iPieDataSet = iPieDataSet3;
                        i3 = entryCount;
                        list2 = dataSets;
                        f6 = cos;
                        f7 = radius;
                        mPPointF = instance;
                        fArr3 = absoluteAngles;
                        i4 = i8;
                    }
                    if (z3 || z4) {
                        float f25 = (f14 * f6) + centerCircleBox.x;
                        float f26 = (f14 * sin) + centerCircleBox.y;
                        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
                        if (!z3 || !z4) {
                            f8 = sin;
                            if (z3) {
                                if (i4 < pieData.getEntryCount() && pieEntry.getLabel() != null) {
                                    drawEntryLabel(canvas, pieEntry.getLabel(), f25, f26 + (calcTextHeight / 2.0f));
                                }
                            } else if (z4) {
                                drawValue(canvas, valueFormatter, f5, pieEntry, 0, f25, f26 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i4));
                            }
                        } else {
                            f8 = sin;
                            drawValue(canvas, valueFormatter, f5, pieEntry, 0, f25, f26, iPieDataSet.getValueTextColor(i4));
                            if (i4 < pieData.getEntryCount() && pieEntry.getLabel() != null) {
                                drawEntryLabel(canvas, pieEntry.getLabel(), f25, f26 + calcTextHeight);
                            }
                        }
                    } else {
                        f8 = sin;
                    }
                    if (pieEntry.getIcon() != null && iPieDataSet.isDrawIconsEnabled()) {
                        Drawable icon = pieEntry.getIcon();
                        float f27 = mPPointF.y;
                        Utils.drawImage(canvas, icon, (int) (((f14 + f27) * f6) + centerCircleBox.x), (int) (((f14 + f27) * f8) + centerCircleBox.y + mPPointF.x), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i7++;
                    i8 = i4 + 1;
                    instance = mPPointF;
                    iPieDataSet3 = iPieDataSet;
                    radius = f7;
                    absoluteAngles = fArr3;
                    i6 = i6;
                    rotationAngle = rotationAngle;
                    drawAngles = drawAngles;
                    dataSets = list2;
                    entryCount = i3;
                    yValuePosition = valuePosition2;
                    xValuePosition = valuePosition;
                }
                i2 = i6;
                list = dataSets;
                f3 = radius;
                f2 = rotationAngle;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                MPPointF.recycleInstance(instance);
                i5 = i7;
            } else {
                i2 = i6;
                list = dataSets;
                f3 = radius;
                f2 = rotationAngle;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
            }
            i6 = i2 + 1;
            radius = f3;
            absoluteAngles = fArr2;
            rotationAngle = f2;
            drawAngles = fArr;
            dataSets = list;
        }
        MPPointF.recycleInstance(centerCircleBox);
        canvas.restore();
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    /* access modifiers changed from: protected */
    public float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return Utils.FLOAT_EPSILON;
        }
        return iPieDataSet.getSliceSpace();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            weakReference.get().recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
