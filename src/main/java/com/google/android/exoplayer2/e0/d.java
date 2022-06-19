package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: DefaultExtractorInput */
public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5063a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    private final i f5064b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5065c;

    /* renamed from: d  reason: collision with root package name */
    private long f5066d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f5067e = new byte[65536];

    /* renamed from: f  reason: collision with root package name */
    private int f5068f;

    /* renamed from: g  reason: collision with root package name */
    private int f5069g;

    public d(i iVar, long j2, long j3) {
        this.f5064b = iVar;
        this.f5066d = j2;
        this.f5065c = j3;
    }

    private void m(int i2) {
        if (i2 != -1) {
            this.f5066d += (long) i2;
        }
    }

    private void n(int i2) {
        int i3 = this.f5068f + i2;
        byte[] bArr = this.f5067e;
        if (i3 > bArr.length) {
            this.f5067e = Arrays.copyOf(this.f5067e, d0.n(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int o(byte[] bArr, int i2, int i3, int i4, boolean z) {
        if (!Thread.interrupted()) {
            int a2 = this.f5064b.a(bArr, i2 + i4, i3 - i4);
            if (a2 != -1) {
                return i4 + a2;
            }
            if (i4 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private int p(byte[] bArr, int i2, int i3) {
        int i4 = this.f5069g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f5067e, 0, bArr, i2, min);
        s(min);
        return min;
    }

    private int q(int i2) {
        int min = Math.min(this.f5069g, i2);
        s(min);
        return min;
    }

    private void s(int i2) {
        int i3 = this.f5069g - i2;
        this.f5069g = i3;
        this.f5068f = 0;
        byte[] bArr = this.f5067e;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[(65536 + i3)] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f5067e = bArr2;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public int a(byte[] bArr, int i2, int i3) {
        int p = p(bArr, i2, i3);
        if (p == 0) {
            p = o(bArr, i2, i3, 0, true);
        }
        m(p);
        return p;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public int b(int i2) {
        int q = q(i2);
        if (q == 0) {
            byte[] bArr = this.f5063a;
            q = o(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        m(q);
        return q;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public boolean c(byte[] bArr, int i2, int i3, boolean z) {
        int p = p(bArr, i2, i3);
        while (p < i3 && p != -1) {
            p = o(bArr, i2, i3, p, z);
        }
        m(p);
        return p != -1;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public long d() {
        return this.f5065c;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public void e() {
        this.f5068f = 0;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public void f(int i2) {
        r(i2, false);
    }

    @Override // com.google.android.exoplayer2.e0.h
    public boolean g(int i2, boolean z) {
        n(i2);
        int i3 = this.f5069g - this.f5068f;
        while (i3 < i2) {
            i3 = o(this.f5067e, this.f5068f, i2, i3, z);
            if (i3 == -1) {
                return false;
            }
            this.f5069g = this.f5068f + i3;
        }
        this.f5068f += i2;
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public boolean h(byte[] bArr, int i2, int i3, boolean z) {
        if (!g(i3, z)) {
            return false;
        }
        System.arraycopy(this.f5067e, this.f5068f - i3, bArr, i2, i3);
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public long i() {
        return this.f5066d + ((long) this.f5068f);
    }

    @Override // com.google.android.exoplayer2.e0.h
    public void j(byte[] bArr, int i2, int i3) {
        h(bArr, i2, i3, false);
    }

    @Override // com.google.android.exoplayer2.e0.h
    public void k(int i2) {
        g(i2, false);
    }

    @Override // com.google.android.exoplayer2.e0.h
    public long l() {
        return this.f5066d;
    }

    public boolean r(int i2, boolean z) {
        int q = q(i2);
        while (q < i2 && q != -1) {
            q = o(this.f5063a, -q, Math.min(i2, this.f5063a.length + q), q, z);
        }
        m(q);
        return q != -1;
    }

    @Override // com.google.android.exoplayer2.e0.h
    public void readFully(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3, false);
    }
}
