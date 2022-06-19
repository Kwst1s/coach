package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.t;
import f.a.a.a.b.d.i;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.d0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import kotlin.j.h;
import vainstrum.Components.ButtonTracking;

/* compiled from: Act_goals.kt */
public final class Act_goals extends gov.va.mobilehealth.ncptsd.covid.CComp.f {
    public ArrayList<i> u;
    public LinearLayoutManager v;
    public v w;
    private androidx.recyclerview.widget.f x;
    private HashMap y;

    /* compiled from: Act_goals.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_goals f9902b;

        a(Act_goals act_goals) {
            this.f9902b = act_goals;
        }

        public final void onClick(View view) {
            this.f9902b.startActivity(new Intent(this.f9902b.getApplicationContext(), Act_new_goal.class));
        }
    }

    /* compiled from: Act_goals.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_goals f9903b;

        b(Act_goals act_goals) {
            this.f9903b = act_goals;
        }

        public final void onClick(View view) {
            this.f9903b.startActivity(new Intent(this.f9903b.getApplicationContext(), Act_new_goal.class));
        }
    }

    /* compiled from: Act_goals.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_goals f9904b;

        c(Act_goals act_goals) {
            this.f9904b = act_goals;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9904b, Act_goal_history.class);
            intent.putExtra("goals", this.f9904b.X());
            this.f9904b.startActivity(intent);
        }
    }

    /* compiled from: Act_goals.kt */
    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_goals f9905b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9906c;

        d(Act_goals act_goals, int i2) {
            this.f9905b = act_goals;
            this.f9906c = i2;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f9905b.Y().G(this.f9905b.X().get(this.f9906c).c());
            this.f9905b.X().remove(this.f9906c);
            Act_goals act_goals = this.f9905b;
            int i3 = o.goals_rview;
            RecyclerView recyclerView = (RecyclerView) act_goals.W(i3);
            kotlin.m.b.f.d(recyclerView, "goals_rview");
            RecyclerView.g adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.h();
            }
            if (this.f9905b.X().isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) this.f9905b.W(o.goals_intro_text);
                kotlin.m.b.f.d(linearLayout, "goals_intro_text");
                linearLayout.setVisibility(0);
                RecyclerView recyclerView2 = (RecyclerView) this.f9905b.W(i3);
                kotlin.m.b.f.d(recyclerView2, "goals_rview");
                recyclerView2.setVisibility(4);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Act_goals.kt */
    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final e f9907b = new e();

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_goals.kt */
    public static final class f<T> implements Comparator<i> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f9908b = new f();

        f() {
        }

        /* renamed from: a */
        public final int compare(i iVar, i iVar2) {
            return kotlin.m.b.f.g(iVar.e(), iVar2.e());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_goals.kt */
    public static final class g implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_goals f9909a;

        g(Act_goals act_goals) {
            this.f9909a = act_goals;
        }

        @Override // gov.va.mobilehealth.ncptsd.covid.CComp.d0
        public final void a(RecyclerView.d0 d0Var) {
            androidx.recyclerview.widget.f Z = this.f9909a.Z();
            if (Z != null) {
                Z.H(d0Var);
            }
        }
    }

    public View W(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final ArrayList<i> X() {
        ArrayList<i> arrayList = this.u;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.m.b.f.p("goals");
        throw null;
    }

    public final v Y() {
        v vVar = this.w;
        if (vVar != null) {
            return vVar;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final androidx.recyclerview.widget.f Z() {
        return this.x;
    }

    public final void a0(int i2) {
        b.a h2 = j.h(this, getString(R.string.really_delete_goal));
        h2.k(R.string.yes, new d(this, i2));
        h2.h(R.string.no, e.f9907b);
        h2.a().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public final void b0() {
        v vVar = this.w;
        if (vVar != null) {
            ArrayList<i> J = vVar.J();
            this.u = J;
            if (J != null) {
                if (J.size() == 0) {
                    LinearLayout linearLayout = (LinearLayout) W(o.goals_layout_create_new2);
                    kotlin.m.b.f.d(linearLayout, "goals_layout_create_new2");
                    linearLayout.setVisibility(8);
                    AppCompatImageView appCompatImageView = (AppCompatImageView) W(o.goals_img_graphs);
                    kotlin.m.b.f.d(appCompatImageView, "goals_img_graphs");
                    appCompatImageView.setVisibility(8);
                    LinearLayout linearLayout2 = (LinearLayout) W(o.goals_intro_text);
                    kotlin.m.b.f.d(linearLayout2, "goals_intro_text");
                    linearLayout2.setVisibility(0);
                    ButtonTracking buttonTracking = (ButtonTracking) W(o.goals_btn_create_new);
                    kotlin.m.b.f.d(buttonTracking, "goals_btn_create_new");
                    buttonTracking.setVisibility(0);
                } else {
                    LinearLayout linearLayout3 = (LinearLayout) W(o.goals_layout_create_new2);
                    kotlin.m.b.f.d(linearLayout3, "goals_layout_create_new2");
                    linearLayout3.setVisibility(0);
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) W(o.goals_img_graphs);
                    kotlin.m.b.f.d(appCompatImageView2, "goals_img_graphs");
                    appCompatImageView2.setVisibility(0);
                    LinearLayout linearLayout4 = (LinearLayout) W(o.goals_intro_text);
                    kotlin.m.b.f.d(linearLayout4, "goals_intro_text");
                    linearLayout4.setVisibility(8);
                    ButtonTracking buttonTracking2 = (ButtonTracking) W(o.goals_btn_create_new);
                    kotlin.m.b.f.d(buttonTracking2, "goals_btn_create_new");
                    buttonTracking2.setVisibility(8);
                }
                ArrayList<i> arrayList = this.u;
                if (arrayList != null) {
                    h.g(arrayList, f.f9908b);
                    ArrayList<i> arrayList2 = this.u;
                    if (arrayList2 != null) {
                        if (arrayList2.isEmpty()) {
                            LinearLayout linearLayout5 = (LinearLayout) W(o.goals_list);
                            kotlin.m.b.f.d(linearLayout5, "goals_list");
                            linearLayout5.setVisibility(8);
                            LinearLayout linearLayout6 = (LinearLayout) W(o.goals_intro_layout);
                            kotlin.m.b.f.d(linearLayout6, "goals_intro_layout");
                            linearLayout6.setVisibility(0);
                        } else {
                            LinearLayout linearLayout7 = (LinearLayout) W(o.goals_list);
                            kotlin.m.b.f.d(linearLayout7, "goals_list");
                            linearLayout7.setVisibility(0);
                            LinearLayout linearLayout8 = (LinearLayout) W(o.goals_intro_layout);
                            kotlin.m.b.f.d(linearLayout8, "goals_intro_layout");
                            linearLayout8.setVisibility(8);
                        }
                        androidx.recyclerview.widget.f fVar = this.x;
                        if (!(fVar == null || fVar == null)) {
                            fVar.m(null);
                        }
                        ArrayList<i> arrayList3 = this.u;
                        if (arrayList3 != null) {
                            f.a.a.a.b.b.d0 d0Var = new f.a.a.a.b.b.d0(this, arrayList3, new g(this));
                            int i2 = o.goals_rview;
                            RecyclerView recyclerView = (RecyclerView) W(i2);
                            kotlin.m.b.f.d(recyclerView, "goals_rview");
                            recyclerView.setAdapter(d0Var);
                            LinearLayoutManager linearLayoutManager = this.v;
                            if (linearLayoutManager != null) {
                                androidx.recyclerview.widget.f fVar2 = new androidx.recyclerview.widget.f(new t(d0Var, linearLayoutManager));
                                this.x = fVar2;
                                if (fVar2 != null) {
                                    fVar2.m((RecyclerView) W(i2));
                                    return;
                                }
                                return;
                            }
                            kotlin.m.b.f.p("layoutManager");
                            throw null;
                        }
                        kotlin.m.b.f.p("goals");
                        throw null;
                    }
                    kotlin.m.b.f.p("goals");
                    throw null;
                }
                kotlin.m.b.f.p("goals");
                throw null;
            }
            kotlin.m.b.f.p("goals");
            throw null;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_goals);
        ((ButtonTracking) W(o.goals_btn_create_new)).setOnClickListener(new a(this));
        ((ButtonTracking) W(o.goals_btn_create_new2)).setOnClickListener(new b(this));
        ((AppCompatImageView) W(o.goals_img_graphs)).setOnClickListener(new c(this));
        int H = m.H(this);
        AppCompatImageView appCompatImageView = (AppCompatImageView) W(o.goals_intro_img);
        kotlin.m.b.f.d(appCompatImageView, "goals_intro_img");
        appCompatImageView.getLayoutParams().height = H;
        this.v = new LinearLayoutManager(getApplicationContext());
        int i2 = o.goals_rview;
        RecyclerView recyclerView = (RecyclerView) W(i2);
        kotlin.m.b.f.d(recyclerView, "goals_rview");
        LinearLayoutManager linearLayoutManager = this.v;
        if (linearLayoutManager != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            ((RecyclerView) W(i2)).setHasFixedSize(true);
            Context applicationContext = getApplicationContext();
            kotlin.m.b.f.d(applicationContext, "applicationContext");
            this.w = new v(applicationContext);
            g0.k(this, getLayoutInflater(), (LinearLayout) W(o.goals_intro_text), j.N(this, "goals_intro.json"), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
            T((Toolbar) W(o.goals_toolbar));
            androidx.appcompat.app.a M = M();
            if (M != null) {
                M.x(true);
            }
            androidx.appcompat.app.a M2 = M();
            if (M2 != null) {
                M2.s(true);
            }
            androidx.appcompat.app.a M3 = M();
            if (M3 != null) {
                M3.t(false);
                return;
            }
            return;
        }
        kotlin.m.b.f.p("layoutManager");
        throw null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        super.onPause();
        ArrayList<i> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.w;
                if (vVar != null) {
                    ArrayList<i> arrayList2 = this.u;
                    if (arrayList2 != null) {
                        i iVar = arrayList2.get(i2);
                        kotlin.m.b.f.d(iVar, "goals[i]");
                        vVar.I(iVar, i2);
                    } else {
                        kotlin.m.b.f.p("goals");
                        throw null;
                    }
                } else {
                    kotlin.m.b.f.p("helper");
                    throw null;
                }
            }
            return;
        }
        kotlin.m.b.f.p("goals");
        throw null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        b0();
        super.onResume();
    }
}
