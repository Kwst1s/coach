package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;

/* compiled from: PopupMenu */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f608a;

    /* renamed from: b  reason: collision with root package name */
    private final g f609b;

    /* renamed from: c  reason: collision with root package name */
    final l f610c;

    /* renamed from: d  reason: collision with root package name */
    d f611d;

    /* renamed from: e  reason: collision with root package name */
    c f612e;

    /* compiled from: PopupMenu */
    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            d dVar = f0.this.f611d;
            if (dVar != null) {
                return dVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
        }
    }

    /* compiled from: PopupMenu */
    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        public void onDismiss() {
            f0 f0Var = f0.this;
            c cVar = f0Var.f612e;
            if (cVar != null) {
                cVar.a(f0Var);
            }
        }
    }

    /* compiled from: PopupMenu */
    public interface c {
        void a(f0 f0Var);
    }

    /* compiled from: PopupMenu */
    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public f0(Context context, View view) {
        this(context, view, 0);
    }

    public Menu a() {
        return this.f609b;
    }

    public MenuInflater b() {
        return new b.a.o.g(this.f608a);
    }

    public void c(c cVar) {
        this.f612e = cVar;
    }

    public void d(d dVar) {
        this.f611d = dVar;
    }

    public void e() {
        this.f610c.k();
    }

    public f0(Context context, View view, int i2) {
        this(context, view, i2, b.a.a.popupMenuStyle, 0);
    }

    public f0(Context context, View view, int i2, int i3, int i4) {
        this.f608a = context;
        g gVar = new g(context);
        this.f609b = gVar;
        gVar.R(new a());
        l lVar = new l(context, gVar, view, false, i3, i4);
        this.f610c = lVar;
        lVar.h(i2);
        lVar.i(new b());
    }
}
