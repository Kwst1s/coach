package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.v.i;
import com.google.android.exoplayer2.e0.v.l;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: VorbisReader */
public final class k extends i {
    private a n;
    private int o;
    private boolean p;
    private l.d q;
    private l.b r;

    /* access modifiers changed from: package-private */
    /* compiled from: VorbisReader */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final l.d f5384a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5385b;

        /* renamed from: c  reason: collision with root package name */
        public final l.c[] f5386c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5387d;

        public a(l.d dVar, l.b bVar, byte[] bArr, l.c[] cVarArr, int i2) {
            this.f5384a = dVar;
            this.f5385b = bArr;
            this.f5386c = cVarArr;
            this.f5387d = i2;
        }
    }

    k() {
    }

    static void l(s sVar, long j2) {
        sVar.J(sVar.d() + 4);
        sVar.f7062a[sVar.d() - 4] = (byte) ((int) (j2 & 255));
        sVar.f7062a[sVar.d() - 3] = (byte) ((int) ((j2 >>> 8) & 255));
        sVar.f7062a[sVar.d() - 2] = (byte) ((int) ((j2 >>> 16) & 255));
        sVar.f7062a[sVar.d() - 1] = (byte) ((int) ((j2 >>> 24) & 255));
    }

    private static int m(byte b2, a aVar) {
        if (!aVar.f5386c[n(b2, aVar.f5387d, 1)].f5388a) {
            return aVar.f5384a.f5392d;
        }
        return aVar.f5384a.f5393e;
    }

    static int n(byte b2, int i2, int i3) {
        return (b2 >> i3) & (255 >>> (8 - i2));
    }

    public static boolean p(s sVar) {
        try {
            return l.k(1, sVar, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public void d(long j2) {
        super.d(j2);
        int i2 = 0;
        this.p = j2 != 0;
        l.d dVar = this.q;
        if (dVar != null) {
            i2 = dVar.f5392d;
        }
        this.o = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public long e(s sVar) {
        byte[] bArr = sVar.f7062a;
        int i2 = 0;
        if ((bArr[0] & 1) == 1) {
            return -1;
        }
        int m = m(bArr[0], this.n);
        if (this.p) {
            i2 = (this.o + m) / 4;
        }
        long j2 = (long) i2;
        l(sVar, j2);
        this.p = true;
        this.o = m;
        return j2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public boolean h(s sVar, long j2, i.b bVar) {
        if (this.n != null) {
            return false;
        }
        a o2 = o(sVar);
        this.n = o2;
        if (o2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n.f5384a.f5394f);
        arrayList.add(this.n.f5385b);
        l.d dVar = this.n.f5384a;
        bVar.f5378a = com.google.android.exoplayer2.l.t(null, "audio/vorbis", null, dVar.f5391c, -1, dVar.f5389a, (int) dVar.f5390b, arrayList, null, 0, null);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    /* access modifiers changed from: package-private */
    public a o(s sVar) {
        if (this.q == null) {
            this.q = l.i(sVar);
            return null;
        } else if (this.r == null) {
            this.r = l.h(sVar);
            return null;
        } else {
            byte[] bArr = new byte[sVar.d()];
            System.arraycopy(sVar.f7062a, 0, bArr, 0, sVar.d());
            l.c[] j2 = l.j(sVar, this.q.f5389a);
            return new a(this.q, this.r, bArr, j2, l.a(j2.length - 1));
        }
    }
}
