package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;

/* compiled from: PesReader */
public final class t implements e0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f5614a;

    /* renamed from: b  reason: collision with root package name */
    private final r f5615b = new r(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f5616c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f5617d;

    /* renamed from: e  reason: collision with root package name */
    private a0 f5618e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5619f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5620g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5621h;

    /* renamed from: i  reason: collision with root package name */
    private int f5622i;

    /* renamed from: j  reason: collision with root package name */
    private int f5623j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5624k;
    private long l;

    public t(l lVar) {
        this.f5614a = lVar;
    }

    private boolean d(s sVar, byte[] bArr, int i2) {
        int min = Math.min(sVar.a(), i2 - this.f5617d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            sVar.L(min);
        } else {
            sVar.h(bArr, this.f5617d, min);
        }
        int i3 = this.f5617d + min;
        this.f5617d = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    private boolean e() {
        this.f5615b.n(0);
        int h2 = this.f5615b.h(24);
        if (h2 != 1) {
            m.f("PesReader", "Unexpected start code prefix: " + h2);
            this.f5623j = -1;
            return false;
        }
        this.f5615b.p(8);
        int h3 = this.f5615b.h(16);
        this.f5615b.p(5);
        this.f5624k = this.f5615b.g();
        this.f5615b.p(2);
        this.f5619f = this.f5615b.g();
        this.f5620g = this.f5615b.g();
        this.f5615b.p(6);
        int h4 = this.f5615b.h(8);
        this.f5622i = h4;
        if (h3 == 0) {
            this.f5623j = -1;
        } else {
            this.f5623j = ((h3 + 6) - 9) - h4;
        }
        return true;
    }

    private void f() {
        this.f5615b.n(0);
        this.l = -9223372036854775807L;
        if (this.f5619f) {
            this.f5615b.p(4);
            this.f5615b.p(1);
            this.f5615b.p(1);
            long h2 = (((long) this.f5615b.h(3)) << 30) | ((long) (this.f5615b.h(15) << 15)) | ((long) this.f5615b.h(15));
            this.f5615b.p(1);
            if (!this.f5621h && this.f5620g) {
                this.f5615b.p(4);
                this.f5615b.p(1);
                this.f5615b.p(1);
                this.f5615b.p(1);
                this.f5618e.b((((long) this.f5615b.h(3)) << 30) | ((long) (this.f5615b.h(15) << 15)) | ((long) this.f5615b.h(15)));
                this.f5621h = true;
            }
            this.l = this.f5618e.b(h2);
        }
    }

    private void g(int i2) {
        this.f5616c = i2;
        this.f5617d = 0;
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public final void a() {
        this.f5616c = 0;
        this.f5617d = 0;
        this.f5621h = false;
        this.f5614a.a();
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public void b(a0 a0Var, i iVar, e0.d dVar) {
        this.f5618e = a0Var;
        this.f5614a.f(iVar, dVar);
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public final void c(s sVar, boolean z) {
        if (z) {
            int i2 = this.f5616c;
            if (!(i2 == 0 || i2 == 1)) {
                if (i2 == 2) {
                    m.f("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.f5623j != -1) {
                        m.f("PesReader", "Unexpected start indicator: expected " + this.f5623j + " more bytes");
                    }
                    this.f5614a.e();
                } else {
                    throw new IllegalStateException();
                }
            }
            g(1);
        }
        while (sVar.a() > 0) {
            int i3 = this.f5616c;
            if (i3 != 0) {
                int i4 = 0;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (d(sVar, this.f5615b.f7058a, Math.min(10, this.f5622i)) && d(sVar, null, this.f5622i)) {
                            f();
                            this.f5614a.d(this.l, this.f5624k);
                            g(3);
                        }
                    } else if (i3 == 3) {
                        int a2 = sVar.a();
                        int i5 = this.f5623j;
                        if (i5 != -1) {
                            i4 = a2 - i5;
                        }
                        if (i4 > 0) {
                            a2 -= i4;
                            sVar.J(sVar.c() + a2);
                        }
                        this.f5614a.c(sVar);
                        int i6 = this.f5623j;
                        if (i6 != -1) {
                            int i7 = i6 - a2;
                            this.f5623j = i7;
                            if (i7 == 0) {
                                this.f5614a.e();
                                g(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (d(sVar, this.f5615b.f7058a, 9)) {
                    if (e()) {
                        i4 = 2;
                    }
                    g(i4);
                }
            } else {
                sVar.L(sVar.a());
            }
        }
    }
}
