package com.bumptech.glide.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.d;
import com.bumptech.glide.f;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.p.j.g;
import com.bumptech.glide.r.l.c;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest */
public final class h<R> implements c, g, g {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    private final String f4314a;

    /* renamed from: b  reason: collision with root package name */
    private final c f4315b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f4316c;

    /* renamed from: d  reason: collision with root package name */
    private final e<R> f4317d;

    /* renamed from: e  reason: collision with root package name */
    private final d f4318e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f4319f;

    /* renamed from: g  reason: collision with root package name */
    private final d f4320g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f4321h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f4322i;

    /* renamed from: j  reason: collision with root package name */
    private final a<?> f4323j;

    /* renamed from: k  reason: collision with root package name */
    private final int f4324k;
    private final int l;
    private final f m;
    private final com.bumptech.glide.p.j.h<R> n;
    private final List<e<R>> o;
    private final com.bumptech.glide.p.k.c<? super R> p;
    private final Executor q;
    private u<R> r;
    private k.d s;
    private long t;
    private volatile k u;
    private a v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private int z;

    /* access modifiers changed from: private */
    /* compiled from: SingleRequest */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private h(Context context, d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, f fVar, com.bumptech.glide.p.j.h<R> hVar, e<R> eVar, List<e<R>> list, d dVar2, k kVar, com.bumptech.glide.p.k.c<? super R> cVar, Executor executor) {
        this.f4314a = D ? String.valueOf(super.hashCode()) : null;
        this.f4315b = c.a();
        this.f4316c = obj;
        this.f4319f = context;
        this.f4320g = dVar;
        this.f4321h = obj2;
        this.f4322i = cls;
        this.f4323j = aVar;
        this.f4324k = i2;
        this.l = i3;
        this.m = fVar;
        this.n = hVar;
        this.f4317d = eVar;
        this.o = list;
        this.f4318e = dVar2;
        this.u = kVar;
        this.p = cVar;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && dVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    /* JADX INFO: finally extract failed */
    private void A(u<R> uVar, R r2, com.bumptech.glide.load.a aVar) {
        boolean z2;
        boolean s2 = s();
        this.v = a.COMPLETE;
        this.r = uVar;
        if (this.f4320g.g() <= 3) {
            Log.d("Glide", "Finished loading " + r2.getClass().getSimpleName() + " from " + aVar + " for " + this.f4321h + " with size [" + this.z + "x" + this.A + "] in " + com.bumptech.glide.r.f.a(this.t) + " ms");
        }
        boolean z3 = true;
        this.B = true;
        try {
            List<e<R>> list = this.o;
            if (list != null) {
                z2 = false;
                for (e<R> eVar : list) {
                    z2 |= eVar.a(r2, this.f4321h, this.n, aVar, s2);
                }
            } else {
                z2 = false;
            }
            e<R> eVar2 = this.f4317d;
            if (eVar2 == null || !eVar2.a(r2, this.f4321h, this.n, aVar, s2)) {
                z3 = false;
            }
            if (!z3 && !z2) {
                this.n.c(r2, this.p.a(aVar, s2));
            }
            this.B = false;
            x();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    private void B() {
        if (m()) {
            Drawable drawable = null;
            if (this.f4321h == null) {
                drawable = q();
            }
            if (drawable == null) {
                drawable = p();
            }
            if (drawable == null) {
                drawable = r();
            }
            this.n.d(drawable);
        }
    }

    private void j() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean l() {
        d dVar = this.f4318e;
        return dVar == null || dVar.l(this);
    }

    private boolean m() {
        d dVar = this.f4318e;
        return dVar == null || dVar.b(this);
    }

    private boolean n() {
        d dVar = this.f4318e;
        return dVar == null || dVar.g(this);
    }

    private void o() {
        j();
        this.f4315b.c();
        this.n.b(this);
        k.d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
    }

    private Drawable p() {
        if (this.w == null) {
            Drawable i2 = this.f4323j.i();
            this.w = i2;
            if (i2 == null && this.f4323j.h() > 0) {
                this.w = t(this.f4323j.h());
            }
        }
        return this.w;
    }

    private Drawable q() {
        if (this.y == null) {
            Drawable j2 = this.f4323j.j();
            this.y = j2;
            if (j2 == null && this.f4323j.k() > 0) {
                this.y = t(this.f4323j.k());
            }
        }
        return this.y;
    }

    private Drawable r() {
        if (this.x == null) {
            Drawable q2 = this.f4323j.q();
            this.x = q2;
            if (q2 == null && this.f4323j.r() > 0) {
                this.x = t(this.f4323j.r());
            }
        }
        return this.x;
    }

    private boolean s() {
        d dVar = this.f4318e;
        return dVar == null || !dVar.h().d();
    }

    private Drawable t(int i2) {
        return com.bumptech.glide.load.o.e.a.a(this.f4320g, i2, this.f4323j.w() != null ? this.f4323j.w() : this.f4319f.getTheme());
    }

    private void u(String str) {
        Log.v("Request", str + " this: " + this.f4314a);
    }

    private static int v(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private void w() {
        d dVar = this.f4318e;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    private void x() {
        d dVar = this.f4318e;
        if (dVar != null) {
            dVar.j(this);
        }
    }

    public static <R> h<R> y(Context context, d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, f fVar, com.bumptech.glide.p.j.h<R> hVar, e<R> eVar, List<e<R>> list, d dVar2, k kVar, com.bumptech.glide.p.k.c<? super R> cVar, Executor executor) {
        return new h<>(context, dVar, obj, obj2, cls, aVar, i2, i3, fVar, hVar, eVar, list, dVar2, kVar, cVar, executor);
    }

    /* JADX INFO: finally extract failed */
    private void z(GlideException glideException, int i2) {
        boolean z2;
        this.f4315b.c();
        synchronized (this.f4316c) {
            glideException.l(this.C);
            int g2 = this.f4320g.g();
            if (g2 <= i2) {
                Log.w("Glide", "Load failed for " + this.f4321h + " with size [" + this.z + "x" + this.A + "]", glideException);
                if (g2 <= 4) {
                    glideException.h("Glide");
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z3 = true;
            this.B = true;
            try {
                List<e<R>> list = this.o;
                if (list != null) {
                    z2 = false;
                    for (e<R> eVar : list) {
                        z2 |= eVar.b(glideException, this.f4321h, this.n, s());
                    }
                } else {
                    z2 = false;
                }
                e<R> eVar2 = this.f4317d;
                if (eVar2 == null || !eVar2.b(glideException, this.f4321h, this.n, s())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    B();
                }
                this.B = false;
                w();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.p.g
    public void a(GlideException glideException) {
        z(glideException, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bumptech.glide.p.h<R> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: com.bumptech.glide.load.engine.k */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bumptech.glide.load.engine.u, com.bumptech.glide.load.engine.u<R>, com.bumptech.glide.load.engine.k$d] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r5.u.k(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.bumptech.glide.p.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bumptech.glide.load.engine.u<?> r6, com.bumptech.glide.load.a r7) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p.h.b(com.bumptech.glide.load.engine.u, com.bumptech.glide.load.a):void");
    }

    @Override // com.bumptech.glide.p.c
    public void c() {
        synchronized (this.f4316c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.u.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    @Override // com.bumptech.glide.p.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4316c
            monitor-enter(r0)
            r5.j()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.r.l.c r1 = r5.f4315b     // Catch:{ all -> 0x0039 }
            r1.c()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.p.h$a r1 = r5.v     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.p.h$a r2 = com.bumptech.glide.p.h.a.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.o()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.u<R> r1 = r5.r     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.r = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.l()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            com.bumptech.glide.p.j.h<R> r3 = r5.n     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.r()     // Catch:{ all -> 0x0039 }
            r3.h(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.v = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.k r0 = r5.u
            r0.k(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p.h.clear():void");
    }

    @Override // com.bumptech.glide.p.c
    public boolean d() {
        boolean z2;
        synchronized (this.f4316c) {
            z2 = this.v == a.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.p.c
    public boolean e(c cVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        f fVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        f fVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f4316c) {
            i2 = this.f4324k;
            i3 = this.l;
            obj = this.f4321h;
            cls = this.f4322i;
            aVar = this.f4323j;
            fVar = this.m;
            List<e<R>> list = this.o;
            size = list != null ? list.size() : 0;
        }
        h hVar = (h) cVar;
        synchronized (hVar.f4316c) {
            i4 = hVar.f4324k;
            i5 = hVar.l;
            obj2 = hVar.f4321h;
            cls2 = hVar.f4322i;
            aVar2 = hVar.f4323j;
            fVar2 = hVar.m;
            List<e<R>> list2 = hVar.o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i2 == i4 && i3 == i5 && com.bumptech.glide.r.k.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2;
    }

    @Override // com.bumptech.glide.p.c
    public boolean f() {
        boolean z2;
        synchronized (this.f4316c) {
            z2 = this.v == a.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.p.g
    public Object g() {
        this.f4315b.c();
        return this.f4316c;
    }

    @Override // com.bumptech.glide.p.j.g
    public void h(int i2, int i3) {
        Object obj;
        this.f4315b.c();
        Object obj2 = this.f4316c;
        synchronized (obj2) {
            try {
                boolean z2 = D;
                if (z2) {
                    u("Got onSizeReady in " + com.bumptech.glide.r.f.a(this.t));
                }
                if (this.v == a.WAITING_FOR_SIZE) {
                    a aVar = a.RUNNING;
                    this.v = aVar;
                    float v2 = this.f4323j.v();
                    this.z = v(i2, v2);
                    this.A = v(i3, v2);
                    if (z2) {
                        u("finished setup for calling load in " + com.bumptech.glide.r.f.a(this.t));
                    }
                    obj = obj2;
                    try {
                        this.s = this.u.f(this.f4320g, this.f4321h, this.f4323j.u(), this.z, this.A, this.f4323j.t(), this.f4322i, this.m, this.f4323j.g(), this.f4323j.x(), this.f4323j.G(), this.f4323j.C(), this.f4323j.n(), this.f4323j.A(), this.f4323j.z(), this.f4323j.y(), this.f4323j.m(), this, this.q);
                        if (this.v != aVar) {
                            this.s = null;
                        }
                        if (z2) {
                            u("finished onSizeReady in " + com.bumptech.glide.r.f.a(this.t));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public void i() {
        synchronized (this.f4316c) {
            j();
            this.f4315b.c();
            this.t = com.bumptech.glide.r.f.b();
            if (this.f4321h == null) {
                if (com.bumptech.glide.r.k.r(this.f4324k, this.l)) {
                    this.z = this.f4324k;
                    this.A = this.l;
                }
                z(new GlideException("Received null model"), q() == null ? 5 : 3);
                return;
            }
            a aVar = this.v;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else if (aVar == a.COMPLETE) {
                b(this.r, com.bumptech.glide.load.a.MEMORY_CACHE);
            } else {
                a aVar3 = a.WAITING_FOR_SIZE;
                this.v = aVar3;
                if (com.bumptech.glide.r.k.r(this.f4324k, this.l)) {
                    h(this.f4324k, this.l);
                } else {
                    this.n.i(this);
                }
                a aVar4 = this.v;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && m()) {
                    this.n.f(r());
                }
                if (D) {
                    u("finished run method in " + com.bumptech.glide.r.f.a(this.t));
                }
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public boolean isRunning() {
        boolean z2;
        synchronized (this.f4316c) {
            a aVar = this.v;
            if (aVar != a.RUNNING) {
                if (aVar != a.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    @Override // com.bumptech.glide.p.c
    public boolean k() {
        boolean z2;
        synchronized (this.f4316c) {
            z2 = this.v == a.COMPLETE;
        }
        return z2;
    }
}
