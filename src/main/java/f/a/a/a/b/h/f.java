package f.a.a.a.b.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import vainstrum.Components.b;

/* compiled from: Frag_support_screen_layouted */
public class f extends b {
    private LinearLayout c0;
    private k d0;

    public static f W1(k kVar) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("screen", kVar);
        fVar.v1(bundle);
        return fVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.d0 = (k) u().getSerializable("screen");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_learn_screen_layouted, viewGroup, false);
        this.c0 = (LinearLayout) inflate.findViewById(R.id.screen_layout);
        inflate.findViewById(R.id.screen_img).setVisibility(8);
        g0.k(n(), D(), this.c0, this.d0.a(), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        return inflate;
    }
}
