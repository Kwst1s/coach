package com.bumptech.glide.load.engine.z;

/* compiled from: IntegerArrayAdapter */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int c() {
        return 4;
    }

    /* renamed from: d */
    public int b(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: e */
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
