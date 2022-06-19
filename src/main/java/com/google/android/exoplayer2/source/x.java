package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.upstream.c;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* compiled from: SampleQueue */
public final class x implements q {

    /* renamed from: a  reason: collision with root package name */
    private final d f6639a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6640b;

    /* renamed from: c  reason: collision with root package name */
    private final w f6641c = new w();

    /* renamed from: d  reason: collision with root package name */
    private final w.a f6642d = new w.a();

    /* renamed from: e  reason: collision with root package name */
    private final s f6643e = new s(32);

    /* renamed from: f  reason: collision with root package name */
    private a f6644f;

    /* renamed from: g  reason: collision with root package name */
    private a f6645g;

    /* renamed from: h  reason: collision with root package name */
    private a f6646h;

    /* renamed from: i  reason: collision with root package name */
    private l f6647i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6648j;

    /* renamed from: k  reason: collision with root package name */
    private l f6649k;
    private long l;
    private long m;
    private boolean n;
    private b o;

    /* access modifiers changed from: private */
    /* compiled from: SampleQueue */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f6650a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6651b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6652c;

        /* renamed from: d  reason: collision with root package name */
        public c f6653d;

        /* renamed from: e  reason: collision with root package name */
        public a f6654e;

        public a(long j2, int i2) {
            this.f6650a = j2;
            this.f6651b = j2 + ((long) i2);
        }

        public a a() {
            this.f6653d = null;
            a aVar = this.f6654e;
            this.f6654e = null;
            return aVar;
        }

        public void b(c cVar, a aVar) {
            this.f6653d = cVar;
            this.f6654e = aVar;
            this.f6652c = true;
        }

        public int c(long j2) {
            return ((int) (j2 - this.f6650a)) + this.f6653d.f6908b;
        }
    }

    /* compiled from: SampleQueue */
    public interface b {
        void n(l lVar);
    }

    public x(d dVar) {
        this.f6639a = dVar;
        int e2 = dVar.e();
        this.f6640b = e2;
        a aVar = new a(0, e2);
        this.f6644f = aVar;
        this.f6645g = aVar;
        this.f6646h = aVar;
    }

    private void A(long j2, byte[] bArr, int i2) {
        e(j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f6645g.f6651b - j2));
            a aVar = this.f6645g;
            System.arraycopy(aVar.f6653d.f6907a, aVar.c(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            a aVar2 = this.f6645g;
            if (j2 == aVar2.f6651b) {
                this.f6645g = aVar2.f6654e;
            }
        }
    }

    private void B(e eVar, w.a aVar) {
        int i2;
        long j2 = aVar.f6637b;
        this.f6643e.H(1);
        A(j2, this.f6643e.f7062a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f6643e.f7062a[0];
        boolean z = (b2 & 128) != 0;
        int i3 = b2 & Byte.MAX_VALUE;
        com.google.android.exoplayer2.d0.b bVar = eVar.f4950c;
        if (bVar.f4929a == null) {
            bVar.f4929a = new byte[16];
        }
        A(j3, bVar.f4929a, i3);
        long j4 = j3 + ((long) i3);
        if (z) {
            this.f6643e.H(2);
            A(j4, this.f6643e.f7062a, 2);
            j4 += 2;
            i2 = this.f6643e.E();
        } else {
            i2 = 1;
        }
        com.google.android.exoplayer2.d0.b bVar2 = eVar.f4950c;
        int[] iArr = bVar2.f4932d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = bVar2.f4933e;
        if (iArr2 == null || iArr2.length < i2) {
            iArr2 = new int[i2];
        }
        if (z) {
            int i4 = i2 * 6;
            this.f6643e.H(i4);
            A(j4, this.f6643e.f7062a, i4);
            j4 += (long) i4;
            this.f6643e.K(0);
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i5] = this.f6643e.E();
                iArr2[i5] = this.f6643e.C();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.f6636a - ((int) (j4 - aVar.f6637b));
        }
        q.a aVar2 = aVar.f6638c;
        com.google.android.exoplayer2.d0.b bVar3 = eVar.f4950c;
        bVar3.c(i2, iArr, iArr2, aVar2.f5104b, bVar3.f4929a, aVar2.f5103a, aVar2.f5105c, aVar2.f5106d);
        long j5 = aVar.f6637b;
        int i6 = (int) (j4 - j5);
        aVar.f6637b = j5 + ((long) i6);
        aVar.f6636a -= i6;
    }

    private void e(long j2) {
        while (true) {
            a aVar = this.f6645g;
            if (j2 >= aVar.f6651b) {
                this.f6645g = aVar.f6654e;
            } else {
                return;
            }
        }
    }

    private void h(a aVar) {
        if (aVar.f6652c) {
            a aVar2 = this.f6646h;
            int i2 = (aVar2.f6652c ? 1 : 0) + (((int) (aVar2.f6650a - aVar.f6650a)) / this.f6640b);
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = aVar.f6653d;
                aVar = aVar.a();
            }
            this.f6639a.c(cVarArr);
        }
    }

    private void i(long j2) {
        a aVar;
        if (j2 != -1) {
            while (true) {
                aVar = this.f6644f;
                if (j2 < aVar.f6651b) {
                    break;
                }
                this.f6639a.b(aVar.f6653d);
                this.f6644f = this.f6644f.a();
            }
            if (this.f6645g.f6650a < aVar.f6650a) {
                this.f6645g = aVar;
            }
        }
    }

    private static l n(l lVar, long j2) {
        if (lVar == null) {
            return null;
        }
        if (j2 == 0) {
            return lVar;
        }
        long j3 = lVar.l;
        return j3 != Long.MAX_VALUE ? lVar.p(j3 + j2) : lVar;
    }

    private void w(int i2) {
        long j2 = this.m + ((long) i2);
        this.m = j2;
        a aVar = this.f6646h;
        if (j2 == aVar.f6651b) {
            this.f6646h = aVar.f6654e;
        }
    }

    private int x(int i2) {
        a aVar = this.f6646h;
        if (!aVar.f6652c) {
            aVar.b(this.f6639a.d(), new a(this.f6646h.f6651b, this.f6640b));
        }
        return Math.min(i2, (int) (this.f6646h.f6651b - this.m));
    }

    private void z(long j2, ByteBuffer byteBuffer, int i2) {
        e(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.f6645g.f6651b - j2));
            a aVar = this.f6645g;
            byteBuffer.put(aVar.f6653d.f6907a, aVar.c(j2), min);
            i2 -= min;
            j2 += (long) min;
            a aVar2 = this.f6645g;
            if (j2 == aVar2.f6651b) {
                this.f6645g = aVar2.f6654e;
            }
        }
    }

    public void C() {
        D(false);
    }

    public void D(boolean z) {
        this.f6641c.x(z);
        h(this.f6644f);
        a aVar = new a(0, this.f6640b);
        this.f6644f = aVar;
        this.f6645g = aVar;
        this.f6646h = aVar;
        this.m = 0;
        this.f6639a.a();
    }

    public void E() {
        this.f6641c.y();
        this.f6645g = this.f6644f;
    }

    public boolean F(int i2) {
        return this.f6641c.z(i2);
    }

    public void G(long j2) {
        if (this.l != j2) {
            this.l = j2;
            this.f6648j = true;
        }
    }

    public void H(b bVar) {
        this.o = bVar;
    }

    public void I(int i2) {
        this.f6641c.A(i2);
    }

    public void J() {
        this.n = true;
    }

    @Override // com.google.android.exoplayer2.e0.q
    public void a(s sVar, int i2) {
        while (i2 > 0) {
            int x = x(i2);
            a aVar = this.f6646h;
            sVar.h(aVar.f6653d.f6907a, aVar.c(this.m), x);
            i2 -= x;
            w(x);
        }
    }

    @Override // com.google.android.exoplayer2.e0.q
    public int b(h hVar, int i2, boolean z) {
        int x = x(i2);
        a aVar = this.f6646h;
        int a2 = hVar.a(aVar.f6653d.f6907a, aVar.c(this.m), x);
        if (a2 != -1) {
            w(a2);
            return a2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    @Override // com.google.android.exoplayer2.e0.q
    public void c(long j2, int i2, int i3, int i4, q.a aVar) {
        if (this.f6648j) {
            d(this.f6649k);
        }
        long j3 = j2 + this.l;
        if (this.n) {
            if ((i2 & 1) != 0 && this.f6641c.c(j3)) {
                this.n = false;
            } else {
                return;
            }
        }
        this.f6641c.d(j3, i2, (this.m - ((long) i3)) - ((long) i4), i3, aVar);
    }

    @Override // com.google.android.exoplayer2.e0.q
    public void d(l lVar) {
        l n2 = n(lVar, this.l);
        boolean l2 = this.f6641c.l(n2);
        this.f6649k = lVar;
        this.f6648j = false;
        b bVar = this.o;
        if (bVar != null && l2) {
            bVar.n(n2);
        }
    }

    public int f(long j2, boolean z, boolean z2) {
        return this.f6641c.a(j2, z, z2);
    }

    public int g() {
        return this.f6641c.b();
    }

    public void j(long j2, boolean z, boolean z2) {
        i(this.f6641c.g(j2, z, z2));
    }

    public void k() {
        i(this.f6641c.h());
    }

    public void l() {
        i(this.f6641c.i());
    }

    public void m(int i2) {
        long j2 = this.f6641c.j(i2);
        this.m = j2;
        if (j2 != 0) {
            a aVar = this.f6644f;
            if (j2 != aVar.f6650a) {
                while (this.m > aVar.f6651b) {
                    aVar = aVar.f6654e;
                }
                a aVar2 = aVar.f6654e;
                h(aVar2);
                a aVar3 = new a(aVar.f6651b, this.f6640b);
                aVar.f6654e = aVar3;
                if (this.m == aVar.f6651b) {
                    aVar = aVar3;
                }
                this.f6646h = aVar;
                if (this.f6645g == aVar2) {
                    this.f6645g = aVar3;
                    return;
                }
                return;
            }
        }
        h(this.f6644f);
        a aVar4 = new a(this.m, this.f6640b);
        this.f6644f = aVar4;
        this.f6645g = aVar4;
        this.f6646h = aVar4;
    }

    public int o() {
        return this.f6641c.m();
    }

    public long p() {
        return this.f6641c.n();
    }

    public long q() {
        return this.f6641c.o();
    }

    public int r() {
        return this.f6641c.q();
    }

    public l s() {
        return this.f6641c.s();
    }

    public int t() {
        return this.f6641c.t();
    }

    public boolean u() {
        return this.f6641c.u();
    }

    public int v() {
        return this.f6641c.v();
    }

    public int y(m mVar, e eVar, boolean z, boolean z2, long j2) {
        int w = this.f6641c.w(mVar, eVar, z, z2, this.f6647i, this.f6642d);
        if (w == -5) {
            this.f6647i = mVar.f5981a;
            return -5;
        } else if (w == -4) {
            if (!eVar.j()) {
                if (eVar.f4952e < j2) {
                    eVar.e(Integer.MIN_VALUE);
                }
                if (eVar.p()) {
                    B(eVar, this.f6642d);
                }
                eVar.n(this.f6642d.f6636a);
                w.a aVar = this.f6642d;
                z(aVar.f6637b, eVar.f4951d, aVar.f6636a);
            }
            return -4;
        } else if (w == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }
}
