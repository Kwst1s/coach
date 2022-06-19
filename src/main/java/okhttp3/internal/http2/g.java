package okhttp3.internal.http2;

import j.e;
import j.f;
import j.t;
import j.u;
import java.io.Closeable;
import java.io.EOFException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.c;

/* access modifiers changed from: package-private */
/* compiled from: Http2Reader */
public final class g implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    static final Logger f10972f = Logger.getLogger(d.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final e f10973b;

    /* renamed from: c  reason: collision with root package name */
    private final a f10974c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10975d;

    /* renamed from: e  reason: collision with root package name */
    final c.a f10976e;

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Reader */
    public static final class a implements t {

        /* renamed from: b  reason: collision with root package name */
        private final e f10977b;

        /* renamed from: c  reason: collision with root package name */
        int f10978c;

        /* renamed from: d  reason: collision with root package name */
        byte f10979d;

        /* renamed from: e  reason: collision with root package name */
        int f10980e;

        /* renamed from: f  reason: collision with root package name */
        int f10981f;

        /* renamed from: g  reason: collision with root package name */
        short f10982g;

        a(e eVar) {
            this.f10977b = eVar;
        }

        private void l() {
            int i2 = this.f10980e;
            int K = g.K(this.f10977b);
            this.f10981f = K;
            this.f10978c = K;
            byte readByte = (byte) (this.f10977b.readByte() & 255);
            this.f10979d = (byte) (this.f10977b.readByte() & 255);
            Logger logger = g.f10972f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(d.b(true, this.f10980e, this.f10978c, readByte, this.f10979d));
            }
            int readInt = this.f10977b.readInt() & Integer.MAX_VALUE;
            this.f10980e = readInt;
            if (readByte != 9) {
                d.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt != i2) {
                d.d("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        @Override // j.t
        public u c() {
            return this.f10977b.c();
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // j.t
        public long v(j.c cVar, long j2) {
            while (true) {
                int i2 = this.f10981f;
                if (i2 == 0) {
                    this.f10977b.b((long) this.f10982g);
                    this.f10982g = 0;
                    if ((this.f10979d & 4) != 0) {
                        return -1;
                    }
                    l();
                } else {
                    long v = this.f10977b.v(cVar, Math.min(j2, (long) i2));
                    if (v == -1) {
                        return -1;
                    }
                    this.f10981f = (int) (((long) this.f10981f) - v);
                    return v;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Http2Reader */
    public interface b {
        void a();

        void b(boolean z, l lVar);

        void c(boolean z, int i2, e eVar, int i3);

        void d(boolean z, int i2, int i3);

        void e(int i2, int i3, int i4, boolean z);

        void f(int i2, a aVar);

        void g(boolean z, int i2, int i3, List<b> list);

        void h(int i2, long j2);

        void i(int i2, int i3, List<b> list);

        void j(int i2, a aVar, f fVar);
    }

    g(e eVar, boolean z) {
        this.f10973b = eVar;
        this.f10975d = z;
        a aVar = new a(eVar);
        this.f10974c = aVar;
        this.f10976e = new c.a(4096, aVar);
    }

    private void G(b bVar, int i2, byte b2, int i3) {
        short s = 0;
        if (i3 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.f10973b.readByte() & 255);
                }
                bVar.c(z2, i3, this.f10973b, l(i2, b2, s));
                this.f10973b.b((long) s);
                return;
            }
            d.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        d.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    private void H(b bVar, int i2, byte b2, int i3) {
        if (i2 < 8) {
            d.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f10973b.readInt();
            int readInt2 = this.f10973b.readInt();
            int i4 = i2 - 8;
            a a2 = a.a(readInt2);
            if (a2 != null) {
                f fVar = f.f10666f;
                if (i4 > 0) {
                    fVar = this.f10973b.g((long) i4);
                }
                bVar.j(readInt, a2, fVar);
                return;
            }
            d.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            d.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    private List<b> I(int i2, short s, byte b2, int i3) {
        a aVar = this.f10974c;
        aVar.f10981f = i2;
        aVar.f10978c = i2;
        aVar.f10982g = s;
        aVar.f10979d = b2;
        aVar.f10980e = i3;
        this.f10976e.k();
        return this.f10976e.e();
    }

    private void J(b bVar, int i2, byte b2, int i3) {
        short s = 0;
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.f10973b.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                M(bVar, i3);
                i2 -= 5;
            }
            bVar.g(z, i3, -1, I(l(i2, b2, s), s, b2, i3));
            return;
        }
        d.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    static int K(e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private void L(b bVar, int i2, byte b2, int i3) {
        boolean z = false;
        if (i2 != 8) {
            d.d("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f10973b.readInt();
            int readInt2 = this.f10973b.readInt();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.d(z, readInt, readInt2);
        } else {
            d.d("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void M(b bVar, int i2) {
        int readInt = this.f10973b.readInt();
        bVar.e(i2, readInt & Integer.MAX_VALUE, (this.f10973b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void N(b bVar, int i2, byte b2, int i3) {
        if (i2 != 5) {
            d.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            M(bVar, i3);
        } else {
            d.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void O(b bVar, int i2, byte b2, int i3) {
        short s = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.f10973b.readByte() & 255);
            }
            bVar.i(i3, this.f10973b.readInt() & Integer.MAX_VALUE, I(l(i2 - 4, b2, s), s, b2, i3));
            return;
        }
        d.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    private void P(b bVar, int i2, byte b2, int i3) {
        if (i2 != 4) {
            d.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int readInt = this.f10973b.readInt();
            a a2 = a.a(readInt);
            if (a2 != null) {
                bVar.f(i3, a2);
                return;
            }
            d.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            d.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void Q(b bVar, int i2, byte b2, int i3) {
        if (i3 != 0) {
            d.d("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
            } else {
                d.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i2 % 6 == 0) {
            l lVar = new l();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                int readShort = this.f10973b.readShort() & 65535;
                int readInt = this.f10973b.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            d.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        d.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    d.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                lVar.i(readShort, readInt);
            }
            bVar.b(false, lVar);
        } else {
            d.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    private void R(b bVar, int i2, byte b2, int i3) {
        if (i2 == 4) {
            long readInt = ((long) this.f10973b.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.h(i3, readInt);
                return;
            }
            d.d("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        d.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        throw null;
    }

    static int l(int i2, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        d.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }

    public boolean E(boolean z, b bVar) {
        try {
            this.f10973b.x(9);
            int K = K(this.f10973b);
            if (K < 0 || K > 16384) {
                d.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(K));
                throw null;
            }
            byte readByte = (byte) (this.f10973b.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f10973b.readByte() & 255);
                int readInt = this.f10973b.readInt() & Integer.MAX_VALUE;
                Logger logger = f10972f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(d.b(true, readInt, K, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        G(bVar, K, readByte2, readInt);
                        break;
                    case 1:
                        J(bVar, K, readByte2, readInt);
                        break;
                    case 2:
                        N(bVar, K, readByte2, readInt);
                        break;
                    case 3:
                        P(bVar, K, readByte2, readInt);
                        break;
                    case 4:
                        Q(bVar, K, readByte2, readInt);
                        break;
                    case 5:
                        O(bVar, K, readByte2, readInt);
                        break;
                    case 6:
                        L(bVar, K, readByte2, readInt);
                        break;
                    case 7:
                        H(bVar, K, readByte2, readInt);
                        break;
                    case 8:
                        R(bVar, K, readByte2, readInt);
                        break;
                    default:
                        this.f10973b.b((long) K);
                        break;
                }
                return true;
            }
            d.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (EOFException unused) {
            return false;
        }
    }

    public void F(b bVar) {
        if (!this.f10975d) {
            e eVar = this.f10973b;
            f fVar = d.f10909a;
            f g2 = eVar.g((long) fVar.r());
            Logger logger = f10972f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(i.k0.e.n("<< CONNECTION %s", g2.k()));
            }
            if (!fVar.equals(g2)) {
                d.d("Expected a connection header but was %s", g2.w());
                throw null;
            }
        } else if (!E(true, bVar)) {
            d.d("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10973b.close();
    }
}
