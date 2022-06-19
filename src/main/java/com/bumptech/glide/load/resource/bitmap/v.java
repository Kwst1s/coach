package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream */
public class v extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private volatile byte[] f4229b;

    /* renamed from: c  reason: collision with root package name */
    private int f4230c;

    /* renamed from: d  reason: collision with root package name */
    private int f4231d;

    /* renamed from: e  reason: collision with root package name */
    private int f4232e;

    /* renamed from: f  reason: collision with root package name */
    private int f4233f;

    /* renamed from: g  reason: collision with root package name */
    private final b f4234g;

    /* access modifiers changed from: package-private */
    /* compiled from: RecyclableBufferedInputStream */
    public static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public v(InputStream inputStream, b bVar) {
        this(inputStream, bVar, 65536);
    }

    private static IOException G() {
        throw new IOException("BufferedInputStream is closed");
    }

    private int l(InputStream inputStream, byte[] bArr) {
        int i2;
        int i3 = this.f4232e;
        if (i3 == -1 || this.f4233f - i3 >= (i2 = this.f4231d)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f4232e = -1;
                this.f4233f = 0;
                this.f4230c = read;
            }
            return read;
        }
        if (i3 == 0 && i2 > bArr.length && this.f4230c == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i2) {
                i2 = length;
            }
            byte[] bArr2 = (byte[]) this.f4234g.e(i2, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f4229b = bArr2;
            this.f4234g.d(bArr);
            bArr = bArr2;
        } else if (i3 > 0) {
            System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
        }
        int i4 = this.f4233f - this.f4232e;
        this.f4233f = i4;
        this.f4232e = 0;
        this.f4230c = 0;
        int read2 = inputStream.read(bArr, i4, bArr.length - i4);
        int i5 = this.f4233f;
        if (read2 > 0) {
            i5 += read2;
        }
        this.f4230c = i5;
        return read2;
    }

    public synchronized void E() {
        this.f4231d = this.f4229b.length;
    }

    public synchronized void F() {
        if (this.f4229b != null) {
            this.f4234g.d(this.f4229b);
            this.f4229b = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f4229b == null || inputStream == null) {
            G();
            throw null;
        }
        return (this.f4230c - this.f4233f) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        if (this.f4229b != null) {
            this.f4234g.d(this.f4229b);
            this.f4229b = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i2) {
        this.f4231d = Math.max(this.f4231d, i2);
        this.f4232e = this.f4233f;
    }

    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f4229b;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            G();
            throw null;
        } else if (this.f4233f >= this.f4230c && l(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr == this.f4229b || (bArr = this.f4229b) != null) {
                int i2 = this.f4230c;
                int i3 = this.f4233f;
                if (i2 - i3 <= 0) {
                    return -1;
                }
                this.f4233f = i3 + 1;
                return bArr[i3] & 255;
            }
            G();
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f4229b != null) {
            int i2 = this.f4232e;
            if (-1 != i2) {
                this.f4233f = i2;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.f4233f + " markLimit: " + this.f4231d);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) {
        if (j2 < 1) {
            return 0;
        }
        byte[] bArr = this.f4229b;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i2 = this.f4230c;
                int i3 = this.f4233f;
                if (((long) (i2 - i3)) >= j2) {
                    this.f4233f = (int) (((long) i3) + j2);
                    return j2;
                }
                long j3 = ((long) i2) - ((long) i3);
                this.f4233f = i2;
                if (this.f4232e == -1 || j2 > ((long) this.f4231d)) {
                    return j3 + inputStream.skip(j2 - j3);
                } else if (l(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    int i4 = this.f4230c;
                    int i5 = this.f4233f;
                    if (((long) (i4 - i5)) >= j2 - j3) {
                        this.f4233f = (int) ((((long) i5) + j2) - j3);
                        return j2;
                    }
                    long j4 = (j3 + ((long) i4)) - ((long) i5);
                    this.f4233f = i4;
                    return j4;
                }
            } else {
                G();
                throw null;
            }
        } else {
            G();
            throw null;
        }
    }

    v(InputStream inputStream, b bVar, int i2) {
        super(inputStream);
        this.f4232e = -1;
        this.f4234g = bVar;
        this.f4229b = (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        byte[] bArr2 = this.f4229b;
        if (bArr2 == null) {
            G();
            throw null;
        } else if (i3 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i6 = this.f4233f;
                int i7 = this.f4230c;
                if (i6 < i7) {
                    int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                    System.arraycopy(bArr2, i6, bArr, i2, i8);
                    this.f4233f += i8;
                    if (i8 == i3 || inputStream.available() == 0) {
                        return i8;
                    }
                    i2 += i8;
                    i4 = i3 - i8;
                } else {
                    i4 = i3;
                }
                while (true) {
                    int i9 = -1;
                    if (this.f4232e == -1 && i4 >= bArr2.length) {
                        i5 = inputStream.read(bArr, i2, i4);
                        if (i5 == -1) {
                            if (i4 != i3) {
                                i9 = i3 - i4;
                            }
                            return i9;
                        }
                    } else if (l(inputStream, bArr2) == -1) {
                        if (i4 != i3) {
                            i9 = i3 - i4;
                        }
                        return i9;
                    } else if (bArr2 == this.f4229b || (bArr2 = this.f4229b) != null) {
                        int i10 = this.f4230c;
                        int i11 = this.f4233f;
                        i5 = i10 - i11 >= i4 ? i4 : i10 - i11;
                        System.arraycopy(bArr2, i11, bArr, i2, i5);
                        this.f4233f += i5;
                    } else {
                        G();
                        throw null;
                    }
                    i4 -= i5;
                    if (i4 == 0) {
                        return i3;
                    }
                    if (inputStream.available() == 0) {
                        return i3 - i4;
                    }
                    i2 += i5;
                }
            } else {
                G();
                throw null;
            }
        }
    }
}
