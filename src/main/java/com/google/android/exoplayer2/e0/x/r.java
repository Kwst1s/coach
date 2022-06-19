package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.m;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;

/* compiled from: MpegAudioReader */
public final class r implements l {

    /* renamed from: a  reason: collision with root package name */
    private final s f5598a;

    /* renamed from: b  reason: collision with root package name */
    private final m f5599b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5600c;

    /* renamed from: d  reason: collision with root package name */
    private String f5601d;

    /* renamed from: e  reason: collision with root package name */
    private q f5602e;

    /* renamed from: f  reason: collision with root package name */
    private int f5603f;

    /* renamed from: g  reason: collision with root package name */
    private int f5604g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5605h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5606i;

    /* renamed from: j  reason: collision with root package name */
    private long f5607j;

    /* renamed from: k  reason: collision with root package name */
    private int f5608k;
    private long l;

    public r() {
        this(null);
    }

    private void b(s sVar) {
        byte[] bArr = sVar.f7062a;
        int d2 = sVar.d();
        for (int c2 = sVar.c(); c2 < d2; c2++) {
            boolean z = (bArr[c2] & 255) == 255;
            boolean z2 = this.f5606i && (bArr[c2] & 224) == 224;
            this.f5606i = z;
            if (z2) {
                sVar.K(c2 + 1);
                this.f5606i = false;
                this.f5598a.f7062a[1] = bArr[c2];
                this.f5604g = 2;
                this.f5603f = 1;
                return;
            }
        }
        sVar.K(d2);
    }

    private void g(s sVar) {
        int min = Math.min(sVar.a(), this.f5608k - this.f5604g);
        this.f5602e.a(sVar, min);
        int i2 = this.f5604g + min;
        this.f5604g = i2;
        int i3 = this.f5608k;
        if (i2 >= i3) {
            this.f5602e.c(this.l, 1, i3, 0, null);
            this.l += this.f5607j;
            this.f5604g = 0;
            this.f5603f = 0;
        }
    }

    private void h(s sVar) {
        int min = Math.min(sVar.a(), 4 - this.f5604g);
        sVar.h(this.f5598a.f7062a, this.f5604g, min);
        int i2 = this.f5604g + min;
        this.f5604g = i2;
        if (i2 >= 4) {
            this.f5598a.K(0);
            if (!m.b(this.f5598a.j(), this.f5599b)) {
                this.f5604g = 0;
                this.f5603f = 1;
                return;
            }
            m mVar = this.f5599b;
            this.f5608k = mVar.f5090c;
            if (!this.f5605h) {
                int i3 = mVar.f5091d;
                this.f5607j = (((long) mVar.f5094g) * 1000000) / ((long) i3);
                this.f5602e.d(l.t(this.f5601d, mVar.f5089b, null, -1, 4096, mVar.f5092e, i3, null, null, 0, this.f5600c));
                this.f5605h = true;
            }
            this.f5598a.K(0);
            this.f5602e.a(this.f5598a, 4);
            this.f5603f = 2;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5603f = 0;
        this.f5604g = 0;
        this.f5606i = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5603f;
            if (i2 == 0) {
                b(sVar);
            } else if (i2 == 1) {
                h(sVar);
            } else if (i2 == 2) {
                g(sVar);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        this.l = j2;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        this.f5601d = dVar.b();
        this.f5602e = iVar.a(dVar.c(), 1);
    }

    public r(String str) {
        this.f5603f = 0;
        s sVar = new s(4);
        this.f5598a = sVar;
        sVar.f7062a[0] = -1;
        this.f5599b = new m();
        this.f5600c = str;
    }
}
