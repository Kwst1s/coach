package com.bumptech.glide.load.o.h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f4154a = new ArrayList();

    /* compiled from: TranscoderRegistry */
    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f4155a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f4156b;

        /* renamed from: c  reason: collision with root package name */
        final e<Z, R> f4157c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f4155a = cls;
            this.f4156b = cls2;
            this.f4157c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f4155a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4156b);
        }
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f4154a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f4157c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f4154a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f4154a.add(new a<>(cls, cls2, eVar));
    }
}
