package com.rd.c.b;

import android.util.Pair;
import android.view.View;
import com.rd.c.c.a;
import com.rd.c.c.b;

/* compiled from: MeasureController */
public class c {
    public Pair<Integer, Integer> a(a aVar, int i2, int i3) {
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int c2 = aVar.c();
        int m = aVar.m();
        int s = aVar.s();
        int h2 = aVar.h();
        int j2 = aVar.j();
        int l = aVar.l();
        int k2 = aVar.k();
        int i6 = aVar.i();
        int i7 = m * 2;
        b g2 = aVar.g();
        int i8 = 0;
        if (c2 != 0) {
            i4 = (i7 * c2) + (s * 2 * c2) + (h2 * (c2 - 1));
            i5 = i7 + s;
            if (g2 != b.HORIZONTAL) {
                i4 = i5;
                i5 = i4;
            }
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (aVar.b() == com.rd.b.d.a.DROP) {
            if (g2 == b.HORIZONTAL) {
                i5 *= 2;
            } else {
                i4 *= 2;
            }
        }
        b bVar = b.HORIZONTAL;
        int i9 = i4 + j2 + k2;
        int i10 = i5 + l + i6;
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i9, size) : i9;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i10, size2) : i10;
        }
        if (size < 0) {
            size = 0;
        }
        if (size2 >= 0) {
            i8 = size2;
        }
        aVar.a0(size);
        aVar.G(i8);
        return new Pair<>(Integer.valueOf(size), Integer.valueOf(i8));
    }
}
