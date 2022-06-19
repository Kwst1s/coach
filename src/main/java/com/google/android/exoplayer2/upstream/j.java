package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.e;
import java.io.InputStream;

/* compiled from: DataSourceInputStream */
public final class j extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private final i f6916b;

    /* renamed from: c  reason: collision with root package name */
    private final k f6917c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6918d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6919e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6920f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f6921g;

    public j(i iVar, k kVar) {
        this.f6916b = iVar;
        this.f6917c = kVar;
        this.f6918d = new byte[1];
    }

    private void l() {
        if (!this.f6919e) {
            this.f6916b.b(this.f6917c);
            this.f6919e = true;
        }
    }

    public void E() {
        l();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        if (!this.f6920f) {
            this.f6916b.close();
            this.f6920f = true;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f6918d) == -1) {
            return -1;
        }
        return this.f6918d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        e.f(!this.f6920f);
        l();
        int a2 = this.f6916b.a(bArr, i2, i3);
        if (a2 == -1) {
            return -1;
        }
        this.f6921g += (long) a2;
        return a2;
    }
}
