package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import b.h.k.u;
import c.e.a.b.b;
import c.e.a.b.c0.g;
import c.e.a.b.c0.k;
import c.e.a.b.c0.n;
import c.e.a.b.l;
import c.e.a.b.z.c;

/* access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper */
public class a {
    private static final boolean t = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f7632a;

    /* renamed from: b  reason: collision with root package name */
    private k f7633b;

    /* renamed from: c  reason: collision with root package name */
    private int f7634c;

    /* renamed from: d  reason: collision with root package name */
    private int f7635d;

    /* renamed from: e  reason: collision with root package name */
    private int f7636e;

    /* renamed from: f  reason: collision with root package name */
    private int f7637f;

    /* renamed from: g  reason: collision with root package name */
    private int f7638g;

    /* renamed from: h  reason: collision with root package name */
    private int f7639h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f7640i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f7641j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f7642k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;
    private int s;

    a(MaterialButton materialButton, k kVar) {
        this.f7632a = materialButton;
        this.f7633b = kVar;
    }

    private void E(int i2, int i3) {
        int G = u.G(this.f7632a);
        int paddingTop = this.f7632a.getPaddingTop();
        int F = u.F(this.f7632a);
        int paddingBottom = this.f7632a.getPaddingBottom();
        int i4 = this.f7636e;
        int i5 = this.f7637f;
        this.f7637f = i3;
        this.f7636e = i2;
        if (!this.o) {
            F();
        }
        u.A0(this.f7632a, G, (paddingTop + i2) - i4, F, (paddingBottom + i3) - i5);
    }

    private void F() {
        this.f7632a.setInternalBackground(a());
        g f2 = f();
        if (f2 != null) {
            f2.W((float) this.s);
        }
    }

    private void G(k kVar) {
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void I() {
        g f2 = f();
        g n2 = n();
        if (f2 != null) {
            f2.e0((float) this.f7639h, this.f7642k);
            if (n2 != null) {
                n2.d0((float) this.f7639h, this.n ? c.e.a.b.s.a.c(this.f7632a, b.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f7634c, this.f7636e, this.f7635d, this.f7637f);
    }

    private Drawable a() {
        g gVar = new g(this.f7633b);
        gVar.M(this.f7632a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.f7641j);
        PorterDuff.Mode mode = this.f7640i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.e0((float) this.f7639h, this.f7642k);
        g gVar2 = new g(this.f7633b);
        gVar2.setTint(0);
        gVar2.d0((float) this.f7639h, this.n ? c.e.a.b.s.a.c(this.f7632a, b.colorSurface) : 0);
        if (t) {
            g gVar3 = new g(this.f7633b);
            this.m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(c.e.a.b.a0.b.d(this.l), J(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        c.e.a.b.a0.a aVar = new c.e.a.b.a0.a(this.f7633b);
        this.m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, c.e.a.b.a0.b.d(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
        this.r = layerDrawable;
        return J(layerDrawable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private g g(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (t) {
            return (g) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z);
        }
        return (g) this.r.getDrawable(!z ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    /* access modifiers changed from: package-private */
    public void A(ColorStateList colorStateList) {
        if (this.f7642k != colorStateList) {
            this.f7642k = colorStateList;
            I();
        }
    }

    /* access modifiers changed from: package-private */
    public void B(int i2) {
        if (this.f7639h != i2) {
            this.f7639h = i2;
            I();
        }
    }

    /* access modifiers changed from: package-private */
    public void C(ColorStateList colorStateList) {
        if (this.f7641j != colorStateList) {
            this.f7641j = colorStateList;
            if (f() != null) {
                androidx.core.graphics.drawable.a.o(f(), this.f7641j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D(PorterDuff.Mode mode) {
        if (this.f7640i != mode) {
            this.f7640i = mode;
            if (f() != null && this.f7640i != null) {
                androidx.core.graphics.drawable.a.p(f(), this.f7640i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i2, int i3) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.f7634c, this.f7636e, i3 - this.f7635d, i2 - this.f7637f);
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f7638g;
    }

    public int c() {
        return this.f7637f;
    }

    public int d() {
        return this.f7636e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (n) this.r.getDrawable(2);
        }
        return (n) this.r.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public g f() {
        return g(false);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public k i() {
        return this.f7633b;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f7642k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f7639h;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f7641j;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f7640i;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void q(TypedArray typedArray) {
        this.f7634c = typedArray.getDimensionPixelOffset(l.h1, 0);
        this.f7635d = typedArray.getDimensionPixelOffset(l.i1, 0);
        this.f7636e = typedArray.getDimensionPixelOffset(l.j1, 0);
        this.f7637f = typedArray.getDimensionPixelOffset(l.k1, 0);
        int i2 = l.o1;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f7638g = dimensionPixelSize;
            y(this.f7633b.w((float) dimensionPixelSize));
            this.p = true;
        }
        this.f7639h = typedArray.getDimensionPixelSize(l.y1, 0);
        this.f7640i = com.google.android.material.internal.k.e(typedArray.getInt(l.n1, -1), PorterDuff.Mode.SRC_IN);
        this.f7641j = c.a(this.f7632a.getContext(), typedArray, l.m1);
        this.f7642k = c.a(this.f7632a.getContext(), typedArray, l.x1);
        this.l = c.a(this.f7632a.getContext(), typedArray, l.w1);
        this.q = typedArray.getBoolean(l.l1, false);
        this.s = typedArray.getDimensionPixelSize(l.p1, 0);
        int G = u.G(this.f7632a);
        int paddingTop = this.f7632a.getPaddingTop();
        int F = u.F(this.f7632a);
        int paddingBottom = this.f7632a.getPaddingBottom();
        if (typedArray.hasValue(l.g1)) {
            s();
        } else {
            F();
        }
        u.A0(this.f7632a, G + this.f7634c, paddingTop + this.f7636e, F + this.f7635d, paddingBottom + this.f7637f);
    }

    /* access modifiers changed from: package-private */
    public void r(int i2) {
        if (f() != null) {
            f().setTint(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.o = true;
        this.f7632a.setSupportBackgroundTintList(this.f7641j);
        this.f7632a.setSupportBackgroundTintMode(this.f7640i);
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z) {
        this.q = z;
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        if (!this.p || this.f7638g != i2) {
            this.f7638g = i2;
            this.p = true;
            y(this.f7633b.w((float) i2));
        }
    }

    public void v(int i2) {
        E(this.f7636e, i2);
    }

    public void w(int i2) {
        E(i2, this.f7637f);
    }

    /* access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            boolean z = t;
            if (z && (this.f7632a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f7632a.getBackground()).setColor(c.e.a.b.a0.b.d(colorStateList));
            } else if (!z && (this.f7632a.getBackground() instanceof c.e.a.b.a0.a)) {
                ((c.e.a.b.a0.a) this.f7632a.getBackground()).setTintList(c.e.a.b.a0.b.d(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(k kVar) {
        this.f7633b = kVar;
        G(kVar);
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z) {
        this.n = z;
        I();
    }
}
