package com.esafirm.imagepicker.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

/* compiled from: LocaleManager */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f4581a;

    private static String a() {
        String str = f4581a;
        if (str == null || str.isEmpty()) {
            return Locale.getDefault().getLanguage();
        }
        return f4581a;
    }

    public static Context b(Context context) {
        Locale locale = new Locale(a());
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
