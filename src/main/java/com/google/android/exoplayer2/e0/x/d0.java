package com.google.android.exoplayer2.e0.x;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: TsExtractor */
public final class d0 implements g {
    private static final long s = ((long) com.google.android.exoplayer2.util.d0.B("AC-3"));
    private static final long t = ((long) com.google.android.exoplayer2.util.d0.B("EAC3"));
    private static final long u = ((long) com.google.android.exoplayer2.util.d0.B("HEVC"));

    /* renamed from: a  reason: collision with root package name */
    private final int f5422a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a0> f5423b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5424c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f5425d;

    /* renamed from: e  reason: collision with root package name */
    private final e0.c f5426e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<e0> f5427f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseBooleanArray f5428g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseBooleanArray f5429h;

    /* renamed from: i  reason: collision with root package name */
    private final c0 f5430i;

    /* renamed from: j  reason: collision with root package name */
    private b0 f5431j;

    /* renamed from: k  reason: collision with root package name */
    private i f5432k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private e0 p;
    private int q;
    private int r;

    /* access modifiers changed from: private */
    /* compiled from: TsExtractor */
    public class a implements x {

        /* renamed from: a  reason: collision with root package name */
        private final r f5433a = new r(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.e0.x.x
        public void b(a0 a0Var, i iVar, e0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.e0.x.x
        public void c(s sVar) {
            if (sVar.y() == 0) {
                sVar.L(7);
                int a2 = sVar.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    sVar.g(this.f5433a, 4);
                    int h2 = this.f5433a.h(16);
                    this.f5433a.p(3);
                    if (h2 == 0) {
                        this.f5433a.p(13);
                    } else {
                        int h3 = this.f5433a.h(13);
                        d0.this.f5427f.put(h3, new y(new b(h3)));
                        d0.k(d0.this);
                    }
                }
                if (d0.this.f5422a != 2) {
                    d0.this.f5427f.remove(0);
                }
            }
        }
    }

    /* compiled from: TsExtractor */
    private class b implements x {

        /* renamed from: a  reason: collision with root package name */
        private final r f5435a = new r(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<e0> f5436b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f5437c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f5438d;

        public b(int i2) {
            this.f5438d = i2;
        }

        private e0.b a(s sVar, int i2) {
            int c2 = sVar.c();
            int i3 = i2 + c2;
            String str = null;
            ArrayList arrayList = null;
            int i4 = -1;
            while (sVar.c() < i3) {
                int y = sVar.y();
                int c3 = sVar.c() + sVar.y();
                if (y == 5) {
                    long A = sVar.A();
                    if (A != d0.s) {
                        if (A != d0.t) {
                            if (A == d0.u) {
                                i4 = 36;
                            }
                            sVar.L(c3 - sVar.c());
                        }
                        i4 = 135;
                        sVar.L(c3 - sVar.c());
                    }
                } else if (y != 106) {
                    if (y != 122) {
                        if (y == 123) {
                            i4 = 138;
                        } else if (y == 10) {
                            str = sVar.v(3).trim();
                        } else if (y == 89) {
                            arrayList = new ArrayList();
                            while (sVar.c() < c3) {
                                String trim = sVar.v(3).trim();
                                int y2 = sVar.y();
                                byte[] bArr = new byte[4];
                                sVar.h(bArr, 0, 4);
                                arrayList.add(new e0.a(trim, y2, bArr));
                            }
                            i4 = 89;
                        }
                        sVar.L(c3 - sVar.c());
                    }
                    i4 = 135;
                    sVar.L(c3 - sVar.c());
                }
                i4 = 129;
                sVar.L(c3 - sVar.c());
            }
            sVar.K(i3);
            return new e0.b(i4, str, arrayList, Arrays.copyOfRange(sVar.f7062a, c2, i3));
        }

        @Override // com.google.android.exoplayer2.e0.x.x
        public void b(a0 a0Var, i iVar, e0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.e0.x.x
        public void c(s sVar) {
            a0 a0Var;
            e0 e0Var;
            if (sVar.y() == 2) {
                int i2 = 0;
                if (d0.this.f5422a == 1 || d0.this.f5422a == 2 || d0.this.l == 1) {
                    a0Var = (a0) d0.this.f5423b.get(0);
                } else {
                    a0Var = new a0(((a0) d0.this.f5423b.get(0)).c());
                    d0.this.f5423b.add(a0Var);
                }
                sVar.L(2);
                int E = sVar.E();
                int i3 = 3;
                sVar.L(3);
                sVar.g(this.f5435a, 2);
                this.f5435a.p(3);
                int i4 = 13;
                d0.this.r = this.f5435a.h(13);
                sVar.g(this.f5435a, 2);
                int i5 = 4;
                this.f5435a.p(4);
                sVar.L(this.f5435a.h(12));
                if (d0.this.f5422a == 2 && d0.this.p == null) {
                    e0.b bVar = new e0.b(21, null, null, com.google.android.exoplayer2.util.d0.f7011f);
                    d0 d0Var = d0.this;
                    d0Var.p = d0Var.f5426e.b(21, bVar);
                    d0.this.p.b(a0Var, d0.this.f5432k, new e0.d(E, 21, 8192));
                }
                this.f5436b.clear();
                this.f5437c.clear();
                int a2 = sVar.a();
                while (a2 > 0) {
                    sVar.g(this.f5435a, 5);
                    int h2 = this.f5435a.h(8);
                    this.f5435a.p(i3);
                    int h3 = this.f5435a.h(i4);
                    this.f5435a.p(i5);
                    int h4 = this.f5435a.h(12);
                    e0.b a3 = a(sVar, h4);
                    if (h2 == 6) {
                        h2 = a3.f5447a;
                    }
                    a2 -= h4 + 5;
                    int i6 = d0.this.f5422a == 2 ? h2 : h3;
                    if (!d0.this.f5428g.get(i6)) {
                        if (d0.this.f5422a == 2 && h2 == 21) {
                            e0Var = d0.this.p;
                        } else {
                            e0Var = d0.this.f5426e.b(h2, a3);
                        }
                        if (d0.this.f5422a != 2 || h3 < this.f5437c.get(i6, 8192)) {
                            this.f5437c.put(i6, h3);
                            this.f5436b.put(i6, e0Var);
                        }
                    }
                    i3 = 3;
                    i5 = 4;
                    i4 = 13;
                }
                int size = this.f5437c.size();
                for (int i7 = 0; i7 < size; i7++) {
                    int keyAt = this.f5437c.keyAt(i7);
                    int valueAt = this.f5437c.valueAt(i7);
                    d0.this.f5428g.put(keyAt, true);
                    d0.this.f5429h.put(valueAt, true);
                    e0 valueAt2 = this.f5436b.valueAt(i7);
                    if (valueAt2 != null) {
                        if (valueAt2 != d0.this.p) {
                            valueAt2.b(a0Var, d0.this.f5432k, new e0.d(E, keyAt, 8192));
                        }
                        d0.this.f5427f.put(valueAt, valueAt2);
                    }
                }
                if (d0.this.f5422a != 2) {
                    d0.this.f5427f.remove(this.f5438d);
                    d0 d0Var2 = d0.this;
                    if (d0Var2.f5422a != 1) {
                        i2 = d0.this.l - 1;
                    }
                    d0Var2.l = i2;
                    if (d0.this.l == 0) {
                        d0.this.f5432k.h();
                        d0.this.m = true;
                    }
                } else if (!d0.this.m) {
                    d0.this.f5432k.h();
                    d0.this.l = 0;
                    d0.this.m = true;
                }
            }
        }
    }

    static {
        d dVar = d.f5421a;
    }

    public d0() {
        this(0);
    }

    private void A(long j2) {
        if (!this.n) {
            this.n = true;
            if (this.f5430i.b() != -9223372036854775807L) {
                b0 b0Var = new b0(this.f5430i.c(), this.f5430i.b(), j2, this.r);
                this.f5431j = b0Var;
                this.f5432k.e(b0Var.b());
                return;
            }
            this.f5432k.e(new o.b(this.f5430i.b()));
        }
    }

    private void B() {
        this.f5428g.clear();
        this.f5427f.clear();
        SparseArray<e0> a2 = this.f5426e.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5427f.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f5427f.put(0, new y(new a()));
        this.p = null;
    }

    private boolean C(int i2) {
        if (this.f5422a == 2 || this.m || !this.f5429h.get(i2, false)) {
            return true;
        }
        return false;
    }

    static /* synthetic */ int k(d0 d0Var) {
        int i2 = d0Var.l;
        d0Var.l = i2 + 1;
        return i2;
    }

    private boolean x(h hVar) {
        s sVar = this.f5424c;
        byte[] bArr = sVar.f7062a;
        if (9400 - sVar.c() < 188) {
            int a2 = this.f5424c.a();
            if (a2 > 0) {
                System.arraycopy(bArr, this.f5424c.c(), bArr, 0, a2);
            }
            this.f5424c.I(bArr, a2);
        }
        while (this.f5424c.a() < 188) {
            int d2 = this.f5424c.d();
            int a3 = hVar.a(bArr, d2, 9400 - d2);
            if (a3 == -1) {
                return false;
            }
            this.f5424c.J(d2 + a3);
        }
        return true;
    }

    private int y() {
        int c2 = this.f5424c.c();
        int d2 = this.f5424c.d();
        int a2 = f0.a(this.f5424c.f7062a, c2, d2);
        this.f5424c.K(a2);
        int i2 = a2 + 188;
        if (i2 > d2) {
            int i3 = this.q + (a2 - c2);
            this.q = i3;
            if (this.f5422a == 2 && i3 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.q = 0;
        }
        return i2;
    }

    static /* synthetic */ g[] z() {
        return new g[]{new d0()};
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5432k = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        b0 b0Var;
        e.f(this.f5422a != 2);
        int size = this.f5423b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a0 a0Var = this.f5423b.get(i2);
            if ((a0Var.e() == -9223372036854775807L) || !(a0Var.e() == 0 || a0Var.c() == j3)) {
                a0Var.g();
                a0Var.h(j3);
            }
        }
        if (!(j3 == 0 || (b0Var = this.f5431j) == null)) {
            b0Var.h(j3);
        }
        this.f5424c.G();
        this.f5425d.clear();
        for (int i3 = 0; i3 < this.f5427f.size(); i3++) {
            this.f5427f.valueAt(i3).a();
        }
        this.q = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        boolean z;
        byte[] bArr = this.f5424c.f7062a;
        hVar.j(bArr, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z = true;
                    break;
                } else if (bArr[(i3 * 188) + i2] != 71) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                hVar.f(i2);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        long d2 = hVar.d();
        e0 e0Var = null;
        if (this.m) {
            if (((d2 == -1 || this.f5422a == 2) ? false : true) && !this.f5430i.d()) {
                return this.f5430i.e(hVar, nVar, this.r);
            }
            A(d2);
            if (this.o) {
                this.o = false;
                e(0, 0);
                if (hVar.l() != 0) {
                    nVar.f5095a = 0;
                    return 1;
                }
            }
            b0 b0Var = this.f5431j;
            if (b0Var != null && b0Var.d()) {
                return this.f5431j.c(hVar, nVar, null);
            }
        }
        if (!x(hVar)) {
            return -1;
        }
        int y = y();
        int d3 = this.f5424c.d();
        if (y > d3) {
            return 0;
        }
        int j2 = this.f5424c.j();
        if ((8388608 & j2) != 0) {
            this.f5424c.K(y);
            return 0;
        }
        boolean z = (4194304 & j2) != 0;
        int i2 = (2096896 & j2) >> 8;
        boolean z2 = (j2 & 32) != 0;
        if ((j2 & 16) != 0) {
            e0Var = this.f5427f.get(i2);
        }
        if (e0Var == null) {
            this.f5424c.K(y);
            return 0;
        }
        if (this.f5422a != 2) {
            int i3 = j2 & 15;
            int i4 = this.f5425d.get(i2, i3 - 1);
            this.f5425d.put(i2, i3);
            if (i4 == i3) {
                this.f5424c.K(y);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                e0Var.a();
            }
        }
        if (z2) {
            this.f5424c.L(this.f5424c.y());
        }
        boolean z3 = this.m;
        if (C(i2)) {
            this.f5424c.J(y);
            e0Var.c(this.f5424c, z);
            this.f5424c.J(d3);
        }
        if (this.f5422a != 2 && !z3 && this.m && d2 != -1) {
            this.o = true;
        }
        this.f5424c.K(y);
        return 0;
    }

    public d0(int i2) {
        this(1, i2);
    }

    public d0(int i2, int i3) {
        this(i2, new a0(0), new i(i3));
    }

    public d0(int i2, a0 a0Var, e0.c cVar) {
        e.e(cVar);
        this.f5426e = cVar;
        this.f5422a = i2;
        if (i2 == 1 || i2 == 2) {
            this.f5423b = Collections.singletonList(a0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f5423b = arrayList;
            arrayList.add(a0Var);
        }
        this.f5424c = new s(new byte[9400], 0);
        this.f5428g = new SparseBooleanArray();
        this.f5429h = new SparseBooleanArray();
        this.f5427f = new SparseArray<>();
        this.f5425d = new SparseIntArray();
        this.f5430i = new c0();
        this.r = -1;
        B();
    }
}
