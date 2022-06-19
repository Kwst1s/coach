package kotlin;

import java.io.Serializable;
import kotlin.m.a.a;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
public final class g<T> implements c<T>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private a<? extends T> f10771b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f10772c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f10773d;

    public g(a<? extends T> aVar, Object obj) {
        f.e(aVar, "initializer");
        this.f10771b = aVar;
        this.f10772c = h.f10774a;
        this.f10773d = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f10772c != h.f10774a;
    }

    @Override // kotlin.c
    public T getValue() {
        T t;
        T t2 = (T) this.f10772c;
        h hVar = h.f10774a;
        if (t2 != hVar) {
            return t2;
        }
        synchronized (this.f10773d) {
            t = (T) this.f10772c;
            if (t == hVar) {
                a<? extends T> aVar = this.f10771b;
                f.c(aVar);
                t = (T) aVar.a();
                this.f10772c = t;
                this.f10771b = null;
            }
        }
        return t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(a aVar, Object obj, int i2, d dVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
