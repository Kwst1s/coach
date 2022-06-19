package com.bumptech.glide.r;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream */
public final class c extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private final long f4366b;

    /* renamed from: c  reason: collision with root package name */
    private int f4367c;

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f4366b = j2;
    }

    public static InputStream E(InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    private int l(int i2) {
        if (i2 >= 0) {
            this.f4367c += i2;
        } else if (this.f4366b - ((long) this.f4367c) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f4366b + ", but read: " + this.f4367c);
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f4366b - ((long) this.f4367c), (long) ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        l(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) {
        int read;
        read = super.read(bArr, i2, i3);
        l(read);
        return read;
    }
}
