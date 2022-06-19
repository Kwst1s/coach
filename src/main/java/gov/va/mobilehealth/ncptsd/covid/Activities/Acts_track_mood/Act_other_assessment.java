package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.n.d.d;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.m.b.f;

/* compiled from: Act_other_assessment.kt */
public final class Act_other_assessment extends i0 {
    private int u;
    private int v;
    private HashMap w;

    /* compiled from: Act_other_assessment.kt */
    static final class a implements m.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_other_assessment f9891a;

        a(Act_other_assessment act_other_assessment) {
            this.f9891a = act_other_assessment;
        }

        @Override // androidx.fragment.app.m.h
        public final void a() {
            m C = this.f9891a.C();
            f.d(C, "supportFragmentManager");
            int d0 = C.d0();
            if (d0 == 0) {
                String str = this.f9891a.getString(R.string.question) + " " + "1" + " " + this.f9891a.getString(R.string.of) + " " + String.valueOf(this.f9891a.Y());
                s.p(this.f9891a, str);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f9891a.W(o.o_assessment_txt_title);
                f.d(appCompatTextView, "o_assessment_txt_title");
                appCompatTextView.setText(str);
                Window window = this.f9891a.getWindow();
                f.d(window, "window");
                window.getDecorView().sendAccessibilityEvent(32);
            } else {
                m.f c0 = this.f9891a.C().c0(d0 - 1);
                f.d(c0, "supportFragmentManager.g…ackEntryAt(backCount - 1)");
                String a2 = c0.a();
                if (a2 != null) {
                    s.p(this.f9891a, a2);
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.f9891a.W(o.o_assessment_txt_title);
                    f.d(appCompatTextView2, "o_assessment_txt_title");
                    appCompatTextView2.setText(a2);
                    Window window2 = this.f9891a.getWindow();
                    f.d(window2, "window");
                    window2.getDecorView().sendAccessibilityEvent(32);
                }
            }
            s.a((Toolbar) this.f9891a.W(o.o_assessment_toolbar));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_other_assessment.kt */
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_other_assessment f9892b;

        b(Act_other_assessment act_other_assessment) {
            this.f9892b = act_other_assessment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f9892b.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_other_assessment.kt */
    public static final class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final c f9893b = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
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

    public final void X(Fragment fragment, String str) {
        f.e(fragment, "fragment");
        f.e(str, "title");
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        FrameLayout frameLayout = (FrameLayout) W(o.o_assessment_container);
        f.d(frameLayout, "o_assessment_container");
        j2.q(frameLayout.getId(), fragment, str);
        j2.h(str);
        j2.i();
    }

    public final int Y() {
        return this.u;
    }

    public final void Z() {
        b.a h2 = j.h(this, getString(R.string.sure_cancel_assessment));
        h2.k(R.string.yes_im_sure, new b(this));
        h2.h(R.string.no_not, c.f9893b);
        h2.a().show();
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
        f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
            return;
        }
        this.v = getIntent().getIntExtra("assessment_type", 0);
        this.u = getIntent().getIntExtra("maxQuestions", 0);
        setContentView(R.layout.act_other_assessment);
        C().e(new a(this));
        T((Toolbar) W(o.o_assessment_toolbar));
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
        String str = getString(R.string.question) + " " + "1" + " " + getString(R.string.of) + " " + String.valueOf(this.u);
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(o.o_assessment_txt_title);
        f.d(appCompatTextView, "o_assessment_txt_title");
        appCompatTextView.setText(str);
        u j2 = C().j();
        FrameLayout frameLayout = (FrameLayout) W(o.o_assessment_container);
        f.d(frameLayout, "o_assessment_container");
        j2.q(frameLayout.getId(), d.m0.a(this.v, 0, this.u, 0, new ArrayList<>()), str);
        j2.j();
        s.p(this, str);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f.e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            Z();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
