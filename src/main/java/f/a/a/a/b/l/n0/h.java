package f.a.a.a.b.l.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_RID_start_decide */
public class h extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private TextView g0;
    private TextView h0;
    private TextView i0;
    private TextView j0;
    private b0 k0;
    private b0 l0;
    private a0 m0;
    private int n0;
    private String o0;
    private String p0;
    private String q0;
    private Boolean r0;
    private Boolean s0;
    private BroadcastReceiver t0;

    /* compiled from: Frag_tool_RID_start_decide */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                h.this.c0.W(b.X1(h.this.k0, h.this.l0, h.this.m0, h.this.n0, h.this.o0, h.this.p0, h.this.q0), h.this.Q(R.string.rid_decide));
            }
        }
    }

    public h() {
        Boolean bool = Boolean.FALSE;
        this.r0 = bool;
        this.s0 = bool;
    }

    public static h e2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, String str2, String str3) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putString("what", str2);
        bundle.putString("how", str3);
        hVar.v1(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.t0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.t0 = new a();
        try {
            n().registerReceiver(this.t0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.k0);
        bundle.putSerializable("selected_tool", this.l0);
        bundle.putSerializable("symptom", this.m0);
        bundle.putInt("old_distress", this.n0);
        bundle.putString("last_tool_name", this.o0);
        bundle.putString("what", this.p0);
        bundle.putString("how", this.q0);
        super.K0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.k0 = (b0) bundle.getSerializable("tool");
            this.l0 = (b0) bundle.getSerializable("selected_tool");
            this.m0 = (a0) bundle.getSerializable("symptom");
            this.n0 = bundle.getInt("old_distress");
            this.o0 = bundle.getString("last_tool_name");
            this.p0 = bundle.getString("what");
            this.q0 = bundle.getString("how");
        } else if (u() != null) {
            this.k0 = (b0) u().getSerializable("tool");
            this.l0 = (b0) u().getSerializable("selected_tool");
            this.m0 = (a0) u().getSerializable("symptom");
            this.n0 = u().getInt("old_distress");
            this.o0 = u().getString("last_tool_name");
            this.p0 = u().getString("what");
            this.q0 = u().getString("how");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.s0 = Boolean.valueOf(m.o(n(), this.l0, this.d0, this.e0, this.s0, this.r0));
            this.r0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.r0 = Boolean.valueOf(m.n(n(), this.l0, this.d0, this.e0, this.s0, this.r0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.m0, this.k0, this.n0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_next_steps, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (TextView) inflate.findViewById(R.id.rid_next_steps_txt_title);
        this.h0 = (TextView) inflate.findViewById(R.id.rid_next_steps_txt_subtitle);
        this.i0 = (TextView) inflate.findViewById(R.id.rid_next_steps_txt_content_1);
        this.j0 = (TextView) inflate.findViewById(R.id.rid_next_steps_txt_content_2);
        if (this.m0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.l0.d(), this.d0, this.e0);
        this.s0 = Boolean.valueOf(m.C0(n(), this.l0.d(), this.d0, false));
        this.r0 = Boolean.valueOf(m.B0(n(), this.l0.d(), this.e0, false));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Q(R.string.rid));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(b.h.d.a.b(n(), R.color.red)), 2, 3, 33);
        this.g0.setText(spannableStringBuilder);
        this.h0.setText(R.string.decide_what_to_do_now);
        this.i0.setText(Html.fromHtml(Q(R.string.rid_decide_text)));
        this.j0.setVisibility(8);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
    }
}
