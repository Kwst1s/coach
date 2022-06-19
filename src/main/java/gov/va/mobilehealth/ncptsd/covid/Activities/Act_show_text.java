package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;

public class Act_show_text extends f {
    private Toolbar u;
    private TextView v;
    private TextView w;
    private String x;
    private String y;

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
        }
        this.x = getIntent().getStringExtra("file");
        this.y = getIntent().getStringExtra("title");
        setContentView(R.layout.act_show_text);
        this.u = (Toolbar) findViewById(R.id.show_text_toolbar);
        this.w = (TextView) findViewById(R.id.show_text_content);
        this.v = (TextView) findViewById(R.id.show_text_toolbar_title);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        this.v.setText(this.y);
        m.A0(this, this.y);
        this.w.setText(Html.fromHtml(j.N(getApplicationContext(), this.x)));
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
            return true;
        }
    }
}
