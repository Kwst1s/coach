package com.bumptech.glide.load;

import com.bumptech.glide.r.j;
import java.security.MessageDigest;

/* compiled from: Option */
public final class g<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f3925e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f3926a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f3927b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3928c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f3929d;

    /* compiled from: Option */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.g.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option */
    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private g(String str, T t, b<T> bVar) {
        j.b(str);
        this.f3928c = str;
        this.f3926a = t;
        j.d(bVar);
        this.f3927b = bVar;
    }

    public static <T> g<T> a(String str, T t, b<T> bVar) {
        return new g<>(str, t, bVar);
    }

    private static <T> b<T> b() {
        return (b<T>) f3925e;
    }

    private byte[] d() {
        if (this.f3929d == null) {
            this.f3929d = this.f3928c.getBytes(f.f3924a);
        }
        return this.f3929d;
    }

    public static <T> g<T> e(String str) {
        return new g<>(str, null, b());
    }

    public static <T> g<T> f(String str, T t) {
        return new g<>(str, t, b());
    }

    public T c() {
        return this.f3926a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f3928c.equals(((g) obj).f3928c);
        }
        return false;
    }

    public void g(T t, MessageDigest messageDigest) {
        this.f3927b.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.f3928c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f3928c + '\'' + '}';
    }
}
