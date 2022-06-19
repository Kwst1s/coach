package f.a.a.a.b.d;

import java.io.Serializable;

/* compiled from: GoalSuccess.kt */
public final class j implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private long f9238b;

    /* renamed from: c  reason: collision with root package name */
    private int f9239c;

    public j(long j2, int i2) {
        this.f9238b = j2;
        this.f9239c = i2;
    }

    public final long a() {
        return this.f9238b;
    }

    public final int c() {
        return this.f9239c;
    }

    public final void d(long j2) {
        this.f9238b = j2;
    }

    public final void e(int i2) {
        this.f9239c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9238b == jVar.f9238b && this.f9239c == jVar.f9239c;
    }

    public int hashCode() {
        long j2 = this.f9238b;
        return (((int) (j2 ^ (j2 >>> 32))) * 31) + this.f9239c;
    }

    public String toString() {
        return "GoalSuccess(date=" + this.f9238b + ", perc=" + this.f9239c + ")";
    }
}
