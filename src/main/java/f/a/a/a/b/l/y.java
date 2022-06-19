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
import org.json.JSONObject;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_leisure */
public class y extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private FABTracking g0;
    private Button h0;
    private AppCompatImageView i0;
    private AppCompatTextView j0;
    private LinearLayout k0;
    private ImageView l0;
    private TextView m0;
    private b0 n0;
    private b0 o0;
    private a0 p0;
    private int q0;
    private String r0;
    private String s0;
    private ArrayList<String> t0;
    private Boolean u0;
    private Boolean v0;
    private BroadcastReceiver w0;
    private int x0 = -1;

    /* compiled from: Frag_tool_leisure */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (y.this.q0 == -1) {
                y.this.c0.finish();
                return;
            }
            h W1 = h.W1(y.this.n0, y.this.p0, y.this.q0, y.this.r0);
            W1.V1(y.this.R1());
            y.this.c0.W(W1, y.this.Q(R.string.distress_meter));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_tool_leisure */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9615b;

        b(String str) {
            this.f9615b = str;
        }

        public void onClick(View view) {
            j.M(y.this.n1(), this.f9615b);
        }
    }

    public y() {
        Boolean bool = Boolean.FALSE;
        this.u0 = bool;
        this.v0 = bool;
    }

    public static y b2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, String str2) {
        y yVar = new y();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("type", str);
        bundle.putString("last_tool_name", str2);
        yVar.v1(bundle);
        return yVar;
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
        bundle.putSerializable("tool", this.n0);
        bundle.putSerializable("selected_tool", this.o0);
        bundle.putSerializable("symptom", this.p0);
        bundle.putInt("old_distress", this.q0);
        bundle.putStringArrayList("texts_to_show", this.t0);
        bundle.putString("last_tool_name", this.r0);
        super.K0(bundle);
    }

    public void c2(boolean z) {
        if (z) {
            int i2 = this.x0 + 1;
            this.x0 = i2;
            if (i2 >= this.t0.size()) {
                this.x0 = 0;
            }
        } else {
            int i3 = this.x0 - 1;
            this.x0 = i3;
            if (i3 < 0) {
                this.x0 = this.t0.size() - 1;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(this.t0.get(this.x0));
            String string = jSONObject.getString("content");
            String string2 = jSONObject.getString("link");
            this.m0.setText(string);
            this.m0.announceForAccessibility(Q(R.string.content_changed) + "\n" + this.t0.get(this.x0));
            if (string2.isEmpty()) {
                this.k0.setVisibility(8);
                return;
            }
            String string3 = jSONObject.getString("link_name");
            this.k0.setVisibility(0);
            this.j0.setText(string3);
            this.k0.setOnClickListener(new b(string2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void d2() {
        try {
            d n = n();
            JSONArray jSONArray = new JSONArray(j.N(n, g.f10089i + File.separator + this.o0.c()));
            this.t0 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getString("type").equals(this.s0)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("phrases");
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        this.t0.add(jSONArray2.getString(i3));
                    }
                }
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
            this.n0 = (b0) bundle.getSerializable("tool");
            this.o0 = (b0) bundle.getSerializable("selected_tool");
            this.p0 = (a0) bundle.getSerializable("symptom");
            this.q0 = bundle.getInt("old_distress");
            this.t0 = bundle.getStringArrayList("texts_to_show");
            this.s0 = bundle.getString("type");
            this.r0 = bundle.getString("last_tool_name");
        } else if (u() != null) {
            this.n0 = (b0) u().getSerializable("tool");
            this.o0 = (b0) u().getSerializable("selected_tool");
            this.p0 = (a0) u().getSerializable("symptom");
            this.q0 = u().getInt("old_distress");
            this.s0 = u().getString("type");
            this.r0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.o0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.f0.getId()) {
            c2(false);
        }
        if (view.getId() == this.g0.getId()) {
            c2(true);
        }
        if (view.getId() == this.d0.getId()) {
            this.v0 = Boolean.valueOf(m.o(n(), this.o0, this.d0, this.e0, this.v0, this.u0));
            this.u0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.u0 = Boolean.valueOf(m.n(n(), this.o0, this.d0, this.e0, this.v0, this.u0));
            this.v0 = Boolean.FALSE;
        }
        if (view.getId() == this.h0.getId()) {
            m.c0(true, this.c0, this.p0, this.n0, this.q0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_leisure, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.h0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.m0 = (TextView) inflate.findViewById(R.id.leisure_txt);
        this.l0 = (ImageView) inflate.findViewById(R.id.leisure_img);
        this.k0 = (LinearLayout) inflate.findViewById(R.id.leisure_btn_link);
        this.i0 = (AppCompatImageView) inflate.findViewById(R.id.button_link_with_image_img);
        this.j0 = (AppCompatTextView) inflate.findViewById(R.id.button_link_with_image_txt);
        this.i0.setImageResource(R.drawable.icon_web);
        if (this.p0 == null) {
            this.h0.setVisibility(8);
        }
        this.l0.getLayoutParams().height = j.r(n()) / 2;
        ImageView imageView = this.l0;
        Act_manage act_manage = this.c0;
        imageView.setImageResource(j.m(act_manage, "t" + this.o0.d()));
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        m.f0(this.o0.d(), this.d0, this.e0);
        this.v0 = Boolean.valueOf(m.C0(n(), this.o0.d(), this.d0, false));
        this.u0 = Boolean.valueOf(m.B0(n(), this.o0.d(), this.e0, false));
        if (this.t0 == null) {
            d2();
        } else {
            c2(true);
        }
        return inflate;
    }
}
