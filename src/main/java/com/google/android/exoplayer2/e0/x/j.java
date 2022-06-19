package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;

/* compiled from: DtsReader */
public final class j implements l {

    /* renamed from: a  reason: collision with root package name */
    private final s f5493a = new s(new byte[18]);

    /* renamed from: b  reason: collision with root package name */
    private final String f5494b;

    /* renamed from: c  reason: collision with root package name */
    private String f5495c;

    /* renamed from: d  reason: collision with root package name */
    private q f5496d;

    /* renamed from: e  reason: collision with root package name */
    private int f5497e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f5498f;

    /* renamed from: g  reason: collision with root package name */
    private int f5499g;

    /* renamed from: h  reason: collision with root package name */
    private long f5500h;

    /* renamed from: i  reason: collision with root package name */
    private l f5501i;

    /* renamed from: j  reason: collision with root package name */
    private int f5502j;

    /* renamed from: k  reason: collision with root package name */
    private long f5503k;

    public j(String str) {
        this.f5494b = str;
    }

    private boolean b(s sVar, byte[] bArr, int i2) {
        int min = Math.min(sVar.a(), i2 - this.f5498f);
        sVar.h(bArr, this.f5498f, min);
        int i3 = this.f5498f + min;
        this.f5498f = i3;
        return i3 == i2;
    }

    private void g() {
        byte[] bArr = this.f5493a.f7062a;
        if (this.f5501i == null) {
            l g2 = o.g(bArr, this.f5495c, this.f5494b, null);
            this.f5501i = g2;
            this.f5496d.d(g2);
        }
        this.f5502j = o.a(bArr);
        this.f5500h = (long) ((int) ((((long) o.f(bArr)) * 1000000) / ((long) this.f5501i.v)));
    }

    private boolean h(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5499g << 8;
            this.f5499g = i2;
            int y = i2 | sVar.y();
            this.f5499g = y;
            if (o.d(y)) {
                byte[] bArr = this.f5493a.f7062a;
                int i3 = this.f5499g;
                bArr[0] = (byte) ((i3 >> 24) & 255);
                bArr[1] = (byte) ((i3 >> 16) & 255);
                bArr[2] = (byte) ((i3 >> 8) & 255);
                bArr[3] = (byte) (i3 & 255);
                this.f5498f = 4;
                this.f5499g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void a() {
        this.f5497e = 0;
        this.f5498f = 0;
        this.f5499g = 0;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void c(s sVar) {
        while (sVar.a() > 0) {
            int i2 = this.f5497e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(sVar.a(), this.f5502j - this.f5498f);
                        this.f5496d.a(sVar, min);
                        int i3 = this.f5498f + min;
                        this.f5498f = i3;
                        int i4 = this.f5502j;
                        if (i3 == i4) {
                            this.f5496d.c(this.f5503k, 1, i4, 0, null);
                            this.f5503k += this.f5500h;
                            this.f5497e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (b(sVar, this.f5493a.f7062a, 18)) {
                    g();
                    this.f5493a.K(0);
                    this.f5496d.a(this.f5493a, 18);
                    this.f5497e = 2;
                }
            } else if (h(sVar)) {
                this.f5497e = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void d(long j2, boolean z) {
        this.f5503k = j2;
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void e() {
    }

    @Override // com.google.android.exoplayer2.e0.x.l
    public void f(i iVar, e0.d dVar) {
        dVar.a();
        this.f5495c = dVar.b();
        this.f5496d = iVar.a(dVar.c(), 1);
    }
}
