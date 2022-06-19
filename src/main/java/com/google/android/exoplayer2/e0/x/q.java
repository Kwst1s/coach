package com.google.android.exoplayer2.e0.x;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;

/* compiled from: LatmReader */
public final class q implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f5587a;

    /* renamed from: b  reason: collision with root package name */
    private final s f5588b;

    /* renamed from: c  reason: collision with root package name */
    private final r f5589c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.exoplayer2.e0.q f5590d;

    /* renamed from: e  reason: collision with root package name */
    private l f5591e;

    /* renamed from: f  reason: collision with root package name */
    private String f5592f;

    /* renamed from: g  reason: collision with root package name */
    private int f5593g;

    /* renamed from: h  reason: collision with root package name */
    private int f5594h;

    /* renamed from: i  reason: collision with root package name */
    private int f5595i;

    /* renamed from: j  reason: collision with root package name */
    private int f5596j;

    /* renamed from: k  reason: collision with root package name */
    private long f5597k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;

    public q(String str) {
        this.f5587a = str;
        s sVar = new s(1024);
        this.f5588b = sVar;
        this.f5589c = new r(sVar.f7062a);
    }

    private static long b(r rVar) {
        return (long) rVar.h((rVar.h(2) + 1) * 8);
    }

    private void g(r rVar) {
        if (!rVar.g()) {
            this.l = true;
            l(rVar);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw new ParserException();
        } else if (this.n == 0) {
            k(rVar, j(rVar));
            if (this.p) {
                rVar.p((int) this.q);
            }
        } else {
            throw new ParserException();
        }
    }

    private int h(r rVar) {
        int b2 = rVar.b();
        Pair<Integer, Integer> i2 = g.i(rVar, true);
        this.r = ((Integer) i2.first).intValue();
        this.t = ((Integer) i2.second).intValue();
        return b2 - rVar.b();
    }

    private void i(r rVar) {
        int h2 = rVar.h(3);
        this.o = h2;
        if (h2 == 0) {
            rVar.p(8);
        } else if (h2 == 1) {
            rVar.p(9);
        } else if (h2 == 3 || h2 == 4 || h2 == 5) {
            rVar.p(6);
        } else if (h2 == 6 || h2 == 7) {
            rVar.p(1);
        } else {
            throw new IllegalStateException();
        }
    }

    private int j(r rVar) {
        int h2;
        if (this.o == 0) {
            int i2 = 0;
            do {
                h2 = rVar.h(8);
                i2 += h2;
            } while (h2 == 255);
            return i2;
        }
        throw new ParserException();
    }

    private void k(r rVar, int i2) {
        int e2 = rVar.e();
        if ((e2 & 7) == 0) {
            this.f5588b.K(e2 >> 3);
        } else {
            rVar.i(this.f5588b.f7062a, 0, i2 * 8);
            this.f5588b.K(0);
        }
        this.f5590d.a(this.f5588b, i2);
        this.f5590d.c(this.f5597k, 1, i2, 0, null);
        this.f5597k += this.s;
    }

    private void l(r rVar) {
        boolean g2;
        int h2 = rVar.h(1);
        int h3 = h2 == 1 ? rVar.h(1) : 0;
        this.m = h3;
        if (h3 == 0) {
            if (h2 == 1) {
                b(rVar);
            }
            if (rVar.g()) {
                this.n = rVar.h(6);
                int h4 = rVar.h(4);
                int h5 = rVar.h(3);
                if (h4 == 0 && h5 == 0) {
                    if (h2 == 0) {
                        int e2 = rVar.e();
                        int h6 = h(rVar);
                        rVar.n(e2);
                        byte[] bArr = new byte[((h6 + 7) / 8)];
                        rVar.i(bArr, 0, h6);
                        l t2 = l.t(this.f5592f, "audio/mp4a-latm", null, -1, -1, this.t, this.r, Collections.singletonList(bArr), null, 0, this.f5587a);
                        if (!t2.equals(this.f5591e)) {
                            this.f5591e = t2;
                            this.s = 1024000000 / ((long) t2.v);
                            this.f5590d.d(t2);
                        }
                    } else {
                        rVar.p(((int) b(rVar)) - h(rVar));
                    }
                    i(rVar);
                    boolean g3 = rVar.g();
                    this.p = g3;
                    this.q = 0;
                    if (g3) {
                        if (h2 == 1) {
                            this.q = b(rVar);
                        } else {
                            do {
                                g2 = rVar.g();
                                this.q = (this.q << 8) + ((long) rVar.h(8));
                            } while (g2);
                        }
                    }
                    if (rVar.g()) {
                        rVar.p(8);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
        throw new ParserException();
    }

    private void m(int i2) {
        this.f5588b.H(i2);
        this.f5589c.l(this.f5588b.f7062a);
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5593g = 0;
        this.l = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5593g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int y = sVar.y();
                    if ((y & 224) == 224) {
                        this.f5596j = y;
                        this.f5593g = 2;
                    } else if (y != 86) {
                        this.f5593g = 0;
                    }
                } else if (i2 == 2) {
                    int y2 = ((this.f5596j & -225) << 8) | sVar.y();
                    this.f5595i = y2;
                    if (y2 > this.f5588b.f7062a.length) {
                        m(y2);
                    }
                    this.f5594h = 0;
                    this.f5593g = 3;
                } else if (i2 == 3) {
                    int min = Math.min(sVar.a(), this.f5595i - this.f5594h);
                    sVar.h(this.f5589c.f7058a, this.f5594h, min);
                    int i3 = this.f5594h + min;
                    this.f5594h = i3;
                    if (i3 == this.f5595i) {
                        this.f5589c.n(0);
                        g(this.f5589c);
                        this.f5593g = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (sVar.y() == 86) {
                this.f5593g = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        this.f5597k = j2;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        this.f5590d = iVar.a(dVar.c(), 1);
        this.f5592f = dVar.b();
    }
}
