package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.f;
import com.bumptech.glide.p.g;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.l.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: EngineJob */
public class l<R> implements h.b<R>, a.f {
    private static final c z = new c();

    /* renamed from: b  reason: collision with root package name */
    final e f3807b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f3808c;

    /* renamed from: d  reason: collision with root package name */
    private final p.a f3809d;

    /* renamed from: e  reason: collision with root package name */
    private final b.h.j.e<l<?>> f3810e;

    /* renamed from: f  reason: collision with root package name */
    private final c f3811f;

    /* renamed from: g  reason: collision with root package name */
    private final m f3812g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b0.a f3813h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b0.a f3814i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b0.a f3815j;

    /* renamed from: k  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b0.a f3816k;
    private final AtomicInteger l;
    private f m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private u<?> r;
    com.bumptech.glide.load.a s;
    private boolean t;
    GlideException u;
    private boolean v;
    p<?> w;
    private h<R> x;
    private volatile boolean y;

    /* access modifiers changed from: private */
    /* compiled from: EngineJob */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final g f3817b;

        a(g gVar) {
            this.f3817b = gVar;
        }

        public void run() {
            synchronized (this.f3817b.g()) {
                synchronized (l.this) {
                    if (l.this.f3807b.b(this.f3817b)) {
                        l.this.f(this.f3817b);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: EngineJob */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final g f3819b;

        b(g gVar) {
            this.f3819b = gVar;
        }

        public void run() {
            synchronized (this.f3819b.g()) {
                synchronized (l.this) {
                    if (l.this.f3807b.b(this.f3819b)) {
                        l.this.w.a();
                        l.this.g(this.f3819b);
                        l.this.r(this.f3819b);
                    }
                    l.this.i();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: EngineJob */
    public static class c {
        c() {
        }

        public <R> p<R> a(u<R> uVar, boolean z, f fVar, p.a aVar) {
            return new p<>(uVar, z, true, fVar, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: EngineJob */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final g f3821a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f3822b;

        d(g gVar, Executor executor) {
            this.f3821a = gVar;
            this.f3822b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f3821a.equals(((d) obj).f3821a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3821a.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: EngineJob */
    public static final class e implements Iterable<d> {

        /* renamed from: b  reason: collision with root package name */
        private final List<d> f3823b;

        e() {
            this(new ArrayList(2));
        }

        private static d d(g gVar) {
            return new d(gVar, com.bumptech.glide.r.e.a());
        }

        /* access modifiers changed from: package-private */
        public void a(g gVar, Executor executor) {
            this.f3823b.add(new d(gVar, executor));
        }

        /* access modifiers changed from: package-private */
        public boolean b(g gVar) {
            return this.f3823b.contains(d(gVar));
        }

        /* access modifiers changed from: package-private */
        public e c() {
            return new e(new ArrayList(this.f3823b));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.f3823b.clear();
        }

        /* access modifiers changed from: package-private */
        public void e(g gVar) {
            this.f3823b.remove(d(gVar));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.f3823b.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f3823b.iterator();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.f3823b.size();
        }

        e(List<d> list) {
            this.f3823b = list;
        }
    }

    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, b.h.j.e<l<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, eVar, z);
    }

    private com.bumptech.glide.load.engine.b0.a j() {
        if (this.o) {
            return this.f3815j;
        }
        return this.p ? this.f3816k : this.f3814i;
    }

    private boolean m() {
        return this.v || this.t || this.y;
    }

    private synchronized void q() {
        if (this.m != null) {
            this.f3807b.clear();
            this.m = null;
            this.w = null;
            this.r = null;
            this.v = false;
            this.y = false;
            this.t = false;
            this.x.w(false);
            this.x = null;
            this.u = null;
            this.s = null;
            this.f3810e.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.u = glideException;
        }
        n();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.bumptech.glide.load.engine.u<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void b(u<R> uVar, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.r = uVar;
            this.s = aVar;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void c(h<?> hVar) {
        j().execute(hVar);
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c d() {
        return this.f3808c;
    }

    /* access modifiers changed from: package-private */
    public synchronized void e(g gVar, Executor executor) {
        this.f3808c.c();
        this.f3807b.a(gVar, executor);
        boolean z2 = true;
        if (this.t) {
            k(1);
            executor.execute(new b(gVar));
        } else if (this.v) {
            k(1);
            executor.execute(new a(gVar));
        } else {
            if (this.y) {
                z2 = false;
            }
            j.a(z2, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar) {
        try {
            gVar.a(this.u);
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(g gVar) {
        try {
            gVar.b(this.w, this.s);
        } catch (Throwable th) {
            throw new b(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (!m()) {
            this.y = true;
            this.x.e();
            this.f3812g.c(this, this.m);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        p<?> pVar;
        synchronized (this) {
            this.f3808c.c();
            j.a(m(), "Not yet complete!");
            int decrementAndGet = this.l.decrementAndGet();
            j.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                pVar = this.w;
                q();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.g();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(int i2) {
        p<?> pVar;
        j.a(m(), "Not yet complete!");
        if (this.l.getAndAdd(i2) == 0 && (pVar = this.w) != null) {
            pVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized l<R> l(f fVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.m = fVar;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f3812g.b(r4, r1, null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f3822b.execute(new com.bumptech.glide.load.engine.l.a(r4, r1.f3821a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.l.n():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f3812g.b(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f3822b.execute(new com.bumptech.glide.load.engine.l.b(r5, r1.f3821a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.l.o():void");
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public synchronized void r(g gVar) {
        boolean z2;
        this.f3808c.c();
        this.f3807b.e(gVar);
        if (this.f3807b.isEmpty()) {
            h();
            if (!this.t) {
                if (!this.v) {
                    z2 = false;
                    if (z2 && this.l.get() == 0) {
                        q();
                    }
                }
            }
            z2 = true;
            q();
        }
    }

    public synchronized void s(h<R> hVar) {
        this.x = hVar;
        (hVar.C() ? this.f3813h : j()).execute(hVar);
    }

    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, b.h.j.e<l<?>> eVar, c cVar) {
        this.f3807b = new e();
        this.f3808c = com.bumptech.glide.r.l.c.a();
        this.l = new AtomicInteger();
        this.f3813h = aVar;
        this.f3814i = aVar2;
        this.f3815j = aVar3;
        this.f3816k = aVar4;
        this.f3812g = mVar;
        this.f3809d = aVar5;
        this.f3810e = eVar;
        this.f3811f = cVar;
    }
}
