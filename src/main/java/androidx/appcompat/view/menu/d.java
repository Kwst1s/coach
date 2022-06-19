package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.e0;
import b.a.g;
import b.h.k.e;
import b.h.k.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    private final Context f315c;

    /* renamed from: d  reason: collision with root package name */
    private final int f316d;

    /* renamed from: e  reason: collision with root package name */
    private final int f317e;

    /* renamed from: f  reason: collision with root package name */
    private final int f318f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f319g;

    /* renamed from: h  reason: collision with root package name */
    final Handler f320h;

    /* renamed from: i  reason: collision with root package name */
    private final List<g> f321i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final List<C0010d> f322j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f323k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private final d0 m = new c();
    private int n = 0;
    private int o = 0;
    private View p;
    View q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private m.a y;
    ViewTreeObserver z;

    /* compiled from: CascadingMenuPopup */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (d.this.c() && d.this.f322j.size() > 0 && !d.this.f322j.get(0).f331a.B()) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0010d dVar : d.this.f322j) {
                    dVar.f331a.a();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.f323k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup */
    class c implements d0 {

        /* compiled from: CascadingMenuPopup */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C0010d f327b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MenuItem f328c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ g f329d;

            a(C0010d dVar, MenuItem menuItem, g gVar) {
                this.f327b = dVar;
                this.f328c = menuItem;
                this.f329d = gVar;
            }

            public void run() {
                C0010d dVar = this.f327b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.f332b.e(false);
                    d.this.B = false;
                }
                if (this.f328c.isEnabled() && this.f328c.hasSubMenu()) {
                    this.f329d.L(this.f328c, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.d0
        public void e(g gVar, MenuItem menuItem) {
            C0010d dVar = null;
            d.this.f320h.removeCallbacksAndMessages(null);
            int size = d.this.f322j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f322j.get(i2).f332b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f322j.size()) {
                    dVar = d.this.f322j.get(i3);
                }
                d.this.f320h.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.d0
        public void f(g gVar, MenuItem menuItem) {
            d.this.f320h.removeCallbacksAndMessages(gVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: androidx.appcompat.view.menu.d$d  reason: collision with other inner class name */
    /* compiled from: CascadingMenuPopup */
    public static class C0010d {

        /* renamed from: a  reason: collision with root package name */
        public final e0 f331a;

        /* renamed from: b  reason: collision with root package name */
        public final g f332b;

        /* renamed from: c  reason: collision with root package name */
        public final int f333c;

        public C0010d(e0 e0Var, g gVar, int i2) {
            this.f331a = e0Var;
            this.f332b = gVar;
            this.f333c = i2;
        }

        public ListView a() {
            return this.f331a.h();
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        this.f315c = context;
        this.p = view;
        this.f317e = i2;
        this.f318f = i3;
        this.f319g = z2;
        this.w = false;
        this.r = D();
        Resources resources = context.getResources();
        this.f316d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.a.d.abc_config_prefDialogWidth));
        this.f320h = new Handler();
    }

    private int A(g gVar) {
        int size = this.f322j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.f322j.get(i2).f332b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(C0010d dVar, g gVar) {
        int i2;
        f fVar;
        int firstVisiblePosition;
        MenuItem B2 = B(dVar.f332b, gVar);
        if (B2 == null) {
            return null;
        }
        ListView a2 = dVar.a();
        ListAdapter adapter = a2.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (B2 == fVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return u.B(this.p) == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List<C0010d> list = this.f322j;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        if (this.r == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void F(g gVar) {
        View view;
        C0010d dVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f315c);
        f fVar = new f(gVar, from, this.f319g, C);
        if (!c() && this.w) {
            fVar.d(true);
        } else if (c()) {
            fVar.d(k.x(gVar));
        }
        int o2 = k.o(fVar, null, this.f315c, this.f316d);
        e0 z2 = z();
        z2.p(fVar);
        z2.F(o2);
        z2.G(this.o);
        if (this.f322j.size() > 0) {
            List<C0010d> list = this.f322j;
            dVar = list.get(list.size() - 1);
            view = C(dVar, gVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            z2.U(false);
            z2.R(null);
            int E = E(o2);
            boolean z3 = E == 1;
            this.r = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z2.D(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) != 5) {
                if (z3) {
                    o2 = view.getWidth();
                }
                i4 = i2 - o2;
                z2.l(i4);
                z2.M(true);
                z2.j(i3);
            } else if (!z3) {
                o2 = view.getWidth();
                i4 = i2 - o2;
                z2.l(i4);
                z2.M(true);
                z2.j(i3);
            }
            i4 = i2 + o2;
            z2.l(i4);
            z2.M(true);
            z2.j(i3);
        } else {
            if (this.s) {
                z2.l(this.u);
            }
            if (this.t) {
                z2.j(this.v);
            }
            z2.H(n());
        }
        this.f322j.add(new C0010d(z2, gVar, this.r));
        z2.a();
        ListView h2 = z2.h();
        h2.setOnKeyListener(this);
        if (dVar == null && this.x && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) h2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.x());
            h2.addHeaderView(frameLayout, null, false);
            z2.a();
        }
    }

    private e0 z() {
        e0 e0Var = new e0(this.f315c, null, this.f317e, this.f318f);
        e0Var.T(this.m);
        e0Var.L(this);
        e0Var.K(this);
        e0Var.D(this.p);
        e0Var.G(this.o);
        e0Var.J(true);
        e0Var.I(2);
        return e0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (!c()) {
            for (g gVar : this.f321i) {
                F(gVar);
            }
            this.f321i.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                boolean z2 = this.z == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f323k);
                }
                this.q.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z2) {
        int A2 = A(gVar);
        if (A2 >= 0) {
            int i2 = A2 + 1;
            if (i2 < this.f322j.size()) {
                this.f322j.get(i2).f332b.e(false);
            }
            C0010d remove = this.f322j.remove(A2);
            remove.f332b.O(this);
            if (this.B) {
                remove.f331a.S(null);
                remove.f331a.E(0);
            }
            remove.f331a.dismiss();
            int size = this.f322j.size();
            if (size > 0) {
                this.r = this.f322j.get(size - 1).f333c;
            } else {
                this.r = D();
            }
            if (size == 0) {
                dismiss();
                m.a aVar = this.y;
                if (aVar != null) {
                    aVar.b(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.f323k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.l);
                this.A.onDismiss();
            } else if (z2) {
                this.f322j.get(0).f332b.e(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.f322j.size() > 0 && this.f322j.get(0).f331a.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.f322j.size();
        if (size > 0) {
            C0010d[] dVarArr = (C0010d[]) this.f322j.toArray(new C0010d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0010d dVar = dVarArr[i2];
                if (dVar.f331a.c()) {
                    dVar.f331a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        for (C0010d dVar : this.f322j) {
            if (rVar == dVar.f332b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        l(rVar);
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z2) {
        for (C0010d dVar : this.f322j) {
            k.y(dVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        if (this.f322j.isEmpty()) {
            return null;
        }
        List<C0010d> list = this.f322j;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.y = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
        gVar.c(this, this.f315c);
        if (c()) {
            F(gVar);
        } else {
            this.f321i.add(gVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.k
    public boolean m() {
        return false;
    }

    public void onDismiss() {
        C0010d dVar;
        int size = this.f322j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f322j.get(i2);
            if (!dVar.f331a.c()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f332b.e(false);
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
        if (this.p != view) {
            this.p = view;
            this.o = e.b(this.n, u.B(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z2) {
        this.w = z2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = e.b(i2, u.B(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i2) {
        this.s = true;
        this.u = i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z2) {
        this.x = z2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i2) {
        this.t = true;
        this.v = i2;
    }
}
