package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase */
class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f1501a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f1502b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f1503c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f1504d = -1;

    c() {
    }

    public int a() {
        return this.f1502b;
    }

    public int b() {
        int i2 = this.f1503c;
        int c2 = c();
        if (c2 == 6) {
            i2 |= 4;
        } else if (c2 == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f1504d;
        if (i2 != -1) {
            return i2;
        }
        return AudioAttributesCompat.a(false, this.f1503c, this.f1501a);
    }

    public int d() {
        return this.f1501a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1502b == cVar.a() && this.f1503c == cVar.b() && this.f1501a == cVar.d() && this.f1504d == cVar.f1504d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1502b), Integer.valueOf(this.f1503c), Integer.valueOf(this.f1501a), Integer.valueOf(this.f1504d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1504d != -1) {
            sb.append(" stream=");
            sb.append(this.f1504d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f1501a));
        sb.append(" content=");
        sb.append(this.f1502b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1503c).toUpperCase());
        return sb.toString();
    }
}
