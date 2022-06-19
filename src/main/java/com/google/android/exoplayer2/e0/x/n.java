package com.google.android.exoplayer2.e0.x;

import android.util.SparseArray;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: H264Reader */
public final class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private final z f5526a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5527b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5528c;

    /* renamed from: d  reason: collision with root package name */
    private final s f5529d = new s(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final s f5530e = new s(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final s f5531f = new s(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f5532g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f5533h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f5534i;

    /* renamed from: j  reason: collision with root package name */
    private q f5535j;

    /* renamed from: k  reason: collision with root package name */
    private b f5536k;
    private boolean l;
    private long m;
    private final s n = new s();

    /* access modifiers changed from: private */
    /* compiled from: H264Reader */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final q f5537a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5538b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f5539c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<q.b> f5540d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<q.a> f5541e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final t f5542f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f5543g;

        /* renamed from: h  reason: collision with root package name */
        private int f5544h;

        /* renamed from: i  reason: collision with root package name */
        private int f5545i;

        /* renamed from: j  reason: collision with root package name */
        private long f5546j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f5547k;
        private long l;
        private a m = new a();
        private a n = new a();
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        /* access modifiers changed from: private */
        /* compiled from: H264Reader */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f5548a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f5549b;

            /* renamed from: c  reason: collision with root package name */
            private q.b f5550c;

            /* renamed from: d  reason: collision with root package name */
            private int f5551d;

            /* renamed from: e  reason: collision with root package name */
            private int f5552e;

            /* renamed from: f  reason: collision with root package name */
            private int f5553f;

            /* renamed from: g  reason: collision with root package name */
            private int f5554g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f5555h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f5556i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f5557j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f5558k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private boolean c(a aVar) {
                boolean z;
                boolean z2;
                if (this.f5548a) {
                    if (!aVar.f5548a || this.f5553f != aVar.f5553f || this.f5554g != aVar.f5554g || this.f5555h != aVar.f5555h) {
                        return true;
                    }
                    if (this.f5556i && aVar.f5556i && this.f5557j != aVar.f5557j) {
                        return true;
                    }
                    int i2 = this.f5551d;
                    int i3 = aVar.f5551d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    int i4 = this.f5550c.f7057k;
                    if (i4 == 0 && aVar.f5550c.f7057k == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                        return true;
                    }
                    if ((i4 != 1 || aVar.f5550c.f7057k != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.f5558k) == (z2 = aVar.f5558k)) {
                        return z && z2 && this.l != aVar.l;
                    }
                    return true;
                }
            }

            public void b() {
                this.f5549b = false;
                this.f5548a = false;
            }

            public boolean d() {
                int i2;
                return this.f5549b && ((i2 = this.f5552e) == 7 || i2 == 2);
            }

            public void e(q.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f5550c = bVar;
                this.f5551d = i2;
                this.f5552e = i3;
                this.f5553f = i4;
                this.f5554g = i5;
                this.f5555h = z;
                this.f5556i = z2;
                this.f5557j = z3;
                this.f5558k = z4;
                this.l = i6;
                this.m = i7;
                this.n = i8;
                this.o = i9;
                this.p = i10;
                this.f5548a = true;
                this.f5549b = true;
            }

            public void f(int i2) {
                this.f5552e = i2;
                this.f5549b = true;
            }
        }

        public b(com.google.android.exoplayer2.e0.q qVar, boolean z, boolean z2) {
            this.f5537a = qVar;
            this.f5538b = z;
            this.f5539c = z2;
            byte[] bArr = new byte[128];
            this.f5543g = bArr;
            this.f5542f = new t(bArr, 0, 0);
            g();
        }

        private void d(int i2) {
            boolean z = this.r;
            this.f5537a.c(this.q, z ? 1 : 0, (int) (this.f5546j - this.p), i2, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x014e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
            // Method dump skipped, instructions count: 408
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.x.n.b.a(byte[], int, int):void");
        }

        public void b(long j2, int i2) {
            boolean z = false;
            if (this.f5545i == 9 || (this.f5539c && this.n.c(this.m))) {
                if (this.o) {
                    d(i2 + ((int) (j2 - this.f5546j)));
                }
                this.p = this.f5546j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i3 = this.f5545i;
            if (i3 == 5 || (this.f5538b && i3 == 1 && this.n.d())) {
                z = true;
            }
            this.r = z2 | z;
        }

        public boolean c() {
            return this.f5539c;
        }

        public void e(q.a aVar) {
            this.f5541e.append(aVar.f7044a, aVar);
        }

        public void f(q.b bVar) {
            this.f5540d.append(bVar.f7050d, bVar);
        }

        public void g() {
            this.f5547k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j2, int i2, long j3) {
            this.f5545i = i2;
            this.l = j3;
            this.f5546j = j2;
            if (!this.f5538b || i2 != 1) {
                if (!this.f5539c) {
                    return;
                }
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.f5544h = 0;
            this.f5547k = true;
        }
    }

    public n(z zVar, boolean z, boolean z2) {
        this.f5526a = zVar;
        this.f5527b = z;
        this.f5528c = z2;
    }

    private void b(long j2, int i2, int i3, long j3) {
        if (!this.l || this.f5536k.c()) {
            this.f5529d.b(i3);
            this.f5530e.b(i3);
            if (!this.l) {
                if (this.f5529d.c() && this.f5530e.c()) {
                    ArrayList arrayList = new ArrayList();
                    s sVar = this.f5529d;
                    arrayList.add(Arrays.copyOf(sVar.f5612d, sVar.f5613e));
                    s sVar2 = this.f5530e;
                    arrayList.add(Arrays.copyOf(sVar2.f5612d, sVar2.f5613e));
                    s sVar3 = this.f5529d;
                    q.b i4 = com.google.android.exoplayer2.util.q.i(sVar3.f5612d, 3, sVar3.f5613e);
                    s sVar4 = this.f5530e;
                    q.a h2 = com.google.android.exoplayer2.util.q.h(sVar4.f5612d, 3, sVar4.f5613e);
                    this.f5535j.d(l.F(this.f5534i, "video/avc", g.c(i4.f7047a, i4.f7048b, i4.f7049c), -1, -1, i4.f7051e, i4.f7052f, -1.0f, arrayList, -1, i4.f7053g, null));
                    this.l = true;
                    this.f5536k.f(i4);
                    this.f5536k.e(h2);
                    this.f5529d.d();
                    this.f5530e.d();
                }
            } else if (this.f5529d.c()) {
                s sVar5 = this.f5529d;
                this.f5536k.f(com.google.android.exoplayer2.util.q.i(sVar5.f5612d, 3, sVar5.f5613e));
                this.f5529d.d();
            } else if (this.f5530e.c()) {
                s sVar6 = this.f5530e;
                this.f5536k.e(com.google.android.exoplayer2.util.q.h(sVar6.f5612d, 3, sVar6.f5613e));
                this.f5530e.d();
            }
        }
        if (this.f5531f.b(i3)) {
            s sVar7 = this.f5531f;
            this.n.I(this.f5531f.f5612d, com.google.android.exoplayer2.util.q.k(sVar7.f5612d, sVar7.f5613e));
            this.n.K(4);
            this.f5526a.a(j3, this.n);
        }
        this.f5536k.b(j2, i2);
    }

    private void g(byte[] bArr, int i2, int i3) {
        if (!this.l || this.f5536k.c()) {
            this.f5529d.a(bArr, i2, i3);
            this.f5530e.a(bArr, i2, i3);
        }
        this.f5531f.a(bArr, i2, i3);
        this.f5536k.a(bArr, i2, i3);
    }

    private void h(long j2, int i2, long j3) {
        if (!this.l || this.f5536k.c()) {
            this.f5529d.e(i2);
            this.f5530e.e(i2);
        }
        this.f5531f.e(i2);
        this.f5536k.h(j2, i2, j3);
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        com.google.android.exoplayer2.util.q.a(this.f5533h);
        this.f5529d.d();
        this.f5530e.d();
        this.f5531f.d();
        this.f5536k.g();
        this.f5532g = 0;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        int c2 = sVar.c();
        int d2 = sVar.d();
        byte[] bArr = sVar.f7062a;
        this.f5532g += (long) sVar.a();
        this.f5535j.a(sVar, sVar.a());
        while (true) {
            int c3 = com.google.android.exoplayer2.util.q.c(bArr, c2, d2, this.f5533h);
            if (c3 == d2) {
                g(bArr, c2, d2);
                return;
            }
            int f2 = com.google.android.exoplayer2.util.q.f(bArr, c3);
            int i2 = c3 - c2;
            if (i2 > 0) {
                g(bArr, c2, c3);
            }
            int i3 = d2 - c3;
            long j2 = this.f5532g - ((long) i3);
            b(j2, i3, i2 < 0 ? -i2 : 0, this.m);
            h(j2, f2, this.m);
            c2 = c3 + 3;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        this.m = j2;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        this.f5534i = dVar.b();
        com.google.android.exoplayer2.e0.q a2 = iVar.a(dVar.c(), 2);
        this.f5535j = a2;
        this.f5536k = new b(a2, this.f5527b, this.f5528c);
        this.f5526a.b(iVar, dVar);
    }
}
