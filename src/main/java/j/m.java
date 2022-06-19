package j;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Options */
public final class m extends AbstractList<f> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    final f[] f10688b;

    private m(f[] fVarArr, int[] iArr) {
        this.f10688b = fVarArr;
    }

    private static void a(long j2, c cVar, int i2, List<f> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        c cVar2;
        int i7;
        int i8 = i3;
        if (i8 < i4) {
            for (int i9 = i8; i9 < i4; i9++) {
                if (list.get(i9).r() < i2) {
                    throw new AssertionError();
                }
            }
            f fVar = list.get(i3);
            f fVar2 = list.get(i4 - 1);
            int i10 = -1;
            if (i2 == fVar.r()) {
                i10 = list2.get(i8).intValue();
                i8++;
                fVar = list.get(i8);
            }
            if (fVar.j(i2) != fVar2.j(i2)) {
                int i11 = 1;
                for (int i12 = i8 + 1; i12 < i4; i12++) {
                    if (list.get(i12 - 1).j(i2) != list.get(i12).j(i2)) {
                        i11++;
                    }
                }
                long c2 = j2 + ((long) c(cVar)) + 2 + ((long) (i11 * 2));
                cVar.d0(i11);
                cVar.d0(i10);
                for (int i13 = i8; i13 < i4; i13++) {
                    byte j3 = list.get(i13).j(i2);
                    if (i13 == i8 || j3 != list.get(i13 - 1).j(i2)) {
                        cVar.d0(j3 & 255);
                    }
                }
                c cVar3 = new c();
                int i14 = i8;
                while (i14 < i4) {
                    byte j4 = list.get(i14).j(i2);
                    int i15 = i14 + 1;
                    int i16 = i15;
                    while (true) {
                        if (i16 >= i4) {
                            i6 = i4;
                            break;
                        } else if (j4 != list.get(i16).j(i2)) {
                            i6 = i16;
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (i15 == i6 && i2 + 1 == list.get(i14).r()) {
                        cVar.d0(list2.get(i14).intValue());
                        i7 = i6;
                        cVar2 = cVar3;
                    } else {
                        cVar.d0((int) ((((long) c(cVar3)) + c2) * -1));
                        i7 = i6;
                        cVar2 = cVar3;
                        a(c2, cVar3, i2 + 1, list, i14, i6, list2);
                    }
                    cVar3 = cVar2;
                    i14 = i7;
                }
                cVar.e(cVar3, cVar3.S());
                return;
            }
            int i17 = 0;
            int min = Math.min(fVar.r(), fVar2.r());
            int i18 = i2;
            while (i18 < min && fVar.j(i18) == fVar2.j(i18)) {
                i17++;
                i18++;
            }
            long c3 = 1 + j2 + ((long) c(cVar)) + 2 + ((long) i17);
            cVar.d0(-i17);
            cVar.d0(i10);
            int i19 = i2;
            while (true) {
                i5 = i2 + i17;
                if (i19 >= i5) {
                    break;
                }
                cVar.d0(fVar.j(i19) & 255);
                i19++;
            }
            if (i8 + 1 != i4) {
                c cVar4 = new c();
                cVar.d0((int) ((((long) c(cVar4)) + c3) * -1));
                a(c3, cVar4, i5, list, i8, i4, list2);
                cVar.e(cVar4, cVar4.S());
            } else if (i5 == list.get(i8).r()) {
                cVar.d0(list2.get(i8).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int c(c cVar) {
        return (int) (cVar.S() / 4);
    }

    public static m d(f... fVarArr) {
        if (fVarArr.length == 0) {
            return new m(new f[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, fVarArr[i3]), Integer.valueOf(i3));
        }
        if (((f) arrayList.get(0)).r() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                f fVar = (f) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    f fVar2 = (f) arrayList.get(i6);
                    if (!fVar2.s(fVar)) {
                        continue;
                        break;
                    } else if (fVar2.r() == fVar.r()) {
                        throw new IllegalArgumentException("duplicate option: " + fVar2);
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            c cVar = new c();
            a(0, cVar, 0, arrayList, 0, arrayList.size(), arrayList2);
            int c2 = c(cVar);
            int[] iArr = new int[c2];
            for (int i7 = 0; i7 < c2; i7++) {
                iArr[i7] = cVar.readInt();
            }
            if (cVar.o()) {
                return new m((f[]) fVarArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    /* renamed from: b */
    public f get(int i2) {
        return this.f10688b[i2];
    }

    public final int size() {
        return this.f10688b.length;
    }
}
