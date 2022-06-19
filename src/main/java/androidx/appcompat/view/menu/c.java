package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.e.g;
import b.h.f.a.b;

/* access modifiers changed from: package-private */
/* compiled from: BaseMenuWrapper */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f312a;

    /* renamed from: b  reason: collision with root package name */
    private g<b, MenuItem> f313b;

    /* renamed from: c  reason: collision with root package name */
    private g<b.h.f.a.c, SubMenu> f314c;

    c(Context context) {
        this.f312a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f313b == null) {
            this.f313b = new g<>();
        }
        MenuItem menuItem2 = this.f313b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f312a, bVar);
        this.f313b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof b.h.f.a.c)) {
            return subMenu;
        }
        b.h.f.a.c cVar = (b.h.f.a.c) subMenu;
        if (this.f314c == null) {
            this.f314c = new g<>();
        }
        SubMenu subMenu2 = this.f314c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f312a, cVar);
        this.f314c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        g<b, MenuItem> gVar = this.f313b;
        if (gVar != null) {
            gVar.clear();
        }
        g<b.h.f.a.c, SubMenu> gVar2 = this.f314c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i2) {
        if (this.f313b != null) {
            int i3 = 0;
            while (i3 < this.f313b.size()) {
                if (this.f313b.i(i3).getGroupId() == i2) {
                    this.f313b.k(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i2) {
        if (this.f313b != null) {
            for (int i3 = 0; i3 < this.f313b.size(); i3++) {
                if (this.f313b.i(i3).getItemId() == i2) {
                    this.f313b.k(i3);
                    return;
                }
            }
        }
    }
}
