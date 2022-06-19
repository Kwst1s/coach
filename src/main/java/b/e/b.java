package b.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f2159f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private static final Object[] f2160g = new Object[0];

    /* renamed from: h  reason: collision with root package name */
    private static Object[] f2161h;

    /* renamed from: i  reason: collision with root package name */
    private static int f2162i;

    /* renamed from: j  reason: collision with root package name */
    private static Object[] f2163j;

    /* renamed from: k  reason: collision with root package name */
    private static int f2164k;

    /* renamed from: b  reason: collision with root package name */
    private int[] f2165b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f2166c;

    /* renamed from: d  reason: collision with root package name */
    int f2167d;

    /* renamed from: e  reason: collision with root package name */
    private f<E, E> f2168e;

    /* access modifiers changed from: package-private */
    /* compiled from: ArraySet */
    public class a extends f<E, E> {
        a() {
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void a() {
            b.this.clear();
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public Object b(int i2, int i3) {
            return b.this.f2166c[i2];
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int d() {
            return b.this.f2167d;
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void g(E e2, E e3) {
            b.this.add(e2);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public void h(int i2) {
            b.this.g(i2);
        }

        /* access modifiers changed from: protected */
        @Override // b.e.f
        public E i(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                Object[] objArr = f2163j;
                if (objArr != null) {
                    this.f2166c = objArr;
                    f2163j = (Object[]) objArr[0];
                    this.f2165b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2164k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f2161h;
                if (objArr2 != null) {
                    this.f2166c = objArr2;
                    f2161h = (Object[]) objArr2[0];
                    this.f2165b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2162i--;
                    return;
                }
            }
        }
        this.f2165b = new int[i2];
        this.f2166c = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f2164k < 10) {
                    objArr[0] = f2163j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2163j = objArr;
                    f2164k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f2162i < 10) {
                    objArr[0] = f2161h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2161h = objArr;
                    f2162i++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f2168e == null) {
            this.f2168e = new a();
        }
        return this.f2168e;
    }

    private int e(Object obj, int i2) {
        int i3 = this.f2167d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f2165b, i3, i2);
        if (a2 < 0 || obj.equals(this.f2166c[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f2165b[i4] == i2) {
            if (obj.equals(this.f2166c[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f2165b[i5] == i2) {
            if (obj.equals(this.f2166c[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private int f() {
        int i2 = this.f2167d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f2165b, i2, 0);
        if (a2 < 0 || this.f2166c[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f2165b[i3] == 0) {
            if (this.f2166c[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f2165b[i4] == 0) {
            if (this.f2166c[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = f();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = e(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ -1;
        int i5 = this.f2167d;
        int[] iArr = this.f2165b;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f2166c;
            a(i6);
            int[] iArr2 = this.f2165b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2166c, 0, objArr.length);
            }
            c(iArr, objArr, this.f2167d);
        }
        int i7 = this.f2167d;
        if (i4 < i7) {
            int[] iArr3 = this.f2165b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f2166c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f2167d - i4);
        }
        this.f2165b[i4] = i2;
        this.f2166c[i4] = e2;
        this.f2167d++;
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: b.e.b<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f2167d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.f2165b;
        if (iArr.length < i2) {
            Object[] objArr = this.f2166c;
            a(i2);
            int i3 = this.f2167d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f2165b, 0, i3);
                System.arraycopy(objArr, 0, this.f2166c, 0, this.f2167d);
            }
            c(iArr, objArr, this.f2167d);
        }
    }

    public void clear() {
        int i2 = this.f2167d;
        if (i2 != 0) {
            c(this.f2165b, this.f2166c, i2);
            this.f2165b = f2159f;
            this.f2166c = f2160g;
            this.f2167d = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2167d; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i2) {
        Object[] objArr = this.f2166c;
        E e2 = (E) objArr[i2];
        int i3 = this.f2167d;
        if (i3 <= 1) {
            c(this.f2165b, objArr, i3);
            this.f2165b = f2159f;
            this.f2166c = f2160g;
            this.f2167d = 0;
        } else {
            int[] iArr = this.f2165b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.f2167d = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr2 = this.f2166c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.f2167d - i2);
                }
                this.f2166c[this.f2167d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                a(i4);
                this.f2167d--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f2165b, 0, i2);
                    System.arraycopy(objArr, 0, this.f2166c, 0, i2);
                }
                int i7 = this.f2167d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.f2165b, i2, i7 - i2);
                    System.arraycopy(objArr, i8, this.f2166c, i2, this.f2167d - i2);
                }
            }
        }
        return e2;
    }

    public E h(int i2) {
        return (E) this.f2166c[i2];
    }

    public int hashCode() {
        int[] iArr = this.f2165b;
        int i2 = this.f2167d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f2167d <= 0;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f2167d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f2166c[i2])) {
                g(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f2167d;
    }

    public Object[] toArray() {
        int i2 = this.f2167d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f2166c, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2167d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2167d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E h2 = h(i2);
            if (h2 != this) {
                sb.append((Object) h2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f2165b = f2159f;
            this.f2166c = f2160g;
        } else {
            a(i2);
        }
        this.f2167d = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f2167d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2167d));
        }
        System.arraycopy(this.f2166c, 0, tArr, 0, this.f2167d);
        int length = tArr.length;
        int i2 = this.f2167d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
