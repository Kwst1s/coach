package gov.va.mobilehealth.ncptsd.covid.Activities_sp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.x0;
import f.a.a.a.b.j.d;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext;
import gov.va.mobilehealth.ncptsd.covid.CComp.h;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.n;
import gov.va.mobilehealth.ncptsd.covid.CComp.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.m.b.f;
import kotlin.o.e;
import vainstrum.Components.ImageViewTracking;

/* compiled from: Act_sp_steps.kt */
public final class Act_sp_steps extends c {
    private final int t = 213;
    private HashMap u;

    /* compiled from: Act_sp_steps.kt */
    static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_steps f9995b;

        a(Act_sp_steps act_sp_steps) {
            this.f9995b = act_sp_steps;
        }

        public final void onClick(View view) {
            this.f9995b.Z();
        }
    }

    /* compiled from: Act_sp_steps.kt */
    public static final class b implements ViewPager.j {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_sp_steps f9996b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(Act_sp_steps act_sp_steps) {
            this.f9996b = act_sp_steps;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            int i3 = i2 + 1;
            o.J(this.f9996b.getApplicationContext(), i3);
            Act_sp_steps act_sp_steps = this.f9996b;
            int i4 = f.a.a.a.b.o.sp_steps_toolbar_txt_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) act_sp_steps.W(i4);
            f.d(appCompatTextView, "sp_steps_toolbar_txt_title");
            appCompatTextView.setText(this.f9996b.getString(R.string.step) + " " + String.valueOf(i3));
            Act_sp_steps act_sp_steps2 = this.f9996b;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) act_sp_steps2.W(i4);
            f.d(appCompatTextView2, "sp_steps_toolbar_txt_title");
            s.p(act_sp_steps2, appCompatTextView2.getText().toString());
            Window window = this.f9996b.getWindow();
            f.d(window, "window");
            window.getDecorView().sendAccessibilityEvent(32);
            if (!j.t(this.f9996b.getApplicationContext(), "seen_swipe_sp2", false)) {
                this.f9996b.b0();
            }
        }
    }

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

    public final void X() {
        if (!o.o(getApplicationContext()) && o.p(getApplicationContext(), 1) && o.p(getApplicationContext(), 2) && o.p(getApplicationContext(), 3) && o.p(getApplicationContext(), 4) && o.p(getApplicationContext(), 4) && o.p(getApplicationContext(), 5) && o.p(getApplicationContext(), 6)) {
            startActivityForResult(new Intent(getApplicationContext(), Act_sp_done_all_congrats.class), this.t);
        }
    }

    public final BottomSheetLayout Y() {
        BottomSheetLayout bottomSheetLayout = (BottomSheetLayout) W(f.a.a.a.b.o.sp_steps_bs_layout);
        f.d(bottomSheetLayout, "sp_steps_bs_layout");
        return bottomSheetLayout;
    }

    public final void Z() {
        ViewPager viewPager = (ViewPager) W(f.a.a.a.b.o.sp_steps_pager);
        f.d(viewPager, "sp_steps_pager");
        int currentItem = viewPager.getCurrentItem();
        if (currentItem == 0) {
            Intent intent = new Intent(getApplicationContext(), Act_jtext.class);
            intent.putExtra("title", getString(R.string.learn_more));
            intent.putExtra("file", h.y);
            startActivity(intent);
        } else if (currentItem == 1) {
            Intent intent2 = new Intent(getApplicationContext(), Act_jtext.class);
            intent2.putExtra("title", getString(R.string.learn_more));
            intent2.putExtra("file", h.z);
            startActivity(intent2);
        } else if (currentItem == 2) {
            startActivity(new Intent(getApplicationContext(), Act_learn_more_step_3.class));
        } else if (currentItem == 3) {
            Intent intent3 = new Intent(getApplicationContext(), Act_jtext.class);
            intent3.putExtra("title", getString(R.string.learn_more));
            intent3.putExtra("file", h.A);
            startActivity(intent3);
        } else if (currentItem == 4) {
            Intent intent4 = new Intent(getApplicationContext(), Act_jtext.class);
            intent4.putExtra("title", getString(R.string.learn_more));
            intent4.putExtra("file", h.B);
            startActivity(intent4);
        } else if (currentItem == 5) {
            startActivity(new Intent(getApplicationContext(), Act_learn_more_step_6.class));
        }
    }

    public final void a0() {
        SharedPreferences.Editor putBoolean;
        j.V(this, getString(R.string.when_finished_swipe));
        SharedPreferences.Editor u2 = j.u(getApplicationContext());
        if (u2 != null && (putBoolean = u2.putBoolean("seen_swipe_sp", true)) != null) {
            putBoolean.apply();
        }
    }

    public final void b0() {
        SharedPreferences.Editor putBoolean;
        SpannableString spannableString = new SpannableString(getString(R.string.remember_tap_i));
        int k2 = e.k(spannableString, "[imgi1]", 0, false, 6, null);
        ImageSpan imageSpan = new ImageSpan(getApplicationContext(), (int) R.drawable.icon_info_black);
        if (k2 != -1) {
            spannableString.setSpan(imageSpan, k2, k2 + 7, 0);
        }
        j.V(this, spannableString);
        SharedPreferences.Editor u2 = j.u(getApplicationContext());
        if (u2 != null && (putBoolean = u2.putBoolean("seen_swipe_sp2", true)) != null) {
            putBoolean.apply();
        }
    }

    public final void c0(int i2) {
        int i3 = f.a.a.a.b.o.sp_steps_pager;
        ((ViewPager) W(i3)).c(new b(this));
        ArrayList<vainstrum.Components.b> arrayList = new ArrayList<>();
        arrayList.add(new f.a.a.a.b.j.a());
        arrayList.add(new f.a.a.a.b.j.b());
        arrayList.add(new f.a.a.a.b.j.c());
        arrayList.add(new d());
        arrayList.add(new f.a.a.a.b.j.e());
        arrayList.add(new f.a.a.a.b.j.f());
        x0 x0Var = new x0(C());
        x0Var.t(this, arrayList);
        ViewPager viewPager = (ViewPager) W(i3);
        f.d(viewPager, "sp_steps_pager");
        viewPager.setAdapter(x0Var);
        ViewPager viewPager2 = (ViewPager) W(i3);
        f.d(viewPager2, "sp_steps_pager");
        viewPager2.setCurrentItem(i2);
        int i4 = i2 + 1;
        o.J(getApplicationContext(), i4);
        int i5 = f.a.a.a.b.o.sp_steps_toolbar_txt_title;
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(i5);
        f.d(appCompatTextView, "sp_steps_toolbar_txt_title");
        appCompatTextView.setText(getString(R.string.step) + " " + String.valueOf(i4));
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(i5);
        f.d(appCompatTextView2, "sp_steps_toolbar_txt_title");
        s.p(this, appCompatTextView2.getText().toString());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.t) {
            finish();
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
        int intExtra = getIntent().getIntExtra("step", 0);
        setContentView(R.layout.act_sp_steps);
        ((ImageViewTracking) W(f.a.a.a.b.o.sp_steps_toolbar_img_help)).setOnClickListener(new a(this));
        c0(intExtra);
        if (!j.t(getApplicationContext(), "seen_swipe_sp", false)) {
            a0();
        } else if (!j.t(getApplicationContext(), "seen_swipe_sp2", false)) {
            b0();
        }
        n.e(getApplicationContext(), System.currentTimeMillis());
        T((Toolbar) W(f.a.a.a.b.o.sp_steps_toolbar));
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
        k.b.d.i();
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        X();
    }
}
