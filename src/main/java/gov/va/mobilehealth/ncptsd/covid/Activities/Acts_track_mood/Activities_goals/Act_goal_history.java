package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import com.github.mikephil.charting.R;
import com.rd.PageIndicatorView;
import f.a.a.a.b.b.y0;
import f.a.a.a.b.d.i;
import f.a.a.a.b.d.j;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: Act_goal_history.kt */
public final class Act_goal_history extends f {
    private ArrayList<i> u;
    private HashMap v;

    /* compiled from: Act_goal_history.kt */
    public static final class a implements ViewPager.j {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_goal_history f9901b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(Act_goal_history act_goal_history) {
            this.f9901b = act_goal_history;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            PageIndicatorView pageIndicatorView = (PageIndicatorView) this.f9901b.W(o.goal_history_pager_indicator);
            kotlin.m.b.f.d(pageIndicatorView, "goal_history_pager_indicator");
            pageIndicatorView.setContentDescription(this.f9901b.getString(R.string.page_indicator) + ", " + this.f9901b.getString(R.string.page) + " " + Integer.toString(i2 + 1));
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

    public final void X() {
        ArrayList<i> arrayList = this.u;
        if (arrayList != null) {
            long j2 = -1;
            kotlin.m.b.f.c(arrayList);
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ArrayList<i> arrayList2 = this.u;
                kotlin.m.b.f.c(arrayList2);
                i iVar = arrayList2.get(i3);
                kotlin.m.b.f.d(iVar, "goals!![i]");
                i iVar2 = iVar;
                ArrayList<j> f2 = iVar2.f();
                kotlin.m.b.f.c(f2);
                if (f2.size() > 1 && iVar2.d() > j2) {
                    j2 = iVar2.d();
                    i2 = i3;
                }
            }
            ((ViewPager) W(o.goal_history_container)).N(i2, false);
        }
    }

    public final void Y() {
        m C = C();
        kotlin.m.b.f.d(C, "supportFragmentManager");
        y0 y0Var = new y0(C);
        y0Var.t(this.u);
        ViewPager viewPager = (ViewPager) W(o.goal_history_container);
        kotlin.m.b.f.d(viewPager, "goal_history_container");
        viewPager.setAdapter(y0Var);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() == null) {
            finish();
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("goals");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type kotlin.collections.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Goal> /* = java.util.ArrayList<gov.va.mobilehealth.ncptsd.covid.Data.Goal> */");
        this.u = (ArrayList) serializableExtra;
        boolean booleanExtra = getIntent().getBooleanExtra("most_recent", false);
        setContentView(R.layout.act_goal_history);
        ArrayList<i> arrayList = this.u;
        if (arrayList != null && arrayList.size() == 1) {
            LinearLayout linearLayout = (LinearLayout) W(o.goal_history_pager_indicator_layout);
            kotlin.m.b.f.d(linearLayout, "goal_history_pager_indicator_layout");
            linearLayout.setVisibility(8);
        }
        Y();
        ((ViewPager) W(o.goal_history_container)).c(new a(this));
        T((Toolbar) W(o.goal_history_toolbar));
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
        if (booleanExtra) {
            X();
            return;
        }
        PageIndicatorView pageIndicatorView = (PageIndicatorView) W(o.goal_history_pager_indicator);
        kotlin.m.b.f.d(pageIndicatorView, "goal_history_pager_indicator");
        pageIndicatorView.setContentDescription(getString(R.string.page_indicator) + ", " + getString(R.string.page) + " " + "1");
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
