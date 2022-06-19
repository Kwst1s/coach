package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;

/* compiled from: ObjectTypeAdapter */
public final class g extends r<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final s f8401b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final f f8402a;

    /* compiled from: ObjectTypeAdapter */
    class a implements s {
        a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.c() == Object.class) {
                return new g(fVar);
            }
            return null;
        }
    }

    g(f fVar) {
        this.f8402a = fVar;
    }

    @Override // com.google.gson.r
    public void c(com.google.gson.stream.a aVar, Object obj) {
        if (obj == null) {
            aVar.P();
            return;
        }
        r g2 = this.f8402a.g(obj.getClass());
        if (g2 instanceof g) {
            aVar.G();
            aVar.J();
            return;
        }
        g2.c(aVar, obj);
    }
}
