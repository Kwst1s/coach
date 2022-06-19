package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator */
class c implements f, d.a<Object> {

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f3716b;

    /* renamed from: c  reason: collision with root package name */
    private final g<?> f3717c;

    /* renamed from: d  reason: collision with root package name */
    private final f.a f3718d;

    /* renamed from: e  reason: collision with root package name */
    private int f3719e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.f f3720f;

    /* renamed from: g  reason: collision with root package name */
    private List<n<File, ?>> f3721g;

    /* renamed from: h  reason: collision with root package name */
    private int f3722h;

    /* renamed from: i  reason: collision with root package name */
    private volatile n.a<?> f3723i;

    /* renamed from: j  reason: collision with root package name */
    private File f3724j;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.f3722h < this.f3721g.size();
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f3718d.b(this.f3720f, exc, this.f3723i.f4022c, a.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f3723i;
        if (aVar != null) {
            aVar.f4022c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void d(Object obj) {
        this.f3718d.c(this.f3720f, obj, this.f3723i.f4022c, a.DATA_DISK_CACHE, this.f3720f);
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean e() {
        while (true) {
            boolean z = false;
            if (this.f3721g == null || !a()) {
                int i2 = this.f3719e + 1;
                this.f3719e = i2;
                if (i2 >= this.f3716b.size()) {
                    return false;
                }
                com.bumptech.glide.load.f fVar = this.f3716b.get(this.f3719e);
                File b2 = this.f3717c.d().b(new d(fVar, this.f3717c.o()));
                this.f3724j = b2;
                if (b2 != null) {
                    this.f3720f = fVar;
                    this.f3721g = this.f3717c.j(b2);
                    this.f3722h = 0;
                }
            } else {
                this.f3723i = null;
                while (!z && a()) {
                    List<n<File, ?>> list = this.f3721g;
                    int i3 = this.f3722h;
                    this.f3722h = i3 + 1;
                    this.f3723i = list.get(i3).a(this.f3724j, this.f3717c.s(), this.f3717c.f(), this.f3717c.k());
                    if (this.f3723i != null && this.f3717c.t(this.f3723i.f4022c.a())) {
                        this.f3723i.f4022c.f(this.f3717c.l(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    c(List<com.bumptech.glide.load.f> list, g<?> gVar, f.a aVar) {
        this.f3719e = -1;
        this.f3716b = list;
        this.f3717c = gVar;
        this.f3718d = aVar;
    }
}
