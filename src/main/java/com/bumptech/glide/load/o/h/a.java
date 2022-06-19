package com.bumptech.glide.load.o.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.o.d.b;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f4148a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4149b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.o.h.e
    public u<byte[]> a(u<Bitmap> uVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.get().compress(this.f4148a, this.f4149b, byteArrayOutputStream);
        uVar.e();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i2) {
        this.f4148a = compressFormat;
        this.f4149b = i2;
    }
}
