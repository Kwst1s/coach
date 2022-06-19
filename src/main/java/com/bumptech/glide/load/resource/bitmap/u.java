package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;

/* compiled from: ParcelFileDescriptorBitmapDecoder */
public final class u implements j<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final l f4228a;

    public u(l lVar) {
        this.f4228a = lVar;
    }

    /* renamed from: c */
    public com.bumptech.glide.load.engine.u<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, h hVar) {
        return this.f4228a.d(parcelFileDescriptor, i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(ParcelFileDescriptor parcelFileDescriptor, h hVar) {
        return this.f4228a.o(parcelFileDescriptor);
    }
}
