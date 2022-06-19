package b.e;

/* compiled from: SparseArrayCompat */
public class h<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2208f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2209b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f2210c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f2211d;

    /* renamed from: e  reason: collision with root package name */
    private int f2212e;

    public h() {
        this(10);
    }

    private void d() {
        int i2 = this.f2212e;
        int[] iArr = this.f2210c;
        Object[] objArr = this.f2211d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2208f) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2209b = false;
        this.f2212e = i3;
    }

    public void a(int i2, E e2) {
        int i3 = this.f2212e;
        if (i3 == 0 || i2 > this.f2210c[i3 - 1]) {
            if (this.f2209b && i3 >= this.f2210c.length) {
                d();
            }
            int i4 = this.f2212e;
            if (i4 >= this.f2210c.length) {
                int e3 = c.e(i4 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.f2210c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f2211d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f2210c = iArr;
                this.f2211d = objArr;
            }
            this.f2210c[i4] = i2;
            this.f2211d[i4] = e2;
            this.f2212e = i4 + 1;
            return;
        }
        j(i2, e2);
    }

    public void b() {
        int i2 = this.f2212e;
        Object[] objArr = this.f2211d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2212e = 0;
        this.f2209b = false;
    }

    /* renamed from: c */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f2210c = (int[]) this.f2210c.clone();
            hVar.f2211d = (Object[]) this.f2211d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(int i2) {
        return f(i2, null);
    }

    public E f(int i2, E e2) {
        int a2 = c.a(this.f2210c, this.f2212e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f2211d;
            if (objArr[a2] != f2208f) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int g(int i2) {
        if (this.f2209b) {
            d();
        }
        return c.a(this.f2210c, this.f2212e, i2);
    }

    public int h(E e2) {
        if (this.f2209b) {
            d();
        }
        for (int i2 = 0; i2 < this.f2212e; i2++) {
            if (this.f2211d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public int i(int i2) {
        if (this.f2209b) {
            d();
        }
        return this.f2210c[i2];
    }

    public void j(int i2, E e2) {
        int a2 = c.a(this.f2210c, this.f2212e, i2);
        if (a2 >= 0) {
            this.f2211d[a2] = e2;
            return;
        }
        int i3 = a2 ^ -1;
        int i4 = this.f2212e;
        if (i3 < i4) {
            Object[] objArr = this.f2211d;
            if (objArr[i3] == f2208f) {
                this.f2210c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f2209b && i4 >= this.f2210c.length) {
            d();
            i3 = c.a(this.f2210c, this.f2212e, i2) ^ -1;
        }
        int i5 = this.f2212e;
        if (i5 >= this.f2210c.length) {
            int e3 = c.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f2210c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2211d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2210c = iArr;
            this.f2211d = objArr2;
        }
        int i6 = this.f2212e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f2210c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f2211d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f2212e - i3);
        }
        this.f2210c[i3] = i2;
        this.f2211d[i3] = e2;
        this.f2212e++;
    }

    public void k(int i2) {
        Object[] objArr;
        Object obj;
        int a2 = c.a(this.f2210c, this.f2212e, i2);
        if (a2 >= 0 && (objArr = this.f2211d)[a2] != (obj = f2208f)) {
            objArr[a2] = obj;
            this.f2209b = true;
        }
    }

    public int m() {
        if (this.f2209b) {
            d();
        }
        return this.f2212e;
    }

    public E n(int i2) {
        if (this.f2209b) {
            d();
        }
        return (E) this.f2211d[i2];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2212e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2212e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(i(i2));
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

    public h(int i2) {
        this.f2209b = false;
        if (i2 == 0) {
            this.f2210c = c.f2170a;
            this.f2211d = c.f2172c;
            return;
        }
        int e2 = c.e(i2);
        this.f2210c = new int[e2];
        this.f2211d = new Object[e2];
    }
}
