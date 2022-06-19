package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: DataCacheKey */
final class d implements f {

    /* renamed from: b  reason: collision with root package name */
    private final f f3725b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3726c;

    d(f fVar, f fVar2) {
        this.f3725b = fVar;
        this.f3726c = fVar2;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        this.f3725b.b(messageDigest);
        this.f3726c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f3725b.equals(dVar.f3725b) || !this.f3726c.equals(dVar.f3726c)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return (this.f3725b.hashCode() * 31) + this.f3726c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f3725b + ", signature=" + this.f3726c + '}';
    }
}
