package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u.c;
import com.google.gson.u.h;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class b implements s {

    /* renamed from: b  reason: collision with root package name */
    private final c f8391b;

    /* compiled from: CollectionTypeAdapterFactory */
    private static final class a<E> extends r<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final r<E> f8392a;

        public a(f fVar, Type type, r<E> rVar, h<? extends Collection<E>> hVar) {
            this.f8392a = new l(fVar, rVar, type);
        }

        /* renamed from: d */
        public void c(com.google.gson.stream.a aVar, Collection<E> collection) {
            if (collection == null) {
                aVar.P();
                return;
            }
            aVar.F();
            for (E e2 : collection) {
                this.f8392a.c(aVar, e2);
            }
            aVar.I();
        }
    }

    public b(c cVar) {
        this.f8391b = cVar;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c2 = aVar.c();
        if (!Collection.class.isAssignableFrom(c2)) {
            return null;
        }
        Type h2 = com.google.gson.u.b.h(e2, c2);
        return new a(fVar, h2, fVar.f(com.google.gson.v.a.b(h2)), this.f8391b.a(aVar));
    }
}
