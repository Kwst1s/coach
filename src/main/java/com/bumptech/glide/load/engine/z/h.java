package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.load.engine.z.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: GroupedLinkedMap */
public class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f3887a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f3888b = new HashMap();

    /* access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f3889a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f3890b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f3891c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f3892d;

        a() {
            this(null);
        }

        public void a(V v) {
            if (this.f3890b == null) {
                this.f3890b = new ArrayList();
            }
            this.f3890b.add(v);
        }

        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.f3890b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f3890b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f3892d = this;
            this.f3891c = this;
            this.f3889a = k2;
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f3887a;
        aVar.f3892d = aVar2;
        aVar.f3891c = aVar2.f3891c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f3887a;
        aVar.f3892d = aVar2.f3892d;
        aVar.f3891c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f3892d;
        aVar2.f3891c = aVar.f3891c;
        aVar.f3891c.f3892d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f3891c.f3892d = aVar;
        aVar.f3892d.f3891c = aVar;
    }

    public V a(K k2) {
        a<K, V> aVar = this.f3888b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.f3888b.put(k2, aVar);
        } else {
            k2.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k2, V v) {
        a<K, V> aVar = this.f3888b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            c(aVar);
            this.f3888b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v);
    }

    public V f() {
        for (a<K, V> aVar = this.f3887a.f3892d; !aVar.equals(this.f3887a); aVar = aVar.f3892d) {
            V b2 = aVar.b();
            if (b2 != null) {
                return b2;
            }
            e(aVar);
            this.f3888b.remove(aVar.f3889a);
            aVar.f3889a.a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f3887a.f3891c; !aVar.equals(this.f3887a); aVar = aVar.f3891c) {
            z = true;
            sb.append('{');
            sb.append((Object) aVar.f3889a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
