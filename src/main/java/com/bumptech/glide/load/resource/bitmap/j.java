package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: CenterInside */
public class j extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4186b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f.f3924a);

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f4186b);
    }

    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.resource.bitmap.f
    public Bitmap c(e eVar, Bitmap bitmap, int i2, int i3) {
        return y.c(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return -670243078;
    }
}
