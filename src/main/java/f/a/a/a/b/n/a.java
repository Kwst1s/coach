package f.a.a.a.b.n;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.j;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_assessment_start;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals.Act_goals;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_track */
public class a extends b implements View.OnClickListener {
    private LinearLayout c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private LinearLayout g0;

    public void onClick(View view) {
        if (view.getId() == this.c0.getId()) {
            F1(new Intent(n(), Act_goals.class));
        }
        if (view.getId() == this.d0.getId()) {
            Intent intent = new Intent(n(), Act_assessment_start.class);
            intent.putExtra("type", 224);
            F1(intent);
        }
        if (view.getId() == this.e0.getId()) {
            Intent intent2 = new Intent(n(), Act_assessment_start.class);
            intent2.putExtra("type", 411);
            F1(intent2);
        }
        if (view.getId() == this.f0.getId()) {
            Intent intent3 = new Intent(n(), Act_assessment_start.class);
            intent3.putExtra("type", j.D0);
            F1(intent3);
        }
        if (view.getId() == this.g0.getId()) {
            Intent intent4 = new Intent(n(), Act_assessment_start.class);
            intent4.putExtra("type", j.I0);
            F1(intent4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_assess, (ViewGroup) null);
        this.c0 = (LinearLayout) inflate.findViewById(R.id.assess_layout_set_goal);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.assess_layout_well_being);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.assess_layout_anxiety);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.assess_layout_mood);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.assess_layout_ptsd_symptoms);
        this.c0.setOnClickListener(this);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        d.e(g.A0);
        return inflate;
    }
}
