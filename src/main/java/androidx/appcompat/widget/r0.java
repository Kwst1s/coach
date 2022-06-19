package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import b.a.e;
import b.a.f;
import b.a.h;
import b.a.j;
import b.h.k.a0;
import b.h.k.u;
import b.h.k.y;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ToolbarWidgetWrapper */
public class r0 implements w {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f737a;

    /* renamed from: b  reason: collision with root package name */
    private int f738b;

    /* renamed from: c  reason: collision with root package name */
    private View f739c;

    /* renamed from: d  reason: collision with root package name */
    private View f740d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f741e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f742f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f743g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f744h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f745i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f746j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f747k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    /* compiled from: ToolbarWidgetWrapper */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final androidx.appcompat.view.menu.a f748b;

        a() {
            this.f748b = new androidx.appcompat.view.menu.a(r0.this.f737a.getContext(), 0, 16908332, 0, 0, r0.this.f745i);
        }

        public void onClick(View view) {
            r0 r0Var = r0.this;
            Window.Callback callback = r0Var.l;
            if (callback != null && r0Var.m) {
                callback.onMenuItemSelected(0, this.f748b);
            }
        }
    }

    /* compiled from: ToolbarWidgetWrapper */
    class b extends a0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f750a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f751b;

        b(int i2) {
            this.f751b = i2;
        }

        @Override // b.h.k.z, b.h.k.a0
        public void a(View view) {
            this.f750a = true;
        }

        @Override // b.h.k.z
        public void b(View view) {
            if (!this.f750a) {
                r0.this.f737a.setVisibility(this.f751b);
            }
        }

        @Override // b.h.k.z, b.h.k.a0
        public void c(View view) {
            r0.this.f737a.setVisibility(0);
        }
    }

    public r0(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    private int B() {
        if (this.f737a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f737a.getNavigationIcon();
        return 15;
    }

    private void H(CharSequence charSequence) {
        this.f745i = charSequence;
        if ((this.f738b & 8) != 0) {
            this.f737a.setTitle(charSequence);
        }
    }

    private void I() {
        if ((this.f738b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f747k)) {
            this.f737a.setNavigationContentDescription(this.p);
        } else {
            this.f737a.setNavigationContentDescription(this.f747k);
        }
    }

    private void J() {
        if ((this.f738b & 4) != 0) {
            Toolbar toolbar = this.f737a;
            Drawable drawable = this.f743g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f737a.setNavigationIcon((Drawable) null);
    }

    private void K() {
        Drawable drawable;
        int i2 = this.f738b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f742f;
            if (drawable == null) {
                drawable = this.f741e;
            }
        } else {
            drawable = this.f741e;
        }
        this.f737a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.w
    public void A(int i2) {
        y(i2 != 0 ? b.a.k.a.a.d(n(), i2) : null);
    }

    public void C(View view) {
        View view2 = this.f740d;
        if (!(view2 == null || (this.f738b & 16) == 0)) {
            this.f737a.removeView(view2);
        }
        this.f740d = view;
        if (view != null && (this.f738b & 16) != 0) {
            this.f737a.addView(view);
        }
    }

    public void D(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f737a.getNavigationContentDescription())) {
                t(this.p);
            }
        }
    }

    public void E(Drawable drawable) {
        this.f742f = drawable;
        K();
    }

    public void F(CharSequence charSequence) {
        this.f747k = charSequence;
        I();
    }

    public void G(CharSequence charSequence) {
        this.f746j = charSequence;
        if ((this.f738b & 8) != 0) {
            this.f737a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.w
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.f737a.getContext());
            this.n = cVar;
            cVar.p(f.action_menu_presenter);
        }
        this.n.k(aVar);
        this.f737a.I((g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.w
    public boolean b() {
        return this.f737a.A();
    }

    @Override // androidx.appcompat.widget.w
    public void c() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.w
    public void collapseActionView() {
        this.f737a.e();
    }

    @Override // androidx.appcompat.widget.w
    public boolean d() {
        return this.f737a.z();
    }

    @Override // androidx.appcompat.widget.w
    public boolean e() {
        return this.f737a.w();
    }

    @Override // androidx.appcompat.widget.w
    public boolean f() {
        return this.f737a.O();
    }

    @Override // androidx.appcompat.widget.w
    public boolean g() {
        return this.f737a.d();
    }

    @Override // androidx.appcompat.widget.w
    public CharSequence getTitle() {
        return this.f737a.getTitle();
    }

    @Override // androidx.appcompat.widget.w
    public void h() {
        this.f737a.f();
    }

    @Override // androidx.appcompat.widget.w
    public void i(m.a aVar, g.a aVar2) {
        this.f737a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.w
    public void j(int i2) {
        this.f737a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.w
    public void k(j0 j0Var) {
        Toolbar toolbar;
        View view = this.f739c;
        if (view != null && view.getParent() == (toolbar = this.f737a)) {
            toolbar.removeView(this.f739c);
        }
        this.f739c = j0Var;
        if (j0Var != null && this.o == 2) {
            this.f737a.addView(j0Var, 0);
            Toolbar.e eVar = (Toolbar.e) this.f739c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) eVar).width = -2;
            ((ViewGroup.MarginLayoutParams) eVar).height = -2;
            eVar.f159a = 8388691;
            j0Var.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.w
    public ViewGroup l() {
        return this.f737a;
    }

    @Override // androidx.appcompat.widget.w
    public void m(boolean z) {
    }

    @Override // androidx.appcompat.widget.w
    public Context n() {
        return this.f737a.getContext();
    }

    @Override // androidx.appcompat.widget.w
    public boolean o() {
        return this.f737a.v();
    }

    @Override // androidx.appcompat.widget.w
    public void p(int i2) {
        View view;
        int i3 = this.f738b ^ i2;
        this.f738b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    I();
                }
                J();
            }
            if ((i3 & 3) != 0) {
                K();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f737a.setTitle(this.f745i);
                    this.f737a.setSubtitle(this.f746j);
                } else {
                    this.f737a.setTitle((CharSequence) null);
                    this.f737a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f740d) != null) {
                if ((i2 & 16) != 0) {
                    this.f737a.addView(view);
                } else {
                    this.f737a.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.w
    public int q() {
        return this.f738b;
    }

    @Override // androidx.appcompat.widget.w
    public Menu r() {
        return this.f737a.getMenu();
    }

    @Override // androidx.appcompat.widget.w
    public void s(int i2) {
        E(i2 != 0 ? b.a.k.a.a.d(n(), i2) : null);
    }

    @Override // androidx.appcompat.widget.w
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? b.a.k.a.a.d(n(), i2) : null);
    }

    @Override // androidx.appcompat.widget.w
    public void setTitle(CharSequence charSequence) {
        this.f744h = true;
        H(charSequence);
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f744h) {
            H(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.w
    public void t(int i2) {
        F(i2 == 0 ? null : n().getString(i2));
    }

    @Override // androidx.appcompat.widget.w
    public int u() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.w
    public y v(int i2, long j2) {
        y d2 = u.d(this.f737a);
        d2.a(i2 == 0 ? 1.0f : Utils.FLOAT_EPSILON);
        d2.d(j2);
        d2.f(new b(i2));
        return d2;
    }

    @Override // androidx.appcompat.widget.w
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.w
    public void x() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.w
    public void y(Drawable drawable) {
        this.f743g = drawable;
        J();
    }

    @Override // androidx.appcompat.widget.w
    public void z(boolean z) {
        this.f737a.setCollapsible(z);
    }

    public r0(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f737a = toolbar;
        this.f745i = toolbar.getTitle();
        this.f746j = toolbar.getSubtitle();
        this.f744h = this.f745i != null;
        this.f743g = toolbar.getNavigationIcon();
        q0 v = q0.v(toolbar.getContext(), null, j.f1998a, b.a.a.actionBarStyle, 0);
        this.q = v.g(j.l);
        if (z) {
            CharSequence p2 = v.p(j.r);
            if (!TextUtils.isEmpty(p2)) {
                setTitle(p2);
            }
            CharSequence p3 = v.p(j.p);
            if (!TextUtils.isEmpty(p3)) {
                G(p3);
            }
            Drawable g2 = v.g(j.n);
            if (g2 != null) {
                E(g2);
            }
            Drawable g3 = v.g(j.m);
            if (g3 != null) {
                setIcon(g3);
            }
            if (this.f743g == null && (drawable = this.q) != null) {
                y(drawable);
            }
            p(v.k(j.f2005h, 0));
            int n2 = v.n(j.f2004g, 0);
            if (n2 != 0) {
                C(LayoutInflater.from(this.f737a.getContext()).inflate(n2, (ViewGroup) this.f737a, false));
                p(this.f738b | 16);
            }
            int m2 = v.m(j.f2007j, 0);
            if (m2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f737a.getLayoutParams();
                layoutParams.height = m2;
                this.f737a.setLayoutParams(layoutParams);
            }
            int e2 = v.e(j.f2003f, -1);
            int e3 = v.e(j.f2002e, -1);
            if (e2 >= 0 || e3 >= 0) {
                this.f737a.H(Math.max(e2, 0), Math.max(e3, 0));
            }
            int n3 = v.n(j.s, 0);
            if (n3 != 0) {
                Toolbar toolbar2 = this.f737a;
                toolbar2.L(toolbar2.getContext(), n3);
            }
            int n4 = v.n(j.q, 0);
            if (n4 != 0) {
                Toolbar toolbar3 = this.f737a;
                toolbar3.K(toolbar3.getContext(), n4);
            }
            int n5 = v.n(j.o, 0);
            if (n5 != 0) {
                this.f737a.setPopupTheme(n5);
            }
        } else {
            this.f738b = B();
        }
        v.w();
        D(i2);
        this.f747k = this.f737a.getNavigationContentDescription();
        this.f737a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.w
    public void setIcon(Drawable drawable) {
        this.f741e = drawable;
        K();
    }
}
