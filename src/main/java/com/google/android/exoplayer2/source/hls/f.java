package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.d0.j;
import com.google.android.exoplayer2.source.d0.m;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: HlsChunkSource */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final h f6372a;

    /* renamed from: b  reason: collision with root package name */
    private final i f6373b;

    /* renamed from: c  reason: collision with root package name */
    private final i f6374c;

    /* renamed from: d  reason: collision with root package name */
    private final o f6375d;

    /* renamed from: e  reason: collision with root package name */
    private final d.a[] f6376e;

    /* renamed from: f  reason: collision with root package name */
    private final HlsPlaylistTracker f6377f;

    /* renamed from: g  reason: collision with root package name */
    private final b0 f6378g;

    /* renamed from: h  reason: collision with root package name */
    private final List<l> f6379h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6380i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f6381j;

    /* renamed from: k  reason: collision with root package name */
    private IOException f6382k;
    private d.a l;
    private boolean m;
    private Uri n;
    private byte[] o;
    private String p;
    private byte[] q;
    private g r;
    private long s = -9223372036854775807L;
    private boolean t;

    /* access modifiers changed from: private */
    /* compiled from: HlsChunkSource */
    public static final class a extends j {

        /* renamed from: k  reason: collision with root package name */
        public final String f6383k;
        private byte[] l;

        public a(i iVar, k kVar, l lVar, int i2, Object obj, byte[] bArr, String str) {
            super(iVar, kVar, 3, lVar, i2, obj, bArr);
            this.f6383k = str;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.d0.j
        public void g(byte[] bArr, int i2) {
            this.l = Arrays.copyOf(bArr, i2);
        }

        public byte[] j() {
            return this.l;
        }
    }

    /* compiled from: HlsChunkSource */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public com.google.android.exoplayer2.source.d0.d f6384a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6385b;

        /* renamed from: c  reason: collision with root package name */
        public d.a f6386c;

        public b() {
            a();
        }

        public void a() {
            this.f6384a = null;
            this.f6385b = false;
            this.f6386c = null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: HlsChunkSource */
    public static final class c extends com.google.android.exoplayer2.source.d0.b {
        public c(e eVar, long j2, int i2) {
            super((long) i2, (long) (eVar.o.size() - 1));
        }
    }

    /* compiled from: HlsChunkSource */
    private static final class d extends com.google.android.exoplayer2.g0.b {

        /* renamed from: g  reason: collision with root package name */
        private int f6387g;

        public d(b0 b0Var, int[] iArr) {
            super(b0Var, iArr);
            this.f6387g = g(b0Var.g(0));
        }

        @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
        public void h(long j2, long j3, long j4, List<? extends com.google.android.exoplayer2.source.d0.l> list, m[] mVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (r(this.f6387g, elapsedRealtime)) {
                for (int i2 = this.f5811b - 1; i2 >= 0; i2--) {
                    if (!r(i2, elapsedRealtime)) {
                        this.f6387g = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.g0.g
        public int l() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.g0.g
        public int m() {
            return this.f6387g;
        }

        @Override // com.google.android.exoplayer2.g0.g
        public Object p() {
            return null;
        }
    }

    public f(h hVar, HlsPlaylistTracker hlsPlaylistTracker, d.a[] aVarArr, g gVar, x xVar, o oVar, List<l> list) {
        this.f6372a = hVar;
        this.f6377f = hlsPlaylistTracker;
        this.f6376e = aVarArr;
        this.f6375d = oVar;
        this.f6379h = list;
        l[] lVarArr = new l[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            lVarArr[i2] = aVarArr[i2].f6466b;
            iArr[i2] = i2;
        }
        i a2 = gVar.a(1);
        this.f6373b = a2;
        if (xVar != null) {
            a2.d(xVar);
        }
        this.f6374c = gVar.a(3);
        b0 b0Var = new b0(lVarArr);
        this.f6378g = b0Var;
        this.r = new d(b0Var, iArr);
    }

    private void a() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    private long c(j jVar, boolean z, e eVar, long j2, long j3) {
        long d2;
        long j4;
        if (jVar != null && !z) {
            return jVar.g();
        }
        long j5 = eVar.p + j2;
        if (jVar != null && !this.m) {
            j3 = jVar.f6103f;
        }
        if (eVar.l || j3 < j5) {
            d2 = (long) d0.d(eVar.o, Long.valueOf(j3 - j2), true, !this.f6377f.a() || jVar == null);
            j4 = eVar.f6472i;
        } else {
            d2 = eVar.f6472i;
            j4 = (long) eVar.o.size();
        }
        return d2 + j4;
    }

    private a i(Uri uri, String str, int i2, int i3, Object obj) {
        return new a(this.f6374c, new k(uri, 0, -1, null, 1), this.f6376e[i2].f6466b, i3, obj, this.f6381j, str);
    }

    private long m(long j2) {
        long j3 = this.s;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private void o(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(d0.h0(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.n = uri;
        this.o = bArr;
        this.p = str;
        this.q = bArr2;
    }

    private void q(e eVar) {
        long j2;
        if (eVar.l) {
            j2 = -9223372036854775807L;
        } else {
            j2 = eVar.e() - this.f6377f.l();
        }
        this.s = j2;
    }

    public m[] b(j jVar, long j2) {
        int i2;
        if (jVar == null) {
            i2 = -1;
        } else {
            i2 = this.f6378g.k(jVar.f6100c);
        }
        int length = this.r.length();
        m[] mVarArr = new m[length];
        for (int i3 = 0; i3 < length; i3++) {
            int e2 = this.r.e(i3);
            d.a aVar = this.f6376e[e2];
            if (!this.f6377f.i(aVar)) {
                mVarArr[i3] = m.f6145a;
            } else {
                e b2 = this.f6377f.b(aVar);
                long l2 = b2.f6469f - this.f6377f.l();
                long c2 = c(jVar, e2 != i2, b2, l2, j2);
                long j3 = b2.f6472i;
                if (c2 < j3) {
                    mVarArr[i3] = m.f6145a;
                } else {
                    mVarArr[i3] = new c(b2, l2, (int) (c2 - j3));
                }
            }
        }
        return mVarArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(long r40, long r42, java.util.List<com.google.android.exoplayer2.source.hls.j> r44, com.google.android.exoplayer2.source.hls.f.b r45) {
        /*
        // Method dump skipped, instructions count: 478
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.f.d(long, long, java.util.List, com.google.android.exoplayer2.source.hls.f$b):void");
    }

    public b0 e() {
        return this.f6378g;
    }

    public g f() {
        return this.r;
    }

    public boolean g(com.google.android.exoplayer2.source.d0.d dVar, long j2) {
        g gVar = this.r;
        return gVar.a(gVar.q(this.f6378g.k(dVar.f6100c)), j2);
    }

    public void h() {
        IOException iOException = this.f6382k;
        if (iOException == null) {
            d.a aVar = this.l;
            if (aVar != null && this.t) {
                this.f6377f.j(aVar);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void j(com.google.android.exoplayer2.source.d0.d dVar) {
        if (dVar instanceof a) {
            a aVar = (a) dVar;
            this.f6381j = aVar.h();
            o(aVar.f6098a.f6922a, aVar.f6383k, aVar.j());
        }
    }

    public boolean k(d.a aVar, long j2) {
        int q2;
        int k2 = this.f6378g.k(aVar.f6466b);
        if (k2 == -1 || (q2 = this.r.q(k2)) == -1) {
            return true;
        }
        this.t = (this.l == aVar) | this.t;
        if (j2 == -9223372036854775807L || this.r.a(q2, j2)) {
            return true;
        }
        return false;
    }

    public void l() {
        this.f6382k = null;
    }

    public void n(g gVar) {
        this.r = gVar;
    }

    public void p(boolean z) {
        this.f6380i = z;
    }
}
