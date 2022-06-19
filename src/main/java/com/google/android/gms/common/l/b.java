package com.google.android.gms.common.l;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f7427b = new b();

    /* renamed from: a  reason: collision with root package name */
    private a f7428a = null;

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        return f7427b.b(context);
    }

    private final synchronized a b(Context context) {
        if (this.f7428a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7428a = new a(context);
        }
        return this.f7428a;
    }
}
