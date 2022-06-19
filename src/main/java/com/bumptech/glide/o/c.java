package com.bumptech.glide.o;

import b.e.a;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.o.h.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final s<?, ?, ?> f4278c = new s<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a  reason: collision with root package name */
    private final a<com.bumptech.glide.r.i, s<?, ?, ?>> f4279a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.r.i> f4280b = new AtomicReference<>();

    private com.bumptech.glide.r.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.r.i andSet = this.f4280b.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.r.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        com.bumptech.glide.r.i b2 = b(cls, cls2, cls3);
        synchronized (this.f4279a) {
            sVar = (s<Data, TResource, Transcode>) this.f4279a.get(b2);
        }
        this.f4280b.set(b2);
        return sVar;
    }

    public boolean c(s<?, ?, ?> sVar) {
        return f4278c.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, s<?, ?, ?> sVar) {
        synchronized (this.f4279a) {
            a<com.bumptech.glide.r.i, s<?, ?, ?>> aVar = this.f4279a;
            com.bumptech.glide.r.i iVar = new com.bumptech.glide.r.i(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f4278c;
            }
            aVar.put(iVar, sVar);
        }
    }
}
