package com.google.android.exoplayer2.source.e0;

import android.util.Base64;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0.u.m;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.d0.g;
import com.google.android.exoplayer2.source.e0.c;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.x;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: SsMediaPeriod */
public final class d implements t, z.a<g<c>> {

    /* renamed from: b  reason: collision with root package name */
    private final c.a f6332b;

    /* renamed from: c  reason: collision with root package name */
    private final x f6333c;

    /* renamed from: d  reason: collision with root package name */
    private final u f6334d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.t f6335e;

    /* renamed from: f  reason: collision with root package name */
    private final v.a f6336f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.d f6337g;

    /* renamed from: h  reason: collision with root package name */
    private final c0 f6338h;

    /* renamed from: i  reason: collision with root package name */
    private final m[] f6339i;

    /* renamed from: j  reason: collision with root package name */
    private final o f6340j;

    /* renamed from: k  reason: collision with root package name */
    private t.a f6341k;
    private a l;
    private g<c>[] m;
    private z n;
    private boolean o;

    public d(a aVar, c.a aVar2, x xVar, o oVar, com.google.android.exoplayer2.upstream.t tVar, v.a aVar3, u uVar, com.google.android.exoplayer2.upstream.d dVar) {
        this.f6332b = aVar2;
        this.f6333c = xVar;
        this.f6334d = uVar;
        this.f6335e = tVar;
        this.f6336f = aVar3;
        this.f6337g = dVar;
        this.f6340j = oVar;
        this.f6338h = h(aVar);
        a.C0134a aVar4 = aVar.f6596e;
        if (aVar4 != null) {
            this.f6339i = new m[]{new m(true, null, 8, p(aVar4.f6601b), 0, 0, null)};
        } else {
            this.f6339i = null;
        }
        this.l = aVar;
        g<c>[] q = q(0);
        this.m = q;
        this.n = oVar.a(q);
        aVar3.I();
    }

    private g<c> e(com.google.android.exoplayer2.g0.g gVar, long j2) {
        int k2 = this.f6338h.k(gVar.j());
        return new g<>(this.l.f6597f[k2].f6602a, null, null, this.f6332b.a(this.f6334d, this.l, k2, gVar, this.f6339i, this.f6333c), this, this.f6337g, j2, this.f6335e, this.f6336f);
    }

    private static c0 h(a aVar) {
        b0[] b0VarArr = new b0[aVar.f6597f.length];
        for (int i2 = 0; i2 < aVar.f6597f.length; i2++) {
            b0VarArr[i2] = new b0(aVar.f6597f[i2].f6611j);
        }
        return new c0(b0VarArr);
    }

    private static byte[] p(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            sb.append((char) bArr[i2]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        w(decode, 0, 3);
        w(decode, 1, 2);
        w(decode, 4, 5);
        w(decode, 6, 7);
        return decode;
    }

    private static g<c>[] q(int i2) {
        return new g[i2];
    }

    private static void w(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long b(long j2, a0 a0Var) {
        g<c>[] gVarArr = this.m;
        for (g<c> gVar : gVarArr) {
            if (gVar.f6124b == 2) {
                return gVar.b(j2, a0Var);
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long c() {
        return this.n.c();
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long d() {
        return this.n.d();
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        return this.n.f(j2);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public void g(long j2) {
        this.n.g(j2);
    }

    @Override // com.google.android.exoplayer2.source.t
    public long j(com.google.android.exoplayer2.g0.g[] gVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (yVarArr[i2] != null) {
                g gVar = (g) yVarArr[i2];
                if (gVarArr[i2] == null || !zArr[i2]) {
                    gVar.M();
                    yVarArr[i2] = null;
                } else {
                    arrayList.add(gVar);
                }
            }
            if (yVarArr[i2] == null && gVarArr[i2] != null) {
                g<c> e2 = e(gVarArr[i2], j2);
                arrayList.add(e2);
                yVarArr[i2] = e2;
                zArr2[i2] = true;
            }
        }
        g<c>[] q = q(arrayList.size());
        this.m = q;
        arrayList.toArray(q);
        this.n = this.f6340j.a(this.m);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long l() {
        if (this.o) {
            return -9223372036854775807L;
        }
        this.f6336f.L();
        this.o = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void m(t.a aVar, long j2) {
        this.f6341k = aVar;
        aVar.k(this);
    }

    @Override // com.google.android.exoplayer2.source.t
    public c0 o() {
        return this.f6338h;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void r() {
        this.f6334d.a();
    }

    @Override // com.google.android.exoplayer2.source.t
    public void s(long j2, boolean z) {
        for (g<c> gVar : this.m) {
            gVar.s(j2, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long t(long j2) {
        for (g<c> gVar : this.m) {
            gVar.O(j2);
        }
        return j2;
    }

    /* renamed from: u */
    public void n(g<c> gVar) {
        this.f6341k.n(this);
    }

    public void v() {
        for (g<c> gVar : this.m) {
            gVar.M();
        }
        this.f6341k = null;
        this.f6336f.J();
    }

    public void x(a aVar) {
        this.l = aVar;
        for (g<c> gVar : this.m) {
            gVar.B().f(aVar);
        }
        this.f6341k.n(this);
    }
}
