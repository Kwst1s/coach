package a.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;

/* compiled from: PdfConverter */
public class a implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    private static a f0h;

    /* renamed from: b  reason: collision with root package name */
    private Context f1b;

    /* renamed from: c  reason: collision with root package name */
    private String f2c;

    /* renamed from: d  reason: collision with root package name */
    private File f3d;

    /* renamed from: e  reason: collision with root package name */
    private PrintAttributes f4e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5f;

    /* renamed from: g  reason: collision with root package name */
    private WebView f6g;

    /* renamed from: a.a.a$a  reason: collision with other inner class name */
    /* compiled from: PdfConverter */
    class C0000a extends WebViewClient {

        /* renamed from: a.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: PdfConverter */
        class C0001a extends PrintDocumentAdapter.LayoutResultCallback {
            C0001a(C0000a aVar) {
            }
        }

        /* renamed from: a.a.a$a$b */
        /* compiled from: PdfConverter */
        class b extends PrintDocumentAdapter.WriteResultCallback {
            b() {
            }

            public void onWriteFinished(PageRange[] pageRangeArr) {
                a.this.e();
            }
        }

        C0000a() {
        }

        public void onPageFinished(WebView webView, String str) {
            if (Build.VERSION.SDK_INT >= 19) {
                PrintDocumentAdapter createPrintDocumentAdapter = a.this.f6g.createPrintDocumentAdapter();
                createPrintDocumentAdapter.onLayout(null, a.this.i(), null, new C0001a(this), null);
                createPrintDocumentAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, a.this.h(), null, new b());
                return;
            }
            throw new RuntimeException("call requires API level 19");
        }
    }

    private a() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        this.f1b = null;
        this.f2c = null;
        this.f3d = null;
        this.f4e = null;
        this.f5f = false;
        this.f6g = null;
    }

    private PrintAttributes f() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        return new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.NA_GOVT_LETTER).setResolution(new PrintAttributes.Resolution("RESOLUTION_ID", "RESOLUTION_ID", 600, 600)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
    }

    public static synchronized a g() {
        a aVar;
        synchronized (a.class) {
            if (f0h == null) {
                f0h = new a();
            }
            aVar = f0h;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ParcelFileDescriptor h() {
        try {
            this.f3d.createNewFile();
            return ParcelFileDescriptor.open(this.f3d, 872415232);
        } catch (Exception e2) {
            Log.d("PdfConverter", "Failed to open ParcelFileDescriptor", e2);
            return null;
        }
    }

    private void j(Runnable runnable) {
        new Handler(this.f1b.getMainLooper()).post(runnable);
    }

    public void d(Context context, String str, File file) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        } else if (str == null) {
            throw new IllegalArgumentException("htmlString can't be null");
        } else if (file == null) {
            throw new IllegalArgumentException("file can't be null");
        } else if (!this.f5f) {
            this.f1b = context;
            this.f2c = str;
            this.f3d = file;
            this.f5f = true;
            j(this);
        }
    }

    public PrintAttributes i() {
        PrintAttributes printAttributes = this.f4e;
        return printAttributes != null ? printAttributes : f();
    }

    public void run() {
        WebView webView = new WebView(this.f1b);
        this.f6g = webView;
        webView.setWebViewClient(new C0000a());
        this.f6g.loadData(this.f2c, "text/HTML", "UTF-8");
    }
}
