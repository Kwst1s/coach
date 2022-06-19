package com.google.gson.u;

import com.google.gson.b;
import com.google.gson.c;
import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.t.e;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class d implements s, Cloneable {

    /* renamed from: h  reason: collision with root package name */
    public static final d f8345h = new d();

    /* renamed from: b  reason: collision with root package name */
    private double f8346b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private int f8347c = 136;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8348d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8349e;

    /* renamed from: f  reason: collision with root package name */
    private List<b> f8350f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<b> f8351g = Collections.emptyList();

    /* compiled from: Excluder */
    class a extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private r<T> f8352a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8353b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f8354c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.gson.v.a f8355d;

        a(boolean z, boolean z2, f fVar, com.google.gson.v.a aVar) {
            this.f8353b = z2;
            this.f8354c = fVar;
            this.f8355d = aVar;
        }

        private r<T> d() {
            r<T> rVar = this.f8352a;
            if (rVar != null) {
                return rVar;
            }
            r<T> h2 = this.f8354c.h(d.this, this.f8355d);
            this.f8352a = h2;
            return h2;
        }

        @Override // com.google.gson.r
        public void c(com.google.gson.stream.a aVar, T t) {
            if (this.f8353b) {
                aVar.P();
            } else {
                d().c(aVar, t);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f8346b != -1.0d && !m((com.google.gson.t.d) cls.getAnnotation(com.google.gson.t.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((this.f8348d || !h(cls)) && !g(cls)) {
            return false;
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z) {
        for (b bVar : z ? this.f8350f : this.f8351g) {
            if (bVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean h(Class<?> cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean j(com.google.gson.t.d dVar) {
        return dVar == null || dVar.value() <= this.f8346b;
    }

    private boolean k(e eVar) {
        return eVar == null || eVar.value() > this.f8346b;
    }

    private boolean m(com.google.gson.t.d dVar, e eVar) {
        return j(dVar) && k(eVar);
    }

    @Override // com.google.gson.s
    public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
        Class<? super T> c2 = aVar.c();
        boolean d2 = d(c2);
        boolean z = d2 || e(c2, true);
        boolean z2 = d2 || e(c2, false);
        if (z || z2) {
            return new a(z2, z, fVar, aVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean c(Class<?> cls, boolean z) {
        return d(cls) || e(cls, z);
    }

    public boolean f(Field field, boolean z) {
        com.google.gson.t.a aVar;
        if ((this.f8347c & field.getModifiers()) != 0) {
            return true;
        }
        if (!(this.f8346b == -1.0d || m((com.google.gson.t.d) field.getAnnotation(com.google.gson.t.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f8349e && ((aVar = (com.google.gson.t.a) field.getAnnotation(com.google.gson.t.a.class)) == null || (!z ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f8348d && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List<b> list = z ? this.f8350f : this.f8351g;
        if (list.isEmpty()) {
            return false;
        }
        c cVar = new c(field);
        for (b bVar : list) {
            if (bVar.b(cVar)) {
                return true;
            }
        }
        return false;
    }
}
