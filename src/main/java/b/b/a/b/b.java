package b.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    c<K, V> f2114b;

    /* renamed from: c  reason: collision with root package name */
    private c<K, V> f2115c;

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2116d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private int f2117e = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // b.b.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f2121e;
        }

        /* access modifiers changed from: package-private */
        @Override // b.b.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f2120d;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b.b.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    public static class C0033b<K, V> extends e<K, V> {
        C0033b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // b.b.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f2120d;
        }

        /* access modifiers changed from: package-private */
        @Override // b.b.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f2121e;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final K f2118b;

        /* renamed from: c  reason: collision with root package name */
        final V f2119c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f2120d;

        /* renamed from: e  reason: collision with root package name */
        c<K, V> f2121e;

        c(K k2, V v) {
            this.f2118b = k2;
            this.f2119c = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f2118b.equals(cVar.f2118b) || !this.f2119c.equals(cVar.f2119c)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2118b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2119c;
        }

        public int hashCode() {
            return this.f2118b.hashCode() ^ this.f2119c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return ((Object) this.f2118b) + "=" + ((Object) this.f2119c);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: SafeIterableMap */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f2122b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2123c = true;

        d() {
        }

        @Override // b.b.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2122b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2121e;
                this.f2122b = cVar3;
                this.f2123c = cVar3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.f2123c) {
                this.f2123c = false;
                this.f2122b = b.this.f2114b;
            } else {
                c<K, V> cVar = this.f2122b;
                this.f2122b = cVar != null ? cVar.f2120d : null;
            }
            return this.f2122b;
        }

        public boolean hasNext() {
            if (!this.f2123c) {
                c<K, V> cVar = this.f2122b;
                if (cVar == null || cVar.f2120d == null) {
                    return false;
                }
                return true;
            } else if (b.this.f2114b != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f2125b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f2126c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2125b = cVar2;
            this.f2126c = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f2126c;
            c<K, V> cVar2 = this.f2125b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // b.b.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f2125b == cVar && cVar == this.f2126c) {
                this.f2126c = null;
                this.f2125b = null;
            }
            c<K, V> cVar2 = this.f2125b;
            if (cVar2 == cVar) {
                this.f2125b = b(cVar2);
            }
            if (this.f2126c == cVar) {
                this.f2126c = e();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2126c;
            this.f2126c = e();
            return cVar;
        }

        public boolean hasNext() {
            return this.f2126c != null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0033b bVar = new C0033b(this.f2115c, this.f2114b);
        this.f2116d.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public Map.Entry<K, V> b() {
        return this.f2114b;
    }

    /* access modifiers changed from: protected */
    public c<K, V> c(K k2) {
        c<K, V> cVar = this.f2114b;
        while (cVar != null && !cVar.f2118b.equals(k2)) {
            cVar = cVar.f2120d;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f2116d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f2115c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public c<K, V> f(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.f2117e++;
        c<K, V> cVar2 = this.f2115c;
        if (cVar2 == null) {
            this.f2114b = cVar;
            this.f2115c = cVar;
            return cVar;
        }
        cVar2.f2120d = cVar;
        cVar.f2121e = cVar2;
        this.f2115c = cVar;
        return cVar;
    }

    public V g(K k2, V v) {
        c<K, V> c2 = c(k2);
        if (c2 != null) {
            return c2.f2119c;
        }
        f(k2, v);
        return null;
    }

    public V h(K k2) {
        c<K, V> c2 = c(k2);
        if (c2 == null) {
            return null;
        }
        this.f2117e--;
        if (!this.f2116d.isEmpty()) {
            for (f<K, V> fVar : this.f2116d.keySet()) {
                fVar.a(c2);
            }
        }
        c<K, V> cVar = c2.f2121e;
        if (cVar != null) {
            cVar.f2120d = c2.f2120d;
        } else {
            this.f2114b = c2.f2120d;
        }
        c<K, V> cVar2 = c2.f2120d;
        if (cVar2 != null) {
            cVar2.f2121e = cVar;
        } else {
            this.f2115c = cVar;
        }
        c2.f2120d = null;
        c2.f2121e = null;
        return c2.f2119c;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().hashCode();
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2114b, this.f2115c);
        this.f2116d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f2117e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
