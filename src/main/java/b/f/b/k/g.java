package b.f.b.k;

import b.f.b.d;
import b.f.b.i;
import b.f.b.k.d;
import b.f.b.k.e;

/* compiled from: Guideline */
public class g extends e {
    protected float p0 = -1.0f;
    protected int q0 = -1;
    protected int r0 = -1;
    private d s0 = this.G;
    private int t0;
    private boolean u0;

    /* compiled from: Guideline */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2343a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
            // Method dump skipped, instructions count: 109
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.g.a.<clinit>():void");
        }
    }

    public g() {
        this.t0 = 0;
        this.O.clear();
        this.O.add(this.s0);
        int length = this.N.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.N[i2] = this.s0;
        }
    }

    @Override // b.f.b.k.e
    public void Z0(d dVar, boolean z) {
        if (I() != null) {
            int x = dVar.x(this.s0);
            if (this.t0 == 1) {
                V0(x);
                W0(0);
                v0(I().v());
                U0(0);
                return;
            }
            V0(0);
            W0(x);
            U0(I().R());
            v0(0);
        }
    }

    public d a1() {
        return this.s0;
    }

    public int b1() {
        return this.t0;
    }

    public int c1() {
        return this.q0;
    }

    public int d1() {
        return this.r0;
    }

    @Override // b.f.b.k.e
    public boolean e0() {
        return this.u0;
    }

    public float e1() {
        return this.p0;
    }

    @Override // b.f.b.k.e
    public boolean f0() {
        return this.u0;
    }

    public void f1(int i2) {
        this.s0.s(i2);
        this.u0 = true;
    }

    @Override // b.f.b.k.e
    public void g(d dVar, boolean z) {
        f fVar = (f) I();
        if (fVar != null) {
            d m = fVar.m(d.b.LEFT);
            d m2 = fVar.m(d.b.RIGHT);
            e eVar = this.R;
            boolean z2 = true;
            boolean z3 = eVar != null && eVar.Q[0] == e.b.WRAP_CONTENT;
            if (this.t0 == 0) {
                m = fVar.m(d.b.TOP);
                m2 = fVar.m(d.b.BOTTOM);
                e eVar2 = this.R;
                if (eVar2 == null || eVar2.Q[1] != e.b.WRAP_CONTENT) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.u0 && this.s0.m()) {
                i q = dVar.q(this.s0);
                dVar.f(q, this.s0.d());
                if (this.q0 != -1) {
                    if (z3) {
                        dVar.h(dVar.q(m2), q, 0, 5);
                    }
                } else if (this.r0 != -1 && z3) {
                    i q2 = dVar.q(m2);
                    dVar.h(q, dVar.q(m), 0, 5);
                    dVar.h(q2, q, 0, 5);
                }
                this.u0 = false;
            } else if (this.q0 != -1) {
                i q3 = dVar.q(this.s0);
                dVar.e(q3, dVar.q(m), this.q0, 8);
                if (z3) {
                    dVar.h(dVar.q(m2), q3, 0, 5);
                }
            } else if (this.r0 != -1) {
                i q4 = dVar.q(this.s0);
                i q5 = dVar.q(m2);
                dVar.e(q4, q5, -this.r0, 8);
                if (z3) {
                    dVar.h(q4, dVar.q(m), 0, 5);
                    dVar.h(q5, q4, 0, 5);
                }
            } else if (this.p0 != -1.0f) {
                dVar.d(b.f.b.d.s(dVar, dVar.q(this.s0), dVar.q(m2), this.p0));
            }
        }
    }

    public void g1(int i2) {
        if (i2 > -1) {
            this.p0 = -1.0f;
            this.q0 = i2;
            this.r0 = -1;
        }
    }

    @Override // b.f.b.k.e
    public boolean h() {
        return true;
    }

    public void h1(int i2) {
        if (i2 > -1) {
            this.p0 = -1.0f;
            this.q0 = -1;
            this.r0 = i2;
        }
    }

    public void i1(float f2) {
        if (f2 > -1.0f) {
            this.p0 = f2;
            this.q0 = -1;
            this.r0 = -1;
        }
    }

    public void j1(int i2) {
        if (this.t0 != i2) {
            this.t0 = i2;
            this.O.clear();
            if (this.t0 == 1) {
                this.s0 = this.F;
            } else {
                this.s0 = this.G;
            }
            this.O.add(this.s0);
            int length = this.N.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.N[i3] = this.s0;
            }
        }
    }

    @Override // b.f.b.k.e
    public d m(d.b bVar) {
        switch (a.f2343a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.t0 == 1) {
                    return this.s0;
                }
                break;
            case 3:
            case 4:
                if (this.t0 == 0) {
                    return this.s0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
