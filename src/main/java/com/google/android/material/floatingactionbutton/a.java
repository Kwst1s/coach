package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import c.e.a.b.c0.k;
import c.e.a.b.c0.l;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: BorderDrawable */
public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final l f7768a = l.k();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f7769b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f7770c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f7771d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f7772e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f7773f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f7774g = new b();

    /* renamed from: h  reason: collision with root package name */
    float f7775h;

    /* renamed from: i  reason: collision with root package name */
    private int f7776i;

    /* renamed from: j  reason: collision with root package name */
    private int f7777j;

    /* renamed from: k  reason: collision with root package name */
    private int f7778k;
    private int l;
    private int m;
    private boolean n = true;
    private k o;
    private ColorStateList p;

    /* compiled from: BorderDrawable */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return a.this;
        }
    }

    a(k kVar) {
        this.o = kVar;
        Paint paint = new Paint(1);
        this.f7769b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.f7771d;
        copyBounds(rect);
        float height = this.f7775h / ((float) rect.height());
        return new LinearGradient((float) Utils.FLOAT_EPSILON, (float) rect.top, (float) Utils.FLOAT_EPSILON, (float) rect.bottom, new int[]{b.h.e.a.b(this.f7776i, this.m), b.h.e.a.b(this.f7777j, this.m), b.h.e.a.b(b.h.e.a.d(this.f7777j, 0), this.m), b.h.e.a.b(b.h.e.a.d(this.l, 0), this.m), b.h.e.a.b(this.l, this.m), b.h.e.a.b(this.f7778k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public RectF b() {
        this.f7773f.set(getBounds());
        return this.f7773f;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void d(float f2) {
        if (this.f7775h != f2) {
            this.f7775h = f2;
            this.f7769b.setStrokeWidth(f2 * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            this.f7769b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.f7769b.getStrokeWidth() / 2.0f;
        copyBounds(this.f7771d);
        this.f7772e.set(this.f7771d);
        float min = Math.min(this.o.r().a(b()), this.f7772e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f7772e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f7772e, min, min, this.f7769b);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3, int i4, int i5) {
        this.f7776i = i2;
        this.f7777j = i3;
        this.f7778k = i4;
        this.l = i5;
    }

    public void f(k kVar) {
        this.o = kVar;
        invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f7774g;
    }

    public int getOpacity() {
        return this.f7775h > Utils.FLOAT_EPSILON ? -3 : -2;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f7771d);
        this.f7772e.set(this.f7771d);
        this.f7768a.d(this.o, 1.0f, this.f7772e, this.f7770c);
        if (this.f7770c.isConvex()) {
            outline.setConvexPath(this.f7770c);
        }
    }

    public boolean getPadding(Rect rect) {
        if (!this.o.u(b())) {
            return true;
        }
        int round = Math.round(this.f7775h);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.m)) == this.m)) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    public void setAlpha(int i2) {
        this.f7769b.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7769b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
