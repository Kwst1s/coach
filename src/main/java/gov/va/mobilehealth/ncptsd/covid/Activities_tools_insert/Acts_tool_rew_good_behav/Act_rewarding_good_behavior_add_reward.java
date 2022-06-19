package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Acts_tool_rew_good_behav;

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
import f.a.a.a.b.d.s;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.HashMap;

/* compiled from: Act_rewarding_good_behavior_add_reward.kt */
public final class Act_rewarding_good_behavior_add_reward extends f {
    private s u;
    private HashMap v;

    /* compiled from: Act_rewarding_good_behavior_add_reward.kt */
    static final class a implements m.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Act_rewarding_good_behavior_add_reward f10041a;

        a(Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward) {
            this.f10041a = act_rewarding_good_behavior_add_reward;
        }

        @Override // androidx.fragment.app.m.h
        public final void a() {
            m C = this.f10041a.C();
            kotlin.m.b.f.d(C, "supportFragmentManager");
            int d0 = C.d0();
            if (d0 == 0) {
                Window window = this.f10041a.getWindow();
                kotlin.m.b.f.d(window, "window");
                window.getDecorView().sendAccessibilityEvent(32);
                this.f10041a.Z(R.string.next);
            } else {
                m.f c0 = this.f10041a.C().c0(d0 - 1);
                kotlin.m.b.f.d(c0, "supportFragmentManager.g…ackEntryAt(backCount - 1)");
                if (c0.a() != null) {
                    Window window2 = this.f10041a.getWindow();
                    kotlin.m.b.f.d(window2, "window");
                    window2.getDecorView().sendAccessibilityEvent(32);
                }
                this.f10041a.Z(R.string.save);
            }
            gov.va.mobilehealth.ncptsd.covid.CComp.s.a((Toolbar) this.f10041a.W(o.rewarding_good_behavior_add_reward_toolbar));
        }
    }

    /* compiled from: Act_rewarding_good_behavior_add_reward.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_rewarding_good_behavior_add_reward f10042b;

        b(Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward) {
            this.f10042b = act_rewarding_good_behavior_add_reward;
        }

        public final void onClick(View view) {
            b.o.a.a.b(this.f10042b.getApplicationContext()).d(new Intent("gov.va.mobilehealth.ACTION_NEXT"));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_rewarding_good_behavior_add_reward.kt */
    public static final class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_rewarding_good_behavior_add_reward f10043b;

        c(Act_rewarding_good_behavior_add_reward act_rewarding_good_behavior_add_reward) {
            this.f10043b = act_rewarding_good_behavior_add_reward;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f10043b.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_rewarding_good_behavior_add_reward.kt */
    public static final class d implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final d f10044b = new d();

        d() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
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

    public final void X(Fragment fragment, String str) {
        kotlin.m.b.f.e(fragment, "fragment");
        kotlin.m.b.f.e(str, "title");
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        FrameLayout frameLayout = (FrameLayout) W(o.rewarding_good_behavior_add_reward_container);
        kotlin.m.b.f.d(frameLayout, "rewarding_good_behavior_add_reward_container");
        j2.q(frameLayout.getId(), fragment, str);
        j2.h(str);
        j2.i();
    }

    public final void Y(boolean z) {
        if (z) {
            int i2 = o.rewarding_good_behavior_add_reward_txt_next;
            AppCompatTextView appCompatTextView = (AppCompatTextView) W(i2);
            kotlin.m.b.f.d(appCompatTextView, "rewarding_good_behavior_add_reward_txt_next");
            StringBuilder sb = new StringBuilder();
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(i2);
            kotlin.m.b.f.d(appCompatTextView2, "rewarding_good_behavior_add_reward_txt_next");
            sb.append(appCompatTextView2.getText().toString());
            sb.append(" ");
            sb.append(getString(R.string.button));
            appCompatTextView.setContentDescription(sb.toString());
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(i2);
            kotlin.m.b.f.d(appCompatTextView3, "rewarding_good_behavior_add_reward_txt_next");
            appCompatTextView3.setAlpha(1.0f);
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(i2);
            kotlin.m.b.f.d(appCompatTextView4, "rewarding_good_behavior_add_reward_txt_next");
            appCompatTextView4.setClickable(true);
            ((AppCompatTextView) W(i2)).setOnClickListener(new b(this));
            return;
        }
        int i3 = o.rewarding_good_behavior_add_reward_txt_next;
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView5, "rewarding_good_behavior_add_reward_txt_next");
        StringBuilder sb2 = new StringBuilder();
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView6, "rewarding_good_behavior_add_reward_txt_next");
        sb2.append(appCompatTextView6.getText().toString());
        sb2.append(" ");
        sb2.append(getString(R.string.button_disabled));
        appCompatTextView5.setContentDescription(sb2.toString());
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView7, "rewarding_good_behavior_add_reward_txt_next");
        appCompatTextView7.setAlpha(0.4f);
        AppCompatTextView appCompatTextView8 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView8, "rewarding_good_behavior_add_reward_txt_next");
        appCompatTextView8.setClickable(false);
        ((AppCompatTextView) W(i3)).setOnClickListener(null);
    }

    public final void Z(int i2) {
        int i3 = o.rewarding_good_behavior_add_reward_txt_next;
        ((AppCompatTextView) W(i3)).setText(i2);
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView, "rewarding_good_behavior_add_reward_txt_next");
        appCompatTextView.setContentDescription(getString(i2) + " " + getString(R.string.button_disabled));
    }

    public final void a0() {
        b.a h2 = j.h(this, getString(R.string.sure_cancel_assessment));
        h2.k(R.string.yes_im_sure, new c(this));
        h2.h(R.string.no_not, d.f10044b);
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
        setContentView(R.layout.act_rewarding_good_behavior_add_reward);
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() != null) {
            getIntent().getBooleanExtra("fromNone", false);
            Intent intent2 = getIntent();
            kotlin.m.b.f.c(intent2);
            Bundle extras = intent2.getExtras();
            kotlin.m.b.f.c(extras);
            if (extras.containsKey("reward")) {
                this.u = (s) getIntent().getSerializableExtra("reward");
            }
        }
        C().e(new a(this));
        T((Toolbar) W(o.rewarding_good_behavior_add_reward_toolbar));
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
        int i2 = o.rewarding_good_behavior_add_reward_txt_toolbar;
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(i2);
        kotlin.m.b.f.d(appCompatTextView, "rewarding_good_behavior_add_reward_txt_toolbar");
        double r = (double) j.r(this);
        Double.isNaN(r);
        appCompatTextView.setMaxWidth((int) (r / 2.2d));
        if (this.u != null) {
            ((AppCompatTextView) W(i2)).setText(R.string.edit_reward);
            gov.va.mobilehealth.ncptsd.covid.CComp.s.p(this, getString(R.string.edit_reward));
        } else {
            gov.va.mobilehealth.ncptsd.covid.CComp.s.p(this, getString(R.string.add_a_reward));
        }
        u j2 = C().j();
        kotlin.m.b.f.d(j2, "supportFragmentManager.beginTransaction()");
        FrameLayout frameLayout = (FrameLayout) W(o.rewarding_good_behavior_add_reward_container);
        kotlin.m.b.f.d(frameLayout, "rewarding_good_behavior_add_reward_container");
        j2.p(frameLayout.getId(), f.a.a.a.a.a.a.a.b.g0.a(this.u));
        j2.j();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        a0();
        return true;
    }
}
