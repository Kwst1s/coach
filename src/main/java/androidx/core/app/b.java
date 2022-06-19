package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: ActivityRecreator */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f1029a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f1030b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f1031c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f1032d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f1033e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f1034f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f1035g = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: package-private */
    /* compiled from: ActivityRecreator */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f1036b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f1037c;

        a(d dVar, Object obj) {
            this.f1036b = dVar;
            this.f1037c = obj;
        }

        public void run() {
            this.f1036b.f1042b = this.f1037c;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.core.app.b$b  reason: collision with other inner class name */
    /* compiled from: ActivityRecreator */
    public class RunnableC0017b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Application f1038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f1039c;

        RunnableC0017b(Application application, d dVar) {
            this.f1038b = application;
            this.f1039c = dVar;
        }

        public void run() {
            this.f1038b.unregisterActivityLifecycleCallbacks(this.f1039c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ActivityRecreator */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f1040b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f1041c;

        c(Object obj, Object obj2) {
            this.f1040b = obj;
            this.f1041c = obj2;
        }

        public void run() {
            try {
                Method method = b.f1032d;
                if (method != null) {
                    method.invoke(this.f1040b, this.f1041c, Boolean.FALSE, "AppCompat recreation");
                    return;
                }
                b.f1033e.invoke(this.f1040b, this.f1041c, Boolean.FALSE);
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ActivityRecreator */
    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        Object f1042b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f1043c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1044d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1045e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1046f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1047g = false;

        d(Activity activity) {
            this.f1043c = activity;
            this.f1044d = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1043c == activity) {
                this.f1043c = null;
                this.f1046f = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1046f && !this.f1047g && !this.f1045e && b.h(this.f1042b, this.f1044d, activity)) {
                this.f1047g = true;
                this.f1042b = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1043c == activity) {
                this.f1045e = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        f1029a = a2;
        f1032d = d(a2);
        f1033e = c(a2);
        f1034f = e(a2);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f1031c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i2) {
                    f1035g.postAtFrontOfQueue(new c(f1030b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f1034f == null) {
            return false;
        } else {
            if (f1033e == null && f1032d == null) {
                return false;
            }
            try {
                Object obj2 = f1031c.get(activity);
                if (obj2 == null || (obj = f1030b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f1035g;
                handler.post(new a(dVar, obj2));
                try {
                    if (g()) {
                        Method method = f1034f;
                        Boolean bool = Boolean.FALSE;
                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                    } else {
                        activity.recreate();
                    }
                    handler.post(new RunnableC0017b(application, dVar));
                    return true;
                } catch (Throwable th) {
                    f1035g.post(new RunnableC0017b(application, dVar));
                    throw th;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
