package com.bumptech.glide.o;

import b.e.a;
import com.bumptech.glide.r.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f4281a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<i, List<Class<?>>> f4282b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f4281a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f4282b) {
            list = this.f4282b.get(andSet);
        }
        this.f4281a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f4282b) {
            this.f4282b.put(new i(cls, cls2, cls3), list);
        }
    }
}
