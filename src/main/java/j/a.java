package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout */
public class a extends u {

    /* renamed from: h  reason: collision with root package name */
    private static final long f10650h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f10651i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    static a f10652j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10653e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private a f10654f;

    /* renamed from: g  reason: collision with root package name */
    private long f10655g;

    /* access modifiers changed from: package-private */
    /* renamed from: j.a$a  reason: collision with other inner class name */
    /* compiled from: AsyncTimeout */
    public class C0238a implements s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f10656b;

        C0238a(s sVar) {
            this.f10656b = sVar;
        }

        @Override // j.s
        public u c() {
            return a.this;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        public void close() {
            a.this.k();
            try {
                this.f10656b.close();
                a.this.m(true);
            } catch (IOException e2) {
                throw a.this.l(e2);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // j.s
        public void e(c cVar, long j2) {
            v.b(cVar.f10663c, 0, j2);
            while (true) {
                long j3 = 0;
                if (j2 > 0) {
                    p pVar = cVar.f10662b;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += (long) (pVar.f10698c - pVar.f10697b);
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        pVar = pVar.f10701f;
                    }
                    a.this.k();
                    try {
                        this.f10656b.e(cVar, j3);
                        j2 -= j3;
                        a.this.m(true);
                    } catch (IOException e2) {
                        throw a.this.l(e2);
                    } catch (Throwable th) {
                        a.this.m(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // j.s, java.io.Flushable
        public void flush() {
            a.this.k();
            try {
                this.f10656b.flush();
                a.this.m(true);
            } catch (IOException e2) {
                throw a.this.l(e2);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f10656b + ")";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AsyncTimeout */
    public class b implements t {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f10658b;

        b(t tVar) {
            this.f10658b = tVar;
        }

        @Override // j.t
        public u c() {
            return a.this;
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.k();
            try {
                this.f10658b.close();
                a.this.m(true);
            } catch (IOException e2) {
                throw a.this.l(e2);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f10658b + ")";
        }

        @Override // j.t
        public long v(c cVar, long j2) {
            a.this.k();
            try {
                long v = this.f10658b.v(cVar, j2);
                a.this.m(true);
                return v;
            } catch (IOException e2) {
                throw a.this.l(e2);
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AsyncTimeout */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0015, code lost:
            r1.t();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<j.a> r0 = j.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                j.a r1 = j.a.i()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                j.a r2 = j.a.f10652j     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                j.a.f10652j = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.t()
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: j.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f10650h = millis;
        f10651i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    static a i() {
        a aVar = f10652j.f10654f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f10650h);
            if (f10652j.f10654f != null || System.nanoTime() - nanoTime < f10651i) {
                return null;
            }
            return f10652j;
        }
        long p = aVar.p(System.nanoTime());
        if (p > 0) {
            long j2 = p / 1000000;
            a.class.wait(j2, (int) (p - (1000000 * j2)));
            return null;
        }
        f10652j.f10654f = aVar.f10654f;
        aVar.f10654f = null;
        return aVar;
    }

    private static synchronized boolean j(a aVar) {
        synchronized (a.class) {
            a aVar2 = f10652j;
            while (aVar2 != null) {
                a aVar3 = aVar2.f10654f;
                if (aVar3 == aVar) {
                    aVar2.f10654f = aVar.f10654f;
                    aVar.f10654f = null;
                    return false;
                }
                aVar2 = aVar3;
            }
            return true;
        }
    }

    private long p(long j2) {
        return this.f10655g - j2;
    }

    private static synchronized void q(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (f10652j == null) {
                f10652j = new a();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            if (j2 != 0 && z) {
                aVar.f10655g = Math.min(j2, aVar.c() - nanoTime) + nanoTime;
            } else if (j2 != 0) {
                aVar.f10655g = j2 + nanoTime;
            } else if (z) {
                aVar.f10655g = aVar.c();
            } else {
                throw new AssertionError();
            }
            long p = aVar.p(nanoTime);
            a aVar2 = f10652j;
            while (true) {
                a aVar3 = aVar2.f10654f;
                if (aVar3 == null) {
                    break;
                } else if (p < aVar3.p(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f10654f;
                }
            }
            aVar.f10654f = aVar2.f10654f;
            aVar2.f10654f = aVar;
            if (aVar2 == f10652j) {
                a.class.notify();
            }
        }
    }

    public final void k() {
        if (!this.f10653e) {
            long h2 = h();
            boolean e2 = e();
            if (h2 != 0 || e2) {
                this.f10653e = true;
                q(this, h2, e2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* access modifiers changed from: package-private */
    public final IOException l(IOException iOException) {
        if (!n()) {
            return iOException;
        }
        return o(iOException);
    }

    /* access modifiers changed from: package-private */
    public final void m(boolean z) {
        if (n() && z) {
            throw o(null);
        }
    }

    public final boolean n() {
        if (!this.f10653e) {
            return false;
        }
        this.f10653e = false;
        return j(this);
    }

    /* access modifiers changed from: protected */
    public IOException o(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final s r(s sVar) {
        return new C0238a(sVar);
    }

    public final t s(t tVar) {
        return new b(tVar);
    }

    /* access modifiers changed from: protected */
    public void t() {
    }
}
