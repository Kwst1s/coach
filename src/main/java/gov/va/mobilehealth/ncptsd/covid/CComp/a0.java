package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_webview;

/* compiled from: JSInterface */
public class a0 {

    /* renamed from: b  reason: collision with root package name */
    public static String f10063b = "<!DOCTYPE html><html><body onload='document.frm1.submit()'><form action='https://findtreatment.samhsa.gov/locator' method='post' name='frm1' encType='multipart/form-data'>  <input type='hidden' name='sAddr' value='%s'><br></form></body></html>";

    /* renamed from: a  reason: collision with root package name */
    private Activity f10064a;

    public a0(Activity activity) {
        this.f10064a = activity;
    }

    @JavascriptInterface
    public void getVal(String str) {
        Intent intent = new Intent(this.f10064a, Act_webview.class);
        intent.putExtra("title", this.f10064a.getString(R.string.samhsa_locator));
        intent.putExtra("body", String.format(f10063b, str));
        this.f10064a.startActivity(intent);
    }
}
