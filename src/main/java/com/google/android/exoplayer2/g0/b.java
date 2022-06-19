package com.google.android.exoplayer2.g0;

import android.os.SystemClock;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.d0.m;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: BaseTrackSelection */
public abstract class b implements g {

    /* renamed from: a  reason: collision with root package name */
    protected final b0 f5810a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f5811b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f5812c;

    /* renamed from: d  reason: collision with root package name */
    private final l[] f5813d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f5814e;

    /* renamed from: f  reason: collision with root package name */
    private int f5815f;

    /* renamed from: com.google.android.exoplayer2.g0.b$b  reason: collision with other inner class name */
    /* compiled from: BaseTrackSelection */
    private static final class C0129b implements Comparator<l> {
        private C0129b() {
        }

        /* renamed from: a */
        public int compare(l lVar, l lVar2) {
            return lVar2.f5973d - lVar.f5973d;
        }
    }

    public b(b0 b0Var, int... iArr) {
        int i2 = 0;
        e.f(iArr.length > 0);
        e.e(b0Var);
        this.f5810a = b0Var;
        int length = iArr.length;
        this.f5811b = length;
        this.f5813d = new l[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f5813d[i3] = b0Var.g(iArr[i3]);
        }
        Arrays.sort(this.f5813d, new C0129b());
        this.f5812c = new int[this.f5811b];
        while (true) {
            int i4 = this.f5811b;
            if (i2 < i4) {
                this.f5812c[i2] = b0Var.k(this.f5813d[i2]);
                i2++;
            } else {
                this.f5814e = new long[i4];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final boolean a(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean r = r(i2, elapsedRealtime);
        int i3 = 0;
        while (i3 < this.f5811b && !r) {
            r = i3 != i2 && !r(i3, elapsedRealtime);
            i3++;
        }
        if (!r) {
            return false;
        }
        long[] jArr = this.f5814e;
        jArr[i2] = Math.max(jArr[i2], elapsedRealtime + j2);
        return true;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final l b(int i2) {
        return this.f5813d[i2];
    }

    @Override // com.google.android.exoplayer2.g0.g
    public void c() {
    }

    @Override // com.google.android.exoplayer2.g0.g
    public void d() {
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final int e(int i2) {
        return this.f5812c[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5810a != bVar.f5810a || !Arrays.equals(this.f5812c, bVar.f5812c)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public int f(long j2, List<? extends com.google.android.exoplayer2.source.d0.l> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final int g(l lVar) {
        for (int i2 = 0; i2 < this.f5811b; i2++) {
            if (this.f5813d[i2] == lVar) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public /* synthetic */ void h(long j2, long j3, long j4, List list, m[] mVarArr) {
        f.b(this, j2, j3, j4, list, mVarArr);
    }

    public int hashCode() {
        if (this.f5815f == 0) {
            this.f5815f = (System.identityHashCode(this.f5810a) * 31) + Arrays.hashCode(this.f5812c);
        }
        return this.f5815f;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final int i() {
        return this.f5812c[m()];
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final b0 j() {
        return this.f5810a;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final l k() {
        return this.f5813d[m()];
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final int length() {
        return this.f5812c.length;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public void n(float f2) {
    }

    @Override // com.google.android.exoplayer2.g0.g
    public /* synthetic */ void o(long j2, long j3, long j4) {
        f.a(this, j2, j3, j4);
    }

    @Override // com.google.android.exoplayer2.g0.g
    public final int q(int i2) {
        for (int i3 = 0; i3 < this.f5811b; i3++) {
            if (this.f5812c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public final boolean r(int i2, long j2) {
        return this.f5814e[i2] > j2;
    }
}
