package com.google.android.exoplayer2.g0;

import java.util.Arrays;

/* compiled from: TrackSelectionArray */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f5848a;

    /* renamed from: b  reason: collision with root package name */
    private final g[] f5849b;

    /* renamed from: c  reason: collision with root package name */
    private int f5850c;

    public h(g... gVarArr) {
        this.f5849b = gVarArr;
        this.f5848a = gVarArr.length;
    }

    public g a(int i2) {
        return this.f5849b[i2];
    }

    public g[] b() {
        return (g[]) this.f5849b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f5849b, ((h) obj).f5849b);
    }

    public int hashCode() {
        if (this.f5850c == 0) {
            this.f5850c = 527 + Arrays.hashCode(this.f5849b);
        }
        return this.f5850c;
    }
}
