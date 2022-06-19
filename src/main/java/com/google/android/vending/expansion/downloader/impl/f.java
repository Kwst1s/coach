package com.google.android.vending.expansion.downloader.impl;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.util.Log;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* compiled from: DownloadThread */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f8176a;

    /* renamed from: b  reason: collision with root package name */
    private d f8177b;

    /* renamed from: c  reason: collision with root package name */
    private DownloaderService f8178c;

    /* renamed from: d  reason: collision with root package name */
    private final g f8179d;

    /* renamed from: e  reason: collision with root package name */
    private final e f8180e;

    /* renamed from: f  reason: collision with root package name */
    private String f8181f;

    /* access modifiers changed from: private */
    /* compiled from: DownloadThread */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f8182a;

        /* renamed from: b  reason: collision with root package name */
        public int f8183b;

        /* renamed from: c  reason: collision with root package name */
        public String f8184c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8185d;

        /* renamed from: e  reason: collision with root package name */
        public String f8186e;

        /* renamed from: f  reason: collision with root package name */
        public String f8187f;

        /* renamed from: g  reason: collision with root package name */
        public String f8188g;

        /* renamed from: h  reason: collision with root package name */
        public int f8189h;

        /* renamed from: i  reason: collision with root package name */
        public long f8190i;

        private b() {
            this.f8182a = 0;
            this.f8183b = 0;
            this.f8185d = false;
            this.f8189h = 0;
            this.f8190i = 0;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DownloadThread */
    public class c extends Throwable {
        private c(f fVar) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DownloadThread */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f8191a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f8192b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8193c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f8194d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f8195e = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f8196f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8197g = false;

        /* renamed from: h  reason: collision with root package name */
        public String f8198h;

        public d(d dVar, DownloaderService downloaderService) {
            this.f8195e = dVar.l;
            this.f8198h = dVar.f8155a;
            this.f8191a = downloaderService.q(dVar.f8157c);
        }
    }

    public f(d dVar, DownloaderService downloaderService, e eVar) {
        this.f8176a = downloaderService;
        this.f8177b = dVar;
        this.f8178c = downloaderService;
        this.f8180e = eVar;
        this.f8179d = g.a(downloaderService);
        this.f8181f = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + "/" + Build.ID + ")" + downloaderService.getPackageName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[SYNTHETIC, Splitter:B:42:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A(com.google.android.vending.expansion.downloader.impl.f.d r10) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.f.A(com.google.android.vending.expansion.downloader.impl.f$d):void");
    }

    private void B(d dVar, b bVar, byte[] bArr, InputStream inputStream) {
        while (true) {
            int u = u(dVar, bVar, bArr, inputStream);
            if (u == -1) {
                k(dVar, bVar);
                return;
            }
            dVar.f8197g = true;
            F(dVar, bArr, u);
            bVar.f8182a += u;
            bVar.f8183b += u;
            w(dVar, bVar);
            d(dVar);
        }
    }

    private void C(d dVar, b bVar) {
        d dVar2 = this.f8177b;
        dVar2.f8158d = bVar.f8184c;
        this.f8179d.j(dVar2);
    }

    private void D(int i2, boolean z, int i3, int i4, boolean z2, String str) {
        d dVar = this.f8177b;
        dVar.f8162h = i2;
        dVar.f8165k = i3;
        dVar.l = i4;
        dVar.f8161g = System.currentTimeMillis();
        if (!z) {
            this.f8177b.f8164j = 0;
        } else if (z2) {
            this.f8177b.f8164j = 1;
        } else {
            this.f8177b.f8164j++;
        }
        this.f8179d.j(this.f8177b);
    }

    private String E() {
        return this.f8181f;
    }

    private void F(d dVar, byte[] bArr, int i2) {
        try {
            if (dVar.f8192b == null) {
                dVar.f8192b = new FileOutputStream(dVar.f8191a, true);
            }
            dVar.f8192b.write(bArr, 0, i2);
            f(dVar);
        } catch (IOException e2) {
            if (!c.e.a.c.a.a.e.k()) {
                throw new e(this, 499, "external media not mounted while writing destination file");
            } else if (c.e.a.c.a.a.e.c(c.e.a.c.a.a.e.h(dVar.f8191a)) < ((long) i2)) {
                throw new e(this, 498, "insufficient space while writing destination file", e2);
            } else {
                throw new e(this, 492, "while writing destination file: " + e2.toString(), e2);
            }
        }
    }

    private void a(b bVar, HttpGet httpGet) {
        if (bVar.f8185d) {
            String str = bVar.f8184c;
            if (str != null) {
                httpGet.addHeader("If-Match", str);
            }
            httpGet.addHeader("Range", "bytes=" + bVar.f8182a + "-");
        }
    }

    private boolean b(b bVar) {
        return bVar.f8182a > 0 && bVar.f8184c == null;
    }

    private void c(d dVar) {
        int t = this.f8178c.t(this.f8179d);
        if (t == 2) {
            throw new e(this, 195, "waiting for network to return");
        } else if (t == 3) {
            throw new e(this, 197, "waiting for wifi");
        } else if (t == 5) {
            throw new e(this, 195, "roaming gov not allowed");
        } else if (t == 6) {
            throw new e(this, 196, "waiting for wifi or for download over cellular to be authorized");
        }
    }

    private void d(d dVar) {
        if (this.f8178c.s() == 1 && this.f8178c.w() == 193) {
            throw new e(this, this.f8178c.w(), "download paused");
        }
    }

    private void e(d dVar, int i2) {
        f(dVar);
        if (dVar.f8191a != null && DownloaderService.B(i2)) {
            new File(dVar.f8191a).delete();
            dVar.f8191a = null;
        }
    }

    private void f(d dVar) {
        try {
            FileOutputStream fileOutputStream = dVar.f8192b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                dVar.f8192b = null;
            }
        } catch (IOException unused) {
        }
    }

    private void g(d dVar, a aVar, HttpGet httpGet) {
        b bVar = new b();
        d(dVar);
        z(dVar, bVar);
        a(bVar, httpGet);
        c(dVar);
        this.f8180e.w(3);
        HttpResponse y = y(dVar, aVar, httpGet);
        l(dVar, bVar, y);
        t(dVar, bVar, y);
        InputStream s = s(dVar, y);
        this.f8180e.w(4);
        B(dVar, bVar, new byte[4096], s);
    }

    private void h(d dVar) {
        A(dVar);
        String str = dVar.f8191a;
        String b2 = c.e.a.c.a.a.e.b(this.f8178c, this.f8177b.f8157c);
        if (!dVar.f8191a.equals(b2)) {
            File file = new File(str);
            File file2 = new File(b2);
            d dVar2 = this.f8177b;
            long j2 = dVar2.f8159e;
            if (j2 == -1 || dVar2.f8160f != j2) {
                throw new e(this, 487, "file delivered with incorrect size. probably due to network not browser configured");
            } else if (!file.renameTo(file2)) {
                throw new e(this, 492, "unable to finalize destination file");
            }
        }
    }

    private int i(d dVar) {
        if (this.f8178c.t(this.f8179d) != 1) {
            return 195;
        }
        if (this.f8177b.f8164j < 5) {
            dVar.f8193c = true;
            return 194;
        }
        Log.w("LVLDL", "reached max retries for " + this.f8177b.f8164j);
        return 495;
    }

    private void k(d dVar, b bVar) {
        d dVar2 = this.f8177b;
        dVar2.f8160f = (long) bVar.f8182a;
        this.f8179d.j(dVar2);
        String str = bVar.f8186e;
        if (!((str == null || bVar.f8182a == Integer.parseInt(str)) ? false : true)) {
            return;
        }
        if (b(bVar)) {
            throw new e(this, 489, "mismatched content length");
        }
        throw new e(this, i(dVar), "closed socket before end of file");
    }

    private void l(d dVar, b bVar, HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 503 || this.f8177b.f8164j >= 5) {
            if (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) {
                n(dVar, httpResponse, statusCode);
            }
            if (statusCode == (bVar.f8185d ? 206 : 200)) {
                dVar.f8195e = 0;
            } else {
                m(dVar, bVar, statusCode);
                throw null;
            }
        } else {
            o(dVar, httpResponse);
            throw null;
        }
    }

    private void m(d dVar, b bVar, int i2) {
        int i3 = !DownloaderService.B(i2) ? (i2 < 300 || i2 >= 400) ? (!bVar.f8185d || i2 != 200) ? 494 : 489 : 493 : i2;
        throw new e(this, i3, "http error " + i2);
    }

    private void n(d dVar, HttpResponse httpResponse, int i2) {
        if (dVar.f8195e < 5) {
            Header firstHeader = httpResponse.getFirstHeader("Location");
            if (firstHeader != null) {
                try {
                    String uri = new URI(this.f8177b.f8155a).resolve(new URI(firstHeader.getValue())).toString();
                    dVar.f8195e++;
                    dVar.f8198h = uri;
                    if (i2 == 301 || i2 == 303) {
                        dVar.f8196f = uri;
                    }
                    throw new c();
                } catch (URISyntaxException unused) {
                    throw new e(this, 495, "Couldn't resolve redirect URI");
                }
            }
        } else {
            throw new e(this, 497, "too many redirects");
        }
    }

    private void o(d dVar, HttpResponse httpResponse) {
        dVar.f8193c = true;
        Header firstHeader = httpResponse.getFirstHeader("Retry-After");
        if (firstHeader != null) {
            try {
                int parseInt = Integer.parseInt(firstHeader.getValue());
                dVar.f8194d = parseInt;
                if (parseInt >= 0) {
                    if (parseInt < 30) {
                        dVar.f8194d = 30;
                    } else if (parseInt > 86400) {
                        dVar.f8194d = 86400;
                    }
                    int nextInt = dVar.f8194d + c.e.a.c.a.a.e.f3488a.nextInt(31);
                    dVar.f8194d = nextInt;
                    dVar.f8194d = nextInt * 1000;
                } else {
                    dVar.f8194d = 0;
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new e(this, 194, "got 503 Service Unavailable, will retry later");
    }

    private static final boolean p(String str) {
        if (str == null) {
            return false;
        }
        try {
            String host = URI.create(str).getHost();
            if (host == null || (!host.equalsIgnoreCase("localhost") && !host.equals("127.0.0.1") && !host.equals("[::1]"))) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException unused) {
        }
    }

    private void q() {
        StringBuilder sb = new StringBuilder();
        sb.append("Net ");
        sb.append(this.f8178c.t(this.f8179d) == 1 ? "Up" : "Down");
        Log.i("LVLDL", sb.toString());
    }

    private void r(int i2, boolean z, int i3, int i4, boolean z2, String str) {
        D(i2, z, i3, i4, z2, str);
        DownloaderService.A(i2);
    }

    private InputStream s(d dVar, HttpResponse httpResponse) {
        try {
            return httpResponse.getEntity().getContent();
        } catch (IOException e2) {
            q();
            int i2 = i(dVar);
            throw new e(this, i2, "while getting entity: " + e2.toString(), e2);
        }
    }

    private void t(d dVar, b bVar, HttpResponse httpResponse) {
        if (!bVar.f8185d) {
            v(dVar, bVar, httpResponse);
            try {
                DownloaderService downloaderService = this.f8178c;
                d dVar2 = this.f8177b;
                dVar.f8191a = downloaderService.p(dVar2.f8157c, dVar2.f8159e);
                try {
                    dVar.f8192b = new FileOutputStream(dVar.f8191a);
                } catch (FileNotFoundException e2) {
                    try {
                        if (new File(c.e.a.c.a.a.e.i(this.f8178c)).mkdirs()) {
                            dVar.f8192b = new FileOutputStream(dVar.f8191a);
                        }
                    } catch (Exception unused) {
                        throw new e(this, 492, "while opening destination file: " + e2.toString(), e2);
                    }
                }
                C(dVar, bVar);
                c(dVar);
            } catch (DownloaderService.GenerateSaveFileError e3) {
                throw new e(this, e3.f8133b, e3.f8134c);
            }
        }
    }

    private int u(d dVar, b bVar, byte[] bArr, InputStream inputStream) {
        try {
            return inputStream.read(bArr);
        } catch (IOException e2) {
            q();
            this.f8177b.f8160f = (long) bVar.f8182a;
            this.f8179d.j(this.f8177b);
            if (b(bVar)) {
                throw new e(this, 489, "while reading response: " + e2.toString() + ", can't resume interrupted download with no ETag", e2);
            }
            int i2 = i(dVar);
            throw new e(this, i2, "while reading response: " + e2.toString(), e2);
        }
    }

    private void v(d dVar, b bVar, HttpResponse httpResponse) {
        Header firstHeader;
        Header firstHeader2 = httpResponse.getFirstHeader("Content-Disposition");
        if (firstHeader2 != null) {
            bVar.f8187f = firstHeader2.getValue();
        }
        Header firstHeader3 = httpResponse.getFirstHeader("Content-Location");
        if (firstHeader3 != null) {
            bVar.f8188g = firstHeader3.getValue();
        }
        Header firstHeader4 = httpResponse.getFirstHeader("ETag");
        if (firstHeader4 != null) {
            bVar.f8184c = firstHeader4.getValue();
        }
        String str = null;
        Header firstHeader5 = httpResponse.getFirstHeader("Transfer-Encoding");
        if (firstHeader5 != null) {
            str = firstHeader5.getValue();
        }
        Header firstHeader6 = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader6 == null || firstHeader6.getValue().equals("application/vnd.android.obb")) {
            if (str == null && (firstHeader = httpResponse.getFirstHeader("Content-Length")) != null) {
                String value = firstHeader.getValue();
                bVar.f8186e = value;
                long parseLong = Long.parseLong(value);
                if (!(parseLong == -1 || parseLong == this.f8177b.f8159e)) {
                    Log.e("LVLDL", "Incorrect file size delivered.");
                }
            }
            if (bVar.f8186e == null && (str == null || !str.equalsIgnoreCase("chunked"))) {
                throw new e(this, 495, "can't know size of download, giving up");
            }
            return;
        }
        throw new e(this, 487, "file delivered with incorrect Mime type");
    }

    private void w(d dVar, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = bVar.f8182a;
        if (i2 - bVar.f8189h > 4096 && currentTimeMillis - bVar.f8190i > 1000) {
            d dVar2 = this.f8177b;
            dVar2.f8160f = (long) i2;
            this.f8179d.l(dVar2);
            bVar.f8189h = bVar.f8182a;
            bVar.f8190i = currentTimeMillis;
            DownloaderService downloaderService = this.f8178c;
            downloaderService.D(((long) bVar.f8183b) + downloaderService.q);
        }
    }

    private HttpResponse y(d dVar, a aVar, HttpGet httpGet) {
        try {
            return aVar.execute(httpGet);
        } catch (IllegalArgumentException e2) {
            throw new e(this, 495, "while trying to execute request: " + e2.toString(), e2);
        } catch (IOException e3) {
            q();
            int i2 = i(dVar);
            throw new e(this, i2, "while trying to execute request: " + e3.toString(), e3);
        }
    }

    private void z(d dVar, b bVar) {
        String str = dVar.f8191a;
        if (str != null) {
            if (c.e.a.c.a.a.e.l(str)) {
                File file = new File(dVar.f8191a);
                if (file.exists()) {
                    long length = file.length();
                    if (length == 0) {
                        file.delete();
                        dVar.f8191a = null;
                    } else if (this.f8177b.f8158d != null) {
                        try {
                            dVar.f8192b = new FileOutputStream(dVar.f8191a, true);
                            bVar.f8182a = (int) length;
                            long j2 = this.f8177b.f8159e;
                            if (j2 != -1) {
                                bVar.f8186e = Long.toString(j2);
                            }
                            bVar.f8184c = this.f8177b.f8158d;
                            bVar.f8185d = true;
                        } catch (FileNotFoundException e2) {
                            throw new e(this, 492, "while opening destination for resuming: " + e2.toString(), e2);
                        }
                    } else {
                        file.delete();
                        throw new e(this, 489, "Trying to resume a download that can't be resumed");
                    }
                }
            } else {
                throw new e(this, 492, "found invalid internal destination filename");
            }
        }
        if (dVar.f8192b != null) {
            f(dVar);
        }
    }

    public HttpHost j(Context context, String str) {
        String host;
        if (p(str) || this.f8178c.C() || (host = Proxy.getHost(context)) == null) {
            return null;
        }
        return new HttpHost(host, Proxy.getPort(context), "http");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: android.os.PowerManager$WakeLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.android.vending.expansion.downloader.impl.a] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x() {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.f.x():void");
    }

    /* access modifiers changed from: private */
    /* compiled from: DownloadThread */
    public class e extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        public int f8199b;

        public e(f fVar, int i2, String str) {
            super(str);
            this.f8199b = i2;
        }

        public e(f fVar, int i2, String str, Throwable th) {
            super(str, th);
            this.f8199b = i2;
        }
    }
}
