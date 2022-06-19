package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.widget.b;
import b.a.j;
import b.h.d.e.f;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatTextHelper */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f753a;

    /* renamed from: b  reason: collision with root package name */
    private o0 f754b;

    /* renamed from: c  reason: collision with root package name */
    private o0 f755c;

    /* renamed from: d  reason: collision with root package name */
    private o0 f756d;

    /* renamed from: e  reason: collision with root package name */
    private o0 f757e;

    /* renamed from: f  reason: collision with root package name */
    private o0 f758f;

    /* renamed from: g  reason: collision with root package name */
    private o0 f759g;

    /* renamed from: h  reason: collision with root package name */
    private o0 f760h;

    /* renamed from: i  reason: collision with root package name */
    private final t f761i;

    /* renamed from: j  reason: collision with root package name */
    private int f762j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f763k = -1;
    private Typeface l;
    private boolean m;

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatTextHelper */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f764a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f765b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f766c;

        a(int i2, int i3, WeakReference weakReference) {
            this.f764a = i2;
            this.f765b = i3;
            this.f766c = weakReference;
        }

        @Override // b.h.d.e.f.a
        public void c(int i2) {
        }

        @Override // b.h.d.e.f.a
        public void d(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f764a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f765b & 2) != 0);
            }
            s.this.n(this.f766c, typeface);
        }
    }

    s(TextView textView) {
        this.f753a = textView;
        this.f761i = new t(textView);
    }

    private void A(int i2, float f2) {
        this.f761i.y(i2, f2);
    }

    private void B(Context context, q0 q0Var) {
        String o;
        this.f762j = q0Var.k(j.M2, this.f762j);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 28) {
            int k2 = q0Var.k(j.R2, -1);
            this.f763k = k2;
            if (k2 != -1) {
                this.f762j = (this.f762j & 2) | 0;
            }
        }
        int i3 = j.Q2;
        if (q0Var.s(i3) || q0Var.s(j.S2)) {
            this.l = null;
            int i4 = j.S2;
            if (q0Var.s(i4)) {
                i3 = i4;
            }
            int i5 = this.f763k;
            int i6 = this.f762j;
            if (!context.isRestricted()) {
                try {
                    Typeface j2 = q0Var.j(i3, this.f762j, new a(i5, i6, new WeakReference(this.f753a)));
                    if (j2 != null) {
                        if (i2 < 28 || this.f763k == -1) {
                            this.l = j2;
                        } else {
                            this.l = Typeface.create(Typeface.create(j2, 0), this.f763k, (this.f762j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (o = q0Var.o(i3)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f763k == -1) {
                    this.l = Typeface.create(o, this.f762j);
                    return;
                }
                Typeface create = Typeface.create(o, 0);
                int i7 = this.f763k;
                if ((this.f762j & 2) != 0) {
                    z = true;
                }
                this.l = Typeface.create(create, i7, z);
                return;
            }
            return;
        }
        int i8 = j.L2;
        if (q0Var.s(i8)) {
            this.m = false;
            int k3 = q0Var.k(i8, 1);
            if (k3 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (k3 == 2) {
                this.l = Typeface.SERIF;
            } else if (k3 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    private void a(Drawable drawable, o0 o0Var) {
        if (drawable != null && o0Var != null) {
            h.i(drawable, o0Var, this.f753a.getDrawableState());
        }
    }

    private static o0 d(Context context, h hVar, int i2) {
        ColorStateList f2 = hVar.f(context, i2);
        if (f2 == null) {
            return null;
        }
        o0 o0Var = new o0();
        o0Var.f702d = true;
        o0Var.f699a = f2;
        return o0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f753a.getCompoundDrawablesRelative();
            TextView textView = this.f753a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (i2 >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f753a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f753a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f753a.getCompoundDrawables();
            TextView textView3 = this.f753a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void y() {
        o0 o0Var = this.f760h;
        this.f754b = o0Var;
        this.f755c = o0Var;
        this.f756d = o0Var;
        this.f757e = o0Var;
        this.f758f = o0Var;
        this.f759g = o0Var;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f754b == null && this.f755c == null && this.f756d == null && this.f757e == null)) {
            Drawable[] compoundDrawables = this.f753a.getCompoundDrawables();
            a(compoundDrawables[0], this.f754b);
            a(compoundDrawables[1], this.f755c);
            a(compoundDrawables[2], this.f756d);
            a(compoundDrawables[3], this.f757e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f758f != null || this.f759g != null) {
            Drawable[] compoundDrawablesRelative = this.f753a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f758f);
            a(compoundDrawablesRelative[2], this.f759g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f761i.b();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f761i.j();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f761i.k();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f761i.l();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f761i.m();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f761i.n();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        o0 o0Var = this.f760h;
        if (o0Var != null) {
            return o0Var.f699a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        o0 o0Var = this.f760h;
        if (o0Var != null) {
            return o0Var.f700b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f761i.s();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ce  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
        // Method dump skipped, instructions count: 794
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.s.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f762j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.f1167a) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i2) {
        String o;
        ColorStateList c2;
        q0 t = q0.t(context, i2, j.J2);
        int i3 = j.U2;
        if (t.s(i3)) {
            r(t.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = j.N2;
            if (t.s(i5) && (c2 = t.c(i5)) != null) {
                this.f753a.setTextColor(c2);
            }
        }
        int i6 = j.K2;
        if (t.s(i6) && t.f(i6, -1) == 0) {
            this.f753a.setTextSize(0, Utils.FLOAT_EPSILON);
        }
        B(context, t);
        if (i4 >= 26) {
            int i7 = j.T2;
            if (t.s(i7) && (o = t.o(i7)) != null) {
                this.f753a.setFontVariationSettings(o);
            }
        }
        t.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f753a.setTypeface(typeface, this.f762j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z) {
        this.f753a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void s(int i2, int i3, int i4, int i5) {
        this.f761i.u(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void t(int[] iArr, int i2) {
        this.f761i.v(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        this.f761i.w(i2);
    }

    /* access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f760h == null) {
            this.f760h = new o0();
        }
        o0 o0Var = this.f760h;
        o0Var.f699a = colorStateList;
        o0Var.f702d = colorStateList != null;
        y();
    }

    /* access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f760h == null) {
            this.f760h = new o0();
        }
        o0 o0Var = this.f760h;
        o0Var.f700b = mode;
        o0Var.f701c = mode != null;
        y();
    }

    /* access modifiers changed from: package-private */
    public void z(int i2, float f2) {
        if (!b.f1167a && !l()) {
            A(i2, f2);
        }
    }
}
