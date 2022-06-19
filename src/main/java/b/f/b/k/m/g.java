package b.f.b.k.m;

import b.f.b.k.m.f;

/* access modifiers changed from: package-private */
/* compiled from: DimensionDependency */
public class g extends f {
    public int m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f2372e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f2372e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // b.f.b.k.m.f
    public void d(int i2) {
        if (!this.f2377j) {
            this.f2377j = true;
            this.f2374g = i2;
            for (d dVar : this.f2378k) {
                dVar.a(dVar);
            }
        }
    }
}
