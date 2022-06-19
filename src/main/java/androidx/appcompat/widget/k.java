package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.e;
import b.a.j;
import b.a.k.a.a;
import b.h.k.u;

/* compiled from: AppCompatImageHelper */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f670a;

    /* renamed from: b  reason: collision with root package name */
    private o0 f671b;

    /* renamed from: c  reason: collision with root package name */
    private o0 f672c;

    /* renamed from: d  reason: collision with root package name */
    private o0 f673d;

    public k(ImageView imageView) {
        this.f670a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f673d == null) {
            this.f673d = new o0();
        }
        o0 o0Var = this.f673d;
        o0Var.a();
        ColorStateList a2 = e.a(this.f670a);
        if (a2 != null) {
            o0Var.f702d = true;
            o0Var.f699a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f670a);
        if (b2 != null) {
            o0Var.f701c = true;
            o0Var.f700b = b2;
        }
        if (!o0Var.f702d && !o0Var.f701c) {
            return false;
        }
        h.i(drawable, o0Var, this.f670a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 21) {
            return i2 == 21;
        }
        if (this.f671b != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f670a.getDrawable();
        if (drawable != null) {
            x.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!j() || !a(drawable)) {
            o0 o0Var = this.f672c;
            if (o0Var != null) {
                h.i(drawable, o0Var, this.f670a.getDrawableState());
                return;
            }
            o0 o0Var2 = this.f671b;
            if (o0Var2 != null) {
                h.i(drawable, o0Var2, this.f670a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        o0 o0Var = this.f672c;
        if (o0Var != null) {
            return o0Var.f699a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        o0 o0Var = this.f672c;
        if (o0Var != null) {
            return o0Var.f700b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f670a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i2) {
        int n;
        Context context = this.f670a.getContext();
        int[] iArr = j.M;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f670a;
        u.k0(imageView, imageView.getContext(), iArr, attributeSet, v.r(), i2, 0);
        try {
            Drawable drawable = this.f670a.getDrawable();
            if (!(drawable != null || (n = v.n(j.N, -1)) == -1 || (drawable = a.d(this.f670a.getContext(), n)) == null)) {
                this.f670a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                x.b(drawable);
            }
            int i3 = j.O;
            if (v.s(i3)) {
                e.c(this.f670a, v.c(i3));
            }
            int i4 = j.P;
            if (v.s(i4)) {
                e.d(this.f670a, x.e(v.k(i4, -1), null));
            }
        } finally {
            v.w();
        }
    }

    public void g(int i2) {
        if (i2 != 0) {
            Drawable d2 = a.d(this.f670a.getContext(), i2);
            if (d2 != null) {
                x.b(d2);
            }
            this.f670a.setImageDrawable(d2);
        } else {
            this.f670a.setImageDrawable(null);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f672c == null) {
            this.f672c = new o0();
        }
        o0 o0Var = this.f672c;
        o0Var.f699a = colorStateList;
        o0Var.f702d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f672c == null) {
            this.f672c = new o0();
        }
        o0 o0Var = this.f672c;
        o0Var.f700b = mode;
        o0Var.f701c = true;
        b();
    }
}
