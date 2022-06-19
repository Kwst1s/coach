package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.p.e;
import com.bumptech.glide.p.j.f;
import com.bumptech.glide.p.j.i;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext */
public class d extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    static final j<?, ?> f3520k = new a();

    /* renamed from: a  reason: collision with root package name */
    private final b f3521a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f3522b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3523c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f3524d;

    /* renamed from: e  reason: collision with root package name */
    private final List<e<Object>> f3525e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f3526f;

    /* renamed from: g  reason: collision with root package name */
    private final k f3527g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3528h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3529i;

    /* renamed from: j  reason: collision with root package name */
    private com.bumptech.glide.p.f f3530j;

    public d(Context context, com.bumptech.glide.load.engine.z.b bVar, Registry registry, f fVar, b.a aVar, Map<Class<?>, j<?, ?>> map, List<e<Object>> list, k kVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f3521a = bVar;
        this.f3522b = registry;
        this.f3523c = fVar;
        this.f3524d = aVar;
        this.f3525e = list;
        this.f3526f = map;
        this.f3527g = kVar;
        this.f3528h = z;
        this.f3529i = i2;
    }

    public <X> i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f3523c.a(imageView, cls);
    }

    public com.bumptech.glide.load.engine.z.b b() {
        return this.f3521a;
    }

    public List<e<Object>> c() {
        return this.f3525e;
    }

    public synchronized com.bumptech.glide.p.f d() {
        if (this.f3530j == null) {
            com.bumptech.glide.p.f a2 = this.f3524d.a();
            a2.J();
            this.f3530j = a2;
        }
        return this.f3530j;
    }

    public <T> j<?, T> e(Class<T> cls) {
        j<?, T> jVar = (j<?, T>) this.f3526f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f3526f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j<?, T>) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) f3520k : jVar;
    }

    public k f() {
        return this.f3527g;
    }

    public int g() {
        return this.f3529i;
    }

    public Registry h() {
        return this.f3522b;
    }

    public boolean i() {
        return this.f3528h;
    }
}
