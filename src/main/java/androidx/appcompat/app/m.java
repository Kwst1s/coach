package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.w;
import b.a.f;
import b.a.j;
import b.a.o.b;
import b.a.o.h;
import b.h.k.a0;
import b.h.k.b0;
import b.h.k.u;
import b.h.k.y;
import b.h.k.z;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class m extends a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final b0 A = new c();

    /* renamed from: a  reason: collision with root package name */
    Context f254a;

    /* renamed from: b  reason: collision with root package name */
    private Context f255b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f256c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f257d;

    /* renamed from: e  reason: collision with root package name */
    w f258e;

    /* renamed from: f  reason: collision with root package name */
    ActionBarContextView f259f;

    /* renamed from: g  reason: collision with root package name */
    View f260g;

    /* renamed from: h  reason: collision with root package name */
    j0 f261h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f262i;

    /* renamed from: j  reason: collision with root package name */
    d f263j;

    /* renamed from: k  reason: collision with root package name */
    b.a.o.b f264k;
    b.a l;
    private boolean m;
    private ArrayList<a.b> n = new ArrayList<>();
    private boolean o;
    private int p = 0;
    boolean q = true;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u = true;
    h v;
    private boolean w;
    boolean x;
    final z y = new a();
    final z z = new b();

    /* compiled from: WindowDecorActionBar */
    class a extends a0 {
        a() {
        }

        @Override // b.h.k.z
        public void b(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.q && (view2 = mVar.f260g) != null) {
                view2.setTranslationY(Utils.FLOAT_EPSILON);
                m.this.f257d.setTranslationY(Utils.FLOAT_EPSILON);
            }
            m.this.f257d.setVisibility(8);
            m.this.f257d.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.v = null;
            mVar2.F();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.f256c;
            if (actionBarOverlayLayout != null) {
                u.j0(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    class b extends a0 {
        b() {
        }

        @Override // b.h.k.z
        public void b(View view) {
            m mVar = m.this;
            mVar.v = null;
            mVar.f257d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar */
    class c implements b0 {
        c() {
        }

        @Override // b.h.k.b0
        public void a(View view) {
            ((View) m.this.f257d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class d extends b.a.o.b implements g.a {

        /* renamed from: d  reason: collision with root package name */
        private final Context f268d;

        /* renamed from: e  reason: collision with root package name */
        private final g f269e;

        /* renamed from: f  reason: collision with root package name */
        private b.a f270f;

        /* renamed from: g  reason: collision with root package name */
        private WeakReference<View> f271g;

        public d(Context context, b.a aVar) {
            this.f268d = context;
            this.f270f = aVar;
            g gVar = new g(context);
            gVar.S(1);
            this.f269e = gVar;
            gVar.R(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            b.a aVar = this.f270f;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
            if (this.f270f != null) {
                k();
                m.this.f259f.l();
            }
        }

        @Override // b.a.o.b
        public void c() {
            m mVar = m.this;
            if (mVar.f263j == this) {
                if (!m.E(mVar.r, mVar.s, false)) {
                    m mVar2 = m.this;
                    mVar2.f264k = this;
                    mVar2.l = this.f270f;
                } else {
                    this.f270f.b(this);
                }
                this.f270f = null;
                m.this.D(false);
                m.this.f259f.g();
                m.this.f258e.l().sendAccessibilityEvent(32);
                m mVar3 = m.this;
                mVar3.f256c.setHideOnContentScrollEnabled(mVar3.x);
                m.this.f263j = null;
            }
        }

        @Override // b.a.o.b
        public View d() {
            WeakReference<View> weakReference = this.f271g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // b.a.o.b
        public Menu e() {
            return this.f269e;
        }

        @Override // b.a.o.b
        public MenuInflater f() {
            return new b.a.o.g(this.f268d);
        }

        @Override // b.a.o.b
        public CharSequence g() {
            return m.this.f259f.getSubtitle();
        }

        @Override // b.a.o.b
        public CharSequence i() {
            return m.this.f259f.getTitle();
        }

        @Override // b.a.o.b
        public void k() {
            if (m.this.f263j == this) {
                this.f269e.d0();
                try {
                    this.f270f.a(this, this.f269e);
                } finally {
                    this.f269e.c0();
                }
            }
        }

        @Override // b.a.o.b
        public boolean l() {
            return m.this.f259f.j();
        }

        @Override // b.a.o.b
        public void m(View view) {
            m.this.f259f.setCustomView(view);
            this.f271g = new WeakReference<>(view);
        }

        @Override // b.a.o.b
        public void n(int i2) {
            o(m.this.f254a.getResources().getString(i2));
        }

        @Override // b.a.o.b
        public void o(CharSequence charSequence) {
            m.this.f259f.setSubtitle(charSequence);
        }

        @Override // b.a.o.b
        public void q(int i2) {
            r(m.this.f254a.getResources().getString(i2));
        }

        @Override // b.a.o.b
        public void r(CharSequence charSequence) {
            m.this.f259f.setTitle(charSequence);
        }

        @Override // b.a.o.b
        public void s(boolean z) {
            super.s(z);
            m.this.f259f.setTitleOptional(z);
        }

        public boolean t() {
            this.f269e.d0();
            try {
                return this.f270f.d(this, this.f269e);
            } finally {
                this.f269e.c0();
            }
        }
    }

    public m(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        L(decorView);
        if (!z2) {
            this.f260g = decorView.findViewById(16908290);
        }
    }

    static boolean E(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private w I(View view) {
        if (view instanceof w) {
            return (w) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void K() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f256c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void L(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        this.f256c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f258e = I(view.findViewById(f.action_bar));
        this.f259f = (ActionBarContextView) view.findViewById(f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.action_bar_container);
        this.f257d = actionBarContainer;
        w wVar = this.f258e;
        if (wVar == null || this.f259f == null || actionBarContainer == null) {
            throw new IllegalStateException(m.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f254a = wVar.n();
        boolean z2 = (this.f258e.q() & 4) != 0;
        if (z2) {
            this.f262i = true;
        }
        b.a.o.a b2 = b.a.o.a.b(this.f254a);
        x(b2.a() || z2);
        O(b2.g());
        TypedArray obtainStyledAttributes = this.f254a.obtainStyledAttributes(null, j.f1998a, b.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.f2008k, false)) {
            P(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f2006i, 0);
        if (dimensionPixelSize != 0) {
            N((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void O(boolean z2) {
        this.o = z2;
        if (!z2) {
            this.f258e.k(null);
            this.f257d.setTabContainer(this.f261h);
        } else {
            this.f257d.setTabContainer(null);
            this.f258e.k(this.f261h);
        }
        boolean z3 = true;
        boolean z4 = J() == 2;
        j0 j0Var = this.f261h;
        if (j0Var != null) {
            if (z4) {
                j0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f256c;
                if (actionBarOverlayLayout != null) {
                    u.j0(actionBarOverlayLayout);
                }
            } else {
                j0Var.setVisibility(8);
            }
        }
        this.f258e.z(!this.o && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f256c;
        if (this.o || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private boolean Q() {
        return u.S(this.f257d);
    }

    private void R() {
        if (!this.t) {
            this.t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f256c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            S(false);
        }
    }

    private void S(boolean z2) {
        if (E(this.r, this.s, this.t)) {
            if (!this.u) {
                this.u = true;
                H(z2);
            }
        } else if (this.u) {
            this.u = false;
            G(z2);
        }
    }

    @Override // androidx.appcompat.app.a
    public void A(CharSequence charSequence) {
        this.f258e.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void B(CharSequence charSequence) {
        this.f258e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public b.a.o.b C(b.a aVar) {
        d dVar = this.f263j;
        if (dVar != null) {
            dVar.c();
        }
        this.f256c.setHideOnContentScrollEnabled(false);
        this.f259f.k();
        d dVar2 = new d(this.f259f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f263j = dVar2;
        dVar2.k();
        this.f259f.h(dVar2);
        D(true);
        this.f259f.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void D(boolean z2) {
        y yVar;
        y yVar2;
        if (z2) {
            R();
        } else {
            K();
        }
        if (Q()) {
            if (z2) {
                yVar = this.f258e.v(4, 100);
                yVar2 = this.f259f.f(0, 200);
            } else {
                yVar2 = this.f258e.v(0, 200);
                yVar = this.f259f.f(8, 100);
            }
            h hVar = new h();
            hVar.d(yVar, yVar2);
            hVar.h();
        } else if (z2) {
            this.f258e.j(4);
            this.f259f.setVisibility(0);
        } else {
            this.f258e.j(0);
            this.f259f.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.b(this.f264k);
            this.f264k = null;
            this.l = null;
        }
    }

    public void G(boolean z2) {
        View view;
        h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z2)) {
            this.y.b(null);
            return;
        }
        this.f257d.setAlpha(1.0f);
        this.f257d.setTransitioning(true);
        h hVar2 = new h();
        float f2 = (float) (-this.f257d.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f257d.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        y d2 = u.d(this.f257d);
        d2.k(f2);
        d2.i(this.A);
        hVar2.c(d2);
        if (this.q && (view = this.f260g) != null) {
            y d3 = u.d(view);
            d3.k(f2);
            hVar2.c(d3);
        }
        hVar2.f(B);
        hVar2.e(250);
        hVar2.g(this.y);
        this.v = hVar2;
        hVar2.h();
    }

    public void H(boolean z2) {
        View view;
        View view2;
        h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f257d.setVisibility(0);
        if (this.p != 0 || (!this.w && !z2)) {
            this.f257d.setAlpha(1.0f);
            this.f257d.setTranslationY(Utils.FLOAT_EPSILON);
            if (this.q && (view = this.f260g) != null) {
                view.setTranslationY(Utils.FLOAT_EPSILON);
            }
            this.z.b(null);
        } else {
            this.f257d.setTranslationY(Utils.FLOAT_EPSILON);
            float f2 = (float) (-this.f257d.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f257d.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f257d.setTranslationY(f2);
            h hVar2 = new h();
            y d2 = u.d(this.f257d);
            d2.k(Utils.FLOAT_EPSILON);
            d2.i(this.A);
            hVar2.c(d2);
            if (this.q && (view2 = this.f260g) != null) {
                view2.setTranslationY(f2);
                y d3 = u.d(this.f260g);
                d3.k(Utils.FLOAT_EPSILON);
                hVar2.c(d3);
            }
            hVar2.f(C);
            hVar2.e(250);
            hVar2.g(this.z);
            this.v = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f256c;
        if (actionBarOverlayLayout != null) {
            u.j0(actionBarOverlayLayout);
        }
    }

    public int J() {
        return this.f258e.u();
    }

    public void M(int i2, int i3) {
        int q2 = this.f258e.q();
        if ((i3 & 4) != 0) {
            this.f262i = true;
        }
        this.f258e.p((i2 & i3) | ((i3 ^ -1) & q2));
    }

    public void N(float f2) {
        u.u0(this.f257d, f2);
    }

    public void P(boolean z2) {
        if (!z2 || this.f256c.w()) {
            this.x = z2;
            this.f256c.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            S(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i2) {
        this.p = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean z2) {
        this.q = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (!this.s) {
            this.s = true;
            S(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        w wVar = this.f258e;
        if (wVar == null || !wVar.o()) {
            return false;
        }
        this.f258e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z2) {
        if (z2 != this.m) {
            this.m = z2;
            int size = this.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.n.get(i2).a(z2);
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f258e.q();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f255b == null) {
            TypedValue typedValue = new TypedValue();
            this.f254a.getTheme().resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f255b = new ContextThemeWrapper(this.f254a, i2);
            } else {
                this.f255b = this.f254a;
            }
        }
        return this.f255b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        O(b.a.o.a.b(this.f254a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu e2;
        d dVar = this.f263j;
        if (dVar == null || (e2 = dVar.e()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        e2.setQwertyMode(z2);
        return e2.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z2) {
        if (!this.f262i) {
            s(z2);
        }
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z2) {
        M(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z2) {
        M(z2 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(int i2) {
        this.f258e.t(i2);
    }

    @Override // androidx.appcompat.app.a
    public void v(int i2) {
        this.f258e.A(i2);
    }

    @Override // androidx.appcompat.app.a
    public void w(Drawable drawable) {
        this.f258e.y(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void x(boolean z2) {
        this.f258e.m(z2);
    }

    @Override // androidx.appcompat.app.a
    public void y(boolean z2) {
        h hVar;
        this.w = z2;
        if (!z2 && (hVar = this.v) != null) {
            hVar.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void z(int i2) {
        A(this.f254a.getString(i2));
    }

    public m(Dialog dialog) {
        new ArrayList();
        L(dialog.getWindow().getDecorView());
    }
}
