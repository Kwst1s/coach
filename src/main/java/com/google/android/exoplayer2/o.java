package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.g0.h;
import com.google.android.exoplayer2.g0.i;
import com.google.android.exoplayer2.g0.j;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: MediaPeriodHolder */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final t f6008a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6009b;

    /* renamed from: c  reason: collision with root package name */
    public final y[] f6010c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean[] f6011d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6013f;

    /* renamed from: g  reason: collision with root package name */
    public p f6014g;

    /* renamed from: h  reason: collision with root package name */
    public o f6015h;

    /* renamed from: i  reason: collision with root package name */
    public c0 f6016i;

    /* renamed from: j  reason: collision with root package name */
    public j f6017j;

    /* renamed from: k  reason: collision with root package name */
    private final y[] f6018k;
    private final i l;
    private final u m;
    private long n;
    private j o;

    public o(y[] yVarArr, long j2, i iVar, d dVar, u uVar, p pVar) {
        this.f6018k = yVarArr;
        this.n = j2 - pVar.f6025b;
        this.l = iVar;
        this.m = uVar;
        Object obj = pVar.f6024a.f6613a;
        e.e(obj);
        this.f6009b = obj;
        this.f6014g = pVar;
        this.f6010c = new y[yVarArr.length];
        this.f6011d = new boolean[yVarArr.length];
        t a2 = uVar.a(pVar.f6024a, dVar);
        long j3 = pVar.f6024a.f6617e;
        this.f6008a = j3 != Long.MIN_VALUE ? new m(a2, true, 0, j3) : a2;
    }

    private void c(y[] yVarArr) {
        int i2 = 0;
        while (true) {
            y[] yVarArr2 = this.f6018k;
            if (i2 < yVarArr2.length) {
                if (yVarArr2[i2].g() == 6 && this.f6017j.c(i2)) {
                    yVarArr[i2] = new q();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void e(j jVar) {
        for (int i2 = 0; i2 < jVar.f5852a; i2++) {
            boolean c2 = jVar.c(i2);
            g a2 = jVar.f5854c.a(i2);
            if (c2 && a2 != null) {
                a2.c();
            }
        }
    }

    private void f(y[] yVarArr) {
        int i2 = 0;
        while (true) {
            y[] yVarArr2 = this.f6018k;
            if (i2 < yVarArr2.length) {
                if (yVarArr2[i2].g() == 6) {
                    yVarArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void g(j jVar) {
        for (int i2 = 0; i2 < jVar.f5852a; i2++) {
            boolean c2 = jVar.c(i2);
            g a2 = jVar.f5854c.a(i2);
            if (c2 && a2 != null) {
                a2.d();
            }
        }
    }

    private void s(j jVar) {
        j jVar2 = this.o;
        if (jVar2 != null) {
            e(jVar2);
        }
        this.o = jVar;
        if (jVar != null) {
            g(jVar);
        }
    }

    public long a(long j2, boolean z) {
        return b(j2, z, new boolean[this.f6018k.length]);
    }

    public long b(long j2, boolean z, boolean[] zArr) {
        int i2 = 0;
        while (true) {
            j jVar = this.f6017j;
            boolean z2 = true;
            if (i2 >= jVar.f5852a) {
                break;
            }
            boolean[] zArr2 = this.f6011d;
            if (z || !jVar.b(this.o, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        f(this.f6010c);
        s(this.f6017j);
        h hVar = this.f6017j.f5854c;
        long j3 = this.f6008a.j(hVar.b(), this.f6011d, this.f6010c, zArr, j2);
        c(this.f6010c);
        this.f6013f = false;
        int i3 = 0;
        while (true) {
            y[] yVarArr = this.f6010c;
            if (i3 >= yVarArr.length) {
                return j3;
            }
            if (yVarArr[i3] != null) {
                e.f(this.f6017j.c(i3));
                if (this.f6018k[i3].g() != 6) {
                    this.f6013f = true;
                }
            } else {
                e.f(hVar.a(i3) == null);
            }
            i3++;
        }
    }

    public void d(long j2) {
        this.f6008a.f(q(j2));
    }

    public long h() {
        if (!this.f6012e) {
            return this.f6014g.f6025b;
        }
        long d2 = this.f6013f ? this.f6008a.d() : Long.MIN_VALUE;
        return d2 == Long.MIN_VALUE ? this.f6014g.f6027d : d2;
    }

    public long i() {
        if (!this.f6012e) {
            return 0;
        }
        return this.f6008a.c();
    }

    public long j() {
        return this.n;
    }

    public long k() {
        return this.f6014g.f6025b + this.n;
    }

    public void l(float f2) {
        this.f6012e = true;
        this.f6016i = this.f6008a.o();
        p(f2);
        long a2 = a(this.f6014g.f6025b, false);
        long j2 = this.n;
        p pVar = this.f6014g;
        this.n = j2 + (pVar.f6025b - a2);
        this.f6014g = pVar.a(a2);
    }

    public boolean m() {
        return this.f6012e && (!this.f6013f || this.f6008a.d() == Long.MIN_VALUE);
    }

    public void n(long j2) {
        if (this.f6012e) {
            this.f6008a.g(q(j2));
        }
    }

    public void o() {
        s(null);
        try {
            if (this.f6014g.f6024a.f6617e != Long.MIN_VALUE) {
                this.m.c(((m) this.f6008a).f6517b);
            } else {
                this.m.c(this.f6008a);
            }
        } catch (RuntimeException e2) {
            com.google.android.exoplayer2.util.m.d("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public boolean p(float f2) {
        j d2 = this.l.d(this.f6018k, this.f6016i);
        if (d2.a(this.o)) {
            return false;
        }
        this.f6017j = d2;
        g[] b2 = d2.f5854c.b();
        for (g gVar : b2) {
            if (gVar != null) {
                gVar.n(f2);
            }
        }
        return true;
    }

    public long q(long j2) {
        return j2 - j();
    }

    public long r(long j2) {
        return j2 + j();
    }
}
