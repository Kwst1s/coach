package okhttp3.internal.connection;

import i.e0;
import i.g0;
import i.h0;
import i.j;
import i.k0.h.c;
import i.v;
import j.g;
import j.h;
import j.l;
import j.s;
import j.t;
import java.io.IOException;
import java.net.ProtocolException;
import javax.annotation.Nullable;

/* compiled from: Exchange */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    final j f10804a;

    /* renamed from: b  reason: collision with root package name */
    final j f10805b;

    /* renamed from: c  reason: collision with root package name */
    final v f10806c;

    /* renamed from: d  reason: collision with root package name */
    final e f10807d;

    /* renamed from: e  reason: collision with root package name */
    final c f10808e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10809f;

    /* compiled from: Exchange */
    private final class a extends g {

        /* renamed from: c  reason: collision with root package name */
        private boolean f10810c;

        /* renamed from: d  reason: collision with root package name */
        private long f10811d;

        /* renamed from: e  reason: collision with root package name */
        private long f10812e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10813f;

        a(s sVar, long j2) {
            super(sVar);
            this.f10811d = j2;
        }

        @Nullable
        private IOException l(@Nullable IOException iOException) {
            if (this.f10810c) {
                return iOException;
            }
            this.f10810c = true;
            return d.this.a(this.f10812e, false, true, iOException);
        }

        @Override // j.g, java.io.Closeable, java.lang.AutoCloseable, j.s
        public void close() {
            if (!this.f10813f) {
                this.f10813f = true;
                long j2 = this.f10811d;
                if (j2 == -1 || this.f10812e == j2) {
                    try {
                        super.close();
                        l(null);
                    } catch (IOException e2) {
                        throw l(e2);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        @Override // j.g, j.s
        public void e(j.c cVar, long j2) {
            if (!this.f10813f) {
                long j3 = this.f10811d;
                if (j3 == -1 || this.f10812e + j2 <= j3) {
                    try {
                        super.e(cVar, j2);
                        this.f10812e += j2;
                    } catch (IOException e2) {
                        throw l(e2);
                    }
                } else {
                    throw new ProtocolException("expected " + this.f10811d + " bytes but received " + (this.f10812e + j2));
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        @Override // j.g, j.s, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e2) {
                throw l(e2);
            }
        }
    }

    /* compiled from: Exchange */
    final class b extends h {

        /* renamed from: c  reason: collision with root package name */
        private final long f10815c;

        /* renamed from: d  reason: collision with root package name */
        private long f10816d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f10817e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10818f;

        b(t tVar, long j2) {
            super(tVar);
            this.f10815c = j2;
            if (j2 == 0) {
                E(null);
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public IOException E(@Nullable IOException iOException) {
            if (this.f10817e) {
                return iOException;
            }
            this.f10817e = true;
            return d.this.a(this.f10816d, true, false, iOException);
        }

        @Override // j.t, j.h, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f10818f) {
                this.f10818f = true;
                try {
                    super.close();
                    E(null);
                } catch (IOException e2) {
                    throw E(e2);
                }
            }
        }

        @Override // j.t, j.h
        public long v(j.c cVar, long j2) {
            if (!this.f10818f) {
                try {
                    long v = l().v(cVar, j2);
                    if (v == -1) {
                        E(null);
                        return -1;
                    }
                    long j3 = this.f10816d + v;
                    long j4 = this.f10815c;
                    if (j4 != -1) {
                        if (j3 > j4) {
                            throw new ProtocolException("expected " + this.f10815c + " bytes but received " + j3);
                        }
                    }
                    this.f10816d = j3;
                    if (j3 == j4) {
                        E(null);
                    }
                    return v;
                } catch (IOException e2) {
                    throw E(e2);
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public d(j jVar, j jVar2, v vVar, e eVar, c cVar) {
        this.f10804a = jVar;
        this.f10805b = jVar2;
        this.f10806c = vVar;
        this.f10807d = eVar;
        this.f10808e = cVar;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException a(long j2, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            o(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.f10806c.o(this.f10805b, iOException);
            } else {
                this.f10806c.m(this.f10805b, j2);
            }
        }
        if (z) {
            if (iOException != null) {
                this.f10806c.t(this.f10805b, iOException);
            } else {
                this.f10806c.r(this.f10805b, j2);
            }
        }
        return this.f10804a.g(this, z2, z, iOException);
    }

    public void b() {
        this.f10808e.cancel();
    }

    public f c() {
        return this.f10808e.h();
    }

    public s d(e0 e0Var, boolean z) {
        this.f10809f = z;
        long a2 = e0Var.a().a();
        this.f10806c.n(this.f10805b);
        return new a(this.f10808e.f(e0Var, a2), a2);
    }

    public void e() {
        this.f10808e.cancel();
        this.f10804a.g(this, true, true, null);
    }

    public void f() {
        try {
            this.f10808e.a();
        } catch (IOException e2) {
            this.f10806c.o(this.f10805b, e2);
            o(e2);
            throw e2;
        }
    }

    public void g() {
        try {
            this.f10808e.c();
        } catch (IOException e2) {
            this.f10806c.o(this.f10805b, e2);
            o(e2);
            throw e2;
        }
    }

    public boolean h() {
        return this.f10809f;
    }

    public void i() {
        this.f10808e.h().p();
    }

    public void j() {
        this.f10804a.g(this, true, false, null);
    }

    public h0 k(g0 g0Var) {
        try {
            this.f10806c.s(this.f10805b);
            String I = g0Var.I("Content-Type");
            long d2 = this.f10808e.d(g0Var);
            return new i.k0.h.h(I, d2, l.d(new b(this.f10808e.e(g0Var), d2)));
        } catch (IOException e2) {
            this.f10806c.t(this.f10805b, e2);
            o(e2);
            throw e2;
        }
    }

    @Nullable
    public g0.a l(boolean z) {
        try {
            g0.a g2 = this.f10808e.g(z);
            if (g2 != null) {
                i.k0.c.f10443a.g(g2, this);
            }
            return g2;
        } catch (IOException e2) {
            this.f10806c.t(this.f10805b, e2);
            o(e2);
            throw e2;
        }
    }

    public void m(g0 g0Var) {
        this.f10806c.u(this.f10805b, g0Var);
    }

    public void n() {
        this.f10806c.v(this.f10805b);
    }

    /* access modifiers changed from: package-private */
    public void o(IOException iOException) {
        this.f10807d.g();
        this.f10808e.h().v(iOException);
    }

    public void p(e0 e0Var) {
        try {
            this.f10806c.q(this.f10805b);
            this.f10808e.b(e0Var);
            this.f10806c.p(this.f10805b, e0Var);
        } catch (IOException e2) {
            this.f10806c.o(this.f10805b, e2);
            o(e2);
            throw e2;
        }
    }
}
