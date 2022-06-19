package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.m.e;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.p;
import com.bumptech.glide.o.a;
import com.bumptech.glide.o.b;
import com.bumptech.glide.o.c;
import com.bumptech.glide.o.d;
import com.bumptech.glide.o.e;
import com.bumptech.glide.o.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final p f3489a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3490b;

    /* renamed from: c  reason: collision with root package name */
    private final e f3491c;

    /* renamed from: d  reason: collision with root package name */
    private final f f3492d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.m.f f3493e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.o.h.f f3494f;

    /* renamed from: g  reason: collision with root package name */
    private final b f3495g;

    /* renamed from: h  reason: collision with root package name */
    private final d f3496h = new d();

    /* renamed from: i  reason: collision with root package name */
    private final c f3497i = new c();

    /* renamed from: j  reason: collision with root package name */
    private final b.h.j.e<List<Throwable>> f3498j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + ((Object) m));
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        b.h.j.e<List<Throwable>> e2 = com.bumptech.glide.r.l.a.e();
        this.f3498j = e2;
        this.f3489a = new p(e2);
        this.f3490b = new a();
        this.f3491c = new e();
        this.f3492d = new f();
        this.f3493e = new com.bumptech.glide.load.m.f();
        this.f3494f = new com.bumptech.glide.load.o.h.f();
        this.f3495g = new b();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f3491c.d(cls, cls2)) {
            for (Class cls5 : this.f3494f.b(cls4, cls3)) {
                arrayList.add(new i(cls, cls4, cls5, this.f3491c.b(cls, cls4), this.f3494f.a(cls4, cls5), this.f3498j));
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.f3490b.a(cls, dVar);
        return this;
    }

    public <TResource> Registry b(Class<TResource> cls, k<TResource> kVar) {
        this.f3492d.a(cls, kVar);
        return this;
    }

    public <Data, TResource> Registry c(Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public <Model, Data> Registry d(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f3489a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        this.f3491c.a(str, jVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b2 = this.f3495g.b();
        if (!b2.isEmpty()) {
            return b2;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> a2 = this.f3497i.a(cls, cls2, cls3);
        if (this.f3497i.c(a2)) {
            return null;
        }
        if (a2 == null) {
            List<i<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            if (f2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new s<>(cls, cls2, cls3, f2, this.f3498j);
            }
            this.f3497i.d(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        return this.f3489a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f3496h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> cls4 : this.f3489a.c(cls)) {
                for (Class<?> cls5 : this.f3491c.d(cls4, cls2)) {
                    if (!this.f3494f.b(cls5, cls3).isEmpty() && !a2.contains(cls5)) {
                        a2.add(cls5);
                    }
                }
            }
            this.f3496h.b(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <X> k<X> k(u<X> uVar) {
        k<X> b2 = this.f3492d.b(uVar.c());
        if (b2 != null) {
            return b2;
        }
        throw new NoResultEncoderAvailableException(uVar.c());
    }

    public <X> com.bumptech.glide.load.m.e<X> l(X x) {
        return this.f3493e.a(x);
    }

    public <X> com.bumptech.glide.load.d<X> m(X x) {
        com.bumptech.glide.load.d<X> b2 = this.f3490b.b(x.getClass());
        if (b2 != null) {
            return b2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(u<?> uVar) {
        return this.f3492d.b(uVar.c()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f3495g.a(imageHeaderParser);
        return this;
    }

    public Registry p(e.a<?> aVar) {
        this.f3493e.b(aVar);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.o.h.e<TResource, Transcode> eVar) {
        this.f3494f.c(cls, cls2, eVar);
        return this;
    }

    public final Registry r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f3491c.e(arrayList);
        return this;
    }
}
