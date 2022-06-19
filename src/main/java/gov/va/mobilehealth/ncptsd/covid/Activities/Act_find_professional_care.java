package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.a;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.k.e;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.HashMap;
import k.b.d;
import kotlin.m.b.f;

/* compiled from: Act_find_professional_care.kt */
public final class Act_find_professional_care extends c {
    private HashMap t;

    public View W(int i2) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        View view = (View) this.t.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.t.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        f.e(context, "base");
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_find_professional_care);
        u j2 = C().j();
        FrameLayout frameLayout = (FrameLayout) W(o.find_professional_care_container);
        f.d(frameLayout, "find_professional_care_container");
        j2.p(frameLayout.getId(), new e());
        j2.j();
        T((Toolbar) W(o.find_professional_care_toolbar));
        a M = M();
        f.c(M);
        M.x(true);
        a M2 = M();
        f.c(M2);
        M2.s(true);
        a M3 = M();
        f.c(M3);
        M3.t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
