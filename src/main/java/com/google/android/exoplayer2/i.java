package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.g0.j;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.f;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.v;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* access modifiers changed from: package-private */
/* compiled from: ExoPlayerImpl */
public final class i extends b implements g {

    /* renamed from: b  reason: collision with root package name */
    final j f5923b;

    /* renamed from: c  reason: collision with root package name */
    private final x[] f5924c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.g0.i f5925d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f5926e;

    /* renamed from: f  reason: collision with root package name */
    private final j f5927f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f5928g;

    /* renamed from: h  reason: collision with root package name */
    private final CopyOnWriteArraySet<t.b> f5929h;

    /* renamed from: i  reason: collision with root package name */
    private final b0.b f5930i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<b> f5931j;

    /* renamed from: k  reason: collision with root package name */
    private u f5932k;
    private boolean l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private s s;
    private r t;
    private int u;
    private int v;
    private long w;

    /* compiled from: ExoPlayerImpl */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            i.this.C(message);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExoPlayerImpl */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final r f5934a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<t.b> f5935b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.g0.i f5936c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f5937d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5938e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5939f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f5940g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f5941h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f5942i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f5943j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f5944k;
        private final boolean l;

        public b(r rVar, r rVar2, Set<t.b> set, com.google.android.exoplayer2.g0.i iVar, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
            this.f5934a = rVar;
            this.f5935b = set;
            this.f5936c = iVar;
            this.f5937d = z;
            this.f5938e = i2;
            this.f5939f = i3;
            this.f5940g = z2;
            this.f5941h = z3;
            boolean z5 = false;
            this.f5942i = z4 || rVar2.f6046f != rVar.f6046f;
            this.f5943j = (rVar2.f6041a == rVar.f6041a && rVar2.f6042b == rVar.f6042b) ? false : true;
            this.f5944k = rVar2.f6047g != rVar.f6047g;
            this.l = rVar2.f6049i != rVar.f6049i ? true : z5;
        }

        public void a() {
            if (this.f5943j || this.f5939f == 0) {
                for (t.b bVar : this.f5935b) {
                    r rVar = this.f5934a;
                    bVar.p(rVar.f6041a, rVar.f6042b, this.f5939f);
                }
            }
            if (this.f5937d) {
                for (t.b bVar2 : this.f5935b) {
                    bVar2.j(this.f5938e);
                }
            }
            if (this.l) {
                this.f5936c.c(this.f5934a.f6049i.f5855d);
                for (t.b bVar3 : this.f5935b) {
                    r rVar2 = this.f5934a;
                    bVar3.D(rVar2.f6048h, rVar2.f6049i.f5854c);
                }
            }
            if (this.f5944k) {
                for (t.b bVar4 : this.f5935b) {
                    bVar4.i(this.f5934a.f6047g);
                }
            }
            if (this.f5942i) {
                for (t.b bVar5 : this.f5935b) {
                    bVar5.h(this.f5941h, this.f5934a.f6046f);
                }
            }
            if (this.f5940g) {
                for (t.b bVar6 : this.f5935b) {
                    bVar6.s();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public i(x[] xVarArr, com.google.android.exoplayer2.g0.i iVar, n nVar, e eVar, f fVar, Looper looper) {
        m.e("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.9.1" + "] [" + d0.f7010e + "]");
        com.google.android.exoplayer2.util.e.f(xVarArr.length > 0);
        com.google.android.exoplayer2.util.e.e(xVarArr);
        this.f5924c = xVarArr;
        com.google.android.exoplayer2.util.e.e(iVar);
        this.f5925d = iVar;
        this.l = false;
        this.n = 0;
        this.o = false;
        this.f5929h = new CopyOnWriteArraySet<>();
        j jVar = new j(new z[xVarArr.length], new g[xVarArr.length], null);
        this.f5923b = jVar;
        this.f5930i = new b0.b();
        this.s = s.f6052e;
        a0 a0Var = a0.f4726d;
        a aVar = new a(looper);
        this.f5926e = aVar;
        this.t = r.g(0, jVar);
        this.f5931j = new ArrayDeque<>();
        j jVar2 = new j(xVarArr, iVar, jVar, nVar, eVar, this.l, this.n, this.o, aVar, this, fVar);
        this.f5927f = jVar2;
        this.f5928g = new Handler(jVar2.p());
    }

    private r B(boolean z, boolean z2, int i2) {
        long j2;
        long j3 = 0;
        if (z) {
            this.u = 0;
            this.v = 0;
            this.w = 0;
        } else {
            this.u = w();
            this.v = A();
            this.w = getCurrentPosition();
        }
        u.a h2 = z ? this.t.h(this.o, this.f4884a) : this.t.f6043c;
        if (!z) {
            j3 = this.t.m;
        }
        if (z) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.t.f6045e;
        }
        return new r(z2 ? b0.f4885a : this.t.f6041a, z2 ? null : this.t.f6042b, h2, j3, j2, i2, false, z2 ? c0.f6086e : this.t.f6048h, z2 ? this.f5923b : this.t.f6049i, h2, j3, 0, j3);
    }

    private void D(r rVar, int i2, boolean z, int i3) {
        int i4 = this.p - i2;
        this.p = i4;
        if (i4 == 0) {
            if (rVar.f6044d == -9223372036854775807L) {
                rVar = rVar.i(rVar.f6043c, 0, rVar.f6045e);
            }
            if ((!this.t.f6041a.r() || this.q) && rVar.f6041a.r()) {
                this.v = 0;
                this.u = 0;
                this.w = 0;
            }
            int i5 = this.q ? 0 : 2;
            boolean z2 = this.r;
            this.q = false;
            this.r = false;
            J(rVar, z, i3, i5, z2, false);
        }
    }

    private long F(u.a aVar, long j2) {
        long b2 = d.b(j2);
        this.t.f6041a.h(aVar.f6613a, this.f5930i);
        return b2 + this.f5930i.k();
    }

    private boolean I() {
        return this.t.f6041a.r() || this.p > 0;
    }

    private void J(r rVar, boolean z, int i2, int i3, boolean z2, boolean z3) {
        boolean z4 = !this.f5931j.isEmpty();
        this.f5931j.addLast(new b(rVar, this.t, this.f5929h, this.f5925d, z, i2, i3, z2, this.l, z3));
        this.t = rVar;
        if (!z4) {
            while (!this.f5931j.isEmpty()) {
                this.f5931j.peekFirst().a();
                this.f5931j.removeFirst();
            }
        }
    }

    public int A() {
        if (I()) {
            return this.v;
        }
        r rVar = this.t;
        return rVar.f6041a.b(rVar.f6043c.f6613a);
    }

    /* access modifiers changed from: package-private */
    public void C(Message message) {
        int i2 = message.what;
        boolean z = true;
        if (i2 == 0) {
            r rVar = (r) message.obj;
            int i3 = message.arg1;
            int i4 = message.arg2;
            if (i4 == -1) {
                z = false;
            }
            D(rVar, i3, z, i4);
        } else if (i2 == 1) {
            s sVar = (s) message.obj;
            if (!this.s.equals(sVar)) {
                this.s = sVar;
                Iterator<t.b> it = this.f5929h.iterator();
                while (it.hasNext()) {
                    it.next().f(sVar);
                }
            }
        } else if (i2 == 2) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
            Iterator<t.b> it2 = this.f5929h.iterator();
            while (it2.hasNext()) {
                it2.next().q(exoPlaybackException);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean E() {
        return !I() && this.t.f6043c.a();
    }

    public void G(u uVar, boolean z, boolean z2) {
        this.f5932k = uVar;
        r B = B(z, z2, 2);
        this.q = true;
        this.p++;
        this.f5927f.I(uVar, z, z2);
        J(B, false, 4, 1, false, false);
    }

    public void H(boolean z, boolean z2) {
        boolean z3 = z && !z2;
        if (this.m != z3) {
            this.m = z3;
            this.f5927f.e0(z3);
        }
        if (this.l != z) {
            this.l = z;
            J(this.t, false, 4, 1, false, true);
        }
    }

    @Override // com.google.android.exoplayer2.t
    public void a() {
        m.e("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.9.1" + "] [" + d0.f7010e + "] [" + k.b() + "]");
        this.f5927f.K();
        this.f5926e.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.g
    public void b(u uVar) {
        G(uVar, true, true);
    }

    @Override // com.google.android.exoplayer2.g
    public v c(v.b bVar) {
        return new v(this.f5927f, bVar, this.t.f6041a, w(), this.f5928g);
    }

    @Override // com.google.android.exoplayer2.t
    public s d() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.t
    public void f(boolean z) {
        H(z, false);
    }

    @Override // com.google.android.exoplayer2.t
    public long g() {
        if (!E()) {
            return getCurrentPosition();
        }
        r rVar = this.t;
        rVar.f6041a.h(rVar.f6043c.f6613a, this.f5930i);
        return this.f5930i.k() + d.b(this.t.f6045e);
    }

    @Override // com.google.android.exoplayer2.t
    public long getCurrentPosition() {
        if (I()) {
            return this.w;
        }
        if (this.t.f6043c.a()) {
            return d.b(this.t.m);
        }
        r rVar = this.t;
        return F(rVar.f6043c, rVar.m);
    }

    @Override // com.google.android.exoplayer2.t
    public long getDuration() {
        if (!E()) {
            return x();
        }
        r rVar = this.t;
        u.a aVar = rVar.f6043c;
        rVar.f6041a.h(aVar.f6613a, this.f5930i);
        return d.b(this.f5930i.b(aVar.f6614b, aVar.f6615c));
    }

    @Override // com.google.android.exoplayer2.t
    public long h() {
        return Math.max(0L, d.b(this.t.l));
    }

    @Override // com.google.android.exoplayer2.t
    public void i(int i2, long j2) {
        b0 b0Var = this.t.f6041a;
        if (i2 < 0 || (!b0Var.r() && i2 >= b0Var.q())) {
            throw new IllegalSeekPositionException(b0Var, i2, j2);
        }
        this.r = true;
        this.p++;
        if (E()) {
            m.f("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.f5926e.obtainMessage(0, 1, -1, this.t).sendToTarget();
            return;
        }
        this.u = i2;
        if (b0Var.r()) {
            this.w = j2 == -9223372036854775807L ? 0 : j2;
            this.v = 0;
        } else {
            long b2 = j2 == -9223372036854775807L ? b0Var.n(i2, this.f4884a).b() : d.a(j2);
            Pair<Object, Long> j3 = b0Var.j(this.f4884a, this.f5930i, i2, b2);
            this.w = d.b(b2);
            this.v = b0Var.b(j3.first);
        }
        this.f5927f.V(b0Var, i2, d.a(j2));
        Iterator<t.b> it = this.f5929h.iterator();
        while (it.hasNext()) {
            it.next().j(1);
        }
    }

    @Override // com.google.android.exoplayer2.t
    public long k() {
        if (!E()) {
            return z();
        }
        r rVar = this.t;
        if (rVar.f6050j.equals(rVar.f6043c)) {
            return d.b(this.t.f6051k);
        }
        return getDuration();
    }

    @Override // com.google.android.exoplayer2.t
    public boolean l() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.t
    public void m(boolean z) {
        r B = B(z, z, 1);
        this.p++;
        this.f5927f.o0(z);
        J(B, false, 4, 1, false, false);
    }

    @Override // com.google.android.exoplayer2.t
    public int n() {
        return this.t.f6046f;
    }

    @Override // com.google.android.exoplayer2.t
    public int p() {
        if (E()) {
            return this.t.f6043c.f6614b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.t
    public void r(t.b bVar) {
        this.f5929h.add(bVar);
    }

    @Override // com.google.android.exoplayer2.t
    public int s() {
        if (E()) {
            return this.t.f6043c.f6615c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.t
    public void setRepeatMode(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.f5927f.h0(i2);
            Iterator<t.b> it = this.f5929h.iterator();
            while (it.hasNext()) {
                it.next().c(i2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.t
    public int t() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.t
    public b0 u() {
        return this.t.f6041a;
    }

    @Override // com.google.android.exoplayer2.t
    public boolean v() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.t
    public int w() {
        if (I()) {
            return this.u;
        }
        r rVar = this.t;
        return rVar.f6041a.h(rVar.f6043c.f6613a, this.f5930i).f4888c;
    }

    public long z() {
        if (I()) {
            return this.w;
        }
        r rVar = this.t;
        if (rVar.f6050j.f6616d != rVar.f6043c.f6616d) {
            return rVar.f6041a.n(w(), this.f4884a).c();
        }
        long j2 = rVar.f6051k;
        if (this.t.f6050j.a()) {
            r rVar2 = this.t;
            b0.b h2 = rVar2.f6041a.h(rVar2.f6050j.f6613a, this.f5930i);
            long f2 = h2.f(this.t.f6050j.f6614b);
            j2 = f2 == Long.MIN_VALUE ? h2.f4889d : f2;
        }
        return F(this.t.f6050j, j2);
    }
}
