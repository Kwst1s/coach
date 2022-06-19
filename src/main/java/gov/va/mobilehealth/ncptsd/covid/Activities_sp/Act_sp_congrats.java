package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.n;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.HashMap;
import kotlin.m.b.f;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_sp_congrats.kt */
public final class Act_sp_congrats extends vainstrum.Components.a {
    private int w = 1;
    private int x;
    private HashMap y;

    /* compiled from: Act_sp_congrats.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_congrats f9968b;

        a(Act_sp_congrats act_sp_congrats) {
            this.f9968b = act_sp_congrats;
        }

        public final void onClick(View view) {
            this.f9968b.finish();
        }
    }

    public View W(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        int i2 = 0;
        for (int i3 = 1; i3 < 7; i3++) {
            if (o.p(getApplicationContext(), i3)) {
                i2++;
            }
        }
        if (i2 >= 2) {
            o.G(getApplicationContext(), true);
        }
    }

    public final void Y() {
        String str;
        String str2;
        switch (this.w) {
            case 1:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_1_n2p);
                ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_1);
                s.p(this, getString(R.string.step_1));
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), j.N(this, h.q), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                n.d(getApplicationContext(), this.w);
                n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                return;
            case 2:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_2_n2p);
                ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_2);
                s.p(this, getString(R.string.step_2));
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), j.N(this, h.r), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                n.d(getApplicationContext(), this.w);
                n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                return;
            case 3:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_3_n2p);
                s.p(this, getString(R.string.step_3));
                if (this.x == 1) {
                    ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_3_contacts);
                    str = j.N(this, h.s);
                } else {
                    ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_3_places);
                    str = j.N(this, h.t);
                }
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), str, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                if (o.p(getApplicationContext(), this.w)) {
                    n.d(getApplicationContext(), this.w);
                    n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                    return;
                }
                return;
            case 4:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_4_n2p);
                ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_4);
                s.p(this, getString(R.string.step_4));
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), j.N(this, h.u), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                n.d(getApplicationContext(), this.w);
                n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                return;
            case 5:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_5_n2p);
                ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_5);
                s.p(this, getString(R.string.step_5));
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), j.N(this, h.v), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                n.d(getApplicationContext(), this.w);
                n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                return;
            case 6:
                ((AppCompatTextView) W(f.a.a.a.b.o.sp_congrats_txt_toolbar)).setText(R.string.step_6_n2p);
                s.p(this, getString(R.string.step_6));
                if (this.x == 1) {
                    ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_6_environment);
                    str2 = j.N(this, h.x);
                } else {
                    ((AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img)).setImageResource(R.drawable.sp_congrats_6_contact);
                    str2 = j.N(this, h.w);
                }
                g0.k(this, getLayoutInflater(), (LinearLayout) W(f.a.a.a.b.o.sp_congrats_layout_content), str2, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
                if (o.p(getApplicationContext(), this.w)) {
                    n.d(getApplicationContext(), this.w);
                    n.f(getApplicationContext(), this.w, System.currentTimeMillis());
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        this.w = getIntent().getIntExtra("step", -1);
        this.x = getIntent().getIntExtra("step_variant", -1);
        setContentView(R.layout.act_sp_congrats);
        double r = (double) j.r(this);
        Double.isNaN(r);
        AppCompatImageView appCompatImageView = (AppCompatImageView) W(f.a.a.a.b.o.sp_congrats_img);
        f.d(appCompatImageView, "sp_congrats_img");
        appCompatImageView.getLayoutParams().height = (int) (r / 1.69d);
        ((TextViewTracking) W(f.a.a.a.b.o.sp_congrats_txt_done)).setOnClickListener(new a(this));
        Y();
        X();
        T((Toolbar) W(f.a.a.a.b.o.sp_congrats_toolbar));
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
