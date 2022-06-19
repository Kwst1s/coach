package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b;
import f.a.a.a.b.d.p;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp.Act_assessment_feedback;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.l;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.text.SimpleDateFormat;
import k.b.d;

public class Act_assessment_detail extends f {
    private b A;
    private int B;
    private Toolbar u;
    private AppCompatTextView v;
    private AppCompatTextView w;
    private AppCompatButton x;
    private LinearLayout y;
    private b z;

    /* access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(View view) {
        Intent intent;
        if (this.B == 124) {
            intent = new Intent(getApplicationContext(), Act_assessment_feedback.class);
            intent.putExtra("points", this.z.c());
            intent.putExtra("q_points", this.z.d());
            intent.putExtra("prevData", this.A);
        } else {
            intent = new Intent(getApplicationContext(), Act_other_assessment_result.class);
            intent.putExtra("points", this.z.c());
            intent.putExtra("q_points", this.z.d());
            intent.putExtra("assessment_type", this.B);
            intent.putExtra("isNew", false);
        }
        startActivity(intent);
    }

    public void Y() {
        for (int i2 = 0; i2 < this.z.d().size(); i2++) {
            p pVar = this.z.d().get(i2);
            View inflate = getLayoutInflater().inflate(R.layout.item_layout_assessment_question, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_layout_assessment_question_layout_question);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.item_layout_assessment_question_txt_answer_text);
            ((AppCompatTextView) inflate.findViewById(R.id.item_layout_assessment_question_txt_number)).setText(getString(R.string.question) + " " + (pVar.c() + 1));
            ((AppCompatTextView) inflate.findViewById(R.id.item_layout_assessment_question_txt_answer_number)).setText(getString(R.string.answer) + " " + (pVar.a() + 1));
            ((AppCompatTextView) inflate.findViewById(R.id.item_layout_assessment_question_txt_score_text)).setText(Integer.toString(pVar.a()));
            if (this.B == 124) {
                appCompatTextView.setText(m.u(getApplicationContext(), pVar.a()));
                m.P0(getApplicationContext(), linearLayout, m.z(getApplicationContext(), pVar.c()), R.dimen.txt_normal, -1, false);
            } else {
                l.a aVar = l.f10128a;
                appCompatTextView.setText(aVar.a(getApplicationContext(), pVar.c(), pVar.a(), this.B));
                g0.k(this, getLayoutInflater(), linearLayout, aVar.e(getApplicationContext(), pVar.c(), this.B), R.dimen.txt_normal, R.dimen.padding_large, 17170444, true);
            }
            this.y.addView(inflate);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.z = (b) getIntent().getSerializableExtra("assess_data");
        this.A = (b) getIntent().getSerializableExtra("previous_assess_data");
        this.B = getIntent().getIntExtra("type", -1);
        setContentView(R.layout.act_assessment_detail);
        this.u = (Toolbar) findViewById(R.id.assessment_detail_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.assessment_detail_txt_title);
        this.w = (AppCompatTextView) findViewById(R.id.assessment_detail_txt_score);
        this.x = (AppCompatButton) findViewById(R.id.assessment_detail_btn_feedback);
        this.y = (LinearLayout) findViewById(R.id.assessment_detail_layout_questions);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        this.v.setText(j.c(simpleDateFormat.format(Long.valueOf(this.z.a()))));
        AppCompatTextView appCompatTextView = this.w;
        appCompatTextView.setText(getString(R.string.score) + ": " + this.z.c());
        Y();
        s.p(this, j.c(simpleDateFormat.format(Long.valueOf(this.z.a()))));
        this.x.setOnClickListener(new a(this));
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
