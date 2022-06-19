package f.a.a.a.b.b;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/* compiled from: CustomWebViewClient */
public class r extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f9021a;

    public r(WebView webView, ProgressBar progressBar) {
        this.f9021a = progressBar;
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        ProgressBar progressBar = this.f9021a;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
