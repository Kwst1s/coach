package b.h.i;

import android.os.Build;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f2583a = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);

    private static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f2583a)) {
            return 0;
        }
        String c2 = b.c(locale);
        if (c2 == null) {
            return a(locale);
        }
        return (c2.equalsIgnoreCase("Arab") || c2.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
