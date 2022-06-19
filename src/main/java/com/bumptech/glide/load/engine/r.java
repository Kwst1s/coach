package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Jobs */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final Map<f, l<?>> f3840a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<f, l<?>> f3841b = new HashMap();

    r() {
    }

    private Map<f, l<?>> b(boolean z) {
        return z ? this.f3841b : this.f3840a;
    }

    /* access modifiers changed from: package-private */
    public l<?> a(f fVar, boolean z) {
        return b(z).get(fVar);
    }

    /* access modifiers changed from: package-private */
    public void c(f fVar, l<?> lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    /* access modifiers changed from: package-private */
    public void d(f fVar, l<?> lVar) {
        Map<f, l<?>> b2 = b(lVar.p());
        if (lVar.equals(b2.get(fVar))) {
            b2.remove(fVar);
        }
    }
}
