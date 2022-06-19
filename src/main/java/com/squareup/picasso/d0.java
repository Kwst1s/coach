package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import j.e;
import j.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
/* compiled from: Utils */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    static final StringBuilder f8688a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final f f8689b = f.i("RIFF");

    /* renamed from: c  reason: collision with root package name */
    private static final f f8690c = f.i("WEBP");

    /* compiled from: Utils */
    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    /* compiled from: Utils */
    private static class b extends Thread {
        b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils */
    static class c implements ThreadFactory {
        c() {
        }

        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    @TargetApi(18)
    static long a(File file) {
        long j2;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            int i2 = Build.VERSION.SDK_INT;
            j2 = ((i2 < 18 ? (long) statFs.getBlockCount() : statFs.getBlockCountLong()) * (i2 < 18 ? (long) statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j2 = 5242880;
        }
        return Math.max(Math.min(j2, 52428800L), 5242880L);
    }

    static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) n(context, "activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7);
    }

    static void c() {
        if (!q()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static <T> T d(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    static File e(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static String f(w wVar) {
        StringBuilder sb = f8688a;
        String g2 = g(wVar, sb);
        sb.setLength(0);
        return g2;
    }

    static String g(w wVar, StringBuilder sb) {
        String str = wVar.f8791f;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(wVar.f8791f);
        } else {
            Uri uri = wVar.f8789d;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(wVar.f8790e);
            }
        }
        sb.append('\n');
        if (wVar.n != Utils.FLOAT_EPSILON) {
            sb.append("rotation:");
            sb.append(wVar.n);
            if (wVar.q) {
                sb.append('@');
                sb.append(wVar.o);
                sb.append('x');
                sb.append(wVar.p);
            }
            sb.append('\n');
        }
        if (wVar.c()) {
            sb.append("resize:");
            sb.append(wVar.f8793h);
            sb.append('x');
            sb.append(wVar.f8794i);
            sb.append('\n');
        }
        if (wVar.f8795j) {
            sb.append("centerCrop:");
            sb.append(wVar.f8796k);
            sb.append('\n');
        } else if (wVar.l) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<c0> list = wVar.f8792g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(wVar.f8792g.get(i2).b());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    static void h(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    static int i(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static String j(c cVar) {
        return k(cVar, BuildConfig.FLAVOR);
    }

    static String k(c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        a h2 = cVar.h();
        if (h2 != null) {
            sb.append(h2.f8634b.d());
        }
        List<a> i2 = cVar.i();
        if (i2 != null) {
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 > 0 || h2 != null) {
                    sb.append(", ");
                }
                sb.append(i2.get(i3).f8634b.d());
            }
        }
        return sb.toString();
    }

    static int l(Resources resources, w wVar) {
        Uri uri;
        int i2 = wVar.f8790e;
        if (i2 != 0 || (uri = wVar.f8789d) == null) {
            return i2;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = wVar.f8789d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + wVar.f8789d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + wVar.f8789d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + wVar.f8789d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + wVar.f8789d);
        }
    }

    static Resources m(Context context, w wVar) {
        Uri uri;
        if (wVar.f8790e != 0 || (uri = wVar.f8789d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + wVar.f8789d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + wVar.f8789d);
        }
    }

    static <T> T n(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    static boolean o(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static boolean p(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 17) {
            try {
                if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                    return true;
                }
                return false;
            } catch (NullPointerException | SecurityException unused) {
                return false;
            }
        } else if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean q() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean r(e eVar) {
        return eVar.B(0, f8689b) && eVar.B(8, f8690c);
    }

    static void s(String str, String str2, String str3) {
        t(str, str2, str3, BuildConfig.FLAVOR);
    }

    static void t(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }
}
