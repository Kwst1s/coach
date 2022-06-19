package okhttp3.internal.http2;

import i.b0;
import i.c0;
import i.e0;
import i.g0;
import i.k0.e;
import i.k0.h.c;
import i.k0.h.i;
import i.k0.h.k;
import i.x;
import i.z;
import j.s;
import j.t;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2ExchangeCodec */
public final class f implements c {

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f10964g = e.r("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h  reason: collision with root package name */
    private static final List<String> f10965h = e.r("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    private final z.a f10966a;

    /* renamed from: b  reason: collision with root package name */
    private final okhttp3.internal.connection.f f10967b;

    /* renamed from: c  reason: collision with root package name */
    private final e f10968c;

    /* renamed from: d  reason: collision with root package name */
    private volatile h f10969d;

    /* renamed from: e  reason: collision with root package name */
    private final c0 f10970e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10971f;

    public f(b0 b0Var, okhttp3.internal.connection.f fVar, z.a aVar, e eVar) {
        this.f10967b = fVar;
        this.f10966a = aVar;
        this.f10968c = eVar;
        List<c0> v = b0Var.v();
        c0 c0Var = c0.H2_PRIOR_KNOWLEDGE;
        this.f10970e = !v.contains(c0Var) ? c0.HTTP_2 : c0Var;
    }

    public static List<b> i(e0 e0Var) {
        x e2 = e0Var.e();
        ArrayList arrayList = new ArrayList(e2.h() + 4);
        arrayList.add(new b(b.f10883f, e0Var.g()));
        arrayList.add(new b(b.f10884g, i.c(e0Var.i())));
        String c2 = e0Var.c("Host");
        if (c2 != null) {
            arrayList.add(new b(b.f10886i, c2));
        }
        arrayList.add(new b(b.f10885h, e0Var.i().B()));
        int h2 = e2.h();
        for (int i2 = 0; i2 < h2; i2++) {
            String lowerCase = e2.e(i2).toLowerCase(Locale.US);
            if (!f10964g.contains(lowerCase) || (lowerCase.equals("te") && e2.i(i2).equals("trailers"))) {
                arrayList.add(new b(lowerCase, e2.i(i2)));
            }
        }
        return arrayList;
    }

    public static g0.a j(x xVar, c0 c0Var) {
        x.a aVar = new x.a();
        int h2 = xVar.h();
        k kVar = null;
        for (int i2 = 0; i2 < h2; i2++) {
            String e2 = xVar.e(i2);
            String i3 = xVar.i(i2);
            if (e2.equals(":status")) {
                kVar = k.a("HTTP/1.1 " + i3);
            } else if (!f10965h.contains(e2)) {
                i.k0.c.f10443a.b(aVar, e2, i3);
            }
        }
        if (kVar != null) {
            g0.a aVar2 = new g0.a();
            aVar2.o(c0Var);
            aVar2.g(kVar.f10520b);
            aVar2.l(kVar.f10521c);
            aVar2.j(aVar.d());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // i.k0.h.c
    public void a() {
        this.f10969d.h().close();
    }

    @Override // i.k0.h.c
    public void b(e0 e0Var) {
        if (this.f10969d == null) {
            this.f10969d = this.f10968c.N(i(e0Var), e0Var.a() != null);
            if (!this.f10971f) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                this.f10969d.l().g((long) this.f10966a.b(), timeUnit);
                this.f10969d.r().g((long) this.f10966a.c(), timeUnit);
                return;
            }
            this.f10969d.f(a.CANCEL);
            throw new IOException("Canceled");
        }
    }

    @Override // i.k0.h.c
    public void c() {
        this.f10968c.flush();
    }

    @Override // i.k0.h.c
    public void cancel() {
        this.f10971f = true;
        if (this.f10969d != null) {
            this.f10969d.f(a.CANCEL);
        }
    }

    @Override // i.k0.h.c
    public long d(g0 g0Var) {
        return i.k0.h.e.b(g0Var);
    }

    @Override // i.k0.h.c
    public t e(g0 g0Var) {
        return this.f10969d.i();
    }

    @Override // i.k0.h.c
    public s f(e0 e0Var, long j2) {
        return this.f10969d.h();
    }

    @Override // i.k0.h.c
    public g0.a g(boolean z) {
        g0.a j2 = j(this.f10969d.p(), this.f10970e);
        if (!z || i.k0.c.f10443a.d(j2) != 100) {
            return j2;
        }
        return null;
    }

    @Override // i.k0.h.c
    public okhttp3.internal.connection.f h() {
        return this.f10967b;
    }
}
