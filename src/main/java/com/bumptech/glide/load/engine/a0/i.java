package com.bumptech.glide.load.engine.a0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: MemorySizeCalculator */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f3681a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3682b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f3683c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3684d;

    /* compiled from: MemorySizeCalculator */
    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        static final int f3685i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        final Context f3686a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f3687b;

        /* renamed from: c  reason: collision with root package name */
        c f3688c;

        /* renamed from: d  reason: collision with root package name */
        float f3689d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f3690e = ((float) f3685i);

        /* renamed from: f  reason: collision with root package name */
        float f3691f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f3692g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f3693h = 4194304;

        public a(Context context) {
            this.f3686a = context;
            this.f3687b = (ActivityManager) context.getSystemService("activity");
            this.f3688c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f3687b)) {
                this.f3690e = Utils.FLOAT_EPSILON;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: MemorySizeCalculator */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f3694a;

        b(DisplayMetrics displayMetrics) {
            this.f3694a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int a() {
            return this.f3694a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int b() {
            return this.f3694a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i2;
        this.f3683c = aVar.f3686a;
        if (e(aVar.f3687b)) {
            i2 = aVar.f3693h / 2;
        } else {
            i2 = aVar.f3693h;
        }
        this.f3684d = i2;
        int c2 = c(aVar.f3687b, aVar.f3691f, aVar.f3692g);
        float b2 = (float) (aVar.f3688c.b() * aVar.f3688c.a() * 4);
        int round = Math.round(aVar.f3690e * b2);
        int round2 = Math.round(b2 * aVar.f3689d);
        int i3 = c2 - i2;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f3682b = round2;
            this.f3681a = round;
        } else {
            float f2 = (float) i3;
            float f3 = aVar.f3690e;
            float f4 = aVar.f3689d;
            float f5 = f2 / (f3 + f4);
            this.f3682b = Math.round(f4 * f5);
            this.f3681a = Math.round(f5 * aVar.f3690e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f3682b));
            sb.append(", pool size: ");
            sb.append(f(this.f3681a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f3687b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f3687b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.f3683c, (long) i2);
    }

    public int a() {
        return this.f3684d;
    }

    public int b() {
        return this.f3681a;
    }

    public int d() {
        return this.f3682b;
    }
}
