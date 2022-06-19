package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: a  reason: collision with root package name */
    private b.b.a.b.b<String, b> f1842a = new b.b.a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f1843b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1844c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f1845d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1846e = true;

    public interface a {
        void a(b bVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (this.f1844c) {
            Bundle bundle = this.f1843b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f1843b.remove(str);
            if (this.f1843b.isEmpty()) {
                this.f1843b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void b(e eVar, Bundle bundle) {
        if (!this.f1844c) {
            if (bundle != null) {
                this.f1843b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            eVar.a(new g() {
                /* class androidx.savedstate.SavedStateRegistry.AnonymousClass1 */

                @Override // androidx.lifecycle.g
                public void d(i iVar, e.a aVar) {
                    if (aVar == e.a.ON_START) {
                        SavedStateRegistry.this.f1846e = true;
                    } else if (aVar == e.a.ON_STOP) {
                        SavedStateRegistry.this.f1846e = false;
                    }
                }
            });
            this.f1844c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f1843b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.b.a.b.b<K, V>.d d2 = this.f1842a.d();
        while (d2.hasNext()) {
            Map.Entry entry = (Map.Entry) d2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f1842a.g(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (this.f1846e) {
            if (this.f1845d == null) {
                this.f1845d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f1845d.b(cls.getName());
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
