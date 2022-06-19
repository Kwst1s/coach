package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.l.b;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7411a = new Object();
    @GuardedBy("sLock")

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7412b;

    /* renamed from: c  reason: collision with root package name */
    private static int f7413c;

    public static int a(Context context) {
        b(context);
        return f7413c;
    }

    private static void b(Context context) {
        synchronized (f7411a) {
            if (!f7412b) {
                f7412b = true;
                try {
                    Bundle bundle = b.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        bundle.getString("com.google.app.id");
                        f7413c = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}
