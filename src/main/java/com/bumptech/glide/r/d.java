package com.bumptech.glide.r;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class d extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    private static final Queue<d> f4368d = k.e(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f4369b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f4370c;

    d() {
    }

    public static d E(InputStream inputStream) {
        d poll;
        Queue<d> queue = f4368d;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.G(inputStream);
        return poll;
    }

    public void F() {
        this.f4370c = null;
        this.f4369b = null;
        Queue<d> queue = f4368d;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(InputStream inputStream) {
        this.f4369b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f4369b.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        this.f4369b.close();
    }

    public IOException l() {
        return this.f4370c;
    }

    public void mark(int i2) {
        this.f4369b.mark(i2);
    }

    public boolean markSupported() {
        return this.f4369b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f4369b.read(bArr);
        } catch (IOException e2) {
            this.f4370c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f4369b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.f4369b.skip(j2);
        } catch (IOException e2) {
            this.f4370c = e2;
            return 0;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f4369b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f4370c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f4369b.read();
        } catch (IOException e2) {
            this.f4370c = e2;
            return -1;
        }
    }
}
