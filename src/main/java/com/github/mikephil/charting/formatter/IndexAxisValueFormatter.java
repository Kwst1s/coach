package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.components.AxisBase;
import java.util.Collection;

public class IndexAxisValueFormatter implements IAxisValueFormatter {
    private int mValueCount;
    private String[] mValues;

    public IndexAxisValueFormatter() {
        this.mValues = new String[0];
        this.mValueCount = 0;
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    public String getFormattedValue(float f2, AxisBase axisBase) {
        int round = Math.round(f2);
        return (round < 0 || round >= this.mValueCount || round != ((int) f2)) ? BuildConfig.FLAVOR : this.mValues[round];
    }

    public String[] getValues() {
        return this.mValues;
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.mValues = strArr;
        this.mValueCount = strArr.length;
    }

    public IndexAxisValueFormatter(String[] strArr) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }
}
