package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.r.k;

/* compiled from: UnitBitmapDecoder */
public final class z implements j<Bitmap, Bitmap> {

    /* access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder */
    public static final class a implements u<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f4245b;

        a(Bitmap bitmap) {
            this.f4245b = bitmap;
        }

        /* renamed from: a */
        public Bitmap get() {
            return this.f4245b;
        }

        @Override // com.bumptech.glide.load.engine.u
        public int b() {
            return k.g(this.f4245b);
        }

        @Override // com.bumptech.glide.load.engine.u
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.u
        public void e() {
        }
    }

    /* renamed from: c */
    public u<Bitmap> a(Bitmap bitmap, int i2, int i3, h hVar) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean b(Bitmap bitmap, h hVar) {
        return true;
    }
}
