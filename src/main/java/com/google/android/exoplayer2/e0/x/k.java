package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbSubtitleReader */
public final class k implements l {

    /* renamed from: a  reason: collision with root package name */
    private final List<e0.a> f5504a;

    /* renamed from: b  reason: collision with root package name */
    private final q[] f5505b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5506c;

    /* renamed from: d  reason: collision with root package name */
    private int f5507d;

    /* renamed from: e  reason: collision with root package name */
    private int f5508e;

    /* renamed from: f  reason: collision with root package name */
    private long f5509f;

    public k(List<e0.a> list) {
        this.f5504a = list;
        this.f5505b = new q[list.size()];
    }

    private boolean b(s sVar, int i2) {
        if (sVar.a() == 0) {
            return false;
        }
        if (sVar.y() != i2) {
            this.f5506c = false;
        }
        this.f5507d--;
        return this.f5506c;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5506c = false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        if (!this.f5506c) {
            return;
        }
        if (this.f5507d != 2 || b(sVar, 32)) {
            if (this.f5507d != 1 || b(sVar, 0)) {
                int c2 = sVar.c();
                int a2 = sVar.a();
                q[] qVarArr = this.f5505b;
                for (q qVar : qVarArr) {
                    sVar.K(c2);
                    qVar.a(sVar, a2);
                }
                this.f5508e += a2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        if (z) {
            this.f5506c = true;
            this.f5509f = j2;
            this.f5508e = 0;
            this.f5507d = 2;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
        if (this.f5506c) {
            for (q qVar : this.f5505b) {
                qVar.c(this.f5509f, 1, this.f5508e, 0, null);
            }
            this.f5506c = false;
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        for (int i2 = 0; i2 < this.f5505b.length; i2++) {
            e0.a aVar = this.f5504a.get(i2);
            dVar.a();
            q a2 = iVar.a(dVar.c(), 3);
            a2.d(l.v(dVar.b(), "application/dvbsubs", null, -1, 0, Collections.singletonList(aVar.f5446b), aVar.f5445a, null));
            this.f5505b[i2] = a2;
        }
    }
}
