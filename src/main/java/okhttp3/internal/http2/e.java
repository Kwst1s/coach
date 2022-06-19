package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http2.g;

/* compiled from: Http2Connection */
public final class e implements Closeable {
    private static final ExecutorService v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), i.k0.e.F("OkHttp Http2Connection", true));

    /* renamed from: b  reason: collision with root package name */
    final boolean f10913b;

    /* renamed from: c  reason: collision with root package name */
    final h f10914c;

    /* renamed from: d  reason: collision with root package name */
    final Map<Integer, h> f10915d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    final String f10916e;

    /* renamed from: f  reason: collision with root package name */
    int f10917f;

    /* renamed from: g  reason: collision with root package name */
    int f10918g;

    /* renamed from: h  reason: collision with root package name */
    boolean f10919h;

    /* renamed from: i  reason: collision with root package name */
    private final ScheduledExecutorService f10920i;

    /* renamed from: j  reason: collision with root package name */
    private final ExecutorService f10921j;

    /* renamed from: k  reason: collision with root package name */
    final k f10922k;
    private boolean l;
    long m = 0;
    long n;
    l o = new l();
    final l p;
    boolean q;
    final Socket r;
    final i s;
    final j t;
    final Set<Integer> u;

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class a extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10923c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f10924d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i2, a aVar) {
            super(str, objArr);
            this.f10923c = i2;
            this.f10924d = aVar;
        }

        @Override // i.k0.d
        public void k() {
            try {
                e.this.c0(this.f10923c, this.f10924d);
            } catch (IOException e2) {
                e.this.I(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class b extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10926c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f10927d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i2, long j2) {
            super(str, objArr);
            this.f10926c = i2;
            this.f10927d = j2;
        }

        @Override // i.k0.d
        public void k() {
            try {
                e.this.s.P(this.f10926c, this.f10927d);
            } catch (IOException e2) {
                e.this.I(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class c extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10929c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f10930d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f10929c = i2;
            this.f10930d = list;
        }

        @Override // i.k0.d
        public void k() {
            if (e.this.f10922k.a(this.f10929c, this.f10930d)) {
                try {
                    e.this.s.N(this.f10929c, a.CANCEL);
                    synchronized (e.this) {
                        e.this.u.remove(Integer.valueOf(this.f10929c));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class d extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10932c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f10933d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f10934e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f10932c = i2;
            this.f10933d = list;
            this.f10934e = z;
        }

        @Override // i.k0.d
        public void k() {
            boolean b2 = e.this.f10922k.b(this.f10932c, this.f10933d, this.f10934e);
            if (b2) {
                try {
                    e.this.s.N(this.f10932c, a.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (b2 || this.f10934e) {
                synchronized (e.this) {
                    e.this.u.remove(Integer.valueOf(this.f10932c));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: okhttp3.internal.http2.e$e  reason: collision with other inner class name */
    /* compiled from: Http2Connection */
    public class C0242e extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10936c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j.c f10937d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f10938e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f10939f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0242e(String str, Object[] objArr, int i2, j.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.f10936c = i2;
            this.f10937d = cVar;
            this.f10938e = i3;
            this.f10939f = z;
        }

        @Override // i.k0.d
        public void k() {
            try {
                boolean d2 = e.this.f10922k.d(this.f10936c, this.f10937d, this.f10938e, this.f10939f);
                if (d2) {
                    e.this.s.N(this.f10936c, a.CANCEL);
                }
                if (d2 || this.f10939f) {
                    synchronized (e.this) {
                        e.this.u.remove(Integer.valueOf(this.f10936c));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class f extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10941c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f10942d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i2, a aVar) {
            super(str, objArr);
            this.f10941c = i2;
            this.f10942d = aVar;
        }

        @Override // i.k0.d
        public void k() {
            e.this.f10922k.c(this.f10941c, this.f10942d);
            synchronized (e.this) {
                e.this.u.remove(Integer.valueOf(this.f10941c));
            }
        }
    }

    /* compiled from: Http2Connection */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        Socket f10944a;

        /* renamed from: b  reason: collision with root package name */
        String f10945b;

        /* renamed from: c  reason: collision with root package name */
        j.e f10946c;

        /* renamed from: d  reason: collision with root package name */
        j.d f10947d;

        /* renamed from: e  reason: collision with root package name */
        h f10948e = h.f10952a;

        /* renamed from: f  reason: collision with root package name */
        k f10949f = k.f11021a;

        /* renamed from: g  reason: collision with root package name */
        boolean f10950g;

        /* renamed from: h  reason: collision with root package name */
        int f10951h;

        public g(boolean z) {
            this.f10950g = z;
        }

        public e a() {
            return new e(this);
        }

        public g b(h hVar) {
            this.f10948e = hVar;
            return this;
        }

        public g c(int i2) {
            this.f10951h = i2;
            return this;
        }

        public g d(Socket socket, String str, j.e eVar, j.d dVar) {
            this.f10944a = socket;
            this.f10945b = str;
            this.f10946c = eVar;
            this.f10947d = dVar;
            return this;
        }
    }

    /* compiled from: Http2Connection */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public static final h f10952a = new a();

        /* compiled from: Http2Connection */
        class a extends h {
            a() {
            }

            @Override // okhttp3.internal.http2.e.h
            public void b(h hVar) {
                hVar.d(a.REFUSED_STREAM, null);
            }
        }

        public void a(e eVar) {
        }

        public abstract void b(h hVar);
    }

    /* compiled from: Http2Connection */
    final class i extends i.k0.d {

        /* renamed from: c  reason: collision with root package name */
        final boolean f10953c;

        /* renamed from: d  reason: collision with root package name */
        final int f10954d;

        /* renamed from: e  reason: collision with root package name */
        final int f10955e;

        i(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", e.this.f10916e, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f10953c = z;
            this.f10954d = i2;
            this.f10955e = i3;
        }

        @Override // i.k0.d
        public void k() {
            e.this.b0(this.f10953c, this.f10954d, this.f10955e);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Connection */
    public class j extends i.k0.d implements g.b {

        /* renamed from: c  reason: collision with root package name */
        final g f10957c;

        /* compiled from: Http2Connection */
        class a extends i.k0.d {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ h f10959c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, h hVar) {
                super(str, objArr);
                this.f10959c = hVar;
            }

            @Override // i.k0.d
            public void k() {
                try {
                    e.this.f10914c.b(this.f10959c);
                } catch (IOException e2) {
                    i.k0.k.e j2 = i.k0.k.e.j();
                    j2.q(4, "Http2Connection.Listener failure for " + e.this.f10916e, e2);
                    try {
                        this.f10959c.d(a.PROTOCOL_ERROR, e2);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection */
        class b extends i.k0.d {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // i.k0.d
            public void k() {
                e eVar = e.this;
                eVar.f10914c.a(eVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Http2Connection */
        public class c extends i.k0.d {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ l f10962c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, l lVar) {
                super(str, objArr);
                this.f10962c = lVar;
            }

            @Override // i.k0.d
            public void k() {
                try {
                    e.this.s.l(this.f10962c);
                } catch (IOException e2) {
                    e.this.I(e2);
                }
            }
        }

        j(g gVar) {
            super("OkHttp %s", e.this.f10916e);
            this.f10957c = gVar;
        }

        private void l(l lVar) {
            try {
                e.this.f10920i.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f10916e}, lVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void a() {
        }

        @Override // okhttp3.internal.http2.g.b
        public void b(boolean z, l lVar) {
            h[] hVarArr;
            long j2;
            int i2;
            synchronized (e.this) {
                int d2 = e.this.p.d();
                if (z) {
                    e.this.p.a();
                }
                e.this.p.h(lVar);
                l(lVar);
                int d3 = e.this.p.d();
                hVarArr = null;
                if (d3 == -1 || d3 == d2) {
                    j2 = 0;
                } else {
                    j2 = (long) (d3 - d2);
                    e eVar = e.this;
                    if (!eVar.q) {
                        eVar.q = true;
                    }
                    if (!eVar.f10915d.isEmpty()) {
                        hVarArr = (h[]) e.this.f10915d.values().toArray(new h[e.this.f10915d.size()]);
                    }
                }
                e.v.execute(new b("OkHttp %s settings", e.this.f10916e));
            }
            if (!(hVarArr == null || j2 == 0)) {
                for (h hVar : hVarArr) {
                    synchronized (hVar) {
                        hVar.a(j2);
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void c(boolean z, int i2, j.e eVar, int i3) {
            if (e.this.T(i2)) {
                e.this.O(i2, eVar, i3, z);
                return;
            }
            h J = e.this.J(i2);
            if (J == null) {
                e.this.d0(i2, a.PROTOCOL_ERROR);
                long j2 = (long) i3;
                e.this.Y(j2);
                eVar.b(j2);
                return;
            }
            J.m(eVar, i3);
            if (z) {
                J.n(i.k0.e.f10447c, true);
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void d(boolean z, int i2, int i3) {
            if (z) {
                synchronized (e.this) {
                    e.this.l = false;
                    e.this.notifyAll();
                }
                return;
            }
            try {
                e.this.f10920i.execute(new i(true, i2, i3));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void e(int i2, int i3, int i4, boolean z) {
        }

        @Override // okhttp3.internal.http2.g.b
        public void f(int i2, a aVar) {
            if (e.this.T(i2)) {
                e.this.S(i2, aVar);
                return;
            }
            h U = e.this.U(i2);
            if (U != null) {
                U.o(aVar);
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void g(boolean z, int i2, int i3, List<b> list) {
            if (e.this.T(i2)) {
                e.this.Q(i2, list, z);
                return;
            }
            synchronized (e.this) {
                h J = e.this.J(i2);
                if (J == null) {
                    e eVar = e.this;
                    if (!eVar.f10919h) {
                        if (i2 > eVar.f10917f) {
                            if (i2 % 2 != eVar.f10918g % 2) {
                                h hVar = new h(i2, e.this, false, z, i.k0.e.H(list));
                                e eVar2 = e.this;
                                eVar2.f10917f = i2;
                                eVar2.f10915d.put(Integer.valueOf(i2), hVar);
                                e.v.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f10916e, Integer.valueOf(i2)}, hVar));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                J.n(i.k0.e.H(list), z);
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void h(int i2, long j2) {
            if (i2 == 0) {
                synchronized (e.this) {
                    e eVar = e.this;
                    eVar.n += j2;
                    eVar.notifyAll();
                }
                return;
            }
            h J = e.this.J(i2);
            if (J != null) {
                synchronized (J) {
                    J.a(j2);
                }
            }
        }

        @Override // okhttp3.internal.http2.g.b
        public void i(int i2, int i3, List<b> list) {
            e.this.R(i3, list);
        }

        @Override // okhttp3.internal.http2.g.b
        public void j(int i2, a aVar, j.f fVar) {
            h[] hVarArr;
            fVar.r();
            synchronized (e.this) {
                hVarArr = (h[]) e.this.f10915d.values().toArray(new h[e.this.f10915d.size()]);
                e.this.f10919h = true;
            }
            for (h hVar : hVarArr) {
                if (hVar.g() > i2 && hVar.j()) {
                    hVar.o(a.REFUSED_STREAM);
                    e.this.U(hVar.g());
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // i.k0.d
        public void k() {
            Throwable th;
            a aVar;
            a aVar2 = a.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                this.f10957c.F(this);
                while (this.f10957c.E(false, this)) {
                }
                aVar = a.NO_ERROR;
                try {
                    e.this.H(aVar, a.CANCEL, null);
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        a aVar3 = a.PROTOCOL_ERROR;
                        e.this.H(aVar3, aVar3, e2);
                        i.k0.e.d(this.f10957c);
                    } catch (Throwable th2) {
                        th = th2;
                        e.this.H(aVar, aVar2, e2);
                        i.k0.e.d(this.f10957c);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e2 = e4;
                aVar = aVar2;
                a aVar32 = a.PROTOCOL_ERROR;
                e.this.H(aVar32, aVar32, e2);
                i.k0.e.d(this.f10957c);
            } catch (Throwable th3) {
                th = th3;
                aVar = aVar2;
                e.this.H(aVar, aVar2, e2);
                i.k0.e.d(this.f10957c);
                throw th;
            }
            i.k0.e.d(this.f10957c);
        }
    }

    e(g gVar) {
        l lVar = new l();
        this.p = lVar;
        this.q = false;
        this.u = new LinkedHashSet();
        this.f10922k = gVar.f10949f;
        boolean z = gVar.f10950g;
        this.f10913b = z;
        this.f10914c = gVar.f10948e;
        int i2 = z ? 1 : 2;
        this.f10918g = i2;
        if (z) {
            this.f10918g = i2 + 2;
        }
        if (z) {
            this.o.i(7, 16777216);
        }
        String str = gVar.f10945b;
        this.f10916e = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, i.k0.e.F(i.k0.e.n("OkHttp %s Writer", str), false));
        this.f10920i = scheduledThreadPoolExecutor;
        if (gVar.f10951h != 0) {
            i iVar = new i(false, 0, 0);
            int i3 = gVar.f10951h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i3, (long) i3, TimeUnit.MILLISECONDS);
        }
        this.f10921j = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), i.k0.e.F(i.k0.e.n("OkHttp %s Push Observer", str), true));
        lVar.i(7, 65535);
        lVar.i(5, 16384);
        this.n = (long) lVar.d();
        this.r = gVar.f10944a;
        this.s = new i(gVar.f10947d, z);
        this.t = new j(new g(gVar.f10946c, z));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void I(@Nullable IOException iOException) {
        a aVar = a.PROTOCOL_ERROR;
        H(aVar, aVar, iOException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.h M(int r11, java.util.List<okhttp3.internal.http2.b> r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.M(int, java.util.List, boolean):okhttp3.internal.http2.h");
    }

    private synchronized void P(i.k0.d dVar) {
        if (!K()) {
            this.f10921j.execute(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(okhttp3.internal.http2.a r4, okhttp3.internal.http2.a r5, @javax.annotation.Nullable java.io.IOException r6) {
        /*
            r3 = this;
            r3.V(r4)     // Catch:{ IOException -> 0x0003 }
        L_0x0003:
            r4 = 0
            monitor-enter(r3)
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r0 = r3.f10915d     // Catch:{ all -> 0x004a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0026
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r4 = r3.f10915d     // Catch:{ all -> 0x004a }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x004a }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r0 = r3.f10915d     // Catch:{ all -> 0x004a }
            int r0 = r0.size()     // Catch:{ all -> 0x004a }
            okhttp3.internal.http2.h[] r0 = new okhttp3.internal.http2.h[r0]     // Catch:{ all -> 0x004a }
            java.lang.Object[] r4 = r4.toArray(r0)     // Catch:{ all -> 0x004a }
            okhttp3.internal.http2.h[] r4 = (okhttp3.internal.http2.h[]) r4     // Catch:{ all -> 0x004a }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r0 = r3.f10915d     // Catch:{ all -> 0x004a }
            r0.clear()     // Catch:{ all -> 0x004a }
        L_0x0026:
            monitor-exit(r3)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0035
            int r0 = r4.length
            r1 = 0
        L_0x002b:
            if (r1 >= r0) goto L_0x0035
            r2 = r4[r1]
            r2.d(r5, r6)     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            int r1 = r1 + 1
            goto L_0x002b
        L_0x0035:
            okhttp3.internal.http2.i r4 = r3.s     // Catch:{ IOException -> 0x003a }
            r4.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            java.net.Socket r4 = r3.r     // Catch:{ IOException -> 0x003f }
            r4.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            java.util.concurrent.ScheduledExecutorService r4 = r3.f10920i
            r4.shutdown()
            java.util.concurrent.ExecutorService r4 = r3.f10921j
            r4.shutdown()
            return
        L_0x004a:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x004e
        L_0x004d:
            throw r4
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.H(okhttp3.internal.http2.a, okhttp3.internal.http2.a, java.io.IOException):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized h J(int i2) {
        return this.f10915d.get(Integer.valueOf(i2));
    }

    public synchronized boolean K() {
        return this.f10919h;
    }

    public synchronized int L() {
        return this.p.e(Integer.MAX_VALUE);
    }

    public h N(List<b> list, boolean z) {
        return M(0, list, z);
    }

    /* access modifiers changed from: package-private */
    public void O(int i2, j.e eVar, int i3, boolean z) {
        j.c cVar = new j.c();
        long j2 = (long) i3;
        eVar.x(j2);
        eVar.v(cVar, j2);
        if (cVar.S() == j2) {
            P(new C0242e("OkHttp %s Push Data[%s]", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.S() + " != " + i3);
    }

    /* access modifiers changed from: package-private */
    public void Q(int i2, List<b> list, boolean z) {
        try {
            P(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void R(int i2, List<b> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i2))) {
                d0(i2, a.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i2));
            try {
                P(new c("OkHttp %s Push Request[%s]", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i2, a aVar) {
        P(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, aVar));
    }

    /* access modifiers changed from: package-private */
    public boolean T(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized h U(int i2) {
        h remove;
        remove = this.f10915d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public void V(a aVar) {
        synchronized (this.s) {
            synchronized (this) {
                if (!this.f10919h) {
                    this.f10919h = true;
                    this.s.I(this.f10917f, aVar, i.k0.e.f10445a);
                }
            }
        }
    }

    public void W() {
        X(true);
    }

    /* access modifiers changed from: package-private */
    public void X(boolean z) {
        if (z) {
            this.s.E();
            this.s.O(this.o);
            int d2 = this.o.d();
            if (d2 != 65535) {
                this.s.P(0, (long) (d2 - 65535));
            }
        }
        new Thread(this.t).start();
    }

    /* access modifiers changed from: package-private */
    public synchronized void Y(long j2) {
        long j3 = this.m + j2;
        this.m = j3;
        if (j3 >= ((long) (this.o.d() / 2))) {
            e0(0, this.m);
            this.m = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.s.K());
        r6 = (long) r3;
        r8.n -= r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Z(int r9, boolean r10, j.c r11, long r12) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.Z(int, boolean, j.c, long):void");
    }

    /* access modifiers changed from: package-private */
    public void a0(int i2, boolean z, List<b> list) {
        this.s.J(z, i2, list);
    }

    /* access modifiers changed from: package-private */
    public void b0(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.l;
                this.l = true;
            }
            if (z2) {
                I(null);
                return;
            }
        }
        try {
            this.s.L(z, i2, i3);
        } catch (IOException e2) {
            I(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(int i2, a aVar) {
        this.s.N(i2, aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        H(a.NO_ERROR, a.CANCEL, null);
    }

    /* access modifiers changed from: package-private */
    public void d0(int i2, a aVar) {
        try {
            this.f10920i.execute(new a("OkHttp %s stream %d", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, aVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void e0(int i2, long j2) {
        try {
            this.f10920i.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f10916e, Integer.valueOf(i2)}, i2, j2));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void flush() {
        this.s.flush();
    }
}
