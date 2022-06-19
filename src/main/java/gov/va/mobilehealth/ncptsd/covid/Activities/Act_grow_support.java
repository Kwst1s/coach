package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.k.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import k.b.d;
import vainstrum.Components.b;

public class Act_grow_support extends i0 {
    private Toolbar u;
    private FrameLayout v;

    public void W(b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), bVar, str);
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
        setContentView(R.layout.act_grow_support);
        this.u = (Toolbar) findViewById(R.id.grow_support_toolbar);
        this.v = (FrameLayout) findViewById(R.id.grow_support_container);
        u j2 = C().j();
        j2.p(this.v.getId(), new f());
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
