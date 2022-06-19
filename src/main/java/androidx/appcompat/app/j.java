package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.r0;
import androidx.appcompat.widget.w;
import androidx.constraintlayout.widget.i;
import b.h.k.u;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: ToolbarActionBar */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    w f226a;

    /* renamed from: b  reason: collision with root package name */
    boolean f227b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f228c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f229d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f230e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a.b> f231f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f232g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.f f233h;

    /* compiled from: ToolbarActionBar */
    class a implements Runnable {
        a() {
        }

        public void run() {
            j.this.F();
        }
    }

    /* compiled from: ToolbarActionBar */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.f228c.onMenuItemSelected(0, menuItem);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ToolbarActionBar */
    public final class c implements m.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f236b;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(g gVar, boolean z) {
            if (!this.f236b) {
                this.f236b = true;
                j.this.f226a.h();
                Window.Callback callback = j.this.f228c;
                if (callback != null) {
                    callback.onPanelClosed(i.H0, gVar);
                }
                this.f236b = false;
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(g gVar) {
            Window.Callback callback = j.this.f228c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(i.H0, gVar);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ToolbarActionBar */
    public final class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
            j jVar = j.this;
            if (jVar.f228c == null) {
                return;
            }
            if (jVar.f226a.b()) {
                j.this.f228c.onPanelClosed(i.H0, gVar);
            } else if (j.this.f228c.onPreparePanel(0, null, gVar)) {
                j.this.f228c.onMenuOpened(i.H0, gVar);
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    private class e extends b.a.o.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // b.a.o.i
        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(j.this.f226a.n());
            }
            return super.onCreatePanelView(i2);
        }

        @Override // b.a.o.i
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                j jVar = j.this;
                if (!jVar.f227b) {
                    jVar.f226a.c();
                    j.this.f227b = true;
                }
            }
            return onPreparePanel;
        }
    }

    j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f233h = bVar;
        this.f226a = new r0(toolbar, false);
        e eVar = new e(callback);
        this.f228c = eVar;
        this.f226a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f226a.setWindowTitle(charSequence);
    }

    private Menu D() {
        if (!this.f229d) {
            this.f226a.i(new c(), new d());
            this.f229d = true;
        }
        return this.f226a.r();
    }

    @Override // androidx.appcompat.app.a
    public void A(CharSequence charSequence) {
        this.f226a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void B(CharSequence charSequence) {
        this.f226a.setWindowTitle(charSequence);
    }

    public Window.Callback E() {
        return this.f228c;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        Menu D = D();
        g gVar = D instanceof g ? (g) D : null;
        if (gVar != null) {
            gVar.d0();
        }
        try {
            D.clear();
            if (!this.f228c.onCreatePanelMenu(0, D) || !this.f228c.onPreparePanel(0, null, D)) {
                D.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.c0();
            }
        }
    }

    public void G(int i2, int i3) {
        this.f226a.p((i2 & i3) | ((i3 ^ -1) & this.f226a.q()));
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f226a.e();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.f226a.o()) {
            return false;
        }
        this.f226a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z != this.f230e) {
            this.f230e = z;
            int size = this.f231f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f231f.get(i2).a(z);
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f226a.q();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f226a.n();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f226a.l().removeCallbacks(this.f232g);
        u.e0(this.f226a.l(), this.f232g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void n() {
        this.f226a.l().removeCallbacks(this.f232g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu D = D();
        if (D == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        D.setQwertyMode(z);
        return D.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f226a.f();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        G(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        G(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(int i2) {
        this.f226a.t(i2);
    }

    @Override // androidx.appcompat.app.a
    public void v(int i2) {
        this.f226a.A(i2);
    }

    @Override // androidx.appcompat.app.a
    public void w(Drawable drawable) {
        this.f226a.y(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void x(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void y(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void z(int i2) {
        w wVar = this.f226a;
        wVar.setTitle(i2 != 0 ? wVar.n().getText(i2) : null);
    }
}
