package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p;

/* compiled from: ClippingMediaPeriod */
public final class m implements t, t.a {

    /* renamed from: b  reason: collision with root package name */
    public final t f6517b;

    /* renamed from: c  reason: collision with root package name */
    private t.a f6518c;

    /* renamed from: d  reason: collision with root package name */
    private a[] f6519d = new a[0];

    /* renamed from: e  reason: collision with root package name */
    private long f6520e;

    /* renamed from: f  reason: collision with root package name */
    long f6521f;

    /* renamed from: g  reason: collision with root package name */
    long f6522g;

    /* compiled from: ClippingMediaPeriod */
    private final class a implements y {

        /* renamed from: b  reason: collision with root package name */
        public final y f6523b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6524c;

        public a(y yVar) {
            this.f6523b = yVar;
        }

        @Override // com.google.android.exoplayer2.source.y
        public void a() {
            this.f6523b.a();
        }

        public void b() {
            this.f6524c = false;
        }

        @Override // com.google.android.exoplayer2.source.y
        public boolean e() {
            return !m.this.h() && this.f6523b.e();
        }

        @Override // com.google.android.exoplayer2.source.y
        public int h(com.google.android.exoplayer2.m mVar, e eVar, boolean z) {
            if (m.this.h()) {
                return -3;
            }
            if (this.f6524c) {
                eVar.l(4);
                return -4;
            }
            int h2 = this.f6523b.h(mVar, eVar, z);
            if (h2 == -5) {
                l lVar = mVar.f5981a;
                int i2 = lVar.x;
                if (!(i2 == 0 && lVar.y == 0)) {
                    m mVar2 = m.this;
                    int i3 = 0;
                    if (mVar2.f6521f != 0) {
                        i2 = 0;
                    }
                    if (mVar2.f6522g == Long.MIN_VALUE) {
                        i3 = lVar.y;
                    }
                    mVar.f5981a = lVar.l(i2, i3);
                }
                return -5;
            }
            m mVar3 = m.this;
            long j2 = mVar3.f6522g;
            if (j2 == Long.MIN_VALUE || ((h2 != -4 || eVar.f4952e < j2) && (h2 != -3 || mVar3.d() != Long.MIN_VALUE))) {
                return h2;
            }
            eVar.f();
            eVar.l(4);
            this.f6524c = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.y
        public int n(long j2) {
            if (m.this.h()) {
                return -3;
            }
            return this.f6523b.n(j2);
        }
    }

    public m(t tVar, boolean z, long j2, long j3) {
        this.f6517b = tVar;
        this.f6520e = z ? j2 : -9223372036854775807L;
        this.f6521f = j2;
        this.f6522g = j3;
    }

    private a0 e(long j2, a0 a0Var) {
        long o = d0.o(a0Var.f4727a, 0, j2 - this.f6521f);
        long j3 = a0Var.f4728b;
        long j4 = this.f6522g;
        long o2 = d0.o(j3, 0, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2);
        if (o == a0Var.f4727a && o2 == a0Var.f4728b) {
            return a0Var;
        }
        return new a0(o, o2);
    }

    private static boolean q(long j2, g[] gVarArr) {
        if (j2 != 0) {
            for (g gVar : gVarArr) {
                if (!(gVar == null || p.k(gVar.k().f5977h))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long b(long j2, a0 a0Var) {
        long j3 = this.f6521f;
        if (j2 == j3) {
            return j3;
        }
        return this.f6517b.b(j2, e(j2, a0Var));
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long c() {
        long c2 = this.f6517b.c();
        if (c2 != Long.MIN_VALUE) {
            long j2 = this.f6522g;
            if (j2 == Long.MIN_VALUE || c2 < j2) {
                return c2;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long d() {
        long d2 = this.f6517b.d();
        if (d2 != Long.MIN_VALUE) {
            long j2 = this.f6522g;
            if (j2 == Long.MIN_VALUE || d2 < j2) {
                return d2;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        return this.f6517b.f(j2);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public void g(long j2) {
        this.f6517b.g(j2);
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f6520e != -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (r2 > r4) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    @Override // com.google.android.exoplayer2.source.t
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long j(com.google.android.exoplayer2.g0.g[] r13, boolean[] r14, com.google.android.exoplayer2.source.y[] r15, boolean[] r16, long r17) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.m.j(com.google.android.exoplayer2.g0.g[], boolean[], com.google.android.exoplayer2.source.y[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.t.a
    public void k(t tVar) {
        this.f6518c.k(this);
    }

    @Override // com.google.android.exoplayer2.source.t
    public long l() {
        if (h()) {
            long j2 = this.f6520e;
            this.f6520e = -9223372036854775807L;
            long l = l();
            return l != -9223372036854775807L ? l : j2;
        }
        long l2 = this.f6517b.l();
        if (l2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.google.android.exoplayer2.util.e.f(l2 >= this.f6521f);
        long j3 = this.f6522g;
        if (j3 != Long.MIN_VALUE && l2 > j3) {
            z = false;
        }
        com.google.android.exoplayer2.util.e.f(z);
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void m(t.a aVar, long j2) {
        this.f6518c = aVar;
        this.f6517b.m(this, j2);
    }

    @Override // com.google.android.exoplayer2.source.t
    public c0 o() {
        return this.f6517b.o();
    }

    /* renamed from: p */
    public void n(t tVar) {
        this.f6518c.n(this);
    }

    @Override // com.google.android.exoplayer2.source.t
    public void r() {
        this.f6517b.r();
    }

    @Override // com.google.android.exoplayer2.source.t
    public void s(long j2, boolean z) {
        this.f6517b.s(j2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    @Override // com.google.android.exoplayer2.source.t
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long t(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f6520e = r0
            com.google.android.exoplayer2.source.m$a[] r0 = r6.f6519d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.b()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.exoplayer2.source.t r0 = r6.f6517b
            long r0 = r0.t(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.f6521f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.f6522g
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.exoplayer2.util.e.f(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.m.t(long):long");
    }
}
