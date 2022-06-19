package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SlidingPercentile */
public class v {

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<b> f7069h = b.f7003b;

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<b> f7070i = c.f7004b;

    /* renamed from: a  reason: collision with root package name */
    private final int f7071a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<b> f7072b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final b[] f7073c = new b[5];

    /* renamed from: d  reason: collision with root package name */
    private int f7074d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f7075e;

    /* renamed from: f  reason: collision with root package name */
    private int f7076f;

    /* renamed from: g  reason: collision with root package name */
    private int f7077g;

    /* access modifiers changed from: private */
    /* compiled from: SlidingPercentile */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7078a;

        /* renamed from: b  reason: collision with root package name */
        public int f7079b;

        /* renamed from: c  reason: collision with root package name */
        public float f7080c;

        private b() {
        }
    }

    public v(int i2) {
        this.f7071a = i2;
    }

    private void b() {
        if (this.f7074d != 1) {
            Collections.sort(this.f7072b, f7069h);
            this.f7074d = 1;
        }
    }

    private void c() {
        if (this.f7074d != 0) {
            Collections.sort(this.f7072b, f7070i);
            this.f7074d = 0;
        }
    }

    static /* synthetic */ int e(b bVar, b bVar2) {
        return bVar.f7078a - bVar2.f7078a;
    }

    public void a(int i2, float f2) {
        b bVar;
        b();
        int i3 = this.f7077g;
        if (i3 > 0) {
            b[] bVarArr = this.f7073c;
            int i4 = i3 - 1;
            this.f7077g = i4;
            bVar = bVarArr[i4];
        } else {
            bVar = new b();
        }
        int i5 = this.f7075e;
        this.f7075e = i5 + 1;
        bVar.f7078a = i5;
        bVar.f7079b = i2;
        bVar.f7080c = f2;
        this.f7072b.add(bVar);
        this.f7076f += i2;
        while (true) {
            int i6 = this.f7076f;
            int i7 = this.f7071a;
            if (i6 > i7) {
                int i8 = i6 - i7;
                b bVar2 = this.f7072b.get(0);
                int i9 = bVar2.f7079b;
                if (i9 <= i8) {
                    this.f7076f -= i9;
                    this.f7072b.remove(0);
                    int i10 = this.f7077g;
                    if (i10 < 5) {
                        b[] bVarArr2 = this.f7073c;
                        this.f7077g = i10 + 1;
                        bVarArr2[i10] = bVar2;
                    }
                } else {
                    bVar2.f7079b = i9 - i8;
                    this.f7076f -= i8;
                }
            } else {
                return;
            }
        }
    }

    public float d(float f2) {
        c();
        float f3 = f2 * ((float) this.f7076f);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7072b.size(); i3++) {
            b bVar = this.f7072b.get(i3);
            i2 += bVar.f7079b;
            if (((float) i2) >= f3) {
                return bVar.f7080c;
            }
        }
        if (this.f7072b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f7072b;
        return arrayList.get(arrayList.size() - 1).f7080c;
    }
}
