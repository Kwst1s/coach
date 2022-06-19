package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* compiled from: HardwareConfigState */
public final class q {

    /* renamed from: f  reason: collision with root package name */
    private static final File f4212f = new File("/proc/self/fd");

    /* renamed from: g  reason: collision with root package name */
    private static volatile q f4213g;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4214a = d();

    /* renamed from: b  reason: collision with root package name */
    private final int f4215b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4216c;

    /* renamed from: d  reason: collision with root package name */
    private int f4217d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4218e = true;

    q() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4215b = 20000;
            this.f4216c = 0;
            return;
        }
        this.f4215b = 700;
        this.f4216c = 128;
    }

    public static q a() {
        if (f4213g == null) {
            synchronized (q.class) {
                if (f4213g == null) {
                    f4213g = new q();
                }
            }
        }
        return f4213g;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i2 = this.f4217d + 1;
        this.f4217d = i2;
        if (i2 >= 50) {
            this.f4217d = 0;
            int length = f4212f.list().length;
            if (length >= this.f4215b) {
                z = false;
            }
            this.f4218e = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f4215b);
            }
        }
        return this.f4218e;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c2 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public boolean c(int i2, int i3, boolean z, boolean z2) {
        int i4;
        if (!z || !this.f4214a || Build.VERSION.SDK_INT < 26 || z2 || i2 < (i4 = this.f4216c) || i3 < i4 || !b()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean e(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean c2 = c(i2, i3, z, z2);
        if (c2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c2;
    }
}
