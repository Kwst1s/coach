package com.bumptech.glide.load.n.y;

import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader */
public class f implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f4088a;

    /* compiled from: UrlLoader */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<URL, InputStream> b(r rVar) {
            return new f(rVar.d(g.class, InputStream.class));
        }
    }

    public f(n<g, InputStream> nVar) {
        this.f4088a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(URL url, int i2, int i3, h hVar) {
        return this.f4088a.a(new g(url), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(URL url) {
        return true;
    }
}
