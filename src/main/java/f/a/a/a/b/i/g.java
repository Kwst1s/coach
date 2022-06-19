package f.a.a.a.b.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.ButtonTracking;
import vainstrum.Components.b;

/* compiled from: Frag_distress_change */
public class g extends b implements View.OnClickListener {
    private Act_manage c0;
    private TextView d0;
    private ButtonTracking e0;
    private ButtonTracking f0;
    private b0 g0;
    private a0 h0;
    private int i0;
    private int j0;
    private String k0;

    public static g W1(b0 b0Var, a0 a0Var, int i2, int i3, String str) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putInt("cur_distress", i3);
        bundle.putString("last_tool_name", str);
        gVar.v1(bundle);
        return gVar;
    }

    public void X1() {
        int i2 = this.i0;
        int i3 = this.j0;
        if (i2 == i3) {
            StringBuilder sb = new StringBuilder(Q(R.string.distress_unchanged_1));
            sb.append(" ");
            sb.append(this.k0);
            sb.append(" ");
            sb.append(Q(R.string.distress_unchanged_2));
            this.d0.setText(sb);
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(Q(R.string.distress_decreased_1));
            sb2.append(" ");
            sb2.append(this.k0);
            sb2.append(" ");
            sb2.append(Q(R.string.distress_decreased_2));
            this.d0.setText(sb2);
        } else {
            StringBuilder sb3 = new StringBuilder(Q(R.string.distress_increased_1));
            sb3.append(" ");
            sb3.append(this.k0);
            sb3.append(" ");
            sb3.append(Q(R.string.distress_increased_2));
            this.d0.setText(sb3);
        }
        if (this.g0 == null) {
            this.e0.setTrackingId("29065");
            this.e0.setText(R.string.try_another_tool);
            this.e0.setContentDescription(Q(R.string.try_another_tool));
            return;
        }
        this.e0.setTrackingId("29204");
        this.e0.setText(R.string.use_this_tool_again);
        this.e0.setContentDescription(Q(R.string.use_this_tool_again));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (u() != null) {
            this.g0 = (b0) u().getSerializable("tool");
            this.h0 = (a0) u().getSerializable("symptom");
            this.i0 = u().getInt("old_distress");
            this.j0 = u().getInt("cur_distress");
            this.k0 = u().getString("last_tool_name");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.e0.getId()) {
            m.c0(false, this.c0, this.h0, this.g0, this.j0);
        }
        if (view.getId() == this.f0.getId()) {
            n().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.o0(bundle);
        View inflate = layoutInflater.inflate(R.layout.frag_distress_change, (ViewGroup) null);
        this.d0 = (TextView) inflate.findViewById(R.id.distress_change_txt);
        this.e0 = (ButtonTracking) inflate.findViewById(R.id.distress_change_btn_give_tool);
        this.f0 = (ButtonTracking) inflate.findViewById(R.id.distress_change_btn_exit);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        X1();
        return inflate;
    }
}
