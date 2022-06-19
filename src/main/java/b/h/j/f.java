package b.h.j;

/* compiled from: Pools */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f2588a;

    /* renamed from: b  reason: collision with root package name */
    private int f2589b;

    public f(int i2) {
        if (i2 > 0) {
            this.f2588a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t) {
        for (int i2 = 0; i2 < this.f2589b; i2++) {
            if (this.f2588a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // b.h.j.e
    public boolean a(T t) {
        if (!c(t)) {
            int i2 = this.f2589b;
            Object[] objArr = this.f2588a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f2589b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // b.h.j.e
    public T b() {
        int i2 = this.f2589b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f2588a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f2589b = i2 - 1;
        return t;
    }
}
