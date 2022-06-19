package b.h.j;

/* compiled from: Pools */
public class g<T> extends f<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f2590c = new Object();

    public g(int i2) {
        super(i2);
    }

    @Override // b.h.j.f, b.h.j.e
    public boolean a(T t) {
        boolean a2;
        synchronized (this.f2590c) {
            a2 = super.a(t);
        }
        return a2;
    }

    @Override // b.h.j.f, b.h.j.e
    public T b() {
        T t;
        synchronized (this.f2590c) {
            t = (T) super.b();
        }
        return t;
    }
}
