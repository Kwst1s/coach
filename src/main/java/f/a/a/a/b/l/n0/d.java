package f.a.a.a.b.l.n0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.q;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.b;

/* compiled from: Frag_tool_RID_history_summary */
public class d extends b {
    private q c0;
    private TextView d0;
    private TextView e0;
    private TextView f0;
    private TextView g0;

    public static d W1(q qVar) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", qVar);
        dVar.v1(bundle);
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        Act_manage act_manage = (Act_manage) n();
        if (u() != null) {
            this.c0 = (q) u().getSerializable("tool");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_history_summary, (ViewGroup) null);
        this.d0 = (TextView) inflate.findViewById(R.id.rid_history_summary_txt_date);
        this.e0 = (TextView) inflate.findViewById(R.id.rid_history_summary_txt_what);
        this.f0 = (TextView) inflate.findViewById(R.id.rid_history_summary_txt_how);
        this.g0 = (TextView) inflate.findViewById(R.id.rid_history_summary_txt_decided);
        TextView textView = this.d0;
        textView.setText("· " + m.v0(this.c0.c()));
        TextView textView2 = this.f0;
        textView2.setText("· " + this.c0.a());
        TextView textView3 = this.e0;
        textView3.setText("· " + this.c0.e());
        TextView textView4 = this.g0;
        textView4.setText("· " + this.c0.d());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
    }
}
