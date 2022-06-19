package f.a.a.a.b.k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_support;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_support */
public class c extends b implements View.OnClickListener {
    private Act_tabs c0;
    private Act_support d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private LinearLayout g0;

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (n() instanceof Act_tabs) {
            this.c0 = (Act_tabs) n();
        } else {
            this.d0 = (Act_support) n();
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.e0.getId()) {
            Act_tabs act_tabs = this.c0;
            if (act_tabs != null) {
                d.l(act_tabs, m.D(act_tabs, R.string.crisis_resources), "support", null);
                this.c0.a0(new d(), Q(R.string.crisis_resources));
            } else {
                d.l(this.d0, m.D(act_tabs, R.string.crisis_resources), "support", null);
                this.d0.X(new d(), Q(R.string.crisis_resources));
            }
        }
        if (view.getId() == this.f0.getId()) {
            Act_tabs act_tabs2 = this.c0;
            if (act_tabs2 != null) {
                d.l(act_tabs2, m.D(act_tabs2, R.string.find_professional_care), "support", null);
                this.c0.a0(new e(), Q(R.string.find_professional_care));
            } else {
                d.l(this.d0, m.D(act_tabs2, R.string.find_professional_care), "support", null);
                this.d0.X(new e(), Q(R.string.find_professional_care));
            }
        }
        if (view.getId() == this.g0.getId()) {
            Act_tabs act_tabs3 = this.c0;
            if (act_tabs3 != null) {
                d.l(act_tabs3, m.D(act_tabs3, R.string.grow_your_support), "support", null);
                this.c0.a0(new f(), Q(R.string.grow_your_support));
                return;
            }
            d.l(this.d0, m.D(act_tabs3, R.string.grow_your_support), "support", null);
            this.d0.X(new f(), Q(R.string.grow_your_support));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_support, (ViewGroup) null);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.support_layout_crisis);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.support_layout_find_care);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.support_layout_grow_support);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        return inflate;
    }
}
