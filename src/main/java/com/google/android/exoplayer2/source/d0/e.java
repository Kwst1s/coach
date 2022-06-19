package com.google.android.exoplayer2.source.d0;

import android.util.SparseArray;
import com.google.android.exoplayer2.e0.f;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;

/* compiled from: ChunkExtractorWrapper */
public final class e implements i {

    /* renamed from: b  reason: collision with root package name */
    public final g f6106b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6107c;

    /* renamed from: d  reason: collision with root package name */
    private final l f6108d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<a> f6109e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f6110f;

    /* renamed from: g  reason: collision with root package name */
    private b f6111g;

    /* renamed from: h  reason: collision with root package name */
    private long f6112h;

    /* renamed from: i  reason: collision with root package name */
    private o f6113i;

    /* renamed from: j  reason: collision with root package name */
    private l[] f6114j;

    /* compiled from: ChunkExtractorWrapper */
    private static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        private final int f6115a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6116b;

        /* renamed from: c  reason: collision with root package name */
        private final l f6117c;

        /* renamed from: d  reason: collision with root package name */
        private final f f6118d = new f();

        /* renamed from: e  reason: collision with root package name */
        public l f6119e;

        /* renamed from: f  reason: collision with root package name */
        private q f6120f;

        /* renamed from: g  reason: collision with root package name */
        private long f6121g;

        public a(int i2, int i3, l lVar) {
            this.f6115a = i2;
            this.f6116b = i3;
            this.f6117c = lVar;
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void a(s sVar, int i2) {
            this.f6120f.a(sVar, i2);
        }

        @Override // com.google.android.exoplayer2.e0.q
        public int b(h hVar, int i2, boolean z) {
            return this.f6120f.b(hVar, i2, z);
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void c(long j2, int i2, int i3, int i4, q.a aVar) {
            long j3 = this.f6121g;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                this.f6120f = this.f6118d;
            }
            this.f6120f.c(j2, i2, i3, i4, aVar);
        }

        @Override // com.google.android.exoplayer2.e0.q
        public void d(l lVar) {
            l lVar2 = this.f6117c;
            if (lVar2 != null) {
                lVar = lVar.m(lVar2);
            }
            this.f6119e = lVar;
            this.f6120f.d(lVar);
        }

        public void e(b bVar, long j2) {
            if (bVar == null) {
                this.f6120f = this.f6118d;
                return;
            }
            this.f6121g = j2;
            q a2 = bVar.a(this.f6115a, this.f6116b);
            this.f6120f = a2;
            l lVar = this.f6119e;
            if (lVar != null) {
                a2.d(lVar);
            }
        }
    }

    /* compiled from: ChunkExtractorWrapper */
    public interface b {
        q a(int i2, int i3);
    }

    public e(g gVar, int i2, l lVar) {
        this.f6106b = gVar;
        this.f6107c = i2;
        this.f6108d = lVar;
    }

    @Override // com.google.android.exoplayer2.e0.i
    public q a(int i2, int i3) {
        a aVar = this.f6109e.get(i2);
        if (aVar == null) {
            com.google.android.exoplayer2.util.e.f(this.f6114j == null);
            aVar = new a(i2, i3, i3 == this.f6107c ? this.f6108d : null);
            aVar.e(this.f6111g, this.f6112h);
            this.f6109e.put(i2, aVar);
        }
        return aVar;
    }

    public l[] b() {
        return this.f6114j;
    }

    public o c() {
        return this.f6113i;
    }

    public void d(b bVar, long j2, long j3) {
        this.f6111g = bVar;
        this.f6112h = j3;
        if (!this.f6110f) {
            this.f6106b.c(this);
            if (j2 != -9223372036854775807L) {
                this.f6106b.e(0, j2);
            }
            this.f6110f = true;
            return;
        }
        g gVar = this.f6106b;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        gVar.e(0, j2);
        for (int i2 = 0; i2 < this.f6109e.size(); i2++) {
            this.f6109e.valueAt(i2).e(bVar, j3);
        }
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void e(o oVar) {
        this.f6113i = oVar;
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void h() {
        l[] lVarArr = new l[this.f6109e.size()];
        for (int i2 = 0; i2 < this.f6109e.size(); i2++) {
            lVarArr[i2] = this.f6109e.valueAt(i2).f6119e;
        }
        this.f6114j = lVarArr;
    }
}
