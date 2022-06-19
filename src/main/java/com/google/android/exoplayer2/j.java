package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.g0.i;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: ExoPlayerImplInternal */
final class j implements Handler.Callback, t.a, i.a, u.b, f.a, v.a {
    private boolean A;
    private int B;
    private boolean C;
    private int D;
    private e E;
    private long F;
    private int G;

    /* renamed from: b  reason: collision with root package name */
    private final x[] f5945b;

    /* renamed from: c  reason: collision with root package name */
    private final y[] f5946c;

    /* renamed from: d  reason: collision with root package name */
    private final i f5947d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.g0.j f5948e;

    /* renamed from: f  reason: collision with root package name */
    private final n f5949f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.e f5950g;

    /* renamed from: h  reason: collision with root package name */
    private final l f5951h;

    /* renamed from: i  reason: collision with root package name */
    private final HandlerThread f5952i;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f5953j;

    /* renamed from: k  reason: collision with root package name */
    private final g f5954k;
    private final b0.c l;
    private final b0.b m;
    private final long n;
    private final boolean o;
    private final f p;
    private final d q;
    private final ArrayList<c> r;
    private final com.google.android.exoplayer2.util.f s;
    private final q t = new q();
    private a0 u;
    private r v;
    private u w;
    private x[] x;
    private boolean y;
    private boolean z;

    /* access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final u f5955a;

        /* renamed from: b  reason: collision with root package name */
        public final b0 f5956b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f5957c;

        public b(u uVar, b0 b0Var, Object obj) {
            this.f5955a = uVar;
            this.f5956b = b0Var;
            this.f5957c = obj;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal */
    public static final class c implements Comparable<c> {

        /* renamed from: b  reason: collision with root package name */
        public final v f5958b;

        /* renamed from: c  reason: collision with root package name */
        public int f5959c;

        /* renamed from: d  reason: collision with root package name */
        public long f5960d;

        /* renamed from: e  reason: collision with root package name */
        public Object f5961e;

        public c(v vVar) {
            this.f5958b = vVar;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            Object obj = this.f5961e;
            if ((obj == null) != (cVar.f5961e == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i2 = this.f5959c - cVar.f5959c;
            if (i2 != 0) {
                return i2;
            }
            return d0.l(this.f5960d, cVar.f5960d);
        }

        public void b(int i2, long j2, Object obj) {
            this.f5959c = i2;
            this.f5960d = j2;
            this.f5961e = obj;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private r f5962a;

        /* renamed from: b  reason: collision with root package name */
        private int f5963b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5964c;

        /* renamed from: d  reason: collision with root package name */
        private int f5965d;

        private d() {
        }

        public boolean d(r rVar) {
            return rVar != this.f5962a || this.f5963b > 0 || this.f5964c;
        }

        public void e(int i2) {
            this.f5963b += i2;
        }

        public void f(r rVar) {
            this.f5962a = rVar;
            this.f5963b = 0;
            this.f5964c = false;
        }

        public void g(int i2) {
            boolean z = true;
            if (!this.f5964c || this.f5965d == 4) {
                this.f5964c = true;
                this.f5965d = i2;
                return;
            }
            if (i2 != 4) {
                z = false;
            }
            com.google.android.exoplayer2.util.e.a(z);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final b0 f5966a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5967b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5968c;

        public e(b0 b0Var, int i2, long j2) {
            this.f5966a = b0Var;
            this.f5967b = i2;
            this.f5968c = j2;
        }
    }

    public j(x[] xVarArr, i iVar, com.google.android.exoplayer2.g0.j jVar, n nVar, com.google.android.exoplayer2.upstream.e eVar, boolean z2, int i2, boolean z3, Handler handler, g gVar, com.google.android.exoplayer2.util.f fVar) {
        this.f5945b = xVarArr;
        this.f5947d = iVar;
        this.f5948e = jVar;
        this.f5949f = nVar;
        this.f5950g = eVar;
        this.z = z2;
        this.B = i2;
        this.C = z3;
        this.f5953j = handler;
        this.f5954k = gVar;
        this.s = fVar;
        this.n = nVar.i();
        this.o = nVar.c();
        this.u = a0.f4726d;
        this.v = r.g(-9223372036854775807L, jVar);
        this.q = new d();
        this.f5946c = new y[xVarArr.length];
        for (int i3 = 0; i3 < xVarArr.length; i3++) {
            xVarArr[i3].h(i3);
            this.f5946c[i3] = xVarArr[i3].u();
        }
        this.p = new f(this, fVar);
        this.r = new ArrayList<>();
        this.x = new x[0];
        this.l = new b0.c();
        this.m = new b0.b();
        iVar.b(this, eVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f5952i = handlerThread;
        handlerThread.start();
        this.f5951h = fVar.b(handlerThread.getLooper(), this);
    }

    private void B() {
        o i2 = this.t.i();
        long i3 = i2.i();
        if (i3 == Long.MIN_VALUE) {
            d0(false);
            return;
        }
        boolean d2 = this.f5949f.d(r(i3), this.p.d().f6053a);
        d0(d2);
        if (d2) {
            i2.d(this.F);
        }
    }

    private void C() {
        if (this.q.d(this.v)) {
            this.f5953j.obtainMessage(0, this.q.f5963b, this.q.f5964c ? this.q.f5965d : -1, this.v).sendToTarget();
            this.q.f(this.v);
        }
    }

    private void D() {
        o i2 = this.t.i();
        o o2 = this.t.o();
        if (!(i2 == null || i2.f6012e)) {
            if (o2 == null || o2.f6015h == i2) {
                for (x xVar : this.x) {
                    if (!xVar.i()) {
                        return;
                    }
                }
                i2.f6008a.r();
            }
        }
    }

    private void E() {
        if (this.t.i() != null) {
            for (x xVar : this.x) {
                if (!xVar.i()) {
                    return;
                }
            }
        }
        this.w.b();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x005b A[EDGE_INSN: B:56:0x005b->B:20:0x005b ?: BREAK  , SYNTHETIC] */
    private void F(long r7, long r9) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.F(long, long):void");
    }

    private void G() {
        this.t.u(this.F);
        if (this.t.A()) {
            p m2 = this.t.m(this.F, this.v);
            if (m2 == null) {
                E();
                return;
            }
            this.t.e(this.f5946c, this.f5947d, this.f5949f.g(), this.w, m2).m(this, m2.f6025b);
            d0(true);
            t(false);
        }
    }

    private void J(u uVar, boolean z2, boolean z3) {
        this.D++;
        O(true, z2, z3);
        this.f5949f.a();
        this.w = uVar;
        l0(2);
        uVar.i(this.f5954k, true, this, this.f5950g.a());
        this.f5951h.b(2);
    }

    private void L() {
        O(true, true, true);
        this.f5949f.f();
        l0(1);
        this.f5952i.quit();
        synchronized (this) {
            this.y = true;
            notifyAll();
        }
    }

    private boolean M(x xVar) {
        o oVar = this.t.o().f6015h;
        return oVar != null && oVar.f6012e && xVar.i();
    }

    private void N() {
        if (this.t.q()) {
            float f2 = this.p.d().f6053a;
            o n2 = this.t.n();
            o o2 = this.t.o();
            boolean z2 = true;
            while (n2 != null && n2.f6012e) {
                if (n2.p(f2)) {
                    if (z2) {
                        o n3 = this.t.n();
                        boolean v2 = this.t.v(n3);
                        boolean[] zArr = new boolean[this.f5945b.length];
                        long b2 = n3.b(this.v.m, v2, zArr);
                        r rVar = this.v;
                        if (!(rVar.f6046f == 4 || b2 == rVar.m)) {
                            r rVar2 = this.v;
                            this.v = rVar2.c(rVar2.f6043c, b2, rVar2.f6045e, q());
                            this.q.g(4);
                            P(b2);
                        }
                        boolean[] zArr2 = new boolean[this.f5945b.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            x[] xVarArr = this.f5945b;
                            if (i2 >= xVarArr.length) {
                                break;
                            }
                            x xVar = xVarArr[i2];
                            zArr2[i2] = xVar.getState() != 0;
                            y yVar = n3.f6010c[i2];
                            if (yVar != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (yVar != xVar.n()) {
                                    e(xVar);
                                } else if (zArr[i2]) {
                                    xVar.r(this.F);
                                }
                            }
                            i2++;
                        }
                        this.v = this.v.f(n3.f6016i, n3.f6017j);
                        j(zArr2, i3);
                    } else {
                        this.t.v(n2);
                        if (n2.f6012e) {
                            n2.a(Math.max(n2.f6014g.f6025b, n2.q(this.F)), false);
                        }
                    }
                    t(true);
                    if (this.v.f6046f != 4) {
                        B();
                        t0();
                        this.f5951h.b(2);
                        return;
                    }
                    return;
                }
                if (n2 == o2) {
                    z2 = false;
                }
                n2 = n2.f6015h;
            }
        }
    }

    private void O(boolean z2, boolean z3, boolean z4) {
        u uVar;
        this.f5951h.e(2);
        this.A = false;
        this.p.i();
        this.F = 0;
        for (x xVar : this.x) {
            try {
                e(xVar);
            } catch (ExoPlaybackException | RuntimeException e2) {
                m.d("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.x = new x[0];
        this.t.d(!z3);
        d0(false);
        if (z3) {
            this.E = null;
        }
        if (z4) {
            this.t.z(b0.f4885a);
            Iterator<c> it = this.r.iterator();
            while (it.hasNext()) {
                it.next().f5958b.k(false);
            }
            this.r.clear();
            this.G = 0;
        }
        u.a h2 = z3 ? this.v.h(this.C, this.l) : this.v.f6043c;
        long j2 = -9223372036854775807L;
        long j3 = z3 ? -9223372036854775807L : this.v.m;
        if (!z3) {
            j2 = this.v.f6045e;
        }
        b0 b0Var = z4 ? b0.f4885a : this.v.f6041a;
        Object obj = z4 ? null : this.v.f6042b;
        r rVar = this.v;
        this.v = new r(b0Var, obj, h2, j3, j2, rVar.f6046f, false, z4 ? c0.f6086e : rVar.f6048h, z4 ? this.f5948e : rVar.f6049i, h2, j3, 0, j3);
        if (z2 && (uVar = this.w) != null) {
            uVar.h(this);
            this.w = null;
        }
    }

    private void P(long j2) {
        if (this.t.q()) {
            j2 = this.t.n().r(j2);
        }
        this.F = j2;
        this.p.g(j2);
        for (x xVar : this.x) {
            xVar.r(this.F);
        }
    }

    private boolean Q(c cVar) {
        Object obj = cVar.f5961e;
        if (obj == null) {
            Pair<Object, Long> S = S(new e(cVar.f5958b.g(), cVar.f5958b.i(), d.a(cVar.f5958b.e())), false);
            if (S == null) {
                return false;
            }
            cVar.b(this.v.f6041a.b(S.first), ((Long) S.second).longValue(), S.first);
            return true;
        }
        int b2 = this.v.f6041a.b(obj);
        if (b2 == -1) {
            return false;
        }
        cVar.f5959c = b2;
        return true;
    }

    private void R() {
        for (int size = this.r.size() - 1; size >= 0; size--) {
            if (!Q(this.r.get(size))) {
                this.r.get(size).f5958b.k(false);
                this.r.remove(size);
            }
        }
        Collections.sort(this.r);
    }

    private Pair<Object, Long> S(e eVar, boolean z2) {
        int b2;
        b0 b0Var = this.v.f6041a;
        b0 b0Var2 = eVar.f5966a;
        if (b0Var.r()) {
            return null;
        }
        if (b0Var2.r()) {
            b0Var2 = b0Var;
        }
        try {
            Pair<Object, Long> j2 = b0Var2.j(this.l, this.m, eVar.f5967b, eVar.f5968c);
            if (b0Var == b0Var2 || (b2 = b0Var.b(j2.first)) != -1) {
                return j2;
            }
            if (!z2 || T(j2.first, b0Var2, b0Var) == null) {
                return null;
            }
            return o(b0Var, b0Var.f(b2, this.m).f4888c, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalSeekPositionException(b0Var, eVar.f5967b, eVar.f5968c);
        }
    }

    private Object T(Object obj, b0 b0Var, b0 b0Var2) {
        int b2 = b0Var.b(obj);
        int i2 = b0Var.i();
        int i3 = b2;
        int i4 = -1;
        for (int i5 = 0; i5 < i2 && i4 == -1; i5++) {
            i3 = b0Var.d(i3, this.m, this.l, this.B, this.C);
            if (i3 == -1) {
                break;
            }
            i4 = b0Var2.b(b0Var.m(i3));
        }
        if (i4 == -1) {
            return null;
        }
        return b0Var2.m(i4);
    }

    private void U(long j2, long j3) {
        this.f5951h.e(2);
        this.f5951h.d(2, j2 + j3);
    }

    private void W(boolean z2) {
        u.a aVar = this.t.n().f6014g.f6024a;
        long Z = Z(aVar, this.v.m, true);
        if (Z != this.v.m) {
            r rVar = this.v;
            this.v = rVar.c(aVar, Z, rVar.f6045e, q());
            if (z2) {
                this.q.g(4);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void X(com.google.android.exoplayer2.j.e r23) {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.X(com.google.android.exoplayer2.j$e):void");
    }

    private long Y(u.a aVar, long j2) {
        return Z(aVar, j2, this.t.n() != this.t.o());
    }

    private long Z(u.a aVar, long j2, boolean z2) {
        q0();
        this.A = false;
        l0(2);
        o n2 = this.t.n();
        o oVar = n2;
        while (true) {
            if (oVar == null) {
                break;
            }
            if (aVar.equals(oVar.f6014g.f6024a) && oVar.f6012e) {
                this.t.v(oVar);
                break;
            }
            oVar = this.t.a();
        }
        if (n2 != oVar || z2) {
            for (x xVar : this.x) {
                e(xVar);
            }
            this.x = new x[0];
            n2 = null;
        }
        if (oVar != null) {
            u0(n2);
            if (oVar.f6013f) {
                long t2 = oVar.f6008a.t(j2);
                oVar.f6008a.s(t2 - this.n, this.o);
                j2 = t2;
            }
            P(j2);
            B();
        } else {
            this.t.d(true);
            this.v = this.v.f(c0.f6086e, this.f5948e);
            P(j2);
        }
        t(false);
        this.f5951h.b(2);
        return j2;
    }

    private void a0(v vVar) {
        if (vVar.e() == -9223372036854775807L) {
            b0(vVar);
        } else if (this.w == null || this.D > 0) {
            this.r.add(new c(vVar));
        } else {
            c cVar = new c(vVar);
            if (Q(cVar)) {
                this.r.add(cVar);
                Collections.sort(this.r);
                return;
            }
            vVar.k(false);
        }
    }

    private void b0(v vVar) {
        if (vVar.c().getLooper() == this.f5951h.g()) {
            d(vVar);
            int i2 = this.v.f6046f;
            if (i2 == 3 || i2 == 2) {
                this.f5951h.b(2);
                return;
            }
            return;
        }
        this.f5951h.f(15, vVar).sendToTarget();
    }

    private void c0(v vVar) {
        vVar.c().post(new a(this, vVar));
    }

    private void d(v vVar) {
        if (!vVar.j()) {
            try {
                vVar.f().m(vVar.h(), vVar.d());
            } finally {
                vVar.k(true);
            }
        }
    }

    private void d0(boolean z2) {
        r rVar = this.v;
        if (rVar.f6047g != z2) {
            this.v = rVar.a(z2);
        }
    }

    private void e(x xVar) {
        this.p.c(xVar);
        l(xVar);
        xVar.c();
    }

    private void f0(boolean z2) {
        this.A = false;
        this.z = z2;
        if (!z2) {
            q0();
            t0();
            return;
        }
        int i2 = this.v.f6046f;
        if (i2 == 3) {
            n0();
            this.f5951h.b(2);
        } else if (i2 == 2) {
            this.f5951h.b(2);
        }
    }

    private void g() {
        int i2;
        long a2 = this.s.a();
        s0();
        if (!this.t.q()) {
            D();
            U(a2, 10);
            return;
        }
        o n2 = this.t.n();
        com.google.android.exoplayer2.util.b0.a("doSomeWork");
        t0();
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        n2.f6008a.s(this.v.m - this.n, this.o);
        x[] xVarArr = this.x;
        boolean z2 = true;
        boolean z3 = true;
        for (x xVar : xVarArr) {
            xVar.l(this.F, elapsedRealtime);
            z3 = z3 && xVar.b();
            boolean z4 = xVar.e() || xVar.b() || M(xVar);
            if (!z4) {
                xVar.q();
            }
            z2 = z2 && z4;
        }
        if (!z2) {
            D();
        }
        long j2 = n2.f6014g.f6027d;
        if (z3 && ((j2 == -9223372036854775807L || j2 <= this.v.m) && n2.f6014g.f6029f)) {
            l0(4);
            q0();
        } else if (this.v.f6046f == 2 && m0(z2)) {
            l0(3);
            if (this.z) {
                n0();
            }
        } else if (this.v.f6046f == 3 && (this.x.length != 0 ? !z2 : !y())) {
            this.A = this.z;
            l0(2);
            q0();
        }
        if (this.v.f6046f == 2) {
            for (x xVar2 : this.x) {
                xVar2.q();
            }
        }
        if ((this.z && this.v.f6046f == 3) || (i2 = this.v.f6046f) == 2) {
            U(a2, 10);
        } else if (this.x.length == 0 || i2 == 4) {
            this.f5951h.e(2);
        } else {
            U(a2, 1000);
        }
        com.google.android.exoplayer2.util.b0.c();
    }

    private void g0(s sVar) {
        this.p.f(sVar);
    }

    private void h(int i2, boolean z2, int i3) {
        o n2 = this.t.n();
        x xVar = this.f5945b[i2];
        this.x[i3] = xVar;
        if (xVar.getState() == 0) {
            com.google.android.exoplayer2.g0.j jVar = n2.f6017j;
            z zVar = jVar.f5853b[i2];
            l[] m2 = m(jVar.f5854c.a(i2));
            boolean z3 = this.z && this.v.f6046f == 3;
            xVar.j(zVar, m2, n2.f6010c[i2], this.F, !z2 && z3, n2.j());
            this.p.e(xVar);
            if (z3) {
                xVar.start();
            }
        }
    }

    private void i0(int i2) {
        this.B = i2;
        if (!this.t.D(i2)) {
            W(true);
        }
        t(false);
    }

    private void j(boolean[] zArr, int i2) {
        this.x = new x[i2];
        o n2 = this.t.n();
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5945b.length; i4++) {
            if (n2.f6017j.c(i4)) {
                h(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private void j0(a0 a0Var) {
        this.u = a0Var;
    }

    private void k0(boolean z2) {
        this.C = z2;
        if (!this.t.E(z2)) {
            W(true);
        }
        t(false);
    }

    private void l(x xVar) {
        if (xVar.getState() == 2) {
            xVar.stop();
        }
    }

    private void l0(int i2) {
        r rVar = this.v;
        if (rVar.f6046f != i2) {
            this.v = rVar.d(i2);
        }
    }

    private static l[] m(g gVar) {
        int length = gVar != null ? gVar.length() : 0;
        l[] lVarArr = new l[length];
        for (int i2 = 0; i2 < length; i2++) {
            lVarArr[i2] = gVar.b(i2);
        }
        return lVarArr;
    }

    private boolean m0(boolean z2) {
        if (this.x.length == 0) {
            return y();
        }
        if (!z2) {
            return false;
        }
        if (!this.v.f6047g) {
            return true;
        }
        o i2 = this.t.i();
        if ((i2.m() && i2.f6014g.f6029f) || this.f5949f.b(q(), this.p.d().f6053a, this.A)) {
            return true;
        }
        return false;
    }

    private void n0() {
        this.A = false;
        this.p.h();
        for (x xVar : this.x) {
            xVar.start();
        }
    }

    private Pair<Object, Long> o(b0 b0Var, int i2, long j2) {
        return b0Var.j(this.l, this.m, i2, j2);
    }

    private void p0(boolean z2, boolean z3) {
        O(true, z2, z2);
        this.q.e(this.D + (z3 ? 1 : 0));
        this.D = 0;
        this.f5949f.h();
        l0(1);
    }

    private long q() {
        return r(this.v.f6051k);
    }

    private void q0() {
        this.p.i();
        for (x xVar : this.x) {
            l(xVar);
        }
    }

    private long r(long j2) {
        o i2 = this.t.i();
        if (i2 == null) {
            return 0;
        }
        return j2 - i2.q(this.F);
    }

    private void r0(c0 c0Var, com.google.android.exoplayer2.g0.j jVar) {
        this.f5949f.e(this.f5945b, c0Var, jVar.f5854c);
    }

    private void s(t tVar) {
        if (this.t.t(tVar)) {
            this.t.u(this.F);
            B();
        }
    }

    private void s0() {
        u uVar = this.w;
        if (uVar != null) {
            if (this.D > 0) {
                uVar.b();
                return;
            }
            G();
            o i2 = this.t.i();
            int i3 = 0;
            if (i2 == null || i2.m()) {
                d0(false);
            } else if (!this.v.f6047g) {
                B();
            }
            if (this.t.q()) {
                o n2 = this.t.n();
                o o2 = this.t.o();
                boolean z2 = false;
                while (this.z && n2 != o2 && this.F >= n2.f6015h.k()) {
                    if (z2) {
                        C();
                    }
                    int i4 = n2.f6014g.f6028e ? 0 : 3;
                    o a2 = this.t.a();
                    u0(n2);
                    r rVar = this.v;
                    p pVar = a2.f6014g;
                    this.v = rVar.c(pVar.f6024a, pVar.f6025b, pVar.f6026c, q());
                    this.q.g(i4);
                    t0();
                    n2 = a2;
                    z2 = true;
                }
                if (o2.f6014g.f6029f) {
                    while (true) {
                        x[] xVarArr = this.f5945b;
                        if (i3 < xVarArr.length) {
                            x xVar = xVarArr[i3];
                            y yVar = o2.f6010c[i3];
                            if (yVar != null && xVar.n() == yVar && xVar.i()) {
                                xVar.p();
                            }
                            i3++;
                        } else {
                            return;
                        }
                    }
                } else if (o2.f6015h != null) {
                    int i5 = 0;
                    while (true) {
                        x[] xVarArr2 = this.f5945b;
                        if (i5 < xVarArr2.length) {
                            x xVar2 = xVarArr2[i5];
                            y yVar2 = o2.f6010c[i5];
                            if (xVar2.n() != yVar2) {
                                return;
                            }
                            if (yVar2 == null || xVar2.i()) {
                                i5++;
                            } else {
                                return;
                            }
                        } else if (!o2.f6015h.f6012e) {
                            D();
                            return;
                        } else {
                            com.google.android.exoplayer2.g0.j jVar = o2.f6017j;
                            o b2 = this.t.b();
                            com.google.android.exoplayer2.g0.j jVar2 = b2.f6017j;
                            boolean z3 = b2.f6008a.l() != -9223372036854775807L;
                            int i6 = 0;
                            while (true) {
                                x[] xVarArr3 = this.f5945b;
                                if (i6 < xVarArr3.length) {
                                    x xVar3 = xVarArr3[i6];
                                    if (jVar.c(i6)) {
                                        if (z3) {
                                            xVar3.p();
                                        } else if (!xVar3.s()) {
                                            g a3 = jVar2.f5854c.a(i6);
                                            boolean c2 = jVar2.c(i6);
                                            boolean z4 = this.f5946c[i6].g() == 6;
                                            z zVar = jVar.f5853b[i6];
                                            z zVar2 = jVar2.f5853b[i6];
                                            if (!c2 || !zVar2.equals(zVar) || z4) {
                                                xVar3.p();
                                            } else {
                                                xVar3.w(m(a3), b2.f6010c[i6], b2.j());
                                            }
                                        }
                                    }
                                    i6++;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void t(boolean z2) {
        long j2;
        o i2 = this.t.i();
        u.a aVar = i2 == null ? this.v.f6043c : i2.f6014g.f6024a;
        boolean z3 = !this.v.f6050j.equals(aVar);
        if (z3) {
            this.v = this.v.b(aVar);
        }
        r rVar = this.v;
        if (i2 == null) {
            j2 = rVar.m;
        } else {
            j2 = i2.h();
        }
        rVar.f6051k = j2;
        this.v.l = q();
        if ((z3 || z2) && i2 != null && i2.f6012e) {
            r0(i2.f6016i, i2.f6017j);
        }
    }

    private void t0() {
        if (this.t.q()) {
            o n2 = this.t.n();
            long l2 = n2.f6008a.l();
            if (l2 != -9223372036854775807L) {
                P(l2);
                if (l2 != this.v.m) {
                    r rVar = this.v;
                    this.v = rVar.c(rVar.f6043c, l2, rVar.f6045e, q());
                    this.q.g(4);
                }
            } else {
                long j2 = this.p.j();
                this.F = j2;
                long q2 = n2.q(j2);
                F(this.v.m, q2);
                this.v.m = q2;
            }
            o i2 = this.t.i();
            this.v.f6051k = i2.h();
            this.v.l = q();
        }
    }

    private void u(t tVar) {
        if (this.t.t(tVar)) {
            o i2 = this.t.i();
            i2.l(this.p.d().f6053a);
            r0(i2.f6016i, i2.f6017j);
            if (!this.t.q()) {
                P(this.t.a().f6014g.f6025b);
                u0(null);
            }
            B();
        }
    }

    private void u0(o oVar) {
        o n2 = this.t.n();
        if (n2 != null && oVar != n2) {
            boolean[] zArr = new boolean[this.f5945b.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                x[] xVarArr = this.f5945b;
                if (i2 < xVarArr.length) {
                    x xVar = xVarArr[i2];
                    zArr[i2] = xVar.getState() != 0;
                    if (n2.f6017j.c(i2)) {
                        i3++;
                    }
                    if (zArr[i2] && (!n2.f6017j.c(i2) || (xVar.s() && xVar.n() == oVar.f6010c[i2]))) {
                        e(xVar);
                    }
                    i2++;
                } else {
                    this.v = this.v.f(n2.f6016i, n2.f6017j);
                    j(zArr, i3);
                    return;
                }
            }
        }
    }

    private void v(s sVar) {
        this.f5953j.obtainMessage(1, sVar).sendToTarget();
        v0(sVar.f6053a);
        x[] xVarArr = this.f5945b;
        for (x xVar : xVarArr) {
            if (xVar != null) {
                xVar.o(sVar.f6053a);
            }
        }
    }

    private void v0(float f2) {
        for (o h2 = this.t.h(); h2 != null; h2 = h2.f6015h) {
            com.google.android.exoplayer2.g0.j jVar = h2.f6017j;
            if (jVar != null) {
                g[] b2 = jVar.f5854c.b();
                for (g gVar : b2) {
                    if (gVar != null) {
                        gVar.n(f2);
                    }
                }
            }
        }
    }

    private void w() {
        l0(4);
        O(false, true, false);
    }

    private void x(b bVar) {
        if (bVar.f5955a == this.w) {
            b0 b0Var = this.v.f6041a;
            b0 b0Var2 = bVar.f5956b;
            Object obj = bVar.f5957c;
            this.t.z(b0Var2);
            this.v = this.v.e(b0Var2, obj);
            R();
            int i2 = this.D;
            long j2 = 0;
            if (i2 > 0) {
                this.q.e(i2);
                this.D = 0;
                e eVar = this.E;
                if (eVar != null) {
                    try {
                        Pair<Object, Long> S = S(eVar, true);
                        this.E = null;
                        if (S == null) {
                            w();
                            return;
                        }
                        Object obj2 = S.first;
                        long longValue = ((Long) S.second).longValue();
                        u.a w2 = this.t.w(obj2, longValue);
                        this.v = this.v.i(w2, w2.a() ? 0 : longValue, longValue);
                    } catch (IllegalSeekPositionException e2) {
                        this.v = this.v.i(this.v.h(this.C, this.l), -9223372036854775807L, -9223372036854775807L);
                        throw e2;
                    }
                } else if (this.v.f6044d != -9223372036854775807L) {
                } else {
                    if (b0Var2.r()) {
                        w();
                        return;
                    }
                    Pair<Object, Long> o2 = o(b0Var2, b0Var2.a(this.C), -9223372036854775807L);
                    Object obj3 = o2.first;
                    long longValue2 = ((Long) o2.second).longValue();
                    u.a w3 = this.t.w(obj3, longValue2);
                    this.v = this.v.i(w3, w3.a() ? 0 : longValue2, longValue2);
                }
            } else if (!b0Var.r()) {
                o h2 = this.t.h();
                r rVar = this.v;
                long j3 = rVar.f6045e;
                Object obj4 = h2 == null ? rVar.f6043c.f6613a : h2.f6009b;
                if (b0Var2.b(obj4) == -1) {
                    Object T = T(obj4, b0Var, b0Var2);
                    if (T == null) {
                        w();
                        return;
                    }
                    Pair<Object, Long> o3 = o(b0Var2, b0Var2.h(T, this.m).f4888c, -9223372036854775807L);
                    Object obj5 = o3.first;
                    long longValue3 = ((Long) o3.second).longValue();
                    u.a w4 = this.t.w(obj5, longValue3);
                    if (h2 != null) {
                        while (true) {
                            h2 = h2.f6015h;
                            if (h2 == null) {
                                break;
                            } else if (h2.f6014g.f6024a.equals(w4)) {
                                h2.f6014g = this.t.p(h2.f6014g);
                            }
                        }
                    }
                    if (!w4.a()) {
                        j2 = longValue3;
                    }
                    this.v = this.v.c(w4, Y(w4, j2), longValue3, q());
                    return;
                }
                u.a aVar = this.v.f6043c;
                if (aVar.a()) {
                    u.a w5 = this.t.w(obj4, j3);
                    if (!w5.equals(aVar)) {
                        if (!w5.a()) {
                            j2 = j3;
                        }
                        this.v = this.v.c(w5, Y(w5, j2), j3, q());
                        return;
                    }
                }
                if (!this.t.C(aVar, this.F)) {
                    W(false);
                }
                t(false);
            } else if (!b0Var2.r()) {
                Pair<Object, Long> o4 = o(b0Var2, b0Var2.a(this.C), -9223372036854775807L);
                Object obj6 = o4.first;
                long longValue4 = ((Long) o4.second).longValue();
                u.a w6 = this.t.w(obj6, longValue4);
                this.v = this.v.i(w6, w6.a() ? 0 : longValue4, longValue4);
            }
        }
    }

    private boolean y() {
        o oVar;
        o n2 = this.t.n();
        long j2 = n2.f6014g.f6027d;
        return j2 == -9223372036854775807L || this.v.m < j2 || ((oVar = n2.f6015h) != null && (oVar.f6012e || oVar.f6014g.f6024a.a()));
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(v vVar) {
        try {
            d(vVar);
        } catch (ExoPlaybackException e2) {
            m.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: H */
    public void n(t tVar) {
        this.f5951h.f(10, tVar).sendToTarget();
    }

    public void I(u uVar, boolean z2, boolean z3) {
        this.f5951h.c(0, z2 ? 1 : 0, z3 ? 1 : 0, uVar).sendToTarget();
    }

    public synchronized void K() {
        if (!this.y) {
            this.f5951h.b(7);
            boolean z2 = false;
            while (!this.y) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void V(b0 b0Var, int i2, long j2) {
        this.f5951h.f(3, new e(b0Var, i2, j2)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.v.a
    public synchronized void b(v vVar) {
        if (this.y) {
            m.f("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            vVar.k(false);
            return;
        }
        this.f5951h.f(14, vVar).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.u.b
    public void c(u uVar, b0 b0Var, Object obj) {
        this.f5951h.f(8, new b(uVar, b0Var, obj)).sendToTarget();
    }

    public void e0(boolean z2) {
        this.f5951h.a(1, z2 ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.f.a
    public void f(s sVar) {
        this.f5951h.f(16, sVar).sendToTarget();
    }

    public void h0(int i2) {
        this.f5951h.a(12, i2, 0).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    J((u) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    f0(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    X((e) message.obj);
                    break;
                case 4:
                    g0((s) message.obj);
                    break;
                case 5:
                    j0((a0) message.obj);
                    break;
                case 6:
                    p0(message.arg1 != 0, true);
                    break;
                case 7:
                    L();
                    return true;
                case 8:
                    x((b) message.obj);
                    break;
                case 9:
                    u((t) message.obj);
                    break;
                case 10:
                    s((t) message.obj);
                    break;
                case 11:
                    N();
                    break;
                case 12:
                    i0(message.arg1);
                    break;
                case 13:
                    k0(message.arg1 != 0);
                    break;
                case 14:
                    a0((v) message.obj);
                    break;
                case 15:
                    c0((v) message.obj);
                    break;
                case 16:
                    v((s) message.obj);
                    break;
                default:
                    return false;
            }
            C();
        } catch (ExoPlaybackException e2) {
            m.d("ExoPlayerImplInternal", "Playback error.", e2);
            p0(false, false);
            this.f5953j.obtainMessage(2, e2).sendToTarget();
            C();
        } catch (IOException e3) {
            m.d("ExoPlayerImplInternal", "Source error.", e3);
            p0(false, false);
            this.f5953j.obtainMessage(2, ExoPlaybackException.c(e3)).sendToTarget();
            C();
        } catch (RuntimeException e4) {
            m.d("ExoPlayerImplInternal", "Internal runtime error.", e4);
            p0(false, false);
            this.f5953j.obtainMessage(2, ExoPlaybackException.d(e4)).sendToTarget();
            C();
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.t.a
    public void k(t tVar) {
        this.f5951h.f(9, tVar).sendToTarget();
    }

    public void o0(boolean z2) {
        this.f5951h.a(6, z2 ? 1 : 0, 0).sendToTarget();
    }

    public Looper p() {
        return this.f5952i.getLooper();
    }
}
