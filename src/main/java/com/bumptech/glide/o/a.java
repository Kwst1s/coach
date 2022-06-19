package com.bumptech.glide.o;

import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0105a<?>> f4274a = new ArrayList();

    /* renamed from: com.bumptech.glide.o.a$a  reason: collision with other inner class name */
    /* compiled from: EncoderRegistry */
    private static final class C0105a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4275a;

        /* renamed from: b  reason: collision with root package name */
        final d<T> f4276b;

        C0105a(Class<T> cls, d<T> dVar) {
            this.f4275a = cls;
            this.f4276b = dVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f4275a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f4274a.add(new C0105a<>(cls, dVar));
    }

    public synchronized <T> d<T> b(Class<T> cls) {
        for (C0105a<?> aVar : this.f4274a) {
            if (aVar.a(cls)) {
                return aVar.f4276b;
            }
        }
        return null;
    }
}
