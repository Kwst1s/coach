package androidx.lifecycle;

import androidx.lifecycle.e;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;

final class SavedStateHandleController implements g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1449a;

    /* renamed from: b  reason: collision with root package name */
    private final s f1450b;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1  reason: invalid class name */
    final class AnonymousClass1 implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f1451a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SavedStateRegistry f1452b;

        @Override // androidx.lifecycle.g
        public void d(i iVar, e.a aVar) {
            if (aVar == e.a.ON_START) {
                this.f1451a.c(this);
                this.f1452b.e(a.class);
            }
        }
    }

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(b bVar) {
            if (bVar instanceof w) {
                v t = ((w) bVar).t();
                SavedStateRegistry f2 = bVar.f();
                for (String str : t.c()) {
                    SavedStateHandleController.h(t.b(str), f2, bVar.c());
                }
                if (!t.c().isEmpty()) {
                    f2.e(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    static void h(t tVar, SavedStateRegistry savedStateRegistry, e eVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) tVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.j()) {
            savedStateHandleController.i(savedStateRegistry, eVar);
            throw null;
        }
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.f1449a = false;
            iVar.c().c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(SavedStateRegistry savedStateRegistry, e eVar) {
        if (this.f1449a) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1449a = true;
        eVar.a(this);
        this.f1450b.a();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f1449a;
    }
}
