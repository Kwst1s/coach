package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import c.e.a.b.c0.g;
import c.e.a.b.l;
import c.e.a.b.z.c;
import c.e.a.b.z.d;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;
import com.google.android.material.internal.k;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: ChipDrawable */
public class a extends g implements b, Drawable.Callback, h.b {
    private static final int[] J0 = {16842910};
    private static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private PorterDuff.Mode A0 = PorterDuff.Mode.SRC_IN;
    private float B;
    private int[] B0;
    private float C = -1.0f;
    private boolean C0;
    private ColorStateList D;
    private ColorStateList D0;
    private float E;
    private WeakReference<AbstractC0150a> E0 = new WeakReference<>(null);
    private ColorStateList F;
    private TextUtils.TruncateAt F0;
    private CharSequence G;
    private boolean G0;
    private boolean H;
    private int H0;
    private Drawable I;
    private boolean I0;
    private ColorStateList J;
    private float K;
    private boolean L;
    private boolean M;
    private Drawable N;
    private Drawable O;
    private ColorStateList P;
    private float Q;
    private CharSequence R;
    private boolean S;
    private boolean T;
    private Drawable U;
    private ColorStateList V;
    private c.e.a.b.m.h W;
    private c.e.a.b.m.h X;
    private float Y;
    private float Z;
    private float a0;
    private float b0;
    private float c0;
    private float d0;
    private float e0;
    private float f0;
    private final Context g0;
    private final Paint h0 = new Paint(1);
    private final Paint i0;
    private final Paint.FontMetrics j0 = new Paint.FontMetrics();
    private final RectF k0 = new RectF();
    private final PointF l0 = new PointF();
    private final Path m0 = new Path();
    private final h n0;
    private int o0;
    private int p0;
    private int q0;
    private int r0;
    private int s0;
    private int t0;
    private boolean u0;
    private int v0;
    private int w0 = 255;
    private ColorFilter x0;
    private PorterDuffColorFilter y0;
    private ColorStateList z;
    private ColorStateList z0;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    /* compiled from: ChipDrawable */
    public interface AbstractC0150a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        M(context);
        this.g0 = context;
        h hVar = new h(this);
        this.n0 = hVar;
        this.G = BuildConfig.FLAVOR;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.i0 = null;
        int[] iArr = J0;
        setState(iArr);
        l2(iArr);
        this.G0 = true;
        if (c.e.a.b.a0.b.f3242a) {
            K0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (!this.I0) {
            this.h0.setColor(this.o0);
            this.h0.setStyle(Paint.Style.FILL);
            this.k0.set(rect);
            canvas.drawRoundRect(this.k0, I0(), I0(), this.h0);
        }
    }

    private void B0(Canvas canvas, Rect rect) {
        if (O2()) {
            o0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.N.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            if (c.e.a.b.a0.b.f3242a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
            } else {
                this.N.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private void C0(Canvas canvas, Rect rect) {
        this.h0.setColor(this.s0);
        this.h0.setStyle(Paint.Style.FILL);
        this.k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.k0, I0(), I0(), this.h0);
            return;
        }
        h(new RectF(rect), this.m0);
        super.p(canvas, this.h0, this.m0, u());
    }

    private void D0(Canvas canvas, Rect rect) {
        Paint paint = this.i0;
        if (paint != null) {
            paint.setColor(b.h.e.a.d(-16777216, 127));
            canvas.drawRect(rect, this.i0);
            if (N2() || M2()) {
                l0(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            if (this.G != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.i0);
            }
            if (O2()) {
                o0(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            this.i0.setColor(b.h.e.a.d(-65536, 127));
            n0(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
            this.i0.setColor(b.h.e.a.d(-16711936, 127));
            p0(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
        }
    }

    private void E0(Canvas canvas, Rect rect) {
        if (this.G != null) {
            Paint.Align t02 = t0(rect, this.l0);
            r0(rect, this.k0);
            if (this.n0.d() != null) {
                this.n0.e().drawableState = getState();
                this.n0.j(this.g0);
            }
            this.n0.e().setTextAlign(t02);
            int i2 = 0;
            boolean z2 = Math.round(this.n0.f(h1().toString())) > Math.round(this.k0.width());
            if (z2) {
                i2 = canvas.save();
                canvas.clipRect(this.k0);
            }
            CharSequence charSequence = this.G;
            if (z2 && this.F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.n0.e(), this.k0.width(), this.F0);
            }
            int length = charSequence.length();
            PointF pointF = this.l0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.n0.e());
            if (z2) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private boolean M2() {
        return this.T && this.U != null && this.u0;
    }

    private boolean N2() {
        return this.H && this.I != null;
    }

    private boolean O2() {
        return this.M && this.N != null;
    }

    private void P2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void Q2() {
        this.D0 = this.C0 ? c.e.a.b.a0.b.d(this.F) : null;
    }

    @TargetApi(21)
    private void R2() {
        this.O = new RippleDrawable(c.e.a.b.a0.b.d(f1()), this.N, K0);
    }

    private float Z0() {
        Drawable drawable = this.u0 ? this.U : this.I;
        float f2 = this.K;
        if (f2 <= Utils.FLOAT_EPSILON && drawable != null) {
            f2 = (float) Math.ceil((double) k.b(this.g0, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f2) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f2;
    }

    private float a1() {
        Drawable drawable = this.u0 ? this.U : this.I;
        float f2 = this.K;
        return (f2 > Utils.FLOAT_EPSILON || drawable == null) ? f2 : (float) drawable.getIntrinsicWidth();
    }

    private void b2(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    private void k0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.N) {
                if (drawable.isStateful()) {
                    drawable.setState(W0());
                }
                androidx.core.graphics.drawable.a.o(drawable, this.P);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.I;
            if (drawable == drawable2 && this.L) {
                androidx.core.graphics.drawable.a.o(drawable2, this.J);
            }
        }
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (N2() || M2()) {
            float f2 = this.Y + this.Z;
            float a1 = a1();
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + a1;
            } else {
                float f4 = ((float) rect.right) - f2;
                rectF.right = f4;
                rectF.left = f4 - a1;
            }
            float Z0 = Z0();
            float exactCenterY = rect.exactCenterY() - (Z0 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + Z0;
        }
    }

    private ColorFilter l1() {
        ColorFilter colorFilter = this.x0;
        return colorFilter != null ? colorFilter : this.y0;
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (O2()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
            } else {
                rectF.left = ((float) rect.left) + f2;
            }
        }
    }

    private static boolean n1(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void o0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (O2()) {
            float f2 = this.f0 + this.e0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.Q;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF.left = f4;
                rectF.right = f4 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.Q;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private void p0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (O2()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private void r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float m02 = this.Y + m0() + this.b0;
            float q02 = this.f0 + q0() + this.c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = ((float) rect.left) + m02;
                rectF.right = ((float) rect.right) - q02;
            } else {
                rectF.left = ((float) rect.left) + q02;
                rectF.right = ((float) rect.right) - m02;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean r1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float s0() {
        this.n0.e().getFontMetrics(this.j0);
        Paint.FontMetrics fontMetrics = this.j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean s1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean t1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f3452a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private boolean u0() {
        return this.T && this.U != null && this.S;
    }

    private void u1(AttributeSet attributeSet, int i2, int i3) {
        TypedArray h2 = j.h(this.g0, attributeSet, l.y, i2, i3, new int[0]);
        this.I0 = h2.hasValue(l.k0);
        b2(c.a(this.g0, h2, l.X));
        F1(c.a(this.g0, h2, l.K));
        T1(h2.getDimension(l.S, Utils.FLOAT_EPSILON));
        int i4 = l.L;
        if (h2.hasValue(i4)) {
            H1(h2.getDimension(i4, Utils.FLOAT_EPSILON));
        }
        X1(c.a(this.g0, h2, l.V));
        Z1(h2.getDimension(l.W, Utils.FLOAT_EPSILON));
        y2(c.a(this.g0, h2, l.j0));
        D2(h2.getText(l.E));
        d f2 = c.f(this.g0, h2, l.z);
        f2.f3462k = h2.getDimension(l.A, f2.f3462k);
        E2(f2);
        int i5 = h2.getInt(l.C, 0);
        if (i5 == 1) {
            q2(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            q2(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            q2(TextUtils.TruncateAt.END);
        }
        S1(h2.getBoolean(l.R, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            S1(h2.getBoolean(l.O, false));
        }
        L1(c.d(this.g0, h2, l.N));
        int i6 = l.Q;
        if (h2.hasValue(i6)) {
            P1(c.a(this.g0, h2, i6));
        }
        N1(h2.getDimension(l.P, -1.0f));
        o2(h2.getBoolean(l.e0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            o2(h2.getBoolean(l.Z, false));
        }
        c2(c.d(this.g0, h2, l.Y));
        m2(c.a(this.g0, h2, l.d0));
        h2(h2.getDimension(l.b0, Utils.FLOAT_EPSILON));
        x1(h2.getBoolean(l.F, false));
        E1(h2.getBoolean(l.J, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            E1(h2.getBoolean(l.H, false));
        }
        z1(c.d(this.g0, h2, l.G));
        int i7 = l.I;
        if (h2.hasValue(i7)) {
            B1(c.a(this.g0, h2, i7));
        }
        B2(c.e.a.b.m.h.b(this.g0, h2, l.l0));
        r2(c.e.a.b.m.h.b(this.g0, h2, l.g0));
        V1(h2.getDimension(l.U, Utils.FLOAT_EPSILON));
        v2(h2.getDimension(l.i0, Utils.FLOAT_EPSILON));
        t2(h2.getDimension(l.h0, Utils.FLOAT_EPSILON));
        I2(h2.getDimension(l.n0, Utils.FLOAT_EPSILON));
        G2(h2.getDimension(l.m0, Utils.FLOAT_EPSILON));
        j2(h2.getDimension(l.c0, Utils.FLOAT_EPSILON));
        e2(h2.getDimension(l.a0, Utils.FLOAT_EPSILON));
        J1(h2.getDimension(l.M, Utils.FLOAT_EPSILON));
        x2(h2.getDimensionPixelSize(l.D, Integer.MAX_VALUE));
        h2.recycle();
    }

    public static a v0(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.u1(attributeSet, i2, i3);
        return aVar;
    }

    private void w0(Canvas canvas, Rect rect) {
        if (M2()) {
            l0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.U.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.U.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean w1(int[] r7, int[] r8) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.w1(int[], int[]):boolean");
    }

    private void x0(Canvas canvas, Rect rect) {
        if (!this.I0) {
            this.h0.setColor(this.p0);
            this.h0.setStyle(Paint.Style.FILL);
            this.h0.setColorFilter(l1());
            this.k0.set(rect);
            canvas.drawRoundRect(this.k0, I0(), I0(), this.h0);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        if (N2()) {
            l0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.I.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.I.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void z0(Canvas canvas, Rect rect) {
        if (this.E > Utils.FLOAT_EPSILON && !this.I0) {
            this.h0.setColor(this.r0);
            this.h0.setStyle(Paint.Style.STROKE);
            if (!this.I0) {
                this.h0.setColorFilter(l1());
            }
            RectF rectF = this.k0;
            float f2 = this.E;
            rectF.set(((float) rect.left) + (f2 / 2.0f), ((float) rect.top) + (f2 / 2.0f), ((float) rect.right) - (f2 / 2.0f), ((float) rect.bottom) - (f2 / 2.0f));
            float f3 = this.C - (this.E / 2.0f);
            canvas.drawRoundRect(this.k0, f3, f3, this.h0);
        }
    }

    public void A1(int i2) {
        z1(b.a.k.a.a.d(this.g0, i2));
    }

    /* access modifiers changed from: package-private */
    public void A2(boolean z2) {
        this.G0 = z2;
    }

    public void B1(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (u0()) {
                androidx.core.graphics.drawable.a.o(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void B2(c.e.a.b.m.h hVar) {
        this.W = hVar;
    }

    public void C1(int i2) {
        B1(b.a.k.a.a.c(this.g0, i2));
    }

    public void C2(int i2) {
        B2(c.e.a.b.m.h.c(this.g0, i2));
    }

    public void D1(int i2) {
        E1(this.g0.getResources().getBoolean(i2));
    }

    public void D2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.n0.i(true);
            invalidateSelf();
            v1();
        }
    }

    public void E1(boolean z2) {
        if (this.T != z2) {
            boolean M2 = M2();
            this.T = z2;
            boolean M22 = M2();
            if (M2 != M22) {
                if (M22) {
                    k0(this.U);
                } else {
                    P2(this.U);
                }
                invalidateSelf();
                v1();
            }
        }
    }

    public void E2(d dVar) {
        this.n0.h(dVar, this.g0);
    }

    public Drawable F0() {
        return this.U;
    }

    public void F1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void F2(int i2) {
        E2(new d(this.g0, i2));
    }

    public ColorStateList G0() {
        return this.V;
    }

    public void G1(int i2) {
        F1(b.a.k.a.a.c(this.g0, i2));
    }

    public void G2(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            v1();
        }
    }

    public ColorStateList H0() {
        return this.A;
    }

    @Deprecated
    public void H1(float f2) {
        if (this.C != f2) {
            this.C = f2;
            setShapeAppearanceModel(C().w(f2));
        }
    }

    public void H2(int i2) {
        G2(this.g0.getResources().getDimension(i2));
    }

    public float I0() {
        return this.I0 ? F() : this.C;
    }

    @Deprecated
    public void I1(int i2) {
        H1(this.g0.getResources().getDimension(i2));
    }

    public void I2(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            invalidateSelf();
            v1();
        }
    }

    public float J0() {
        return this.f0;
    }

    public void J1(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            v1();
        }
    }

    public void J2(int i2) {
        I2(this.g0.getResources().getDimension(i2));
    }

    public Drawable K0() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void K1(int i2) {
        J1(this.g0.getResources().getDimension(i2));
    }

    public void K2(boolean z2) {
        if (this.C0 != z2) {
            this.C0 = z2;
            Q2();
            onStateChange(getState());
        }
    }

    public float L0() {
        return this.K;
    }

    public void L1(Drawable drawable) {
        Drawable K02 = K0();
        if (K02 != drawable) {
            float m02 = m0();
            this.I = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float m03 = m0();
            P2(K02);
            if (N2()) {
                k0(this.I);
            }
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L2() {
        return this.G0;
    }

    public ColorStateList M0() {
        return this.J;
    }

    public void M1(int i2) {
        L1(b.a.k.a.a.d(this.g0, i2));
    }

    public float N0() {
        return this.B;
    }

    public void N1(float f2) {
        if (this.K != f2) {
            float m02 = m0();
            this.K = f2;
            float m03 = m0();
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    public float O0() {
        return this.Y;
    }

    public void O1(int i2) {
        N1(this.g0.getResources().getDimension(i2));
    }

    public ColorStateList P0() {
        return this.D;
    }

    public void P1(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (N2()) {
                androidx.core.graphics.drawable.a.o(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float Q0() {
        return this.E;
    }

    public void Q1(int i2) {
        P1(b.a.k.a.a.c(this.g0, i2));
    }

    public Drawable R0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void R1(int i2) {
        S1(this.g0.getResources().getBoolean(i2));
    }

    public CharSequence S0() {
        return this.R;
    }

    public void S1(boolean z2) {
        if (this.H != z2) {
            boolean N2 = N2();
            this.H = z2;
            boolean N22 = N2();
            if (N2 != N22) {
                if (N22) {
                    k0(this.I);
                } else {
                    P2(this.I);
                }
                invalidateSelf();
                v1();
            }
        }
    }

    public float T0() {
        return this.e0;
    }

    public void T1(float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidateSelf();
            v1();
        }
    }

    public float U0() {
        return this.Q;
    }

    public void U1(int i2) {
        T1(this.g0.getResources().getDimension(i2));
    }

    public float V0() {
        return this.d0;
    }

    public void V1(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            v1();
        }
    }

    public int[] W0() {
        return this.B0;
    }

    public void W1(int i2) {
        V1(this.g0.getResources().getDimension(i2));
    }

    public ColorStateList X0() {
        return this.P;
    }

    public void X1(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                f0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void Y0(RectF rectF) {
        p0(getBounds(), rectF);
    }

    public void Y1(int i2) {
        X1(b.a.k.a.a.c(this.g0, i2));
    }

    public void Z1(float f2) {
        if (this.E != f2) {
            this.E = f2;
            this.h0.setStrokeWidth(f2);
            if (this.I0) {
                super.g0(f2);
            }
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        v1();
        invalidateSelf();
    }

    public void a2(int i2) {
        Z1(this.g0.getResources().getDimension(i2));
    }

    public TextUtils.TruncateAt b1() {
        return this.F0;
    }

    public c.e.a.b.m.h c1() {
        return this.X;
    }

    public void c2(Drawable drawable) {
        Drawable R0 = R0();
        if (R0 != drawable) {
            float q02 = q0();
            this.N = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (c.e.a.b.a0.b.f3242a) {
                R2();
            }
            float q03 = q0();
            P2(R0);
            if (O2()) {
                k0(this.N);
            }
            invalidateSelf();
            if (q02 != q03) {
                v1();
            }
        }
    }

    public float d1() {
        return this.a0;
    }

    public void d2(CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = b.h.i.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Override // c.e.a.b.c0.g
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i2 = 0;
            int i3 = this.w0;
            if (i3 < 255) {
                i2 = c.e.a.b.o.a.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i3);
            }
            A0(canvas, bounds);
            x0(canvas, bounds);
            if (this.I0) {
                super.draw(canvas);
            }
            z0(canvas, bounds);
            C0(canvas, bounds);
            y0(canvas, bounds);
            w0(canvas, bounds);
            if (this.G0) {
                E0(canvas, bounds);
            }
            B0(canvas, bounds);
            D0(canvas, bounds);
            if (this.w0 < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public float e1() {
        return this.Z;
    }

    public void e2(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (O2()) {
                v1();
            }
        }
    }

    public ColorStateList f1() {
        return this.F;
    }

    public void f2(int i2) {
        e2(this.g0.getResources().getDimension(i2));
    }

    public c.e.a.b.m.h g1() {
        return this.W;
    }

    public void g2(int i2) {
        c2(b.a.k.a.a.d(this.g0, i2));
    }

    public int getAlpha() {
        return this.w0;
    }

    public ColorFilter getColorFilter() {
        return this.x0;
    }

    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Y + m0() + this.b0 + this.n0.f(h1().toString()) + this.c0 + q0() + this.f0), this.H0);
    }

    @Override // c.e.a.b.c0.g
    public int getOpacity() {
        return -3;
    }

    @Override // c.e.a.b.c0.g
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public CharSequence h1() {
        return this.G;
    }

    public void h2(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            invalidateSelf();
            if (O2()) {
                v1();
            }
        }
    }

    public d i1() {
        return this.n0.d();
    }

    public void i2(int i2) {
        h2(this.g0.getResources().getDimension(i2));
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // c.e.a.b.c0.g
    public boolean isStateful() {
        return r1(this.z) || r1(this.A) || r1(this.D) || (this.C0 && r1(this.D0)) || t1(this.n0.d()) || u0() || s1(this.I) || s1(this.U) || r1(this.z0);
    }

    public float j1() {
        return this.c0;
    }

    public void j2(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            if (O2()) {
                v1();
            }
        }
    }

    public float k1() {
        return this.b0;
    }

    public void k2(int i2) {
        j2(this.g0.getResources().getDimension(i2));
    }

    public boolean l2(int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (O2()) {
            return w1(getState(), iArr);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float m0() {
        if (N2() || M2()) {
            return this.Z + a1() + this.a0;
        }
        return Utils.FLOAT_EPSILON;
    }

    public boolean m1() {
        return this.C0;
    }

    public void m2(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (O2()) {
                androidx.core.graphics.drawable.a.o(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void n2(int i2) {
        m2(b.a.k.a.a.c(this.g0, i2));
    }

    public boolean o1() {
        return this.S;
    }

    public void o2(boolean z2) {
        if (this.M != z2) {
            boolean O2 = O2();
            this.M = z2;
            boolean O22 = O2();
            if (O2 != O22) {
                if (O22) {
                    k0(this.N);
                } else {
                    P2(this.N);
                }
                invalidateSelf();
                v1();
            }
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (N2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.I, i2);
        }
        if (M2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.U, i2);
        }
        if (O2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.N, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (N2()) {
            onLevelChange |= this.I.setLevel(i2);
        }
        if (M2()) {
            onLevelChange |= this.U.setLevel(i2);
        }
        if (O2()) {
            onLevelChange |= this.N.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // c.e.a.b.c0.g, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return w1(iArr, W0());
    }

    public boolean p1() {
        return s1(this.N);
    }

    public void p2(AbstractC0150a aVar) {
        this.E0 = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: package-private */
    public float q0() {
        return O2() ? this.d0 + this.Q + this.e0 : Utils.FLOAT_EPSILON;
    }

    public boolean q1() {
        return this.M;
    }

    public void q2(TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    public void r2(c.e.a.b.m.h hVar) {
        this.X = hVar;
    }

    public void s2(int i2) {
        r2(c.e.a.b.m.h.c(this.g0, i2));
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // c.e.a.b.c0.g
    public void setAlpha(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            invalidateSelf();
        }
    }

    @Override // c.e.a.b.c0.g
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.x0 != colorFilter) {
            this.x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // c.e.a.b.c0.g, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // c.e.a.b.c0.g, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.y0 = c.e.a.b.u.a.a(this, this.z0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (N2()) {
            visible |= this.I.setVisible(z2, z3);
        }
        if (M2()) {
            visible |= this.U.setVisible(z2, z3);
        }
        if (O2()) {
            visible |= this.N.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* access modifiers changed from: package-private */
    public Paint.Align t0(Rect rect, PointF pointF) {
        pointF.set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float m02 = this.Y + m0() + this.b0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = ((float) rect.left) + m02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - m02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - s0();
        }
        return align;
    }

    public void t2(float f2) {
        if (this.a0 != f2) {
            float m02 = m0();
            this.a0 = f2;
            float m03 = m0();
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    public void u2(int i2) {
        t2(this.g0.getResources().getDimension(i2));
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void v1() {
        AbstractC0150a aVar = this.E0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void v2(float f2) {
        if (this.Z != f2) {
            float m02 = m0();
            this.Z = f2;
            float m03 = m0();
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    public void w2(int i2) {
        v2(this.g0.getResources().getDimension(i2));
    }

    public void x1(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            float m02 = m0();
            if (!z2 && this.u0) {
                this.u0 = false;
            }
            float m03 = m0();
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    public void x2(int i2) {
        this.H0 = i2;
    }

    public void y1(int i2) {
        x1(this.g0.getResources().getBoolean(i2));
    }

    public void y2(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            Q2();
            onStateChange(getState());
        }
    }

    public void z1(Drawable drawable) {
        if (this.U != drawable) {
            float m02 = m0();
            this.U = drawable;
            float m03 = m0();
            P2(this.U);
            k0(this.U);
            invalidateSelf();
            if (m02 != m03) {
                v1();
            }
        }
    }

    public void z2(int i2) {
        y2(b.a.k.a.a.c(this.g0, i2));
    }
}
