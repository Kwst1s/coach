package f.a.a.a.b.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_home;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import vainstrum.Components.b;

/* compiled from: Frag_privacy */
public class s extends b {
    private Act_home c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private AppCompatTextView f0;
    private ImageView g0;
    private ImageView h0;

    /* compiled from: Frag_privacy */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            s.this.c0.r0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        this.c0 = (Act_home) n();
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_how_to_use, viewGroup, false);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.home_layout_toolbar);
        this.f0 = (AppCompatTextView) inflate.findViewById(R.id.home_txt_title);
        this.g0 = (ImageView) inflate.findViewById(R.id.home_icon_drawer);
        this.h0 = (ImageView) inflate.findViewById(R.id.home_icon_reminders);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.how_to_use_layout_content);
        this.f0.setText(R.string.privacy_policy);
        AppCompatTextView appCompatTextView = this.f0;
        appCompatTextView.setContentDescription(Q(R.string.privacy_policy) + " " + Q(R.string.heading));
        this.d0.setBackgroundColor(b.h.d.a.b(n(), R.color.colorPrimary));
        this.g0.setOnClickListener(new a());
        this.h0.setVisibility(4);
        try {
            g0.k(n(), D(), this.e0, j.N(n(), g.O), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return inflate;
    }
}
