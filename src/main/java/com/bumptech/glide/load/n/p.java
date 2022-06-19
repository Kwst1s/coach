package com.bumptech.glide.load.n;

import b.h.j.e;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f4023a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4024b;

    /* access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0099a<?>> f4025a = new HashMap();

        /* access modifiers changed from: private */
        /* renamed from: com.bumptech.glide.load.n.p$a$a  reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        public static class C0099a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f4026a;

            public C0099a(List<n<Model, ?>> list) {
                this.f4026a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f4025a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0099a<?> aVar = this.f4025a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f4026a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f4025a.put(cls, new C0099a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(e<List<Throwable>> eVar) {
        this(new r(eVar));
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    private synchronized <A> List<n<A, ?>> e(Class<A> cls) {
        List<n<A, ?>> b2;
        b2 = this.f4024b.b(cls);
        if (b2 == null) {
            b2 = Collections.unmodifiableList(this.f4023a.e(cls));
            this.f4024b.c(cls, b2);
        }
        return b2;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f4023a.b(cls, cls2, oVar);
        this.f4024b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f4023a.g(cls);
    }

    public <A> List<n<A, ?>> d(A a2) {
        List<n<A, ?>> e2 = e(b(a2));
        if (!e2.isEmpty()) {
            int size = e2.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                n<A, ?> nVar = e2.get(i2);
                if (nVar.b(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a2, e2);
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    private p(r rVar) {
        this.f4024b = new a();
        this.f4023a = rVar;
    }
}
