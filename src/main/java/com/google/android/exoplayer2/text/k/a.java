package com.google.android.exoplayer2.text.k;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.constraintlayout.widget.i;
import b.a.j;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.g;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Cea608Decoder */
public final class a extends e {
    private static final int[] s = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] t = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] u = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] v = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, i.B0, i.C0, i.D0, i.E0, i.F0, 106, i.G0, i.H0, i.I0, 110, 111, 112, 113, j.y0, j.z0, j.A0, j.B0, j.C0, j.D0, j.E0, j.F0, j.G0, 231, 247, 209, 241, 9632};
    private static final int[] w = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] x = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] y = {195, 227, 205, 204, 236, 210, 242, 213, 245, j.H0, 125, 92, 94, 95, j.I0, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: g  reason: collision with root package name */
    private final s f6664g = new s();

    /* renamed from: h  reason: collision with root package name */
    private final int f6665h;

    /* renamed from: i  reason: collision with root package name */
    private final int f6666i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<C0136a> f6667j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private C0136a f6668k = new C0136a(0, 4);
    private List<com.google.android.exoplayer2.text.a> l;
    private List<com.google.android.exoplayer2.text.a> m;
    private int n;
    private int o;
    private boolean p;
    private byte q;
    private byte r;

    /* access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.k.a$a  reason: collision with other inner class name */
    /* compiled from: Cea608Decoder */
    public static class C0136a {

        /* renamed from: a  reason: collision with root package name */
        private final List<C0137a> f6669a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f6670b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f6671c = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        private int f6672d;

        /* renamed from: e  reason: collision with root package name */
        private int f6673e;

        /* renamed from: f  reason: collision with root package name */
        private int f6674f;

        /* renamed from: g  reason: collision with root package name */
        private int f6675g;

        /* renamed from: h  reason: collision with root package name */
        private int f6676h;

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.k.a$a$a  reason: collision with other inner class name */
        /* compiled from: Cea608Decoder */
        public static class C0137a {

            /* renamed from: a  reason: collision with root package name */
            public final int f6677a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f6678b;

            /* renamed from: c  reason: collision with root package name */
            public int f6679c;

            public C0137a(int i2, boolean z, int i3) {
                this.f6677a = i2;
                this.f6678b = z;
                this.f6679c = i3;
            }
        }

        public C0136a(int i2, int i3) {
            g(i2);
            i(i3);
        }

        private static void j(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            }
        }

        private static void l(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i2, i3, 33);
        }

        private static void p(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }

        public void a(char c2) {
            this.f6671c.append(c2);
        }

        public void b() {
            int length = this.f6671c.length();
            if (length > 0) {
                this.f6671c.delete(length - 1, length);
                for (int size = this.f6669a.size() - 1; size >= 0; size--) {
                    C0137a aVar = this.f6669a.get(size);
                    int i2 = aVar.f6679c;
                    if (i2 == length) {
                        aVar.f6679c = i2 - 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public com.google.android.exoplayer2.text.a c() {
            int i2;
            float f2;
            int i3;
            int i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f6670b.size(); i5++) {
                spannableStringBuilder.append((CharSequence) this.f6670b.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f6673e + this.f6674f;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (this.f6675g == 2 && (Math.abs(i7) < 3 || length < 0)) {
                f2 = 0.5f;
                i2 = 1;
            } else if (this.f6675g != 2 || i7 <= 0) {
                f2 = ((((float) i6) / 32.0f) * 0.8f) + 0.1f;
                i2 = 0;
            } else {
                f2 = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.f6675g == 1 || (i4 = this.f6672d) > 7) {
                i4 = (this.f6672d - 15) - 2;
                i3 = 2;
            } else {
                i3 = 0;
            }
            return new com.google.android.exoplayer2.text.a(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i4, 1, i3, f2, i2, Float.MIN_VALUE);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f6671c);
            int length = spannableStringBuilder.length();
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            boolean z = false;
            while (i2 < this.f6669a.size()) {
                C0137a aVar = this.f6669a.get(i2);
                boolean z2 = aVar.f6678b;
                int i8 = aVar.f6677a;
                if (i8 != 8) {
                    boolean z3 = i8 == 7;
                    if (i8 != 7) {
                        i7 = a.u[i8];
                    }
                    z = z3;
                }
                int i9 = aVar.f6679c;
                i2++;
                if (i9 != (i2 < this.f6669a.size() ? this.f6669a.get(i2).f6679c : length)) {
                    if (i3 != -1 && !z2) {
                        p(spannableStringBuilder, i3, i9);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i9;
                    }
                    if (i4 != -1 && !z) {
                        l(spannableStringBuilder, i4, i9);
                        i4 = -1;
                    } else if (i4 == -1 && z) {
                        i4 = i9;
                    }
                    if (i7 != i6) {
                        j(spannableStringBuilder, i5, i9, i6);
                        i6 = i7;
                        i5 = i9;
                    }
                }
            }
            if (!(i3 == -1 || i3 == length)) {
                p(spannableStringBuilder, i3, length);
            }
            if (!(i4 == -1 || i4 == length)) {
                l(spannableStringBuilder, i4, length);
            }
            if (i5 != length) {
                j(spannableStringBuilder, i5, length, i6);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public int e() {
            return this.f6672d;
        }

        public boolean f() {
            return this.f6669a.isEmpty() && this.f6670b.isEmpty() && this.f6671c.length() == 0;
        }

        public void g(int i2) {
            this.f6675g = i2;
            this.f6669a.clear();
            this.f6670b.clear();
            this.f6671c.setLength(0);
            this.f6672d = 15;
            this.f6673e = 0;
            this.f6674f = 0;
        }

        public void h() {
            this.f6670b.add(d());
            this.f6671c.setLength(0);
            this.f6669a.clear();
            int min = Math.min(this.f6676h, this.f6672d);
            while (this.f6670b.size() >= min) {
                this.f6670b.remove(0);
            }
        }

        public void i(int i2) {
            this.f6676h = i2;
        }

        public void k(int i2) {
            this.f6673e = i2;
        }

        public void m(int i2) {
            this.f6672d = i2;
        }

        public void n(int i2, boolean z) {
            this.f6669a.add(new C0137a(i2, z, this.f6671c.length()));
        }

        public void o(int i2) {
            this.f6674f = i2;
        }

        public String toString() {
            return this.f6671c.toString();
        }
    }

    public a(String str, int i2) {
        this.f6665h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 3 || i2 == 4) {
            this.f6666i = 2;
        } else {
            this.f6666i = 1;
        }
        D(0);
        C();
    }

    private static boolean A(byte b2) {
        return (b2 & 240) == 16;
    }

    private static boolean B(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private void C() {
        this.f6668k.g(this.n);
        this.f6667j.clear();
        this.f6667j.add(this.f6668k);
    }

    private void D(int i2) {
        int i3 = this.n;
        if (i3 != i2) {
            this.n = i2;
            C();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.l = null;
            }
        }
    }

    private void E(int i2) {
        this.o = i2;
        this.f6668k.i(i2);
    }

    private static char o(byte b2) {
        return (char) v[(b2 & Byte.MAX_VALUE) - 32];
    }

    private List<com.google.android.exoplayer2.text.a> p() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f6667j.size(); i2++) {
            com.google.android.exoplayer2.text.a c2 = this.f6667j.get(i2).c();
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    private static char q(byte b2) {
        return (char) x[b2 & 31];
    }

    private static char r(byte b2) {
        return (char) y[b2 & 31];
    }

    private static char s(byte b2) {
        return (char) w[b2 & 15];
    }

    private boolean t(byte b2, byte b3) {
        boolean A = A(b2);
        if (A) {
            if (this.p && this.q == b2 && this.r == b3) {
                this.p = false;
                return true;
            }
            this.p = true;
            this.q = b2;
            this.r = b3;
        }
        if (x(b2, b3)) {
            u(b3);
        } else if (z(b2, b3)) {
            w(b2, b3);
        } else if (B(b2, b3)) {
            this.f6668k.o(b3 - 32);
        } else if (y(b2, b3)) {
            v(b3);
        }
        return A;
    }

    private void u(byte b2) {
        this.f6668k.a(' ');
        this.f6668k.n((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    private void v(byte b2) {
        if (b2 == 32) {
            D(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    D(1);
                    E(2);
                    return;
                case 38:
                    D(1);
                    E(3);
                    return;
                case 39:
                    D(1);
                    E(4);
                    return;
                default:
                    int i2 = this.n;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.l = null;
                                    if (i2 == 1 || i2 == 3) {
                                        C();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 == 1 && !this.f6668k.f()) {
                                        this.f6668k.h();
                                        return;
                                    }
                                    return;
                                case 46:
                                    C();
                                    return;
                                case 47:
                                    this.l = p();
                                    C();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.f6668k.b();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            D(3);
        }
    }

    private void w(byte b2, byte b3) {
        int i2 = s[b2 & 7];
        boolean z = false;
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.f6668k.e()) {
            if (this.n != 1 && !this.f6668k.f()) {
                C0136a aVar = new C0136a(this.n, this.o);
                this.f6668k = aVar;
                this.f6667j.add(aVar);
            }
            this.f6668k.m(i2);
        }
        boolean z2 = (b3 & 16) == 16;
        if ((b3 & 1) == 1) {
            z = true;
        }
        int i3 = (b3 >> 1) & 7;
        this.f6668k.n(z2 ? 8 : i3, z);
        if (z2) {
            this.f6668k.k(t[i3]);
        }
    }

    private static boolean x(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean y(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    private static boolean z(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    @Override // com.google.android.exoplayer2.d0.c, com.google.android.exoplayer2.text.k.e
    public void a() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.k.e
    public d f() {
        List<com.google.android.exoplayer2.text.a> list = this.l;
        this.m = list;
        return new f(list);
    }

    @Override // com.google.android.exoplayer2.d0.c, com.google.android.exoplayer2.text.k.e
    public void flush() {
        super.flush();
        this.l = null;
        this.m = null;
        D(0);
        E(4);
        C();
        this.p = false;
        this.q = 0;
        this.r = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.k.e
    public void g(g gVar) {
        byte b2;
        int i2;
        this.f6664g.I(gVar.f4951d.array(), gVar.f4951d.limit());
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int a2 = this.f6664g.a();
            int i3 = this.f6665h;
            if (a2 < i3) {
                break;
            }
            if (i3 == 2) {
                b2 = -4;
            } else {
                b2 = (byte) this.f6664g.y();
            }
            byte y2 = (byte) (this.f6664g.y() & 127);
            byte y3 = (byte) (this.f6664g.y() & 127);
            if ((b2 & 6) == 4 && (((i2 = this.f6666i) != 1 || (b2 & 1) == 0) && ((i2 != 2 || (b2 & 1) == 1) && !(y2 == 0 && y3 == 0)))) {
                if ((y2 & 247) == 17 && (y3 & 240) == 48) {
                    this.f6668k.a(s(y3));
                } else if ((y2 & 246) == 18 && (y3 & 224) == 32) {
                    this.f6668k.b();
                    if ((y2 & 1) == 0) {
                        this.f6668k.a(q(y3));
                    } else {
                        this.f6668k.a(r(y3));
                    }
                } else if ((y2 & 224) == 0) {
                    z2 = t(y2, y3);
                } else {
                    this.f6668k.a(o(y2));
                    if ((y3 & 224) != 0) {
                        this.f6668k.a(o(y3));
                    }
                }
                z = true;
            }
        }
        if (z) {
            if (!z2) {
                this.p = false;
            }
            int i4 = this.n;
            if (i4 == 1 || i4 == 3) {
                this.l = p();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.k.e
    public boolean j() {
        return this.l != this.m;
    }
}
