package com.rd;

import com.rd.b.b.b;

/* compiled from: IndicatorManager */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private com.rd.c.a f8473a;

    /* renamed from: b  reason: collision with root package name */
    private com.rd.b.a f8474b;

    /* renamed from: c  reason: collision with root package name */
    private AbstractC0171a f8475c;

    /* renamed from: com.rd.a$a  reason: collision with other inner class name */
    /* compiled from: IndicatorManager */
    interface AbstractC0171a {
        void e();
    }

    a(AbstractC0171a aVar) {
        this.f8475c = aVar;
        com.rd.c.a aVar2 = new com.rd.c.a();
        this.f8473a = aVar2;
        this.f8474b = new com.rd.b.a(aVar2.b(), this);
    }

    @Override // com.rd.b.b.b.a
    public void a(com.rd.b.c.a aVar) {
        this.f8473a.g(aVar);
        AbstractC0171a aVar2 = this.f8475c;
        if (aVar2 != null) {
            aVar2.e();
        }
    }

    public com.rd.b.a b() {
        return this.f8474b;
    }

    public com.rd.c.a c() {
        return this.f8473a;
    }

    public com.rd.c.c.a d() {
        return this.f8473a.b();
    }
}
