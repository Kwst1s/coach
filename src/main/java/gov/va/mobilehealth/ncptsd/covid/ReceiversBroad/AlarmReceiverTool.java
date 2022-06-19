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

public class AlarmReceiverTool extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f10175a = 219;

    public void onReceive(Context context, Intent intent) {
        if (q.h(context)) {
            q.F(context, true, "try_tool_lastday");
            Intent intent2 = new Intent(context, Act_splash.class);
            intent2.addFlags(604012544);
            intent2.putExtra("onNotificationStart", true);
            intent2.putExtra("assessment", false);
            intent2.putExtra("goal", false);
            intent2.putExtra("manage", true);
            PendingIntent activity = PendingIntent.getActivity(context, 211, intent2, 134217728);
            h.d dVar = new h.d(context, context.getString(R.string.notif_system_channel_id));
            dVar.q(R.drawable.icon_notif);
            dVar.k(context.getString(R.string.app_name));
            h.b bVar = new h.b();
            bVar.h(context.getString(R.string.take_minute_manage_stress));
            dVar.s(bVar);
            dVar.e(true);
            dVar.j(context.getString(R.string.take_minute_manage_stress));
            dVar.i(activity);
            ((NotificationManager) context.getSystemService("notification")).notify(this.f10175a, dVar.b());
        }
    }
}
