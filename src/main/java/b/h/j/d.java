package b.h.j;

/* compiled from: Pair */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f2586a;

    /* renamed from: b  reason: collision with root package name */
    public final S f2587b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f2586a, this.f2586a) || !c.a(dVar.f2587b, this.f2587b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f2 = this.f2586a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f2587b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "Pair{" + ((Object) this.f2586a) + " " + ((Object) this.f2587b) + "}";
    }
}
