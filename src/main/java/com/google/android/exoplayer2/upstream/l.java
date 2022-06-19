package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.Arrays;

/* compiled from: DefaultAllocator */
public final class l implements d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6930a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6931b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f6932c;

    /* renamed from: d  reason: collision with root package name */
    private final c[] f6933d;

    /* renamed from: e  reason: collision with root package name */
    private int f6934e;

    /* renamed from: f  reason: collision with root package name */
    private int f6935f;

    /* renamed from: g  reason: collision with root package name */
    private int f6936g;

    /* renamed from: h  reason: collision with root package name */
    private c[] f6937h;

    public l(boolean z, int i2) {
        this(z, i2, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.d
    public synchronized void a() {
        int i2 = 0;
        int max = Math.max(0, d0.h(this.f6934e, this.f6931b) - this.f6935f);
        int i3 = this.f6936g;
        if (max < i3) {
            if (this.f6932c != null) {
                int i4 = i3 - 1;
                while (i2 <= i4) {
                    c[] cVarArr = this.f6937h;
                    c cVar = cVarArr[i2];
                    byte[] bArr = cVar.f6907a;
                    byte[] bArr2 = this.f6932c;
                    if (bArr == bArr2) {
                        i2++;
                    } else {
                        c cVar2 = cVarArr[i4];
                        if (cVar2.f6907a != bArr2) {
                            i4--;
                        } else {
                            cVarArr[i2] = cVar2;
                            cVarArr[i4] = cVar;
                            i4--;
                            i2++;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.f6936g) {
                    return;
                }
            }
            Arrays.fill(this.f6937h, max, this.f6936g, (Object) null);
            this.f6936g = max;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.d
    public synchronized void b(c cVar) {
        c[] cVarArr = this.f6933d;
        cVarArr[0] = cVar;
        c(cVarArr);
    }

    @Override // com.google.android.exoplayer2.upstream.d
    public synchronized void c(c[] cVarArr) {
        int i2 = this.f6936g;
        int length = cVarArr.length + i2;
        c[] cVarArr2 = this.f6937h;
        if (length >= cVarArr2.length) {
            this.f6937h = (c[]) Arrays.copyOf(cVarArr2, Math.max(cVarArr2.length * 2, i2 + cVarArr.length));
        }
        for (c cVar : cVarArr) {
            c[] cVarArr3 = this.f6937h;
            int i3 = this.f6936g;
            this.f6936g = i3 + 1;
            cVarArr3[i3] = cVar;
        }
        this.f6935f -= cVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.d
    public synchronized c d() {
        c cVar;
        this.f6935f++;
        int i2 = this.f6936g;
        if (i2 > 0) {
            c[] cVarArr = this.f6937h;
            int i3 = i2 - 1;
            this.f6936g = i3;
            cVar = cVarArr[i3];
            cVarArr[i3] = null;
        } else {
            cVar = new c(new byte[this.f6931b], 0);
        }
        return cVar;
    }

    @Override // com.google.android.exoplayer2.upstream.d
    public int e() {
        return this.f6931b;
    }

    public synchronized int f() {
        return this.f6935f * this.f6931b;
    }

    public synchronized void g() {
        if (this.f6930a) {
            h(0);
        }
    }

    public synchronized void h(int i2) {
        boolean z = i2 < this.f6934e;
        this.f6934e = i2;
        if (z) {
            a();
        }
    }

    public l(boolean z, int i2, int i3) {
        e.a(i2 > 0);
        e.a(i3 >= 0);
        this.f6930a = z;
        this.f6931b = i2;
        this.f6936g = i3;
        this.f6937h = new c[(i3 + 100)];
        if (i3 > 0) {
            this.f6932c = new byte[(i3 * i2)];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f6937h[i4] = new c(this.f6932c, i4 * i2);
            }
        } else {
            this.f6932c = null;
        }
        this.f6933d = new c[1];
    }
}
