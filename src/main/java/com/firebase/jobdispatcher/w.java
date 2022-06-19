package com.firebase.jobdispatcher;

/* compiled from: RetryStrategy */
public final class w {

    /* renamed from: d  reason: collision with root package name */
    public static final w f4671d = new w(1, 30, 3600);

    /* renamed from: a  reason: collision with root package name */
    private final int f4672a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4673b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4674c;

    w(int i2, int i3, int i4) {
        this.f4672a = i2;
        this.f4673b = i3;
        this.f4674c = i4;
    }

    public int a() {
        return this.f4673b;
    }

    public int b() {
        return this.f4674c;
    }

    public int c() {
        return this.f4672a;
    }
}
