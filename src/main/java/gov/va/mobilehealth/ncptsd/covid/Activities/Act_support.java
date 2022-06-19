package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import k.b.d;
import vainstrum.Components.b;

public class Act_support extends c {
    private Toolbar t;
    private FrameLayout u;
    private AppCompatTextView v;

    class a implements m.h {
        a() {
        }

        @Override // androidx.fragment.app.m.h
        public void a() {
            int d0 = Act_support.this.C().d0();
            if (d0 == 0) {
                Act_support.this.v.setText(R.string.get_support);
                Act_support act_support = Act_support.this;
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_support, act_support.getString(R.string.get_support));
                Act_support.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                return;
            }
            m.f c0 = Act_support.this.C().c0(d0 - 1);
            if (c0 != null) {
                Act_support.this.C().i0().get(0);
                String a2 = c0.a();
                if (a2 != null) {
                    Act_support.this.v.setText(a2);
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(Act_support.this, a2);
                    Act_support.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                }
            }
        }
    }

    public void X(b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.u.getId(), bVar, str);
        j2.h(str);
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
        setContentView(R.layout.act_support);
        this.t = (Toolbar) findViewById(R.id.support_toolbar);
        this.u = (FrameLayout) findViewById(R.id.support_container);
        this.v = (AppCompatTextView) findViewById(R.id.support_txt_title);
        C().e(new a());
        u j2 = C().j();
        j2.p(this.u.getId(), new f.a.a.a.b.k.c());
        j2.j();
        T(this.t);
        M().x(true);
        M().s(true);
        M().t(false);
        M().v(R.drawable.ef_ic_arrow_back);
        M().u(R.string.navigate_up);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
