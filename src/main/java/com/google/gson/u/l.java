package com.google.gson.u;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: UnsafeAllocator */
public abstract class l {

    /* access modifiers changed from: package-private */
    /* compiled from: UnsafeAllocator */
    public class a extends l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f8384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f8385b;

        a(Method method, Object obj) {
            this.f8384a = method;
            this.f8385b = obj;
        }

        @Override // com.google.gson.u.l
        public <T> T c(Class<T> cls) {
            l.a(cls);
            return (T) this.f8384a.invoke(this.f8385b, cls);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: UnsafeAllocator */
    public class b extends l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f8386a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8387b;

        b(Method method, int i2) {
            this.f8386a = method;
            this.f8387b = i2;
        }

        @Override // com.google.gson.u.l
        public <T> T c(Class<T> cls) {
            l.a(cls);
            return (T) this.f8386a.invoke(null, cls, Integer.valueOf(this.f8387b));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: UnsafeAllocator */
    public class c extends l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f8388a;

        c(Method method) {
            this.f8388a = method;
        }

        @Override // com.google.gson.u.l
        public <T> T c(Class<T> cls) {
            l.a(cls);
            return (T) this.f8388a.invoke(null, cls, Object.class);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: UnsafeAllocator */
    public class d extends l {
        d() {
        }

        @Override // com.google.gson.u.l
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static l b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract <T> T c(Class<T> cls);
}
