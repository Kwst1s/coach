package com.bumptech.glide.q;

import com.bumptech.glide.load.f;
import com.bumptech.glide.r.j;
import java.security.MessageDigest;

/* compiled from: ObjectKey */
public final class b implements f {

    /* renamed from: b  reason: collision with root package name */
    private final Object f4358b;

    public b(Object obj) {
        j.d(obj);
        this.f4358b = obj;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f4358b.toString().getBytes(f.f3924a));
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f4358b.equals(((b) obj).f4358b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f4358b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f4358b + '}';
    }
}
