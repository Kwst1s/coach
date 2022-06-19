package gov.va.mobilehealth.ncptsd.covid.ReceiversBroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import gov.va.mobilehealth.ncptsd.covid.CComp.q;

public class UpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (q.g(context)) {
            q.E(context, true, "ptsd_symptoms_lastday");
        }
        if (q.e(context)) {
            q.C(context, true);
        }
        if (q.f(context)) {
            q.D(context, true, "goal_lastday");
        }
    }
}
