package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;

/* compiled from: BitmapDrawableDecoder */
public class a<DataType> implements j<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final j<DataType, Bitmap> f4164a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f4165b;

    public a(Resources resources, j<DataType, Bitmap> jVar) {
        com.bumptech.glide.r.j.d(resources);
        this.f4165b = resources;
        com.bumptech.glide.r.j.d(jVar);
        this.f4164a = jVar;
    }

    @Override // com.bumptech.glide.load.j
    public u<BitmapDrawable> a(DataType datatype, int i2, int i3, h hVar) {
        return t.f(this.f4165b, this.f4164a.a(datatype, i2, i3, hVar));
    }

    @Override // com.bumptech.glide.load.j
    public boolean b(DataType datatype, h hVar) {
        return this.f4164a.b(datatype, hVar);
    }
}
