package com.bumptech.glide.l;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3609a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f3610b;

    /* renamed from: c  reason: collision with root package name */
    private c f3611c;

    /* renamed from: d  reason: collision with root package name */
    private int f3612d = 0;

    private boolean b() {
        return this.f3611c.f3599b != 0;
    }

    private int d() {
        try {
            return this.f3610b.get() & 255;
        } catch (Exception unused) {
            this.f3611c.f3599b = 1;
            return 0;
        }
    }

    private void e() {
        this.f3611c.f3601d.f3587a = n();
        this.f3611c.f3601d.f3588b = n();
        this.f3611c.f3601d.f3589c = n();
        this.f3611c.f3601d.f3590d = n();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        b bVar = this.f3611c.f3601d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        bVar.f3591e = z;
        if (z2) {
            bVar.f3597k = g(pow);
        } else {
            bVar.f3597k = null;
        }
        this.f3611c.f3601d.f3596j = this.f3610b.position();
        r();
        if (!b()) {
            c cVar = this.f3611c;
            cVar.f3600c++;
            cVar.f3602e.add(cVar.f3601d);
        }
    }

    private void f() {
        int d2 = d();
        this.f3612d = d2;
        if (d2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    int i4 = this.f3612d;
                    if (i2 < i4) {
                        i3 = i4 - i2;
                        this.f3610b.get(this.f3609a, i2, i3);
                        i2 += i3;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f3612d, e2);
                    }
                    this.f3611c.f3599b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f3610b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f3611c.f3599b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i2) {
        boolean z = false;
        while (!z && !b() && this.f3611c.f3600c <= i2) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    q();
                } else if (d3 == 249) {
                    this.f3611c.f3601d = new b();
                    j();
                } else if (d3 == 254) {
                    q();
                } else if (d3 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f3609a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f3611c;
                if (cVar.f3601d == null) {
                    cVar.f3601d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f3611c.f3599b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int d2 = d();
        b bVar = this.f3611c.f3601d;
        int i2 = (d2 & 28) >> 2;
        bVar.f3593g = i2;
        boolean z = true;
        if (i2 == 0) {
            bVar.f3593g = 1;
        }
        if ((d2 & 1) == 0) {
            z = false;
        }
        bVar.f3592f = z;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f3611c.f3601d;
        bVar2.f3595i = n * 10;
        bVar2.f3594h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f3611c.f3599b = 1;
            return;
        }
        l();
        if (this.f3611c.f3605h && !b()) {
            c cVar = this.f3611c;
            cVar.f3598a = g(cVar.f3606i);
            c cVar2 = this.f3611c;
            cVar2.l = cVar2.f3598a[cVar2.f3607j];
        }
    }

    private void l() {
        this.f3611c.f3603f = n();
        this.f3611c.f3604g = n();
        int d2 = d();
        c cVar = this.f3611c;
        cVar.f3605h = (d2 & 128) != 0;
        cVar.f3606i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.f3611c.f3607j = d();
        this.f3611c.f3608k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f3609a;
            if (bArr[0] == 1) {
                this.f3611c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f3612d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f3610b.getShort();
    }

    private void o() {
        this.f3610b = null;
        Arrays.fill(this.f3609a, (byte) 0);
        this.f3611c = new c();
        this.f3612d = 0;
    }

    private void q() {
        int d2;
        do {
            d2 = d();
            this.f3610b.position(Math.min(this.f3610b.position() + d2, this.f3610b.limit()));
        } while (d2 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f3610b = null;
        this.f3611c = null;
    }

    public c c() {
        if (this.f3610b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f3611c;
        } else {
            k();
            if (!b()) {
                h();
                c cVar = this.f3611c;
                if (cVar.f3600c < 0) {
                    cVar.f3599b = 1;
                }
            }
            return this.f3611c;
        }
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f3610b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f3610b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
