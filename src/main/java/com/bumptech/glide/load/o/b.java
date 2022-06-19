package com.bumptech.glide.load.o;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* compiled from: SimpleResource */
public class b<T> implements u<T> {

    /* renamed from: b  reason: collision with root package name */
    protected final T f4097b;

    public b(T t) {
        j.d(t);
        this.f4097b = t;
    }

    @Override // com.bumptech.glide.load.engine.u
    public final int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<T> c() {
        return (Class<T>) this.f4097b.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
    }

    @Override // com.bumptech.glide.load.engine.u
    public final T get() {
        return this.f4097b;
    }
}
