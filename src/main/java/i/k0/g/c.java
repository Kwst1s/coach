package i.k0.g;

import i.e0;
import i.g0;
import i.i;
import i.k0.h.d;
import i.k0.h.e;
import i.x;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheStrategy */
public final class c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final e0 f10458a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final g0 f10459b;

    /* compiled from: CacheStrategy */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f10460a;

        /* renamed from: b  reason: collision with root package name */
        final e0 f10461b;

        /* renamed from: c  reason: collision with root package name */
        final g0 f10462c;

        /* renamed from: d  reason: collision with root package name */
        private Date f10463d;

        /* renamed from: e  reason: collision with root package name */
        private String f10464e;

        /* renamed from: f  reason: collision with root package name */
        private Date f10465f;

        /* renamed from: g  reason: collision with root package name */
        private String f10466g;

        /* renamed from: h  reason: collision with root package name */
        private Date f10467h;

        /* renamed from: i  reason: collision with root package name */
        private long f10468i;

        /* renamed from: j  reason: collision with root package name */
        private long f10469j;

        /* renamed from: k  reason: collision with root package name */
        private String f10470k;
        private int l = -1;

        public a(long j2, e0 e0Var, g0 g0Var) {
            this.f10460a = j2;
            this.f10461b = e0Var;
            this.f10462c = g0Var;
            if (g0Var != null) {
                this.f10468i = g0Var.T();
                this.f10469j = g0Var.R();
                x K = g0Var.K();
                int h2 = K.h();
                for (int i2 = 0; i2 < h2; i2++) {
                    String e2 = K.e(i2);
                    String i3 = K.i(i2);
                    if ("Date".equalsIgnoreCase(e2)) {
                        this.f10463d = d.b(i3);
                        this.f10464e = i3;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.f10467h = d.b(i3);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f10465f = d.b(i3);
                        this.f10466g = i3;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.f10470k = i3;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = e.f(i3, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f10463d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0L, this.f10469j - date.getTime());
            }
            int i2 = this.l;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.f10469j;
            return j2 + (j3 - this.f10468i) + (this.f10460a - j3);
        }

        private long b() {
            long j2;
            long j3;
            i E = this.f10462c.E();
            if (E.d() != -1) {
                return TimeUnit.SECONDS.toMillis((long) E.d());
            }
            if (this.f10467h != null) {
                Date date = this.f10463d;
                if (date != null) {
                    j3 = date.getTime();
                } else {
                    j3 = this.f10469j;
                }
                long time = this.f10467h.getTime() - j3;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f10465f == null || this.f10462c.S().i().x() != null) {
                return 0;
            } else {
                Date date2 = this.f10463d;
                if (date2 != null) {
                    j2 = date2.getTime();
                } else {
                    j2 = this.f10468i;
                }
                long time2 = j2 - this.f10465f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private c d() {
            if (this.f10462c == null) {
                return new c(this.f10461b, null);
            }
            if (this.f10461b.f() && this.f10462c.H() == null) {
                return new c(this.f10461b, null);
            }
            if (!c.a(this.f10462c, this.f10461b)) {
                return new c(this.f10461b, null);
            }
            i b2 = this.f10461b.b();
            if (b2.h() || e(this.f10461b)) {
                return new c(this.f10461b, null);
            }
            i E = this.f10462c.E();
            long a2 = a();
            long b3 = b();
            if (b2.d() != -1) {
                b3 = Math.min(b3, TimeUnit.SECONDS.toMillis((long) b2.d()));
            }
            long j2 = 0;
            long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis((long) b2.f()) : 0;
            if (!E.g() && b2.e() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) b2.e());
            }
            if (!E.h()) {
                long j3 = millis + a2;
                if (j3 < j2 + b3) {
                    g0.a O = this.f10462c.O();
                    if (j3 >= b3) {
                        O.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a2 > 86400000 && f()) {
                        O.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, O.c());
                }
            }
            String str = this.f10470k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f10465f != null) {
                str = this.f10466g;
            } else if (this.f10463d == null) {
                return new c(this.f10461b, null);
            } else {
                str = this.f10464e;
            }
            x.a f2 = this.f10461b.e().f();
            i.k0.c.f10443a.b(f2, str2, str);
            e0.a h2 = this.f10461b.h();
            h2.d(f2.d());
            return new c(h2.a(), this.f10462c);
        }

        private static boolean e(e0 e0Var) {
            return (e0Var.c("If-Modified-Since") == null && e0Var.c("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f10462c.E().d() == -1 && this.f10467h == null;
        }

        public c c() {
            c d2 = d();
            return (d2.f10458a == null || !this.f10461b.b().j()) ? d2 : new c(null, null);
        }
    }

    c(e0 e0Var, g0 g0Var) {
        this.f10458a = e0Var;
        this.f10459b = g0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.E().b() == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(i.g0 r3, i.e0 r4) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: i.k0.g.c.a(i.g0, i.e0):boolean");
    }
}
