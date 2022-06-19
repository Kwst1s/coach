package b.f.b;

import b.f.b.d;
import b.f.b.i;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: ArrayRow */
public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    i f2225a = null;

    /* renamed from: b  reason: collision with root package name */
    float f2226b = Utils.FLOAT_EPSILON;

    /* renamed from: c  reason: collision with root package name */
    boolean f2227c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<i> f2228d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f2229e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2230f = false;

    /* compiled from: ArrayRow */
    public interface a {
        float a(int i2);

        void b(i iVar, float f2, boolean z);

        float c(i iVar);

        void clear();

        boolean d(i iVar);

        int e();

        float f(b bVar, boolean z);

        void g(i iVar, float f2);

        float h(i iVar, boolean z);

        i i(int i2);

        void j(float f2);

        void k();
    }

    public b() {
    }

    private boolean u(i iVar, d dVar) {
        return iVar.m <= 1;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int e2 = this.f2229e.e();
        i iVar2 = null;
        float f2 = Utils.FLOAT_EPSILON;
        for (int i2 = 0; i2 < e2; i2++) {
            float a2 = this.f2229e.a(i2);
            if (a2 < Utils.FLOAT_EPSILON) {
                i i3 = this.f2229e.i(i2);
                if ((zArr == null || !zArr[i3.f2268c]) && i3 != iVar && (((aVar = i3.f2275j) == i.a.SLACK || aVar == i.a.ERROR) && a2 < f2)) {
                    f2 = a2;
                    iVar2 = i3;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z) {
        if (iVar.f2272g) {
            this.f2226b += iVar.f2271f * this.f2229e.c(iVar);
            this.f2229e.h(iVar, z);
            if (z) {
                iVar.c(this);
            }
            if (d.t && iVar != null && this.f2229e.e() == 0) {
                this.f2230f = true;
                dVar.f2235a = true;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z) {
        this.f2226b += bVar.f2226b * this.f2229e.f(bVar, z);
        if (z) {
            bVar.f2225a.c(this);
        }
        if (d.t && this.f2225a != null && this.f2229e.e() == 0) {
            this.f2230f = true;
            dVar.f2235a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z) {
        if (iVar.n) {
            float c2 = this.f2229e.c(iVar);
            this.f2226b += iVar.p * c2;
            this.f2229e.h(iVar, z);
            if (z) {
                iVar.c(this);
            }
            this.f2229e.b(dVar.n.f2234d[iVar.o], c2, z);
            if (d.t && iVar != null && this.f2229e.e() == 0) {
                this.f2230f = true;
                dVar.f2235a = true;
            }
        }
    }

    public void D(d dVar) {
        if (dVar.f2241g.length != 0) {
            boolean z = false;
            while (!z) {
                int e2 = this.f2229e.e();
                for (int i2 = 0; i2 < e2; i2++) {
                    i i3 = this.f2229e.i(i2);
                    if (i3.f2269d != -1 || i3.f2272g || i3.n) {
                        this.f2228d.add(i3);
                    }
                }
                int size = this.f2228d.size();
                if (size > 0) {
                    for (int i4 = 0; i4 < size; i4++) {
                        i iVar = this.f2228d.get(i4);
                        if (iVar.f2272g) {
                            A(dVar, iVar, true);
                        } else if (iVar.n) {
                            C(dVar, iVar, true);
                        } else {
                            B(dVar, dVar.f2241g[iVar.f2269d], true);
                        }
                    }
                    this.f2228d.clear();
                } else {
                    z = true;
                }
            }
            if (d.t && this.f2225a != null && this.f2229e.e() == 0) {
                this.f2230f = true;
                dVar.f2235a = true;
            }
        }
    }

    @Override // b.f.b.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2225a = null;
            this.f2229e.clear();
            for (int i2 = 0; i2 < bVar.f2229e.e(); i2++) {
                this.f2229e.b(bVar.f2229e.i(i2), bVar.f2229e.a(i2), true);
            }
        }
    }

    @Override // b.f.b.d.a
    public void b(i iVar) {
        int i2 = iVar.f2270e;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2229e.g(iVar, f2);
    }

    @Override // b.f.b.d.a
    public i c(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // b.f.b.d.a
    public void clear() {
        this.f2229e.clear();
        this.f2225a = null;
        this.f2226b = Utils.FLOAT_EPSILON;
    }

    public b d(d dVar, int i2) {
        this.f2229e.g(dVar.o(i2, "ep"), 1.0f);
        this.f2229e.g(dVar.o(i2, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b e(i iVar, int i2) {
        this.f2229e.g(iVar, (float) i2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z;
        i g2 = g(dVar);
        if (g2 == null) {
            z = true;
        } else {
            x(g2);
            z = false;
        }
        if (this.f2229e.e() == 0) {
            this.f2230f = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public i g(d dVar) {
        boolean u;
        boolean u2;
        int e2 = this.f2229e.e();
        i iVar = null;
        i iVar2 = null;
        boolean z = false;
        boolean z2 = false;
        float f2 = Utils.FLOAT_EPSILON;
        float f3 = Utils.FLOAT_EPSILON;
        for (int i2 = 0; i2 < e2; i2++) {
            float a2 = this.f2229e.a(i2);
            i i3 = this.f2229e.i(i2);
            if (i3.f2275j == i.a.UNRESTRICTED) {
                if (iVar == null) {
                    u2 = u(i3, dVar);
                } else if (f2 > a2) {
                    u2 = u(i3, dVar);
                } else if (!z && u(i3, dVar)) {
                    f2 = a2;
                    iVar = i3;
                    z = true;
                }
                z = u2;
                f2 = a2;
                iVar = i3;
            } else if (iVar == null && a2 < Utils.FLOAT_EPSILON) {
                if (iVar2 == null) {
                    u = u(i3, dVar);
                } else if (f3 > a2) {
                    u = u(i3, dVar);
                } else if (!z2 && u(i3, dVar)) {
                    f3 = a2;
                    iVar2 = i3;
                    z2 = true;
                }
                z2 = u;
                f3 = a2;
                iVar2 = i3;
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // b.f.b.d.a
    public i getKey() {
        return this.f2225a;
    }

    /* access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar4, 1.0f);
            this.f2229e.g(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
            this.f2229e.g(iVar3, -1.0f);
            this.f2229e.g(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f2226b = (float) ((-i2) + i3);
            }
        } else if (f2 <= Utils.FLOAT_EPSILON) {
            this.f2229e.g(iVar, -1.0f);
            this.f2229e.g(iVar2, 1.0f);
            this.f2226b = (float) i2;
        } else if (f2 >= 1.0f) {
            this.f2229e.g(iVar4, -1.0f);
            this.f2229e.g(iVar3, 1.0f);
            this.f2226b = (float) (-i3);
        } else {
            float f3 = 1.0f - f2;
            this.f2229e.g(iVar, f3 * 1.0f);
            this.f2229e.g(iVar2, f3 * -1.0f);
            this.f2229e.g(iVar3, -1.0f * f2);
            this.f2229e.g(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f2226b = (((float) (-i2)) * f3) + (((float) i3) * f2);
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b i(i iVar, int i2) {
        this.f2225a = iVar;
        float f2 = (float) i2;
        iVar.f2271f = f2;
        this.f2226b = f2;
        this.f2230f = true;
        return this;
    }

    @Override // b.f.b.d.a
    public boolean isEmpty() {
        return this.f2225a == null && this.f2226b == Utils.FLOAT_EPSILON && this.f2229e.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f2) {
        this.f2229e.g(iVar, -1.0f);
        this.f2229e.g(iVar2, f2);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2229e.g(iVar, -1.0f);
        this.f2229e.g(iVar2, 1.0f);
        this.f2229e.g(iVar3, f2);
        this.f2229e.g(iVar4, -f2);
        return this;
    }

    public b l(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f2226b = Utils.FLOAT_EPSILON;
        if (f3 == Utils.FLOAT_EPSILON || f2 == f4) {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
            this.f2229e.g(iVar4, 1.0f);
            this.f2229e.g(iVar3, -1.0f);
        } else if (f2 == Utils.FLOAT_EPSILON) {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
        } else if (f4 == Utils.FLOAT_EPSILON) {
            this.f2229e.g(iVar3, 1.0f);
            this.f2229e.g(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
            this.f2229e.g(iVar4, f5);
            this.f2229e.g(iVar3, -f5);
        }
        return this;
    }

    public b m(i iVar, int i2) {
        if (i2 < 0) {
            this.f2226b = (float) (i2 * -1);
            this.f2229e.g(iVar, 1.0f);
        } else {
            this.f2226b = (float) i2;
            this.f2229e.g(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2226b = (float) i2;
        }
        if (!z) {
            this.f2229e.g(iVar, -1.0f);
            this.f2229e.g(iVar2, 1.0f);
        } else {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2226b = (float) i2;
        }
        if (!z) {
            this.f2229e.g(iVar, -1.0f);
            this.f2229e.g(iVar2, 1.0f);
            this.f2229e.g(iVar3, 1.0f);
        } else {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
            this.f2229e.g(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2226b = (float) i2;
        }
        if (!z) {
            this.f2229e.g(iVar, -1.0f);
            this.f2229e.g(iVar2, 1.0f);
            this.f2229e.g(iVar3, -1.0f);
        } else {
            this.f2229e.g(iVar, 1.0f);
            this.f2229e.g(iVar2, -1.0f);
            this.f2229e.g(iVar3, 1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2229e.g(iVar3, 0.5f);
        this.f2229e.g(iVar4, 0.5f);
        this.f2229e.g(iVar, -0.5f);
        this.f2229e.g(iVar2, -0.5f);
        this.f2226b = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        float f2 = this.f2226b;
        if (f2 < Utils.FLOAT_EPSILON) {
            this.f2226b = f2 * -1.0f;
            this.f2229e.k();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.f2225a;
        return iVar != null && (iVar.f2275j == i.a.UNRESTRICTED || this.f2226b >= Utils.FLOAT_EPSILON);
    }

    /* access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f2229e.d(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    /* access modifiers changed from: package-private */
    public void x(i iVar) {
        i iVar2 = this.f2225a;
        if (iVar2 != null) {
            this.f2229e.g(iVar2, -1.0f);
            this.f2225a.f2269d = -1;
            this.f2225a = null;
        }
        float h2 = this.f2229e.h(iVar, true) * -1.0f;
        this.f2225a = iVar;
        if (h2 != 1.0f) {
            this.f2226b /= h2;
            this.f2229e.j(h2);
        }
    }

    public void y() {
        this.f2225a = null;
        this.f2229e.clear();
        this.f2226b = Utils.FLOAT_EPSILON;
        this.f2230f = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z() {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.b.z():java.lang.String");
    }

    public b(c cVar) {
        this.f2229e = new a(this, cVar);
    }
}
