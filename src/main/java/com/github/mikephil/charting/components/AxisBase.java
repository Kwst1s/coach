package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
    private int mAxisLineColor = -7829368;
    private DashPathEffect mAxisLineDashPathEffect = null;
    private float mAxisLineWidth = 1.0f;
    public float mAxisMaximum = Utils.FLOAT_EPSILON;
    public float mAxisMinimum = Utils.FLOAT_EPSILON;
    public float mAxisRange = Utils.FLOAT_EPSILON;
    protected IAxisValueFormatter mAxisValueFormatter;
    protected boolean mCenterAxisLabels = false;
    public float[] mCenteredEntries = new float[0];
    protected boolean mCustomAxisMax = false;
    protected boolean mCustomAxisMin = false;
    public int mDecimals;
    protected boolean mDrawAxisLine = true;
    protected boolean mDrawGridLines = true;
    protected boolean mDrawLabels = true;
    protected boolean mDrawLimitLineBehindData = false;
    public float[] mEntries = new float[0];
    public int mEntryCount;
    protected boolean mForceLabels = false;
    protected float mGranularity = 1.0f;
    protected boolean mGranularityEnabled = false;
    private int mGridColor = -7829368;
    private DashPathEffect mGridDashPathEffect = null;
    private float mGridLineWidth = 1.0f;
    private int mLabelCount = 6;
    protected List<LimitLine> mLimitLines;
    protected float mSpaceMax = Utils.FLOAT_EPSILON;
    protected float mSpaceMin = Utils.FLOAT_EPSILON;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        if (this.mLimitLines.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public void calculate(float f2, float f3) {
        float f4 = this.mCustomAxisMin ? this.mAxisMinimum : f2 - this.mSpaceMin;
        float f5 = this.mCustomAxisMax ? this.mAxisMaximum : f3 + this.mSpaceMax;
        if (Math.abs(f5 - f4) == Utils.FLOAT_EPSILON) {
            f5 += 1.0f;
            f4 -= 1.0f;
        }
        this.mAxisMinimum = f4;
        this.mAxisMaximum = f5;
        this.mAxisRange = Math.abs(f5 - f4);
    }

    public void disableAxisLineDashedLine() {
        this.mAxisLineDashPathEffect = null;
    }

    public void disableGridDashedLine() {
        this.mGridDashPathEffect = null;
    }

    public void enableAxisLineDashedLine(float f2, float f3, float f4) {
        this.mAxisLineDashPathEffect = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public void enableGridDashedLine(float f2, float f3, float f4) {
        this.mGridDashPathEffect = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public int getAxisLineColor() {
        return this.mAxisLineColor;
    }

    public DashPathEffect getAxisLineDashPathEffect() {
        return this.mAxisLineDashPathEffect;
    }

    public float getAxisLineWidth() {
        return this.mAxisLineWidth;
    }

    public float getAxisMaximum() {
        return this.mAxisMaximum;
    }

    public float getAxisMinimum() {
        return this.mAxisMinimum;
    }

    public String getFormattedLabel(int i2) {
        return (i2 < 0 || i2 >= this.mEntries.length) ? BuildConfig.FLAVOR : getValueFormatter().getFormattedValue(this.mEntries[i2], this);
    }

    public float getGranularity() {
        return this.mGranularity;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.mGridDashPathEffect;
    }

    public float getGridLineWidth() {
        return this.mGridLineWidth;
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public String getLongestLabel() {
        String str = BuildConfig.FLAVOR;
        for (int i2 = 0; i2 < this.mEntries.length; i2++) {
            String formattedLabel = getFormattedLabel(i2);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public float getSpaceMax() {
        return this.mSpaceMax;
    }

    public float getSpaceMin() {
        return this.mSpaceMin;
    }

    public IAxisValueFormatter getValueFormatter() {
        IAxisValueFormatter iAxisValueFormatter = this.mAxisValueFormatter;
        if (iAxisValueFormatter == null || ((iAxisValueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) iAxisValueFormatter).getDecimalDigits() != this.mDecimals)) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }

    public boolean isAxisLineDashedLineEnabled() {
        return this.mAxisLineDashPathEffect != null;
    }

    public boolean isAxisMaxCustom() {
        return this.mCustomAxisMax;
    }

    public boolean isAxisMinCustom() {
        return this.mCustomAxisMin;
    }

    public boolean isCenterAxisLabelsEnabled() {
        return this.mCenterAxisLabels && this.mEntryCount > 0;
    }

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public boolean isGranularityEnabled() {
        return this.mGranularityEnabled;
    }

    public boolean isGridDashedLineEnabled() {
        return this.mGridDashPathEffect != null;
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void resetAxisMaximum() {
        this.mCustomAxisMax = false;
    }

    public void resetAxisMinimum() {
        this.mCustomAxisMin = false;
    }

    public void setAxisLineColor(int i2) {
        this.mAxisLineColor = i2;
    }

    public void setAxisLineDashedLine(DashPathEffect dashPathEffect) {
        this.mAxisLineDashPathEffect = dashPathEffect;
    }

    public void setAxisLineWidth(float f2) {
        this.mAxisLineWidth = Utils.convertDpToPixel(f2);
    }

    @Deprecated
    public void setAxisMaxValue(float f2) {
        setAxisMaximum(f2);
    }

    public void setAxisMaximum(float f2) {
        this.mCustomAxisMax = true;
        this.mAxisMaximum = f2;
        this.mAxisRange = Math.abs(f2 - this.mAxisMinimum);
    }

    @Deprecated
    public void setAxisMinValue(float f2) {
        setAxisMinimum(f2);
    }

    public void setAxisMinimum(float f2) {
        this.mCustomAxisMin = true;
        this.mAxisMinimum = f2;
        this.mAxisRange = Math.abs(this.mAxisMaximum - f2);
    }

    public void setCenterAxisLabels(boolean z) {
        this.mCenterAxisLabels = z;
    }

    public void setDrawAxisLine(boolean z) {
        this.mDrawAxisLine = z;
    }

    public void setDrawGridLines(boolean z) {
        this.mDrawGridLines = z;
    }

    public void setDrawLabels(boolean z) {
        this.mDrawLabels = z;
    }

    public void setDrawLimitLinesBehindData(boolean z) {
        this.mDrawLimitLineBehindData = z;
    }

    public void setGranularity(float f2) {
        this.mGranularity = f2;
        this.mGranularityEnabled = true;
    }

    public void setGranularityEnabled(boolean z) {
        this.mGranularityEnabled = z;
    }

    public void setGridColor(int i2) {
        this.mGridColor = i2;
    }

    public void setGridDashedLine(DashPathEffect dashPathEffect) {
        this.mGridDashPathEffect = dashPathEffect;
    }

    public void setGridLineWidth(float f2) {
        this.mGridLineWidth = Utils.convertDpToPixel(f2);
    }

    public void setLabelCount(int i2) {
        if (i2 > 25) {
            i2 = 25;
        }
        if (i2 < 2) {
            i2 = 2;
        }
        this.mLabelCount = i2;
        this.mForceLabels = false;
    }

    public void setSpaceMax(float f2) {
        this.mSpaceMax = f2;
    }

    public void setSpaceMin(float f2) {
        this.mSpaceMin = f2;
    }

    public void setValueFormatter(IAxisValueFormatter iAxisValueFormatter) {
        if (iAxisValueFormatter == null) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        } else {
            this.mAxisValueFormatter = iAxisValueFormatter;
        }
    }

    public void setLabelCount(int i2, boolean z) {
        setLabelCount(i2);
        this.mForceLabels = z;
    }
}
