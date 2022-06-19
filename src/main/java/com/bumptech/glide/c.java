package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.g;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.j;
import com.bumptech.glide.m.d;
import com.bumptech.glide.m.l;
import com.bumptech.glide.p.f;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f3509a = new b.e.a();

    /* renamed from: b  reason: collision with root package name */
    private k f3510b;

    /* renamed from: c  reason: collision with root package name */
    private e f3511c;

    /* renamed from: d  reason: collision with root package name */
    private b f3512d;

    /* renamed from: e  reason: collision with root package name */
    private h f3513e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.engine.b0.a f3514f;

    /* renamed from: g  reason: collision with root package name */
    private com.bumptech.glide.load.engine.b0.a f3515g;

    /* renamed from: h  reason: collision with root package name */
    private a.AbstractC0090a f3516h;

    /* renamed from: i  reason: collision with root package name */
    private i f3517i;

    /* renamed from: j  reason: collision with root package name */
    private d f3518j;

    /* renamed from: k  reason: collision with root package name */
    private int f3519k = 4;
    private b.a l = new a(this);
    private l.b m;
    private com.bumptech.glide.load.engine.b0.a n;
    private boolean o;
    private List<com.bumptech.glide.p.e<Object>> p;
    private boolean q;
    private boolean r;

    /* compiled from: GlideBuilder */
    class a implements b.a {
        a(c cVar) {
        }

        @Override // com.bumptech.glide.b.a
        public f a() {
            return new f();
        }
    }

    /* access modifiers changed from: package-private */
    public b a(Context context) {
        if (this.f3514f == null) {
            this.f3514f = com.bumptech.glide.load.engine.b0.a.g();
        }
        if (this.f3515g == null) {
            this.f3515g = com.bumptech.glide.load.engine.b0.a.e();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.engine.b0.a.c();
        }
        if (this.f3517i == null) {
            this.f3517i = new i.a(context).a();
        }
        if (this.f3518j == null) {
            this.f3518j = new com.bumptech.glide.m.f();
        }
        if (this.f3511c == null) {
            int b2 = this.f3517i.b();
            if (b2 > 0) {
                this.f3511c = new com.bumptech.glide.load.engine.z.k((long) b2);
            } else {
                this.f3511c = new com.bumptech.glide.load.engine.z.f();
            }
        }
        if (this.f3512d == null) {
            this.f3512d = new j(this.f3517i.a());
        }
        if (this.f3513e == null) {
            this.f3513e = new g((long) this.f3517i.d());
        }
        if (this.f3516h == null) {
            this.f3516h = new com.bumptech.glide.load.engine.a0.f(context);
        }
        if (this.f3510b == null) {
            this.f3510b = new k(this.f3513e, this.f3516h, this.f3515g, this.f3514f, com.bumptech.glide.load.engine.b0.a.h(), this.n, this.o);
        }
        List<com.bumptech.glide.p.e<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new b(context, this.f3510b, this.f3513e, this.f3511c, this.f3512d, new l(this.m), this.f3518j, this.f3519k, this.l, this.f3509a, this.p, this.q, this.r);
    }

    /* access modifiers changed from: package-private */
    public void b(l.b bVar) {
        this.m = bVar;
    }
}
