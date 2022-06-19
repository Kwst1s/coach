package i;

import i.x;
import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.internal.connection.d;

/* compiled from: Response */
public final class g0 implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    final e0 f10358b;

    /* renamed from: c  reason: collision with root package name */
    final c0 f10359c;

    /* renamed from: d  reason: collision with root package name */
    final int f10360d;

    /* renamed from: e  reason: collision with root package name */
    final String f10361e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    final w f10362f;

    /* renamed from: g  reason: collision with root package name */
    final x f10363g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    final h0 f10364h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final g0 f10365i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final g0 f10366j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final g0 f10367k;
    final long l;
    final long m;
    @Nullable
    final d n;
    @Nullable
    private volatile i o;

    g0(a aVar) {
        this.f10358b = aVar.f10368a;
        this.f10359c = aVar.f10369b;
        this.f10360d = aVar.f10370c;
        this.f10361e = aVar.f10371d;
        this.f10362f = aVar.f10372e;
        this.f10363g = aVar.f10373f.d();
        this.f10364h = aVar.f10374g;
        this.f10365i = aVar.f10375h;
        this.f10366j = aVar.f10376i;
        this.f10367k = aVar.f10377j;
        this.l = aVar.f10378k;
        this.m = aVar.l;
        this.n = aVar.m;
    }

    public i E() {
        i iVar = this.o;
        if (iVar != null) {
            return iVar;
        }
        i k2 = i.k(this.f10363g);
        this.o = k2;
        return k2;
    }

    @Nullable
    public g0 F() {
        return this.f10366j;
    }

    public int G() {
        return this.f10360d;
    }

    @Nullable
    public w H() {
        return this.f10362f;
    }

    @Nullable
    public String I(String str) {
        return J(str, null);
    }

    @Nullable
    public String J(String str, @Nullable String str2) {
        String c2 = this.f10363g.c(str);
        return c2 != null ? c2 : str2;
    }

    public x K() {
        return this.f10363g;
    }

    public boolean L() {
        int i2 = this.f10360d;
        return i2 >= 200 && i2 < 300;
    }

    public String M() {
        return this.f10361e;
    }

    @Nullable
    public g0 N() {
        return this.f10365i;
    }

    public a O() {
        return new a(this);
    }

    @Nullable
    public g0 P() {
        return this.f10367k;
    }

    public c0 Q() {
        return this.f10359c;
    }

    public long R() {
        return this.m;
    }

    public e0 S() {
        return this.f10358b;
    }

    public long T() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h0 h0Var = this.f10364h;
        if (h0Var != null) {
            h0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Nullable
    public h0 l() {
        return this.f10364h;
    }

    public String toString() {
        return "Response{protocol=" + this.f10359c + ", code=" + this.f10360d + ", message=" + this.f10361e + ", url=" + this.f10358b.i() + '}';
    }

    /* compiled from: Response */
    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        e0 f10368a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        c0 f10369b;

        /* renamed from: c  reason: collision with root package name */
        int f10370c;

        /* renamed from: d  reason: collision with root package name */
        String f10371d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        w f10372e;

        /* renamed from: f  reason: collision with root package name */
        x.a f10373f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        h0 f10374g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        g0 f10375h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        g0 f10376i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        g0 f10377j;

        /* renamed from: k  reason: collision with root package name */
        long f10378k;
        long l;
        @Nullable
        d m;

        public a() {
            this.f10370c = -1;
            this.f10373f = new x.a();
        }

        private void e(g0 g0Var) {
            if (g0Var.f10364h != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, g0 g0Var) {
            if (g0Var.f10364h != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (g0Var.f10365i != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (g0Var.f10366j != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (g0Var.f10367k != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a a(String str, String str2) {
            this.f10373f.a(str, str2);
            return this;
        }

        public a b(@Nullable h0 h0Var) {
            this.f10374g = h0Var;
            return this;
        }

        public g0 c() {
            if (this.f10368a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f10369b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f10370c < 0) {
                throw new IllegalStateException("code < 0: " + this.f10370c);
            } else if (this.f10371d != null) {
                return new g0(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a d(@Nullable g0 g0Var) {
            if (g0Var != null) {
                f("cacheResponse", g0Var);
            }
            this.f10376i = g0Var;
            return this;
        }

        public a g(int i2) {
            this.f10370c = i2;
            return this;
        }

        public a h(@Nullable w wVar) {
            this.f10372e = wVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f10373f.g(str, str2);
            return this;
        }

        public a j(x xVar) {
            this.f10373f = xVar.f();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void k(d dVar) {
            this.m = dVar;
        }

        public a l(String str) {
            this.f10371d = str;
            return this;
        }

        public a m(@Nullable g0 g0Var) {
            if (g0Var != null) {
                f("networkResponse", g0Var);
            }
            this.f10375h = g0Var;
            return this;
        }

        public a n(@Nullable g0 g0Var) {
            if (g0Var != null) {
                e(g0Var);
            }
            this.f10377j = g0Var;
            return this;
        }

        public a o(c0 c0Var) {
            this.f10369b = c0Var;
            return this;
        }

        public a p(long j2) {
            this.l = j2;
            return this;
        }

        public a q(e0 e0Var) {
            this.f10368a = e0Var;
            return this;
        }

        public a r(long j2) {
            this.f10378k = j2;
            return this;
        }

        a(g0 g0Var) {
            this.f10370c = -1;
            this.f10368a = g0Var.f10358b;
            this.f10369b = g0Var.f10359c;
            this.f10370c = g0Var.f10360d;
            this.f10371d = g0Var.f10361e;
            this.f10372e = g0Var.f10362f;
            this.f10373f = g0Var.f10363g.f();
            this.f10374g = g0Var.f10364h;
            this.f10375h = g0Var.f10365i;
            this.f10376i = g0Var.f10366j;
            this.f10377j = g0Var.f10367k;
            this.f10378k = g0Var.l;
            this.l = g0Var.m;
            this.m = g0Var.n;
        }
    }
}
