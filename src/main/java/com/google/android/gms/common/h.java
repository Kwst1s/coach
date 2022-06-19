package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.n;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class h {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static h f7293a;

    private h(Context context) {
        context.getApplicationContext();
    }

    @RecentlyNonNull
    public static h a(@RecentlyNonNull Context context) {
        n.f(context);
        synchronized (h.class) {
            if (f7293a == null) {
                o.a(context);
                f7293a = new h(context);
            }
        }
        return f7293a;
    }

    @Nullable
    private static p b(PackageInfo packageInfo, p... pVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        r rVar = new r(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            if (pVarArr[i2].equals(rVar)) {
                return pVarArr[i2];
            }
        }
        return null;
    }

    public static boolean c(@RecentlyNonNull PackageInfo packageInfo, boolean z) {
        p pVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                pVar = b(packageInfo, t.f7434a);
            } else {
                pVar = b(packageInfo, t.f7434a[0]);
            }
            if (pVar != null) {
                return true;
            }
        }
        return false;
    }
}
