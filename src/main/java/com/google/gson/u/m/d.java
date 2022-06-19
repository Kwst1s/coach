package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.t.b;
import com.google.gson.u.c;
import com.google.gson.v.a;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class d implements s {

    /* renamed from: b  reason: collision with root package name */
    private final c f8395b;

    public d(c cVar) {
        this.f8395b = cVar;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(f fVar, a<T> aVar) {
        b bVar = (b) aVar.c().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (r<T>) b(this.f8395b, fVar, aVar, bVar);
    }

    /* access modifiers changed from: package-private */
    public r<?> b(c cVar, f fVar, a<?> aVar, b bVar) {
        r<?> rVar;
        Object a2 = cVar.a(a.a(bVar.value())).a();
        if (a2 instanceof r) {
            rVar = (r) a2;
        } else if (a2 instanceof s) {
            rVar = ((s) a2).a(fVar, aVar);
        } else {
            boolean z = a2 instanceof p;
            if (z || (a2 instanceof j)) {
                j jVar = null;
                p pVar = z ? (p) a2 : null;
                if (a2 instanceof j) {
                    jVar = (j) a2;
                }
                rVar = new k<>(pVar, jVar, fVar, aVar, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (rVar == null || !bVar.nullSafe()) ? rVar : rVar.a();
    }
}
