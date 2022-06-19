package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class j implements t {

    /* renamed from: b  reason: collision with root package name */
    private int f10673b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final e f10674c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f10675d;

    /* renamed from: e  reason: collision with root package name */
    private final k f10676e;

    /* renamed from: f  reason: collision with root package name */
    private final CRC32 f10677f = new CRC32();

    public j(t tVar) {
        if (tVar != null) {
            Inflater inflater = new Inflater(true);
            this.f10675d = inflater;
            e d2 = l.d(tVar);
            this.f10674c = d2;
            this.f10676e = new k(d2, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void E() {
        this.f10674c.x(10);
        byte J = this.f10674c.a().J(3);
        boolean z = ((J >> 1) & 1) == 1;
        if (z) {
            G(this.f10674c.a(), 0, 10);
        }
        l("ID1ID2", 8075, this.f10674c.readShort());
        this.f10674c.b(8);
        if (((J >> 2) & 1) == 1) {
            this.f10674c.x(2);
            if (z) {
                G(this.f10674c.a(), 0, 2);
            }
            long s = (long) this.f10674c.a().s();
            this.f10674c.x(s);
            if (z) {
                G(this.f10674c.a(), 0, s);
            }
            this.f10674c.b(s);
        }
        if (((J >> 3) & 1) == 1) {
            long A = this.f10674c.A((byte) 0);
            if (A != -1) {
                if (z) {
                    G(this.f10674c.a(), 0, A + 1);
                }
                this.f10674c.b(A + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((J >> 4) & 1) == 1) {
            long A2 = this.f10674c.A((byte) 0);
            if (A2 != -1) {
                if (z) {
                    G(this.f10674c.a(), 0, A2 + 1);
                }
                this.f10674c.b(A2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            l("FHCRC", this.f10674c.s(), (short) ((int) this.f10677f.getValue()));
            this.f10677f.reset();
        }
    }

    private void F() {
        l("CRC", this.f10674c.m(), (int) this.f10677f.getValue());
        l("ISIZE", this.f10674c.m(), (int) this.f10675d.getBytesWritten());
    }

    private void G(c cVar, long j2, long j3) {
        p pVar = cVar.f10662b;
        while (true) {
            int i2 = pVar.f10698c;
            int i3 = pVar.f10697b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            pVar = pVar.f10701f;
        }
        while (j3 > 0) {
            int i4 = (int) (((long) pVar.f10697b) + j2);
            int min = (int) Math.min((long) (pVar.f10698c - i4), j3);
            this.f10677f.update(pVar.f10696a, i4, min);
            j3 -= (long) min;
            pVar = pVar.f10701f;
            j2 = 0;
        }
    }

    private void l(String str, int i2, int i3) {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    @Override // j.t
    public u c() {
        return this.f10674c.c();
    }

    @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10676e.close();
    }

    @Override // j.t
    public long v(c cVar, long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (j2 == 0) {
            return 0;
        } else {
            if (this.f10673b == 0) {
                E();
                this.f10673b = 1;
            }
            if (this.f10673b == 1) {
                long j3 = cVar.f10663c;
                long v = this.f10676e.v(cVar, j2);
                if (v != -1) {
                    G(cVar, j3, v);
                    return v;
                }
                this.f10673b = 2;
            }
            if (this.f10673b == 2) {
                F();
                this.f10673b = 3;
                if (!this.f10674c.o()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }
}
