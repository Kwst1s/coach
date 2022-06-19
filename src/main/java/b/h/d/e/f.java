package b.h.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import b.h.j.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ResourcesCompat */
public final class f {

    /* compiled from: ResourcesCompat */
    public static abstract class a {

        /* access modifiers changed from: package-private */
        /* renamed from: b.h.d.e.f$a$a  reason: collision with other inner class name */
        /* compiled from: ResourcesCompat */
        public class RunnableC0039a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Typeface f2464b;

            RunnableC0039a(Typeface typeface) {
                this.f2464b = typeface;
            }

            public void run() {
                a.this.d(this.f2464b);
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat */
        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f2466b;

            b(int i2) {
                this.f2466b = i2;
            }

            public void run() {
                a.this.c(this.f2466b);
            }
        }

        public final void a(int i2, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new b(i2));
        }

        public final void b(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0039a(typeface));
        }

        public abstract void c(int i2);

        public abstract void d(Typeface typeface);
    }

    /* compiled from: ResourcesCompat */
    public static final class b {

        /* access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f2468a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f2469b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f2470c;

            static void a(Resources.Theme theme) {
                synchronized (f2468a) {
                    if (!f2470c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f2469b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f2470c = true;
                    }
                    Method method = f2469b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f2469b = null;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b.h.d.e.f$b$b  reason: collision with other inner class name */
        /* compiled from: ResourcesCompat */
        public static class C0040b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                C0040b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    public static Drawable a(Resources resources, int i2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme);
        }
        return resources.getDrawable(i2);
    }

    public static Typeface b(Context context, int i2) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i2, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface c(Context context, int i2, TypedValue typedValue, int i3, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i2, typedValue, i3, aVar, null, true, false);
    }

    public static void d(Context context, int i2, a aVar, Handler handler) {
        h.c(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            e(context, i2, new TypedValue(), 0, aVar, handler, false, false);
        }
    }

    private static Typeface e(Context context, int i2, TypedValue typedValue, int i3, a aVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface f2 = f(context, resources, typedValue, i2, i3, aVar, handler, z, z2);
        if (f2 != null || aVar != null || z2) {
            return f2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface f(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, b.h.d.e.f.a r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.d.e.f.f(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, b.h.d.e.f$a, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
