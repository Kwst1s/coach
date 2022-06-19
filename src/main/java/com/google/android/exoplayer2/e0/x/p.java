package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;

/* compiled from: Id3Reader */
public final class p implements l {

    /* renamed from: a  reason: collision with root package name */
    private final s f5581a = new s(10);

    /* renamed from: b  reason: collision with root package name */
    private q f5582b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5583c;

    /* renamed from: d  reason: collision with root package name */
    private long f5584d;

    /* renamed from: e  reason: collision with root package name */
    private int f5585e;

    /* renamed from: f  reason: collision with root package name */
    private int f5586f;

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5583c = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        if (this.f5583c) {
            int a2 = sVar.a();
            int i2 = this.f5586f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(sVar.f7062a, sVar.c(), this.f5581a.f7062a, this.f5586f, min);
                if (this.f5586f + min == 10) {
                    this.f5581a.K(0);
                    if (73 == this.f5581a.y() && 68 == this.f5581a.y() && 51 == this.f5581a.y()) {
                        this.f5581a.L(3);
                        this.f5585e = this.f5581a.x() + 10;
                    } else {
                        m.f("Id3Reader", "Discarding invalid ID3 tag");
                        this.f5583c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f5585e - this.f5586f);
            this.f5582b.a(sVar, min2);
            this.f5586f += min2;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        if (z) {
            this.f5583c = true;
            this.f5584d = j2;
            this.f5585e = 0;
            this.f5586f = 0;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
        int i2;
        if (this.f5583c && (i2 = this.f5585e) != 0 && this.f5586f == i2) {
            this.f5582b.c(this.f5584d, 1, i2, 0, null);
            this.f5583c = false;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        q a2 = iVar.a(dVar.c(), 4);
        this.f5582b = a2;
        a2.d(l.x(dVar.b(), "application/id3", null, -1, null));
    }
}
