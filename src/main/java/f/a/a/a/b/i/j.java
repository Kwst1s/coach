package f.a.a.a.b.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.k.d;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.b;

/* compiled from: Frag_high_distress */
public class j extends b implements View.OnClickListener {
    private Act_manage c0;
    private Button d0;
    private Button e0;
    private b0 f0;
    private a0 g0;
    private int h0;

    public static j W1(b0 b0Var, a0 a0Var, int i2, String str) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        jVar.v1(bundle);
        return jVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (u() != null) {
            this.f0 = (b0) u().getSerializable("tool");
            this.g0 = (a0) u().getSerializable("symptom");
            this.h0 = u().getInt("old_distress");
            u().getString("last_tool_name");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            m.c0(true, this.c0, this.g0, this.f0, this.h0);
        }
        if (view.getId() == this.e0.getId()) {
            d dVar = new d();
            dVar.V1(R1());
            this.c0.W(dVar, Q(R.string.crisis_resources));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_high_distress, (ViewGroup) null);
        this.d0 = (Button) inflate.findViewById(R.id.high_distress_btn_give_tool);
        this.e0 = (Button) inflate.findViewById(R.id.high_distress_btn_talk_someone);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        return inflate;
    }
}
