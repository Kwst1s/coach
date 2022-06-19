package f.a.a.a.b.k;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f0;
import com.github.mikephil.charting.R;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.LinearLayoutButtonRole;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.HashMap;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONObject;
import vainstrum.Components.ButtonTracking;

/* compiled from: Frag_learn_screen_local_resources.kt */
public final class b extends vainstrum.Components.b {
    private String c0;
    private HashMap d0;

    /* compiled from: Frag_learn_screen_local_resources.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9443b;

        a(b bVar) {
            this.f9443b = bVar;
        }

        public final void onClick(View view) {
            k.b.d.k(this.f9443b.Q(R.string.visit_cdc_web));
            j.M(this.f9443b.n1(), "https://www.cdc.gov/coronavirus/2019-ncov/index.html");
        }
    }

    /* renamed from: f.a.a.a.b.k.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_learn_screen_local_resources.kt */
    static final class View$OnClickListenerC0194b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9444b;

        View$OnClickListenerC0194b(b bVar) {
            this.f9444b = bVar;
        }

        public final void onClick(View view) {
            k.b.d.k(this.f9444b.Q(R.string.select_state_territory));
            this.f9444b.a2();
        }
    }

    /* compiled from: Frag_learn_screen_local_resources.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9445b;

        c(b bVar) {
            this.f9445b = bVar;
        }

        public final void onClick(View view) {
            j.M(this.f9445b.n1(), this.f9445b.Y1());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_learn_screen_local_resources.kt */
    public static final class d implements f0.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f9446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f9447b;

        d(b bVar, JSONArray jSONArray) {
            this.f9446a = bVar;
            this.f9447b = jSONArray;
        }

        @Override // androidx.appcompat.widget.f0.d
        public final boolean onMenuItemClick(MenuItem menuItem) {
            JSONArray jSONArray = this.f9447b;
            f.d(menuItem, "item");
            JSONObject jSONObject = jSONArray.getJSONObject(menuItem.getItemId());
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.f9446a.X1(o.local_resources_txt_state_territory);
            f.d(appCompatTextView, "local_resources_txt_state_territory");
            appCompatTextView.setText(jSONObject.getString("name"));
            this.f9446a.Z1(jSONObject.getString("url"));
            Context w = this.f9446a.w();
            b bVar = this.f9446a;
            int i2 = o.local_resources_layout_state_territory;
            j.U(w, (LinearLayoutButtonRole) bVar.X1(i2), jSONObject.getString("name") + " " + " state selected");
            s.a((LinearLayoutButtonRole) this.f9446a.X1(i2));
            b bVar2 = this.f9446a;
            int i3 = o.local_resources_btn_find_resources;
            ButtonTracking buttonTracking = (ButtonTracking) bVar2.X1(i3);
            f.d(buttonTracking, "local_resources_btn_find_resources");
            buttonTracking.setAlpha(1.0f);
            ButtonTracking buttonTracking2 = (ButtonTracking) this.f9446a.X1(i3);
            f.d(buttonTracking2, "local_resources_btn_find_resources");
            buttonTracking2.setEnabled(true);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        AppCompatTextView appCompatTextView = (AppCompatTextView) X1(o.button_link_with_image_txt);
        f.d(appCompatTextView, "button_link_with_image_txt");
        appCompatTextView.setText(Q(R.string.visit_cdc_web));
        ((AppCompatImageView) X1(o.button_link_with_image_img)).setImageResource(R.drawable.icon_web);
        int i2 = o.button_link_with_image_layout;
        LinearLayoutButtonRole linearLayoutButtonRole = (LinearLayoutButtonRole) X1(i2);
        f.d(linearLayoutButtonRole, "button_link_with_image_layout");
        linearLayoutButtonRole.setContentDescription(Q(R.string.visit_cdc_web));
        ((LinearLayoutButtonRole) X1(i2)).setOnClickListener(new a(this));
        ((LinearLayoutButtonRole) X1(o.local_resources_layout_state_territory)).setOnClickListener(new View$OnClickListenerC0194b(this));
        ((ButtonTracking) X1(o.local_resources_btn_find_resources)).setOnClickListener(new c(this));
    }

    public void W1() {
        HashMap hashMap = this.d0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.d0 == null) {
            this.d0 = new HashMap();
        }
        View view = (View) this.d0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.d0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final String Y1() {
        return this.c0;
    }

    public final void Z1(String str) {
        this.c0 = str;
    }

    public final void a2() {
        JSONArray jSONArray = new JSONArray(j.N(p1(), g.M));
        f0 f0Var = new f0(p1(), (LinearLayoutButtonRole) X1(o.local_resources_layout_state_territory));
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            f0Var.a().add(-1, i2, i2, jSONArray.getJSONObject(i2).getString("name"));
        }
        f0Var.d(new d(this, jSONArray));
        f0Var.e();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_learn_screen_local_resources, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
