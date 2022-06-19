package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.o.e.d;

/* compiled from: ResourceBitmapDecoder */
public class w implements j<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f4235a;

    /* renamed from: b  reason: collision with root package name */
    private final e f4236b;

    public w(d dVar, e eVar) {
        this.f4235a = dVar;
        this.f4236b = eVar;
    }

    /* renamed from: c */
    public u<Bitmap> a(Uri uri, int i2, int i3, h hVar) {
        u<Drawable> c2 = this.f4235a.a(uri, i2, i3, hVar);
        if (c2 == null) {
            return null;
        }
        return m.a(this.f4236b, c2.get(), i2, i3);
    }

    /* renamed from: d */
    public boolean b(Uri uri, h hVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
