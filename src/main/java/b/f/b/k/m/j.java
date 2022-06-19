package b.f.b.k.m;

import b.f.b.k.e;
import b.f.b.k.g;

/* access modifiers changed from: package-private */
/* compiled from: GuidelineReference */
public class j extends p {
    public j(e eVar) {
        super(eVar);
        eVar.f2328d.f();
        eVar.f2329e.f();
        this.f2408f = ((g) eVar).b1();
    }

    private void q(f fVar) {
        this.f2410h.f2378k.add(fVar);
        fVar.l.add(this.f2410h);
    }

    @Override // b.f.b.k.m.d, b.f.b.k.m.p
    public void a(d dVar) {
        f fVar = this.f2410h;
        if (fVar.f2370c && !fVar.f2377j) {
            this.f2410h.d((int) ((((float) fVar.l.get(0).f2374g) * ((g) this.f2404b).e1()) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void d() {
        g gVar = (g) this.f2404b;
        int c1 = gVar.c1();
        int d1 = gVar.d1();
        gVar.e1();
        if (gVar.b1() == 1) {
            if (c1 != -1) {
                this.f2410h.l.add(this.f2404b.R.f2328d.f2410h);
                this.f2404b.R.f2328d.f2410h.f2378k.add(this.f2410h);
                this.f2410h.f2373f = c1;
            } else if (d1 != -1) {
                this.f2410h.l.add(this.f2404b.R.f2328d.f2411i);
                this.f2404b.R.f2328d.f2411i.f2378k.add(this.f2410h);
                this.f2410h.f2373f = -d1;
            } else {
                f fVar = this.f2410h;
                fVar.f2369b = true;
                fVar.l.add(this.f2404b.R.f2328d.f2411i);
                this.f2404b.R.f2328d.f2411i.f2378k.add(this.f2410h);
            }
            q(this.f2404b.f2328d.f2410h);
            q(this.f2404b.f2328d.f2411i);
            return;
        }
        if (c1 != -1) {
            this.f2410h.l.add(this.f2404b.R.f2329e.f2410h);
            this.f2404b.R.f2329e.f2410h.f2378k.add(this.f2410h);
            this.f2410h.f2373f = c1;
        } else if (d1 != -1) {
            this.f2410h.l.add(this.f2404b.R.f2329e.f2411i);
            this.f2404b.R.f2329e.f2411i.f2378k.add(this.f2410h);
            this.f2410h.f2373f = -d1;
        } else {
            f fVar2 = this.f2410h;
            fVar2.f2369b = true;
            fVar2.l.add(this.f2404b.R.f2329e.f2411i);
            this.f2404b.R.f2329e.f2411i.f2378k.add(this.f2410h);
        }
        q(this.f2404b.f2329e.f2410h);
        q(this.f2404b.f2329e.f2411i);
    }

    @Override // b.f.b.k.m.p
    public void e() {
        if (((g) this.f2404b).b1() == 1) {
            this.f2404b.V0(this.f2410h.f2374g);
        } else {
            this.f2404b.W0(this.f2410h.f2374g);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void f() {
        this.f2410h.c();
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public boolean m() {
        return false;
    }
}
