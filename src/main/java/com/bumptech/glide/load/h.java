package com.bumptech.glide.load;

import b.e.a;
import com.bumptech.glide.r.b;
import java.security.MessageDigest;

/* compiled from: Options */
public final class h implements f {

    /* renamed from: b  reason: collision with root package name */
    private final a<g<?>, Object> f3930b = new b();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(g<T> gVar, Object obj, MessageDigest messageDigest) {
        gVar.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f3930b.size(); i2++) {
            f(this.f3930b.i(i2), this.f3930b.m(i2), messageDigest);
        }
    }

    public <T> T c(g<T> gVar) {
        return this.f3930b.containsKey(gVar) ? (T) this.f3930b.get(gVar) : gVar.c();
    }

    public void d(h hVar) {
        this.f3930b.j(hVar.f3930b);
    }

    public <T> h e(g<T> gVar, T t) {
        this.f3930b.put(gVar, t);
        return this;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f3930b.equals(((h) obj).f3930b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f3930b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f3930b + '}';
    }
}
