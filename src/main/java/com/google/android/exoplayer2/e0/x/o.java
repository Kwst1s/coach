package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import java.util.Collections;

/* compiled from: H265Reader */
public final class o implements l {

    /* renamed from: a  reason: collision with root package name */
    private final z f5559a;

    /* renamed from: b  reason: collision with root package name */
    private String f5560b;

    /* renamed from: c  reason: collision with root package name */
    private q f5561c;

    /* renamed from: d  reason: collision with root package name */
    private a f5562d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5563e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f5564f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final s f5565g = new s(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final s f5566h = new s(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final s f5567i = new s(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final s f5568j = new s(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final s f5569k = new s(40, 128);
    private long l;
    private long m;
    private final s n = new s();

    /* access modifiers changed from: private */
    /* compiled from: H265Reader */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final q f5570a;

        /* renamed from: b  reason: collision with root package name */
        private long f5571b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5572c;

        /* renamed from: d  reason: collision with root package name */
        private int f5573d;

        /* renamed from: e  reason: collision with root package name */
        private long f5574e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5575f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5576g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f5577h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5578i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5579j;

        /* renamed from: k  reason: collision with root package name */
        private long f5580k;
        private long l;
        private boolean m;

        public a(q qVar) {
            this.f5570a = qVar;
        }

        private void b(int i2) {
            boolean z = this.m;
            this.f5570a.c(this.l, z ? 1 : 0, (int) (this.f5571b - this.f5580k), i2, null);
        }

        public void a(long j2, int i2) {
            if (this.f5579j && this.f5576g) {
                this.m = this.f5572c;
                this.f5579j = false;
            } else if (this.f5577h || this.f5576g) {
                if (this.f5578i) {
                    b(i2 + ((int) (j2 - this.f5571b)));
                }
                this.f5580k = this.f5571b;
                this.l = this.f5574e;
                this.f5578i = true;
                this.m = this.f5572c;
            }
        }

        public void c(byte[] bArr, int i2, int i3) {
            if (this.f5575f) {
                int i4 = this.f5573d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f5576g = (bArr[i5] & 128) != 0;
                    this.f5575f = false;
                    return;
                }
                this.f5573d = i4 + (i3 - i2);
            }
        }

        public void d() {
            this.f5575f = false;
            this.f5576g = false;
            this.f5577h = false;
            this.f5578i = false;
            this.f5579j = false;
        }

        public void e(long j2, int i2, int i3, long j3) {
            boolean z = false;
            this.f5576g = false;
            this.f5577h = false;
            this.f5574e = j3;
            this.f5573d = 0;
            this.f5571b = j2;
            if (i3 >= 32) {
                if (!this.f5579j && this.f5578i) {
                    b(i2);
                    this.f5578i = false;
                }
                if (i3 <= 34) {
                    this.f5577h = !this.f5579j;
                    this.f5579j = true;
                }
            }
            boolean z2 = i3 >= 16 && i3 <= 21;
            this.f5572c = z2;
            if (z2 || i3 <= 9) {
                z = true;
            }
            this.f5575f = z;
        }
    }

    public o(z zVar) {
        this.f5559a = zVar;
    }

    private void b(long j2, int i2, int i3, long j3) {
        if (this.f5563e) {
            this.f5562d.a(j2, i2);
        } else {
            this.f5565g.b(i3);
            this.f5566h.b(i3);
            this.f5567i.b(i3);
            if (this.f5565g.c() && this.f5566h.c() && this.f5567i.c()) {
                this.f5561c.d(h(this.f5560b, this.f5565g, this.f5566h, this.f5567i));
                this.f5563e = true;
            }
        }
        if (this.f5568j.b(i3)) {
            s sVar = this.f5568j;
            this.n.I(this.f5568j.f5612d, com.google.android.exoplayer2.util.q.k(sVar.f5612d, sVar.f5613e));
            this.n.L(5);
            this.f5559a.a(j3, this.n);
        }
        if (this.f5569k.b(i3)) {
            s sVar2 = this.f5569k;
            this.n.I(this.f5569k.f5612d, com.google.android.exoplayer2.util.q.k(sVar2.f5612d, sVar2.f5613e));
            this.n.L(5);
            this.f5559a.a(j3, this.n);
        }
    }

    private void g(byte[] bArr, int i2, int i3) {
        if (this.f5563e) {
            this.f5562d.c(bArr, i2, i3);
        } else {
            this.f5565g.a(bArr, i2, i3);
            this.f5566h.a(bArr, i2, i3);
            this.f5567i.a(bArr, i2, i3);
        }
        this.f5568j.a(bArr, i2, i3);
        this.f5569k.a(bArr, i2, i3);
    }

    private static l h(String str, s sVar, s sVar2, s sVar3) {
        float f2;
        int i2 = sVar.f5613e;
        byte[] bArr = new byte[(sVar2.f5613e + i2 + sVar3.f5613e)];
        System.arraycopy(sVar.f5612d, 0, bArr, 0, i2);
        System.arraycopy(sVar2.f5612d, 0, bArr, sVar.f5613e, sVar2.f5613e);
        System.arraycopy(sVar3.f5612d, 0, bArr, sVar.f5613e + sVar2.f5613e, sVar3.f5613e);
        t tVar = new t(sVar2.f5612d, 0, sVar2.f5613e);
        tVar.l(44);
        int e2 = tVar.e(3);
        tVar.k();
        tVar.l(88);
        tVar.l(8);
        int i3 = 0;
        for (int i4 = 0; i4 < e2; i4++) {
            if (tVar.d()) {
                i3 += 89;
            }
            if (tVar.d()) {
                i3 += 8;
            }
        }
        tVar.l(i3);
        if (e2 > 0) {
            tVar.l((8 - e2) * 2);
        }
        tVar.h();
        int h2 = tVar.h();
        if (h2 == 3) {
            tVar.k();
        }
        int h3 = tVar.h();
        int h4 = tVar.h();
        if (tVar.d()) {
            int h5 = tVar.h();
            int h6 = tVar.h();
            int h7 = tVar.h();
            int h8 = tVar.h();
            h3 -= ((h2 == 1 || h2 == 2) ? 2 : 1) * (h5 + h6);
            h4 -= (h2 == 1 ? 2 : 1) * (h7 + h8);
        }
        tVar.h();
        tVar.h();
        int h9 = tVar.h();
        for (int i5 = tVar.d() ? 0 : e2; i5 <= e2; i5++) {
            tVar.h();
            tVar.h();
            tVar.h();
        }
        tVar.h();
        tVar.h();
        tVar.h();
        tVar.h();
        tVar.h();
        tVar.h();
        if (tVar.d() && tVar.d()) {
            i(tVar);
        }
        tVar.l(2);
        if (tVar.d()) {
            tVar.l(8);
            tVar.h();
            tVar.h();
            tVar.k();
        }
        j(tVar);
        if (tVar.d()) {
            for (int i6 = 0; i6 < tVar.h(); i6++) {
                tVar.l(h9 + 4 + 1);
            }
        }
        tVar.l(2);
        float f3 = 1.0f;
        if (tVar.d() && tVar.d()) {
            int e3 = tVar.e(8);
            if (e3 == 255) {
                int e4 = tVar.e(16);
                int e5 = tVar.e(16);
                if (!(e4 == 0 || e5 == 0)) {
                    f3 = ((float) e4) / ((float) e5);
                }
                f2 = f3;
            } else {
                float[] fArr = com.google.android.exoplayer2.util.q.f7041b;
                if (e3 < fArr.length) {
                    f2 = fArr[e3];
                } else {
                    m.f("H265Reader", "Unexpected aspect_ratio_idc value: " + e3);
                }
            }
            return l.F(str, "video/hevc", null, -1, -1, h3, h4, -1.0f, Collections.singletonList(bArr), -1, f2, null);
        }
        f2 = 1.0f;
        return l.F(str, "video/hevc", null, -1, -1, h3, h4, -1.0f, Collections.singletonList(bArr), -1, f2, null);
    }

    private static void i(t tVar) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (!tVar.d()) {
                    tVar.h();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        tVar.g();
                    }
                    for (int i5 = 0; i5 < min; i5++) {
                        tVar.g();
                    }
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    private static void j(t tVar) {
        int h2 = tVar.h();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < h2; i3++) {
            if (i3 != 0) {
                z = tVar.d();
            }
            if (z) {
                tVar.k();
                tVar.h();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (tVar.d()) {
                        tVar.k();
                    }
                }
            } else {
                int h3 = tVar.h();
                int h4 = tVar.h();
                int i5 = h3 + h4;
                for (int i6 = 0; i6 < h3; i6++) {
                    tVar.h();
                    tVar.k();
                }
                for (int i7 = 0; i7 < h4; i7++) {
                    tVar.h();
                    tVar.k();
                }
                i2 = i5;
            }
        }
    }

    private void k(long j2, int i2, int i3, long j3) {
        if (this.f5563e) {
            this.f5562d.e(j2, i2, i3, j3);
        } else {
            this.f5565g.e(i3);
            this.f5566h.e(i3);
            this.f5567i.e(i3);
        }
        this.f5568j.e(i3);
        this.f5569k.e(i3);
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        com.google.android.exoplayer2.util.q.a(this.f5564f);
        this.f5565g.d();
        this.f5566h.d();
        this.f5567i.d();
        this.f5568j.d();
        this.f5569k.d();
        this.f5562d.d();
        this.l = 0;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int c2 = sVar.c();
            int d2 = sVar.d();
            byte[] bArr = sVar.f7062a;
            this.l += (long) sVar.a();
            this.f5561c.a(sVar, sVar.a());
            while (true) {
                if (c2 < d2) {
                    int c3 = com.google.android.exoplayer2.util.q.c(bArr, c2, d2, this.f5564f);
                    if (c3 == d2) {
                        g(bArr, c2, d2);
                        return;
                    }
                    int e2 = com.google.android.exoplayer2.util.q.e(bArr, c3);
                    int i2 = c3 - c2;
                    if (i2 > 0) {
                        g(bArr, c2, c3);
                    }
                    int i3 = d2 - c3;
                    long j2 = this.l - ((long) i3);
                    b(j2, i3, i2 < 0 ? -i2 : 0, this.m);
                    k(j2, i3, e2, this.m);
                    c2 = c3 + 3;
                }
            }
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
        this.f5560b = dVar.b();
        q a2 = iVar.a(dVar.c(), 2);
        this.f5561c = a2;
        this.f5562d = new a(a2);
        this.f5559a.b(iVar, dVar);
    }
}
