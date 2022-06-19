package com.google.android.exoplayer2.e0.s;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.s;

/* compiled from: Sniffer */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private final s f5158a = new s(8);

    /* renamed from: b  reason: collision with root package name */
    private int f5159b;

    private long a(h hVar) {
        int i2 = 0;
        hVar.j(this.f5158a.f7062a, 0, 1);
        int i3 = this.f5158a.f7062a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (i4 ^ -1);
        hVar.j(this.f5158a.f7062a, 1, i5);
        while (i2 < i5) {
            i2++;
            i6 = (this.f5158a.f7062a[i2] & 255) + (i6 << 8);
        }
        this.f5159b += i5 + 1;
        return (long) i6;
    }

    public boolean b(h hVar) {
        long d2 = hVar.d();
        long j2 = 1024;
        if (d2 != -1 && d2 <= 1024) {
            j2 = d2;
        }
        int i2 = (int) j2;
        hVar.j(this.f5158a.f7062a, 0, 4);
        long A = this.f5158a.A();
        this.f5159b = 4;
        while (A != 440786851) {
            int i3 = this.f5159b + 1;
            this.f5159b = i3;
            if (i3 == i2) {
                return false;
            }
            hVar.j(this.f5158a.f7062a, 0, 1);
            A = ((A << 8) & -256) | ((long) (this.f5158a.f7062a[0] & 255));
        }
        long a2 = a(hVar);
        long j3 = (long) this.f5159b;
        if (a2 == Long.MIN_VALUE) {
            return false;
        }
        if (d2 != -1 && j3 + a2 >= d2) {
            return false;
        }
        while (true) {
            int i4 = this.f5159b;
            long j4 = j3 + a2;
            if (((long) i4) < j4) {
                if (a(hVar) == Long.MIN_VALUE) {
                    return false;
                }
                long a3 = a(hVar);
                if (a3 < 0 || a3 > 2147483647L) {
                    return false;
                }
                if (a3 != 0) {
                    int i5 = (int) a3;
                    hVar.k(i5);
                    this.f5159b += i5;
                }
            } else if (((long) i4) == j4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
