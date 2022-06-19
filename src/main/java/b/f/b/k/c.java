package b.f.b.k;

import b.f.b.k.e;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: ChainHead */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected e f2294a;

    /* renamed from: b  reason: collision with root package name */
    protected e f2295b;

    /* renamed from: c  reason: collision with root package name */
    protected e f2296c;

    /* renamed from: d  reason: collision with root package name */
    protected e f2297d;

    /* renamed from: e  reason: collision with root package name */
    protected e f2298e;

    /* renamed from: f  reason: collision with root package name */
    protected e f2299f;

    /* renamed from: g  reason: collision with root package name */
    protected e f2300g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<e> f2301h;

    /* renamed from: i  reason: collision with root package name */
    protected int f2302i;

    /* renamed from: j  reason: collision with root package name */
    protected int f2303j;

    /* renamed from: k  reason: collision with root package name */
    protected float f2304k = Utils.FLOAT_EPSILON;
    int l;
    int m;
    int n;
    private int o;
    private boolean p = false;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private boolean t;

    public c(e eVar, int i2, boolean z) {
        this.f2294a = eVar;
        this.o = i2;
        this.p = z;
    }

    private void b() {
        int i2 = this.o * 2;
        e eVar = this.f2294a;
        boolean z = false;
        e eVar2 = eVar;
        boolean z2 = false;
        while (!z2) {
            this.f2302i++;
            e[] eVarArr = eVar.l0;
            int i3 = this.o;
            e eVar3 = null;
            eVarArr[i3] = null;
            eVar.k0[i3] = null;
            if (eVar.Q() != 8) {
                this.l++;
                e.b s2 = eVar.s(this.o);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (s2 != bVar) {
                    this.m += eVar.C(this.o);
                }
                int e2 = this.m + eVar.N[i2].e();
                this.m = e2;
                int i4 = i2 + 1;
                this.m = e2 + eVar.N[i4].e();
                int e3 = this.n + eVar.N[i2].e();
                this.n = e3;
                this.n = e3 + eVar.N[i4].e();
                if (this.f2295b == null) {
                    this.f2295b = eVar;
                }
                this.f2297d = eVar;
                e.b[] bVarArr = eVar.Q;
                int i5 = this.o;
                if (bVarArr[i5] == bVar) {
                    int[] iArr = eVar.p;
                    if (iArr[i5] == 0 || iArr[i5] == 3 || iArr[i5] == 2) {
                        this.f2303j++;
                        float[] fArr = eVar.j0;
                        float f2 = fArr[i5];
                        if (f2 > Utils.FLOAT_EPSILON) {
                            this.f2304k += fArr[i5];
                        }
                        if (c(eVar, i5)) {
                            if (f2 < Utils.FLOAT_EPSILON) {
                                this.q = true;
                            } else {
                                this.r = true;
                            }
                            if (this.f2301h == null) {
                                this.f2301h = new ArrayList<>();
                            }
                            this.f2301h.add(eVar);
                        }
                        if (this.f2299f == null) {
                            this.f2299f = eVar;
                        }
                        e eVar4 = this.f2300g;
                        if (eVar4 != null) {
                            eVar4.k0[this.o] = eVar;
                        }
                        this.f2300g = eVar;
                    }
                    if (this.o == 0) {
                        if (eVar.n == 0 && eVar.q == 0) {
                            int i6 = eVar.r;
                        }
                    } else if (eVar.o == 0 && eVar.t == 0) {
                        int i7 = eVar.u;
                    }
                    int i8 = (eVar.U > Utils.FLOAT_EPSILON ? 1 : (eVar.U == Utils.FLOAT_EPSILON ? 0 : -1));
                }
            }
            if (eVar2 != eVar) {
                eVar2.l0[this.o] = eVar;
            }
            d dVar = eVar.N[i2 + 1].f2310f;
            if (dVar != null) {
                e eVar5 = dVar.f2308d;
                d[] dVarArr = eVar5.N;
                if (dVarArr[i2].f2310f != null && dVarArr[i2].f2310f.f2308d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z2 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f2295b;
        if (eVar6 != null) {
            this.m -= eVar6.N[i2].e();
        }
        e eVar7 = this.f2297d;
        if (eVar7 != null) {
            this.m -= eVar7.N[i2 + 1].e();
        }
        this.f2296c = eVar;
        if (this.o != 0 || !this.p) {
            this.f2298e = this.f2294a;
        } else {
            this.f2298e = eVar;
        }
        if (this.r && this.q) {
            z = true;
        }
        this.s = z;
    }

    private static boolean c(e eVar, int i2) {
        if (eVar.Q() != 8 && eVar.Q[i2] == e.b.MATCH_CONSTRAINT) {
            int[] iArr = eVar.p;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.t) {
            b();
        }
        this.t = true;
    }
}
