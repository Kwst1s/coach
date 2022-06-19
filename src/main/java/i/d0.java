package i;

import com.github.mikephil.charting.BuildConfig;
import i.k0.d;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.connection.j;

/* access modifiers changed from: package-private */
/* compiled from: RealCall */
public final class d0 implements j {

    /* renamed from: b  reason: collision with root package name */
    final b0 f10323b;

    /* renamed from: c  reason: collision with root package name */
    private j f10324c;

    /* renamed from: d  reason: collision with root package name */
    final e0 f10325d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f10326e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10327f;

    /* access modifiers changed from: package-private */
    /* compiled from: RealCall */
    public final class a extends d {

        /* renamed from: c  reason: collision with root package name */
        private final k f10328c;

        /* renamed from: d  reason: collision with root package name */
        private volatile AtomicInteger f10329d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d0 f10330e;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[SYNTHETIC, Splitter:B:12:0x002d] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ all -> 0x0026 }] */
        @Override // i.k0.d
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k() {
            /*
                r5 = this;
                i.d0 r0 = r5.f10330e
                okhttp3.internal.connection.j r0 = i.d0.a(r0)
                r0.p()
                r0 = 0
                i.d0 r1 = r5.f10330e     // Catch:{ IOException -> 0x0028 }
                i.g0 r0 = r1.c()     // Catch:{ IOException -> 0x0028 }
                r1 = 1
                i.k r2 = r5.f10328c     // Catch:{ IOException -> 0x0024 }
                i.d0 r3 = r5.f10330e     // Catch:{ IOException -> 0x0024 }
                r2.a(r3, r0)     // Catch:{ IOException -> 0x0024 }
            L_0x0018:
                i.d0 r0 = r5.f10330e
                i.b0 r0 = r0.f10323b
                i.s r0 = r0.j()
                r0.d(r5)
                goto L_0x0055
            L_0x0024:
                r0 = move-exception
                goto L_0x002b
            L_0x0026:
                r0 = move-exception
                goto L_0x0056
            L_0x0028:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x002b:
                if (r1 == 0) goto L_0x004d
                i.k0.k.e r1 = i.k0.k.e.j()     // Catch:{ all -> 0x0026 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                r3.<init>()     // Catch:{ all -> 0x0026 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0026 }
                i.d0 r4 = r5.f10330e     // Catch:{ all -> 0x0026 }
                java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0026 }
                r3.append(r4)     // Catch:{ all -> 0x0026 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0026 }
                r1.q(r2, r3, r0)     // Catch:{ all -> 0x0026 }
                goto L_0x0018
            L_0x004d:
                i.k r1 = r5.f10328c     // Catch:{ all -> 0x0026 }
                i.d0 r2 = r5.f10330e     // Catch:{ all -> 0x0026 }
                r1.b(r2, r0)     // Catch:{ all -> 0x0026 }
                goto L_0x0018
            L_0x0055:
                return
            L_0x0056:
                i.d0 r1 = r5.f10330e
                i.b0 r1 = r1.f10323b
                i.s r1 = r1.j()
                r1.d(r5)
                goto L_0x0063
            L_0x0062:
                throw r0
            L_0x0063:
                goto L_0x0062
            */
            throw new UnsupportedOperationException("Method not decompiled: i.d0.a.k():void");
        }

        /* access modifiers changed from: package-private */
        public AtomicInteger l() {
            return this.f10329d;
        }

        /* access modifiers changed from: package-private */
        public void m(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                this.f10330e.f10324c.l(interruptedIOException);
                this.f10328c.b(this.f10330e, interruptedIOException);
                this.f10330e.f10323b.j().d(this);
            } catch (Throwable th) {
                this.f10330e.f10323b.j().d(this);
                throw th;
            }
        }
    }

    private d0(b0 b0Var, e0 e0Var, boolean z) {
        this.f10323b = b0Var;
        this.f10325d = e0Var;
        this.f10326e = z;
    }

    static d0 e(b0 b0Var, e0 e0Var, boolean z) {
        d0 d0Var = new d0(b0Var, e0Var, z);
        d0Var.f10324c = new j(b0Var, d0Var);
        return d0Var;
    }

    /* renamed from: b */
    public d0 clone() {
        return e(this.f10323b, this.f10325d, this.f10326e);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i.g0 c() {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: i.d0.c():i.g0");
    }

    public boolean d() {
        return this.f10324c.i();
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f10325d.i().z();
    }

    /* access modifiers changed from: package-private */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : BuildConfig.FLAVOR);
        sb.append(this.f10326e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }

    @Override // i.j
    public g0 l() {
        synchronized (this) {
            if (!this.f10327f) {
                this.f10327f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f10324c.p();
        this.f10324c.b();
        try {
            this.f10323b.j().a(this);
            return c();
        } finally {
            this.f10323b.j().e(this);
        }
    }
}
