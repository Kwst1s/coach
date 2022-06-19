package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.g;
import java.util.ArrayList;

/* compiled from: Grouping */
public class i {
    public static o a(e eVar, int i2, ArrayList<o> arrayList, o oVar) {
        int i3;
        int b1;
        if (i2 == 0) {
            i3 = eVar.m0;
        } else {
            i3 = eVar.n0;
        }
        int i4 = 0;
        if (i3 != -1 && (oVar == null || i3 != oVar.f2399b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i5);
                if (oVar2.c() == i3) {
                    if (oVar != null) {
                        oVar.g(i2, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i5++;
                }
            }
        } else if (i3 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof b.f.b.k.i) && (b1 = ((b.f.b.k.i) eVar).b1(i2)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i6);
                    if (oVar3.c() == b1) {
                        oVar = oVar3;
                        break;
                    }
                    i6++;
                }
            }
            if (oVar == null) {
                oVar = new o(i2);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof g) {
                g gVar = (g) eVar;
                d a1 = gVar.a1();
                if (gVar.b1() == 0) {
                    i4 = 1;
                }
                a1.b(i4, arrayList, oVar);
            }
            if (i2 == 0) {
                eVar.m0 = oVar.c();
                eVar.F.b(i2, arrayList, oVar);
                eVar.H.b(i2, arrayList, oVar);
            } else {
                eVar.n0 = oVar.c();
                eVar.G.b(i2, arrayList, oVar);
                eVar.J.b(i2, arrayList, oVar);
                eVar.I.b(i2, arrayList, oVar);
            }
            eVar.M.b(i2, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = arrayList.get(i3);
            if (i2 == oVar.f2399b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:175:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x038a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(b.f.b.k.f r16, b.f.b.k.m.b.AbstractC0036b r17) {
        /*
        // Method dump skipped, instructions count: 913
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.i.c(b.f.b.k.f, b.f.b.k.m.b$b):boolean");
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
