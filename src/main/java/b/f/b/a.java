package b.f.b;

import b.f.b.b;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables */
public class a implements b.a {
    private static float l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int f2214a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final b f2215b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f2216c;

    /* renamed from: d  reason: collision with root package name */
    private int f2217d = 8;

    /* renamed from: e  reason: collision with root package name */
    private i f2218e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f2219f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f2220g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f2221h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f2222i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f2223j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2224k = false;

    a(b bVar, c cVar) {
        this.f2215b = bVar;
        this.f2216c = cVar;
    }

    @Override // b.f.b.b.a
    public float a(int i2) {
        int i3 = this.f2222i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2214a) {
            if (i4 == i2) {
                return this.f2221h[i3];
            }
            i3 = this.f2220g[i3];
            i4++;
        }
        return Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b.a
    public void b(i iVar, float f2, boolean z) {
        float f3 = l;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f2222i;
            if (i2 == -1) {
                this.f2222i = 0;
                this.f2221h[0] = f2;
                this.f2219f[0] = iVar.f2268c;
                this.f2220g[0] = -1;
                iVar.m++;
                iVar.a(this.f2215b);
                this.f2214a++;
                if (!this.f2224k) {
                    int i3 = this.f2223j + 1;
                    this.f2223j = i3;
                    int[] iArr = this.f2219f;
                    if (i3 >= iArr.length) {
                        this.f2224k = true;
                        this.f2223j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f2214a) {
                int[] iArr2 = this.f2219f;
                int i6 = iArr2[i2];
                int i7 = iVar.f2268c;
                if (i6 == i7) {
                    float[] fArr = this.f2221h;
                    float f4 = fArr[i2] + f2;
                    float f5 = l;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = Utils.FLOAT_EPSILON;
                    }
                    fArr[i2] = f4;
                    if (f4 == Utils.FLOAT_EPSILON) {
                        if (i2 == this.f2222i) {
                            this.f2222i = this.f2220g[i2];
                        } else {
                            int[] iArr3 = this.f2220g;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            iVar.c(this.f2215b);
                        }
                        if (this.f2224k) {
                            this.f2223j = i2;
                        }
                        iVar.m--;
                        this.f2214a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f2220g[i2];
                i4++;
            }
            int i8 = this.f2223j;
            int i9 = i8 + 1;
            if (this.f2224k) {
                int[] iArr4 = this.f2219f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f2219f;
            if (i8 >= iArr5.length && this.f2214a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f2219f;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.f2219f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f2217d * 2;
                this.f2217d = i11;
                this.f2224k = false;
                this.f2223j = i8 - 1;
                this.f2221h = Arrays.copyOf(this.f2221h, i11);
                this.f2219f = Arrays.copyOf(this.f2219f, this.f2217d);
                this.f2220g = Arrays.copyOf(this.f2220g, this.f2217d);
            }
            this.f2219f[i8] = iVar.f2268c;
            this.f2221h[i8] = f2;
            if (i5 != -1) {
                int[] iArr8 = this.f2220g;
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                this.f2220g[i8] = this.f2222i;
                this.f2222i = i8;
            }
            iVar.m++;
            iVar.a(this.f2215b);
            this.f2214a++;
            if (!this.f2224k) {
                this.f2223j++;
            }
            int i12 = this.f2223j;
            int[] iArr9 = this.f2219f;
            if (i12 >= iArr9.length) {
                this.f2224k = true;
                this.f2223j = iArr9.length - 1;
            }
        }
    }

    @Override // b.f.b.b.a
    public final float c(i iVar) {
        int i2 = this.f2222i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            if (this.f2219f[i2] == iVar.f2268c) {
                return this.f2221h[i2];
            }
            i2 = this.f2220g[i2];
            i3++;
        }
        return Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b.a
    public final void clear() {
        int i2 = this.f2222i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            i iVar = this.f2216c.f2234d[this.f2219f[i2]];
            if (iVar != null) {
                iVar.c(this.f2215b);
            }
            i2 = this.f2220g[i2];
            i3++;
        }
        this.f2222i = -1;
        this.f2223j = -1;
        this.f2224k = false;
        this.f2214a = 0;
    }

    @Override // b.f.b.b.a
    public boolean d(i iVar) {
        int i2 = this.f2222i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            if (this.f2219f[i2] == iVar.f2268c) {
                return true;
            }
            i2 = this.f2220g[i2];
            i3++;
        }
        return false;
    }

    @Override // b.f.b.b.a
    public int e() {
        return this.f2214a;
    }

    @Override // b.f.b.b.a
    public float f(b bVar, boolean z) {
        float c2 = c(bVar.f2225a);
        h(bVar.f2225a, z);
        b.a aVar = bVar.f2229e;
        int e2 = aVar.e();
        for (int i2 = 0; i2 < e2; i2++) {
            i i3 = aVar.i(i2);
            b(i3, aVar.c(i3) * c2, z);
        }
        return c2;
    }

    @Override // b.f.b.b.a
    public final void g(i iVar, float f2) {
        if (f2 == Utils.FLOAT_EPSILON) {
            h(iVar, true);
            return;
        }
        int i2 = this.f2222i;
        if (i2 == -1) {
            this.f2222i = 0;
            this.f2221h[0] = f2;
            this.f2219f[0] = iVar.f2268c;
            this.f2220g[0] = -1;
            iVar.m++;
            iVar.a(this.f2215b);
            this.f2214a++;
            if (!this.f2224k) {
                int i3 = this.f2223j + 1;
                this.f2223j = i3;
                int[] iArr = this.f2219f;
                if (i3 >= iArr.length) {
                    this.f2224k = true;
                    this.f2223j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f2214a) {
            int[] iArr2 = this.f2219f;
            int i6 = iArr2[i2];
            int i7 = iVar.f2268c;
            if (i6 == i7) {
                this.f2221h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f2220g[i2];
            i4++;
        }
        int i8 = this.f2223j;
        int i9 = i8 + 1;
        if (this.f2224k) {
            int[] iArr3 = this.f2219f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f2219f;
        if (i8 >= iArr4.length && this.f2214a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f2219f;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f2219f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f2217d * 2;
            this.f2217d = i11;
            this.f2224k = false;
            this.f2223j = i8 - 1;
            this.f2221h = Arrays.copyOf(this.f2221h, i11);
            this.f2219f = Arrays.copyOf(this.f2219f, this.f2217d);
            this.f2220g = Arrays.copyOf(this.f2220g, this.f2217d);
        }
        this.f2219f[i8] = iVar.f2268c;
        this.f2221h[i8] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.f2220g;
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            this.f2220g[i8] = this.f2222i;
            this.f2222i = i8;
        }
        iVar.m++;
        iVar.a(this.f2215b);
        int i12 = this.f2214a + 1;
        this.f2214a = i12;
        if (!this.f2224k) {
            this.f2223j++;
        }
        int[] iArr8 = this.f2219f;
        if (i12 >= iArr8.length) {
            this.f2224k = true;
        }
        if (this.f2223j >= iArr8.length) {
            this.f2224k = true;
            this.f2223j = iArr8.length - 1;
        }
    }

    @Override // b.f.b.b.a
    public final float h(i iVar, boolean z) {
        if (this.f2218e == iVar) {
            this.f2218e = null;
        }
        int i2 = this.f2222i;
        if (i2 == -1) {
            return Utils.FLOAT_EPSILON;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f2214a) {
            if (this.f2219f[i2] == iVar.f2268c) {
                if (i2 == this.f2222i) {
                    this.f2222i = this.f2220g[i2];
                } else {
                    int[] iArr = this.f2220g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.c(this.f2215b);
                }
                iVar.m--;
                this.f2214a--;
                this.f2219f[i2] = -1;
                if (this.f2224k) {
                    this.f2223j = i2;
                }
                return this.f2221h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f2220g[i2];
        }
        return Utils.FLOAT_EPSILON;
    }

    @Override // b.f.b.b.a
    public i i(int i2) {
        int i3 = this.f2222i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2214a) {
            if (i4 == i2) {
                return this.f2216c.f2234d[this.f2219f[i3]];
            }
            i3 = this.f2220g[i3];
            i4++;
        }
        return null;
    }

    @Override // b.f.b.b.a
    public void j(float f2) {
        int i2 = this.f2222i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            float[] fArr = this.f2221h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f2220g[i2];
            i3++;
        }
    }

    @Override // b.f.b.b.a
    public void k() {
        int i2 = this.f2222i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            float[] fArr = this.f2221h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f2220g[i2];
            i3++;
        }
    }

    public String toString() {
        int i2 = this.f2222i;
        String str = BuildConfig.FLAVOR;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2214a) {
            str = ((str + " -> ") + this.f2221h[i2] + " : ") + this.f2216c.f2234d[this.f2219f[i2]];
            i2 = this.f2220g[i2];
            i3++;
        }
        return str;
    }
}
