package b.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap */
public class g<K, V> {

    /* renamed from: e  reason: collision with root package name */
    static Object[] f2201e;

    /* renamed from: f  reason: collision with root package name */
    static int f2202f;

    /* renamed from: g  reason: collision with root package name */
    static Object[] f2203g;

    /* renamed from: h  reason: collision with root package name */
    static int f2204h;

    /* renamed from: b  reason: collision with root package name */
    int[] f2205b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f2206c;

    /* renamed from: d  reason: collision with root package name */
    int f2207d;

    public g() {
        this.f2205b = c.f2170a;
        this.f2206c = c.f2172c;
        this.f2207d = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                Object[] objArr = f2203g;
                if (objArr != null) {
                    this.f2206c = objArr;
                    f2203g = (Object[]) objArr[0];
                    this.f2205b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2204h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f2201e;
                if (objArr2 != null) {
                    this.f2206c = objArr2;
                    f2201e = (Object[]) objArr2[0];
                    this.f2205b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2202f--;
                    return;
                }
            }
        }
        this.f2205b = new int[i2];
        this.f2206c = new Object[(i2 << 1)];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f2204h < 10) {
                    objArr[0] = f2203g;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2203g = objArr;
                    f2204h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (g.class) {
                if (f2202f < 10) {
                    objArr[0] = f2201e;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2201e = objArr;
                    f2202f++;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.f2207d;
        int[] iArr = this.f2205b;
        if (iArr.length < i2) {
            Object[] objArr = this.f2206c;
            a(i2);
            if (this.f2207d > 0) {
                System.arraycopy(iArr, 0, this.f2205b, 0, i3);
                System.arraycopy(objArr, 0, this.f2206c, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.f2207d != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f2207d;
        if (i2 > 0) {
            int[] iArr = this.f2205b;
            Object[] objArr = this.f2206c;
            this.f2205b = c.f2170a;
            this.f2206c = c.f2172c;
            this.f2207d = 0;
            d(iArr, objArr, i2);
        }
        if (this.f2207d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public int e(Object obj, int i2) {
        int i3 = this.f2207d;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(this.f2205b, i3, i2);
        if (b2 < 0 || obj.equals(this.f2206c[b2 << 1])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.f2205b[i4] == i2) {
            if (obj.equals(this.f2206c[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = b2 - 1;
        while (i5 >= 0 && this.f2205b[i5] == i2) {
            if (obj.equals(this.f2206c[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2207d; i2++) {
                try {
                    K i3 = i(i2);
                    V m = m(i2);
                    Object obj2 = gVar.get(i3);
                    if (m == null) {
                        if (obj2 != null || !gVar.containsKey(i3)) {
                            return false;
                        }
                    } else if (!m.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f2207d; i4++) {
                try {
                    K i5 = i(i4);
                    V m2 = m(i4);
                    Object obj3 = map.get(i5);
                    if (m2 == null) {
                        if (obj3 != null || !map.containsKey(i5)) {
                            return false;
                        }
                    } else if (!m2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int i2 = this.f2207d;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f2205b, i2, 0);
        if (b2 < 0 || this.f2206c[b2 << 1] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.f2205b[i3] == 0) {
            if (this.f2206c[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.f2205b[i4] == 0) {
            if (this.f2206c[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int f2 = f(obj);
        return f2 >= 0 ? (V) this.f2206c[(f2 << 1) + 1] : v;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        int i2 = this.f2207d * 2;
        Object[] objArr = this.f2206c;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f2205b;
        Object[] objArr = this.f2206c;
        int i2 = this.f2207d;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public K i(int i2) {
        return (K) this.f2206c[i2 << 1];
    }

    public boolean isEmpty() {
        return this.f2207d <= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: b.e.g<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public void j(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.f2207d;
        c(this.f2207d + i2);
        if (this.f2207d != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.i(i3), gVar.m(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f2205b, 0, this.f2205b, 0, i2);
            System.arraycopy(gVar.f2206c, 0, this.f2206c, 0, i2 << 1);
            this.f2207d = i2;
        }
    }

    public V k(int i2) {
        Object[] objArr = this.f2206c;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f2207d;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f2205b, objArr, i4);
            this.f2205b = c.f2170a;
            this.f2206c = c.f2172c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f2205b;
            int i7 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i8 = i2 + 1;
                    int i9 = i6 - i2;
                    System.arraycopy(iArr, i8, iArr, i2, i9);
                    Object[] objArr2 = this.f2206c;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i3, i9 << 1);
                }
                Object[] objArr3 = this.f2206c;
                int i10 = i6 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                if (i4 > 8) {
                    i7 = i4 + (i4 >> 1);
                }
                a(i7);
                if (i4 == this.f2207d) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.f2205b, 0, i2);
                        System.arraycopy(objArr, 0, this.f2206c, 0, i3);
                    }
                    if (i2 < i6) {
                        int i11 = i2 + 1;
                        int i12 = i6 - i2;
                        System.arraycopy(iArr, i11, this.f2205b, i2, i12);
                        System.arraycopy(objArr, i11 << 1, this.f2206c, i3, i12 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i5 = i6;
        }
        if (i4 == this.f2207d) {
            this.f2207d = i5;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V l(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f2206c;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V m(int i2) {
        return (V) this.f2206c[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int i3;
        int i4 = this.f2207d;
        if (k2 == null) {
            i3 = g();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = e(k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            Object[] objArr = this.f2206c;
            V v2 = (V) objArr[i5];
            objArr[i5] = v;
            return v2;
        }
        int i6 = i3 ^ -1;
        int[] iArr = this.f2205b;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.f2206c;
            a(i7);
            if (i4 == this.f2207d) {
                int[] iArr2 = this.f2205b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f2206c, 0, objArr2.length);
                }
                d(iArr, objArr2, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f2205b;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f2206c;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f2207d - i6) << 1);
        }
        int i9 = this.f2207d;
        if (i4 == i9) {
            int[] iArr4 = this.f2205b;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr4 = this.f2206c;
                int i10 = i6 << 1;
                objArr4[i10] = k2;
                objArr4[i10 + 1] = v;
                this.f2207d = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V v2 = get(k2);
        return v2 == null ? put(k2, v) : v2;
    }

    public V remove(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return k(f2);
        }
        return null;
    }

    public V replace(K k2, V v) {
        int f2 = f(k2);
        if (f2 >= 0) {
            return l(f2, v);
        }
        return null;
    }

    public int size() {
        return this.f2207d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2207d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2207d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K i3 = i(i2);
            if (i3 != this) {
                sb.append((Object) i3);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m = m(i2);
            if (m != this) {
                sb.append((Object) m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int f2 = f(obj);
        if (f2 < 0) {
            return false;
        }
        V m = m(f2);
        if (obj2 != m && (obj2 == null || !obj2.equals(m))) {
            return false;
        }
        k(f2);
        return true;
    }

    public boolean replace(K k2, V v, V v2) {
        int f2 = f(k2);
        if (f2 < 0) {
            return false;
        }
        V m = m(f2);
        if (m != v && (v == null || !v.equals(m))) {
            return false;
        }
        l(f2, v2);
        return true;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f2205b = c.f2170a;
            this.f2206c = c.f2172c;
        } else {
            a(i2);
        }
        this.f2207d = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            j(gVar);
        }
    }
}
