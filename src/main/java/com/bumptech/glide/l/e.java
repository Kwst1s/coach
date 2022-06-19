package com.bumptech.glide.l;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.l.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder */
public class e implements a {
    private static final String u = "e";

    /* renamed from: a  reason: collision with root package name */
    private int[] f3613a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f3614b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0086a f3615c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f3616d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f3617e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f3618f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f3619g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f3620h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f3621i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f3622j;

    /* renamed from: k  reason: collision with root package name */
    private int f3623k;
    private c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    public e(a.AbstractC0086a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        q(cVar, byteBuffer, i2);
    }

    private int i(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.p + i2; i10++) {
            byte[] bArr = this.f3621i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f3613a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.p + i12; i13++) {
            byte[] bArr2 = this.f3621i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f3613a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void j(b bVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f3622j;
        int i7 = bVar.f3590d;
        int i8 = this.p;
        int i9 = i7 / i8;
        int i10 = bVar.f3588b / i8;
        int i11 = bVar.f3589c / i8;
        int i12 = bVar.f3587a / i8;
        boolean z2 = this.f3623k == 0;
        int i13 = this.r;
        int i14 = this.q;
        byte[] bArr = this.f3621i;
        int[] iArr2 = this.f3613a;
        Boolean bool = this.s;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i16 < i9) {
            Boolean bool2 = bool;
            if (bVar.f3591e) {
                if (i17 >= i9) {
                    i2 = i9;
                    int i19 = i18 + 1;
                    if (i19 == 2) {
                        i18 = i19;
                        i17 = 4;
                    } else if (i19 == 3) {
                        i18 = i19;
                        i17 = 2;
                        i15 = 4;
                    } else if (i19 != 4) {
                        i18 = i19;
                    } else {
                        i18 = i19;
                        i17 = 1;
                        i15 = 2;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i17 + i15;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z3 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i16 * i8 * bVar.f3589c;
                if (z3) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = iArr2[bArr[i25] & 255];
                        if (i27 != 0) {
                            iArr[i26] = i27;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i10;
                    }
                } else {
                    i6 = i10;
                    int i28 = ((i23 - i22) * i8) + i25;
                    int i29 = i22;
                    while (true) {
                        i5 = i11;
                        if (i29 >= i23) {
                            break;
                        }
                        int i30 = i(i25, i28, bVar.f3589c);
                        if (i30 != 0) {
                            iArr[i29] = i30;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i29++;
                        i11 = i5;
                    }
                    bool = bool2;
                    i16++;
                    i10 = i6;
                    i11 = i5;
                    i9 = i2;
                    i17 = i4;
                }
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i16++;
            i10 = i6;
            i11 = i5;
            i9 = i2;
            i17 = i4;
        }
        if (this.s == null) {
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            this.s = Boolean.valueOf(z);
        }
    }

    private void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f3622j;
        int i2 = bVar2.f3590d;
        int i3 = bVar2.f3588b;
        int i4 = bVar2.f3589c;
        int i5 = bVar2.f3587a;
        boolean z = this.f3623k == 0;
        int i6 = this.r;
        byte[] bArr = this.f3621i;
        int[] iArr2 = this.f3613a;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f3589c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = b3 & 255;
                if (i14 != b2) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                i2 = i2;
            }
            i7++;
            bVar2 = bVar;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b2 != -1));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x00f7 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r7v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void l(b bVar) {
        int i2;
        int i3;
        short s2;
        e eVar = this;
        if (bVar != null) {
            eVar.f3616d.position(bVar.f3596j);
        }
        if (bVar == null) {
            c cVar = eVar.l;
            i2 = cVar.f3603f;
            i3 = cVar.f3604g;
        } else {
            i2 = bVar.f3589c;
            i3 = bVar.f3590d;
        }
        int i4 = i2 * i3;
        byte[] bArr = eVar.f3621i;
        if (bArr == null || bArr.length < i4) {
            eVar.f3621i = eVar.f3615c.c(i4);
        }
        byte[] bArr2 = eVar.f3621i;
        if (eVar.f3618f == null) {
            eVar.f3618f = new short[4096];
        }
        short[] sArr = eVar.f3618f;
        if (eVar.f3619g == null) {
            eVar.f3619g = new byte[4096];
        }
        byte[] bArr3 = eVar.f3619g;
        if (eVar.f3620h == null) {
            eVar.f3620h = new byte[4097];
        }
        byte[] bArr4 = eVar.f3620h;
        int p2 = p();
        int i5 = 1 << p2;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = p2 + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = eVar.f3617e;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (i15 == 0) {
                i15 = o();
                if (i15 <= 0) {
                    eVar.o = 3;
                    break;
                }
                i16 = 0;
            }
            i18 += (bArr5[i16] & 255) << i17;
            i16++;
            i15--;
            int i23 = i17 + 8;
            int i24 = i13;
            int i25 = i12;
            int i26 = i20;
            int i27 = i21;
            while (true) {
                if (i23 < i25) {
                    i20 = i26;
                    i13 = i24;
                    i17 = i23;
                    eVar = this;
                    i21 = i27;
                    i8 = i8;
                    i12 = i25;
                    break;
                }
                int i28 = i18 & i14;
                i18 >>= i25;
                i23 -= i25;
                if (i28 == i5) {
                    i14 = i9;
                    i25 = i8;
                    i24 = i7;
                    i7 = i24;
                    i26 = -1;
                } else if (i28 == i6) {
                    i17 = i23;
                    i21 = i27;
                    i13 = i24;
                    i8 = i8;
                    i7 = i7;
                    i20 = i26;
                    i12 = i25;
                    eVar = this;
                    break;
                } else if (i26 == -1) {
                    bArr2[i19] = bArr3[i28];
                    i19++;
                    i10++;
                    i26 = i28;
                    i27 = i26;
                    i7 = i7;
                    i23 = i23;
                } else {
                    if (i28 >= i24) {
                        bArr4[i22] = (byte) i27;
                        i22++;
                        s2 = i26;
                    } else {
                        s2 = i28;
                    }
                    while (s2 >= i5) {
                        bArr4[i22] = bArr3[s2];
                        i22++;
                        s2 = sArr[s2];
                    }
                    i27 = bArr3[s2] & 255;
                    byte b2 = (byte) i27;
                    bArr2[i19] = b2;
                    while (true) {
                        i19++;
                        i10++;
                        if (i22 <= 0) {
                            break;
                        }
                        i22--;
                        bArr2[i19] = bArr4[i22];
                    }
                    if (i24 < 4096) {
                        sArr[i24] = (short) i26;
                        bArr3[i24] = b2;
                        i24++;
                        if ((i24 & i14) == 0 && i24 < 4096) {
                            i25++;
                            i14 += i24;
                        }
                    }
                    i26 = i28;
                    i7 = i7;
                    i23 = i23;
                    bArr4 = bArr4;
                }
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    private Bitmap n() {
        Boolean bool = this.s;
        Bitmap a2 = this.f3615c.a(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        a2.setHasAlpha(true);
        return a2;
    }

    private int o() {
        int p2 = p();
        if (p2 <= 0) {
            return p2;
        }
        ByteBuffer byteBuffer = this.f3616d;
        byteBuffer.get(this.f3617e, 0, Math.min(p2, byteBuffer.remaining()));
        return p2;
    }

    private int p() {
        return this.f3616d.get() & 255;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f3622j;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.f3615c.f(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f3593g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.f3593g) > 0) {
            if (i3 == 2) {
                if (!bVar.f3592f) {
                    c cVar = this.l;
                    int i5 = cVar.l;
                    if (bVar.f3597k == null || cVar.f3607j != bVar.f3594h) {
                        i4 = i5;
                    }
                }
                int i6 = bVar2.f3590d;
                int i7 = this.p;
                int i8 = i6 / i7;
                int i9 = bVar2.f3588b / i7;
                int i10 = bVar2.f3589c / i7;
                int i11 = bVar2.f3587a / i7;
                int i12 = this.r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.r;
                }
            } else if (i3 == 3 && (bitmap = this.m) != null) {
                int i17 = this.r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.q);
            }
        }
        l(bVar);
        if (bVar.f3591e || this.p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.n && ((i2 = bVar.f3593g) == 0 || i2 == 1)) {
            if (this.m == null) {
                this.m = n();
            }
            Bitmap bitmap3 = this.m;
            int i18 = this.r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        }
        Bitmap n2 = n();
        int i19 = this.r;
        n2.setPixels(iArr, 0, i19, 0, 0, i19, this.q);
        return n2;
    }

    @Override // com.bumptech.glide.l.a
    public int a() {
        return this.f3623k;
    }

    @Override // com.bumptech.glide.l.a
    public synchronized Bitmap b() {
        if (this.l.f3600c <= 0 || this.f3623k < 0) {
            String str = u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.l.f3600c + ", framePointer=" + this.f3623k);
            }
            this.o = 1;
        }
        int i2 = this.o;
        if (i2 != 1) {
            if (i2 != 2) {
                this.o = 0;
                if (this.f3617e == null) {
                    this.f3617e = this.f3615c.c(255);
                }
                b bVar = this.l.f3602e.get(this.f3623k);
                int i3 = this.f3623k - 1;
                b bVar2 = i3 >= 0 ? this.l.f3602e.get(i3) : null;
                int[] iArr = bVar.f3597k;
                if (iArr == null) {
                    iArr = this.l.f3598a;
                }
                this.f3613a = iArr;
                if (iArr == null) {
                    String str2 = u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f3623k);
                    }
                    this.o = 1;
                    return null;
                }
                if (bVar.f3592f) {
                    System.arraycopy(iArr, 0, this.f3614b, 0, iArr.length);
                    int[] iArr2 = this.f3614b;
                    this.f3613a = iArr2;
                    iArr2[bVar.f3594h] = 0;
                    if (bVar.f3593g == 2 && this.f3623k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return r(bVar, bVar2);
            }
        }
        String str3 = u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.o);
        }
        return null;
    }

    @Override // com.bumptech.glide.l.a
    public void c() {
        this.f3623k = (this.f3623k + 1) % this.l.f3600c;
    }

    @Override // com.bumptech.glide.l.a
    public void clear() {
        this.l = null;
        byte[] bArr = this.f3621i;
        if (bArr != null) {
            this.f3615c.b(bArr);
        }
        int[] iArr = this.f3622j;
        if (iArr != null) {
            this.f3615c.d(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f3615c.f(bitmap);
        }
        this.m = null;
        this.f3616d = null;
        this.s = null;
        byte[] bArr2 = this.f3617e;
        if (bArr2 != null) {
            this.f3615c.b(bArr2);
        }
    }

    @Override // com.bumptech.glide.l.a
    public int d() {
        return this.l.f3600c;
    }

    @Override // com.bumptech.glide.l.a
    public int e() {
        int i2;
        if (this.l.f3600c <= 0 || (i2 = this.f3623k) < 0) {
            return 0;
        }
        return m(i2);
    }

    @Override // com.bumptech.glide.l.a
    public int f() {
        return this.f3616d.limit() + this.f3621i.length + (this.f3622j.length * 4);
    }

    @Override // com.bumptech.glide.l.a
    public void g(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // com.bumptech.glide.l.a
    public ByteBuffer getData() {
        return this.f3616d;
    }

    @Override // com.bumptech.glide.l.a
    public void h() {
        this.f3623k = -1;
    }

    public int m(int i2) {
        if (i2 >= 0) {
            c cVar = this.l;
            if (i2 < cVar.f3600c) {
                return cVar.f3602e.get(i2).f3595i;
            }
        }
        return -1;
    }

    public synchronized void q(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.o = 0;
            this.l = cVar;
            this.f3623k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f3616d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f3616d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator<b> it = cVar.f3602e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f3593g == 3) {
                        this.n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.p = highestOneBit;
            int i3 = cVar.f3603f;
            this.r = i3 / highestOneBit;
            int i4 = cVar.f3604g;
            this.q = i4 / highestOneBit;
            this.f3621i = this.f3615c.c(i3 * i4);
            this.f3622j = this.f3615c.e(this.r * this.q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public e(a.AbstractC0086a aVar) {
        this.f3614b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.f3615c = aVar;
        this.l = new c();
    }
}
