package com.bumptech.glide.load.engine;

import com.bumptech.glide.d;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.o.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: DecodeHelper */
public final class g<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f3730a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f3731b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private d f3732c;

    /* renamed from: d  reason: collision with root package name */
    private Object f3733d;

    /* renamed from: e  reason: collision with root package name */
    private int f3734e;

    /* renamed from: f  reason: collision with root package name */
    private int f3735f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f3736g;

    /* renamed from: h  reason: collision with root package name */
    private h.e f3737h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.load.h f3738i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, l<?>> f3739j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f3740k;
    private boolean l;
    private boolean m;
    private f n;
    private com.bumptech.glide.f o;
    private j p;
    private boolean q;
    private boolean r;

    g() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f3732c = null;
        this.f3733d = null;
        this.n = null;
        this.f3736g = null;
        this.f3740k = null;
        this.f3738i = null;
        this.o = null;
        this.f3739j = null;
        this.p = null;
        this.f3730a.clear();
        this.l = false;
        this.f3731b.clear();
        this.m = false;
    }

    /* access modifiers changed from: package-private */
    public b b() {
        return this.f3732c.b();
    }

    /* access modifiers changed from: package-private */
    public List<f> c() {
        if (!this.m) {
            this.m = true;
            this.f3731b.clear();
            List<n.a<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = g2.get(i2);
                if (!this.f3731b.contains(aVar.f4020a)) {
                    this.f3731b.add(aVar.f4020a);
                }
                for (int i3 = 0; i3 < aVar.f4021b.size(); i3++) {
                    if (!this.f3731b.contains(aVar.f4021b.get(i3))) {
                        this.f3731b.add(aVar.f4021b.get(i3));
                    }
                }
            }
        }
        return this.f3731b;
    }

    /* access modifiers changed from: package-private */
    public a d() {
        return this.f3737h.a();
    }

    /* access modifiers changed from: package-private */
    public j e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f3735f;
    }

    /* access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f3730a.clear();
            List i2 = this.f3732c.h().i(this.f3733d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                n.a<?> a2 = ((n) i2.get(i3)).a(this.f3733d, this.f3734e, this.f3735f, this.f3738i);
                if (a2 != null) {
                    this.f3730a.add(a2);
                }
            }
        }
        return this.f3730a;
    }

    /* access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f3732c.h().h(cls, this.f3736g, this.f3740k);
    }

    /* access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f3733d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<n<File, ?>> j(File file) {
        return this.f3732c.h().i(file);
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.load.h k() {
        return this.f3738i;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.f l() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f3732c.h().j(this.f3733d.getClass(), this.f3736g, this.f3740k);
    }

    /* access modifiers changed from: package-private */
    public <Z> k<Z> n(u<Z> uVar) {
        return this.f3732c.h().k(uVar);
    }

    /* access modifiers changed from: package-private */
    public f o() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.d<X> p(X x) {
        return this.f3732c.h().m(x);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    /* access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.f3740k;
    }

    /* access modifiers changed from: package-private */
    public <Z> l<Z> r(Class<Z> cls) {
        l<Z> lVar = (l<Z>) this.f3739j.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, l<?>>> it = this.f3739j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (l<Z>) next.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f3739j.isEmpty() || !this.q) {
            return c.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f3734e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public <R> void u(d dVar, Object obj, f fVar, int i2, int i3, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, com.bumptech.glide.load.h hVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, h.e eVar) {
        this.f3732c = dVar;
        this.f3733d = obj;
        this.n = fVar;
        this.f3734e = i2;
        this.f3735f = i3;
        this.p = jVar;
        this.f3736g = cls;
        this.f3737h = eVar;
        this.f3740k = cls2;
        this.o = fVar2;
        this.f3738i = hVar;
        this.f3739j = map;
        this.q = z;
        this.r = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean v(u<?> uVar) {
        return this.f3732c.h().n(uVar);
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public boolean x(f fVar) {
        List<n.a<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).f4020a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
