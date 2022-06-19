package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.r;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.lang.reflect.InvocationTargetException;
import k.b.d;

public class Act_webview extends f {
    private Toolbar u;
    private WebView v;
    private TextView w;
    private CircularProgressBar x;
    private String y;
    private String z;

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        d.i();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.y = getIntent().getStringExtra("url");
        this.z = getIntent().getStringExtra("body");
        String stringExtra = getIntent().getStringExtra("title");
        setContentView(R.layout.act_webview);
        this.w = (TextView) findViewById(R.id.webview_txt_title);
        this.u = (Toolbar) findViewById(R.id.webview_toolbar);
        this.v = (WebView) findViewById(R.id.webview_webview);
        this.x = (CircularProgressBar) findViewById(R.id.webview_pb);
        this.v.getSettings().setJavaScriptEnabled(true);
        this.v.getSettings().setLoadsImagesAutomatically(true);
        this.v.getSettings().setLoadWithOverviewMode(true);
        this.v.getSettings().setUseWideViewPort(true);
        this.v.getSettings().setBuiltInZoomControls(true);
        this.v.getSettings().setDisplayZoomControls(false);
        this.v.getSettings().setSupportZoom(true);
        this.v.getSettings().setDomStorageEnabled(true);
        this.v.getSettings().setAppCacheEnabled(true);
        this.v.setWebViewClient(new r(this.v, this.x));
        if (bundle == null) {
            String str = this.z;
            if (str != null) {
                this.v.loadData(str, "text/html", "UTF-8");
            } else {
                String str2 = this.y;
                if (str2 != null) {
                    this.v.loadUrl(str2);
                }
            }
        } else {
            this.v.restoreState(bundle);
        }
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        this.w.setText(j.g(stringExtra));
        s.p(this, stringExtra);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onPause() {
        this.v.onPause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f, androidx.appcompat.app.c
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStop() {
        try {
            Class.forName("android.webkit.WebView").getMethod("onStop", null).invoke(this.v, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        super.onStop();
    }
}
