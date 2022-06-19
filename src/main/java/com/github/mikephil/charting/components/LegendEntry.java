package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.ColorTemplate;

public class LegendEntry {
    public Legend.LegendForm form = Legend.LegendForm.DEFAULT;
    public int formColor = ColorTemplate.COLOR_NONE;
    public DashPathEffect formLineDashEffect = null;
    public float formLineWidth = Float.NaN;
    public float formSize = Float.NaN;
    public String label;

    public LegendEntry() {
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f2, float f3, DashPathEffect dashPathEffect, int i2) {
        this.label = str;
        this.form = legendForm;
        this.formSize = f2;
        this.formLineWidth = f3;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = i2;
    }
}
