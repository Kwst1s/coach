package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.p;
import java.util.concurrent.TimeUnit;
import k.b.d;

public class AppLifecycleListener implements h {

    /* renamed from: a  reason: collision with root package name */
    private Context f10053a;

    public AppLifecycleListener(Context context) {
        this.f10053a = context;
    }

    @p(e.a.ON_STOP)
    public void onMoveToBackground() {
        Context context = this.f10053a;
        if (context != null) {
            long b2 = ((App) context.getApplicationContext()).b();
            String a2 = ((App) this.f10053a.getApplicationContext()).a();
            if (b2 != -1) {
                d.m(this.f10053a, false, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - b2));
            }
            if (a2 != null) {
                d.l(this.f10053a, a2, "dropoff_screen", null);
            }
        }
    }

    @p(e.a.ON_START)
    public void onMoveToForeground() {
        Context context = this.f10053a;
        if (context != null) {
            if (j.t(context, "first_session_start_covid", true)) {
                d.s(this.f10053a);
                j.u(this.f10053a).putBoolean("first_session_start_covid", false).apply();
            } else {
                d.t(this.f10053a);
            }
            if (o.h(this.f10053a)) {
                o.M(this.f10053a, false, true, false);
            }
            ((App) this.f10053a.getApplicationContext()).h(System.currentTimeMillis());
        }
    }
}
