package com.bumptech.glide.load.m;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.r.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher */
public class j implements d<InputStream> {

    /* renamed from: h  reason: collision with root package name */
    static final b f3949h = new a();

    /* renamed from: b  reason: collision with root package name */
    private final g f3950b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3951c;

    /* renamed from: d  reason: collision with root package name */
    private final b f3952d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f3953e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f3954f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f3955g;

    /* compiled from: HttpUrlFetcher */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.m.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(g gVar, int i2) {
        this(gVar, i2, f3949h);
    }

    private InputStream c(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f3954f = c.E(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f3954f = httpURLConnection.getInputStream();
        }
        return this.f3954f;
    }

    private static boolean d(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f3953e = this.f3952d.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f3953e.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f3953e.setConnectTimeout(this.f3951c);
            this.f3953e.setReadTimeout(this.f3951c);
            this.f3953e.setUseCaches(false);
            this.f3953e.setDoInput(true);
            this.f3953e.setInstanceFollowRedirects(false);
            this.f3953e.connect();
            this.f3954f = this.f3953e.getInputStream();
            if (this.f3955g) {
                return null;
            }
            int responseCode = this.f3953e.getResponseCode();
            if (d(responseCode)) {
                return c(this.f3953e);
            }
            if (g(responseCode)) {
                String headerField = this.f3953e.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f3953e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @Override // com.bumptech.glide.load.m.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        InputStream inputStream = this.f3954f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f3953e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f3953e = null;
    }

    @Override // com.bumptech.glide.load.m.d
    public void cancel() {
        this.f3955g = true;
    }

    @Override // com.bumptech.glide.load.m.d
    public com.bumptech.glide.load.a e() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.m.d
    public void f(f fVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long b2 = com.bumptech.glide.r.f.b();
        try {
            aVar.d(h(this.f3950b.h(), 0, null, this.f3950b.e()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.r.f.a(b2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            aVar.c(e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.r.f.a(b2));
            }
            throw th;
        }
    }

    j(g gVar, int i2, b bVar) {
        this.f3950b = gVar;
        this.f3951c = i2;
        this.f3952d = bVar;
    }
}
