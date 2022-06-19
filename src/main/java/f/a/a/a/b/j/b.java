package f.a.a.a.b.j;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.z0;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step2_coping_strategies;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import vainstrum.Components.ButtonTracking;

/* compiled from: Frag_sp_step_2.kt */
public final class b extends vainstrum.Components.b {
    private ArrayList<f.a.a.a.b.e.a> c0;
    public LinearLayoutManager d0;
    private f e0;
    private HashMap f0;

    /* compiled from: Frag_sp_step_2.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9395b;

        a(b bVar) {
            this.f9395b = bVar;
        }

        public final void onClick(View view) {
            this.f9395b.F1(new Intent(this.f9395b.n(), Act_sp_step2_coping_strategies.class));
        }
    }

    /* renamed from: f.a.a.a.b.j.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_sp_step_2.kt */
    static final class View$OnClickListenerC0189b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f9396b;

        View$OnClickListenerC0189b(b bVar) {
            this.f9396b = bVar;
        }

        public final void onClick(View view) {
            this.f9396b.F1(new Intent(this.f9396b.n(), Act_sp_step2_coping_strategies.class));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_2.kt */
    public static final class c implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f9397a;

        c(b bVar) {
            this.f9397a = bVar;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            f Y1 = this.f9397a.Y1();
            if (Y1 != null) {
                kotlin.m.b.f.c(d0Var);
                Y1.H(d0Var);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
        if (this.c0 != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList<f.a.a.a.b.e.a> arrayList = this.c0;
            kotlin.m.b.f.c(arrayList);
            Iterator<f.a.a.a.b.e.a> it = arrayList.iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.a next = it.next();
                kotlin.m.b.f.d(next, "cs");
                jSONArray.put(next.a());
            }
            d n = n();
            kotlin.m.b.f.c(n);
            o.u(n, jSONArray);
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        a2();
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        kotlin.m.b.f.e(view, "view");
        super.N0(view, bundle);
        d n = n();
        kotlin.m.b.f.c(n);
        String N = j.N(n, h.f10101e);
        d n2 = n();
        kotlin.m.b.f.c(n2);
        g0.k(n2, D(), (LinearLayout) X1(f.a.a.a.b.o.sp_step_2_intro_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        ((ButtonTracking) X1(f.a.a.a.b.o.sp_step_2_btn_add_coping_strategy)).setOnClickListener(new a(this));
        ((ButtonTracking) X1(f.a.a.a.b.o.sp_step_2_btn_edit_coping_strategies)).setOnClickListener(new View$OnClickListenerC0189b(this));
        d n3 = n();
        kotlin.m.b.f.c(n3);
        this.d0 = new LinearLayoutManager(n3);
        int i2 = f.a.a.a.b.o.sp_step_2_rview;
        ((RecyclerView) X1(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) X1(i2);
        kotlin.m.b.f.d(recyclerView, "sp_step_2_rview");
        LinearLayoutManager linearLayoutManager = this.d0;
        if (linearLayoutManager != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        } else {
            kotlin.m.b.f.p("layoutManager");
            throw null;
        }
    }

    public void W1() {
        HashMap hashMap = this.f0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.f0 == null) {
            this.f0 = new HashMap();
        }
        View view = (View) this.f0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.f0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final f Y1() {
        return this.e0;
    }

    public final void Z1() {
        d n = n();
        kotlin.m.b.f.c(n);
        ArrayList<f.a.a.a.b.e.a> P = new z(n).P();
        this.c0 = new ArrayList<>();
        d n2 = n();
        kotlin.m.b.f.c(n2);
        JSONArray g2 = o.g(n2);
        int length = g2.length();
        for (int i2 = 0; i2 < length; i2++) {
            Iterator<f.a.a.a.b.e.a> it = P.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f.a.a.a.b.e.a next = it.next();
                kotlin.m.b.f.d(next, "cs");
                int a2 = next.a();
                Object obj = g2.get(i2);
                if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                    ArrayList<f.a.a.a.b.e.a> arrayList = this.c0;
                    kotlin.m.b.f.c(arrayList);
                    arrayList.add(next);
                    break;
                }
            }
        }
        d n3 = n();
        kotlin.m.b.f.c(n3);
        kotlin.m.b.f.d(n3, "activity!!");
        ArrayList<f.a.a.a.b.e.a> arrayList2 = this.c0;
        kotlin.m.b.f.c(arrayList2);
        f.a.a.a.b.c.a aVar = new f.a.a.a.b.c.a(n3, arrayList2, new c(this));
        int i3 = f.a.a.a.b.o.sp_step_2_rview;
        RecyclerView recyclerView = (RecyclerView) X1(i3);
        kotlin.m.b.f.d(recyclerView, "sp_step_2_rview");
        recyclerView.setAdapter(aVar);
        f fVar = this.e0;
        if (!(fVar == null || fVar == null)) {
            fVar.m(null);
        }
        f fVar2 = new f(new z0(aVar));
        this.e0 = fVar2;
        if (fVar2 != null) {
            fVar2.m((RecyclerView) X1(i3));
        }
    }

    public final void a2() {
        d n = n();
        kotlin.m.b.f.c(n);
        if (o.g(n).length() != 0) {
            LinearLayout linearLayout = (LinearLayout) X1(f.a.a.a.b.o.sp_step_2_layout_intro);
            kotlin.m.b.f.d(linearLayout, "sp_step_2_layout_intro");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_2_layout_contents);
            kotlin.m.b.f.d(linearLayout2, "sp_step_2_layout_contents");
            linearLayout2.setVisibility(0);
            Z1();
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_2_layout_intro);
        kotlin.m.b.f.d(linearLayout3, "sp_step_2_layout_intro");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_2_layout_contents);
        kotlin.m.b.f.d(linearLayout4, "sp_step_2_layout_contents");
        linearLayout4.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.m.b.f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_sp_step_2, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
