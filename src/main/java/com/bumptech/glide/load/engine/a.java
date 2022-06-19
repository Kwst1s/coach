package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.f;
import com.bumptech.glide.r.j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
/* compiled from: ActiveResources */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3655a;

    /* renamed from: b  reason: collision with root package name */
    final Map<f, d> f3656b;

    /* renamed from: c  reason: collision with root package name */
    private final ReferenceQueue<p<?>> f3657c;

    /* renamed from: d  reason: collision with root package name */
    private p.a f3658d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f3659e;

    /* renamed from: f  reason: collision with root package name */
    private volatile c f3660f;

    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    /* compiled from: ActiveResources */
    class ThreadFactoryC0088a implements ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        /* compiled from: ActiveResources */
        class RunnableC0089a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Runnable f3661b;

            RunnableC0089a(ThreadFactoryC0088a aVar, Runnable runnable) {
                this.f3661b = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f3661b.run();
            }
        }

        ThreadFactoryC0088a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0089a(this, runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources */
    class b implements Runnable {
        b() {
        }

        public void run() {
            a.this.b();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ActiveResources */
    public interface c {
        void a();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ActiveResources */
    public static final class d extends WeakReference<p<?>> {

        /* renamed from: a  reason: collision with root package name */
        final f f3663a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3664b;

        /* renamed from: c  reason: collision with root package name */
        u<?> f3665c;

        d(f fVar, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            u<?> uVar;
            j.d(fVar);
            this.f3663a = fVar;
            if (!pVar.f() || !z) {
                uVar = null;
            } else {
                u<?> d2 = pVar.d();
                j.d(d2);
                uVar = d2;
            }
            this.f3665c = uVar;
            this.f3664b = pVar.f();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3665c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0088a()));
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(f fVar, p<?> pVar) {
        d put = this.f3656b.put(fVar, new d(fVar, pVar, this.f3657c, this.f3655a));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        while (!this.f3659e) {
            try {
                c((d) this.f3657c.remove());
                c cVar = this.f3660f;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(d dVar) {
        synchronized (this) {
            this.f3656b.remove(dVar.f3663a);
            if (dVar.f3664b) {
                u<?> uVar = dVar.f3665c;
                if (uVar != null) {
                    this.f3658d.d(dVar.f3663a, new p<>(uVar, true, false, dVar.f3663a, this.f3658d));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(f fVar) {
        d remove = this.f3656b.remove(fVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized p<?> e(f fVar) {
        d dVar = this.f3656b.get(fVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = (p) dVar.get();
        if (pVar == null) {
            c(dVar);
        }
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f3658d = aVar;
            }
        }
    }

    a(boolean z, Executor executor) {
        this.f3656b = new HashMap();
        this.f3657c = new ReferenceQueue<>();
        this.f3655a = z;
        executor.execute(new b());
    }
}
