package okhttp3.internal.connection;

import i.i0;
import i.k0.e;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.j;

/* compiled from: RealConnectionPool */
public final class g {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f10839g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.F("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    private final int f10840a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10841b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f10842c = new a(this);

    /* renamed from: d  reason: collision with root package name */
    private final Deque<f> f10843d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    final h f10844e = new h();

    /* renamed from: f  reason: collision with root package name */
    boolean f10845f;

    public g(int i2, long j2, TimeUnit timeUnit) {
        this.f10840a = i2;
        this.f10841b = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void e() {
        /*
            r6 = this;
        L_0x0000:
            long r0 = java.lang.System.nanoTime()
            long r0 = r6.a(r0)
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000f
            return
        L_0x000f:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0000
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r0 / r2
            long r2 = r2 * r4
            long r0 = r0 - r2
            monitor-enter(r6)
            int r1 = (int) r0
            r6.wait(r4, r1)     // Catch:{ InterruptedException -> 0x0025 }
            goto L_0x0025
        L_0x0023:
            r0 = move-exception
            goto L_0x0027
        L_0x0025:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            goto L_0x0000
        L_0x0027:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            goto L_0x002a
        L_0x0029:
            throw r0
        L_0x002a:
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.g.e():void");
    }

    private int f(f fVar, long j2) {
        List<Reference<j>> list = fVar.p;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<j> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                i.k0.k.e.j().r("A connection to " + fVar.q().a().l() + " was leaked. Did you forget to close a response body?", ((j.b) reference).f10869a);
                list.remove(i2);
                fVar.f10838k = true;
                if (list.isEmpty()) {
                    fVar.q = j2 - this.f10841b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long a(long j2) {
        synchronized (this) {
            f fVar = null;
            long j3 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (f fVar2 : this.f10843d) {
                if (f(fVar2, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - fVar2.q;
                    if (j4 > j3) {
                        fVar = fVar2;
                        j3 = j4;
                    }
                }
            }
            long j5 = this.f10841b;
            if (j3 < j5) {
                if (i2 <= this.f10840a) {
                    if (i2 > 0) {
                        return j5 - j3;
                    } else if (i3 > 0) {
                        return j5;
                    } else {
                        this.f10845f = false;
                        return -1;
                    }
                }
            }
            this.f10843d.remove(fVar);
            e.e(fVar.s());
            return 0;
        }
    }

    public void b(i0 i0Var, IOException iOException) {
        if (i0Var.b().type() != Proxy.Type.DIRECT) {
            i.e a2 = i0Var.a();
            a2.i().connectFailed(a2.l().C(), i0Var.b().address(), iOException);
        }
        this.f10844e.b(i0Var);
    }

    /* access modifiers changed from: package-private */
    public boolean c(f fVar) {
        if (fVar.f10838k || this.f10840a == 0) {
            this.f10843d.remove(fVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    public void g(f fVar) {
        if (!this.f10845f) {
            this.f10845f = true;
            f10839g.execute(this.f10842c);
        }
        this.f10843d.add(fVar);
    }

    /* access modifiers changed from: package-private */
    public boolean h(i.e eVar, j jVar, @Nullable List<i0> list, boolean z) {
        for (f fVar : this.f10843d) {
            if ((!z || fVar.n()) && fVar.l(eVar, list)) {
                jVar.a(fVar);
                return true;
            }
        }
        return false;
    }
}
