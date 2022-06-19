package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.mikephil.charting.R;

/* compiled from: SAMHSALocatorWidget */
public class f0 extends WebView {

    /* renamed from: b  reason: collision with root package name */
    public static String f10079b = "https://findtreatment.samhsa.gov/locator/widget/260";

    /* access modifiers changed from: package-private */
    /* compiled from: SAMHSALocatorWidget */
    public class a extends WebViewClient {
        a() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.equals(f0.f10079b)) {
                f0.this.loadUrl("javascript:(function () {let btn =  document.getElementsByTagName(\"button\")[0];\n            let txt = document.getElementById('sAddr1');\n            let string;\n            function getVal(){                 return Android.getVal(string);            }\n            btn.addEventListener('click', function(event) {\n                event.preventDefault();\n                string = txt.value;\n                getVal()\n            });})()");
            }
        }
    }

    public f0(Context context) {
        super(context);
        setLayerType(1, null);
    }

    public void a(Activity activity) {
        setScrollContainer(false);
        setWebChromeClient(new WebChromeClient());
        getSettings().setAllowFileAccess(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        addJavascriptInterface(new a0(activity), "Android");
        setWebViewClient(new a());
        loadUrl(f10079b);
        setBackgroundColor(b.h.d.a.b(getContext(), R.color.grey_hh_light));
    }
}
