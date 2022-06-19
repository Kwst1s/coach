package f.a.a.a.b.m;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_general_tool_learn_content_refresher */
public class a extends vainstrum.Components.b implements View.OnClickListener {
    private FABTracking c0;
    private FABTracking d0;
    private FABTracking e0;
    private FABTracking f0;
    private FABTracking g0;
    private FABTracking h0;
    private Space i0;
    private LinearLayout j0;
    private ImageView k0;
    private JSONArray l0;
    private int m0 = -1;
    private int n0 = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.m.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class View$OnClickListenerC0212a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9618b;

        View$OnClickListenerC0212a(String str) {
            this.f9618b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f9618b);
            a aVar = a.this;
            aVar.F1(Intent.createChooser(intent, aVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9620b;

        b(String str) {
            this.f9620b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("title", this.f9620b);
            a.this.F1(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9622b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9623c;

        c(String str, String str2) {
            this.f9622b = str;
            this.f9623c = str2;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", a.this.Q(R.string.heard_this_app) + " " + this.f9622b + "\n" + this.f9623c);
            a aVar = a.this;
            aVar.F1(Intent.createChooser(intent, aVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9625b;

        d(String str) {
            this.f9625b = str;
        }

        public void onClick(View view) {
            if (!this.f9625b.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f9625b));
                a.this.F1(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9627b;

        e(String str) {
            this.f9627b = str;
        }

        public void onClick(View view) {
            if (!this.f9627b.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f9627b));
                a.this.F1(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9629b;

        f(String str) {
            this.f9629b = str;
        }

        public void onClick(View view) {
            if (!this.f9629b.isEmpty()) {
                a.this.F1(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.f9629b, null)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9631b;

        g(String str) {
            this.f9631b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f9631b);
            a aVar = a.this;
            aVar.F1(Intent.createChooser(intent, aVar.Q(R.string.share)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9633b;

        h(String str) {
            this.f9633b = str;
        }

        public void onClick(View view) {
            new SimpleDateFormat("yyyymmdd");
            Calendar.getInstance().add(3, 1);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("rrule", "FREQ=DAILY;UNTIL");
            intent.putExtra("title", this.f9633b);
            a.this.F1(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_general_tool_learn_content_refresher */
    public class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9635b;

        i(String str) {
            this.f9635b = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f9635b));
            a.this.F1(intent);
        }
    }

    public static a X1(int i2, String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i2);
        bundle.putString("name", str);
        aVar.v1(bundle);
        return aVar;
    }

    public int W1(JSONArray jSONArray, boolean z) {
        if (z) {
            int i2 = this.n0 + 1;
            this.n0 = i2;
            if (i2 == jSONArray.length()) {
                this.n0 = 0;
            }
        } else {
            int i3 = this.n0 - 1;
            this.n0 = i3;
            if (i3 < 0) {
                this.n0 = jSONArray.length() - 1;
            }
        }
        return this.n0;
    }

    public void Y1(boolean z) {
        try {
            androidx.fragment.app.d n = n();
            JSONArray jSONArray = new JSONArray(j.N(n, gov.va.mobilehealth.ncptsd.covid.CComp.g.f10089i + File.separator + m.E(this.m0)));
            this.l0 = jSONArray;
            String str = null;
            switch (this.m0) {
                case 34:
                    this.i0.setVisibility(0);
                    ((LinearLayout.LayoutParams) this.h0.getLayoutParams()).setMarginEnd(K().getDimensionPixelSize(R.dimen.padding_small));
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    String string = this.l0.getString(this.n0);
                    d2(this.l0, string);
                    if (!z) {
                        LinearLayout linearLayout = this.j0;
                        linearLayout.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(string));
                    }
                    this.d0.l();
                    this.c0.l();
                    this.e0.l();
                    this.f0.l();
                    return;
                case 35:
                    this.k0.getLayoutParams().height = j.r(n()) / 9;
                    JSONObject jSONObject = this.l0.getJSONObject(this.n0);
                    String string2 = j.F(jSONObject, "message") ? jSONObject.getString("message") : null;
                    if (j.F(jSONObject, "calendar")) {
                        str = jSONObject.getString("calendar");
                    }
                    e2(this.l0, jSONObject.getString("text"), string2, str);
                    if (!z) {
                        LinearLayout linearLayout2 = this.j0;
                        linearLayout2.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject.getString("text")));
                    }
                    this.c0.l();
                    this.d0.l();
                    this.f0.l();
                    return;
                case 36:
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    JSONObject jSONObject2 = this.l0.getJSONObject(this.n0);
                    Z1(this.l0, jSONObject2.getString("text"), j.m(n(), jSONObject2.getString("img")), jSONObject2.getString("link"), jSONObject2.getString("link_ios"));
                    if (!z) {
                        LinearLayout linearLayout3 = this.j0;
                        linearLayout3.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject2.getString("text")));
                    }
                    this.e0.l();
                    this.f0.l();
                    return;
                case 37:
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    JSONObject jSONObject3 = this.l0.getJSONObject(this.n0);
                    b2(this.l0, jSONObject3.getString("text"), jSONObject3.getString("action"), jSONObject3.getString("action_text"), jSONObject3.getString("link"));
                    if (!z) {
                        LinearLayout linearLayout4 = this.j0;
                        linearLayout4.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject3.getString("text")));
                    }
                    this.e0.l();
                    this.c0.l();
                    this.d0.l();
                    this.f0.l();
                    return;
                case 38:
                    JSONObject jSONObject4 = jSONArray.getJSONObject(this.n0);
                    String string3 = j.F(jSONObject4, "message") ? jSONObject4.getString("message") : null;
                    String string4 = j.F(jSONObject4, "calendar") ? jSONObject4.getString("calendar") : null;
                    String string5 = j.F(jSONObject4, "link") ? jSONObject4.getString("link") : null;
                    if (j.F(jSONObject4, "action_text")) {
                        str = jSONObject4.getString("action_text");
                    }
                    this.k0.getLayoutParams().height = j.r(n()) / 5;
                    f2(this.l0, jSONObject4.getString("text"), string3, string4, string5, str);
                    if (!z) {
                        LinearLayout linearLayout5 = this.j0;
                        linearLayout5.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject4.getString("text")));
                    }
                    this.d0.l();
                    this.f0.l();
                    return;
                case 39:
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    JSONObject jSONObject5 = this.l0.getJSONObject(this.n0);
                    c2(this.l0, jSONObject5.getString("text"), jSONObject5.getString("image"));
                    if (!z) {
                        LinearLayout linearLayout6 = this.j0;
                        linearLayout6.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject5.getString("text")));
                    }
                    this.c0.l();
                    this.e0.l();
                    this.d0.l();
                    this.f0.l();
                    return;
                case 40:
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    String string6 = this.l0.getString(this.n0);
                    this.i0.setVisibility(0);
                    ((LinearLayout.LayoutParams) this.h0.getLayoutParams()).setMarginEnd(K().getDimensionPixelSize(R.dimen.padding_small));
                    a2(this.l0, string6);
                    if (!z) {
                        LinearLayout linearLayout7 = this.j0;
                        linearLayout7.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(string6));
                    }
                    this.c0.l();
                    this.d0.l();
                    this.e0.l();
                    this.f0.l();
                    return;
                case 41:
                    this.k0.getLayoutParams().height = j.r(n()) / 2;
                    JSONObject jSONObject6 = this.l0.getJSONObject(this.n0);
                    if (j.F(jSONObject6, "action")) {
                        str = jSONObject6.getString("action");
                    }
                    g2(this.l0, jSONObject6.getString("text"), jSONObject6.getString("image"), str);
                    if (!z) {
                        LinearLayout linearLayout8 = this.j0;
                        linearLayout8.announceForAccessibility(Q(R.string.content_changed) + "\n" + g0.h(jSONObject6.getString("text")));
                    }
                    this.c0.l();
                    this.e0.l();
                    this.d0.l();
                    this.f0.l();
                    return;
                default:
                    return;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void Z1(JSONArray jSONArray, String str, int i2, String str2, String str3) {
        this.k0.setImageResource(i2);
        this.j0.removeAllViews();
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.d0.setOnClickListener(new c(str2, str3));
        this.c0.setOnClickListener(new d(str2));
    }

    public void a2(JSONArray jSONArray, String str) {
        this.j0.removeAllViews();
        this.k0.setImageResource(R.drawable.t40);
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void b2(JSONArray jSONArray, String str, String str2, String str3, String str4) {
        this.j0.removeAllViews();
        this.k0.setImageResource(R.drawable.t37);
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        if (str2.isEmpty()) {
            this.c0.l();
            return;
        }
        this.c0.t();
        if (str2.equals("app")) {
            this.c0.setOnClickListener(new e(str4));
        } else if (str2.equals("phone")) {
            this.c0.setOnClickListener(new f(str4));
        }
    }

    public void c2(JSONArray jSONArray, String str, String str2) {
        this.j0.removeAllViews();
        this.k0.setImageResource(j.m(n(), str2));
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void d2(JSONArray jSONArray, String str) {
        this.j0.removeAllViews();
        this.k0.setImageResource(R.drawable.t34);
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    public void e2(JSONArray jSONArray, String str, String str2, String str3) {
        this.j0.removeAllViews();
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.c0.l();
        this.e0.l();
        if (str2 != null) {
            this.f0.t();
            this.f0.setOnClickListener(new View$OnClickListenerC0212a(str2));
        }
        if (str3 != null) {
            this.e0.t();
            this.e0.setOnClickListener(new b(str3));
        }
    }

    public void f2(JSONArray jSONArray, String str, String str2, String str3, String str4, String str5) {
        this.j0.removeAllViews();
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.f0.l();
        this.c0.l();
        this.e0.l();
        if (str2 != null) {
            this.f0.t();
            this.f0.setOnClickListener(new g(str2));
        }
        if (str3 != null) {
            this.e0.t();
            this.e0.setOnClickListener(new h(str3));
        }
        if (str4 != null) {
            this.c0.t();
            this.c0.setContentDescription(str5);
            this.c0.setOnClickListener(new i(str4));
        }
    }

    public void g2(JSONArray jSONArray, String str, String str2, String str3) {
        this.j0.removeAllViews();
        this.k0.setImageResource(j.m(n(), str2));
        g0.k(n(), D(), this.j0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (u() != null) {
            this.m0 = u().getInt("id");
            u().getString("name");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.g0.getId()) {
            W1(this.l0, false);
            Y1(false);
        }
        if (view.getId() == this.h0.getId()) {
            W1(this.l0, true);
            Y1(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_content_refresher, (ViewGroup) null);
        this.c0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_action);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_share);
        this.g0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_previous);
        this.h0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_next);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_calendar);
        this.f0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_message);
        this.k0 = (ImageView) inflate.findViewById(R.id.content_refresher_img);
        this.j0 = (LinearLayout) inflate.findViewById(R.id.content_refresher_layout_content);
        this.i0 = (Space) inflate.findViewById(R.id.bottom_tool_refresh_space);
        inflate.findViewById(R.id.bottom_tool_btn_thumb_up).setVisibility(8);
        inflate.findViewById(R.id.bottom_tool_btn_thumb_down).setVisibility(8);
        inflate.findViewById(R.id.bottom_tool_btn_new_tool).setVisibility(8);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.k0.getLayoutParams().height = j.r(n()) / 2;
        Y1(true);
        return inflate;
    }
}
