package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.s;

/* compiled from: StandaloneMediaClock */
public final class w implements o {

    /* renamed from: b  reason: collision with root package name */
    private final f f7081b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7082c;

    /* renamed from: d  reason: collision with root package name */
    private long f7083d;

    /* renamed from: e  reason: collision with root package name */
    private long f7084e;

    /* renamed from: f  reason: collision with root package name */
    private s f7085f = s.f6052e;

    public w(f fVar) {
        this.f7081b = fVar;
    }

    public void a(long j2) {
        this.f7083d = j2;
        if (this.f7082c) {
            this.f7084e = this.f7081b.c();
        }
    }

    public void b() {
        if (!this.f7082c) {
            this.f7084e = this.f7081b.c();
            this.f7082c = true;
        }
    }

    public void c() {
        if (this.f7082c) {
            a(v());
            this.f7082c = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.o
    public s d() {
        return this.f7085f;
    }

    @Override // com.google.android.exoplayer2.util.o
    public s f(s sVar) {
        if (this.f7082c) {
            a(v());
        }
        this.f7085f = sVar;
        return sVar;
    }

    @Override // com.google.android.exoplayer2.util.o
    public long v() {
        long j2;
        long j3 = this.f7083d;
        if (!this.f7082c) {
            return j3;
        }
        long c2 = this.f7081b.c() - this.f7084e;
        s sVar = this.f7085f;
        if (sVar.f6053a == 1.0f) {
            j2 = d.a(c2);
        } else {
            j2 = sVar.a(c2);
        }
        return j3 + j2;
    }
}
