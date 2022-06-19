package com.bumptech.glide.load.n;

import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;

/* compiled from: UnitModelLoader */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f4053a = new v<>();

    /* compiled from: UnitModelLoader */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f4054a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f4054a;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    /* compiled from: UnitModelLoader */
    private static class b<Model> implements d<Model> {

        /* renamed from: b  reason: collision with root package name */
        private final Model f4055b;

        b(Model model) {
            this.f4055b = model;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Model> a() {
            return (Class<Model>) this.f4055b.getClass();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(f fVar, d.a<? super Model> aVar) {
            aVar.d(this.f4055b);
        }
    }

    public static <T> v<T> c() {
        return (v<T>) f4053a;
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Model> a(Model model, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(model), new b(model));
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean b(Model model) {
        return true;
    }
}
