package okhttp3.internal.http2;

import i.k0.e;
import j.c;
import j.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.c;

/* access modifiers changed from: package-private */
/* compiled from: Http2Writer */
public final class i implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    private static final Logger f11007h = Logger.getLogger(d.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final d f11008b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11009c;

    /* renamed from: d  reason: collision with root package name */
    private final c f11010d;

    /* renamed from: e  reason: collision with root package name */
    private int f11011e = 16384;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11012f;

    /* renamed from: g  reason: collision with root package name */
    final c.b f11013g;

    i(d dVar, boolean z) {
        this.f11008b = dVar;
        this.f11009c = z;
        j.c cVar = new j.c();
        this.f11010d = cVar;
        this.f11013g = new c.b(cVar);
    }

    private void Q(int i2, long j2) {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.f11011e, j2);
            long j3 = (long) min;
            j2 -= j3;
            H(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : 0);
            this.f11008b.e(this.f11010d, j3);
        }
    }

    private static void R(d dVar, int i2) {
        dVar.p((i2 >>> 16) & 255);
        dVar.p((i2 >>> 8) & 255);
        dVar.p(i2 & 255);
    }

    public synchronized void E() {
        if (this.f11012f) {
            throw new IOException("closed");
        } else if (this.f11009c) {
            Logger logger = f11007h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.n(">> CONNECTION %s", d.f10909a.k()));
            }
            this.f11008b.r(d.f10909a.v());
            this.f11008b.flush();
        }
    }

    public synchronized void F(boolean z, int i2, j.c cVar, int i3) {
        if (!this.f11012f) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            G(i2, b2, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void G(int i2, byte b2, j.c cVar, int i3) {
        H(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.f11008b.e(cVar, (long) i3);
        }
    }

    public void H(int i2, int i3, byte b2, byte b3) {
        Logger logger = f11007h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(d.b(false, i2, i3, b2, b3));
        }
        int i4 = this.f11011e;
        if (i3 > i4) {
            d.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            R(this.f11008b, i3);
            this.f11008b.p(b2 & 255);
            this.f11008b.p(b3 & 255);
            this.f11008b.i(i2 & Integer.MAX_VALUE);
        } else {
            d.c("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    public synchronized void I(int i2, a aVar, byte[] bArr) {
        if (this.f11012f) {
            throw new IOException("closed");
        } else if (aVar.f10880b != -1) {
            H(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f11008b.i(i2);
            this.f11008b.i(aVar.f10880b);
            if (bArr.length > 0) {
                this.f11008b.r(bArr);
            }
            this.f11008b.flush();
        } else {
            d.c("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void J(boolean z, int i2, List<b> list) {
        if (!this.f11012f) {
            this.f11013g.g(list);
            long S = this.f11010d.S();
            int min = (int) Math.min((long) this.f11011e, S);
            long j2 = (long) min;
            byte b2 = S == j2 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            H(i2, min, (byte) 1, b2);
            this.f11008b.e(this.f11010d, j2);
            if (S > j2) {
                Q(i2, S - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public int K() {
        return this.f11011e;
    }

    public synchronized void L(boolean z, int i2, int i3) {
        if (!this.f11012f) {
            H(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f11008b.i(i2);
            this.f11008b.i(i3);
            this.f11008b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void M(int i2, int i3, List<b> list) {
        if (!this.f11012f) {
            this.f11013g.g(list);
            long S = this.f11010d.S();
            int min = (int) Math.min((long) (this.f11011e - 4), S);
            long j2 = (long) min;
            H(i2, min + 4, (byte) 5, S == j2 ? (byte) 4 : 0);
            this.f11008b.i(i3 & Integer.MAX_VALUE);
            this.f11008b.e(this.f11010d, j2);
            if (S > j2) {
                Q(i2, S - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void N(int i2, a aVar) {
        if (this.f11012f) {
            throw new IOException("closed");
        } else if (aVar.f10880b != -1) {
            H(i2, 4, (byte) 3, (byte) 0);
            this.f11008b.i(aVar.f10880b);
            this.f11008b.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void O(l lVar) {
        if (!this.f11012f) {
            int i2 = 0;
            H(0, lVar.j() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (lVar.g(i2)) {
                    this.f11008b.h(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f11008b.i(lVar.b(i2));
                }
                i2++;
            }
            this.f11008b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void P(int i2, long j2) {
        if (this.f11012f) {
            throw new IOException("closed");
        } else if (j2 == 0 || j2 > 2147483647L) {
            d.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
            throw null;
        } else {
            H(i2, 4, (byte) 8, (byte) 0);
            this.f11008b.i((int) j2);
            this.f11008b.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f11012f = true;
        this.f11008b.close();
    }

    public synchronized void flush() {
        if (!this.f11012f) {
            this.f11008b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void l(l lVar) {
        if (!this.f11012f) {
            this.f11011e = lVar.f(this.f11011e);
            if (lVar.c() != -1) {
                this.f11013g.e(lVar.c());
            }
            H(0, 0, (byte) 4, (byte) 1);
            this.f11008b.flush();
        } else {
            throw new IOException("closed");
        }
    }
}
