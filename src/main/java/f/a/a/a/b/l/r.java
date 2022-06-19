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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_change_perspective */
public class r extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private FABTracking g0;
    private Button h0;
    private ImageView i0;
    private TextView j0;
    private b0 k0;
    private b0 l0;
    private a0 m0;
    private int n0;
    private String o0;
    private ArrayList<String> p0;
    private Boolean q0;
    private Boolean r0;
    private BroadcastReceiver s0;
    private int t0 = -1;

    /* compiled from: Frag_tool_change_perspective */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (r.this.n0 == -1) {
                r.this.c0.finish();
                return;
            }
            h W1 = h.W1(r.this.k0, r.this.m0, r.this.n0, r.this.o0);
            W1.V1(r.this.R1());
            r.this.c0.W(W1, r.this.Q(R.string.distress_meter));
        }
    }

    public r() {
        Boolean bool = Boolean.FALSE;
        this.q0 = bool;
        this.r0 = bool;
    }

    public static r b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        r rVar = new r();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        rVar.v1(bundle);
        return rVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.s0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.s0 = new a();
        try {
            n().registerReceiver(this.s0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.k0);
        bundle.putSerializable("selected_tool", this.l0);
        bundle.putSerializable("symptom", this.m0);
        bundle.putInt("old_distress", this.n0);
        bundle.putStringArrayList("texts_to_show", this.p0);
        bundle.putString("last_tool_name", this.o0);
        super.K0(bundle);
    }

    public void c2(boolean z) {
        if (z) {
            int i2 = this.t0 + 1;
            this.t0 = i2;
            if (i2 >= this.p0.size()) {
                this.t0 = 0;
            }
        } else {
            int i3 = this.t0 - 1;
            this.t0 = i3;
            if (i3 < 0) {
                this.t0 = this.p0.size() - 1;
            }
        }
        this.j0.setText(this.p0.get(this.t0));
        this.j0.announceForAccessibility(Q(R.string.content_changed) + "\n" + this.p0.get(this.t0));
    }

    public void d2() {
        try {
            d n = n();
            JSONArray jSONArray = new JSONArray(j.N(n, g.f10089i + File.separator + this.l0.c()));
            this.p0 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.p0.add(jSONArray.getJSONObject(i2).getString("content"));
            }
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
            this.k0 = (b0) bundle.getSerializable("tool");
            this.l0 = (b0) bundle.getSerializable("selected_tool");
            this.m0 = (a0) bundle.getSerializable("symptom");
            this.n0 = bundle.getInt("old_distress");
            this.p0 = bundle.getStringArrayList("texts_to_show");
            this.o0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.k0 = (b0) u().getSerializable("tool");
            this.l0 = (b0) u().getSerializable("selected_tool");
            this.m0 = (a0) u().getSerializable("symptom");
            this.n0 = u().getInt("old_distress");
            this.o0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.l0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.f0.getId()) {
            c2(false);
            TextView textView = this.j0;
            textView.announceForAccessibility(textView.getText());
        }
        if (view.getId() == this.g0.getId()) {
            c2(true);
            TextView textView2 = this.j0;
            textView2.announceForAccessibility(textView2.getText());
        }
        if (view.getId() == this.d0.getId()) {
            this.r0 = Boolean.valueOf(m.o(n(), this.l0, this.d0, this.e0, this.r0, this.q0));
            this.q0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.q0 = Boolean.valueOf(m.n(n(), this.l0, this.d0, this.e0, this.r0, this.q0));
            this.r0 = Boolean.FALSE;
        }
        if (view.getId() == this.h0.getId()) {
            m.c0(true, this.c0, this.m0, this.k0, this.n0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_change_perspective, (ViewGroup) null);
        this.i0 = (ImageView) inflate.findViewById(R.id.change_perspective_img);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.h0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.j0 = (TextView) inflate.findViewById(R.id.change_perspective_txt);
        this.i0.getLayoutParams().height = m.H(n());
        this.i0.setImageResource(R.drawable.t3);
        if (this.m0 == null) {
            this.h0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.l0.d(), this.d0, this.e0);
        this.r0 = Boolean.valueOf(m.C0(n(), this.l0.d(), this.d0, false));
        this.q0 = Boolean.valueOf(m.B0(n(), this.l0.d(), this.e0, false));
        if (this.p0 == null) {
            d2();
        } else {
            c2(true);
        }
        return inflate;
    }
}
