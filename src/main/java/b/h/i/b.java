package b.h.i;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2560a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2561b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2560a = cls.getMethod("getScript", String.class);
                    f2561b = cls.getMethod("addLikelySubtags", String.class);
                }
            } catch (Exception e2) {
                f2560a = null;
                f2561b = null;
                Log.w("ICUCompat", e2);
            }
        } else if (i2 < 24) {
            try {
                f2561b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f2561b;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }

    private static String b(String str) {
        try {
            Method method = f2560a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 >= 21) {
            try {
                return ((Locale) f2561b.invoke(null, locale)).getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            } catch (IllegalAccessException e3) {
                Log.w("ICUCompat", e3);
                return locale.getScript();
            }
        } else {
            String a2 = a(locale);
            if (a2 != null) {
                return b(a2);
            }
            return null;
        }
    }
}
