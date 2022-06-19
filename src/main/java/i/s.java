package i;

import i.d0;
import i.k0.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: Dispatcher */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private int f10618a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f10619b = 5;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Runnable f10620c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f10621d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<d0.a> f10622e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<d0.a> f10623f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<d0> f10624g = new ArrayDeque();

    private <T> void c(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f10620c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!f() && runnable != null) {
            runnable.run();
        }
    }

    private boolean f() {
        int i2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<d0.a> it = this.f10622e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d0.a next = it.next();
                if (this.f10623f.size() >= this.f10618a) {
                    break;
                } else if (next.l().get() < this.f10619b) {
                    it.remove();
                    next.l().incrementAndGet();
                    arrayList.add(next);
                    this.f10623f.add(next);
                }
            }
            z = g() > 0;
        }
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((d0.a) arrayList.get(i2)).m(b());
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(d0 d0Var) {
        this.f10624g.add(d0Var);
    }

    public synchronized ExecutorService b() {
        if (this.f10621d == null) {
            this.f10621d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.F("OkHttp Dispatcher", false));
        }
        return this.f10621d;
    }

    /* access modifiers changed from: package-private */
    public void d(d0.a aVar) {
        aVar.l().decrementAndGet();
        c(this.f10623f, aVar);
    }

    /* access modifiers changed from: package-private */
    public void e(d0 d0Var) {
        c(this.f10624g, d0Var);
    }

    public synchronized int g() {
        return this.f10623f.size() + this.f10624g.size();
    }
}
