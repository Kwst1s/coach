package i.k0.g;

import i.c0;
import i.e0;
import i.g0;
import i.k0.g.c;
import i.k0.h.f;
import i.k0.h.h;
import i.x;
import i.z;
import j.c;
import j.d;
import j.e;
import j.l;
import j.s;
import j.t;
import j.u;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheInterceptor */
public final class a implements z {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    final f f10453a;

    /* access modifiers changed from: package-private */
    /* renamed from: i.k0.g.a$a  reason: collision with other inner class name */
    /* compiled from: CacheInterceptor */
    public class C0233a implements t {

        /* renamed from: b  reason: collision with root package name */
        boolean f10454b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f10455c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f10456d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f10457e;

        C0233a(a aVar, e eVar, b bVar, d dVar) {
            this.f10455c = eVar;
            this.f10456d = bVar;
            this.f10457e = dVar;
        }

        @Override // j.t
        public u c() {
            return this.f10455c.c();
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f10454b && !i.k0.e.m(this, 100, TimeUnit.MILLISECONDS)) {
                this.f10454b = true;
                this.f10456d.b();
            }
            this.f10455c.close();
        }

        @Override // j.t
        public long v(c cVar, long j2) {
            try {
                long v = this.f10455c.v(cVar, j2);
                if (v == -1) {
                    if (!this.f10454b) {
                        this.f10454b = true;
                        this.f10457e.close();
                    }
                    return -1;
                }
                cVar.H(this.f10457e.a(), cVar.S() - v, v);
                this.f10457e.t();
                return v;
            } catch (IOException e2) {
                if (!this.f10454b) {
                    this.f10454b = true;
                    this.f10456d.b();
                }
                throw e2;
            }
        }
    }

    public a(@Nullable f fVar) {
        this.f10453a = fVar;
    }

    private g0 b(b bVar, g0 g0Var) {
        s a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return g0Var;
        }
        C0233a aVar = new C0233a(this, g0Var.l().G(), bVar, l.c(a2));
        String I = g0Var.I("Content-Type");
        long l = g0Var.l().l();
        g0.a O = g0Var.O();
        O.b(new h(I, l, l.d(aVar)));
        return O.c();
    }

    private static x c(x xVar, x xVar2) {
        x.a aVar = new x.a();
        int h2 = xVar.h();
        for (int i2 = 0; i2 < h2; i2++) {
            String e2 = xVar.e(i2);
            String i3 = xVar.i(i2);
            if ((!"Warning".equalsIgnoreCase(e2) || !i3.startsWith("1")) && (d(e2) || !e(e2) || xVar2.c(e2) == null)) {
                i.k0.c.f10443a.b(aVar, e2, i3);
            }
        }
        int h3 = xVar2.h();
        for (int i4 = 0; i4 < h3; i4++) {
            String e3 = xVar2.e(i4);
            if (!d(e3) && e(e3)) {
                i.k0.c.f10443a.b(aVar, e3, xVar2.i(i4));
            }
        }
        return aVar.d();
    }

    static boolean d(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean e(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    private static g0 f(g0 g0Var) {
        if (g0Var == null || g0Var.l() == null) {
            return g0Var;
        }
        g0.a O = g0Var.O();
        O.b(null);
        return O.c();
    }

    @Override // i.z
    public g0 a(z.a aVar) {
        f fVar = this.f10453a;
        g0 a2 = fVar != null ? fVar.a(aVar.e()) : null;
        c c2 = new c.a(System.currentTimeMillis(), aVar.e(), a2).c();
        e0 e0Var = c2.f10458a;
        g0 g0Var = c2.f10459b;
        f fVar2 = this.f10453a;
        if (fVar2 != null) {
            fVar2.c(c2);
        }
        if (a2 != null && g0Var == null) {
            i.k0.e.d(a2.l());
        }
        if (e0Var == null && g0Var == null) {
            g0.a aVar2 = new g0.a();
            aVar2.q(aVar.e());
            aVar2.o(c0.HTTP_1_1);
            aVar2.g(504);
            aVar2.l("Unsatisfiable Request (only-if-cached)");
            aVar2.b(i.k0.e.f10448d);
            aVar2.r(-1);
            aVar2.p(System.currentTimeMillis());
            return aVar2.c();
        } else if (e0Var == null) {
            g0.a O = g0Var.O();
            O.d(f(g0Var));
            return O.c();
        } else {
            try {
                g0 d2 = aVar.d(e0Var);
                if (d2 == null && a2 != null) {
                }
                if (g0Var != null) {
                    if (d2.G() == 304) {
                        g0.a O2 = g0Var.O();
                        O2.j(c(g0Var.K(), d2.K()));
                        O2.r(d2.T());
                        O2.p(d2.R());
                        O2.d(f(g0Var));
                        O2.m(f(d2));
                        g0 c3 = O2.c();
                        d2.l().close();
                        this.f10453a.b();
                        this.f10453a.d(g0Var, c3);
                        return c3;
                    }
                    i.k0.e.d(g0Var.l());
                }
                g0.a O3 = d2.O();
                O3.d(f(g0Var));
                O3.m(f(d2));
                g0 c4 = O3.c();
                if (this.f10453a != null) {
                    if (i.k0.h.e.c(c4) && c.a(c4, e0Var)) {
                        return b(this.f10453a.f(c4), c4);
                    }
                    if (f.a(e0Var.g())) {
                        try {
                            this.f10453a.e(e0Var);
                        } catch (IOException unused) {
                        }
                    }
                }
                return c4;
            } finally {
                if (a2 != null) {
                    i.k0.e.d(a2.l());
                }
            }
        }
    }
}
