package com.google.android.gms.common.l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7426a;

    public a(@RecentlyNonNull Context context) {
        this.f7426a = context;
    }

    @RecentlyNonNull
    public ApplicationInfo a(@RecentlyNonNull String str, int i2) {
        return this.f7426a.getPackageManager().getApplicationInfo(str, i2);
    }

    @RecentlyNonNull
    public CharSequence b(@RecentlyNonNull String str) {
        return this.f7426a.getPackageManager().getApplicationLabel(this.f7426a.getPackageManager().getApplicationInfo(str, 0));
    }

    @RecentlyNonNull
    public PackageInfo c(@RecentlyNonNull String str, int i2) {
        return this.f7426a.getPackageManager().getPackageInfo(str, i2);
    }
}
