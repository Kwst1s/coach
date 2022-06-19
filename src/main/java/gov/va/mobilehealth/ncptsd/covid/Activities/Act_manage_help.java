package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.u;
import f.a.a.a.b.i.i;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.i0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.p;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class Act_manage_help extends i0 {
    private Toolbar u;
    private AppCompatTextView v;
    private FrameLayout w;
    private ArrayList<u> x;

    class a implements m.h {
        a() {
        }

        @Override // androidx.fragment.app.m.h
        public void a() {
            String a2;
            int d0 = Act_manage_help.this.C().d0();
            if (d0 == 0) {
                Act_manage_help.this.v.setText(R.string.help_c);
                Act_manage_help act_manage_help = Act_manage_help.this;
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(act_manage_help, act_manage_help.getString(R.string.help));
                Act_manage_help.this.getWindow().getDecorView().sendAccessibilityEvent(32);
                return;
            }
            m.f c0 = Act_manage_help.this.C().c0(d0 - 1);
            if (c0 != null && (a2 = c0.a()) != null) {
                Act_manage_help.this.v.setText(a2);
                gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(Act_manage_help.this, a2);
                Act_manage_help.this.getWindow().getDecorView().sendAccessibilityEvent(32);
            }
        }
    }

    public void X(Fragment fragment, String str) {
        androidx.fragment.app.u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.w.getId(), fragment, str);
        j2.h(str);
        j2.j();
    }

    public void Y(Fragment fragment, String str) {
        androidx.fragment.app.u j2 = C().j();
        j2.r(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        j2.q(this.w.getId(), fragment, str);
        j2.i();
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
        setContentView(R.layout.act_manage_help);
        this.u = (Toolbar) findViewById(R.id.manage_help_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.manage_help_toolbar_txt);
        this.w = (FrameLayout) findViewById(R.id.manage_help_container);
        try {
            this.x = p.c(new JSONArray(j.N(this, g.f10085e + File.separator + g.s)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        C().e(new a());
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        Y(i.X1(this.x), getString(R.string.help_c));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
