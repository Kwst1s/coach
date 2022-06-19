package com.bumptech.glide.p.j;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.r.k;

/* compiled from: CustomTarget */
public abstract class c<T> implements h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final int f4339b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4340c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.p.c f4341d;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.m.i
    public void a() {
    }

    @Override // com.bumptech.glide.p.j.h
    public final void b(g gVar) {
    }

    @Override // com.bumptech.glide.p.j.h
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.m.i
    public void e() {
    }

    @Override // com.bumptech.glide.p.j.h
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.j.h
    public final com.bumptech.glide.p.c g() {
        return this.f4341d;
    }

    @Override // com.bumptech.glide.p.j.h
    public final void i(g gVar) {
        gVar.h(this.f4339b, this.f4340c);
    }

    @Override // com.bumptech.glide.p.j.h
    public final void j(com.bumptech.glide.p.c cVar) {
        this.f4341d = cVar;
    }

    @Override // com.bumptech.glide.m.i
    public void k() {
    }

    public c(int i2, int i3) {
        if (k.r(i2, i3)) {
            this.f4339b = i2;
            this.f4340c = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
