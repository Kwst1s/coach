package b.h.e;

import android.graphics.Path;
import android.util.Log;
import androidx.constraintlayout.widget.i;
import b.a.j;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* compiled from: PathParser */
public class c {

    /* access modifiers changed from: private */
    /* compiled from: PathParser */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2476a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2477b;

        a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] fArr) {
        arrayList.add(new b(c2, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (!(bVarArr[i2].f2478a == bVarArr2[i2].f2478a && bVarArr[i2].f2479b.length == bVarArr2[i2].f2479b.length)) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i(str, i2);
            String trim = str.substring(i3, i4).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i3 = i4;
            i2 = i4 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d2 = d(str);
        if (d2 == null) {
            return null;
        }
        try {
            b.e(d2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(java.lang.String r8, int r9, b.h.e.c.a r10) {
        /*
            r0 = 0
            r10.f2477b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0035
            r6 = 69
            if (r5 == r6) goto L_0x0033
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0033
            switch(r5) {
                case 44: goto L_0x0035;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0031
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0037
        L_0x0027:
            r10.f2477b = r7
            goto L_0x0035
        L_0x002a:
            if (r1 == r9) goto L_0x0031
            if (r2 != 0) goto L_0x0031
            r10.f2477b = r7
            goto L_0x0035
        L_0x0031:
            r2 = 0
            goto L_0x0037
        L_0x0033:
            r2 = 1
            goto L_0x0037
        L_0x0035:
            r2 = 0
            r4 = 1
        L_0x0037:
            if (r4 == 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003d:
            r10.f2476a = r1
            return
            switch-data {44->0x0035, 45->0x002a, 46->0x0022, }
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.e.c.g(java.lang.String, int, b.h.e.c$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                g(str, i2, aVar);
                int i4 = aVar.f2476a;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = aVar.f2477b ? i4 : i4 + 1;
            }
            return c(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    private static int i(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i2 = 0; i2 < bVarArr2.length; i2++) {
            bVarArr[i2].f2478a = bVarArr2[i2].f2478a;
            for (int i3 = 0; i3 < bVarArr2[i2].f2479b.length; i3++) {
                bVarArr[i2].f2479b[i3] = bVarArr2[i2].f2479b[i3];
            }
        }
    }

    /* compiled from: PathParser */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f2478a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f2479b;

        b(char c2, float[] fArr) {
            this.f2478a = c2;
            this.f2479b = fArr;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            char c4 = c3;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c4) {
                case 'A':
                case i.x0:
                    i2 = 7;
                    break;
                case 'C':
                case i.z0:
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case i.E0:
                case j.C0:
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case i.H0:
                case i.I0:
                case j.A0:
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case j.z0:
                    i2 = 4;
                    break;
                case 'Z':
                case j.G0:
                    path.close();
                    path.moveTo(f14, f15);
                    f10 = f14;
                    f12 = f10;
                    f11 = f15;
                    f13 = f11;
                    i2 = 2;
                    break;
            }
            float f16 = f10;
            float f17 = f11;
            float f18 = f14;
            float f19 = f15;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                        f16 = fArr2[i7];
                        float f20 = fArr2[i8];
                        float f21 = fArr2[i5];
                        float f22 = fArr2[i6];
                        f17 = f20;
                        f13 = f22;
                        f12 = f21;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f17);
                        f16 = fArr2[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                        float f23 = fArr2[i10];
                        float f24 = fArr2[i11];
                        f16 = fArr2[i12];
                        f17 = fArr2[i13];
                        f12 = f23;
                        f13 = f24;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f16, fArr2[i14]);
                        f17 = fArr2[i14];
                    } else if (c4 != 'a') {
                        if (c4 == 'c') {
                            int i15 = i4 + 2;
                            int i16 = i4 + 3;
                            int i17 = i4 + 4;
                            int i18 = i4 + 5;
                            path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                            f3 = fArr2[i15] + f16;
                            f2 = fArr2[i16] + f17;
                            f16 += fArr2[i17];
                            f4 = fArr2[i18];
                            f17 += f4;
                            f12 = f3;
                            f13 = f2;
                        } else if (c4 != 'h') {
                            if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i19 = i4 + 0;
                                    path.rLineTo(Utils.FLOAT_EPSILON, fArr2[i19]);
                                    f5 = fArr2[i19];
                                } else if (c4 != 'L') {
                                    if (c4 == 'M') {
                                        int i20 = i4 + 0;
                                        f16 = fArr2[i20];
                                        int i21 = i4 + 1;
                                        f17 = fArr2[i21];
                                        if (i4 > 0) {
                                            path.lineTo(fArr2[i20], fArr2[i21]);
                                        } else {
                                            path.moveTo(fArr2[i20], fArr2[i21]);
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f16 = (f16 * 2.0f) - f12;
                                            f17 = (f17 * 2.0f) - f13;
                                        }
                                        int i22 = i4 + 0;
                                        int i23 = i4 + 1;
                                        int i24 = i4 + 2;
                                        int i25 = i4 + 3;
                                        path.cubicTo(f16, f17, fArr2[i22], fArr2[i23], fArr2[i24], fArr2[i25]);
                                        f3 = fArr2[i22];
                                        f2 = fArr2[i23];
                                        f16 = fArr2[i24];
                                        f17 = fArr2[i25];
                                        f12 = f3;
                                        f13 = f2;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f16 = (f16 * 2.0f) - f12;
                                            f17 = (f17 * 2.0f) - f13;
                                        }
                                        int i26 = i4 + 0;
                                        int i27 = i4 + 1;
                                        path.quadTo(f16, f17, fArr2[i26], fArr2[i27]);
                                        float f25 = fArr2[i26];
                                        float f26 = fArr2[i27];
                                        i3 = i4;
                                        f13 = f17;
                                        f12 = f16;
                                        f16 = f25;
                                        f17 = f26;
                                    } else if (c4 == 'l') {
                                        int i28 = i4 + 0;
                                        int i29 = i4 + 1;
                                        path.rLineTo(fArr2[i28], fArr2[i29]);
                                        f16 += fArr2[i28];
                                        f5 = fArr2[i29];
                                    } else if (c4 == 'm') {
                                        int i30 = i4 + 0;
                                        f16 += fArr2[i30];
                                        int i31 = i4 + 1;
                                        f17 += fArr2[i31];
                                        if (i4 > 0) {
                                            path.rLineTo(fArr2[i30], fArr2[i31]);
                                        } else {
                                            path.rMoveTo(fArr2[i30], fArr2[i31]);
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f27 = f16 - f12;
                                            f6 = f17 - f13;
                                            f7 = f27;
                                        } else {
                                            f7 = Utils.FLOAT_EPSILON;
                                            f6 = Utils.FLOAT_EPSILON;
                                        }
                                        int i32 = i4 + 0;
                                        int i33 = i4 + 1;
                                        int i34 = i4 + 2;
                                        int i35 = i4 + 3;
                                        path.rCubicTo(f7, f6, fArr2[i32], fArr2[i33], fArr2[i34], fArr2[i35]);
                                        f3 = fArr2[i32] + f16;
                                        f2 = fArr2[i33] + f17;
                                        f16 += fArr2[i34];
                                        f4 = fArr2[i35];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f8 = f16 - f12;
                                            f9 = f17 - f13;
                                        } else {
                                            f9 = Utils.FLOAT_EPSILON;
                                            f8 = Utils.FLOAT_EPSILON;
                                        }
                                        int i36 = i4 + 0;
                                        int i37 = i4 + 1;
                                        path.rQuadTo(f8, f9, fArr2[i36], fArr2[i37]);
                                        float f28 = f8 + f16;
                                        float f29 = f9 + f17;
                                        f16 += fArr2[i36];
                                        f17 += fArr2[i37];
                                        f13 = f29;
                                        f12 = f28;
                                    }
                                    i3 = i4;
                                    f19 = f17;
                                    f18 = f16;
                                } else {
                                    int i38 = i4 + 0;
                                    int i39 = i4 + 1;
                                    path.lineTo(fArr2[i38], fArr2[i39]);
                                    f16 = fArr2[i38];
                                    f17 = fArr2[i39];
                                }
                                f17 += f5;
                            } else {
                                int i40 = i4 + 0;
                                int i41 = i4 + 1;
                                int i42 = i4 + 2;
                                int i43 = i4 + 3;
                                path.rQuadTo(fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                                f3 = fArr2[i40] + f16;
                                f2 = fArr2[i41] + f17;
                                f16 += fArr2[i42];
                                f4 = fArr2[i43];
                            }
                            f17 += f4;
                            f12 = f3;
                            f13 = f2;
                        } else {
                            int i44 = i4 + 0;
                            path.rLineTo(fArr2[i44], Utils.FLOAT_EPSILON);
                            f16 += fArr2[i44];
                        }
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        int i46 = i4 + 6;
                        i3 = i4;
                        c(path, f16, f17, fArr2[i45] + f16, fArr2[i46] + f17, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != Utils.FLOAT_EPSILON, fArr2[i4 + 4] != Utils.FLOAT_EPSILON);
                        f16 += fArr2[i45];
                        f17 += fArr2[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    c(path, f16, f17, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != Utils.FLOAT_EPSILON, fArr2[i3 + 4] != Utils.FLOAT_EPSILON);
                    f16 = fArr2[i47];
                    f17 = fArr2[i48];
                }
                f13 = f17;
                f12 = f16;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f16;
            fArr[1] = f17;
            fArr[2] = f12;
            fArr[3] = f13;
            fArr[4] = f18;
            fArr[5] = f19;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = (double) ceil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i2 = 0;
            double d24 = d6;
            double d25 = d7;
            while (i2 < ceil) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d28 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d29 = (d13 * sin3) - (d14 * cos3);
                double d30 = (sin3 * d16) + (cos3 * d17);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sin4 = (Math.sin(d31) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
                path.cubicTo((float) (d24 + (d23 * sin4)), (float) (d25 + (d22 * sin4)), (float) (d27 - (sin4 * d29)), (float) (d28 - (sin4 * d30)), (float) d27, (float) d28);
                i2++;
                d20 = d20;
                sin = sin;
                d24 = d27;
                d16 = d16;
                cos = cos;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                ceil = ceil;
                d25 = d28;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f2;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = (double) f3;
            Double.isNaN(d6);
            double d7 = (double) f6;
            Double.isNaN(d7);
            double d8 = (d5 + (d6 * sin)) / d7;
            double d9 = (double) (-f2);
            Double.isNaN(d9);
            Double.isNaN(d6);
            double d10 = (double) f7;
            Double.isNaN(d10);
            double d11 = ((d9 * sin) + (d6 * cos)) / d10;
            double d12 = (double) f4;
            Double.isNaN(d12);
            double d13 = (double) f5;
            Double.isNaN(d13);
            Double.isNaN(d7);
            double d14 = ((d12 * cos) + (d13 * sin)) / d7;
            double d15 = (double) (-f4);
            Double.isNaN(d15);
            Double.isNaN(d13);
            Double.isNaN(d10);
            double d16 = ((d15 * sin) + (d13 * cos)) / d10;
            double d17 = d8 - d14;
            double d18 = d11 - d16;
            double d19 = (d8 + d14) / 2.0d;
            double d20 = (d11 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == Utils.DOUBLE_EPSILON) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < Utils.DOUBLE_EPSILON) {
                Log.w("PathParser", "Points are too far apart " + d21);
                float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                c(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d22);
            double d23 = d17 * sqrt2;
            double d24 = sqrt2 * d18;
            if (z == z2) {
                d3 = d19 - d24;
                d2 = d20 + d23;
            } else {
                d3 = d19 + d24;
                d2 = d20 - d23;
            }
            double atan2 = Math.atan2(d11 - d2, d8 - d3);
            double atan22 = Math.atan2(d16 - d2, d14 - d3) - atan2;
            if (z2 != (atan22 >= Utils.DOUBLE_EPSILON)) {
                atan22 = atan22 > Utils.DOUBLE_EPSILON ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d7);
            double d25 = d3 * d7;
            Double.isNaN(d10);
            double d26 = d2 * d10;
            b(path, (d25 * cos) - (d26 * sin), (d25 * sin) + (d26 * cos), d7, d10, d4, d6, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                a(path, fArr, c2, bVarArr[i2].f2478a, bVarArr[i2].f2479b);
                c2 = bVarArr[i2].f2478a;
            }
        }

        public void d(b bVar, b bVar2, float f2) {
            this.f2478a = bVar.f2478a;
            int i2 = 0;
            while (true) {
                float[] fArr = bVar.f2479b;
                if (i2 < fArr.length) {
                    this.f2479b[i2] = (fArr[i2] * (1.0f - f2)) + (bVar2.f2479b[i2] * f2);
                    i2++;
                } else {
                    return;
                }
            }
        }

        b(b bVar) {
            this.f2478a = bVar.f2478a;
            float[] fArr = bVar.f2479b;
            this.f2479b = c.c(fArr, 0, fArr.length);
        }
    }
}
