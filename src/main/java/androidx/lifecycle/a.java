package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache */
class a {

    /* renamed from: c  reason: collision with root package name */
    static a f1454c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, C0021a> f1455a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1456b = new HashMap();

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    public static class C0021a {

        /* renamed from: a  reason: collision with root package name */
        final Map<e.a, List<b>> f1457a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, e.a> f1458b;

        C0021a(Map<b, e.a> map) {
            this.f1458b = map;
            for (Map.Entry<b, e.a> entry : map.entrySet()) {
                e.a value = entry.getValue();
                List<b> list = this.f1457a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f1457a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, i iVar, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(iVar, aVar, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar, e.a aVar, Object obj) {
            b(this.f1457a.get(aVar), iVar, aVar, obj);
            b(this.f1457a.get(e.a.ON_ANY), iVar, aVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f1459a;

        /* renamed from: b  reason: collision with root package name */
        final Method f1460b;

        b(int i2, Method method) {
            this.f1459a = i2;
            this.f1460b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar, e.a aVar, Object obj) {
            try {
                int i2 = this.f1459a;
                if (i2 == 0) {
                    this.f1460b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1460b.invoke(obj, iVar);
                } else if (i2 == 2) {
                    this.f1460b.invoke(obj, iVar, aVar);
                }
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1459a != bVar.f1459a || !this.f1460b.getName().equals(bVar.f1460b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f1459a * 31) + this.f1460b.getName().hashCode();
        }
    }

    a() {
    }

    private C0021a a(Class<?> cls, Method[] methodArr) {
        int i2;
        C0021a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c2 = c(superclass)) == null)) {
            hashMap.putAll(c2.f1458b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, e.a> entry : c(cls2).f1458b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(i.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                e.a value = pVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == e.a.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0021a aVar = new C0021a(hashMap);
        this.f1455a.put(cls, aVar);
        this.f1456b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<b, e.a> map, b bVar, e.a aVar, Class<?> cls) {
        e.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f1460b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public C0021a c(Class<?> cls) {
        C0021a aVar = this.f1455a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f1456b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((p) method.getAnnotation(p.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f1456b.put(cls, Boolean.FALSE);
        return false;
    }
}
