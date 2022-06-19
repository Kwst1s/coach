package androidx.fragment.app;

import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.lifecycle.j;

/* access modifiers changed from: package-private */
/* compiled from: FragmentViewLifecycleOwner */
public class y implements i {

    /* renamed from: b  reason: collision with root package name */
    private j f1426b = null;

    y() {
    }

    /* access modifiers changed from: package-private */
    public void a(e.a aVar) {
        this.f1426b.i(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f1426b == null) {
            this.f1426b = new j(this);
        }
    }

    @Override // androidx.lifecycle.i
    public e c() {
        b();
        return this.f1426b;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f1426b != null;
    }

    /* access modifiers changed from: package-private */
    public void g(e.b bVar) {
        this.f1426b.p(bVar);
    }
}
