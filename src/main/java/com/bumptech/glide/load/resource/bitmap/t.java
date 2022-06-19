package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* compiled from: LazyBitmapDrawableResource */
public final class t implements u<BitmapDrawable>, q {

    /* renamed from: b  reason: collision with root package name */
    private final Resources f4226b;

    /* renamed from: c  reason: collision with root package name */
    private final u<Bitmap> f4227c;

    private t(Resources resources, u<Bitmap> uVar) {
        j.d(resources);
        this.f4226b = resources;
        j.d(uVar);
        this.f4227c = uVar;
    }

    public static u<BitmapDrawable> f(Resources resources, u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new t(resources, uVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        u<Bitmap> uVar = this.f4227c;
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return this.f4227c.b();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    /* renamed from: d */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f4226b, this.f4227c.get());
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
        this.f4227c.e();
    }
}
