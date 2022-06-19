package com.google.gson.u;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedTreeMap */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Comparable> f8359i = new a();

    /* renamed from: b  reason: collision with root package name */
    Comparator<? super K> f8360b;

    /* renamed from: c  reason: collision with root package name */
    e<K, V> f8361c;

    /* renamed from: d  reason: collision with root package name */
    int f8362d;

    /* renamed from: e  reason: collision with root package name */
    int f8363e;

    /* renamed from: f  reason: collision with root package name */
    final e<K, V> f8364f;

    /* renamed from: g  reason: collision with root package name */
    private g<K, V>.b f8365g;

    /* renamed from: h  reason: collision with root package name */
    private g<K, V>.c f8366h;

    /* compiled from: LinkedTreeMap */
    class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap */
        class a extends g<K, V>.d {
            a(b bVar) {
                super();
            }

            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.d((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            e<K, V> d2;
            if (!(obj instanceof Map.Entry) || (d2 = g.this.d((Map.Entry) obj)) == null) {
                return false;
            }
            g.this.g(d2, true);
            return true;
        }

        public int size() {
            return g.this.f8362d;
        }
    }

    /* compiled from: LinkedTreeMap */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap */
        class a extends g<K, V>.d {
            a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f8378g;
            }
        }

        c() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            return g.this.h(obj) != null;
        }

        public int size() {
            return g.this.f8362d;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: LinkedTreeMap */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f8369b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f8370c = null;

        /* renamed from: d  reason: collision with root package name */
        int f8371d;

        d() {
            this.f8369b = g.this.f8364f.f8376e;
            this.f8371d = g.this.f8363e;
        }

        /* access modifiers changed from: package-private */
        public final e<K, V> a() {
            e<K, V> eVar = this.f8369b;
            g gVar = g.this;
            if (eVar == gVar.f8364f) {
                throw new NoSuchElementException();
            } else if (gVar.f8363e == this.f8371d) {
                this.f8369b = eVar.f8376e;
                this.f8370c = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f8369b != g.this.f8364f;
        }

        public final void remove() {
            e<K, V> eVar = this.f8370c;
            if (eVar != null) {
                g.this.g(eVar, true);
                this.f8370c = null;
                this.f8371d = g.this.f8363e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public g() {
        this(f8359i);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void f(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f8374c;
            e<K, V> eVar3 = eVar.f8375d;
            int i2 = 0;
            int i3 = eVar2 != null ? eVar2.f8380i : 0;
            int i4 = eVar3 != null ? eVar3.f8380i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                e<K, V> eVar4 = eVar3.f8374c;
                e<K, V> eVar5 = eVar3.f8375d;
                int i6 = eVar5 != null ? eVar5.f8380i : 0;
                if (eVar4 != null) {
                    i2 = eVar4.f8380i;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                e<K, V> eVar6 = eVar2.f8374c;
                e<K, V> eVar7 = eVar2.f8375d;
                int i8 = eVar7 != null ? eVar7.f8380i : 0;
                if (eVar6 != null) {
                    i2 = eVar6.f8380i;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                eVar.f8380i = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f8380i = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f8373b;
        }
    }

    private void i(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f8373b;
        eVar.f8373b = null;
        if (eVar2 != null) {
            eVar2.f8373b = eVar3;
        }
        if (eVar3 == null) {
            this.f8361c = eVar2;
        } else if (eVar3.f8374c == eVar) {
            eVar3.f8374c = eVar2;
        } else {
            eVar3.f8375d = eVar2;
        }
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8374c;
        e<K, V> eVar3 = eVar.f8375d;
        e<K, V> eVar4 = eVar3.f8374c;
        e<K, V> eVar5 = eVar3.f8375d;
        eVar.f8375d = eVar4;
        if (eVar4 != null) {
            eVar4.f8373b = eVar;
        }
        i(eVar, eVar3);
        eVar3.f8374c = eVar;
        eVar.f8373b = eVar3;
        int i2 = 0;
        int max = Math.max(eVar2 != null ? eVar2.f8380i : 0, eVar4 != null ? eVar4.f8380i : 0) + 1;
        eVar.f8380i = max;
        if (eVar5 != null) {
            i2 = eVar5.f8380i;
        }
        eVar3.f8380i = Math.max(max, i2) + 1;
    }

    private void k(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8374c;
        e<K, V> eVar3 = eVar.f8375d;
        e<K, V> eVar4 = eVar2.f8374c;
        e<K, V> eVar5 = eVar2.f8375d;
        eVar.f8374c = eVar5;
        if (eVar5 != null) {
            eVar5.f8373b = eVar;
        }
        i(eVar, eVar2);
        eVar2.f8375d = eVar;
        eVar.f8373b = eVar2;
        int i2 = 0;
        int max = Math.max(eVar3 != null ? eVar3.f8380i : 0, eVar5 != null ? eVar5.f8380i : 0) + 1;
        eVar.f8380i = max;
        if (eVar4 != null) {
            i2 = eVar4.f8380i;
        }
        eVar2.f8380i = Math.max(max, i2) + 1;
    }

    /* access modifiers changed from: package-private */
    public e<K, V> c(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f8360b;
        e<K, V> eVar2 = this.f8361c;
        if (eVar2 != null) {
            K k3 = comparator == f8359i ? k2 : null;
            while (true) {
                if (k3 != null) {
                    i2 = k3.compareTo(eVar2.f8378g);
                } else {
                    i2 = comparator.compare(k2, eVar2.f8378g);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f8374c : eVar2.f8375d;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.f8364f;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k2, eVar4, eVar4.f8377f);
            if (i2 < 0) {
                eVar2.f8374c = eVar;
            } else {
                eVar2.f8375d = eVar;
            }
            f(eVar2, true);
        } else if (comparator != f8359i || (k2 instanceof Comparable)) {
            eVar = new e<>(eVar2, k2, eVar4, eVar4.f8377f);
            this.f8361c = eVar;
        } else {
            throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
        }
        this.f8362d++;
        this.f8363e++;
        return eVar;
    }

    public void clear() {
        this.f8361c = null;
        this.f8362d = 0;
        this.f8363e++;
        e<K, V> eVar = this.f8364f;
        eVar.f8377f = eVar;
        eVar.f8376e = eVar;
    }

    public boolean containsKey(Object obj) {
        return e(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public e<K, V> d(Map.Entry<?, ?> entry) {
        e<K, V> e2 = e(entry.getKey());
        if (e2 != null && a(e2.f8379h, entry.getValue())) {
            return e2;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public e<K, V> e(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return c(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b bVar = this.f8365g;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.f8365g = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public void g(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f8377f;
            eVar2.f8376e = eVar.f8376e;
            eVar.f8376e.f8377f = eVar2;
        }
        e<K, V> eVar3 = eVar.f8374c;
        e<K, V> eVar4 = eVar.f8375d;
        e<K, V> eVar5 = eVar.f8373b;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f8374c = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f8375d = null;
            } else {
                i(eVar, null);
            }
            f(eVar5, false);
            this.f8362d--;
            this.f8363e++;
            return;
        }
        e<K, V> b2 = eVar3.f8380i > eVar4.f8380i ? eVar3.b() : eVar4.a();
        g(b2, false);
        e<K, V> eVar6 = eVar.f8374c;
        if (eVar6 != null) {
            i2 = eVar6.f8380i;
            b2.f8374c = eVar6;
            eVar6.f8373b = b2;
            eVar.f8374c = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f8375d;
        if (eVar7 != null) {
            i3 = eVar7.f8380i;
            b2.f8375d = eVar7;
            eVar7.f8373b = b2;
            eVar.f8375d = null;
        }
        b2.f8380i = Math.max(i2, i3) + 1;
        i(eVar, b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> e2 = e(obj);
        if (e2 != null) {
            return e2.f8379h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public e<K, V> h(Object obj) {
        e<K, V> e2 = e(obj);
        if (e2 != null) {
            g(e2, true);
        }
        return e2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c cVar = this.f8366h;
        if (cVar != null) {
            return cVar;
        }
        g<K, V>.c cVar2 = new c();
        this.f8366h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        Objects.requireNonNull(k2, "key == null");
        e<K, V> c2 = c(k2, true);
        V v2 = c2.f8379h;
        c2.f8379h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h2 = h(obj);
        if (h2 != null) {
            return h2.f8379h;
        }
        return null;
    }

    public int size() {
        return this.f8362d;
    }

    public g(Comparator<? super K> comparator) {
        this.f8362d = 0;
        this.f8363e = 0;
        this.f8364f = new e<>();
        this.f8360b = comparator == null ? f8359i : comparator;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f8373b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f8374c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f8375d;

        /* renamed from: e  reason: collision with root package name */
        e<K, V> f8376e;

        /* renamed from: f  reason: collision with root package name */
        e<K, V> f8377f;

        /* renamed from: g  reason: collision with root package name */
        final K f8378g;

        /* renamed from: h  reason: collision with root package name */
        V f8379h;

        /* renamed from: i  reason: collision with root package name */
        int f8380i;

        e() {
            this.f8378g = null;
            this.f8377f = this;
            this.f8376e = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f8374c; eVar2 != null; eVar2 = eVar2.f8374c) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f8375d; eVar2 != null; eVar2 = eVar2.f8375d) {
                eVar = eVar2;
            }
            return eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f8378g
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f8379h
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.u.g.e.equals(java.lang.Object):boolean");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f8378g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f8379h;
        }

        public int hashCode() {
            K k2 = this.f8378g;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f8379h;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f8379h;
            this.f8379h = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f8378g) + "=" + ((Object) this.f8379h);
        }

        e(e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.f8373b = eVar;
            this.f8378g = k2;
            this.f8380i = 1;
            this.f8376e = eVar2;
            this.f8377f = eVar3;
            eVar3.f8376e = this;
            eVar2.f8377f = this;
        }
    }
}
