package com.bumptech.glide.load.o.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;

/* compiled from: DrawableBytesTranscoder */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f4151a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f4152b;

    /* renamed from: c  reason: collision with root package name */
    private final e<com.bumptech.glide.load.o.g.c, byte[]> f4153c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.load.o.g.c, byte[]> eVar3) {
        this.f4151a = eVar;
        this.f4152b = eVar2;
        this.f4153c = eVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bumptech.glide.load.engine.u<android.graphics.drawable.Drawable> */
    /* JADX WARN: Multi-variable type inference failed */
    private static u<com.bumptech.glide.load.o.g.c> b(u<Drawable> uVar) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.o.h.e
    public u<byte[]> a(u<Drawable> uVar, h hVar) {
        Drawable drawable = uVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4152b.a(com.bumptech.glide.load.resource.bitmap.e.f(((BitmapDrawable) drawable).getBitmap(), this.f4151a), hVar);
        }
        if (!(drawable instanceof com.bumptech.glide.load.o.g.c)) {
            return null;
        }
        e<com.bumptech.glide.load.o.g.c, byte[]> eVar = this.f4153c;
        b(uVar);
        return eVar.a(uVar, hVar);
    }
}
