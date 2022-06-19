package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.w;

/* compiled from: FragmentController */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final j<?> f1274a;

    private h(j<?> jVar) {
        this.f1274a = jVar;
    }

    public static h b(j<?> jVar) {
        b.h.j.h.d(jVar, "callbacks == null");
        return new h(jVar);
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f1274a;
        jVar.f1279e.h(jVar, jVar, fragment);
    }

    public void c() {
        this.f1274a.f1279e.s();
    }

    public void d(Configuration configuration) {
        this.f1274a.f1279e.t(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f1274a.f1279e.u(menuItem);
    }

    public void f() {
        this.f1274a.f1279e.v();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f1274a.f1279e.w(menu, menuInflater);
    }

    public void h() {
        this.f1274a.f1279e.x();
    }

    public void i() {
        this.f1274a.f1279e.z();
    }

    public void j(boolean z) {
        this.f1274a.f1279e.A(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.f1274a.f1279e.B(menuItem);
    }

    public void l(Menu menu) {
        this.f1274a.f1279e.C(menu);
    }

    public void m() {
        this.f1274a.f1279e.E();
    }

    public void n(boolean z) {
        this.f1274a.f1279e.F(z);
    }

    public boolean o(Menu menu) {
        return this.f1274a.f1279e.G(menu);
    }

    public void p() {
        this.f1274a.f1279e.I();
    }

    public void q() {
        this.f1274a.f1279e.J();
    }

    public void r() {
        this.f1274a.f1279e.L();
    }

    public boolean s() {
        return this.f1274a.f1279e.R(true);
    }

    public Fragment t(String str) {
        return this.f1274a.f1279e.Z(str);
    }

    public m u() {
        return this.f1274a.f1279e;
    }

    public void v() {
        this.f1274a.f1279e.F0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1274a.f1279e.j0().onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        j<?> jVar = this.f1274a;
        if (jVar instanceof w) {
            jVar.f1279e.T0(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable y() {
        return this.f1274a.f1279e.V0();
    }
}
