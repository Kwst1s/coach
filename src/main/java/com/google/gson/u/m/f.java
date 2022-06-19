package com.google.gson.u.m;

import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u.b;
import com.google.gson.u.c;
import com.google.gson.u.h;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory */
public final class f implements s {

    /* renamed from: b  reason: collision with root package name */
    private final c f8396b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f8397c;

    /* compiled from: MapTypeAdapterFactory */
    private final class a<K, V> extends r<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final r<K> f8398a;

        /* renamed from: b  reason: collision with root package name */
        private final r<V> f8399b;

        public a(com.google.gson.f fVar, Type type, r<K> rVar, Type type2, r<V> rVar2, h<? extends Map<K, V>> hVar) {
            this.f8398a = new l(fVar, rVar, type);
            this.f8399b = new l(fVar, rVar2, type2);
        }

        private String d(k kVar) {
            if (kVar.g()) {
                n c2 = kVar.c();
                if (c2.m()) {
                    return String.valueOf(c2.i());
                }
                if (c2.k()) {
                    return Boolean.toString(c2.h());
                }
                if (c2.n()) {
                    return c2.j();
                }
                throw new AssertionError();
            } else if (kVar.e()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.google.gson.r<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.google.gson.r<V> */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: e */
        public void c(com.google.gson.stream.a aVar, Map<K, V> map) {
            if (map == null) {
                aVar.P();
            } else if (!f.this.f8397c) {
                aVar.G();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    aVar.N(String.valueOf(entry.getKey()));
                    this.f8399b.c(aVar, entry.getValue());
                }
                aVar.J();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    k b2 = this.f8398a.b(entry2.getKey());
                    arrayList.add(b2);
                    arrayList2.add(entry2.getValue());
                    z |= b2.d() || b2.f();
                }
                if (z) {
                    aVar.F();
                    int size = arrayList.size();
                    while (i2 < size) {
                        aVar.F();
                        com.google.gson.u.k.a((k) arrayList.get(i2), aVar);
                        this.f8399b.c(aVar, arrayList2.get(i2));
                        aVar.I();
                        i2++;
                    }
                    aVar.I();
                    return;
                }
                aVar.G();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    aVar.N(d((k) arrayList.get(i2)));
                    this.f8399b.c(aVar, arrayList2.get(i2));
                    i2++;
                }
                aVar.J();
            }
        }
    }

    public f(c cVar, boolean z) {
        this.f8396b = cVar;
        this.f8397c = z;
    }

    private r<?> b(com.google.gson.f fVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return m.f8435f;
        }
        return fVar.f(com.google.gson.v.a.b(type));
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        Type e2 = aVar.e();
        if (!Map.class.isAssignableFrom(aVar.c())) {
            return null;
        }
        Type[] j2 = b.j(e2, b.k(e2));
        return new a(fVar, j2[0], b(fVar, j2[0]), j2[1], fVar.f(com.google.gson.v.a.b(j2[1])), this.f8396b.a(aVar));
    }
}
