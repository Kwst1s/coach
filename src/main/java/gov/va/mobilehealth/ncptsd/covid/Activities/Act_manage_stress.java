package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.i.k;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.HashMap;

/* compiled from: Act_manage_stress.kt */
public final class Act_manage_stress extends f {
    private HashMap u;

    public View W(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
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
        setContentView(R.layout.act_manage_stress);
        u j2 = C().j();
        kotlin.m.b.f.d(j2, "supportFragmentManager.beginTransaction()");
        FrameLayout frameLayout = (FrameLayout) W(o.manage_stress_container);
        kotlin.m.b.f.d(frameLayout, "manage_stress_container");
        j2.p(frameLayout.getId(), new k());
        j2.j();
        T((Toolbar) W(o.manage_stress_toolbar));
        a M = M();
        kotlin.m.b.f.c(M);
        M.x(true);
        a M2 = M();
        kotlin.m.b.f.c(M2);
        M2.s(true);
        a M3 = M();
        kotlin.m.b.f.c(M3);
        M3.t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
