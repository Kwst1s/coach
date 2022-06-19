package okhttp3.internal.connection;

import i.b0;
import i.e;
import i.e0;
import i.k0.c;
import i.l;
import i.v;
import i.y;
import i.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Transmitter */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f10857a;

    /* renamed from: b  reason: collision with root package name */
    private final g f10858b;

    /* renamed from: c  reason: collision with root package name */
    private final i.j f10859c;

    /* renamed from: d  reason: collision with root package name */
    private final v f10860d;

    /* renamed from: e  reason: collision with root package name */
    private final j.a f10861e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Object f10862f;

    /* renamed from: g  reason: collision with root package name */
    private e0 f10863g;

    /* renamed from: h  reason: collision with root package name */
    private e f10864h;

    /* renamed from: i  reason: collision with root package name */
    public f f10865i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private d f10866j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10867k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* compiled from: Transmitter */
    class a extends j.a {
        a() {
        }

        /* access modifiers changed from: protected */
        @Override // j.a
        public void t() {
            j.this.d();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Transmitter */
    public static final class b extends WeakReference<j> {

        /* renamed from: a  reason: collision with root package name */
        final Object f10869a;

        b(j jVar, Object obj) {
            super(jVar);
            this.f10869a = obj;
        }
    }

    public j(b0 b0Var, i.j jVar) {
        a aVar = new a();
        this.f10861e = aVar;
        this.f10857a = b0Var;
        this.f10858b = c.f10443a.h(b0Var.g());
        this.f10859c = jVar;
        this.f10860d = b0Var.m().a(jVar);
        aVar.g((long) b0Var.d(), TimeUnit.MILLISECONDS);
    }

    private e e(y yVar) {
        l lVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (yVar.m()) {
            SSLSocketFactory C = this.f10857a.C();
            hostnameVerifier = this.f10857a.p();
            sSLSocketFactory = C;
            lVar = this.f10857a.e();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            lVar = null;
        }
        return new e(yVar.l(), yVar.w(), this.f10857a.k(), this.f10857a.B(), sSLSocketFactory, hostnameVerifier, lVar, this.f10857a.x(), this.f10857a.w(), this.f10857a.v(), this.f10857a.h(), this.f10857a.y());
    }

    @Nullable
    private IOException j(@Nullable IOException iOException, boolean z) {
        f fVar;
        Socket n2;
        boolean z2;
        boolean z3;
        synchronized (this.f10858b) {
            if (z) {
                if (this.f10866j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            fVar = this.f10865i;
            n2 = (fVar == null || this.f10866j != null || (!z && !this.o)) ? null : n();
            if (this.f10865i != null) {
                fVar = null;
            }
            z2 = true;
            z3 = this.o && this.f10866j == null;
        }
        i.k0.e.e(n2);
        if (fVar != null) {
            this.f10860d.h(this.f10859c, fVar);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = q(iOException);
            if (z2) {
                this.f10860d.b(this.f10859c, iOException);
            } else {
                this.f10860d.a(this.f10859c);
            }
        }
        return iOException;
    }

    @Nullable
    private IOException q(@Nullable IOException iOException) {
        if (this.n || !this.f10861e.n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        if (this.f10865i == null) {
            this.f10865i = fVar;
            fVar.p.add(new b(this, this.f10862f));
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        this.f10862f = i.k0.k.e.j().n("response.body().close()");
        this.f10860d.c(this.f10859c);
    }

    public boolean c() {
        return this.f10864h.a();
    }

    public void d() {
        d dVar;
        f fVar;
        synchronized (this.f10858b) {
            this.m = true;
            dVar = this.f10866j;
            e eVar = this.f10864h;
            if (eVar == null || eVar.b() == null) {
                fVar = this.f10865i;
            } else {
                fVar = this.f10864h.b();
            }
        }
        if (dVar != null) {
            dVar.b();
        } else if (fVar != null) {
            fVar.c();
        }
    }

    public void f() {
        synchronized (this.f10858b) {
            if (!this.o) {
                this.f10866j = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return j(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r7;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.IOException g(okhttp3.internal.connection.d r4, boolean r5, boolean r6, @javax.annotation.Nullable java.io.IOException r7) {
        /*
            r3 = this;
            okhttp3.internal.connection.g r0 = r3.f10858b
            monitor-enter(r0)
            okhttp3.internal.connection.d r1 = r3.f10866j     // Catch:{ all -> 0x003d }
            if (r4 == r1) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r7
        L_0x0009:
            r4 = 0
            r2 = 1
            if (r5 == 0) goto L_0x0013
            boolean r5 = r3.f10867k     // Catch:{ all -> 0x003d }
            r5 = r5 ^ r2
            r3.f10867k = r2     // Catch:{ all -> 0x003d }
            goto L_0x0014
        L_0x0013:
            r5 = 0
        L_0x0014:
            if (r6 == 0) goto L_0x001d
            boolean r6 = r3.l     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x001b
            r5 = 1
        L_0x001b:
            r3.l = r2     // Catch:{ all -> 0x003d }
        L_0x001d:
            boolean r6 = r3.f10867k     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            boolean r6 = r3.l     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            if (r5 == 0) goto L_0x0034
            okhttp3.internal.connection.f r5 = r1.c()     // Catch:{ all -> 0x003d }
            int r6 = r5.m     // Catch:{ all -> 0x003d }
            int r6 = r6 + r2
            r5.m = r6     // Catch:{ all -> 0x003d }
            r5 = 0
            r3.f10866j = r5     // Catch:{ all -> 0x003d }
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x003c
            java.io.IOException r7 = r3.j(r7, r4)
        L_0x003c:
            return r7
        L_0x003d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.j.g(okhttp3.internal.connection.d, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public boolean h() {
        boolean z;
        synchronized (this.f10858b) {
            z = this.f10866j != null;
        }
        return z;
    }

    public boolean i() {
        boolean z;
        synchronized (this.f10858b) {
            z = this.m;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public d k(z.a aVar, boolean z) {
        synchronized (this.f10858b) {
            if (this.o) {
                throw new IllegalStateException("released");
            } else if (this.f10866j != null) {
                throw new IllegalStateException("exchange != null");
            }
        }
        d dVar = new d(this, this.f10859c, this.f10860d, this.f10864h, this.f10864h.c(this.f10857a, aVar, z));
        synchronized (this.f10858b) {
            this.f10866j = dVar;
            this.f10867k = false;
            this.l = false;
        }
        return dVar;
    }

    @Nullable
    public IOException l(@Nullable IOException iOException) {
        synchronized (this.f10858b) {
            this.o = true;
        }
        return j(iOException, false);
    }

    public void m(e0 e0Var) {
        e0 e0Var2 = this.f10863g;
        if (e0Var2 != null) {
            if (!i.k0.e.B(e0Var2.i(), e0Var.i())) {
                if (this.f10866j != null) {
                    throw new IllegalStateException();
                } else if (this.f10864h != null) {
                    j(null, true);
                    this.f10864h = null;
                }
            } else {
                return;
            }
        }
        this.f10863g = e0Var;
        this.f10864h = new e(this, this.f10858b, e(e0Var.i()), this.f10859c, this.f10860d);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Socket n() {
        int i2 = 0;
        int size = this.f10865i.p.size();
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.f10865i.p.get(i2).get() == this) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            f fVar = this.f10865i;
            fVar.p.remove(i2);
            this.f10865i = null;
            if (!fVar.p.isEmpty()) {
                return null;
            }
            fVar.q = System.nanoTime();
            if (this.f10858b.c(fVar)) {
                return fVar.s();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public void o() {
        if (!this.n) {
            this.n = true;
            this.f10861e.n();
            return;
        }
        throw new IllegalStateException();
    }

    public void p() {
        this.f10861e.k();
    }
}
