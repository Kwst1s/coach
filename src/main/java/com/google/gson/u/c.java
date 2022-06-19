package com.google.gson.u;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, com.google.gson.h<?>> f8334a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.u.n.b f8335b = com.google.gson.u.n.b.a();

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class a implements h<T> {
        a(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class b implements h<T> {
        b(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.gson.u.c$c  reason: collision with other inner class name */
    /* compiled from: ConstructorConstructor */
    public class C0167c implements h<T> {
        C0167c(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class d implements h<T> {
        d(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new g();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class e implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final l f8336a = l.b();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f8337b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f8338c;

        e(c cVar, Class cls, Type type) {
            this.f8337b = cls;
            this.f8338c = type;
        }

        @Override // com.google.gson.u.h
        public T a() {
            try {
                return (T) this.f8336a.c(this.f8337b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f8338c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* compiled from: ConstructorConstructor */
    class f implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.h f8339a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f8340b;

        f(c cVar, com.google.gson.h hVar, Type type) {
            this.f8339a = hVar;
            this.f8340b = type;
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) this.f8339a.a(this.f8340b);
        }
    }

    /* compiled from: ConstructorConstructor */
    class g implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.h f8341a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f8342b;

        g(c cVar, com.google.gson.h hVar, Type type) {
            this.f8341a = hVar;
            this.f8342b = type;
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) this.f8341a.a(this.f8342b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class h implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f8343a;

        h(c cVar, Constructor constructor) {
            this.f8343a = constructor;
        }

        @Override // com.google.gson.u.h
        public T a() {
            try {
                return (T) this.f8343a.newInstance(null);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.f8343a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.f8343a + " with no args", e3.getTargetException());
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class i implements h<T> {
        i(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class j implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f8344a;

        j(c cVar, Type type) {
            this.f8344a = type;
        }

        @Override // com.google.gson.u.h
        public T a() {
            Type type = this.f8344a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f8344a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f8344a.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class k implements h<T> {
        k(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class l implements h<T> {
        l(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class m implements h<T> {
        m(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor */
    public class n implements h<T> {
        n(c cVar) {
        }

        @Override // com.google.gson.u.h
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.h<?>> map) {
        this.f8334a = map;
    }

    private <T> h<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f8335b.b(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> h<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new b(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.v.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                return new d(this);
            }
            return new C0167c(this);
        }
    }

    private <T> h<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public <T> h<T> a(com.google.gson.v.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c2 = aVar.c();
        com.google.gson.h<?> hVar = this.f8334a.get(e2);
        if (hVar != null) {
            return new f(this, hVar, e2);
        }
        com.google.gson.h<?> hVar2 = this.f8334a.get(c2);
        if (hVar2 != null) {
            return new g(this, hVar2, e2);
        }
        h<T> b2 = b(c2);
        if (b2 != null) {
            return b2;
        }
        h<T> c3 = c(e2, c2);
        if (c3 != null) {
            return c3;
        }
        return d(e2, c2);
    }

    public String toString() {
        return this.f8334a.toString();
    }
}
