package c.b.a.a.j.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import c.b.a.a.j.f.b.d;
import c.b.a.a.m.b;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: MediaSourceProvider */
public class a {
    @SuppressLint({"DefaultLocale"})

    /* renamed from: a  reason: collision with root package name */
    protected String f3109a = String.format("ExoMedia %s (%d) / Android %s / %s", "4.3.0", 43000, Build.VERSION.RELEASE, Build.MODEL);

    /* renamed from: c.b.a.a.j.f.a$a  reason: collision with other inner class name */
    /* compiled from: MediaSourceProvider */
    public static class C0068a {

        /* renamed from: a  reason: collision with root package name */
        public final d f3110a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3111b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3112c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3113d;

        public C0068a(d dVar, String str, String str2, String str3) {
            this.f3110a = dVar;
            this.f3112c = str;
            this.f3111b = str2;
            this.f3113d = str3;
        }
    }

    protected static C0068a a(Uri uri) {
        String a2 = b.a(uri);
        if (a2 != null && !a2.isEmpty()) {
            for (C0068a aVar : c.b.a.a.a.f3053b) {
                String str = aVar.f3111b;
                if (str != null && str.equalsIgnoreCase(a2)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    protected static C0068a b(Uri uri) {
        for (C0068a aVar : c.b.a.a.a.f3053b) {
            if (aVar.f3113d != null && uri.toString().matches(aVar.f3113d)) {
                return aVar;
            }
        }
        return null;
    }

    protected static C0068a c(Uri uri) {
        C0068a d2 = d(uri);
        if (d2 != null) {
            return d2;
        }
        C0068a a2 = a(uri);
        if (a2 != null) {
            return a2;
        }
        C0068a b2 = b(uri);
        if (b2 != null) {
            return b2;
        }
        return null;
    }

    protected static C0068a d(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.isEmpty()) {
            for (C0068a aVar : c.b.a.a.a.f3053b) {
                String str = aVar.f3112c;
                if (str != null && str.equalsIgnoreCase(scheme)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public u e(Context context, Handler handler, Uri uri, x xVar) {
        C0068a c2 = c(uri);
        return (c2 != null ? c2.f3110a : new c.b.a.a.j.f.b.b()).a(context, uri, this.f3109a, handler, xVar);
    }
}
