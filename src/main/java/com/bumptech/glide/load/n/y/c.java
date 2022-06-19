package com.bumptech.glide.load.n.y;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.p.b;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader */
public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4068a;

    /* compiled from: MediaStoreImageThumbLoader */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4069a;

        public a(Context context) {
            this.f4069a = context;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new c(this.f4069a);
        }
    }

    public c(Context context) {
        this.f4068a = context.getApplicationContext();
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i2, int i3, h hVar) {
        if (b.d(i2, i3)) {
            return new n.a<>(new com.bumptech.glide.q.b(uri), com.bumptech.glide.load.m.p.c.d(this.f4068a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.a(uri);
    }
}
