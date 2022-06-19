package com.bumptech.glide.k;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class b implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f3580b;

    /* renamed from: c  reason: collision with root package name */
    private final Charset f3581c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f3582d;

    /* renamed from: e  reason: collision with root package name */
    private int f3583e;

    /* renamed from: f  reason: collision with root package name */
    private int f3584f;

    /* compiled from: StrictLineReader */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f3581c.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void E() {
        InputStream inputStream = this.f3580b;
        byte[] bArr = this.f3582d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f3583e = 0;
            this.f3584f = read;
            return;
        }
        throw new EOFException();
    }

    public boolean F() {
        return this.f3584f == -1;
    }

    public String G() {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f3580b) {
            if (this.f3582d != null) {
                if (this.f3583e >= this.f3584f) {
                    E();
                }
                for (int i4 = this.f3583e; i4 != this.f3584f; i4++) {
                    byte[] bArr2 = this.f3582d;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.f3583e) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.f3582d;
                                int i5 = this.f3583e;
                                String str = new String(bArr3, i5, i3 - i5, this.f3581c.name());
                                this.f3583e = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.f3582d;
                        int i52 = this.f3583e;
                        String str2 = new String(bArr32, i52, i3 - i52, this.f3581c.name());
                        this.f3583e = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f3584f - this.f3583e) + 80);
                loop1:
                while (true) {
                    byte[] bArr4 = this.f3582d;
                    int i6 = this.f3583e;
                    aVar.write(bArr4, i6, this.f3584f - i6);
                    this.f3584f = -1;
                    E();
                    i2 = this.f3583e;
                    while (true) {
                        if (i2 != this.f3584f) {
                            bArr = this.f3582d;
                            if (bArr[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                int i7 = this.f3583e;
                if (i2 != i7) {
                    aVar.write(bArr, i7, i2 - i7);
                }
                this.f3583e = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3580b) {
            if (this.f3582d != null) {
                this.f3582d = null;
                this.f3580b.close();
            }
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f3586a)) {
            this.f3580b = inputStream;
            this.f3581c = charset;
            this.f3582d = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
