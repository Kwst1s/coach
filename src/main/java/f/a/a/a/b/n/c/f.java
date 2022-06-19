package f.a.a.a.b.n.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp.Act_assessment;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.b;

/* compiled from: Frag_assessment_introduction */
public class f extends b {
    private AppCompatImageView c0;
    private Button d0;

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(View view) {
        F1(new Intent(p1(), Act_assessment.class));
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_assessment_introduction, (ViewGroup) null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.assessment_intro_img);
        this.c0 = appCompatImageView;
        appCompatImageView.getLayoutParams().height = m.H(n1());
        Button button = (Button) inflate.findViewById(R.id.assessment_intro_btn_next);
        this.d0 = button;
        button.setOnClickListener(new b(this));
        return inflate;
    }
}
