package com.google.android.exoplayer2.e0.x;

import android.util.Pair;
import com.google.android.exoplayer2.e0.f;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: AdtsReader */
public final class h implements l {
    private static final byte[] v = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5480a;

    /* renamed from: b  reason: collision with root package name */
    private final r f5481b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5482c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5483d;

    /* renamed from: e  reason: collision with root package name */
    private String f5484e;

    /* renamed from: f  reason: collision with root package name */
    private q f5485f;

    /* renamed from: g  reason: collision with root package name */
    private q f5486g;

    /* renamed from: h  reason: collision with root package name */
    private int f5487h;

    /* renamed from: i  reason: collision with root package name */
    private int f5488i;

    /* renamed from: j  reason: collision with root package name */
    private int f5489j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5490k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private q t;
    private long u;

    public h(boolean z) {
        this(z, null);
    }

    private void b(s sVar) {
        if (sVar.a() != 0) {
            this.f5481b.f7058a[0] = sVar.f7062a[sVar.c()];
            this.f5481b.n(2);
            int h2 = this.f5481b.h(4);
            int i2 = this.n;
            if (i2 == -1 || h2 == i2) {
                if (!this.l) {
                    this.l = true;
                    this.m = this.o;
                    this.n = h2;
                }
                s();
                return;
            }
            p();
        }
    }

    private boolean g(s sVar, int i2) {
        sVar.K(i2 + 1);
        if (!v(sVar, this.f5481b.f7058a, 1)) {
            return false;
        }
        this.f5481b.n(4);
        int h2 = this.f5481b.h(1);
        int i3 = this.m;
        if (i3 != -1 && h2 != i3) {
            return false;
        }
        if (this.n != -1) {
            if (!v(sVar, this.f5481b.f7058a, 1)) {
                return true;
            }
            this.f5481b.n(2);
            if (this.f5481b.h(4) != this.n) {
                return false;
            }
            sVar.K(i2 + 2);
        }
        if (!v(sVar, this.f5481b.f7058a, 4)) {
            return true;
        }
        this.f5481b.n(14);
        int h3 = this.f5481b.h(13);
        if (h3 <= 6) {
            return false;
        }
        int i4 = i2 + h3;
        int i5 = i4 + 1;
        if (i5 >= sVar.d()) {
            return true;
        }
        byte[] bArr = sVar.f7062a;
        if (!k(bArr[i4], bArr[i5]) || (this.m != -1 && ((sVar.f7062a[i5] & 8) >> 3) != h2)) {
            return false;
        }
        return true;
    }

    private boolean h(s sVar, byte[] bArr, int i2) {
        int min = Math.min(sVar.a(), i2 - this.f5488i);
        sVar.h(bArr, this.f5488i, min);
        int i3 = this.f5488i + min;
        this.f5488i = i3;
        return i3 == i2;
    }

    private void i(s sVar) {
        byte[] bArr = sVar.f7062a;
        int c2 = sVar.c();
        int d2 = sVar.d();
        while (c2 < d2) {
            int i2 = c2 + 1;
            int i3 = bArr[c2] & 255;
            if (this.f5489j != 512 || !k((byte) -1, (byte) i3) || (!this.l && !g(sVar, i2 - 2))) {
                int i4 = this.f5489j;
                int i5 = i3 | i4;
                if (i5 == 329) {
                    this.f5489j = 768;
                } else if (i5 == 511) {
                    this.f5489j = 512;
                } else if (i5 == 836) {
                    this.f5489j = 1024;
                } else if (i5 == 1075) {
                    t();
                    sVar.K(i2);
                    return;
                } else if (i4 != 256) {
                    this.f5489j = 256;
                    i2--;
                }
                c2 = i2;
            } else {
                this.o = (i3 & 8) >> 3;
                boolean z = true;
                if ((i3 & 1) != 0) {
                    z = false;
                }
                this.f5490k = z;
                if (!this.l) {
                    q();
                } else {
                    s();
                }
                sVar.K(i2);
                return;
            }
        }
        sVar.K(c2);
    }

    private boolean k(byte b2, byte b3) {
        return l(((b2 & 255) << 8) | (b3 & 255));
    }

    public static boolean l(int i2) {
        return (i2 & 65526) == 65520;
    }

    private void m() {
        this.f5481b.n(0);
        if (!this.p) {
            int h2 = this.f5481b.h(2) + 1;
            if (h2 != 2) {
                m.f("AdtsReader", "Detected audio object type: " + h2 + ", but assuming AAC LC.");
                h2 = 2;
            }
            this.f5481b.p(5);
            byte[] a2 = g.a(h2, this.n, this.f5481b.h(3));
            Pair<Integer, Integer> j2 = g.j(a2);
            l t2 = l.t(this.f5484e, "audio/mp4a-latm", null, -1, -1, ((Integer) j2.second).intValue(), ((Integer) j2.first).intValue(), Collections.singletonList(a2), null, 0, this.f5483d);
            this.q = 1024000000 / ((long) t2.v);
            this.f5485f.d(t2);
            this.p = true;
        } else {
            this.f5481b.p(10);
        }
        this.f5481b.p(4);
        int h3 = (this.f5481b.h(13) - 2) - 5;
        if (this.f5490k) {
            h3 -= 2;
        }
        u(this.f5485f, this.q, 0, h3);
    }

    private void n() {
        this.f5486g.a(this.f5482c, 10);
        this.f5482c.K(6);
        u(this.f5486g, 0, 10, this.f5482c.x() + 10);
    }

    private void o(s sVar) {
        int min = Math.min(sVar.a(), this.r - this.f5488i);
        this.t.a(sVar, min);
        int i2 = this.f5488i + min;
        this.f5488i = i2;
        int i3 = this.r;
        if (i2 == i3) {
            this.t.c(this.s, 1, i3, 0, null);
            this.s += this.u;
            r();
        }
    }

    private void p() {
        this.l = false;
        r();
    }

    private void q() {
        this.f5487h = 1;
        this.f5488i = 0;
    }

    private void r() {
        this.f5487h = 0;
        this.f5488i = 0;
        this.f5489j = 256;
    }

    private void s() {
        this.f5487h = 3;
        this.f5488i = 0;
    }

    private void t() {
        this.f5487h = 2;
        this.f5488i = v.length;
        this.r = 0;
        this.f5482c.K(0);
    }

    private void u(q qVar, long j2, int i2, int i3) {
        this.f5487h = 4;
        this.f5488i = i2;
        this.t = qVar;
        this.u = j2;
        this.r = i3;
    }

    private boolean v(s sVar, byte[] bArr, int i2) {
        if (sVar.a() < i2) {
            return false;
        }
        sVar.h(bArr, 0, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        p();
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5487h;
            if (i2 == 0) {
                i(sVar);
            } else if (i2 == 1) {
                b(sVar);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (h(sVar, this.f5481b.f7058a, this.f5490k ? 7 : 5)) {
                        m();
                    }
                } else if (i2 == 4) {
                    o(sVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (h(sVar, this.f5482c.f7062a, 10)) {
                n();
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        this.s = j2;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        this.f5484e = dVar.b();
        this.f5485f = iVar.a(dVar.c(), 1);
        if (this.f5480a) {
            dVar.a();
            q a2 = iVar.a(dVar.c(), 4);
            this.f5486g = a2;
            a2.d(l.x(dVar.b(), "application/id3", null, -1, null));
            return;
        }
        this.f5486g = new f();
    }

    public long j() {
        return this.q;
    }

    public h(boolean z, String str) {
        this.f5481b = new r(new byte[7]);
        this.f5482c = new s(Arrays.copyOf(v, 10));
        r();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.f5480a = z;
        this.f5483d = str;
    }
}
