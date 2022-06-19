package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.n;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class d {
    public static boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Throwable th) {
        return b(context, th, 536870912);
    }

    private static boolean b(Context context, Throwable th, int i2) {
        try {
            n.f(context);
            n.f(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
