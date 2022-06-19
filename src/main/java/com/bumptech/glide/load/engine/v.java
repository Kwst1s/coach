package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: ResourceCacheGenerator */
public class v implements f, d.a<Object> {

    /* renamed from: b  reason: collision with root package name */
    private final f.a f3850b;

    /* renamed from: c  reason: collision with root package name */
    private final g<?> f3851c;

    /* renamed from: d  reason: collision with root package name */
    private int f3852d;

    /* renamed from: e  reason: collision with root package name */
    private int f3853e = -1;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.f f3854f;

    /* renamed from: g  reason: collision with root package name */
    private List<n<File, ?>> f3855g;

    /* renamed from: h  reason: collision with root package name */
    private int f3856h;

    /* renamed from: i  reason: collision with root package name */
    private volatile n.a<?> f3857i;

    /* renamed from: j  reason: collision with root package name */
    private File f3858j;

    /* renamed from: k  reason: collision with root package name */
    private w f3859k;

    v(g<?> gVar, f.a aVar) {
        this.f3851c = gVar;
        this.f3850b = aVar;
    }

    private boolean a() {
        return this.f3856h < this.f3855g.size();
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f3850b.b(this.f3859k, exc, this.f3857i.f4022c, a.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f3857i;
        if (aVar != null) {
            aVar.f4022c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void d(Object obj) {
        this.f3850b.c(this.f3854f, obj, this.f3857i.f4022c, a.RESOURCE_DISK_CACHE, this.f3859k);
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean e() {
        List<com.bumptech.glide.load.f> c2 = this.f3851c.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> m = this.f3851c.m();
        if (!m.isEmpty()) {
            while (true) {
                if (this.f3855g == null || !a()) {
                    int i2 = this.f3853e + 1;
                    this.f3853e = i2;
                    if (i2 >= m.size()) {
                        int i3 = this.f3852d + 1;
                        this.f3852d = i3;
                        if (i3 >= c2.size()) {
                            return false;
                        }
                        this.f3853e = 0;
                    }
                    com.bumptech.glide.load.f fVar = c2.get(this.f3852d);
                    Class<?> cls = m.get(this.f3853e);
                    this.f3859k = new w(this.f3851c.b(), fVar, this.f3851c.o(), this.f3851c.s(), this.f3851c.f(), this.f3851c.r(cls), cls, this.f3851c.k());
                    File b2 = this.f3851c.d().b(this.f3859k);
                    this.f3858j = b2;
                    if (b2 != null) {
                        this.f3854f = fVar;
                        this.f3855g = this.f3851c.j(b2);
                        this.f3856h = 0;
                    }
                } else {
                    this.f3857i = null;
                    while (!z && a()) {
                        List<n<File, ?>> list = this.f3855g;
                        int i4 = this.f3856h;
                        this.f3856h = i4 + 1;
                        this.f3857i = list.get(i4).a(this.f3858j, this.f3851c.s(), this.f3851c.f(), this.f3851c.k());
                        if (this.f3857i != null && this.f3851c.t(this.f3857i.f4022c.a())) {
                            this.f3857i.f4022c.f(this.f3851c.l(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f3851c.q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f3851c.i() + " to " + this.f3851c.q());
        }
    }
}
