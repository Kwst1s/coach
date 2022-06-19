package com.devbrackets.android.exomedia.core.video.exo;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import c.b.a.a.j.c.b;
import c.b.a.a.j.d.d;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.u;
import java.util.Map;

/* compiled from: ExoVideoDelegate */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected c.b.a.a.j.c.a f4429a;

    /* renamed from: b  reason: collision with root package name */
    protected c.b.a.a.j.a f4430b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f4431c = false;

    /* renamed from: d  reason: collision with root package name */
    protected Context f4432d;

    /* renamed from: e  reason: collision with root package name */
    protected c.b.a.a.j.g.a f4433e;

    /* renamed from: f  reason: collision with root package name */
    protected C0111a f4434f = new C0111a();

    /* access modifiers changed from: protected */
    /* renamed from: com.devbrackets.android.exomedia.core.video.exo.a$a  reason: collision with other inner class name */
    /* compiled from: ExoVideoDelegate */
    public class C0111a implements d, c.b.a.a.k.a {
        protected C0111a() {
        }

        @Override // c.b.a.a.k.a
        public void d(int i2) {
            a.this.f4430b.d(i2);
        }

        @Override // c.b.a.a.j.d.d
        public void g(com.google.android.exoplayer2.f0.a aVar) {
            a.this.f4430b.g(aVar);
        }
    }

    public a(Context context, c.b.a.a.j.g.a aVar) {
        this.f4432d = context.getApplicationContext();
        this.f4433e = aVar;
        u();
    }

    public Map<c.b.a.a.d, c0> a() {
        return this.f4429a.x();
    }

    public int b() {
        return this.f4429a.y();
    }

    public long c() {
        if (!this.f4430b.S()) {
            return 0;
        }
        return this.f4429a.z();
    }

    public long d() {
        if (!this.f4430b.S()) {
            return 0;
        }
        return this.f4429a.B();
    }

    public float e() {
        return this.f4429a.G();
    }

    public float f() {
        return this.f4429a.I();
    }

    public b g() {
        return this.f4429a.J();
    }

    /* access modifiers changed from: protected */
    public void h() {
        c.b.a.a.j.c.a aVar = new c.b.a.a.j.c.a(this.f4432d);
        this.f4429a = aVar;
        aVar.X(this.f4434f);
        this.f4429a.T(this.f4434f);
    }

    public boolean i() {
        return this.f4429a.F();
    }

    public void j() {
        this.f4429a.u();
    }

    public void k(Surface surface) {
        this.f4429a.a0(surface);
        if (this.f4431c) {
            this.f4429a.Y(true);
        }
    }

    public void l() {
        this.f4429a.Y(false);
        this.f4431c = false;
    }

    public void m() {
        this.f4429a.L();
    }

    public void n(long j2) {
        this.f4429a.P(j2);
    }

    public void o(c.b.a.a.j.d.a aVar) {
        this.f4429a.U(aVar);
    }

    public void p(s sVar) {
        this.f4429a.V(sVar);
    }

    public void q(c.b.a.a.j.a aVar) {
        c.b.a.a.j.a aVar2 = this.f4430b;
        if (aVar2 != null) {
            this.f4429a.N(aVar2);
            this.f4429a.M(this.f4430b);
        }
        this.f4430b = aVar;
        this.f4429a.r(aVar);
        this.f4429a.o(aVar);
    }

    public void r(int i2) {
        this.f4429a.Z(i2);
    }

    public void s(Uri uri) {
        t(uri, null);
    }

    public void t(Uri uri, u uVar) {
        this.f4430b.a0(false);
        this.f4429a.P(0);
        if (uVar != null) {
            this.f4429a.W(uVar);
            this.f4430b.Z(false);
        } else if (uri != null) {
            this.f4429a.b0(uri);
            this.f4430b.Z(false);
        } else {
            this.f4429a.W(null);
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        h();
    }

    public void v() {
        this.f4429a.Y(true);
        this.f4430b.Z(false);
        this.f4431c = true;
    }

    public void w(boolean z) {
        this.f4429a.e0();
        this.f4431c = false;
        if (z) {
            this.f4430b.R(this.f4433e);
        }
    }
}
