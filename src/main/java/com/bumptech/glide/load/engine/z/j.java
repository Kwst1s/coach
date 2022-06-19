package com.bumptech.glide.load.engine.z;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool */
public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f3893a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f3894b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f3895c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f3896d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final int f3897e;

    /* renamed from: f  reason: collision with root package name */
    private int f3898f;

    /* access modifiers changed from: private */
    /* compiled from: LruArrayPool */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f3899a;

        /* renamed from: b  reason: collision with root package name */
        int f3900b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f3901c;

        a(b bVar) {
            this.f3899a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.f3899a.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, Class<?> cls) {
            this.f3900b = i2;
            this.f3901c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3900b == aVar.f3900b && this.f3901c == aVar.f3901c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f3900b * 31;
            Class<?> cls = this.f3901c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f3900b + "array=" + this.f3901c + '}';
        }
    }

    /* compiled from: LruArrayPool */
    private static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a e(int i2, Class<?> cls) {
            a aVar = (a) b();
            aVar.b(i2, cls);
            return aVar;
        }
    }

    public j(int i2) {
        this.f3897e = i2;
    }

    private void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> m = m(cls);
        Integer num = (Integer) m.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        } else if (num.intValue() == 1) {
            m.remove(Integer.valueOf(i2));
        } else {
            m.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void g() {
        h(this.f3897e);
    }

    private void h(int i2) {
        while (this.f3898f > i2) {
            Object f2 = this.f3893a.f();
            com.bumptech.glide.r.j.d(f2);
            a i3 = i(f2);
            this.f3898f -= i3.b(f2) * i3.c();
            f(i3.b(f2), f2.getClass());
            if (Log.isLoggable(i3.a(), 2)) {
                Log.v(i3.a(), "evicted: " + i3.b(f2));
            }
        }
    }

    private <T> a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> a<T> j(Class<T> cls) {
        g gVar = (a<T>) this.f3896d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f3896d.put(cls, gVar);
        }
        return gVar;
    }

    private <T> T k(a aVar) {
        return (T) this.f3893a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        a<T> j2 = j(cls);
        T t = (T) k(aVar);
        if (t != null) {
            this.f3898f -= j2.b(t) * j2.c();
            f(j2.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(j2.a(), 2)) {
            Log.v(j2.a(), "Allocated " + aVar.f3900b + " bytes");
        }
        return j2.newArray(aVar.f3900b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f3895c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f3895c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i2 = this.f3898f;
        return i2 == 0 || this.f3897e / i2 >= 2;
    }

    private boolean o(int i2) {
        return i2 <= this.f3897e / 2;
    }

    private boolean p(int i2, Integer num) {
        return num != null && (n() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void a(int i2) {
        if (i2 >= 40) {
            try {
                b();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 >= 20 || i2 == 15) {
            h(this.f3897e / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        return (T) l(this.f3894b.e(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> void d(T t) {
        Class<?> cls = t.getClass();
        a<T> j2 = j(cls);
        int b2 = j2.b(t);
        int c2 = j2.c() * b2;
        if (o(c2)) {
            a e2 = this.f3894b.e(b2, cls);
            this.f3893a.d(e2, t);
            NavigableMap<Integer, Integer> m = m(cls);
            Integer num = (Integer) m.get(Integer.valueOf(e2.f3900b));
            Integer valueOf = Integer.valueOf(e2.f3900b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            m.put(valueOf, Integer.valueOf(i2));
            this.f3898f += c2;
            g();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T e(int i2, Class<T> cls) {
        a aVar;
        Integer ceilingKey = m(cls).ceilingKey(Integer.valueOf(i2));
        if (p(i2, ceilingKey)) {
            aVar = this.f3894b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f3894b.e(i2, cls);
        }
        return (T) l(aVar, cls);
    }
}
