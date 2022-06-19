package com.bumptech.glide.load.o.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.o.g.c;
import com.bumptech.glide.r.j;

/* compiled from: DrawableResource */
public abstract class b<T extends Drawable> implements u<T>, q {

    /* renamed from: b  reason: collision with root package name */
    protected final T f4102b;

    public b(T t) {
        j.d(t);
        this.f4102b = t;
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        T t = this.f4102b;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).e().prepareToDraw();
        }
    }

    /* renamed from: d */
    public final T get() {
        Drawable.ConstantState constantState = this.f4102b.getConstantState();
        return constantState == null ? this.f4102b : (T) constantState.newDrawable();
    }
}
