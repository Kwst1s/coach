package f.a.a.a.b.n.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.p;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_other_assessment;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_other_assessment_result;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.m.b.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Frag_otherAssessment_questionary.kt */
public final class d extends vainstrum.Components.b {
    public static final a m0 = new a(null);
    private Act_other_assessment c0;
    private int d0;
    private int e0;
    private ArrayList<p> f0;
    private int g0;
    private int h0 = -1;
    private boolean i0;
    private int j0 = -1;
    private boolean k0;
    private HashMap l0;

    /* compiled from: Frag_otherAssessment_questionary.kt */
    public static final class a {
        private a() {
        }

        public final d a(int i2, int i3, int i4, int i5, ArrayList<p> arrayList) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_QUESTION", i3);
            bundle.putInt("ARG_POINTS", i5);
            bundle.putInt("ARG_MAX_QUESTIONS", i4);
            bundle.putInt("ARG_ASSESSMENT_TYPE", i2);
            bundle.putSerializable("ARG_Q_POINTS", arrayList);
            dVar.v1(bundle);
            return dVar;
        }

        public /* synthetic */ a(kotlin.m.b.d dVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Frag_otherAssessment_questionary.kt */
    public static final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f9668b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LinearLayout f9669c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f9670d;

        /* compiled from: Frag_otherAssessment_questionary.kt */
        static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f9671b;

            a(b bVar) {
                this.f9671b = bVar;
            }

            public final void onClick(View view) {
                k.b.d.k(this.f9671b.f9670d.getString("answer"));
                b bVar = this.f9671b;
                bVar.f9668b.b2(bVar.f9670d.getInt("points"));
                this.f9671b.f9668b.Z1();
            }
        }

        b(d dVar, LinearLayout linearLayout, JSONObject jSONObject) {
            this.f9668b = dVar;
            this.f9669c = linearLayout;
            this.f9670d = jSONObject;
        }

        public final void run() {
            this.f9669c.setOnClickListener(new a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        this.k0 = false;
        if (this.d0 + 1 == this.g0) {
            this.i0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        f.e(bundle, "outState");
        bundle.putInt("ARG_QUESTION", this.d0);
        bundle.putInt("ARG_POINTS", this.e0);
        bundle.putInt("ARG_POINTS_SELECTED", this.h0);
        bundle.putInt("ARG_MAX_QUESTIONS", this.g0);
        bundle.putInt("ARG_ASSESSMENT_TYPE", this.j0);
        bundle.putSerializable("ARG_Q_POINTS", this.f0);
        super.K0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void N0(View view, Bundle bundle) {
        f.e(view, "view");
        super.N0(view, bundle);
        a2();
        this.k0 = false;
    }

    public void W1() {
        HashMap hashMap = this.l0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View X1(int i2) {
        if (this.l0 == null) {
            this.l0 = new HashMap();
        }
        View view = (View) this.l0.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View T = T();
        if (T == null) {
            return null;
        }
        View findViewById = T.findViewById(i2);
        this.l0.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Y1() {
        if (this.f0 == null) {
            this.f0 = new ArrayList<>();
        }
        ArrayList<p> arrayList = this.f0;
        f.c(arrayList);
        int size = arrayList.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            ArrayList<p> arrayList2 = this.f0;
            f.c(arrayList2);
            p pVar = arrayList2.get(i2);
            f.d(pVar, "q_points!![i]");
            if (pVar.c() == this.d0) {
                ArrayList<p> arrayList3 = this.f0;
                f.c(arrayList3);
                arrayList3.remove(i2);
                ArrayList<p> arrayList4 = this.f0;
                f.c(arrayList4);
                arrayList4.add(i2, new p(this.d0, this.h0));
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            ArrayList<p> arrayList5 = this.f0;
            f.c(arrayList5);
            arrayList5.add(new p(this.d0, this.h0));
        }
    }

    public final void Z1() {
        if (!this.k0) {
            this.k0 = true;
            Y1();
            if (this.i0) {
                Intent intent = new Intent(n(), Act_other_assessment_result.class);
                intent.putExtra("points", this.h0 + this.e0);
                intent.putExtra("q_points", this.f0);
                intent.putExtra("assessment_type", this.j0);
                intent.putExtra("isNew", true);
                F1(intent);
                androidx.fragment.app.d n = n();
                if (n != null) {
                    n.finish();
                    return;
                }
                return;
            }
            int i2 = this.d0 + 1;
            d a2 = m0.a(this.j0, i2, this.g0, this.h0 + this.e0, this.f0);
            Act_other_assessment act_other_assessment = this.c0;
            f.c(act_other_assessment);
            act_other_assessment.X(a2, Q(R.string.question) + " " + String.valueOf(i2 + 1) + " " + Q(R.string.of) + " " + String.valueOf(this.g0));
        }
    }

    public final void a2() {
        String str;
        int i2 = this.j0;
        ViewGroup viewGroup = null;
        if (i2 == 119) {
            str = j.N(p1(), g.f10084d + File.separator + "track_mood_questions.json");
        } else if (i2 == 224) {
            str = j.N(p1(), g.f10084d + File.separator + "well_being_questions.json");
        } else if (i2 != 411) {
            str = null;
        } else {
            str = j.N(p1(), g.f10084d + File.separator + "track_anxiety_questions.json");
        }
        JSONObject jSONObject = new JSONArray(str).getJSONObject(this.d0);
        String string = jSONObject.getString("question");
        f.c(string);
        g0.k(n1(), D(), (LinearLayout) X1(o.assessment_questionary_content_question), string, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        JSONArray jSONArray = jSONObject.getJSONArray("answers");
        int dimensionPixelSize = K().getDimensionPixelSize(R.dimen.padding_large);
        int dimensionPixelSize2 = K().getDimensionPixelSize(R.dimen.padding_medium);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize2);
        int length = jSONArray.length();
        int i3 = 0;
        while (i3 < length) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Act_other_assessment act_other_assessment = this.c0;
            f.c(act_other_assessment);
            View inflate = act_other_assessment.getLayoutInflater().inflate(R.layout.assessment_btn, viewGroup);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.assessment_btn_layout);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.assessment_btn_txt_answer);
            AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.assessment_btn_img_check);
            f.d(linearLayout, "btn_layout");
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setContentDescription(jSONObject2.getString("answer") + " button " + Q(R.string.select_and_continue));
            f.d(appCompatTextView, "txt");
            appCompatTextView.setText(jSONObject2.getString("answer"));
            new Handler().postDelayed(new b(this, linearLayout, jSONObject2), 500);
            int i4 = this.d0;
            ArrayList<p> arrayList = this.f0;
            f.c(arrayList);
            if (i4 < arrayList.size()) {
                ArrayList<p> arrayList2 = this.f0;
                f.c(arrayList2);
                p pVar = arrayList2.get(this.d0);
                f.d(pVar, "q_points!![cur_question]");
                if (pVar.a() == jSONObject2.getInt("points")) {
                    linearLayout.setContentDescription(jSONObject2.getString("answer") + " " + Q(R.string.chosen) + " button " + Q(R.string.select_and_continue));
                    appCompatTextView.setTextColor(-1);
                    linearLayout.setBackgroundResource(R.drawable.btn_blue_very_rounded);
                    f.d(appCompatImageView, "img_check");
                    appCompatImageView.setVisibility(0);
                    ((LinearLayout) X1(o.assessment_questionary_btn_layout)).addView(inflate);
                    i3++;
                    viewGroup = null;
                }
            }
            ((LinearLayout) X1(o.assessment_questionary_btn_layout)).addView(inflate);
            i3++;
            viewGroup = null;
        }
    }

    public final void b2(int i2) {
        this.h0 = i2;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        androidx.fragment.app.d n1 = n1();
        Objects.requireNonNull(n1, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_other_assessment");
        this.c0 = (Act_other_assessment) n1;
        if (bundle != null) {
            this.d0 = bundle.getInt("ARG_QUESTION");
            this.e0 = bundle.getInt("ARG_POINTS");
            Serializable serializable = bundle.getSerializable("ARG_Q_POINTS");
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Q_Points>");
            this.f0 = (ArrayList) serializable;
            this.h0 = bundle.getInt("ARG_POINTS_SELECTED");
            this.g0 = bundle.getInt("ARG_MAX_QUESTIONS");
            this.j0 = bundle.getInt("ARG_ASSESSMENT_TYPE");
        } else if (u() != null) {
            this.d0 = o1().getInt("ARG_QUESTION");
            this.e0 = o1().getInt("ARG_POINTS");
            Serializable serializable2 = o1().getSerializable("ARG_Q_POINTS");
            Objects.requireNonNull(serializable2, "null cannot be cast to non-null type java.util.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Q_Points>");
            this.f0 = (ArrayList) serializable2;
            this.j0 = o1().getInt("ARG_ASSESSMENT_TYPE");
            this.g0 = o1().getInt("ARG_MAX_QUESTIONS");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_other_assessment_questionary, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void v0() {
        super.v0();
        W1();
    }
}
