package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;

/* compiled from: SpliceInfoSectionReader */
public final class a0 implements x {

    /* renamed from: a  reason: collision with root package name */
    private com.google.android.exoplayer2.util.a0 f5405a;

    /* renamed from: b  reason: collision with root package name */
    private q f5406b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5407c;

    @Override // com.google.android.exoplayer2.e0.x.x
    public void b(com.google.android.exoplayer2.util.a0 a0Var, i iVar, e0.d dVar) {
        this.f5405a = a0Var;
        dVar.a();
        q a2 = iVar.a(dVar.c(), 4);
        this.f5406b = a2;
        a2.d(l.x(dVar.b(), "application/x-scte35", null, -1, null));
    }

    @Override // com.google.android.exoplayer2.e0.x.x
    public void c(s sVar) {
        if (!this.f5407c) {
            if (this.f5405a.e() != -9223372036854775807L) {
                this.f5406b.d(l.w(null, "application/x-scte35", this.f5405a.e()));
                this.f5407c = true;
            } else {
                return;
            }
        }
        int a2 = sVar.a();
        this.f5406b.a(sVar, a2);
        this.f5406b.c(this.f5405a.d(), 1, a2, 0, null);
    }
}
