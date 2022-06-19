package b.e;

/* compiled from: LongSparseArray */
public class d<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2173f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2174b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f2175c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f2176d;

    /* renamed from: e  reason: collision with root package name */
    private int f2177e;

    public d() {
        this(10);
    }

    private void d() {
        int i2 = this.f2177e;
        long[] jArr = this.f2175c;
        Object[] objArr = this.f2176d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2173f) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2174b = false;
        this.f2177e = i3;
    }

    public void a(long j2, E e2) {
        int i2 = this.f2177e;
        if (i2 == 0 || j2 > this.f2175c[i2 - 1]) {
            if (this.f2174b && i2 >= this.f2175c.length) {
                d();
            }
            int i3 = this.f2177e;
            if (i3 >= this.f2175c.length) {
                int f2 = c.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.f2175c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f2176d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f2175c = jArr;
                this.f2176d = objArr;
            }
            this.f2175c[i3] = j2;
            this.f2176d[i3] = e2;
            this.f2177e = i3 + 1;
            return;
        }
        i(j2, e2);
    }

    public void b() {
        int i2 = this.f2177e;
        Object[] objArr = this.f2176d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2177e = 0;
        this.f2174b = false;
    }

    /* renamed from: c */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f2175c = (long[]) this.f2175c.clone();
            dVar.f2176d = (Object[]) this.f2176d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(long j2) {
        return f(j2, null);
    }

    public E f(long j2, E e2) {
        int b2 = c.b(this.f2175c, this.f2177e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f2176d;
            if (objArr[b2] != f2173f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public int g(long j2) {
        if (this.f2174b) {
            d();
        }
        return c.b(this.f2175c, this.f2177e, j2);
    }

    public long h(int i2) {
        if (this.f2174b) {
            d();
        }
        return this.f2175c[i2];
    }

    public void i(long j2, E e2) {
        int b2 = c.b(this.f2175c, this.f2177e, j2);
        if (b2 >= 0) {
            this.f2176d[b2] = e2;
            return;
        }
        int i2 = b2 ^ -1;
        int i3 = this.f2177e;
        if (i2 < i3) {
            Object[] objArr = this.f2176d;
            if (objArr[i2] == f2173f) {
                this.f2175c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f2174b && i3 >= this.f2175c.length) {
            d();
            i2 = c.b(this.f2175c, this.f2177e, j2) ^ -1;
        }
        int i4 = this.f2177e;
        if (i4 >= this.f2175c.length) {
            int f2 = c.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f2175c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2176d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2175c = jArr;
            this.f2176d = objArr2;
        }
        int i5 = this.f2177e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f2175c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f2176d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f2177e - i2);
        }
        this.f2175c[i2] = j2;
        this.f2176d[i2] = e2;
        this.f2177e++;
    }

    public void j(long j2) {
        Object[] objArr;
        Object obj;
        int b2 = c.b(this.f2175c, this.f2177e, j2);
        if (b2 >= 0 && (objArr = this.f2176d)[b2] != (obj = f2173f)) {
            objArr[b2] = obj;
            this.f2174b = true;
        }
    }

    public void k(int i2) {
        Object[] objArr = this.f2176d;
        Object obj = objArr[i2];
        Object obj2 = f2173f;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2174b = true;
        }
    }

    public int m() {
        if (this.f2174b) {
            d();
        }
        return this.f2177e;
    }

    public E n(int i2) {
        if (this.f2174b) {
            d();
        }
        return (E) this.f2176d[i2];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2177e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2177e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(h(i2));
            sb.append('=');
            E n = n(i2);
            if (n != this) {
                sb.append((Object) n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f2174b = false;
        if (i2 == 0) {
            this.f2175c = c.f2171b;
            this.f2176d = c.f2172c;
            return;
        }
        int f2 = c.f(i2);
        this.f2175c = new long[f2];
        this.f2176d = new Object[f2];
    }
}
