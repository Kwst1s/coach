package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.appcompat.widget.AppCompatTextView;
import b.a.j;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.App;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import k.b.c;

public class Act_splash extends i0 {
    private Handler u;

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                if (b.h.d.a.a(Act_splash.this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    androidx.core.app.a.l(Act_splash.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, j.H0);
                } else {
                    Act_splash.this.X();
                }
            }
            super.handleMessage(message);
        }
    }

    public void W() {
        Message message = new Message();
        message.what = 0;
        this.u.sendMessageDelayed(message, 2000);
        o.f(getApplicationContext());
        if (o.h(getApplicationContext())) {
            o.M(getApplicationContext(), false, true, false);
        }
    }

    public void X() {
        if (gov.va.mobilehealth.ncptsd.covid.CComp.j.C(getApplicationContext())) {
            startActivity(new Intent(getApplicationContext(), Act_license_agreement.class));
            finish();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), Act_home.class);
        if (getIntent().getExtras() != null) {
            intent.putExtras(getIntent().getExtras());
        }
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    @Override // androidx.activity.ComponentActivity, gov.va.mobilehealth.ncptsd.covid.CComp.i0
    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_splash);
        ((NotificationManager) getSystemService("notification")).cancelAll();
        this.u = new a();
        m.l(getApplicationContext());
        m.N0(getApplication(), false);
        gov.va.mobilehealth.ncptsd.covid.CComp.j.A(getApplicationContext());
        if (!gov.va.mobilehealth.ncptsd.covid.CComp.j.t(this, "addedSIIMages", false)) {
            m.z0(getApplicationContext());
            gov.va.mobilehealth.ncptsd.covid.CComp.j.u(this).putBoolean("addedSIIMages", true).apply();
        }
        if (!gov.va.mobilehealth.ncptsd.covid.CComp.j.t(this, "favorite_cluster", false)) {
            gov.va.mobilehealth.ncptsd.covid.CComp.j.u(this).putBoolean("favorites_lost", m.e(getApplicationContext())).apply();
            m.d(getApplicationContext());
            gov.va.mobilehealth.ncptsd.covid.CComp.j.u(this).putBoolean("favorite_cluster", true).apply();
        }
        double dimensionPixelSize = (double) getResources().getDimensionPixelSize(R.dimen.txt_xlarge);
        Double.isNaN(dimensionPixelSize);
        ((AppCompatTextView) findViewById(R.id.splash_txt_covid)).setTextSize(0, (float) (dimensionPixelSize * 1.4d));
        ((App) getApplication()).h(-1);
        if (gov.va.mobilehealth.ncptsd.covid.CComp.j.s(this).getBoolean("instrumentation_enabled", true)) {
            c.n(true);
            c.q(this);
        } else {
            c.n(false);
        }
        k.f10124a.a(getApplicationContext());
        W();
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 123) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            gov.va.mobilehealth.ncptsd.covid.CComp.j.W(this, getString(R.string.need_permission_read_storage_to_download_files_use_application));
        } else {
            X();
        }
    }
}
