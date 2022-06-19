package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: ChunkIndex */
public final class b implements o {

    /* renamed from: a  reason: collision with root package name */
    public final int f5051a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f5052b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f5053c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f5054d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f5055e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5056f;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f5052b = iArr;
        this.f5053c = jArr;
        this.f5054d = jArr2;
        this.f5055e = jArr3;
        int length = iArr.length;
        this.f5051a = length;
        if (length > 0) {
            this.f5056f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f5056f = 0;
        }
    }

    public int a(long j2) {
        return d0.e(this.f5055e, j2, true, true);
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        int a2 = a(j2);
        p pVar = new p(this.f5055e[a2], this.f5053c[a2]);
        if (pVar.f5101a >= j2 || a2 == this.f5051a - 1) {
            return new o.a(pVar);
        }
        int i2 = a2 + 1;
        return new o.a(pVar, new p(this.f5055e[i2], this.f5053c[i2]));
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.f5056f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f5051a + ", sizes=" + Arrays.toString(this.f5052b) + ", offsets=" + Arrays.toString(this.f5053c) + ", timeUs=" + Arrays.toString(this.f5055e) + ", durationsUs=" + Arrays.toString(this.f5054d) + ")";
    }
}
