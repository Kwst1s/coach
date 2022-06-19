package com.bumptech.glide.load.n;

import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.r.j;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader */
public interface n<Model, Data> {

    /* compiled from: ModelLoader */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final f f4020a;

        /* renamed from: b  reason: collision with root package name */
        public final List<f> f4021b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f4022c;

        public a(f fVar, d<Data> dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(f fVar, List<f> list, d<Data> dVar) {
            j.d(fVar);
            this.f4020a = fVar;
            j.d(list);
            this.f4021b = list;
            j.d(dVar);
            this.f4022c = dVar;
        }
    }

    a<Data> a(Model model, int i2, int i3, h hVar);

    boolean b(Model model);
}
