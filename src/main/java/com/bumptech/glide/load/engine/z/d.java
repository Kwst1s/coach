package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.load.engine.z.m;
import com.bumptech.glide.r.k;
import java.util.Queue;

/* access modifiers changed from: package-private */
/* compiled from: BaseKeyPool */
public abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f3886a = k.e(20);

    d() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    /* access modifiers changed from: package-private */
    public T b() {
        T poll = this.f3886a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t) {
        if (this.f3886a.size() < 20) {
            this.f3886a.offer(t);
        }
    }
}
