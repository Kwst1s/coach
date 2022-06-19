package com.google.android.vending.expansion.downloader.impl;

import android.os.Looper;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* compiled from: AndroidHttpClient */
public final class a implements HttpClient {

    /* renamed from: d  reason: collision with root package name */
    static Class<?> f8141d;

    /* renamed from: e  reason: collision with root package name */
    private static final HttpRequestInterceptor f8142e = new C0161a();

    /* renamed from: a  reason: collision with root package name */
    private final HttpClient f8143a;

    /* renamed from: b  reason: collision with root package name */
    private RuntimeException f8144b = new IllegalStateException("AndroidHttpClient created and never closed");

    /* renamed from: c  reason: collision with root package name */
    private volatile d f8145c;

    /* renamed from: com.google.android.vending.expansion.downloader.impl.a$a  reason: collision with other inner class name */
    /* compiled from: AndroidHttpClient */
    static class C0161a implements HttpRequestInterceptor {
        C0161a() {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("This thread forbids HTTP requests");
            }
        }
    }

    /* compiled from: AndroidHttpClient */
    class b extends DefaultHttpClient {
        b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
            super(clientConnectionManager, httpParams);
        }

        /* access modifiers changed from: protected */
        public HttpContext createHttpContext() {
            BasicHttpContext basicHttpContext = new BasicHttpContext();
            basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
            basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
            basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
            return basicHttpContext;
        }

        /* access modifiers changed from: protected */
        public BasicHttpProcessor createHttpProcessor() {
            BasicHttpProcessor createHttpProcessor = a.super.createHttpProcessor();
            createHttpProcessor.addRequestInterceptor(a.f8142e);
            createHttpProcessor.addRequestInterceptor(new c(a.this, null));
            return createHttpProcessor;
        }
    }

    /* compiled from: AndroidHttpClient */
    private class c implements HttpRequestInterceptor {
        private c() {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            d dVar = a.this.f8145c;
            if (dVar != null && dVar.c() && (httpRequest instanceof HttpUriRequest)) {
                dVar.d(a.f((HttpUriRequest) httpRequest, false));
            }
        }

        /* synthetic */ c(a aVar, C0161a aVar2) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AndroidHttpClient */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f8148a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8149b;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean c() {
            return Log.isLoggable(this.f8148a, this.f8149b);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void d(String str) {
            Log.println(this.f8149b, this.f8148a, str);
        }
    }

    static {
        try {
            f8141d = Class.forName("android.net.SSLSessionCache");
        } catch (Exception unused) {
        }
    }

    private a(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f8143a = new b(clientConnectionManager, httpParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [org.apache.http.conn.scheme.SocketFactory] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.vending.expansion.downloader.impl.a e(java.lang.String r10, android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.a.e(java.lang.String, android.content.Context):com.google.android.vending.expansion.downloader.impl.a");
    }

    /* access modifiers changed from: private */
    public static String f(HttpUriRequest httpUriRequest, boolean z) {
        HttpEntity entity;
        StringBuilder sb = new StringBuilder();
        sb.append("curl ");
        Header[] allHeaders = httpUriRequest.getAllHeaders();
        for (Header header : allHeaders) {
            if (z || (!header.getName().equals("Authorization") && !header.getName().equals("Cookie"))) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        URI uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpUriRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = original.getURI();
            }
        }
        sb.append("\"");
        sb.append(uri);
        sb.append("\"");
        if ((httpUriRequest instanceof HttpEntityEnclosingRequest) && (entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity()) != null && entity.isRepeatable()) {
            if (entity.getContentLength() < 1024) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                sb.append(" --data-ascii \"");
                sb.append(byteArrayOutputStream2);
                sb.append("\"");
            } else {
                sb.append(" [TOO MUCH DATA TO INCLUDE]");
            }
        }
        return sb.toString();
    }

    public void d() {
        if (this.f8144b != null) {
            getConnectionManager().shutdown();
            this.f8144b = null;
        }
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) {
        return this.f8143a.execute(httpUriRequest);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
        RuntimeException runtimeException = this.f8144b;
        if (runtimeException != null) {
            Log.e("AndroidHttpClient", "Leak found", runtimeException);
            this.f8144b = null;
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return this.f8143a.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.f8143a.getParams();
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return this.f8143a.execute(httpUriRequest, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return this.f8143a.execute(httpHost, httpRequest);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return this.f8143a.execute(httpHost, httpRequest, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) this.f8143a.execute(httpUriRequest, responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) this.f8143a.execute(httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) this.f8143a.execute(httpHost, httpRequest, responseHandler);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) this.f8143a.execute(httpHost, httpRequest, responseHandler, httpContext);
    }
}
