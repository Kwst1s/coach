package f.a.a.a.b.k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.k;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_grow_support;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_support;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.p;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import vainstrum.Components.b;

/* compiled from: Frag_support_grow_support */
public class f extends b implements View.OnClickListener {
    private Act_tabs c0;
    private Act_support d0;
    private Act_grow_support e0;
    private LinearLayout f0;
    private LinearLayout g0;
    private LinearLayout h0;
    private ArrayList<k> i0;

    public void W1(k kVar) {
        Act_tabs act_tabs = this.c0;
        if (act_tabs != null) {
            act_tabs.a0(f.a.a.a.b.h.f.W1(kVar), kVar.c());
            return;
        }
        Act_support act_support = this.d0;
        if (act_support != null) {
            act_support.X(f.a.a.a.b.h.f.W1(kVar), kVar.c());
        } else {
            this.e0.W(f.a.a.a.b.h.f.W1(kVar), kVar.c());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (n() instanceof Act_tabs) {
            this.c0 = (Act_tabs) n();
        } else if (n() instanceof Act_support) {
            this.d0 = (Act_support) n();
        } else {
            this.e0 = (Act_grow_support) n();
        }
        try {
            this.i0 = p.b(new JSONArray(j.N(n(), g.v)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.f0.getId()) {
            W1(this.i0.get(0));
        }
        if (view.getId() == this.g0.getId()) {
            W1(this.i0.get(1));
        }
        if (view.getId() == this.h0.getId()) {
            W1(this.i0.get(2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_grow_support, (ViewGroup) null);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.grow_support_layout_someone_you_trust);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.grow_support_layout_feeling_alone);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.grow_support_layout_growing_support);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        return inflate;
    }
}
