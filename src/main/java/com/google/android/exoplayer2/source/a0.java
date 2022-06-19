package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.util.e;

/* compiled from: SinglePeriodTimeline */
public final class a0 extends b0 {

    /* renamed from: k  reason: collision with root package name */
    private static final Object f6058k = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final long f6059b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6060c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6061d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6062e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6063f;

    /* renamed from: g  reason: collision with root package name */
    private final long f6064g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6065h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f6066i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f6067j;

    public a0(long j2, boolean z, boolean z2, Object obj) {
        this(j2, j2, 0, 0, z, z2, obj);
    }

    @Override // com.google.android.exoplayer2.b0
    public int b(Object obj) {
        return f6058k.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.b0
    public b0.b g(int i2, b0.b bVar, boolean z) {
        e.c(i2, 0, 1);
        bVar.n(null, z ? f6058k : null, 0, this.f6061d, -this.f6063f);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.b0
    public int i() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.b0
    public Object m(int i2) {
        e.c(i2, 0, 1);
        return f6058k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r1 > r6) goto L_0x0027;
     */
    @Override // com.google.android.exoplayer2.b0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.b0.c p(int r19, com.google.android.exoplayer2.b0.c r20, boolean r21, long r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = 1
            r3 = r19
            com.google.android.exoplayer2.util.e.c(r3, r1, r2)
            if (r21 == 0) goto L_0x000e
            java.lang.Object r1 = r0.f6067j
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            r3 = r1
            long r1 = r0.f6064g
            boolean r9 = r0.f6066i
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 == 0) goto L_0x0030
            r6 = 0
            int r8 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0030
            long r6 = r0.f6062e
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0029
        L_0x0027:
            r10 = r4
            goto L_0x0031
        L_0x0029:
            long r1 = r1 + r22
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0030
            goto L_0x0027
        L_0x0030:
            r10 = r1
        L_0x0031:
            long r4 = r0.f6059b
            long r6 = r0.f6060c
            boolean r8 = r0.f6065h
            long r12 = r0.f6062e
            r14 = 0
            r15 = 0
            long r1 = r0.f6063f
            r16 = r1
            r2 = r20
            r2.e(r3, r4, r6, r8, r9, r10, r12, r14, r15, r16)
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.a0.p(int, com.google.android.exoplayer2.b0$c, boolean, long):com.google.android.exoplayer2.b0$c");
    }

    @Override // com.google.android.exoplayer2.b0
    public int q() {
        return 1;
    }

    public a0(long j2, long j3, long j4, long j5, boolean z, boolean z2, Object obj) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2, obj);
    }

    public a0(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, Object obj) {
        this.f6059b = j2;
        this.f6060c = j3;
        this.f6061d = j4;
        this.f6062e = j5;
        this.f6063f = j6;
        this.f6064g = j7;
        this.f6065h = z;
        this.f6066i = z2;
        this.f6067j = obj;
    }
}
