package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.util.d0;

/* compiled from: BinarySearchSeeker */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final C0121a f5028a;

    /* renamed from: b  reason: collision with root package name */
    protected final g f5029b;

    /* renamed from: c  reason: collision with root package name */
    protected d f5030c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5031d;

    /* renamed from: com.google.android.exoplayer2.e0.a$a  reason: collision with other inner class name */
    /* compiled from: BinarySearchSeeker */
    public static class C0121a implements o {

        /* renamed from: a  reason: collision with root package name */
        private final e f5032a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5033b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5034c;

        /* renamed from: d  reason: collision with root package name */
        private final long f5035d;

        /* renamed from: e  reason: collision with root package name */
        private final long f5036e;

        /* renamed from: f  reason: collision with root package name */
        private final long f5037f;

        /* renamed from: g  reason: collision with root package name */
        private final long f5038g;

        public C0121a(e eVar, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f5032a = eVar;
            this.f5033b = j2;
            this.f5034c = j3;
            this.f5035d = j4;
            this.f5036e = j5;
            this.f5037f = j6;
            this.f5038g = j7;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public boolean g() {
            return true;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public o.a h(long j2) {
            this.f5032a.a(j2);
            return new o.a(new p(j2, d.h(j2, this.f5034c, this.f5035d, this.f5036e, this.f5037f, this.f5038g)));
        }

        @Override // com.google.android.exoplayer2.e0.o
        public long j() {
            return this.f5033b;
        }

        public long k(long j2) {
            this.f5032a.a(j2);
            return j2;
        }
    }

    /* compiled from: BinarySearchSeeker */
    public static final class b implements e {
        @Override // com.google.android.exoplayer2.e0.a.e
        public long a(long j2) {
            return j2;
        }
    }

    /* compiled from: BinarySearchSeeker */
    public static final class c {
    }

    /* access modifiers changed from: protected */
    /* compiled from: BinarySearchSeeker */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final long f5039a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5040b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5041c;

        /* renamed from: d  reason: collision with root package name */
        private long f5042d;

        /* renamed from: e  reason: collision with root package name */
        private long f5043e;

        /* renamed from: f  reason: collision with root package name */
        private long f5044f;

        /* renamed from: g  reason: collision with root package name */
        private long f5045g;

        /* renamed from: h  reason: collision with root package name */
        private long f5046h;

        protected d(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f5039a = j2;
            this.f5040b = j3;
            this.f5042d = j4;
            this.f5043e = j5;
            this.f5044f = j6;
            this.f5045g = j7;
            this.f5041c = j8;
            this.f5046h = h(j3, j4, j5, j6, j7, j8);
        }

        protected static long h(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) (((float) (j2 - j3)) * (((float) (j6 - j5)) / ((float) (j4 - j3))));
            return d0.o(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long i() {
            return this.f5045g;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long j() {
            return this.f5044f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long k() {
            return this.f5046h;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long l() {
            return this.f5039a;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long m() {
            return this.f5040b;
        }

        private void n() {
            this.f5046h = h(this.f5040b, this.f5042d, this.f5043e, this.f5044f, this.f5045g, this.f5041c);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void o(long j2, long j3) {
            this.f5043e = j2;
            this.f5045g = j3;
            n();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void p(long j2, long j3) {
            this.f5042d = j2;
            this.f5044f = j3;
            n();
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: BinarySearchSeeker */
    public interface e {
        long a(long j2);
    }

    /* compiled from: BinarySearchSeeker */
    public static final class f {

        /* renamed from: d  reason: collision with root package name */
        public static final f f5047d = new f(-3, -9223372036854775807L, -1);

        /* renamed from: a  reason: collision with root package name */
        private final int f5048a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5049b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5050c;

        private f(int i2, long j2, long j3) {
            this.f5048a = i2;
            this.f5049b = j2;
            this.f5050c = j3;
        }

        public static f d(long j2, long j3) {
            return new f(-1, j2, j3);
        }

        public static f e(long j2) {
            return new f(0, -9223372036854775807L, j2);
        }

        public static f f(long j2, long j3) {
            return new f(-2, j2, j3);
        }
    }

    /* compiled from: BinarySearchSeeker */
    protected interface g {
        f a(h hVar, long j2, c cVar);
    }

    protected a(e eVar, g gVar, long j2, long j3, long j4, long j5, long j6, long j7, int i2) {
        this.f5029b = gVar;
        this.f5031d = i2;
        this.f5028a = new C0121a(eVar, j2, j3, j4, j5, j6, j7);
    }

    /* access modifiers changed from: protected */
    public d a(long j2) {
        this.f5028a.k(j2);
        return new d(j2, j2, this.f5028a.f5034c, this.f5028a.f5035d, this.f5028a.f5036e, this.f5028a.f5037f, this.f5028a.f5038g);
    }

    public final o b() {
        return this.f5028a;
    }

    public int c(h hVar, n nVar, c cVar) {
        g gVar = this.f5029b;
        com.google.android.exoplayer2.util.e.e(gVar);
        g gVar2 = gVar;
        while (true) {
            d dVar = this.f5030c;
            com.google.android.exoplayer2.util.e.e(dVar);
            d dVar2 = dVar;
            long j2 = dVar2.j();
            long i2 = dVar2.i();
            long k2 = dVar2.k();
            if (i2 - j2 <= ((long) this.f5031d)) {
                e(false, j2);
                return g(hVar, j2, nVar);
            } else if (!i(hVar, k2)) {
                return g(hVar, k2, nVar);
            } else {
                hVar.e();
                f a2 = gVar2.a(hVar, dVar2.m(), cVar);
                int i3 = a2.f5048a;
                if (i3 == -3) {
                    e(false, k2);
                    return g(hVar, k2, nVar);
                } else if (i3 == -2) {
                    dVar2.p(a2.f5049b, a2.f5050c);
                } else if (i3 == -1) {
                    dVar2.o(a2.f5049b, a2.f5050c);
                } else if (i3 == 0) {
                    e(true, a2.f5050c);
                    i(hVar, a2.f5050c);
                    return g(hVar, a2.f5050c, nVar);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean d() {
        return this.f5030c != null;
    }

    /* access modifiers changed from: protected */
    public final void e(boolean z, long j2) {
        this.f5030c = null;
        f(z, j2);
    }

    /* access modifiers changed from: protected */
    public void f(boolean z, long j2) {
    }

    /* access modifiers changed from: protected */
    public final int g(h hVar, long j2, n nVar) {
        if (j2 == hVar.l()) {
            return 0;
        }
        nVar.f5095a = j2;
        return 1;
    }

    public final void h(long j2) {
        d dVar = this.f5030c;
        if (dVar == null || dVar.l() != j2) {
            this.f5030c = a(j2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i(h hVar, long j2) {
        long l = j2 - hVar.l();
        if (l < 0 || l > 262144) {
            return false;
        }
        hVar.f((int) l);
        return true;
    }
}
