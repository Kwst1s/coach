package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.k;

/* compiled from: BitmapResource */
public class e implements u<Bitmap>, q {

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f4181b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f4182c;

    public e(Bitmap bitmap, com.bumptech.glide.load.engine.z.e eVar) {
        j.e(bitmap, "Bitmap must not be null");
        this.f4181b = bitmap;
        j.e(eVar, "BitmapPool must not be null");
        this.f4182c = eVar;
    }

    public static e f(Bitmap bitmap, com.bumptech.glide.load.engine.z.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        this.f4181b.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return k.g(this.f4181b);
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    /* renamed from: d */
    public Bitmap get() {
        return this.f4181b;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
        this.f4182c.d(this.f4181b);
    }
}
