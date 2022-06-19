package com.bumptech.glide.load.o.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;

/* access modifiers changed from: package-private */
/* compiled from: NonOwnedDrawableResource */
public final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static u<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return Math.max(1, this.f4102b.getIntrinsicWidth() * this.f4102b.getIntrinsicHeight() * 4);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<android.graphics.drawable.Drawable> */
    @Override // com.bumptech.glide.load.engine.u
    public Class<Drawable> c() {
        return this.f4102b.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
    }
}
