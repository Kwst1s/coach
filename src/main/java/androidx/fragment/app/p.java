package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: FragmentManagerViewModel */
public final class p extends t {

    /* renamed from: h  reason: collision with root package name */
    private static final u.a f1315h = new a();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Fragment> f1316b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, p> f1317c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, v> f1318d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1319e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1320f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1321g = false;

    /* compiled from: FragmentManagerViewModel */
    static class a implements u.a {
        a() {
        }

        @Override // androidx.lifecycle.u.a
        public <T extends t> T a(Class<T> cls) {
            return new p(true);
        }
    }

    p(boolean z) {
        this.f1319e = z;
    }

    static p i(v vVar) {
        return (p) new u(vVar, f1315h).a(p.class);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.lifecycle.t
    public void d() {
        if (m.s0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1320f = true;
    }

    /* access modifiers changed from: package-private */
    public boolean e(Fragment fragment) {
        if (this.f1316b.containsKey(fragment.f1214f)) {
            return false;
        }
        this.f1316b.put(fragment.f1214f, fragment);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (!this.f1316b.equals(pVar.f1316b) || !this.f1317c.equals(pVar.f1317c) || !this.f1318d.equals(pVar.f1318d)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (m.s0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        p pVar = this.f1317c.get(fragment.f1214f);
        if (pVar != null) {
            pVar.d();
            this.f1317c.remove(fragment.f1214f);
        }
        v vVar = this.f1318d.get(fragment.f1214f);
        if (vVar != null) {
            vVar.a();
            this.f1318d.remove(fragment.f1214f);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment g(String str) {
        return this.f1316b.get(str);
    }

    /* access modifiers changed from: package-private */
    public p h(Fragment fragment) {
        p pVar = this.f1317c.get(fragment.f1214f);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this.f1319e);
        this.f1317c.put(fragment.f1214f, pVar2);
        return pVar2;
    }

    public int hashCode() {
        return (((this.f1316b.hashCode() * 31) + this.f1317c.hashCode()) * 31) + this.f1318d.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> j() {
        return this.f1316b.values();
    }

    /* access modifiers changed from: package-private */
    public v k(Fragment fragment) {
        v vVar = this.f1318d.get(fragment.f1214f);
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v();
        this.f1318d.put(fragment.f1214f, vVar2);
        return vVar2;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f1320f;
    }

    /* access modifiers changed from: package-private */
    public boolean m(Fragment fragment) {
        return this.f1316b.remove(fragment.f1214f) != null;
    }

    /* access modifiers changed from: package-private */
    public boolean n(Fragment fragment) {
        if (!this.f1316b.containsKey(fragment.f1214f)) {
            return true;
        }
        if (this.f1319e) {
            return this.f1320f;
        }
        return !this.f1321g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1316b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1317c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1318d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
