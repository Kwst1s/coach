package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.g0;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.l;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_i_message;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_i_messages */
public class w extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private Button g0;
    private LinearLayout h0;
    private LinearLayout i0;
    private RecyclerView j0;
    private TextView k0;
    private LinearLayout l0;
    private ImageView m0;
    private b0 n0;
    private b0 o0;
    private a0 p0;
    private int q0;
    private String r0;
    private Boolean s0;
    private Boolean t0;
    private BroadcastReceiver u0;
    private ArrayList<l> v0;

    /* compiled from: Frag_tool_i_messages */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            w.this.F1(new Intent(w.this.n(), Act_new_i_message.class));
        }
    }

    /* compiled from: Frag_tool_i_messages */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (w.this.q0 == -1) {
                w.this.c0.finish();
                return;
            }
            h W1 = h.W1(w.this.n0, w.this.p0, w.this.q0, w.this.r0);
            W1.V1(w.this.R1());
            w.this.c0.W(W1, w.this.Q(R.string.distress_meter));
        }
    }

    public w() {
        Boolean bool = Boolean.FALSE;
        this.s0 = bool;
        this.t0 = bool;
    }

    public static w b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        w wVar = new w();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        wVar.v1(bundle);
        return wVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.u0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.u0 = new b();
        try {
            n().registerReceiver(this.u0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        c2();
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.n0);
        bundle.putSerializable("selected_tool", this.o0);
        bundle.putSerializable("symptom", this.p0);
        bundle.putInt("old_distress", this.q0);
        bundle.putString("last_tool_name", this.r0);
        super.K0(bundle);
    }

    public void c2() {
        ArrayList<l> s02 = new u(n()).s0();
        this.v0 = s02;
        if (!s02.isEmpty()) {
            this.i0.setVisibility(8);
            this.h0.setVisibility(0);
            this.j0.setAdapter(new g0(n(), this.v0));
            return;
        }
        this.i0.setVisibility(0);
        this.h0.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.n0 = (b0) bundle.getSerializable("tool");
            this.o0 = (b0) bundle.getSerializable("selected_tool");
            this.p0 = (a0) bundle.getSerializable("symptom");
            this.q0 = bundle.getInt("old_distress");
            this.r0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.n0 = (b0) u().getSerializable("tool");
            this.o0 = (b0) u().getSerializable("selected_tool");
            this.p0 = (a0) u().getSerializable("symptom");
            this.q0 = u().getInt("old_distress");
            this.r0 = u().getString("last_tool_name");
            d.u(n(), this.o0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.t0 = Boolean.valueOf(m.o(n(), this.o0, this.d0, this.e0, this.t0, this.s0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.s0 = Boolean.valueOf(m.n(n(), this.o0, this.d0, this.e0, this.t0, this.s0));
            this.t0 = Boolean.FALSE;
        }
        if (view.getId() == this.g0.getId()) {
            m.c0(true, this.c0, this.p0, this.n0, this.q0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_i_messages, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.g0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_add);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.i_messages_layout);
        this.i0 = (LinearLayout) inflate.findViewById(R.id.i_messages_layout_no_elements);
        this.j0 = (RecyclerView) inflate.findViewById(R.id.i_messages_rview);
        this.l0 = (LinearLayout) inflate.findViewById(R.id.i_messages_layout_container);
        this.m0 = (ImageView) inflate.findViewById(R.id.i_messages_limits_img);
        this.k0 = (TextView) inflate.findViewById(R.id.i_messages_top_txt);
        this.m0.getLayoutParams().height = m.H(n());
        this.m0.setImageResource(R.drawable.t44);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.k0.setText(R.string.find_time_share_i_messages);
        m.f0(this.o0.d(), this.d0, this.e0);
        this.t0 = Boolean.valueOf(m.C0(n(), this.o0.d(), this.d0, false));
        this.s0 = Boolean.valueOf(m.B0(n(), this.o0.d(), this.e0, false));
        try {
            gov.va.mobilehealth.ncptsd.covid.CComp.g0.k(n(), D(), this.l0, j.N(n(), g.H), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f0.setOnClickListener(new a());
        this.f0.setContentDescription(Q(R.string.add_i_message));
        if (this.p0 == null) {
            this.g0.setVisibility(8);
        }
        this.j0.setLayoutManager(new LinearLayoutManager(n()));
        this.j0.setHasFixedSize(true);
        return inflate;
    }
}
