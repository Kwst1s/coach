package i.k0.h;

import i.e0;
import i.g0;
import i.k0.e;
import i.z;
import j.l;
import java.net.ProtocolException;
import okhttp3.internal.connection.d;

/* compiled from: CallServerInterceptor */
public final class b implements z {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10502a;

    public b(boolean z) {
        this.f10502a = z;
    }

    @Override // i.z
    public g0 a(z.a aVar) {
        boolean z;
        g0 g0Var;
        g gVar = (g) aVar;
        d f2 = gVar.f();
        e0 e2 = gVar.e();
        long currentTimeMillis = System.currentTimeMillis();
        f2.p(e2);
        g0.a aVar2 = null;
        if (!f.b(e2.g()) || e2.a() == null) {
            f2.j();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(e2.c("Expect"))) {
                f2.g();
                f2.n();
                aVar2 = f2.l(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar2 != null) {
                f2.j();
                if (!f2.c().n()) {
                    f2.i();
                }
            } else if (e2.a().e()) {
                f2.g();
                e2.a().g(l.c(f2.d(e2, true)));
            } else {
                j.d c2 = l.c(f2.d(e2, false));
                e2.a().g(c2);
                c2.close();
            }
        }
        if (e2.a() == null || !e2.a().e()) {
            f2.f();
        }
        if (!z) {
            f2.n();
        }
        if (aVar2 == null) {
            aVar2 = f2.l(false);
        }
        aVar2.q(e2);
        aVar2.h(f2.c().k());
        aVar2.r(currentTimeMillis);
        aVar2.p(System.currentTimeMillis());
        g0 c3 = aVar2.c();
        int G = c3.G();
        if (G == 100) {
            g0.a l = f2.l(false);
            l.q(e2);
            l.h(f2.c().k());
            l.r(currentTimeMillis);
            l.p(System.currentTimeMillis());
            c3 = l.c();
            G = c3.G();
        }
        f2.m(c3);
        if (!this.f10502a || G != 101) {
            g0.a O = c3.O();
            O.b(f2.k(c3));
            g0Var = O.c();
        } else {
            g0.a O2 = c3.O();
            O2.b(e.f10448d);
            g0Var = O2.c();
        }
        if ("close".equalsIgnoreCase(g0Var.S().c("Connection")) || "close".equalsIgnoreCase(g0Var.I("Connection"))) {
            f2.i();
        }
        if ((G != 204 && G != 205) || g0Var.l().l() <= 0) {
            return g0Var;
        }
        throw new ProtocolException("HTTP " + G + " had non-zero Content-Length: " + g0Var.l().l());
    }
}
