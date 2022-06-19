package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import b.e.d;
import b.e.g;
import b.h.j.e;
import b.h.j.f;

/* access modifiers changed from: package-private */
/* compiled from: ViewInfoStore */
public class s {

    /* renamed from: a  reason: collision with root package name */
    final g<RecyclerView.d0, a> f1834a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.d0> f1835b = new d<>();

    /* access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static e<a> f1836d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        int f1837a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.c f1838b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f1839c;

        private a() {
        }

        static void a() {
            do {
            } while (f1836d.b() != null);
        }

        static a b() {
            a b2 = f1836d.b();
            return b2 == null ? new a() : b2;
        }

        static void c(a aVar) {
            aVar.f1837a = 0;
            aVar.f1838b = null;
            aVar.f1839c = null;
            f1836d.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    s() {
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i2) {
        a m;
        RecyclerView.l.c cVar;
        int f2 = this.f1834a.f(d0Var);
        if (f2 >= 0 && (m = this.f1834a.m(f2)) != null) {
            int i3 = m.f1837a;
            if ((i3 & i2) != 0) {
                int i4 = (i2 ^ -1) & i3;
                m.f1837a = i4;
                if (i2 == 4) {
                    cVar = m.f1838b;
                } else if (i2 == 8) {
                    cVar = m.f1839c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.f1834a.k(f2);
                    a.c(m);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1834a.put(d0Var, aVar);
        }
        aVar.f1837a |= 2;
        aVar.f1838b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1834a.put(d0Var, aVar);
        }
        aVar.f1837a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j2, RecyclerView.d0 d0Var) {
        this.f1835b.i(j2, d0Var);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1834a.put(d0Var, aVar);
        }
        aVar.f1839c = cVar;
        aVar.f1837a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1834a.put(d0Var, aVar);
        }
        aVar.f1838b = cVar;
        aVar.f1837a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f1834a.clear();
        this.f1835b.b();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.d0 g(long j2) {
        return this.f1835b.e(j2);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar == null || (aVar.f1837a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f1834a.get(d0Var);
        return (aVar == null || (aVar.f1837a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.f1834a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 i2 = this.f1834a.i(size);
            a k2 = this.f1834a.k(size);
            int i3 = k2.f1837a;
            if ((i3 & 3) == 3) {
                bVar.a(i2);
            } else if ((i3 & 1) != 0) {
                RecyclerView.l.c cVar = k2.f1838b;
                if (cVar == null) {
                    bVar.a(i2);
                } else {
                    bVar.c(i2, cVar, k2.f1839c);
                }
            } else if ((i3 & 14) == 14) {
                bVar.b(i2, k2.f1838b, k2.f1839c);
            } else if ((i3 & 12) == 12) {
                bVar.d(i2, k2.f1838b, k2.f1839c);
            } else if ((i3 & 4) != 0) {
                bVar.c(i2, k2.f1838b, null);
            } else if ((i3 & 8) != 0) {
                bVar.b(i2, k2.f1838b, k2.f1839c);
            }
            a.c(k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.d0 d0Var) {
        a aVar = this.f1834a.get(d0Var);
        if (aVar != null) {
            aVar.f1837a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.d0 d0Var) {
        int m = this.f1835b.m() - 1;
        while (true) {
            if (m < 0) {
                break;
            } else if (d0Var == this.f1835b.n(m)) {
                this.f1835b.k(m);
                break;
            } else {
                m--;
            }
        }
        a remove = this.f1834a.remove(d0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
