package com.bumptech.glide.r.l;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object> f4385a = new C0109a();

    /* renamed from: com.bumptech.glide.r.l.a$a  reason: collision with other inner class name */
    /* compiled from: FactoryPools */
    class C0109a implements g<Object> {
        C0109a() {
        }

        @Override // com.bumptech.glide.r.l.a.g
        public void a(Object obj) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FactoryPools */
    public class b implements d<List<T>> {
        b() {
        }

        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FactoryPools */
    public class c implements g<List<T>> {
        c() {
        }

        /* renamed from: b */
        public void a(List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools */
    public interface d<T> {
        T a();
    }

    /* access modifiers changed from: private */
    /* compiled from: FactoryPools */
    public static final class e<T> implements b.h.j.e<T> {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f4386a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f4387b;

        /* renamed from: c  reason: collision with root package name */
        private final b.h.j.e<T> f4388c;

        e(b.h.j.e<T> eVar, d<T> dVar, g<T> gVar) {
            this.f4388c = eVar;
            this.f4386a = dVar;
            this.f4387b = gVar;
        }

        @Override // b.h.j.e
        public boolean a(T t) {
            if (t instanceof f) {
                t.d().b(true);
            }
            this.f4387b.a(t);
            return this.f4388c.a(t);
        }

        @Override // b.h.j.e
        public T b() {
            T b2 = this.f4388c.b();
            if (b2 == null) {
                b2 = this.f4386a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b2.getClass());
                }
            }
            if (b2 instanceof f) {
                b2.d().b(false);
            }
            return b2;
        }
    }

    /* compiled from: FactoryPools */
    public interface f {
        c d();
    }

    /* compiled from: FactoryPools */
    public interface g<T> {
        void a(T t);
    }

    private static <T extends f> b.h.j.e<T> a(b.h.j.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    private static <T> b.h.j.e<T> b(b.h.j.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) f4385a;
    }

    public static <T extends f> b.h.j.e<T> d(int i2, d<T> dVar) {
        return a(new b.h.j.g(i2), dVar);
    }

    public static <T> b.h.j.e<List<T>> e() {
        return f(20);
    }

    public static <T> b.h.j.e<List<T>> f(int i2) {
        return b(new b.h.j.g(i2), new b(), new c());
    }
}
