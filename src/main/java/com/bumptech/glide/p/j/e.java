package com.bumptech.glide.p.j;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.p.k.b;

/* compiled from: ImageViewTarget */
public abstract class e<Z> extends i<ImageView, Z> implements b.a {

    /* renamed from: h  reason: collision with root package name */
    private Animatable f4342h;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void p(Z z) {
        if (z instanceof Animatable) {
            Z z2 = z;
            this.f4342h = z2;
            z2.start();
            return;
        }
        this.f4342h = null;
    }

    private void s(Z z) {
        r(z);
        p(z);
    }

    @Override // com.bumptech.glide.p.j.a, com.bumptech.glide.m.i
    public void a() {
        Animatable animatable = this.f4342h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.p.j.h
    public void c(Z z, b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            s(z);
        } else {
            p(z);
        }
    }

    @Override // com.bumptech.glide.p.j.h, com.bumptech.glide.p.j.a
    public void d(Drawable drawable) {
        super.d(drawable);
        s(null);
        q(drawable);
    }

    @Override // com.bumptech.glide.p.j.a, com.bumptech.glide.m.i
    public void e() {
        Animatable animatable = this.f4342h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.p.j.i, com.bumptech.glide.p.j.h, com.bumptech.glide.p.j.a
    public void f(Drawable drawable) {
        super.f(drawable);
        s(null);
        q(drawable);
    }

    @Override // com.bumptech.glide.p.j.i, com.bumptech.glide.p.j.h, com.bumptech.glide.p.j.a
    public void h(Drawable drawable) {
        super.h(drawable);
        Animatable animatable = this.f4342h;
        if (animatable != null) {
            animatable.stop();
        }
        s(null);
        q(drawable);
    }

    public void q(Drawable drawable) {
        ((ImageView) this.f4344b).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void r(Z z);
}
