package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: TrackFragment */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public e f5313a;

    /* renamed from: b  reason: collision with root package name */
    public long f5314b;

    /* renamed from: c  reason: collision with root package name */
    public long f5315c;

    /* renamed from: d  reason: collision with root package name */
    public long f5316d;

    /* renamed from: e  reason: collision with root package name */
    public int f5317e;

    /* renamed from: f  reason: collision with root package name */
    public int f5318f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f5319g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f5320h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f5321i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f5322j;

    /* renamed from: k  reason: collision with root package name */
    public long[] f5323k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public m o;
    public int p;
    public s q;
    public boolean r;
    public long s;

    n() {
    }

    public void a(h hVar) {
        hVar.readFully(this.q.f7062a, 0, this.p);
        this.q.K(0);
        this.r = false;
    }

    public void b(s sVar) {
        sVar.h(this.q.f7062a, 0, this.p);
        this.q.K(0);
        this.r = false;
    }

    public long c(int i2) {
        return this.f5323k[i2] + ((long) this.f5322j[i2]);
    }

    public void d(int i2) {
        s sVar = this.q;
        if (sVar == null || sVar.d() < i2) {
            this.q = new s(i2);
        }
        this.p = i2;
        this.m = true;
        this.r = true;
    }

    public void e(int i2, int i3) {
        this.f5317e = i2;
        this.f5318f = i3;
        int[] iArr = this.f5320h;
        if (iArr == null || iArr.length < i2) {
            this.f5319g = new long[i2];
            this.f5320h = new int[i2];
        }
        int[] iArr2 = this.f5321i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f5321i = new int[i4];
            this.f5322j = new int[i4];
            this.f5323k = new long[i4];
            this.l = new boolean[i4];
            this.n = new boolean[i4];
        }
    }

    public void f() {
        this.f5317e = 0;
        this.s = 0;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public boolean g(int i2) {
        return this.m && this.n[i2];
    }
}
