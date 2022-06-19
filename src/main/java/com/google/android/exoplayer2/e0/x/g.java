package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.c;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;

/* compiled from: AdtsExtractor */
public final class g implements com.google.android.exoplayer2.e0.g {
    private static final int n = d0.B("ID3");

    /* renamed from: a  reason: collision with root package name */
    private final int f5467a;

    /* renamed from: b  reason: collision with root package name */
    private final h f5468b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5469c;

    /* renamed from: d  reason: collision with root package name */
    private final s f5470d;

    /* renamed from: e  reason: collision with root package name */
    private final r f5471e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5472f;

    /* renamed from: g  reason: collision with root package name */
    private i f5473g;

    /* renamed from: h  reason: collision with root package name */
    private long f5474h;

    /* renamed from: i  reason: collision with root package name */
    private long f5475i;

    /* renamed from: j  reason: collision with root package name */
    private int f5476j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5477k;
    private boolean l;
    private boolean m;

    static {
        b bVar = b.f5408a;
    }

    public g() {
        this(0);
    }

    private void b(h hVar) {
        if (!this.f5477k) {
            this.f5476j = -1;
            hVar.e();
            long j2 = 0;
            if (hVar.l() == 0) {
                k(hVar);
            }
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (!hVar.h(this.f5470d.f7062a, 0, 2, true)) {
                    break;
                }
                this.f5470d.K(0);
                if (!h.l(this.f5470d.E())) {
                    break;
                } else if (!hVar.h(this.f5470d.f7062a, 0, 4, true)) {
                    break;
                } else {
                    this.f5471e.n(14);
                    int h2 = this.f5471e.h(13);
                    if (h2 > 6) {
                        j2 += (long) h2;
                        i3++;
                        if (i3 != 1000) {
                            if (!hVar.g(h2 - 6, true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        this.f5477k = true;
                        throw new ParserException("Malformed ADTS stream");
                    }
                }
            }
            i2 = i3;
            hVar.e();
            if (i2 > 0) {
                this.f5476j = (int) (j2 / ((long) i2));
            } else {
                this.f5476j = -1;
            }
            this.f5477k = true;
        }
    }

    private static int d(int i2, long j2) {
        return (int) ((((long) (i2 * 8)) * 1000000) / j2);
    }

    private o g(long j2) {
        return new c(j2, this.f5475i, d(this.f5476j, this.f5468b.j()), this.f5476j);
    }

    static /* synthetic */ com.google.android.exoplayer2.e0.g[] h() {
        return new com.google.android.exoplayer2.e0.g[]{new g()};
    }

    private void j(long j2, boolean z, boolean z2) {
        if (!this.m) {
            boolean z3 = z && this.f5476j > 0;
            if (!z3 || this.f5468b.j() != -9223372036854775807L || z2) {
                i iVar = this.f5473g;
                e.e(iVar);
                i iVar2 = iVar;
                if (!z3 || this.f5468b.j() == -9223372036854775807L) {
                    iVar2.e(new o.b(-9223372036854775807L));
                } else {
                    iVar2.e(g(j2));
                }
                this.m = true;
            }
        }
    }

    private int k(h hVar) {
        int i2 = 0;
        while (true) {
            hVar.j(this.f5470d.f7062a, 0, 10);
            this.f5470d.K(0);
            if (this.f5470d.B() != n) {
                break;
            }
            this.f5470d.L(3);
            int x = this.f5470d.x();
            i2 += x + 10;
            hVar.k(x);
        }
        hVar.e();
        hVar.k(i2);
        if (this.f5475i == -1) {
            this.f5475i = (long) i2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5473g = iVar;
        this.f5468b.f(iVar, new e0.d(0, 1));
        iVar.h();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.l = false;
        this.f5468b.a();
        this.f5474h = this.f5472f + j3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r9.e();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if ((r3 - r0) < 8192) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        return false;
     */
    @Override // com.google.android.exoplayer2.e0.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(com.google.android.exoplayer2.e0.h r9) {
        /*
            r8 = this;
            int r0 = r8.k(r9)
            r1 = 0
            r3 = r0
        L_0x0006:
            r2 = 0
            r4 = 0
        L_0x0008:
            com.google.android.exoplayer2.util.s r5 = r8.f5470d
            byte[] r5 = r5.f7062a
            r6 = 2
            r9.j(r5, r1, r6)
            com.google.android.exoplayer2.util.s r5 = r8.f5470d
            r5.K(r1)
            com.google.android.exoplayer2.util.s r5 = r8.f5470d
            int r5 = r5.E()
            boolean r5 = com.google.android.exoplayer2.e0.x.h.l(r5)
            if (r5 != 0) goto L_0x0031
            r9.e()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L_0x002d
            return r1
        L_0x002d:
            r9.k(r3)
            goto L_0x0006
        L_0x0031:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L_0x003b
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L_0x003b
            return r5
        L_0x003b:
            com.google.android.exoplayer2.util.s r5 = r8.f5470d
            byte[] r5 = r5.f7062a
            r9.j(r5, r1, r6)
            com.google.android.exoplayer2.util.r r5 = r8.f5471e
            r6 = 14
            r5.n(r6)
            com.google.android.exoplayer2.util.r r5 = r8.f5471e
            r6 = 13
            int r5 = r5.h(r6)
            r6 = 6
            if (r5 > r6) goto L_0x0055
            return r1
        L_0x0055:
            int r6 = r5 + -6
            r9.k(r6)
            int r4 = r4 + r5
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.x.g.f(com.google.android.exoplayer2.e0.h):boolean");
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        long d2 = hVar.d();
        boolean z = ((this.f5467a & 1) == 0 || d2 == -1) ? false : true;
        if (z) {
            b(hVar);
        }
        int a2 = hVar.a(this.f5469c.f7062a, 0, 2048);
        boolean z2 = a2 == -1;
        j(d2, z, z2);
        if (z2) {
            return -1;
        }
        this.f5469c.K(0);
        this.f5469c.J(a2);
        if (!this.l) {
            this.f5468b.d(this.f5474h, true);
            this.l = true;
        }
        this.f5468b.c(this.f5469c);
        return 0;
    }

    public g(long j2) {
        this(j2, 0);
    }

    public g(long j2, int i2) {
        this.f5472f = j2;
        this.f5474h = j2;
        this.f5467a = i2;
        this.f5468b = new h(true);
        this.f5469c = new s(2048);
        this.f5476j = -1;
        this.f5475i = -1;
        s sVar = new s(10);
        this.f5470d = sVar;
        this.f5471e = new r(sVar.f7062a);
    }
}
