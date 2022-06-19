package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.e0;
import b.a.d;
import b.a.g;
import b.h.k.u;

/* compiled from: StandardMenuPopup */
final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    private static final int w = g.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    private final Context f402c;

    /* renamed from: d  reason: collision with root package name */
    private final g f403d;

    /* renamed from: e  reason: collision with root package name */
    private final f f404e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f405f;

    /* renamed from: g  reason: collision with root package name */
    private final int f406g;

    /* renamed from: h  reason: collision with root package name */
    private final int f407h;

    /* renamed from: i  reason: collision with root package name */
    private final int f408i;

    /* renamed from: j  reason: collision with root package name */
    final e0 f409j;

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f410k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private m.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private int u = 0;
    private boolean v;

    /* compiled from: StandardMenuPopup */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (q.this.c() && !q.this.f409j.B()) {
                View view = q.this.o;
                if (view == null || !view.isShown()) {
                    q.this.dismiss();
                } else {
                    q.this.f409j.a();
                }
            }
        }
    }

    /* compiled from: StandardMenuPopup */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.q = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.q.removeGlobalOnLayoutListener(qVar.f410k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f402c = context;
        this.f403d = gVar;
        this.f405f = z;
        this.f404e = new f(gVar, LayoutInflater.from(context), z, w);
        this.f407h = i2;
        this.f408i = i3;
        Resources resources = context.getResources();
        this.f406g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.n = view;
        this.f409j = new e0(context, null, i2, i3);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.f409j.K(this);
        this.f409j.L(this);
        this.f409j.J(true);
        View view2 = this.o;
        boolean z = this.q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.q = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f410k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.f409j.D(view2);
        this.f409j.G(this.u);
        if (!this.s) {
            this.t = k.o(this.f404e, null, this.f402c, this.f406g);
            this.s = true;
        }
        this.f409j.F(this.t);
        this.f409j.I(2);
        this.f409j.H(n());
        this.f409j.a();
        ListView h2 = this.f409j.h();
        h2.setOnKeyListener(this);
        if (this.v && this.f403d.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f402c).inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) h2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f403d.x());
            }
            frameLayout.setEnabled(false);
            h2.addHeaderView(frameLayout, null, false);
        }
        this.f409j.p(this.f404e);
        this.f409j.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        if (gVar == this.f403d) {
            dismiss();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return !this.r && this.f409j.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (c()) {
            this.f409j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f402c, rVar, this.o, this.f405f, this.f407h, this.f408i);
            lVar.j(this.p);
            lVar.g(k.x(rVar));
            lVar.i(this.m);
            this.m = null;
            this.f403d.e(false);
            int d2 = this.f409j.d();
            int n2 = this.f409j.n();
            if ((Gravity.getAbsoluteGravity(this.u, u.B(this.n)) & 7) == 5) {
                d2 += this.n.getWidth();
            }
            if (lVar.n(d2, n2)) {
                m.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.c(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        this.s = false;
        f fVar = this.f404e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.f409j.h();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
    }

    public void onDismiss() {
        this.r = true;
        this.f403d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f410k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.f404e.d(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i2) {
        this.u = i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i2) {
        this.f409j.l(i2);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i2) {
        this.f409j.j(i2);
    }
}
