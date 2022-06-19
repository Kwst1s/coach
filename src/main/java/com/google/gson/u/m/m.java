package com.google.gson.u.m;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
public final class m {
    public static final com.google.gson.r<String> A;
    public static final com.google.gson.r<BigDecimal> B = new h();
    public static final com.google.gson.r<BigInteger> C = new i();
    public static final com.google.gson.s D;
    public static final com.google.gson.r<StringBuilder> E;
    public static final com.google.gson.s F;
    public static final com.google.gson.r<StringBuffer> G;
    public static final com.google.gson.s H;
    public static final com.google.gson.r<URL> I;
    public static final com.google.gson.s J;
    public static final com.google.gson.r<URI> K;
    public static final com.google.gson.s L;
    public static final com.google.gson.r<InetAddress> M;
    public static final com.google.gson.s N;
    public static final com.google.gson.r<UUID> O;
    public static final com.google.gson.s P;
    public static final com.google.gson.r<Currency> Q;
    public static final com.google.gson.s R;
    public static final com.google.gson.s S = new r();
    public static final com.google.gson.r<Calendar> T;
    public static final com.google.gson.s U;
    public static final com.google.gson.r<Locale> V;
    public static final com.google.gson.s W;
    public static final com.google.gson.r<com.google.gson.k> X;
    public static final com.google.gson.s Y;
    public static final com.google.gson.s Z = new w();

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.r<Class> f8430a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.gson.s f8431b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.gson.r<BitSet> f8432c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.s f8433d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.r<Boolean> f8434e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.r<Boolean> f8435f = new c0();

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.s f8436g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.r<Number> f8437h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.s f8438i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.r<Number> f8439j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.s f8440k;
    public static final com.google.gson.r<Number> l;
    public static final com.google.gson.s m;
    public static final com.google.gson.r<AtomicInteger> n;
    public static final com.google.gson.s o;
    public static final com.google.gson.r<AtomicBoolean> p;
    public static final com.google.gson.s q;
    public static final com.google.gson.r<AtomicIntegerArray> r;
    public static final com.google.gson.s s;
    public static final com.google.gson.r<Number> t = new b();
    public static final com.google.gson.r<Number> u = new c();
    public static final com.google.gson.r<Number> v = new d();
    public static final com.google.gson.r<Number> w;
    public static final com.google.gson.s x;
    public static final com.google.gson.r<Character> y;
    public static final com.google.gson.s z;

    /* compiled from: TypeAdapters */
    class a extends com.google.gson.r<AtomicIntegerArray> {
        a() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, AtomicIntegerArray atomicIntegerArray) {
            aVar.F();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                aVar.Z((long) atomicIntegerArray.get(i2));
            }
            aVar.I();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TypeAdapters */
    public class a0 implements com.google.gson.s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f8441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.r f8442c;

        /* compiled from: TypeAdapters */
        class a extends com.google.gson.r<T1> {
            a(Class cls) {
            }

            @Override // com.google.gson.r
            public void c(com.google.gson.stream.a aVar, T1 t1) {
                a0.this.f8442c.c(aVar, t1);
            }
        }

        a0(Class cls, com.google.gson.r rVar) {
            this.f8441b = cls;
            this.f8442c = rVar;
        }

        @Override // com.google.gson.s
        public <T2> com.google.gson.r<T2> a(com.google.gson.f fVar, com.google.gson.v.a<T2> aVar) {
            Class<? super T2> c2 = aVar.c();
            if (!this.f8441b.isAssignableFrom(c2)) {
                return null;
            }
            return new a(c2);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f8441b.getName() + ",adapter=" + this.f8442c + "]";
        }
    }

    /* compiled from: TypeAdapters */
    class b extends com.google.gson.r<Number> {
        b() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class b0 extends com.google.gson.r<Boolean> {
        b0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Boolean bool) {
            aVar.a0(bool);
        }
    }

    /* compiled from: TypeAdapters */
    class c extends com.google.gson.r<Number> {
        c() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class c0 extends com.google.gson.r<Boolean> {
        c0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Boolean bool) {
            aVar.c0(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters */
    class d extends com.google.gson.r<Number> {
        d() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class d0 extends com.google.gson.r<Number> {
        d0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class e extends com.google.gson.r<Number> {
        e() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class e0 extends com.google.gson.r<Number> {
        e0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class f extends com.google.gson.r<Character> {
        f() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Character ch) {
            aVar.c0(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters */
    class f0 extends com.google.gson.r<Number> {
        f0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Number number) {
            aVar.b0(number);
        }
    }

    /* compiled from: TypeAdapters */
    class g extends com.google.gson.r<String> {
        g() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, String str) {
            aVar.c0(str);
        }
    }

    /* compiled from: TypeAdapters */
    class g0 extends com.google.gson.r<AtomicInteger> {
        g0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, AtomicInteger atomicInteger) {
            aVar.Z((long) atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters */
    class h extends com.google.gson.r<BigDecimal> {
        h() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, BigDecimal bigDecimal) {
            aVar.b0(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters */
    class h0 extends com.google.gson.r<AtomicBoolean> {
        h0() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, AtomicBoolean atomicBoolean) {
            aVar.d0(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters */
    class i extends com.google.gson.r<BigInteger> {
        i() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, BigInteger bigInteger) {
            aVar.b0(bigInteger);
        }
    }

    /* compiled from: TypeAdapters */
    private static final class i0<T extends Enum<T>> extends com.google.gson.r<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f8444a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f8445b = new HashMap();

        public i0(Class<T> cls) {
            try {
                T[] enumConstants = cls.getEnumConstants();
                for (T t : enumConstants) {
                    String name = t.name();
                    com.google.gson.t.c cVar = (com.google.gson.t.c) cls.getField(name).getAnnotation(com.google.gson.t.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f8444a.put(str, t);
                        }
                    }
                    this.f8444a.put(name, t);
                    this.f8445b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, T t) {
            aVar.c0(t == null ? null : this.f8445b.get(t));
        }
    }

    /* compiled from: TypeAdapters */
    class j extends com.google.gson.r<StringBuilder> {
        j() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, StringBuilder sb) {
            aVar.c0(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters */
    class k extends com.google.gson.r<Class> {
        k() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.a, java.lang.Object] */
        @Override // com.google.gson.r
        public /* bridge */ /* synthetic */ void c(com.google.gson.stream.a aVar, Class cls) {
            d(aVar, cls);
            throw null;
        }

        public void d(com.google.gson.stream.a aVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters */
    class l extends com.google.gson.r<StringBuffer> {
        l() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, StringBuffer stringBuffer) {
            aVar.c0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: com.google.gson.u.m.m$m  reason: collision with other inner class name */
    /* compiled from: TypeAdapters */
    class C0170m extends com.google.gson.r<URL> {
        C0170m() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, URL url) {
            aVar.c0(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters */
    class n extends com.google.gson.r<URI> {
        n() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, URI uri) {
            aVar.c0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters */
    class o extends com.google.gson.r<InetAddress> {
        o() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, InetAddress inetAddress) {
            aVar.c0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters */
    class p extends com.google.gson.r<UUID> {
        p() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, UUID uuid) {
            aVar.c0(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters */
    class q extends com.google.gson.r<Currency> {
        q() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Currency currency) {
            aVar.c0(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters */
    class r implements com.google.gson.s {

        /* compiled from: TypeAdapters */
        class a extends com.google.gson.r<Timestamp> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.gson.r f8446a;

            a(r rVar, com.google.gson.r rVar2) {
                this.f8446a = rVar2;
            }

            /* renamed from: d */
            public void c(com.google.gson.stream.a aVar, Timestamp timestamp) {
                this.f8446a.c(aVar, timestamp);
            }
        }

        r() {
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() != Timestamp.class) {
                return null;
            }
            return new a(this, fVar.g(Date.class));
        }
    }

    /* compiled from: TypeAdapters */
    class s extends com.google.gson.r<Calendar> {
        s() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Calendar calendar) {
            if (calendar == null) {
                aVar.P();
                return;
            }
            aVar.G();
            aVar.N("year");
            aVar.Z((long) calendar.get(1));
            aVar.N("month");
            aVar.Z((long) calendar.get(2));
            aVar.N("dayOfMonth");
            aVar.Z((long) calendar.get(5));
            aVar.N("hourOfDay");
            aVar.Z((long) calendar.get(11));
            aVar.N("minute");
            aVar.Z((long) calendar.get(12));
            aVar.N("second");
            aVar.Z((long) calendar.get(13));
            aVar.J();
        }
    }

    /* compiled from: TypeAdapters */
    class t extends com.google.gson.r<Locale> {
        t() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Locale locale) {
            aVar.c0(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters */
    class u extends com.google.gson.r<com.google.gson.k> {
        u() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, com.google.gson.k kVar) {
            if (kVar == null || kVar.e()) {
                aVar.P();
            } else if (kVar.g()) {
                com.google.gson.n c2 = kVar.c();
                if (c2.m()) {
                    aVar.b0(c2.i());
                } else if (c2.k()) {
                    aVar.d0(c2.h());
                } else {
                    aVar.c0(c2.j());
                }
            } else if (kVar.d()) {
                aVar.F();
                Iterator<com.google.gson.k> it = kVar.a().iterator();
                while (it.hasNext()) {
                    c(aVar, it.next());
                }
                aVar.I();
            } else if (kVar.f()) {
                aVar.G();
                for (Map.Entry<String, com.google.gson.k> entry : kVar.b().i()) {
                    aVar.N(entry.getKey());
                    c(aVar, entry.getValue());
                }
                aVar.J();
            } else {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
        }
    }

    /* compiled from: TypeAdapters */
    class v extends com.google.gson.r<BitSet> {
        v() {
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, BitSet bitSet) {
            aVar.F();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                aVar.Z(bitSet.get(i2) ? 1 : 0);
            }
            aVar.I();
        }
    }

    /* compiled from: TypeAdapters */
    class w implements com.google.gson.s {
        w() {
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class<? super Object> c2 = aVar.c();
            if (!Enum.class.isAssignableFrom(c2) || c2 == Enum.class) {
                return null;
            }
            if (!c2.isEnum()) {
                c2 = c2.getSuperclass();
            }
            return new i0(c2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TypeAdapters */
    public class x implements com.google.gson.s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f8447b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.r f8448c;

        x(Class cls, com.google.gson.r rVar) {
            this.f8447b = cls;
            this.f8448c = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() == this.f8447b) {
                return this.f8448c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f8447b.getName() + ",adapter=" + this.f8448c + "]";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TypeAdapters */
    public class y implements com.google.gson.s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f8449b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f8450c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.gson.r f8451d;

        y(Class cls, Class cls2, com.google.gson.r rVar) {
            this.f8449b = cls;
            this.f8450c = cls2;
            this.f8451d = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class<? super T> c2 = aVar.c();
            if (c2 == this.f8449b || c2 == this.f8450c) {
                return this.f8451d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f8450c.getName() + "+" + this.f8449b.getName() + ",adapter=" + this.f8451d + "]";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TypeAdapters */
    public class z implements com.google.gson.s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f8452b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f8453c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.gson.r f8454d;

        z(Class cls, Class cls2, com.google.gson.r rVar) {
            this.f8452b = cls;
            this.f8453c = cls2;
            this.f8454d = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            Class<? super T> c2 = aVar.c();
            if (c2 == this.f8452b || c2 == this.f8453c) {
                return this.f8454d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f8452b.getName() + "+" + this.f8453c.getName() + ",adapter=" + this.f8454d + "]";
        }
    }

    static {
        com.google.gson.r<Class> a2 = new k().a();
        f8430a = a2;
        f8431b = a(Class.class, a2);
        com.google.gson.r<BitSet> a3 = new v().a();
        f8432c = a3;
        f8433d = a(BitSet.class, a3);
        b0 b0Var = new b0();
        f8434e = b0Var;
        f8436g = b(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f8437h = d0Var;
        f8438i = b(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f8439j = e0Var;
        f8440k = b(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        l = f0Var;
        m = b(Integer.TYPE, Integer.class, f0Var);
        com.google.gson.r<AtomicInteger> a4 = new g0().a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        com.google.gson.r<AtomicBoolean> a5 = new h0().a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        com.google.gson.r<AtomicIntegerArray> a6 = new a().a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        e eVar = new e();
        w = eVar;
        x = a(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = b(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        D = a(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = a(StringBuffer.class, lVar);
        C0170m mVar = new C0170m();
        I = mVar;
        J = a(URL.class, mVar);
        n nVar = new n();
        K = nVar;
        L = a(URI.class, nVar);
        o oVar = new o();
        M = oVar;
        N = d(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = a(UUID.class, pVar);
        com.google.gson.r<Currency> a7 = new q().a();
        Q = a7;
        R = a(Currency.class, a7);
        s sVar = new s();
        T = sVar;
        U = c(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = a(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = d(com.google.gson.k.class, uVar);
    }

    public static <TT> com.google.gson.s a(Class<TT> cls, com.google.gson.r<TT> rVar) {
        return new x(cls, rVar);
    }

    public static <TT> com.google.gson.s b(Class<TT> cls, Class<TT> cls2, com.google.gson.r<? super TT> rVar) {
        return new y(cls, cls2, rVar);
    }

    public static <TT> com.google.gson.s c(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.r<? super TT> rVar) {
        return new z(cls, cls2, rVar);
    }

    public static <T1> com.google.gson.s d(Class<T1> cls, com.google.gson.r<T1> rVar) {
        return new a0(cls, rVar);
    }
}
