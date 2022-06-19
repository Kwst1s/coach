package com.bumptech.glide.load.engine;

import b.h.j.e;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.l.a;
import com.bumptech.glide.r.l.c;

/* access modifiers changed from: package-private */
/* compiled from: LockedResource */
public final class t<Z> implements u<Z>, a.f {

    /* renamed from: f  reason: collision with root package name */
    private static final e<t<?>> f3845f = com.bumptech.glide.r.l.a.d(20, new a());

    /* renamed from: b  reason: collision with root package name */
    private final c f3846b = c.a();

    /* renamed from: c  reason: collision with root package name */
    private u<Z> f3847c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3848d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3849e;

    /* compiled from: LockedResource */
    class a implements a.d<t<?>> {
        a() {
        }

        /* renamed from: b */
        public t<?> a() {
            return new t<>();
        }
    }

    t() {
    }

    private void a(u<Z> uVar) {
        this.f3849e = false;
        this.f3848d = true;
        this.f3847c = uVar;
    }

    static <Z> t<Z> f(u<Z> uVar) {
        t<?> b2 = f3845f.b();
        j.d(b2);
        t<Z> tVar = (t<Z>) b2;
        tVar.a(uVar);
        return tVar;
    }

    private void g() {
        this.f3847c = null;
        f3845f.a(this);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return this.f3847c.b();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Z> c() {
        return this.f3847c.c();
    }

    @Override // com.bumptech.glide.r.l.a.f
    public c d() {
        return this.f3846b;
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void e() {
        this.f3846b.c();
        this.f3849e = true;
        if (!this.f3848d) {
            this.f3847c.e();
            g();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public Z get() {
        return this.f3847c.get();
    }

    /* access modifiers changed from: package-private */
    public synchronized void h() {
        this.f3846b.c();
        if (this.f3848d) {
            this.f3848d = false;
            if (this.f3849e) {
                e();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
