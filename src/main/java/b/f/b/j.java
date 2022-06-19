package b.f.b;

import b.f.b.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* compiled from: SolverVariableValues */
public class j implements b.a {
    private static float m = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private int f2283a = 16;

    /* renamed from: b  reason: collision with root package name */
    private int f2284b = 16;

    /* renamed from: c  reason: collision with root package name */
    int[] f2285c = new int[16];

    /* renamed from: d  reason: collision with root package name */
    int[] f2286d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f2287e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    float[] f2288f = new float[16];

    /* renamed from: g  reason: collision with root package name */
    int[] f2289g = new int[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f2290h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int f2291i = 0;

    /* renamed from: j  reason: collision with root package name */
    int f2292j = -1;

    /* renamed from: k  reason: collision with root package name */
    private final b f2293k;
    protected final c l;

    j(b bVar, c cVar) {
        this.f2293k = bVar;
        this.l = cVar;
        clear();
    }

    private void l(i iVar, int i2) {
        int[] iArr;
        int i3 = iVar.f2268c % this.f2284b;
        int[] iArr2 = this.f2285c;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f2286d;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.f2286d[i2] = -1;
    }

    private void m(int i2, i iVar, float f2) {
        this.f2287e[i2] = iVar.f2268c;
        this.f2288f[i2] = f2;
        this.f2289g[i2] = -1;
        this.f2290h[i2] = -1;
        iVar.a(this.f2293k);
        iVar.m++;
        this.f2291i++;
    }

    private int n() {
        for (int i2 = 0; i2 < this.f2283a; i2++) {
            if (this.f2287e[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void o() {
        int i2 = this.f2283a * 2;
        this.f2287e = Arrays.copyOf(this.f2287e, i2);
        this.f2288f = Arrays.copyOf(this.f2288f, i2);
        this.f2289g = Arrays.copyOf(this.f2289g, i2);
        this.f2290h = Arrays.copyOf(this.f2290h, i2);
        this.f2286d = Arrays.copyOf(this.f2286d, i2);
        for (int i3 = this.f2283a; i3 < i2; i3++) {
            this.f2287e[i3] = -1;
            this.f2286d[i3] = -1;
        }
        this.f2283a = i2;
    }

    private void q(int i2, i iVar, float f2) {
        int n = n();
        m(n, iVar, f2);
        if (i2 != -1) {
            this.f2289g[n] = i2;
            int[] iArr = this.f2290h;
            iArr[n] = iArr[i2];
            iArr[i2] = n;
        } else {
            this.f2289g[n] = -1;
            if (this.f2291i > 0) {
                this.f2290h[n] = this.f2292j;
                this.f2292j = n;
            } else {
                this.f2290h[n] = -1;
            }
        }
        int[] iArr2 = this.f2290h;
        if (iArr2[n] != -1) {
            this.f2289g[iArr2[n]] = n;
        }
        l(iVar, n);
    }

    private void r(i iVar) {
        int[] iArr;
        int i2 = iVar.f2268c;
        int i3 = i2 % this.f2284b;
        int[] iArr2 = this.f2285c;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.f2287e[i4] == i2) {
                int[] iArr3 = this.f2286d;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
                return;
            }
            while (true) {
                iArr = this.f2286d;
                if (iArr[i4] == -1 || this.f2287e[iArr[i4]] == i2) {
                    int i5 = iArr[i4];
                } else {
                    i4 = iArr[i4];
                }
            }
            int i52 = iArr[i4];
            if (i52 != -1 && this.f2287e[i52] == i2) {
                iArr[i4] = iArr[i52];
                iArr[i52] = -1;
            }
        }
    }

    @Override // b.f.b.b.a
    public float a(int i2) {
        int i3 = this.f2291i;
        int i4 = this.f2292j;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f2288f[i4];
            }
            i4 = this.f2290h[i4];
            if (i4 == -1) {
                return Utils.FLOAT_EPSILON;
            }
        }
        return Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b.a
    public void b(i iVar, float f2, boolean z) {
        float f3 = m;
        if (f2 <= (-f3) || f2 >= f3) {
            int p = p(iVar);
            if (p == -1) {
                g(iVar, f2);
                return;
            }
            float[] fArr = this.f2288f;
            fArr[p] = fArr[p] + f2;
            float f4 = fArr[p];
            float f5 = m;
            if (f4 > (-f5) && fArr[p] < f5) {
                fArr[p] = 0.0f;
                h(iVar, z);
            }
        }
    }

    @Override // b.f.b.b.a
    public float c(i iVar) {
        int p = p(iVar);
        return p != -1 ? this.f2288f[p] : Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b.a
    public void clear() {
        int i2 = this.f2291i;
        for (int i3 = 0; i3 < i2; i3++) {
            i i4 = i(i3);
            if (i4 != null) {
                i4.c(this.f2293k);
            }
        }
        for (int i5 = 0; i5 < this.f2283a; i5++) {
            this.f2287e[i5] = -1;
            this.f2286d[i5] = -1;
        }
        for (int i6 = 0; i6 < this.f2284b; i6++) {
            this.f2285c[i6] = -1;
        }
        this.f2291i = 0;
        this.f2292j = -1;
    }

    @Override // b.f.b.b.a
    public boolean d(i iVar) {
        return p(iVar) != -1;
    }

    @Override // b.f.b.b.a
    public int e() {
        return this.f2291i;
    }

    @Override // b.f.b.b.a
    public float f(b bVar, boolean z) {
        float c2 = c(bVar.f2225a);
        h(bVar.f2225a, z);
        j jVar = (j) bVar.f2229e;
        int e2 = jVar.e();
        int i2 = jVar.f2292j;
        int i3 = 0;
        int i4 = 0;
        while (i3 < e2) {
            int[] iArr = jVar.f2287e;
            if (iArr[i4] != -1) {
                b(this.l.f2234d[iArr[i4]], jVar.f2288f[i4] * c2, z);
                i3++;
            }
            i4++;
        }
        return c2;
    }

    @Override // b.f.b.b.a
    public void g(i iVar, float f2) {
        float f3 = m;
        if (f2 <= (-f3) || f2 >= f3) {
            if (this.f2291i == 0) {
                m(0, iVar, f2);
                l(iVar, 0);
                this.f2292j = 0;
                return;
            }
            int p = p(iVar);
            if (p != -1) {
                this.f2288f[p] = f2;
                return;
            }
            if (this.f2291i + 1 >= this.f2283a) {
                o();
            }
            int i2 = this.f2291i;
            int i3 = this.f2292j;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                int[] iArr = this.f2287e;
                int i6 = iArr[i3];
                int i7 = iVar.f2268c;
                if (i6 == i7) {
                    this.f2288f[i3] = f2;
                    return;
                }
                if (iArr[i3] < i7) {
                    i4 = i3;
                }
                i3 = this.f2290h[i3];
                if (i3 == -1) {
                    break;
                }
            }
            q(i4, iVar, f2);
            return;
        }
        h(iVar, true);
    }

    @Override // b.f.b.b.a
    public float h(i iVar, boolean z) {
        int p = p(iVar);
        if (p == -1) {
            return Utils.FLOAT_EPSILON;
        }
        r(iVar);
        float f2 = this.f2288f[p];
        if (this.f2292j == p) {
            this.f2292j = this.f2290h[p];
        }
        this.f2287e[p] = -1;
        int[] iArr = this.f2289g;
        if (iArr[p] != -1) {
            int[] iArr2 = this.f2290h;
            iArr2[iArr[p]] = iArr2[p];
        }
        int[] iArr3 = this.f2290h;
        if (iArr3[p] != -1) {
            iArr[iArr3[p]] = iArr[p];
        }
        this.f2291i--;
        iVar.m--;
        if (z) {
            iVar.c(this.f2293k);
        }
        return f2;
    }

    @Override // b.f.b.b.a
    public i i(int i2) {
        int i3 = this.f2291i;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f2292j;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.l.f2234d[this.f2287e[i4]];
            }
            i4 = this.f2290h[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // b.f.b.b.a
    public void j(float f2) {
        int i2 = this.f2291i;
        int i3 = this.f2292j;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f2288f;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f2290h[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // b.f.b.b.a
    public void k() {
        int i2 = this.f2291i;
        int i3 = this.f2292j;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f2288f;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.f2290h[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    public int p(i iVar) {
        int[] iArr;
        if (!(this.f2291i == 0 || iVar == null)) {
            int i2 = iVar.f2268c;
            int i3 = this.f2285c[i2 % this.f2284b];
            if (i3 == -1) {
                return -1;
            }
            if (this.f2287e[i3] == i2) {
                return i3;
            }
            while (true) {
                iArr = this.f2286d;
                if (iArr[i3] != -1 && this.f2287e[iArr[i3]] != i2) {
                    i3 = iArr[i3];
                }
            }
            if (iArr[i3] != -1 && this.f2287e[iArr[i3]] == i2) {
                return iArr[i3];
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i2 = this.f2291i;
        for (int i3 = 0; i3 < i2; i3++) {
            i i4 = i(i3);
            if (i4 != null) {
                String str2 = str + i4 + " = " + a(i3) + " ";
                int p = p(i4);
                String str3 = str2 + "[p: ";
                String str4 = (this.f2289g[p] != -1 ? str3 + this.l.f2234d[this.f2287e[this.f2289g[p]]] : str3 + "none") + ", n: ";
                str = (this.f2290h[p] != -1 ? str4 + this.l.f2234d[this.f2287e[this.f2290h[p]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
