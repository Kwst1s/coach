package com.bumptech.glide.p;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.f;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.o.g.c;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.p.a;
import com.bumptech.glide.r.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.Map;

/* compiled from: BaseRequestOptions */
public abstract class a<T extends a<T>> implements Cloneable {
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    private int f4291b;

    /* renamed from: c  reason: collision with root package name */
    private float f4292c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private j f4293d = j.f3780c;

    /* renamed from: e  reason: collision with root package name */
    private f f4294e = f.NORMAL;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f4295f;

    /* renamed from: g  reason: collision with root package name */
    private int f4296g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f4297h;

    /* renamed from: i  reason: collision with root package name */
    private int f4298i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4299j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f4300k = -1;
    private int l = -1;
    private com.bumptech.glide.load.f m = com.bumptech.glide.q.a.c();
    private boolean n;
    private boolean o = true;
    private Drawable p;
    private int q;
    private h r = new h();
    private Map<Class<?>, l<?>> s = new b();
    private Class<?> t = Object.class;
    private boolean u;
    private Resources.Theme v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z = true;

    private boolean D(int i2) {
        return E(this.f4291b, i2);
    }

    private static boolean E(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private T N(k kVar, l<Bitmap> lVar) {
        return R(kVar, lVar, false);
    }

    private T R(k kVar, l<Bitmap> lVar, boolean z2) {
        T t2;
        if (z2) {
            t2 = a0(kVar, lVar);
        } else {
            t2 = O(kVar, lVar);
        }
        t2.z = true;
        return t2;
    }

    private T S() {
        return this;
    }

    private T T() {
        if (!this.u) {
            S();
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final boolean A() {
        return this.f4299j;
    }

    public final boolean B() {
        return D(8);
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.z;
    }

    public final boolean F() {
        return this.o;
    }

    public final boolean G() {
        return this.n;
    }

    public final boolean H() {
        return D(2048);
    }

    public final boolean I() {
        return com.bumptech.glide.r.k.r(this.l, this.f4300k);
    }

    public T J() {
        this.u = true;
        S();
        return this;
    }

    public T K() {
        return O(k.f4189c, new i());
    }

    public T L() {
        return N(k.f4188b, new com.bumptech.glide.load.resource.bitmap.j());
    }

    public T M() {
        return N(k.f4187a, new p());
    }

    /* access modifiers changed from: package-private */
    public final T O(k kVar, l<Bitmap> lVar) {
        if (this.w) {
            return (T) clone().O(kVar, lVar);
        }
        f(kVar);
        return Z(lVar, false);
    }

    public T P(int i2, int i3) {
        if (this.w) {
            return (T) clone().P(i2, i3);
        }
        this.l = i2;
        this.f4300k = i3;
        this.f4291b |= 512;
        T();
        return this;
    }

    public T Q(f fVar) {
        if (this.w) {
            return (T) clone().Q(fVar);
        }
        com.bumptech.glide.r.j.d(fVar);
        this.f4294e = fVar;
        this.f4291b |= 8;
        T();
        return this;
    }

    public <Y> T U(g<Y> gVar, Y y2) {
        if (this.w) {
            return (T) clone().U(gVar, y2);
        }
        com.bumptech.glide.r.j.d(gVar);
        com.bumptech.glide.r.j.d(y2);
        this.r.e(gVar, y2);
        T();
        return this;
    }

    public T V(com.bumptech.glide.load.f fVar) {
        if (this.w) {
            return (T) clone().V(fVar);
        }
        com.bumptech.glide.r.j.d(fVar);
        this.m = fVar;
        this.f4291b |= 1024;
        T();
        return this;
    }

    public T W(float f2) {
        if (this.w) {
            return (T) clone().W(f2);
        }
        if (f2 < Utils.FLOAT_EPSILON || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f4292c = f2;
        this.f4291b |= 2;
        T();
        return this;
    }

    public T X(boolean z2) {
        if (this.w) {
            return (T) clone().X(true);
        }
        this.f4299j = !z2;
        this.f4291b |= 256;
        T();
        return this;
    }

    public T Y(l<Bitmap> lVar) {
        return Z(lVar, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bumptech.glide.load.l<android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public T Z(l<Bitmap> lVar, boolean z2) {
        if (this.w) {
            return (T) clone().Z(lVar, z2);
        }
        n nVar = new n(lVar, z2);
        b0(Bitmap.class, lVar, z2);
        b0(Drawable.class, nVar, z2);
        nVar.c();
        b0(BitmapDrawable.class, nVar, z2);
        b0(c.class, new com.bumptech.glide.load.o.g.f(lVar), z2);
        T();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.w) {
            return (T) clone().a(aVar);
        }
        if (E(aVar.f4291b, 2)) {
            this.f4292c = aVar.f4292c;
        }
        if (E(aVar.f4291b, 262144)) {
            this.x = aVar.x;
        }
        if (E(aVar.f4291b, 1048576)) {
            this.A = aVar.A;
        }
        if (E(aVar.f4291b, 4)) {
            this.f4293d = aVar.f4293d;
        }
        if (E(aVar.f4291b, 8)) {
            this.f4294e = aVar.f4294e;
        }
        if (E(aVar.f4291b, 16)) {
            this.f4295f = aVar.f4295f;
            this.f4296g = 0;
            this.f4291b &= -33;
        }
        if (E(aVar.f4291b, 32)) {
            this.f4296g = aVar.f4296g;
            this.f4295f = null;
            this.f4291b &= -17;
        }
        if (E(aVar.f4291b, 64)) {
            this.f4297h = aVar.f4297h;
            this.f4298i = 0;
            this.f4291b &= -129;
        }
        if (E(aVar.f4291b, 128)) {
            this.f4298i = aVar.f4298i;
            this.f4297h = null;
            this.f4291b &= -65;
        }
        if (E(aVar.f4291b, 256)) {
            this.f4299j = aVar.f4299j;
        }
        if (E(aVar.f4291b, 512)) {
            this.l = aVar.l;
            this.f4300k = aVar.f4300k;
        }
        if (E(aVar.f4291b, 1024)) {
            this.m = aVar.m;
        }
        if (E(aVar.f4291b, 4096)) {
            this.t = aVar.t;
        }
        if (E(aVar.f4291b, 8192)) {
            this.p = aVar.p;
            this.q = 0;
            this.f4291b &= -16385;
        }
        if (E(aVar.f4291b, 16384)) {
            this.q = aVar.q;
            this.p = null;
            this.f4291b &= -8193;
        }
        if (E(aVar.f4291b, 32768)) {
            this.v = aVar.v;
        }
        if (E(aVar.f4291b, 65536)) {
            this.o = aVar.o;
        }
        if (E(aVar.f4291b, 131072)) {
            this.n = aVar.n;
        }
        if (E(aVar.f4291b, 2048)) {
            this.s.putAll(aVar.s);
            this.z = aVar.z;
        }
        if (E(aVar.f4291b, 524288)) {
            this.y = aVar.y;
        }
        if (!this.o) {
            this.s.clear();
            int i2 = this.f4291b & -2049;
            this.f4291b = i2;
            this.n = false;
            this.f4291b = i2 & -131073;
            this.z = true;
        }
        this.f4291b |= aVar.f4291b;
        this.r.d(aVar.r);
        T();
        return this;
    }

    /* access modifiers changed from: package-private */
    public final T a0(k kVar, l<Bitmap> lVar) {
        if (this.w) {
            return (T) clone().a0(kVar, lVar);
        }
        f(kVar);
        return Y(lVar);
    }

    public T b() {
        if (!this.u || this.w) {
            this.w = true;
            J();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* access modifiers changed from: package-private */
    public <Y> T b0(Class<Y> cls, l<Y> lVar, boolean z2) {
        if (this.w) {
            return (T) clone().b0(cls, lVar, z2);
        }
        com.bumptech.glide.r.j.d(cls);
        com.bumptech.glide.r.j.d(lVar);
        this.s.put(cls, lVar);
        int i2 = this.f4291b | 2048;
        this.f4291b = i2;
        this.o = true;
        int i3 = i2 | 65536;
        this.f4291b = i3;
        this.z = false;
        if (z2) {
            this.f4291b = i3 | 131072;
            this.n = true;
        }
        T();
        return this;
    }

    /* renamed from: c */
    public T clone() {
        try {
            T t2 = (T) ((a) super.clone());
            h hVar = new h();
            t2.r = hVar;
            hVar.d(this.r);
            b bVar = new b();
            t2.s = bVar;
            bVar.putAll(this.s);
            t2.u = false;
            t2.w = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T c0(boolean z2) {
        if (this.w) {
            return (T) clone().c0(z2);
        }
        this.A = z2;
        this.f4291b |= 1048576;
        T();
        return this;
    }

    public T d(Class<?> cls) {
        if (this.w) {
            return (T) clone().d(cls);
        }
        com.bumptech.glide.r.j.d(cls);
        this.t = cls;
        this.f4291b |= 4096;
        T();
        return this;
    }

    public T e(j jVar) {
        if (this.w) {
            return (T) clone().e(jVar);
        }
        com.bumptech.glide.r.j.d(jVar);
        this.f4293d = jVar;
        this.f4291b |= 4;
        T();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.f4292c, this.f4292c) == 0 && this.f4296g == aVar.f4296g && com.bumptech.glide.r.k.c(this.f4295f, aVar.f4295f) && this.f4298i == aVar.f4298i && com.bumptech.glide.r.k.c(this.f4297h, aVar.f4297h) && this.q == aVar.q && com.bumptech.glide.r.k.c(this.p, aVar.p) && this.f4299j == aVar.f4299j && this.f4300k == aVar.f4300k && this.l == aVar.l && this.n == aVar.n && this.o == aVar.o && this.x == aVar.x && this.y == aVar.y && this.f4293d.equals(aVar.f4293d) && this.f4294e == aVar.f4294e && this.r.equals(aVar.r) && this.s.equals(aVar.s) && this.t.equals(aVar.t) && com.bumptech.glide.r.k.c(this.m, aVar.m) && com.bumptech.glide.r.k.c(this.v, aVar.v)) {
            return true;
        }
        return false;
    }

    public T f(k kVar) {
        com.bumptech.glide.r.j.d(kVar);
        return U((g<Y>) k.f4192f, kVar);
    }

    public final j g() {
        return this.f4293d;
    }

    public final int h() {
        return this.f4296g;
    }

    public int hashCode() {
        return com.bumptech.glide.r.k.m(this.v, com.bumptech.glide.r.k.m(this.m, com.bumptech.glide.r.k.m(this.t, com.bumptech.glide.r.k.m(this.s, com.bumptech.glide.r.k.m(this.r, com.bumptech.glide.r.k.m(this.f4294e, com.bumptech.glide.r.k.m(this.f4293d, com.bumptech.glide.r.k.n(this.y, com.bumptech.glide.r.k.n(this.x, com.bumptech.glide.r.k.n(this.o, com.bumptech.glide.r.k.n(this.n, com.bumptech.glide.r.k.l(this.l, com.bumptech.glide.r.k.l(this.f4300k, com.bumptech.glide.r.k.n(this.f4299j, com.bumptech.glide.r.k.m(this.p, com.bumptech.glide.r.k.l(this.q, com.bumptech.glide.r.k.m(this.f4297h, com.bumptech.glide.r.k.l(this.f4298i, com.bumptech.glide.r.k.m(this.f4295f, com.bumptech.glide.r.k.l(this.f4296g, com.bumptech.glide.r.k.j(this.f4292c)))))))))))))))))))));
    }

    public final Drawable i() {
        return this.f4295f;
    }

    public final Drawable j() {
        return this.p;
    }

    public final int k() {
        return this.q;
    }

    public final boolean m() {
        return this.y;
    }

    public final h n() {
        return this.r;
    }

    public final int o() {
        return this.f4300k;
    }

    public final int p() {
        return this.l;
    }

    public final Drawable q() {
        return this.f4297h;
    }

    public final int r() {
        return this.f4298i;
    }

    public final f s() {
        return this.f4294e;
    }

    public final Class<?> t() {
        return this.t;
    }

    public final com.bumptech.glide.load.f u() {
        return this.m;
    }

    public final float v() {
        return this.f4292c;
    }

    public final Resources.Theme w() {
        return this.v;
    }

    public final Map<Class<?>, l<?>> x() {
        return this.s;
    }

    public final boolean y() {
        return this.A;
    }

    public final boolean z() {
        return this.x;
    }
}
