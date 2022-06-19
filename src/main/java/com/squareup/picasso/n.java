package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream */
final class n extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f8714b;

    /* renamed from: c  reason: collision with root package name */
    private long f8715c;

    /* renamed from: d  reason: collision with root package name */
    private long f8716d;

    /* renamed from: e  reason: collision with root package name */
    private long f8717e;

    /* renamed from: f  reason: collision with root package name */
    private long f8718f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8719g;

    /* renamed from: h  reason: collision with root package name */
    private int f8720h;

    n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void G(long j2) {
        try {
            long j3 = this.f8716d;
            long j4 = this.f8715c;
            if (j3 >= j4 || j4 > this.f8717e) {
                this.f8716d = j4;
                this.f8714b.mark((int) (j2 - j4));
            } else {
                this.f8714b.reset();
                this.f8714b.mark((int) (j2 - this.f8716d));
                H(this.f8716d, this.f8715c);
            }
            this.f8717e = j2;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    private void H(long j2, long j3) {
        while (j2 < j3) {
            long skip = this.f8714b.skip(j3 - j2);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j2 += skip;
        }
    }

    public void E(long j2) {
        if (this.f8715c > this.f8717e || j2 < this.f8716d) {
            throw new IOException("Cannot reset");
        }
        this.f8714b.reset();
        H(this.f8716d, j2);
        this.f8715c = j2;
    }

    public long F(int i2) {
        long j2 = this.f8715c + ((long) i2);
        if (this.f8717e < j2) {
            G(j2);
        }
        return this.f8715c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f8714b.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        this.f8714b.close();
    }

    public void l(boolean z) {
        this.f8719g = z;
    }

    public void mark(int i2) {
        this.f8718f = F(i2);
    }

    public boolean markSupported() {
        return this.f8714b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.f8719g) {
            long j2 = this.f8717e;
            if (this.f8715c + 1 > j2) {
                G(j2 + ((long) this.f8720h));
            }
        }
        int read = this.f8714b.read();
        if (read != -1) {
            this.f8715c++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() {
        E(this.f8718f);
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        if (!this.f8719g) {
            long j3 = this.f8715c;
            if (j3 + j2 > this.f8717e) {
                G(j3 + j2 + ((long) this.f8720h));
            }
        }
        long skip = this.f8714b.skip(j2);
        this.f8715c += skip;
        return skip;
    }

    n(InputStream inputStream, int i2) {
        this(inputStream, i2, 1024);
    }

    private n(InputStream inputStream, int i2, int i3) {
        this.f8718f = -1;
        this.f8719g = true;
        this.f8720h = -1;
        this.f8714b = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i2) : inputStream;
        this.f8720h = i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        if (!this.f8719g) {
            long j2 = this.f8715c;
            if (((long) bArr.length) + j2 > this.f8717e) {
                G(j2 + ((long) bArr.length) + ((long) this.f8720h));
            }
        }
        int read = this.f8714b.read(bArr);
        if (read != -1) {
            this.f8715c += (long) read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        if (!this.f8719g) {
            long j2 = this.f8715c;
            long j3 = (long) i3;
            if (j2 + j3 > this.f8717e) {
                G(j2 + j3 + ((long) this.f8720h));
            }
        }
        int read = this.f8714b.read(bArr, i2, i3);
        if (read != -1) {
            this.f8715c += (long) read;
        }
        return read;
    }
}
