package com.google.android.exoplayer2.e0.t;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.k;
import com.google.android.exoplayer2.e0.l;
import com.google.android.exoplayer2.e0.m;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.h.h;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;

/* compiled from: Mp3Extractor */
public final class e implements g {
    private static final h.a o = b.f5165a;
    private static final int p = d0.B("Xing");
    private static final int q = d0.B("Info");
    private static final int r = d0.B("VBRI");

    /* renamed from: a  reason: collision with root package name */
    private final int f5169a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5170b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5171c;

    /* renamed from: d  reason: collision with root package name */
    private final m f5172d;

    /* renamed from: e  reason: collision with root package name */
    private final k f5173e;

    /* renamed from: f  reason: collision with root package name */
    private final l f5174f;

    /* renamed from: g  reason: collision with root package name */
    private i f5175g;

    /* renamed from: h  reason: collision with root package name */
    private q f5176h;

    /* renamed from: i  reason: collision with root package name */
    private int f5177i;

    /* renamed from: j  reason: collision with root package name */
    private com.google.android.exoplayer2.f0.a f5178j;

    /* renamed from: k  reason: collision with root package name */
    private a f5179k;
    private long l;
    private long m;
    private int n;

    /* access modifiers changed from: package-private */
    /* compiled from: Mp3Extractor */
    public interface a extends o {
        long b(long j2);

        long d();
    }

    static {
        a aVar = a.f5164a;
    }

    public e() {
        this(0);
    }

    private a b(com.google.android.exoplayer2.e0.h hVar) {
        hVar.j(this.f5171c.f7062a, 0, 4);
        this.f5171c.K(0);
        m.b(this.f5171c.j(), this.f5172d);
        return new c(hVar.d(), hVar.l(), this.f5172d);
    }

    private static int d(s sVar, int i2) {
        if (sVar.d() >= i2 + 4) {
            sVar.K(i2);
            int j2 = sVar.j();
            if (j2 == p || j2 == q) {
                return j2;
            }
        }
        if (sVar.d() < 40) {
            return 0;
        }
        sVar.K(36);
        int j3 = sVar.j();
        int i3 = r;
        if (j3 == i3) {
            return i3;
        }
        return 0;
    }

    private static boolean g(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    static /* synthetic */ g[] h() {
        return new g[]{new e()};
    }

    static /* synthetic */ boolean j(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    private static d k(com.google.android.exoplayer2.f0.a aVar, long j2) {
        if (aVar == null) {
            return null;
        }
        int k2 = aVar.k();
        for (int i2 = 0; i2 < k2; i2++) {
            a.b g2 = aVar.g(i2);
            if (g2 instanceof com.google.android.exoplayer2.f0.h.k) {
                return d.a(j2, (com.google.android.exoplayer2.f0.h.k) g2);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.e0.t.e.a l(com.google.android.exoplayer2.e0.h r10) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.t.e.l(com.google.android.exoplayer2.e0.h):com.google.android.exoplayer2.e0.t.e$a");
    }

    private boolean m(com.google.android.exoplayer2.e0.h hVar) {
        if ((this.f5179k == null || hVar.i() != this.f5179k.d()) && hVar.h(this.f5171c.f7062a, 0, 4, true)) {
            return false;
        }
        return true;
    }

    private int n(com.google.android.exoplayer2.e0.h hVar) {
        if (this.n == 0) {
            hVar.e();
            if (m(hVar)) {
                return -1;
            }
            this.f5171c.K(0);
            int j2 = this.f5171c.j();
            if (!g(j2, (long) this.f5177i) || m.a(j2) == -1) {
                hVar.f(1);
                this.f5177i = 0;
                return 0;
            }
            m.b(j2, this.f5172d);
            if (this.l == -9223372036854775807L) {
                this.l = this.f5179k.b(hVar.l());
                if (this.f5170b != -9223372036854775807L) {
                    this.l += this.f5170b - this.f5179k.b(0);
                }
            }
            this.n = this.f5172d.f5090c;
        }
        int b2 = this.f5176h.b(hVar, this.n, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.n - b2;
        this.n = i2;
        if (i2 > 0) {
            return 0;
        }
        long j3 = this.l;
        m mVar = this.f5172d;
        this.f5176h.c(j3 + ((this.m * 1000000) / ((long) mVar.f5091d)), 1, mVar.f5090c, 0, null);
        this.m += (long) this.f5172d.f5094g;
        this.n = 0;
        return 0;
    }

    private boolean o(com.google.android.exoplayer2.e0.h hVar, boolean z) {
        int i2;
        int i3;
        int a2;
        h.a aVar;
        int i4 = z ? 16384 : 131072;
        hVar.e();
        if (hVar.l() == 0) {
            if ((this.f5169a & 2) == 0) {
                aVar = null;
            } else {
                aVar = o;
            }
            com.google.android.exoplayer2.f0.a a3 = this.f5174f.a(hVar, aVar);
            this.f5178j = a3;
            if (a3 != null) {
                this.f5173e.c(a3);
            }
            i2 = (int) hVar.i();
            if (!z) {
                hVar.f(i2);
            }
            i3 = 0;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!m(hVar)) {
                this.f5171c.K(0);
                int j2 = this.f5171c.j();
                if ((i3 == 0 || g(j2, (long) i3)) && (a2 = m.a(j2)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        m.b(j2, this.f5172d);
                        i3 = j2;
                    }
                    hVar.k(a2 - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 != i4) {
                        if (z) {
                            hVar.e();
                            hVar.k(i2 + i7);
                        } else {
                            hVar.f(1);
                        }
                        i6 = i7;
                        i3 = 0;
                        i5 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw new ParserException("Searched too many bytes.");
                    }
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            hVar.f(i2 + i6);
        } else {
            hVar.e();
        }
        this.f5177i = i3;
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5175g = iVar;
        this.f5176h = iVar.a(0, 1);
        this.f5175g.h();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5177i = 0;
        this.l = -9223372036854775807L;
        this.m = 0;
        this.n = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(com.google.android.exoplayer2.e0.h hVar) {
        return o(hVar, true);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(com.google.android.exoplayer2.e0.h hVar, n nVar) {
        if (this.f5177i == 0) {
            try {
                o(hVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f5179k == null) {
            a l2 = l(hVar);
            d k2 = k(this.f5178j, hVar.l());
            if (k2 != null) {
                this.f5179k = k2;
            } else if (l2 != null) {
                this.f5179k = l2;
            }
            a aVar = this.f5179k;
            if (aVar == null || (!aVar.g() && (this.f5169a & 1) != 0)) {
                this.f5179k = b(hVar);
            }
            this.f5175g.e(this.f5179k);
            q qVar = this.f5176h;
            m mVar = this.f5172d;
            String str = mVar.f5089b;
            int i2 = mVar.f5092e;
            int i3 = mVar.f5091d;
            k kVar = this.f5173e;
            qVar.d(com.google.android.exoplayer2.l.r(null, str, null, -1, 4096, i2, i3, -1, kVar.f5081a, kVar.f5082b, null, null, 0, null, (this.f5169a & 2) != 0 ? null : this.f5178j));
        }
        return n(hVar);
    }

    public e(int i2) {
        this(i2, -9223372036854775807L);
    }

    public e(int i2, long j2) {
        this.f5169a = i2;
        this.f5170b = j2;
        this.f5171c = new s(10);
        this.f5172d = new m();
        this.f5173e = new k();
        this.l = -9223372036854775807L;
        this.f5174f = new l();
    }
}
