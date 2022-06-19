package com.google.android.exoplayer2.text.k;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import b.a.j;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.g;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Cea708Decoder */
public final class c extends e {

    /* renamed from: g  reason: collision with root package name */
    private final s f6681g = new s();

    /* renamed from: h  reason: collision with root package name */
    private final r f6682h = new r();

    /* renamed from: i  reason: collision with root package name */
    private final int f6683i;

    /* renamed from: j  reason: collision with root package name */
    private final a[] f6684j;

    /* renamed from: k  reason: collision with root package name */
    private a f6685k;
    private List<com.google.android.exoplayer2.text.a> l;
    private List<com.google.android.exoplayer2.text.a> m;
    private b n;
    private int o;

    /* access modifiers changed from: private */
    /* compiled from: Cea708Decoder */
    public static final class a {
        private static final int[] A = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] B = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] C = {false, false, false, true, true, true, false};
        private static final int[] D;
        private static final int[] E = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] F = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] G;
        public static final int w = h(2, 2, 2, 0);
        public static final int x;
        public static final int y;
        private static final int[] z = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: a  reason: collision with root package name */
        private final List<SpannableString> f6686a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final SpannableStringBuilder f6687b = new SpannableStringBuilder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f6688c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6689d;

        /* renamed from: e  reason: collision with root package name */
        private int f6690e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6691f;

        /* renamed from: g  reason: collision with root package name */
        private int f6692g;

        /* renamed from: h  reason: collision with root package name */
        private int f6693h;

        /* renamed from: i  reason: collision with root package name */
        private int f6694i;

        /* renamed from: j  reason: collision with root package name */
        private int f6695j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6696k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;

        static {
            int h2 = h(0, 0, 0, 0);
            x = h2;
            int h3 = h(0, 0, 0, 3);
            y = h3;
            D = new int[]{h2, h3, h2, h2, h3, h2, h2};
            G = new int[]{h2, h2, h2, h2, h2, h3, h3};
        }

        public a() {
            l();
        }

        public static int g(int i2, int i3, int i4) {
            return h(i2, i3, i4, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.e.c(r4, r0, r1)
                com.google.android.exoplayer2.util.e.c(r5, r0, r1)
                com.google.android.exoplayer2.util.e.c(r6, r0, r1)
                com.google.android.exoplayer2.util.e.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.k.c.a.h(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == '\n') {
                this.f6686a.add(d());
                this.f6687b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while (true) {
                    if ((this.f6696k && this.f6686a.size() >= this.f6695j) || this.f6686a.size() >= 15) {
                        this.f6686a.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.f6687b.append(c2);
            }
        }

        public void b() {
            int length = this.f6687b.length();
            if (length > 0) {
                this.f6687b.delete(length - 1, length);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.text.k.b c() {
            /*
            // Method dump skipped, instructions count: 192
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.k.c.a.c():com.google.android.exoplayer2.text.k.b");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f6687b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f6686a.clear();
            this.f6687b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f6688c = true;
            this.f6689d = z2;
            this.f6696k = z3;
            this.f6690e = i2;
            this.f6691f = z5;
            this.f6692g = i3;
            this.f6693h = i4;
            this.f6694i = i7;
            int i10 = i5 + 1;
            if (this.f6695j != i10) {
                this.f6695j = i10;
                while (true) {
                    if ((!z3 || this.f6686a.size() < this.f6695j) && this.f6686a.size() < 15) {
                        break;
                    }
                    this.f6686a.remove(0);
                }
            }
            if (!(i8 == 0 || this.m == i8)) {
                this.m = i8;
                int i11 = i8 - 1;
                q(D[i11], y, C[i11], 0, A[i11], B[i11], z[i11]);
            }
            if (i9 != 0 && this.n != i9) {
                this.n = i9;
                int i12 = i9 - 1;
                m(0, 1, 1, false, false, F[i12], E[i12]);
                n(w, G[i12], x);
            }
        }

        public boolean i() {
            return this.f6688c;
        }

        public boolean j() {
            return !i() || (this.f6686a.isEmpty() && this.f6687b.length() == 0);
        }

        public boolean k() {
            return this.f6689d;
        }

        public void l() {
            e();
            this.f6688c = false;
            this.f6689d = false;
            this.f6690e = 4;
            this.f6691f = false;
            this.f6692g = 0;
            this.f6693h = 0;
            this.f6694i = 0;
            this.f6695j = 15;
            this.f6696k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i2 = x;
            this.o = i2;
            this.s = w;
            this.u = i2;
        }

        public void m(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.p != -1) {
                if (!z2) {
                    this.f6687b.setSpan(new StyleSpan(2), this.p, this.f6687b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.f6687b.length();
            }
            if (this.q != -1) {
                if (!z3) {
                    this.f6687b.setSpan(new UnderlineSpan(), this.q, this.f6687b.length(), 33);
                    this.q = -1;
                }
            } else if (z3) {
                this.q = this.f6687b.length();
            }
        }

        public void n(int i2, int i3, int i4) {
            if (!(this.r == -1 || this.s == i2)) {
                this.f6687b.setSpan(new ForegroundColorSpan(this.s), this.r, this.f6687b.length(), 33);
            }
            if (i2 != w) {
                this.r = this.f6687b.length();
                this.s = i2;
            }
            if (!(this.t == -1 || this.u == i3)) {
                this.f6687b.setSpan(new BackgroundColorSpan(this.u), this.t, this.f6687b.length(), 33);
            }
            if (i3 != x) {
                this.t = this.f6687b.length();
                this.u = i3;
            }
        }

        public void o(int i2, int i3) {
            if (this.v != i2) {
                a('\n');
            }
            this.v = i2;
        }

        public void p(boolean z2) {
            this.f6689d = z2;
        }

        public void q(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.o = i2;
            this.l = i7;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Cea708Decoder */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6697a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6698b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f6699c;

        /* renamed from: d  reason: collision with root package name */
        int f6700d = 0;

        public b(int i2, int i3) {
            this.f6697a = i2;
            this.f6698b = i3;
            this.f6699c = new byte[((i3 * 2) - 1)];
        }
    }

    public c(int i2, List<byte[]> list) {
        this.f6683i = i2 == -1 ? 1 : i2;
        this.f6684j = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f6684j[i3] = new a();
        }
        this.f6685k = this.f6684j[0];
        D();
    }

    private void A() {
        this.f6682h.p(4);
        int h2 = this.f6682h.h(4);
        this.f6682h.p(2);
        this.f6685k.o(h2, this.f6682h.h(6));
    }

    private void B() {
        int h2 = a.h(this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2));
        int h3 = this.f6682h.h(2);
        int g2 = a.g(this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2));
        if (this.f6682h.g()) {
            h3 |= 4;
        }
        boolean g3 = this.f6682h.g();
        int h4 = this.f6682h.h(2);
        int h5 = this.f6682h.h(2);
        int h6 = this.f6682h.h(2);
        this.f6682h.p(8);
        this.f6685k.q(h2, g2, g3, h3, h4, h5, h6);
    }

    private void C() {
        b bVar = this.n;
        int i2 = bVar.f6700d;
        if (i2 != (bVar.f6698b * 2) - 1) {
            m.f("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.n.f6698b * 2) - 1) + ", but current index is " + this.n.f6700d + " (sequence number " + this.n.f6697a + "); ignoring packet");
            return;
        }
        this.f6682h.m(bVar.f6699c, i2);
        int h2 = this.f6682h.h(3);
        int h3 = this.f6682h.h(5);
        if (h2 == 7) {
            this.f6682h.p(2);
            h2 = this.f6682h.h(6);
            if (h2 < 7) {
                m.f("Cea708Decoder", "Invalid extended service number: " + h2);
            }
        }
        if (h3 == 0) {
            if (h2 != 0) {
                m.f("Cea708Decoder", "serviceNumber is non-zero (" + h2 + ") when blockSize is 0");
            }
        } else if (h2 == this.f6683i) {
            boolean z = false;
            while (this.f6682h.b() > 0) {
                int h4 = this.f6682h.h(8);
                if (h4 == 16) {
                    int h5 = this.f6682h.h(8);
                    if (h5 <= 31) {
                        r(h5);
                    } else if (h5 <= 127) {
                        w(h5);
                    } else if (h5 <= 159) {
                        s(h5);
                    } else if (h5 <= 255) {
                        x(h5);
                    } else {
                        m.f("Cea708Decoder", "Invalid extended command: " + h5);
                    }
                } else if (h4 <= 31) {
                    p(h4);
                } else if (h4 <= 127) {
                    u(h4);
                } else if (h4 <= 159) {
                    q(h4);
                } else if (h4 <= 255) {
                    v(h4);
                } else {
                    m.f("Cea708Decoder", "Invalid base command: " + h4);
                }
                z = true;
            }
            if (z) {
                this.l = o();
            }
        }
    }

    private void D() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f6684j[i2].l();
        }
    }

    private void n() {
        if (this.n != null) {
            C();
            this.n = null;
        }
    }

    private List<com.google.android.exoplayer2.text.a> o() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f6684j[i2].j() && this.f6684j[i2].k()) {
                arrayList.add(this.f6684j[i2].c());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void p(int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.l = o();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    D();
                    return;
                case 13:
                    this.f6685k.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        m.f("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        this.f6682h.p(8);
                        return;
                    } else if (i2 < 24 || i2 > 31) {
                        m.f("Cea708Decoder", "Invalid C0 command: " + i2);
                        return;
                    } else {
                        m.f("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i2);
                        this.f6682h.p(16);
                        return;
                    }
            }
        } else {
            this.f6685k.b();
        }
    }

    private void q(int i2) {
        int i3 = 1;
        switch (i2) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i4 = i2 - 128;
                if (this.o != i4) {
                    this.o = i4;
                    this.f6685k = this.f6684j[i4];
                    return;
                }
                return;
            case 136:
                while (i3 <= 8) {
                    if (this.f6682h.g()) {
                        this.f6684j[8 - i3].e();
                    }
                    i3++;
                }
                return;
            case 137:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.f6682h.g()) {
                        this.f6684j[8 - i5].p(true);
                    }
                }
                return;
            case 138:
                while (i3 <= 8) {
                    if (this.f6682h.g()) {
                        this.f6684j[8 - i3].p(false);
                    }
                    i3++;
                }
                return;
            case 139:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.f6682h.g()) {
                        a aVar = this.f6684j[8 - i6];
                        aVar.p(!aVar.k());
                    }
                }
                return;
            case 140:
                while (i3 <= 8) {
                    if (this.f6682h.g()) {
                        this.f6684j[8 - i3].l();
                    }
                    i3++;
                }
                return;
            case 141:
                this.f6682h.p(8);
                return;
            case 142:
                return;
            case 143:
                D();
                return;
            case 144:
                if (!this.f6685k.i()) {
                    this.f6682h.p(16);
                    return;
                } else {
                    y();
                    return;
                }
            case 145:
                if (!this.f6685k.i()) {
                    this.f6682h.p(24);
                    return;
                } else {
                    z();
                    return;
                }
            case 146:
                if (!this.f6685k.i()) {
                    this.f6682h.p(16);
                    return;
                } else {
                    A();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                m.f("Cea708Decoder", "Invalid C1 command: " + i2);
                return;
            case 151:
                if (!this.f6685k.i()) {
                    this.f6682h.p(32);
                    return;
                } else {
                    B();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i7 = i2 - 152;
                t(i7);
                if (this.o != i7) {
                    this.o = i7;
                    this.f6685k = this.f6684j[i7];
                    return;
                }
                return;
        }
    }

    private void r(int i2) {
        if (i2 > 7) {
            if (i2 <= 15) {
                this.f6682h.p(8);
            } else if (i2 <= 23) {
                this.f6682h.p(16);
            } else if (i2 <= 31) {
                this.f6682h.p(24);
            }
        }
    }

    private void s(int i2) {
        if (i2 <= 135) {
            this.f6682h.p(32);
        } else if (i2 <= 143) {
            this.f6682h.p(40);
        } else if (i2 <= 159) {
            this.f6682h.p(2);
            this.f6682h.p(this.f6682h.h(6) * 8);
        }
    }

    private void t(int i2) {
        a aVar = this.f6684j[i2];
        this.f6682h.p(2);
        boolean g2 = this.f6682h.g();
        boolean g3 = this.f6682h.g();
        boolean g4 = this.f6682h.g();
        int h2 = this.f6682h.h(3);
        boolean g5 = this.f6682h.g();
        int h3 = this.f6682h.h(7);
        int h4 = this.f6682h.h(8);
        int h5 = this.f6682h.h(4);
        int h6 = this.f6682h.h(4);
        this.f6682h.p(2);
        int h7 = this.f6682h.h(6);
        this.f6682h.p(2);
        aVar.f(g2, g3, g4, h2, g5, h3, h4, h6, h7, h5, this.f6682h.h(3), this.f6682h.h(3));
    }

    private void u(int i2) {
        if (i2 == 127) {
            this.f6685k.a(9835);
        } else {
            this.f6685k.a((char) (i2 & 255));
        }
    }

    private void v(int i2) {
        this.f6685k.a((char) (i2 & 255));
    }

    private void w(int i2) {
        if (i2 == 32) {
            this.f6685k.a(' ');
        } else if (i2 == 33) {
            this.f6685k.a(160);
        } else if (i2 == 37) {
            this.f6685k.a(8230);
        } else if (i2 == 42) {
            this.f6685k.a(352);
        } else if (i2 == 44) {
            this.f6685k.a(338);
        } else if (i2 == 63) {
            this.f6685k.a(376);
        } else if (i2 == 57) {
            this.f6685k.a(8482);
        } else if (i2 == 58) {
            this.f6685k.a(353);
        } else if (i2 == 60) {
            this.f6685k.a(339);
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    this.f6685k.a(9608);
                    return;
                case 49:
                    this.f6685k.a(8216);
                    return;
                case 50:
                    this.f6685k.a(8217);
                    return;
                case 51:
                    this.f6685k.a(8220);
                    return;
                case 52:
                    this.f6685k.a(8221);
                    return;
                case 53:
                    this.f6685k.a(8226);
                    return;
                default:
                    switch (i2) {
                        case j.C0:
                            this.f6685k.a(8539);
                            return;
                        case j.D0:
                            this.f6685k.a(8540);
                            return;
                        case j.E0:
                            this.f6685k.a(8541);
                            return;
                        case j.F0:
                            this.f6685k.a(8542);
                            return;
                        case j.G0:
                            this.f6685k.a(9474);
                            return;
                        case j.H0:
                            this.f6685k.a(9488);
                            return;
                        case j.I0:
                            this.f6685k.a(9492);
                            return;
                        case 125:
                            this.f6685k.a(9472);
                            return;
                        case 126:
                            this.f6685k.a(9496);
                            return;
                        case 127:
                            this.f6685k.a(9484);
                            return;
                        default:
                            m.f("Cea708Decoder", "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            this.f6685k.a(8480);
        }
    }

    private void x(int i2) {
        if (i2 == 160) {
            this.f6685k.a(13252);
            return;
        }
        m.f("Cea708Decoder", "Invalid G3 character: " + i2);
        this.f6685k.a('_');
    }

    private void y() {
        this.f6685k.m(this.f6682h.h(4), this.f6682h.h(2), this.f6682h.h(2), this.f6682h.g(), this.f6682h.g(), this.f6682h.h(3), this.f6682h.h(3));
    }

    private void z() {
        int h2 = a.h(this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2));
        int h3 = a.h(this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2));
        this.f6682h.p(2);
        this.f6685k.n(h2, h3, a.g(this.f6682h.h(2), this.f6682h.h(2), this.f6682h.h(2)));
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
        this.o = 0;
        this.f6685k = this.f6684j[0];
        D();
        this.n = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.k.e
    public void g(g gVar) {
        this.f6681g.I(gVar.f4951d.array(), gVar.f4951d.limit());
        while (this.f6681g.a() >= 3) {
            int y = this.f6681g.y() & 7;
            int i2 = y & 3;
            boolean z = false;
            boolean z2 = (y & 4) == 4;
            byte y2 = (byte) this.f6681g.y();
            byte y3 = (byte) this.f6681g.y();
            if ((i2 == 2 || i2 == 3) && z2) {
                if (i2 == 3) {
                    n();
                    int i3 = (y2 & 192) >> 6;
                    int i4 = y2 & 63;
                    if (i4 == 0) {
                        i4 = 64;
                    }
                    b bVar = new b(i3, i4);
                    this.n = bVar;
                    byte[] bArr = bVar.f6699c;
                    int i5 = bVar.f6700d;
                    bVar.f6700d = i5 + 1;
                    bArr[i5] = y3;
                } else {
                    if (i2 == 2) {
                        z = true;
                    }
                    e.a(z);
                    b bVar2 = this.n;
                    if (bVar2 == null) {
                        m.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = bVar2.f6699c;
                        int i6 = bVar2.f6700d;
                        int i7 = i6 + 1;
                        bVar2.f6700d = i7;
                        bArr2[i6] = y2;
                        bVar2.f6700d = i7 + 1;
                        bArr2[i7] = y3;
                    }
                }
                b bVar3 = this.n;
                if (bVar3.f6700d == (bVar3.f6698b * 2) - 1) {
                    n();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.k.e
    public boolean j() {
        return this.l != this.m;
    }
}
