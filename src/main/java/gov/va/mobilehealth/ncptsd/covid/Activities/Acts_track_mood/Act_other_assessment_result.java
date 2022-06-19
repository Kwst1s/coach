package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b;
import f.a.a.a.b.d.p;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.l;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import k.b.d;
import vainstrum.Components.ButtonTracking;

/* compiled from: Act_other_assessment_result.kt */
public final class Act_other_assessment_result extends f {
    private HashMap A;
    private int u;
    private int v = -1;
    public ArrayList<p> w;
    public u x;
    private boolean y = true;
    private boolean z;

    /* compiled from: Act_other_assessment_result.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_other_assessment_result f9894b;

        a(Act_other_assessment_result act_other_assessment_result) {
            this.f9894b = act_other_assessment_result;
        }

        public final void onClick(View view) {
            if (!this.f9894b.Y()) {
                this.f9894b.d0(true);
                if (this.f9894b.c0()) {
                    int X = this.f9894b.X();
                    if (X == 119) {
                        d.g(this.f9894b.getApplicationContext(), "mood", m.j(this.f9894b.getApplicationContext(), this.f9894b.b0(), this.f9894b.X()), this.f9894b.a0());
                    } else if (X == 224) {
                        d.g(this.f9894b.getApplicationContext(), "wellbeing", m.j(this.f9894b.getApplicationContext(), this.f9894b.b0(), this.f9894b.X()), this.f9894b.a0());
                    } else if (X == 411) {
                        d.g(this.f9894b.getApplicationContext(), "anxiety", m.j(this.f9894b.getApplicationContext(), this.f9894b.b0(), this.f9894b.X()), this.f9894b.a0());
                    }
                    this.f9894b.Z().l(new b(System.currentTimeMillis(), this.f9894b.b0(), this.f9894b.a0()), this.f9894b.X());
                }
                this.f9894b.finish();
            }
        }
    }

    public View W(int i2) {
        if (this.A == null) {
            this.A = new HashMap();
        }
        View view = (View) this.A.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.A.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int X() {
        return this.v;
    }

    public final boolean Y() {
        return this.z;
    }

    public final u Z() {
        u uVar = this.x;
        if (uVar != null) {
            return uVar;
        }
        kotlin.m.b.f.p("helper");
        throw null;
    }

    public final int a0() {
        return this.u;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public final ArrayList<p> b0() {
        ArrayList<p> arrayList = this.w;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.m.b.f.p("q_points");
        throw null;
    }

    public final boolean c0() {
        return this.y;
    }

    public final void d0(boolean z2) {
        this.z = z2;
    }

    public final void e0() {
        int i2 = this.v;
        String str = null;
        if (i2 == 119) {
            if (kotlin.m.b.f.a(b0.a(getApplicationContext()), "es")) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView, "other_assessment_feedback_txt_toolbar");
                appCompatTextView.setText(getString(R.string.total_score_no_2p));
                s.p(this, getString(R.string.total_score_no_2p));
            } else {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView2, "other_assessment_feedback_txt_toolbar");
                appCompatTextView2.setText(getString(R.string.mood) + " " + getString(R.string.feedback));
                s.p(this, getString(R.string.mood) + " " + getString(R.string.feedback));
            }
            l.a aVar = l.f10128a;
            Context applicationContext = getApplicationContext();
            kotlin.m.b.f.d(applicationContext, "applicationContext");
            int i3 = this.u;
            ArrayList<p> arrayList = this.w;
            if (arrayList == null) {
                kotlin.m.b.f.p("q_points");
                throw null;
            } else if (arrayList != null) {
                p pVar = arrayList.get(arrayList.size() - 1);
                kotlin.m.b.f.d(pVar, "q_points[q_points.size - 1]");
                str = aVar.d(applicationContext, i3, pVar.a());
            } else {
                kotlin.m.b.f.p("q_points");
                throw null;
            }
        } else if (i2 == 224) {
            if (kotlin.m.b.f.a(b0.a(getApplicationContext()), "es")) {
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView3, "other_assessment_feedback_txt_toolbar");
                appCompatTextView3.setText(getString(R.string.total_score_no_2p));
                s.p(this, getString(R.string.total_score_no_2p));
            } else {
                AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView4, "other_assessment_feedback_txt_toolbar");
                appCompatTextView4.setText(getString(R.string.well_being) + " " + getString(R.string.feedback));
                s.p(this, getString(R.string.well_being) + " " + getString(R.string.feedback));
            }
            l.a aVar2 = l.f10128a;
            Context applicationContext2 = getApplicationContext();
            kotlin.m.b.f.d(applicationContext2, "applicationContext");
            str = aVar2.f(applicationContext2, this.u);
        } else if (i2 == 411) {
            if (kotlin.m.b.f.a(b0.a(getApplicationContext()), "es")) {
                AppCompatTextView appCompatTextView5 = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView5, "other_assessment_feedback_txt_toolbar");
                appCompatTextView5.setText(getString(R.string.total_score_no_2p));
                s.p(this, getString(R.string.total_score_no_2p));
            } else {
                AppCompatTextView appCompatTextView6 = (AppCompatTextView) W(o.other_assessment_feedback_txt_toolbar);
                kotlin.m.b.f.d(appCompatTextView6, "other_assessment_feedback_txt_toolbar");
                appCompatTextView6.setText(getString(R.string.anxiety) + " " + getString(R.string.feedback));
                s.p(this, getString(R.string.anxiety) + " " + getString(R.string.feedback));
            }
            l.a aVar3 = l.f10128a;
            Context applicationContext3 = getApplicationContext();
            kotlin.m.b.f.d(applicationContext3, "applicationContext");
            str = aVar3.b(applicationContext3, this.u);
        }
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) W(o.other_assessment_results_txt_score);
        kotlin.m.b.f.d(appCompatTextView7, "other_assessment_results_txt_score");
        appCompatTextView7.setText(String.valueOf(this.u));
        if (str != null) {
            g0.k(this, getLayoutInflater(), (LinearLayout) W(o.other_assessment_results_content), str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        this.y = getIntent().getBooleanExtra("isNew", false);
        this.u = getIntent().getIntExtra("points", -1);
        this.v = getIntent().getIntExtra("assessment_type", -1);
        Serializable serializableExtra = getIntent().getSerializableExtra("q_points");
        kotlin.m.b.f.c(serializableExtra);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type kotlin.collections.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Q_Points> /* = java.util.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Q_Points> */");
        this.w = (ArrayList) serializableExtra;
        setContentView(R.layout.act_other_assessment_result);
        ((ButtonTracking) W(o.other_assessment_results_btn_done)).setOnClickListener(new a(this));
        this.x = new u(getApplicationContext());
        T((Toolbar) W(o.other_assessment_feedback_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.x(false);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.s(false);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
        e0();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        super.onResume();
        this.z = false;
    }
}
