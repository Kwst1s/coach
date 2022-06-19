package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;

public class Act_new_goal extends f {
    private boolean A = false;
    private boolean B = true;
    private String C = null;
    private Toolbar u;
    private FrameLayout v;
    private TextView w;
    private TextView x;
    private String y;
    private int z;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            if (!Act_new_goal.this.isFinishing()) {
                dialogInterface.dismiss();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_new_goal.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            d.j(Act_new_goal.this.getApplicationContext(), "22144");
            Act_new_goal.this.c0();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0() {
        int d0 = C().d0();
        if (d0 == 0) {
            this.B = true;
            this.x.setVisibility(0);
            M().z(R.string.new_goal);
            this.C = getString(R.string.new_goal);
            s.p(this, getString(R.string.new_goal));
            getWindow().getDecorView().sendAccessibilityEvent(32);
            return;
        }
        String a2 = C().c0(d0 - 1).a();
        if (a2 != null) {
            this.C = a2;
            M().A(a2);
            s.p(this, getString(R.string.new_goal));
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
        this.B = false;
        this.x.setVisibility(4);
    }

    public void W(Fragment fragment, String str) {
        this.C = str;
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), fragment, str);
        j2.h(str);
        j2.i();
    }

    public int X() {
        return this.z;
    }

    public String Y() {
        return this.y;
    }

    public void Z() {
        W(new f.a.a.a.b.n.b.a(), getString(R.string.your_goal));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void c0() {
        Fragment Y;
        if (this.C != null && (Y = C().Y(this.C)) != null && (Y instanceof f.a.a.a.b.n.b.b)) {
            ((f.a.a.a.b.n.b.b) Y).X1();
        }
    }

    public void d0(Fragment fragment, String str) {
        this.C = str;
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), fragment, str);
        j2.i();
    }

    public void e0(boolean z2) {
        this.A = z2;
        if (z2) {
            this.x.setEnabled(true);
            this.x.setOnClickListener(new c());
            this.x.setAlpha(1.0f);
            return;
        }
        this.x.setEnabled(false);
        this.x.setOnClickListener(null);
        this.x.setAlpha(0.3f);
    }

    public void f0(int i2) {
        this.z = i2;
    }

    public void g0(String str) {
        this.y = str;
    }

    public void h0() {
        b.a h2 = j.h(this, getString(R.string.really_exit_and_lose));
        h2.k(R.string.yes, new b());
        h2.h(R.string.no, new a());
        h2.a().show();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!this.B) {
            super.onBackPressed();
        } else if (this.A) {
            h0();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_new_goal);
        this.u = (Toolbar) findViewById(R.id.new_goal_toolbar);
        this.v = (FrameLayout) findViewById(R.id.new_goal_container);
        this.x = (TextView) findViewById(R.id.new_goal_txt_next);
        this.w = (TextView) findViewById(R.id.new_goal_txt_title);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        C().e(new a(this));
        d0(new f.a.a.a.b.n.b.b(), getString(R.string.new_goal));
        this.w.setText(getString(R.string.new_goal));
        s.p(this, getString(R.string.new_goal));
        e0(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.A) {
            h0();
            return true;
        }
        finish();
        return true;
    }
}
