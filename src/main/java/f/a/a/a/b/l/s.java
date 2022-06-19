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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.d;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import org.json.JSONObject;
import vainstrum.Components.FABTracking;
import vainstrum.Components.b;

/* compiled from: Frag_tool_connect_with_others */
public class s extends b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private AppCompatImageView g0;
    private AppCompatTextView h0;
    private LinearLayout i0;
    private b0 j0;
    private b0 k0;
    private a0 l0;
    private int m0;
    private String n0;
    private TextView o0;
    private TextView p0;
    private FloatingActionButton q0;
    private FloatingActionButton r0;
    private ImageView s0;
    private JSONArray t0;
    private Boolean u0;
    private Boolean v0;
    private BroadcastReceiver w0;
    private int x0 = -1;

    /* compiled from: Frag_tool_connect_with_others */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (s.this.m0 == -1) {
                s.this.c0.finish();
                return;
            }
            h W1 = h.W1(s.this.j0, s.this.l0, s.this.m0, s.this.n0);
            W1.V1(s.this.R1());
            s.this.c0.W(W1, s.this.Q(R.string.distress_meter));
        }
    }

    public s() {
        Boolean bool = Boolean.FALSE;
        this.u0 = bool;
        this.v0 = bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(String str, View view) {
        j.M(n1(), str);
    }

    public static s d2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        s sVar = new s();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        sVar.v1(bundle);
        return sVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.w0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.w0 = new a();
        try {
            n().registerReceiver(this.w0, intentFilter);
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
        bundle.putString("texts_to_show", this.t0.toString());
        bundle.putString("last_tool_name", this.n0);
        super.K0(bundle);
    }

    public void e2(boolean z) {
        if (z) {
            try {
                int i2 = this.x0 + 1;
                this.x0 = i2;
                if (i2 >= this.t0.length()) {
                    this.x0 = 0;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            int i3 = this.x0 - 1;
            this.x0 = i3;
            if (i3 < 0) {
                this.x0 = this.t0.length() - 1;
            }
        }
        JSONObject jSONObject = this.t0.getJSONObject(this.x0);
        this.o0.setText(jSONObject.getString("title"));
        this.p0.setText(jSONObject.getString("content"));
        this.p0.announceForAccessibility(Q(R.string.content_changed) + "\n" + ((Object) this.o0.getText()) + ", " + ((Object) this.p0.getText()));
        if (j.F(jSONObject, "link")) {
            String string = jSONObject.getString("link");
            if (string.isEmpty()) {
                this.i0.setVisibility(8);
                return;
            }
            String string2 = jSONObject.getString("link_name");
            this.i0.setVisibility(0);
            this.h0.setText(string2);
            this.i0.setOnClickListener(new b(this, string));
            return;
        }
        this.i0.setVisibility(8);
    }

    public void f2() {
        try {
            d n = n();
            this.t0 = new JSONArray(j.N(n, g.f10089i + File.separator + this.k0.c()));
            e2(true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
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
            String string = bundle.getString("texts_to_show");
            if (string != null) {
                try {
                    this.t0 = new JSONArray(string);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
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
        if (view.getId() == this.q0.getId()) {
            e2(false);
        }
        if (view.getId() == this.r0.getId()) {
            e2(true);
        }
        if (view.getId() == this.d0.getId()) {
            this.v0 = Boolean.valueOf(m.o(n(), this.k0, this.d0, this.e0, this.v0, this.u0));
            this.u0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.u0 = Boolean.valueOf(m.n(n(), this.k0, this.d0, this.e0, this.v0, this.u0));
            this.v0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.l0, this.j0, this.m0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_connect_with_others, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.o0 = (TextView) inflate.findViewById(R.id.connect_others_txt_title);
        this.p0 = (TextView) inflate.findViewById(R.id.connect_others_txt_content);
        this.q0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.r0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.s0 = (ImageView) inflate.findViewById(R.id.connect_others_img);
        this.i0 = (LinearLayout) inflate.findViewById(R.id.connect_others_btn_link);
        this.g0 = (AppCompatImageView) inflate.findViewById(R.id.button_link_with_image_img);
        this.h0 = (AppCompatTextView) inflate.findViewById(R.id.button_link_with_image_txt);
        this.g0.setImageResource(R.drawable.icon_web);
        this.s0.getLayoutParams().height = m.H(n());
        this.s0.setImageResource(R.drawable.t4);
        if (this.l0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        m.f0(this.k0.d(), this.d0, this.e0);
        this.v0 = Boolean.valueOf(m.C0(n(), this.k0.d(), this.d0, false));
        this.u0 = Boolean.valueOf(m.B0(n(), this.k0.d(), this.e0, false));
        if (this.t0 == null) {
            f2();
        } else {
            e2(true);
        }
        return inflate;
    }
}
