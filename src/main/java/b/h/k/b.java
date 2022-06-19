package b.h.k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private AbstractC0047b f2595a;

    /* compiled from: ActionProvider */
    public interface a {
    }

    /* renamed from: b.h.k.b$b  reason: collision with other inner class name */
    /* compiled from: ActionProvider */
    public interface AbstractC0047b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f2595a = null;
    }

    public void i(a aVar) {
    }

    public void j(AbstractC0047b bVar) {
        if (!(this.f2595a == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2595a = bVar;
    }
}
