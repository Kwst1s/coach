package com.google.android.exoplayer2.text.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: DvbParser */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f6711h = {0, 7, 8, 15};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f6712i = {0, 119, -120, -1};

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f6713j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f6714a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f6715b;

    /* renamed from: c  reason: collision with root package name */
    private final Canvas f6716c = new Canvas();

    /* renamed from: d  reason: collision with root package name */
    private final C0138b f6717d = new C0138b(719, 575, 0, 719, 0, 575);

    /* renamed from: e  reason: collision with root package name */
    private final a f6718e = new a(0, c(), d(), e());

    /* renamed from: f  reason: collision with root package name */
    private final h f6719f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f6720g;

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6721a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f6722b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f6723c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f6724d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f6721a = i2;
            this.f6722b = iArr;
            this.f6723c = iArr2;
            this.f6724d = iArr3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.l.b$b  reason: collision with other inner class name */
    /* compiled from: DvbParser */
    public static final class C0138b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6725a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6726b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6727c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6728d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6729e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6730f;

        public C0138b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f6725a = i2;
            this.f6726b = i3;
            this.f6727c = i4;
            this.f6728d = i5;
            this.f6729e = i6;
            this.f6730f = i7;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f6731a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6732b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f6733c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f6734d;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f6731a = i2;
            this.f6732b = z;
            this.f6733c = bArr;
            this.f6734d = bArr2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f6735a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6736b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<e> f6737c;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.f6735a = i3;
            this.f6736b = i4;
            this.f6737c = sparseArray;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f6738a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6739b;

        public e(int i2, int i3) {
            this.f6738a = i2;
            this.f6739b = i3;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f6740a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6741b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6742c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6743d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6744e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6745f;

        /* renamed from: g  reason: collision with root package name */
        public final int f6746g;

        /* renamed from: h  reason: collision with root package name */
        public final int f6747h;

        /* renamed from: i  reason: collision with root package name */
        public final int f6748i;

        /* renamed from: j  reason: collision with root package name */
        public final SparseArray<g> f6749j;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f6740a = i2;
            this.f6741b = z;
            this.f6742c = i3;
            this.f6743d = i4;
            this.f6744e = i6;
            this.f6745f = i7;
            this.f6746g = i8;
            this.f6747h = i9;
            this.f6748i = i10;
            this.f6749j = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.f6749j;
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    this.f6749j.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f6750a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6751b;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f6750a = i4;
            this.f6751b = i5;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DvbParser */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f6752a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6753b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f6754c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f6755d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f6756e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f6757f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f6758g = new SparseArray<>();

        /* renamed from: h  reason: collision with root package name */
        public C0138b f6759h;

        /* renamed from: i  reason: collision with root package name */
        public d f6760i;

        public h(int i2, int i3) {
            this.f6752a = i2;
            this.f6753b = i3;
        }

        public void a() {
            this.f6754c.clear();
            this.f6755d.clear();
            this.f6756e.clear();
            this.f6757f.clear();
            this.f6758g.clear();
            this.f6759h = null;
            this.f6760i = null;
        }
    }

    public b(int i2, int i3) {
        Paint paint = new Paint();
        this.f6714a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f6715b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f6719f = new h(i2, i3);
    }

    private static byte[] a(int i2, int i3, r rVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) rVar.h(i3);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = f(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = f(63, i4, i5, i3);
            } else {
                int i6 = i2 & 136;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = f(255, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + 127;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = f(255, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = f(255, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = f(127, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    private static int f(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0065 */
    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[LOOP:0: B:1:0x0009->B:31:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int g(com.google.android.exoplayer2.util.r r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.l.b.g(com.google.android.exoplayer2.util.r, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0072 */
    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[LOOP:0: B:1:0x0009->B:34:0x008e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int h(com.google.android.exoplayer2.util.r r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.l.b.h(com.google.android.exoplayer2.util.r, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0039 */
    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    private static int i(r rVar, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        int i4;
        boolean z;
        byte b2;
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            int h2 = rVar.h(8);
            if (h2 != 0) {
                z = z2;
                i4 = 1;
                b2 = h2;
            } else if (!rVar.g()) {
                int h3 = rVar.h(7);
                if (h3 != 0) {
                    z = z2;
                    i4 = h3;
                    b2 = 0;
                } else {
                    b2 = 0;
                    z = true;
                    i4 = 0;
                }
            } else {
                z = z2;
                i4 = rVar.h(7);
                b2 = rVar.h(8);
            }
            if (!(i4 == 0 || paint == null)) {
                if (bArr != 0) {
                    b2 = bArr[b2];
                }
                paint.setColor(iArr[b2 == true ? 1 : 0]);
                canvas.drawRect((float) i5, (float) i3, (float) (i5 + i4), (float) (i3 + 1), paint);
            }
            i5 += i4;
            if (z) {
                return i5;
            }
            z2 = z;
        }
    }

    private static void j(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        r rVar = new r(bArr);
        int i5 = i3;
        int i6 = i4;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        while (rVar.b() != 0) {
            int h2 = rVar.h(8);
            if (h2 != 240) {
                switch (h2) {
                    case 16:
                        if (i2 == 3) {
                            bArr3 = bArr4 == null ? f6712i : bArr4;
                        } else if (i2 == 2) {
                            bArr3 = bArr5 == null ? f6711h : bArr5;
                        } else {
                            bArr2 = null;
                            i5 = g(rVar, iArr, bArr2, i5, i6, paint, canvas);
                            rVar.c();
                            continue;
                        }
                        bArr2 = bArr3;
                        i5 = g(rVar, iArr, bArr2, i5, i6, paint, canvas);
                        rVar.c();
                        continue;
                    case 17:
                        i5 = h(rVar, iArr, i2 == 3 ? f6713j : null, i5, i6, paint, canvas);
                        rVar.c();
                        continue;
                    case 18:
                        i5 = i(rVar, iArr, null, i5, i6, paint, canvas);
                        continue;
                    default:
                        switch (h2) {
                            case 32:
                                bArr5 = a(4, 4, rVar);
                                continue;
                            case 33:
                                bArr4 = a(4, 8, rVar);
                                continue;
                            case 34:
                                bArr4 = a(16, 8, rVar);
                                continue;
                            default:
                                continue;
                        }
                }
            } else {
                i6 += 2;
                i5 = i3;
            }
        }
    }

    private static void k(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i2 == 3) {
            iArr = aVar.f6724d;
        } else if (i2 == 2) {
            iArr = aVar.f6723c;
        } else {
            iArr = aVar.f6722b;
        }
        j(cVar.f6733c, iArr, i2, i3, i4, paint, canvas);
        j(cVar.f6734d, iArr, i2, i3, i4 + 1, paint, canvas);
    }

    private static a l(r rVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 8;
        int h2 = rVar.h(8);
        rVar.p(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] c2 = c();
        int[] d2 = d();
        int[] e2 = e();
        while (i10 > 0) {
            int h3 = rVar.h(i8);
            int h4 = rVar.h(i8);
            int i11 = i10 - 2;
            int[] iArr = (h4 & 128) != 0 ? c2 : (h4 & 64) != 0 ? d2 : e2;
            if ((h4 & 1) != 0) {
                i6 = rVar.h(i8);
                i5 = rVar.h(i8);
                i4 = rVar.h(i8);
                i3 = rVar.h(i8);
                i7 = i11 - 4;
            } else {
                int h5 = rVar.h(4) << 4;
                i4 = rVar.h(4) << 4;
                i7 = i11 - 2;
                i3 = rVar.h(i9) << 6;
                i6 = rVar.h(6) << i9;
                i5 = h5;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = 255;
            }
            double d3 = (double) i6;
            double d4 = (double) (i5 - 128);
            Double.isNaN(d4);
            Double.isNaN(d3);
            double d5 = (double) (i4 - 128);
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d5);
            Double.isNaN(d3);
            iArr[h3] = f((byte) (255 - (i3 & 255)), d0.n((int) (d3 + (1.402d * d4)), 0, 255), d0.n((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), d0.n((int) (d3 + (d5 * 1.772d)), 0, 255));
            i10 = i7;
            h2 = h2;
            i8 = 8;
            i9 = 2;
        }
        return new a(h2, c2, d2, e2);
    }

    private static C0138b m(r rVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        rVar.p(4);
        boolean g2 = rVar.g();
        rVar.p(3);
        int h2 = rVar.h(16);
        int h3 = rVar.h(16);
        if (g2) {
            int h4 = rVar.h(16);
            int h5 = rVar.h(16);
            int h6 = rVar.h(16);
            i2 = rVar.h(16);
            i4 = h5;
            i3 = h6;
            i5 = h4;
        } else {
            i4 = h2;
            i2 = h3;
            i5 = 0;
            i3 = 0;
        }
        return new C0138b(h2, h3, i5, i4, i3, i2);
    }

    private static c n(r rVar) {
        byte[] bArr;
        int h2 = rVar.h(16);
        rVar.p(4);
        int h3 = rVar.h(2);
        boolean g2 = rVar.g();
        rVar.p(1);
        byte[] bArr2 = null;
        if (h3 == 1) {
            rVar.p(rVar.h(8) * 16);
        } else if (h3 == 0) {
            int h4 = rVar.h(16);
            int h5 = rVar.h(16);
            if (h4 > 0) {
                bArr2 = new byte[h4];
                rVar.j(bArr2, 0, h4);
            }
            if (h5 > 0) {
                bArr = new byte[h5];
                rVar.j(bArr, 0, h5);
                return new c(h2, g2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h2, g2, bArr2, bArr);
    }

    private static d o(r rVar, int i2) {
        int h2 = rVar.h(8);
        int h3 = rVar.h(4);
        int h4 = rVar.h(2);
        rVar.p(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int h5 = rVar.h(8);
            rVar.p(8);
            i3 -= 6;
            sparseArray.put(h5, new e(rVar.h(16), rVar.h(16)));
        }
        return new d(h2, h3, h4, sparseArray);
    }

    private static f p(r rVar, int i2) {
        int i3;
        int i4;
        int h2 = rVar.h(8);
        rVar.p(4);
        boolean g2 = rVar.g();
        rVar.p(3);
        int i5 = 16;
        int h3 = rVar.h(16);
        int h4 = rVar.h(16);
        int h5 = rVar.h(3);
        int h6 = rVar.h(3);
        int i6 = 2;
        rVar.p(2);
        int h7 = rVar.h(8);
        int h8 = rVar.h(8);
        int h9 = rVar.h(4);
        int h10 = rVar.h(2);
        rVar.p(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int h11 = rVar.h(i5);
            int h12 = rVar.h(i6);
            int h13 = rVar.h(i6);
            int h14 = rVar.h(12);
            rVar.p(4);
            int h15 = rVar.h(12);
            i7 -= 6;
            if (h12 == 1 || h12 == 2) {
                i7 -= 2;
                i4 = rVar.h(8);
                i3 = rVar.h(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(h11, new g(h12, h13, h14, h15, i4, i3));
            h10 = h10;
            i6 = 2;
            i5 = 16;
        }
        return new f(h2, g2, h3, h4, h5, h6, h7, h8, h9, h10, sparseArray);
    }

    private static void q(r rVar, h hVar) {
        int h2 = rVar.h(8);
        int h3 = rVar.h(16);
        int h4 = rVar.h(16);
        int d2 = rVar.d() + h4;
        if (h4 * 8 > rVar.b()) {
            m.f("DvbParser", "Data field length exceeds limit");
            rVar.p(rVar.b());
            return;
        }
        switch (h2) {
            case 16:
                if (h3 == hVar.f6752a) {
                    d dVar = hVar.f6760i;
                    d o = o(rVar, h4);
                    if (o.f6736b == 0) {
                        if (!(dVar == null || dVar.f6735a == o.f6735a)) {
                            hVar.f6760i = o;
                            break;
                        }
                    } else {
                        hVar.f6760i = o;
                        hVar.f6754c.clear();
                        hVar.f6755d.clear();
                        hVar.f6756e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f6760i;
                if (h3 == hVar.f6752a && dVar2 != null) {
                    f p = p(rVar, h4);
                    if (dVar2.f6736b == 0) {
                        p.a(hVar.f6754c.get(p.f6740a));
                    }
                    hVar.f6754c.put(p.f6740a, p);
                    break;
                }
            case 18:
                if (h3 != hVar.f6752a) {
                    if (h3 == hVar.f6753b) {
                        a l = l(rVar, h4);
                        hVar.f6757f.put(l.f6721a, l);
                        break;
                    }
                } else {
                    a l2 = l(rVar, h4);
                    hVar.f6755d.put(l2.f6721a, l2);
                    break;
                }
                break;
            case 19:
                if (h3 != hVar.f6752a) {
                    if (h3 == hVar.f6753b) {
                        c n = n(rVar);
                        hVar.f6758g.put(n.f6731a, n);
                        break;
                    }
                } else {
                    c n2 = n(rVar);
                    hVar.f6756e.put(n2.f6731a, n2);
                    break;
                }
                break;
            case 20:
                if (h3 == hVar.f6752a) {
                    hVar.f6759h = m(rVar);
                    break;
                }
                break;
        }
        rVar.q(d2 - rVar.d());
    }

    public List<com.google.android.exoplayer2.text.a> b(byte[] bArr, int i2) {
        int i3;
        int i4;
        SparseArray<g> sparseArray;
        r rVar = new r(bArr, i2);
        while (rVar.b() >= 48 && rVar.h(8) == 15) {
            q(rVar, this.f6719f);
        }
        h hVar = this.f6719f;
        if (hVar.f6760i == null) {
            return Collections.emptyList();
        }
        C0138b bVar = hVar.f6759h;
        if (bVar == null) {
            bVar = this.f6717d;
        }
        Bitmap bitmap = this.f6720g;
        if (!(bitmap != null && bVar.f6725a + 1 == bitmap.getWidth() && bVar.f6726b + 1 == this.f6720g.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.f6725a + 1, bVar.f6726b + 1, Bitmap.Config.ARGB_8888);
            this.f6720g = createBitmap;
            this.f6716c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.f6719f.f6760i.f6737c;
        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
            e valueAt = sparseArray2.valueAt(i5);
            f fVar = this.f6719f.f6754c.get(sparseArray2.keyAt(i5));
            int i6 = valueAt.f6738a + bVar.f6727c;
            int i7 = valueAt.f6739b + bVar.f6729e;
            float f2 = (float) i6;
            float f3 = (float) i7;
            this.f6716c.clipRect(f2, f3, (float) Math.min(fVar.f6742c + i6, bVar.f6728d), (float) Math.min(fVar.f6743d + i7, bVar.f6730f), Region.Op.REPLACE);
            a aVar = this.f6719f.f6755d.get(fVar.f6745f);
            if (aVar == null && (aVar = this.f6719f.f6757f.get(fVar.f6745f)) == null) {
                aVar = this.f6718e;
            }
            SparseArray<g> sparseArray3 = fVar.f6749j;
            int i8 = 0;
            while (i8 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i8);
                g valueAt2 = sparseArray3.valueAt(i8);
                c cVar = this.f6719f.f6756e.get(keyAt);
                c cVar2 = cVar == null ? this.f6719f.f6758g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i4 = i8;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f6744e, valueAt2.f6750a + i6, i7 + valueAt2.f6751b, cVar2.f6732b ? null : this.f6714a, this.f6716c);
                } else {
                    i4 = i8;
                    sparseArray = sparseArray3;
                }
                i8 = i4 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f6741b) {
                int i9 = fVar.f6744e;
                if (i9 == 3) {
                    i3 = aVar.f6724d[fVar.f6746g];
                } else if (i9 == 2) {
                    i3 = aVar.f6723c[fVar.f6747h];
                } else {
                    i3 = aVar.f6722b[fVar.f6748i];
                }
                this.f6715b.setColor(i3);
                this.f6716c.drawRect(f2, f3, (float) (fVar.f6742c + i6), (float) (fVar.f6743d + i7), this.f6715b);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f6720g, i6, i7, fVar.f6742c, fVar.f6743d);
            int i10 = bVar.f6725a;
            int i11 = bVar.f6726b;
            arrayList.add(new com.google.android.exoplayer2.text.a(createBitmap2, f2 / ((float) i10), 0, f3 / ((float) i11), 0, ((float) fVar.f6742c) / ((float) i10), ((float) fVar.f6743d) / ((float) i11)));
            this.f6716c.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public void r() {
        this.f6719f.a();
    }
}
