package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.p;
import java.util.Collections;
import java.util.List;

/* compiled from: TextRenderer */
public final class j extends c implements Handler.Callback {

    /* renamed from: k  reason: collision with root package name */
    private final Handler f6663k;
    private final i l;
    private final f m;
    private final m n;
    private boolean o;
    private boolean p;
    private int q;
    private l r;
    private e s;
    private g t;
    private h u;
    private h v;
    private int w;

    public j(i iVar, Looper looper) {
        this(iVar, looper, f.f6659a);
    }

    private void K() {
        Q(Collections.emptyList());
    }

    private long L() {
        int i2 = this.w;
        if (i2 == -1 || i2 >= this.u.d()) {
            return Long.MAX_VALUE;
        }
        return this.u.b(this.w);
    }

    private void M(List<a> list) {
        this.l.b(list);
    }

    private void N() {
        this.t = null;
        this.w = -1;
        h hVar = this.u;
        if (hVar != null) {
            hVar.m();
            this.u = null;
        }
        h hVar2 = this.v;
        if (hVar2 != null) {
            hVar2.m();
            this.v = null;
        }
    }

    private void O() {
        N();
        this.s.a();
        this.s = null;
        this.q = 0;
    }

    private void P() {
        O();
        this.s = this.m.b(this.r);
    }

    private void Q(List<a> list) {
        Handler handler = this.f6663k;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            M(list);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void B() {
        this.r = null;
        K();
        O();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void D(long j2, boolean z) {
        K();
        this.o = false;
        this.p = false;
        if (this.q != 0) {
            P();
            return;
        }
        N();
        this.s.flush();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c
    public void G(l[] lVarArr, long j2) {
        l lVar = lVarArr[0];
        this.r = lVar;
        if (this.s != null) {
            this.q = 1;
        } else {
            this.s = this.m.b(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.y
    public int a(l lVar) {
        return this.m.a(lVar) ? c.J(null, lVar.f5980k) ? 4 : 2 : p.l(lVar.f5977h) ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.x
    public boolean b() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.x
    public boolean e() {
        return true;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            M((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.x
    public void l(long j2, long j3) {
        boolean z;
        if (!this.p) {
            if (this.v == null) {
                this.s.b(j2);
                try {
                    this.v = (h) this.s.d();
                } catch (SubtitleDecoderException e2) {
                    throw ExoPlaybackException.a(e2, y());
                }
            }
            if (getState() == 2) {
                if (this.u != null) {
                    long L = L();
                    z = false;
                    while (L <= j2) {
                        this.w++;
                        L = L();
                        z = true;
                    }
                } else {
                    z = false;
                }
                h hVar = this.v;
                if (hVar != null) {
                    if (hVar.j()) {
                        if (!z && L() == Long.MAX_VALUE) {
                            if (this.q == 2) {
                                P();
                            } else {
                                N();
                                this.p = true;
                            }
                        }
                    } else if (this.v.f4954c <= j2) {
                        h hVar2 = this.u;
                        if (hVar2 != null) {
                            hVar2.m();
                        }
                        h hVar3 = this.v;
                        this.u = hVar3;
                        this.v = null;
                        this.w = hVar3.a(j2);
                        z = true;
                    }
                }
                if (z) {
                    Q(this.u.c(j2));
                }
                if (this.q != 2) {
                    while (!this.o) {
                        try {
                            if (this.t == null) {
                                g gVar = (g) this.s.e();
                                this.t = gVar;
                                if (gVar == null) {
                                    return;
                                }
                            }
                            if (this.q == 1) {
                                this.t.l(4);
                                this.s.c(this.t);
                                this.t = null;
                                this.q = 2;
                                return;
                            }
                            int H = H(this.n, this.t, false);
                            if (H == -4) {
                                if (this.t.j()) {
                                    this.o = true;
                                } else {
                                    g gVar2 = this.t;
                                    gVar2.f6660g = this.n.f5981a.l;
                                    gVar2.o();
                                }
                                this.s.c(this.t);
                                this.t = null;
                            } else if (H == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e3) {
                            throw ExoPlaybackException.a(e3, y());
                        }
                    }
                }
            }
        }
    }

    public j(i iVar, Looper looper, f fVar) {
        super(3);
        Handler handler;
        e.e(iVar);
        this.l = iVar;
        if (looper == null) {
            handler = null;
        } else {
            handler = d0.r(looper, this);
        }
        this.f6663k = handler;
        this.m = fVar;
        this.n = new m();
    }
}
