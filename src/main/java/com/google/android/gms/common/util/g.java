package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f7440a;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean h() {
        boolean z = false;
        if (!g()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.equals("REL")) {
            return true;
        }
        String str = Build.VERSION.CODENAME;
        if (!(str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z')) {
            return false;
        }
        Boolean bool = f7440a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if ("google".equals(Build.BRAND) && !Build.ID.startsWith("RPP1") && !Build.ID.startsWith("RPP2") && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457) {
                z = true;
            }
            f7440a = Boolean.valueOf(z);
        } catch (NumberFormatException unused) {
            f7440a = Boolean.TRUE;
        }
        if (!f7440a.booleanValue()) {
            Log.w("PlatformVersion", "Build version must be at least 6301457 to support R in gmscore");
        }
        return f7440a.booleanValue();
    }
}
