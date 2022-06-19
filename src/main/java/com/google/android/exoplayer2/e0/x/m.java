package com.google.android.exoplayer2.e0.x;

import android.util.Pair;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;

/* compiled from: H262Reader */
public final class m implements l {
    private static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f5510a;

    /* renamed from: b  reason: collision with root package name */
    private q f5511b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5512c;

    /* renamed from: d  reason: collision with root package name */
    private long f5513d;

    /* renamed from: e  reason: collision with root package name */
    private final g0 f5514e;

    /* renamed from: f  reason: collision with root package name */
    private final s f5515f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean[] f5516g;

    /* renamed from: h  reason: collision with root package name */
    private final a f5517h;

    /* renamed from: i  reason: collision with root package name */
    private final s f5518i;

    /* renamed from: j  reason: collision with root package name */
    private long f5519j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5520k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;

    /* access modifiers changed from: private */
    /* compiled from: H262Reader */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static final byte[] f5521e = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f5522a;

        /* renamed from: b  reason: collision with root package name */
        public int f5523b;

        /* renamed from: c  reason: collision with root package name */
        public int f5524c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f5525d;

        public a(int i2) {
            this.f5525d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f5522a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f5525d;
                int length = bArr2.length;
                int i5 = this.f5523b;
                if (length < i5 + i4) {
                    this.f5525d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f5525d, this.f5523b, i4);
                this.f5523b += i4;
            }
        }

        public boolean b(int i2, int i3) {
            if (this.f5522a) {
                int i4 = this.f5523b - i3;
                this.f5523b = i4;
                if (this.f5524c == 0 && i2 == 181) {
                    this.f5524c = i4;
                } else {
                    this.f5522a = false;
                    return true;
                }
            } else if (i2 == 179) {
                this.f5522a = true;
            }
            byte[] bArr = f5521e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f5522a = false;
            this.f5523b = 0;
            this.f5524c = 0;
        }
    }

    public m() {
        this(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.l, java.lang.Long> b(com.google.android.exoplayer2.e0.x.m.a r20, java.lang.String r21) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.x.m.b(com.google.android.exoplayer2.e0.x.m$a, java.lang.String):android.util.Pair");
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        com.google.android.exoplayer2.util.q.a(this.f5516g);
        this.f5517h.c();
        if (this.f5514e != null) {
            this.f5518i.d();
        }
        this.f5519j = 0;
        this.f5520k = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        int i2;
        int c2 = sVar.c();
        int d2 = sVar.d();
        byte[] bArr = sVar.f7062a;
        this.f5519j += (long) sVar.a();
        this.f5511b.a(sVar, sVar.a());
        while (true) {
            int c3 = com.google.android.exoplayer2.util.q.c(bArr, c2, d2, this.f5516g);
            if (c3 == d2) {
                break;
            }
            int i3 = c3 + 3;
            int i4 = sVar.f7062a[i3] & 255;
            int i5 = c3 - c2;
            boolean z = false;
            if (!this.f5512c) {
                if (i5 > 0) {
                    this.f5517h.a(bArr, c2, c3);
                }
                if (this.f5517h.b(i4, i5 < 0 ? -i5 : 0)) {
                    Pair<l, Long> b2 = b(this.f5517h, this.f5510a);
                    this.f5511b.d((l) b2.first);
                    this.f5513d = ((Long) b2.second).longValue();
                    this.f5512c = true;
                }
            }
            if (this.f5514e != null) {
                if (i5 > 0) {
                    this.f5518i.a(bArr, c2, c3);
                    i2 = 0;
                } else {
                    i2 = -i5;
                }
                if (this.f5518i.b(i2)) {
                    s sVar2 = this.f5518i;
                    this.f5515f.I(this.f5518i.f5612d, com.google.android.exoplayer2.util.q.k(sVar2.f5612d, sVar2.f5613e));
                    this.f5514e.a(this.n, this.f5515f);
                }
                if (i4 == 178 && sVar.f7062a[c3 + 2] == 1) {
                    this.f5518i.e(i4);
                }
            }
            if (i4 == 0 || i4 == 179) {
                int i6 = d2 - c3;
                if (this.f5520k && this.p && this.f5512c) {
                    this.f5511b.c(this.n, this.o ? 1 : 0, ((int) (this.f5519j - this.m)) - i6, i6, null);
                }
                boolean z2 = this.f5520k;
                if (!z2 || this.p) {
                    this.m = this.f5519j - ((long) i6);
                    long j2 = this.l;
                    if (j2 == -9223372036854775807L) {
                        j2 = z2 ? this.n + this.f5513d : 0;
                    }
                    this.n = j2;
                    this.o = false;
                    this.l = -9223372036854775807L;
                    this.f5520k = true;
                }
                if (i4 == 0) {
                    z = true;
                }
                this.p = z;
            } else if (i4 == 184) {
                this.o = true;
            }
            c2 = i3;
        }
        if (!this.f5512c) {
            this.f5517h.a(bArr, c2, d2);
        }
        if (this.f5514e != null) {
            this.f5518i.a(bArr, c2, d2);
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
        this.f5510a = dVar.b();
        this.f5511b = iVar.a(dVar.c(), 2);
        g0 g0Var = this.f5514e;
        if (g0Var != null) {
            g0Var.b(iVar, dVar);
        }
    }

    public m(g0 g0Var) {
        this.f5514e = g0Var;
        this.f5516g = new boolean[4];
        this.f5517h = new a(128);
        if (g0Var != null) {
            this.f5518i = new s(178, 128);
            this.f5515f = new s();
            return;
        }
        this.f5518i = null;
        this.f5515f = null;
    }
}
