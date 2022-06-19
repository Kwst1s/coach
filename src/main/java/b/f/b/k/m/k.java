package b.f.b.k.m;

import b.f.b.k.a;
import b.f.b.k.e;
import b.f.b.k.m.f;

/* access modifiers changed from: package-private */
/* compiled from: HelperReferences */
public class k extends p {
    public k(e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f2410h.f2378k.add(fVar);
        fVar.l.add(this.f2410h);
    }

    @Override // b.f.b.k.m.d, b.f.b.k.m.p
    public void a(d dVar) {
        a aVar = (a) this.f2404b;
        int e1 = aVar.e1();
        int i2 = 0;
        int i3 = -1;
        for (f fVar : this.f2410h.l) {
            int i4 = fVar.f2374g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (e1 == 0 || e1 == 2) {
            this.f2410h.d(i3 + aVar.f1());
        } else {
            this.f2410h.d(i2 + aVar.f1());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void d() {
        e eVar = this.f2404b;
        if (eVar instanceof a) {
            this.f2410h.f2369b = true;
            a aVar = (a) eVar;
            int e1 = aVar.e1();
            boolean d1 = aVar.d1();
            int i2 = 0;
            if (e1 == 0) {
                this.f2410h.f2372e = f.a.LEFT;
                while (i2 < aVar.q0) {
                    e eVar2 = aVar.p0[i2];
                    if (d1 || eVar2.Q() != 8) {
                        f fVar = eVar2.f2328d.f2410h;
                        fVar.f2378k.add(this.f2410h);
                        this.f2410h.l.add(fVar);
                    }
                    i2++;
                }
                q(this.f2404b.f2328d.f2410h);
                q(this.f2404b.f2328d.f2411i);
            } else if (e1 == 1) {
                this.f2410h.f2372e = f.a.RIGHT;
                while (i2 < aVar.q0) {
                    e eVar3 = aVar.p0[i2];
                    if (d1 || eVar3.Q() != 8) {
                        f fVar2 = eVar3.f2328d.f2411i;
                        fVar2.f2378k.add(this.f2410h);
                        this.f2410h.l.add(fVar2);
                    }
                    i2++;
                }
                q(this.f2404b.f2328d.f2410h);
                q(this.f2404b.f2328d.f2411i);
            } else if (e1 == 2) {
                this.f2410h.f2372e = f.a.TOP;
                while (i2 < aVar.q0) {
                    e eVar4 = aVar.p0[i2];
                    if (d1 || eVar4.Q() != 8) {
                        f fVar3 = eVar4.f2329e.f2410h;
                        fVar3.f2378k.add(this.f2410h);
                        this.f2410h.l.add(fVar3);
                    }
                    i2++;
                }
                q(this.f2404b.f2329e.f2410h);
                q(this.f2404b.f2329e.f2411i);
            } else if (e1 == 3) {
                this.f2410h.f2372e = f.a.BOTTOM;
                while (i2 < aVar.q0) {
                    e eVar5 = aVar.p0[i2];
                    if (d1 || eVar5.Q() != 8) {
                        f fVar4 = eVar5.f2329e.f2411i;
                        fVar4.f2378k.add(this.f2410h);
                        this.f2410h.l.add(fVar4);
                    }
                    i2++;
                }
                q(this.f2404b.f2329e.f2410h);
                q(this.f2404b.f2329e.f2411i);
            }
        }
    }

    @Override // b.f.b.k.m.p
    public void e() {
        e eVar = this.f2404b;
        if (eVar instanceof a) {
            int e1 = ((a) eVar).e1();
            if (e1 == 0 || e1 == 1) {
                this.f2404b.V0(this.f2410h.f2374g);
            } else {
                this.f2404b.W0(this.f2410h.f2374g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void f() {
        this.f2405c = null;
        this.f2410h.c();
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public boolean m() {
        return false;
    }
}
