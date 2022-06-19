package com.rd.e;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: DensityUtils */
public class b {
    public static int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, Resources.getSystem().getDisplayMetrics());
    }
}
