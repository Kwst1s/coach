package i;

import i.g0;
import i.j;
import i.k0.e;
import i.k0.g.f;
import i.k0.m.c;
import i.v;
import i.x;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.g;

/* compiled from: OkHttpClient */
public class b0 implements Cloneable, j.a {
    static final List<c0> D = e.r(c0.HTTP_2, c0.HTTP_1_1);
    static final List<p> E = e.r(p.f10596g, p.f10597h);
    final int A;
    final int B;
    final int C;

    /* renamed from: b  reason: collision with root package name */
    final s f10292b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final Proxy f10293c;

    /* renamed from: d  reason: collision with root package name */
    final List<c0> f10294d;

    /* renamed from: e  reason: collision with root package name */
    final List<p> f10295e;

    /* renamed from: f  reason: collision with root package name */
    final List<z> f10296f;

    /* renamed from: g  reason: collision with root package name */
    final List<z> f10297g;

    /* renamed from: h  reason: collision with root package name */
    final v.b f10298h;

    /* renamed from: i  reason: collision with root package name */
    final ProxySelector f10299i;

    /* renamed from: j  reason: collision with root package name */
    final r f10300j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final h f10301k;
    @Nullable
    final f l;
    final SocketFactory m;
    final SSLSocketFactory n;
    final c o;
    final HostnameVerifier p;
    final l q;
    final g r;
    final g s;
    final o t;
    final u u;
    final boolean v;
    final boolean w;
    final boolean x;
    final int y;
    final int z;

    /* compiled from: OkHttpClient */
    class a extends i.k0.c {
        a() {
        }

        @Override // i.k0.c
        public void a(x.a aVar, String str) {
            aVar.b(str);
        }

        @Override // i.k0.c
        public void b(x.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        @Override // i.k0.c
        public void c(p pVar, SSLSocket sSLSocket, boolean z) {
            pVar.a(sSLSocket, z);
        }

        @Override // i.k0.c
        public int d(g0.a aVar) {
            return aVar.f10370c;
        }

        @Override // i.k0.c
        public boolean e(e eVar, e eVar2) {
            return eVar.d(eVar2);
        }

        @Override // i.k0.c
        @Nullable
        public d f(g0 g0Var) {
            return g0Var.n;
        }

        @Override // i.k0.c
        public void g(g0.a aVar, d dVar) {
            aVar.k(dVar);
        }

        @Override // i.k0.c
        public g h(o oVar) {
            return oVar.f10593a;
        }
    }

    /* compiled from: OkHttpClient */
    public static final class b {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        s f10302a = new s();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Proxy f10303b;

        /* renamed from: c  reason: collision with root package name */
        List<c0> f10304c = b0.D;

        /* renamed from: d  reason: collision with root package name */
        List<p> f10305d = b0.E;

        /* renamed from: e  reason: collision with root package name */
        final List<z> f10306e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<z> f10307f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        v.b f10308g = v.k(v.f10626a);

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f10309h;

        /* renamed from: i  reason: collision with root package name */
        r f10310i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        h f10311j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        f f10312k;
        SocketFactory l;
        @Nullable
        SSLSocketFactory m;
        @Nullable
        c n;
        HostnameVerifier o;
        l p;
        g q;
        g r;
        o s;
        u t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public b() {
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f10309h = proxySelector;
            if (proxySelector == null) {
                this.f10309h = new i.k0.l.a();
            }
            this.f10310i = r.f10617a;
            this.l = SocketFactory.getDefault();
            this.o = i.k0.m.d.f10573a;
            this.p = l.f10574c;
            g gVar = g.f10357a;
            this.q = gVar;
            this.r = gVar;
            this.s = new o();
            this.t = u.f10625a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public b0 a() {
            return new b0(this);
        }

        public b b(@Nullable h hVar) {
            this.f10311j = hVar;
            this.f10312k = null;
            return this;
        }
    }

    static {
        i.k0.c.f10443a = new a();
    }

    public b0() {
        this(new b());
    }

    private static SSLSocketFactory t(X509TrustManager x509TrustManager) {
        try {
            SSLContext l2 = i.k0.k.e.j().l();
            l2.init(null, new TrustManager[]{x509TrustManager}, null);
            return l2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public boolean A() {
        return this.x;
    }

    public SocketFactory B() {
        return this.m;
    }

    public SSLSocketFactory C() {
        return this.n;
    }

    public int D() {
        return this.B;
    }

    @Override // i.j.a
    public j a(e0 e0Var) {
        return d0.e(this, e0Var, false);
    }

    public g b() {
        return this.s;
    }

    @Nullable
    public h c() {
        return this.f10301k;
    }

    public int d() {
        return this.y;
    }

    public l e() {
        return this.q;
    }

    public int f() {
        return this.z;
    }

    public o g() {
        return this.t;
    }

    public List<p> h() {
        return this.f10295e;
    }

    public r i() {
        return this.f10300j;
    }

    public s j() {
        return this.f10292b;
    }

    public u k() {
        return this.u;
    }

    public v.b m() {
        return this.f10298h;
    }

    public boolean n() {
        return this.w;
    }

    public boolean o() {
        return this.v;
    }

    public HostnameVerifier p() {
        return this.p;
    }

    public List<z> q() {
        return this.f10296f;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public f r() {
        h hVar = this.f10301k;
        return hVar != null ? hVar.f10379b : this.l;
    }

    public List<z> s() {
        return this.f10297g;
    }

    public int u() {
        return this.C;
    }

    public List<c0> v() {
        return this.f10294d;
    }

    @Nullable
    public Proxy w() {
        return this.f10293c;
    }

    public g x() {
        return this.r;
    }

    public ProxySelector y() {
        return this.f10299i;
    }

    public int z() {
        return this.A;
    }

    b0(b bVar) {
        boolean z2;
        this.f10292b = bVar.f10302a;
        this.f10293c = bVar.f10303b;
        this.f10294d = bVar.f10304c;
        List<p> list = bVar.f10305d;
        this.f10295e = list;
        this.f10296f = e.q(bVar.f10306e);
        this.f10297g = e.q(bVar.f10307f);
        this.f10298h = bVar.f10308g;
        this.f10299i = bVar.f10309h;
        this.f10300j = bVar.f10310i;
        this.f10301k = bVar.f10311j;
        this.l = bVar.f10312k;
        this.m = bVar.l;
        Iterator<p> it = list.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                p next = it.next();
                if (z2 || next.d()) {
                    z2 = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.m;
        if (sSLSocketFactory != null || !z2) {
            this.n = sSLSocketFactory;
            this.o = bVar.n;
        } else {
            X509TrustManager A2 = e.A();
            this.n = t(A2);
            this.o = c.b(A2);
        }
        if (this.n != null) {
            i.k0.k.e.j().f(this.n);
        }
        this.p = bVar.o;
        this.q = bVar.p.f(this.o);
        this.r = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        if (this.f10296f.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f10296f);
        } else if (this.f10297g.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f10297g);
        }
    }
}
