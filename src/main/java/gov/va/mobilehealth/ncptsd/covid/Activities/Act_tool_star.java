package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import com.github.mikephil.charting.R;
import f.a.a.a.b.l.h0.b;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;

public class Act_tool_star extends f {
    private Toolbar u;
    private AppCompatTextView v;
    private FrameLayout w;
    private int x;

    public void W() {
        Intent intent = new Intent(getApplicationContext(), Act_show_text.class);
        switch (this.x) {
            case 1000:
                intent.putExtra("file", g.P);
                intent.putExtra("title", getString(R.string.winding_down) + " " + getString(R.string.help_c));
                break;
            case 1001:
                intent.putExtra("file", g.Q);
                intent.putExtra("title", getString(R.string.stay_awake) + " " + getString(R.string.help_c));
                break;
            case 1002:
                intent.putExtra("file", g.R);
                intent.putExtra("title", getString(R.string.cant_sleep) + " " + getString(R.string.help_c));
                break;
            case 1003:
                intent.putExtra("file", g.S);
                intent.putExtra("title", getString(R.string.wake_up) + " " + getString(R.string.help_c));
                break;
        }
        startActivity(intent);
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
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.x = getIntent().getIntExtra("tool_code", -1);
        setContentView(R.layout.act_tool_star);
        this.u = (Toolbar) findViewById(R.id.tool_star_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.tool_star_txt_title);
        this.w = (FrameLayout) findViewById(R.id.tool_star_container);
        u j2 = C().j();
        switch (this.x) {
            case 1000:
                s.p(this, getString(R.string.winding_down));
                this.v.setText(R.string.winding_down);
                j2.p(this.w.getId(), b.W1(1000, getString(R.string.winding_down), g.P, getString(R.string.evening_activities)));
                break;
            case 1001:
                s.p(this, getString(R.string.stay_awake));
                this.v.setText(R.string.stay_awake);
                j2.p(this.w.getId(), b.W1(1001, getString(R.string.stay_awake), g.Q, getString(R.string.activities_to_keep_you_awake)));
                break;
            case 1002:
                s.p(this, getString(R.string.cant_sleep));
                this.v.setText(R.string.cant_sleep);
                j2.p(this.w.getId(), b.W1(1002, getString(R.string.cant_sleep), g.R, getString(R.string.middle_night_activities)));
                break;
            case 1003:
                s.p(this, getString(R.string.wake_up));
                this.v.setText(R.string.wake_up);
                j2.p(this.w.getId(), b.W1(1003, getString(R.string.wake_up), g.S, getString(R.string.morning_activities)));
                break;
        }
        j2.j();
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_act_manage, menu);
        menu.findItem(R.id.action_manage_done).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            d.i();
            finish();
            return true;
        } else if (itemId != R.id.action_manage_help) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            W();
            return true;
        }
    }
}
