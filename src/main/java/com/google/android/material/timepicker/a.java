package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import b.h.k.u;
import c.e.a.b.c0.g;
import c.e.a.b.c0.i;
import c.e.a.b.f;
import c.e.a.b.h;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: RadialViewGroup */
class a extends ConstraintLayout {
    private final Runnable u;
    private int v;
    private g w;

    /* renamed from: com.google.android.material.timepicker.a$a  reason: collision with other inner class name */
    /* compiled from: RadialViewGroup */
    class RunnableC0160a implements Runnable {
        RunnableC0160a() {
        }

        public void run() {
            a.this.z();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable v() {
        g gVar = new g();
        this.w = gVar;
        gVar.V(new i(0.5f));
        this.w.X(ColorStateList.valueOf(-1));
        return this.w;
    }

    private static boolean y(View view) {
        return "skip".equals(view.getTag());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void z() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (y(getChildAt(i3))) {
                i2++;
            }
        }
        d dVar = new d();
        dVar.g(this);
        float f2 = Utils.FLOAT_EPSILON;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            int i5 = f.circle_center;
            if (id != i5 && !y(childAt)) {
                dVar.i(childAt.getId(), i5, this.v, f2);
                f2 += 360.0f / ((float) (childCount - i2));
            }
        }
        dVar.c(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(u.k());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        z();
    }

    public void setBackgroundColor(int i2) {
        this.w.X(ColorStateList.valueOf(i2));
    }

    public int w() {
        return this.v;
    }

    public void x(int i2) {
        this.v = i2;
        z();
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(h.material_radial_view_group, this);
        u.q0(this, v());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.q2, i2, 0);
        this.v = obtainStyledAttributes.getDimensionPixelSize(l.r2, 0);
        this.u = new RunnableC0160a();
        obtainStyledAttributes.recycle();
    }
}
