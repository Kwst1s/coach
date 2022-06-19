package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintSet */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f924d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    private static SparseIntArray f925e;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, a> f926a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f927b = true;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, a> f928c = new HashMap<>();

    /* compiled from: ConstraintSet */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f929a;

        /* renamed from: b  reason: collision with root package name */
        public final C0015d f930b = new C0015d();

        /* renamed from: c  reason: collision with root package name */
        public final c f931c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f932d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f933e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, a> f934f = new HashMap<>();

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void f(int i2, ConstraintLayout.b bVar) {
            this.f929a = i2;
            b bVar2 = this.f932d;
            bVar2.f942h = bVar.f871d;
            bVar2.f943i = bVar.f872e;
            bVar2.f944j = bVar.f873f;
            bVar2.f945k = bVar.f874g;
            bVar2.l = bVar.f875h;
            bVar2.m = bVar.f876i;
            bVar2.n = bVar.f877j;
            bVar2.o = bVar.f878k;
            bVar2.p = bVar.l;
            bVar2.q = bVar.p;
            bVar2.r = bVar.q;
            bVar2.s = bVar.r;
            bVar2.t = bVar.s;
            bVar2.u = bVar.z;
            bVar2.v = bVar.A;
            bVar2.w = bVar.B;
            bVar2.x = bVar.m;
            bVar2.y = bVar.n;
            bVar2.z = bVar.o;
            bVar2.A = bVar.P;
            bVar2.B = bVar.Q;
            bVar2.C = bVar.R;
            bVar2.f941g = bVar.f870c;
            bVar2.f939e = bVar.f868a;
            bVar2.f940f = bVar.f869b;
            b bVar3 = this.f932d;
            bVar3.f937c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar3.f938d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar3.D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar3.E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar3.F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar3.G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar3.P = bVar.E;
            bVar3.Q = bVar.D;
            bVar3.S = bVar.G;
            bVar3.R = bVar.F;
            bVar3.h0 = bVar.S;
            bVar3.i0 = bVar.T;
            bVar3.T = bVar.H;
            bVar3.U = bVar.I;
            bVar3.V = bVar.L;
            bVar3.W = bVar.M;
            bVar3.X = bVar.J;
            bVar3.Y = bVar.K;
            bVar3.Z = bVar.N;
            bVar3.a0 = bVar.O;
            bVar3.g0 = bVar.U;
            bVar3.K = bVar.u;
            bVar3.M = bVar.w;
            bVar3.J = bVar.t;
            bVar3.L = bVar.v;
            b bVar4 = this.f932d;
            bVar4.O = bVar.x;
            bVar4.N = bVar.y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar4.H = bVar.getMarginEnd();
                this.f932d.I = bVar.getMarginStart();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void g(int i2, e.a aVar) {
            f(i2, aVar);
            this.f930b.f957d = aVar.o0;
            e eVar = this.f933e;
            eVar.f960b = aVar.r0;
            eVar.f961c = aVar.s0;
            eVar.f962d = aVar.t0;
            eVar.f963e = aVar.u0;
            eVar.f964f = aVar.v0;
            eVar.f965g = aVar.w0;
            eVar.f966h = aVar.x0;
            eVar.f967i = aVar.y0;
            eVar.f968j = aVar.z0;
            eVar.f969k = aVar.A0;
            eVar.m = aVar.q0;
            eVar.l = aVar.p0;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void h(b bVar, int i2, e.a aVar) {
            g(i2, aVar);
            if (bVar instanceof Barrier) {
                b bVar2 = this.f932d;
                bVar2.d0 = 1;
                Barrier barrier = (Barrier) bVar;
                bVar2.b0 = barrier.getType();
                this.f932d.e0 = barrier.getReferencedIds();
                this.f932d.c0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f932d;
            bVar.f871d = bVar2.f942h;
            bVar.f872e = bVar2.f943i;
            bVar.f873f = bVar2.f944j;
            bVar.f874g = bVar2.f945k;
            bVar.f875h = bVar2.l;
            bVar.f876i = bVar2.m;
            bVar.f877j = bVar2.n;
            bVar.f878k = bVar2.o;
            bVar.l = bVar2.p;
            bVar.p = bVar2.q;
            bVar.q = bVar2.r;
            bVar.r = bVar2.s;
            bVar.s = bVar2.t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.G;
            bVar.x = bVar2.O;
            bVar.y = bVar2.N;
            bVar.u = bVar2.K;
            bVar.w = bVar2.M;
            bVar.z = bVar2.u;
            bVar.A = bVar2.v;
            bVar.m = bVar2.x;
            bVar.n = bVar2.y;
            b bVar3 = this.f932d;
            bVar.o = bVar3.z;
            bVar.B = bVar3.w;
            bVar.P = bVar3.A;
            bVar.Q = bVar3.B;
            bVar.E = bVar3.P;
            bVar.D = bVar3.Q;
            bVar.G = bVar3.S;
            bVar.F = bVar3.R;
            bVar.S = bVar3.h0;
            bVar.T = bVar3.i0;
            bVar.H = bVar3.T;
            bVar.I = bVar3.U;
            bVar.L = bVar3.V;
            bVar.M = bVar3.W;
            bVar.J = bVar3.X;
            bVar.K = bVar3.Y;
            bVar.N = bVar3.Z;
            bVar.O = bVar3.a0;
            bVar.R = bVar3.C;
            bVar.f870c = bVar3.f941g;
            bVar.f868a = bVar3.f939e;
            bVar.f869b = bVar3.f940f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar3.f937c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar3.f938d;
            String str = bVar3.g0;
            if (str != null) {
                bVar.U = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(this.f932d.I);
                bVar.setMarginEnd(this.f932d.H);
            }
            bVar.a();
        }

        /* renamed from: e */
        public a clone() {
            a aVar = new a();
            aVar.f932d.a(this.f932d);
            aVar.f931c.a(this.f931c);
            aVar.f930b.a(this.f930b);
            aVar.f933e.a(this.f933e);
            aVar.f929a = this.f929a;
            return aVar;
        }
    }

    /* compiled from: ConstraintSet */
    public static class b {
        private static SparseIntArray k0;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public boolean f935a = false;
        public float a0 = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f936b = false;
        public int b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f937c;
        public int c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f938d;
        public int d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f939e = -1;
        public int[] e0;

        /* renamed from: f  reason: collision with root package name */
        public int f940f = -1;
        public String f0;

        /* renamed from: g  reason: collision with root package name */
        public float f941g = -1.0f;
        public String g0;

        /* renamed from: h  reason: collision with root package name */
        public int f942h = -1;
        public boolean h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f943i = -1;
        public boolean i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f944j = -1;
        public boolean j0 = true;

        /* renamed from: k  reason: collision with root package name */
        public int f945k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = Utils.FLOAT_EPSILON;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k0 = sparseIntArray;
            sparseIntArray.append(i.c3, 24);
            k0.append(i.d3, 25);
            k0.append(i.f3, 28);
            k0.append(i.g3, 29);
            k0.append(i.l3, 35);
            k0.append(i.k3, 34);
            k0.append(i.N2, 4);
            k0.append(i.M2, 3);
            k0.append(i.K2, 1);
            k0.append(i.q3, 6);
            k0.append(i.r3, 7);
            k0.append(i.U2, 17);
            k0.append(i.V2, 18);
            k0.append(i.W2, 19);
            k0.append(i.v2, 26);
            k0.append(i.h3, 31);
            k0.append(i.i3, 32);
            k0.append(i.T2, 10);
            k0.append(i.S2, 9);
            k0.append(i.u3, 13);
            k0.append(i.x3, 16);
            k0.append(i.v3, 14);
            k0.append(i.s3, 11);
            k0.append(i.w3, 15);
            k0.append(i.t3, 12);
            k0.append(i.o3, 38);
            k0.append(i.a3, 37);
            k0.append(i.Z2, 39);
            k0.append(i.n3, 40);
            k0.append(i.Y2, 20);
            k0.append(i.m3, 36);
            k0.append(i.R2, 5);
            k0.append(i.b3, 76);
            k0.append(i.j3, 76);
            k0.append(i.e3, 76);
            k0.append(i.L2, 76);
            k0.append(i.J2, 76);
            k0.append(i.y2, 23);
            k0.append(i.A2, 27);
            k0.append(i.C2, 30);
            k0.append(i.D2, 8);
            k0.append(i.z2, 33);
            k0.append(i.B2, 2);
            k0.append(i.w2, 22);
            k0.append(i.x2, 21);
            k0.append(i.O2, 61);
            k0.append(i.Q2, 62);
            k0.append(i.P2, 63);
            k0.append(i.p3, 69);
            k0.append(i.X2, 70);
            k0.append(i.H2, 71);
            k0.append(i.F2, 72);
            k0.append(i.G2, 73);
            k0.append(i.I2, 74);
            k0.append(i.E2, 75);
        }

        public void a(b bVar) {
            this.f935a = bVar.f935a;
            this.f937c = bVar.f937c;
            this.f936b = bVar.f936b;
            this.f938d = bVar.f938d;
            this.f939e = bVar.f939e;
            this.f940f = bVar.f940f;
            this.f941g = bVar.f941g;
            this.f942h = bVar.f942h;
            this.f943i = bVar.f943i;
            this.f944j = bVar.f944j;
            this.f945k = bVar.f945k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.a0 = bVar.a0;
            this.b0 = bVar.b0;
            this.c0 = bVar.c0;
            this.d0 = bVar.d0;
            this.g0 = bVar.g0;
            int[] iArr = bVar.e0;
            if (iArr != null) {
                this.e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.e0 = null;
            }
            this.f0 = bVar.f0;
            this.h0 = bVar.h0;
            this.i0 = bVar.i0;
            this.j0 = bVar.j0;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.u2);
            this.f936b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = k0.get(index);
                if (i3 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.p = d.o(obtainStyledAttributes, index, this.p);
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            this.o = d.o(obtainStyledAttributes, index, this.o);
                            continue;
                        case 4:
                            this.n = d.o(obtainStyledAttributes, index, this.n);
                            continue;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.t = d.o(obtainStyledAttributes, index, this.t);
                            continue;
                        case 10:
                            this.s = d.o(obtainStyledAttributes, index, this.s);
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.f939e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f939e);
                            continue;
                        case 18:
                            this.f940f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f940f);
                            continue;
                        case 19:
                            this.f941g = obtainStyledAttributes.getFloat(index, this.f941g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.f938d = obtainStyledAttributes.getLayoutDimension(index, this.f938d);
                            continue;
                        case 22:
                            this.f937c = obtainStyledAttributes.getLayoutDimension(index, this.f937c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            this.f942h = d.o(obtainStyledAttributes, index, this.f942h);
                            continue;
                        case 25:
                            this.f943i = d.o(obtainStyledAttributes, index, this.f943i);
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            this.f944j = d.o(obtainStyledAttributes, index, this.f944j);
                            continue;
                        case 29:
                            this.f945k = d.o(obtainStyledAttributes, index, this.f945k);
                            continue;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            this.q = d.o(obtainStyledAttributes, index, this.q);
                            continue;
                        case 32:
                            this.r = d.o(obtainStyledAttributes, index, this.r);
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            this.m = d.o(obtainStyledAttributes, index, this.m);
                            continue;
                        case 35:
                            this.l = d.o(obtainStyledAttributes, index, this.l);
                            continue;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i3) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.x = d.o(obtainStyledAttributes, index, this.x);
                                            continue;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            continue;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    continue;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    continue;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    continue;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + k0.get(index));
                                                    continue;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + k0.get(index));
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet */
    public static class c {

        /* renamed from: h  reason: collision with root package name */
        private static SparseIntArray f946h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f947a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f948b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f949c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f950d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f951e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f952f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f953g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f946h = sparseIntArray;
            sparseIntArray.append(i.B3, 1);
            f946h.append(i.D3, 2);
            f946h.append(i.E3, 3);
            f946h.append(i.A3, 4);
            f946h.append(i.z3, 5);
            f946h.append(i.C3, 6);
        }

        public void a(c cVar) {
            this.f947a = cVar.f947a;
            this.f948b = cVar.f948b;
            this.f949c = cVar.f949c;
            this.f950d = cVar.f950d;
            this.f951e = cVar.f951e;
            this.f953g = cVar.f953g;
            this.f952f = cVar.f952f;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.y3);
            this.f947a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f946h.get(index)) {
                    case 1:
                        this.f953g = obtainStyledAttributes.getFloat(index, this.f953g);
                        break;
                    case 2:
                        this.f950d = obtainStyledAttributes.getInt(index, this.f950d);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f949c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f949c = b.f.a.a.a.f2213a[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f951e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f948b = d.o(obtainStyledAttributes, index, this.f948b);
                        break;
                    case 6:
                        this.f952f = obtainStyledAttributes.getFloat(index, this.f952f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.d$d  reason: collision with other inner class name */
    /* compiled from: ConstraintSet */
    public static class C0015d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f954a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f955b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f956c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f957d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f958e = Float.NaN;

        public void a(C0015d dVar) {
            this.f954a = dVar.f954a;
            this.f955b = dVar.f955b;
            this.f957d = dVar.f957d;
            this.f958e = dVar.f958e;
            this.f956c = dVar.f956c;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.F3);
            this.f954a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.H3) {
                    this.f957d = obtainStyledAttributes.getFloat(index, this.f957d);
                } else if (index == i.G3) {
                    this.f955b = obtainStyledAttributes.getInt(index, this.f955b);
                    this.f955b = d.f924d[this.f955b];
                } else if (index == i.J3) {
                    this.f956c = obtainStyledAttributes.getInt(index, this.f956c);
                } else if (index == i.I3) {
                    this.f958e = obtainStyledAttributes.getFloat(index, this.f958e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet */
    public static class e {
        private static SparseIntArray n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f959a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f960b = Utils.FLOAT_EPSILON;

        /* renamed from: c  reason: collision with root package name */
        public float f961c = Utils.FLOAT_EPSILON;

        /* renamed from: d  reason: collision with root package name */
        public float f962d = Utils.FLOAT_EPSILON;

        /* renamed from: e  reason: collision with root package name */
        public float f963e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f964f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f965g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f966h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f967i = Utils.FLOAT_EPSILON;

        /* renamed from: j  reason: collision with root package name */
        public float f968j = Utils.FLOAT_EPSILON;

        /* renamed from: k  reason: collision with root package name */
        public float f969k = Utils.FLOAT_EPSILON;
        public boolean l = false;
        public float m = Utils.FLOAT_EPSILON;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(i.U3, 1);
            n.append(i.V3, 2);
            n.append(i.W3, 3);
            n.append(i.S3, 4);
            n.append(i.T3, 5);
            n.append(i.O3, 6);
            n.append(i.P3, 7);
            n.append(i.Q3, 8);
            n.append(i.R3, 9);
            n.append(i.X3, 10);
            n.append(i.Y3, 11);
        }

        public void a(e eVar) {
            this.f959a = eVar.f959a;
            this.f960b = eVar.f960b;
            this.f961c = eVar.f961c;
            this.f962d = eVar.f962d;
            this.f963e = eVar.f963e;
            this.f964f = eVar.f964f;
            this.f965g = eVar.f965g;
            this.f966h = eVar.f966h;
            this.f967i = eVar.f967i;
            this.f968j = eVar.f968j;
            this.f969k = eVar.f969k;
            this.l = eVar.l;
            this.m = eVar.m;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.N3);
            this.f959a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.f960b = obtainStyledAttributes.getFloat(index, this.f960b);
                        break;
                    case 2:
                        this.f961c = obtainStyledAttributes.getFloat(index, this.f961c);
                        break;
                    case 3:
                        this.f962d = obtainStyledAttributes.getFloat(index, this.f962d);
                        break;
                    case 4:
                        this.f963e = obtainStyledAttributes.getFloat(index, this.f963e);
                        break;
                    case 5:
                        this.f964f = obtainStyledAttributes.getFloat(index, this.f964f);
                        break;
                    case 6:
                        this.f965g = obtainStyledAttributes.getDimension(index, this.f965g);
                        break;
                    case 7:
                        this.f966h = obtainStyledAttributes.getDimension(index, this.f966h);
                        break;
                    case 8:
                        this.f967i = obtainStyledAttributes.getDimension(index, this.f967i);
                        break;
                    case 9:
                        this.f968j = obtainStyledAttributes.getDimension(index, this.f968j);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f969k = obtainStyledAttributes.getDimension(index, this.f969k);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.l = true;
                            this.m = obtainStyledAttributes.getDimension(index, this.m);
                            break;
                        } else {
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f925e = sparseIntArray;
        sparseIntArray.append(i.d0, 25);
        f925e.append(i.e0, 26);
        f925e.append(i.g0, 29);
        f925e.append(i.h0, 30);
        f925e.append(i.n0, 36);
        f925e.append(i.m0, 35);
        f925e.append(i.L, 4);
        f925e.append(i.K, 3);
        f925e.append(i.I, 1);
        f925e.append(i.v0, 6);
        f925e.append(i.w0, 7);
        f925e.append(i.S, 17);
        f925e.append(i.T, 18);
        f925e.append(i.U, 19);
        f925e.append(i.f975b, 27);
        f925e.append(i.i0, 32);
        f925e.append(i.j0, 33);
        f925e.append(i.R, 10);
        f925e.append(i.Q, 9);
        f925e.append(i.z0, 13);
        f925e.append(i.C0, 16);
        f925e.append(i.A0, 14);
        f925e.append(i.x0, 11);
        f925e.append(i.B0, 15);
        f925e.append(i.y0, 12);
        f925e.append(i.q0, 40);
        f925e.append(i.b0, 39);
        f925e.append(i.a0, 41);
        f925e.append(i.p0, 42);
        f925e.append(i.Z, 20);
        f925e.append(i.o0, 37);
        f925e.append(i.P, 5);
        f925e.append(i.c0, 82);
        f925e.append(i.l0, 82);
        f925e.append(i.f0, 82);
        f925e.append(i.J, 82);
        f925e.append(i.H, 82);
        f925e.append(i.f980g, 24);
        f925e.append(i.f982i, 28);
        f925e.append(i.u, 31);
        f925e.append(i.v, 8);
        f925e.append(i.f981h, 34);
        f925e.append(i.f983j, 2);
        f925e.append(i.f978e, 23);
        f925e.append(i.f979f, 21);
        f925e.append(i.f977d, 22);
        f925e.append(i.f984k, 43);
        f925e.append(i.x, 44);
        f925e.append(i.s, 45);
        f925e.append(i.t, 46);
        f925e.append(i.r, 60);
        f925e.append(i.p, 47);
        f925e.append(i.q, 48);
        f925e.append(i.l, 49);
        f925e.append(i.m, 50);
        f925e.append(i.n, 51);
        f925e.append(i.o, 52);
        f925e.append(i.w, 53);
        f925e.append(i.r0, 54);
        f925e.append(i.V, 55);
        f925e.append(i.s0, 56);
        f925e.append(i.W, 57);
        f925e.append(i.t0, 58);
        f925e.append(i.X, 59);
        f925e.append(i.M, 61);
        f925e.append(i.O, 62);
        f925e.append(i.N, 63);
        f925e.append(i.y, 64);
        f925e.append(i.G0, 65);
        f925e.append(i.E, 66);
        f925e.append(i.H0, 67);
        f925e.append(i.E0, 79);
        f925e.append(i.f976c, 38);
        f925e.append(i.D0, 68);
        f925e.append(i.u0, 69);
        f925e.append(i.Y, 70);
        f925e.append(i.C, 71);
        f925e.append(i.A, 72);
        f925e.append(i.B, 73);
        f925e.append(i.D, 74);
        f925e.append(i.z, 75);
        f925e.append(i.F0, 76);
        f925e.append(i.k0, 77);
        f925e.append(i.I0, 78);
        f925e.append(i.G, 80);
        f925e.append(i.F, 81);
    }

    private int[] j(View view, String str) {
        int i2;
        Object g2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = h.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (g2 = ((ConstraintLayout) view.getParent()).g(0, trim)) != null && (g2 instanceof Integer)) {
                i2 = ((Integer) g2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private a k(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f974a);
        p(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a l(int i2) {
        if (!this.f928c.containsKey(Integer.valueOf(i2))) {
            this.f928c.put(Integer.valueOf(i2), new a());
        }
        return this.f928c.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: private */
    public static int o(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private void p(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (!(index == i.f976c || i.u == index || i.v == index)) {
                aVar.f931c.f947a = true;
                aVar.f932d.f936b = true;
                aVar.f930b.f954a = true;
                aVar.f933e.f959a = true;
            }
            switch (f925e.get(index)) {
                case 1:
                    b bVar = aVar.f932d;
                    bVar.p = o(typedArray, index, bVar.p);
                    break;
                case 2:
                    b bVar2 = aVar.f932d;
                    bVar2.G = typedArray.getDimensionPixelSize(index, bVar2.G);
                    break;
                case 3:
                    b bVar3 = aVar.f932d;
                    bVar3.o = o(typedArray, index, bVar3.o);
                    break;
                case 4:
                    b bVar4 = aVar.f932d;
                    bVar4.n = o(typedArray, index, bVar4.n);
                    break;
                case 5:
                    aVar.f932d.w = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f932d;
                    bVar5.A = typedArray.getDimensionPixelOffset(index, bVar5.A);
                    break;
                case 7:
                    b bVar6 = aVar.f932d;
                    bVar6.B = typedArray.getDimensionPixelOffset(index, bVar6.B);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f932d;
                        bVar7.H = typedArray.getDimensionPixelSize(index, bVar7.H);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    b bVar8 = aVar.f932d;
                    bVar8.t = o(typedArray, index, bVar8.t);
                    break;
                case 10:
                    b bVar9 = aVar.f932d;
                    bVar9.s = o(typedArray, index, bVar9.s);
                    break;
                case 11:
                    b bVar10 = aVar.f932d;
                    bVar10.M = typedArray.getDimensionPixelSize(index, bVar10.M);
                    break;
                case 12:
                    b bVar11 = aVar.f932d;
                    bVar11.N = typedArray.getDimensionPixelSize(index, bVar11.N);
                    break;
                case 13:
                    b bVar12 = aVar.f932d;
                    bVar12.J = typedArray.getDimensionPixelSize(index, bVar12.J);
                    break;
                case 14:
                    b bVar13 = aVar.f932d;
                    bVar13.L = typedArray.getDimensionPixelSize(index, bVar13.L);
                    break;
                case 15:
                    b bVar14 = aVar.f932d;
                    bVar14.O = typedArray.getDimensionPixelSize(index, bVar14.O);
                    break;
                case 16:
                    b bVar15 = aVar.f932d;
                    bVar15.K = typedArray.getDimensionPixelSize(index, bVar15.K);
                    break;
                case 17:
                    b bVar16 = aVar.f932d;
                    bVar16.f939e = typedArray.getDimensionPixelOffset(index, bVar16.f939e);
                    break;
                case 18:
                    b bVar17 = aVar.f932d;
                    bVar17.f940f = typedArray.getDimensionPixelOffset(index, bVar17.f940f);
                    break;
                case 19:
                    b bVar18 = aVar.f932d;
                    bVar18.f941g = typedArray.getFloat(index, bVar18.f941g);
                    break;
                case 20:
                    b bVar19 = aVar.f932d;
                    bVar19.u = typedArray.getFloat(index, bVar19.u);
                    break;
                case 21:
                    b bVar20 = aVar.f932d;
                    bVar20.f938d = typedArray.getLayoutDimension(index, bVar20.f938d);
                    break;
                case 22:
                    C0015d dVar = aVar.f930b;
                    dVar.f955b = typedArray.getInt(index, dVar.f955b);
                    C0015d dVar2 = aVar.f930b;
                    dVar2.f955b = f924d[dVar2.f955b];
                    break;
                case 23:
                    b bVar21 = aVar.f932d;
                    bVar21.f937c = typedArray.getLayoutDimension(index, bVar21.f937c);
                    break;
                case 24:
                    b bVar22 = aVar.f932d;
                    bVar22.D = typedArray.getDimensionPixelSize(index, bVar22.D);
                    break;
                case 25:
                    b bVar23 = aVar.f932d;
                    bVar23.f942h = o(typedArray, index, bVar23.f942h);
                    break;
                case 26:
                    b bVar24 = aVar.f932d;
                    bVar24.f943i = o(typedArray, index, bVar24.f943i);
                    break;
                case 27:
                    b bVar25 = aVar.f932d;
                    bVar25.C = typedArray.getInt(index, bVar25.C);
                    break;
                case 28:
                    b bVar26 = aVar.f932d;
                    bVar26.E = typedArray.getDimensionPixelSize(index, bVar26.E);
                    break;
                case 29:
                    b bVar27 = aVar.f932d;
                    bVar27.f944j = o(typedArray, index, bVar27.f944j);
                    break;
                case 30:
                    b bVar28 = aVar.f932d;
                    bVar28.f945k = o(typedArray, index, bVar28.f945k);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f932d;
                        bVar29.I = typedArray.getDimensionPixelSize(index, bVar29.I);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    b bVar30 = aVar.f932d;
                    bVar30.q = o(typedArray, index, bVar30.q);
                    break;
                case 33:
                    b bVar31 = aVar.f932d;
                    bVar31.r = o(typedArray, index, bVar31.r);
                    break;
                case 34:
                    b bVar32 = aVar.f932d;
                    bVar32.F = typedArray.getDimensionPixelSize(index, bVar32.F);
                    break;
                case 35:
                    b bVar33 = aVar.f932d;
                    bVar33.m = o(typedArray, index, bVar33.m);
                    break;
                case 36:
                    b bVar34 = aVar.f932d;
                    bVar34.l = o(typedArray, index, bVar34.l);
                    break;
                case 37:
                    b bVar35 = aVar.f932d;
                    bVar35.v = typedArray.getFloat(index, bVar35.v);
                    break;
                case 38:
                    aVar.f929a = typedArray.getResourceId(index, aVar.f929a);
                    break;
                case 39:
                    b bVar36 = aVar.f932d;
                    bVar36.Q = typedArray.getFloat(index, bVar36.Q);
                    break;
                case 40:
                    b bVar37 = aVar.f932d;
                    bVar37.P = typedArray.getFloat(index, bVar37.P);
                    break;
                case 41:
                    b bVar38 = aVar.f932d;
                    bVar38.R = typedArray.getInt(index, bVar38.R);
                    break;
                case 42:
                    b bVar39 = aVar.f932d;
                    bVar39.S = typedArray.getInt(index, bVar39.S);
                    break;
                case 43:
                    C0015d dVar3 = aVar.f930b;
                    dVar3.f957d = typedArray.getFloat(index, dVar3.f957d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f933e;
                        eVar.l = true;
                        eVar.m = typedArray.getDimension(index, eVar.m);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    e eVar2 = aVar.f933e;
                    eVar2.f961c = typedArray.getFloat(index, eVar2.f961c);
                    break;
                case 46:
                    e eVar3 = aVar.f933e;
                    eVar3.f962d = typedArray.getFloat(index, eVar3.f962d);
                    break;
                case 47:
                    e eVar4 = aVar.f933e;
                    eVar4.f963e = typedArray.getFloat(index, eVar4.f963e);
                    break;
                case 48:
                    e eVar5 = aVar.f933e;
                    eVar5.f964f = typedArray.getFloat(index, eVar5.f964f);
                    break;
                case 49:
                    e eVar6 = aVar.f933e;
                    eVar6.f965g = typedArray.getDimension(index, eVar6.f965g);
                    break;
                case 50:
                    e eVar7 = aVar.f933e;
                    eVar7.f966h = typedArray.getDimension(index, eVar7.f966h);
                    break;
                case 51:
                    e eVar8 = aVar.f933e;
                    eVar8.f967i = typedArray.getDimension(index, eVar8.f967i);
                    break;
                case 52:
                    e eVar9 = aVar.f933e;
                    eVar9.f968j = typedArray.getDimension(index, eVar9.f968j);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f933e;
                        eVar10.f969k = typedArray.getDimension(index, eVar10.f969k);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    b bVar40 = aVar.f932d;
                    bVar40.T = typedArray.getInt(index, bVar40.T);
                    break;
                case 55:
                    b bVar41 = aVar.f932d;
                    bVar41.U = typedArray.getInt(index, bVar41.U);
                    break;
                case 56:
                    b bVar42 = aVar.f932d;
                    bVar42.V = typedArray.getDimensionPixelSize(index, bVar42.V);
                    break;
                case 57:
                    b bVar43 = aVar.f932d;
                    bVar43.W = typedArray.getDimensionPixelSize(index, bVar43.W);
                    break;
                case 58:
                    b bVar44 = aVar.f932d;
                    bVar44.X = typedArray.getDimensionPixelSize(index, bVar44.X);
                    break;
                case 59:
                    b bVar45 = aVar.f932d;
                    bVar45.Y = typedArray.getDimensionPixelSize(index, bVar45.Y);
                    break;
                case 60:
                    e eVar11 = aVar.f933e;
                    eVar11.f960b = typedArray.getFloat(index, eVar11.f960b);
                    break;
                case 61:
                    b bVar46 = aVar.f932d;
                    bVar46.x = o(typedArray, index, bVar46.x);
                    break;
                case 62:
                    b bVar47 = aVar.f932d;
                    bVar47.y = typedArray.getDimensionPixelSize(index, bVar47.y);
                    break;
                case 63:
                    b bVar48 = aVar.f932d;
                    bVar48.z = typedArray.getFloat(index, bVar48.z);
                    break;
                case 64:
                    c cVar = aVar.f931c;
                    cVar.f948b = o(typedArray, index, cVar.f948b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f931c.f949c = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f931c.f949c = b.f.a.a.a.f2213a[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f931c.f951e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f931c;
                    cVar2.f953g = typedArray.getFloat(index, cVar2.f953g);
                    break;
                case 68:
                    C0015d dVar4 = aVar.f930b;
                    dVar4.f958e = typedArray.getFloat(index, dVar4.f958e);
                    break;
                case 69:
                    aVar.f932d.Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f932d.a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f932d;
                    bVar49.b0 = typedArray.getInt(index, bVar49.b0);
                    break;
                case 73:
                    b bVar50 = aVar.f932d;
                    bVar50.c0 = typedArray.getDimensionPixelSize(index, bVar50.c0);
                    break;
                case 74:
                    aVar.f932d.f0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f932d;
                    bVar51.j0 = typedArray.getBoolean(index, bVar51.j0);
                    break;
                case 76:
                    c cVar3 = aVar.f931c;
                    cVar3.f950d = typedArray.getInt(index, cVar3.f950d);
                    break;
                case 77:
                    aVar.f932d.g0 = typedArray.getString(index);
                    break;
                case 78:
                    C0015d dVar5 = aVar.f930b;
                    dVar5.f956c = typedArray.getInt(index, dVar5.f956c);
                    break;
                case 79:
                    c cVar4 = aVar.f931c;
                    cVar4.f952f = typedArray.getFloat(index, cVar4.f952f);
                    break;
                case 80:
                    b bVar52 = aVar.f932d;
                    bVar52.h0 = typedArray.getBoolean(index, bVar52.h0);
                    break;
                case 81:
                    b bVar53 = aVar.f932d;
                    bVar53.i0 = typedArray.getBoolean(index, bVar53.i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f925e.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f925e.get(index));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f928c.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f928c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + b.f.a.b.a.a(childAt));
            } else if (this.f927b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.f928c.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = this.f928c.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        aVar.f932d.d0 = 1;
                    }
                    int i3 = aVar.f932d.d0;
                    if (i3 != -1 && i3 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(aVar.f932d.b0);
                        barrier.setMargin(aVar.f932d.c0);
                        barrier.setAllowsGoneWidget(aVar.f932d.j0);
                        b bVar = aVar.f932d;
                        int[] iArr = bVar.e0;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = bVar.f0;
                            if (str != null) {
                                bVar.e0 = j(barrier, str);
                                barrier.setReferencedIds(aVar.f932d.e0);
                            }
                        }
                    }
                    ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                    bVar2.a();
                    aVar.d(bVar2);
                    if (z) {
                        a.c(childAt, aVar.f934f);
                    }
                    childAt.setLayoutParams(bVar2);
                    C0015d dVar = aVar.f930b;
                    if (dVar.f956c == 0) {
                        childAt.setVisibility(dVar.f955b);
                    }
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 17) {
                        childAt.setAlpha(aVar.f930b.f957d);
                        childAt.setRotation(aVar.f933e.f960b);
                        childAt.setRotationX(aVar.f933e.f961c);
                        childAt.setRotationY(aVar.f933e.f962d);
                        childAt.setScaleX(aVar.f933e.f963e);
                        childAt.setScaleY(aVar.f933e.f964f);
                        if (!Float.isNaN(aVar.f933e.f965g)) {
                            childAt.setPivotX(aVar.f933e.f965g);
                        }
                        if (!Float.isNaN(aVar.f933e.f966h)) {
                            childAt.setPivotY(aVar.f933e.f966h);
                        }
                        childAt.setTranslationX(aVar.f933e.f967i);
                        childAt.setTranslationY(aVar.f933e.f968j);
                        if (i4 >= 21) {
                            childAt.setTranslationZ(aVar.f933e.f969k);
                            e eVar = aVar.f933e;
                            if (eVar.l) {
                                childAt.setElevation(eVar.m);
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f928c.get(num);
            int i5 = aVar2.f932d.d0;
            if (i5 != -1 && i5 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f932d;
                int[] iArr2 = bVar3.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f0;
                    if (str2 != null) {
                        bVar3.e0 = j(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f932d.e0);
                    }
                }
                barrier2.setType(aVar2.f932d.b0);
                barrier2.setMargin(aVar2.f932d.c0);
                ConstraintLayout.b e2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.n();
                aVar2.d(e2);
                constraintLayout.addView(barrier2, e2);
            }
            if (aVar2.f932d.f935a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b e3 = constraintLayout.generateDefaultLayoutParams();
                aVar2.d(e3);
                constraintLayout.addView(guideline, e3);
            }
        }
    }

    public void e(int i2, int i3) {
        if (this.f928c.containsKey(Integer.valueOf(i2))) {
            a aVar = this.f928c.get(Integer.valueOf(i2));
            switch (i3) {
                case 1:
                    b bVar = aVar.f932d;
                    bVar.f943i = -1;
                    bVar.f942h = -1;
                    bVar.D = -1;
                    bVar.J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f932d;
                    bVar2.f945k = -1;
                    bVar2.f944j = -1;
                    bVar2.E = -1;
                    bVar2.L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f932d;
                    bVar3.m = -1;
                    bVar3.l = -1;
                    bVar3.F = -1;
                    bVar3.K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f932d;
                    bVar4.n = -1;
                    bVar4.o = -1;
                    bVar4.G = -1;
                    bVar4.M = -1;
                    return;
                case 5:
                    aVar.f932d.p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f932d;
                    bVar5.q = -1;
                    bVar5.r = -1;
                    bVar5.I = -1;
                    bVar5.O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f932d;
                    bVar6.s = -1;
                    bVar6.t = -1;
                    bVar6.H = -1;
                    bVar6.N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i2) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f928c.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f927b || id != -1) {
                if (!this.f928c.containsKey(Integer.valueOf(id))) {
                    this.f928c.put(Integer.valueOf(id), new a());
                }
                a aVar = this.f928c.get(Integer.valueOf(id));
                aVar.f934f = a.a(this.f926a, childAt);
                aVar.f(id, bVar);
                aVar.f930b.f955b = childAt.getVisibility();
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 17) {
                    aVar.f930b.f957d = childAt.getAlpha();
                    aVar.f933e.f960b = childAt.getRotation();
                    aVar.f933e.f961c = childAt.getRotationX();
                    aVar.f933e.f962d = childAt.getRotationY();
                    aVar.f933e.f963e = childAt.getScaleX();
                    aVar.f933e.f964f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == Utils.DOUBLE_EPSILON && ((double) pivotY) == Utils.DOUBLE_EPSILON)) {
                        e eVar = aVar.f933e;
                        eVar.f965g = pivotX;
                        eVar.f966h = pivotY;
                    }
                    aVar.f933e.f967i = childAt.getTranslationX();
                    aVar.f933e.f968j = childAt.getTranslationY();
                    if (i3 >= 21) {
                        aVar.f933e.f969k = childAt.getTranslationZ();
                        e eVar2 = aVar.f933e;
                        if (eVar2.l) {
                            eVar2.m = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f932d.j0 = barrier.o();
                    aVar.f932d.e0 = barrier.getReferencedIds();
                    aVar.f932d.b0 = barrier.getType();
                    aVar.f932d.c0 = barrier.getMargin();
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void h(e eVar) {
        int childCount = eVar.getChildCount();
        this.f928c.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = eVar.getChildAt(i2);
            e.a aVar = (e.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f927b || id != -1) {
                if (!this.f928c.containsKey(Integer.valueOf(id))) {
                    this.f928c.put(Integer.valueOf(id), new a());
                }
                a aVar2 = this.f928c.get(Integer.valueOf(id));
                if (childAt instanceof b) {
                    aVar2.h((b) childAt, id, aVar);
                }
                aVar2.g(id, aVar);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void i(int i2, int i3, int i4, float f2) {
        b bVar = l(i2).f932d;
        bVar.x = i3;
        bVar.y = i4;
        bVar.z = f2;
    }

    public void m(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a k2 = k(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        k2.f932d.f935a = true;
                    }
                    this.f928c.put(Integer.valueOf(k2.f929a), k2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        if (r0.equals("PropertySet") != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0179, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.n(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
