package com.bumptech.glide.load.n;

import b.h.j.e;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.r.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory */
public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f4036e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f4037f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f4038a;

    /* renamed from: b  reason: collision with root package name */
    private final c f4039b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f4040c;

    /* renamed from: d  reason: collision with root package name */
    private final e<List<Throwable>> f4041d;

    /* compiled from: MultiModelLoaderFactory */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.n.n
        public n.a<Object> a(Object obj, int i2, int i3, h hVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.n.n
        public boolean b(Object obj) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f4042a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f4043b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f4044c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f4042a = cls;
            this.f4043b = cls2;
            this.f4044c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.f4042a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f4043b.isAssignableFrom(cls2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MultiModelLoaderFactory */
    public static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, e<List<Throwable>> eVar) {
            return new q<>(list, eVar);
        }
    }

    public r(e<List<Throwable>> eVar) {
        this(eVar, f4036e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f4038a;
        list.add(z ? list.size() : 0, bVar);
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: com.bumptech.glide.load.n.n<? extends Model, ? extends Data>, com.bumptech.glide.load.n.n<Model, Data> */
    private <Model, Data> n<Model, Data> c(b<?, ?> bVar) {
        n b2 = bVar.f4044c.b(this);
        j.d(b2);
        return (n<? extends Model, ? extends Data>) b2;
    }

    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f4037f;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f4038a) {
                if (this.f4040c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f4040c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f4040c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4039b.a(arrayList, this.f4041d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f4040c.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f4038a) {
                if (!this.f4040c.contains(bVar)) {
                    if (bVar.a(cls)) {
                        this.f4040c.add(bVar);
                        arrayList.add(c(bVar));
                        this.f4040c.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.f4040c.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f4038a) {
            if (!arrayList.contains(bVar.f4043b) && bVar.a(cls)) {
                arrayList.add(bVar.f4043b);
            }
        }
        return arrayList;
    }

    r(e<List<Throwable>> eVar, c cVar) {
        this.f4038a = new ArrayList();
        this.f4040c = new HashSet();
        this.f4041d = eVar;
        this.f4039b = cVar;
    }
}
