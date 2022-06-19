package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
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

public class Act_jtext extends f {
    private Toolbar u;
    private AppCompatTextView v;
    private LinearLayout w;

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
        String stringExtra = getIntent().getStringExtra("title");
        String stringExtra2 = getIntent().getStringExtra("file");
        setContentView(R.layout.act_jtext);
        this.u = (Toolbar) findViewById(R.id.jtext_toolbar);
        this.w = (LinearLayout) findViewById(R.id.jtext_layout_content);
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R.id.jtext_txt_toolbar);
        this.v = appCompatTextView;
        appCompatTextView.setText(stringExtra);
        s.p(this, stringExtra);
        g0.k(this, getLayoutInflater(), this.w, j.N(this, stringExtra2), R.dimen.txt_normal, R.dimen.padding_large, 17170444, false);
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
