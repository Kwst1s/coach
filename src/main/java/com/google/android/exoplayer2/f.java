package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.w;

/* access modifiers changed from: package-private */
/* compiled from: DefaultMediaClock */
public final class f implements o {

    /* renamed from: b  reason: collision with root package name */
    private final w f5701b;

    /* renamed from: c  reason: collision with root package name */
    private final a f5702c;

    /* renamed from: d  reason: collision with root package name */
    private x f5703d;

    /* renamed from: e  reason: collision with root package name */
    private o f5704e;

    /* compiled from: DefaultMediaClock */
    public interface a {
        void f(s sVar);
    }

    public f(a aVar, com.google.android.exoplayer2.util.f fVar) {
        this.f5702c = aVar;
        this.f5701b = new w(fVar);
    }

    private void a() {
        this.f5701b.a(this.f5704e.v());
        s d2 = this.f5704e.d();
        if (!d2.equals(this.f5701b.d())) {
            this.f5701b.f(d2);
            this.f5702c.f(d2);
        }
    }

    private boolean b() {
        x xVar = this.f5703d;
        return xVar != null && !xVar.b() && (this.f5703d.e() || !this.f5703d.i());
    }

    public void c(x xVar) {
        if (xVar == this.f5703d) {
            this.f5704e = null;
            this.f5703d = null;
        }
    }

    @Override // com.google.android.exoplayer2.util.o
    public s d() {
        o oVar = this.f5704e;
        if (oVar != null) {
            return oVar.d();
        }
        return this.f5701b.d();
    }

    public void e(x xVar) {
        o oVar;
        o t = xVar.t();
        if (t != null && t != (oVar = this.f5704e)) {
            if (oVar == null) {
                this.f5704e = t;
                this.f5703d = xVar;
                t.f(this.f5701b.d());
                a();
                return;
            }
            throw ExoPlaybackException.d(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    @Override // com.google.android.exoplayer2.util.o
    public s f(s sVar) {
        o oVar = this.f5704e;
        if (oVar != null) {
            sVar = oVar.f(sVar);
        }
        this.f5701b.f(sVar);
        this.f5702c.f(sVar);
        return sVar;
    }

    public void g(long j2) {
        this.f5701b.a(j2);
    }

    public void h() {
        this.f5701b.b();
    }

    public void i() {
        this.f5701b.c();
    }

    public long j() {
        if (!b()) {
            return this.f5701b.v();
        }
        a();
        return this.f5704e.v();
    }

    @Override // com.google.android.exoplayer2.util.o
    public long v() {
        if (b()) {
            return this.f5704e.v();
        }
        return this.f5701b.v();
    }
}
