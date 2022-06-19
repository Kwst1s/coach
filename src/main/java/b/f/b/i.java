package b.f.b;

import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* compiled from: SolverVariable */
public class i {
    private static int q = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2266a;

    /* renamed from: b  reason: collision with root package name */
    private String f2267b;

    /* renamed from: c  reason: collision with root package name */
    public int f2268c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f2269d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f2270e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f2271f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2272g = false;

    /* renamed from: h  reason: collision with root package name */
    float[] f2273h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    float[] f2274i = new float[9];

    /* renamed from: j  reason: collision with root package name */
    a f2275j;

    /* renamed from: k  reason: collision with root package name */
    b[] f2276k = new b[16];
    int l = 0;
    public int m = 0;
    boolean n = false;
    int o = -1;
    float p = Utils.FLOAT_EPSILON;

    /* compiled from: SolverVariable */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f2275j = aVar;
    }

    static void b() {
        q++;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.l;
            if (i2 >= i3) {
                b[] bVarArr = this.f2276k;
                if (i3 >= bVarArr.length) {
                    this.f2276k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f2276k;
                int i4 = this.l;
                bVarArr2[i4] = bVar;
                this.l = i4 + 1;
                return;
            } else if (this.f2276k[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.l;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f2276k[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f2276k;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.l--;
                return;
            }
            i3++;
        }
    }

    public void d() {
        this.f2267b = null;
        this.f2275j = a.UNKNOWN;
        this.f2270e = 0;
        this.f2268c = -1;
        this.f2269d = -1;
        this.f2271f = Utils.FLOAT_EPSILON;
        this.f2272g = false;
        this.n = false;
        this.o = -1;
        this.p = Utils.FLOAT_EPSILON;
        int i2 = this.l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2276k[i3] = null;
        }
        this.l = 0;
        this.m = 0;
        this.f2266a = false;
        Arrays.fill(this.f2274i, (float) Utils.FLOAT_EPSILON);
    }

    public void e(d dVar, float f2) {
        this.f2271f = f2;
        this.f2272g = true;
        this.n = false;
        this.o = -1;
        this.p = Utils.FLOAT_EPSILON;
        int i2 = this.l;
        this.f2269d = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2276k[i3].A(dVar, this, false);
        }
        this.l = 0;
    }

    public void f(a aVar, String str) {
        this.f2275j = aVar;
    }

    public final void g(d dVar, b bVar) {
        int i2 = this.l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2276k[i3].B(dVar, bVar, false);
        }
        this.l = 0;
    }

    public String toString() {
        if (this.f2267b != null) {
            return BuildConfig.FLAVOR + this.f2267b;
        }
        return BuildConfig.FLAVOR + this.f2268c;
    }
}
