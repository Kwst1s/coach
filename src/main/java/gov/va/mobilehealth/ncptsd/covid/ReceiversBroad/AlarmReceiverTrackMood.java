package gov.va.mobilehealth.ncptsd.covid.ReceiversBroad;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.h;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_splash;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;

public class AlarmReceiverTrackMood extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f10176a = 209;

    public void onReceive(Context context, Intent intent) {
        if (q.i(context)) {
            q.G(context, true, "track_mood_lastday");
            Intent intent2 = new Intent(context, Act_splash.class);
            intent2.addFlags(604012544);
            intent2.putExtra("onNotificationStart", true);
            intent2.putExtra("assessment", true);
            intent2.putExtra("goal", false);
            PendingIntent activity = PendingIntent.getActivity(context, 201, intent2, 134217728);
            h.d dVar = new h.d(context, context.getString(R.string.notif_system_channel_id));
            dVar.q(R.drawable.icon_notif);
            dVar.k(context.getString(R.string.app_name));
            h.b bVar = new h.b();
            bVar.h(context.getString(R.string.come_rate_mood));
            dVar.s(bVar);
            dVar.e(true);
            dVar.j(context.getString(R.string.come_rate_mood));
            dVar.i(activity);
            ((NotificationManager) context.getSystemService("notification")).notify(this.f10176a, dVar.b());
        }
    }
}
