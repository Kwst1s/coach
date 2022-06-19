package com.google.android.exoplayer2.e0.r;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.c;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: AmrExtractor */
public final class b implements g {
    private static final int[] p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] q;
    private static final byte[] r = d0.K("#!AMR\n");
    private static final byte[] s = d0.K("#!AMR-WB\n");
    private static final int t;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5108a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5109b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5110c;

    /* renamed from: d  reason: collision with root package name */
    private long f5111d;

    /* renamed from: e  reason: collision with root package name */
    private int f5112e;

    /* renamed from: f  reason: collision with root package name */
    private int f5113f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5114g;

    /* renamed from: h  reason: collision with root package name */
    private long f5115h;

    /* renamed from: i  reason: collision with root package name */
    private int f5116i;

    /* renamed from: j  reason: collision with root package name */
    private int f5117j;

    /* renamed from: k  reason: collision with root package name */
    private long f5118k;
    private i l;
    private q m;
    private o n;
    private boolean o;

    static {
        a aVar = a.f5107a;
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        q = iArr;
        t = iArr[8];
    }

    public b() {
        this(0);
    }

    private static int b(int i2, long j2) {
        return (int) ((((long) (i2 * 8)) * 1000000) / j2);
    }

    private o d(long j2) {
        return new c(j2, this.f5115h, b(this.f5116i, 20000), this.f5116i);
    }

    private int g(int i2) {
        if (j(i2)) {
            return this.f5110c ? q[i2] : p[i2];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f5110c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i2);
        throw new ParserException(sb.toString());
    }

    private boolean h(int i2) {
        return !this.f5110c && (i2 < 12 || i2 > 14);
    }

    private boolean j(int i2) {
        return i2 >= 0 && i2 <= 15 && (k(i2) || h(i2));
    }

    private boolean k(int i2) {
        return this.f5110c && (i2 < 10 || i2 > 13);
    }

    static /* synthetic */ g[] l() {
        return new g[]{new b()};
    }

    private void m() {
        if (!this.o) {
            this.o = true;
            boolean z = this.f5110c;
            this.m.d(l.s(null, z ? "audio/amr-wb" : "audio/3gpp", null, -1, t, 1, z ? 16000 : 8000, -1, null, null, 0, null));
        }
    }

    private void n(long j2, int i2) {
        int i3;
        if (!this.f5114g) {
            if ((this.f5109b & 1) == 0 || j2 == -1 || !((i3 = this.f5116i) == -1 || i3 == this.f5112e)) {
                o.b bVar = new o.b(-9223372036854775807L);
                this.n = bVar;
                this.l.e(bVar);
                this.f5114g = true;
            } else if (this.f5117j >= 20 || i2 == -1) {
                o d2 = d(j2);
                this.n = d2;
                this.l.e(d2);
                this.f5114g = true;
            }
        }
    }

    private boolean o(h hVar, byte[] bArr) {
        hVar.e();
        byte[] bArr2 = new byte[bArr.length];
        hVar.j(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int p(h hVar) {
        hVar.e();
        hVar.j(this.f5108a, 0, 1);
        byte b2 = this.f5108a[0];
        if ((b2 & 131) <= 0) {
            return g((b2 >> 3) & 15);
        }
        throw new ParserException("Invalid padding bits for frame header " + ((int) b2));
    }

    private boolean q(h hVar) {
        byte[] bArr = r;
        if (o(hVar, bArr)) {
            this.f5110c = false;
            hVar.f(bArr.length);
            return true;
        }
        byte[] bArr2 = s;
        if (!o(hVar, bArr2)) {
            return false;
        }
        this.f5110c = true;
        hVar.f(bArr2.length);
        return true;
    }

    private int r(h hVar) {
        if (this.f5113f == 0) {
            try {
                int p2 = p(hVar);
                this.f5112e = p2;
                this.f5113f = p2;
                if (this.f5116i == -1) {
                    this.f5115h = hVar.l();
                    this.f5116i = this.f5112e;
                }
                if (this.f5116i == this.f5112e) {
                    this.f5117j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b2 = this.m.b(hVar, this.f5113f, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.f5113f - b2;
        this.f5113f = i2;
        if (i2 > 0) {
            return 0;
        }
        this.m.c(this.f5118k + this.f5111d, 1, this.f5112e, 0, null);
        this.f5111d += 20000;
        return 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.l = iVar;
        this.m = iVar.a(0, 1);
        iVar.h();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5111d = 0;
        this.f5112e = 0;
        this.f5113f = 0;
        if (j2 != 0) {
            o oVar = this.n;
            if (oVar instanceof c) {
                this.f5118k = ((c) oVar).c(j2);
                return;
            }
        }
        this.f5118k = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        return q(hVar);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        if (hVar.l() != 0 || q(hVar)) {
            m();
            int r2 = r(hVar);
            n(hVar.d(), r2);
            return r2;
        }
        throw new ParserException("Could not find AMR header.");
    }

    public b(int i2) {
        this.f5109b = i2;
        this.f5108a = new byte[1];
        this.f5116i = -1;
    }
}
