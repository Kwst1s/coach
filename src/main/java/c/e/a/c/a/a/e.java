package c.e.a.c.a.a;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: Helpers */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static Random f3488a = new Random(SystemClock.uptimeMillis());

    static {
        Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    }

    public static boolean a(Context context, String str, long j2, boolean z) {
        File file = new File(b(context, str));
        if (!file.exists()) {
            return false;
        }
        if (file.length() == j2) {
            return true;
        }
        if (!z) {
            return false;
        }
        file.delete();
        return false;
    }

    public static String b(Context context, String str) {
        return i(context) + File.separator + str;
    }

    public static long c(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
    }

    public static String d(long j2, long j3) {
        if (j3 == 0) {
            return BuildConfig.FLAVOR;
        }
        return Long.toString((j2 * 100) / j3) + "%";
    }

    public static String e(long j2, long j3) {
        if (j3 == 0) {
            return BuildConfig.FLAVOR;
        }
        return String.format("%.2f", Float.valueOf(((float) j2) / 1048576.0f)) + "MB /" + String.format("%.2f", Float.valueOf(((float) j3) / 1048576.0f)) + "MB";
    }

    public static int f(int i2) {
        switch (i2) {
            case 1:
                return R.string.state_idle;
            case 2:
                return R.string.state_fetching_url;
            case 3:
                return R.string.state_connecting;
            case 4:
                return R.string.state_downloading;
            case 5:
                return R.string.state_completed;
            case 6:
                return R.string.state_paused_network_unavailable;
            case 7:
                return R.string.state_paused_by_request;
            case 8:
                return R.string.state_paused_wifi_disabled;
            case 9:
                return R.string.state_paused_wifi_unavailable;
            case 10:
                return R.string.state_paused_wifi_disabled;
            case 11:
                return R.string.state_paused_wifi_unavailable;
            case 12:
                return R.string.state_paused_roaming;
            case 13:
                return R.string.state_paused_network_setup_failure;
            case 14:
                return R.string.state_paused_sdcard_unavailable;
            case 15:
                return R.string.state_failed_unlicensed;
            case 16:
                return R.string.state_failed_fetching_url;
            case 17:
                return R.string.state_failed_sdcard_full;
            case 18:
                return R.string.state_failed_cancelled;
            default:
                return R.string.state_unknown;
        }
    }

    public static String g(Context context, boolean z, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "main." : "patch.");
        sb.append(i2);
        sb.append(".");
        sb.append(context.getPackageName());
        sb.append(".obb");
        return sb.toString();
    }

    public static File h(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for " + str);
    }

    public static String i(Context context) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return externalStorageDirectory.toString() + a.f3469a + context.getPackageName();
    }

    public static String j(long j2) {
        SimpleDateFormat simpleDateFormat;
        if (j2 > 3600000) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        }
        return simpleDateFormat.format(new Date(j2 - ((long) TimeZone.getDefault().getRawOffset())));
    }

    public static boolean k() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean l(String str) {
        String replaceFirst = str.replaceFirst("/+", "/");
        return replaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) || replaceFirst.startsWith(Environment.getExternalStorageDirectory().toString());
    }
}
