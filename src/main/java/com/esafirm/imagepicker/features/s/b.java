package com.esafirm.imagepicker.features.s;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import c.c.a.f;

/* compiled from: CameraHelper */
public class b {
    public static boolean a(Context context) {
        boolean z = new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(context.getPackageManager()) != null;
        if (!z) {
            Context applicationContext = context.getApplicationContext();
            Toast.makeText(applicationContext, applicationContext.getString(f.ef_error_no_camera), 1).show();
        }
        return z;
    }
}
