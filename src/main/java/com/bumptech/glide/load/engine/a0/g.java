package com.bumptech.glide.load.engine.a0;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;

/* compiled from: LruResourceCache */
public class g extends com.bumptech.glide.r.g<f, u<?>> implements h {

    /* renamed from: d  reason: collision with root package name */
    private h.a f3680d;

    public g(long j2) {
        super(j2);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public void c(h.a aVar) {
        this.f3680d = aVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public /* bridge */ /* synthetic */ u d(f fVar, u uVar) {
        return (u) super.k(fVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public /* bridge */ /* synthetic */ u e(f fVar) {
        return (u) super.l(fVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int i(u<?> uVar) {
        if (uVar == null) {
            return super.i(null);
        }
        return uVar.b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void j(f fVar, u<?> uVar) {
        h.a aVar = this.f3680d;
        if (aVar != null && uVar != null) {
            aVar.a(uVar);
        }
    }
}
