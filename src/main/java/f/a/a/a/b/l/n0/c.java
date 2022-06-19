package f.a.a.a.b.l.n0;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.q;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import vainstrum.Components.b;

/* compiled from: Frag_tool_RID_history */
public class c extends b {
    private Act_manage c0;
    private ScrollView d0;
    private TableLayout e0;
    private TextView f0;
    private ArrayList<q> g0;

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(q qVar, View view) {
        this.c0.W(d.W1(qVar), Q(R.string.rid_summary));
    }

    public void Y1() {
        LayoutInflater layoutInflater = n().getLayoutInflater();
        for (int i2 = 0; i2 < this.g0.size(); i2++) {
            q qVar = this.g0.get(i2);
            View inflate = layoutInflater.inflate(R.layout.item_table, (ViewGroup) null);
            inflate.setBackgroundResource(R.drawable.custom_bg_transp_white);
            TextView textView = (TextView) inflate.findViewById(R.id.item_table_txt_2);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) inflate.findViewById(R.id.item_table_txt_1)).setText(m.v0(qVar.c()));
            textView.setText(qVar.e());
            inflate.setOnClickListener(new a(this, qVar));
            inflate.setContentDescription(m.s(n(), qVar));
            this.e0.addView(inflate);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_rid_history, (ViewGroup) null);
        this.d0 = (ScrollView) inflate.findViewById(R.id.rid_history_layout_table);
        this.e0 = (TableLayout) inflate.findViewById(R.id.rid_history_table);
        this.f0 = (TextView) inflate.findViewById(R.id.rid_history_txt_empty);
        ArrayList<q> w0 = new u(n()).w0();
        this.g0 = w0;
        if (w0 == null) {
            this.f0.setVisibility(0);
            this.d0.setVisibility(8);
        } else if (!w0.isEmpty()) {
            Y1();
            this.f0.setVisibility(8);
        } else {
            this.f0.setVisibility(0);
            this.d0.setVisibility(8);
        }
        return inflate;
    }
}
