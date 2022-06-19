package b.h.k;

/* compiled from: DisplayCutoutCompat */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2596a;

    private c(Object obj) {
        this.f2596a = obj;
    }

    static c a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new c(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return b.h.j.c.a(this.f2596a, ((c) obj).f2596a);
    }

    public int hashCode() {
        Object obj = this.f2596a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2596a + "}";
    }
}
