package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import java.util.HashMap;
import k.b.d;
import kotlin.m.b.f;
import vainstrum.Components.ButtonTracking;

/* compiled from: Act_learn_more_step_6.kt */
public final class Act_learn_more_step_6 extends vainstrum.Components.a {
    private HashMap w;

    /* compiled from: Act_learn_more_step_6.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_learn_more_step_6 f9966b;

        a(Act_learn_more_step_6 act_learn_more_step_6) {
            this.f9966b = act_learn_more_step_6;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9966b.getApplicationContext(), Act_jtext.class);
            intent.putExtra("title", this.f9966b.getString(R.string.safety_help));
            intent.putExtra("file", h.E);
            this.f9966b.startActivity(intent);
        }
    }

    /* compiled from: Act_learn_more_step_6.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_learn_more_step_6 f9967b;

        b(Act_learn_more_step_6 act_learn_more_step_6) {
            this.f9967b = act_learn_more_step_6;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9967b.getApplicationContext(), Act_jtext.class);
            intent.putExtra("title", this.f9967b.getString(R.string.enlisting_help_others));
            intent.putExtra("file", h.F);
            this.f9967b.startActivity(intent);
        }
    }

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

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_learn_more_step_6);
        ((ButtonTracking) W(o.sp_step6_learn_more_safety_help)).setOnClickListener(new a(this));
        ((ButtonTracking) W(o.sp_step6_enlisting_help_other)).setOnClickListener(new b(this));
        T((Toolbar) W(o.sp_step6_learn_more_toolbar));
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
