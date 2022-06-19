package com.google.android.exoplayer2.e0.s;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayDeque;

/* access modifiers changed from: package-private */
/* compiled from: DefaultEbmlReader */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5120a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<C0122b> f5121b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final g f5122c = new g();

    /* renamed from: d  reason: collision with root package name */
    private d f5123d;

    /* renamed from: e  reason: collision with root package name */
    private int f5124e;

    /* renamed from: f  reason: collision with root package name */
    private int f5125f;

    /* renamed from: g  reason: collision with root package name */
    private long f5126g;

    /* renamed from: com.google.android.exoplayer2.e0.s.b$b  reason: collision with other inner class name */
    /* compiled from: DefaultEbmlReader */
    private static final class C0122b {

        /* renamed from: a  reason: collision with root package name */
        private final int f5127a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5128b;

        private C0122b(int i2, long j2) {
            this.f5127a = i2;
            this.f5128b = j2;
        }
    }

    private long c(h hVar) {
        hVar.e();
        while (true) {
            hVar.j(this.f5120a, 0, 4);
            int c2 = g.c(this.f5120a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) g.a(this.f5120a, c2, false);
                if (this.f5123d.d(a2)) {
                    hVar.f(c2);
                    return (long) a2;
                }
            }
            hVar.f(1);
        }
    }

    private double d(h hVar, int i2) {
        long f2 = f(hVar, i2);
        if (i2 == 4) {
            return (double) Float.intBitsToFloat((int) f2);
        }
        return Double.longBitsToDouble(f2);
    }

    private long f(h hVar, int i2) {
        hVar.readFully(this.f5120a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f5120a[i3] & 255));
        }
        return j2;
    }

    private String g(h hVar, int i2) {
        if (i2 == 0) {
            return BuildConfig.FLAVOR;
        }
        byte[] bArr = new byte[i2];
        hVar.readFully(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    @Override // com.google.android.exoplayer2.e0.s.c
    public boolean a(h hVar) {
        e.f(this.f5123d != null);
        while (true) {
            if (this.f5121b.isEmpty() || hVar.l() < this.f5121b.peek().f5128b) {
                if (this.f5124e == 0) {
                    long d2 = this.f5122c.d(hVar, true, false, 4);
                    if (d2 == -2) {
                        d2 = c(hVar);
                    }
                    if (d2 == -1) {
                        return false;
                    }
                    this.f5125f = (int) d2;
                    this.f5124e = 1;
                }
                if (this.f5124e == 1) {
                    this.f5126g = this.f5122c.d(hVar, false, true, 8);
                    this.f5124e = 2;
                }
                int b2 = this.f5123d.b(this.f5125f);
                if (b2 == 0) {
                    hVar.f((int) this.f5126g);
                    this.f5124e = 0;
                } else if (b2 == 1) {
                    long l = hVar.l();
                    this.f5121b.push(new C0122b(this.f5125f, this.f5126g + l));
                    this.f5123d.g(this.f5125f, l, this.f5126g);
                    this.f5124e = 0;
                    return true;
                } else if (b2 == 2) {
                    long j2 = this.f5126g;
                    if (j2 <= 8) {
                        this.f5123d.h(this.f5125f, f(hVar, (int) j2));
                        this.f5124e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f5126g);
                } else if (b2 == 3) {
                    long j3 = this.f5126g;
                    if (j3 <= 2147483647L) {
                        this.f5123d.f(this.f5125f, g(hVar, (int) j3));
                        this.f5124e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f5126g);
                } else if (b2 == 4) {
                    this.f5123d.e(this.f5125f, (int) this.f5126g, hVar);
                    this.f5124e = 0;
                    return true;
                } else if (b2 == 5) {
                    long j4 = this.f5126g;
                    if (j4 == 4 || j4 == 8) {
                        this.f5123d.c(this.f5125f, d(hVar, (int) j4));
                        this.f5124e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid float size: " + this.f5126g);
                } else {
                    throw new ParserException("Invalid element type " + b2);
                }
            } else {
                this.f5123d.a(this.f5121b.pop().f5127a);
                return true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.s.c
    public void b(d dVar) {
        this.f5123d = dVar;
    }

    @Override // com.google.android.exoplayer2.e0.s.c
    public void e() {
        this.f5124e = 0;
        this.f5121b.clear();
        this.f5122c.e();
    }
}
