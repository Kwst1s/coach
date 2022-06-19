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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_general_tool_content_refresher */
public class o extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private FloatingActionButton f0;
    private FloatingActionButton g0;
    private FloatingActionButton h0;
    private FloatingActionButton i0;
    private FloatingActionButton j0;
    private FloatingActionButton k0;
    private Button l0;
    private Space m0;
    private AppCompatTextView n0;
    private b0 o0;
    private b0 p0;
    private a0 q0;
    private int r0;
    private String s0;
    private LinearLayout t0;
    private ImageView u0;
    private JSONArray v0;
    private Boolean w0;
    private Boolean x0;
    private BroadcastReceiver y0;
    private int z0 = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9580b;

        a(String str) {
            this.f9580b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f9580b));
            o.this.F1(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9582b;

        b(String str) {
            this.f9582b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f9582b);
            o oVar = o.this;
            oVar.F1(Intent.createChooser(intent, oVar.Q(R.string.share)));
        }
    }

    /* compiled from: Frag_general_tool_content_refresher */
    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                return;
            }
            if (o.this.r0 == -1) {
                o.this.c0.finish();
                return;
            }
            f.a.a.a.b.i.h W1 = f.a.a.a.b.i.h.W1(o.this.o0, o.this.q0, o.this.r0, o.this.s0);
            W1.V1(o.this.R1());
            o.this.c0.W(W1, o.this.Q(R.string.distress_meter));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9585b;

        d(String str) {
            this.f9585b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f9585b);
            o oVar = o.this;
            oVar.F1(Intent.createChooser(intent, oVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9587b;

        e(String str) {
            this.f9587b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("title", this.f9587b);
            o.this.F1(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9589b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9590c;

        f(String str, String str2) {
            this.f9589b = str;
            this.f9590c = str2;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", o.this.Q(R.string.heard_this_app) + " " + this.f9589b + "\n" + this.f9590c);
            o oVar = o.this;
            oVar.F1(Intent.createChooser(intent, oVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9592b;

        g(String str) {
            this.f9592b = str;
        }

        public void onClick(View view) {
            if (!this.f9592b.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f9592b));
                o.this.F1(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9594b;

        h(String str) {
            this.f9594b = str;
        }

        public void onClick(View view) {
            if (!this.f9594b.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f9594b));
                o.this.F1(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9596b;

        i(String str) {
            this.f9596b = str;
        }

        public void onClick(View view) {
            if (!this.f9596b.isEmpty()) {
                o.this.F1(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.f9596b, null)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9598b;

        j(String str) {
            this.f9598b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f9598b);
            o oVar = o.this;
            oVar.F1(Intent.createChooser(intent, oVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_content_refresher */
    public class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9600b;

        k(String str) {
            this.f9600b = str;
        }

        public void onClick(View view) {
            new SimpleDateFormat("yyyymmdd");
            Calendar.getInstance().add(3, 1);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("rrule", "FREQ=DAILY;UNTIL");
            intent.putExtra("title", this.f9600b);
            o.this.F1(intent);
        }
    }

    public o() {
        Boolean bool = Boolean.FALSE;
        this.w0 = bool;
        this.x0 = bool;
    }

    public static o c2(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str) {
        o oVar = new o();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        oVar.v1(bundle);
        return oVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.y0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.y0 = new c();
        try {
            n().registerReceiver(this.y0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.o0);
        bundle.putSerializable("selected_tool", this.p0);
        bundle.putSerializable("symptom", this.q0);
        bundle.putInt("old_distress", this.r0);
        bundle.putString("texts_to_show", this.v0.toString());
        bundle.putString("last_tool_name", this.s0);
        super.K0(bundle);
    }

    public int b2(JSONArray jSONArray, boolean z) {
        if (z) {
            int i2 = this.z0 + 1;
            this.z0 = i2;
            if (i2 == jSONArray.length()) {
                this.z0 = 0;
            }
        } else {
            int i3 = this.z0 - 1;
            this.z0 = i3;
            if (i3 < 0) {
                this.z0 = jSONArray.length() - 1;
            }
        }
        return this.z0;
    }

    public void d2(boolean z) {
        try {
            androidx.fragment.app.d n = n();
            this.v0 = new JSONArray(gov.va.mobilehealth.ncptsd.covid.CComp.j.N(n, gov.va.mobilehealth.ncptsd.covid.CComp.g.f10089i + File.separator + this.p0.c()));
            int i2 = -1;
            b0 b0Var = this.p0;
            if (b0Var == null) {
                b0 b0Var2 = this.o0;
                if (b0Var2 != null) {
                    i2 = b0Var2.d();
                }
            } else {
                i2 = b0Var.d();
            }
            String str = null;
            if (i2 == 52) {
                this.u0.getLayoutParams().height = m.H(n1());
                JSONObject jSONObject = this.v0.getJSONObject(this.z0);
                if (gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject, "message")) {
                    str = jSONObject.getString("message");
                }
                g2(jSONObject.getString("text"), jSONObject.getString("image"), str);
                if (!z) {
                    LinearLayout linearLayout = this.t0;
                    linearLayout.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject.getString("text")));
                }
                this.m0.setVisibility(0);
                this.f0.l();
                this.h0.l();
                this.g0.l();
            } else if (i2 != 56) {
                switch (i2) {
                    case 34:
                        this.m0.setVisibility(0);
                        ((LinearLayout.LayoutParams) this.k0.getLayoutParams()).setMarginEnd(K().getDimensionPixelSize(R.dimen.padding_small));
                        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
                        String string = this.v0.getString(this.z0);
                        k2(this.v0, string);
                        if (!z) {
                            LinearLayout linearLayout2 = this.t0;
                            linearLayout2.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(string));
                        }
                        this.g0.l();
                        this.f0.l();
                        this.h0.l();
                        this.i0.l();
                        return;
                    case 35:
                        this.n0.setVisibility(0);
                        this.n0.setText(R.string.positive_communication_txt_fix);
                        this.u0.getLayoutParams().height = m.H(n());
                        ImageView imageView = this.u0;
                        androidx.fragment.app.d n2 = n();
                        imageView.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(n2, "t" + i2));
                        JSONObject jSONObject2 = this.v0.getJSONObject(this.z0);
                        String string2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject2, "message") ? jSONObject2.getString("message") : null;
                        if (gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject2, "calendar")) {
                            str = jSONObject2.getString("calendar");
                        }
                        this.m0.setVisibility(0);
                        l2(this.v0, jSONObject2.getString("text"), string2, str);
                        if (!z) {
                            LinearLayout linearLayout3 = this.t0;
                            linearLayout3.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject2.getString("text")));
                        }
                        this.f0.l();
                        this.g0.l();
                        return;
                    case 36:
                        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
                        JSONObject jSONObject3 = this.v0.getJSONObject(this.z0);
                        e2(this.v0, jSONObject3.getString("text"), gov.va.mobilehealth.ncptsd.covid.CComp.j.m(n(), jSONObject3.getString("img")), jSONObject3.getString("link"), jSONObject3.getString("link_ios"));
                        if (!z) {
                            LinearLayout linearLayout4 = this.t0;
                            linearLayout4.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject3.getString("text")));
                        }
                        this.h0.l();
                        this.i0.l();
                        return;
                    case 37:
                        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
                        JSONObject jSONObject4 = this.v0.getJSONObject(this.z0);
                        h2(this.v0, jSONObject4.getString("text"), jSONObject4.getString("action"), jSONObject4.getString("action_text"), jSONObject4.getString("link"));
                        if (!z) {
                            LinearLayout linearLayout5 = this.t0;
                            linearLayout5.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject4.getString("text")));
                        }
                        this.h0.l();
                        this.f0.l();
                        this.g0.l();
                        this.i0.l();
                        return;
                    case 38:
                        this.n0.setVisibility(0);
                        this.n0.setText(R.string.reconnecting_parents_txt);
                        this.u0.getLayoutParams().height = m.H(n());
                        ImageView imageView2 = this.u0;
                        androidx.fragment.app.d n3 = n();
                        imageView2.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(n3, "t" + i2));
                        JSONObject jSONObject5 = this.v0.getJSONObject(this.z0);
                        String string3 = gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject5, "message") ? jSONObject5.getString("message") : null;
                        String string4 = gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject5, "calendar") ? jSONObject5.getString("calendar") : null;
                        String string5 = gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject5, "link") ? jSONObject5.getString("link") : null;
                        String string6 = gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject5, "action_text") ? jSONObject5.getString("action_text") : null;
                        this.m0.setVisibility(0);
                        m2(this.v0, jSONObject5.getString("text"), string3, string4, string5, string6);
                        if (!z) {
                            LinearLayout linearLayout6 = this.t0;
                            linearLayout6.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject5.getString("text")));
                        }
                        this.g0.l();
                        return;
                    case 39:
                        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
                        JSONObject jSONObject6 = this.v0.getJSONObject(this.z0);
                        j2(this.v0, jSONObject6.getString("text"), jSONObject6.getString("image"));
                        if (!z) {
                            LinearLayout linearLayout7 = this.t0;
                            linearLayout7.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject6.getString("text")));
                        }
                        this.f0.l();
                        this.h0.l();
                        this.g0.l();
                        this.i0.l();
                        return;
                    case 40:
                        this.n0.setVisibility(0);
                        this.n0.setText(R.string.arg_healthier_txt_fix);
                        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
                        String string7 = this.v0.getString(this.z0);
                        this.m0.setVisibility(0);
                        ((LinearLayout.LayoutParams) this.k0.getLayoutParams()).setMarginEnd(K().getDimensionPixelSize(R.dimen.padding_small));
                        f2(this.v0, string7);
                        if (!z) {
                            LinearLayout linearLayout8 = this.t0;
                            linearLayout8.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(string7));
                        }
                        this.f0.l();
                        this.g0.l();
                        this.h0.l();
                        this.i0.l();
                        return;
                    case 41:
                        this.u0.getLayoutParams().height = m.H(n());
                        JSONObject jSONObject7 = this.v0.getJSONObject(this.z0);
                        if (gov.va.mobilehealth.ncptsd.covid.CComp.j.F(jSONObject7, "action")) {
                            str = jSONObject7.getString("action");
                        }
                        n2(this.v0, jSONObject7.getString("text"), jSONObject7.getString("image"), str);
                        if (!z) {
                            LinearLayout linearLayout9 = this.t0;
                            linearLayout9.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject7.getString("text")));
                        }
                        this.f0.l();
                        this.h0.l();
                        this.g0.l();
                        this.i0.l();
                        return;
                    default:
                        return;
                }
            } else {
                this.u0.getLayoutParams().height = m.H(n1());
                JSONObject jSONObject8 = this.v0.getJSONObject(this.z0);
                i2(jSONObject8.getString("text"), jSONObject8.getString("image"));
                if (!z) {
                    LinearLayout linearLayout10 = this.t0;
                    linearLayout10.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject8.getString("text")));
                }
                this.m0.setVisibility(0);
                this.i0.l();
                this.f0.l();
                this.h0.l();
                this.g0.l();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void e2(JSONArray jSONArray, String str, int i2, String str2, String str3) {
        this.u0.setImageResource(i2);
        this.t0.removeAllViews();
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.g0.setOnClickListener(new f(str2, str3));
        this.f0.setOnClickListener(new g(str2));
    }

    public void f2(JSONArray jSONArray, String str) {
        this.t0.removeAllViews();
        this.u0.setImageResource(R.drawable.t40);
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void g2(String str, String str2, String str3) {
        this.t0.removeAllViews();
        this.u0.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(this.c0, str2));
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.i0.l();
        this.h0.l();
        if (str3 != null) {
            this.i0.t();
            this.i0.setOnClickListener(new b(str3));
        }
    }

    public void h2(JSONArray jSONArray, String str, String str2, String str3, String str4) {
        this.t0.removeAllViews();
        this.u0.setImageResource(R.drawable.t37);
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        if (str2.isEmpty()) {
            this.f0.l();
            return;
        }
        this.f0.t();
        if (str2.equals("app")) {
            this.f0.setOnClickListener(new h(str4));
        } else if (str2.equals("phone")) {
            this.f0.setOnClickListener(new i(str4));
        }
    }

    public void i2(String str, String str2) {
        this.t0.removeAllViews();
        this.u0.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(this.c0, str2));
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void j2(JSONArray jSONArray, String str, String str2) {
        this.t0.removeAllViews();
        this.u0.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(n(), str2));
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void k2(JSONArray jSONArray, String str) {
        this.t0.removeAllViews();
        this.u0.setImageResource(R.drawable.t34);
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void l2(JSONArray jSONArray, String str, String str2, String str3) {
        this.t0.removeAllViews();
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.i0.l();
        this.h0.l();
        if (str2 != null) {
            this.i0.t();
            this.i0.setOnClickListener(new d(str2));
        }
        if (str3 != null) {
            this.h0.t();
            this.h0.setOnClickListener(new e(str3));
        }
    }

    public void m2(JSONArray jSONArray, String str, String str2, String str3, String str4, String str5) {
        this.t0.removeAllViews();
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.i0.l();
        this.f0.l();
        this.h0.l();
        if (str2 != null) {
            this.i0.t();
            this.i0.setOnClickListener(new j(str2));
        }
        if (str3 != null) {
            this.h0.t();
            this.h0.setOnClickListener(new k(str3));
        }
        if (str4 != null) {
            this.f0.t();
            this.f0.setContentDescription(str5);
            this.f0.setOnClickListener(new a(str4));
        }
    }

    public void n2(JSONArray jSONArray, String str, String str2, String str3) {
        this.t0.removeAllViews();
        this.u0.setImageResource(gov.va.mobilehealth.ncptsd.covid.CComp.j.m(n(), str2));
        g0.k(n(), D(), this.t0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.o0 = (b0) bundle.getSerializable("tool");
            this.p0 = (b0) bundle.getSerializable("selected_tool");
            this.q0 = (a0) bundle.getSerializable("symptom");
            this.r0 = bundle.getInt("old_distress");
            this.s0 = bundle.getString("last_tool_name");
            String string = bundle.getString("texts_to_show");
            if (string != null) {
                try {
                    this.v0 = new JSONArray(string);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (u() != null) {
            this.o0 = (b0) u().getSerializable("tool");
            this.p0 = (b0) u().getSerializable("selected_tool");
            this.q0 = (a0) u().getSerializable("symptom");
            this.r0 = u().getInt("old_distress");
            this.s0 = u().getString("last_tool_name");
            k.b.d.u(n(), this.p0.g());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.x0 = Boolean.valueOf(m.o(n(), this.p0, this.d0, this.e0, this.x0, this.w0));
            this.w0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.w0 = Boolean.valueOf(m.n(n(), this.p0, this.d0, this.e0, this.x0, this.w0));
            this.x0 = Boolean.FALSE;
        }
        if (view.getId() == this.l0.getId()) {
            m.c0(true, this.c0, this.q0, this.o0, this.r0);
        }
        if (view.getId() == this.j0.getId()) {
            b2(this.v0, false);
            d2(false);
        }
        if (view.getId() == this.k0.getId()) {
            b2(this.v0, true);
            d2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_content_refresher, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_action);
        this.g0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_share);
        this.j0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.k0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.l0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.h0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_calendar);
        this.i0 = (FloatingActionButton) inflate.findViewById(R.id.bottom_tool_btn_message);
        this.u0 = (ImageView) inflate.findViewById(R.id.content_refresher_img);
        this.t0 = (LinearLayout) inflate.findViewById(R.id.content_refresher_layout_content);
        this.m0 = (Space) inflate.findViewById(R.id.bottom_tool_refresh_space);
        this.n0 = (AppCompatTextView) inflate.findViewById(R.id.content_refresher_txt_top_static);
        if (this.q0 == null) {
            this.l0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        int i2 = -1;
        b0 b0Var = this.p0;
        if (b0Var == null) {
            b0 b0Var2 = this.o0;
            if (b0Var2 != null) {
                i2 = b0Var2.d();
            }
        } else {
            i2 = b0Var.d();
        }
        if (i2 == 36) {
            this.d0.setSize(1);
            this.e0.setSize(1);
            this.f0.setSize(1);
            this.g0.setSize(1);
            this.h0.setSize(1);
            this.i0.setSize(1);
            this.j0.setSize(1);
            this.k0.setSize(1);
        }
        m.f0(this.p0.d(), this.d0, this.e0);
        this.x0 = Boolean.valueOf(m.C0(n(), this.p0.d(), this.d0, false));
        this.w0 = Boolean.valueOf(m.B0(n(), this.p0.d(), this.e0, false));
        this.u0.getLayoutParams().height = gov.va.mobilehealth.ncptsd.covid.CComp.j.r(n()) / 2;
        d2(true);
        return inflate;
    }
}
