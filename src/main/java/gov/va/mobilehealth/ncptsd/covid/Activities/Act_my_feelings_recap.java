package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.o;
import f.a.a.a.b.l.m0.c;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import k.b.d;

public class Act_my_feelings_recap extends i0 {
    private Toolbar u;
    private FrameLayout v;
    private o w;

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
        }
        this.w = (o) getIntent().getSerializableExtra("myfeeling");
        setContentView(R.layout.act_my_feelings_recap);
        this.u = (Toolbar) findViewById(R.id.my_feelings_recap_toolbar);
        this.v = (FrameLayout) findViewById(R.id.my_feelings_recap_container);
        u j2 = C().j();
        j2.p(this.v.getId(), c.Z1(this.w.d(), this.w.c(), this.w.e()));
        j2.j();
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
