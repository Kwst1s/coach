package com.bumptech.glide.load.engine.z;

/* compiled from: ByteArrayAdapter */
public final class g implements a<byte[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int c() {
        return 1;
    }

    /* renamed from: d */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: e */
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
