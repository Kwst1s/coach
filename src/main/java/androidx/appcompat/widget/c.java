package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import b.h.k.b;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: ActionMenuPresenter */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    private b A;
    final f B = new f();
    int C;

    /* renamed from: j  reason: collision with root package name */
    d f573j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f574k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private final SparseBooleanArray w = new SparseBooleanArray();
    e x;
    a y;
    RunnableC0012c z;

    /* access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter */
    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, b.a.a.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).l()) {
                View view2 = c.this.f573j;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).f311i : view2);
            }
            j(c.this.B);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.l
        public void e() {
            c cVar = c.this;
            cVar.y = null;
            cVar.C = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public p a() {
            a aVar = c.this.y;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* compiled from: ActionMenuPresenter */
    public class RunnableC0012c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f576b;

        public RunnableC0012c(e eVar) {
            this.f576b = eVar;
        }

        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f306d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f306d.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).f311i;
            if (!(view == null || view.getWindowToken() == null || !this.f576b.m())) {
                c.this.x = this.f576b;
            }
            c.this.z = null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter */
        class a extends a0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.a0
            public p b() {
                e eVar = c.this.x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.a0
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.a0
            public boolean d() {
                c cVar = c.this;
                if (cVar.z != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, b.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            s0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter */
    public class e extends l {
        public e(Context context, g gVar, View view, boolean z) {
            super(context, gVar, view, z, b.a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.B);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.l
        public void e() {
            if (((androidx.appcompat.view.menu.b) c.this).f306d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f306d.close();
            }
            c.this.x = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.D().e(false);
            }
            m.a m = c.this.m();
            if (m != null) {
                m.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) c.this).f306d) {
                return false;
            }
            c.this.C = ((r) gVar).getItem().getItemId();
            m.a m = c.this.m();
            if (m != null) {
                return m.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, b.a.g.abc_action_menu_layout, b.a.g.abc_action_menu_item_layout);
    }

    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f311i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f573j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.l) {
            return this.f574k;
        }
        return null;
    }

    public boolean B() {
        n nVar;
        RunnableC0012c cVar = this.z;
        if (cVar == null || (nVar = this.f311i) == null) {
            e eVar = this.x;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) nVar).removeCallbacks(cVar);
        this.z = null;
        return true;
    }

    public boolean C() {
        a aVar = this.y;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.z != null || E();
    }

    public boolean E() {
        e eVar = this.x;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.r) {
            this.q = b.a.o.a.b(this.f305c).d();
        }
        g gVar = this.f306d;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void G(boolean z2) {
        this.u = z2;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f311i = actionMenuView;
        actionMenuView.b(this.f306d);
    }

    public void I(Drawable drawable) {
        d dVar = this.f573j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.l = true;
        this.f574k = drawable;
    }

    public void J(boolean z2) {
        this.m = z2;
        this.n = true;
    }

    public boolean K() {
        g gVar;
        if (!this.m || E() || (gVar = this.f306d) == null || this.f311i == null || this.z != null || gVar.z().isEmpty()) {
            return false;
        }
        RunnableC0012c cVar = new RunnableC0012c(new e(this.f305c, this.f306d, this.f573j, true));
        this.z = cVar;
        ((View) this.f311i).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.b
    public void b(g gVar, boolean z2) {
        y();
        super.b(gVar, z2);
    }

    @Override // androidx.appcompat.view.menu.b
    public void c(i iVar, n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f311i);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.b
    public void d(Context context, g gVar) {
        super.d(context, gVar);
        Resources resources = context.getResources();
        b.a.o.a b2 = b.a.o.a.b(context);
        if (!this.n) {
            this.m = b2.h();
        }
        if (!this.t) {
            this.o = b2.c();
        }
        if (!this.r) {
            this.q = b2.d();
        }
        int i2 = this.o;
        if (this.m) {
            if (this.f573j == null) {
                d dVar = new d(this.f304b);
                this.f573j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.f574k);
                    this.f574k = null;
                    this.l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f573j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f573j.getMeasuredWidth();
        } else {
            this.f573j = null;
        }
        this.p = i2;
        this.v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.b
    public boolean e(r rVar) {
        boolean z2 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.e0() != this.f306d) {
            rVar2 = (r) rVar2.e0();
        }
        View z3 = z(rVar2.getItem());
        if (z3 == null) {
            return false;
        }
        rVar.getItem().getItemId();
        int size = rVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f305c, rVar, z3);
        this.y = aVar;
        aVar.g(z2);
        this.y.k();
        super.e(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.b
    public void f(boolean z2) {
        n nVar;
        super.f(z2);
        ((View) this.f311i).requestLayout();
        g gVar = this.f306d;
        boolean z3 = false;
        if (gVar != null) {
            ArrayList<i> s2 = gVar.s();
            int size = s2.size();
            for (int i2 = 0; i2 < size; i2++) {
                b.h.k.b b2 = s2.get(i2).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        g gVar2 = this.f306d;
        ArrayList<i> z4 = gVar2 != null ? gVar2.z() : null;
        if (this.m && z4 != null) {
            int size2 = z4.size();
            if (size2 == 1) {
                z3 = !z4.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f573j == null) {
                this.f573j = new d(this.f304b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f573j.getParent();
            if (viewGroup != this.f311i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f573j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f311i;
                actionMenuView.addView(this.f573j, actionMenuView.F());
            }
        } else {
            d dVar = this.f573j;
            if (dVar != null && dVar.getParent() == (nVar = this.f311i)) {
                ((ViewGroup) nVar).removeView(this.f573j);
            }
        }
        ((ActionMenuView) this.f311i).setOverflowReserved(this.m);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        int i2;
        ArrayList<i> arrayList;
        int i3;
        int i4;
        int i5;
        c cVar = this;
        g gVar = cVar.f306d;
        View view = null;
        int i6 = 0;
        if (gVar != null) {
            arrayList = gVar.E();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = cVar.q;
        int i8 = cVar.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f311i;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            i iVar = arrayList.get(i11);
            if (iVar.o()) {
                i9++;
            } else if (iVar.n()) {
                i10++;
            } else {
                z2 = true;
            }
            if (cVar.u && iVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (cVar.m && (z2 || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = cVar.w;
        sparseBooleanArray.clear();
        if (cVar.s) {
            int i13 = cVar.v;
            i3 = i8 / i13;
            i4 = i13 + ((i8 % i13) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i2) {
            i iVar2 = arrayList.get(i14);
            if (iVar2.o()) {
                View n2 = cVar.n(iVar2, view, viewGroup);
                if (cVar.s) {
                    i3 -= ActionMenuView.L(n2, i4, i3, makeMeasureSpec, i6);
                } else {
                    n2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n2.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i5 = i2;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i8 > 0 && (!cVar.s || i3 > 0);
                boolean z5 = z4;
                i5 = i2;
                if (z4) {
                    View n3 = cVar.n(iVar2, null, viewGroup);
                    if (cVar.s) {
                        int L = ActionMenuView.L(n3, i4, i3, makeMeasureSpec, 0);
                        i3 -= L;
                        if (L == 0) {
                            z5 = false;
                        }
                    } else {
                        n3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = n3.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z4 = z5 & (!cVar.s ? i8 + i15 > 0 : i8 >= 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        i iVar3 = arrayList.get(i16);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i12++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                iVar2.u(z4);
            } else {
                i5 = i2;
                iVar2.u(false);
                i14++;
                view = null;
                cVar = this;
                i2 = i5;
                i6 = 0;
            }
            i14++;
            view = null;
            cVar = this;
            i2 = i5;
            i6 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f573j) {
            return false;
        }
        return super.l(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public n o(ViewGroup viewGroup) {
        n nVar = this.f311i;
        n o2 = super.o(viewGroup);
        if (nVar != o2) {
            ((ActionMenuView) o2).setPresenter(this);
        }
        return o2;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i2, i iVar) {
        return iVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
