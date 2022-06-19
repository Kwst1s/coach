package com.bumptech.glide.load.m;

import com.bumptech.glide.load.m.e;
import com.bumptech.glide.r.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f3941b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f3942a = new HashMap();

    /* compiled from: DataRewinderRegistry */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.m.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.m.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* compiled from: DataRewinderRegistry */
    private static final class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3943a;

        b(Object obj) {
            this.f3943a = obj;
        }

        @Override // com.bumptech.glide.load.m.e
        public Object a() {
            return this.f3943a;
        }

        @Override // com.bumptech.glide.load.m.e
        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        j.d(t);
        aVar = this.f3942a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f3942a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f3941b;
        }
        return (e<T>) aVar.b(t);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f3942a.put(aVar.a(), aVar);
    }
}
