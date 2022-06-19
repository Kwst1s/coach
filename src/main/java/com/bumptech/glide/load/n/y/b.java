package com.bumptech.glide.load.n.y;

import android.net.Uri;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader */
public class b implements n<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f4066b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f4067a;

    /* compiled from: HttpUriLoader */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f4067a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i2, int i3, h hVar) {
        return this.f4067a.a(new g(uri.toString()), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f4066b.contains(uri.getScheme());
    }
}
