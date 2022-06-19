package f.a.a.a.b.g;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.f0;
import b.h.d.a;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_contacts;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_music;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_pictures;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.c;
import vainstrum.Components.LinearLayoutTracking;
import vainstrum.Components.b;

/* compiled from: Frag_personalize */
public class r extends b implements View.OnClickListener {
    private Act_home c0;
    private LinearLayout d0;
    private AppCompatTextView e0;
    private ImageView f0;
    private ImageView g0;
    private LinearLayoutTracking h0;
    private LinearLayoutTracking i0;
    private LinearLayoutTracking j0;
    private LinearLayoutTracking k0;
    private LinearLayoutTracking l0;
    private LinearLayoutTracking m0;
    private SwitchCompat n0;
    private SwitchCompat o0;
    private AppCompatTextView p0;

    /* access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ boolean Y1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.lang_en) {
            b0.e(n(), "en");
            c.c(W1());
            n().recreate();
            return true;
        }
        b0.e(n(), "es");
        c.c(W1());
        n().recreate();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void a2(View view) {
        Act_home act_home = this.c0;
        if (act_home != null) {
            act_home.r0();
        } else {
            n().finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(CompoundButton compoundButton, boolean z) {
        m.L0(n(), z);
        s.q(n(), this.k0, Q(R.string.inspiring_quotes_in_home), z);
        if (z) {
            this.k0.setTrackingId("11963");
        } else {
            this.k0.setTrackingId("12258");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void e2(CompoundButton compoundButton, boolean z) {
        m.J0(n(), z);
        s.q(n(), this.l0, Q(R.string.distress_meter), z);
        if (z) {
            this.l0.setTrackingId("12263");
        } else {
            this.l0.setTrackingId("12480");
        }
    }

    public String W1() {
        String a2 = b0.a(w());
        if (a2.equals("en") || a2.equals("es")) {
            return a2;
        }
        return "en";
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        if (n() instanceof Act_home) {
            this.c0 = (Act_home) n();
        }
        super.o0(bundle);
    }

    public void onClick(View view) {
        if (view.getId() == this.h0.getId()) {
            F1(new Intent(n(), Act_contacts.class));
        }
        if (view.getId() == this.i0.getId()) {
            Intent intent = new Intent(n(), Act_pictures.class);
            intent.putExtra("soothing", true);
            F1(intent);
        }
        if (view.getId() == this.j0.getId()) {
            Intent intent2 = new Intent(n(), Act_music.class);
            intent2.putExtra("soothing", true);
            F1(intent2);
        }
        if (view.getId() == this.k0.getId()) {
            SwitchCompat switchCompat = this.n0;
            switchCompat.setChecked(!switchCompat.isChecked());
        }
        if (view.getId() == this.l0.getId()) {
            SwitchCompat switchCompat2 = this.o0;
            switchCompat2.setChecked(!switchCompat2.isChecked());
        }
        if (view.getId() == this.m0.getId()) {
            f0 f0Var = new f0(n(), this.m0, 8388613);
            f0Var.b().inflate(R.menu.menu_lang, f0Var.a());
            f0Var.d(new i(this));
            f0Var.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_personalize, viewGroup, false);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.e0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.f0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.g0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.h0 = (LinearLayoutTracking) inflate.findViewById(R.id.setup_layout_contacts);
        this.i0 = (LinearLayoutTracking) inflate.findViewById(R.id.setup_layout_soothing_pictures);
        this.j0 = (LinearLayoutTracking) inflate.findViewById(R.id.setup_layout_soothing_songs);
        this.k0 = (LinearLayoutTracking) inflate.findViewById(R.id.settings_layout_coach);
        this.m0 = (LinearLayoutTracking) inflate.findViewById(R.id.settings_layout_language);
        this.n0 = (SwitchCompat) inflate.findViewById(R.id.settings_switch_coach);
        this.p0 = (AppCompatTextView) inflate.findViewById(R.id.settings_txt_language);
        this.l0 = (LinearLayoutTracking) inflate.findViewById(R.id.settings_layout_distress_meter);
        this.o0 = (SwitchCompat) inflate.findViewById(R.id.settings_switch_distress_meter);
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        if (this.c0 == null) {
            this.f0.setImageResource(R.drawable.full_arrow_left_white);
        }
        this.g0.setVisibility(4);
        this.f0.setOnClickListener(new l(this));
        if (m.c(n())) {
            this.n0.setChecked(true);
            this.k0.setTrackingId("11963");
            s.q(n(), this.k0, Q(R.string.inspiring_quotes_in_home), true);
        } else {
            this.n0.setChecked(false);
            this.k0.setTrackingId("12258");
            s.q(n(), this.k0, Q(R.string.inspiring_quotes_in_home), false);
        }
        this.l0.setVisibility(8);
        this.n0.setOnCheckedChangeListener(new j(this));
        this.o0.setOnCheckedChangeListener(new k(this));
        if (b0.a(n()).equals("es")) {
            this.p0.setText(R.string.spanish);
            LinearLayoutTracking linearLayoutTracking = this.m0;
            linearLayoutTracking.setContentDescription(Q(R.string.language) + " " + Q(R.string.spanish));
        } else {
            this.p0.setText(R.string.english);
            LinearLayoutTracking linearLayoutTracking2 = this.m0;
            linearLayoutTracking2.setContentDescription(Q(R.string.language) + " " + Q(R.string.english));
        }
        this.m0.setVisibility(0);
        this.e0.setText(R.string.personalize_short);
        AppCompatTextView appCompatTextView = this.e0;
        appCompatTextView.setContentDescription(Q(R.string.personalize_short) + " " + Q(R.string.heading));
        this.d0.setBackgroundColor(a.b(n(), R.color.colorPrimary));
        return inflate;
    }
}
