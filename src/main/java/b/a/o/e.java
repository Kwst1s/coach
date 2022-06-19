package b.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import b.a.o.b;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class e extends b implements g.a {

    /* renamed from: d  reason: collision with root package name */
    private Context f2065d;

    /* renamed from: e  reason: collision with root package name */
    private ActionBarContextView f2066e;

    /* renamed from: f  reason: collision with root package name */
    private b.a f2067f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<View> f2068g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2069h;

    /* renamed from: i  reason: collision with root package name */
    private g f2070i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f2065d = context;
        this.f2066e = actionBarContextView;
        this.f2067f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.S(1);
        this.f2070i = gVar;
        gVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f2067f.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(g gVar) {
        k();
        this.f2066e.l();
    }

    @Override // b.a.o.b
    public void c() {
        if (!this.f2069h) {
            this.f2069h = true;
            this.f2066e.sendAccessibilityEvent(32);
            this.f2067f.b(this);
        }
    }

    @Override // b.a.o.b
    public View d() {
        WeakReference<View> weakReference = this.f2068g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // b.a.o.b
    public Menu e() {
        return this.f2070i;
    }

    @Override // b.a.o.b
    public MenuInflater f() {
        return new g(this.f2066e.getContext());
    }

    @Override // b.a.o.b
    public CharSequence g() {
        return this.f2066e.getSubtitle();
    }

    @Override // b.a.o.b
    public CharSequence i() {
        return this.f2066e.getTitle();
    }

    @Override // b.a.o.b
    public void k() {
        this.f2067f.a(this, this.f2070i);
    }

    @Override // b.a.o.b
    public boolean l() {
        return this.f2066e.j();
    }

    @Override // b.a.o.b
    public void m(View view) {
        this.f2066e.setCustomView(view);
        this.f2068g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // b.a.o.b
    public void n(int i2) {
        o(this.f2065d.getString(i2));
    }

    @Override // b.a.o.b
    public void o(CharSequence charSequence) {
        this.f2066e.setSubtitle(charSequence);
    }

    @Override // b.a.o.b
    public void q(int i2) {
        r(this.f2065d.getString(i2));
    }

    @Override // b.a.o.b
    public void r(CharSequence charSequence) {
        this.f2066e.setTitle(charSequence);
    }

    @Override // b.a.o.b
    public void s(boolean z) {
        super.s(z);
        this.f2066e.setTitleOptional(z);
    }
}
