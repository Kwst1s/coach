package com.bumptech.glide.load.o.g;

import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.o.e.b;

/* compiled from: GifDrawableResource */
public class e extends b<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.o.e.b, com.bumptech.glide.load.engine.q
    public void a() {
        ((c) this.f4102b).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int b() {
        return ((c) this.f4102b).i();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<c> c() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void e() {
        ((c) this.f4102b).stop();
        ((c) this.f4102b).k();
    }
}
