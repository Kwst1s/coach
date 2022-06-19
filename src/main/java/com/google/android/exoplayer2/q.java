package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.g0.i;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: MediaPeriodQueue */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final b0.b f6030a = new b0.b();

    /* renamed from: b  reason: collision with root package name */
    private final b0.c f6031b = new b0.c();

    /* renamed from: c  reason: collision with root package name */
    private long f6032c;

    /* renamed from: d  reason: collision with root package name */
    private b0 f6033d = b0.f4885a;

    /* renamed from: e  reason: collision with root package name */
    private int f6034e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6035f;

    /* renamed from: g  reason: collision with root package name */
    private o f6036g;

    /* renamed from: h  reason: collision with root package name */
    private o f6037h;

    /* renamed from: i  reason: collision with root package name */
    private o f6038i;

    /* renamed from: j  reason: collision with root package name */
    private int f6039j;

    /* renamed from: k  reason: collision with root package name */
    private Object f6040k;
    private long l;

    private boolean B() {
        o oVar;
        o h2 = h();
        if (h2 == null) {
            return true;
        }
        int b2 = this.f6033d.b(h2.f6009b);
        while (true) {
            b2 = this.f6033d.d(b2, this.f6030a, this.f6031b, this.f6034e, this.f6035f);
            while (true) {
                oVar = h2.f6015h;
                if (oVar != null && !h2.f6014g.f6028e) {
                    h2 = oVar;
                }
            }
            if (b2 == -1 || oVar == null || this.f6033d.b(oVar.f6009b) != b2) {
                boolean v = v(h2);
                h2.f6014g = p(h2.f6014g);
            } else {
                h2 = h2.f6015h;
            }
        }
        boolean v2 = v(h2);
        h2.f6014g = p(h2.f6014g);
        if (!v2 || !q()) {
            return true;
        }
        return false;
    }

    private boolean c(o oVar, p pVar) {
        p pVar2 = oVar.f6014g;
        return pVar2.f6025b == pVar.f6025b && pVar2.f6024a.equals(pVar.f6024a);
    }

    private p f(r rVar) {
        return j(rVar.f6043c, rVar.f6045e, rVar.f6044d);
    }

    private p g(o oVar, long j2) {
        long j3;
        long j4;
        Object obj;
        long j5;
        p pVar = oVar.f6014g;
        long j6 = (oVar.j() + pVar.f6027d) - j2;
        long j7 = 0;
        if (pVar.f6028e) {
            int d2 = this.f6033d.d(this.f6033d.b(pVar.f6024a.f6613a), this.f6030a, this.f6031b, this.f6034e, this.f6035f);
            if (d2 == -1) {
                return null;
            }
            int i2 = this.f6033d.g(d2, this.f6030a, true).f4888c;
            Object obj2 = this.f6030a.f4887b;
            long j8 = pVar.f6024a.f6616d;
            if (this.f6033d.n(i2, this.f6031b).f4894c == d2) {
                Pair<Object, Long> k2 = this.f6033d.k(this.f6031b, this.f6030a, i2, -9223372036854775807L, Math.max(0L, j6));
                if (k2 == null) {
                    return null;
                }
                Object obj3 = k2.first;
                long longValue = ((Long) k2.second).longValue();
                o oVar2 = oVar.f6015h;
                if (oVar2 == null || !oVar2.f6009b.equals(obj3)) {
                    j5 = this.f6032c;
                    this.f6032c = 1 + j5;
                } else {
                    j5 = oVar.f6015h.f6014g.f6024a.f6616d;
                }
                j7 = longValue;
                j4 = j5;
                obj = obj3;
            } else {
                obj = obj2;
                j4 = j8;
            }
            return j(x(obj, j7, j4), j7, j7);
        }
        u.a aVar = pVar.f6024a;
        this.f6033d.h(aVar.f6613a, this.f6030a);
        if (aVar.a()) {
            int i3 = aVar.f6614b;
            int a2 = this.f6030a.a(i3);
            if (a2 == -1) {
                return null;
            }
            int j9 = this.f6030a.j(i3, aVar.f6615c);
            if (j9 >= a2) {
                long j10 = pVar.f6026c;
                if (this.f6030a.c() == 1 && this.f6030a.f(0) == 0) {
                    b0 b0Var = this.f6033d;
                    b0.c cVar = this.f6031b;
                    b0.b bVar = this.f6030a;
                    Pair<Object, Long> k3 = b0Var.k(cVar, bVar, bVar.f4888c, -9223372036854775807L, Math.max(0L, j6));
                    if (k3 == null) {
                        return null;
                    }
                    j3 = ((Long) k3.second).longValue();
                } else {
                    j3 = j10;
                }
                return l(aVar.f6613a, j3, aVar.f6616d);
            } else if (!this.f6030a.m(i3, j9)) {
                return null;
            } else {
                return k(aVar.f6613a, i3, j9, pVar.f6026c, aVar.f6616d);
            }
        } else {
            long j11 = pVar.f6024a.f6617e;
            if (j11 != Long.MIN_VALUE) {
                int e2 = this.f6030a.e(j11);
                if (e2 == -1) {
                    return l(aVar.f6613a, pVar.f6024a.f6617e, aVar.f6616d);
                }
                int i4 = this.f6030a.i(e2);
                if (!this.f6030a.m(e2, i4)) {
                    return null;
                }
                return k(aVar.f6613a, e2, i4, pVar.f6024a.f6617e, aVar.f6616d);
            }
            int c2 = this.f6030a.c();
            if (c2 == 0) {
                return null;
            }
            int i5 = c2 - 1;
            if (this.f6030a.f(i5) != Long.MIN_VALUE || this.f6030a.l(i5)) {
                return null;
            }
            int i6 = this.f6030a.i(i5);
            if (!this.f6030a.m(i5, i6)) {
                return null;
            }
            return k(aVar.f6613a, i5, i6, this.f6030a.h(), aVar.f6616d);
        }
    }

    private p j(u.a aVar, long j2, long j3) {
        this.f6033d.h(aVar.f6613a, this.f6030a);
        if (!aVar.a()) {
            return l(aVar.f6613a, j3, aVar.f6616d);
        }
        if (!this.f6030a.m(aVar.f6614b, aVar.f6615c)) {
            return null;
        }
        return k(aVar.f6613a, aVar.f6614b, aVar.f6615c, j2, aVar.f6616d);
    }

    private p k(Object obj, int i2, int i3, long j2, long j3) {
        u.a aVar = new u.a(obj, i2, i3, j3);
        boolean r = r(aVar);
        boolean s = s(aVar, r);
        return new p(aVar, i3 == this.f6030a.i(i2) ? this.f6030a.g() : 0, j2, this.f6033d.h(aVar.f6613a, this.f6030a).b(aVar.f6614b, aVar.f6615c), r, s);
    }

    private p l(Object obj, long j2, long j3) {
        long j4;
        int d2 = this.f6030a.d(j2);
        if (d2 == -1) {
            j4 = Long.MIN_VALUE;
        } else {
            j4 = this.f6030a.f(d2);
        }
        u.a aVar = new u.a(obj, j3, j4);
        this.f6033d.h(aVar.f6613a, this.f6030a);
        boolean r = r(aVar);
        return new p(aVar, j2, -9223372036854775807L, j4 == Long.MIN_VALUE ? this.f6030a.h() : j4, r, s(aVar, r));
    }

    private boolean r(u.a aVar) {
        int c2 = this.f6033d.h(aVar.f6613a, this.f6030a).c();
        if (c2 == 0) {
            return true;
        }
        int i2 = c2 - 1;
        boolean a2 = aVar.a();
        if (this.f6030a.f(i2) == Long.MIN_VALUE) {
            int a3 = this.f6030a.a(i2);
            if (a3 == -1) {
                return false;
            }
            if (a2 && aVar.f6614b == i2 && aVar.f6615c == a3 + -1) {
                return true;
            }
            if (a2 || this.f6030a.i(i2) != a3) {
                return false;
            }
            return true;
        } else if (a2 || aVar.f6617e != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean s(u.a aVar, boolean z) {
        int b2 = this.f6033d.b(aVar.f6613a);
        return !this.f6033d.n(this.f6033d.f(b2, this.f6030a).f4888c, this.f6031b).f4893b && this.f6033d.s(b2, this.f6030a, this.f6031b, this.f6034e, this.f6035f) && z;
    }

    private u.a x(Object obj, long j2, long j3) {
        long j4;
        this.f6033d.h(obj, this.f6030a);
        int e2 = this.f6030a.e(j2);
        if (e2 != -1) {
            return new u.a(obj, e2, this.f6030a.i(e2), j3);
        }
        int d2 = this.f6030a.d(j2);
        if (d2 == -1) {
            j4 = Long.MIN_VALUE;
        } else {
            j4 = this.f6030a.f(d2);
        }
        return new u.a(obj, j3, j4);
    }

    private long y(Object obj) {
        int b2;
        int i2 = this.f6033d.h(obj, this.f6030a).f4888c;
        Object obj2 = this.f6040k;
        if (!(obj2 == null || (b2 = this.f6033d.b(obj2)) == -1 || this.f6033d.f(b2, this.f6030a).f4888c != i2)) {
            return this.l;
        }
        for (o h2 = h(); h2 != null; h2 = h2.f6015h) {
            if (h2.f6009b.equals(obj)) {
                return h2.f6014g.f6024a.f6616d;
            }
        }
        for (o h3 = h(); h3 != null; h3 = h3.f6015h) {
            int b3 = this.f6033d.b(h3.f6009b);
            if (b3 != -1 && this.f6033d.f(b3, this.f6030a).f4888c == i2) {
                return h3.f6014g.f6024a.f6616d;
            }
        }
        long j2 = this.f6032c;
        this.f6032c = 1 + j2;
        return j2;
    }

    public boolean A() {
        o oVar = this.f6038i;
        return oVar == null || (!oVar.f6014g.f6029f && oVar.m() && this.f6038i.f6014g.f6027d != -9223372036854775807L && this.f6039j < 100);
    }

    public boolean C(u.a aVar, long j2) {
        int b2 = this.f6033d.b(aVar.f6613a);
        o oVar = null;
        int i2 = b2;
        for (o h2 = h(); h2 != null; h2 = h2.f6015h) {
            if (oVar == null) {
                h2.f6014g = p(h2.f6014g);
            } else if (i2 == -1 || !h2.f6009b.equals(this.f6033d.m(i2))) {
                return true ^ v(oVar);
            } else {
                p g2 = g(oVar, j2);
                if (g2 == null) {
                    return true ^ v(oVar);
                }
                h2.f6014g = p(h2.f6014g);
                if (!c(h2, g2)) {
                    return true ^ v(oVar);
                }
            }
            if (h2.f6014g.f6028e) {
                i2 = this.f6033d.d(i2, this.f6030a, this.f6031b, this.f6034e, this.f6035f);
            }
            oVar = h2;
        }
        return true;
    }

    public boolean D(int i2) {
        this.f6034e = i2;
        return B();
    }

    public boolean E(boolean z) {
        this.f6035f = z;
        return B();
    }

    public o a() {
        o oVar = this.f6036g;
        if (oVar != null) {
            if (oVar == this.f6037h) {
                this.f6037h = oVar.f6015h;
            }
            oVar.o();
            int i2 = this.f6039j - 1;
            this.f6039j = i2;
            if (i2 == 0) {
                this.f6038i = null;
                o oVar2 = this.f6036g;
                this.f6040k = oVar2.f6009b;
                this.l = oVar2.f6014g.f6024a.f6616d;
            }
            this.f6036g = this.f6036g.f6015h;
        } else {
            o oVar3 = this.f6038i;
            this.f6036g = oVar3;
            this.f6037h = oVar3;
        }
        return this.f6036g;
    }

    public o b() {
        o oVar = this.f6037h;
        e.f((oVar == null || oVar.f6015h == null) ? false : true);
        o oVar2 = this.f6037h.f6015h;
        this.f6037h = oVar2;
        return oVar2;
    }

    public void d(boolean z) {
        o h2 = h();
        if (h2 != null) {
            this.f6040k = z ? h2.f6009b : null;
            this.l = h2.f6014g.f6024a.f6616d;
            h2.o();
            v(h2);
        } else if (!z) {
            this.f6040k = null;
        }
        this.f6036g = null;
        this.f6038i = null;
        this.f6037h = null;
        this.f6039j = 0;
    }

    public t e(y[] yVarArr, i iVar, d dVar, u uVar, p pVar) {
        long j2;
        o oVar = this.f6038i;
        if (oVar == null) {
            j2 = pVar.f6025b;
        } else {
            j2 = oVar.j() + this.f6038i.f6014g.f6027d;
        }
        o oVar2 = new o(yVarArr, j2, iVar, dVar, uVar, pVar);
        if (this.f6038i != null) {
            e.f(q());
            this.f6038i.f6015h = oVar2;
        }
        this.f6040k = null;
        this.f6038i = oVar2;
        this.f6039j++;
        return oVar2.f6008a;
    }

    public o h() {
        return q() ? this.f6036g : this.f6038i;
    }

    public o i() {
        return this.f6038i;
    }

    public p m(long j2, r rVar) {
        o oVar = this.f6038i;
        if (oVar == null) {
            return f(rVar);
        }
        return g(oVar, j2);
    }

    public o n() {
        return this.f6036g;
    }

    public o o() {
        return this.f6037h;
    }

    public p p(p pVar) {
        long j2;
        boolean r = r(pVar.f6024a);
        boolean s = s(pVar.f6024a, r);
        this.f6033d.h(pVar.f6024a.f6613a, this.f6030a);
        if (pVar.f6024a.a()) {
            b0.b bVar = this.f6030a;
            u.a aVar = pVar.f6024a;
            j2 = bVar.b(aVar.f6614b, aVar.f6615c);
        } else {
            j2 = pVar.f6024a.f6617e;
            if (j2 == Long.MIN_VALUE) {
                j2 = this.f6030a.h();
            }
        }
        return new p(pVar.f6024a, pVar.f6025b, pVar.f6026c, j2, r, s);
    }

    public boolean q() {
        return this.f6036g != null;
    }

    public boolean t(t tVar) {
        o oVar = this.f6038i;
        return oVar != null && oVar.f6008a == tVar;
    }

    public void u(long j2) {
        o oVar = this.f6038i;
        if (oVar != null) {
            oVar.n(j2);
        }
    }

    public boolean v(o oVar) {
        boolean z = false;
        e.f(oVar != null);
        this.f6038i = oVar;
        while (true) {
            oVar = oVar.f6015h;
            if (oVar != null) {
                if (oVar == this.f6037h) {
                    this.f6037h = this.f6036g;
                    z = true;
                }
                oVar.o();
                this.f6039j--;
            } else {
                this.f6038i.f6015h = null;
                return z;
            }
        }
    }

    public u.a w(Object obj, long j2) {
        return x(obj, j2, y(obj));
    }

    public void z(b0 b0Var) {
        this.f6033d = b0Var;
    }
}
