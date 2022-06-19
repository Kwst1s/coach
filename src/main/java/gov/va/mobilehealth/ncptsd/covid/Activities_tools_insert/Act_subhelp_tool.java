package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import k.b.d;

public class Act_subhelp_tool extends f {
    private Toolbar u;
    private AppCompatTextView v;
    private LinearLayout w;
    private boolean x = false;
    private boolean y = true;

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        String stringExtra = getIntent().getStringExtra("title");
        String stringExtra2 = getIntent().getStringExtra("content");
        this.x = getIntent().getBooleanExtra("showDone", false);
        this.y = getIntent().getBooleanExtra("showClose", true);
        setContentView(R.layout.act_subhelp_tool);
        this.u = (Toolbar) findViewById(R.id.subhelp_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.subhelp_toolbar_txt);
        this.w = (LinearLayout) findViewById(R.id.subhelp_container);
        g0.k(this, getLayoutInflater(), this.w, stringExtra2, R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
        T(this.u);
        M().t(true);
        if (this.x) {
            M().x(true);
            M().s(true);
            M().v(R.drawable.icon_close);
        }
        this.v.setText(stringExtra);
        T(this.u);
        M().t(false);
        if (this.y) {
            M().x(true);
            M().s(true);
            M().v(R.drawable.icon_close_white);
            M().u(R.string.close);
        } else {
            M().x(false);
            M().s(false);
        }
        s.p(this, stringExtra);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.act_menu_subhelp_tool, menu);
        if (this.x) {
            return true;
        }
        menu.findItem(R.id.action_subhelp_done).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.action_subhelp_done) {
                d.k("Done");
                finish();
            }
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
