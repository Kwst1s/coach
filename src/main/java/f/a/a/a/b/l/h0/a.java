package f.a.a.a.b.l.h0;

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
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tool_star;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_good_sleep_habits */
public class a extends b implements View.OnClickListener {
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
    private LinearLayout q0;
    private LinearLayout r0;

    /* renamed from: f.a.a.a.b.l.h0.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_tool_good_sleep_habits */
    class C0197a extends BroadcastReceiver {
        C0197a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (a.this.j0 == -1) {
                a.this.c0.finish();
            } else {
                a.this.c0.W(h.W1(a.this.g0, a.this.i0, a.this.j0, a.this.k0), a.this.Q(R.string.distress_meter));
            }
        }
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        this.l0 = bool;
        this.m0 = bool;
    }

    public static a b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        aVar.v1(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.n0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.n0 = new C0197a();
        try {
            n().registerReceiver(this.n0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
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
        if (view.getId() == this.o0.getId()) {
            Intent intent = new Intent(n(), Act_tool_star.class);
            intent.putExtra("tool_code", 1000);
            F1(intent);
        }
        if (view.getId() == this.p0.getId()) {
            Intent intent2 = new Intent(n(), Act_tool_star.class);
            intent2.putExtra("tool_code", 1001);
            F1(intent2);
        }
        if (view.getId() == this.q0.getId()) {
            Intent intent3 = new Intent(n(), Act_tool_star.class);
            intent3.putExtra("tool_code", 1002);
            F1(intent3);
        }
        if (view.getId() == this.r0.getId()) {
            Intent intent4 = new Intent(n(), Act_tool_star.class);
            intent4.putExtra("tool_code", 1003);
            F1(intent4);
        }
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
        View inflate = layoutInflater.inflate(R.layout.frag_tool_good_sleep_habits, viewGroup, false);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.o0 = (LinearLayout) inflate.findViewById(R.id.following_rules_layout_winding_down);
        this.p0 = (LinearLayout) inflate.findViewById(R.id.following_rules_layout_keep_awake);
        this.q0 = (LinearLayout) inflate.findViewById(R.id.following_rules_layout_cant_sleep);
        this.r0 = (LinearLayout) inflate.findViewById(R.id.following_rules_layout_help_wake_up);
        if (this.i0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.h0.d(), this.d0, this.e0);
        this.m0 = Boolean.valueOf(m.C0(n(), this.h0.d(), this.d0, false));
        this.l0 = Boolean.valueOf(m.B0(n(), this.h0.d(), this.e0, false));
        this.o0.setOnClickListener(this);
        this.p0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        return inflate;
    }
}
