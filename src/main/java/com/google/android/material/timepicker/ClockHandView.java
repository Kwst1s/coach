package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import b.h.k.u;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public class ClockHandView extends View {

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f8080b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8081c;

    /* renamed from: d  reason: collision with root package name */
    private float f8082d;

    /* renamed from: e  reason: collision with root package name */
    private float f8083e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8084f;

    /* renamed from: g  reason: collision with root package name */
    private int f8085g;

    /* renamed from: h  reason: collision with root package name */
    private final List<d> f8086h;

    /* renamed from: i  reason: collision with root package name */
    private final int f8087i;

    /* renamed from: j  reason: collision with root package name */
    private final float f8088j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f8089k;
    private final RectF l;
    private final int m;
    private float n;
    private boolean o;
    private c p;
    private double q;
    private int r;

    /* access modifiers changed from: package-private */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends AnimatorListenerAdapter {
        b(ClockHandView clockHandView) {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f2, boolean z);
    }

    public interface d {
        void a(float f2, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.f8089k.setStrokeWidth(Utils.FLOAT_EPSILON);
        canvas.drawCircle((((float) this.r) * ((float) Math.cos(this.q))) + f2, (((float) this.r) * ((float) Math.sin(this.q))) + f3, (float) this.f8087i, this.f8089k);
        double sin = Math.sin(this.q);
        double cos = Math.cos(this.q);
        double d2 = (double) ((float) (this.r - this.f8087i));
        Double.isNaN(d2);
        Double.isNaN(d2);
        this.f8089k.setStrokeWidth((float) this.m);
        canvas.drawLine(f2, f3, (float) (width + ((int) (cos * d2))), (float) (height + ((int) (d2 * sin))), this.f8089k);
        canvas.drawCircle(f2, f3, this.f8088j, this.f8089k);
    }

    private int e(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair<Float, Float> h(float f2) {
        float f3 = f();
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f3), Float.valueOf(f2));
    }

    private boolean i(float f2, float f3, boolean z, boolean z2, boolean z3) {
        float e2 = (float) e(f2, f3);
        boolean z4 = false;
        boolean z5 = f() != e2;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.f8081c) {
            z4 = true;
        }
        l(e2, z4);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.n = f3;
        this.q = Math.toRadians((double) (f3 - 90.0f));
        float width = ((float) (getWidth() / 2)) + (((float) this.r) * ((float) Math.cos(this.q)));
        float height = ((float) (getHeight() / 2)) + (((float) this.r) * ((float) Math.sin(this.q)));
        RectF rectF = this.l;
        int i2 = this.f8087i;
        rectF.set(width - ((float) i2), height - ((float) i2), width + ((float) i2), height + ((float) i2));
        for (d dVar : this.f8086h) {
            dVar.a(f3, z);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f8086h.add(dVar);
    }

    public RectF d() {
        return this.l;
    }

    public float f() {
        return this.n;
    }

    public int g() {
        return this.f8087i;
    }

    public void j(int i2) {
        this.r = i2;
        invalidate();
    }

    public void k(float f2) {
        l(f2, false);
    }

    public void l(float f2, boolean z) {
        ValueAnimator valueAnimator = this.f8080b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            m(f2, false);
            return;
        }
        Pair<Float, Float> h2 = h(f2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h2.first).floatValue(), ((Float) h2.second).floatValue());
        this.f8080b = ofFloat;
        ofFloat.setDuration(200L);
        this.f8080b.addUpdateListener(new a());
        this.f8080b.addListener(new b(this));
        this.f8080b.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        k(f());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.f8082d);
                int i3 = (int) (y - this.f8083e);
                this.f8084f = (i2 * i2) + (i3 * i3) > this.f8085g;
                boolean z4 = this.o;
                z3 = actionMasked == 1;
                z2 = z4;
            } else {
                z3 = false;
                z2 = false;
            }
            z = false;
        } else {
            this.f8082d = x;
            this.f8083e = y;
            this.f8084f = true;
            this.o = false;
            z3 = false;
            z2 = false;
            z = true;
        }
        boolean i4 = i(x, y, z2, z, z3) | this.o;
        this.o = i4;
        if (i4 && z3 && (cVar = this.p) != null) {
            cVar.a((float) e(x, y), this.f8084f);
        }
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8086h = new ArrayList();
        Paint paint = new Paint();
        this.f8089k = paint;
        this.l = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.y0, i2, 0);
        this.r = obtainStyledAttributes.getDimensionPixelSize(l.z0, 0);
        this.f8087i = obtainStyledAttributes.getDimensionPixelSize(l.A0, 0);
        Resources resources = getResources();
        this.m = resources.getDimensionPixelSize(c.e.a.b.d.material_clock_hand_stroke_width);
        this.f8088j = (float) resources.getDimensionPixelSize(c.e.a.b.d.material_clock_hand_center_dot_radius);
        int c2 = c.e.a.b.s.a.c(this, c.e.a.b.b.f3257k);
        paint.setAntiAlias(true);
        paint.setColor(c2);
        k(Utils.FLOAT_EPSILON);
        this.f8085g = ViewConfiguration.get(context).getScaledTouchSlop();
        u.x0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
