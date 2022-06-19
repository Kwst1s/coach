package com.bumptech.glide.load.o.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.r.j;

/* compiled from: BitmapDrawableTranscoder */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f4150a;

    public b(Resources resources) {
        j.d(resources);
        this.f4150a = resources;
    }

    @Override // com.bumptech.glide.load.o.h.e
    public u<BitmapDrawable> a(u<Bitmap> uVar, h hVar) {
        return t.f(this.f4150a, uVar);
    }
}
