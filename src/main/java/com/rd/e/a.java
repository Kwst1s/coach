package com.rd.e;

import android.util.Pair;
import com.github.mikephil.charting.utils.Utils;
import com.rd.c.c.b;

/* compiled from: CoordinatesUtils */
public class a {
    public static int a(com.rd.c.c.a aVar, int i2) {
        if (aVar == null) {
            return 0;
        }
        if (aVar.g() == b.HORIZONTAL) {
            return g(aVar, i2);
        }
        return h(aVar, i2);
    }

    private static int b(com.rd.c.c.a aVar, float f2, float f3) {
        int i2;
        int c2 = aVar.c();
        int m = aVar.m();
        int s = aVar.s();
        int h2 = aVar.h();
        int d2 = aVar.g() == b.HORIZONTAL ? aVar.d() : aVar.v();
        int i3 = 0;
        int i4 = 0;
        while (i3 < c2) {
            if (i3 > 0) {
                i2 = h2;
            } else {
                i2 = h2 / 2;
            }
            int i5 = (m * 2) + (s / 2) + i2 + i4;
            boolean z = true;
            boolean z2 = f2 >= ((float) i4) && f2 <= ((float) i5);
            if (f3 < Utils.FLOAT_EPSILON || f3 > ((float) d2)) {
                z = false;
            }
            if (z2 && z) {
                return i3;
            }
            i3++;
            i4 = i5;
        }
        return -1;
    }

    private static int c(com.rd.c.c.a aVar, int i2) {
        int c2 = aVar.c();
        int m = aVar.m();
        int s = aVar.s();
        int h2 = aVar.h();
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            int i5 = s / 2;
            int i6 = i3 + m + i5;
            if (i2 == i4) {
                return i6;
            }
            i3 = i6 + m + h2 + i5;
        }
        return aVar.b() == com.rd.b.d.a.DROP ? i3 + (m * 2) : i3;
    }

    public static int d(com.rd.c.c.a aVar, float f2, float f3) {
        if (aVar == null) {
            return -1;
        }
        if (aVar.g() != b.HORIZONTAL) {
            f3 = f2;
            f2 = f3;
        }
        return b(aVar, f2, f3);
    }

    public static Pair<Integer, Float> e(com.rd.c.c.a aVar, int i2, float f2, boolean z) {
        int c2 = aVar.c();
        int q = aVar.q();
        if (z) {
            i2 = (c2 - 1) - i2;
        }
        boolean z2 = false;
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = c2 - 1;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        boolean z3 = i2 > q;
        boolean z4 = !z ? i2 + 1 < q : i2 + -1 < q;
        if (z3 || z4) {
            aVar.V(i2);
            q = i2;
        }
        float f3 = Utils.FLOAT_EPSILON;
        if (q == i2 && f2 != Utils.FLOAT_EPSILON) {
            z2 = true;
        }
        if (z2) {
            i2 = z ? i2 - 1 : i2 + 1;
        } else {
            f2 = 1.0f - f2;
        }
        if (f2 > 1.0f) {
            f3 = 1.0f;
        } else if (f2 >= Utils.FLOAT_EPSILON) {
            f3 = f2;
        }
        return new Pair<>(Integer.valueOf(i2), Float.valueOf(f3));
    }

    private static int f(com.rd.c.c.a aVar) {
        int m = aVar.m();
        return aVar.b() == com.rd.b.d.a.DROP ? m * 3 : m;
    }

    public static int g(com.rd.c.c.a aVar, int i2) {
        int i3;
        if (aVar == null) {
            return 0;
        }
        if (aVar.g() == b.HORIZONTAL) {
            i3 = c(aVar, i2);
        } else {
            i3 = f(aVar);
        }
        return i3 + aVar.j();
    }

    public static int h(com.rd.c.c.a aVar, int i2) {
        int i3;
        if (aVar == null) {
            return 0;
        }
        if (aVar.g() == b.HORIZONTAL) {
            i3 = f(aVar);
        } else {
            i3 = c(aVar, i2);
        }
        return i3 + aVar.l();
    }
}
