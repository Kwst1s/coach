package c.b.a.a.m;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: StopWatch */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f3170a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3171b;

    /* renamed from: c  reason: collision with root package name */
    protected Handler f3172c;

    /* renamed from: d  reason: collision with root package name */
    protected HandlerThread f3173d;

    /* renamed from: e  reason: collision with root package name */
    protected a f3174e;

    /* renamed from: f  reason: collision with root package name */
    protected b f3175f;

    /* renamed from: g  reason: collision with root package name */
    protected long f3176g;

    /* renamed from: h  reason: collision with root package name */
    protected long f3177h;

    /* renamed from: i  reason: collision with root package name */
    protected long f3178i;

    /* renamed from: j  reason: collision with root package name */
    protected float f3179j;

    /* compiled from: StopWatch */
    public interface a {
        void a(long j2);
    }

    /* compiled from: StopWatch */
    protected class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        protected long f3180b = 0;

        /* renamed from: c  reason: collision with root package name */
        protected long f3181c = -1;

        protected b() {
        }

        public void a() {
            e eVar = e.this;
            eVar.f3172c.postDelayed(eVar.f3175f, (long) eVar.f3171b);
        }

        public void run() {
            if (this.f3181c == -1) {
                this.f3181c = e.this.f3176g;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f3180b = currentTimeMillis;
            e eVar = e.this;
            eVar.f3177h = (long) (((float) eVar.f3177h) + (((float) (currentTimeMillis - this.f3181c)) * eVar.f3179j));
            this.f3181c = currentTimeMillis;
            if (eVar.f3170a) {
                a();
            }
            e eVar2 = e.this;
            a aVar = eVar2.f3174e;
            if (aVar != null) {
                aVar.a(eVar2.f3177h + eVar2.f3178i);
            }
        }
    }

    public e() {
        this(true);
    }

    public long a() {
        return this.f3177h + this.f3178i;
    }

    public boolean b() {
        return this.f3170a;
    }

    public void c(float f2) {
        this.f3179j = f2;
    }

    public void d() {
        if (b()) {
            this.f3172c.removeCallbacksAndMessages(null);
            HandlerThread handlerThread = this.f3173d;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f3178i = this.f3177h + this.f3178i;
            this.f3170a = false;
            this.f3177h = 0;
        }
    }

    public e(boolean z) {
        this.f3170a = false;
        this.f3171b = 33;
        this.f3175f = new b();
        this.f3176g = 0;
        this.f3177h = 0;
        this.f3178i = 0;
        this.f3179j = 1.0f;
        if (z) {
            this.f3172c = new Handler();
        }
    }
}
