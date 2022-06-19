package com.google.android.exoplayer2.e0.u;

import android.util.Pair;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.e0.u.c;
import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.h0.h;
import com.google.android.exoplayer2.h0.k;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: AtomParsers */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5203a = d0.B("vide");

    /* renamed from: b  reason: collision with root package name */
    private static final int f5204b = d0.B("soun");

    /* renamed from: c  reason: collision with root package name */
    private static final int f5205c = d0.B("text");

    /* renamed from: d  reason: collision with root package name */
    private static final int f5206d = d0.B("sbtl");

    /* renamed from: e  reason: collision with root package name */
    private static final int f5207e = d0.B("subt");

    /* renamed from: f  reason: collision with root package name */
    private static final int f5208f = d0.B("clcp");

    /* renamed from: g  reason: collision with root package name */
    private static final int f5209g = d0.B("meta");

    /* access modifiers changed from: private */
    /* compiled from: AtomParsers */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f5210a;

        /* renamed from: b  reason: collision with root package name */
        public int f5211b;

        /* renamed from: c  reason: collision with root package name */
        public int f5212c;

        /* renamed from: d  reason: collision with root package name */
        public long f5213d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f5214e;

        /* renamed from: f  reason: collision with root package name */
        private final s f5215f;

        /* renamed from: g  reason: collision with root package name */
        private final s f5216g;

        /* renamed from: h  reason: collision with root package name */
        private int f5217h;

        /* renamed from: i  reason: collision with root package name */
        private int f5218i;

        public a(s sVar, s sVar2, boolean z) {
            this.f5216g = sVar;
            this.f5215f = sVar2;
            this.f5214e = z;
            sVar2.K(12);
            this.f5210a = sVar2.C();
            sVar.K(12);
            this.f5218i = sVar.C();
            com.google.android.exoplayer2.util.e.g(sVar.j() != 1 ? false : true, "first_chunk must be 1");
            this.f5211b = -1;
        }

        public boolean a() {
            long j2;
            int i2 = this.f5211b + 1;
            this.f5211b = i2;
            if (i2 == this.f5210a) {
                return false;
            }
            if (this.f5214e) {
                j2 = this.f5215f.D();
            } else {
                j2 = this.f5215f.A();
            }
            this.f5213d = j2;
            if (this.f5211b == this.f5217h) {
                this.f5212c = this.f5216g.C();
                this.f5216g.L(4);
                int i3 = this.f5218i - 1;
                this.f5218i = i3;
                this.f5217h = i3 > 0 ? this.f5216g.C() - 1 : -1;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AtomParsers */
    public interface b {
        boolean a();

        int b();

        int c();
    }

    /* access modifiers changed from: private */
    /* compiled from: AtomParsers */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final m[] f5219a;

        /* renamed from: b  reason: collision with root package name */
        public l f5220b;

        /* renamed from: c  reason: collision with root package name */
        public int f5221c;

        /* renamed from: d  reason: collision with root package name */
        public int f5222d = 0;

        public c(int i2) {
            this.f5219a = new m[i2];
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.e0.u.d$d  reason: collision with other inner class name */
    /* compiled from: AtomParsers */
    public static final class C0123d implements b {

        /* renamed from: a  reason: collision with root package name */
        private final int f5223a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5224b;

        /* renamed from: c  reason: collision with root package name */
        private final s f5225c;

        public C0123d(c.b bVar) {
            s sVar = bVar.R0;
            this.f5225c = sVar;
            sVar.K(12);
            this.f5223a = sVar.C();
            this.f5224b = sVar.C();
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public boolean a() {
            return this.f5223a != 0;
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public int b() {
            return this.f5224b;
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public int c() {
            int i2 = this.f5223a;
            return i2 == 0 ? this.f5225c.C() : i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AtomParsers */
    public static final class e implements b {

        /* renamed from: a  reason: collision with root package name */
        private final s f5226a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5227b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5228c;

        /* renamed from: d  reason: collision with root package name */
        private int f5229d;

        /* renamed from: e  reason: collision with root package name */
        private int f5230e;

        public e(c.b bVar) {
            s sVar = bVar.R0;
            this.f5226a = sVar;
            sVar.K(12);
            this.f5228c = sVar.C() & 255;
            this.f5227b = sVar.C();
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public boolean a() {
            return false;
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public int b() {
            return this.f5227b;
        }

        @Override // com.google.android.exoplayer2.e0.u.d.b
        public int c() {
            int i2 = this.f5228c;
            if (i2 == 8) {
                return this.f5226a.y();
            }
            if (i2 == 16) {
                return this.f5226a.E();
            }
            int i3 = this.f5229d;
            this.f5229d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f5230e & 15;
            }
            int y = this.f5226a.y();
            this.f5230e = y;
            return (y & 240) >> 4;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AtomParsers */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f5231a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5232b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5233c;

        public f(int i2, long j2, int i3) {
            this.f5231a = i2;
            this.f5232b = j2;
            this.f5233c = i3;
        }
    }

    private static boolean a(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        int n = d0.n(3, 0, length);
        int n2 = d0.n(jArr.length - 3, 0, length);
        if (jArr[0] > j3 || j3 >= jArr[n] || jArr[n2] >= j4 || j4 > j2) {
            return false;
        }
        return true;
    }

    private static int b(s sVar, int i2, int i3) {
        int c2 = sVar.c();
        while (c2 - i2 < i3) {
            sVar.K(c2);
            int j2 = sVar.j();
            com.google.android.exoplayer2.util.e.b(j2 > 0, "childAtomSize should be positive");
            if (sVar.j() == c.K) {
                return c2;
            }
            c2 += j2;
        }
        return -1;
    }

    private static void c(s sVar, int i2, int i3, int i4, int i5, String str, boolean z, com.google.android.exoplayer2.drm.l lVar, c cVar, int i6) {
        int i7;
        int i8;
        int i9;
        String str2;
        String str3;
        com.google.android.exoplayer2.drm.l lVar2;
        String str4;
        int i10;
        int i11;
        int i12 = i3;
        com.google.android.exoplayer2.drm.l lVar3 = lVar;
        sVar.K(i12 + 8 + 8);
        if (z) {
            i7 = sVar.E();
            sVar.L(6);
        } else {
            sVar.L(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            int E = sVar.E();
            sVar.L(6);
            int z2 = sVar.z();
            if (i7 == 1) {
                sVar.L(16);
            }
            i8 = z2;
            i9 = E;
        } else if (i7 == 2) {
            sVar.L(16);
            i8 = (int) Math.round(sVar.i());
            i9 = sVar.C();
            sVar.L(20);
        } else {
            return;
        }
        int c2 = sVar.c();
        List list = null;
        int i13 = i2;
        if (i13 == c.b0) {
            Pair<Integer, m> o = o(sVar, i12, i4);
            if (o != null) {
                i13 = ((Integer) o.first).intValue();
                if (lVar3 == null) {
                    lVar3 = null;
                } else {
                    lVar3 = lVar3.l(((m) o.second).f5309b);
                }
                cVar.f5219a[i6] = (m) o.second;
            }
            sVar.K(c2);
        }
        com.google.android.exoplayer2.drm.l lVar4 = lVar3;
        String str5 = "audio/raw";
        if (i13 == c.o) {
            str2 = "audio/ac3";
        } else if (i13 == c.q) {
            str2 = "audio/eac3";
        } else if (i13 == c.s) {
            str2 = "audio/vnd.dts";
        } else if (i13 == c.t || i13 == c.u) {
            str2 = "audio/vnd.dts.hd";
        } else if (i13 == c.v) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i13 == c.y0) {
            str2 = "audio/3gpp";
        } else {
            str2 = i13 == c.z0 ? "audio/amr-wb" : (i13 == c.m || i13 == c.n) ? str5 : i13 == c.f5201k ? "audio/mpeg" : i13 == c.O0 ? "audio/alac" : i13 == c.P0 ? "audio/g711-alaw" : i13 == c.Q0 ? "audio/g711-mlaw" : null;
        }
        String str6 = str2;
        int i14 = i9;
        int i15 = i8;
        int i16 = c2;
        byte[] bArr = null;
        while (i16 - i12 < i4) {
            sVar.K(i16);
            int j2 = sVar.j();
            com.google.android.exoplayer2.util.e.b(j2 > 0, "childAtomSize should be positive");
            int j3 = sVar.j();
            int i17 = c.K;
            if (j3 == i17 || (z && j3 == c.l)) {
                str4 = str6;
                str3 = str5;
                lVar2 = lVar4;
                if (j3 == i17) {
                    i10 = i16;
                } else {
                    i10 = b(sVar, i16, j2);
                }
                if (i10 != -1) {
                    Pair<String, byte[]> f2 = f(sVar, i10);
                    str6 = (String) f2.first;
                    bArr = (byte[]) f2.second;
                    if ("audio/mp4a-latm".equals(str6)) {
                        Pair<Integer, Integer> j4 = g.j(bArr);
                        i15 = ((Integer) j4.first).intValue();
                        i14 = ((Integer) j4.second).intValue();
                    }
                    i16 += j2;
                    i12 = i3;
                    lVar4 = lVar2;
                    str5 = str3;
                }
            } else {
                if (j3 == c.p) {
                    sVar.K(i16 + 8);
                    cVar.f5220b = com.google.android.exoplayer2.audio.g.d(sVar, Integer.toString(i5), str, lVar4);
                } else if (j3 == c.r) {
                    sVar.K(i16 + 8);
                    cVar.f5220b = com.google.android.exoplayer2.audio.g.g(sVar, Integer.toString(i5), str, lVar4);
                } else {
                    if (j3 == c.w) {
                        str4 = str6;
                        str3 = str5;
                        lVar2 = lVar4;
                        i11 = i16;
                        cVar.f5220b = l.t(Integer.toString(i5), str6, null, -1, -1, i14, i15, null, lVar2, 0, str);
                        j2 = j2;
                    } else {
                        i11 = i16;
                        str4 = str6;
                        str3 = str5;
                        lVar2 = lVar4;
                        if (j3 == c.O0) {
                            byte[] bArr2 = new byte[j2];
                            i16 = i11;
                            sVar.K(i16);
                            sVar.h(bArr2, 0, j2);
                            bArr = bArr2;
                        }
                    }
                    i16 = i11;
                }
                str4 = str6;
                str3 = str5;
                lVar2 = lVar4;
            }
            str6 = str4;
            i16 += j2;
            i12 = i3;
            lVar4 = lVar2;
            str5 = str3;
        }
        if (cVar.f5220b == null && str6 != null) {
            int i18 = str5.equals(str6) ? 2 : -1;
            String num = Integer.toString(i5);
            if (bArr != null) {
                list = Collections.singletonList(bArr);
            }
            cVar.f5220b = l.s(num, str6, null, -1, -1, i14, i15, i18, list, lVar4, 0, str);
        }
    }

    static Pair<Integer, m> d(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            sVar.K(i4);
            int j2 = sVar.j();
            int j3 = sVar.j();
            if (j3 == c.c0) {
                num = Integer.valueOf(sVar.j());
            } else if (j3 == c.X) {
                sVar.L(4);
                str = sVar.v(4);
            } else if (j3 == c.Y) {
                i5 = i4;
                i6 = j2;
            }
            i4 += j2;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        com.google.android.exoplayer2.util.e.b(num != null, "frma atom is mandatory");
        com.google.android.exoplayer2.util.e.b(i5 != -1, "schi atom is mandatory");
        m p = p(sVar, i5, i6, str);
        if (p != null) {
            z = true;
        }
        com.google.android.exoplayer2.util.e.b(z, "tenc atom is mandatory");
        return Pair.create(num, p);
    }

    private static Pair<long[], long[]> e(c.a aVar) {
        c.b g2;
        if (aVar == null || (g2 = aVar.g(c.R)) == null) {
            return Pair.create(null, null);
        }
        s sVar = g2.R0;
        sVar.K(8);
        int c2 = c.c(sVar.j());
        int C = sVar.C();
        long[] jArr = new long[C];
        long[] jArr2 = new long[C];
        for (int i2 = 0; i2 < C; i2++) {
            jArr[i2] = c2 == 1 ? sVar.D() : sVar.A();
            jArr2[i2] = c2 == 1 ? sVar.r() : (long) sVar.j();
            if (sVar.u() == 1) {
                sVar.L(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> f(s sVar, int i2) {
        sVar.K(i2 + 8 + 4);
        sVar.L(1);
        g(sVar);
        sVar.L(2);
        int y = sVar.y();
        if ((y & 128) != 0) {
            sVar.L(2);
        }
        if ((y & 64) != 0) {
            sVar.L(sVar.E());
        }
        if ((y & 32) != 0) {
            sVar.L(2);
        }
        sVar.L(1);
        g(sVar);
        String e2 = p.e(sVar.y());
        if ("audio/mpeg".equals(e2) || "audio/vnd.dts".equals(e2) || "audio/vnd.dts.hd".equals(e2)) {
            return Pair.create(e2, null);
        }
        sVar.L(12);
        sVar.L(1);
        int g2 = g(sVar);
        byte[] bArr = new byte[g2];
        sVar.h(bArr, 0, g2);
        return Pair.create(e2, bArr);
    }

    private static int g(s sVar) {
        int y = sVar.y();
        int i2 = y & 127;
        while ((y & 128) == 128) {
            y = sVar.y();
            i2 = (i2 << 7) | (y & 127);
        }
        return i2;
    }

    private static int h(s sVar) {
        sVar.K(16);
        int j2 = sVar.j();
        if (j2 == f5204b) {
            return 1;
        }
        if (j2 == f5203a) {
            return 2;
        }
        if (j2 == f5205c || j2 == f5206d || j2 == f5207e || j2 == f5208f) {
            return 3;
        }
        return j2 == f5209g ? 4 : -1;
    }

    private static com.google.android.exoplayer2.f0.a i(s sVar, int i2) {
        sVar.L(8);
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < i2) {
            a.b c2 = h.c(sVar);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.f0.a(arrayList);
    }

    private static Pair<Long, String> j(s sVar) {
        int i2 = 8;
        sVar.K(8);
        int c2 = c.c(sVar.j());
        sVar.L(c2 == 0 ? 8 : 16);
        long A = sVar.A();
        if (c2 == 0) {
            i2 = 4;
        }
        sVar.L(i2);
        int E = sVar.E();
        return Pair.create(Long.valueOf(A), BuildConfig.FLAVOR + ((char) (((E >> 10) & 31) + 96)) + ((char) (((E >> 5) & 31) + 96)) + ((char) ((E & 31) + 96)));
    }

    private static com.google.android.exoplayer2.f0.a k(s sVar, int i2) {
        sVar.L(12);
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int j2 = sVar.j();
            if (sVar.j() == c.C0) {
                sVar.K(c2);
                return i(sVar, c2 + j2);
            }
            sVar.L(j2 - 8);
        }
        return null;
    }

    private static long l(s sVar) {
        int i2 = 8;
        sVar.K(8);
        if (c.c(sVar.j()) != 0) {
            i2 = 16;
        }
        sVar.L(i2);
        return sVar.A();
    }

    private static float m(s sVar, int i2) {
        sVar.K(i2 + 8);
        return ((float) sVar.C()) / ((float) sVar.C());
    }

    private static byte[] n(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            sVar.K(i4);
            int j2 = sVar.j();
            if (sVar.j() == c.J0) {
                return Arrays.copyOfRange(sVar.f7062a, i4, j2 + i4);
            }
            i4 += j2;
        }
        return null;
    }

    private static Pair<Integer, m> o(s sVar, int i2, int i3) {
        Pair<Integer, m> d2;
        int c2 = sVar.c();
        while (c2 - i2 < i3) {
            sVar.K(c2);
            int j2 = sVar.j();
            com.google.android.exoplayer2.util.e.b(j2 > 0, "childAtomSize should be positive");
            if (sVar.j() == c.W && (d2 = d(sVar, c2, j2)) != null) {
                return d2;
            }
            c2 += j2;
        }
        return null;
    }

    private static m p(s sVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            sVar.K(i6);
            int j2 = sVar.j();
            if (sVar.j() == c.Z) {
                int c2 = c.c(sVar.j());
                sVar.L(1);
                if (c2 == 0) {
                    sVar.L(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int y = sVar.y();
                    i4 = y & 15;
                    i5 = (y & 240) >> 4;
                }
                boolean z = sVar.y() == 1;
                int y2 = sVar.y();
                byte[] bArr2 = new byte[16];
                sVar.h(bArr2, 0, 16);
                if (z && y2 == 0) {
                    int y3 = sVar.y();
                    bArr = new byte[y3];
                    sVar.h(bArr, 0, y3);
                }
                return new m(z, str, y2, bArr2, i5, i4, bArr);
            }
            i6 += j2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03db A[EDGE_INSN: B:208:0x03db->B:157:0x03db ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.e0.u.o q(com.google.android.exoplayer2.e0.u.l r35, com.google.android.exoplayer2.e0.u.c.a r36, com.google.android.exoplayer2.e0.k r37) {
        /*
        // Method dump skipped, instructions count: 1245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e0.u.d.q(com.google.android.exoplayer2.e0.u.l, com.google.android.exoplayer2.e0.u.c$a, com.google.android.exoplayer2.e0.k):com.google.android.exoplayer2.e0.u.o");
    }

    private static c r(s sVar, int i2, int i3, String str, com.google.android.exoplayer2.drm.l lVar, boolean z) {
        sVar.K(12);
        int j2 = sVar.j();
        c cVar = new c(j2);
        for (int i4 = 0; i4 < j2; i4++) {
            int c2 = sVar.c();
            int j3 = sVar.j();
            com.google.android.exoplayer2.util.e.b(j3 > 0, "childAtomSize should be positive");
            int j4 = sVar.j();
            if (j4 == c.f5193c || j4 == c.f5194d || j4 == c.a0 || j4 == c.l0 || j4 == c.f5195e || j4 == c.f5196f || j4 == c.f5197g || j4 == c.K0 || j4 == c.L0) {
                w(sVar, j4, c2, j3, i2, i3, lVar, cVar, i4);
            } else if (j4 == c.f5200j || j4 == c.b0 || j4 == c.o || j4 == c.q || j4 == c.s || j4 == c.v || j4 == c.t || j4 == c.u || j4 == c.y0 || j4 == c.z0 || j4 == c.m || j4 == c.n || j4 == c.f5201k || j4 == c.O0 || j4 == c.P0 || j4 == c.Q0) {
                c(sVar, j4, c2, j3, i2, str, z, lVar, cVar, i4);
            } else if (j4 == c.k0 || j4 == c.u0 || j4 == c.v0 || j4 == c.w0 || j4 == c.x0) {
                s(sVar, j4, c2, j3, i2, str, cVar);
            } else if (j4 == c.N0) {
                cVar.f5220b = l.x(Integer.toString(i2), "application/x-camera-motion", null, -1, null);
            }
            sVar.K(c2 + j3);
        }
        return cVar;
    }

    private static void s(s sVar, int i2, int i3, int i4, int i5, String str, c cVar) {
        sVar.K(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != c.k0) {
            if (i2 == c.u0) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                sVar.h(bArr, 0, i6);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == c.v0) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == c.w0) {
                j2 = 0;
            } else if (i2 == c.x0) {
                cVar.f5222d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.f5220b = l.C(Integer.toString(i5), str2, null, -1, 0, str, -1, null, j2, list);
    }

    private static f t(s sVar) {
        boolean z;
        int i2 = 8;
        sVar.K(8);
        int c2 = c.c(sVar.j());
        sVar.L(c2 == 0 ? 8 : 16);
        int j2 = sVar.j();
        sVar.L(4);
        int c3 = sVar.c();
        if (c2 == 0) {
            i2 = 4;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            } else if (sVar.f7062a[c3 + i4] != -1) {
                z = false;
                break;
            } else {
                i4++;
            }
        }
        long j3 = -9223372036854775807L;
        if (z) {
            sVar.L(i2);
        } else {
            long A = c2 == 0 ? sVar.A() : sVar.D();
            if (A != 0) {
                j3 = A;
            }
        }
        sVar.L(16);
        int j4 = sVar.j();
        int j5 = sVar.j();
        sVar.L(4);
        int j6 = sVar.j();
        int j7 = sVar.j();
        if (j4 == 0 && j5 == 65536 && j6 == -65536 && j7 == 0) {
            i3 = 90;
        } else if (j4 == 0 && j5 == -65536 && j6 == 65536 && j7 == 0) {
            i3 = 270;
        } else if (j4 == -65536 && j5 == 0 && j6 == 0 && j7 == -65536) {
            i3 = 180;
        }
        return new f(j2, j3, i3);
    }

    public static l u(c.a aVar, c.b bVar, long j2, com.google.android.exoplayer2.drm.l lVar, boolean z, boolean z2) {
        long j3;
        c.b bVar2;
        long[] jArr;
        long[] jArr2;
        c.a f2 = aVar.f(c.F);
        int h2 = h(f2.g(c.T).R0);
        if (h2 == -1) {
            return null;
        }
        f t = t(aVar.g(c.P).R0);
        long j4 = -9223372036854775807L;
        if (j2 == -9223372036854775807L) {
            bVar2 = bVar;
            j3 = t.f5232b;
        } else {
            bVar2 = bVar;
            j3 = j2;
        }
        long l = l(bVar2.R0);
        if (j3 != -9223372036854775807L) {
            j4 = d0.Z(j3, 1000000, l);
        }
        c.a f3 = f2.f(c.G).f(c.H);
        Pair<Long, String> j5 = j(f2.g(c.S).R0);
        c r = r(f3.g(c.U).R0, t.f5231a, t.f5233c, (String) j5.second, lVar, z2);
        if (!z) {
            Pair<long[], long[]> e2 = e(aVar.f(c.Q));
            jArr = (long[]) e2.second;
            jArr2 = (long[]) e2.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (r.f5220b == null) {
            return null;
        }
        return new l(t.f5231a, h2, ((Long) j5.first).longValue(), l, j4, r.f5220b, r.f5222d, r.f5219a, r.f5221c, jArr2, jArr);
    }

    public static com.google.android.exoplayer2.f0.a v(c.b bVar, boolean z) {
        if (z) {
            return null;
        }
        s sVar = bVar.R0;
        sVar.K(8);
        while (sVar.a() >= 8) {
            int c2 = sVar.c();
            int j2 = sVar.j();
            if (sVar.j() == c.B0) {
                sVar.K(c2);
                return k(sVar, c2 + j2);
            }
            sVar.L(j2 - 8);
        }
        return null;
    }

    private static void w(s sVar, int i2, int i3, int i4, int i5, int i6, com.google.android.exoplayer2.drm.l lVar, c cVar, int i7) {
        com.google.android.exoplayer2.drm.l lVar2 = lVar;
        sVar.K(i3 + 8 + 8);
        sVar.L(16);
        int E = sVar.E();
        int E2 = sVar.E();
        sVar.L(50);
        int c2 = sVar.c();
        String str = null;
        int i8 = i2;
        if (i8 == c.a0) {
            Pair<Integer, m> o = o(sVar, i3, i4);
            if (o != null) {
                i8 = ((Integer) o.first).intValue();
                if (lVar2 == null) {
                    lVar2 = null;
                } else {
                    lVar2 = lVar2.l(((m) o.second).f5309b);
                }
                cVar.f5219a[i7] = (m) o.second;
            }
            sVar.K(c2);
        }
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z = false;
        float f2 = 1.0f;
        int i9 = -1;
        while (c2 - i3 < i4) {
            sVar.K(c2);
            int c3 = sVar.c();
            int j2 = sVar.j();
            if (j2 == 0 && sVar.c() - i3 == i4) {
                break;
            }
            com.google.android.exoplayer2.util.e.b(j2 > 0, "childAtomSize should be positive");
            int j3 = sVar.j();
            if (j3 == c.I) {
                com.google.android.exoplayer2.util.e.f(str == null);
                sVar.K(c3 + 8);
                h b2 = h.b(sVar);
                list = b2.f5877a;
                cVar.f5221c = b2.f5878b;
                if (!z) {
                    f2 = b2.f5881e;
                }
                str = "video/avc";
            } else if (j3 == c.J) {
                com.google.android.exoplayer2.util.e.f(str == null);
                sVar.K(c3 + 8);
                k a2 = k.a(sVar);
                list = a2.f5896a;
                cVar.f5221c = a2.f5897b;
                str = "video/hevc";
            } else if (j3 == c.M0) {
                com.google.android.exoplayer2.util.e.f(str == null);
                str = i8 == c.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (j3 == c.f5198h) {
                com.google.android.exoplayer2.util.e.f(str == null);
                str = "video/3gpp";
            } else if (j3 == c.K) {
                com.google.android.exoplayer2.util.e.f(str == null);
                Pair<String, byte[]> f3 = f(sVar, c3);
                str = (String) f3.first;
                list = Collections.singletonList(f3.second);
            } else if (j3 == c.j0) {
                f2 = m(sVar, c3);
                z = true;
            } else if (j3 == c.I0) {
                bArr = n(sVar, c3, j2);
            } else if (j3 == c.H0) {
                int y = sVar.y();
                sVar.L(3);
                if (y == 0) {
                    int y2 = sVar.y();
                    if (y2 == 0) {
                        i9 = 0;
                    } else if (y2 == 1) {
                        i9 = 1;
                    } else if (y2 == 2) {
                        i9 = 2;
                    } else if (y2 == 3) {
                        i9 = 3;
                    }
                }
            }
            c2 += j2;
        }
        if (str != null) {
            cVar.f5220b = l.G(Integer.toString(i5), str, null, -1, -1, E, E2, -1.0f, list, i6, f2, bArr, i9, null, lVar2);
        }
    }
}
