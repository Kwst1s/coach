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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.m0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.w;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_strenght;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_my_strenghts */
public class a0 extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private LinearLayout g0;
    private LinearLayout h0;
    private ImageView i0;
    private RecyclerView j0;
    private LinearLayout k0;
    private FABTracking l0;
    private b0 m0;
    private b0 n0;
    private f.a.a.a.b.d.a0 o0;
    private int p0;
    private String q0;
    private Boolean r0;
    private Boolean s0;
    private BroadcastReceiver t0;
    private ArrayList<w> u0;

    /* compiled from: Frag_tool_my_strenghts */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (a0.this.p0 == -1) {
                a0.this.c0.finish();
                return;
            }
            h W1 = h.W1(a0.this.m0, a0.this.o0, a0.this.p0, a0.this.q0);
            W1.V1(a0.this.R1());
            a0.this.c0.W(W1, a0.this.Q(R.string.distress_meter));
        }
    }

    public a0() {
        Boolean bool = Boolean.FALSE;
        this.r0 = bool;
        this.s0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(View view) {
        F1(new Intent(n(), Act_new_strenght.class));
    }

    public static a0 d2(b0 b0Var, b0 b0Var2, f.a.a.a.b.d.a0 a0Var, int i2, String str) {
        a0 a0Var2 = new a0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        a0Var2.v1(bundle);
        return a0Var2;
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
        e2();
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.m0);
        bundle.putSerializable("selected_tool", this.n0);
        bundle.putSerializable("symptom", this.o0);
        bundle.putInt("old_distress", this.p0);
        bundle.putString("last_tool_name", this.q0);
        super.K0(bundle);
    }

    public void e2() {
        ArrayList<w> x0 = new u(n()).x0();
        this.u0 = x0;
        if (!x0.isEmpty()) {
            this.h0.setVisibility(8);
            this.g0.setVisibility(0);
            this.j0.setAdapter(new m0(n(), this.u0));
            return;
        }
        this.h0.setVisibility(0);
        this.g0.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.m0 = (b0) bundle.getSerializable("tool");
            this.n0 = (b0) bundle.getSerializable("selected_tool");
            this.o0 = (f.a.a.a.b.d.a0) bundle.getSerializable("symptom");
            this.p0 = bundle.getInt("old_distress");
            this.q0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.m0 = (b0) u().getSerializable("tool");
            this.n0 = (b0) u().getSerializable("selected_tool");
            this.o0 = (f.a.a.a.b.d.a0) u().getSerializable("symptom");
            this.p0 = u().getInt("old_distress");
            this.q0 = u().getString("last_tool_name");
            d.u(n(), this.n0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.s0 = Boolean.valueOf(m.o(n(), this.n0, this.d0, this.e0, this.s0, this.r0));
            this.r0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.r0 = Boolean.valueOf(m.n(n(), this.n0, this.d0, this.e0, this.s0, this.r0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.o0, this.m0, this.p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_seeing_my_strenghts, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.l0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_add);
        this.g0 = (LinearLayout) inflate.findViewById(R.id.seeing_my_strenghts_layout);
        this.h0 = (LinearLayout) inflate.findViewById(R.id.seeing_my_strenghts_layout_no_elements);
        this.i0 = (ImageView) inflate.findViewById(R.id.seeing_my_strenghts_img);
        this.j0 = (RecyclerView) inflate.findViewById(R.id.seeing_my_strenghts_rview);
        this.k0 = (LinearLayout) inflate.findViewById(R.id.seeing_my_strenghts_layout_container);
        this.i0.getLayoutParams().height = m.H(this.c0);
        this.i0.setImageResource(R.drawable.t45);
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.n0.d(), this.d0, this.e0);
        this.s0 = Boolean.valueOf(m.C0(n(), this.n0.d(), this.d0, false));
        this.r0 = Boolean.valueOf(m.B0(n(), this.n0.d(), this.e0, false));
        try {
            g0.k(n(), D(), this.k0, j.N(n(), g.I), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.l0.setContentDescription(Q(R.string.add_strenght));
        this.l0.setOnClickListener(new f(this));
        if (this.o0 == null) {
            this.f0.setVisibility(8);
        }
        this.j0.setLayoutManager(new LinearLayoutManager(n()));
        this.j0.setHasFixedSize(true);
        return inflate;
    }
}
