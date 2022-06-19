package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f7458a = new a();

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    private static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7459a = new c.e.a.a.b.c.a(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f7459a.post(runnable);
        }
    }
}
