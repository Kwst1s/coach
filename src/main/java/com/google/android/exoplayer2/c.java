package com.google.android.exoplayer2;

import com.google.android.exoplayer2.d0.e;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.util.o;

/* compiled from: BaseRenderer */
public abstract class c implements x, y {

    /* renamed from: b  reason: collision with root package name */
    private final int f4899b;

    /* renamed from: c  reason: collision with root package name */
    private z f4900c;

    /* renamed from: d  reason: collision with root package name */
    private int f4901d;

    /* renamed from: e  reason: collision with root package name */
    private int f4902e;

    /* renamed from: f  reason: collision with root package name */
    private y f4903f;

    /* renamed from: g  reason: collision with root package name */
    private l[] f4904g;

    /* renamed from: h  reason: collision with root package name */
    private long f4905h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4906i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4907j;

    public c(int i2) {
        this.f4899b = i2;
    }

    protected static boolean J(m<?> mVar, l lVar) {
        if (lVar == null) {
            return true;
        }
        if (mVar == null) {
            return false;
        }
        return mVar.d(lVar);
    }

    /* access modifiers changed from: protected */
    public final boolean A() {
        return this.f4906i ? this.f4907j : this.f4903f.e();
    }

    /* access modifiers changed from: protected */
    public abstract void B();

    /* access modifiers changed from: protected */
    public void C(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void D(long j2, boolean z);

    /* access modifiers changed from: protected */
    public void E() {
    }

    /* access modifiers changed from: protected */
    public void F() {
    }

    /* access modifiers changed from: protected */
    public void G(l[] lVarArr, long j2) {
    }

    /* access modifiers changed from: protected */
    public final int H(m mVar, e eVar, boolean z) {
        int h2 = this.f4903f.h(mVar, eVar, z);
        if (h2 == -4) {
            if (eVar.j()) {
                this.f4906i = true;
                if (this.f4907j) {
                    return -4;
                }
                return -3;
            }
            eVar.f4952e += this.f4905h;
        } else if (h2 == -5) {
            l lVar = mVar.f5981a;
            long j2 = lVar.l;
            if (j2 != Long.MAX_VALUE) {
                mVar.f5981a = lVar.p(j2 + this.f4905h);
            }
        }
        return h2;
    }

    /* access modifiers changed from: protected */
    public int I(long j2) {
        return this.f4903f.n(j2 - this.f4905h);
    }

    @Override // com.google.android.exoplayer2.x
    public final void c() {
        boolean z = true;
        if (this.f4902e != 1) {
            z = false;
        }
        com.google.android.exoplayer2.util.e.f(z);
        this.f4902e = 0;
        this.f4903f = null;
        this.f4904g = null;
        this.f4907j = false;
        B();
    }

    @Override // com.google.android.exoplayer2.x, com.google.android.exoplayer2.y
    public final int g() {
        return this.f4899b;
    }

    @Override // com.google.android.exoplayer2.x
    public final int getState() {
        return this.f4902e;
    }

    @Override // com.google.android.exoplayer2.x
    public final void h(int i2) {
        this.f4901d = i2;
    }

    @Override // com.google.android.exoplayer2.x
    public final boolean i() {
        return this.f4906i;
    }

    @Override // com.google.android.exoplayer2.x
    public final void j(z zVar, l[] lVarArr, y yVar, long j2, boolean z, long j3) {
        com.google.android.exoplayer2.util.e.f(this.f4902e == 0);
        this.f4900c = zVar;
        this.f4902e = 1;
        C(z);
        w(lVarArr, yVar, j3);
        D(j2, z);
    }

    @Override // com.google.android.exoplayer2.y
    public int k() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.v.b
    public void m(int i2, Object obj) {
    }

    @Override // com.google.android.exoplayer2.x
    public final y n() {
        return this.f4903f;
    }

    @Override // com.google.android.exoplayer2.x
    public /* synthetic */ void o(float f2) {
        w.a(this, f2);
    }

    @Override // com.google.android.exoplayer2.x
    public final void p() {
        this.f4907j = true;
    }

    @Override // com.google.android.exoplayer2.x
    public final void q() {
        this.f4903f.a();
    }

    @Override // com.google.android.exoplayer2.x
    public final void r(long j2) {
        this.f4907j = false;
        this.f4906i = false;
        D(j2, false);
    }

    @Override // com.google.android.exoplayer2.x
    public final boolean s() {
        return this.f4907j;
    }

    @Override // com.google.android.exoplayer2.x
    public final void start() {
        boolean z = true;
        if (this.f4902e != 1) {
            z = false;
        }
        com.google.android.exoplayer2.util.e.f(z);
        this.f4902e = 2;
        E();
    }

    @Override // com.google.android.exoplayer2.x
    public final void stop() {
        com.google.android.exoplayer2.util.e.f(this.f4902e == 2);
        this.f4902e = 1;
        F();
    }

    @Override // com.google.android.exoplayer2.x
    public o t() {
        return null;
    }

    @Override // com.google.android.exoplayer2.x
    public final y u() {
        return this;
    }

    @Override // com.google.android.exoplayer2.x
    public final void w(l[] lVarArr, y yVar, long j2) {
        com.google.android.exoplayer2.util.e.f(!this.f4907j);
        this.f4903f = yVar;
        this.f4906i = false;
        this.f4904g = lVarArr;
        this.f4905h = j2;
        G(lVarArr, j2);
    }

    /* access modifiers changed from: protected */
    public final z x() {
        return this.f4900c;
    }

    /* access modifiers changed from: protected */
    public final int y() {
        return this.f4901d;
    }

    /* access modifiers changed from: protected */
    public final l[] z() {
        return this.f4904g;
    }
}
