package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: ExtractorMediaPeriod */
final class r implements t, i, Loader.b<a>, Loader.f, x.b {
    private boolean A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f6527b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.i f6528c;

    /* renamed from: d  reason: collision with root package name */
    private final t f6529d;

    /* renamed from: e  reason: collision with root package name */
    private final v.a f6530e;

    /* renamed from: f  reason: collision with root package name */
    private final c f6531f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.d f6532g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6533h;

    /* renamed from: i  reason: collision with root package name */
    private final long f6534i;

    /* renamed from: j  reason: collision with root package name */
    private final Loader f6535j = new Loader("Loader:ExtractorMediaPeriod");

    /* renamed from: k  reason: collision with root package name */
    private final b f6536k;
    private final com.google.android.exoplayer2.util.i l;
    private final Runnable m;
    private final Runnable n;
    private final Handler o;
    private t.a p;
    private o q;
    private x[] r;
    private int[] s;
    private boolean t;
    private boolean u;
    private d v;
    private boolean w;
    private int x;
    private boolean y;
    private boolean z;

    /* access modifiers changed from: package-private */
    /* compiled from: ExtractorMediaPeriod */
    public final class a implements Loader.e {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6537a;

        /* renamed from: b  reason: collision with root package name */
        private final w f6538b;

        /* renamed from: c  reason: collision with root package name */
        private final b f6539c;

        /* renamed from: d  reason: collision with root package name */
        private final i f6540d;

        /* renamed from: e  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.i f6541e;

        /* renamed from: f  reason: collision with root package name */
        private final n f6542f;

        /* renamed from: g  reason: collision with root package name */
        private volatile boolean f6543g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f6544h = true;

        /* renamed from: i  reason: collision with root package name */
        private long f6545i;

        /* renamed from: j  reason: collision with root package name */
        private k f6546j;

        /* renamed from: k  reason: collision with root package name */
        private long f6547k = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.i iVar, b bVar, i iVar2, com.google.android.exoplayer2.util.i iVar3) {
            this.f6537a = uri;
            this.f6538b = new w(iVar);
            this.f6539c = bVar;
            this.f6540d = iVar2;
            this.f6541e = iVar3;
            n nVar = new n();
            this.f6542f = nVar;
            this.f6546j = new k(uri, nVar.f5095a, -1, r.this.f6533h);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void h(long j2, long j3) {
            this.f6542f.f5095a = j2;
            this.f6545i = j3;
            this.f6544h = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void a() {
            Throwable th;
            int i2 = 0;
            while (i2 == 0 && !this.f6543g) {
                com.google.android.exoplayer2.e0.d dVar = null;
                try {
                    long j2 = this.f6542f.f5095a;
                    k kVar = new k(this.f6537a, j2, -1, r.this.f6533h);
                    this.f6546j = kVar;
                    long b2 = this.f6538b.b(kVar);
                    this.f6547k = b2;
                    if (b2 != -1) {
                        this.f6547k = b2 + j2;
                    }
                    Uri e2 = this.f6538b.e();
                    com.google.android.exoplayer2.util.e.e(e2);
                    Uri uri = e2;
                    com.google.android.exoplayer2.e0.d dVar2 = new com.google.android.exoplayer2.e0.d(this.f6538b, j2, this.f6547k);
                    try {
                        g b3 = this.f6539c.b(dVar2, this.f6540d, uri);
                        if (this.f6544h) {
                            b3.e(j2, this.f6545i);
                            this.f6544h = false;
                        }
                        while (i2 == 0 && !this.f6543g) {
                            this.f6541e.a();
                            i2 = b3.i(dVar2, this.f6542f);
                            if (dVar2.l() > r.this.f6534i + j2) {
                                j2 = dVar2.l();
                                this.f6541e.b();
                                r.this.o.post(r.this.n);
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.f6542f.f5095a = dVar2.l();
                        }
                        d0.j(this.f6538b);
                    } catch (Throwable th2) {
                        th = th2;
                        dVar = dVar2;
                        if (!(i2 == 1 || dVar == null)) {
                            this.f6542f.f5095a = dVar.l();
                        }
                        d0.j(this.f6538b);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.f6542f.f5095a = dVar.l();
                    d0.j(this.f6538b);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() {
            this.f6543g = true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExtractorMediaPeriod */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final g[] f6548a;

        /* renamed from: b  reason: collision with root package name */
        private g f6549b;

        public b(g[] gVarArr) {
            this.f6548a = gVarArr;
        }

        public void a() {
            g gVar = this.f6549b;
            if (gVar != null) {
                gVar.a();
                this.f6549b = null;
            }
        }

        public g b(h hVar, i iVar, Uri uri) {
            g gVar = this.f6549b;
            if (gVar != null) {
                return gVar;
            }
            g[] gVarArr = this.f6548a;
            int length = gVarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                g gVar2 = gVarArr[i2];
                try {
                    if (gVar2.f(hVar)) {
                        this.f6549b = gVar2;
                        hVar.e();
                        break;
                    }
                    hVar.e();
                    i2++;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    hVar.e();
                    throw th;
                }
            }
            g gVar3 = this.f6549b;
            if (gVar3 != null) {
                gVar3.c(iVar);
                return this.f6549b;
            }
            throw new UnrecognizedInputFormatException("None of the available extractors (" + d0.y(this.f6548a) + ") could read the stream.", uri);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ExtractorMediaPeriod */
    public interface c {
        void g(long j2, boolean z);
    }

    /* access modifiers changed from: private */
    /* compiled from: ExtractorMediaPeriod */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final o f6550a;

        /* renamed from: b  reason: collision with root package name */
        public final c0 f6551b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f6552c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f6553d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f6554e;

        public d(o oVar, c0 c0Var, boolean[] zArr) {
            this.f6550a = oVar;
            this.f6551b = c0Var;
            this.f6552c = zArr;
            int i2 = c0Var.f6087b;
            this.f6553d = new boolean[i2];
            this.f6554e = new boolean[i2];
        }
    }

    /* compiled from: ExtractorMediaPeriod */
    private final class e implements y {

        /* renamed from: b  reason: collision with root package name */
        private final int f6555b;

        public e(int i2) {
            this.f6555b = i2;
        }

        @Override // com.google.android.exoplayer2.source.y
        public void a() {
            r.this.L();
        }

        @Override // com.google.android.exoplayer2.source.y
        public boolean e() {
            return r.this.E(this.f6555b);
        }

        @Override // com.google.android.exoplayer2.source.y
        public int h(m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z) {
            return r.this.P(this.f6555b, mVar, eVar, z);
        }

        @Override // com.google.android.exoplayer2.source.y
        public int n(long j2) {
            return r.this.S(this.f6555b, j2);
        }
    }

    public r(Uri uri, com.google.android.exoplayer2.upstream.i iVar, g[] gVarArr, com.google.android.exoplayer2.upstream.t tVar, v.a aVar, c cVar, com.google.android.exoplayer2.upstream.d dVar, String str, int i2) {
        this.f6527b = uri;
        this.f6528c = iVar;
        this.f6529d = tVar;
        this.f6530e = aVar;
        this.f6531f = cVar;
        this.f6532g = dVar;
        this.f6533h = str;
        this.f6534i = (long) i2;
        this.f6536k = new b(gVarArr);
        this.l = new com.google.android.exoplayer2.util.i();
        this.m = new b(this);
        this.n = new a(this);
        this.o = new Handler();
        this.s = new int[0];
        this.r = new x[0];
        this.F = -9223372036854775807L;
        this.D = -1;
        this.C = -9223372036854775807L;
        this.x = 1;
        aVar.I();
    }

    private int A() {
        int i2 = 0;
        for (x xVar : this.r) {
            i2 += xVar.t();
        }
        return i2;
    }

    private long B() {
        long j2 = Long.MIN_VALUE;
        for (x xVar : this.r) {
            j2 = Math.max(j2, xVar.q());
        }
        return j2;
    }

    private d C() {
        d dVar = this.v;
        com.google.android.exoplayer2.util.e.e(dVar);
        return dVar;
    }

    private boolean D() {
        return this.F != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H() {
        if (!this.J) {
            t.a aVar = this.p;
            com.google.android.exoplayer2.util.e.e(aVar);
            aVar.n(this);
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        o oVar = this.q;
        if (!(this.J || this.u || !this.t || oVar == null)) {
            for (x xVar : this.r) {
                if (xVar.s() == null) {
                    return;
                }
            }
            this.l.b();
            int length = this.r.length;
            b0[] b0VarArr = new b0[length];
            boolean[] zArr = new boolean[length];
            this.C = oVar.j();
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= length) {
                    break;
                }
                l s2 = this.r[i2].s();
                b0VarArr[i2] = new b0(s2);
                String str = s2.f5977h;
                if (!p.m(str) && !p.k(str)) {
                    z2 = false;
                }
                zArr[i2] = z2;
                this.w = z2 | this.w;
                i2++;
            }
            this.x = (this.D == -1 && oVar.j() == -9223372036854775807L) ? 7 : 1;
            this.v = new d(oVar, new c0(b0VarArr), zArr);
            this.u = true;
            this.f6531f.g(this.C, oVar.g());
            t.a aVar = this.p;
            com.google.android.exoplayer2.util.e.e(aVar);
            aVar.k(this);
        }
    }

    private void J(int i2) {
        d C2 = C();
        boolean[] zArr = C2.f6554e;
        if (!zArr[i2]) {
            l g2 = C2.f6551b.g(i2).g(0);
            this.f6530e.c(p.g(g2.f5977h), g2, 0, null, this.E);
            zArr[i2] = true;
        }
    }

    private void K(int i2) {
        boolean[] zArr = C().f6552c;
        if (this.G && zArr[i2] && !this.r[i2].u()) {
            this.F = 0;
            this.G = false;
            this.z = true;
            this.E = 0;
            this.H = 0;
            for (x xVar : this.r) {
                xVar.C();
            }
            t.a aVar = this.p;
            com.google.android.exoplayer2.util.e.e(aVar);
            aVar.n(this);
        }
    }

    private boolean R(boolean[] zArr, long j2) {
        int length = this.r.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                return true;
            }
            x xVar = this.r[i2];
            xVar.E();
            if (xVar.f(j2, true, false) == -1) {
                z2 = false;
            }
            if (z2 || (!zArr[i2] && this.w)) {
                i2++;
            }
        }
        return false;
    }

    private void T() {
        a aVar = new a(this.f6527b, this.f6528c, this.f6536k, this, this.l);
        if (this.u) {
            o oVar = C().f6550a;
            com.google.android.exoplayer2.util.e.f(D());
            long j2 = this.C;
            if (j2 == -9223372036854775807L || this.F < j2) {
                aVar.h(oVar.h(this.F).f5096a.f5102b, this.F);
                this.F = -9223372036854775807L;
            } else {
                this.I = true;
                this.F = -9223372036854775807L;
                return;
            }
        }
        this.H = A();
        this.f6530e.G(aVar.f6546j, 1, -1, null, 0, null, aVar.f6545i, this.C, this.f6535j.l(aVar, this, this.f6529d.b(this.x)));
    }

    private boolean U() {
        return this.z || D();
    }

    private boolean y(a aVar, int i2) {
        o oVar;
        if (this.D == -1 && ((oVar = this.q) == null || oVar.j() == -9223372036854775807L)) {
            if (!this.u || U()) {
                this.z = this.u;
                this.E = 0;
                this.H = 0;
                for (x xVar : this.r) {
                    xVar.C();
                }
                aVar.h(0, 0);
                return true;
            }
            this.G = true;
            return false;
        }
        this.H = i2;
        return true;
    }

    private void z(a aVar) {
        if (this.D == -1) {
            this.D = aVar.f6547k;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean E(int i2) {
        return !U() && (this.I || this.r[i2].u());
    }

    /* access modifiers changed from: package-private */
    public void L() {
        this.f6535j.i(this.f6529d.b(this.x));
    }

    /* renamed from: M */
    public void k(a aVar, long j2, long j3, boolean z2) {
        this.f6530e.x(aVar.f6546j, aVar.f6538b.g(), aVar.f6538b.h(), 1, -1, null, 0, null, aVar.f6545i, this.C, j2, j3, aVar.f6538b.f());
        if (!z2) {
            z(aVar);
            for (x xVar : this.r) {
                xVar.C();
            }
            if (this.B > 0) {
                t.a aVar2 = this.p;
                com.google.android.exoplayer2.util.e.e(aVar2);
                aVar2.n(this);
            }
        }
    }

    /* renamed from: N */
    public void q(a aVar, long j2, long j3) {
        if (this.C == -9223372036854775807L) {
            o oVar = this.q;
            com.google.android.exoplayer2.util.e.e(oVar);
            o oVar2 = oVar;
            long B2 = B();
            long j4 = B2 == Long.MIN_VALUE ? 0 : B2 + 10000;
            this.C = j4;
            this.f6531f.g(j4, oVar2.g());
        }
        this.f6530e.A(aVar.f6546j, aVar.f6538b.g(), aVar.f6538b.h(), 1, -1, null, 0, null, aVar.f6545i, this.C, j2, j3, aVar.f6538b.f());
        z(aVar);
        this.I = true;
        t.a aVar2 = this.p;
        com.google.android.exoplayer2.util.e.e(aVar2);
        aVar2.n(this);
    }

    /* renamed from: O */
    public Loader.c p(a aVar, long j2, long j3, IOException iOException, int i2) {
        Loader.c cVar;
        a aVar2;
        boolean z2;
        z(aVar);
        long c2 = this.f6529d.c(this.x, this.C, iOException, i2);
        if (c2 == -9223372036854775807L) {
            cVar = Loader.f6880f;
        } else {
            int A2 = A();
            if (A2 > this.H) {
                aVar2 = aVar;
                z2 = true;
            } else {
                z2 = false;
                aVar2 = aVar;
            }
            cVar = y(aVar2, A2) ? Loader.g(z2, c2) : Loader.f6879e;
        }
        this.f6530e.D(aVar.f6546j, aVar.f6538b.g(), aVar.f6538b.h(), 1, -1, null, 0, null, aVar.f6545i, this.C, j2, j3, aVar.f6538b.f(), iOException, !cVar.c());
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public int P(int i2, m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z2) {
        if (U()) {
            return -3;
        }
        J(i2);
        int y2 = this.r[i2].y(mVar, eVar, z2, this.I, this.E);
        if (y2 == -3) {
            K(i2);
        }
        return y2;
    }

    public void Q() {
        if (this.u) {
            for (x xVar : this.r) {
                xVar.k();
            }
        }
        this.f6535j.k(this);
        this.o.removeCallbacksAndMessages(null);
        this.p = null;
        this.J = true;
        this.f6530e.J();
    }

    /* access modifiers changed from: package-private */
    public int S(int i2, long j2) {
        int i3 = 0;
        if (U()) {
            return 0;
        }
        J(i2);
        x xVar = this.r[i2];
        if (!this.I || j2 <= xVar.q()) {
            int f2 = xVar.f(j2, true, true);
            if (f2 != -1) {
                i3 = f2;
            }
        } else {
            i3 = xVar.g();
        }
        if (i3 == 0) {
            K(i2);
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.e0.i
    public q a(int i2, int i3) {
        int length = this.r.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.s[i4] == i2) {
                return this.r[i4];
            }
        }
        x xVar = new x(this.f6532g);
        xVar.H(this);
        int i5 = length + 1;
        int[] copyOf = Arrays.copyOf(this.s, i5);
        this.s = copyOf;
        copyOf[length] = i2;
        x[] xVarArr = (x[]) Arrays.copyOf(this.r, i5);
        xVarArr[length] = xVar;
        d0.g(xVarArr);
        this.r = xVarArr;
        return xVar;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long b(long j2, a0 a0Var) {
        o oVar = C().f6550a;
        if (!oVar.g()) {
            return 0;
        }
        o.a h2 = oVar.h(j2);
        return d0.Y(j2, a0Var, h2.f5096a.f5101a, h2.f5097b.f5101a);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long c() {
        if (this.B == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long d() {
        long j2;
        boolean[] zArr = C().f6552c;
        if (this.I) {
            return Long.MIN_VALUE;
        }
        if (D()) {
            return this.F;
        }
        if (this.w) {
            j2 = Long.MAX_VALUE;
            int length = this.r.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i2]) {
                    j2 = Math.min(j2, this.r[i2].q());
                }
            }
        } else {
            j2 = B();
        }
        return j2 == Long.MIN_VALUE ? this.E : j2;
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void e(o oVar) {
        this.q = oVar;
        this.o.post(this.m);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        if (this.I || this.G) {
            return false;
        }
        if (this.u && this.B == 0) {
            return false;
        }
        boolean c2 = this.l.c();
        if (this.f6535j.h()) {
            return c2;
        }
        T();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public void g(long j2) {
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void h() {
        this.t = true;
        this.o.post(this.m);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void i() {
        for (x xVar : this.r) {
            xVar.C();
        }
        this.f6536k.a();
    }

    @Override // com.google.android.exoplayer2.source.t
    public long j(com.google.android.exoplayer2.g0.g[] gVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        d C2 = C();
        c0 c0Var = C2.f6551b;
        boolean[] zArr3 = C2.f6553d;
        int i2 = this.B;
        int i3 = 0;
        for (int i4 = 0; i4 < gVarArr.length; i4++) {
            if (yVarArr[i4] != null && (gVarArr[i4] == null || !zArr[i4])) {
                int i5 = ((e) yVarArr[i4]).f6555b;
                com.google.android.exoplayer2.util.e.f(zArr3[i5]);
                this.B--;
                zArr3[i5] = false;
                yVarArr[i4] = null;
            }
        }
        boolean z2 = !this.y ? j2 != 0 : i2 == 0;
        for (int i6 = 0; i6 < gVarArr.length; i6++) {
            if (yVarArr[i6] == null && gVarArr[i6] != null) {
                com.google.android.exoplayer2.g0.g gVar = gVarArr[i6];
                com.google.android.exoplayer2.util.e.f(gVar.length() == 1);
                com.google.android.exoplayer2.util.e.f(gVar.e(0) == 0);
                int k2 = c0Var.k(gVar.j());
                com.google.android.exoplayer2.util.e.f(!zArr3[k2]);
                this.B++;
                zArr3[k2] = true;
                yVarArr[i6] = new e(k2);
                zArr2[i6] = true;
                if (!z2) {
                    x xVar = this.r[k2];
                    xVar.E();
                    z2 = xVar.f(j2, true, true) == -1 && xVar.r() != 0;
                }
            }
        }
        if (this.B == 0) {
            this.G = false;
            this.z = false;
            if (this.f6535j.h()) {
                x[] xVarArr = this.r;
                int length = xVarArr.length;
                while (i3 < length) {
                    xVarArr[i3].k();
                    i3++;
                }
                this.f6535j.f();
            } else {
                x[] xVarArr2 = this.r;
                int length2 = xVarArr2.length;
                while (i3 < length2) {
                    xVarArr2[i3].C();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = t(j2);
            while (i3 < yVarArr.length) {
                if (yVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.y = true;
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long l() {
        if (!this.A) {
            this.f6530e.L();
            this.A = true;
        }
        if (!this.z) {
            return -9223372036854775807L;
        }
        if (!this.I && A() <= this.H) {
            return -9223372036854775807L;
        }
        this.z = false;
        return this.E;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void m(t.a aVar, long j2) {
        this.p = aVar;
        this.l.c();
        T();
    }

    @Override // com.google.android.exoplayer2.source.x.b
    public void n(l lVar) {
        this.o.post(this.m);
    }

    @Override // com.google.android.exoplayer2.source.t
    public c0 o() {
        return C().f6551b;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void r() {
        L();
    }

    @Override // com.google.android.exoplayer2.source.t
    public void s(long j2, boolean z2) {
        if (!D()) {
            boolean[] zArr = C().f6553d;
            int length = this.r.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.r[i2].j(j2, z2, zArr[i2]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long t(long j2) {
        d C2 = C();
        o oVar = C2.f6550a;
        boolean[] zArr = C2.f6552c;
        if (!oVar.g()) {
            j2 = 0;
        }
        this.z = false;
        this.E = j2;
        if (D()) {
            this.F = j2;
            return j2;
        } else if (this.x != 7 && R(zArr, j2)) {
            return j2;
        } else {
            this.G = false;
            this.F = j2;
            this.I = false;
            if (this.f6535j.h()) {
                this.f6535j.f();
            } else {
                for (x xVar : this.r) {
                    xVar.C();
                }
            }
            return j2;
        }
    }
}
