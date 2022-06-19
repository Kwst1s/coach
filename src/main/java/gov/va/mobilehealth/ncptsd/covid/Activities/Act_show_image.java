package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.j0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import k.b.d;

public class Act_show_image extends f {
    private Toolbar u;
    private RelativeLayout v;
    private j0 w;
    private String x;

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_show_image);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.x = extras.getString("image");
            extras.getBoolean("soothing");
            this.u = (Toolbar) findViewById(R.id.show_img_toolbar);
            this.v = (RelativeLayout) findViewById(R.id.show_img_layout);
            j0 j0Var = new j0(this);
            this.w = j0Var;
            j0Var.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            Uri parse = Uri.parse(this.x);
            T(this.u);
            M().x(true);
            M().s(true);
            M().t(true);
            M().z(R.string.soothing_images);
            m.A0(this, getString(R.string.soothing_images));
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.w.addView(imageView);
            this.w.setMaxZoom(7.0f);
            this.v.addView(this.w);
            h<Drawable> s = b.v(this).s(parse);
            s.v0(0.5f);
            s.o0(imageView);
        }
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
