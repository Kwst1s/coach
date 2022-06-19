package b.f.b;

/* access modifiers changed from: package-private */
/* compiled from: Pools */
public class g<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f2257a;

    /* renamed from: b  reason: collision with root package name */
    private int f2258b;

    g(int i2) {
        if (i2 > 0) {
            this.f2257a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // b.f.b.f
    public boolean a(T t) {
        int i2 = this.f2258b;
        Object[] objArr = this.f2257a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f2258b = i2 + 1;
        return true;
    }

    @Override // b.f.b.f
    public T b() {
        int i2 = this.f2258b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f2257a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f2258b = i2 - 1;
        return t;
    }

    @Override // b.f.b.f
    public void c(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t = tArr[i3];
            int i4 = this.f2258b;
            Object[] objArr = this.f2257a;
            if (i4 < objArr.length) {
                objArr[i4] = t;
                this.f2258b = i4 + 1;
            }
        }
    }
}
