package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;

public class Act_slideshow_settings extends f implements View.OnClickListener {
    private TextView A;
    private int B;
    private int C;
    private Toolbar u;
    private LinearLayout v;
    private LinearLayout w;
    private TextView x;
    private TextView y;
    private TextView z;

    class a implements DialogInterface.OnClickListener {
        a(Act_slideshow_settings act_slideshow_settings) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            Act_slideshow_settings.this.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(f0 f0Var) {
        s.a(this.v);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ boolean Z(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.times_15 /*{ENCODED_INT: 2131297884}*/:
                this.B = 15;
                break;
            case R.id.times_30 /*{ENCODED_INT: 2131297885}*/:
                this.B = 30;
                break;
            case R.id.times_45 /*{ENCODED_INT: 2131297886}*/:
                this.B = 45;
                break;
            case R.id.times_5 /*{ENCODED_INT: 2131297887}*/:
                this.B = 5;
                break;
            case R.id.times_60 /*{ENCODED_INT: 2131297888}*/:
                this.B = 60;
                break;
        }
        TextView textView = this.x;
        textView.setText(Integer.toString(this.B) + " " + getString(R.string.seconds));
        LinearLayout linearLayout = this.v;
        linearLayout.setContentDescription(getString(R.string.time) + " " + Integer.toString(this.B) + " " + getString(R.string.seconds) + " " + getString(R.string.button));
        s.a(this.v);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(f0 f0Var) {
        s.a(this.w);
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ boolean d0(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.trans_crossfade /*{ENCODED_INT: 2131297912}*/:
                this.C = 2;
                break;
            case R.id.trans_fade_to_white /*{ENCODED_INT: 2131297913}*/:
                this.C = 3;
                break;
            case R.id.trans_slide /*{ENCODED_INT: 2131297914}*/:
                this.C = 1;
                break;
        }
        this.y.setText(m.a0(getApplicationContext(), this.C));
        LinearLayout linearLayout = this.w;
        linearLayout.setContentDescription(getString(R.string.transition_effect) + " " + m.a0(getApplicationContext(), this.C) + " " + getString(R.string.button));
        s.a(this.w);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void e0() {
        f0 f0Var = new f0(this, this.v, 5);
        f0Var.b().inflate(R.menu.menu_times, f0Var.a());
        f0Var.c(new b0(this));
        f0Var.d(new y(this));
        f0Var.e();
    }

    public void f0() {
        f0 f0Var = new f0(this, this.w, 5);
        f0Var.b().inflate(R.menu.menu_transitions, f0Var.a());
        f0Var.c(new a0(this));
        f0Var.d(new z(this));
        f0Var.e();
    }

    public void g0() {
        TextView textView = this.x;
        textView.setText(Integer.toString(this.B) + " " + getString(R.string.seconds));
        LinearLayout linearLayout = this.v;
        linearLayout.setContentDescription(getString(R.string.time) + " " + Integer.toString(this.B) + " " + getString(R.string.seconds) + " " + getString(R.string.button));
        this.y.setText(m.a0(getApplicationContext(), this.C));
        LinearLayout linearLayout2 = this.w;
        linearLayout2.setContentDescription(getString(R.string.transition_effect) + " " + m.a0(getApplicationContext(), this.C) + " " + getString(R.string.button));
    }

    public void onClick(View view) {
        if (view.getId() == this.v.getId()) {
            e0();
        }
        if (view.getId() == this.w.getId()) {
            f0();
        }
        if (view.getId() == this.A.getId()) {
            m.I0(getApplicationContext(), this.B);
            m.H0(getApplicationContext(), this.C);
            finish();
        }
        if (view.getId() == this.z.getId()) {
            b.a h2 = j.h(this, getString(R.string.lose_unsaved_really_exit));
            h2.k(R.string.yes, new b());
            h2.h(R.string.no, new a(this));
            h2.a().show();
            this.u.announceForAccessibility(getString(R.string.lose_unsaved_really_exit));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_slideshow_settings);
        this.u = (Toolbar) findViewById(R.id.slideshow_settings_toolbar);
        this.x = (TextView) findViewById(R.id.slideshow_settings_txt_seconds);
        this.y = (TextView) findViewById(R.id.slideshow_settings_txt_transition);
        this.z = (TextView) findViewById(R.id.slideshow_settings_txt_cancel);
        this.A = (TextView) findViewById(R.id.slideshow_settings_txt_save);
        this.v = (LinearLayout) findViewById(R.id.slideshow_settings_layout_seconds);
        this.w = (LinearLayout) findViewById(R.id.slideshow_settings_layout_transition);
        T(this.u);
        M().t(false);
        M().x(false);
        M().s(false);
        M().u(R.string.cancel);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B = m.B(getApplicationContext());
        this.C = m.A(getApplicationContext());
        g0();
    }
}
