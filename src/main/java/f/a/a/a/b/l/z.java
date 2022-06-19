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
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.b.j0;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.o;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_my_feeling;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_my_feelings */
public class z extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private b0 g0;
    private b0 h0;
    private a0 i0;
    private int j0;
    private String k0;
    private Boolean l0;
    private Boolean m0;
    private BroadcastReceiver n0;
    private LinearLayout o0;
    private LinearLayout p0;
    private RecyclerView q0;
    private LinearLayout r0;
    private FloatingActionButton s0;
    private ArrayList<o> t0;

    /* compiled from: Frag_tool_my_feelings */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (z.this.j0 == -1) {
                z.this.c0.finish();
                return;
            }
            h W1 = h.W1(z.this.g0, z.this.i0, z.this.j0, z.this.k0);
            W1.V1(z.this.R1());
            z.this.c0.W(W1, z.this.Q(R.string.distress_meter));
        }
    }

    public z() {
        Boolean bool = Boolean.FALSE;
        this.l0 = bool;
        this.m0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(View view) {
        F1(new Intent(n(), Act_new_my_feeling.class));
    }

    public static z d2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        z zVar = new z();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        zVar.v1(bundle);
        return zVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.n0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.n0 = new a();
        try {
            n().registerReceiver(this.n0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        e2();
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.g0);
        bundle.putSerializable("selected_tool", this.h0);
        bundle.putSerializable("symptom", this.i0);
        bundle.putInt("old_distress", this.j0);
        bundle.putString("last_tool_name", this.k0);
        super.K0(bundle);
    }

    public void e2() {
        ArrayList<o> u0 = new u(n()).u0();
        this.t0 = u0;
        if (!u0.isEmpty()) {
            this.p0.setVisibility(8);
            this.o0.setVisibility(0);
            this.q0.setAdapter(new j0(n(), this.t0));
            return;
        }
        this.p0.setVisibility(0);
        this.o0.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.g0 = (b0) bundle.getSerializable("tool");
            this.h0 = (b0) bundle.getSerializable("selected_tool");
            this.i0 = (a0) bundle.getSerializable("symptom");
            this.j0 = bundle.getInt("old_distress");
            this.k0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.g0 = (b0) u().getSerializable("tool");
            this.h0 = (b0) u().getSerializable("selected_tool");
            this.i0 = (a0) u().getSerializable("symptom");
            this.j0 = u().getInt("old_distress");
            this.k0 = u().getString("last_tool_name");
            d.u(n(), this.h0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.m0 = Boolean.valueOf(m.o(n(), this.h0, this.d0, this.e0, this.m0, this.l0));
            this.l0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.l0 = Boolean.valueOf(m.n(n(), this.h0, this.d0, this.e0, this.m0, this.l0));
            this.m0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.i0, this.g0, this.j0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_my_feelings, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.s0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_add);
        this.q0 = (RecyclerView) inflate.findViewById(R.id.my_feelings_rview);
        this.r0 = (LinearLayout) inflate.findViewById(R.id.my_feelings_layout_container);
        this.o0 = (LinearLayout) inflate.findViewById(R.id.my_feelings_layout);
        this.p0 = (LinearLayout) inflate.findViewById(R.id.my_feelings_layout_no_elements);
        inflate.findViewById(R.id.my_feelings_img).getLayoutParams().height = m.H(n());
        try {
            g0.k(n(), D(), this.r0, j.N(n(), g.J), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.s0.setContentDescription(Q(R.string.add_a_feeling));
        this.s0.setOnClickListener(new e(this));
        if (this.i0 == null) {
            this.f0.setVisibility(8);
        }
        m.f0(this.h0.d(), this.d0, this.e0);
        this.m0 = Boolean.valueOf(m.C0(n(), this.h0.d(), this.d0, false));
        this.l0 = Boolean.valueOf(m.B0(n(), this.h0.d(), this.e0, false));
        this.q0.setLayoutManager(new LinearLayoutManager(n()));
        this.q0.setHasFixedSize(true);
        return inflate;
    }
}
