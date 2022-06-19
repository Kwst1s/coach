package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.j;
import java.security.MessageDigest;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: EngineKey */
public class n implements f {

    /* renamed from: b  reason: collision with root package name */
    private final Object f3824b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3825c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3826d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f3827e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f3828f;

    /* renamed from: g  reason: collision with root package name */
    private final f f3829g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, l<?>> f3830h;

    /* renamed from: i  reason: collision with root package name */
    private final h f3831i;

    /* renamed from: j  reason: collision with root package name */
    private int f3832j;

    n(Object obj, f fVar, int i2, int i3, Map<Class<?>, l<?>> map, Class<?> cls, Class<?> cls2, h hVar) {
        j.d(obj);
        this.f3824b = obj;
        j.e(fVar, "Signature must not be null");
        this.f3829g = fVar;
        this.f3825c = i2;
        this.f3826d = i3;
        j.d(map);
        this.f3830h = map;
        j.e(cls, "Resource class must not be null");
        this.f3827e = cls;
        j.e(cls2, "Transcode class must not be null");
        this.f3828f = cls2;
        j.d(hVar);
        this.f3831i = hVar;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f3824b.equals(nVar.f3824b) || !this.f3829g.equals(nVar.f3829g) || this.f3826d != nVar.f3826d || this.f3825c != nVar.f3825c || !this.f3830h.equals(nVar.f3830h) || !this.f3827e.equals(nVar.f3827e) || !this.f3828f.equals(nVar.f3828f) || !this.f3831i.equals(nVar.f3831i)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        if (this.f3832j == 0) {
            int hashCode = this.f3824b.hashCode();
            this.f3832j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f3829g.hashCode();
            this.f3832j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f3825c;
            this.f3832j = i2;
            int i3 = (i2 * 31) + this.f3826d;
            this.f3832j = i3;
            int hashCode3 = (i3 * 31) + this.f3830h.hashCode();
            this.f3832j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f3827e.hashCode();
            this.f3832j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f3828f.hashCode();
            this.f3832j = hashCode5;
            this.f3832j = (hashCode5 * 31) + this.f3831i.hashCode();
        }
        return this.f3832j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f3824b + ", width=" + this.f3825c + ", height=" + this.f3826d + ", resourceClass=" + this.f3827e + ", transcodeClass=" + this.f3828f + ", signature=" + this.f3829g + ", hashCode=" + this.f3832j + ", transformations=" + this.f3830h + ", options=" + this.f3831i + '}';
    }
}
