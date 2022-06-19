package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.b;
import f.a.a.a.b.n.c.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.ArrayList;
import k.b.d;

public class Act_assessment_feedback extends i0 {
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
        setContentView(R.layout.act_assessment_feedback);
        u j2 = C().j();
        j2.p(R.id.assessment_feedback_container, h.c2(getIntent().getIntExtra("points", -1), (ArrayList) getIntent().getSerializableExtra("q_points"), true, (b) getIntent().getSerializableExtra("prevData")));
        j2.j();
        T((Toolbar) findViewById(R.id.assessment_feedback_toolbar));
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
