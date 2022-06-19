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
import android.widget.TextView;
import androidx.fragment.app.d;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import f.a.a.a.b.i.h;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_grounding */
public class u extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private FABTracking g0;
    private Button h0;
    private ImageView i0;
    private TextView j0;
    private TextView k0;
    private b0 l0;
    private b0 m0;
    private a0 n0;
    private int o0;
    private String p0;
    private JSONArray q0;
    private Boolean r0;
    private Boolean s0;
    private BroadcastReceiver t0;
    private int u0 = -1;

    /* compiled from: Frag_tool_grounding */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (u.this.o0 == -1) {
                u.this.c0.finish();
                return;
            }
            h W1 = h.W1(u.this.l0, u.this.n0, u.this.o0, u.this.p0);
            W1.V1(u.this.R1());
            u.this.c0.W(W1, u.this.Q(R.string.distress_meter));
        }
    }

    public u() {
        Boolean bool = Boolean.FALSE;
        this.r0 = bool;
        this.s0 = bool;
    }

    public static u b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        u uVar = new u();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        uVar.v1(bundle);
        return uVar;
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
        bundle.putSerializable("tool", this.l0);
        bundle.putSerializable("selected_tool", this.m0);
        bundle.putSerializable("symptom", this.n0);
        bundle.putInt("old_distress", this.o0);
        bundle.putString("texts_to_show", this.q0.toString());
        bundle.putString("last_tool_name", this.p0);
        super.K0(bundle);
    }

    public void c2(boolean z) {
        if (z) {
            try {
                int i2 = this.u0 + 1;
                this.u0 = i2;
                if (i2 >= this.q0.length()) {
                    this.u0 = 0;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            int i3 = this.u0 - 1;
            this.u0 = i3;
            if (i3 < 0) {
                this.u0 = this.q0.length() - 1;
            }
        }
        this.j0.setText(this.q0.getJSONObject(this.u0).getString("title"));
        this.j0.setContentDescription(this.q0.getJSONObject(this.u0).getString("title") + " " + Q(R.string.heading));
        this.k0.setText(this.q0.getJSONObject(this.u0).getString("content"));
        this.k0.announceForAccessibility(Q(R.string.content_changed) + "\n" + ((Object) this.j0.getText()) + ", " + ((Object) this.k0.getText()));
    }

    public void d2() {
        try {
            d n = n();
            this.q0 = new JSONArray(j.N(n, g.f10089i + File.separator + this.m0.c()));
            c2(true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.l0 = (b0) bundle.getSerializable("tool");
            this.m0 = (b0) bundle.getSerializable("selected_tool");
            this.n0 = (a0) bundle.getSerializable("symptom");
            this.o0 = bundle.getInt("old_distress");
            String string = bundle.getString("texts_to_show");
            this.p0 = bundle.getString("last_tool_name");
            if (string != null) {
                try {
                    this.q0 = new JSONArray(string);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (u() != null) {
            this.l0 = (b0) u().getSerializable("tool");
            this.m0 = (b0) u().getSerializable("selected_tool");
            this.n0 = (a0) u().getSerializable("symptom");
            this.o0 = u().getInt("old_distress");
            this.p0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.m0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.f0.getId()) {
            c2(false);
            TextView textView = this.k0;
            textView.announceForAccessibility(this.j0.getText().toString() + " " + ((Object) this.k0.getText()));
        }
        if (view.getId() == this.g0.getId()) {
            c2(true);
            TextView textView2 = this.k0;
            textView2.announceForAccessibility(this.j0.getText().toString() + " " + ((Object) this.k0.getText()));
        }
        if (view.getId() == this.d0.getId()) {
            this.s0 = Boolean.valueOf(m.o(n(), this.m0, this.d0, this.e0, this.s0, this.r0));
            this.r0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.r0 = Boolean.valueOf(m.n(n(), this.m0, this.d0, this.e0, this.s0, this.r0));
            this.s0 = Boolean.FALSE;
        }
        if (view.getId() == this.h0.getId()) {
            m.c0(true, this.c0, this.n0, this.l0, this.o0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_grounding, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.h0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.i0 = (ImageView) inflate.findViewById(R.id.grounding_img);
        this.j0 = (TextView) inflate.findViewById(R.id.grounding_txt_title);
        this.k0 = (TextView) inflate.findViewById(R.id.grounding_txt_content);
        this.i0.getLayoutParams().height = m.H(n());
        this.i0.setImageResource(R.drawable.t6);
        if (this.n0 == null) {
            this.h0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        m.f0(this.m0.d(), this.d0, this.e0);
        this.s0 = Boolean.valueOf(m.C0(n(), this.m0.d(), this.d0, false));
        this.r0 = Boolean.valueOf(m.B0(n(), this.m0.d(), this.e0, false));
        if (this.q0 == null) {
            d2();
        } else {
            c2(true);
        }
        return inflate;
    }
}
