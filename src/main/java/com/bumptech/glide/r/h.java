package com.bumptech.glide.r;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream */
public class h extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private int f4378b = Integer.MIN_VALUE;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    private void E(long j2) {
        int i2 = this.f4378b;
        if (i2 != Integer.MIN_VALUE && j2 != -1) {
            this.f4378b = (int) (((long) i2) - j2);
        }
    }

    private long l(long j2) {
        int i2 = this.f4378b;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : (long) i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i2 = this.f4378b;
        if (i2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i2, super.available());
    }

    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f4378b = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (l(1) == -1) {
            return -1;
        }
        int read = super.read();
        E(1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f4378b = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        long l = l(j2);
        if (l == -1) {
            return 0;
        }
        long skip = super.skip(l);
        E(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int l = (int) l((long) i3);
        if (l == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, l);
        E((long) read);
        return read;
    }
}
