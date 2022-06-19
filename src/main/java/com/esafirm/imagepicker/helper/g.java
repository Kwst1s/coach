package com.esafirm.imagepicker.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import b.h.d.a;
import c.c.a.b;

/* compiled from: ViewUtils */
public class g {
    public static Drawable a(Context context) {
        int i2;
        if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
            i2 = b.ef_ic_arrow_back;
        } else {
            i2 = b.ef_ic_arrow_forward;
        }
        return a.d(context.getApplicationContext(), i2);
    }
}
