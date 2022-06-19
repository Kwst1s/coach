package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;

public class Act_license_agreement extends f implements View.OnClickListener {
    private Toolbar u;
    private LinearLayout v;
    private ImageView w;
    private Button x;

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void onClick(View view) {
        if (view.getId() == this.x.getId()) {
            startActivity(new Intent(this, Act_tutorial.class));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_license_agreement);
        this.u = (Toolbar) findViewById(R.id.license_toolbar);
        this.v = (LinearLayout) findViewById(R.id.license_layout_texts);
        this.x = (Button) findViewById(R.id.license_btn_accept);
        this.w = (ImageView) findViewById(R.id.license_img_logo);
        this.x.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        double r = (double) j.r(this);
        Double.isNaN(r);
        layoutParams.width = (int) (r / 1.4d);
        m.P0(getApplicationContext(), this.v, j.N(this, g.q), R.dimen.txt_normal, R.dimen.padding_medium, false);
        T(this.u);
        M().t(false);
    }
}
