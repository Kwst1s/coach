package f.a.a.a.b.n.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Act_other_assessment;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.l;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import k.b.d;
import vainstrum.Components.b;

/* compiled from: Frag_otherAssessment_intro */
public class c extends b {
    private AppCompatImageView c0;
    private LinearLayout d0;
    private Button e0;
    private int f0;

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void X1(View view) {
        int i2 = this.f0;
        if (i2 == 119) {
            d.h(p1(), "Assessment_Mood");
        } else if (i2 == 224) {
            d.h(p1(), "Assessment_WellBeing");
        } else if (i2 == 411) {
            d.h(p1(), "Assessment_Anxiety");
        }
        Intent intent = new Intent(p1(), Act_other_assessment.class);
        intent.putExtra("assessment_type", this.f0);
        intent.putExtra("maxQuestions", l.f10128a.c(this.f0));
        F1(intent);
    }

    public static c Y1(int i2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        cVar.v1(bundle);
        return cVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.f0 = o1().getInt("type");
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        String str = null;
        View inflate = layoutInflater.inflate(R.layout.frag_o_assessment_introduction, (ViewGroup) null);
        this.c0 = (AppCompatImageView) inflate.findViewById(R.id.o_assessment_intro_img);
        this.d0 = (LinearLayout) inflate.findViewById(R.id.o_assessment_intro_layout_content);
        this.c0.getLayoutParams().height = m.H(n1());
        int i3 = this.f0;
        if (i3 == 119) {
            Context p1 = p1();
            str = j.N(p1, g.f10084d + File.separator + "track_mood_intro.json");
            i2 = R.drawable.track_mood_img;
        } else if (i3 == 224) {
            Context p12 = p1();
            str = j.N(p12, g.f10084d + File.separator + "well_being_intro.json");
            i2 = R.drawable.track_well_being_img;
        } else if (i3 != 411) {
            i2 = -1;
        } else {
            Context p13 = p1();
            str = j.N(p13, g.f10084d + File.separator + "track_anxiety_intro.json");
            i2 = R.drawable.track_anxiety_img;
        }
        g0.k(n1(), D(), this.d0, str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        this.c0.setImageResource(i2);
        Button button = (Button) inflate.findViewById(R.id.o_assessment_intro_btn_next);
        this.e0 = button;
        button.setOnClickListener(new a(this));
        return inflate;
    }
}
