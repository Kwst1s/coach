package f.a.a.a.b.k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import vainstrum.Components.b;

/* compiled from: Frag_support_find_care */
public class e extends b {
    private LinearLayout c0;

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_learn_screen_layouted, viewGroup, false);
        this.c0 = (LinearLayout) inflate.findViewById(R.id.screen_layout);
        inflate.findViewById(R.id.screen_img).setVisibility(8);
        try {
            g0.k(n(), D(), this.c0, j.N(n(), g.u), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return inflate;
    }
}
