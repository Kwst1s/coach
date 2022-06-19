package i;

import i.e0;
import i.g0;
import i.k0.e;
import i.k0.g.d;
import i.k0.g.f;
import i.k0.h.k;
import i.x;
import j.g;
import j.l;
import j.s;
import j.t;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Cache */
public final class h implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    final f f10379b;

    /* renamed from: c  reason: collision with root package name */
    final i.k0.g.d f10380c;

    /* renamed from: d  reason: collision with root package name */
    int f10381d;

    /* renamed from: e  reason: collision with root package name */
    int f10382e;

    /* renamed from: f  reason: collision with root package name */
    private int f10383f;

    /* renamed from: g  reason: collision with root package name */
    private int f10384g;

    /* renamed from: h  reason: collision with root package name */
    private int f10385h;

    /* compiled from: Cache */
    class a implements f {
        a() {
        }

        @Override // i.k0.g.f
        @Nullable
        public g0 a(e0 e0Var) {
            return h.this.E(e0Var);
        }

        @Override // i.k0.g.f
        public void b() {
            h.this.J();
        }

        @Override // i.k0.g.f
        public void c(i.k0.g.c cVar) {
            h.this.K(cVar);
        }

        @Override // i.k0.g.f
        public void d(g0 g0Var, g0 g0Var2) {
            h.this.L(g0Var, g0Var2);
        }

        @Override // i.k0.g.f
        public void e(e0 e0Var) {
            h.this.I(e0Var);
        }

        @Override // i.k0.g.f
        @Nullable
        public i.k0.g.b f(g0 g0Var) {
            return h.this.G(g0Var);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Cache */
    public final class b implements i.k0.g.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f10387a;

        /* renamed from: b  reason: collision with root package name */
        private s f10388b;

        /* renamed from: c  reason: collision with root package name */
        private s f10389c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10390d;

        /* compiled from: Cache */
        class a extends g {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.c f10392c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(s sVar, h hVar, d.c cVar) {
                super(sVar);
                this.f10392c = cVar;
            }

            @Override // j.g, java.io.Closeable, java.lang.AutoCloseable, j.s
            public void close() {
                synchronized (h.this) {
                    b bVar = b.this;
                    if (!bVar.f10390d) {
                        bVar.f10390d = true;
                        h.this.f10381d++;
                        super.close();
                        this.f10392c.b();
                    }
                }
            }
        }

        b(d.c cVar) {
            this.f10387a = cVar;
            s d2 = cVar.d(1);
            this.f10388b = d2;
            this.f10389c = new a(d2, h.this, cVar);
        }

        @Override // i.k0.g.b
        public s a() {
            return this.f10389c;
        }

        @Override // i.k0.g.b
        public void b() {
            synchronized (h.this) {
                if (!this.f10390d) {
                    this.f10390d = true;
                    h.this.f10382e++;
                    e.d(this.f10388b);
                    try {
                        this.f10387a.a();
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Cache */
    public static class c extends h0 {

        /* renamed from: b  reason: collision with root package name */
        final d.e f10394b;

        /* renamed from: c  reason: collision with root package name */
        private final j.e f10395c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f10396d;

        /* compiled from: Cache */
        class a extends j.h {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.e f10397c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, t tVar, d.e eVar) {
                super(tVar);
                this.f10397c = eVar;
            }

            @Override // j.t, j.h, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f10397c.close();
                super.close();
            }
        }

        c(d.e eVar, String str, String str2) {
            this.f10394b = eVar;
            this.f10396d = str2;
            this.f10395c = l.d(new a(this, eVar.E(1), eVar));
        }

        @Override // i.h0
        public j.e G() {
            return this.f10395c;
        }

        @Override // i.h0
        public long l() {
            try {
                String str = this.f10396d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    public h(File file, long j2) {
        this(file, j2, i.k0.j.a.f10545a);
    }

    public static String F(y yVar) {
        return j.f.i(yVar.toString()).l().k();
    }

    static int H(j.e eVar) {
        try {
            long u = eVar.u();
            String j2 = eVar.j();
            if (u >= 0 && u <= 2147483647L && j2.isEmpty()) {
                return (int) u;
            }
            throw new IOException("expected an int but was \"" + u + j2 + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void l(@Nullable d.c cVar) {
        if (cVar != null) {
            try {
                cVar.a();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public g0 E(e0 e0Var) {
        try {
            d.e K = this.f10380c.K(F(e0Var.i()));
            if (K == null) {
                return null;
            }
            try {
                d dVar = new d(K.E(0));
                g0 d2 = dVar.d(K);
                if (dVar.b(e0Var, d2)) {
                    return d2;
                }
                e.d(d2.l());
                return null;
            } catch (IOException unused) {
                e.d(K);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public i.k0.g.b G(g0 g0Var) {
        d.c cVar;
        String g2 = g0Var.S().g();
        if (i.k0.h.f.a(g0Var.S().g())) {
            try {
                I(g0Var.S());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g2.equals("GET") || i.k0.h.e.e(g0Var)) {
            return null;
        } else {
            d dVar = new d(g0Var);
            try {
                cVar = this.f10380c.I(F(g0Var.S().i()));
                if (cVar == null) {
                    return null;
                }
                try {
                    dVar.f(cVar);
                    return new b(cVar);
                } catch (IOException unused2) {
                    l(cVar);
                    return null;
                }
            } catch (IOException unused3) {
                cVar = null;
                l(cVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I(e0 e0Var) {
        this.f10380c.T(F(e0Var.i()));
    }

    /* access modifiers changed from: package-private */
    public synchronized void J() {
        this.f10384g++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void K(i.k0.g.c cVar) {
        this.f10385h++;
        if (cVar.f10458a != null) {
            this.f10383f++;
        } else if (cVar.f10459b != null) {
            this.f10384g++;
        }
    }

    /* access modifiers changed from: package-private */
    public void L(g0 g0Var, g0 g0Var2) {
        d.c cVar;
        d dVar = new d(g0Var2);
        try {
            cVar = ((c) g0Var.l()).f10394b.l();
            if (cVar != null) {
                try {
                    dVar.f(cVar);
                    cVar.b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            cVar = null;
            l(cVar);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10380c.close();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f10380c.flush();
    }

    h(File file, long j2, i.k0.j.a aVar) {
        this.f10379b = new a();
        this.f10380c = i.k0.g.d.G(aVar, file, 201105, 2, j2);
    }

    /* access modifiers changed from: private */
    /* compiled from: Cache */
    public static final class d {

        /* renamed from: k  reason: collision with root package name */
        private static final String f10398k = (i.k0.k.e.j().k() + "-Sent-Millis");
        private static final String l = (i.k0.k.e.j().k() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f10399a;

        /* renamed from: b  reason: collision with root package name */
        private final x f10400b;

        /* renamed from: c  reason: collision with root package name */
        private final String f10401c;

        /* renamed from: d  reason: collision with root package name */
        private final c0 f10402d;

        /* renamed from: e  reason: collision with root package name */
        private final int f10403e;

        /* renamed from: f  reason: collision with root package name */
        private final String f10404f;

        /* renamed from: g  reason: collision with root package name */
        private final x f10405g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private final w f10406h;

        /* renamed from: i  reason: collision with root package name */
        private final long f10407i;

        /* renamed from: j  reason: collision with root package name */
        private final long f10408j;

        d(t tVar) {
            j0 j0Var;
            try {
                j.e d2 = l.d(tVar);
                this.f10399a = d2.j();
                this.f10401c = d2.j();
                x.a aVar = new x.a();
                int H = h.H(d2);
                for (int i2 = 0; i2 < H; i2++) {
                    aVar.b(d2.j());
                }
                this.f10400b = aVar.d();
                k a2 = k.a(d2.j());
                this.f10402d = a2.f10519a;
                this.f10403e = a2.f10520b;
                this.f10404f = a2.f10521c;
                x.a aVar2 = new x.a();
                int H2 = h.H(d2);
                for (int i3 = 0; i3 < H2; i3++) {
                    aVar2.b(d2.j());
                }
                String str = f10398k;
                String e2 = aVar2.e(str);
                String str2 = l;
                String e3 = aVar2.e(str2);
                aVar2.f(str);
                aVar2.f(str2);
                long j2 = 0;
                this.f10407i = e2 != null ? Long.parseLong(e2) : 0;
                this.f10408j = e3 != null ? Long.parseLong(e3) : j2;
                this.f10405g = aVar2.d();
                if (a()) {
                    String j3 = d2.j();
                    if (j3.length() <= 0) {
                        m a3 = m.a(d2.j());
                        List<Certificate> c2 = c(d2);
                        List<Certificate> c3 = c(d2);
                        if (!d2.o()) {
                            j0Var = j0.a(d2.j());
                        } else {
                            j0Var = j0.SSL_3_0;
                        }
                        this.f10406h = w.c(j0Var, a3, c2, c3);
                    } else {
                        throw new IOException("expected \"\" but was \"" + j3 + "\"");
                    }
                } else {
                    this.f10406h = null;
                }
            } finally {
                tVar.close();
            }
        }

        private boolean a() {
            return this.f10399a.startsWith("https://");
        }

        private List<Certificate> c(j.e eVar) {
            int H = h.H(eVar);
            if (H == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(H);
                for (int i2 = 0; i2 < H; i2++) {
                    String j2 = eVar.j();
                    j.c cVar = new j.c();
                    cVar.W(j.f.e(j2));
                    arrayList.add(instance.generateCertificate(cVar.D()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void e(j.d dVar, List<Certificate> list) {
            try {
                dVar.z((long) list.size()).p(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    dVar.y(j.f.m(list.get(i2).getEncoded()).a()).p(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean b(e0 e0Var, g0 g0Var) {
            return this.f10399a.equals(e0Var.i().toString()) && this.f10401c.equals(e0Var.g()) && i.k0.h.e.o(g0Var, this.f10400b, e0Var);
        }

        public g0 d(d.e eVar) {
            String c2 = this.f10405g.c("Content-Type");
            String c3 = this.f10405g.c("Content-Length");
            e0.a aVar = new e0.a();
            aVar.g(this.f10399a);
            aVar.e(this.f10401c, null);
            aVar.d(this.f10400b);
            e0 a2 = aVar.a();
            g0.a aVar2 = new g0.a();
            aVar2.q(a2);
            aVar2.o(this.f10402d);
            aVar2.g(this.f10403e);
            aVar2.l(this.f10404f);
            aVar2.j(this.f10405g);
            aVar2.b(new c(eVar, c2, c3));
            aVar2.h(this.f10406h);
            aVar2.r(this.f10407i);
            aVar2.p(this.f10408j);
            return aVar2.c();
        }

        public void f(d.c cVar) {
            j.d c2 = l.c(cVar.d(0));
            c2.y(this.f10399a).p(10);
            c2.y(this.f10401c).p(10);
            c2.z((long) this.f10400b.h()).p(10);
            int h2 = this.f10400b.h();
            for (int i2 = 0; i2 < h2; i2++) {
                c2.y(this.f10400b.e(i2)).y(": ").y(this.f10400b.i(i2)).p(10);
            }
            c2.y(new k(this.f10402d, this.f10403e, this.f10404f).toString()).p(10);
            c2.z((long) (this.f10405g.h() + 2)).p(10);
            int h3 = this.f10405g.h();
            for (int i3 = 0; i3 < h3; i3++) {
                c2.y(this.f10405g.e(i3)).y(": ").y(this.f10405g.i(i3)).p(10);
            }
            c2.y(f10398k).y(": ").z(this.f10407i).p(10);
            c2.y(l).y(": ").z(this.f10408j).p(10);
            if (a()) {
                c2.p(10);
                c2.y(this.f10406h.a().d()).p(10);
                e(c2, this.f10406h.f());
                e(c2, this.f10406h.d());
                c2.y(this.f10406h.g().d()).p(10);
            }
            c2.close();
        }

        d(g0 g0Var) {
            this.f10399a = g0Var.S().i().toString();
            this.f10400b = i.k0.h.e.n(g0Var);
            this.f10401c = g0Var.S().g();
            this.f10402d = g0Var.Q();
            this.f10403e = g0Var.G();
            this.f10404f = g0Var.M();
            this.f10405g = g0Var.K();
            this.f10406h = g0Var.H();
            this.f10407i = g0Var.T();
            this.f10408j = g0Var.R();
        }
    }
}
