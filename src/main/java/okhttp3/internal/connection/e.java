package okhttp3.internal.connection;

import i.b0;
import i.i0;
import i.j;
import i.k0.h.c;
import i.v;
import i.z;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.i;

/* access modifiers changed from: package-private */
/* compiled from: ExchangeFinder */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final j f10820a;

    /* renamed from: b  reason: collision with root package name */
    private final i.e f10821b;

    /* renamed from: c  reason: collision with root package name */
    private final g f10822c;

    /* renamed from: d  reason: collision with root package name */
    private final j f10823d;

    /* renamed from: e  reason: collision with root package name */
    private final v f10824e;

    /* renamed from: f  reason: collision with root package name */
    private i.a f10825f;

    /* renamed from: g  reason: collision with root package name */
    private final i f10826g;

    /* renamed from: h  reason: collision with root package name */
    private f f10827h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10828i;

    e(j jVar, g gVar, i.e eVar, j jVar2, v vVar) {
        this.f10820a = jVar;
        this.f10822c = gVar;
        this.f10821b = eVar;
        this.f10823d = jVar2;
        this.f10824e = vVar;
        this.f10826g = new i(eVar, gVar.f10844e, jVar2, vVar);
    }

    private f d(int i2, int i3, int i4, int i5, boolean z) {
        Socket socket;
        i0 q;
        f fVar;
        Socket n;
        f fVar2;
        boolean z2;
        boolean z3;
        List<i0> list;
        i.a aVar;
        synchronized (this.f10822c) {
            if (!this.f10820a.i()) {
                this.f10828i = false;
                socket = null;
                q = f() ? this.f10820a.f10865i.q() : null;
                j jVar = this.f10820a;
                fVar = jVar.f10865i;
                n = (fVar == null || !fVar.f10838k) ? null : jVar.n();
                j jVar2 = this.f10820a;
                fVar2 = jVar2.f10865i;
                if (fVar2 != null) {
                    fVar = null;
                } else {
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    q = null;
                } else if (this.f10822c.h(this.f10821b, jVar2, null, false)) {
                    fVar2 = this.f10820a.f10865i;
                    q = null;
                    z2 = true;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        i.k0.e.e(n);
        if (fVar != null) {
            this.f10824e.h(this.f10823d, fVar);
        }
        if (z2) {
            this.f10824e.g(this.f10823d, fVar2);
        }
        if (fVar2 != null) {
            return fVar2;
        }
        if (q != null || ((aVar = this.f10825f) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f10825f = this.f10826g.d();
            z3 = true;
        }
        synchronized (this.f10822c) {
            if (!this.f10820a.i()) {
                if (z3) {
                    list = this.f10825f.a();
                    if (this.f10822c.h(this.f10821b, this.f10820a, list, false)) {
                        fVar2 = this.f10820a.f10865i;
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (q == null) {
                        q = this.f10825f.c();
                    }
                    fVar2 = new f(this.f10822c, q);
                    this.f10827h = fVar2;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.f10824e.g(this.f10823d, fVar2);
            return fVar2;
        }
        fVar2.d(i2, i3, i4, i5, z, this.f10823d, this.f10824e);
        this.f10822c.f10844e.a(fVar2.q());
        synchronized (this.f10822c) {
            this.f10827h = null;
            if (this.f10822c.h(this.f10821b, this.f10820a, list, true)) {
                fVar2.f10838k = true;
                socket = fVar2.s();
                fVar2 = this.f10820a.f10865i;
            } else {
                this.f10822c.g(fVar2);
                this.f10820a.a(fVar2);
            }
        }
        i.k0.e.e(socket);
        this.f10824e.g(this.f10823d, fVar2);
        return fVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.m(r9) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.f e(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.f r0 = r3.d(r4, r5, r6, r7, r8)
            okhttp3.internal.connection.g r1 = r3.f10822c
            monitor-enter(r1)
            int r2 = r0.m     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.m(r9)
            if (r1 != 0) goto L_0x0018
            r0.p()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.e(int, int, int, int, boolean, boolean):okhttp3.internal.connection.f");
    }

    private boolean f() {
        f fVar = this.f10820a.f10865i;
        return fVar != null && fVar.l == 0 && i.k0.e.B(fVar.q().a().l(), this.f10821b.l());
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        i.a aVar;
        synchronized (this.f10822c) {
            boolean z = false;
            if (!this.f10828i) {
                return false;
            }
            if (f() || (((aVar = this.f10825f) != null && aVar.b()) || this.f10826g.b())) {
                z = true;
            }
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public f b() {
        return this.f10827h;
    }

    public c c(b0 b0Var, z.a aVar, boolean z) {
        try {
            return e(aVar.a(), aVar.b(), aVar.c(), b0Var.u(), b0Var.A(), z).o(b0Var, aVar);
        } catch (RouteException e2) {
            g();
            throw e2;
        } catch (IOException e3) {
            g();
            throw new RouteException(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        synchronized (this.f10822c) {
            this.f10828i = true;
        }
    }
}
