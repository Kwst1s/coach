package com.bumptech.glide.load.m;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: ExifOrientationStream */
public final class g extends FilterInputStream {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f3944d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f3945e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f3946f;

    /* renamed from: b  reason: collision with root package name */
    private final byte f3947b;

    /* renamed from: c  reason: collision with root package name */
    private int f3948c;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f3944d = bArr;
        int length = bArr.length;
        f3945e = length;
        f3946f = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
        }
        this.f3947b = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i2;
        int i3;
        int i4 = this.f3948c;
        if (i4 < 2 || i4 > (i3 = f3946f)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f3947b;
        } else {
            i2 = f3944d[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f3948c++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f3948c = (int) (((long) this.f3948c) + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = this.f3948c;
        int i6 = f3946f;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f3947b;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f3944d, this.f3948c - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f3948c += i4;
        }
        return i4;
    }
}
