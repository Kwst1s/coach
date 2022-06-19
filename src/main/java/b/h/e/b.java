package b.h.e;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f2471e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f2472a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2473b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2474c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2475d;

    private b(int i2, int i3, int i4, int i5) {
        this.f2472a = i2;
        this.f2473b = i3;
        this.f2474c = i4;
        this.f2475d = i5;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f2472a, bVar2.f2472a), Math.max(bVar.f2473b, bVar2.f2473b), Math.max(bVar.f2474c, bVar2.f2474c), Math.max(bVar.f2475d, bVar2.f2475d));
    }

    public static b b(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return f2471e;
        }
        return new b(i2, i3, i4, i5);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f2472a, this.f2473b, this.f2474c, this.f2475d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2475d == bVar.f2475d && this.f2472a == bVar.f2472a && this.f2474c == bVar.f2474c && this.f2473b == bVar.f2473b;
    }

    public int hashCode() {
        return (((((this.f2472a * 31) + this.f2473b) * 31) + this.f2474c) * 31) + this.f2475d;
    }

    public String toString() {
        return "Insets{left=" + this.f2472a + ", top=" + this.f2473b + ", right=" + this.f2474c + ", bottom=" + this.f2475d + '}';
    }
}
