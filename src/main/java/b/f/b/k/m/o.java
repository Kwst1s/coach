package b.f.b.k.m;

import b.f.b.d;
import b.f.b.k.b;
import b.f.b.k.e;
import b.f.b.k.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WidgetGroup */
public class o {

    /* renamed from: f  reason: collision with root package name */
    static int f2397f;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<e> f2398a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f2399b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2400c = 0;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f2401d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f2402e = -1;

    /* access modifiers changed from: package-private */
    /* compiled from: WidgetGroup */
    public class a {
        public a(o oVar, e eVar, d dVar, int i2) {
            new WeakReference(eVar);
            dVar.x(eVar.F);
            dVar.x(eVar.G);
            dVar.x(eVar.H);
            dVar.x(eVar.I);
            dVar.x(eVar.J);
        }
    }

    public o(int i2) {
        int i3 = f2397f;
        f2397f = i3 + 1;
        this.f2399b = i3;
        this.f2400c = i2;
    }

    private String e() {
        int i2 = this.f2400c;
        if (i2 == 0) {
            return "Horizontal";
        }
        if (i2 == 1) {
            return "Vertical";
        }
        return i2 == 2 ? "Both" : "Unknown";
    }

    private int j(d dVar, ArrayList<e> arrayList, int i2) {
        int x;
        int x2;
        f fVar = (f) arrayList.get(0).I();
        dVar.D();
        fVar.g(dVar, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).g(dVar, false);
        }
        if (i2 == 0 && fVar.y0 > 0) {
            b.b(fVar, dVar, arrayList, 0);
        }
        if (i2 == 1 && fVar.z0 > 0) {
            b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f2401d = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f2401d.add(new a(this, arrayList.get(i4), dVar, i2));
        }
        if (i2 == 0) {
            x = dVar.x(fVar.F);
            x2 = dVar.x(fVar.H);
            dVar.D();
        } else {
            x = dVar.x(fVar.G);
            x2 = dVar.x(fVar.I);
            dVar.D();
        }
        return x2 - x;
    }

    public boolean a(e eVar) {
        if (this.f2398a.contains(eVar)) {
            return false;
        }
        this.f2398a.add(eVar);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int size = this.f2398a.size();
        if (this.f2402e != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                o oVar = arrayList.get(i2);
                if (this.f2402e == oVar.f2399b) {
                    g(this.f2400c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f2399b;
    }

    public int d() {
        return this.f2400c;
    }

    public int f(d dVar, int i2) {
        if (this.f2398a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f2398a, i2);
    }

    public void g(int i2, o oVar) {
        Iterator<e> it = this.f2398a.iterator();
        while (it.hasNext()) {
            e next = it.next();
            oVar.a(next);
            if (i2 == 0) {
                next.m0 = oVar.c();
            } else {
                next.n0 = oVar.c();
            }
        }
        this.f2402e = oVar.f2399b;
    }

    public void h(boolean z) {
    }

    public void i(int i2) {
        this.f2400c = i2;
    }

    public String toString() {
        String str = e() + " [" + this.f2399b + "] <";
        Iterator<e> it = this.f2398a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().r();
        }
        return str + " >";
    }
}
