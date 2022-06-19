package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements u {

    /* renamed from: d  reason: collision with root package name */
    public static final c f6878d = g(false, -9223372036854775807L);

    /* renamed from: e  reason: collision with root package name */
    public static final c f6879e = new c(2, -9223372036854775807L);

    /* renamed from: f  reason: collision with root package name */
    public static final c f6880f = new c(3, -9223372036854775807L);

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f6881a;

    /* renamed from: b  reason: collision with root package name */
    private d<? extends e> f6882b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f6883c;

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public interface b<T extends e> {
        void k(T t, long j2, long j3, boolean z);

        c p(T t, long j2, long j3, IOException iOException, int i2);

        void q(T t, long j2, long j3);
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f6884a;

        /* renamed from: b  reason: collision with root package name */
        private final long f6885b;

        public boolean c() {
            int i2 = this.f6884a;
            return i2 == 0 || i2 == 1;
        }

        private c(int i2, long j2) {
            this.f6884a = i2;
            this.f6885b = j2;
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public final class d<T extends e> extends Handler implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final int f6886b;

        /* renamed from: c  reason: collision with root package name */
        private final T f6887c;

        /* renamed from: d  reason: collision with root package name */
        private final long f6888d;

        /* renamed from: e  reason: collision with root package name */
        private b<T> f6889e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f6890f;

        /* renamed from: g  reason: collision with root package name */
        private int f6891g;

        /* renamed from: h  reason: collision with root package name */
        private volatile Thread f6892h;

        /* renamed from: i  reason: collision with root package name */
        private volatile boolean f6893i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f6894j;

        public d(Looper looper, T t, b<T> bVar, int i2, long j2) {
            super(looper);
            this.f6887c = t;
            this.f6889e = bVar;
            this.f6886b = i2;
            this.f6888d = j2;
        }

        private void b() {
            this.f6890f = null;
            Loader.this.f6881a.execute(Loader.this.f6882b);
        }

        private void c() {
            Loader.this.f6882b = null;
        }

        private long d() {
            return (long) Math.min((this.f6891g - 1) * 1000, 5000);
        }

        public void a(boolean z) {
            this.f6894j = z;
            this.f6890f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f6893i = true;
                this.f6887c.b();
                if (this.f6892h != null) {
                    this.f6892h.interrupt();
                }
            }
            if (z) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f6889e.k(this.f6887c, elapsedRealtime, elapsedRealtime - this.f6888d, true);
                this.f6889e = null;
            }
        }

        public void e(int i2) {
            IOException iOException = this.f6890f;
            if (iOException != null && this.f6891g > i2) {
                throw iOException;
            }
        }

        public void f(long j2) {
            com.google.android.exoplayer2.util.e.f(Loader.this.f6882b == null);
            Loader.this.f6882b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                b();
            }
        }

        public void handleMessage(Message message) {
            long j2;
            if (!this.f6894j) {
                int i2 = message.what;
                if (i2 == 0) {
                    b();
                } else if (i2 != 4) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = elapsedRealtime - this.f6888d;
                    if (this.f6893i) {
                        this.f6889e.k(this.f6887c, elapsedRealtime, j3, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 1) {
                        this.f6889e.k(this.f6887c, elapsedRealtime, j3, false);
                    } else if (i3 == 2) {
                        try {
                            this.f6889e.q(this.f6887c, elapsedRealtime, j3);
                        } catch (RuntimeException e2) {
                            m.d("LoadTask", "Unexpected exception handling load completed", e2);
                            Loader.this.f6883c = new UnexpectedLoaderException(e2);
                        }
                    } else if (i3 == 3) {
                        IOException iOException = (IOException) message.obj;
                        this.f6890f = iOException;
                        int i4 = this.f6891g + 1;
                        this.f6891g = i4;
                        c p = this.f6889e.p(this.f6887c, elapsedRealtime, j3, iOException, i4);
                        if (p.f6884a == 3) {
                            Loader.this.f6883c = this.f6890f;
                        } else if (p.f6884a != 2) {
                            if (p.f6884a == 1) {
                                this.f6891g = 1;
                            }
                            if (p.f6885b != -9223372036854775807L) {
                                j2 = p.f6885b;
                            } else {
                                j2 = d();
                            }
                            f(j2);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        public void run() {
            try {
                this.f6892h = Thread.currentThread();
                if (!this.f6893i) {
                    b0.a("load:" + this.f6887c.getClass().getSimpleName());
                    try {
                        this.f6887c.a();
                    } finally {
                        b0.c();
                    }
                }
                if (!this.f6894j) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.f6894j) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.google.android.exoplayer2.util.e.f(this.f6893i);
                if (!this.f6894j) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                m.d("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.f6894j) {
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                m.d("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.f6894j) {
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                m.d("LoadTask", "Unexpected error loading stream", e5);
                if (!this.f6894j) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            }
        }
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
        void i();
    }

    /* access modifiers changed from: private */
    public static final class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final f f6896b;

        public g(f fVar) {
            this.f6896b = fVar;
        }

        public void run() {
            this.f6896b.i();
        }
    }

    static {
        g(true, -9223372036854775807L);
    }

    public Loader(String str) {
        this.f6881a = d0.R(str);
    }

    public static c g(boolean z, long j2) {
        return new c(z ? 1 : 0, j2);
    }

    @Override // com.google.android.exoplayer2.upstream.u
    public void a() {
        i(Integer.MIN_VALUE);
    }

    public void f() {
        this.f6882b.a(false);
    }

    public boolean h() {
        return this.f6882b != null;
    }

    public void i(int i2) {
        IOException iOException = this.f6883c;
        if (iOException == null) {
            d<? extends e> dVar = this.f6882b;
            if (dVar != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = dVar.f6886b;
                }
                dVar.e(i2);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void j() {
        k(null);
    }

    public void k(f fVar) {
        d<? extends e> dVar = this.f6882b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f6881a.execute(new g(fVar));
        }
        this.f6881a.shutdown();
    }

    public <T extends e> long l(T t, b<T> bVar, int i2) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.e.f(myLooper != null);
        this.f6883c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new d(myLooper, t, bVar, i2, elapsedRealtime).f(0);
        return elapsedRealtime;
    }
}
