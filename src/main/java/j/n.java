package j;

import java.nio.ByteBuffer;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: RealBufferedSink */
public final class n implements d {

    /* renamed from: b  reason: collision with root package name */
    public final c f10689b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final s f10690c;

    /* renamed from: d  reason: collision with root package name */
    boolean f10691d;

    n(s sVar) {
        Objects.requireNonNull(sVar, "sink == null");
        this.f10690c = sVar;
    }

    @Override // j.d
    public c a() {
        return this.f10689b;
    }

    @Override // j.s
    public u c() {
        return this.f10690c.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, j.s, java.nio.channels.Channel
    public void close() {
        Throwable th;
        if (!this.f10691d) {
            try {
                c cVar = this.f10689b;
                long j2 = cVar.f10663c;
                if (j2 > 0) {
                    this.f10690c.e(cVar, j2);
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f10690c.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f10691d = true;
            if (th != null) {
                v.e(th);
                throw null;
            }
        }
    }

    @Override // j.d
    public d d(byte[] bArr, int i2, int i3) {
        if (!this.f10691d) {
            this.f10689b.Y(bArr, i2, i3);
            t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.s
    public void e(c cVar, long j2) {
        if (!this.f10691d) {
            this.f10689b.e(cVar, j2);
            t();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d f(long j2) {
        if (!this.f10691d) {
            this.f10689b.c0(j2);
            return t();
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d, j.s, java.io.Flushable
    public void flush() {
        if (!this.f10691d) {
            c cVar = this.f10689b;
            long j2 = cVar.f10663c;
            if (j2 > 0) {
                this.f10690c.e(cVar, j2);
            }
            this.f10690c.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d h(int i2) {
        if (!this.f10691d) {
            this.f10689b.e0(i2);
            t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d i(int i2) {
        if (!this.f10691d) {
            this.f10689b.d0(i2);
            return t();
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f10691d;
    }

    @Override // j.d
    public d p(int i2) {
        if (!this.f10691d) {
            this.f10689b.a0(i2);
            t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d r(byte[] bArr) {
        if (!this.f10691d) {
            this.f10689b.X(bArr);
            t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d t() {
        if (!this.f10691d) {
            long G = this.f10689b.G();
            if (G > 0) {
                this.f10690c.e(this.f10689b, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f10690c + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.f10691d) {
            int write = this.f10689b.write(byteBuffer);
            t();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d y(String str) {
        if (!this.f10691d) {
            this.f10689b.g0(str);
            return t();
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.d
    public d z(long j2) {
        if (!this.f10691d) {
            this.f10689b.b0(j2);
            t();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
