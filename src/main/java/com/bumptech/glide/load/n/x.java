package com.bumptech.glide.load.n;

import android.net.Uri;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f4061b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, Data> f4062a;

    /* compiled from: UrlUriLoader */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f4062a = nVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i2, int i3, h hVar) {
        return this.f4062a.a(new g(uri.toString()), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f4061b.contains(uri.getScheme());
    }
}
