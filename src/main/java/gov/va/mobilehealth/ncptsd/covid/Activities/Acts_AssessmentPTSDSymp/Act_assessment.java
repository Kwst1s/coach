package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_AssessmentPTSDSymp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.n.c.e;
import f.a.a.a.b.n.c.g;
import f.a.a.a.b.n.c.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;

public class Act_assessment extends i0 {
    private Toolbar u;
    private FrameLayout v;
    private AppCompatTextView w;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a(Act_assessment act_assessment) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_assessment.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y() {
        int d0 = C().d0();
        if (d0 == 0) {
            String str = getString(R.string.question) + " " + 1 + " " + getString(R.string.of) + " " + 20;
            m.A0(this, str);
            this.w.setText(str);
            getWindow().getDecorView().sendAccessibilityEvent(32);
            return;
        }
        Fragment fragment = C().i0().get(0);
        String a2 = C().c0(d0 - 1).a();
        if (a2 != null) {
            this.w.setText(a2);
            m.A0(this, a2);
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
        if (fragment == null) {
            return;
        }
        if (fragment.getClass().equals(h.class)) {
            if (M() != null) {
                M().x(false);
                M().s(false);
            }
        } else if (M() != null) {
            M().x(true);
            M().s(true);
        }
    }

    public void W(Fragment fragment, String str) {
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), fragment, str);
        j2.h(str);
        j2.i();
    }

    public void Z() {
        b.a h2 = j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes, new b());
        h2.h(R.string.no, new a(this));
        h2.a().show();
        this.u.announceForAccessibility(getString(R.string.lose_unsaved_really_exit));
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
        setContentView(R.layout.act_assessment);
        this.u = (Toolbar) findViewById(R.id.assessment_toolbar);
        this.v = (FrameLayout) findViewById(R.id.assessment_container);
        this.w = (AppCompatTextView) findViewById(R.id.assessment_txt_title);
        C().e(new a(this));
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        d.h(getApplicationContext(), "Assessment_PTSDSymptoms");
        if (!m.e0(this)) {
            u j2 = C().j();
            j2.q(this.v.getId(), g.e2(0, 0, null), null);
            j2.i();
            m.A0(this, getString(R.string.question) + " 1 " + getString(R.string.of) + " " + 20);
            AppCompatTextView appCompatTextView = this.w;
            appCompatTextView.setText(getString(R.string.question) + " 1 " + getString(R.string.of) + " " + 20);
        } else if (m.i0(this)) {
            u j3 = C().j();
            j3.q(this.v.getId(), new e(), null);
            j3.i();
            m.A0(this, getString(R.string.assessment_too_early));
            this.w.setText(getString(R.string.assessment_too_early));
        } else {
            u j4 = C().j();
            j4.q(this.v.getId(), g.e2(0, 0, null), null);
            j4.i();
            m.A0(this, getString(R.string.question) + " 1 " + getString(R.string.of) + " " + 20);
            AppCompatTextView appCompatTextView2 = this.w;
            appCompatTextView2.setText(getString(R.string.question) + " 1 " + getString(R.string.of) + " " + 20);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        Z();
        return true;
    }
}
