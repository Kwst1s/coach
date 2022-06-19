package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* access modifiers changed from: package-private */
/* compiled from: FragmentLifecycleCallbacksDispatcher */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f1281a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final m f1282b;

    /* access modifiers changed from: private */
    /* compiled from: FragmentLifecycleCallbacksDispatcher */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final m.g f1283a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f1284b;
    }

    l(m mVar) {
        this.f1282b = mVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.a(this.f1282b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Context context, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().b(fragment, context, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.b(this.f1282b, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.c(this.f1282b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().d(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.d(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().e(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.e(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().f(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.f(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, Context context, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().g(fragment, context, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.g(this.f1282b, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.h(this.f1282b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().i(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.i(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.j(this.f1282b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().k(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.k(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().l(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.l(this.f1282b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.m(this.f1282b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z) {
        Fragment l0 = this.f1282b.l0();
        if (l0 != null) {
            l0.I().k0().n(fragment, true);
        }
        Iterator<a> it = this.f1281a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1284b) {
                next.f1283a.n(this.f1282b, fragment);
            }
        }
    }
}
