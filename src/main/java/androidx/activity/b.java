package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f109a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f110b = new CopyOnWriteArrayList<>();

    public b(boolean z) {
        this.f109a = z;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f110b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f109a;
    }

    public final void d() {
        Iterator<a> it = this.f110b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f110b.remove(aVar);
    }

    public final void f(boolean z) {
        this.f109a = z;
    }
}
