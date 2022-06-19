package i.k0.h;

import i.a0;
import i.e0;
import i.f0;
import i.g0;
import i.k0.e;
import i.k0.f;
import i.q;
import i.r;
import i.x;
import i.z;
import j.j;
import j.l;
import java.util.List;

/* compiled from: BridgeInterceptor */
public final class a implements z {

    /* renamed from: a  reason: collision with root package name */
    private final r f10501a;

    public a(r rVar) {
        this.f10501a = rVar;
    }

    private String b(List<q> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            q qVar = list.get(i2);
            sb.append(qVar.c());
            sb.append('=');
            sb.append(qVar.k());
        }
        return sb.toString();
    }

    @Override // i.z
    public g0 a(z.a aVar) {
        e0 e2 = aVar.e();
        e0.a h2 = e2.h();
        f0 a2 = e2.a();
        if (a2 != null) {
            a0 b2 = a2.b();
            if (b2 == null) {
                long a3 = a2.a();
                if (a3 != -1) {
                    h2.c("Content-Length", Long.toString(a3));
                    h2.f("Transfer-Encoding");
                } else {
                    h2.c("Transfer-Encoding", "chunked");
                    h2.f("Content-Length");
                }
            } else {
                b2.toString();
                throw null;
            }
        }
        boolean z = false;
        if (e2.c("Host") == null) {
            h2.c("Host", e.p(e2.i(), false));
        }
        if (e2.c("Connection") == null) {
            h2.c("Connection", "Keep-Alive");
        }
        if (e2.c("Accept-Encoding") == null && e2.c("Range") == null) {
            z = true;
            h2.c("Accept-Encoding", "gzip");
        }
        List<q> a4 = this.f10501a.a(e2.i());
        if (!a4.isEmpty()) {
            h2.c("Cookie", b(a4));
        }
        if (e2.c("User-Agent") == null) {
            h2.c("User-Agent", f.a());
        }
        g0 d2 = aVar.d(h2.a());
        e.g(this.f10501a, e2.i(), d2.K());
        g0.a O = d2.O();
        O.q(e2);
        if (z && "gzip".equalsIgnoreCase(d2.I("Content-Encoding")) && e.c(d2)) {
            j jVar = new j(d2.l().G());
            x.a f2 = d2.K().f();
            f2.f("Content-Encoding");
            f2.f("Content-Length");
            O.j(f2.d());
            O.b(new h(d2.I("Content-Type"), -1, l.d(jVar)));
        }
        return O.c();
    }
}
