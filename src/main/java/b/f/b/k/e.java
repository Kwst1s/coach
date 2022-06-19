package b.f.b.k;

import b.f.b.k.d;
import b.f.b.k.m.c;
import b.f.b.k.m.f;
import b.f.b.k.m.l;
import b.f.b.k.m.n;
import b.f.b.k.m.p;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintWidget */
public class e {
    public static float o0 = 0.5f;
    private boolean A = false;
    private boolean B;
    private boolean C = false;
    private int D = 0;
    private int E = 0;
    public d F;
    public d G;
    public d H;
    public d I;
    public d J;
    d K;
    d L;
    public d M;
    public d[] N;
    protected ArrayList<d> O;
    private boolean[] P;
    public b[] Q;
    public e R;
    int S;
    int T;
    public float U;
    protected int V;
    protected int W;
    protected int X;
    int Y;
    protected int Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2325a = false;
    protected int a0;

    /* renamed from: b  reason: collision with root package name */
    public c f2326b;
    float b0;

    /* renamed from: c  reason: collision with root package name */
    public c f2327c;
    float c0;

    /* renamed from: d  reason: collision with root package name */
    public l f2328d = null;
    private Object d0;

    /* renamed from: e  reason: collision with root package name */
    public n f2329e = null;
    private int e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f2330f = {true, true};
    private String f0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2331g = true;
    private String g0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2332h = false;
    int h0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2333i = true;
    int i0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2334j = false;
    public float[] j0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2335k = false;
    protected e[] k0;
    public int l = -1;
    protected e[] l0;
    public int m = -1;
    public int m0;
    public int n = 0;
    public int n0;
    public int o = 0;
    public int[] p = new int[2];
    public int q = 0;
    public int r = 0;
    public float s = 1.0f;
    public int t = 0;
    public int u = 0;
    public float v = 1.0f;
    int w = -1;
    float x = 1.0f;
    private int[] y = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float z = Utils.FLOAT_EPSILON;

    /* access modifiers changed from: package-private */
    /* compiled from: ConstraintWidget */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2336a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2337b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
            // Method dump skipped, instructions count: 156
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.e.a.<clinit>():void");
        }
    }

    /* compiled from: ConstraintWidget */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.LEFT);
        this.F = dVar;
        d dVar2 = new d(this, d.b.TOP);
        this.G = dVar2;
        d dVar3 = new d(this, d.b.RIGHT);
        this.H = dVar3;
        d dVar4 = new d(this, d.b.BOTTOM);
        this.I = dVar4;
        d dVar5 = new d(this, d.b.BASELINE);
        this.J = dVar5;
        this.K = new d(this, d.b.CENTER_X);
        this.L = new d(this, d.b.CENTER_Y);
        d dVar6 = new d(this, d.b.CENTER);
        this.M = dVar6;
        this.N = new d[]{dVar, dVar3, dVar2, dVar4, dVar5, dVar6};
        this.O = new ArrayList<>();
        this.P = new boolean[2];
        b bVar = b.FIXED;
        this.Q = new b[]{bVar, bVar};
        this.R = null;
        this.S = 0;
        this.T = 0;
        this.U = Utils.FLOAT_EPSILON;
        this.V = -1;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f2 = o0;
        this.b0 = f2;
        this.c0 = f2;
        this.e0 = 0;
        this.f0 = null;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = new float[]{-1.0f, -1.0f};
        this.k0 = new e[]{null, null};
        this.l0 = new e[]{null, null};
        this.m0 = -1;
        this.n0 = -1;
        d();
    }

    private boolean Y(int i2) {
        int i3 = i2 * 2;
        d[] dVarArr = this.N;
        if (!(dVarArr[i3].f2310f == null || dVarArr[i3].f2310f.f2310f == dVarArr[i3])) {
            int i4 = i3 + 1;
            return dVarArr[i4].f2310f != null && dVarArr[i4].f2310f.f2310f == dVarArr[i4];
        }
    }

    private void d() {
        this.O.add(this.F);
        this.O.add(this.G);
        this.O.add(this.H);
        this.O.add(this.I);
        this.O.add(this.K);
        this.O.add(this.L);
        this.O.add(this.M);
        this.O.add(this.J);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x043c  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04c2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x04fd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:341:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(b.f.b.d r31, boolean r32, boolean r33, boolean r34, boolean r35, b.f.b.i r36, b.f.b.i r37, b.f.b.k.e.b r38, boolean r39, b.f.b.k.d r40, b.f.b.k.d r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
        // Method dump skipped, instructions count: 1341
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.e.i(b.f.b.d, boolean, boolean, boolean, boolean, b.f.b.i, b.f.b.i, b.f.b.k.e$b, boolean, b.f.b.k.d, b.f.b.k.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public int A() {
        return this.D;
    }

    public void A0(int i2, int i3, int i4, float f2) {
        this.n = i2;
        this.q = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.r = i4;
        this.s = f2;
        if (f2 > Utils.FLOAT_EPSILON && f2 < 1.0f && i2 == 0) {
            this.n = 2;
        }
    }

    public int B() {
        return this.E;
    }

    public void B0(float f2) {
        this.j0[0] = f2;
    }

    public int C(int i2) {
        if (i2 == 0) {
            return R();
        }
        if (i2 == 1) {
            return v();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void C0(int i2, boolean z2) {
        this.P[i2] = z2;
    }

    public int D() {
        return this.y[1];
    }

    public void D0(boolean z2) {
        this.B = z2;
    }

    public int E() {
        return this.y[0];
    }

    public void E0(boolean z2) {
        this.C = z2;
    }

    public int F() {
        return this.a0;
    }

    public void F0(int i2, int i3) {
        this.D = i2;
        this.E = i3;
        I0(false);
    }

    public int G() {
        return this.Z;
    }

    public void G0(int i2) {
        this.y[1] = i2;
    }

    public e H(int i2) {
        d dVar;
        d dVar2;
        if (i2 == 0) {
            d dVar3 = this.H;
            d dVar4 = dVar3.f2310f;
            if (dVar4 == null || dVar4.f2310f != dVar3) {
                return null;
            }
            return dVar4.f2308d;
        } else if (i2 == 1 && (dVar2 = (dVar = this.I).f2310f) != null && dVar2.f2310f == dVar) {
            return dVar2.f2308d;
        } else {
            return null;
        }
    }

    public void H0(int i2) {
        this.y[0] = i2;
    }

    public e I() {
        return this.R;
    }

    public void I0(boolean z2) {
        this.f2331g = z2;
    }

    public e J(int i2) {
        d dVar;
        d dVar2;
        if (i2 == 0) {
            d dVar3 = this.F;
            d dVar4 = dVar3.f2310f;
            if (dVar4 == null || dVar4.f2310f != dVar3) {
                return null;
            }
            return dVar4.f2308d;
        } else if (i2 == 1 && (dVar2 = (dVar = this.G).f2310f) != null && dVar2.f2310f == dVar) {
            return dVar2.f2308d;
        } else {
            return null;
        }
    }

    public void J0(int i2) {
        if (i2 < 0) {
            this.a0 = 0;
        } else {
            this.a0 = i2;
        }
    }

    public int K() {
        return S() + this.S;
    }

    public void K0(int i2) {
        if (i2 < 0) {
            this.Z = 0;
        } else {
            this.Z = i2;
        }
    }

    public p L(int i2) {
        if (i2 == 0) {
            return this.f2328d;
        }
        if (i2 == 1) {
            return this.f2329e;
        }
        return null;
    }

    public void L0(int i2, int i3) {
        this.W = i2;
        this.X = i3;
    }

    public float M() {
        return this.c0;
    }

    public void M0(e eVar) {
        this.R = eVar;
    }

    public int N() {
        return this.i0;
    }

    public void N0(float f2) {
        this.c0 = f2;
    }

    public b O() {
        return this.Q[1];
    }

    public void O0(int i2) {
        this.i0 = i2;
    }

    public int P() {
        int i2 = 0;
        if (this.F != null) {
            i2 = 0 + this.G.f2311g;
        }
        return this.H != null ? i2 + this.I.f2311g : i2;
    }

    public void P0(int i2, int i3) {
        this.X = i2;
        int i4 = i3 - i2;
        this.T = i4;
        int i5 = this.a0;
        if (i4 < i5) {
            this.T = i5;
        }
    }

    public int Q() {
        return this.e0;
    }

    public void Q0(b bVar) {
        this.Q[1] = bVar;
    }

    public int R() {
        if (this.e0 == 8) {
            return 0;
        }
        return this.S;
    }

    public void R0(int i2, int i3, int i4, float f2) {
        this.o = i2;
        this.t = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.u = i4;
        this.v = f2;
        if (f2 > Utils.FLOAT_EPSILON && f2 < 1.0f && i2 == 0) {
            this.o = 2;
        }
    }

    public int S() {
        e eVar = this.R;
        if (eVar == null || !(eVar instanceof f)) {
            return this.W;
        }
        return ((f) eVar).w0 + this.W;
    }

    public void S0(float f2) {
        this.j0[1] = f2;
    }

    public int T() {
        e eVar = this.R;
        if (eVar == null || !(eVar instanceof f)) {
            return this.X;
        }
        return ((f) eVar).x0 + this.X;
    }

    public void T0(int i2) {
        this.e0 = i2;
    }

    public boolean U() {
        return this.A;
    }

    public void U0(int i2) {
        this.S = i2;
        int i3 = this.Z;
        if (i2 < i3) {
            this.S = i3;
        }
    }

    public boolean V(int i2) {
        if (i2 == 0) {
            return (this.F.f2310f != null ? 1 : 0) + (this.H.f2310f != null ? 1 : 0) < 2;
        }
        if ((this.G.f2310f != null ? 1 : 0) + (this.I.f2310f != null ? 1 : 0) + (this.J.f2310f != null ? 1 : 0) < 2) {
            return true;
        }
        return false;
    }

    public void V0(int i2) {
        this.W = i2;
    }

    public boolean W() {
        int size = this.O.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.O.get(i2).l()) {
                return true;
            }
        }
        return false;
    }

    public void W0(int i2) {
        this.X = i2;
    }

    public void X(d.b bVar, e eVar, d.b bVar2, int i2, int i3) {
        m(bVar).a(eVar.m(bVar2), i2, i3, true);
    }

    public void X0(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.w == -1) {
            if (z4 && !z5) {
                this.w = 0;
            } else if (!z4 && z5) {
                this.w = 1;
                if (this.V == -1) {
                    this.x = 1.0f / this.x;
                }
            }
        }
        if (this.w == 0 && (!this.G.n() || !this.I.n())) {
            this.w = 1;
        } else if (this.w == 1 && (!this.F.n() || !this.H.n())) {
            this.w = 0;
        }
        if (this.w == -1 && (!this.G.n() || !this.I.n() || !this.F.n() || !this.H.n())) {
            if (this.G.n() && this.I.n()) {
                this.w = 0;
            } else if (this.F.n() && this.H.n()) {
                this.x = 1.0f / this.x;
                this.w = 1;
            }
        }
        if (this.w == -1) {
            int i2 = this.q;
            if (i2 > 0 && this.t == 0) {
                this.w = 0;
            } else if (i2 == 0 && this.t > 0) {
                this.x = 1.0f / this.x;
                this.w = 1;
            }
        }
    }

    public void Y0(boolean z2, boolean z3) {
        int i2;
        int i3;
        boolean k2 = z2 & this.f2328d.k();
        boolean k3 = z3 & this.f2329e.k();
        l lVar = this.f2328d;
        int i4 = lVar.f2410h.f2374g;
        n nVar = this.f2329e;
        int i5 = nVar.f2410h.f2374g;
        int i6 = lVar.f2411i.f2374g;
        int i7 = nVar.f2411i.f2374g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (k2) {
            this.W = i4;
        }
        if (k3) {
            this.X = i5;
        }
        if (this.e0 == 8) {
            this.S = 0;
            this.T = 0;
            return;
        }
        if (k2) {
            if (this.Q[0] == b.FIXED && i9 < (i3 = this.S)) {
                i9 = i3;
            }
            this.S = i9;
            int i11 = this.Z;
            if (i9 < i11) {
                this.S = i11;
            }
        }
        if (k3) {
            if (this.Q[1] == b.FIXED && i10 < (i2 = this.T)) {
                i10 = i2;
            }
            this.T = i10;
            int i12 = this.a0;
            if (i10 < i12) {
                this.T = i12;
            }
        }
    }

    public boolean Z() {
        d dVar = this.F;
        d dVar2 = dVar.f2310f;
        if (dVar2 != null && dVar2.f2310f == dVar) {
            return true;
        }
        d dVar3 = this.H;
        d dVar4 = dVar3.f2310f;
        return dVar4 != null && dVar4.f2310f == dVar3;
    }

    public void Z0(b.f.b.d dVar, boolean z2) {
        n nVar;
        l lVar;
        int x2 = dVar.x(this.F);
        int x3 = dVar.x(this.G);
        int x4 = dVar.x(this.H);
        int x5 = dVar.x(this.I);
        if (z2 && (lVar = this.f2328d) != null) {
            f fVar = lVar.f2410h;
            if (fVar.f2377j) {
                f fVar2 = lVar.f2411i;
                if (fVar2.f2377j) {
                    x2 = fVar.f2374g;
                    x4 = fVar2.f2374g;
                }
            }
        }
        if (z2 && (nVar = this.f2329e) != null) {
            f fVar3 = nVar.f2410h;
            if (fVar3.f2377j) {
                f fVar4 = nVar.f2411i;
                if (fVar4.f2377j) {
                    x3 = fVar3.f2374g;
                    x5 = fVar4.f2374g;
                }
            }
        }
        int i2 = x5 - x3;
        if (x4 - x2 < 0 || i2 < 0 || x2 == Integer.MIN_VALUE || x2 == Integer.MAX_VALUE || x3 == Integer.MIN_VALUE || x3 == Integer.MAX_VALUE || x4 == Integer.MIN_VALUE || x4 == Integer.MAX_VALUE || x5 == Integer.MIN_VALUE || x5 == Integer.MAX_VALUE) {
            x5 = 0;
            x2 = 0;
            x3 = 0;
            x4 = 0;
        }
        t0(x2, x3, x4, x5);
    }

    public boolean a0() {
        return this.B;
    }

    public boolean b0() {
        d dVar = this.G;
        d dVar2 = dVar.f2310f;
        if (dVar2 != null && dVar2.f2310f == dVar) {
            return true;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f2310f;
        return dVar4 != null && dVar4.f2310f == dVar3;
    }

    public boolean c0() {
        return this.C;
    }

    public boolean d0() {
        return this.f2331g && this.e0 != 8;
    }

    public void e(f fVar, b.f.b.d dVar, HashSet<e> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                j.a(fVar, dVar, this);
                hashSet.remove(this);
                g(dVar, fVar.B1(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<d> c2 = this.F.c();
            if (c2 != null) {
                Iterator<d> it = c2.iterator();
                while (it.hasNext()) {
                    it.next().f2308d.e(fVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<d> c3 = this.H.c();
            if (c3 != null) {
                Iterator<d> it2 = c3.iterator();
                while (it2.hasNext()) {
                    it2.next().f2308d.e(fVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<d> c4 = this.G.c();
        if (c4 != null) {
            Iterator<d> it3 = c4.iterator();
            while (it3.hasNext()) {
                it3.next().f2308d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> c5 = this.I.c();
        if (c5 != null) {
            Iterator<d> it4 = c5.iterator();
            while (it4.hasNext()) {
                it4.next().f2308d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> c6 = this.J.c();
        if (c6 != null) {
            Iterator<d> it5 = c6.iterator();
            while (it5.hasNext()) {
                it5.next().f2308d.e(fVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean e0() {
        return this.f2334j || (this.F.m() && this.H.m());
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof k) || (this instanceof g);
    }

    public boolean f0() {
        return this.f2335k || (this.G.m() && this.I.m());
    }

    /* JADX WARNING: Removed duplicated region for block: B:182:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x055d  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x05d1  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x05db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(b.f.b.d r53, boolean r54) {
        /*
        // Method dump skipped, instructions count: 1537
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.e.g(b.f.b.d, boolean):void");
    }

    public boolean g0() {
        b[] bVarArr = this.Q;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public boolean h() {
        return this.e0 != 8;
    }

    public void h0() {
        this.F.p();
        this.G.p();
        this.H.p();
        this.I.p();
        this.J.p();
        this.K.p();
        this.L.p();
        this.M.p();
        this.R = null;
        this.z = Utils.FLOAT_EPSILON;
        this.S = 0;
        this.T = 0;
        this.U = Utils.FLOAT_EPSILON;
        this.V = -1;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        float f2 = o0;
        this.b0 = f2;
        this.c0 = f2;
        b[] bVarArr = this.Q;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.d0 = null;
        this.e0 = 0;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        float[] fArr = this.j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.l = -1;
        this.m = -1;
        int[] iArr = this.y;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.n = 0;
        this.o = 0;
        this.s = 1.0f;
        this.v = 1.0f;
        this.r = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.q = 0;
        this.t = 0;
        this.w = -1;
        this.x = 1.0f;
        boolean[] zArr = this.f2330f;
        zArr[0] = true;
        zArr[1] = true;
        this.C = false;
        boolean[] zArr2 = this.P;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f2331g = true;
    }

    public void i0() {
        this.f2334j = false;
        this.f2335k = false;
        int size = this.O.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.O.get(i2).q();
        }
    }

    public void j(e eVar, float f2, int i2) {
        d.b bVar = d.b.CENTER;
        X(bVar, eVar, bVar, i2, 0);
        this.z = f2;
    }

    public void j0(b.f.b.c cVar) {
        this.F.r(cVar);
        this.G.r(cVar);
        this.H.r(cVar);
        this.I.r(cVar);
        this.J.r(cVar);
        this.M.r(cVar);
        this.K.r(cVar);
        this.L.r(cVar);
    }

    public void k(b.f.b.d dVar) {
        dVar.q(this.F);
        dVar.q(this.G);
        dVar.q(this.H);
        dVar.q(this.I);
        if (this.Y > 0) {
            dVar.q(this.J);
        }
    }

    public void k0(int i2) {
        this.Y = i2;
        this.A = i2 > 0;
    }

    public void l() {
        if (this.f2328d == null) {
            this.f2328d = new l(this);
        }
        if (this.f2329e == null) {
            this.f2329e = new n(this);
        }
    }

    public void l0(Object obj) {
        this.d0 = obj;
    }

    public d m(d.b bVar) {
        switch (a.f2336a[bVar.ordinal()]) {
            case 1:
                return this.F;
            case 2:
                return this.G;
            case 3:
                return this.H;
            case 4:
                return this.I;
            case 5:
                return this.J;
            case 6:
                return this.M;
            case 7:
                return this.K;
            case 8:
                return this.L;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void m0(String str) {
        this.f0 = str;
    }

    public int n() {
        return this.Y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n0(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.e.n0(java.lang.String):void");
    }

    public float o(int i2) {
        if (i2 == 0) {
            return this.b0;
        }
        if (i2 == 1) {
            return this.c0;
        }
        return -1.0f;
    }

    public void o0(int i2) {
        if (this.A) {
            int i3 = i2 - this.Y;
            int i4 = this.T + i3;
            this.X = i3;
            this.G.s(i3);
            this.I.s(i4);
            this.J.s(i2);
            this.f2335k = true;
        }
    }

    public int p() {
        return T() + this.T;
    }

    public void p0(int i2, int i3) {
        this.F.s(i2);
        this.H.s(i3);
        this.W = i2;
        this.S = i3 - i2;
        this.f2334j = true;
    }

    public Object q() {
        return this.d0;
    }

    public void q0(int i2) {
        this.F.s(i2);
        this.W = i2;
    }

    public String r() {
        return this.f0;
    }

    public void r0(int i2) {
        this.G.s(i2);
        this.X = i2;
    }

    public b s(int i2) {
        if (i2 == 0) {
            return y();
        }
        if (i2 == 1) {
            return O();
        }
        return null;
    }

    public void s0(int i2, int i3) {
        this.G.s(i2);
        this.I.s(i3);
        this.X = i2;
        this.T = i3 - i2;
        if (this.A) {
            this.J.s(i2 + this.Y);
        }
        this.f2335k = true;
    }

    public float t() {
        return this.U;
    }

    public void t0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.W = i2;
        this.X = i3;
        if (this.e0 == 8) {
            this.S = 0;
            this.T = 0;
            return;
        }
        b[] bVarArr = this.Q;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i8 < (i7 = this.S)) {
            i8 = i7;
        }
        if (bVarArr[1] == bVar2 && i9 < (i6 = this.T)) {
            i9 = i6;
        }
        this.S = i8;
        this.T = i9;
        int i10 = this.a0;
        if (i9 < i10) {
            this.T = i10;
        }
        int i11 = this.Z;
        if (i8 < i11) {
            this.S = i11;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.g0;
        String str3 = BuildConfig.FLAVOR;
        if (str2 != null) {
            str = "type: " + this.g0 + " ";
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.f0 != null) {
            str3 = "id: " + this.f0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.W);
        sb.append(", ");
        sb.append(this.X);
        sb.append(") - (");
        sb.append(this.S);
        sb.append(" x ");
        sb.append(this.T);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.V;
    }

    public void u0(boolean z2) {
        this.A = z2;
    }

    public int v() {
        if (this.e0 == 8) {
            return 0;
        }
        return this.T;
    }

    public void v0(int i2) {
        this.T = i2;
        int i3 = this.a0;
        if (i2 < i3) {
            this.T = i3;
        }
    }

    public float w() {
        return this.b0;
    }

    public void w0(float f2) {
        this.b0 = f2;
    }

    public int x() {
        return this.h0;
    }

    public void x0(int i2) {
        this.h0 = i2;
    }

    public b y() {
        return this.Q[0];
    }

    public void y0(int i2, int i3) {
        this.W = i2;
        int i4 = i3 - i2;
        this.S = i4;
        int i5 = this.Z;
        if (i4 < i5) {
            this.S = i5;
        }
    }

    public int z() {
        d dVar = this.F;
        int i2 = 0;
        if (dVar != null) {
            i2 = 0 + dVar.f2311g;
        }
        d dVar2 = this.H;
        return dVar2 != null ? i2 + dVar2.f2311g : i2;
    }

    public void z0(b bVar) {
        this.Q[0] = bVar;
    }
}
