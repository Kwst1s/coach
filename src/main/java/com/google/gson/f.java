package com.google.gson;

import com.google.gson.u.k;
import com.google.gson.u.m.g;
import com.google.gson.u.m.h;
import com.google.gson.u.m.i;
import com.google.gson.u.m.j;
import com.google.gson.u.m.m;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class f {

    /* renamed from: j  reason: collision with root package name */
    private static final com.google.gson.v.a<?> f8285j = com.google.gson.v.a.a(Object.class);

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.v.a<?>, C0165f<?>>> f8286a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.google.gson.v.a<?>, r<?>> f8287b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.u.c f8288c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.u.m.d f8289d;

    /* renamed from: e  reason: collision with root package name */
    final List<s> f8290e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f8291f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f8292g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f8293h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f8294i;

    /* access modifiers changed from: package-private */
    /* compiled from: Gson */
    public class a extends r<Number> {
        a(f fVar) {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            if (number == null) {
                aVar.P();
                return;
            }
            f.c(number.doubleValue());
            aVar.b0(number);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Gson */
    public class b extends r<Number> {
        b(f fVar) {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            if (number == null) {
                aVar.P();
                return;
            }
            f.c((double) number.floatValue());
            aVar.b0(number);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Gson */
    public class c extends r<Number> {
        c() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            if (number == null) {
                aVar.P();
            } else {
                aVar.c0(number.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Gson */
    public class d extends r<AtomicLong> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f8295a;

        d(r rVar) {
            this.f8295a = rVar;
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, AtomicLong atomicLong) {
            this.f8295a.c(aVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Gson */
    public class e extends r<AtomicLongArray> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f8296a;

        e(r rVar) {
            this.f8296a = rVar;
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, AtomicLongArray atomicLongArray) {
            aVar.F();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f8296a.c(aVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            aVar.I();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.gson.f$f  reason: collision with other inner class name */
    /* compiled from: Gson */
    public static class C0165f<T> extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private r<T> f8297a;

        C0165f() {
        }

        @Override // com.google.gson.r
        public void c(com.google.gson.stream.a aVar, T t) {
            r<T> rVar = this.f8297a;
            if (rVar != null) {
                rVar.c(aVar, t);
                return;
            }
            throw new IllegalStateException();
        }

        public void d(r<T> rVar) {
            if (this.f8297a == null) {
                this.f8297a = rVar;
                return;
            }
            throw new AssertionError();
        }
    }

    f(com.google.gson.u.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, q qVar, String str, int i2, int i3, List<s> list, List<s> list2, List<s> list3) {
        com.google.gson.u.c cVar = new com.google.gson.u.c(map);
        this.f8288c = cVar;
        this.f8291f = z;
        this.f8292g = z3;
        this.f8293h = z4;
        this.f8294i = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(m.Y);
        arrayList.add(g.f8401b);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(m.D);
        arrayList.add(m.m);
        arrayList.add(m.f8436g);
        arrayList.add(m.f8438i);
        arrayList.add(m.f8440k);
        r<Number> i4 = i(qVar);
        arrayList.add(m.b(Long.TYPE, Long.class, i4));
        arrayList.add(m.b(Double.TYPE, Double.class, d(z7)));
        arrayList.add(m.b(Float.TYPE, Float.class, e(z7)));
        arrayList.add(m.x);
        arrayList.add(m.o);
        arrayList.add(m.q);
        arrayList.add(m.a(AtomicLong.class, a(i4)));
        arrayList.add(m.a(AtomicLongArray.class, b(i4)));
        arrayList.add(m.s);
        arrayList.add(m.z);
        arrayList.add(m.F);
        arrayList.add(m.H);
        arrayList.add(m.a(BigDecimal.class, m.B));
        arrayList.add(m.a(BigInteger.class, m.C));
        arrayList.add(m.J);
        arrayList.add(m.L);
        arrayList.add(m.P);
        arrayList.add(m.R);
        arrayList.add(m.W);
        arrayList.add(m.N);
        arrayList.add(m.f8433d);
        arrayList.add(com.google.gson.u.m.c.f8393b);
        arrayList.add(m.U);
        arrayList.add(j.f8418b);
        arrayList.add(i.f8416b);
        arrayList.add(m.S);
        arrayList.add(com.google.gson.u.m.a.f8389b);
        arrayList.add(m.f8431b);
        arrayList.add(new com.google.gson.u.m.b(cVar));
        arrayList.add(new com.google.gson.u.m.f(cVar, z2));
        com.google.gson.u.m.d dVar2 = new com.google.gson.u.m.d(cVar);
        this.f8289d = dVar2;
        arrayList.add(dVar2);
        arrayList.add(m.Z);
        arrayList.add(new h(cVar, eVar, dVar, dVar2));
        this.f8290e = Collections.unmodifiableList(arrayList);
    }

    private static r<AtomicLong> a(r<Number> rVar) {
        return new d(rVar).a();
    }

    private static r<AtomicLongArray> b(r<Number> rVar) {
        return new e(rVar).a();
    }

    static void c(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private r<Number> d(boolean z) {
        if (z) {
            return m.v;
        }
        return new a(this);
    }

    private r<Number> e(boolean z) {
        if (z) {
            return m.u;
        }
        return new b(this);
    }

    private static r<Number> i(q qVar) {
        if (qVar == q.DEFAULT) {
            return m.t;
        }
        return new c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<com.google.gson.v.a<?>, com.google.gson.r<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: com.google.gson.r<T>, com.google.gson.r<?> */
    public <T> r<T> f(com.google.gson.v.a<T> aVar) {
        r<T> rVar = (r<T>) this.f8287b.get(aVar == null ? f8285j : aVar);
        if (rVar != null) {
            return rVar;
        }
        Map<com.google.gson.v.a<?>, C0165f<?>> map = this.f8286a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f8286a.set(map);
            z = true;
        }
        C0165f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            C0165f<?> fVar2 = new C0165f<>();
            map.put(aVar, fVar2);
            for (s sVar : this.f8290e) {
                r rVar2 = (r<T>) sVar.a(this, aVar);
                if (rVar2 != null) {
                    fVar2.d(rVar2);
                    this.f8287b.put(aVar, rVar2);
                    return rVar2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f8286a.remove();
            }
        }
    }

    public <T> r<T> g(Class<T> cls) {
        return f(com.google.gson.v.a.a(cls));
    }

    public <T> r<T> h(s sVar, com.google.gson.v.a<T> aVar) {
        if (!this.f8290e.contains(sVar)) {
            sVar = this.f8289d;
        }
        boolean z = false;
        for (s sVar2 : this.f8290e) {
            if (z) {
                r<T> a2 = sVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (sVar2 == sVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.stream.a j(Writer writer) {
        if (this.f8292g) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(writer);
        if (this.f8294i) {
            aVar.V("  ");
        }
        aVar.X(this.f8291f);
        return aVar;
    }

    public String k(k kVar) {
        StringWriter stringWriter = new StringWriter();
        o(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String l(Object obj) {
        if (obj == null) {
            return k(l.f8310a);
        }
        return m(obj, obj.getClass());
    }

    public String m(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        q(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void n(k kVar, com.google.gson.stream.a aVar) {
        boolean M = aVar.M();
        aVar.W(true);
        boolean L = aVar.L();
        aVar.U(this.f8293h);
        boolean K = aVar.K();
        aVar.X(this.f8291f);
        try {
            k.a(kVar, aVar);
            aVar.W(M);
            aVar.U(L);
            aVar.X(K);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            aVar.W(M);
            aVar.U(L);
            aVar.X(K);
            throw th;
        }
    }

    public void o(k kVar, Appendable appendable) {
        try {
            n(kVar, j(k.b(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void p(Object obj, Type type, com.google.gson.stream.a aVar) {
        r f2 = f(com.google.gson.v.a.b(type));
        boolean M = aVar.M();
        aVar.W(true);
        boolean L = aVar.L();
        aVar.U(this.f8293h);
        boolean K = aVar.K();
        aVar.X(this.f8291f);
        try {
            f2.c(aVar, obj);
            aVar.W(M);
            aVar.U(L);
            aVar.X(K);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            aVar.W(M);
            aVar.U(L);
            aVar.X(K);
            throw th;
        }
    }

    public void q(Object obj, Type type, Appendable appendable) {
        try {
            p(obj, type, j(k.b(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f8291f + ",factories:" + this.f8290e + ",instanceCreators:" + this.f8288c + "}";
    }
}
