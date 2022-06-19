package okhttp3.internal.connection;

import i.b0;
import i.c0;
import i.e0;
import i.g0;
import i.i0;
import i.j;
import i.k0.c;
import i.k0.i.a;
import i.n;
import i.v;
import i.w;
import i.y;
import i.z;
import j.d;
import j.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.e;
import okhttp3.internal.http2.h;

/* compiled from: RealConnection */
public final class f extends e.h implements n {

    /* renamed from: b  reason: collision with root package name */
    public final g f10829b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f10830c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f10831d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f10832e;

    /* renamed from: f  reason: collision with root package name */
    private w f10833f;

    /* renamed from: g  reason: collision with root package name */
    private c0 f10834g;

    /* renamed from: h  reason: collision with root package name */
    private e f10835h;

    /* renamed from: i  reason: collision with root package name */
    private j.e f10836i;

    /* renamed from: j  reason: collision with root package name */
    private d f10837j;

    /* renamed from: k  reason: collision with root package name */
    boolean f10838k;
    int l;
    int m;
    private int n;
    private int o = 1;
    final List<Reference<j>> p = new ArrayList();
    long q = Long.MAX_VALUE;

    public f(g gVar, i0 i0Var) {
        this.f10829b = gVar;
        this.f10830c = i0Var;
    }

    private void e(int i2, int i3, j jVar, v vVar) {
        Socket socket;
        Proxy b2 = this.f10830c.b();
        i.e a2 = this.f10830c.a();
        if (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) {
            socket = a2.j().createSocket();
        } else {
            socket = new Socket(b2);
        }
        this.f10831d = socket;
        vVar.f(jVar, this.f10830c.d(), b2);
        this.f10831d.setSoTimeout(i3);
        try {
            i.k0.k.e.j().h(this.f10831d, this.f10830c.d(), i2);
            try {
                this.f10836i = l.d(l.m(this.f10831d));
                this.f10837j = l.c(l.i(this.f10831d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f10830c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0137 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013d A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(okhttp3.internal.connection.c r8) {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.f(okhttp3.internal.connection.c):void");
    }

    private void g(int i2, int i3, int i4, j jVar, v vVar) {
        e0 i5 = i();
        y i6 = i5.i();
        for (int i7 = 0; i7 < 21; i7++) {
            e(i2, i3, jVar, vVar);
            i5 = h(i3, i4, i5, i6);
            if (i5 != null) {
                i.k0.e.e(this.f10831d);
                this.f10831d = null;
                this.f10837j = null;
                this.f10836i = null;
                vVar.d(jVar, this.f10830c.d(), this.f10830c.b(), null);
            } else {
                return;
            }
        }
    }

    private e0 h(int i2, int i3, e0 e0Var, y yVar) {
        String str = "CONNECT " + i.k0.e.p(yVar, true) + " HTTP/1.1";
        while (true) {
            j.e eVar = this.f10836i;
            a aVar = new a(null, null, eVar, this.f10837j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eVar.c().g((long) i2, timeUnit);
            this.f10837j.c().g((long) i3, timeUnit);
            aVar.B(e0Var.e(), str);
            aVar.a();
            g0.a g2 = aVar.g(false);
            g2.q(e0Var);
            g0 c2 = g2.c();
            aVar.A(c2);
            int G = c2.G();
            if (G != 200) {
                if (G == 407) {
                    e0 a2 = this.f10830c.a().h().a(this.f10830c, c2);
                    if (a2 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(c2.I("Connection"))) {
                        return a2;
                    } else {
                        e0Var = a2;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c2.G());
                }
            } else if (this.f10836i.n().o() && this.f10837j.a().o()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private e0 i() {
        e0.a aVar = new e0.a();
        aVar.h(this.f10830c.a().l());
        aVar.e("CONNECT", null);
        aVar.c("Host", i.k0.e.p(this.f10830c.a().l(), true));
        aVar.c("Proxy-Connection", "Keep-Alive");
        aVar.c("User-Agent", i.k0.f.a());
        e0 a2 = aVar.a();
        g0.a aVar2 = new g0.a();
        aVar2.q(a2);
        aVar2.o(c0.HTTP_1_1);
        aVar2.g(407);
        aVar2.l("Preemptive Authenticate");
        aVar2.b(i.k0.e.f10448d);
        aVar2.r(-1);
        aVar2.p(-1);
        aVar2.i("Proxy-Authenticate", "OkHttp-Preemptive");
        e0 a3 = this.f10830c.a().h().a(this.f10830c, aVar2.c());
        return a3 != null ? a3 : a2;
    }

    private void j(c cVar, int i2, j jVar, v vVar) {
        if (this.f10830c.a().k() == null) {
            List<c0> f2 = this.f10830c.a().f();
            c0 c0Var = c0.H2_PRIOR_KNOWLEDGE;
            if (f2.contains(c0Var)) {
                this.f10832e = this.f10831d;
                this.f10834g = c0Var;
                t(i2);
                return;
            }
            this.f10832e = this.f10831d;
            this.f10834g = c0.HTTP_1_1;
            return;
        }
        vVar.x(jVar);
        f(cVar);
        vVar.w(jVar, this.f10833f);
        if (this.f10834g == c0.HTTP_2) {
            t(i2);
        }
    }

    private boolean r(List<i0> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            i0 i0Var = list.get(i2);
            if (i0Var.b().type() == Proxy.Type.DIRECT && this.f10830c.b().type() == Proxy.Type.DIRECT && this.f10830c.d().equals(i0Var.d())) {
                return true;
            }
        }
        return false;
    }

    private void t(int i2) {
        this.f10832e.setSoTimeout(0);
        e.g gVar = new e.g(true);
        gVar.d(this.f10832e, this.f10830c.a().l().l(), this.f10836i, this.f10837j);
        gVar.b(this);
        gVar.c(i2);
        e a2 = gVar.a();
        this.f10835h = a2;
        a2.W();
    }

    @Override // okhttp3.internal.http2.e.h
    public void a(e eVar) {
        synchronized (this.f10829b) {
            this.o = eVar.L();
        }
    }

    @Override // okhttp3.internal.http2.e.h
    public void b(h hVar) {
        hVar.d(okhttp3.internal.http2.a.REFUSED_STREAM, null);
    }

    public void c() {
        i.k0.e.e(this.f10831d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r17, int r18, int r19, int r20, boolean r21, i.j r22, i.v r23) {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.d(int, int, int, int, boolean, i.j, i.v):void");
    }

    public w k() {
        return this.f10833f;
    }

    /* access modifiers changed from: package-private */
    public boolean l(i.e eVar, @Nullable List<i0> list) {
        if (this.p.size() >= this.o || this.f10838k || !c.f10443a.e(this.f10830c.a(), eVar)) {
            return false;
        }
        if (eVar.l().l().equals(q().a().l().l())) {
            return true;
        }
        if (this.f10835h == null || list == null || !r(list) || eVar.e() != i.k0.m.d.f10573a || !u(eVar.l())) {
            return false;
        }
        try {
            eVar.a().a(eVar.l().l(), k().f());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean m(boolean z) {
        if (this.f10832e.isClosed() || this.f10832e.isInputShutdown() || this.f10832e.isOutputShutdown()) {
            return false;
        }
        e eVar = this.f10835h;
        if (eVar != null) {
            return !eVar.K();
        }
        if (z) {
            try {
                int soTimeout = this.f10832e.getSoTimeout();
                try {
                    this.f10832e.setSoTimeout(1);
                    if (this.f10836i.o()) {
                        this.f10832e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f10832e.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.f10832e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f10835h != null;
    }

    /* access modifiers changed from: package-private */
    public i.k0.h.c o(b0 b0Var, z.a aVar) {
        if (this.f10835h != null) {
            return new okhttp3.internal.http2.f(b0Var, this, aVar, this.f10835h);
        }
        this.f10832e.setSoTimeout(aVar.b());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f10836i.c().g((long) aVar.b(), timeUnit);
        this.f10837j.c().g((long) aVar.c(), timeUnit);
        return new a(b0Var, this, this.f10836i, this.f10837j);
    }

    public void p() {
        synchronized (this.f10829b) {
            this.f10838k = true;
        }
    }

    public i0 q() {
        return this.f10830c;
    }

    public Socket s() {
        return this.f10832e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f10830c.a().l().l());
        sb.append(":");
        sb.append(this.f10830c.a().l().w());
        sb.append(", proxy=");
        sb.append(this.f10830c.b());
        sb.append(" hostAddress=");
        sb.append(this.f10830c.d());
        sb.append(" cipherSuite=");
        w wVar = this.f10833f;
        sb.append(wVar != null ? wVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f10834g);
        sb.append('}');
        return sb.toString();
    }

    public boolean u(y yVar) {
        if (yVar.w() != this.f10830c.a().l().w()) {
            return false;
        }
        if (yVar.l().equals(this.f10830c.a().l().l())) {
            return true;
        }
        if (this.f10833f == null || !i.k0.m.d.f10573a.c(yVar.l(), (X509Certificate) this.f10833f.f().get(0))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void v(@Nullable IOException iOException) {
        synchronized (this.f10829b) {
            if (iOException instanceof StreamResetException) {
                okhttp3.internal.http2.a aVar = ((StreamResetException) iOException).f10870b;
                if (aVar == okhttp3.internal.http2.a.REFUSED_STREAM) {
                    int i2 = this.n + 1;
                    this.n = i2;
                    if (i2 > 1) {
                        this.f10838k = true;
                        this.l++;
                    }
                } else if (aVar != okhttp3.internal.http2.a.CANCEL) {
                    this.f10838k = true;
                    this.l++;
                }
            } else if (!n() || (iOException instanceof ConnectionShutdownException)) {
                this.f10838k = true;
                if (this.m == 0) {
                    if (iOException != null) {
                        this.f10829b.b(this.f10830c, iOException);
                    }
                    this.l++;
                }
            }
        }
    }
}
