package com.bumptech.glide.r;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: Executors */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f4371a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f4372b = new b();

    /* compiled from: Executors */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f4373a = new Handler(Looper.getMainLooper());

        a() {
        }

        public void execute(Runnable runnable) {
            this.f4373a.post(runnable);
        }
    }

    /* compiled from: Executors */
    class b implements Executor {
        b() {
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f4372b;
    }

    public static Executor b() {
        return f4371a;
    }
}
