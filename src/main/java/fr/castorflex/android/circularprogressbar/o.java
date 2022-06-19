package fr.castorflex.android.circularprogressbar;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.github.mikephil.charting.utils.Utils;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: Utils */
public class o {
    static void a(int i2) {
        if (i2 < 0 || i2 > 360) {
            throw new IllegalArgumentException(String.format(Locale.US, "Illegal angle %d: must be >=0 and <=360", Integer.valueOf(i2)));
        }
    }

    static void b(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least 1 color");
        }
    }

    static void c(float f2, String str) {
        if (f2 < Utils.FLOAT_EPSILON) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s %f must be positive", str, Float.valueOf(f2)));
        }
    }

    static void d(float f2) {
        if (f2 <= Utils.FLOAT_EPSILON) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    static float e(ValueAnimator valueAnimator) {
        if (Build.VERSION.SDK_INT >= 23) {
            return valueAnimator.getAnimatedFraction();
        }
        return valueAnimator.getInterpolator().getInterpolation(Math.min(valueAnimator.getDuration() > 0 ? ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration()) : Utils.FLOAT_EPSILON, 1.0f));
    }

    @TargetApi(21)
    static boolean f(PowerManager powerManager) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            return powerManager.isPowerSaveMode();
        } catch (Exception unused) {
            return false;
        }
    }

    static PowerManager g(Context context) {
        return (PowerManager) context.getSystemService("power");
    }
}
