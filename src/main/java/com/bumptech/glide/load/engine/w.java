package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* access modifiers changed from: package-private */
/* compiled from: ResourceCacheKey */
public final class w implements f {

    /* renamed from: j  reason: collision with root package name */
    private static final g<Class<?>, byte[]> f3860j = new g<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final b f3861b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3862c;

    /* renamed from: d  reason: collision with root package name */
    private final f f3863d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3864e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3865f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f3866g;

    /* renamed from: h  reason: collision with root package name */
    private final h f3867h;

    /* renamed from: i  reason: collision with root package name */
    private final l<?> f3868i;

    w(b bVar, f fVar, f fVar2, int i2, int i3, l<?> lVar, Class<?> cls, h hVar) {
        this.f3861b = bVar;
        this.f3862c = fVar;
        this.f3863d = fVar2;
        this.f3864e = i2;
        this.f3865f = i3;
        this.f3868i = lVar;
        this.f3866g = cls;
        this.f3867h = hVar;
    }

    private byte[] c() {
        g<Class<?>, byte[]> gVar = f3860j;
        byte[] g2 = gVar.g(this.f3866g);
        if (g2 != null) {
            return g2;
        }
        byte[] bytes = this.f3866g.getName().getBytes(f.f3924a);
        gVar.k(this.f3866g, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f3861b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f3864e).putInt(this.f3865f).array();
        this.f3863d.b(messageDigest);
        this.f3862c.b(messageDigest);
        messageDigest.update(bArr);
        l<?> lVar = this.f3868i;
        if (lVar != null) {
            lVar.b(messageDigest);
        }
        this.f3867h.b(messageDigest);
        messageDigest.update(c());
        this.f3861b.d(bArr);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f3865f != wVar.f3865f || this.f3864e != wVar.f3864e || !k.c(this.f3868i, wVar.f3868i) || !this.f3866g.equals(wVar.f3866g) || !this.f3862c.equals(wVar.f3862c) || !this.f3863d.equals(wVar.f3863d) || !this.f3867h.equals(wVar.f3867h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        int hashCode = (((((this.f3862c.hashCode() * 31) + this.f3863d.hashCode()) * 31) + this.f3864e) * 31) + this.f3865f;
        l<?> lVar = this.f3868i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        return (((hashCode * 31) + this.f3866g.hashCode()) * 31) + this.f3867h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f3862c + ", signature=" + this.f3863d + ", width=" + this.f3864e + ", height=" + this.f3865f + ", decodedResourceClass=" + this.f3866g + ", transformation='" + this.f3868i + '\'' + ", options=" + this.f3867h + '}';
    }
}
