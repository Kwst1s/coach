package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.engine.a0.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class d implements a.AbstractC0090a {

    /* renamed from: a  reason: collision with root package name */
    private final long f3671a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3672b;

    /* compiled from: DiskLruCacheFactory */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.f3671a = j2;
        this.f3672b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.AbstractC0090a
    public a a() {
        File a2 = this.f3672b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.c(a2, this.f3671a);
        }
        return null;
    }
}
