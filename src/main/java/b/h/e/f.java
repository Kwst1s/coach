package b.h.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b.e.g;
import b.h.d.e.c;
import b.h.h.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
class f extends j {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f2487b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f2488c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f2489d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f2490e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method2 = null;
            method = null;
        }
        f2488c = constructor;
        f2487b = cls;
        f2489d = method;
        f2490e = method2;
    }

    f() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f2489d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2487b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2490e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f2489d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f2488c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        Object n = n();
        if (n == null) {
            return null;
        }
        c.C0038c[] a2 = bVar.a();
        for (c.C0038c cVar : a2) {
            ByteBuffer b2 = k.b(context, resources, cVar.b());
            if (b2 == null || !k(n, b2, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return l(n);
    }

    @Override // b.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        Object n = n();
        if (n == null) {
            return null;
        }
        g gVar = new g();
        for (b.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, c2);
                gVar.put(c2, byteBuffer);
            }
            if (byteBuffer == null || !k(n, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        Typeface l = l(n);
        if (l == null) {
            return null;
        }
        return Typeface.create(l, i2);
    }
}
