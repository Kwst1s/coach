package com.google.android.exoplayer2.f0.h;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.f0.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: Id3Decoder */
public final class h implements com.google.android.exoplayer2.f0.b {

    /* renamed from: b  reason: collision with root package name */
    public static final int f5742b = d0.B("ID3");

    /* renamed from: a  reason: collision with root package name */
    private final a f5743a;

    /* compiled from: Id3Decoder */
    public interface a {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    /* access modifiers changed from: private */
    /* compiled from: Id3Decoder */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f5744a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5745b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5746c;

        public b(int i2, boolean z, int i3) {
            this.f5744a = i2;
            this.f5745b = z;
            this.f5746c = i3;
        }
    }

    static {
        a aVar = a.f5718a;
    }

    public h() {
        this(null);
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return d0.f7011f;
        }
        return Arrays.copyOfRange(bArr, i2, i3);
    }

    private static b d(s sVar, int i2, int i3) {
        int i4;
        String str;
        int y = sVar.y();
        String t = t(y);
        int i5 = i2 - 1;
        byte[] bArr = new byte[i5];
        sVar.h(bArr, 0, i5);
        if (i3 == 2) {
            str = "image/" + d0.h0(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i4 = 2;
        } else {
            i4 = w(bArr, 0);
            String h0 = d0.h0(new String(bArr, 0, i4, "ISO-8859-1"));
            if (h0.indexOf(47) == -1) {
                str = "image/" + h0;
            } else {
                str = h0;
            }
        }
        int i6 = i4 + 2;
        int v = v(bArr, i6, y);
        return new b(str, new String(bArr, i6, v - i6, t), bArr[i4 + 1] & 255, b(bArr, v + s(y), i5));
    }

    private static c e(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.h(bArr, 0, i2);
        return new c(str, bArr);
    }

    private static d f(s sVar, int i2, int i3, boolean z, int i4, a aVar) {
        int c2 = sVar.c();
        int w = w(sVar.f7062a, c2);
        String str = new String(sVar.f7062a, c2, w - c2, "ISO-8859-1");
        sVar.K(w + 1);
        int j2 = sVar.j();
        int j3 = sVar.j();
        long A = sVar.A();
        long j4 = A == 4294967295L ? -1 : A;
        long A2 = sVar.A();
        long j5 = A2 == 4294967295L ? -1 : A2;
        ArrayList arrayList = new ArrayList();
        int i5 = c2 + i2;
        while (sVar.c() < i5) {
            i i6 = i(i3, sVar, z, i4, aVar);
            if (i6 != null) {
                arrayList.add(i6);
            }
        }
        i[] iVarArr = new i[arrayList.size()];
        arrayList.toArray(iVarArr);
        return new d(str, j2, j3, j4, j5, iVarArr);
    }

    private static e g(s sVar, int i2, int i3, boolean z, int i4, a aVar) {
        int c2 = sVar.c();
        int w = w(sVar.f7062a, c2);
        String str = new String(sVar.f7062a, c2, w - c2, "ISO-8859-1");
        sVar.K(w + 1);
        int y = sVar.y();
        boolean z2 = (y & 2) != 0;
        boolean z3 = (y & 1) != 0;
        int y2 = sVar.y();
        String[] strArr = new String[y2];
        for (int i5 = 0; i5 < y2; i5++) {
            int c3 = sVar.c();
            int w2 = w(sVar.f7062a, c3);
            strArr[i5] = new String(sVar.f7062a, c3, w2 - c3, "ISO-8859-1");
            sVar.K(w2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = c2 + i2;
        while (sVar.c() < i6) {
            i i7 = i(i3, sVar, z, i4, aVar);
            if (i7 != null) {
                arrayList.add(i7);
            }
        }
        i[] iVarArr = new i[arrayList.size()];
        arrayList.toArray(iVarArr);
        return new e(str, z2, z3, strArr, iVarArr);
    }

    private static f h(s sVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int y = sVar.y();
        String t = t(y);
        byte[] bArr = new byte[3];
        sVar.h(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        sVar.h(bArr2, 0, i3);
        int v = v(bArr2, 0, y);
        String str2 = new String(bArr2, 0, v, t);
        int s = v + s(y);
        return new f(str, str2, n(bArr2, s, v(bArr2, s, y), t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0190, code lost:
        if (r13 == 67) goto L_0x0192;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.f0.h.i i(int r19, com.google.android.exoplayer2.util.s r20, boolean r21, int r22, com.google.android.exoplayer2.f0.h.h.a r23) {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f0.h.h.i(int, com.google.android.exoplayer2.util.s, boolean, int, com.google.android.exoplayer2.f0.h.h$a):com.google.android.exoplayer2.f0.h.i");
    }

    private static g j(s sVar, int i2) {
        int y = sVar.y();
        String t = t(y);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.h(bArr, 0, i3);
        int w = w(bArr, 0);
        String str = new String(bArr, 0, w, "ISO-8859-1");
        int i4 = w + 1;
        int v = v(bArr, i4, y);
        String n = n(bArr, i4, v, t);
        int s = v + s(y);
        int v2 = v(bArr, s, y);
        return new g(str, n, n(bArr, s, v2, t), b(bArr, v2 + s(y), i3));
    }

    private static b k(s sVar) {
        if (sVar.a() < 10) {
            m.f("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int B = sVar.B();
        if (B != f5742b) {
            m.f("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + B);
            return null;
        }
        int y = sVar.y();
        boolean z = true;
        sVar.L(1);
        int y2 = sVar.y();
        int x = sVar.x();
        if (y == 2) {
            if ((y2 & 64) != 0) {
                m.f("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (y == 3) {
            if ((y2 & 64) != 0) {
                int j2 = sVar.j();
                sVar.L(j2);
                x -= j2 + 4;
            }
        } else if (y == 4) {
            if ((y2 & 64) != 0) {
                int x2 = sVar.x();
                sVar.L(x2 - 4);
                x -= x2;
            }
            if ((y2 & 16) != 0) {
                x -= 10;
            }
        } else {
            m.f("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + y);
            return null;
        }
        if (y >= 4 || (y2 & 128) == 0) {
            z = false;
        }
        return new b(y, z, x);
    }

    private static k l(s sVar, int i2) {
        int E = sVar.E();
        int B = sVar.B();
        int B2 = sVar.B();
        int y = sVar.y();
        int y2 = sVar.y();
        r rVar = new r();
        rVar.k(sVar);
        int i3 = ((i2 - 10) * 8) / (y + y2);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h2 = rVar.h(y);
            int h3 = rVar.h(y2);
            iArr[i4] = h2;
            iArr2[i4] = h3;
        }
        return new k(E, B, B2, iArr, iArr2);
    }

    private static l m(s sVar, int i2) {
        byte[] bArr = new byte[i2];
        sVar.h(bArr, 0, i2);
        int w = w(bArr, 0);
        return new l(new String(bArr, 0, w, "ISO-8859-1"), b(bArr, w + 1, i2));
    }

    private static String n(byte[] bArr, int i2, int i3, String str) {
        return (i3 <= i2 || i3 > bArr.length) ? BuildConfig.FLAVOR : new String(bArr, i2, i3 - i2, str);
    }

    private static m o(s sVar, int i2, String str) {
        if (i2 < 1) {
            return null;
        }
        int y = sVar.y();
        String t = t(y);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.h(bArr, 0, i3);
        return new m(str, null, new String(bArr, 0, v(bArr, 0, y), t));
    }

    private static m p(s sVar, int i2) {
        if (i2 < 1) {
            return null;
        }
        int y = sVar.y();
        String t = t(y);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.h(bArr, 0, i3);
        int v = v(bArr, 0, y);
        String str = new String(bArr, 0, v, t);
        int s = v + s(y);
        return new m("TXXX", str, n(bArr, s, v(bArr, s, y), t));
    }

    private static n q(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.h(bArr, 0, i2);
        return new n(str, null, new String(bArr, 0, w(bArr, 0), "ISO-8859-1"));
    }

    private static n r(s sVar, int i2) {
        if (i2 < 1) {
            return null;
        }
        int y = sVar.y();
        String t = t(y);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.h(bArr, 0, i3);
        int v = v(bArr, 0, y);
        String str = new String(bArr, 0, v, t);
        int s = v + s(y);
        return new n("WXXX", str, n(bArr, s, w(bArr, s), "ISO-8859-1"));
    }

    private static int s(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static String t(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String u(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private static int v(byte[] bArr, int i2, int i3) {
        int w = w(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return w;
        }
        while (w < bArr.length - 1) {
            if (w % 2 == 0 && bArr[w + 1] == 0) {
                return w;
            }
            w = w(bArr, w + 1);
        }
        return bArr.length;
    }

    private static int w(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    static /* synthetic */ boolean x(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    private static int y(s sVar, int i2) {
        byte[] bArr = sVar.f7062a;
        int c2 = sVar.c();
        while (true) {
            int i3 = c2 + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[c2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, c2 + 2, bArr, i3, (i2 - c2) - 2);
                i2--;
            }
            c2 = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean z(com.google.android.exoplayer2.util.s r18, int r19, int r20, boolean r21) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f0.h.h.z(com.google.android.exoplayer2.util.s, int, int, boolean):boolean");
    }

    @Override // com.google.android.exoplayer2.f0.b
    public com.google.android.exoplayer2.f0.a a(d dVar) {
        ByteBuffer byteBuffer = dVar.f4951d;
        return c(byteBuffer.array(), byteBuffer.limit());
    }

    public com.google.android.exoplayer2.f0.a c(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        s sVar = new s(bArr, i2);
        b k2 = k(sVar);
        if (k2 == null) {
            return null;
        }
        int c2 = sVar.c();
        int i3 = k2.f5744a == 2 ? 6 : 10;
        int i4 = k2.f5746c;
        if (k2.f5745b) {
            i4 = y(sVar, k2.f5746c);
        }
        sVar.J(c2 + i4);
        boolean z = false;
        if (!z(sVar, k2.f5744a, i3, false)) {
            if (k2.f5744a != 4 || !z(sVar, 4, i3, true)) {
                m.f("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + k2.f5744a);
                return null;
            }
            z = true;
        }
        while (sVar.a() >= i3) {
            i i5 = i(k2.f5744a, sVar, z, i3, this.f5743a);
            if (i5 != null) {
                arrayList.add(i5);
            }
        }
        return new com.google.android.exoplayer2.f0.a(arrayList);
    }

    public h(a aVar) {
        this.f5743a = aVar;
    }
}
