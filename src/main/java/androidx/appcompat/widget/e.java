package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import b.a.j;
import b.h.k.u;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatBackgroundHelper */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f600a;

    /* renamed from: b  reason: collision with root package name */
    private final h f601b;

    /* renamed from: c  reason: collision with root package name */
    private int f602c = -1;

    /* renamed from: d  reason: collision with root package name */
    private o0 f603d;

    /* renamed from: e  reason: collision with root package name */
    private o0 f604e;

    /* renamed from: f  reason: collision with root package name */
    private o0 f605f;

    e(View view) {
        this.f600a = view;
        this.f601b = h.b();
    }

    private boolean a(Drawable drawable) {
        if (this.f605f == null) {
            this.f605f = new o0();
        }
        o0 o0Var = this.f605f;
        o0Var.a();
        ColorStateList s = u.s(this.f600a);
        if (s != null) {
            o0Var.f702d = true;
            o0Var.f699a = s;
        }
        PorterDuff.Mode t = u.t(this.f600a);
        if (t != null) {
            o0Var.f701c = true;
            o0Var.f700b = t;
        }
        if (!o0Var.f702d && !o0Var.f701c) {
            return false;
        }
        h.i(drawable, o0Var, this.f600a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 21) {
            return i2 == 21;
        }
        if (this.f603d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f600a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            o0 o0Var = this.f604e;
            if (o0Var != null) {
                h.i(background, o0Var, this.f600a.getDrawableState());
                return;
            }
            o0 o0Var2 = this.f603d;
            if (o0Var2 != null) {
                h.i(background, o0Var2, this.f600a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        o0 o0Var = this.f604e;
        if (o0Var != null) {
            return o0Var.f699a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        o0 o0Var = this.f604e;
        if (o0Var != null) {
            return o0Var.f700b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i2) {
        Context context = this.f600a.getContext();
        int[] iArr = j.D3;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        View view = this.f600a;
        u.k0(view, view.getContext(), iArr, attributeSet, v.r(), i2, 0);
        try {
            int i3 = j.E3;
            if (v.s(i3)) {
                this.f602c = v.n(i3, -1);
                ColorStateList f2 = this.f601b.f(this.f600a.getContext(), this.f602c);
                if (f2 != null) {
                    h(f2);
                }
            }
            int i4 = j.F3;
            if (v.s(i4)) {
                u.r0(this.f600a, v.c(i4));
            }
            int i5 = j.G3;
            if (v.s(i5)) {
                u.s0(this.f600a, x.e(v.k(i5, -1), null));
            }
        } finally {
            v.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f602c = -1;
        h(null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        this.f602c = i2;
        h hVar = this.f601b;
        h(hVar != null ? hVar.f(this.f600a.getContext(), i2) : null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f603d == null) {
                this.f603d = new o0();
            }
            o0 o0Var = this.f603d;
            o0Var.f699a = colorStateList;
            o0Var.f702d = true;
        } else {
            this.f603d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f604e == null) {
            this.f604e = new o0();
        }
        o0 o0Var = this.f604e;
        o0Var.f699a = colorStateList;
        o0Var.f702d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f604e == null) {
            this.f604e = new o0();
        }
        o0 o0Var = this.f604e;
        o0Var.f700b = mode;
        o0Var.f701c = true;
        b();
    }
}
