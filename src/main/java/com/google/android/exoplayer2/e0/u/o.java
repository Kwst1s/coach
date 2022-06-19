package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: TrackSampleTable */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final l f5324a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5325b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f5326c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f5327d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5328e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f5329f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f5330g;

    /* renamed from: h  reason: collision with root package name */
    public final long f5331h;

    public o(l lVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        boolean z = true;
        e.a(iArr.length == jArr2.length);
        e.a(jArr.length == jArr2.length);
        e.a(iArr2.length != jArr2.length ? false : z);
        this.f5324a = lVar;
        this.f5326c = jArr;
        this.f5327d = iArr;
        this.f5328e = i2;
        this.f5329f = jArr2;
        this.f5330g = iArr2;
        this.f5331h = j2;
        this.f5325b = jArr.length;
    }

    public int a(long j2) {
        for (int e2 = d0.e(this.f5329f, j2, true, false); e2 >= 0; e2--) {
            if ((this.f5330g[e2] & 1) != 0) {
                return e2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int c2 = d0.c(this.f5329f, j2, true, false); c2 < this.f5329f.length; c2++) {
            if ((this.f5330g[c2] & 1) != 0) {
                return c2;
            }
        }
        return -1;
    }
}
