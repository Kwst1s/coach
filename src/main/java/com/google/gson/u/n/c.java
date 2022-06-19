package com.google.gson.u.n;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor */
final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    private static Class f8456d;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8457b = d();

    /* renamed from: c  reason: collision with root package name */
    private final Field f8458c = c();

    c() {
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f8456d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.u.n.b
    public void b(AccessibleObject accessibleObject) {
        if (!e(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e(AccessibleObject accessibleObject) {
        if (!(this.f8457b == null || this.f8458c == null)) {
            try {
                long longValue = ((Long) f8456d.getMethod("objectFieldOffset", Field.class).invoke(this.f8457b, this.f8458c)).longValue();
                f8456d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f8457b, accessibleObject, Long.valueOf(longValue), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
