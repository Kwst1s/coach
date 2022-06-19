package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.a;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: PsBinarySearchSeeker */
public final class u extends com.google.android.exoplayer2.e0.a {

    /* compiled from: PsBinarySearchSeeker */
    private static final class b implements a.g {

        /* renamed from: a  reason: collision with root package name */
        private final a0 f5625a;

        /* renamed from: b  reason: collision with root package name */
        private final s f5626b;

        private a.f b(s sVar, long j2, long j3) {
            int i2 = -1;
            long j4 = -9223372036854775807L;
            int i3 = -1;
            while (sVar.a() >= 4) {
                if (u.k(sVar.f7062a, sVar.c()) != 442) {
                    sVar.L(1);
                } else {
                    sVar.L(4);
                    long l = v.l(sVar);
                    if (l != -9223372036854775807L) {
                        long b2 = this.f5625a.b(l);
                        if (b2 > j2) {
                            if (j4 == -9223372036854775807L) {
                                return a.f.d(b2, j3);
                            }
                            return a.f.e(j3 + ((long) i3));
                        } else if (100000 + b2 > j2) {
                            return a.f.e(j3 + ((long) sVar.c()));
                        } else {
                            i3 = sVar.c();
                            j4 = b2;
                        }
                    }
                    c(sVar);
                    i2 = sVar.c();
                }
            }
            if (j4 != -9223372036854775807L) {
                return a.f.f(j4, j3 + ((long) i2));
            }
            return a.f.f5047d;
        }

        private static void c(s sVar) {
            int d2 = sVar.d();
            if (sVar.a() < 10) {
                sVar.K(d2);
                return;
            }
            sVar.L(9);
            int y = sVar.y() & 7;
            if (sVar.a() < y) {
                sVar.K(d2);
                return;
            }
            sVar.L(y);
            if (sVar.a() < 4) {
                sVar.K(d2);
                return;
            }
            if (u.k(sVar.f7062a, sVar.c()) == 443) {
                sVar.L(4);
                int E = sVar.E();
                if (sVar.a() < E) {
                    sVar.K(d2);
                    return;
                }
                sVar.L(E);
            }
            while (sVar.a() >= 4 && (r1 = u.k(sVar.f7062a, sVar.c())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                sVar.L(4);
                if (sVar.a() < 2) {
                    sVar.K(d2);
                    return;
                }
                sVar.K(Math.min(sVar.d(), sVar.c() + sVar.E()));
            }
        }

        @Override // com.google.android.exoplayer2.e0.a.g
        public a.f a(h hVar, long j2, a.c cVar) {
            long l = hVar.l();
            int min = (int) Math.min(20000L, hVar.d() - hVar.l());
            this.f5626b.H(min);
            hVar.j(this.f5626b.f7062a, 0, min);
            return b(this.f5626b, j2, l);
        }

        private b(a0 a0Var) {
            this.f5625a = a0Var;
            this.f5626b = new s(20000);
        }
    }

    public u(a0 a0Var, long j2, long j3) {
        super(new a.b(), new b(a0Var), j2, 0, j2 + 1, 0, j3, 188, 1000);
    }

    /* access modifiers changed from: private */
    public static int k(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
