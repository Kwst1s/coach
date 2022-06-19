package com.google.android.material.theme.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.a.o.d;
import c.e.a.b.b;

/* compiled from: MaterialThemeOverlay */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f8071a = {16842752, b.theme};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f8072b = {b.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8071a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8072b, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i2, int i3) {
        int b2 = b(context, attributeSet, i2, i3);
        boolean z = (context instanceof d) && ((d) context).c() == b2;
        if (b2 == 0 || z) {
            return context;
        }
        d dVar = new d(context, b2);
        int a2 = a(context, attributeSet);
        if (a2 != 0) {
            dVar.getTheme().applyStyle(a2, true);
        }
        return dVar;
    }
}
