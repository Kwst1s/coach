package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

/* compiled from: LocaleHelper */
public class b0 {
    public static String a(Context context) {
        return b(context, Resources.getSystem().getConfiguration().locale.getLanguage());
    }

    private static String b(Context context, String str) {
        return j.s(context).getString("Locale.Helper.Selected.Language", str);
    }

    public static Context c(Context context, String str) {
        return e(context, b(context, str));
    }

    private static void d(Context context, String str) {
        SharedPreferences.Editor u = j.u(context);
        u.putString("Locale.Helper.Selected.Language", str);
        u.apply();
    }

    public static Context e(Context context, String str) {
        d(context, str);
        if (Build.VERSION.SDK_INT >= 24) {
            return f(context, str);
        }
        g(context, str);
        return context;
    }

    @TargetApi(24)
    private static Context f(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context g(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
