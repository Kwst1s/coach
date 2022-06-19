package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* compiled from: SectionReader */
public final class y implements e0 {

    /* renamed from: a  reason: collision with root package name */
    private final x f5654a;

    /* renamed from: b  reason: collision with root package name */
    private final s f5655b = new s(32);

    /* renamed from: c  reason: collision with root package name */
    private int f5656c;

    /* renamed from: d  reason: collision with root package name */
    private int f5657d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5658e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5659f;

    public y(x xVar) {
        this.f5654a = xVar;
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public void a() {
        this.f5659f = true;
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public void b(a0 a0Var, i iVar, e0.d dVar) {
        this.f5654a.b(a0Var, iVar, dVar);
        this.f5659f = true;
    }

    @Override // com.google.android.exoplayer2.e0.x.e0
    public void c(s sVar, boolean z) {
        int i2;
        if (z) {
            i2 = sVar.c() + sVar.y();
        } else {
            i2 = -1;
        }
        if (this.f5659f) {
            if (z) {
                this.f5659f = false;
                sVar.K(i2);
                this.f5657d = 0;
            } else {
                return;
            }
        }
        while (sVar.a() > 0) {
            int i3 = this.f5657d;
            boolean z2 = true;
            if (i3 < 3) {
                if (i3 == 0) {
                    int y = sVar.y();
                    sVar.K(sVar.c() - 1);
                    if (y == 255) {
                        this.f5659f = true;
                        return;
                    }
                }
                int min = Math.min(sVar.a(), 3 - this.f5657d);
                sVar.h(this.f5655b.f7062a, this.f5657d, min);
                int i4 = this.f5657d + min;
                this.f5657d = i4;
                if (i4 == 3) {
                    this.f5655b.H(3);
                    this.f5655b.L(1);
                    int y2 = this.f5655b.y();
                    int y3 = this.f5655b.y();
                    if ((y2 & 128) == 0) {
                        z2 = false;
                    }
                    this.f5658e = z2;
                    this.f5656c = (((y2 & 15) << 8) | y3) + 3;
                    int b2 = this.f5655b.b();
                    int i5 = this.f5656c;
                    if (b2 < i5) {
                        s sVar2 = this.f5655b;
                        byte[] bArr = sVar2.f7062a;
                        sVar2.H(Math.min(4098, Math.max(i5, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f5655b.f7062a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(sVar.a(), this.f5656c - this.f5657d);
                sVar.h(this.f5655b.f7062a, this.f5657d, min2);
                int i6 = this.f5657d + min2;
                this.f5657d = i6;
                int i7 = this.f5656c;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.f5658e) {
                        this.f5655b.H(i7);
                    } else if (d0.p(this.f5655b.f7062a, 0, i7, -1) != 0) {
                        this.f5659f = true;
                        return;
                    } else {
                        this.f5655b.H(this.f5656c - 4);
                    }
                    this.f5654a.c(this.f5655b);
                    this.f5657d = 0;
                }
            }
        }
    }
}
