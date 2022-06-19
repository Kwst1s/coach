package gov.va.mobilehealth.ncptsd.covid.ExpansionUtils.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.Vector;

/* compiled from: APKExpansionSupport */
public class a {
    static String[] a(Context context, int i2, int i3) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i2 > 0) {
                    String str = file + File.separator + "main." + i2 + "." + packageName + ".obb";
                    if (new File(str).isFile()) {
                        vector.add(str);
                    }
                }
                if (i3 > 0) {
                    String str2 = file + File.separator + "patch." + i2 + "." + packageName + ".obb";
                    if (new File(str2).isFile()) {
                        vector.add(str2);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static b b(Context context, int i2, int i3) {
        return c(a(context, i2, i3));
    }

    public static b c(String[] strArr) {
        b bVar = null;
        for (String str : strArr) {
            if (bVar == null) {
                bVar = new b(str);
            } else {
                bVar.a(str);
            }
        }
        return bVar;
    }
}
