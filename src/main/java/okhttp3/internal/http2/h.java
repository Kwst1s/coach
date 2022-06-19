package okhttp3.internal.http2;

import i.x;
import j.e;
import j.s;
import j.t;
import j.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Http2Stream */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    long f10983a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f10984b;

    /* renamed from: c  reason: collision with root package name */
    final int f10985c;

    /* renamed from: d  reason: collision with root package name */
    final e f10986d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<x> f10987e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10988f;

    /* renamed from: g  reason: collision with root package name */
    private final b f10989g;

    /* renamed from: h  reason: collision with root package name */
    final a f10990h;

    /* renamed from: i  reason: collision with root package name */
    final c f10991i;

    /* renamed from: j  reason: collision with root package name */
    final c f10992j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    a f10993k;
    @Nullable
    IOException l;

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Stream */
    public final class a implements s {

        /* renamed from: b  reason: collision with root package name */
        private final j.c f10994b = new j.c();

        /* renamed from: c  reason: collision with root package name */
        private x f10995c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10996d;

        /* renamed from: e  reason: collision with root package name */
        boolean f10997e;

        a() {
        }

        private void l(boolean z) {
            h hVar;
            long min;
            h hVar2;
            boolean z2;
            synchronized (h.this) {
                h.this.f10992j.k();
                while (true) {
                    try {
                        hVar = h.this;
                        if (hVar.f10984b > 0 || this.f10997e || this.f10996d || hVar.f10993k != null) {
                            hVar.f10992j.u();
                            h.this.c();
                            min = Math.min(h.this.f10984b, this.f10994b.S());
                            hVar2 = h.this;
                            hVar2.f10984b -= min;
                        } else {
                            hVar.q();
                        }
                    } finally {
                        h.this.f10992j.u();
                    }
                }
                hVar.f10992j.u();
                h.this.c();
                min = Math.min(h.this.f10984b, this.f10994b.S());
                hVar2 = h.this;
                hVar2.f10984b -= min;
            }
            hVar2.f10992j.k();
            if (z) {
                try {
                    if (min == this.f10994b.S()) {
                        z2 = true;
                        h hVar3 = h.this;
                        hVar3.f10986d.Z(hVar3.f10985c, z2, this.f10994b, min);
                    }
                } catch (Throwable th) {
                    h.this.f10992j.u();
                    throw th;
                }
            }
            z2 = false;
            h hVar32 = h.this;
            hVar32.f10986d.Z(hVar32.f10985c, z2, this.f10994b, min);
        }

        @Override // j.s
        public u c() {
            return h.this.f10992j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r8.f10994b.S() <= 0) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r8.f10995c == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            if (r3 == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
            if (r8.f10994b.S() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            l(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
            r0 = r8.f10998f;
            r0.f10986d.a0(r0.f10985c, true, i.k0.e.G(r8.f10995c));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
            if (r2 == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            if (r8.f10994b.S() <= 0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
            l(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
            r0 = r8.f10998f;
            r0.f10986d.Z(r0.f10985c, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            r2 = r8.f10998f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r8.f10996d = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            r8.f10998f.f10986d.flush();
            r8.f10998f.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f10998f.f10990h.f10997e != false) goto L_0x0067;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
            // Method dump skipped, instructions count: 130
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.h.a.close():void");
        }

        @Override // j.s
        public void e(j.c cVar, long j2) {
            this.f10994b.e(cVar, j2);
            while (this.f10994b.S() >= 16384) {
                l(false);
            }
        }

        @Override // j.s, java.io.Flushable
        public void flush() {
            synchronized (h.this) {
                h.this.c();
            }
            while (this.f10994b.S() > 0) {
                l(false);
                h.this.f10986d.flush();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http2Stream */
    public final class b implements t {

        /* renamed from: b  reason: collision with root package name */
        private final j.c f10999b = new j.c();

        /* renamed from: c  reason: collision with root package name */
        private final j.c f11000c = new j.c();

        /* renamed from: d  reason: collision with root package name */
        private final long f11001d;

        /* renamed from: e  reason: collision with root package name */
        private x f11002e;

        /* renamed from: f  reason: collision with root package name */
        boolean f11003f;

        /* renamed from: g  reason: collision with root package name */
        boolean f11004g;

        b(long j2) {
            this.f11001d = j2;
        }

        private void F(long j2) {
            h.this.f10986d.Y(j2);
        }

        /* access modifiers changed from: package-private */
        public void E(e eVar, long j2) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j2 > 0) {
                synchronized (h.this) {
                    z = this.f11004g;
                    z2 = true;
                    z3 = this.f11000c.S() + j2 > this.f11001d;
                }
                if (z3) {
                    eVar.b(j2);
                    h.this.f(a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.b(j2);
                    return;
                } else {
                    long v = eVar.v(this.f10999b, j2);
                    if (v != -1) {
                        j2 -= v;
                        synchronized (h.this) {
                            if (this.f11000c.S() != 0) {
                                z2 = false;
                            }
                            this.f11000c.Z(this.f10999b);
                            if (z2) {
                                h.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // j.t
        public u c() {
            return h.this.f10991i;
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long S;
            synchronized (h.this) {
                this.f11003f = true;
                S = this.f11000c.S();
                this.f11000c.E();
                h.this.notifyAll();
            }
            if (S > 0) {
                F(S);
            }
            h.this.b();
        }

        @Override // j.t
        public long v(j.c cVar, long j2) {
            Throwable th;
            long v;
            if (j2 >= 0) {
                while (true) {
                    th = null;
                    synchronized (h.this) {
                        h.this.f10991i.k();
                        try {
                            h hVar = h.this;
                            if (hVar.f10993k != null) {
                                th = hVar.l;
                                if (th == null) {
                                    th = new StreamResetException(h.this.f10993k);
                                }
                            }
                            if (this.f11003f) {
                                throw new IOException("stream closed");
                            } else if (this.f11000c.S() > 0) {
                                j.c cVar2 = this.f11000c;
                                v = cVar2.v(cVar, Math.min(j2, cVar2.S()));
                                h hVar2 = h.this;
                                long j3 = hVar2.f10983a + v;
                                hVar2.f10983a = j3;
                                if (th == null && j3 >= ((long) (hVar2.f10986d.o.d() / 2))) {
                                    h hVar3 = h.this;
                                    hVar3.f10986d.e0(hVar3.f10985c, hVar3.f10983a);
                                    h.this.f10983a = 0;
                                }
                            } else if (this.f11004g || th != null) {
                                v = -1;
                            } else {
                                h.this.q();
                            }
                        } finally {
                            h.this.f10991i.u();
                        }
                    }
                }
                h.this.f10991i.u();
                if (v != -1) {
                    F(v);
                    return v;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Stream */
    public class c extends j.a {
        c() {
        }

        /* access modifiers changed from: protected */
        @Override // j.a
        public IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        @Override // j.a
        public void t() {
            h.this.f(a.CANCEL);
        }

        public void u() {
            if (n()) {
                throw o(null);
            }
        }
    }

    h(int i2, e eVar, boolean z, boolean z2, @Nullable x xVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f10987e = arrayDeque;
        this.f10991i = new c();
        this.f10992j = new c();
        Objects.requireNonNull(eVar, "connection == null");
        this.f10985c = i2;
        this.f10986d = eVar;
        this.f10984b = (long) eVar.p.d();
        b bVar = new b((long) eVar.o.d());
        this.f10989g = bVar;
        a aVar = new a();
        this.f10990h = aVar;
        bVar.f11004g = z2;
        aVar.f10997e = z;
        if (xVar != null) {
            arrayDeque.add(xVar);
        }
        if (j() && xVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        } else if (!j() && xVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean e(a aVar, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.f10993k != null) {
                return false;
            }
            if (this.f10989g.f11004g && this.f10990h.f10997e) {
                return false;
            }
            this.f10993k = aVar;
            this.l = iOException;
            notifyAll();
            this.f10986d.U(this.f10985c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f10984b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        boolean z;
        boolean k2;
        synchronized (this) {
            b bVar = this.f10989g;
            if (!bVar.f11004g && bVar.f11003f) {
                a aVar = this.f10990h;
                if (aVar.f10997e || aVar.f10996d) {
                    z = true;
                    k2 = k();
                }
            }
            z = false;
            k2 = k();
        }
        if (z) {
            d(a.CANCEL, null);
        } else if (!k2) {
            this.f10986d.U(this.f10985c);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a aVar = this.f10990h;
        if (aVar.f10996d) {
            throw new IOException("stream closed");
        } else if (aVar.f10997e) {
            throw new IOException("stream finished");
        } else if (this.f10993k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.f10993k);
        }
    }

    public void d(a aVar, @Nullable IOException iOException) {
        if (e(aVar, iOException)) {
            this.f10986d.c0(this.f10985c, aVar);
        }
    }

    public void f(a aVar) {
        if (e(aVar, null)) {
            this.f10986d.d0(this.f10985c, aVar);
        }
    }

    public int g() {
        return this.f10985c;
    }

    public s h() {
        synchronized (this) {
            if (!this.f10988f) {
                if (!j()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f10990h;
    }

    public t i() {
        return this.f10989g;
    }

    public boolean j() {
        if (this.f10986d.f10913b == ((this.f10985c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean k() {
        if (this.f10993k != null) {
            return false;
        }
        b bVar = this.f10989g;
        if (bVar.f11004g || bVar.f11003f) {
            a aVar = this.f10990h;
            if ((aVar.f10997e || aVar.f10996d) && this.f10988f) {
                return false;
            }
        }
        return true;
    }

    public u l() {
        return this.f10991i;
    }

    /* access modifiers changed from: package-private */
    public void m(e eVar, int i2) {
        this.f10989g.E(eVar, (long) i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(i.x r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f10988f     // Catch:{ all -> 0x002e }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            if (r4 != 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            okhttp3.internal.http2.h$b r0 = r2.f10989g     // Catch:{ all -> 0x002e }
            okhttp3.internal.http2.h.b.l(r0, r3)     // Catch:{ all -> 0x002e }
            goto L_0x0016
        L_0x000f:
            r2.f10988f = r1     // Catch:{ all -> 0x002e }
            java.util.Deque<i.x> r0 = r2.f10987e     // Catch:{ all -> 0x002e }
            r0.add(r3)     // Catch:{ all -> 0x002e }
        L_0x0016:
            if (r4 == 0) goto L_0x001c
            okhttp3.internal.http2.h$b r3 = r2.f10989g     // Catch:{ all -> 0x002e }
            r3.f11004g = r1     // Catch:{ all -> 0x002e }
        L_0x001c:
            boolean r3 = r2.k()     // Catch:{ all -> 0x002e }
            r2.notifyAll()     // Catch:{ all -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x002d
            okhttp3.internal.http2.e r3 = r2.f10986d
            int r4 = r2.f10985c
            r3.U(r4)
        L_0x002d:
            return
        L_0x002e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.h.n(i.x, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void o(a aVar) {
        if (this.f10993k == null) {
            this.f10993k = aVar;
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized x p() {
        this.f10991i.k();
        while (this.f10987e.isEmpty() && this.f10993k == null) {
            try {
                q();
            } catch (Throwable th) {
                this.f10991i.u();
                throw th;
            }
        }
        this.f10991i.u();
        if (!this.f10987e.isEmpty()) {
        } else {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.f10993k);
        }
        return this.f10987e.removeFirst();
    }

    /* access modifiers changed from: package-private */
    public void q() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public u r() {
        return this.f10992j;
    }
}
