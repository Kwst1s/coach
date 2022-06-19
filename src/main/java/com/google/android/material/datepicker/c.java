package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import c.e.a.b.l;
import c.e.a.b.z.b;

/* access modifiers changed from: package-private */
/* compiled from: CalendarStyle */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    final b f7680a;

    /* renamed from: b  reason: collision with root package name */
    final b f7681b;

    /* renamed from: c  reason: collision with root package name */
    final b f7682c;

    /* renamed from: d  reason: collision with root package name */
    final b f7683d;

    /* renamed from: e  reason: collision with root package name */
    final b f7684e;

    /* renamed from: f  reason: collision with root package name */
    final b f7685f;

    /* renamed from: g  reason: collision with root package name */
    final b f7686g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f7687h;

    c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.c(context, c.e.a.b.b.materialCalendarStyle, h.class.getCanonicalName()), l.D1);
        this.f7680a = b.a(context, obtainStyledAttributes.getResourceId(l.G1, 0));
        this.f7686g = b.a(context, obtainStyledAttributes.getResourceId(l.E1, 0));
        this.f7681b = b.a(context, obtainStyledAttributes.getResourceId(l.F1, 0));
        this.f7682c = b.a(context, obtainStyledAttributes.getResourceId(l.H1, 0));
        ColorStateList a2 = c.e.a.b.z.c.a(context, obtainStyledAttributes, l.I1);
        this.f7683d = b.a(context, obtainStyledAttributes.getResourceId(l.K1, 0));
        this.f7684e = b.a(context, obtainStyledAttributes.getResourceId(l.J1, 0));
        this.f7685f = b.a(context, obtainStyledAttributes.getResourceId(l.L1, 0));
        Paint paint = new Paint();
        this.f7687h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
