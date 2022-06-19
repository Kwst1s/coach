package f.a.a.a.b.l.n0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_RID_start */
public class g extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private Button g0;
    private Button h0;
    private b0 i0;
    private b0 j0;
    private a0 k0;
    private int l0;
    private String m0;
    private Boolean n0;
    private Boolean o0;

    public g() {
        Boolean bool = Boolean.FALSE;
        this.n0 = bool;
        this.o0 = bool;
    }

    public static g W1(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        gVar.v1(bundle);
        return gVar;
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
        if (view.getId() == this.g0.getId()) {
            this.c0.W(f.m2(this.i0, this.j0, this.k0, this.l0, this.m0), Q(R.string.rid_relax));
        }
        if (view.getId() == this.h0.getId()) {
            this.c0.W(new c(), Q(R.string.rid_history));
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
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_start, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (Button) inflate.findViewById(R.id.rid_btn_begin);
        this.h0 = (Button) inflate.findViewById(R.id.rid_btn_view_history);
        if (this.k0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
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
