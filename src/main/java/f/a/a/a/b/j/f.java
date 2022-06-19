package f.a.a.a.b.j;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.z0;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_congrats;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_step6_env_safe;
import gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_steps;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import vainstrum.Components.ButtonTracking;

/* compiled from: Frag_sp_step_6.kt */
public final class f extends vainstrum.Components.b {
    private final int c0 = 37;
    private final int d0 = 38;
    private final int e0 = 39;
    private ArrayList<f.a.a.a.b.e.d> f0;
    private ArrayList<f.a.a.a.b.e.b> g0;
    public Act_sp_steps h0;
    public z i0;
    public LinearLayoutManager j0;
    public LinearLayoutManager k0;
    private androidx.recyclerview.widget.f l0;
    private androidx.recyclerview.widget.f m0;
    private HashMap n0;

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9430b;

        a(f fVar) {
            this.f9430b = fVar;
        }

        public final void run() {
            Intent intent = new Intent(this.f9430b.Z1(), Act_sp_congrats.class);
            intent.putExtra("step", 6);
            intent.putExtra("step_variant", 2);
            this.f9430b.F1(intent);
        }
    }

    /* compiled from: Frag_sp_step_6.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9431b;

        b(f fVar) {
            this.f9431b = fVar;
        }

        public final void onClick(View view) {
            this.f9431b.F1(new Intent(this.f9431b.n(), Act_sp_step6_env_safe.class));
        }
    }

    /* compiled from: Frag_sp_step_6.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9432b;

        c(f fVar) {
            this.f9432b = fVar;
        }

        public final void onClick(View view) {
            this.f9432b.F1(new Intent(this.f9432b.n(), Act_sp_step6_env_safe.class));
        }
    }

    /* compiled from: Frag_sp_step_6.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9433b;

        d(f fVar) {
            this.f9433b = fVar;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f9433b.Z1(), "android.permission.READ_CONTACTS") != 0) {
                f fVar = this.f9433b;
                fVar.m1(new String[]{"android.permission.READ_CONTACTS"}, fVar.c2());
                return;
            }
            this.f9433b.g2();
        }
    }

    /* compiled from: Frag_sp_step_6.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9434b;

        e(f fVar) {
            this.f9434b = fVar;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f9434b.Z1(), "android.permission.READ_CONTACTS") != 0) {
                f fVar = this.f9434b;
                fVar.m1(new String[]{"android.permission.READ_CONTACTS"}, fVar.c2());
                return;
            }
            this.f9434b.g2();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.j.f$f  reason: collision with other inner class name */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class C0193f implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f9435a;

        C0193f(f fVar) {
            this.f9435a = fVar;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            androidx.recyclerview.widget.f d2 = this.f9435a.d2();
            if (d2 != null) {
                kotlin.m.b.f.c(d0Var);
                d2.H(d0Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class g implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f9436a;

        g(f fVar) {
            this.f9436a = fVar;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            androidx.recyclerview.widget.f d2 = this.f9436a.d2();
            if (d2 != null) {
                kotlin.m.b.f.c(d0Var);
                d2.H(d0Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9438c;

        h(f fVar, TextView textView) {
            this.f9437b = fVar;
            this.f9438c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9438c;
            kotlin.m.b.f.d(textView, "txt_choose");
            k.b.d.k(textView.getText().toString());
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            f fVar = this.f9437b;
            fVar.H1(intent, fVar.b2());
            this.f9437b.Z1().Y().q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9439b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9440c;

        i(f fVar, TextView textView) {
            this.f9439b = fVar;
            this.f9440c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9440c;
            kotlin.m.b.f.d(textView, "txt_create");
            k.b.d.k(textView.getText().toString());
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/raw_contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            f fVar = this.f9439b;
            fVar.H1(intent, fVar.a2());
            this.f9439b.Z1().Y().q();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_sp_step_6.kt */
    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f9442c;

        j(f fVar, TextView textView) {
            this.f9441b = fVar;
            this.f9442c = textView;
        }

        public final void onClick(View view) {
            TextView textView = this.f9442c;
            kotlin.m.b.f.d(textView, "txt_cancel");
            k.b.d.k(textView.getText().toString());
            this.f9441b.Z1().Y().q();
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        super.E0();
        e2();
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(int i2, String[] strArr, int[] iArr) {
        kotlin.m.b.f.e(strArr, "permissions");
        kotlin.m.b.f.e(iArr, "grantResults");
        if (i2 == this.e0) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                g2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        h2();
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        kotlin.m.b.f.e(view, "view");
        super.N0(view, bundle);
        ((ButtonTracking) X1(o.sp_step_6_btn_ways_keep_environment_safe)).setOnClickListener(new b(this));
        ((ButtonTracking) X1(o.sp_step_6_btn_edit_safety_options)).setOnClickListener(new c(this));
        ((ButtonTracking) X1(o.sp_step_6_btn_add_people_who_can_help_me)).setOnClickListener(new d(this));
        ((ButtonTracking) X1(o.sp_step_6_btn_edit_contacts)).setOnClickListener(new e(this));
        androidx.fragment.app.d n = n();
        kotlin.m.b.f.c(n);
        String N = gov.va.mobilehealth.ncptsd.covid.CComp.j.N(n, gov.va.mobilehealth.ncptsd.covid.CComp.h.f10106j);
        androidx.fragment.app.d n2 = n();
        kotlin.m.b.f.c(n2);
        g0.k(n2, D(), (LinearLayout) X1(o.sp_step_6_intro_content), N, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        androidx.fragment.app.d n3 = n();
        kotlin.m.b.f.c(n3);
        this.i0 = new z(n3);
        androidx.fragment.app.d n4 = n();
        kotlin.m.b.f.c(n4);
        this.j0 = new LinearLayoutManager(n4);
        int i2 = o.sp_step_6_layout_rview_contacts;
        ((RecyclerView) X1(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) X1(i2);
        kotlin.m.b.f.d(recyclerView, "sp_step_6_layout_rview_contacts");
        LinearLayoutManager linearLayoutManager = this.j0;
        if (linearLayoutManager != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView2 = (RecyclerView) X1(i2);
            kotlin.m.b.f.d(recyclerView2, "sp_step_6_layout_rview_contacts");
            recyclerView2.setNestedScrollingEnabled(false);
            androidx.fragment.app.d n5 = n();
            kotlin.m.b.f.c(n5);
            this.k0 = new LinearLayoutManager(n5);
            int i3 = o.sp_step_6_layout_rview_ideas;
            ((RecyclerView) X1(i3)).setHasFixedSize(true);
            RecyclerView recyclerView3 = (RecyclerView) X1(i3);
            kotlin.m.b.f.d(recyclerView3, "sp_step_6_layout_rview_ideas");
            LinearLayoutManager linearLayoutManager2 = this.k0;
            if (linearLayoutManager2 != null) {
                recyclerView3.setLayoutManager(linearLayoutManager2);
                RecyclerView recyclerView4 = (RecyclerView) X1(i3);
                kotlin.m.b.f.d(recyclerView4, "sp_step_6_layout_rview_ideas");
                recyclerView4.setNestedScrollingEnabled(false);
                return;
            }
            kotlin.m.b.f.p("layoutManagerIdeas");
            throw null;
        }
        kotlin.m.b.f.p("layoutManagerContacts");
        throw null;
    }

    public void W1() {
        HashMap hashMap = this.n0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.n0 == null) {
            this.n0 = new HashMap();
        }
        View view = (View) this.n0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.n0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Y1(String str, String str2, String str3) {
        kotlin.m.b.f.e(str, "id");
        kotlin.m.b.f.e(str2, "name");
        z zVar = this.i0;
        if (zVar != null) {
            zVar.F(str2, str, str3, 6, null);
            z zVar2 = this.i0;
            if (zVar2 != null) {
                f.a.a.a.b.e.d W = zVar2.W(6);
                if (this.f0 == null) {
                    this.f0 = new ArrayList<>();
                }
                ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
                kotlin.m.b.f.c(arrayList);
                arrayList.add(0, W);
                JSONArray jSONArray = new JSONArray();
                ArrayList<f.a.a.a.b.e.d> arrayList2 = this.f0;
                kotlin.m.b.f.c(arrayList2);
                Iterator<f.a.a.a.b.e.d> it = arrayList2.iterator();
                while (it.hasNext()) {
                    f.a.a.a.b.e.d next = it.next();
                    kotlin.m.b.f.d(next, "contact");
                    jSONArray.put(next.c());
                }
                Act_sp_steps act_sp_steps = this.h0;
                if (act_sp_steps != null) {
                    if (!gov.va.mobilehealth.ncptsd.covid.CComp.o.q(act_sp_steps, 6, 2)) {
                        new Handler().postDelayed(new a(this), 150);
                    }
                    Act_sp_steps act_sp_steps2 = this.h0;
                    if (act_sp_steps2 != null) {
                        if (gov.va.mobilehealth.ncptsd.covid.CComp.o.q(act_sp_steps2, 6, 1)) {
                            Act_sp_steps act_sp_steps3 = this.h0;
                            if (act_sp_steps3 != null) {
                                gov.va.mobilehealth.ncptsd.covid.CComp.o.H(act_sp_steps3, 6);
                            } else {
                                kotlin.m.b.f.p("act");
                                throw null;
                            }
                        }
                        Act_sp_steps act_sp_steps4 = this.h0;
                        if (act_sp_steps4 != null) {
                            gov.va.mobilehealth.ncptsd.covid.CComp.o.I(act_sp_steps4, 6, 2);
                            Act_sp_steps act_sp_steps5 = this.h0;
                            if (act_sp_steps5 != null) {
                                gov.va.mobilehealth.ncptsd.covid.CComp.o.v(act_sp_steps5, jSONArray, 6);
                                h2();
                                return;
                            }
                            kotlin.m.b.f.p("act");
                            throw null;
                        }
                        kotlin.m.b.f.p("act");
                        throw null;
                    }
                    kotlin.m.b.f.p("act");
                    throw null;
                }
                kotlin.m.b.f.p("act");
                throw null;
            }
            kotlin.m.b.f.p("helper");
            throw null;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final Act_sp_steps Z1() {
        Act_sp_steps act_sp_steps = this.h0;
        if (act_sp_steps != null) {
            return act_sp_steps;
        }
        kotlin.m.b.f.p("act");
        throw null;
    }

    public final int a2() {
        return this.d0;
    }

    public final int b2() {
        return this.c0;
    }

    public final int c2() {
        return this.e0;
    }

    public final androidx.recyclerview.widget.f d2() {
        return this.l0;
    }

    public final void e2() {
        if (this.f0 != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
            kotlin.m.b.f.c(arrayList);
            Iterator<f.a.a.a.b.e.d> it = arrayList.iterator();
            while (it.hasNext()) {
                f.a.a.a.b.e.d next = it.next();
                kotlin.m.b.f.d(next, "contact");
                jSONArray.put(next.c());
            }
            androidx.fragment.app.d n = n();
            kotlin.m.b.f.c(n);
            gov.va.mobilehealth.ncptsd.covid.CComp.o.v(n, jSONArray, 6);
        }
        if (this.g0 != null) {
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<f.a.a.a.b.e.b> arrayList2 = this.g0;
            kotlin.m.b.f.c(arrayList2);
            Iterator<f.a.a.a.b.e.b> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                f.a.a.a.b.e.b next2 = it2.next();
                kotlin.m.b.f.d(next2, "idea");
                jSONArray2.put(next2.c());
            }
            androidx.fragment.app.d n2 = n();
            kotlin.m.b.f.c(n2);
            gov.va.mobilehealth.ncptsd.covid.CComp.o.w(n2, jSONArray2);
        }
    }

    public final void f2() {
        z zVar = this.i0;
        if (zVar != null) {
            ArrayList<f.a.a.a.b.e.d> Q = zVar.Q(6);
            this.f0 = new ArrayList<>();
            androidx.fragment.app.d n = n();
            kotlin.m.b.f.c(n);
            JSONArray i2 = gov.va.mobilehealth.ncptsd.covid.CComp.o.i(n, 6);
            int length = i2.length();
            for (int i3 = 0; i3 < length; i3++) {
                Iterator<f.a.a.a.b.e.d> it = Q.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f.a.a.a.b.e.d next = it.next();
                    kotlin.m.b.f.d(next, "contact");
                    int c2 = next.c();
                    Object obj = i2.get(i3);
                    if ((obj instanceof Integer) && c2 == ((Integer) obj).intValue()) {
                        ArrayList<f.a.a.a.b.e.d> arrayList = this.f0;
                        kotlin.m.b.f.c(arrayList);
                        arrayList.add(next);
                        break;
                    }
                }
            }
            ArrayList<f.a.a.a.b.e.d> arrayList2 = this.f0;
            kotlin.m.b.f.c(arrayList2);
            if (!arrayList2.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) X1(o.sp_step_6_layout_contents_contacts);
                kotlin.m.b.f.d(linearLayout, "sp_step_6_layout_contents_contacts");
                linearLayout.setVisibility(0);
                ArrayList<f.a.a.a.b.e.d> arrayList3 = this.f0;
                kotlin.m.b.f.c(arrayList3);
                f.a.a.a.b.c.i iVar = new f.a.a.a.b.c.i(this, arrayList3, new C0193f(this));
                int i4 = o.sp_step_6_layout_rview_contacts;
                RecyclerView recyclerView = (RecyclerView) X1(i4);
                kotlin.m.b.f.d(recyclerView, "sp_step_6_layout_rview_contacts");
                recyclerView.setAdapter(iVar);
                androidx.recyclerview.widget.f fVar = this.l0;
                if (!(fVar == null || fVar == null)) {
                    fVar.m(null);
                }
                androidx.recyclerview.widget.f fVar2 = new androidx.recyclerview.widget.f(new z0(iVar));
                this.l0 = fVar2;
                fVar2.m((RecyclerView) X1(i4));
            } else {
                LinearLayout linearLayout2 = (LinearLayout) X1(o.sp_step_6_layout_contents_contacts);
                kotlin.m.b.f.d(linearLayout2, "sp_step_6_layout_contents_contacts");
                linearLayout2.setVisibility(8);
            }
            z zVar2 = this.i0;
            if (zVar2 != null) {
                ArrayList<f.a.a.a.b.e.b> R = zVar2.R();
                this.g0 = new ArrayList<>();
                androidx.fragment.app.d n2 = n();
                kotlin.m.b.f.c(n2);
                JSONArray j2 = gov.va.mobilehealth.ncptsd.covid.CComp.o.j(n2);
                int length2 = j2.length();
                for (int i5 = 0; i5 < length2; i5++) {
                    Iterator<f.a.a.a.b.e.b> it2 = R.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        f.a.a.a.b.e.b next2 = it2.next();
                        kotlin.m.b.f.d(next2, "idea");
                        int c3 = next2.c();
                        Object obj2 = j2.get(i5);
                        if ((obj2 instanceof Integer) && c3 == ((Integer) obj2).intValue()) {
                            ArrayList<f.a.a.a.b.e.b> arrayList4 = this.g0;
                            kotlin.m.b.f.c(arrayList4);
                            arrayList4.add(next2);
                            break;
                        }
                    }
                }
                ArrayList<f.a.a.a.b.e.b> arrayList5 = this.g0;
                kotlin.m.b.f.c(arrayList5);
                if (!arrayList5.isEmpty()) {
                    LinearLayout linearLayout3 = (LinearLayout) X1(o.sp_step_6_layout_contents_ideas);
                    kotlin.m.b.f.d(linearLayout3, "sp_step_6_layout_contents_ideas");
                    linearLayout3.setVisibility(0);
                    ArrayList<f.a.a.a.b.e.b> arrayList6 = this.g0;
                    kotlin.m.b.f.c(arrayList6);
                    f.a.a.a.b.c.g gVar = new f.a.a.a.b.c.g(this, arrayList6, new g(this));
                    int i6 = o.sp_step_6_layout_rview_ideas;
                    RecyclerView recyclerView2 = (RecyclerView) X1(i6);
                    kotlin.m.b.f.d(recyclerView2, "sp_step_6_layout_rview_ideas");
                    recyclerView2.setAdapter(gVar);
                    androidx.recyclerview.widget.f fVar3 = this.m0;
                    if (!(fVar3 == null || fVar3 == null)) {
                        fVar3.m(null);
                    }
                    androidx.recyclerview.widget.f fVar4 = new androidx.recyclerview.widget.f(new z0(gVar));
                    this.m0 = fVar4;
                    fVar4.m((RecyclerView) X1(i6));
                    return;
                }
                LinearLayout linearLayout4 = (LinearLayout) X1(o.sp_step_6_layout_contents_ideas);
                kotlin.m.b.f.d(linearLayout4, "sp_step_6_layout_contents_ideas");
                linearLayout4.setVisibility(8);
                return;
            }
            kotlin.m.b.f.p("helper");
            throw null;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final void g2() {
        Act_sp_steps act_sp_steps = this.h0;
        if (act_sp_steps != null) {
            View inflate = LayoutInflater.from(act_sp_steps).inflate(R.layout.bs_contacts, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.bs_contacts_txt_pick);
            TextView textView2 = (TextView) inflate.findViewById(R.id.bs_contacts_txt_create);
            TextView textView3 = (TextView) inflate.findViewById(R.id.bs_contacts_txt_cancel);
            textView.setOnClickListener(new h(this, textView));
            textView2.setOnClickListener(new i(this, textView2));
            textView3.setOnClickListener(new j(this, textView3));
            Act_sp_steps act_sp_steps2 = this.h0;
            if (act_sp_steps2 != null) {
                act_sp_steps2.Y().C(inflate);
                s.b(textView);
                return;
            }
            kotlin.m.b.f.p("act");
            throw null;
        }
        kotlin.m.b.f.p("act");
        throw null;
    }

    public final void h2() {
        androidx.fragment.app.d n = n();
        kotlin.m.b.f.c(n);
        if (gov.va.mobilehealth.ncptsd.covid.CComp.o.i(n, 6).length() == 0) {
            androidx.fragment.app.d n2 = n();
            kotlin.m.b.f.c(n2);
            if (gov.va.mobilehealth.ncptsd.covid.CComp.o.j(n2).length() == 0) {
                LinearLayout linearLayout = (LinearLayout) X1(o.sp_step_6_layout_intro);
                kotlin.m.b.f.d(linearLayout, "sp_step_6_layout_intro");
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = (LinearLayout) X1(o.sp_step_6_layout_contents);
                kotlin.m.b.f.d(linearLayout2, "sp_step_6_layout_contents");
                linearLayout2.setVisibility(8);
                ButtonTracking buttonTracking = (ButtonTracking) X1(o.sp_step_6_btn_edit_contacts);
                kotlin.m.b.f.d(buttonTracking, "sp_step_6_btn_edit_contacts");
                buttonTracking.setVisibility(8);
                ButtonTracking buttonTracking2 = (ButtonTracking) X1(o.sp_step_6_btn_edit_safety_options);
                kotlin.m.b.f.d(buttonTracking2, "sp_step_6_btn_edit_safety_options");
                buttonTracking2.setVisibility(8);
                return;
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) X1(o.sp_step_6_layout_intro);
        kotlin.m.b.f.d(linearLayout3, "sp_step_6_layout_intro");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = (LinearLayout) X1(o.sp_step_6_layout_contents);
        kotlin.m.b.f.d(linearLayout4, "sp_step_6_layout_contents");
        linearLayout4.setVisibility(0);
        ButtonTracking buttonTracking3 = (ButtonTracking) X1(o.sp_step_6_btn_edit_contacts);
        kotlin.m.b.f.d(buttonTracking3, "sp_step_6_btn_edit_contacts");
        buttonTracking3.setVisibility(0);
        ButtonTracking buttonTracking4 = (ButtonTracking) X1(o.sp_step_6_btn_edit_safety_options);
        kotlin.m.b.f.d(buttonTracking4, "sp_step_6_btn_edit_safety_options");
        buttonTracking4.setVisibility(0);
        f2();
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        super.j0(i2, i3, intent);
        if ((i2 == this.c0 || i2 == this.d0) && i3 == -1) {
            kotlin.m.b.f.c(intent);
            Uri data = intent.getData();
            Act_sp_steps act_sp_steps = this.h0;
            String str = null;
            if (act_sp_steps != null) {
                ContentResolver contentResolver = act_sp_steps.getContentResolver();
                kotlin.m.b.f.c(data);
                Cursor query = contentResolver.query(data, null, null, null, null);
                kotlin.m.b.f.c(query);
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndex("display_name"));
                    Act_sp_steps act_sp_steps2 = this.h0;
                    if (act_sp_steps2 != null) {
                        ContentResolver contentResolver2 = act_sp_steps2.getContentResolver();
                        Uri uri = ContactsContract.Contacts.CONTENT_URI;
                        Cursor query2 = contentResolver2.query(uri, null, "DISPLAY_NAME = '" + string2 + '\'', null, null);
                        kotlin.m.b.f.c(query2);
                        if (query2.moveToFirst()) {
                            String string3 = query2.getString(query2.getColumnIndex("_id"));
                            Uri uri2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                            Cursor query3 = contentResolver2.query(uri2, null, "contact_id = " + string3, null, null);
                            while (true) {
                                kotlin.m.b.f.c(query3);
                                if (!query3.moveToNext()) {
                                    break;
                                }
                                str = query3.getString(query3.getColumnIndex("data1"));
                            }
                            query3.close();
                        }
                        query2.close();
                        kotlin.m.b.f.d(string, "id");
                        kotlin.m.b.f.d(string2, "name");
                        Y1(string, string2, str);
                        gov.va.mobilehealth.ncptsd.covid.CComp.o.A();
                        return;
                    }
                    kotlin.m.b.f.p("act");
                    throw null;
                }
                return;
            }
            kotlin.m.b.f.p("act");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        androidx.fragment.app.d n = n();
        Objects.requireNonNull(n, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities_sp.Act_sp_steps");
        this.h0 = (Act_sp_steps) n;
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.m.b.f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_sp_step_6, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
