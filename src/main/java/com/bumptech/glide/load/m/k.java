package com.bumptech.glide.load.m;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.m.e;
import com.bumptech.glide.load.resource.bitmap.v;
import java.io.InputStream;

/* compiled from: InputStreamRewinder */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final v f3956a;

    /* compiled from: InputStreamRewinder */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f3957a;

        public a(b bVar) {
            this.f3957a = bVar;
        }

        @Override // com.bumptech.glide.load.m.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f3957a);
        }
    }

    public k(InputStream inputStream, b bVar) {
        v vVar = new v(inputStream, bVar);
        this.f3956a = vVar;
        vVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.m.e
    public void b() {
        this.f3956a.F();
    }

    public void c() {
        this.f3956a.E();
    }

    /* renamed from: d */
    public InputStream a() {
        this.f3956a.reset();
        return this.f3956a;
    }
}
