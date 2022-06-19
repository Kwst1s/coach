package com.google.gson.u.m;

import com.google.gson.f;
import com.google.gson.j;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;

/* compiled from: TreeTypeAdapter */
public final class k<T> extends r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final p<T> f8420a;

    /* renamed from: b  reason: collision with root package name */
    private final j<T> f8421b;

    /* renamed from: c  reason: collision with root package name */
    final f f8422c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.v.a<T> f8423d;

    /* renamed from: e  reason: collision with root package name */
    private final s f8424e;

    /* renamed from: f  reason: collision with root package name */
    private final k<T>.b f8425f = new b();

    /* renamed from: g  reason: collision with root package name */
    private r<T> f8426g;

    /* compiled from: TreeTypeAdapter */
    private final class b implements o {
        private b(k kVar) {
        }
    }

    public k(p<T> pVar, j<T> jVar, f fVar, com.google.gson.v.a<T> aVar, s sVar) {
        this.f8420a = pVar;
        this.f8421b = jVar;
        this.f8422c = fVar;
        this.f8423d = aVar;
        this.f8424e = sVar;
    }

    private r<T> d() {
        r<T> rVar = this.f8426g;
        if (rVar != null) {
            return rVar;
        }
        r<T> h2 = this.f8422c.h(this.f8424e, this.f8423d);
        this.f8426g = h2;
        return h2;
    }

    @Override // com.google.gson.r
    public void c(com.google.gson.stream.a aVar, T t) {
        p<T> pVar = this.f8420a;
        if (pVar == null) {
            d().c(aVar, t);
        } else if (t == null) {
            aVar.P();
        } else {
            com.google.gson.u.k.a(pVar.a(t, this.f8423d.e(), this.f8425f), aVar);
        }
    }
}
