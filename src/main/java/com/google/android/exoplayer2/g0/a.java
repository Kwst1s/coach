package com.google.android.exoplayer2.g0;

import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.d0.l;
import com.google.android.exoplayer2.source.d0.m;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.f;
import java.util.List;

/* compiled from: AdaptiveTrackSelection */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    private final e f5797g;

    /* renamed from: h  reason: collision with root package name */
    private final long f5798h;

    /* renamed from: i  reason: collision with root package name */
    private final long f5799i;

    /* renamed from: j  reason: collision with root package name */
    private final long f5800j;

    /* renamed from: k  reason: collision with root package name */
    private final float f5801k;
    private final float l;
    private final long m;
    private final f n;
    private float o = 1.0f;
    private int p = s(Long.MIN_VALUE);
    private int q = 1;
    private long r = -9223372036854775807L;

    /* renamed from: com.google.android.exoplayer2.g0.a$a  reason: collision with other inner class name */
    /* compiled from: AdaptiveTrackSelection */
    public static final class C0128a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final e f5802a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5803b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5804c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5805d;

        /* renamed from: e  reason: collision with root package name */
        private final float f5806e;

        /* renamed from: f  reason: collision with root package name */
        private final float f5807f;

        /* renamed from: g  reason: collision with root package name */
        private final long f5808g;

        /* renamed from: h  reason: collision with root package name */
        private final f f5809h;

        @Deprecated
        public C0128a(e eVar) {
            this(eVar, 10000, 25000, 25000, 0.75f, 0.75f, 2000, f.f7015a);
        }

        /* renamed from: b */
        public a a(b0 b0Var, e eVar, int... iArr) {
            e eVar2 = this.f5802a;
            return new a(b0Var, iArr, eVar2 != null ? eVar2 : eVar, (long) this.f5803b, (long) this.f5804c, (long) this.f5805d, this.f5806e, this.f5807f, this.f5808g, this.f5809h);
        }

        @Deprecated
        public C0128a(e eVar, int i2, int i3, int i4, float f2, float f3, long j2, f fVar) {
            this.f5802a = eVar;
            this.f5803b = i2;
            this.f5804c = i3;
            this.f5805d = i4;
            this.f5806e = f2;
            this.f5807f = f3;
            this.f5808g = j2;
            this.f5809h = fVar;
        }
    }

    public a(b0 b0Var, int[] iArr, e eVar, long j2, long j3, long j4, float f2, float f3, long j5, f fVar) {
        super(b0Var, iArr);
        this.f5797g = eVar;
        this.f5798h = j2 * 1000;
        this.f5799i = j3 * 1000;
        this.f5800j = j4 * 1000;
        this.f5801k = f2;
        this.l = f3;
        this.m = j5;
        this.n = fVar;
    }

    private int s(long j2) {
        long b2 = (long) (((float) this.f5797g.b()) * this.f5801k);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5811b; i3++) {
            if (j2 == Long.MIN_VALUE || !r(i3, j2)) {
                if (((long) Math.round(((float) b(i3).f5973d) * this.o)) <= b2) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    private long t(long j2) {
        return (j2 > -9223372036854775807L ? 1 : (j2 == -9223372036854775807L ? 0 : -1)) != 0 && (j2 > this.f5798h ? 1 : (j2 == this.f5798h ? 0 : -1)) <= 0 ? (long) (((float) j2) * this.l) : this.f5798h;
    }

    @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
    public void d() {
        this.r = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
    public int f(long j2, List<? extends l> list) {
        int i2;
        int i3;
        long c2 = this.n.c();
        long j3 = this.r;
        if (j3 != -9223372036854775807L && c2 - j3 < this.m) {
            return list.size();
        }
        this.r = c2;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (d0.I(((l) list.get(size - 1)).f6103f - j2, this.o) < this.f5800j) {
            return size;
        }
        com.google.android.exoplayer2.l b2 = b(s(c2));
        for (int i4 = 0; i4 < size; i4++) {
            l lVar = (l) list.get(i4);
            com.google.android.exoplayer2.l lVar2 = lVar.f6100c;
            if (d0.I(lVar.f6103f - j2, this.o) >= this.f5800j && lVar2.f5973d < b2.f5973d && (i2 = lVar2.n) != -1 && i2 < 720 && (i3 = lVar2.m) != -1 && i3 < 1280 && i2 < b2.n) {
                return i4;
            }
        }
        return size;
    }

    @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
    public void h(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr) {
        long c2 = this.n.c();
        int i2 = this.p;
        int s = s(c2);
        this.p = s;
        if (s != i2) {
            if (!r(i2, c2)) {
                com.google.android.exoplayer2.l b2 = b(i2);
                com.google.android.exoplayer2.l b3 = b(this.p);
                if (b3.f5973d > b2.f5973d && j3 < t(j4)) {
                    this.p = i2;
                } else if (b3.f5973d < b2.f5973d && j3 >= this.f5799i) {
                    this.p = i2;
                }
            }
            if (this.p != i2) {
                this.q = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.g0.g
    public int l() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public int m() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
    public void n(float f2) {
        this.o = f2;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public Object p() {
        return null;
    }
}
