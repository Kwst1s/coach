package f.a.a.a.b.g;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_delete_mood_check;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_export_mood_check;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_license_agreement;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import k.b.c;
import vainstrum.Components.LinearLayoutTracking;
import vainstrum.Components.b;

/* compiled from: Frag_manage_data */
public class q extends b implements View.OnClickListener {
    private Act_home c0;
    private LinearLayout d0;
    private AppCompatTextView e0;
    private ImageView f0;
    private ImageView g0;
    private LinearLayoutTracking h0;
    private SwitchCompat i0;
    private LinearLayoutTracking j0;
    private LinearLayoutTracking k0;
    private LinearLayoutTracking l0;
    private LinearLayoutTracking m0;
    private u n0;
    private boolean o0;

    /* compiled from: Frag_manage_data */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                q.this.h0.setTrackingId("15744");
                q.this.h0.setContentDescription(q.this.Q(R.string.provide_anonymouse_usage_data_switch_activated));
                q.this.h0.announceForAccessibility(q.this.Q(R.string.provide_anonymouse_usage_data_switch_activated));
                c.n(true);
                c.q(q.this.n());
                c.m(q.this.n(), "analytics_on", null);
            } else {
                c.m(q.this.n(), "analytics_off", null);
                q.this.h0.setTrackingId("15865");
                q.this.h0.setContentDescription(q.this.Q(R.string.provide_anonymouse_usage_data_switch_deactivated));
                q.this.h0.announceForAccessibility(q.this.Q(R.string.provide_anonymouse_usage_data_switch_deactivated));
                c.n(false);
                c.s(q.this.n());
            }
            j.u(q.this.n()).putBoolean("instrumentation_enabled", z).apply();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void Y1(View view) {
        Act_home act_home = this.c0;
        if (act_home != null) {
            act_home.r0();
        } else {
            n().finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2(DialogInterface dialogInterface, int i2) {
        this.n0.O(n1());
        new z(n1()).K(n1());
        new v(n1()).E(n1());
        j.u(n1()).clear().commit();
        m.f(n1());
        Toast.makeText(n1(), (int) R.string.all_data_deleted_successfully, 1).show();
        Act_tabs act_tabs = Act_tabs.P;
        if (act_tabs != null) {
            act_tabs.finish();
        }
        n1().finish();
        F1(new Intent(n1(), Act_license_agreement.class));
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void d2(DialogInterface dialogInterface, int i2) {
        m.f(n1());
        Toast.makeText(n1(), (int) R.string.tool_preferences_restored_successfully, 1).show();
    }

    public static q f2(boolean z) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putSerializable("close", Boolean.valueOf(z));
        qVar.v1(bundle);
        return qVar;
    }

    public void g2() {
        b.a h2 = j.h(n1(), Q(R.string.do_you_really_want_to_remove_all_data));
        h2.k(R.string.yes, new d(this));
        h2.h(R.string.no, e.f9349b);
        h2.a().show();
    }

    public void h2() {
        b.a h2 = j.h(n1(), Q(R.string.do_you_really_want_to_reset_tool_preferences));
        h2.k(R.string.yes, new g(this));
        h2.h(R.string.no, f.f9350b);
        h2.a().show();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        if (n() instanceof Act_home) {
            this.c0 = (Act_home) n();
        }
        if (u() != null) {
            this.o0 = u().getBoolean("close", false);
        }
        super.o0(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == this.h0.getId()) {
            SwitchCompat switchCompat = this.i0;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
        if (view.getId() == this.k0.getId()) {
            F1(new Intent(p1(), Act_delete_mood_check.class));
        }
        if (view.getId() == this.m0.getId()) {
            g2();
        }
        if (view.getId() == this.l0.getId()) {
            h2();
        }
        if (view.getId() == this.j0.getId()) {
            F1(new Intent(p1(), Act_export_mood_check.class));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_manage_data, viewGroup, false);
        this.h0 = (LinearLayoutTracking) inflate.findViewById(R.id.manage_data_provide_analytics);
        this.i0 = (SwitchCompat) inflate.findViewById(R.id.manage_data_provide_analytics_switch);
        this.j0 = (LinearLayoutTracking) inflate.findViewById(R.id.manage_data_layout_export);
        this.k0 = (LinearLayoutTracking) inflate.findViewById(R.id.manage_data_layout_delete_mood_check_data);
        this.l0 = (LinearLayoutTracking) inflate.findViewById(R.id.manage_data_layout_reset_tool);
        this.m0 = (LinearLayoutTracking) inflate.findViewById(R.id.manage_data_layout_delete_all);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.e0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.f0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.g0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.d0.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
        this.f0.setOnClickListener(new h(this));
        if (this.o0) {
            this.f0.setImageResource(R.drawable.ef_ic_arrow_back);
        }
        this.g0.setVisibility(4);
        this.h0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.e0.setText(R.string.manage_data);
        AppCompatTextView appCompatTextView = this.e0;
        appCompatTextView.setContentDescription(Q(R.string.manage_data) + " " + Q(R.string.heading));
        if (j.s(n()).getBoolean("instrumentation_enabled", true)) {
            this.h0.setTrackingId("15744");
            this.h0.setContentDescription(Q(R.string.provide_anonymouse_usage_data_switch_activated));
            this.i0.setChecked(true);
        } else {
            this.h0.setTrackingId("15865");
            this.h0.setContentDescription(Q(R.string.provide_anonymouse_usage_data_switch_deactivated));
            this.i0.setChecked(false);
        }
        this.i0.setOnCheckedChangeListener(new a());
        this.n0 = new u(n());
        this.d0.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
        return inflate;
    }
}
