package gov.va.mobilehealth.ncptsd.covid.Activities.Acts_track_mood.Activities_goals;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.i;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.v;

public class Act_edit_goal extends f {
    private Toolbar u;
    private FrameLayout v;
    private f.a.a.a.b.n.b.c w;
    private i x;
    private boolean y = false;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a(Act_edit_goal act_edit_goal) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            Act_edit_goal.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements DialogInterface.OnClickListener {
        c(Act_edit_goal act_edit_goal) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            new v(Act_edit_goal.this.getApplicationContext()).G(Act_edit_goal.this.x.c());
            dialogInterface.dismiss();
            Act_edit_goal.this.finish();
        }
    }

    public void X(Fragment fragment, String str) {
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), fragment, str);
        j2.i();
    }

    public void Y(boolean z) {
        this.y = z;
    }

    public void Z() {
        b.a h2 = j.h(this, getString(R.string.really_delete_goal));
        h2.k(R.string.yes_im_sure, new d());
        h2.h(R.string.cancel, new c(this));
        h2.a().show();
    }

    public void a0() {
        b.a h2 = j.h(this, getString(R.string.really_exit_and_lose));
        h2.k(R.string.yes, new b());
        h2.h(R.string.no, new a(this));
        h2.a().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.y) {
            a0();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.x = (i) getIntent().getSerializableExtra("goal");
        setContentView(R.layout.act_edit_goal);
        this.u = (Toolbar) findViewById(R.id.edit_goal_toolbar);
        this.v = (FrameLayout) findViewById(R.id.edit_goal_container);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        f.a.a.a.b.n.b.c a2 = f.a.a.a.b.n.b.c.a2(this.x);
        this.w = a2;
        X(a2, getString(R.string.your_goal));
        s.p(this, getString(R.string.your_goal));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_goal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.y) {
                    a0();
                } else {
                    finish();
                }
                return true;
            case R.id.action_edit_delete /*{ENCODED_INT: 2131296332}*/:
                k.b.d.j(getApplicationContext(), "22388");
                Z();
                return true;
            case R.id.action_edit_edit /*{ENCODED_INT: 2131296333}*/:
                k.b.d.j(getApplicationContext(), "22376");
                this.w.Y1();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
