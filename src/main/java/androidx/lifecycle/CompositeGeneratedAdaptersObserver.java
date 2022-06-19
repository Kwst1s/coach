package androidx.lifecycle;

import androidx.lifecycle.e;

/* access modifiers changed from: package-private */
public class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    private final d[] f1427a;

    CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f1427a = dVarArr;
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, e.a aVar) {
        m mVar = new m();
        for (d dVar : this.f1427a) {
            dVar.a(iVar, aVar, false, mVar);
        }
        for (d dVar2 : this.f1427a) {
            dVar2.a(iVar, aVar, true, mVar);
        }
    }
}
