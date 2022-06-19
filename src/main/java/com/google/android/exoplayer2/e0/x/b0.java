package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.a;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: TsBinarySearchSeeker */
public final class b0 extends com.google.android.exoplayer2.e0.a {

    /* compiled from: TsBinarySearchSeeker */
    private static final class a implements a.g {

        /* renamed from: a  reason: collision with root package name */
        private final a0 f5409a;

        /* renamed from: b  reason: collision with root package name */
        private final s f5410b = new s(37600);

        /* renamed from: c  reason: collision with root package name */
        private final int f5411c;

        public a(int i2, a0 a0Var) {
            this.f5411c = i2;
            this.f5409a = a0Var;
        }

        private a.f b(s sVar, long j2, long j3) {
            int a2;
            int a3;
            int d2 = sVar.d();
            long j4 = -1;
            long j5 = -1;
            long j6 = -9223372036854775807L;
            while (sVar.a() >= 188 && (a3 = (a2 = f0.a(sVar.f7062a, sVar.c(), d2)) + 188) <= d2) {
                long b2 = f0.b(sVar, a2, this.f5411c);
                if (b2 != -9223372036854775807L) {
                    long b3 = this.f5409a.b(b2);
                    if (b3 > j2) {
                        if (j6 == -9223372036854775807L) {
                            return a.f.d(b3, j3);
                        }
                        return a.f.e(j3 + j5);
                    } else if (100000 + b3 > j2) {
                        return a.f.e(j3 + ((long) a2));
                    } else {
                        j5 = (long) a2;
                        j6 = b3;
                    }
                }
                sVar.K(a3);
                j4 = (long) a3;
            }
            if (j6 != -9223372036854775807L) {
                return a.f.f(j6, j3 + j4);
            }
            return a.f.f5047d;
        }

        @Override // com.google.android.exoplayer2.e0.a.g
        public a.f a(h hVar, long j2, a.c cVar) {
            long l = hVar.l();
            int min = (int) Math.min(37600L, hVar.d() - hVar.l());
            this.f5410b.H(min);
            hVar.j(this.f5410b.f7062a, 0, min);
            return b(this.f5410b, j2, l);
        }
    }

    public b0(a0 a0Var, long j2, long j3, int i2) {
        super(new a.b(), new a(i2, a0Var), j2, 0, j2 + 1, 0, j3, 188, 940);
    }
}
