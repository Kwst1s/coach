package f.a.a.a.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_finding_treatment_for_veterans;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_finding_treatment */
public class t extends b implements View.OnClickListener {
    private int c0 = 9001;
    private Act_manage d0;
    private FABTracking e0;
    private FABTracking f0;
    private Button g0;
    private b0 h0;
    private b0 i0;
    private a0 j0;
    private int k0;
    private String l0;
    private Boolean m0;
    private Boolean n0;
    private BroadcastReceiver o0;
    private Button p0;
    private Button q0;
    private Button r0;
    private Button s0;

    /* compiled from: Frag_tool_finding_treatment */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (t.this.k0 == -1) {
                t.this.d0.finish();
                return;
            }
            h W1 = h.W1(t.this.h0, t.this.j0, t.this.k0, t.this.l0);
            W1.V1(t.this.R1());
            t.this.d0.W(W1, t.this.Q(R.string.distress_meter));
        }
    }

    public t() {
        Boolean bool = Boolean.FALSE;
        this.m0 = bool;
        this.n0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(View view) {
        this.n0 = Boolean.valueOf(m.o(n(), this.i0, this.e0, this.f0, this.n0, this.m0));
        this.m0 = Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void e2(View view) {
        this.m0 = Boolean.valueOf(m.n(n(), this.i0, this.e0, this.f0, this.n0, this.m0));
        this.n0 = Boolean.FALSE;
    }

    public static t f2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        t tVar = new t();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        tVar.v1(bundle);
        return tVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.o0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.o0 = new a();
        try {
            n().registerReceiver(this.o0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.d0 = (Act_manage) n();
        if (bundle != null) {
            this.h0 = (b0) bundle.getSerializable("tool");
            this.i0 = (b0) bundle.getSerializable("selected_tool");
            this.j0 = (a0) bundle.getSerializable("symptom");
            this.k0 = bundle.getInt("old_distress");
            this.l0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.h0 = (b0) u().getSerializable("tool");
            this.i0 = (b0) u().getSerializable("selected_tool");
            this.j0 = (a0) u().getSerializable("symptom");
            this.k0 = u().getInt("old_distress");
            this.l0 = u().getString("last_tool_name");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.p0.getId()) {
            F1(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", "1-800-662-4357", null)));
        }
        if (view.getId() == this.q0.getId()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.addiction.com/meetingfinder/"));
            F1(intent);
        }
        if (view.getId() == this.r0.getId()) {
            H1(new Intent(n(), Act_finding_treatment_for_veterans.class), this.c0);
        }
        if (view.getId() == this.s0.getId()) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://findtreatment.samhsa.gov/locator"));
            F1(intent2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_finding_treatment, viewGroup, false);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.g0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.p0 = (Button) inflate.findViewById(R.id.f_treatment_btn_talk_with_someone);
        this.q0 = (Button) inflate.findViewById(R.id.f_treatment_btn_find_recovery_groups);
        this.r0 = (Button) inflate.findViewById(R.id.f_treatment_btn_resources);
        this.s0 = (Button) inflate.findViewById(R.id.f_treatment_btn_samhsa);
        this.g0.setOnClickListener(this);
        this.p0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        this.s0.setOnClickListener(this);
        m.f0(this.i0.d(), this.e0, this.f0);
        this.n0 = Boolean.valueOf(m.C0(n(), this.i0.d(), this.e0, false));
        this.m0 = Boolean.valueOf(m.B0(n(), this.i0.d(), this.f0, false));
        if (this.j0 == null) {
            this.g0.setVisibility(8);
        }
        this.e0.setOnClickListener(new c(this));
        this.f0.setOnClickListener(new d(this));
        return inflate;
    }
}
