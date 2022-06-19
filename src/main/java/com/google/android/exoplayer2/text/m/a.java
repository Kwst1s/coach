package com.google.android.exoplayer2.text.m;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* compiled from: PgsDecoder */
public final class a extends b {
    private final s n = new s();
    private final s o = new s();
    private final C0139a p = new C0139a();
    private Inflater q;

    /* access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.m.a$a  reason: collision with other inner class name */
    /* compiled from: PgsDecoder */
    public static final class C0139a {

        /* renamed from: a  reason: collision with root package name */
        private final s f6762a = new s();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f6763b = new int[256];

        /* renamed from: c  reason: collision with root package name */
        private boolean f6764c;

        /* renamed from: d  reason: collision with root package name */
        private int f6765d;

        /* renamed from: e  reason: collision with root package name */
        private int f6766e;

        /* renamed from: f  reason: collision with root package name */
        private int f6767f;

        /* renamed from: g  reason: collision with root package name */
        private int f6768g;

        /* renamed from: h  reason: collision with root package name */
        private int f6769h;

        /* renamed from: i  reason: collision with root package name */
        private int f6770i;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void e(s sVar, int i2) {
            int B;
            if (i2 >= 4) {
                sVar.L(3);
                int i3 = i2 - 4;
                if ((sVar.y() & 128) != 0) {
                    if (i3 >= 7 && (B = sVar.B()) >= 4) {
                        this.f6769h = sVar.E();
                        this.f6770i = sVar.E();
                        this.f6762a.H(B - 4);
                        i3 -= 7;
                    } else {
                        return;
                    }
                }
                int c2 = this.f6762a.c();
                int d2 = this.f6762a.d();
                if (c2 < d2 && i3 > 0) {
                    int min = Math.min(i3, d2 - c2);
                    sVar.h(this.f6762a.f7062a, c2, min);
                    this.f6762a.K(c2 + min);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void f(s sVar, int i2) {
            if (i2 >= 19) {
                this.f6765d = sVar.E();
                this.f6766e = sVar.E();
                sVar.L(11);
                this.f6767f = sVar.E();
                this.f6768g = sVar.E();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void g(s sVar, int i2) {
            if (i2 % 5 == 2) {
                sVar.L(2);
                Arrays.fill(this.f6763b, 0);
                int i3 = i2 / 5;
                for (int i4 = 0; i4 < i3; i4++) {
                    int y = sVar.y();
                    int y2 = sVar.y();
                    int y3 = sVar.y();
                    int y4 = sVar.y();
                    int y5 = sVar.y();
                    double d2 = (double) y2;
                    double d3 = (double) (y3 - 128);
                    Double.isNaN(d3);
                    Double.isNaN(d2);
                    double d4 = (double) (y4 - 128);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    int[] iArr = this.f6763b;
                    int n = d0.n((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255) << 8;
                    iArr[y] = d0.n((int) (d2 + (d4 * 1.772d)), 0, 255) | n | (y5 << 24) | (d0.n((int) ((1.402d * d3) + d2), 0, 255) << 16);
                }
                this.f6764c = true;
            }
        }

        public com.google.android.exoplayer2.text.a d() {
            int i2;
            int i3;
            int i4;
            if (this.f6765d == 0 || this.f6766e == 0 || this.f6769h == 0 || this.f6770i == 0 || this.f6762a.d() == 0 || this.f6762a.c() != this.f6762a.d() || !this.f6764c) {
                return null;
            }
            this.f6762a.K(0);
            int i5 = this.f6769h * this.f6770i;
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int y = this.f6762a.y();
                if (y != 0) {
                    i4 = i6 + 1;
                    iArr[i6] = this.f6763b[y];
                } else {
                    int y2 = this.f6762a.y();
                    if (y2 != 0) {
                        if ((y2 & 64) == 0) {
                            i2 = y2 & 63;
                        } else {
                            i2 = ((y2 & 63) << 8) | this.f6762a.y();
                        }
                        if ((y2 & 128) == 0) {
                            i3 = 0;
                        } else {
                            i3 = this.f6763b[this.f6762a.y()];
                        }
                        i4 = i2 + i6;
                        Arrays.fill(iArr, i6, i4, i3);
                    }
                }
                i6 = i4;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.f6769h, this.f6770i, Bitmap.Config.ARGB_8888);
            int i7 = this.f6765d;
            float f2 = ((float) this.f6767f) / ((float) i7);
            int i8 = this.f6766e;
            return new com.google.android.exoplayer2.text.a(createBitmap, f2, 0, ((float) this.f6768g) / ((float) i8), 0, ((float) this.f6769h) / ((float) i7), ((float) this.f6770i) / ((float) i8));
        }

        public void h() {
            this.f6765d = 0;
            this.f6766e = 0;
            this.f6767f = 0;
            this.f6768g = 0;
            this.f6769h = 0;
            this.f6770i = 0;
            this.f6762a.H(0);
            this.f6764c = false;
        }
    }

    public a() {
        super("PgsDecoder");
    }

    private void C(s sVar) {
        if (sVar.a() > 0 && sVar.f() == 120) {
            if (this.q == null) {
                this.q = new Inflater();
            }
            if (d0.L(sVar, this.o, this.q)) {
                s sVar2 = this.o;
                sVar.I(sVar2.f7062a, sVar2.d());
            }
        }
    }

    private static com.google.android.exoplayer2.text.a D(s sVar, C0139a aVar) {
        int d2 = sVar.d();
        int y = sVar.y();
        int E = sVar.E();
        int c2 = sVar.c() + E;
        com.google.android.exoplayer2.text.a aVar2 = null;
        if (c2 > d2) {
            sVar.K(d2);
            return null;
        }
        if (y != 128) {
            switch (y) {
                case 20:
                    aVar.g(sVar, E);
                    break;
                case 21:
                    aVar.e(sVar, E);
                    break;
                case 22:
                    aVar.f(sVar, E);
                    break;
            }
        } else {
            aVar2 = aVar.d();
            aVar.h();
        }
        sVar.K(c2);
        return aVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.b
    public d z(byte[] bArr, int i2, boolean z) {
        this.n.I(bArr, i2);
        C(this.n);
        this.p.h();
        ArrayList arrayList = new ArrayList();
        while (this.n.a() >= 3) {
            com.google.android.exoplayer2.text.a D = D(this.n, this.p);
            if (D != null) {
                arrayList.add(D);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
