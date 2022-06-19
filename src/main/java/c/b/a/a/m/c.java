package c.b.a.a.m;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Repeater */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f3162a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3163b;

    /* renamed from: c  reason: collision with root package name */
    protected Handler f3164c;

    /* renamed from: d  reason: collision with root package name */
    protected HandlerThread f3165d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f3166e;

    /* renamed from: f  reason: collision with root package name */
    protected b f3167f;

    /* renamed from: g  reason: collision with root package name */
    protected a f3168g;

    /* access modifiers changed from: protected */
    /* compiled from: Repeater */
    public class a implements Runnable {
        protected a() {
        }

        public void a() {
            c cVar = c.this;
            cVar.f3164c.postDelayed(cVar.f3168g, (long) cVar.f3163b);
        }

        public void run() {
            b bVar = c.this.f3167f;
            if (bVar != null) {
                bVar.a();
            }
            if (c.this.f3162a) {
                a();
            }
        }
    }

    /* compiled from: Repeater */
    public interface b {
        void a();
    }

    public c() {
        this(true);
    }

    public void a(b bVar) {
        this.f3167f = bVar;
    }

    public void b(int i2) {
        this.f3163b = i2;
    }

    public void c() {
        if (!this.f3162a) {
            this.f3162a = true;
            if (this.f3166e) {
                HandlerThread handlerThread = new HandlerThread("ExoMedia_Repeater_HandlerThread");
                this.f3165d = handlerThread;
                handlerThread.start();
                this.f3164c = new Handler(this.f3165d.getLooper());
            }
            this.f3168g.a();
        }
    }

    public void d() {
        HandlerThread handlerThread = this.f3165d;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f3162a = false;
    }

    public c(boolean z) {
        this.f3162a = false;
        this.f3163b = 33;
        this.f3166e = false;
        this.f3168g = new a();
        if (z) {
            this.f3164c = new Handler();
        } else {
            this.f3166e = true;
        }
    }
}
