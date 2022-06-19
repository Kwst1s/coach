package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class u implements DialogInterface.OnClickListener {
    public static u a(Activity activity, Intent intent, int i2) {
        return new w(intent, activity, i2);
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            b();
        } catch (ActivityNotFoundException e2) {
            String str = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
            Log.e("DialogRedirect", str, e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
