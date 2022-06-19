package com.bumptech.glide.o;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f4288a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4289a;

        /* renamed from: b  reason: collision with root package name */
        final k<T> f4290b;

        a(Class<T> cls, k<T> kVar) {
            this.f4289a = cls;
            this.f4290b = kVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f4289a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.f4288a.add(new a<>(cls, kVar));
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: com.bumptech.glide.load.k<T>, com.bumptech.glide.load.k<Z> */
    public synchronized <Z> k<Z> b(Class<Z> cls) {
        int size = this.f4288a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.f4288a.get(i2);
            if (aVar.a(cls)) {
                return (k<T>) aVar.f4290b;
            }
        }
        return null;
    }
}
