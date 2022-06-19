package gov.va.mobilehealth.ncptsd.covid.ExpansionUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import c.e.a.c.a.a.c;

public class ExpAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            c.d(context, intent, DownloaderExpService.class);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
