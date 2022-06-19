package f.a.a.a.b.l.l0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatButton;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.d.d;
import f.a.a.a.b.f.i;
import f.a.a.a.b.i.h;
import f.a.a.a.b.l.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.r;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_familyAudio_intro */
public class b extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private ImageView d0;
    private AppCompatButton e0;
    private LinearLayout f0;
    private FABTracking g0;
    private FABTracking h0;
    private Button i0;
    private b0 j0;
    private b0 k0;
    private a0 l0;
    private int m0;
    private String n0;
    private Boolean o0;
    private Boolean p0;
    private d q0;
    private BroadcastReceiver r0;

    /* compiled from: Frag_tool_familyAudio_intro */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            b.this.c0.finish();
        }
    }

    /* renamed from: f.a.a.a.b.l.l0.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_tool_familyAudio_intro */
    class DialogInterface$OnClickListenerC0206b implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC0206b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            new f.a.a.a.b.p.a(b.this.n(), b.this.v(), new i()).execute(new Void[0]);
        }
    }

    /* compiled from: Frag_tool_familyAudio_intro */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (b.this.m0 == -1) {
                b.this.c0.finish();
            } else {
                b.this.c0.W(h.W1(b.this.j0, b.this.l0, b.this.m0, b.this.n0), b.this.Q(R.string.distress_meter));
            }
        }
    }

    public b() {
        Boolean bool = Boolean.FALSE;
        this.o0 = bool;
        this.p0 = bool;
    }

    public static b b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bVar.v1(bundle);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.r0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.r0 = new c();
        try {
            n().registerReceiver(this.r0, intentFilter);
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
        super.K0(bundle);
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
        } else if (u() != null) {
            this.j0 = (b0) u().getSerializable("tool");
            this.k0 = (b0) u().getSerializable("selected_tool");
            this.l0 = (a0) u().getSerializable("symptom");
            this.m0 = u().getInt("old_distress");
            this.n0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.k0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.g0.getId()) {
            this.p0 = Boolean.valueOf(m.o(n(), this.k0, this.g0, this.h0, this.p0, this.o0));
            this.o0 = Boolean.FALSE;
        }
        if (view.getId() == this.h0.getId()) {
            this.o0 = Boolean.valueOf(m.n(n(), this.k0, this.g0, this.h0, this.p0, this.o0));
            this.p0 = Boolean.FALSE;
        }
        if (view.getId() == this.i0.getId()) {
            m.c0(true, this.c0, this.l0, this.j0, this.m0);
        }
        if (view.getId() != this.e0.getId()) {
            return;
        }
        if (this.k0.d() == 5 || this.k0.d() == 20) {
            this.c0.W(d.p2(this.j0, this.k0, this.l0, this.m0, this.n0), this.q0.a());
        } else if (this.k0.d() == 56) {
            Act_manage act_manage = this.c0;
            b0 b0Var = this.j0;
            b0 b0Var2 = this.k0;
            act_manage.W(o.c2(b0Var, b0Var2, this.l0, this.m0, b0Var2.g()), this.q0.a());
        } else {
            this.c0.W(a.k2(this.j0, this.k0, this.l0, this.m0, this.n0, this.q0), this.q0.a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_family_audio_intro, viewGroup, false);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.h0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.i0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.e0 = (AppCompatButton) inflate.findViewById(R.id.audio_family_tool_intro_btn_continue);
        this.d0 = (ImageView) inflate.findViewById(R.id.audio_family_tool_intro_img);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.audio_family_tool_intro_layout_content);
        if (this.l0 == null) {
            this.i0.setVisibility(8);
        }
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        m.f0(this.k0.d(), this.g0, this.h0);
        this.p0 = Boolean.valueOf(m.C0(n(), this.k0.d(), this.g0, false));
        this.o0 = Boolean.valueOf(m.B0(n(), this.k0.d(), this.h0, false));
        this.q0 = m.u0(n(), this.k0.d());
        this.d0.getLayoutParams().height = m.H(n());
        g0.k(n(), D(), this.f0, this.q0.f(), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.d0.setImageResource(this.q0.e());
        if (gov.va.mobilehealth.ncptsd.covid.CComp.b0.a(this.c0).equals("es") && !r.a(n())) {
            b.a h2 = j.h(n(), Q(R.string.may_take_some_time_to_connect));
            h2.k(R.string.go_on, new DialogInterface$OnClickListenerC0206b());
            h2.h(R.string.cancel, new a());
            h2.a().show();
        }
        return inflate;
    }
}
