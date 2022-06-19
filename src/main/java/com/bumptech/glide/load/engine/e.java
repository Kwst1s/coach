package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.h;
import java.io.File;

/* compiled from: DataCacheWriter */
class e<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final d<DataType> f3727a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f3728b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3729c;

    e(d<DataType> dVar, DataType datatype, h hVar) {
        this.f3727a = dVar;
        this.f3728b = datatype;
        this.f3729c = hVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.b
    public boolean a(File file) {
        return this.f3727a.a(this.f3728b, file, this.f3729c);
    }
}
