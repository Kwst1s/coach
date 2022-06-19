package b.f.b.k.m;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DependencyNode */
public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public d f2368a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2369b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2370c = false;

    /* renamed from: d  reason: collision with root package name */
    p f2371d;

    /* renamed from: e  reason: collision with root package name */
    a f2372e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    int f2373f;

    /* renamed from: g  reason: collision with root package name */
    public int f2374g;

    /* renamed from: h  reason: collision with root package name */
    int f2375h = 1;

    /* renamed from: i  reason: collision with root package name */
    g f2376i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2377j = false;

    /* renamed from: k  reason: collision with root package name */
    List<d> f2378k = new ArrayList();
    List<f> l = new ArrayList();

    /* compiled from: DependencyNode */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f2371d = pVar;
    }

    @Override // b.f.b.k.m.d
    public void a(d dVar) {
        for (f fVar : this.l) {
            if (!fVar.f2377j) {
                return;
            }
        }
        this.f2370c = true;
        d dVar2 = this.f2368a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f2369b) {
            this.f2371d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f2377j) {
            g gVar = this.f2376i;
            if (gVar != null) {
                if (gVar.f2377j) {
                    this.f2373f = this.f2375h * gVar.f2374g;
                } else {
                    return;
                }
            }
            d(fVar2.f2374g + this.f2373f);
        }
        d dVar3 = this.f2368a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f2378k.add(dVar);
        if (this.f2377j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.l.clear();
        this.f2378k.clear();
        this.f2377j = false;
        this.f2374g = 0;
        this.f2370c = false;
        this.f2369b = false;
    }

    public void d(int i2) {
        if (!this.f2377j) {
            this.f2377j = true;
            this.f2374g = i2;
            for (d dVar : this.f2378k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2371d.f2404b.r());
        sb.append(":");
        sb.append(this.f2372e);
        sb.append("(");
        sb.append(this.f2377j ? Integer.valueOf(this.f2374g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.f2378k.size());
        sb.append(">");
        return sb.toString();
    }
}
