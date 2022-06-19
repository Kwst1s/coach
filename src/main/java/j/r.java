package j;

import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: SegmentedByteString */
public final class r extends f {

    /* renamed from: g  reason: collision with root package name */
    final transient byte[][] f10705g;

    /* renamed from: h  reason: collision with root package name */
    final transient int[] f10706h;

    r(c cVar, int i2) {
        super(null);
        v.b(cVar.f10663c, 0, (long) i2);
        p pVar = cVar.f10662b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = pVar.f10698c;
            int i7 = pVar.f10697b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                pVar = pVar.f10701f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f10705g = new byte[i5][];
        this.f10706h = new int[(i5 * 2)];
        p pVar2 = cVar.f10662b;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f10705g;
            bArr[i8] = pVar2.f10696a;
            int i9 = pVar2.f10698c;
            int i10 = pVar2.f10697b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f10706h;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            pVar2.f10699d = true;
            i8++;
            pVar2 = pVar2.f10701f;
        }
    }

    private int y(int i2) {
        int binarySearch = Arrays.binarySearch(this.f10706h, 0, this.f10705g.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private f z() {
        return new f(v());
    }

    @Override // j.f
    public String a() {
        return z().a();
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.r() != r() || !n(0, fVar, 0, r())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        int i2 = this.f10668c;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f10705g.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f10705g[i3];
            int[] iArr = this.f10706h;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f10668c = i5;
        return i5;
    }

    @Override // j.f
    public byte j(int i2) {
        int i3;
        v.b((long) this.f10706h[this.f10705g.length - 1], (long) i2, 1);
        int y = y(i2);
        if (y == 0) {
            i3 = 0;
        } else {
            i3 = this.f10706h[y - 1];
        }
        int[] iArr = this.f10706h;
        byte[][] bArr = this.f10705g;
        return bArr[y][(i2 - i3) + iArr[bArr.length + y]];
    }

    @Override // j.f
    public String k() {
        return z().k();
    }

    @Override // j.f
    public f l() {
        return z().l();
    }

    @Override // j.f
    public boolean n(int i2, f fVar, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > r() - i4) {
            return false;
        }
        int y = y(i2);
        while (i4 > 0) {
            if (y == 0) {
                i5 = 0;
            } else {
                i5 = this.f10706h[y - 1];
            }
            int min = Math.min(i4, ((this.f10706h[y] - i5) + i5) - i2);
            int[] iArr = this.f10706h;
            byte[][] bArr = this.f10705g;
            if (!fVar.o(i3, bArr[y], (i2 - i5) + iArr[bArr.length + y], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            y++;
        }
        return true;
    }

    @Override // j.f
    public boolean o(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > r() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int y = y(i2);
        while (i4 > 0) {
            if (y == 0) {
                i5 = 0;
            } else {
                i5 = this.f10706h[y - 1];
            }
            int min = Math.min(i4, ((this.f10706h[y] - i5) + i5) - i2);
            int[] iArr = this.f10706h;
            byte[][] bArr2 = this.f10705g;
            if (!v.a(bArr2[y], (i2 - i5) + iArr[bArr2.length + y], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            y++;
        }
        return true;
    }

    @Override // j.f
    public f p() {
        return z().p();
    }

    @Override // j.f
    public f q() {
        return z().q();
    }

    @Override // j.f
    public int r() {
        return this.f10706h[this.f10705g.length - 1];
    }

    @Override // j.f
    public f t(int i2, int i3) {
        return z().t(i2, i3);
    }

    @Override // j.f
    public String toString() {
        return z().toString();
    }

    @Override // j.f
    public f u() {
        return z().u();
    }

    @Override // j.f
    public byte[] v() {
        int[] iArr = this.f10706h;
        byte[][] bArr = this.f10705g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f10706h;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f10705g[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // j.f
    public String w() {
        return z().w();
    }

    /* access modifiers changed from: package-private */
    @Override // j.f
    public void x(c cVar) {
        int length = this.f10705g.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f10706h;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            p pVar = new p(this.f10705g[i2], i4, (i4 + i5) - i3, true, false);
            p pVar2 = cVar.f10662b;
            if (pVar2 == null) {
                pVar.f10702g = pVar;
                pVar.f10701f = pVar;
                cVar.f10662b = pVar;
            } else {
                pVar2.f10702g.c(pVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f10663c += (long) i3;
    }
}
