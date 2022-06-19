package b.f.b.k;

import b.f.b.c;
import java.util.ArrayList;

/* compiled from: WidgetContainer */
public class l extends e {
    public ArrayList<e> p0 = new ArrayList<>();

    public void a(e eVar) {
        this.p0.add(eVar);
        if (eVar.I() != null) {
            ((l) eVar.I()).c1(eVar);
        }
        eVar.M0(this);
    }

    public ArrayList<e> a1() {
        return this.p0;
    }

    public void b1() {
        ArrayList<e> arrayList = this.p0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.p0.get(i2);
                if (eVar instanceof l) {
                    ((l) eVar).b1();
                }
            }
        }
    }

    public void c1(e eVar) {
        this.p0.remove(eVar);
        eVar.h0();
    }

    public void d1() {
        this.p0.clear();
    }

    @Override // b.f.b.k.e
    public void h0() {
        this.p0.clear();
        super.h0();
    }

    @Override // b.f.b.k.e
    public void j0(c cVar) {
        super.j0(cVar);
        int size = this.p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p0.get(i2).j0(cVar);
        }
    }
}
