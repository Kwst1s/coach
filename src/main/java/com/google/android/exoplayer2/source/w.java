package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: SampleMetadataQueue */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private int f6625a = 1000;

    /* renamed from: b  reason: collision with root package name */
    private int[] f6626b = new int[1000];

    /* renamed from: c  reason: collision with root package name */
    private long[] f6627c = new long[1000];

    /* renamed from: d  reason: collision with root package name */
    private int[] f6628d = new int[1000];

    /* renamed from: e  reason: collision with root package name */
    private int[] f6629e = new int[1000];

    /* renamed from: f  reason: collision with root package name */
    private long[] f6630f = new long[1000];

    /* renamed from: g  reason: collision with root package name */
    private q.a[] f6631g = new q.a[1000];

    /* renamed from: h  reason: collision with root package name */
    private l[] f6632h = new l[1000];

    /* renamed from: i  reason: collision with root package name */
    private int f6633i;

    /* renamed from: j  reason: collision with root package name */
    private int f6634j;

    /* renamed from: k  reason: collision with root package name */
    private int f6635k;
    private int l;
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean o = true;
    private boolean p = true;
    private l q;
    private int r;

    /* compiled from: SampleMetadataQueue */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6636a;

        /* renamed from: b  reason: collision with root package name */
        public long f6637b;

        /* renamed from: c  reason: collision with root package name */
        public q.a f6638c;
    }

    private long f(int i2) {
        this.m = Math.max(this.m, p(i2));
        int i3 = this.f6633i - i2;
        this.f6633i = i3;
        this.f6634j += i2;
        int i4 = this.f6635k + i2;
        this.f6635k = i4;
        int i5 = this.f6625a;
        if (i4 >= i5) {
            this.f6635k = i4 - i5;
        }
        int i6 = this.l - i2;
        this.l = i6;
        if (i6 < 0) {
            this.l = 0;
        }
        if (i3 != 0) {
            return this.f6627c[this.f6635k];
        }
        int i7 = this.f6635k;
        if (i7 != 0) {
            i5 = i7;
        }
        int i8 = i5 - 1;
        return this.f6627c[i8] + ((long) this.f6628d[i8]);
    }

    private int k(int i2, int i3, long j2, boolean z) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3 && this.f6630f[i2] <= j2; i5++) {
            if (!z || (this.f6629e[i2] & 1) != 0) {
                i4 = i5;
            }
            i2++;
            if (i2 == this.f6625a) {
                i2 = 0;
            }
        }
        return i4;
    }

    private long p(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int r2 = r(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f6630f[r2]);
            if ((this.f6629e[r2] & 1) != 0) {
                break;
            }
            r2--;
            if (r2 == -1) {
                r2 = this.f6625a - 1;
            }
        }
        return j2;
    }

    private int r(int i2) {
        int i3 = this.f6635k + i2;
        int i4 = this.f6625a;
        return i3 < i4 ? i3 : i3 - i4;
    }

    public void A(int i2) {
        this.r = i2;
    }

    public synchronized int a(long j2, boolean z, boolean z2) {
        int r2 = r(this.l);
        if (u() && j2 >= this.f6630f[r2]) {
            if (j2 <= this.n || z2) {
                int k2 = k(r2, this.f6633i - this.l, j2, z);
                if (k2 == -1) {
                    return -1;
                }
                this.l += k2;
                return k2;
            }
        }
        return -1;
    }

    public synchronized int b() {
        int i2;
        int i3 = this.f6633i;
        i2 = i3 - this.l;
        this.l = i3;
        return i2;
    }

    public synchronized boolean c(long j2) {
        boolean z = false;
        if (this.f6633i == 0) {
            if (j2 > this.m) {
                z = true;
            }
            return z;
        } else if (Math.max(this.m, p(this.l)) >= j2) {
            return false;
        } else {
            int i2 = this.f6633i;
            int r2 = r(i2 - 1);
            while (i2 > this.l && this.f6630f[r2] >= j2) {
                i2--;
                r2--;
                if (r2 == -1) {
                    r2 = this.f6625a - 1;
                }
            }
            j(this.f6634j + i2);
            return true;
        }
    }

    public synchronized void d(long j2, int i2, long j3, int i3, q.a aVar) {
        if (this.o) {
            if ((i2 & 1) != 0) {
                this.o = false;
            } else {
                return;
            }
        }
        e.f(!this.p);
        e(j2);
        int r2 = r(this.f6633i);
        this.f6630f[r2] = j2;
        long[] jArr = this.f6627c;
        jArr[r2] = j3;
        this.f6628d[r2] = i3;
        this.f6629e[r2] = i2;
        this.f6631g[r2] = aVar;
        this.f6632h[r2] = this.q;
        this.f6626b[r2] = this.r;
        int i4 = this.f6633i + 1;
        this.f6633i = i4;
        int i5 = this.f6625a;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            q.a[] aVarArr = new q.a[i6];
            l[] lVarArr = new l[i6];
            int i7 = this.f6635k;
            int i8 = i5 - i7;
            System.arraycopy(jArr, i7, jArr2, 0, i8);
            System.arraycopy(this.f6630f, this.f6635k, jArr3, 0, i8);
            System.arraycopy(this.f6629e, this.f6635k, iArr2, 0, i8);
            System.arraycopy(this.f6628d, this.f6635k, iArr3, 0, i8);
            System.arraycopy(this.f6631g, this.f6635k, aVarArr, 0, i8);
            System.arraycopy(this.f6632h, this.f6635k, lVarArr, 0, i8);
            System.arraycopy(this.f6626b, this.f6635k, iArr, 0, i8);
            int i9 = this.f6635k;
            System.arraycopy(this.f6627c, 0, jArr2, i8, i9);
            System.arraycopy(this.f6630f, 0, jArr3, i8, i9);
            System.arraycopy(this.f6629e, 0, iArr2, i8, i9);
            System.arraycopy(this.f6628d, 0, iArr3, i8, i9);
            System.arraycopy(this.f6631g, 0, aVarArr, i8, i9);
            System.arraycopy(this.f6632h, 0, lVarArr, i8, i9);
            System.arraycopy(this.f6626b, 0, iArr, i8, i9);
            this.f6627c = jArr2;
            this.f6630f = jArr3;
            this.f6629e = iArr2;
            this.f6628d = iArr3;
            this.f6631g = aVarArr;
            this.f6632h = lVarArr;
            this.f6626b = iArr;
            this.f6635k = 0;
            this.f6633i = this.f6625a;
            this.f6625a = i6;
        }
    }

    public synchronized void e(long j2) {
        this.n = Math.max(this.n, j2);
    }

    public synchronized long g(long j2, boolean z, boolean z2) {
        int i2;
        int i3 = this.f6633i;
        if (i3 != 0) {
            long[] jArr = this.f6630f;
            int i4 = this.f6635k;
            if (j2 >= jArr[i4]) {
                if (z2 && (i2 = this.l) != i3) {
                    i3 = i2 + 1;
                }
                int k2 = k(i4, i3, j2, z);
                if (k2 == -1) {
                    return -1;
                }
                return f(k2);
            }
        }
        return -1;
    }

    public synchronized long h() {
        int i2 = this.f6633i;
        if (i2 == 0) {
            return -1;
        }
        return f(i2);
    }

    public synchronized long i() {
        int i2 = this.l;
        if (i2 == 0) {
            return -1;
        }
        return f(i2);
    }

    public long j(int i2) {
        int t = t() - i2;
        e.a(t >= 0 && t <= this.f6633i - this.l);
        int i3 = this.f6633i - t;
        this.f6633i = i3;
        this.n = Math.max(this.m, p(i3));
        int i4 = this.f6633i;
        if (i4 == 0) {
            return 0;
        }
        int r2 = r(i4 - 1);
        return this.f6627c[r2] + ((long) this.f6628d[r2]);
    }

    public synchronized boolean l(l lVar) {
        if (lVar == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (d0.b(lVar, this.q)) {
            return false;
        }
        this.q = lVar;
        return true;
    }

    public int m() {
        return this.f6634j;
    }

    public synchronized long n() {
        return this.f6633i == 0 ? Long.MIN_VALUE : this.f6630f[this.f6635k];
    }

    public synchronized long o() {
        return this.n;
    }

    public int q() {
        return this.f6634j + this.l;
    }

    public synchronized l s() {
        return this.p ? null : this.q;
    }

    public int t() {
        return this.f6634j + this.f6633i;
    }

    public synchronized boolean u() {
        return this.l != this.f6633i;
    }

    public int v() {
        return u() ? this.f6626b[r(this.l)] : this.r;
    }

    public synchronized int w(m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z, boolean z2, l lVar, a aVar) {
        if (u()) {
            int r2 = r(this.l);
            if (z || this.f6632h[r2] != lVar) {
                mVar.f5981a = this.f6632h[r2];
                return -5;
            } else if (eVar.q()) {
                return -3;
            } else {
                eVar.f4952e = this.f6630f[r2];
                eVar.l(this.f6629e[r2]);
                aVar.f6636a = this.f6628d[r2];
                aVar.f6637b = this.f6627c[r2];
                aVar.f6638c = this.f6631g[r2];
                this.l++;
                return -4;
            }
        } else if (z2) {
            eVar.l(4);
            return -4;
        } else {
            l lVar2 = this.q;
            if (lVar2 == null || (!z && lVar2 == lVar)) {
                return -3;
            }
            mVar.f5981a = lVar2;
            return -5;
        }
    }

    public void x(boolean z) {
        this.f6633i = 0;
        this.f6634j = 0;
        this.f6635k = 0;
        this.l = 0;
        this.o = true;
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        if (z) {
            this.q = null;
            this.p = true;
        }
    }

    public synchronized void y() {
        this.l = 0;
    }

    public synchronized boolean z(int i2) {
        int i3 = this.f6634j;
        if (i3 > i2 || i2 > this.f6633i + i3) {
            return false;
        }
        this.l = i2 - i3;
        return true;
    }
}
