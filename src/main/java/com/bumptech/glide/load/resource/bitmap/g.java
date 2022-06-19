package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.r.a;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder */
public class g implements j<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final l f4183a;

    public g(l lVar) {
        this.f4183a = lVar;
    }

    /* renamed from: c */
    public u<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, h hVar) {
        return this.f4183a.f(a.f(byteBuffer), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(ByteBuffer byteBuffer, h hVar) {
        return this.f4183a.q(byteBuffer);
    }
}
