package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import b.h.j.h;
import b.h.k.u;
import c.e.a.b.c0.g;
import c.e.a.b.c0.k;
import c.e.a.b.l;
import c.e.a.b.z.c;

/* compiled from: CalendarItemStyle */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f7674a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f7675b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f7676c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f7677d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7678e;

    /* renamed from: f  reason: collision with root package name */
    private final k f7679f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, k kVar, Rect rect) {
        h.b(rect.left);
        h.b(rect.top);
        h.b(rect.right);
        h.b(rect.bottom);
        this.f7674a = rect;
        this.f7675b = colorStateList2;
        this.f7676c = colorStateList;
        this.f7677d = colorStateList3;
        this.f7678e = i2;
        this.f7679f = kVar;
    }

    static b a(Context context, int i2) {
        h.a(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.M1);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(l.N1, 0), obtainStyledAttributes.getDimensionPixelOffset(l.P1, 0), obtainStyledAttributes.getDimensionPixelOffset(l.O1, 0), obtainStyledAttributes.getDimensionPixelOffset(l.Q1, 0));
        ColorStateList a2 = c.a(context, obtainStyledAttributes, l.R1);
        ColorStateList a3 = c.a(context, obtainStyledAttributes, l.W1);
        ColorStateList a4 = c.a(context, obtainStyledAttributes, l.U1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.V1, 0);
        k m = k.b(context, obtainStyledAttributes.getResourceId(l.S1, 0), obtainStyledAttributes.getResourceId(l.T1, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a2, a3, a4, dimensionPixelSize, m, rect);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f7674a.bottom;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f7674a.top;
    }

    /* access modifiers changed from: package-private */
    public void d(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f7679f);
        gVar2.setShapeAppearanceModel(this.f7679f);
        gVar.X(this.f7676c);
        gVar.e0((float) this.f7678e, this.f7677d);
        textView.setTextColor(this.f7675b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f7675b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.f7674a;
        u.q0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
