package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.o0;
import com.google.android.gms.common.l.b;
import com.google.android.gms.common.util.f;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7288a = g.f7290a;

    /* renamed from: b  reason: collision with root package name */
    private static final e f7289b = new e();

    e() {
    }

    @RecentlyNonNull
    public static e e() {
        return f7289b;
    }

    private static String j(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f7288a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(b.a(context).c(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    @RecentlyNullable
    public Intent a(Context context, int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            if (context == null || !f.e(context)) {
                return o0.c("com.google.android.gms", j(context, str));
            }
            return o0.a();
        } else if (i2 != 3) {
            return null;
        } else {
            return o0.b("com.google.android.gms");
        }
    }

    @RecentlyNullable
    public PendingIntent b(@RecentlyNonNull Context context, int i2, int i3) {
        return c(context, i2, i3, null);
    }

    @RecentlyNullable
    public PendingIntent c(@RecentlyNonNull Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, a2, 134217728);
    }

    public String d(int i2) {
        return g.b(i2);
    }

    public int f(@RecentlyNonNull Context context) {
        return g(context, f7288a);
    }

    public int g(@RecentlyNonNull Context context, int i2) {
        int e2 = g.e(context, i2);
        if (g.f(context, e2)) {
            return 18;
        }
        return e2;
    }

    public boolean h(int i2) {
        return g.h(i2);
    }

    public void i(@RecentlyNonNull Context context, int i2) {
        g.a(context, i2);
    }
}
