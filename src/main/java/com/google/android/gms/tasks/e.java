package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class e<TResult> implements h<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7460a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f7461b = new Object();
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private a<TResult> f7462c;

    public e(Executor executor, a<TResult> aVar) {
        this.f7460a = executor;
        this.f7462c = aVar;
    }

    @Override // com.google.android.gms.tasks.h
    public final void a(b<TResult> bVar) {
        synchronized (this.f7461b) {
            if (this.f7462c != null) {
                this.f7460a.execute(new f(this, bVar));
            }
        }
    }
}
