package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.g0.j;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;

/* access modifiers changed from: package-private */
/* compiled from: PlaybackInfo */
public final class r {
    private static final u.a n = new u.a(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final b0 f6041a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6042b;

    /* renamed from: c  reason: collision with root package name */
    public final u.a f6043c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6044d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6045e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6046f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6047g;

    /* renamed from: h  reason: collision with root package name */
    public final c0 f6048h;

    /* renamed from: i  reason: collision with root package name */
    public final j f6049i;

    /* renamed from: j  reason: collision with root package name */
    public final u.a f6050j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f6051k;
    public volatile long l;
    public volatile long m;

    public r(b0 b0Var, Object obj, u.a aVar, long j2, long j3, int i2, boolean z, c0 c0Var, j jVar, u.a aVar2, long j4, long j5, long j6) {
        this.f6041a = b0Var;
        this.f6042b = obj;
        this.f6043c = aVar;
        this.f6044d = j2;
        this.f6045e = j3;
        this.f6046f = i2;
        this.f6047g = z;
        this.f6048h = c0Var;
        this.f6049i = jVar;
        this.f6050j = aVar2;
        this.f6051k = j4;
        this.l = j5;
        this.m = j6;
    }

    public static r g(long j2, j jVar) {
        b0 b0Var = b0.f4885a;
        u.a aVar = n;
        return new r(b0Var, null, aVar, j2, -9223372036854775807L, 1, false, c0.f6086e, jVar, aVar, j2, 0, j2);
    }

    public r a(boolean z) {
        return new r(this.f6041a, this.f6042b, this.f6043c, this.f6044d, this.f6045e, this.f6046f, z, this.f6048h, this.f6049i, this.f6050j, this.f6051k, this.l, this.m);
    }

    public r b(u.a aVar) {
        return new r(this.f6041a, this.f6042b, this.f6043c, this.f6044d, this.f6045e, this.f6046f, this.f6047g, this.f6048h, this.f6049i, aVar, this.f6051k, this.l, this.m);
    }

    public r c(u.a aVar, long j2, long j3, long j4) {
        return new r(this.f6041a, this.f6042b, aVar, j2, aVar.a() ? j3 : -9223372036854775807L, this.f6046f, this.f6047g, this.f6048h, this.f6049i, this.f6050j, this.f6051k, j4, j2);
    }

    public r d(int i2) {
        return new r(this.f6041a, this.f6042b, this.f6043c, this.f6044d, this.f6045e, i2, this.f6047g, this.f6048h, this.f6049i, this.f6050j, this.f6051k, this.l, this.m);
    }

    public r e(b0 b0Var, Object obj) {
        return new r(b0Var, obj, this.f6043c, this.f6044d, this.f6045e, this.f6046f, this.f6047g, this.f6048h, this.f6049i, this.f6050j, this.f6051k, this.l, this.m);
    }

    public r f(c0 c0Var, j jVar) {
        return new r(this.f6041a, this.f6042b, this.f6043c, this.f6044d, this.f6045e, this.f6046f, this.f6047g, c0Var, jVar, this.f6050j, this.f6051k, this.l, this.m);
    }

    public u.a h(boolean z, b0.c cVar) {
        if (this.f6041a.r()) {
            return n;
        }
        b0 b0Var = this.f6041a;
        return new u.a(this.f6041a.m(b0Var.n(b0Var.a(z), cVar).f4894c));
    }

    public r i(u.a aVar, long j2, long j3) {
        return new r(this.f6041a, this.f6042b, aVar, j2, aVar.a() ? j3 : -9223372036854775807L, this.f6046f, this.f6047g, this.f6048h, this.f6049i, aVar, j2, 0, j2);
    }
}
