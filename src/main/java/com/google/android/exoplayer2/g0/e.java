package com.google.android.exoplayer2.g0;

import android.util.Pair;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.z;

/* compiled from: MappingTrackSelector */
public abstract class e extends i {

    /* renamed from: b  reason: collision with root package name */
    private a f5844b;

    /* compiled from: MappingTrackSelector */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f5845a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f5846b;

        /* renamed from: c  reason: collision with root package name */
        private final c0[] f5847c;

        a(int[] iArr, c0[] c0VarArr, int[] iArr2, int[][][] iArr3, c0 c0Var) {
            this.f5846b = iArr;
            this.f5847c = c0VarArr;
            this.f5845a = iArr.length;
        }

        public int a() {
            return this.f5845a;
        }

        public int b(int i2) {
            return this.f5846b[i2];
        }

        public c0 c(int i2) {
            return this.f5847c[i2];
        }
    }

    private static int e(y[] yVarArr, b0 b0Var) {
        int length = yVarArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < yVarArr.length; i3++) {
            y yVar = yVarArr[i3];
            for (int i4 = 0; i4 < b0Var.f6079b; i4++) {
                int a2 = yVar.a(b0Var.g(i4)) & 7;
                if (a2 > i2) {
                    if (a2 == 4) {
                        return i3;
                    }
                    length = i3;
                    i2 = a2;
                }
            }
        }
        return length;
    }

    private static int[] g(y yVar, b0 b0Var) {
        int[] iArr = new int[b0Var.f6079b];
        for (int i2 = 0; i2 < b0Var.f6079b; i2++) {
            iArr[i2] = yVar.a(b0Var.g(i2));
        }
        return iArr;
    }

    private static int[] h(y[] yVarArr) {
        int length = yVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = yVarArr[i2].k();
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.g0.i
    public final void c(Object obj) {
        this.f5844b = (a) obj;
    }

    @Override // com.google.android.exoplayer2.g0.i
    public final j d(y[] yVarArr, c0 c0Var) {
        int[] iArr;
        int[] iArr2 = new int[(yVarArr.length + 1)];
        int length = yVarArr.length + 1;
        b0[][] b0VarArr = new b0[length][];
        int[][][] iArr3 = new int[(yVarArr.length + 1)][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = c0Var.f6087b;
            b0VarArr[i2] = new b0[i3];
            iArr3[i2] = new int[i3][];
        }
        int[] h2 = h(yVarArr);
        for (int i4 = 0; i4 < c0Var.f6087b; i4++) {
            b0 g2 = c0Var.g(i4);
            int e2 = e(yVarArr, g2);
            if (e2 == yVarArr.length) {
                iArr = new int[g2.f6079b];
            } else {
                iArr = g(yVarArr[e2], g2);
            }
            int i5 = iArr2[e2];
            b0VarArr[e2][i5] = g2;
            iArr3[e2][i5] = iArr;
            iArr2[e2] = iArr2[e2] + 1;
        }
        c0[] c0VarArr = new c0[yVarArr.length];
        int[] iArr4 = new int[yVarArr.length];
        for (int i6 = 0; i6 < yVarArr.length; i6++) {
            int i7 = iArr2[i6];
            c0VarArr[i6] = new c0((b0[]) d0.T(b0VarArr[i6], i7));
            iArr3[i6] = (int[][]) d0.T(iArr3[i6], i7);
            iArr4[i6] = yVarArr[i6].g();
        }
        a aVar = new a(iArr4, c0VarArr, h2, iArr3, new c0((b0[]) d0.T(b0VarArr[yVarArr.length], iArr2[yVarArr.length])));
        Pair<z[], g[]> i8 = i(aVar, iArr3, h2);
        return new j((z[]) i8.first, (g[]) i8.second, aVar);
    }

    public final a f() {
        return this.f5844b;
    }

    /* access modifiers changed from: protected */
    public abstract Pair<z[], g[]> i(a aVar, int[][][] iArr, int[] iArr2);
}
