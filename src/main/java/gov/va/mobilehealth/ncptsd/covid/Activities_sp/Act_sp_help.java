package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.l0;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.HashMap;
import k.b.d;
import kotlin.m.b.f;
import vainstrum.Components.a;

/* compiled from: Act_sp_help.kt */
public final class Act_sp_help extends a {
    private HashMap w;

    public View W(int i2) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.w.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        l0 l0Var = new l0(this, o.l(this));
        RecyclerView recyclerView = (RecyclerView) W(f.a.a.a.b.o.sp_help_rview);
        f.d(recyclerView, "sp_help_rview");
        recyclerView.setAdapter(l0Var);
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
        setContentView(R.layout.act_sp_help);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        int i2 = f.a.a.a.b.o.sp_help_rview;
        ((RecyclerView) W(i2)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) W(i2);
        f.d(recyclerView, "sp_help_rview");
        recyclerView.setLayoutManager(linearLayoutManager);
        X();
        T((Toolbar) W(f.a.a.a.b.o.sp_help_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.x(true);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.s(true);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
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
