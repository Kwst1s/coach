package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.util.e;
import java.io.EOFException;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: DefaultOggSeeker */
public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private final f f5333a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final long f5334b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5335c;

    /* renamed from: d  reason: collision with root package name */
    private final i f5336d;

    /* renamed from: e  reason: collision with root package name */
    private int f5337e;

    /* renamed from: f  reason: collision with root package name */
    private long f5338f;

    /* renamed from: g  reason: collision with root package name */
    private long f5339g;

    /* renamed from: h  reason: collision with root package name */
    private long f5340h;

    /* renamed from: i  reason: collision with root package name */
    private long f5341i;

    /* renamed from: j  reason: collision with root package name */
    private long f5342j;

    /* renamed from: k  reason: collision with root package name */
    private long f5343k;
    private long l;

    /* access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.e0.v.b$b  reason: collision with other inner class name */
    /* compiled from: DefaultOggSeeker */
    public class C0124b implements o {
        private C0124b() {
        }

        @Override // com.google.android.exoplayer2.e0.o
        public boolean g() {
            return true;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public o.a h(long j2) {
            if (j2 == 0) {
                return new o.a(new p(0, b.this.f5334b));
            }
            long b2 = b.this.f5336d.b(j2);
            b bVar = b.this;
            return new o.a(new p(j2, bVar.i(bVar.f5334b, b2, 30000)));
        }

        @Override // com.google.android.exoplayer2.e0.o
        public long j() {
            return b.this.f5336d.a(b.this.f5338f);
        }
    }

    public b(long j2, long j3, i iVar, long j4, long j5, boolean z) {
        e.a(j2 >= 0 && j3 > j2);
        this.f5336d = iVar;
        this.f5334b = j2;
        this.f5335c = j3;
        if (j4 == j3 - j2 || z) {
            this.f5338f = j5;
            this.f5337e = 3;
            return;
        }
        this.f5337e = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long i(long j2, long j3, long j4) {
        long j5 = this.f5335c;
        long j6 = this.f5334b;
        long j7 = j2 + (((j3 * (j5 - j6)) / this.f5338f) - j4);
        if (j7 >= j6) {
            j6 = j7;
        }
        return j6 >= j5 ? j5 - 1 : j6;
    }

    @Override // com.google.android.exoplayer2.e0.v.g
    public long a(h hVar) {
        int i2 = this.f5337e;
        if (i2 == 0) {
            long l2 = hVar.l();
            this.f5339g = l2;
            this.f5337e = 1;
            long j2 = this.f5335c - 65307;
            if (j2 > l2) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long j3 = this.f5340h;
                long j4 = 0;
                if (j3 != 0) {
                    long j5 = j(j3, hVar);
                    if (j5 >= 0) {
                        return j5;
                    }
                    j4 = o(hVar, this.f5340h, -(j5 + 2));
                }
                this.f5337e = 3;
                return -(j4 + 2);
            } else if (i2 == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f5338f = k(hVar);
        this.f5337e = 3;
        return this.f5339g;
    }

    @Override // com.google.android.exoplayer2.e0.v.g
    public long e(long j2) {
        int i2 = this.f5337e;
        e.a(i2 == 3 || i2 == 2);
        long j3 = 0;
        if (j2 != 0) {
            j3 = this.f5336d.b(j2);
        }
        this.f5340h = j3;
        this.f5337e = 2;
        l();
        return this.f5340h;
    }

    /* renamed from: h */
    public C0124b c() {
        if (this.f5338f != 0) {
            return new C0124b();
        }
        return null;
    }

    public long j(long j2, h hVar) {
        long j3 = 2;
        if (this.f5341i == this.f5342j) {
            return -(this.f5343k + 2);
        }
        long l2 = hVar.l();
        if (!n(hVar, this.f5342j)) {
            long j4 = this.f5341i;
            if (j4 != l2) {
                return j4;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f5333a.a(hVar, false);
        hVar.e();
        f fVar = this.f5333a;
        long j5 = fVar.f5361c;
        long j6 = j2 - j5;
        int i2 = fVar.f5363e + fVar.f5364f;
        if (j6 < 0 || j6 > 72000) {
            if (j6 < 0) {
                this.f5342j = l2;
                this.l = j5;
            } else {
                long j7 = (long) i2;
                long l3 = hVar.l() + j7;
                this.f5341i = l3;
                this.f5343k = this.f5333a.f5361c;
                if ((this.f5342j - l3) + j7 < 100000) {
                    hVar.f(i2);
                    return -(this.f5343k + 2);
                }
            }
            long j8 = this.f5342j;
            long j9 = this.f5341i;
            if (j8 - j9 < 100000) {
                this.f5342j = j9;
                return j9;
            }
            long j10 = (long) i2;
            if (j6 > 0) {
                j3 = 1;
            }
            long j11 = j10 * j3;
            long j12 = this.f5342j;
            long j13 = this.f5341i;
            return Math.min(Math.max((hVar.l() - j11) + ((j6 * (j12 - j13)) / (this.l - this.f5343k)), j13), this.f5342j - 1);
        }
        hVar.f(i2);
        return -(this.f5333a.f5361c + 2);
    }

    /* access modifiers changed from: package-private */
    public long k(h hVar) {
        m(hVar);
        this.f5333a.b();
        while ((this.f5333a.f5360b & 4) != 4 && hVar.l() < this.f5335c) {
            this.f5333a.a(hVar, false);
            f fVar = this.f5333a;
            hVar.f(fVar.f5363e + fVar.f5364f);
        }
        return this.f5333a.f5361c;
    }

    public void l() {
        this.f5341i = this.f5334b;
        this.f5342j = this.f5335c;
        this.f5343k = 0;
        this.l = this.f5338f;
    }

    /* access modifiers changed from: package-private */
    public void m(h hVar) {
        if (!n(hVar, this.f5335c)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n(h hVar, long j2) {
        int i2;
        long min = Math.min(j2 + 3, this.f5335c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i4 = 0;
            if (hVar.l() + ((long) i3) <= min || (i3 = (int) (min - hVar.l())) >= 4) {
                hVar.h(bArr, 0, i3, false);
                while (true) {
                    i2 = i3 - 3;
                    if (i4 >= i2) {
                        break;
                    } else if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        hVar.f(i4);
                        return true;
                    } else {
                        i4++;
                    }
                }
            } else {
                return false;
            }
            hVar.f(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public long o(h hVar, long j2, long j3) {
        this.f5333a.a(hVar, false);
        while (true) {
            f fVar = this.f5333a;
            if (fVar.f5361c < j2) {
                hVar.f(fVar.f5363e + fVar.f5364f);
                f fVar2 = this.f5333a;
                long j4 = fVar2.f5361c;
                fVar2.a(hVar, false);
                j3 = j4;
            } else {
                hVar.e();
                return j3;
            }
        }
    }
}
