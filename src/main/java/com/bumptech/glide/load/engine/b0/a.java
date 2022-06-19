package com.bumptech.glide.load.engine.b0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: GlideExecutor */
public final class a implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final long f3699b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f3700c;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f3701a;

    /* renamed from: com.bumptech.glide.load.engine.b0.a$a  reason: collision with other inner class name */
    /* compiled from: GlideExecutor */
    public static final class C0091a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f3702a;

        /* renamed from: b  reason: collision with root package name */
        private int f3703b;

        /* renamed from: c  reason: collision with root package name */
        private int f3704c;

        /* renamed from: d  reason: collision with root package name */
        private c f3705d = c.f3714b;

        /* renamed from: e  reason: collision with root package name */
        private String f3706e;

        /* renamed from: f  reason: collision with root package name */
        private long f3707f;

        C0091a(boolean z) {
            this.f3702a = z;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f3706e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f3703b, this.f3704c, this.f3707f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f3706e, this.f3705d, this.f3702a));
                if (this.f3707f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f3706e);
        }

        public C0091a b(String str) {
            this.f3706e = str;
            return this;
        }

        public C0091a c(int i2) {
            this.f3703b = i2;
            this.f3704c = i2;
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: GlideExecutor */
    public static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f3708a;

        /* renamed from: b  reason: collision with root package name */
        final c f3709b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f3710c;

        /* renamed from: d  reason: collision with root package name */
        private int f3711d;

        /* renamed from: com.bumptech.glide.load.engine.b0.a$b$a  reason: collision with other inner class name */
        /* compiled from: GlideExecutor */
        class C0092a extends Thread {
            C0092a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f3710c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f3709b.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.f3708a = str;
            this.f3709b = cVar;
            this.f3710c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C0092a aVar;
            aVar = new C0092a(runnable, "glide-" + this.f3708a + "-thread-" + this.f3711d);
            this.f3711d = this.f3711d + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor */
    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f3713a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f3714b;

        /* renamed from: com.bumptech.glide.load.engine.b0.a$c$a  reason: collision with other inner class name */
        /* compiled from: GlideExecutor */
        class C0093a implements c {
            C0093a() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.c
            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0093a aVar = new C0093a();
            f3713a = aVar;
            f3714b = aVar;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f3701a = executorService;
    }

    public static int a() {
        if (f3700c == 0) {
            f3700c = Math.min(4, b.a());
        }
        return f3700c;
    }

    public static C0091a b() {
        int i2 = a() >= 4 ? 2 : 1;
        C0091a aVar = new C0091a(true);
        aVar.c(i2);
        aVar.b("animation");
        return aVar;
    }

    public static a c() {
        return b().a();
    }

    public static C0091a d() {
        C0091a aVar = new C0091a(true);
        aVar.c(1);
        aVar.b("disk-cache");
        return aVar;
    }

    public static a e() {
        return d().a();
    }

    public static C0091a f() {
        C0091a aVar = new C0091a(false);
        aVar.c(a());
        aVar.b("source");
        return aVar;
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f3699b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f3714b, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) {
        return this.f3701a.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f3701a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f3701a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f3701a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f3701a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3701a.isTerminated();
    }

    public void shutdown() {
        this.f3701a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f3701a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f3701a.submit(runnable);
    }

    public String toString() {
        return this.f3701a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        return this.f3701a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        return (T) this.f3701a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f3701a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f3701a.submit(callable);
    }
}
