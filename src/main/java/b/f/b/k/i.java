package b.f.b.k;

import b.f.b.k.m.o;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: HelperWidget */
public class i extends e implements h {
    public e[] p0 = new e[4];
    public int q0 = 0;

    @Override // b.f.b.k.h
    public void a(e eVar) {
        if (eVar != this && eVar != null) {
            int i2 = this.q0 + 1;
            e[] eVarArr = this.p0;
            if (i2 > eVarArr.length) {
                this.p0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            }
            e[] eVarArr2 = this.p0;
            int i3 = this.q0;
            eVarArr2[i3] = eVar;
            this.q0 = i3 + 1;
        }
    }

    public void a1(ArrayList<o> arrayList, int i2, o oVar) {
        for (int i3 = 0; i3 < this.q0; i3++) {
            oVar.a(this.p0[i3]);
        }
        for (int i4 = 0; i4 < this.q0; i4++) {
            b.f.b.k.m.i.a(this.p0[i4], i2, arrayList, oVar);
        }
    }

    @Override // b.f.b.k.h
    public void b(f fVar) {
    }

    public int b1(int i2) {
        int i3;
        int i4;
        for (int i5 = 0; i5 < this.q0; i5++) {
            e eVar = this.p0[i5];
            if (i2 == 0 && (i4 = eVar.m0) != -1) {
                return i4;
            }
            if (i2 == 1 && (i3 = eVar.n0) != -1) {
                return i3;
            }
        }
        return -1;
    }

    @Override // b.f.b.k.h
    public void c() {
        this.q0 = 0;
        Arrays.fill(this.p0, (Object) null);
    }
}
