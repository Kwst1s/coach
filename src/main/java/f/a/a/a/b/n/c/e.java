package f.a.a.a.b.n.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_new_reminders;
import gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp.Act_assessment;

/* compiled from: Frag_assessment_in_7_days */
public class e extends vainstrum.Components.b {
    private Act_assessment c0;
    private Button d0;
    private Button e0;

    /* compiled from: Frag_assessment_in_7_days */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            g e2 = g.e2(0, 0, null);
            e2.V1(e.this.R1());
            Act_assessment act_assessment = e.this.c0;
            act_assessment.W(e2, e.this.Q(R.string.question) + " 1 " + e.this.Q(R.string.of) + " " + Integer.toString(20));
        }
    }

    /* compiled from: Frag_assessment_in_7_days */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(e.this.p1(), Act_new_reminders.class);
            intent.putExtra("showOnly", 5);
            e.this.n1().startActivity(intent);
            e.this.n1().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_assessment) n();
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_assessment_in_7_days, (ViewGroup) null);
        this.d0 = (Button) inflate.findViewById(R.id.assessment_in_7_take_it_now);
        this.e0 = (Button) inflate.findViewById(R.id.assessment_in_7_set_reminder);
        this.d0.setOnClickListener(new a());
        this.e0.setOnClickListener(new b());
        return inflate;
    }
}
