package com.firebase.jobdispatcher;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.core.net.a;

/* compiled from: ConstraintChecker */
class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4602a;

    b(Context context) {
        this.f4602a = context;
    }

    private boolean b(int i2) {
        if (!f(i2)) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f4602a.getSystemService("connectivity");
        if (!c(connectivityManager)) {
            return false;
        }
        if (!g(i2) || d(connectivityManager)) {
            return true;
        }
        return false;
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        Log.i("FJD.ConstraintChecker", "NetworkInfo null, assuming network inaccessible");
        return false;
    }

    private static boolean d(ConnectivityManager connectivityManager) {
        return !a.a(connectivityManager);
    }

    private static boolean e(int i2) {
        return (i2 & 2) != 0;
    }

    private static boolean f(int i2) {
        return e(i2) || g(i2);
    }

    private static boolean g(int i2) {
        return (i2 & 1) != 0;
    }

    public boolean a(q qVar) {
        return b(a.a(qVar.c()));
    }
}
