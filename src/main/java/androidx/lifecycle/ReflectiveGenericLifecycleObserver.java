package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;

/* access modifiers changed from: package-private */
public class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1447a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0021a f1448b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1447a = obj;
        this.f1448b = a.f1454c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, e.a aVar) {
        this.f1448b.a(iVar, aVar, this.f1447a);
    }
}
