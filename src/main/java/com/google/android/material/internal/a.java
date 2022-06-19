package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import b.h.j.h;
import b.h.k.e;
import b.h.k.u;
import c.e.a.b.z.a;
import c.e.a.b.z.d;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.internal.g;

/* compiled from: CollapsingTextHelper */
public final class a {
    private static final boolean b0 = (Build.VERSION.SDK_INT < 18);
    private static final Paint c0 = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private int[] F;
    private boolean G;
    private final TextPaint H;
    private final TextPaint I;
    private TimeInterpolator J;
    private TimeInterpolator K;
    private float L;
    private float M;
    private float N;
    private ColorStateList O;
    private float P;
    private float Q;
    private float R;
    private ColorStateList S;
    private float T;
    private float U;
    private StaticLayout V;
    private float W;
    private float X;
    private float Y;
    private CharSequence Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f7816a;
    private int a0 = 1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7817b;

    /* renamed from: c  reason: collision with root package name */
    private float f7818c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f7819d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f7820e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f7821f;

    /* renamed from: g  reason: collision with root package name */
    private int f7822g = 16;

    /* renamed from: h  reason: collision with root package name */
    private int f7823h = 16;

    /* renamed from: i  reason: collision with root package name */
    private float f7824i = 15.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f7825j = 15.0f;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f7826k;
    private ColorStateList l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Typeface s;
    private Typeface t;
    private Typeface u;
    private c.e.a.b.z.a v;
    private c.e.a.b.z.a w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    /* compiled from: CollapsingTextHelper */
    class C0155a implements a.AbstractC0083a {
        C0155a() {
        }

        @Override // c.e.a.b.z.a.AbstractC0083a
        public void a(Typeface typeface) {
            a.this.M(typeface);
        }
    }

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public a(View view) {
        this.f7816a = view;
        TextPaint textPaint = new TextPaint(129);
        this.H = textPaint;
        this.I = new TextPaint(textPaint);
        this.f7820e = new Rect();
        this.f7819d = new Rect();
        this.f7821f = new RectF();
    }

    private boolean A() {
        return u.B(this.f7816a) == 1;
    }

    private static float C(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.e.a.b.m.a.a(f2, f3, f4);
    }

    private static boolean F(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void J(float f2) {
        this.W = f2;
        u.d0(this.f7816a);
    }

    private boolean N(Typeface typeface) {
        c.e.a.b.z.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        if (this.s == typeface) {
            return false;
        }
        this.s = typeface;
        return true;
    }

    private void Q(float f2) {
        this.X = f2;
        u.d0(this.f7816a);
    }

    private boolean U(Typeface typeface) {
        c.e.a.b.z.a aVar = this.v;
        if (aVar != null) {
            aVar.c();
        }
        if (this.t == typeface) {
            return false;
        }
        this.t = typeface;
        return true;
    }

    private void W(float f2) {
        g(f2);
        boolean z2 = b0 && this.D != 1.0f;
        this.A = z2;
        if (z2) {
            l();
        }
        u.d0(this.f7816a);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private void b() {
        StaticLayout staticLayout;
        float f2 = this.E;
        g(this.f7825j);
        CharSequence charSequence = this.y;
        if (!(charSequence == null || (staticLayout = this.V) == null)) {
            this.Z = TextUtils.ellipsize(charSequence, this.H, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.Z;
        float f3 = Utils.FLOAT_EPSILON;
        float measureText = charSequence2 != null ? this.H.measureText(charSequence2, 0, charSequence2.length()) : Utils.FLOAT_EPSILON;
        int b2 = e.b(this.f7823h, this.z ? 1 : 0);
        int i2 = b2 & 112;
        if (i2 == 48) {
            this.n = (float) this.f7820e.top;
        } else if (i2 != 80) {
            this.n = ((float) this.f7820e.centerY()) - ((this.H.descent() - this.H.ascent()) / 2.0f);
        } else {
            this.n = ((float) this.f7820e.bottom) + this.H.ascent();
        }
        int i3 = b2 & 8388615;
        if (i3 == 1) {
            this.p = ((float) this.f7820e.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.p = (float) this.f7820e.left;
        } else {
            this.p = ((float) this.f7820e.right) - measureText;
        }
        g(this.f7824i);
        StaticLayout staticLayout2 = this.V;
        float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : Utils.FLOAT_EPSILON;
        CharSequence charSequence3 = this.y;
        float measureText2 = charSequence3 != null ? this.H.measureText(charSequence3, 0, charSequence3.length()) : Utils.FLOAT_EPSILON;
        StaticLayout staticLayout3 = this.V;
        if (staticLayout3 != null && this.a0 > 1 && !this.z) {
            measureText2 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.V;
        if (staticLayout4 != null) {
            f3 = staticLayout4.getLineLeft(0);
        }
        this.Y = f3;
        int b3 = e.b(this.f7822g, this.z ? 1 : 0);
        int i4 = b3 & 112;
        if (i4 == 48) {
            this.m = (float) this.f7819d.top;
        } else if (i4 != 80) {
            this.m = ((float) this.f7819d.centerY()) - (height / 2.0f);
        } else {
            this.m = (((float) this.f7819d.bottom) - height) + this.H.descent();
        }
        int i5 = b3 & 8388615;
        if (i5 == 1) {
            this.o = ((float) this.f7819d.centerX()) - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.o = (float) this.f7819d.left;
        } else {
            this.o = ((float) this.f7819d.right) - measureText2;
        }
        h();
        W(f2);
    }

    private boolean c0() {
        return this.a0 > 1 && !this.z && !this.A;
    }

    private void d() {
        f(this.f7818c);
    }

    private boolean e(CharSequence charSequence) {
        return (A() ? b.h.i.e.f2576d : b.h.i.e.f2575c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f2) {
        y(f2);
        this.q = C(this.o, this.p, f2, this.J);
        this.r = C(this.m, this.n, f2, this.J);
        W(C(this.f7824i, this.f7825j, f2, this.K));
        TimeInterpolator timeInterpolator = c.e.a.b.m.a.f3376b;
        J(1.0f - C(Utils.FLOAT_EPSILON, 1.0f, 1.0f - f2, timeInterpolator));
        Q(C(1.0f, Utils.FLOAT_EPSILON, f2, timeInterpolator));
        if (this.l != this.f7826k) {
            this.H.setColor(a(t(), r(), f2));
        } else {
            this.H.setColor(r());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f3 = this.T;
            float f4 = this.U;
            if (f3 != f4) {
                this.H.setLetterSpacing(C(f4, f3, f2, timeInterpolator));
            } else {
                this.H.setLetterSpacing(f3);
            }
        }
        this.H.setShadowLayer(C(this.P, this.L, f2, null), C(this.Q, this.M, f2, null), C(this.R, this.N, f2, null), a(s(this.S), s(this.O), f2));
        u.d0(this.f7816a);
    }

    private void g(float f2) {
        float f3;
        boolean z2;
        boolean z3;
        if (this.x != null) {
            float width = (float) this.f7820e.width();
            float width2 = (float) this.f7819d.width();
            boolean z4 = false;
            int i2 = 1;
            if (z(f2, this.f7825j)) {
                f3 = this.f7825j;
                this.D = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.f7824i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z(f2, f4)) {
                    this.D = 1.0f;
                } else {
                    this.D = f2 / this.f7824i;
                }
                float f5 = this.f7825j / this.f7824i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
                z2 = z3;
            }
            if (width > Utils.FLOAT_EPSILON) {
                z2 = this.E != f3 || this.G || z2;
                this.E = f3;
                this.G = false;
            }
            if (this.y == null || z2) {
                this.H.setTextSize(this.E);
                this.H.setTypeface(this.u);
                TextPaint textPaint = this.H;
                if (this.D != 1.0f) {
                    z4 = true;
                }
                textPaint.setLinearText(z4);
                this.z = e(this.x);
                if (c0()) {
                    i2 = this.a0;
                }
                StaticLayout i3 = i(i2, width, this.z);
                this.V = i3;
                this.y = i3.getText();
            }
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private StaticLayout i(int i2, float f2, boolean z2) {
        StaticLayout staticLayout;
        try {
            g c2 = g.c(this.x, this.H, (int) f2);
            c2.e(TextUtils.TruncateAt.END);
            c2.g(z2);
            c2.d(Layout.Alignment.ALIGN_NORMAL);
            c2.f(false);
            c2.h(i2);
            staticLayout = c2.a();
        } catch (g.a e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        h.c(staticLayout);
        return staticLayout;
    }

    private void k(Canvas canvas, float f2, float f3) {
        int alpha = this.H.getAlpha();
        canvas.translate(f2, f3);
        float f4 = (float) alpha;
        this.H.setAlpha((int) (this.X * f4));
        this.V.draw(canvas);
        this.H.setAlpha((int) (this.W * f4));
        int lineBaseline = this.V.getLineBaseline(0);
        CharSequence charSequence = this.Z;
        float f5 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), Utils.FLOAT_EPSILON, f5, this.H);
        String trim = this.Z.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        this.H.setAlpha(alpha);
        canvas.drawText(trim, 0, Math.min(this.V.getLineEnd(0), trim.length()), Utils.FLOAT_EPSILON, f5, (Paint) this.H);
    }

    private void l() {
        if (this.B == null && !this.f7819d.isEmpty() && !TextUtils.isEmpty(this.y)) {
            f(Utils.FLOAT_EPSILON);
            int width = this.V.getWidth();
            int height = this.V.getHeight();
            if (width > 0 && height > 0) {
                this.B = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.V.draw(new Canvas(this.B));
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    private float p(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (((float) i2) / 2.0f) - (c() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.z ? (float) this.f7820e.left : ((float) this.f7820e.right) - c() : this.z ? ((float) this.f7820e.right) - c() : (float) this.f7820e.left;
    }

    private float q(RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (((float) i2) / 2.0f) + (c() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.z ? rectF.left + c() : (float) this.f7820e.right : this.z ? (float) this.f7820e.right : rectF.left + c();
    }

    private int s(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.F;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private int t() {
        return s(this.f7826k);
    }

    private void w(TextPaint textPaint) {
        textPaint.setTextSize(this.f7825j);
        textPaint.setTypeface(this.s);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.T);
        }
    }

    private void x(TextPaint textPaint) {
        textPaint.setTextSize(this.f7824i);
        textPaint.setTypeface(this.t);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.U);
        }
    }

    private void y(float f2) {
        this.f7821f.left = C((float) this.f7819d.left, (float) this.f7820e.left, f2, this.J);
        this.f7821f.top = C(this.m, this.n, f2, this.J);
        this.f7821f.right = C((float) this.f7819d.right, (float) this.f7820e.right, f2, this.J);
        this.f7821f.bottom = C((float) this.f7819d.bottom, (float) this.f7820e.bottom, f2, this.J);
    }

    private static boolean z(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    public final boolean B() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f7826k) != null && colorStateList.isStateful());
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.f7817b = this.f7820e.width() > 0 && this.f7820e.height() > 0 && this.f7819d.width() > 0 && this.f7819d.height() > 0;
    }

    public void E() {
        if (this.f7816a.getHeight() > 0 && this.f7816a.getWidth() > 0) {
            b();
            d();
        }
    }

    public void G(int i2, int i3, int i4, int i5) {
        if (!F(this.f7820e, i2, i3, i4, i5)) {
            this.f7820e.set(i2, i3, i4, i5);
            this.G = true;
            D();
        }
    }

    public void H(Rect rect) {
        G(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void I(int i2) {
        d dVar = new d(this.f7816a.getContext(), i2);
        ColorStateList colorStateList = dVar.f3452a;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = dVar.f3462k;
        if (f2 != Utils.FLOAT_EPSILON) {
            this.f7825j = f2;
        }
        ColorStateList colorStateList2 = dVar.f3453b;
        if (colorStateList2 != null) {
            this.O = colorStateList2;
        }
        this.M = dVar.f3457f;
        this.N = dVar.f3458g;
        this.L = dVar.f3459h;
        this.T = dVar.f3461j;
        c.e.a.b.z.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        this.w = new c.e.a.b.z.a(new C0155a(), dVar.e());
        dVar.h(this.f7816a.getContext(), this.w);
        E();
    }

    public void K(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            E();
        }
    }

    public void L(int i2) {
        if (this.f7823h != i2) {
            this.f7823h = i2;
            E();
        }
    }

    public void M(Typeface typeface) {
        if (N(typeface)) {
            E();
        }
    }

    public void O(int i2, int i3, int i4, int i5) {
        if (!F(this.f7819d, i2, i3, i4, i5)) {
            this.f7819d.set(i2, i3, i4, i5);
            this.G = true;
            D();
        }
    }

    public void P(Rect rect) {
        O(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void R(ColorStateList colorStateList) {
        if (this.f7826k != colorStateList) {
            this.f7826k = colorStateList;
            E();
        }
    }

    public void S(int i2) {
        if (this.f7822g != i2) {
            this.f7822g = i2;
            E();
        }
    }

    public void T(float f2) {
        if (this.f7824i != f2) {
            this.f7824i = f2;
            E();
        }
    }

    public void V(float f2) {
        float a2 = b.h.g.a.a(f2, Utils.FLOAT_EPSILON, 1.0f);
        if (a2 != this.f7818c) {
            this.f7818c = a2;
            d();
        }
    }

    public void X(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        E();
    }

    public final boolean Y(int[] iArr) {
        this.F = iArr;
        if (!B()) {
            return false;
        }
        E();
        return true;
    }

    public void Z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            h();
            E();
        }
    }

    public void a0(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        E();
    }

    public void b0(Typeface typeface) {
        boolean N2 = N(typeface);
        boolean U2 = U(typeface);
        if (N2 || U2) {
            E();
        }
    }

    public float c() {
        if (this.x == null) {
            return Utils.FLOAT_EPSILON;
        }
        w(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void j(Canvas canvas) {
        int save = canvas.save();
        if (this.y != null && this.f7817b) {
            boolean z2 = false;
            float lineLeft = (this.q + this.V.getLineLeft(0)) - (this.Y * 2.0f);
            this.H.setTextSize(this.E);
            float f2 = this.q;
            float f3 = this.r;
            if (this.A && this.B != null) {
                z2 = true;
            }
            float f4 = this.D;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z2) {
                canvas.drawBitmap(this.B, f2, f3, this.C);
                canvas.restoreToCount(save);
                return;
            }
            if (c0()) {
                k(canvas, lineLeft, f3);
            } else {
                canvas.translate(f2, f3);
                this.V.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void m(RectF rectF, int i2, int i3) {
        this.z = e(this.x);
        rectF.left = p(i2, i3);
        rectF.top = (float) this.f7820e.top;
        rectF.right = q(rectF, i2, i3);
        rectF.bottom = ((float) this.f7820e.top) + o();
    }

    public ColorStateList n() {
        return this.l;
    }

    public float o() {
        w(this.I);
        return -this.I.ascent();
    }

    public int r() {
        return s(this.l);
    }

    public float u() {
        x(this.I);
        return -this.I.ascent();
    }

    public float v() {
        return this.f7818c;
    }
}
