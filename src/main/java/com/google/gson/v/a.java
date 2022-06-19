package com.google.gson.v;

import com.google.gson.u.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f8459a;

    /* renamed from: b  reason: collision with root package name */
    final Type f8460b;

    /* renamed from: c  reason: collision with root package name */
    final int f8461c;

    protected a() {
        Type d2 = d(a.class);
        this.f8460b = d2;
        this.f8459a = (Class<? super T>) b.k(d2);
        this.f8461c = d2.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    static Type d(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> c() {
        return this.f8459a;
    }

    public final Type e() {
        return this.f8460b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f8460b, ((a) obj).f8460b);
    }

    public final int hashCode() {
        return this.f8461c;
    }

    public final String toString() {
        return b.u(this.f8460b);
    }

    a(Type type) {
        com.google.gson.u.a.b(type);
        Type b2 = b.b(type);
        this.f8460b = b2;
        this.f8459a = (Class<? super T>) b.k(b2);
        this.f8461c = b2.hashCode();
    }
}
