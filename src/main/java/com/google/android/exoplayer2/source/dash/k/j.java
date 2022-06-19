package com.google.android.exoplayer2.source.dash.k;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import java.util.List;

/* compiled from: SegmentBase */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    final h f6296a;

    /* renamed from: b  reason: collision with root package name */
    final long f6297b;

    /* renamed from: c  reason: collision with root package name */
    final long f6298c;

    /* compiled from: SegmentBase */
    public static abstract class a extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f6299d;

        /* renamed from: e  reason: collision with root package name */
        final long f6300e;

        /* renamed from: f  reason: collision with root package name */
        final List<d> f6301f;

        public a(h hVar, long j2, long j3, long j4, long j5, List<d> list) {
            super(hVar, j2, j3);
            this.f6299d = j4;
            this.f6300e = j5;
            this.f6301f = list;
        }

        public long c() {
            return this.f6299d;
        }

        public abstract int d(long j2);

        public final long e(long j2, long j3) {
            List<d> list = this.f6301f;
            if (list != null) {
                return (list.get((int) (j2 - this.f6299d)).f6306b * 1000000) / this.f6297b;
            }
            int d2 = d(j3);
            return (d2 == -1 || j2 != (c() + ((long) d2)) - 1) ? (this.f6300e * 1000000) / this.f6297b : j3 - g(j2);
        }

        public long f(long j2, long j3) {
            long c2 = c();
            long d2 = (long) d(j3);
            if (d2 == 0) {
                return c2;
            }
            if (this.f6301f == null) {
                long j4 = this.f6299d + (j2 / ((this.f6300e * 1000000) / this.f6297b));
                if (j4 < c2) {
                    return c2;
                }
                return d2 == -1 ? j4 : Math.min(j4, (c2 + d2) - 1);
            }
            long j5 = (d2 + c2) - 1;
            long j6 = c2;
            while (j6 <= j5) {
                long j7 = ((j5 - j6) / 2) + j6;
                long g2 = g(j7);
                if (g2 < j2) {
                    j6 = j7 + 1;
                } else if (g2 <= j2) {
                    return j7;
                } else {
                    j5 = j7 - 1;
                }
            }
            return j6 == c2 ? j6 : j5;
        }

        public final long g(long j2) {
            long j3;
            List<d> list = this.f6301f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f6299d)).f6305a - this.f6298c;
            } else {
                j3 = (j2 - this.f6299d) * this.f6300e;
            }
            return d0.Z(j3, 1000000, this.f6297b);
        }

        public abstract h h(i iVar, long j2);

        public boolean i() {
            return this.f6301f != null;
        }
    }

    /* compiled from: SegmentBase */
    public static class b extends a {

        /* renamed from: g  reason: collision with root package name */
        final List<h> f6302g;

        public b(h hVar, long j2, long j3, long j4, long j5, List<d> list, List<h> list2) {
            super(hVar, j2, j3, j4, j5, list);
            this.f6302g = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j.a
        public int d(long j2) {
            return this.f6302g.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j.a
        public h h(i iVar, long j2) {
            return this.f6302g.get((int) (j2 - this.f6299d));
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j.a
        public boolean i() {
            return true;
        }
    }

    /* compiled from: SegmentBase */
    public static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        final l f6303g;

        /* renamed from: h  reason: collision with root package name */
        final l f6304h;

        public c(h hVar, long j2, long j3, long j4, long j5, List<d> list, l lVar, l lVar2) {
            super(hVar, j2, j3, j4, j5, list);
            this.f6303g = lVar;
            this.f6304h = lVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j
        public h a(i iVar) {
            l lVar = this.f6303g;
            if (lVar == null) {
                return j.super.a(iVar);
            }
            l lVar2 = iVar.f6287a;
            return new h(lVar.a(lVar2.f5971b, 0, lVar2.f5973d, 0), 0, -1);
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j.a
        public int d(long j2) {
            List<d> list = this.f6301f;
            if (list != null) {
                return list.size();
            }
            if (j2 != -9223372036854775807L) {
                return (int) d0.i(j2, (this.f6300e * 1000000) / this.f6297b);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.dash.k.j.a
        public h h(i iVar, long j2) {
            long j3;
            List<d> list = this.f6301f;
            if (list != null) {
                j3 = list.get((int) (j2 - this.f6299d)).f6305a;
            } else {
                j3 = (j2 - this.f6299d) * this.f6300e;
            }
            l lVar = this.f6304h;
            l lVar2 = iVar.f6287a;
            return new h(lVar.a(lVar2.f5971b, j2, lVar2.f5973d, j3), 0, -1);
        }
    }

    /* compiled from: SegmentBase */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final long f6305a;

        /* renamed from: b  reason: collision with root package name */
        final long f6306b;

        public d(long j2, long j3) {
            this.f6305a = j2;
            this.f6306b = j3;
        }
    }

    public j(h hVar, long j2, long j3) {
        this.f6296a = hVar;
        this.f6297b = j2;
        this.f6298c = j3;
    }

    public h a(i iVar) {
        return this.f6296a;
    }

    public long b() {
        return d0.Z(this.f6298c, 1000000, this.f6297b);
    }

    /* compiled from: SegmentBase */
    public static class e extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f6307d;

        /* renamed from: e  reason: collision with root package name */
        final long f6308e;

        public e(h hVar, long j2, long j3, long j4, long j5) {
            super(hVar, j2, j3);
            this.f6307d = j4;
            this.f6308e = j5;
        }

        public h c() {
            long j2 = this.f6308e;
            if (j2 <= 0) {
                return null;
            }
            return new h(null, this.f6307d, j2);
        }

        public e() {
            this(null, 1, 0, 0, 0);
        }
    }
}
