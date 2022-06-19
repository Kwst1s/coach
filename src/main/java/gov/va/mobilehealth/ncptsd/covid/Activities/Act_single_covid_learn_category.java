package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.n;
import f.a.a.a.b.h.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;

public class Act_single_covid_learn_category extends f {
    private Toolbar u;
    private FrameLayout v;
    private AppCompatTextView w;
    private n x;

    public void W(Fragment fragment, String str) {
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), fragment, str);
        j2.h(str);
        j2.j();
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
        this.x = (n) getIntent().getSerializableExtra("data");
        setContentView(R.layout.act_support);
        this.u = (Toolbar) findViewById(R.id.support_toolbar);
        this.v = (FrameLayout) findViewById(R.id.support_container);
        this.w = (AppCompatTextView) findViewById(R.id.support_txt_title);
        u j2 = C().j();
        j2.p(this.v.getId(), e.L1(this.x));
        j2.j();
        this.w.setText(this.x.a());
        s.p(this, this.x.a());
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
