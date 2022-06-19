package j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: RealBufferedSource */
public final class o implements e {

    /* renamed from: b  reason: collision with root package name */
    public final c f10692b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final t f10693c;

    /* renamed from: d  reason: collision with root package name */
    boolean f10694d;

    o(t tVar) {
        Objects.requireNonNull(tVar, "source == null");
        this.f10693c = tVar;
    }

    @Override // j.e
    public long A(byte b2) {
        return l(b2, 0, Long.MAX_VALUE);
    }

    @Override // j.e
    public boolean B(long j2, f fVar) {
        return E(j2, fVar, 0, fVar.r());
    }

    @Override // j.e
    public long C() {
        x(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!F((long) i3)) {
                break;
            }
            byte J = this.f10692b.J((long) i2);
            if ((J >= 48 && J <= 57) || ((J >= 97 && J <= 102) || (J >= 65 && J <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(J)));
            }
        }
        return this.f10692b.C();
    }

    @Override // j.e
    public InputStream D() {
        return new a();
    }

    public boolean E(long j2, f fVar, int i2, int i3) {
        if (this.f10694d) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || i2 < 0 || i3 < 0 || fVar.r() - i2 < i3) {
            return false;
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = ((long) i4) + j2;
                if (!(F(1 + j3) && this.f10692b.J(j3) == fVar.j(i2 + i4))) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean F(long j2) {
        c cVar;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.f10694d) {
            do {
                cVar = this.f10692b;
                if (cVar.f10663c >= j2) {
                    return true;
                }
            } while (this.f10693c.v(cVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // j.e
    public c a() {
        return this.f10692b;
    }

    @Override // j.e
    public void b(long j2) {
        if (!this.f10694d) {
            while (j2 > 0) {
                c cVar = this.f10692b;
                if (cVar.f10663c == 0 && this.f10693c.v(cVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f10692b.S());
                this.f10692b.b(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.t
    public u c() {
        return this.f10693c.c();
    }

    @Override // j.t, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (!this.f10694d) {
            this.f10694d = true;
            this.f10693c.close();
            this.f10692b.E();
        }
    }

    @Override // j.e
    public f g(long j2) {
        x(j2);
        return this.f10692b.g(j2);
    }

    public boolean isOpen() {
        return !this.f10694d;
    }

    @Override // j.e
    public String j() {
        return w(Long.MAX_VALUE);
    }

    @Override // j.e
    public byte[] k() {
        this.f10692b.Z(this.f10693c);
        return this.f10692b.k();
    }

    public long l(byte b2, long j2, long j3) {
        if (this.f10694d) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
        } else {
            while (j2 < j3) {
                long K = this.f10692b.K(b2, j2, j3);
                if (K == -1) {
                    c cVar = this.f10692b;
                    long j4 = cVar.f10663c;
                    if (j4 >= j3 || this.f10693c.v(cVar, 8192) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return K;
                }
            }
            return -1;
        }
    }

    @Override // j.e
    public int m() {
        x(4);
        return this.f10692b.m();
    }

    @Override // j.e
    public c n() {
        return this.f10692b;
    }

    @Override // j.e
    public boolean o() {
        if (!this.f10694d) {
            return this.f10692b.o() && this.f10693c.v(this.f10692b, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // j.e
    public byte[] q(long j2) {
        x(j2);
        return this.f10692b.q(j2);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f10692b;
        if (cVar.f10663c == 0 && this.f10693c.v(cVar, 8192) == -1) {
            return -1;
        }
        return this.f10692b.read(byteBuffer);
    }

    @Override // j.e
    public byte readByte() {
        x(1);
        return this.f10692b.readByte();
    }

    @Override // j.e
    public void readFully(byte[] bArr) {
        try {
            x((long) bArr.length);
            this.f10692b.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f10692b;
                long j2 = cVar.f10663c;
                if (j2 > 0) {
                    int M = cVar.M(bArr, i2, (int) j2);
                    if (M != -1) {
                        i2 += M;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // j.e
    public int readInt() {
        x(4);
        return this.f10692b.readInt();
    }

    @Override // j.e
    public short readShort() {
        x(2);
        return this.f10692b.readShort();
    }

    @Override // j.e
    public short s() {
        x(2);
        return this.f10692b.s();
    }

    public String toString() {
        return "buffer(" + this.f10693c + ")";
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    @Override // j.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long u() {
        /*
            r6 = this;
            r0 = 1
            r6.x(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.F(r3)
            if (r3 == 0) goto L_0x0040
            j.c r3 = r6.f10692b
            long r4 = (long) r1
            byte r3 = r3.J(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            j.c r0 = r6.f10692b
            long r0 = r0.u()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.o.u():long");
    }

    @Override // j.t
    public long v(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.f10694d) {
            c cVar2 = this.f10692b;
            if (cVar2.f10663c == 0 && this.f10693c.v(cVar2, 8192) == -1) {
                return -1;
            }
            return this.f10692b.v(cVar, Math.min(j2, this.f10692b.f10663c));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // j.e
    public String w(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            long l = l((byte) 10, 0, j3);
            if (l != -1) {
                return this.f10692b.R(l);
            }
            if (j3 < Long.MAX_VALUE && F(j3) && this.f10692b.J(j3 - 1) == 13 && F(1 + j3) && this.f10692b.J(j3) == 10) {
                return this.f10692b.R(j3);
            }
            c cVar = new c();
            c cVar2 = this.f10692b;
            cVar2.H(cVar, 0, Math.min(32L, cVar2.S()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f10692b.S(), j2) + " content=" + cVar.N().k() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    @Override // j.e
    public void x(long j2) {
        if (!F(j2)) {
            throw new EOFException();
        }
    }

    /* compiled from: RealBufferedSource */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            o oVar = o.this;
            if (!oVar.f10694d) {
                return (int) Math.min(oVar.f10692b.f10663c, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            o.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            o oVar = o.this;
            if (!oVar.f10694d) {
                c cVar = oVar.f10692b;
                if (cVar.f10663c == 0 && oVar.f10693c.v(cVar, 8192) == -1) {
                    return -1;
                }
                return o.this.f10692b.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return o.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            if (!o.this.f10694d) {
                v.b((long) bArr.length, (long) i2, (long) i3);
                o oVar = o.this;
                c cVar = oVar.f10692b;
                if (cVar.f10663c == 0 && oVar.f10693c.v(cVar, 8192) == -1) {
                    return -1;
                }
                return o.this.f10692b.M(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }
}
