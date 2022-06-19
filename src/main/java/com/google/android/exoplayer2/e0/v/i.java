package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: StreamReader */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private final e f5367a = new e();

    /* renamed from: b  reason: collision with root package name */
    private q f5368b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.exoplayer2.e0.i f5369c;

    /* renamed from: d  reason: collision with root package name */
    private g f5370d;

    /* renamed from: e  reason: collision with root package name */
    private long f5371e;

    /* renamed from: f  reason: collision with root package name */
    private long f5372f;

    /* renamed from: g  reason: collision with root package name */
    private long f5373g;

    /* renamed from: h  reason: collision with root package name */
    private int f5374h;

    /* renamed from: i  reason: collision with root package name */
    private int f5375i;

    /* renamed from: j  reason: collision with root package name */
    private b f5376j;

    /* renamed from: k  reason: collision with root package name */
    private long f5377k;
    private boolean l;
    private boolean m;

    /* access modifiers changed from: package-private */
    /* compiled from: StreamReader */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        l f5378a;

        /* renamed from: b  reason: collision with root package name */
        g f5379b;

        b() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: StreamReader */
    public static final class c implements g {
        private c() {
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public long a(h hVar) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public o c() {
            return new o.b(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.e0.v.g
        public long e(long j2) {
            return 0;
        }
    }

    private int g(h hVar) {
        boolean z = true;
        while (z) {
            if (!this.f5367a.d(hVar)) {
                this.f5374h = 3;
                return -1;
            }
            this.f5377k = hVar.l() - this.f5372f;
            z = h(this.f5367a.c(), this.f5372f, this.f5376j);
            if (z) {
                this.f5372f = hVar.l();
            }
        }
        l lVar = this.f5376j.f5378a;
        this.f5375i = lVar.v;
        if (!this.m) {
            this.f5368b.d(lVar);
            this.m = true;
        }
        g gVar = this.f5376j.f5379b;
        if (gVar != null) {
            this.f5370d = gVar;
        } else if (hVar.d() == -1) {
            this.f5370d = new c();
        } else {
            f b2 = this.f5367a.b();
            this.f5370d = new b(this.f5372f, hVar.d(), this, (long) (b2.f5363e + b2.f5364f), b2.f5361c, (b2.f5360b & 4) != 0);
        }
        this.f5376j = null;
        this.f5374h = 2;
        this.f5367a.f();
        return 0;
    }

    private int i(h hVar, n nVar) {
        long a2 = this.f5370d.a(hVar);
        if (a2 >= 0) {
            nVar.f5095a = a2;
            return 1;
        }
        if (a2 < -1) {
            d(-(a2 + 2));
        }
        if (!this.l) {
            this.f5369c.e(this.f5370d.c());
            this.l = true;
        }
        if (this.f5377k > 0 || this.f5367a.d(hVar)) {
            this.f5377k = 0;
            s c2 = this.f5367a.c();
            long e2 = e(c2);
            if (e2 >= 0) {
                long j2 = this.f5373g;
                if (j2 + e2 >= this.f5371e) {
                    long a3 = a(j2);
                    this.f5368b.a(c2, c2.d());
                    this.f5368b.c(a3, 1, c2.d(), 0, null);
                    this.f5371e = -1;
                }
            }
            this.f5373g += e2;
            return 0;
        }
        this.f5374h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long a(long j2) {
        return (j2 * 1000000) / ((long) this.f5375i);
    }

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (((long) this.f5375i) * j2) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public void c(com.google.android.exoplayer2.e0.i iVar, q qVar) {
        this.f5369c = iVar;
        this.f5368b = qVar;
        j(true);
    }

    /* access modifiers changed from: protected */
    public void d(long j2) {
        this.f5373g = j2;
    }

    /* access modifiers changed from: protected */
    public abstract long e(s sVar);

    /* access modifiers changed from: package-private */
    public final int f(h hVar, n nVar) {
        int i2 = this.f5374h;
        if (i2 == 0) {
            return g(hVar);
        }
        if (i2 == 1) {
            hVar.f((int) this.f5372f);
            this.f5374h = 2;
            return 0;
        } else if (i2 == 2) {
            return i(hVar, nVar);
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean h(s sVar, long j2, b bVar);

    /* access modifiers changed from: protected */
    public void j(boolean z) {
        if (z) {
            this.f5376j = new b();
            this.f5372f = 0;
            this.f5374h = 0;
        } else {
            this.f5374h = 1;
        }
        this.f5371e = -1;
        this.f5373g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void k(long j2, long j3) {
        this.f5367a.e();
        if (j2 == 0) {
            j(!this.l);
        } else if (this.f5374h != 0) {
            this.f5371e = this.f5370d.e(j3);
            this.f5374h = 2;
        }
    }
}
