package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.n.c.d;
import f.a.a.a.b.n.d.c;
import f.a.a.a.b.n.d.e;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_new_reminders;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.HashMap;
import vainstrum.Components.ImageViewTracking;

/* compiled from: Act_assessment_start.kt */
public final class Act_assessment_start extends f {
    private int u = -1;
    private HashMap v;

    /* compiled from: Act_assessment_start.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_assessment_start f9890b;

        a(Act_assessment_start act_assessment_start) {
            this.f9890b = act_assessment_start;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f9890b, Act_new_reminders.class);
            int X = this.f9890b.X();
            if (X == 119) {
                intent.putExtra("showOnly", 4);
            } else if (X == 124) {
                intent.putExtra("showOnly", 5);
            } else if (X == 224) {
                intent.putExtra("showOnly", 2);
            } else if (X == 411) {
                intent.putExtra("showOnly", 3);
            }
            this.f9890b.startActivity(intent);
        }
    }

    public View W(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int X() {
        return this.u;
    }

    public final void Y() {
        u j2 = C().j();
        kotlin.m.b.f.d(j2, "supportFragmentManager.beginTransaction()");
        int i2 = this.u;
        if (i2 == 119) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) W(o.assessment_start_txt_title);
            kotlin.m.b.f.d(appCompatTextView, "assessment_start_txt_title");
            appCompatTextView.setText(getString(R.string.track_mood));
            s.p(this, getString(R.string.track_mood));
            if (m.d0(getApplicationContext(), this.u)) {
                ImageViewTracking imageViewTracking = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking, "assessment_start_img_reminder");
                imageViewTracking.setVisibility(0);
                FrameLayout frameLayout = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout, "assessment_start_container");
                j2.q(frameLayout.getId(), e.b2(this.u), null);
            } else {
                ImageViewTracking imageViewTracking2 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking2, "assessment_start_img_reminder");
                imageViewTracking2.setVisibility(8);
                FrameLayout frameLayout2 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout2, "assessment_start_container");
                j2.q(frameLayout2.getId(), c.Y1(this.u), null);
            }
        } else if (i2 == 124) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(o.assessment_start_txt_title);
            kotlin.m.b.f.d(appCompatTextView2, "assessment_start_txt_title");
            appCompatTextView2.setText(getString(R.string.track_ptsd_symptoms));
            s.p(this, getString(R.string.track_ptsd_symptoms));
            if (m.e0(getApplicationContext())) {
                ImageViewTracking imageViewTracking3 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking3, "assessment_start_img_reminder");
                imageViewTracking3.setVisibility(0);
                FrameLayout frameLayout3 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout3, "assessment_start_container");
                j2.q(frameLayout3.getId(), new d(), null);
            } else {
                ImageViewTracking imageViewTracking4 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking4, "assessment_start_img_reminder");
                imageViewTracking4.setVisibility(8);
                FrameLayout frameLayout4 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout4, "assessment_start_container");
                j2.q(frameLayout4.getId(), new f.a.a.a.b.n.c.f(), null);
            }
        } else if (i2 == 224) {
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(o.assessment_start_txt_title);
            kotlin.m.b.f.d(appCompatTextView3, "assessment_start_txt_title");
            appCompatTextView3.setText(getString(R.string.track_well_being));
            s.p(this, getString(R.string.track_well_being));
            if (m.d0(getApplicationContext(), this.u)) {
                ImageViewTracking imageViewTracking5 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking5, "assessment_start_img_reminder");
                imageViewTracking5.setVisibility(0);
                FrameLayout frameLayout5 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout5, "assessment_start_container");
                j2.q(frameLayout5.getId(), e.b2(this.u), null);
            } else {
                ImageViewTracking imageViewTracking6 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking6, "assessment_start_img_reminder");
                imageViewTracking6.setVisibility(8);
                FrameLayout frameLayout6 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout6, "assessment_start_container");
                j2.q(frameLayout6.getId(), c.Y1(this.u), null);
            }
        } else if (i2 == 411) {
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(o.assessment_start_txt_title);
            kotlin.m.b.f.d(appCompatTextView4, "assessment_start_txt_title");
            appCompatTextView4.setText(getString(R.string.track_anxiety));
            s.p(this, getString(R.string.track_anxiety));
            if (m.d0(getApplicationContext(), this.u)) {
                ImageViewTracking imageViewTracking7 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking7, "assessment_start_img_reminder");
                imageViewTracking7.setVisibility(0);
                FrameLayout frameLayout7 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout7, "assessment_start_container");
                j2.q(frameLayout7.getId(), e.b2(this.u), null);
            } else {
                ImageViewTracking imageViewTracking8 = (ImageViewTracking) W(o.assessment_start_img_reminder);
                kotlin.m.b.f.d(imageViewTracking8, "assessment_start_img_reminder");
                imageViewTracking8.setVisibility(8);
                FrameLayout frameLayout8 = (FrameLayout) W(o.assessment_start_container);
                kotlin.m.b.f.d(frameLayout8, "assessment_start_container");
                j2.q(frameLayout8.getId(), c.Y1(this.u), null);
            }
        }
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
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        this.u = getIntent().getIntExtra("type", b.a.j.I0);
        setContentView(R.layout.act_assessment_start);
        ((ImageViewTracking) W(o.assessment_start_img_reminder)).setOnClickListener(new a(this));
        T((Toolbar) W(o.assessment_start_toolbar));
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
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        super.onResume();
        Y();
    }
}
