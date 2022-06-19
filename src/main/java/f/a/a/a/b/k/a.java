package f.a.a.a.b.k;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.c0;
import f.a.a.a.b.d.u;
import f.a.a.a.b.h.c;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_find_resources;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.p;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import k.b.d;
import kotlin.m.b.f;
import org.json.JSONArray;
import vainstrum.Components.b;

/* compiled from: Frag_find_resources.kt */
public final class a extends b {
    public ArrayList<u> c0;
    private HashMap d0;

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        if (f.a(b0.a(n()), "es")) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) X1(o.find_resources_btn_disclaimer);
            f.d(appCompatTextView, "find_resources_btn_disclaimer");
            appCompatTextView.setVisibility(0);
        } else {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) X1(o.find_resources_btn_disclaimer);
            f.d(appCompatTextView2, "find_resources_btn_disclaimer");
            appCompatTextView2.setVisibility(8);
        }
        int i2 = o.find_resources_rview;
        ((RecyclerView) X1(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) X1(i2);
        f.d(recyclerView, "find_resources_rview");
        recyclerView.setLayoutManager(new LinearLayoutManager(n1()));
        Z1();
        a2();
        d.e(g.B0);
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

    public final void Y1(u uVar) {
        f.e(uVar, "screen");
        d.k(uVar.c());
        if (uVar.d() == 10009) {
            b bVar = new b();
            if (n1() instanceof Act_tabs) {
                androidx.fragment.app.d n1 = n1();
                Objects.requireNonNull(n1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                Act_tabs act_tabs = (Act_tabs) n1;
                bVar.V1(act_tabs.getTitle().toString());
                act_tabs.a0(bVar, uVar.c());
            } else if (n1() instanceof Act_find_resources) {
                androidx.fragment.app.d n12 = n1();
                Objects.requireNonNull(n12, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_find_resources");
                Act_find_resources act_find_resources = (Act_find_resources) n12;
                bVar.V1(act_find_resources.getTitle().toString());
                act_find_resources.X(bVar, uVar.c());
            }
        } else {
            c Z1 = c.Z1(uVar, true);
            f.d(Z1, "frag");
            Z1.a2(false);
            if (n1() instanceof Act_tabs) {
                androidx.fragment.app.d n13 = n1();
                Objects.requireNonNull(n13, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                Act_tabs act_tabs2 = (Act_tabs) n13;
                Z1.V1(act_tabs2.getTitle().toString());
                act_tabs2.a0(Z1, uVar.c());
            } else if (n1() instanceof Act_find_resources) {
                androidx.fragment.app.d n14 = n1();
                Objects.requireNonNull(n14, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_find_resources");
                Act_find_resources act_find_resources2 = (Act_find_resources) n14;
                Z1.V1(act_find_resources2.getTitle().toString());
                act_find_resources2.X(Z1, uVar.c());
            }
        }
    }

    public final void Z1() {
        Context p1 = p1();
        String N = j.N(p1, g.f10082b + File.separator + "find_resources.json");
        this.c0 = new ArrayList<>();
        ArrayList<u> a2 = p.a(new JSONArray(N));
        f.d(a2, "C_F_Parse_Json.parseCovidLearn(jArr)");
        this.c0 = a2;
    }

    public final void a2() {
        ArrayList<u> arrayList = this.c0;
        if (arrayList != null) {
            c0 c0Var = new c0(this, arrayList);
            RecyclerView recyclerView = (RecyclerView) X1(o.find_resources_rview);
            f.d(recyclerView, "find_resources_rview");
            recyclerView.setAdapter(c0Var);
            return;
        }
        f.p("screens");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_find_resources, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
