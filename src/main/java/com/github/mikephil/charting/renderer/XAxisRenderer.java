package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRenderer extends AxisRenderer {
    protected RectF mGridClippingRect = new RectF();
    protected RectF mLimitLineClippingRect = new RectF();
    private Path mLimitLinePath = new Path();
    float[] mLimitLineSegmentsBuffer = new float[4];
    protected float[] mRenderGridLinesBuffer = new float[2];
    protected Path mRenderGridLinesPath = new Path();
    protected float[] mRenderLimitLinesBuffer = new float[2];
    protected XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f2, float f3, boolean z) {
        float f4;
        double d2;
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (z) {
                f4 = (float) valuesByTouchPoint2.x;
                d2 = valuesByTouchPoint.x;
            } else {
                f4 = (float) valuesByTouchPoint.x;
                d2 = valuesByTouchPoint2.x;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f2 = f4;
            f3 = (float) d2;
        }
        computeAxisValues(f2, f3);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxisValues(float f2, float f3) {
        super.computeAxisValues(f2, f3);
        computeSize();
    }

    /* access modifiers changed from: protected */
    public void computeSize() {
        String longestLabel = this.mXAxis.getLongestLabel();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize calcTextSize = Utils.calcTextSize(this.mAxisLabelPaint, longestLabel);
        float f2 = calcTextSize.width;
        float calcTextHeight = (float) Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f2, calcTextHeight, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(f2);
        this.mXAxis.mLabelHeight = Math.round(calcTextHeight);
        this.mXAxis.mLabelRotatedWidth = Math.round(sizeOfRotatedRectangleByDegrees.width);
        this.mXAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
        FSize.recycleInstance(calcTextSize);
    }

    /* access modifiers changed from: protected */
    public void drawGridLine(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(f2, this.mViewPortHandler.contentBottom());
        path.lineTo(f2, this.mViewPortHandler.contentTop());
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, String str, float f2, float f3, MPPointF mPPointF, float f4) {
        Utils.drawXAxisValue(canvas, str, f2, f3, this.mAxisLabelPaint, mPPointF, f4);
    }

    /* access modifiers changed from: protected */
    public void drawLabels(Canvas canvas, float f2, MPPointF mPPointF) {
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        boolean isCenterAxisLabelsEnabled = this.mXAxis.isCenterAxisLabelsEnabled();
        int i2 = this.mXAxis.mEntryCount * 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3 += 2) {
            if (isCenterAxisLabelsEnabled) {
                fArr[i3] = this.mXAxis.mCenteredEntries[i3 / 2];
            } else {
                fArr[i3] = this.mXAxis.mEntries[i3 / 2];
            }
        }
        this.mTrans.pointValuesToPixel(fArr);
        for (int i4 = 0; i4 < i2; i4 += 2) {
            float f3 = fArr[i4];
            if (this.mViewPortHandler.isInBoundsX(f3)) {
                IAxisValueFormatter valueFormatter = this.mXAxis.getValueFormatter();
                XAxis xAxis = this.mXAxis;
                String formattedValue = valueFormatter.getFormattedValue(xAxis.mEntries[i4 / 2], xAxis);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    int i5 = this.mXAxis.mEntryCount;
                    if (i4 == i5 - 1 && i5 > 1) {
                        float calcTextWidth = (float) Utils.calcTextWidth(this.mAxisLabelPaint, formattedValue);
                        if (calcTextWidth > this.mViewPortHandler.offsetRight() * 2.0f && f3 + calcTextWidth > this.mViewPortHandler.getChartWidth()) {
                            f3 -= calcTextWidth / 2.0f;
                        }
                    } else if (i4 == 0) {
                        f3 += ((float) Utils.calcTextWidth(this.mAxisLabelPaint, formattedValue)) / 2.0f;
                    }
                }
                drawLabel(canvas, formattedValue, f3, f2, mPPointF, labelRotationAngle);
            }
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), Utils.FLOAT_EPSILON);
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float yOffset = this.mXAxis.getYOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                instance.x = 0.5f;
                instance.y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                instance.x = 0.5f;
                instance.y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() + yOffset + ((float) this.mXAxis.mLabelRotatedHeight), instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                instance.x = 0.5f;
                instance.y = Utils.FLOAT_EPSILON;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                instance.x = 0.5f;
                instance.y = Utils.FLOAT_EPSILON;
                drawLabels(canvas, (this.mViewPortHandler.contentBottom() - yOffset) - ((float) this.mXAxis.mLabelRotatedHeight), instance);
            } else {
                instance.x = 0.5f;
                instance.y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, instance);
                instance.x = 0.5f;
                instance.y = Utils.FLOAT_EPSILON;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, instance);
            }
            MPPointF.recycleInstance(instance);
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            this.mAxisLinePaint.setPathEffect(this.mXAxis.getAxisLineDashPathEffect());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            int save = canvas.save();
            canvas.clipRect(getGridClippingRect());
            if (this.mRenderGridLinesBuffer.length != this.mAxis.mEntryCount * 2) {
                this.mRenderGridLinesBuffer = new float[(this.mXAxis.mEntryCount * 2)];
            }
            float[] fArr = this.mRenderGridLinesBuffer;
            for (int i2 = 0; i2 < fArr.length; i2 += 2) {
                float[] fArr2 = this.mXAxis.mEntries;
                int i3 = i2 / 2;
                fArr[i2] = fArr2[i3];
                fArr[i2 + 1] = fArr2[i3];
            }
            this.mTrans.pointValuesToPixel(fArr);
            setupGridPaint();
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                drawGridLine(canvas, fArr[i4], fArr[i4 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void renderLimitLineLabel(Canvas canvas, LimitLine limitLine, float[] fArr, float f2) {
        String label = limitLine.getLabel();
        if (label != null && !label.equals(BuildConfig.FLAVOR)) {
            this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
            this.mLimitLinePaint.setPathEffect(null);
            this.mLimitLinePaint.setColor(limitLine.getTextColor());
            this.mLimitLinePaint.setStrokeWidth(0.5f);
            this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
            float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
            LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
            if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + f2 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - f2, this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + f2 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - f2, this.mLimitLinePaint);
            }
        }
    }

    public void renderLimitLineLine(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.mLimitLineSegmentsBuffer;
        fArr2[0] = fArr[0];
        fArr2[1] = this.mViewPortHandler.contentTop();
        float[] fArr3 = this.mLimitLineSegmentsBuffer;
        fArr3[2] = fArr[0];
        fArr3[3] = this.mViewPortHandler.contentBottom();
        this.mLimitLinePath.reset();
        Path path = this.mLimitLinePath;
        float[] fArr4 = this.mLimitLineSegmentsBuffer;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.mLimitLinePath;
        float[] fArr5 = this.mLimitLineSegmentsBuffer;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(limitLine.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
        this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
        canvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = this.mRenderLimitLinesBuffer;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i2 = 0; i2 < limitLines.size(); i2++) {
                LimitLine limitLine = limitLines.get(i2);
                if (limitLine.isEnabled()) {
                    int save = canvas.save();
                    this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                    this.mLimitLineClippingRect.inset(-limitLine.getLineWidth(), Utils.FLOAT_EPSILON);
                    canvas.clipRect(this.mLimitLineClippingRect);
                    fArr[0] = limitLine.getLimit();
                    fArr[1] = 0.0f;
                    this.mTrans.pointValuesToPixel(fArr);
                    renderLimitLineLine(canvas, limitLine, fArr);
                    renderLimitLineLabel(canvas, limitLine, fArr, limitLine.getYOffset() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setupGridPaint() {
        this.mGridPaint.setColor(this.mXAxis.getGridColor());
        this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
        this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
    }
}
