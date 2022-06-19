package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f7436a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f7437b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f7438c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f7439d;

    public static boolean a(@RecentlyNonNull Context context) {
        return b(context.getPackageManager());
    }

    public static boolean b(@RecentlyNonNull PackageManager packageManager) {
        if (f7439d == null) {
            f7439d = Boolean.valueOf(g.f() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f7439d.booleanValue();
    }

    @TargetApi(20)
    public static boolean c(@RecentlyNonNull Context context) {
        return d(context.getPackageManager());
    }

    @TargetApi(20)
    public static boolean d(@RecentlyNonNull PackageManager packageManager) {
        if (f7436a == null) {
            f7436a = Boolean.valueOf(g.c() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f7436a.booleanValue();
    }

    @TargetApi(26)
    public static boolean e(@RecentlyNonNull Context context) {
        if (!c(context)) {
            return false;
        }
        if (g.e()) {
            return g(context) && !g.f();
        }
        return true;
    }

    public static boolean f(@RecentlyNonNull Context context) {
        if (f7438c == null) {
            f7438c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f7438c.booleanValue();
    }

    @TargetApi(21)
    private static boolean g(Context context) {
        if (f7437b == null) {
            f7437b = Boolean.valueOf(g.d() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f7437b.booleanValue();
    }
}
