package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import b.h.k.d0.c;
import c.e.a.b.d;
import c.e.a.b.f;
import c.e.a.b.h;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.timepicker.ClockHandView;

class ClockFaceView extends a implements ClockHandView.d {
    private final SparseArray<TextView> A;
    private final int[] B;
    private final float[] C;
    private final int D;
    private String[] E;
    private float F;
    private final ClockHandView x;
    private final Rect y;
    private final RectF z;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.x(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.x.g()) - ClockFaceView.this.D);
            return true;
        }
    }

    class b extends b.h.k.a {
        b() {
        }

        @Override // b.h.k.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            int intValue = ((Integer) view.getTag(f.material_value_index)).intValue();
            if (intValue > 0) {
                cVar.B0((View) ClockFaceView.this.A.get(intValue - 1));
            }
            cVar.d0(c.C0048c.a(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void D() {
        RectF d2 = this.x.d();
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            TextView textView = this.A.get(i2);
            textView.getDrawingRect(this.y);
            this.y.offset(textView.getPaddingLeft(), textView.getPaddingTop());
            offsetDescendantRectToMyCoords(textView, this.y);
            this.z.set(this.y);
            textView.getPaint().setShader(E(d2, this.z));
            textView.invalidate();
        }
    }

    private RadialGradient E(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.z.left, rectF.centerY() - this.z.top, rectF.width() * 0.5f, this.B, this.C, Shader.TileMode.CLAMP);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f2, boolean z2) {
        if (Math.abs(this.F - f2) > 0.001f) {
            this.F = f2;
            D();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        c.E0(accessibilityNodeInfo).c0(c.b.a(1, this.E.length, false, 1));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        D();
    }

    @Override // com.google.android.material.timepicker.a
    public void x(int i2) {
        if (i2 != w()) {
            super.x(i2);
            this.x.j(w());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.y = new Rect();
        this.z = new RectF();
        this.A = new SparseArray<>();
        this.C = new float[]{Utils.FLOAT_EPSILON, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.w0, i2, 0);
        Resources resources = getResources();
        obtainStyledAttributes.getColor(l.x0, -16777216);
        LayoutInflater.from(context).inflate(h.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.material_clock_hand);
        this.x = clockHandView;
        this.D = resources.getDimensionPixelSize(d.material_clock_hand_padding);
        int c2 = c.e.a.b.s.a.c(this, c.e.a.b.b.colorOnSurface);
        int c3 = c.e.a.b.s.a.c(this, c.e.a.b.b.colorOnPrimary);
        this.B = new int[]{c3, c3, c2};
        clockHandView.b(this);
        setBackgroundColor(b.a.k.a.a.c(context, c.e.a.b.c.material_timepicker_clockface).getDefaultColor());
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        new b();
    }
}
