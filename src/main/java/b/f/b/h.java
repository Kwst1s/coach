package b.f.b;

import b.f.b.b;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: PriorityGoalRow */
public class h extends b {

    /* renamed from: g  reason: collision with root package name */
    private int f2259g = 128;

    /* renamed from: h  reason: collision with root package name */
    private i[] f2260h = new i[128];

    /* renamed from: i  reason: collision with root package name */
    private i[] f2261i = new i[128];

    /* renamed from: j  reason: collision with root package name */
    private int f2262j = 0;

    /* renamed from: k  reason: collision with root package name */
    b f2263k = new b(this);

    /* access modifiers changed from: package-private */
    /* compiled from: PriorityGoalRow */
    public class a implements Comparator<i> {
        a(h hVar) {
        }

        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return iVar.f2268c - iVar2.f2268c;
        }
    }

    /* compiled from: PriorityGoalRow */
    class b implements Comparable {

        /* renamed from: b  reason: collision with root package name */
        i f2264b;

        public b(h hVar) {
        }

        public boolean a(i iVar, float f2) {
            boolean z = true;
            if (this.f2264b.f2266a) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.f2264b.f2274i;
                    fArr[i2] = fArr[i2] + (iVar.f2274i[i2] * f2);
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        this.f2264b.f2274i[i2] = 0.0f;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    h.this.G(this.f2264b);
                }
                return false;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float f3 = iVar.f2274i[i3];
                if (f3 != Utils.FLOAT_EPSILON) {
                    float f4 = f3 * f2;
                    if (Math.abs(f4) < 1.0E-4f) {
                        f4 = Utils.FLOAT_EPSILON;
                    }
                    this.f2264b.f2274i[i3] = f4;
                } else {
                    this.f2264b.f2274i[i3] = 0.0f;
                }
            }
            return true;
        }

        public void b(i iVar) {
            this.f2264b = iVar;
        }

        public final boolean c() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.f2264b.f2274i[i2];
                if (f2 > Utils.FLOAT_EPSILON) {
                    return false;
                }
                if (f2 < Utils.FLOAT_EPSILON) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f2264b.f2268c - ((i) obj).f2268c;
        }

        public final boolean d(i iVar) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = iVar.f2274i[i2];
                float f3 = this.f2264b.f2274i[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f2264b.f2274i, (float) Utils.FLOAT_EPSILON);
        }

        public String toString() {
            String str = "[ ";
            if (this.f2264b != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.f2264b.f2274i[i2] + " ";
                }
            }
            return str + "] " + this.f2264b;
        }
    }

    public h(c cVar) {
        super(cVar);
    }

    private final void F(i iVar) {
        int i2;
        int i3 = this.f2262j + 1;
        i[] iVarArr = this.f2260h;
        if (i3 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f2260h = iVarArr2;
            this.f2261i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f2260h;
        int i4 = this.f2262j;
        iVarArr3[i4] = iVar;
        int i5 = i4 + 1;
        this.f2262j = i5;
        if (i5 > 1 && iVarArr3[i5 - 1].f2268c > iVar.f2268c) {
            int i6 = 0;
            while (true) {
                i2 = this.f2262j;
                if (i6 >= i2) {
                    break;
                }
                this.f2261i[i6] = this.f2260h[i6];
                i6++;
            }
            Arrays.sort(this.f2261i, 0, i2, new a(this));
            for (int i7 = 0; i7 < this.f2262j; i7++) {
                this.f2260h[i7] = this.f2261i[i7];
            }
        }
        iVar.f2266a = true;
        iVar.a(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void G(i iVar) {
        int i2 = 0;
        while (i2 < this.f2262j) {
            if (this.f2260h[i2] == iVar) {
                while (true) {
                    int i3 = this.f2262j;
                    if (i2 < i3 - 1) {
                        i[] iVarArr = this.f2260h;
                        int i4 = i2 + 1;
                        iVarArr[i2] = iVarArr[i4];
                        i2 = i4;
                    } else {
                        this.f2262j = i3 - 1;
                        iVar.f2266a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // b.f.b.b
    public void B(d dVar, b bVar, boolean z) {
        i iVar = bVar.f2225a;
        if (iVar != null) {
            b.a aVar = bVar.f2229e;
            int e2 = aVar.e();
            for (int i2 = 0; i2 < e2; i2++) {
                i i3 = aVar.i(i2);
                float a2 = aVar.a(i2);
                this.f2263k.b(i3);
                if (this.f2263k.a(iVar, a2)) {
                    F(i3);
                }
                this.f2226b += bVar.f2226b * a2;
            }
            G(iVar);
        }
    }

    @Override // b.f.b.b, b.f.b.d.a
    public void b(i iVar) {
        this.f2263k.b(iVar);
        this.f2263k.e();
        iVar.f2274i[iVar.f2270e] = 1.0f;
        F(iVar);
    }

    @Override // b.f.b.b, b.f.b.d.a
    public i c(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f2262j; i3++) {
            i iVar = this.f2260h[i3];
            if (!zArr[iVar.f2268c]) {
                this.f2263k.b(iVar);
                if (i2 == -1) {
                    if (!this.f2263k.c()) {
                    }
                } else if (!this.f2263k.d(this.f2260h[i2])) {
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f2260h[i2];
    }

    @Override // b.f.b.b, b.f.b.d.a
    public void clear() {
        this.f2262j = 0;
        this.f2226b = Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b, b.f.b.d.a
    public boolean isEmpty() {
        return this.f2262j == 0;
    }

    @Override // b.f.b.b
    public String toString() {
        String str = BuildConfig.FLAVOR + " goal -> (" + this.f2226b + ") : ";
        for (int i2 = 0; i2 < this.f2262j; i2++) {
            this.f2263k.b(this.f2260h[i2]);
            str = str + this.f2263k + " ";
        }
        return str;
    }
}
