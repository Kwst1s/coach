package com.bumptech.glide.r;

/* compiled from: MultiClassKey */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f4379a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f4380b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f4381c;

    public i() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f4379a = cls;
        this.f4380b = cls2;
        this.f4381c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f4379a.equals(iVar.f4379a) && this.f4380b.equals(iVar.f4380b) && k.c(this.f4381c, iVar.f4381c);
    }

    public int hashCode() {
        int hashCode = ((this.f4379a.hashCode() * 31) + this.f4380b.hashCode()) * 31;
        Class<?> cls = this.f4381c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f4379a + ", second=" + this.f4380b + '}';
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
