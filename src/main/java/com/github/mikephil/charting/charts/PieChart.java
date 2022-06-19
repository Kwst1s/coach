package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText;
    private MPPointF mCenterTextOffset;
    private float mCenterTextRadiusPercent;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawEntryLabels;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawSlicesUnderHole;
    private float mHoleRadiusPercent;
    protected float mMaxAngle;
    protected float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    public PieChart(Context context) {
        super(context);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = BuildConfig.FLAVOR;
        this.mCenterTextOffset = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
    }

    private float calcAngle(float f2) {
        return calcAngle(f2, ((PieData) this.mData).getYValueSum());
    }

    private void calcAngles() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.mDrawAngles.length != entryCount) {
            this.mDrawAngles = new float[entryCount];
        } else {
            for (int i2 = 0; i2 < entryCount; i2++) {
                this.mDrawAngles[i2] = 0.0f;
            }
        }
        if (this.mAbsoluteAngles.length != entryCount) {
            this.mAbsoluteAngles = new float[entryCount];
        } else {
            for (int i3 = 0; i3 < entryCount; i3++) {
                this.mAbsoluteAngles[i3] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List dataSets = ((PieData) this.mData).getDataSets();
        int i4 = 0;
        for (int i5 = 0; i5 < ((PieData) this.mData).getDataSetCount(); i5++) {
            IPieDataSet iPieDataSet = (IPieDataSet) dataSets.get(i5);
            for (int i6 = 0; i6 < iPieDataSet.getEntryCount(); i6++) {
                this.mDrawAngles[i4] = calcAngle(Math.abs(((PieEntry) iPieDataSet.getEntryForIndex(i6)).getY()), yValueSum);
                if (i4 == 0) {
                    this.mAbsoluteAngles[i4] = this.mDrawAngles[i4];
                } else {
                    float[] fArr = this.mAbsoluteAngles;
                    fArr[i4] = fArr[i4 - 1] + this.mDrawAngles[i4];
                }
                i4++;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData != null) {
            float diameter = getDiameter() / 2.0f;
            MPPointF centerOffsets = getCenterOffsets();
            float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
            RectF rectF = this.mCircleBox;
            float f2 = centerOffsets.x;
            float f3 = centerOffsets.y;
            rectF.set((f2 - diameter) + selectionShift, (f3 - diameter) + selectionShift, (f2 + diameter) - selectionShift, (f3 + diameter) - selectionShift);
            MPPointF.recycleInstance(centerOffsets);
        }
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.mCenterTextOffset;
        return MPPointF.getInstance(mPPointF.x, mPPointF.y);
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i2) {
        List dataSets = ((PieData) this.mData).getDataSets();
        for (int i3 = 0; i3 < dataSets.size(); i3++) {
            if (((IPieDataSet) dataSets.get(i3)).getEntryForXValue((float) i2, Float.NaN) != null) {
                return i3;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f2) {
        float normalizedAngle = Utils.getNormalizedAngle(f2 - getRotationAngle());
        int i2 = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i2 >= fArr.length) {
                return -1;
            }
            if (fArr[i2] > normalizedAngle) {
                return i2;
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f2 = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f2 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f3 = radius - f2;
        float rotationAngle = getRotationAngle();
        int x = (int) highlight.getX();
        float f4 = this.mDrawAngles[x] / 2.0f;
        double d2 = (double) f3;
        double cos = Math.cos(Math.toRadians((double) (((this.mAbsoluteAngles[x] + rotationAngle) - f4) * this.mAnimator.getPhaseY())));
        Double.isNaN(d2);
        double d3 = (double) centerCircleBox.x;
        Double.isNaN(d3);
        float f5 = (float) ((cos * d2) + d3);
        double sin = Math.sin(Math.toRadians((double) (((rotationAngle + this.mAbsoluteAngles[x]) - f4) * this.mAnimator.getPhaseY())));
        Double.isNaN(d2);
        double d4 = d2 * sin;
        double d5 = (double) centerCircleBox.y;
        Double.isNaN(d5);
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{f5, (float) (d4 + d5)};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return Utils.FLOAT_EPSILON;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        return Utils.FLOAT_EPSILON;
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public boolean needsHighlight(int i2) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i3 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i3].getX()) == i2) {
                return true;
            }
            i3++;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            this.mRenderer.drawExtras(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = BuildConfig.FLAVOR;
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i2) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i2);
    }

    public void setCenterTextOffset(float f2, float f3) {
        this.mCenterTextOffset.x = Utils.convertDpToPixel(f2);
        this.mCenterTextOffset.y = Utils.convertDpToPixel(f3);
    }

    public void setCenterTextRadiusPercent(float f2) {
        this.mCenterTextRadiusPercent = f2;
    }

    public void setCenterTextSize(float f2) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f2));
    }

    public void setCenterTextSizePixels(float f2) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f2);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.mDrawCenterText = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.mDrawEntryLabels = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.mDrawHole = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.mDrawEntryLabels = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.mDrawSlicesUnderHole = z;
    }

    public void setEntryLabelColor(int i2) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i2);
    }

    public void setEntryLabelTextSize(float f2) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f2));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setHoleColor(int i2) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i2);
    }

    public void setHoleRadius(float f2) {
        this.mHoleRadiusPercent = f2;
    }

    public void setMaxAngle(float f2) {
        if (f2 > 360.0f) {
            f2 = 360.0f;
        }
        if (f2 < 90.0f) {
            f2 = 90.0f;
        }
        this.mMaxAngle = f2;
    }

    public void setTransparentCircleAlpha(int i2) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i2);
    }

    public void setTransparentCircleColor(int i2) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i2);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f2) {
        this.mTransparentCircleRadiusPercent = f2;
    }

    public void setUsePercentValues(boolean z) {
        this.mUsePercentValues = z;
    }

    private float calcAngle(float f2, float f3) {
        return (f2 / f3) * this.mMaxAngle;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = BuildConfig.FLAVOR;
        this.mCenterTextOffset = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = BuildConfig.FLAVOR;
        this.mCenterTextOffset = MPPointF.getInstance(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
    }
}
