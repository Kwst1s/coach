package com.bumptech.glide.load.n.y;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.p.b;
import com.bumptech.glide.load.m.p.c;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import com.bumptech.glide.load.resource.bitmap.a0;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader */
public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4070a;

    /* compiled from: MediaStoreVideoThumbLoader */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4071a;

        public a(Context context) {
            this.f4071a = context;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new d(this.f4071a);
        }
    }

    public d(Context context) {
        this.f4070a = context.getApplicationContext();
    }

    private boolean e(h hVar) {
        Long l = (Long) hVar.c(a0.f4166d);
        return l != null && l.longValue() == -1;
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i2, int i3, h hVar) {
        if (!b.d(i2, i3) || !e(hVar)) {
            return null;
        }
        return new n.a<>(new com.bumptech.glide.q.b(uri), c.g(this.f4070a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.c(uri);
    }
}
