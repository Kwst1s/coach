package androidx.coordinatorlayout.widget;

import b.e.g;
import b.h.j.e;
import b.h.j.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f1012a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f1013b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f1014c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f1015d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> arrayList2 = this.f1013b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        e(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> f() {
        ArrayList<T> b2 = this.f1012a.b();
        return b2 == null ? new ArrayList<>() : b2;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1012a.a(arrayList);
    }

    public void a(T t, T t2) {
        if (!this.f1013b.containsKey(t) || !this.f1013b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f1013b.get(t);
        if (arrayList == null) {
            arrayList = f();
            this.f1013b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void b(T t) {
        if (!this.f1013b.containsKey(t)) {
            this.f1013b.put(t, null);
        }
    }

    public void c() {
        int size = this.f1013b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> m = this.f1013b.m(i2);
            if (m != null) {
                k(m);
            }
        }
        this.f1013b.clear();
    }

    public boolean d(T t) {
        return this.f1013b.containsKey(t);
    }

    public List g(T t) {
        return this.f1013b.get(t);
    }

    public List<T> h(T t) {
        int size = this.f1013b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> m = this.f1013b.m(i2);
            if (m != null && m.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1013b.i(i2));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f1014c.clear();
        this.f1015d.clear();
        int size = this.f1013b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f1013b.i(i2), this.f1014c, this.f1015d);
        }
        return this.f1014c;
    }

    public boolean j(T t) {
        int size = this.f1013b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> m = this.f1013b.m(i2);
            if (m != null && m.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
