package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.stream.a;
import com.google.gson.u.m.h;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper */
public final class l<T> extends r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f8427a;

    /* renamed from: b  reason: collision with root package name */
    private final r<T> f8428b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f8429c;

    l(f fVar, r<T> rVar, Type type) {
        this.f8427a = fVar;
        this.f8428b = rVar;
        this.f8429c = type;
    }

    private Type d(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // com.google.gson.r
    public void c(a aVar, T t) {
        r<T> rVar = this.f8428b;
        Type d2 = d(this.f8429c, t);
        if (d2 != this.f8429c) {
            rVar = this.f8427a.f(com.google.gson.v.a.b(d2));
            if (rVar instanceof h.b) {
                r<T> rVar2 = this.f8428b;
                if (!(rVar2 instanceof h.b)) {
                    rVar = rVar2;
                }
            }
        }
        rVar.c(aVar, t);
    }
}
