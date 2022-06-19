package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class b {
    public static boolean a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((com.google.android.gms.common.l.b.a(context).a(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
