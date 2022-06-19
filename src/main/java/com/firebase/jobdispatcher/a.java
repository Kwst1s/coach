package com.firebase.jobdispatcher;

/* compiled from: Constraint */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f4601a = {2, 1, 4, 8};

    static int a(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 : iArr) {
            i2 |= i3;
        }
        return i2;
    }

    static int[] b(int i2) {
        int[] iArr = f4601a;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            i3 += (i2 & i5) == i5 ? 1 : 0;
        }
        int[] iArr2 = new int[i3];
        int[] iArr3 = f4601a;
        int i6 = 0;
        for (int i7 : iArr3) {
            if ((i2 & i7) == i7) {
                iArr2[i6] = i7;
                i6++;
            }
        }
        return iArr2;
    }
}
