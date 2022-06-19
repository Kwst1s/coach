package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: ResourcesFlusher */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Field f218a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f219b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f220c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f221d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f222e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f223f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f224g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f225h;

    static void a(Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 >= 24) {
                d(resources);
            } else if (i2 >= 23) {
                c(resources);
            } else if (i2 >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        if (!f219b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f218a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f219b = true;
        }
        Field field = f218a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f219b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f218a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f219b = true;
        }
        Object obj = null;
        Field field = f218a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj != null) {
            e(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f225h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f224g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f225h = true;
        }
        Field field = f224g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f219b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f218a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f219b = true;
                }
                Field field2 = f218a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    e(obj2);
                }
            }
        }
    }

    private static void e(Object obj) {
        if (!f221d) {
            try {
                f220c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f221d = true;
        }
        Class<?> cls = f220c;
        if (cls != null) {
            if (!f223f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f222e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f223f = true;
            }
            Field field = f222e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
