package b.f.b.k;

import b.f.b.d;
import java.util.ArrayList;

/* compiled from: Chain */
public class b {
    /* JADX DEBUG: Multi-variable search result rejected for r2v56, resolved type: b.f.b.k.e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r8 == 2) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r8 == 2) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x025c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02b5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0508  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x050e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x039f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:323:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(b.f.b.k.f r37, b.f.b.d r38, int r39, int r40, b.f.b.k.c r41) {
        /*
        // Method dump skipped, instructions count: 1331
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.b.a(b.f.b.k.f, b.f.b.d, int, int, b.f.b.k.c):void");
    }

    public static void b(f fVar, d dVar, ArrayList<e> arrayList, int i2) {
        c[] cVarArr;
        int i3;
        int i4;
        if (i2 == 0) {
            i4 = fVar.y0;
            cVarArr = fVar.B0;
            i3 = 0;
        } else {
            int i5 = fVar.z0;
            cVarArr = fVar.A0;
            i4 = i5;
            i3 = 2;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            c cVar = cVarArr[i6];
            cVar.a();
            if (arrayList == null || (arrayList != null && arrayList.contains(cVar.f2294a))) {
                a(fVar, dVar, i2, i3, cVar);
            }
        }
    }
}
