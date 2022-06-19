package com.bumptech.glide.load.o.d;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* compiled from: BytesResource */
public class b implements u<byte[]> {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f4100b;

    public b(byte[] bArr) {
        j.d(bArr);
        this.f4100b = bArr;
    }

    /* renamed from: a */
    public byte[] get() {
        return this.f4100b;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return this.f4100b.length;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
    }
}
