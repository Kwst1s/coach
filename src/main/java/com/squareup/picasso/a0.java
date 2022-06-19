package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* access modifiers changed from: package-private */
/* compiled from: Stats */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    final HandlerThread f8645a;

    /* renamed from: b  reason: collision with root package name */
    final d f8646b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f8647c;

    /* renamed from: d  reason: collision with root package name */
    long f8648d;

    /* renamed from: e  reason: collision with root package name */
    long f8649e;

    /* renamed from: f  reason: collision with root package name */
    long f8650f;

    /* renamed from: g  reason: collision with root package name */
    long f8651g;

    /* renamed from: h  reason: collision with root package name */
    long f8652h;

    /* renamed from: i  reason: collision with root package name */
    long f8653i;

    /* renamed from: j  reason: collision with root package name */
    long f8654j;

    /* renamed from: k  reason: collision with root package name */
    long f8655k;
    int l;
    int m;
    int n;

    /* compiled from: Stats */
    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final a0 f8656a;

        /* renamed from: com.squareup.picasso.a0$a$a  reason: collision with other inner class name */
        /* compiled from: Stats */
        class RunnableC0175a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Message f8657b;

            RunnableC0175a(a aVar, Message message) {
                this.f8657b = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f8657b.what);
            }
        }

        a(Looper looper, a0 a0Var) {
            super(looper);
            this.f8656a = a0Var;
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f8656a.j();
            } else if (i2 == 1) {
                this.f8656a.k();
            } else if (i2 == 2) {
                this.f8656a.h((long) message.arg1);
            } else if (i2 == 3) {
                this.f8656a.i((long) message.arg1);
            } else if (i2 != 4) {
                t.p.post(new RunnableC0175a(this, message));
            } else {
                this.f8656a.l((Long) message.obj);
            }
        }
    }

    a0(d dVar) {
        this.f8646b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f8645a = handlerThread;
        handlerThread.start();
        d0.h(handlerThread.getLooper());
        this.f8647c = new a(handlerThread.getLooper(), this);
    }

    private static long g(int i2, long j2) {
        return j2 / ((long) i2);
    }

    private void m(Bitmap bitmap, int i2) {
        int i3 = d0.i(bitmap);
        Handler handler = this.f8647c;
        handler.sendMessage(handler.obtainMessage(i2, i3, 0));
    }

    /* access modifiers changed from: package-private */
    public b0 a() {
        return new b0(this.f8646b.a(), this.f8646b.size(), this.f8648d, this.f8649e, this.f8650f, this.f8651g, this.f8652h, this.f8653i, this.f8654j, this.f8655k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    /* access modifiers changed from: package-private */
    public void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f8647c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f8647c.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void f(long j2) {
        Handler handler = this.f8647c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j2)));
    }

    /* access modifiers changed from: package-private */
    public void h(long j2) {
        int i2 = this.m + 1;
        this.m = i2;
        long j3 = this.f8651g + j2;
        this.f8651g = j3;
        this.f8654j = g(i2, j3);
    }

    /* access modifiers changed from: package-private */
    public void i(long j2) {
        this.n++;
        long j3 = this.f8652h + j2;
        this.f8652h = j3;
        this.f8655k = g(this.m, j3);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f8648d++;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f8649e++;
    }

    /* access modifiers changed from: package-private */
    public void l(Long l2) {
        this.l++;
        long longValue = this.f8650f + l2.longValue();
        this.f8650f = longValue;
        this.f8653i = g(this.l, longValue);
    }
}
