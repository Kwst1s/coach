package com.google.android.exoplayer2.source.e0;

import android.net.Uri;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0.u.m;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.d0.d;
import com.google.android.exoplayer2.source.d0.e;
import com.google.android.exoplayer2.source.d0.f;
import com.google.android.exoplayer2.source.e0.c;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;
import java.util.List;

/* compiled from: DefaultSsChunkSource */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final u f6323a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6324b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6325c;

    /* renamed from: d  reason: collision with root package name */
    private final e[] f6326d;

    /* renamed from: e  reason: collision with root package name */
    private final i f6327e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a f6328f;

    /* renamed from: g  reason: collision with root package name */
    private int f6329g;

    /* renamed from: h  reason: collision with root package name */
    private IOException f6330h;

    /* compiled from: DefaultSsChunkSource */
    public static final class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f6331a;

        public a(i.a aVar) {
            this.f6331a = aVar;
        }

        @Override // com.google.android.exoplayer2.source.e0.c.a
        public c a(u uVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i2, g gVar, m[] mVarArr, x xVar) {
            i a2 = this.f6331a.a();
            if (xVar != null) {
                a2.d(xVar);
            }
            return new b(uVar, aVar, i2, gVar, a2, mVarArr);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.e0.b$b  reason: collision with other inner class name */
    /* compiled from: DefaultSsChunkSource */
    private static final class C0133b extends com.google.android.exoplayer2.source.d0.b {
        public C0133b(a.b bVar, int i2, int i3) {
            super((long) i3, (long) (bVar.f6612k - 1));
        }
    }

    public b(u uVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i2, g gVar, i iVar, m[] mVarArr) {
        this.f6323a = uVar;
        this.f6328f = aVar;
        this.f6324b = i2;
        this.f6325c = gVar;
        this.f6327e = iVar;
        a.b bVar = aVar.f6597f[i2];
        this.f6326d = new e[gVar.length()];
        for (int i3 = 0; i3 < this.f6326d.length; i3++) {
            int e2 = gVar.e(i3);
            l lVar = bVar.f6611j[e2];
            int i4 = bVar.f6602a;
            this.f6326d[i3] = new e(new com.google.android.exoplayer2.e0.u.g(3, null, new com.google.android.exoplayer2.e0.u.l(e2, i4, bVar.f6604c, -9223372036854775807L, aVar.f6598g, lVar, 0, mVarArr, i4 == 2 ? 4 : 0, null, null), null), bVar.f6602a, lVar);
        }
    }

    private static com.google.android.exoplayer2.source.d0.l i(l lVar, i iVar, Uri uri, String str, int i2, long j2, long j3, long j4, int i3, Object obj, e eVar) {
        return new com.google.android.exoplayer2.source.d0.i(iVar, new k(uri, 0, -1, str), lVar, i3, obj, j2, j3, j4, -9223372036854775807L, (long) i2, 1, j2, eVar);
    }

    private long j(long j2) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f6328f;
        if (!aVar.f6595d) {
            return -9223372036854775807L;
        }
        a.b bVar = aVar.f6597f[this.f6324b];
        int i2 = bVar.f6612k - 1;
        return (bVar.e(i2) + bVar.c(i2)) - j2;
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public void a() {
        IOException iOException = this.f6330h;
        if (iOException == null) {
            this.f6323a.a();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public long b(long j2, a0 a0Var) {
        a.b bVar = this.f6328f.f6597f[this.f6324b];
        int d2 = bVar.d(j2);
        long e2 = bVar.e(d2);
        return d0.Y(j2, a0Var, e2, (e2 >= j2 || d2 >= bVar.f6612k + -1) ? e2 : bVar.e(d2 + 1));
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public int d(long j2, List<? extends com.google.android.exoplayer2.source.d0.l> list) {
        if (this.f6330h != null || this.f6325c.length() < 2) {
            return list.size();
        }
        return this.f6325c.f(j2, list);
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public void e(d dVar) {
    }

    @Override // com.google.android.exoplayer2.source.e0.c
    public void f(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b[] bVarArr = this.f6328f.f6597f;
        int i2 = this.f6324b;
        a.b bVar = bVarArr[i2];
        int i3 = bVar.f6612k;
        a.b bVar2 = aVar.f6597f[i2];
        if (i3 == 0 || bVar2.f6612k == 0) {
            this.f6329g += i3;
        } else {
            int i4 = i3 - 1;
            long e2 = bVar.e(i4) + bVar.c(i4);
            long e3 = bVar2.e(0);
            if (e2 <= e3) {
                this.f6329g += i3;
            } else {
                this.f6329g += bVar.d(e3);
            }
        }
        this.f6328f = aVar;
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public final void g(long j2, long j3, List<? extends com.google.android.exoplayer2.source.d0.l> list, f fVar) {
        int i2;
        long j4 = j3;
        if (this.f6330h == null) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f6328f;
            a.b bVar = aVar.f6597f[this.f6324b];
            if (bVar.f6612k == 0) {
                fVar.f6123b = !aVar.f6595d;
                return;
            }
            if (list.isEmpty()) {
                i2 = bVar.d(j4);
            } else {
                i2 = (int) (((com.google.android.exoplayer2.source.d0.l) list.get(list.size() - 1)).g() - ((long) this.f6329g));
                if (i2 < 0) {
                    this.f6330h = new BehindLiveWindowException();
                    return;
                }
            }
            if (i2 >= bVar.f6612k) {
                fVar.f6123b = !this.f6328f.f6595d;
                return;
            }
            long j5 = j4 - j2;
            long j6 = j(j2);
            int length = this.f6325c.length();
            com.google.android.exoplayer2.source.d0.m[] mVarArr = new com.google.android.exoplayer2.source.d0.m[length];
            for (int i3 = 0; i3 < length; i3++) {
                mVarArr[i3] = new C0133b(bVar, this.f6325c.e(i3), i2);
            }
            this.f6325c.h(j2, j5, j6, list, mVarArr);
            long e2 = bVar.e(i2);
            long c2 = e2 + bVar.c(i2);
            if (!list.isEmpty()) {
                j4 = -9223372036854775807L;
            }
            int i4 = i2 + this.f6329g;
            int m = this.f6325c.m();
            e eVar = this.f6326d[m];
            fVar.f6122a = i(this.f6325c.k(), this.f6327e, bVar.a(this.f6325c.e(m), i2), null, i4, e2, c2, j4, this.f6325c.l(), this.f6325c.p(), eVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public boolean h(d dVar, boolean z, Exception exc, long j2) {
        if (z && j2 != -9223372036854775807L) {
            g gVar = this.f6325c;
            if (gVar.a(gVar.g(dVar.f6100c), j2)) {
                return true;
            }
        }
        return false;
    }
}
