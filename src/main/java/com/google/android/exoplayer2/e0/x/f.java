package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.audio.g;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;

/* compiled from: Ac3Reader */
public final class f implements l {

    /* renamed from: a  reason: collision with root package name */
    private final r f5456a;

    /* renamed from: b  reason: collision with root package name */
    private final s f5457b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5458c;

    /* renamed from: d  reason: collision with root package name */
    private String f5459d;

    /* renamed from: e  reason: collision with root package name */
    private q f5460e;

    /* renamed from: f  reason: collision with root package name */
    private int f5461f;

    /* renamed from: g  reason: collision with root package name */
    private int f5462g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5463h;

    /* renamed from: i  reason: collision with root package name */
    private long f5464i;

    /* renamed from: j  reason: collision with root package name */
    private l f5465j;

    /* renamed from: k  reason: collision with root package name */
    private int f5466k;
    private long l;

    public f() {
        this(null);
    }

    private boolean b(s sVar, byte[] bArr, int i2) {
        int min = Math.min(sVar.a(), i2 - this.f5462g);
        sVar.h(bArr, this.f5462g, min);
        int i3 = this.f5462g + min;
        this.f5462g = i3;
        return i3 == i2;
    }

    private void g() {
        this.f5456a.n(0);
        g.b e2 = g.e(this.f5456a);
        l lVar = this.f5465j;
        if (!(lVar != null && e2.f4775c == lVar.u && e2.f4774b == lVar.v && e2.f4773a == lVar.f5977h)) {
            l t = l.t(this.f5459d, e2.f4773a, null, -1, -1, e2.f4775c, e2.f4774b, null, null, 0, this.f5458c);
            this.f5465j = t;
            this.f5460e.d(t);
        }
        this.f5466k = e2.f4776d;
        this.f5464i = (((long) e2.f4777e) * 1000000) / ((long) this.f5465j.v);
    }

    private boolean h(s sVar) {
        while (true) {
            boolean z = false;
            if (sVar.a() <= 0) {
                return false;
            }
            if (!this.f5463h) {
                if (sVar.y() == 11) {
                    z = true;
                }
                this.f5463h = z;
            } else {
                int y = sVar.y();
                if (y == 119) {
                    this.f5463h = false;
                    return true;
                }
                if (y == 11) {
                    z = true;
                }
                this.f5463h = z;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5461f = 0;
        this.f5462g = 0;
        this.f5463h = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5461f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(sVar.a(), this.f5466k - this.f5462g);
                        this.f5460e.a(sVar, min);
                        int i3 = this.f5462g + min;
                        this.f5462g = i3;
                        int i4 = this.f5466k;
                        if (i3 == i4) {
                            this.f5460e.c(this.l, 1, i4, 0, null);
                            this.l += this.f5464i;
                            this.f5461f = 0;
                        }
                    }
                } else if (b(sVar, this.f5457b.f7062a, 128)) {
                    g();
                    this.f5457b.K(0);
                    this.f5460e.a(this.f5457b, 128);
                    this.f5461f = 2;
                }
            } else if (h(sVar)) {
                this.f5461f = 1;
                byte[] bArr = this.f5457b.f7062a;
                bArr[0] = 11;
                bArr[1] = 119;
                this.f5462g = 2;
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
        this.f5459d = dVar.b();
        this.f5460e = iVar.a(dVar.c(), 1);
    }

    public f(String str) {
        r rVar = new r(new byte[128]);
        this.f5456a = rVar;
        this.f5457b = new s(rVar.f7058a);
        this.f5461f = 0;
        this.f5458c = str;
    }
}
