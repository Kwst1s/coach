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
import f.a.a.a.b.e.e;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step1_my_ws;
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

/* compiled from: Frag_sp_step_1.kt */
public final class a extends vainstrum.Components.b {
    private ArrayList<e> c0;
    public LinearLayoutManager d0;
    private f e0;
    private HashMap f0;

    /* renamed from: f.a.a.a.b.j.a$a  reason: collision with other inner class name */
    /* compiled from: Frag_sp_step_1.kt */
    static final class View$OnClickListenerC0188a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f9392b;

        View$OnClickListenerC0188a(a aVar) {
            this.f9392b = aVar;
        }

        public final void onClick(View view) {
            this.f9392b.F1(new Intent(this.f9392b.n(), Act_sp_step1_my_ws.class));
        }
    }

    /* compiled from: Frag_sp_step_1.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f9393b;

        b(a aVar) {
            this.f9393b = aVar;
        }

        public final void onClick(View view) {
            this.f9393b.F1(new Intent(this.f9393b.n(), Act_sp_step1_my_ws.class));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_1.kt */
    public static final class c implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f9394a;

        c(a aVar) {
            this.f9394a = aVar;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            f Y1 = this.f9394a.Y1();
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
            ArrayList<e> arrayList = this.c0;
            kotlin.m.b.f.c(arrayList);
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                kotlin.m.b.f.d(next, "ws");
                jSONArray.put(next.a());
            }
            d n = n();
            kotlin.m.b.f.c(n);
            o.z(n, jSONArray);
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
        String N = j.N(n, h.f10100d);
        d n2 = n();
        kotlin.m.b.f.c(n2);
        g0.k(n2, D(), (LinearLayout) X1(f.a.a.a.b.o.sp_step_1_intro_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        ((ButtonTracking) X1(f.a.a.a.b.o.sp_step_1_btn_add_ws)).setOnClickListener(new View$OnClickListenerC0188a(this));
        ((ButtonTracking) X1(f.a.a.a.b.o.sp_step_1_btn_edit_ws)).setOnClickListener(new b(this));
        d n3 = n();
        kotlin.m.b.f.c(n3);
        this.d0 = new LinearLayoutManager(n3);
        int i2 = f.a.a.a.b.o.sp_step_1_rview;
        ((RecyclerView) X1(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) X1(i2);
        kotlin.m.b.f.d(recyclerView, "sp_step_1_rview");
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
        ArrayList<e> V = new z(n).V();
        this.c0 = new ArrayList<>();
        d n2 = n();
        kotlin.m.b.f.c(n2);
        JSONArray m = o.m(n2);
        int length = m.length();
        for (int i2 = 0; i2 < length; i2++) {
            Iterator<e> it = V.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                kotlin.m.b.f.d(next, "ws");
                int a2 = next.a();
                Object obj = m.get(i2);
                if ((obj instanceof Integer) && a2 == ((Integer) obj).intValue()) {
                    ArrayList<e> arrayList = this.c0;
                    kotlin.m.b.f.c(arrayList);
                    arrayList.add(next);
                    break;
                }
            }
        }
        d n3 = n();
        kotlin.m.b.f.c(n3);
        kotlin.m.b.f.d(n3, "activity!!");
        ArrayList<e> arrayList2 = this.c0;
        kotlin.m.b.f.c(arrayList2);
        f.a.a.a.b.c.j jVar = new f.a.a.a.b.c.j(n3, arrayList2, new c(this));
        int i3 = f.a.a.a.b.o.sp_step_1_rview;
        RecyclerView recyclerView = (RecyclerView) X1(i3);
        kotlin.m.b.f.d(recyclerView, "sp_step_1_rview");
        recyclerView.setAdapter(jVar);
        f fVar = this.e0;
        if (!(fVar == null || fVar == null)) {
            fVar.m(null);
        }
        f fVar2 = new f(new z0(jVar));
        this.e0 = fVar2;
        if (fVar2 != null) {
            fVar2.m((RecyclerView) X1(i3));
        }
    }

    public final void a2() {
        d n = n();
        kotlin.m.b.f.c(n);
        if (o.m(n).length() != 0) {
            LinearLayout linearLayout = (LinearLayout) X1(f.a.a.a.b.o.sp_step_1_layout_intro);
            kotlin.m.b.f.d(linearLayout, "sp_step_1_layout_intro");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_1_layout_contents);
            kotlin.m.b.f.d(linearLayout2, "sp_step_1_layout_contents");
            linearLayout2.setVisibility(0);
            Z1();
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_1_layout_intro);
        kotlin.m.b.f.d(linearLayout3, "sp_step_1_layout_intro");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = (LinearLayout) X1(f.a.a.a.b.o.sp_step_1_layout_contents);
        kotlin.m.b.f.d(linearLayout4, "sp_step_1_layout_contents");
        linearLayout4.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.m.b.f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_sp_step_1, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
