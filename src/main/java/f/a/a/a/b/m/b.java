package f.a.a.a.b.m;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_finding_treatment_for_veterans;

/* compiled from: Frag_tool_learn_finding_treatment */
public class b extends vainstrum.Components.b implements View.OnClickListener {
    private int c0 = 9001;
    private Button d0;
    private Button e0;
    private Button f0;
    private Button g0;

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            F1(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", "1-800-662-4357", null)));
        }
        if (view.getId() == this.e0.getId()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.addiction.com/meetingfinder/"));
            F1(intent);
        }
        if (view.getId() == this.f0.getId()) {
            H1(new Intent(n(), Act_finding_treatment_for_veterans.class), this.c0);
        }
        if (view.getId() == this.g0.getId()) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://findtreatment.samhsa.gov/locator"));
            F1(intent2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_finding_treatment, viewGroup, false);
        inflate.findViewById(R.id.bottom_tool_layout).setVisibility(8);
        this.d0 = (Button) inflate.findViewById(R.id.f_treatment_btn_talk_with_someone);
        this.e0 = (Button) inflate.findViewById(R.id.f_treatment_btn_find_recovery_groups);
        this.f0 = (Button) inflate.findViewById(R.id.f_treatment_btn_resources);
        Button button = (Button) inflate.findViewById(R.id.f_treatment_btn_samhsa);
        this.g0 = button;
        button.setOnClickListener(this);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        return inflate;
    }
}
