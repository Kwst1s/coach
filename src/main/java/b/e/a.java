package b.e;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: i  reason: collision with root package name */
    f<K, V> f2157i;

    /* access modifiers changed from: package-private */
    /* renamed from: b.e.a$a  reason: collision with other inner class name */
    /* compiled from: ArrayMap */
    public class C0035a extends f<K, V> {
        C0035a() {
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void a() {
            a.this.clear();
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public Object b(int i2, int i3) {
            return a.this.f2206c[(i2 << 1) + i3];
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public Map<K, V> c() {
            return a.this;
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int d() {
            return a.this.f2207d;
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int e(Object obj) {
            return a.this.f(obj);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int f(Object obj) {
            return a.this.h(obj);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void g(K k2, V v) {
            a.this.put(k2, v);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void h(int i2) {
            a.this.k(i2);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public V i(int i2, V v) {
            return (V) a.this.l(i2, v);
        }
    }

    public a() {
    }

    private f<K, V> n() {
        if (this.f2157i == null) {
            this.f2157i = new C0035a();
        }
        return this.f2157i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: b.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f2207d + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }
}
