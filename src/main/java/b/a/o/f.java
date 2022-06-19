package b.a.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import b.a.o.b;
import b.e.g;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f2071a;

    /* renamed from: b  reason: collision with root package name */
    final b f2072b;

    /* compiled from: SupportActionModeWrapper */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f2073a;

        /* renamed from: b  reason: collision with root package name */
        final Context f2074b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f2075c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f2076d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f2074b = context;
            this.f2073a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f2076d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f2074b, (b.h.f.a.a) menu);
            this.f2076d.put(menu, oVar);
            return oVar;
        }

        @Override // b.a.o.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f2073a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // b.a.o.b.a
        public void b(b bVar) {
            this.f2073a.onDestroyActionMode(e(bVar));
        }

        @Override // b.a.o.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f2073a.onActionItemClicked(e(bVar), new j(this.f2074b, (b.h.f.a.b) menuItem));
        }

        @Override // b.a.o.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f2073a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f2075c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f2075c.get(i2);
                if (fVar != null && fVar.f2072b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f2074b, bVar);
            this.f2075c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f2071a = context;
        this.f2072b = bVar;
    }

    public void finish() {
        this.f2072b.c();
    }

    public View getCustomView() {
        return this.f2072b.d();
    }

    public Menu getMenu() {
        return new o(this.f2071a, (b.h.f.a.a) this.f2072b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f2072b.f();
    }

    public CharSequence getSubtitle() {
        return this.f2072b.g();
    }

    public Object getTag() {
        return this.f2072b.h();
    }

    public CharSequence getTitle() {
        return this.f2072b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f2072b.j();
    }

    public void invalidate() {
        this.f2072b.k();
    }

    public boolean isTitleOptional() {
        return this.f2072b.l();
    }

    public void setCustomView(View view) {
        this.f2072b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2072b.o(charSequence);
    }

    public void setTag(Object obj) {
        this.f2072b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2072b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f2072b.s(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f2072b.n(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f2072b.q(i2);
    }
}
