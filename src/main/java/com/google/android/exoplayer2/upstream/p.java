package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: DefaultHttpDataSource */
public class p extends f implements HttpDataSource {
    private static final Pattern t = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> u = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6968e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6969f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6970g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6971h;

    /* renamed from: i  reason: collision with root package name */
    private final u<String> f6972i;

    /* renamed from: j  reason: collision with root package name */
    private final HttpDataSource.b f6973j;

    /* renamed from: k  reason: collision with root package name */
    private final HttpDataSource.b f6974k = new HttpDataSource.b();
    private k l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public p(String str, u<String> uVar, int i2, int i3, boolean z, HttpDataSource.b bVar) {
        super(true);
        e.d(str);
        this.f6971h = str;
        this.f6972i = uVar;
        this.f6969f = i2;
        this.f6970g = i3;
        this.f6968e = z;
        this.f6973j = bVar;
    }

    private void k() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                m.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.m = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long l(java.net.HttpURLConnection r10) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.p.l(java.net.HttpURLConnection):long");
    }

    private static URL m(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
        }
        throw new ProtocolException("Null location redirect");
    }

    private HttpURLConnection n(k kVar) {
        HttpURLConnection o2;
        URL url = new URL(kVar.f6922a.toString());
        int i2 = kVar.f6923b;
        byte[] bArr = kVar.f6924c;
        long j2 = kVar.f6926e;
        long j3 = kVar.f6927f;
        boolean c2 = kVar.c(1);
        if (!this.f6968e) {
            return o(url, i2, bArr, j2, j3, c2, true);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                o2 = o(url, i2, bArr, j2, j3, c2, false);
                int responseCode = o2.getResponseCode();
                String headerField = o2.getHeaderField("Location");
                if ((i2 == 1 || i2 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    o2.disconnect();
                    url = m(url, headerField);
                } else if (i2 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return o2;
                } else {
                    o2.disconnect();
                    url = m(url, headerField);
                    bArr = null;
                    i2 = 1;
                }
                i3 = i4;
                j3 = j3;
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i4);
            }
        }
        return o2;
    }

    private HttpURLConnection o(URL url, int i2, byte[] bArr, long j2, long j3, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f6969f);
        httpURLConnection.setReadTimeout(this.f6970g);
        HttpDataSource.b bVar = this.f6973j;
        if (bVar != null) {
            for (Map.Entry<String, String> entry : bVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.f6974k.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f6971h);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(k.b(i2));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static void p(HttpURLConnection httpURLConnection, long j2) {
        int i2 = d0.f7006a;
        if (i2 == 19 || i2 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int q(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.q;
        if (j2 != -1) {
            long j3 = j2 - this.s;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = this.n.read(bArr, i2, i3);
        if (read != -1) {
            this.s += (long) read;
            f(read);
            return read;
        } else if (this.q == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private void r() {
        if (this.r != this.p) {
            byte[] andSet = u.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j2 = this.r;
                long j3 = this.p;
                if (j2 != j3) {
                    int read = this.n.read(andSet, 0, (int) Math.min(j3 - j2, (long) andSet.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.r += (long) read;
                        f(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    u.set(andSet);
                    return;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        try {
            r();
            return q(bArr, i2, i3);
        } catch (IOException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, this.l, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        this.l = kVar;
        long j2 = 0;
        this.s = 0;
        this.r = 0;
        h(kVar);
        try {
            HttpURLConnection n2 = n(kVar);
            this.m = n2;
            try {
                int responseCode = n2.getResponseCode();
                String responseMessage = this.m.getResponseMessage();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.m.getHeaderFields();
                    k();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, responseMessage, headerFields, kVar);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = this.m.getContentType();
                u<String> uVar = this.f6972i;
                if (uVar == null || uVar.a(contentType)) {
                    if (responseCode == 200) {
                        long j3 = kVar.f6926e;
                        if (j3 != 0) {
                            j2 = j3;
                        }
                    }
                    this.p = j2;
                    if (!kVar.c(1)) {
                        long j4 = kVar.f6927f;
                        long j5 = -1;
                        if (j4 != -1) {
                            this.q = j4;
                        } else {
                            long l2 = l(this.m);
                            if (l2 != -1) {
                                j5 = l2 - this.p;
                            }
                            this.q = j5;
                        }
                    } else {
                        this.q = kVar.f6927f;
                    }
                    try {
                        this.n = this.m.getInputStream();
                        this.o = true;
                        i(kVar);
                        return this.q;
                    } catch (IOException e2) {
                        k();
                        throw new HttpDataSource.HttpDataSourceException(e2, kVar, 1);
                    }
                } else {
                    k();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, kVar);
                }
            } catch (IOException e3) {
                k();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + kVar.f6922a.toString(), e3, kVar, 1);
            }
        } catch (IOException e4) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + kVar.f6922a.toString(), e4, kVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f, com.google.android.exoplayer2.upstream.i
    public Map<String, List<String>> c() {
        HttpURLConnection httpURLConnection = this.m;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        try {
            if (this.n != null) {
                p(this.m, j());
                try {
                    this.n.close();
                } catch (IOException e2) {
                    throw new HttpDataSource.HttpDataSourceException(e2, this.l, 3);
                }
            }
        } finally {
            this.n = null;
            k();
            if (this.o) {
                this.o = false;
                g();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* access modifiers changed from: protected */
    public final long j() {
        long j2 = this.q;
        return j2 == -1 ? j2 : j2 - this.s;
    }
}
