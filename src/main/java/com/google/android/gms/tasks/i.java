package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class i<TResult> extends b<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7468a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final g<TResult> f7469b = new g<>();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private boolean f7470c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f7471d;
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    private TResult f7472e;
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    private Exception f7473f;

    i() {
    }

    @GuardedBy("mLock")
    private final void j() {
        n.i(this.f7470c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void m() {
        if (this.f7470c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    @GuardedBy("mLock")
    private final void n() {
        if (this.f7471d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void o() {
        synchronized (this.f7468a) {
            if (this.f7470c) {
                this.f7469b.a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> a(a<TResult> aVar) {
        b(d.f7458a, aVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> b(Executor executor, a<TResult> aVar) {
        g<TResult> gVar = this.f7469b;
        j.a(executor);
        gVar.b(new e(executor, aVar));
        o();
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final Exception c() {
        Exception exc;
        synchronized (this.f7468a) {
            exc = this.f7473f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.b
    public final TResult d() {
        TResult tresult;
        synchronized (this.f7468a) {
            j();
            n();
            if (this.f7473f == null) {
                tresult = this.f7472e;
            } else {
                throw new RuntimeExecutionException(this.f7473f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean e() {
        return this.f7471d;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean f() {
        boolean z;
        synchronized (this.f7468a) {
            z = this.f7470c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean g() {
        boolean z;
        synchronized (this.f7468a) {
            z = this.f7470c && !this.f7471d && this.f7473f == null;
        }
        return z;
    }

    public final void h(Exception exc) {
        n.g(exc, "Exception must not be null");
        synchronized (this.f7468a) {
            m();
            this.f7470c = true;
            this.f7473f = exc;
        }
        this.f7469b.a(this);
    }

    public final void i(TResult tresult) {
        synchronized (this.f7468a) {
            m();
            this.f7470c = true;
            this.f7472e = tresult;
        }
        this.f7469b.a(this);
    }

    public final boolean k(Exception exc) {
        n.g(exc, "Exception must not be null");
        synchronized (this.f7468a) {
            if (this.f7470c) {
                return false;
            }
            this.f7470c = true;
            this.f7473f = exc;
            this.f7469b.a(this);
            return true;
        }
    }

    public final boolean l(TResult tresult) {
        synchronized (this.f7468a) {
            if (this.f7470c) {
                return false;
            }
            this.f7470c = true;
            this.f7472e = tresult;
            this.f7469b.a(this);
            return true;
        }
    }
}
