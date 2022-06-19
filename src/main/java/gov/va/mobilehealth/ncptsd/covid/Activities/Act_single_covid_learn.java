package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.u;
import f.a.a.a.b.h.c;
import f.a.a.a.b.h.d;
import f.a.a.a.b.k.b;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;

public class Act_single_covid_learn extends f {
    private Toolbar u;
    private FrameLayout v;
    private AppCompatTextView w;
    private u x;

    /* access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void Y() {
        if (!isFinishing() && (C().i0().get(0) instanceof d)) {
            b0(getString(R.string.for_healtcare_workers));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void a0() {
        if (C().d0() > 0) {
            new Handler().postDelayed(new x(this), 200);
        } else if (this.x.d() == 2010) {
            b0(getString(R.string.for_healtcare_workers));
        }
    }

    public void W(Fragment fragment, String str) {
        androidx.fragment.app.u j2 = C().j();
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

    public void b0(String str) {
        this.w.setText(str);
        m.A0(this, str);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.x = (u) getIntent().getSerializableExtra("screen");
        boolean booleanExtra = getIntent().getBooleanExtra("noImage", false);
        setContentView(R.layout.act_support);
        this.u = (Toolbar) findViewById(R.id.support_toolbar);
        this.v = (FrameLayout) findViewById(R.id.support_container);
        this.w = (AppCompatTextView) findViewById(R.id.support_txt_title);
        C().e(new w(this));
        androidx.fragment.app.u j2 = C().j();
        if (this.x.g()) {
            j2.p(this.v.getId(), m.L(Math.abs(this.x.d()), this.x.c()));
        } else if (this.x.d() == 2010) {
            j2.p(this.v.getId(), d.g0.a(this.x));
        } else if (this.x.d() == 10009) {
            j2.p(this.v.getId(), new b());
        } else {
            j2.p(this.v.getId(), c.Z1(this.x, booleanExtra));
        }
        j2.j();
        this.w.setText(this.x.c());
        s.p(this, this.x.c());
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }
}
