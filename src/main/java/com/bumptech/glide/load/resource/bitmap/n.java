package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation */
public class n implements l<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f4209b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4210c;

    public n(l<Bitmap> lVar, boolean z) {
        this.f4209b = lVar;
        this.f4210c = z;
    }

    private u<Drawable> d(Context context, u<Bitmap> uVar) {
        return t.f(context.getResources(), uVar);
    }

    @Override // com.bumptech.glide.load.l
    public u<Drawable> a(Context context, u<Drawable> uVar, int i2, int i3) {
        e f2 = b.c(context).f();
        Drawable drawable = uVar.get();
        u<Bitmap> a2 = m.a(f2, drawable, i2, i3);
        if (a2 != null) {
            u<Bitmap> a3 = this.f4209b.a(context, a2, i2, i3);
            if (!a3.equals(a2)) {
                return d(context, a3);
            }
            a3.e();
            return uVar;
        } else if (!this.f4210c) {
            return uVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
        this.f4209b.b(messageDigest);
    }

    public l<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f4209b.equals(((n) obj).f4209b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f4209b.hashCode();
    }
}
