package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import java.util.HashMap;
import kotlin.m.b.f;
import vainstrum.Components.ButtonTracking;

/* compiled from: Act_sp_done_all_congrats.kt */
public final class Act_sp_done_all_congrats extends vainstrum.Components.a {
    private HashMap w;

    /* compiled from: Act_sp_done_all_congrats.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_done_all_congrats f9969b;

        a(Act_sp_done_all_congrats act_sp_done_all_congrats) {
            this.f9969b = act_sp_done_all_congrats;
        }

        public final void onClick(View view) {
            this.f9969b.finish();
        }
    }

    /* compiled from: Act_sp_done_all_congrats.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_done_all_congrats f9970b;

        b(Act_sp_done_all_congrats act_sp_done_all_congrats) {
            this.f9970b = act_sp_done_all_congrats;
        }

        public final void onClick(View view) {
            o.C(this.f9970b, false);
            o.t(this.f9970b);
            this.f9970b.finish();
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
        setContentView(R.layout.act_sp_done_all_congrats);
        double r = (double) j.r(this);
        Double.isNaN(r);
        Double.isNaN(r);
        AppCompatImageView appCompatImageView = (AppCompatImageView) W(f.a.a.a.b.o.sp_done_all_congrats_img);
        f.d(appCompatImageView, "sp_done_all_congrats_img");
        appCompatImageView.getLayoutParams().height = (int) (r / 1.69d);
        ((ButtonTracking) W(f.a.a.a.b.o.sp_done_all_congrats_btn_continue)).setOnClickListener(new a(this));
        ((ButtonTracking) W(f.a.a.a.b.o.sp_done_all_congrats_btn_give_us_feedback)).setOnClickListener(new b(this));
        o.y(getApplicationContext());
        T((Toolbar) W(f.a.a.a.b.o.sp_done_all_congrats_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.x(false);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.s(false);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.t(false);
        }
    }
}
