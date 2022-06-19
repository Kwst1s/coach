package com.google.gson.u.m;

import com.google.gson.e;
import com.google.gson.f;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u.d;
import com.google.gson.u.j;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class h implements s {

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.u.c f8403b;

    /* renamed from: c  reason: collision with root package name */
    private final e f8404c;

    /* renamed from: d  reason: collision with root package name */
    private final d f8405d;

    /* renamed from: e  reason: collision with root package name */
    private final d f8406e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.gson.u.n.b f8407f = com.google.gson.u.n.b.a();

    /* access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory */
    public class a extends c {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Field f8408c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f8409d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ r f8410e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f8411f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.google.gson.v.a f8412g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar, String str, boolean z, boolean z2, Field field, boolean z3, r rVar, f fVar, com.google.gson.v.a aVar, boolean z4) {
            super(str, z, z2);
            this.f8408c = field;
            this.f8409d = z3;
            this.f8410e = rVar;
            this.f8411f = fVar;
            this.f8412g = aVar;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.gson.u.m.h.c
        public void a(com.google.gson.stream.a aVar, Object obj) {
            r rVar;
            Object obj2 = this.f8408c.get(obj);
            if (this.f8409d) {
                rVar = this.f8410e;
            } else {
                rVar = new l(this.f8411f, this.f8410e, this.f8412g.e());
            }
            rVar.c(aVar, obj2);
        }

        @Override // com.google.gson.u.m.h.c
        public boolean b(Object obj) {
            if (this.f8415b && this.f8408c.get(obj) != obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    public static final class b<T> extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, c> f8413a;

        b(com.google.gson.u.h<T> hVar, Map<String, c> map) {
            this.f8413a = map;
        }

        @Override // com.google.gson.r
        public void c(com.google.gson.stream.a aVar, T t) {
            if (t == null) {
                aVar.P();
                return;
            }
            aVar.G();
            try {
                for (c cVar : this.f8413a.values()) {
                    if (cVar.b(t)) {
                        aVar.N(cVar.f8414a);
                        cVar.a(aVar, t);
                    }
                }
                aVar.J();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f8414a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f8415b;

        protected c(String str, boolean z, boolean z2) {
            this.f8414a = str;
            this.f8415b = z;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(com.google.gson.stream.a aVar, Object obj);

        /* access modifiers changed from: package-private */
        public abstract boolean b(Object obj);
    }

    public h(com.google.gson.u.c cVar, e eVar, d dVar, d dVar2) {
        this.f8403b = cVar;
        this.f8404c = eVar;
        this.f8405d = dVar;
        this.f8406e = dVar2;
    }

    private c b(f fVar, Field field, String str, com.google.gson.v.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = j.a(aVar.c());
        com.google.gson.t.b bVar = (com.google.gson.t.b) field.getAnnotation(com.google.gson.t.b.class);
        r<?> b2 = bVar != null ? this.f8406e.b(this.f8403b, fVar, aVar, bVar) : null;
        boolean z3 = b2 != null;
        if (b2 == null) {
            b2 = fVar.f(aVar);
        }
        return new a(this, str, z, z2, field, z3, b2, fVar, aVar, a2);
    }

    static boolean d(Field field, boolean z, d dVar) {
        return !dVar.c(field.getType(), z) && !dVar.f(field, z);
    }

    private Map<String, c> e(f fVar, com.google.gson.v.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type e2 = aVar.e();
        com.google.gson.v.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean c2 = c(field, true);
                boolean c3 = c(field, z);
                if (c2 || c3) {
                    this.f8407f.b(field);
                    Type p = com.google.gson.u.b.p(aVar2.e(), cls2, field.getGenericType());
                    List<String> f2 = f(field);
                    int size = f2.size();
                    c cVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = f2.get(i3);
                        boolean z2 = i3 != 0 ? false : c2;
                        cVar = cVar == null ? (c) linkedHashMap.put(str, b(fVar, field, str, com.google.gson.v.a.b(p), z2, c3)) : cVar;
                        i3++;
                        c2 = z2;
                        f2 = f2;
                        size = size;
                        field = field;
                    }
                    if (cVar != null) {
                        throw new IllegalArgumentException(e2 + " declares multiple JSON fields named " + cVar.f8414a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.google.gson.v.a.b(com.google.gson.u.b.p(aVar2.e(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.c();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        com.google.gson.t.c cVar = (com.google.gson.t.c) field.getAnnotation(com.google.gson.t.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f8404c.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(f fVar, com.google.gson.v.a<T> aVar) {
        Class<? super T> c2 = aVar.c();
        if (!Object.class.isAssignableFrom(c2)) {
            return null;
        }
        return new b(this.f8403b.a(aVar), e(fVar, aVar, c2));
    }

    public boolean c(Field field, boolean z) {
        return d(field, z, this.f8405d);
    }
}
