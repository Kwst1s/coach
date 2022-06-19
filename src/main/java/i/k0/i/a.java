package i.k0.i;

import i.b0;
import i.e0;
import i.g0;
import i.k0.h.k;
import i.x;
import i.y;
import j.i;
import j.s;
import j.t;
import j.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1ExchangeCodec */
public final class a implements i.k0.h.c {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f10522a;

    /* renamed from: b  reason: collision with root package name */
    private final okhttp3.internal.connection.f f10523b;

    /* renamed from: c  reason: collision with root package name */
    private final j.e f10524c;

    /* renamed from: d  reason: collision with root package name */
    private final j.d f10525d;

    /* renamed from: e  reason: collision with root package name */
    private int f10526e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f10527f = 262144;

    /* renamed from: g  reason: collision with root package name */
    private x f10528g;

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public abstract class b implements t {

        /* renamed from: b  reason: collision with root package name */
        protected final i f10529b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f10530c;

        private b() {
            this.f10529b = new i(a.this.f10524c.c());
        }

        @Override // j.t
        public u c() {
            return this.f10529b;
        }

        /* access modifiers changed from: package-private */
        public final void l() {
            if (a.this.f10526e != 6) {
                if (a.this.f10526e == 5) {
                    a.this.s(this.f10529b);
                    a.this.f10526e = 6;
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f10526e);
            }
        }

        @Override // j.t
        public long v(j.c cVar, long j2) {
            try {
                return a.this.f10524c.v(cVar, j2);
            } catch (IOException e2) {
                a.this.f10523b.p();
                l();
                throw e2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public final class c implements s {

        /* renamed from: b  reason: collision with root package name */
        private final i f10532b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10533c;

        c() {
            this.f10532b = new i(a.this.f10525d.c());
        }

        @Override // j.s
        public u c() {
            return this.f10532b;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        public synchronized void close() {
            if (!this.f10533c) {
                this.f10533c = true;
                a.this.f10525d.y("0\r\n\r\n");
                a.this.s(this.f10532b);
                a.this.f10526e = 3;
            }
        }

        @Override // j.s
        public void e(j.c cVar, long j2) {
            if (this.f10533c) {
                throw new IllegalStateException("closed");
            } else if (j2 != 0) {
                a.this.f10525d.f(j2);
                a.this.f10525d.y("\r\n");
                a.this.f10525d.e(cVar, j2);
                a.this.f10525d.y("\r\n");
            }
        }

        @Override // j.s, java.io.Flushable
        public synchronized void flush() {
            if (!this.f10533c) {
                a.this.f10525d.flush();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final y f10535e;

        /* renamed from: f  reason: collision with root package name */
        private long f10536f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10537g = true;

        d(y yVar) {
            super();
            this.f10535e = yVar;
        }

        private void E() {
            if (this.f10536f != -1) {
                a.this.f10524c.j();
            }
            try {
                this.f10536f = a.this.f10524c.C();
                String trim = a.this.f10524c.j().trim();
                if (this.f10536f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f10536f + trim + "\"");
                } else if (this.f10536f == 0) {
                    this.f10537g = false;
                    a aVar = a.this;
                    aVar.f10528g = aVar.z();
                    i.k0.h.e.g(a.this.f10522a.i(), this.f10535e, a.this.f10528g);
                    l();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f10530c) {
                if (this.f10537g && !i.k0.e.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a.this.f10523b.p();
                    l();
                }
                this.f10530c = true;
            }
        }

        @Override // j.t, i.k0.i.a.b
        public long v(j.c cVar, long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f10530c) {
                throw new IllegalStateException("closed");
            } else if (!this.f10537g) {
                return -1;
            } else {
                long j3 = this.f10536f;
                if (j3 == 0 || j3 == -1) {
                    E();
                    if (!this.f10537g) {
                        return -1;
                    }
                }
                long v = super.v(cVar, Math.min(j2, this.f10536f));
                if (v != -1) {
                    this.f10536f -= v;
                    return v;
                }
                a.this.f10523b.p();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                l();
                throw protocolException;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public class e extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f10539e;

        e(long j2) {
            super();
            this.f10539e = j2;
            if (j2 == 0) {
                l();
            }
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f10530c) {
                if (this.f10539e != 0 && !i.k0.e.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a.this.f10523b.p();
                    l();
                }
                this.f10530c = true;
            }
        }

        @Override // j.t, i.k0.i.a.b
        public long v(j.c cVar, long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (!this.f10530c) {
                long j3 = this.f10539e;
                if (j3 == 0) {
                    return -1;
                }
                long v = super.v(cVar, Math.min(j3, j2));
                if (v != -1) {
                    long j4 = this.f10539e - v;
                    this.f10539e = j4;
                    if (j4 == 0) {
                        l();
                    }
                    return v;
                }
                a.this.f10523b.p();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                l();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public final class f implements s {

        /* renamed from: b  reason: collision with root package name */
        private final i f10541b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10542c;

        private f() {
            this.f10541b = new i(a.this.f10525d.c());
        }

        @Override // j.s
        public u c() {
            return this.f10541b;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
        public void close() {
            if (!this.f10542c) {
                this.f10542c = true;
                a.this.s(this.f10541b);
                a.this.f10526e = 3;
            }
        }

        @Override // j.s
        public void e(j.c cVar, long j2) {
            if (!this.f10542c) {
                i.k0.e.c(cVar.S(), 0, j2);
                a.this.f10525d.e(cVar, j2);
                return;
            }
            throw new IllegalStateException("closed");
        }

        @Override // j.s, java.io.Flushable
        public void flush() {
            if (!this.f10542c) {
                a.this.f10525d.flush();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec */
    public class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f10544e;

        private g(a aVar) {
            super();
        }

        @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f10530c) {
                if (!this.f10544e) {
                    l();
                }
                this.f10530c = true;
            }
        }

        @Override // j.t, i.k0.i.a.b
        public long v(j.c cVar, long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f10530c) {
                throw new IllegalStateException("closed");
            } else if (this.f10544e) {
                return -1;
            } else {
                long v = super.v(cVar, j2);
                if (v != -1) {
                    return v;
                }
                this.f10544e = true;
                l();
                return -1;
            }
        }
    }

    public a(b0 b0Var, okhttp3.internal.connection.f fVar, j.e eVar, j.d dVar) {
        this.f10522a = b0Var;
        this.f10523b = fVar;
        this.f10524c = eVar;
        this.f10525d = dVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(i iVar) {
        u i2 = iVar.i();
        iVar.j(u.f10707d);
        i2.a();
        i2.b();
    }

    private s t() {
        if (this.f10526e == 1) {
            this.f10526e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    private t u(y yVar) {
        if (this.f10526e == 4) {
            this.f10526e = 5;
            return new d(yVar);
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    private t v(long j2) {
        if (this.f10526e == 4) {
            this.f10526e = 5;
            return new e(j2);
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    private s w() {
        if (this.f10526e == 1) {
            this.f10526e = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    private t x() {
        if (this.f10526e == 4) {
            this.f10526e = 5;
            this.f10523b.p();
            return new g();
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    private String y() {
        String w = this.f10524c.w(this.f10527f);
        this.f10527f -= (long) w.length();
        return w;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private x z() {
        x.a aVar = new x.a();
        while (true) {
            String y = y();
            if (y.length() == 0) {
                return aVar.d();
            }
            i.k0.c.f10443a.a(aVar, y);
        }
    }

    public void A(g0 g0Var) {
        long b2 = i.k0.h.e.b(g0Var);
        if (b2 != -1) {
            t v = v(b2);
            i.k0.e.C(v, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            v.close();
        }
    }

    public void B(x xVar, String str) {
        if (this.f10526e == 0) {
            this.f10525d.y(str).y("\r\n");
            int h2 = xVar.h();
            for (int i2 = 0; i2 < h2; i2++) {
                this.f10525d.y(xVar.e(i2)).y(": ").y(xVar.i(i2)).y("\r\n");
            }
            this.f10525d.y("\r\n");
            this.f10526e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f10526e);
    }

    @Override // i.k0.h.c
    public void a() {
        this.f10525d.flush();
    }

    @Override // i.k0.h.c
    public void b(e0 e0Var) {
        B(e0Var.e(), i.k0.h.i.a(e0Var, this.f10523b.q().b().type()));
    }

    @Override // i.k0.h.c
    public void c() {
        this.f10525d.flush();
    }

    @Override // i.k0.h.c
    public void cancel() {
        okhttp3.internal.connection.f fVar = this.f10523b;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // i.k0.h.c
    public long d(g0 g0Var) {
        if (!i.k0.h.e.c(g0Var)) {
            return 0;
        }
        if ("chunked".equalsIgnoreCase(g0Var.I("Transfer-Encoding"))) {
            return -1;
        }
        return i.k0.h.e.b(g0Var);
    }

    @Override // i.k0.h.c
    public t e(g0 g0Var) {
        if (!i.k0.h.e.c(g0Var)) {
            return v(0);
        }
        if ("chunked".equalsIgnoreCase(g0Var.I("Transfer-Encoding"))) {
            return u(g0Var.S().i());
        }
        long b2 = i.k0.h.e.b(g0Var);
        if (b2 != -1) {
            return v(b2);
        }
        return x();
    }

    @Override // i.k0.h.c
    public s f(e0 e0Var, long j2) {
        if (e0Var.a() != null && e0Var.a().e()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if ("chunked".equalsIgnoreCase(e0Var.c("Transfer-Encoding"))) {
            return t();
        } else {
            if (j2 != -1) {
                return w();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    @Override // i.k0.h.c
    public g0.a g(boolean z) {
        int i2 = this.f10526e;
        if (i2 == 1 || i2 == 3) {
            try {
                k a2 = k.a(y());
                g0.a aVar = new g0.a();
                aVar.o(a2.f10519a);
                aVar.g(a2.f10520b);
                aVar.l(a2.f10521c);
                aVar.j(z());
                if (z && a2.f10520b == 100) {
                    return null;
                }
                if (a2.f10520b == 100) {
                    this.f10526e = 3;
                    return aVar;
                }
                this.f10526e = 4;
                return aVar;
            } catch (EOFException e2) {
                throw new IOException("unexpected end of stream on " + this.f10523b.q().a().l().z(), e2);
            }
        } else {
            throw new IllegalStateException("state: " + this.f10526e);
        }
    }

    @Override // i.k0.h.c
    public okhttp3.internal.connection.f h() {
        return this.f10523b;
    }
}
