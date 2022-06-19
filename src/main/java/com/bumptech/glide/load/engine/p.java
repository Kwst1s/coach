package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.r.j;

/* access modifiers changed from: package-private */
/* compiled from: EngineResource */
public class p<Z> implements u<Z> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3833b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3834c;

    /* renamed from: d  reason: collision with root package name */
    private final u<Z> f3835d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3836e;

    /* renamed from: f  reason: collision with root package name */
    private final f f3837f;

    /* renamed from: g  reason: collision with root package name */
    private int f3838g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3839h;

    /* access modifiers changed from: package-private */
    /* compiled from: EngineResource */
    public interface a {
        void d(f fVar, p<?> pVar);
    }

    p(u<Z> uVar, boolean z, boolean z2, f fVar, a aVar) {
        j.d(uVar);
        this.f3835d = uVar;
        this.f3833b = z;
        this.f3834c = z2;
        this.f3837f = fVar;
        j.d(aVar);
        this.f3836e = aVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f3839h) {
            this.f3838g++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return this.f3835d.b();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Z> c() {
        return this.f3835d.c();
    }

    /* access modifiers changed from: package-private */
    public u<Z> d() {
        return this.f3835d;
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void e() {
        if (this.f3838g > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f3839h) {
            this.f3839h = true;
            if (this.f3834c) {
                this.f3835d.e();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f3833b;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean z;
        synchronized (this) {
            int i2 = this.f3838g;
            if (i2 > 0) {
                z = true;
                int i3 = i2 - 1;
                this.f3838g = i3;
                if (i3 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f3836e.d(this.f3837f, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public Z get() {
        return this.f3835d.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f3833b + ", listener=" + this.f3836e + ", key=" + this.f3837f + ", acquired=" + this.f3838g + ", isRecycled=" + this.f3839h + ", resource=" + this.f3835d + '}';
    }
}
