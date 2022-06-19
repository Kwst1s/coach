package c.e.a.a.c;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.e;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final e f3220a = e.e();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3221b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f3222c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f3223d = null;

    public static void a(@RecentlyNonNull Context context) {
        n.g(context, "Context must not be null");
        f3220a.i(context, 11925000);
        synchronized (f3221b) {
            Context b2 = b(context);
            if (b2 != null) {
                e(b2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            Context c2 = c(context, true);
            if (c2 != null) {
                e(c2, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    private static Context b(Context context) {
        try {
            return DynamiteModule.c(context, DynamiteModule.f7450j, "com.google.android.gms.providerinstaller.dynamite").b();
        } catch (DynamiteModule.LoadingException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    private static Context c(Context context, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context c2 = g.c(context);
        if (c2 != null) {
            try {
                if (f3223d == null) {
                    f3223d = d(c2, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, Long.TYPE});
                }
                f3223d.invoke(null, context, Long.valueOf(elapsedRealtime));
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to report request stats: ".concat(valueOf) : new String("Failed to report request stats: "));
            }
        }
        return c2;
    }

    private static Method d(Context context, String str, String str2, Class[] clsArr) {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void e(Context context, Context context2, String str) {
        try {
            if (f3222c == null) {
                f3222c = d(context, str, "insertProvider", new Class[]{Context.class});
            }
            f3222c.invoke(null, context);
        } catch (Exception e2) {
            Throwable cause = e2.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                String valueOf = String.valueOf(cause == null ? e2.getMessage() : cause.getMessage());
                Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
