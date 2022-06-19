package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private int f11022a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f11023b = new int[10];

    /* access modifiers changed from: package-private */
    public void a() {
        this.f11022a = 0;
        Arrays.fill(this.f11023b, 0);
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return this.f11023b[i2];
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if ((this.f11022a & 2) != 0) {
            return this.f11023b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if ((this.f11022a & 128) != 0) {
            return this.f11023b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int e(int i2) {
        return (this.f11022a & 16) != 0 ? this.f11023b[4] : i2;
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        return (this.f11022a & 32) != 0 ? this.f11023b[5] : i2;
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i2) {
        return ((1 << i2) & this.f11022a) != 0;
    }

    /* access modifiers changed from: package-private */
    public void h(l lVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (lVar.g(i2)) {
                i(i2, lVar.b(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public l i(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f11023b;
            if (i2 < iArr.length) {
                this.f11022a = (1 << i2) | this.f11022a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Integer.bitCount(this.f11022a);
    }
}
