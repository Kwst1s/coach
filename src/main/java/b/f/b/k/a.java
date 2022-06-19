package b.f.b.k;

import b.f.b.i;
import b.f.b.k.d;
import b.f.b.k.e;

/* compiled from: Barrier */
public class a extends i {
    private int r0 = 0;
    private boolean s0 = true;
    private int t0 = 0;
    boolean u0 = false;

    public boolean c1() {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        boolean z = true;
        while (true) {
            i2 = this.q0;
            if (i5 >= i2) {
                break;
            }
            e eVar = this.p0[i5];
            if ((this.s0 || eVar.h()) && ((((i3 = this.r0) == 0 || i3 == 1) && !eVar.e0()) || (((i4 = this.r0) == 2 || i4 == 3) && !eVar.f0()))) {
                z = false;
            }
            i5++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int i6 = 0;
        boolean z2 = false;
        for (int i7 = 0; i7 < this.q0; i7++) {
            e eVar2 = this.p0[i7];
            if (this.s0 || eVar2.h()) {
                if (!z2) {
                    int i8 = this.r0;
                    if (i8 == 0) {
                        i6 = eVar2.m(d.b.LEFT).d();
                    } else if (i8 == 1) {
                        i6 = eVar2.m(d.b.RIGHT).d();
                    } else if (i8 == 2) {
                        i6 = eVar2.m(d.b.TOP).d();
                    } else if (i8 == 3) {
                        i6 = eVar2.m(d.b.BOTTOM).d();
                    }
                    z2 = true;
                }
                int i9 = this.r0;
                if (i9 == 0) {
                    i6 = Math.min(i6, eVar2.m(d.b.LEFT).d());
                } else if (i9 == 1) {
                    i6 = Math.max(i6, eVar2.m(d.b.RIGHT).d());
                } else if (i9 == 2) {
                    i6 = Math.min(i6, eVar2.m(d.b.TOP).d());
                } else if (i9 == 3) {
                    i6 = Math.max(i6, eVar2.m(d.b.BOTTOM).d());
                }
            }
        }
        int i10 = i6 + this.t0;
        int i11 = this.r0;
        if (i11 == 0 || i11 == 1) {
            p0(i10, i10);
        } else {
            s0(i10, i10);
        }
        this.u0 = true;
        return true;
    }

    public boolean d1() {
        return this.s0;
    }

    @Override // b.f.b.k.e
    public boolean e0() {
        return this.u0;
    }

    public int e1() {
        return this.r0;
    }

    @Override // b.f.b.k.e
    public boolean f0() {
        return this.u0;
    }

    public int f1() {
        return this.t0;
    }

    @Override // b.f.b.k.e
    public void g(b.f.b.d dVar, boolean z) {
        Object[] objArr;
        boolean z2;
        int i2;
        int i3;
        int i4;
        d[] dVarArr = this.N;
        dVarArr[0] = this.F;
        dVarArr[2] = this.G;
        dVarArr[1] = this.H;
        dVarArr[3] = this.I;
        int i5 = 0;
        while (true) {
            objArr = this.N;
            if (i5 >= objArr.length) {
                break;
            }
            objArr[i5].f2313i = dVar.q(objArr[i5]);
            i5++;
        }
        int i6 = this.r0;
        if (i6 >= 0 && i6 < 4) {
            d dVar2 = objArr[i6];
            if (!this.u0) {
                c1();
            }
            if (this.u0) {
                this.u0 = false;
                int i7 = this.r0;
                if (i7 == 0 || i7 == 1) {
                    dVar.f(this.F.f2313i, this.W);
                    dVar.f(this.H.f2313i, this.W);
                } else if (i7 == 2 || i7 == 3) {
                    dVar.f(this.G.f2313i, this.X);
                    dVar.f(this.I.f2313i, this.X);
                }
            } else {
                int i8 = 0;
                while (true) {
                    if (i8 >= this.q0) {
                        z2 = false;
                        break;
                    }
                    e eVar = this.p0[i8];
                    if ((this.s0 || eVar.h()) && ((((i3 = this.r0) == 0 || i3 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.F.f2310f != null && eVar.H.f2310f != null) || (((i4 = this.r0) == 2 || i4 == 3) && eVar.O() == e.b.MATCH_CONSTRAINT && eVar.G.f2310f != null && eVar.I.f2310f != null))) {
                        z2 = true;
                    } else {
                        i8++;
                    }
                }
                z2 = true;
                boolean z3 = this.F.k() || this.H.k();
                boolean z4 = this.G.k() || this.I.k();
                boolean z5 = !z2 && (((i2 = this.r0) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4))));
                int i9 = 5;
                if (!z5) {
                    i9 = 4;
                }
                for (int i10 = 0; i10 < this.q0; i10++) {
                    e eVar2 = this.p0[i10];
                    if (this.s0 || eVar2.h()) {
                        i q = dVar.q(eVar2.N[this.r0]);
                        d[] dVarArr2 = eVar2.N;
                        int i11 = this.r0;
                        dVarArr2[i11].f2313i = q;
                        int i12 = (dVarArr2[i11].f2310f == null || dVarArr2[i11].f2310f.f2308d != this) ? 0 : dVarArr2[i11].f2311g + 0;
                        if (i11 == 0 || i11 == 2) {
                            dVar.i(dVar2.f2313i, q, this.t0 - i12, z2);
                        } else {
                            dVar.g(dVar2.f2313i, q, this.t0 + i12, z2);
                        }
                        dVar.e(dVar2.f2313i, q, this.t0 + i12, i9);
                    }
                }
                int i13 = this.r0;
                if (i13 == 0) {
                    dVar.e(this.H.f2313i, this.F.f2313i, 0, 8);
                    dVar.e(this.F.f2313i, this.R.H.f2313i, 0, 4);
                    dVar.e(this.F.f2313i, this.R.F.f2313i, 0, 0);
                } else if (i13 == 1) {
                    dVar.e(this.F.f2313i, this.H.f2313i, 0, 8);
                    dVar.e(this.F.f2313i, this.R.F.f2313i, 0, 4);
                    dVar.e(this.F.f2313i, this.R.H.f2313i, 0, 0);
                } else if (i13 == 2) {
                    dVar.e(this.I.f2313i, this.G.f2313i, 0, 8);
                    dVar.e(this.G.f2313i, this.R.I.f2313i, 0, 4);
                    dVar.e(this.G.f2313i, this.R.G.f2313i, 0, 0);
                } else if (i13 == 3) {
                    dVar.e(this.G.f2313i, this.I.f2313i, 0, 8);
                    dVar.e(this.G.f2313i, this.R.G.f2313i, 0, 4);
                    dVar.e(this.G.f2313i, this.R.I.f2313i, 0, 0);
                }
            }
        }
    }

    public int g1() {
        int i2 = this.r0;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // b.f.b.k.e
    public boolean h() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void h1() {
        for (int i2 = 0; i2 < this.q0; i2++) {
            e eVar = this.p0[i2];
            int i3 = this.r0;
            if (i3 == 0 || i3 == 1) {
                eVar.C0(0, true);
            } else if (i3 == 2 || i3 == 3) {
                eVar.C0(1, true);
            }
        }
    }

    public void i1(boolean z) {
        this.s0 = z;
    }

    public void j1(int i2) {
        this.r0 = i2;
    }

    public void k1(int i2) {
        this.t0 = i2;
    }

    @Override // b.f.b.k.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i2 = 0; i2 < this.q0; i2++) {
            e eVar = this.p0[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }
}
