package com.bumptech.glide.m;

import com.bumptech.glide.p.j.h;
import com.bumptech.glide.r.k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker */
public final class p implements i {

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<?>> f4272b = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.m.i
    public void a() {
        for (h hVar : k.i(this.f4272b)) {
            hVar.a();
        }
    }

    @Override // com.bumptech.glide.m.i
    public void e() {
        for (h hVar : k.i(this.f4272b)) {
            hVar.e();
        }
    }

    @Override // com.bumptech.glide.m.i
    public void k() {
        for (h hVar : k.i(this.f4272b)) {
            hVar.k();
        }
    }

    public void l() {
        this.f4272b.clear();
    }

    public List<h<?>> m() {
        return k.i(this.f4272b);
    }

    public void n(h<?> hVar) {
        this.f4272b.add(hVar);
    }

    public void o(h<?> hVar) {
        this.f4272b.remove(hVar);
    }
}
