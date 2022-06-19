package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.f;
import com.bumptech.glide.load.o.a;

/* compiled from: BitmapImageDecoderResourceDecoder */
public final class d extends a<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final e f4180b = new f();

    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.o.a
    public u<Bitmap> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]");
        }
        return new e(decodeBitmap, this.f4180b);
    }
}
