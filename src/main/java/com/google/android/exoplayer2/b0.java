package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.a;
import com.google.android.exoplayer2.util.e;

/* compiled from: Timeline */
public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f4885a = new a();

    /* compiled from: Timeline */
    static class a extends b0 {
        a() {
        }

        @Override // com.google.android.exoplayer2.b0
        public int b(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.b0
        public b g(int i2, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.b0
        public int i() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b0
        public Object m(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.b0
        public c p(int i2, c cVar, boolean z, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.b0
        public int q() {
            return 0;
        }
    }

    /* compiled from: Timeline */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f4886a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4887b;

        /* renamed from: c  reason: collision with root package name */
        public int f4888c;

        /* renamed from: d  reason: collision with root package name */
        public long f4889d;

        /* renamed from: e  reason: collision with root package name */
        private long f4890e;

        /* renamed from: f  reason: collision with root package name */
        private com.google.android.exoplayer2.source.ads.a f4891f;

        public int a(int i2) {
            return this.f4891f.f6071c[i2].f6074a;
        }

        public long b(int i2, int i3) {
            a.C0131a aVar = this.f4891f.f6071c[i2];
            if (aVar.f6074a != -1) {
                return aVar.f6077d[i3];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f4891f.f6069a;
        }

        public int d(long j2) {
            return this.f4891f.a(j2);
        }

        public int e(long j2) {
            return this.f4891f.b(j2);
        }

        public long f(int i2) {
            return this.f4891f.f6070b[i2];
        }

        public long g() {
            return this.f4891f.f6072d;
        }

        public long h() {
            return this.f4889d;
        }

        public int i(int i2) {
            return this.f4891f.f6071c[i2].a();
        }

        public int j(int i2, int i3) {
            return this.f4891f.f6071c[i2].b(i3);
        }

        public long k() {
            return d.b(this.f4890e);
        }

        public boolean l(int i2) {
            return !this.f4891f.f6071c[i2].c();
        }

        public boolean m(int i2, int i3) {
            a.C0131a aVar = this.f4891f.f6071c[i2];
            return (aVar.f6074a == -1 || aVar.f6076c[i3] == 0) ? false : true;
        }

        public b n(Object obj, Object obj2, int i2, long j2, long j3) {
            o(obj, obj2, i2, j2, j3, com.google.android.exoplayer2.source.ads.a.f6068f);
            return this;
        }

        public b o(Object obj, Object obj2, int i2, long j2, long j3, com.google.android.exoplayer2.source.ads.a aVar) {
            this.f4886a = obj;
            this.f4887b = obj2;
            this.f4888c = i2;
            this.f4889d = j2;
            this.f4890e = j3;
            this.f4891f = aVar;
            return this;
        }
    }

    /* compiled from: Timeline */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Object f4892a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4893b;

        /* renamed from: c  reason: collision with root package name */
        public int f4894c;

        /* renamed from: d  reason: collision with root package name */
        public int f4895d;

        /* renamed from: e  reason: collision with root package name */
        public long f4896e;

        /* renamed from: f  reason: collision with root package name */
        public long f4897f;

        /* renamed from: g  reason: collision with root package name */
        public long f4898g;

        public long a() {
            return d.b(this.f4896e);
        }

        public long b() {
            return this.f4896e;
        }

        public long c() {
            return d.b(this.f4897f);
        }

        public long d() {
            return this.f4898g;
        }

        public c e(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            this.f4892a = obj;
            this.f4893b = z2;
            this.f4896e = j4;
            this.f4897f = j5;
            this.f4894c = i2;
            this.f4895d = i3;
            this.f4898g = j6;
            return this;
        }
    }

    public int a(boolean z) {
        return r() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z) {
        if (r()) {
            return -1;
        }
        return q() - 1;
    }

    public final int d(int i2, b bVar, c cVar, int i3, boolean z) {
        int i4 = f(i2, bVar).f4888c;
        if (n(i4, cVar).f4895d != i2) {
            return i2 + 1;
        }
        int e2 = e(i4, i3, z);
        if (e2 == -1) {
            return -1;
        }
        return n(e2, cVar).f4894c;
    }

    public int e(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == c(z) ? a(z) : i2 + 1;
            }
            throw new IllegalStateException();
        } else if (i2 == c(z)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public final b f(int i2, b bVar) {
        return g(i2, bVar, false);
    }

    public abstract b g(int i2, b bVar, boolean z);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public abstract int i();

    public final Pair<Object, Long> j(c cVar, b bVar, int i2, long j2) {
        return k(cVar, bVar, i2, j2, 0);
    }

    public final Pair<Object, Long> k(c cVar, b bVar, int i2, long j2, long j3) {
        e.c(i2, 0, q());
        p(i2, cVar, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = cVar.b();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = cVar.f4894c;
        long d2 = cVar.d() + j2;
        long h2 = g(i3, bVar, true).h();
        while (h2 != -9223372036854775807L && d2 >= h2 && i3 < cVar.f4895d) {
            d2 -= h2;
            i3++;
            h2 = g(i3, bVar, true).h();
        }
        return Pair.create(bVar.f4887b, Long.valueOf(d2));
    }

    public int l(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == a(z) ? c(z) : i2 - 1;
            }
            throw new IllegalStateException();
        } else if (i2 == a(z)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public abstract Object m(int i2);

    public final c n(int i2, c cVar) {
        return o(i2, cVar, false);
    }

    public final c o(int i2, c cVar, boolean z) {
        return p(i2, cVar, z, 0);
    }

    public abstract c p(int i2, c cVar, boolean z, long j2);

    public abstract int q();

    public final boolean r() {
        return q() == 0;
    }

    public final boolean s(int i2, b bVar, c cVar, int i3, boolean z) {
        return d(i2, bVar, cVar, i3, z) == -1;
    }
}
