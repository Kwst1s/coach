package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ViewModelStore */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, t> f1496a = new HashMap<>();

    public final void a() {
        for (t tVar : this.f1496a.values()) {
            tVar.a();
        }
        this.f1496a.clear();
    }

    /* access modifiers changed from: package-private */
    public final t b(String str) {
        return this.f1496a.get(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f1496a.keySet());
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, t tVar) {
        t put = this.f1496a.put(str, tVar);
        if (put != null) {
            put.d();
        }
    }
}
