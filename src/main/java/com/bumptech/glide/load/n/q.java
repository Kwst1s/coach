package com.bumptech.glide.load.n;

import b.h.j.e;
import com.bumptech.glide.f;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.r.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: MultiModelLoader */
public class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f4027a;

    /* renamed from: b  reason: collision with root package name */
    private final e<List<Throwable>> f4028b;

    /* compiled from: MultiModelLoader */
    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final List<d<Data>> f4029b;

        /* renamed from: c  reason: collision with root package name */
        private final e<List<Throwable>> f4030c;

        /* renamed from: d  reason: collision with root package name */
        private int f4031d = 0;

        /* renamed from: e  reason: collision with root package name */
        private f f4032e;

        /* renamed from: f  reason: collision with root package name */
        private d.a<? super Data> f4033f;

        /* renamed from: g  reason: collision with root package name */
        private List<Throwable> f4034g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4035h;

        a(List<d<Data>> list, e<List<Throwable>> eVar) {
            this.f4030c = eVar;
            j.c(list);
            this.f4029b = list;
        }

        private void g() {
            if (!this.f4035h) {
                if (this.f4031d < this.f4029b.size() - 1) {
                    this.f4031d++;
                    f(this.f4032e, this.f4033f);
                    return;
                }
                j.d(this.f4034g);
                this.f4033f.c(new GlideException("Fetch failed", new ArrayList(this.f4034g)));
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f4029b.get(0).a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            List<Throwable> list = this.f4034g;
            if (list != null) {
                this.f4030c.a(list);
            }
            this.f4034g = null;
            for (d<Data> dVar : this.f4029b) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void c(Exception exc) {
            List<Throwable> list = this.f4034g;
            j.d(list);
            list.add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
            this.f4035h = true;
            for (d<Data> dVar : this.f4029b) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void d(Data data) {
            if (data != null) {
                this.f4033f.d(data);
            } else {
                g();
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return this.f4029b.get(0).e();
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(f fVar, d.a<? super Data> aVar) {
            this.f4032e = fVar;
            this.f4033f = aVar;
            this.f4034g = this.f4030c.b();
            this.f4029b.get(this.f4031d).f(fVar, this);
            if (this.f4035h) {
                cancel();
            }
        }
    }

    q(List<n<Model, Data>> list, e<List<Throwable>> eVar) {
        this.f4027a = list;
        this.f4028b = eVar;
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Data> a(Model model, int i2, int i3, h hVar) {
        n.a<Data> a2;
        int size = this.f4027a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.f fVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.f4027a.get(i4);
            if (nVar.b(model) && (a2 = nVar.a(model, i2, i3, hVar)) != null) {
                fVar = a2.f4020a;
                arrayList.add(a2.f4022c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a<>(fVar, new a(arrayList, this.f4028b));
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean b(Model model) {
        for (n<Model, Data> nVar : this.f4027a) {
            if (nVar.b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f4027a.toArray()) + '}';
    }
}
