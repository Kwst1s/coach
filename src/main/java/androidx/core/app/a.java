package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: ActivityCompat */
public class a extends b.h.d.a {

    /* renamed from: c  reason: collision with root package name */
    private static d f1024c;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* compiled from: ActivityCompat */
    class RunnableC0016a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f1025b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f1026c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1027d;

        RunnableC0016a(String[] strArr, Activity activity, int i2) {
            this.f1025b = strArr;
            this.f1026c = activity;
            this.f1027d = i2;
        }

        public void run() {
            int[] iArr = new int[this.f1025b.length];
            PackageManager packageManager = this.f1026c.getPackageManager();
            String packageName = this.f1026c.getPackageName();
            int length = this.f1025b.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f1025b[i2], packageName);
            }
            ((c) this.f1026c).onRequestPermissionsResult(this.f1027d, this.f1025b, iArr);
        }
    }

    /* compiled from: ActivityCompat */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f1028b;

        b(Activity activity) {
            this.f1028b = activity;
        }

        public void run() {
            if (!this.f1028b.isFinishing() && !b.i(this.f1028b)) {
                this.f1028b.recreate();
            }
        }
    }

    /* compiled from: ActivityCompat */
    public interface c {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat */
    public interface d {
        boolean a(Activity activity, int i2, int i3, Intent intent);

        boolean b(Activity activity, String[] strArr, int i2);
    }

    /* compiled from: ActivityCompat */
    public interface e {
        void d(int i2);
    }

    public static void i(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static d j() {
        return f1024c;
    }

    public static void k(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            activity.recreate();
        } else if (i2 <= 23) {
            new Handler(activity.getMainLooper()).post(new b(activity));
        } else if (!b.i(activity)) {
            activity.recreate();
        }
    }

    public static void l(Activity activity, String[] strArr, int i2) {
        d dVar = f1024c;
        if (dVar == null || !dVar.b(activity, strArr, i2)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof e) {
                    ((e) activity).d(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0016a(strArr, activity, i2));
            }
        }
    }

    public static boolean m(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void n(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }
}
