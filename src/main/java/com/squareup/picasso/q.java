package com.squareup.picasso;

/* compiled from: NetworkPolicy */
public enum q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: b  reason: collision with root package name */
    final int f8737b;

    private q(int i2) {
        this.f8737b = i2;
    }

    public static boolean a(int i2) {
        return (i2 & OFFLINE.f8737b) != 0;
    }

    public static boolean c(int i2) {
        return (i2 & NO_CACHE.f8737b) == 0;
    }

    public static boolean d(int i2) {
        return (i2 & NO_STORE.f8737b) == 0;
    }
}
