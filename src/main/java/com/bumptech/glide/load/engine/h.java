package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.r.l.a;
import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: DecodeJob */
public class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private Object A;
    private com.bumptech.glide.load.a B;
    private com.bumptech.glide.load.m.d<?> C;
    private volatile f D;
    private volatile boolean E;
    private volatile boolean F;

    /* renamed from: b  reason: collision with root package name */
    private final g<R> f3741b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final List<Throwable> f3742c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f3743d = com.bumptech.glide.r.l.c.a();

    /* renamed from: e  reason: collision with root package name */
    private final e f3744e;

    /* renamed from: f  reason: collision with root package name */
    private final b.h.j.e<h<?>> f3745f;

    /* renamed from: g  reason: collision with root package name */
    private final d<?> f3746g = new d<>();

    /* renamed from: h  reason: collision with root package name */
    private final f f3747h = new f();

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.d f3748i;

    /* renamed from: j  reason: collision with root package name */
    private com.bumptech.glide.load.f f3749j;

    /* renamed from: k  reason: collision with root package name */
    private com.bumptech.glide.f f3750k;
    private n l;
    private int m;
    private int n;
    private j o;
    private com.bumptech.glide.load.h p;
    private b<R> q;
    private int r;
    private EnumC0094h s;
    private g t;
    private long u;
    private boolean v;
    private Object w;
    private Thread x;
    private com.bumptech.glide.load.f y;
    private com.bumptech.glide.load.f z;

    /* access modifiers changed from: package-private */
    /* compiled from: DecodeJob */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3751a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3752b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f3753c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
            // Method dump skipped, instructions count: 127
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.h.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DecodeJob */
    public interface b<R> {
        void a(GlideException glideException);

        void b(u<R> uVar, com.bumptech.glide.load.a aVar);

        void c(h<?> hVar);
    }

    /* access modifiers changed from: private */
    /* compiled from: DecodeJob */
    public final class c<Z> implements i.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.a f3754a;

        c(com.bumptech.glide.load.a aVar) {
            this.f3754a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        public u<Z> a(u<Z> uVar) {
            return h.this.v(this.f3754a, uVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DecodeJob */
    public static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private com.bumptech.glide.load.f f3756a;

        /* renamed from: b  reason: collision with root package name */
        private k<Z> f3757b;

        /* renamed from: c  reason: collision with root package name */
        private t<Z> f3758c;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3756a = null;
            this.f3757b = null;
            this.f3758c = null;
        }

        /* access modifiers changed from: package-private */
        public void b(e eVar, com.bumptech.glide.load.h hVar) {
            com.bumptech.glide.r.l.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f3756a, new e(this.f3757b, this.f3758c, hVar));
            } finally {
                this.f3758c.h();
                com.bumptech.glide.r.l.b.d();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f3758c != null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.bumptech.glide.load.k<X> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bumptech.glide.load.engine.t<X> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public <X> void d(com.bumptech.glide.load.f fVar, k<X> kVar, t<X> tVar) {
            this.f3756a = fVar;
            this.f3757b = kVar;
            this.f3758c = tVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DecodeJob */
    public interface e {
        com.bumptech.glide.load.engine.a0.a a();
    }

    /* access modifiers changed from: private */
    /* compiled from: DecodeJob */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3759a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3760b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3761c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.f3761c || z || this.f3760b) && this.f3759a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f3760b = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            this.f3761c = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean d(boolean z) {
            this.f3759a = true;
            return a(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            this.f3760b = false;
            this.f3759a = false;
            this.f3761c = false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DecodeJob */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* access modifiers changed from: private */
    /* renamed from: com.bumptech.glide.load.engine.h$h  reason: collision with other inner class name */
    /* compiled from: DecodeJob */
    public enum EnumC0094h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, b.h.j.e<h<?>> eVar2) {
        this.f3744e = eVar;
        this.f3745f = eVar2;
    }

    private void A() {
        int i2 = a.f3751a[this.t.ordinal()];
        if (i2 == 1) {
            this.s = k(EnumC0094h.INITIALIZE);
            this.D = j();
            y();
        } else if (i2 == 2) {
            y();
        } else if (i2 == 3) {
            i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.t);
        }
    }

    private void B() {
        Throwable th;
        this.f3743d.c();
        if (this.E) {
            if (this.f3742c.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f3742c;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.E = true;
    }

    private <Data> u<R> g(com.bumptech.glide.load.m.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b2 = com.bumptech.glide.r.f.b();
            u<R> h2 = h(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + h2, b2);
            }
            return h2;
        } finally {
            dVar.b();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.bumptech.glide.load.engine.s<Data, ?, R>, com.bumptech.glide.load.engine.s<Data, ResourceType, R> */
    private <Data> u<R> h(Data data, com.bumptech.glide.load.a aVar) {
        return z(data, aVar, (s<Data, ?, R>) this.f3741b.h(data.getClass()));
    }

    private void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.u;
            p("Retrieved data", j2, "data: " + this.A + ", cache key: " + this.y + ", fetcher: " + this.C);
        }
        u<R> uVar = null;
        try {
            uVar = g(this.C, this.A, this.B);
        } catch (GlideException e2) {
            e2.j(this.z, this.B);
            this.f3742c.add(e2);
        }
        if (uVar != null) {
            r(uVar, this.B);
        } else {
            y();
        }
    }

    private f j() {
        int i2 = a.f3752b[this.s.ordinal()];
        if (i2 == 1) {
            return new v(this.f3741b, this);
        }
        if (i2 == 2) {
            return new c(this.f3741b, this);
        }
        if (i2 == 3) {
            return new y(this.f3741b, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.s);
    }

    private EnumC0094h k(EnumC0094h hVar) {
        int i2 = a.f3752b[hVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return this.v ? EnumC0094h.FINISHED : EnumC0094h.SOURCE;
            }
            if (i2 == 3 || i2 == 4) {
                return EnumC0094h.FINISHED;
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + hVar);
            } else if (this.o.b()) {
                return EnumC0094h.RESOURCE_CACHE;
            } else {
                return k(EnumC0094h.RESOURCE_CACHE);
            }
        } else if (this.o.a()) {
            return EnumC0094h.DATA_CACHE;
        } else {
            return k(EnumC0094h.DATA_CACHE);
        }
    }

    private com.bumptech.glide.load.h l(com.bumptech.glide.load.a aVar) {
        com.bumptech.glide.load.h hVar = this.p;
        if (Build.VERSION.SDK_INT < 26) {
            return hVar;
        }
        boolean z2 = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f3741b.w();
        com.bumptech.glide.load.g<Boolean> gVar = l.f4200i;
        Boolean bool = (Boolean) hVar.c(gVar);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return hVar;
        }
        com.bumptech.glide.load.h hVar2 = new com.bumptech.glide.load.h();
        hVar2.d(this.p);
        hVar2.e(gVar, Boolean.valueOf(z2));
        return hVar2;
    }

    private int m() {
        return this.f3750k.ordinal();
    }

    private void o(String str, long j2) {
        p(str, j2, null);
    }

    private void p(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.r.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.l);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(u<R> uVar, com.bumptech.glide.load.a aVar) {
        B();
        this.q.b(uVar, aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.bumptech.glide.load.engine.t */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.bumptech.glide.load.engine.t */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.bumptech.glide.load.engine.t */
    /* JADX WARN: Multi-variable type inference failed */
    private void r(u<R> uVar, com.bumptech.glide.load.a aVar) {
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
        t tVar = 0;
        if (this.f3746g.c()) {
            uVar = t.f(uVar);
            tVar = uVar;
        }
        q(uVar, aVar);
        this.s = EnumC0094h.ENCODE;
        try {
            if (this.f3746g.c()) {
                this.f3746g.b(this.f3744e, this.p);
            }
            t();
        } finally {
            if (tVar != 0) {
                tVar.h();
            }
        }
    }

    private void s() {
        B();
        this.q.a(new GlideException("Failed to load resource", new ArrayList(this.f3742c)));
        u();
    }

    private void t() {
        if (this.f3747h.b()) {
            x();
        }
    }

    private void u() {
        if (this.f3747h.c()) {
            x();
        }
    }

    private void x() {
        this.f3747h.e();
        this.f3746g.a();
        this.f3741b.a();
        this.E = false;
        this.f3748i = null;
        this.f3749j = null;
        this.p = null;
        this.f3750k = null;
        this.l = null;
        this.q = null;
        this.s = null;
        this.D = null;
        this.x = null;
        this.y = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.u = 0;
        this.F = false;
        this.w = null;
        this.f3742c.clear();
        this.f3745f.a(this);
    }

    private void y() {
        this.x = Thread.currentThread();
        this.u = com.bumptech.glide.r.f.b();
        boolean z2 = false;
        while (!this.F && this.D != null && !(z2 = this.D.e())) {
            this.s = k(this.s);
            this.D = j();
            if (this.s == EnumC0094h.SOURCE) {
                a();
                return;
            }
        }
        if ((this.s == EnumC0094h.FINISHED || this.F) && !z2) {
            s();
        }
    }

    private <Data, ResourceType> u<R> z(Data data, com.bumptech.glide.load.a aVar, s<Data, ResourceType, R> sVar) {
        com.bumptech.glide.load.h l2 = l(aVar);
        com.bumptech.glide.load.m.e<Data> l3 = this.f3748i.h().l(data);
        try {
            return sVar.a(l3, l2, this.m, this.n, new c(aVar));
        } finally {
            l3.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        EnumC0094h k2 = k(EnumC0094h.INITIALIZE);
        return k2 == EnumC0094h.RESOURCE_CACHE || k2 == EnumC0094h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a() {
        this.t = g.SWITCH_TO_SOURCE_SERVICE;
        this.q.c(this);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void b(com.bumptech.glide.load.f fVar, Exception exc, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.k(fVar, aVar, dVar.a());
        this.f3742c.add(glideException);
        if (Thread.currentThread() != this.x) {
            this.t = g.SWITCH_TO_SOURCE_SERVICE;
            this.q.c(this);
            return;
        }
        y();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c(com.bumptech.glide.load.f fVar, Object obj, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.y = fVar;
        this.A = obj;
        this.C = dVar;
        this.B = aVar;
        this.z = fVar2;
        if (Thread.currentThread() != this.x) {
            this.t = g.DECODE_DATA;
            this.q.c(this);
            return;
        }
        com.bumptech.glide.r.l.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            com.bumptech.glide.r.l.b.d();
        }
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c d() {
        return this.f3743d;
    }

    public void e() {
        this.F = true;
        f fVar = this.D;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    /* renamed from: f */
    public int compareTo(h<?> hVar) {
        int m2 = m() - hVar.m();
        return m2 == 0 ? this.r - hVar.r : m2;
    }

    /* access modifiers changed from: package-private */
    public h<R> n(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, com.bumptech.glide.load.l<?>> map, boolean z2, boolean z3, boolean z4, com.bumptech.glide.load.h hVar, b<R> bVar, int i4) {
        this.f3741b.u(dVar, obj, fVar, i2, i3, jVar, cls, cls2, fVar2, hVar, map, z2, z3, this.f3744e);
        this.f3748i = dVar;
        this.f3749j = fVar;
        this.f3750k = fVar2;
        this.l = nVar;
        this.m = i2;
        this.n = i3;
        this.o = jVar;
        this.v = z4;
        this.p = hVar;
        this.q = bVar;
        this.r = i4;
        this.t = g.INITIALIZE;
        this.w = obj;
        return this;
    }

    public void run() {
        com.bumptech.glide.r.l.b.b("DecodeJob#run(model=%s)", this.w);
        com.bumptech.glide.load.m.d<?> dVar = this.C;
        try {
            if (this.F) {
                s();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.r.l.b.d();
                return;
            }
            A();
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.r.l.b.d();
        } catch (b e2) {
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.r.l.b.d();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public <Z> u<Z> v(com.bumptech.glide.load.a aVar, u<Z> uVar) {
        com.bumptech.glide.load.l<Z> lVar;
        u<Z> uVar2;
        com.bumptech.glide.load.c cVar;
        com.bumptech.glide.load.f fVar;
        Class<?> cls = uVar.get().getClass();
        k kVar = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.l<Z> r2 = this.f3741b.r(cls);
            lVar = r2;
            uVar2 = r2.a(this.f3748i, uVar, this.m, this.n);
        } else {
            uVar2 = uVar;
            lVar = null;
        }
        if (!uVar.equals(uVar2)) {
            uVar.e();
        }
        if (this.f3741b.v(uVar2)) {
            kVar = this.f3741b.n(uVar2);
            cVar = kVar.b(this.p);
        } else {
            cVar = com.bumptech.glide.load.c.NONE;
        }
        if (!this.o.d(!this.f3741b.x(this.y), aVar, cVar)) {
            return uVar2;
        }
        if (kVar != null) {
            int i2 = a.f3753c[cVar.ordinal()];
            if (i2 == 1) {
                fVar = new d(this.y, this.f3749j);
            } else if (i2 == 2) {
                fVar = new w(this.f3741b.b(), this.y, this.f3749j, this.m, this.n, lVar, cls, this.p);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + cVar);
            }
            t f2 = t.f(uVar2);
            this.f3746g.d(fVar, kVar, f2);
            return f2;
        }
        throw new Registry.NoResultEncoderAvailableException(uVar2.get().getClass());
    }

    /* access modifiers changed from: package-private */
    public void w(boolean z2) {
        if (this.f3747h.d(z2)) {
            x();
        }
    }
}
