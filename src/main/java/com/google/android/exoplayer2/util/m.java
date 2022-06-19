package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: Log */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static int f7032a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7033b = true;

    private static String a(String str, Throwable th) {
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " - " + message;
    }

    public static void b(String str, String str2) {
        if (f7032a == 0) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f7032a <= 3) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (!f7033b) {
            c(str, a(str2, th));
        }
        if (f7032a <= 3) {
            Log.e(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (f7032a <= 1) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (f7032a <= 2) {
            Log.w(str, str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        if (!f7033b) {
            f(str, a(str2, th));
        }
        if (f7032a <= 2) {
            Log.w(str, str2, th);
        }
    }
}
