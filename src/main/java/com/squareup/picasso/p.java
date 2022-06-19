package com.squareup.picasso;

/* compiled from: MemoryPolicy */
public enum p {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: b  reason: collision with root package name */
    final int f8732b;

    private p(int i2) {
        this.f8732b = i2;
    }

    static boolean a(int i2) {
        return (i2 & NO_CACHE.f8732b) == 0;
    }

    static boolean c(int i2) {
        return (i2 & NO_STORE.f8732b) == 0;
    }
}
