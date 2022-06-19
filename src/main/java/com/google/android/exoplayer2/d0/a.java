package com.google.android.exoplayer2.d0;

/* compiled from: Buffer */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    private int f4928b;

    public final void e(int i2) {
        this.f4928b = i2 | this.f4928b;
    }

    public void f() {
        this.f4928b = 0;
    }

    public final void g(int i2) {
        this.f4928b = (i2 ^ -1) & this.f4928b;
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i2) {
        return (this.f4928b & i2) == i2;
    }

    public final boolean i() {
        return h(Integer.MIN_VALUE);
    }

    public final boolean j() {
        return h(4);
    }

    public final boolean k() {
        return h(1);
    }

    public final void l(int i2) {
        this.f4928b = i2;
    }
}
