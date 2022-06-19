package com.bumptech.glide.load.n.y;

import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.j;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.load.n.m;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader */
public class a implements n<g, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.load.g<Integer> f4063b = com.bumptech.glide.load.g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    private final m<g, g> f4064a;

    /* renamed from: com.bumptech.glide.load.n.y.a$a  reason: collision with other inner class name */
    /* compiled from: HttpGlideUrlLoader */
    public static class C0100a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f4065a = new m<>(500);

        @Override // com.bumptech.glide.load.n.o
        public n<g, InputStream> b(r rVar) {
            return new a(this.f4065a);
        }
    }

    public a(m<g, g> mVar) {
        this.f4064a = mVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(g gVar, int i2, int i3, h hVar) {
        m<g, g> mVar = this.f4064a;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.f4064a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) hVar.c(f4063b)).intValue()));
    }

    /* renamed from: d */
    public boolean b(g gVar) {
        return true;
    }
}
