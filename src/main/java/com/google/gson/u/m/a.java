package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u.b;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter */
public final class a<E> extends r<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final s f8389b = new C0169a();

    /* renamed from: a  reason: collision with root package name */
    private final r<E> f8390a;

    /* renamed from: com.google.gson.u.m.a$a  reason: collision with other inner class name */
    /* compiled from: ArrayTypeAdapter */
    class C0169a implements s {
        C0169a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
            Type e2 = aVar.e();
            if (!(e2 instanceof GenericArrayType) && (!(e2 instanceof Class) || !((Class) e2).isArray())) {
                return null;
            }
            Type g2 = b.g(e2);
            return new a(fVar, fVar.f(com.google.gson.v.a.b(g2)), b.k(g2));
        }
    }

    public a(f fVar, r<E> rVar, Class<E> cls) {
        this.f8390a = new l(fVar, rVar, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.r<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.r
    public void c(com.google.gson.stream.a aVar, Object obj) {
        if (obj == null) {
            aVar.P();
            return;
        }
        aVar.F();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f8390a.c(aVar, Array.get(obj, i2));
        }
        aVar.I();
    }
}
