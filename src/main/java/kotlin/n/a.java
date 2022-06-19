package kotlin.n;

import kotlin.j.u;
import kotlin.l.c;
import kotlin.m.b.d;

/* compiled from: Progressions.kt */
public class a implements Iterable<Integer> {

    /* renamed from: e  reason: collision with root package name */
    public static final C0241a f10787e = new C0241a(null);

    /* renamed from: b  reason: collision with root package name */
    private final int f10788b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10789c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10790d;

    /* renamed from: kotlin.n.a$a  reason: collision with other inner class name */
    /* compiled from: Progressions.kt */
    public static final class C0241a {
        private C0241a() {
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }

        public /* synthetic */ C0241a(d dVar) {
            this();
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.f10788b = i2;
            this.f10789c = c.b(i2, i3, i4);
            this.f10790d = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f10788b;
    }

    public final int b() {
        return this.f10789c;
    }

    public final int c() {
        return this.f10790d;
    }

    /* renamed from: d */
    public u iterator() {
        return new b(this.f10788b, this.f10789c, this.f10790d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.f10788b == aVar.f10788b && this.f10789c == aVar.f10789c && this.f10790d == aVar.f10790d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f10788b * 31) + this.f10789c) * 31) + this.f10790d;
    }

    public boolean isEmpty() {
        if (this.f10790d > 0) {
            if (this.f10788b > this.f10789c) {
                return true;
            }
        } else if (this.f10788b < this.f10789c) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i2;
        StringBuilder sb;
        if (this.f10790d > 0) {
            sb = new StringBuilder();
            sb.append(this.f10788b);
            sb.append("..");
            sb.append(this.f10789c);
            sb.append(" step ");
            i2 = this.f10790d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f10788b);
            sb.append(" downTo ");
            sb.append(this.f10789c);
            sb.append(" step ");
            i2 = -this.f10790d;
        }
        sb.append(i2);
        return sb.toString();
    }
}
