package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.e0.v.i;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: FlacReader */
public final class c extends i {
    private k n;
    private a o;

    /* compiled from: FlacReader */
    private class a implements g, o {

        /* renamed from: a  reason: collision with root package name */
        private long[] f5345a;

        /* renamed from: b  reason: collision with root package name */
        private long[] f5346b;

        /* renamed from: c  reason: collision with root package name */
        private long f5347c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f5348d = -1;

        public a() {
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public long a(h hVar) {
            long j2 = this.f5348d;
            if (j2 < 0) {
                return -1;
            }
            long j3 = -(j2 + 2);
            this.f5348d = -1;
            return j3;
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public o c() {
            return this;
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public long e(long j2) {
            long b2 = c.this.b(j2);
            this.f5348d = this.f5345a[d0.e(this.f5345a, b2, true, true)];
            return b2;
        }

        public void f(s sVar) {
            sVar.L(1);
            int B = sVar.B() / 18;
            this.f5345a = new long[B];
            this.f5346b = new long[B];
            for (int i2 = 0; i2 < B; i2++) {
                this.f5345a[i2] = sVar.r();
                this.f5346b[i2] = sVar.r();
                sVar.L(2);
            }
        }

        @Override // com.google.android.exoplayer2.e0.o
        public boolean g() {
            return true;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public o.a h(long j2) {
            int e2 = d0.e(this.f5345a, c.this.b(j2), true, true);
            long a2 = c.this.a(this.f5345a[e2]);
            p pVar = new p(a2, this.f5347c + this.f5346b[e2]);
            if (a2 < j2) {
                long[] jArr = this.f5345a;
                if (e2 != jArr.length - 1) {
                    int i2 = e2 + 1;
                    return new o.a(pVar, new p(c.this.a(jArr[i2]), this.f5347c + this.f5346b[i2]));
                }
            }
            return new o.a(pVar);
        }

        public void i(long j2) {
            this.f5347c = j2;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public long j() {
            return c.this.n.b();
        }
    }

    c() {
    }

    private int m(s sVar) {
        int i2;
        int i3;
        int i4 = (sVar.f7062a[2] & 255) >> 4;
        switch (i4) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = 576;
                i3 = i4 - 2;
                break;
            case 6:
            case 7:
                sVar.L(4);
                sVar.F();
                int y = i4 == 6 ? sVar.y() : sVar.E();
                sVar.K(0);
                return y + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = 256;
                i3 = i4 - 8;
                break;
            default:
                return -1;
        }
        return i2 << i3;
    }

    private static boolean n(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean o(s sVar) {
        return sVar.a() >= 5 && sVar.y() == 127 && sVar.A() == 1179402563;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public long e(s sVar) {
        if (!n(sVar.f7062a)) {
            return -1;
        }
        return (long) m(sVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public boolean h(s sVar, long j2, i.b bVar) {
        byte[] bArr = sVar.f7062a;
        if (this.n == null) {
            this.n = new k(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, sVar.d());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            int a2 = this.n.a();
            k kVar = this.n;
            bVar.f5378a = l.t(null, "audio/flac", null, -1, a2, kVar.f7029b, kVar.f7028a, singletonList, null, 0, null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            a aVar = new a();
            this.o = aVar;
            aVar.f(sVar);
            return true;
        } else if (!n(bArr)) {
            return true;
        } else {
            a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.i(j2);
                bVar.f5379b = this.o;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
