package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.e0.f;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.source.d0.e;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.util.m;

/* compiled from: BaseMediaChunkOutput */
public final class c implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f6096a;

    /* renamed from: b  reason: collision with root package name */
    private final x[] f6097b;

    public c(int[] iArr, x[] xVarArr) {
        this.f6096a = iArr;
        this.f6097b = xVarArr;
    }

    @Override // com.google.android.exoplayer2.source.d0.e.b
    public q a(int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f6096a;
            if (i4 >= iArr.length) {
                m.c("BaseMediaChunkOutput", "Unmatched track of type: " + i3);
                return new f();
            } else if (i3 == iArr[i4]) {
                return this.f6097b[i4];
            } else {
                i4++;
            }
        }
    }

    public int[] b() {
        int[] iArr = new int[this.f6097b.length];
        int i2 = 0;
        while (true) {
            x[] xVarArr = this.f6097b;
            if (i2 >= xVarArr.length) {
                return iArr;
            }
            if (xVarArr[i2] != null) {
                iArr[i2] = xVarArr[i2].t();
            }
            i2++;
        }
    }

    public void c(long j2) {
        x[] xVarArr = this.f6097b;
        for (x xVar : xVarArr) {
            if (xVar != null) {
                xVar.G(j2);
            }
        }
    }
}
