package kotlin.n;

/* compiled from: Ranges.kt */
public final class c extends a {
    static {
        new c(1, 0);
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // kotlin.n.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.n.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.n.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // kotlin.n.a
    public String toString() {
        return a() + ".." + b();
    }
}
