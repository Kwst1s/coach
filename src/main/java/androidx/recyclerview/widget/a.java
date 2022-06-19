package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import b.h.j.e;
import b.h.j.f;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: AdapterHelper */
public class a implements l.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f1674a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f1675b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f1676c;

    /* renamed from: d  reason: collision with root package name */
    final AbstractC0023a f1677d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f1678e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f1679f;

    /* renamed from: g  reason: collision with root package name */
    final l f1680g;

    /* renamed from: h  reason: collision with root package name */
    private int f1681h;

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AdapterHelper */
    public interface AbstractC0023a {
        void a(int i2, int i3);

        void b(b bVar);

        RecyclerView.d0 c(int i2);

        void d(int i2, int i3);

        void e(int i2, int i3);

        void f(int i2, int i3);

        void g(b bVar);

        void h(int i2, int i3, Object obj);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AdapterHelper */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f1682a;

        /* renamed from: b  reason: collision with root package name */
        int f1683b;

        /* renamed from: c  reason: collision with root package name */
        Object f1684c;

        /* renamed from: d  reason: collision with root package name */
        int f1685d;

        b(int i2, int i3, int i4, Object obj) {
            this.f1682a = i2;
            this.f1683b = i3;
            this.f1685d = i4;
            this.f1684c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i2 = this.f1682a;
            if (i2 == 1) {
                return "add";
            }
            if (i2 == 2) {
                return "rm";
            }
            if (i2 != 4) {
                return i2 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f1682a;
            if (i2 != bVar.f1682a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f1685d - this.f1683b) == 1 && this.f1685d == bVar.f1683b && this.f1683b == bVar.f1685d) {
                return true;
            }
            if (this.f1685d != bVar.f1685d || this.f1683b != bVar.f1683b) {
                return false;
            }
            Object obj2 = this.f1684c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1684c)) {
                    return false;
                }
            } else if (bVar.f1684c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1682a * 31) + this.f1683b) * 31) + this.f1685d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1683b + "c:" + this.f1685d + ",p:" + this.f1684c + "]";
        }
    }

    a(AbstractC0023a aVar) {
        this(aVar, false);
    }

    private void c(b bVar) {
        u(bVar);
    }

    private void d(b bVar) {
        u(bVar);
    }

    private void f(b bVar) {
        char c2;
        boolean z;
        int i2 = bVar.f1683b;
        int i3 = bVar.f1685d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f1677d.c(i4) != null || h(i4)) {
                if (c3 == 0) {
                    k(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    u(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f1685d) {
            a(bVar);
            bVar = b(2, i2, i5, null);
        }
        if (c3 == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    private void g(b bVar) {
        int i2 = bVar.f1683b;
        int i3 = bVar.f1685d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f1677d.c(i2) != null || h(i2)) {
                if (c2 == 0) {
                    k(b(4, i4, i5, bVar.f1684c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    u(b(4, i4, i5, bVar.f1684c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f1685d) {
            Object obj = bVar.f1684c;
            a(bVar);
            bVar = b(4, i4, i5, obj);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    private boolean h(int i2) {
        int size = this.f1676c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1676c.get(i3);
            int i4 = bVar.f1682a;
            if (i4 == 8) {
                if (n(bVar.f1685d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f1683b;
                int i6 = bVar.f1685d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i2;
        int i3 = bVar.f1682a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int y = y(bVar.f1683b, i3);
        int i4 = bVar.f1683b;
        int i5 = bVar.f1682a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f1685d; i7++) {
            int y2 = y(bVar.f1683b + (i2 * i7), bVar.f1682a);
            int i8 = bVar.f1682a;
            if (i8 == 2 ? y2 == y : i8 == 4 && y2 == y + 1) {
                i6++;
            } else {
                b b2 = b(i8, y, i6, bVar.f1684c);
                l(b2, i4);
                a(b2);
                if (bVar.f1682a == 4) {
                    i4 += i6;
                }
                y = y2;
                i6 = 1;
            }
        }
        Object obj = bVar.f1684c;
        a(bVar);
        if (i6 > 0) {
            b b3 = b(bVar.f1682a, y, i6, obj);
            l(b3, i4);
            a(b3);
        }
    }

    private void u(b bVar) {
        this.f1676c.add(bVar);
        int i2 = bVar.f1682a;
        if (i2 == 1) {
            this.f1677d.e(bVar.f1683b, bVar.f1685d);
        } else if (i2 == 2) {
            this.f1677d.d(bVar.f1683b, bVar.f1685d);
        } else if (i2 == 4) {
            this.f1677d.h(bVar.f1683b, bVar.f1685d, bVar.f1684c);
        } else if (i2 == 8) {
            this.f1677d.a(bVar.f1683b, bVar.f1685d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int y(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f1676c.size() - 1; size >= 0; size--) {
            b bVar = this.f1676c.get(size);
            int i6 = bVar.f1682a;
            if (i6 == 8) {
                int i7 = bVar.f1683b;
                int i8 = bVar.f1685d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            bVar.f1683b = i7 + 1;
                            bVar.f1685d = i8 + 1;
                        } else if (i3 == 2) {
                            bVar.f1683b = i7 - 1;
                            bVar.f1685d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        bVar.f1685d = i8 + 1;
                    } else if (i3 == 2) {
                        bVar.f1685d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.f1683b = i7 + 1;
                    } else if (i3 == 2) {
                        bVar.f1683b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = bVar.f1683b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= bVar.f1685d;
                    } else if (i6 == 2) {
                        i2 += bVar.f1685d;
                    }
                } else if (i3 == 1) {
                    bVar.f1683b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f1683b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f1676c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1676c.get(size2);
            if (bVar2.f1682a == 8) {
                int i10 = bVar2.f1685d;
                if (i10 == bVar2.f1683b || i10 < 0) {
                    this.f1676c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1685d <= 0) {
                this.f1676c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void a(b bVar) {
        if (!this.f1679f) {
            bVar.f1684c = null;
            this.f1674a.a(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.l.a
    public b b(int i2, int i3, int i4, Object obj) {
        b b2 = this.f1674a.b();
        if (b2 == null) {
            return new b(i2, i3, i4, obj);
        }
        b2.f1682a = i2;
        b2.f1683b = i3;
        b2.f1685d = i4;
        b2.f1684c = obj;
        return b2;
    }

    public int e(int i2) {
        int size = this.f1675b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1675b.get(i3);
            int i4 = bVar.f1682a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1683b;
                    if (i5 <= i2) {
                        int i6 = bVar.f1685d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1683b;
                    if (i7 == i2) {
                        i2 = bVar.f1685d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f1685d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1683b <= i2) {
                i2 += bVar.f1685d;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int size = this.f1676c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1677d.b(this.f1676c.get(i2));
        }
        w(this.f1676c);
        this.f1681h = 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f1675b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1675b.get(i2);
            int i3 = bVar.f1682a;
            if (i3 == 1) {
                this.f1677d.b(bVar);
                this.f1677d.e(bVar.f1683b, bVar.f1685d);
            } else if (i3 == 2) {
                this.f1677d.b(bVar);
                this.f1677d.f(bVar.f1683b, bVar.f1685d);
            } else if (i3 == 4) {
                this.f1677d.b(bVar);
                this.f1677d.h(bVar.f1683b, bVar.f1685d, bVar.f1684c);
            } else if (i3 == 8) {
                this.f1677d.b(bVar);
                this.f1677d.a(bVar.f1683b, bVar.f1685d);
            }
            Runnable runnable = this.f1678e;
            if (runnable != null) {
                runnable.run();
            }
        }
        w(this.f1675b);
        this.f1681h = 0;
    }

    /* access modifiers changed from: package-private */
    public void l(b bVar, int i2) {
        this.f1677d.g(bVar);
        int i3 = bVar.f1682a;
        if (i3 == 2) {
            this.f1677d.f(i2, bVar.f1685d);
        } else if (i3 == 4) {
            this.f1677d.h(i2, bVar.f1685d, bVar.f1684c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int m(int i2) {
        return n(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public int n(int i2, int i3) {
        int size = this.f1676c.size();
        while (i3 < size) {
            b bVar = this.f1676c.get(i3);
            int i4 = bVar.f1682a;
            if (i4 == 8) {
                int i5 = bVar.f1683b;
                if (i5 == i2) {
                    i2 = bVar.f1685d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f1685d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f1683b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f1685d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f1685d;
                }
            }
            i3++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i2) {
        return (i2 & this.f1681h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f1675b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return !this.f1676c.isEmpty() && !this.f1675b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f1675b.add(b(4, i2, i3, obj));
        this.f1681h |= 4;
        if (this.f1675b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f1675b.add(b(8, i2, i3, null));
            this.f1681h |= 8;
            if (this.f1675b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1675b.add(b(2, i2, i3, null));
        this.f1681h |= 2;
        if (this.f1675b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.f1680g.b(this.f1675b);
        int size = this.f1675b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1675b.get(i2);
            int i3 = bVar.f1682a;
            if (i3 == 1) {
                c(bVar);
            } else if (i3 == 2) {
                f(bVar);
            } else if (i3 == 4) {
                g(bVar);
            } else if (i3 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1678e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1675b.clear();
    }

    /* access modifiers changed from: package-private */
    public void w(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void x() {
        w(this.f1675b);
        w(this.f1676c);
        this.f1681h = 0;
    }

    a(AbstractC0023a aVar, boolean z) {
        this.f1674a = new f(30);
        this.f1675b = new ArrayList<>();
        this.f1676c = new ArrayList<>();
        this.f1681h = 0;
        this.f1677d = aVar;
        this.f1679f = z;
        this.f1680g = new l(this);
    }
}
