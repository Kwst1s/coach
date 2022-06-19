package com.google.android.exoplayer2.e0.t;

import com.google.android.exoplayer2.e0.m;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.e0.t.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: VbriSeeker */
public final class f implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f5180a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f5181b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5182c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5183d;

    private f(long[] jArr, long[] jArr2, long j2, long j3) {
        this.f5180a = jArr;
        this.f5181b = jArr2;
        this.f5182c = j2;
        this.f5183d = j3;
    }

    public static f a(long j2, long j3, m mVar, s sVar) {
        int i2;
        sVar.L(10);
        int j4 = sVar.j();
        if (j4 <= 0) {
            return null;
        }
        int i3 = mVar.f5091d;
        long Z = d0.Z((long) j4, 1000000 * ((long) (i3 >= 32000 ? 1152 : 576)), (long) i3);
        int E = sVar.E();
        int E2 = sVar.E();
        int E3 = sVar.E();
        sVar.L(2);
        long j5 = j3 + ((long) mVar.f5090c);
        long[] jArr = new long[E];
        long[] jArr2 = new long[E];
        int i4 = 0;
        long j6 = j3;
        while (i4 < E) {
            jArr[i4] = (((long) i4) * Z) / ((long) E);
            jArr2[i4] = Math.max(j6, j5);
            if (E3 == 1) {
                i2 = sVar.y();
            } else if (E3 == 2) {
                i2 = sVar.E();
            } else if (E3 == 3) {
                i2 = sVar.B();
            } else if (E3 != 4) {
                return null;
            } else {
                i2 = sVar.C();
            }
            j6 += (long) (i2 * E2);
            i4++;
            j5 = j5;
            E2 = E2;
        }
        if (!(j2 == -1 || j2 == j6)) {
            com.google.android.exoplayer2.util.m.f("VbriSeeker", "VBRI data size mismatch: " + j2 + ", " + j6);
        }
        return new f(jArr, jArr2, Z, j6);
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long b(long j2) {
        return this.f5180a[d0.e(this.f5181b, j2, true, true)];
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long d() {
        return this.f5183d;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        int e2 = d0.e(this.f5180a, j2, true, true);
        long[] jArr = this.f5180a;
        p pVar = new p(jArr[e2], this.f5181b[e2]);
        if (pVar.f5101a >= j2 || e2 == jArr.length - 1) {
            return new o.a(pVar);
        }
        int i2 = e2 + 1;
        return new o.a(pVar, new p(this.f5180a[i2], this.f5181b[i2]));
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.f5182c;
    }
}
