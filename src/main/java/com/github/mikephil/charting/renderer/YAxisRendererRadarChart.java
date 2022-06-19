package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;
    private Path mRenderLimitLinesPathBuffer = new Path();

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.mChart = radarChart;
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxisValues(float f2, float f3) {
        double d2;
        double d3;
        int i2;
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
        boolean isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            float f5 = ((float) abs) / ((float) (labelCount - 1));
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i3 = 0; i3 < labelCount; i3++) {
                this.mAxis.mEntries[i3] = f4;
                f4 += f5;
            }
        } else {
            if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                d2 = Utils.DOUBLE_EPSILON;
            } else {
                double d5 = (double) f4;
                Double.isNaN(d5);
                d2 = Math.ceil(d5 / roundToNextSignificant) * roundToNextSignificant;
            }
            if (isCenterAxisLabelsEnabled) {
                d2 -= roundToNextSignificant;
            }
            if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                d3 = 0.0d;
            } else {
                double d6 = (double) f3;
                Double.isNaN(d6);
                d3 = Utils.nextUp(Math.floor(d6 / roundToNextSignificant) * roundToNextSignificant);
            }
            if (roundToNextSignificant != Utils.DOUBLE_EPSILON) {
                i2 = isCenterAxisLabelsEnabled;
                for (double d7 = d2; d7 <= d3; d7 += roundToNextSignificant) {
                    i2++;
                }
            } else {
                i2 = isCenterAxisLabelsEnabled;
            }
            int i4 = i2 + 1;
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = i4;
            if (axisBase3.mEntries.length < i4) {
                axisBase3.mEntries = new float[i4];
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (d2 == Utils.DOUBLE_EPSILON) {
                    d2 = 0.0d;
                }
                this.mAxis.mEntries[i5] = (float) d2;
                d2 += roundToNextSignificant;
            }
            labelCount = i4;
        }
        if (roundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (isCenterAxisLabelsEnabled) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float[] fArr = axisBase4.mEntries;
            float f6 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i6 = 0; i6 < labelCount; i6++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i6] = axisBase5.mEntries[i6] + f6;
            }
        }
        AxisBase axisBase6 = this.mAxis;
        float[] fArr2 = axisBase6.mEntries;
        float f7 = fArr2[0];
        axisBase6.mAxisMinimum = f7;
        float f8 = fArr2[labelCount - 1];
        axisBase6.mAxisMaximum = f8;
        axisBase6.mAxisRange = Math.abs(f8 - f7);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            MPPointF centerOffsets = this.mChart.getCenterOffsets();
            MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            float factor = this.mChart.getFactor();
            int i2 = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
            for (int i3 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i3 < i2; i3++) {
                YAxis yAxis = this.mYAxis;
                Utils.getPosition(centerOffsets, (yAxis.mEntries[i3] - yAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle(), instance);
                canvas.drawText(this.mYAxis.getFormattedLabel(i3), instance.x + 10.0f, instance.y, this.mAxisLabelPaint);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(instance);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null) {
            float sliceAngle = this.mChart.getSliceAngle();
            float factor = this.mChart.getFactor();
            MPPointF centerOffsets = this.mChart.getCenterOffsets();
            MPPointF instance = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
            for (int i2 = 0; i2 < limitLines.size(); i2++) {
                LimitLine limitLine = limitLines.get(i2);
                if (limitLine.isEnabled()) {
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
                    Path path = this.mRenderLimitLinesPathBuffer;
                    path.reset();
                    for (int i3 = 0; i3 < ((IRadarDataSet) ((RadarData) this.mChart.getData()).getMaxEntryCountSet()).getEntryCount(); i3++) {
                        Utils.getPosition(centerOffsets, limit, (((float) i3) * sliceAngle) + this.mChart.getRotationAngle(), instance);
                        if (i3 == 0) {
                            path.moveTo(instance.x, instance.y);
                        } else {
                            path.lineTo(instance.x, instance.y);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.mLimitLinePaint);
                }
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(instance);
        }
    }
}
