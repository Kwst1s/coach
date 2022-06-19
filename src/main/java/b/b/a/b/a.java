package b.b.a.b;

import b.b.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap */
public class a<K, V> extends b<K, V> {

    /* renamed from: f  reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f2113f = new HashMap<>();

    /* access modifiers changed from: protected */
    @Override // b.b.a.b.b
    public b.c<K, V> c(K k2) {
        return this.f2113f.get(k2);
    }

    public boolean contains(K k2) {
        return this.f2113f.containsKey(k2);
    }

    @Override // b.b.a.b.b
    public V g(K k2, V v) {
        b.c<K, V> c2 = c(k2);
        if (c2 != null) {
            return c2.f2119c;
        }
        this.f2113f.put(k2, f(k2, v));
        return null;
    }

    @Override // b.b.a.b.b
    public V h(K k2) {
        V v = (V) super.h(k2);
        this.f2113f.remove(k2);
        return v;
    }

    public Map.Entry<K, V> i(K k2) {
        if (contains(k2)) {
            return this.f2113f.get(k2).f2121e;
        }
        return null;
    }
}
