package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: OggPacket */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final f f5353a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final s f5354b = new s(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f5355c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f5356d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5357e;

    e() {
    }

    private int a(int i2) {
        int i3;
        int i4 = 0;
        this.f5356d = 0;
        do {
            int i5 = this.f5356d;
            int i6 = i2 + i5;
            f fVar = this.f5353a;
            if (i6 >= fVar.f5362d) {
                break;
            }
            int[] iArr = fVar.f5365g;
            this.f5356d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public f b() {
        return this.f5353a;
    }

    public s c() {
        return this.f5354b;
    }

    public boolean d(h hVar) {
        int i2;
        com.google.android.exoplayer2.util.e.f(hVar != null);
        if (this.f5357e) {
            this.f5357e = false;
            this.f5354b.G();
        }
        while (!this.f5357e) {
            if (this.f5355c < 0) {
                if (!this.f5353a.a(hVar, true)) {
                    return false;
                }
                f fVar = this.f5353a;
                int i3 = fVar.f5363e;
                if ((fVar.f5360b & 1) == 1 && this.f5354b.d() == 0) {
                    i3 += a(0);
                    i2 = this.f5356d + 0;
                } else {
                    i2 = 0;
                }
                hVar.f(i3);
                this.f5355c = i2;
            }
            int a2 = a(this.f5355c);
            int i4 = this.f5355c + this.f5356d;
            if (a2 > 0) {
                if (this.f5354b.b() < this.f5354b.d() + a2) {
                    s sVar = this.f5354b;
                    sVar.f7062a = Arrays.copyOf(sVar.f7062a, sVar.d() + a2);
                }
                s sVar2 = this.f5354b;
                hVar.readFully(sVar2.f7062a, sVar2.d(), a2);
                s sVar3 = this.f5354b;
                sVar3.J(sVar3.d() + a2);
                this.f5357e = this.f5353a.f5365g[i4 + -1] != 255;
            }
            if (i4 == this.f5353a.f5362d) {
                i4 = -1;
            }
            this.f5355c = i4;
        }
        return true;
    }

    public void e() {
        this.f5353a.b();
        this.f5354b.G();
        this.f5355c = -1;
        this.f5357e = false;
    }

    public void f() {
        s sVar = this.f5354b;
        byte[] bArr = sVar.f7062a;
        if (bArr.length != 65025) {
            sVar.f7062a = Arrays.copyOf(bArr, Math.max(65025, sVar.d()));
        }
    }
}
