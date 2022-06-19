package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import javax.annotation.CheckReturnValue;

/* access modifiers changed from: package-private */
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7429a;

    static synchronized void a(Context context) {
        synchronized (o.class) {
            if (f7429a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f7429a = context.getApplicationContext();
            }
        }
    }
}
