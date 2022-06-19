package com.esafirm.imagepicker.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import c.c.a.i.b;
import com.esafirm.imagepicker.features.p;
import com.github.mikephil.charting.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ImagePickerUtils */
public class c {
    public static File a(p pVar) {
        File file;
        String g2 = pVar.g();
        if (pVar.k()) {
            file = new File(g2);
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), g2);
        }
        if (file.exists() || file.mkdirs()) {
            String str = "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            try {
                return File.createTempFile(str, ".jpg", file);
            } catch (IOException unused) {
                e.c().a("Oops! Failed create " + str + " file");
                return null;
            }
        } else {
            e.c().a("Oops! Failed create " + g2);
            return null;
        }
    }

    private static String b(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
            return fileExtensionFromUrl;
        }
        return str.contains(".") ? str.substring(str.lastIndexOf(".") + 1, str.length()) : BuildConfig.FLAVOR;
    }

    public static String c(String str) {
        String str2 = File.separator;
        return str.contains(str2) ? str.substring(str.lastIndexOf(str2) + 1) : str;
    }

    public static void d(Context context, Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    public static boolean e(b bVar) {
        return b(bVar.g()).equalsIgnoreCase("gif");
    }

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean g(b bVar) {
        String str;
        String b2 = b(bVar.g());
        if (TextUtils.isEmpty(b2)) {
            str = URLConnection.guessContentTypeFromName(bVar.g());
        } else {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(b2);
        }
        return str != null && str.startsWith("video");
    }

    public static void h(Context context, Uri uri) {
        context.revokeUriPermission(uri, 3);
    }
}
