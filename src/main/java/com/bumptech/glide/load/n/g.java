package com.bumptech.glide.load.n;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.f;
import com.bumptech.glide.r.j;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl */
public class g implements f {

    /* renamed from: b  reason: collision with root package name */
    private final h f3996b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f3997c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3998d;

    /* renamed from: e  reason: collision with root package name */
    private String f3999e;

    /* renamed from: f  reason: collision with root package name */
    private URL f4000f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f4001g;

    /* renamed from: h  reason: collision with root package name */
    private int f4002h;

    public g(URL url) {
        this(url, h.f4003a);
    }

    private byte[] d() {
        if (this.f4001g == null) {
            this.f4001g = c().getBytes(f.f3924a);
        }
        return this.f4001g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f3999e)) {
            String str = this.f3998d;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f3997c;
                j.d(url);
                str = url.toString();
            }
            this.f3999e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f3999e;
    }

    private URL g() {
        if (this.f4000f == null) {
            this.f4000f = new URL(f());
        }
        return this.f4000f;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f3998d;
        if (str != null) {
            return str;
        }
        URL url = this.f3997c;
        j.d(url);
        return url.toString();
    }

    public Map<String, String> e() {
        return this.f3996b.a();
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!c().equals(gVar.c()) || !this.f3996b.equals(gVar.f3996b)) {
            return false;
        }
        return true;
    }

    public URL h() {
        return g();
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        if (this.f4002h == 0) {
            int hashCode = c().hashCode();
            this.f4002h = hashCode;
            this.f4002h = (hashCode * 31) + this.f3996b.hashCode();
        }
        return this.f4002h;
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f4003a);
    }

    public g(URL url, h hVar) {
        j.d(url);
        this.f3997c = url;
        this.f3998d = null;
        j.d(hVar);
        this.f3996b = hVar;
    }

    public g(String str, h hVar) {
        this.f3997c = null;
        j.b(str);
        this.f3998d = str;
        j.d(hVar);
        this.f3996b = hVar;
    }
}
