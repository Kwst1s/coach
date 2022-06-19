package f.a.a.a.b.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.n;
import f.a.a.a.b.d.u;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs;
import gov.va.mobilehealth.ncptsd.covid.CComp.LinearLayoutButtonRole;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.m.b.f;

/* compiled from: Frag_learn_screen_layouted_healthcare.kt */
public final class d extends vainstrum.Components.b {
    public static final a g0 = new a(null);
    public androidx.appcompat.app.c c0;
    private u d0;
    private boolean e0 = true;
    private HashMap f0;

    /* compiled from: Frag_learn_screen_layouted_healthcare.kt */
    public static final class a {
        private a() {
        }

        public final d a(u uVar) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen", uVar);
            dVar.v1(bundle);
            return dVar;
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }

    /* compiled from: Frag_learn_screen_layouted_healthcare.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9371b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f9372c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u f9373d;

        b(d dVar, n nVar, u uVar) {
            this.f9371b = dVar;
            this.f9372c = nVar;
            this.f9373d = uVar;
        }

        public final void onClick(View view) {
            if (this.f9371b.Y1() instanceof Act_tabs) {
                androidx.appcompat.app.c Y1 = this.f9371b.Y1();
                Objects.requireNonNull(Y1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                g L1 = g.L1(this.f9372c, 0);
                u uVar = this.f9373d;
                f.d(uVar, "screen1");
                ((Act_tabs) Y1).Z(L1, uVar.c());
            } else if (this.f9371b.Y1() instanceof Act_single_covid_learn) {
                androidx.appcompat.app.c Y12 = this.f9371b.Y1();
                Objects.requireNonNull(Y12, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn");
                g L12 = g.L1(this.f9372c, 0);
                u uVar2 = this.f9373d;
                f.d(uVar2, "screen1");
                ((Act_single_covid_learn) Y12).W(L12, uVar2.c());
            }
        }
    }

    /* compiled from: Frag_learn_screen_layouted_healthcare.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9374b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f9375c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u f9376d;

        c(d dVar, n nVar, u uVar) {
            this.f9374b = dVar;
            this.f9375c = nVar;
            this.f9376d = uVar;
        }

        public final void onClick(View view) {
            if (this.f9374b.Y1() instanceof Act_tabs) {
                androidx.appcompat.app.c Y1 = this.f9374b.Y1();
                Objects.requireNonNull(Y1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                g L1 = g.L1(this.f9375c, 1);
                u uVar = this.f9376d;
                f.d(uVar, "screen2");
                ((Act_tabs) Y1).Z(L1, uVar.c());
            } else if (this.f9374b.Y1() instanceof Act_single_covid_learn) {
                androidx.appcompat.app.c Y12 = this.f9374b.Y1();
                Objects.requireNonNull(Y12, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn");
                g L12 = g.L1(this.f9375c, 1);
                u uVar2 = this.f9376d;
                f.d(uVar2, "screen2");
                ((Act_single_covid_learn) Y12).W(L12, uVar2.c());
            }
        }
    }

    /* renamed from: f.a.a.a.b.h.d$d  reason: collision with other inner class name */
    /* compiled from: Frag_learn_screen_layouted_healthcare.kt */
    static final class View$OnClickListenerC0187d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9377b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f9378c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u f9379d;

        View$OnClickListenerC0187d(d dVar, n nVar, u uVar) {
            this.f9377b = dVar;
            this.f9378c = nVar;
            this.f9379d = uVar;
        }

        public final void onClick(View view) {
            if (this.f9377b.Y1() instanceof Act_tabs) {
                androidx.appcompat.app.c Y1 = this.f9377b.Y1();
                Objects.requireNonNull(Y1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                g L1 = g.L1(this.f9378c, 2);
                u uVar = this.f9379d;
                f.d(uVar, "screen3");
                ((Act_tabs) Y1).Z(L1, uVar.c());
            } else if (this.f9377b.Y1() instanceof Act_single_covid_learn) {
                androidx.appcompat.app.c Y12 = this.f9377b.Y1();
                Objects.requireNonNull(Y12, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn");
                g L12 = g.L1(this.f9378c, 2);
                u uVar2 = this.f9379d;
                f.d(uVar2, "screen3");
                ((Act_single_covid_learn) Y12).W(L12, uVar2.c());
            }
        }
    }

    /* compiled from: Frag_learn_screen_layouted_healthcare.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9380b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f9381c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u f9382d;

        e(d dVar, n nVar, u uVar) {
            this.f9380b = dVar;
            this.f9381c = nVar;
            this.f9382d = uVar;
        }

        public final void onClick(View view) {
            if (this.f9380b.Y1() instanceof Act_tabs) {
                androidx.appcompat.app.c Y1 = this.f9380b.Y1();
                Objects.requireNonNull(Y1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_tabs");
                g L1 = g.L1(this.f9381c, 3);
                u uVar = this.f9382d;
                f.d(uVar, "screen4");
                ((Act_tabs) Y1).Z(L1, uVar.c());
            } else if (this.f9380b.Y1() instanceof Act_single_covid_learn) {
                androidx.appcompat.app.c Y12 = this.f9380b.Y1();
                Objects.requireNonNull(Y12, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Act_single_covid_learn");
                g L12 = g.L1(this.f9381c, 3);
                u uVar2 = this.f9382d;
                f.d(uVar2, "screen4");
                ((Act_single_covid_learn) Y12).W(L12, uVar2.c());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        u uVar = this.d0;
        f.c(uVar);
        g0.k(n(), D(), (LinearLayout) X1(o.screen_hc_layout), uVar.a(), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        if (this.e0) {
            androidx.fragment.app.d n = n();
            u uVar2 = this.d0;
            f.c(uVar2);
            k.b.d.r(n, uVar2.c());
        }
        u uVar3 = this.d0;
        f.c(uVar3);
        if (uVar3.d() == 5002) {
            ((NestedScrollView) X1(o.screen_hc_sview)).setBackgroundColor(-1);
        }
        u P = m.P(n(), "learn_hc_workers.json", 20101);
        u P2 = m.P(n(), "learn_hc_workers.json", 20102);
        u P3 = m.P(n(), "learn_hc_workers.json", 20103);
        u P4 = m.P(n(), "learn_hc_workers.json", 20104);
        ArrayList arrayList = new ArrayList();
        arrayList.add(P);
        arrayList.add(P2);
        arrayList.add(P3);
        arrayList.add(P4);
        n nVar = new n(BuildConfig.FLAVOR, arrayList, BuildConfig.FLAVOR);
        ((LinearLayoutButtonRole) X1(o.screen_hc_layout_l1)).setOnClickListener(new b(this, nVar, P));
        ((LinearLayoutButtonRole) X1(o.screen_hc_layout_l2)).setOnClickListener(new c(this, nVar, P2));
        ((LinearLayoutButtonRole) X1(o.screen_hc_layout_l3)).setOnClickListener(new View$OnClickListenerC0187d(this, nVar, P3));
        ((LinearLayoutButtonRole) X1(o.screen_hc_layout_l4)).setOnClickListener(new e(this, nVar, P4));
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

    public final androidx.appcompat.app.c Y1() {
        androidx.appcompat.app.c cVar = this.c0;
        if (cVar != null) {
            return cVar;
        }
        f.p("act");
        throw null;
    }

    public final void Z1(boolean z) {
        this.e0 = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (n1() instanceof Act_tabs) {
            Act_tabs act_tabs = (Act_tabs) n1();
            f.c(act_tabs);
            this.c0 = act_tabs;
        } else if (n1() instanceof Act_single_covid_learn) {
            Act_single_covid_learn act_single_covid_learn = (Act_single_covid_learn) n1();
            f.c(act_single_covid_learn);
            this.c0 = act_single_covid_learn;
        }
        if (u() != null) {
            Serializable serializable = o1().getSerializable("screen");
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.Screen");
            this.d0 = (u) serializable;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_learn_screen_layouted_healthcare, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
