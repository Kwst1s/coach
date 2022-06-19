package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.r.a;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder */
public final class s implements j<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f4225a = new d();

    /* renamed from: c */
    public u<Bitmap> a(InputStream inputStream, int i2, int i3, h hVar) {
        return this.f4225a.a(ImageDecoder.createSource(a.b(inputStream)), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, h hVar) {
        return true;
    }
}
