package f.a.a.a.b.l.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.q;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_RID_summary */
public class j extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private TextView g0;
    private TextView h0;
    private TextView i0;
    private b0 j0;
    private b0 k0;
    private a0 l0;
    private int m0;
    private String n0;
    private String o0;
    private String p0;
    private String q0;
    private boolean r0 = false;
    private Boolean s0;
    private Boolean t0;
    private BroadcastReceiver u0;

    /* compiled from: Frag_tool_RID_summary */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                j.this.c2();
                if (j.this.m0 == -1) {
                    j.this.c0.finish();
                } else {
                    j.this.c0.W(h.W1(j.this.j0, j.this.l0, j.this.m0, j.this.n0), j.this.Q(R.string.distress_meter));
                }
            }
        }
    }

    public j() {
        Boolean bool = Boolean.FALSE;
        this.s0 = bool;
        this.t0 = bool;
    }

    public static j b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, String str2, String str3, String str4) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putString("what", str2);
        bundle.putString("how", str3);
        bundle.putString("decide", str4);
        jVar.v1(bundle);
        return jVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.u0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.u0 = new a();
        try {
            n().registerReceiver(this.u0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.j0);
        bundle.putSerializable("selected_tool", this.k0);
        bundle.putSerializable("symptom", this.l0);
        bundle.putInt("old_distress", this.m0);
        bundle.putString("last_tool_name", this.n0);
        bundle.putString("what", this.o0);
        bundle.putString("how", this.p0);
        bundle.putString("decide", this.q0);
        super.K0(bundle);
    }

    public void c2() {
        if (!this.r0) {
            new u(n()).M(new q(System.currentTimeMillis(), this.o0, this.p0, this.q0));
            this.r0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.j0 = (b0) bundle.getSerializable("tool");
            this.k0 = (b0) bundle.getSerializable("selected_tool");
            this.l0 = (a0) bundle.getSerializable("symptom");
            this.m0 = bundle.getInt("old_distress");
            this.n0 = bundle.getString("last_tool_name");
            this.o0 = bundle.getString("what");
            this.p0 = bundle.getString("how");
            this.q0 = bundle.getString("decide");
        } else if (u() != null) {
            this.j0 = (b0) u().getSerializable("tool");
            this.k0 = (b0) u().getSerializable("selected_tool");
            this.l0 = (a0) u().getSerializable("symptom");
            this.m0 = u().getInt("old_distress");
            this.n0 = u().getString("last_tool_name");
            this.o0 = u().getString("what");
            this.p0 = u().getString("how");
            this.q0 = u().getString("decide");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.t0 = Boolean.valueOf(m.o(n(), this.k0, this.d0, this.e0, this.t0, this.s0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.s0 = Boolean.valueOf(m.n(n(), this.k0, this.d0, this.e0, this.t0, this.s0));
            this.t0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.l0, this.j0, this.m0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_summary, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (TextView) inflate.findViewById(R.id.rid_summary_txt_what);
        this.h0 = (TextView) inflate.findViewById(R.id.rid_summary_txt_how);
        this.i0 = (TextView) inflate.findViewById(R.id.rid_summary_txt_decided);
        if (this.l0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.k0.d(), this.d0, this.e0);
        this.t0 = Boolean.valueOf(m.C0(n(), this.k0.d(), this.d0, false));
        this.s0 = Boolean.valueOf(m.B0(n(), this.k0.d(), this.e0, false));
        TextView textView = this.h0;
        textView.setText("· " + this.p0);
        TextView textView2 = this.g0;
        textView2.setText("· " + this.o0);
        TextView textView3 = this.i0;
        textView3.setText("· " + this.q0);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
    }
}
