package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import java.io.File;

/* compiled from: C_F_SpanishTools */
public class r {
    public static boolean a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        int i2 = 0;
        while (true) {
            String[] strArr = i.f10112a;
            if (i2 >= strArr.length) {
                return true;
            }
            if (!new File(externalFilesDir, strArr[i2]).exists()) {
                return false;
            }
            i2++;
        }
    }
}
