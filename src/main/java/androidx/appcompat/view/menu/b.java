package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
public abstract class b implements m {

    /* renamed from: b  reason: collision with root package name */
    protected Context f304b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f305c;

    /* renamed from: d  reason: collision with root package name */
    protected g f306d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f307e;

    /* renamed from: f  reason: collision with root package name */
    private m.a f308f;

    /* renamed from: g  reason: collision with root package name */
    private int f309g;

    /* renamed from: h  reason: collision with root package name */
    private int f310h;

    /* renamed from: i  reason: collision with root package name */
    protected n f311i;

    public b(Context context, int i2, int i3) {
        this.f304b = context;
        this.f307e = LayoutInflater.from(context);
        this.f309g = i2;
        this.f310h = i3;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f311i).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f308f;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public abstract void c(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void d(Context context, g gVar) {
        this.f305c = context;
        LayoutInflater.from(context);
        this.f306d = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.appcompat.view.menu.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(androidx.appcompat.view.menu.r r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.m$a r0 = r1.f308f
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.g r2 = r1.f306d
        L_0x0009:
            boolean r2 = r0.c(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.e(androidx.appcompat.view.menu.r):boolean");
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f311i;
        if (viewGroup != null) {
            g gVar = this.f306d;
            int i2 = 0;
            if (gVar != null) {
                gVar.r();
                ArrayList<i> E = this.f306d.E();
                int size = E.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i iVar = E.get(i4);
                    if (q(i3, iVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View n = n(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            n.setPressed(false);
                            n.jumpDrawablesToCurrentState();
                        }
                        if (n != childAt) {
                            a(n, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!l(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public n.a h(ViewGroup viewGroup) {
        return (n.a) this.f307e.inflate(this.f310h, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.f308f = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public m.a m() {
        return this.f308f;
    }

    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = h(viewGroup);
        }
        c(iVar, aVar);
        return (View) aVar;
    }

    public n o(ViewGroup viewGroup) {
        if (this.f311i == null) {
            n nVar = (n) this.f307e.inflate(this.f309g, viewGroup, false);
            this.f311i = nVar;
            nVar.b(this.f306d);
            f(true);
        }
        return this.f311i;
    }

    public void p(int i2) {
    }

    public abstract boolean q(int i2, i iVar);
}
