package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import com.bumptech.glide.l.a;
import com.bumptech.glide.load.engine.z.e;

/* compiled from: GifBitmapProvider */
public final class b implements a.AbstractC0086a {

    /* renamed from: a  reason: collision with root package name */
    private final e f4112a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f4113b;

    public b(e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.f4112a = eVar;
        this.f4113b = bVar;
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f4112a.e(i2, i3, config);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public void b(byte[] bArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f4113b;
        if (bVar != null) {
            bVar.d(bArr);
        }
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public byte[] c(int i2) {
        com.bumptech.glide.load.engine.z.b bVar = this.f4113b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public void d(int[] iArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f4113b;
        if (bVar != null) {
            bVar.d(iArr);
        }
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public int[] e(int i2) {
        com.bumptech.glide.load.engine.z.b bVar = this.f4113b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.e(i2, int[].class);
    }

    @Override // com.bumptech.glide.l.a.AbstractC0086a
    public void f(Bitmap bitmap) {
        this.f4112a.d(bitmap);
    }
}
