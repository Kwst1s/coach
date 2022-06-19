package com.google.android.exoplayer2.f0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* compiled from: MetadataRenderer */
public final class f extends c implements Handler.Callback {

    /* renamed from: k  reason: collision with root package name */
    private final c f5708k;
    private final e l;
    private final Handler m;
    private final m n;
    private final d o;
    private final a[] p;
    private final long[] q;
    private int r;
    private int s;
    private b t;
    private boolean u;

    public f(e eVar, Looper looper, c cVar) {
        super(4);
        Handler handler;
        e.e(eVar);
        this.l = eVar;
        if (looper == null) {
            handler = null;
        } else {
            handler = d0.r(looper, this);
        }
        this.m = handler;
        e.e(cVar);
        this.f5708k = cVar;
        this.n = new m();
        this.o = new d();
        this.p = new a[5];
        this.q = new long[5];
    }

    private void K() {
        Arrays.fill(this.p, (Object) null);
        this.r = 0;
        this.s = 0;
    }

    private void L(a aVar) {
        Handler handler = this.m;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            M(aVar);
        }
    }

    private void M(a aVar) {
        this.l.g(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void B() {
        K();
        this.t = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void D(long j2, boolean z) {
        K();
        this.u = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void G(l[] lVarArr, long j2) {
        this.t = this.f5708k.b(lVarArr[0]);
    }

    @Override // com.google.android.exoplayer2.y
    public int a(l lVar) {
        if (this.f5708k.a(lVar)) {
            return c.J(null, lVar.f5980k) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.x
    public boolean b() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.x
    public boolean e() {
        return true;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            M((a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.x
    public void l(long j2, long j3) {
        if (!this.u && this.s < 5) {
            this.o.f();
            if (H(this.n, this.o, false) == -4) {
                if (this.o.j()) {
                    this.u = true;
                } else if (!this.o.i()) {
                    d dVar = this.o;
                    dVar.f5707g = this.n.f5981a.l;
                    dVar.o();
                    int i2 = (this.r + this.s) % 5;
                    this.p[i2] = this.t.a(this.o);
                    this.q[i2] = this.o.f4952e;
                    this.s++;
                }
            }
        }
        if (this.s > 0) {
            long[] jArr = this.q;
            int i3 = this.r;
            if (jArr[i3] <= j2) {
                L(this.p[i3]);
                a[] aVarArr = this.p;
                int i4 = this.r;
                aVarArr[i4] = null;
                this.r = (i4 + 1) % 5;
                this.s--;
            }
        }
    }
}
