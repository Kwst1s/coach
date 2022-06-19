package gov.va.mobilehealth.ncptsd.covid.ReceiversBroad;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.h;
import b.a.j;
import b.h.d.a;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_splash;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;

public class AlarmReceiverQuotes extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f10174a = 89;

    public void onReceive(Context context, Intent intent) {
        if (q.e(context)) {
            q.C(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String stringExtra = intent.getStringExtra("message");
            int intExtra = intent.getIntExtra("index", -1);
            Intent intent2 = new Intent(context, Act_splash.class);
            intent2.addFlags(604012544);
            intent2.putExtra("onNotificationStart", true);
            intent2.putExtra("assessment", false);
            intent2.putExtra("index", intExtra);
            PendingIntent activity = PendingIntent.getActivity(context, j.G0, intent2, 134217728);
            if (Build.VERSION.SDK_INT < 26) {
                h.d dVar = new h.d(context);
                dVar.q(R.drawable.icon_notif);
                dVar.k(context.getString(R.string.app_name));
                h.b bVar = new h.b();
                bVar.h(stringExtra);
                dVar.s(bVar);
                dVar.u(new long[1000]);
                dVar.r(RingtoneManager.getDefaultUri(2));
                dVar.m(a.b(context, R.color.azure), 1500, 2500);
                dVar.p(2);
                dVar.i(activity);
                dVar.j(stringExtra);
                Notification b2 = dVar.b();
                int i2 = b2.defaults | 1;
                b2.defaults = i2;
                b2.defaults = i2 | 2;
                notificationManager.notify(this.f10174a, b2);
                return;
            }
            h.d dVar2 = new h.d(context, context.getString(R.string.notif_system_channel_id));
            dVar2.q(R.drawable.icon_notif);
            dVar2.k(context.getString(R.string.app_name));
            dVar2.p(2);
            h.b bVar2 = new h.b();
            bVar2.h(stringExtra);
            dVar2.s(bVar2);
            dVar2.e(true);
            dVar2.j(stringExtra);
            dVar2.i(activity);
            notificationManager.notify(this.f10174a, dVar2.b());
        }
    }
}
