package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.t0;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class g {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f7290a = 12451000;

    /* renamed from: b  reason: collision with root package name */
    static final AtomicBoolean f7291b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f7292c = new AtomicBoolean();

    @Deprecated
    public static void a(@RecentlyNonNull Context context, int i2) {
        int g2 = e.e().g(context, i2);
        if (g2 != 0) {
            Intent a2 = e.e().a(context, g2, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(g2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (a2 == null) {
                throw new GooglePlayServicesNotAvailableException(g2);
            }
            throw new GooglePlayServicesRepairableException(g2, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static String b(int i2) {
        return a.p(i2);
    }

    @RecentlyNullable
    public static Context c(@RecentlyNonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNullable
    public static Resources d(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int e(@RecentlyNonNull Context context, int i2) {
        try {
            context.getResources().getString(i.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f7292c.get()) {
            int a2 = t0.a(context);
            if (a2 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            } else if (a2 != f7290a) {
                throw new GooglePlayServicesIncorrectManifestValueException(a2);
            }
        }
        return i(context, !f.e(context) && !f.f(context), i2);
    }

    @Deprecated
    public static boolean f(@RecentlyNonNull Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return j(context, "com.google.android.gms");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean g(@RecentlyNonNull Context context) {
        if (!com.google.android.gms.common.util.g.b()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        n.f(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean h(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    private static int i(Context context, boolean z, int i2) {
        n.a(i2 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            h.a(context);
            if (!h.c(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                return 9;
            }
            if (z) {
                n.f(packageInfo);
                if (!h.c(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                    return 9;
                }
            }
            if (h.a(packageInfo2.versionCode) < h.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                sb.append("Google Play services out of date for ");
                sb.append(packageName);
                sb.append(".  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                    return 1;
                }
            }
            if (!applicationInfo.enabled) {
                return 3;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @TargetApi(21)
    static boolean j(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (com.google.android.gms.common.util.g.d()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !g(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
