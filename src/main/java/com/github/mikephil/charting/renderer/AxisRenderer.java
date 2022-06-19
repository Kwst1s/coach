package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(-16777216);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f2, float f3, boolean z) {
        float f4;
        double d2;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!z) {
                f4 = (float) valuesByTouchPoint2.y;
                d2 = valuesByTouchPoint.y;
            } else {
                f4 = (float) valuesByTouchPoint.y;
                d2 = valuesByTouchPoint2.y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f2 = f4;
            f3 = (float) d2;
        }
        computeAxisValues(f2, f3);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00e5 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* access modifiers changed from: protected */
    public void computeAxisValues(float f2, float f3) {
        double d2;
        double d3;
        float f4 = f2;
        int labelCount = this.mAxis.getLabelCount();
        double abs = (double) Math.abs(f3 - f4);
        if (labelCount == 0 || abs <= Utils.DOUBLE_EPSILON || Double.isInfinite(abs)) {
            AxisBase axisBase = this.mAxis;
            axisBase.mEntries = new float[0];
            axisBase.mCenteredEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double d4 = (double) labelCount;
        Double.isNaN(abs);
        Double.isNaN(d4);
        double roundToNextSignificant = (double) Utils.roundToNextSignificant(abs / d4);
        if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < ((double) this.mAxis.getGranularity())) {
            roundToNextSignificant = (double) this.mAxis.getGranularity();
        }
        double roundToNextSignificant2 = (double) Utils.roundToNextSignificant(Math.pow(10.0d, (double) ((int) Math.log10(roundToNextSignificant))));
        Double.isNaN(roundToNextSignificant2);
        if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
            Double.isNaN(roundToNextSignificant2);
            roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
        }
        int isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            roundToNextSignificant = (double) (((float) abs) / ((float) (labelCount - 1)));
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i2 = 0; i2 < labelCount; i2++) {
                this.mAxis.mEntries[i2] = f4;
                double d5 = (double) f4;
                Double.isNaN(d5);
                Double.isNaN(roundToNextSignificant);
                f4 = (float) (d5 + roundToNextSignificant);
            }
        } else {
            if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                d2 = Utils.DOUBLE_EPSILON;
            } else {
                double d6 = (double) f4;
                Double.isNaN(d6);
                d2 = Math.ceil(d6 / roundToNextSignificant) * roundToNextSignificant;
            }
            if (this.mAxis.isCenterAxisLabelsEnabled()) {
                d2 -= roundToNextSignificant;
            }
            if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                d3 = 0.0d;
            } else {
                double d7 = (double) f3;
                Double.isNaN(d7);
                d3 = Utils.nextUp(Math.floor(d7 / roundToNextSignificant) * roundToNextSignificant);
            }
            if (roundToNextSignificant != Utils.DOUBLE_EPSILON) {
                double d8 = d2;
                isCenterAxisLabelsEnabled = isCenterAxisLabelsEnabled;
                while (d8 <= d3) {
                    d8 += roundToNextSignificant;
                    isCenterAxisLabelsEnabled++;
                }
            }
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = isCenterAxisLabelsEnabled;
            if (axisBase3.mEntries.length < isCenterAxisLabelsEnabled) {
                axisBase3.mEntries = new float[isCenterAxisLabelsEnabled];
            }
            for (int i3 = 0; i3 < isCenterAxisLabelsEnabled; i3++) {
                if (d2 == Utils.DOUBLE_EPSILON) {
                    d2 = 0.0d;
                }
                this.mAxis.mEntries[i3] = (float) d2;
                d2 += roundToNextSignificant;
            }
            labelCount = isCenterAxisLabelsEnabled;
        }
        if (roundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (this.mAxis.isCenterAxisLabelsEnabled()) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float f5 = ((float) roundToNextSignificant) / 2.0f;
            for (int i4 = 0; i4 < labelCount; i4++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i4] = axisBase5.mEntries[i4] + f5;
            }
        }
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);
}
