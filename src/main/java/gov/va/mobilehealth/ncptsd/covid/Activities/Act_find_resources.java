package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;
import vainstrum.Components.b;

public class Act_find_resources extends f {
    private Toolbar u;
    private FrameLayout v;
    private AppCompatTextView w;

    class a implements m.h {
        a() {
        }

        @Override // androidx.fragment.app.m.h
        public void a() {
            int d0 = Act_find_resources.this.C().d0();
            if (d0 == 0) {
                Act_find_resources.this.w.setText(R.string.find_resources);
                Act_find_resources act_find_resources = Act_find_resources.this;
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_find_resources, act_find_resources.getString(R.string.find_resources));
                Act_find_resources.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                return;
            }
            m.f c0 = Act_find_resources.this.C().c0(d0 - 1);
            if (c0 != null) {
                Act_find_resources.this.C().i0().get(0);
                String a2 = c0.a();
                if (a2 != null) {
                    Act_find_resources.this.w.setText(a2);
                    gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(Act_find_resources.this, a2);
                    Act_find_resources.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                }
            }
        }
    }

    public void X(b bVar, String str) {
        bVar.V1(getTitle().toString());
        u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.v.getId(), bVar, str);
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
        this.u = (Toolbar) findViewById(R.id.support_toolbar);
        this.v = (FrameLayout) findViewById(R.id.support_container);
        this.w = (AppCompatTextView) findViewById(R.id.support_txt_title);
        C().e(new a());
        u j2 = C().j();
        j2.p(this.v.getId(), new f.a.a.a.b.k.a());
        j2.j();
        this.w.setText(R.string.find_resources);
        s.p(this, getString(R.string.find_resources));
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
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
