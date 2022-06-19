package com.bumptech.glide.r;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* compiled from: LogTime */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f4374a;

    static {
        double d2 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f4374a = d2;
    }

    public static double a(long j2) {
        double b2 = (double) (b() - j2);
        double d2 = f4374a;
        Double.isNaN(b2);
        return b2 * d2;
    }

    @TargetApi(17)
    public static long b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
