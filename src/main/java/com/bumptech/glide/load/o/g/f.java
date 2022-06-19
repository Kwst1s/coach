package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.e;
import com.bumptech.glide.r.j;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation */
public class f implements l<c> {

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f4125b;

    public f(l<Bitmap> lVar) {
        j.d(lVar);
        this.f4125b = lVar;
    }

    @Override // com.bumptech.glide.load.l
    public u<c> a(Context context, u<c> uVar, int i2, int i3) {
        c cVar = uVar.get();
        u<Bitmap> eVar = new e(cVar.e(), b.c(context).f());
        u<Bitmap> a2 = this.f4125b.a(context, eVar, i2, i3);
        if (!eVar.equals(a2)) {
            eVar.e();
        }
        cVar.m(this.f4125b, a2.get());
        return uVar;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        this.f4125b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f4125b.equals(((f) obj).f4125b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f4125b.hashCode();
    }
}
