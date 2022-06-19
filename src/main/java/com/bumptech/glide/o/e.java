package com.bumptech.glide.o;

import com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f4283a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f4284b = new HashMap();

    /* access modifiers changed from: private */
    /* compiled from: ResourceDecoderRegistry */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4285a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f4286b;

        /* renamed from: c  reason: collision with root package name */
        final j<T, R> f4287c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.f4285a = cls;
            this.f4286b = cls2;
            this.f4287c = jVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f4285a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4286b);
        }
    }

    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> list;
        if (!this.f4283a.contains(str)) {
            this.f4283a.add(str);
        }
        list = this.f4284b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f4284b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, jVar));
    }

    public synchronized <T, R> List<j<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f4283a) {
            List<a<?, ?>> list = this.f4284b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f4287c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f4283a) {
            List<a<?, ?>> list = this.f4284b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f4286b)) {
                        arrayList.add(aVar.f4286b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f4283a);
        this.f4283a.clear();
        for (String str : list) {
            this.f4283a.add(str);
        }
        for (String str2 : arrayList) {
            if (!list.contains(str2)) {
                this.f4283a.add(str2);
            }
        }
    }
}
