package f.a.a.a.b.h;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.n;
import f.a.a.a.b.d.u;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.p;
import java.io.File;
import java.util.ArrayList;
import k.b.d;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Frag_learn_covid */
public class b extends vainstrum.Components.b implements View.OnClickListener {
    private Act_tabs c0;
    private LinearLayout d0;
    private LinearLayout e0;
    private LinearLayout f0;
    private LinearLayout g0;
    private LinearLayout h0;

    public static ArrayList<u> W1(Activity activity, String str) {
        String N = j.N(activity, g.f10082b + File.separator + str);
        ArrayList<u> arrayList = new ArrayList<>();
        try {
            return p.a(new JSONArray(N));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_tabs) n();
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.c0.Z(e.L1(new n(Q(R.string.staying_well), W1(n1(), "learn_staying_sane.json"), "learn_icon_learn")), Q(R.string.staying_well));
        }
        if (view.getId() == this.e0.getId()) {
            this.c0.Z(e.L1(new n(Q(R.string.staying_balanced), W1(n1(), "learn_staying_balanced.json"), "learn_icon_learn")), Q(R.string.staying_balanced));
        }
        if (view.getId() == this.f0.getId()) {
            this.c0.Z(e.L1(new n(Q(R.string.staying_together), W1(n1(), "learn_staying_together.json"), "learn_icon_learn")), Q(R.string.staying_together));
        }
        if (view.getId() == this.g0.getId()) {
            this.c0.Z(e.L1(new n(Q(R.string.staying_safe), W1(n1(), "learn_staying_safe.json"), "learn_icon_learn")), Q(R.string.staying_safe));
        }
        if (view.getId() == this.h0.getId()) {
            this.c0.Z(e.L1(new n(Q(R.string.staying_healthy), W1(n1(), "learn_staying_healthy.json"), "learn_icon_learn")), Q(R.string.staying_healthy));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_learn_covid, (ViewGroup) null);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.learn_covid_layout_learn_staying_sane);
        this.e0 = (LinearLayout) inflate.findViewById(R.id.learn_covid_layout_learn_staying_balanced);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.learn_covid_layout_learn_staying_together);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.learn_covid_layout_learn_staying_safe);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.learn_covid_layout_learn_staying_healthy);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        d.e(g.z0);
        return inflate;
    }
}
