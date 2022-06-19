package b.h.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2524a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f2525b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f2526c;

    /* renamed from: d  reason: collision with root package name */
    private int f2527d;

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f2528e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final int f2529f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2530g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2531h;

    /* compiled from: SelfDestructiveThread */
    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c.this.a();
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                c.this.b((Runnable) message.obj);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SelfDestructiveThread */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f2533b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Handler f2534c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f2535d;

        /* compiled from: SelfDestructiveThread */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f2536b;

            a(Object obj) {
                this.f2536b = obj;
            }

            public void run() {
                b.this.f2535d.a(this.f2536b);
            }
        }

        b(c cVar, Callable callable, Handler handler, d dVar) {
            this.f2533b = callable;
            this.f2534c = handler;
            this.f2535d = dVar;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f2533b.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f2534c.post(new a(obj));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b.h.h.c$c  reason: collision with other inner class name */
    /* compiled from: SelfDestructiveThread */
    public class RunnableC0042c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f2538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callable f2539c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReentrantLock f2540d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f2541e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Condition f2542f;

        RunnableC0042c(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f2538b = atomicReference;
            this.f2539c = callable;
            this.f2540d = reentrantLock;
            this.f2541e = atomicBoolean;
            this.f2542f = condition;
        }

        public void run() {
            try {
                this.f2538b.set(this.f2539c.call());
            } catch (Exception unused) {
            }
            this.f2540d.lock();
            try {
                this.f2541e.set(false);
                this.f2542f.signal();
            } finally {
                this.f2540d.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread */
    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i2, int i3) {
        this.f2531h = str;
        this.f2530g = i2;
        this.f2529f = i3;
        this.f2527d = 0;
    }

    private void c(Runnable runnable) {
        synchronized (this.f2524a) {
            if (this.f2525b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f2531h, this.f2530g);
                this.f2525b = handlerThread;
                handlerThread.start();
                this.f2526c = new Handler(this.f2525b.getLooper(), this.f2528e);
                this.f2527d++;
            }
            this.f2526c.removeMessages(0);
            Handler handler = this.f2526c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f2524a) {
            if (!this.f2526c.hasMessages(1)) {
                this.f2525b.quit();
                this.f2525b = null;
                this.f2526c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f2524a) {
            this.f2526c.removeMessages(0);
            Handler handler = this.f2526c;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.f2529f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(this, callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new RunnableC0042c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i2);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
