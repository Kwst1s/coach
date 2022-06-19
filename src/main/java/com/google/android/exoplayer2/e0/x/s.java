package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: NalUnitTargetBuffer */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final int f5609a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5610b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5611c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5612d;

    /* renamed from: e  reason: collision with root package name */
    public int f5613e;

    public s(int i2, int i3) {
        this.f5609a = i2;
        byte[] bArr = new byte[(i3 + 3)];
        this.f5612d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f5610b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f5612d;
            int length = bArr2.length;
            int i5 = this.f5613e;
            if (length < i5 + i4) {
                this.f5612d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f5612d, this.f5613e, i4);
            this.f5613e += i4;
        }
    }

    public boolean b(int i2) {
        if (!this.f5610b) {
            return false;
        }
        this.f5613e -= i2;
        this.f5610b = false;
        this.f5611c = true;
        return true;
    }

    public boolean c() {
        return this.f5611c;
    }

    public void d() {
        this.f5610b = false;
        this.f5611c = false;
    }

    public void e(int i2) {
        boolean z = true;
        e.f(!this.f5610b);
        if (i2 != this.f5609a) {
            z = false;
        }
        this.f5610b = z;
        if (z) {
            this.f5613e = 3;
            this.f5611c = false;
        }
    }
}
