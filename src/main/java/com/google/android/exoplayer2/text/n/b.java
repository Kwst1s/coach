package com.google.android.exoplayer2.text.n;

import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: SsaSubtitle */
public final class b implements d {

    /* renamed from: b  reason: collision with root package name */
    private final a[] f6772b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f6773c;

    public b(a[] aVarArr, long[] jArr) {
        this.f6772b = aVarArr;
        this.f6773c = jArr;
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        int c2 = d0.c(this.f6773c, j2, false, false);
        if (c2 < this.f6773c.length) {
            return c2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        boolean z = true;
        e.a(i2 >= 0);
        if (i2 >= this.f6773c.length) {
            z = false;
        }
        e.a(z);
        return this.f6773c[i2];
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        int e2 = d0.e(this.f6773c, j2, true, false);
        if (e2 != -1) {
            a[] aVarArr = this.f6772b;
            if (aVarArr[e2] != null) {
                return Collections.singletonList(aVarArr[e2]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return this.f6773c.length;
    }
}
