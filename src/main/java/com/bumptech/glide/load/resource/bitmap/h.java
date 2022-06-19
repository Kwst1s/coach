package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder */
public final class h implements j<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f4184a = new d();

    /* renamed from: c */
    public u<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.load.h hVar) {
        return this.f4184a.a(ImageDecoder.createSource(byteBuffer), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(ByteBuffer byteBuffer, com.bumptech.glide.load.h hVar) {
        return true;
    }
}
