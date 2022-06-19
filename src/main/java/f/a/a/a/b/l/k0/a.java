package f.a.a.a.b.l.k0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_time_out_start */
public class a extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private AppCompatImageView g0;
    private Button h0;
    private b0 i0;
    private b0 j0;
    private a0 k0;
    private int l0;
    private String m0;
    private Boolean n0;
    private Boolean o0;
    private BroadcastReceiver p0;

    /* renamed from: f.a.a.a.b.l.k0.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_tool_time_out_start */
    class C0203a extends BroadcastReceiver {
        C0203a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (a.this.l0 == -1) {
                a.this.c0.finish();
            } else {
                a.this.c0.W(h.W1(a.this.i0, a.this.k0, a.this.l0, a.this.m0), a.this.Q(R.string.distress_meter));
            }
        }
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        this.n0 = bool;
        this.o0 = bool;
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
        n().unregisterReceiver(this.p0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.p0 = new C0203a();
        try {
            n().registerReceiver(this.p0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.i0);
        bundle.putSerializable("selected_tool", this.j0);
        bundle.putSerializable("symptom", this.k0);
        bundle.putInt("old_distress", this.l0);
        bundle.putString("last_tool_name", this.m0);
        super.K0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.i0 = (b0) bundle.getSerializable("tool");
            this.j0 = (b0) bundle.getSerializable("selected_tool");
            this.k0 = (a0) bundle.getSerializable("symptom");
            this.l0 = bundle.getInt("old_distress");
            this.m0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.i0 = (b0) u().getSerializable("tool");
            this.j0 = (b0) u().getSerializable("selected_tool");
            this.k0 = (a0) u().getSerializable("symptom");
            this.l0 = u().getInt("old_distress");
            this.m0 = u().getString("last_tool_name");
            d.u(n(), this.j0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.h0.getId()) {
            this.c0.W(b.l2(this.i0, this.j0, this.k0, this.l0, this.m0), Q(R.string.time_out_timer));
        }
        if (view.getId() == this.d0.getId()) {
            this.o0 = Boolean.valueOf(m.o(n(), this.j0, this.d0, this.e0, this.o0, this.n0));
            this.n0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.n0 = Boolean.valueOf(m.n(n(), this.j0, this.d0, this.e0, this.o0, this.n0));
            this.o0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.k0, this.i0, this.l0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_time_out_start, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.h0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_continue);
        this.g0 = (AppCompatImageView) inflate.findViewById(R.id.time_out_img);
        if (this.k0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.g0.getLayoutParams().height = m.H(n1());
        m.f0(this.j0.d(), this.d0, this.e0);
        this.o0 = Boolean.valueOf(m.C0(n(), this.j0.d(), this.d0, false));
        this.n0 = Boolean.valueOf(m.B0(n(), this.j0.d(), this.e0, false));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
    }
}
