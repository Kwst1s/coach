package com.bumptech.glide.load.m;

import com.bumptech.glide.load.engine.z.b;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream */
public final class c extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    private final OutputStream f3937b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f3938c;

    /* renamed from: d  reason: collision with root package name */
    private b f3939d;

    /* renamed from: e  reason: collision with root package name */
    private int f3940e;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void E() {
        if (this.f3940e == this.f3938c.length) {
            l();
        }
    }

    private void F() {
        byte[] bArr = this.f3938c;
        if (bArr != null) {
            this.f3939d.d(bArr);
            this.f3938c = null;
        }
    }

    private void l() {
        int i2 = this.f3940e;
        if (i2 > 0) {
            this.f3937b.write(this.f3938c, 0, i2);
            this.f3940e = 0;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f3937b.close();
            F();
        } catch (Throwable th) {
            this.f3937b.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        l();
        this.f3937b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        byte[] bArr = this.f3938c;
        int i3 = this.f3940e;
        this.f3940e = i3 + 1;
        bArr[i3] = (byte) i2;
        E();
    }

    c(OutputStream outputStream, b bVar, int i2) {
        this.f3937b = outputStream;
        this.f3939d = bVar;
        this.f3938c = (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f3940e;
            if (i7 != 0 || i5 < this.f3938c.length) {
                int min = Math.min(i5, this.f3938c.length - i7);
                System.arraycopy(bArr, i6, this.f3938c, this.f3940e, min);
                this.f3940e += min;
                i4 += min;
                E();
            } else {
                this.f3937b.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
