package b.f.b.k.m;

import b.f.b.d;
import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.f;
import b.f.b.k.g;
import b.f.b.k.h;
import b.f.b.k.j;
import b.f.b.k.k;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: BasicMeasure */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<e> f2345a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f2346b = new a();

    /* renamed from: c  reason: collision with root package name */
    private f f2347c;

    /* compiled from: BasicMeasure */
    public static class a {

        /* renamed from: k  reason: collision with root package name */
        public static int f2348k = 0;
        public static int l = 1;
        public static int m = 2;

        /* renamed from: a  reason: collision with root package name */
        public e.b f2349a;

        /* renamed from: b  reason: collision with root package name */
        public e.b f2350b;

        /* renamed from: c  reason: collision with root package name */
        public int f2351c;

        /* renamed from: d  reason: collision with root package name */
        public int f2352d;

        /* renamed from: e  reason: collision with root package name */
        public int f2353e;

        /* renamed from: f  reason: collision with root package name */
        public int f2354f;

        /* renamed from: g  reason: collision with root package name */
        public int f2355g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2356h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2357i;

        /* renamed from: j  reason: collision with root package name */
        public int f2358j;
    }

    /* renamed from: b.f.b.k.m.b$b  reason: collision with other inner class name */
    /* compiled from: BasicMeasure */
    public interface AbstractC0036b {
        void a(e eVar, a aVar);

        void b();
    }

    public b(f fVar) {
        this.f2347c = fVar;
    }

    private boolean a(AbstractC0036b bVar, e eVar, int i2) {
        this.f2346b.f2349a = eVar.y();
        this.f2346b.f2350b = eVar.O();
        this.f2346b.f2351c = eVar.R();
        this.f2346b.f2352d = eVar.v();
        a aVar = this.f2346b;
        aVar.f2357i = false;
        aVar.f2358j = i2;
        e.b bVar2 = aVar.f2349a;
        e.b bVar3 = e.b.MATCH_CONSTRAINT;
        boolean z = bVar2 == bVar3;
        boolean z2 = aVar.f2350b == bVar3;
        boolean z3 = z && eVar.U > Utils.FLOAT_EPSILON;
        boolean z4 = z2 && eVar.U > Utils.FLOAT_EPSILON;
        if (z3 && eVar.p[0] == 4) {
            aVar.f2349a = e.b.FIXED;
        }
        if (z4 && eVar.p[1] == 4) {
            aVar.f2350b = e.b.FIXED;
        }
        bVar.a(eVar, aVar);
        eVar.U0(this.f2346b.f2353e);
        eVar.v0(this.f2346b.f2354f);
        eVar.u0(this.f2346b.f2356h);
        eVar.k0(this.f2346b.f2355g);
        a aVar2 = this.f2346b;
        aVar2.f2358j = a.f2348k;
        return aVar2.f2357i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.U <= com.github.mikephil.charting.utils.Utils.FLOAT_EPSILON) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(b.f.b.k.f r13) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.b.b(b.f.b.k.f):void");
    }

    private void c(f fVar, String str, int i2, int i3) {
        int G = fVar.G();
        int F = fVar.F();
        fVar.K0(0);
        fVar.J0(0);
        fVar.U0(i2);
        fVar.v0(i3);
        fVar.K0(G);
        fVar.J0(F);
        this.f2347c.b1();
    }

    public long d(f fVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        boolean z;
        int i12;
        boolean z2;
        boolean z3;
        int i13;
        boolean z4;
        AbstractC0036b bVar;
        int i14;
        int i15;
        int i16;
        boolean z5;
        b.f.b.e eVar;
        AbstractC0036b r1 = fVar.r1();
        int size = fVar.p0.size();
        int R = fVar.R();
        int v = fVar.v();
        boolean b2 = j.b(i2, 128);
        boolean z6 = b2 || j.b(i2, 64);
        if (z6) {
            int i17 = 0;
            while (true) {
                if (i17 >= size) {
                    break;
                }
                e eVar2 = fVar.p0.get(i17);
                e.b y = eVar2.y();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                boolean z7 = (y == bVar2) && (eVar2.O() == bVar2) && eVar2.t() > Utils.FLOAT_EPSILON;
                if ((!eVar2.Z() || !z7) && ((!eVar2.b0() || !z7) && !(eVar2 instanceof k) && !eVar2.Z() && !eVar2.b0())) {
                    i17++;
                }
            }
            z6 = false;
        }
        if (z6 && (eVar = d.x) != null) {
            eVar.f2248c++;
        }
        boolean z8 = z6 & ((i5 == 1073741824 && i7 == 1073741824) || b2);
        if (z8) {
            int min = Math.min(fVar.E(), i6);
            int min2 = Math.min(fVar.D(), i8);
            if (i5 == 1073741824 && fVar.R() != min) {
                fVar.U0(min);
                fVar.u1();
            }
            if (i7 == 1073741824 && fVar.v() != min2) {
                fVar.v0(min2);
                fVar.u1();
            }
            if (i5 == 1073741824 && i7 == 1073741824) {
                z = fVar.o1(b2);
                i11 = 2;
            } else {
                boolean p1 = fVar.p1(b2);
                if (i5 == 1073741824) {
                    p1 &= fVar.q1(b2, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i7 == 1073741824) {
                    z = fVar.q1(b2, 1) & p1;
                    i11++;
                } else {
                    z = p1;
                }
            }
            if (z) {
                fVar.Y0(i5 == 1073741824, i7 == 1073741824);
            }
        } else {
            z = false;
            i11 = 0;
        }
        if (z && i11 == 2) {
            return 0;
        }
        int s1 = fVar.s1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = this.f2345a.size();
        if (size > 0) {
            c(fVar, "First pass", R, v);
        }
        if (size2 > 0) {
            e.b y2 = fVar.y();
            e.b bVar3 = e.b.WRAP_CONTENT;
            boolean z9 = y2 == bVar3;
            boolean z10 = fVar.O() == bVar3;
            int max = Math.max(fVar.R(), this.f2347c.G());
            int max2 = Math.max(fVar.v(), this.f2347c.F());
            int i18 = 0;
            boolean z11 = false;
            while (i18 < size2) {
                e eVar3 = this.f2345a.get(i18);
                if (!(eVar3 instanceof k)) {
                    i14 = s1;
                    i16 = R;
                    i15 = v;
                } else {
                    int R2 = eVar3.R();
                    i14 = s1;
                    int v2 = eVar3.v();
                    i16 = R;
                    boolean a2 = a(r1, eVar3, a.l) | z11;
                    b.f.b.e eVar4 = fVar.u0;
                    i15 = v;
                    if (eVar4 != null) {
                        eVar4.f2247b++;
                    }
                    int R3 = eVar3.R();
                    int v3 = eVar3.v();
                    if (R3 != R2) {
                        eVar3.U0(R3);
                        if (z9 && eVar3.K() > max) {
                            max = Math.max(max, eVar3.K() + eVar3.m(d.b.RIGHT).e());
                        }
                        z5 = true;
                    } else {
                        z5 = a2;
                    }
                    if (v3 != v2) {
                        eVar3.v0(v3);
                        if (z10 && eVar3.p() > max2) {
                            max2 = Math.max(max2, eVar3.p() + eVar3.m(d.b.BOTTOM).e());
                        }
                        z5 = true;
                    }
                    z11 = z5 | ((k) eVar3).d1();
                }
                i18++;
                s1 = i14;
                R = i16;
                v = i15;
            }
            int i19 = 0;
            int i20 = 2;
            while (i19 < i20) {
                int i21 = 0;
                while (i21 < size2) {
                    e eVar5 = this.f2345a.get(i21);
                    if ((!(eVar5 instanceof h) || (eVar5 instanceof k)) && !(eVar5 instanceof g) && eVar5.Q() != 8 && ((!z8 || !eVar5.f2328d.f2407e.f2377j || !eVar5.f2329e.f2407e.f2377j) && !(eVar5 instanceof k))) {
                        int R4 = eVar5.R();
                        int v4 = eVar5.v();
                        int n = eVar5.n();
                        int i22 = a.l;
                        z4 = z8;
                        if (i19 == 1) {
                            i22 = a.m;
                        }
                        boolean a3 = a(r1, eVar5, i22) | z11;
                        b.f.b.e eVar6 = fVar.u0;
                        i13 = size2;
                        bVar = r1;
                        if (eVar6 != null) {
                            eVar6.f2247b++;
                        }
                        int R5 = eVar5.R();
                        int v5 = eVar5.v();
                        if (R5 != R4) {
                            eVar5.U0(R5);
                            if (z9 && eVar5.K() > max) {
                                max = Math.max(max, eVar5.K() + eVar5.m(d.b.RIGHT).e());
                            }
                            a3 = true;
                        }
                        if (v5 != v4) {
                            eVar5.v0(v5);
                            if (z10 && eVar5.p() > max2) {
                                max2 = Math.max(max2, eVar5.p() + eVar5.m(d.b.BOTTOM).e());
                            }
                            a3 = true;
                        }
                        z11 = (!eVar5.U() || n == eVar5.n()) ? a3 : true;
                    } else {
                        z4 = z8;
                        i13 = size2;
                        bVar = r1;
                    }
                    i21++;
                    size2 = i13;
                    r1 = bVar;
                    z8 = z4;
                }
                if (!z11) {
                    break;
                }
                c(fVar, "intermediate pass", R, v);
                i19++;
                r1 = r1;
                z8 = z8;
                i20 = 2;
                z11 = false;
                size2 = size2;
            }
            if (z11) {
                c(fVar, "2nd pass", R, v);
                if (fVar.R() < max) {
                    fVar.U0(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (fVar.v() < max2) {
                    fVar.v0(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    c(fVar, "3rd pass", R, v);
                }
            }
            i12 = s1;
        } else {
            i12 = s1;
        }
        fVar.E1(i12);
        return 0;
    }

    public void e(f fVar) {
        this.f2345a.clear();
        int size = fVar.p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = fVar.p0.get(i2);
            e.b y = eVar.y();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (y == bVar || eVar.O() == bVar) {
                this.f2345a.add(eVar);
            }
        }
        fVar.u1();
    }
}
