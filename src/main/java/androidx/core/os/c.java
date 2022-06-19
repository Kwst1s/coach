package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;

/* compiled from: ConfigurationCompat */
public final class c {
    public static d a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.d(configuration.getLocales());
        }
        return d.a(configuration.locale);
    }
}
