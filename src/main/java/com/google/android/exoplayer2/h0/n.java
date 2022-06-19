package com.google.android.exoplayer2.h0;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.d0;

@TargetApi(16)
/* compiled from: VideoFrameReleaseTimeHelper */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f5902a;

    /* renamed from: b  reason: collision with root package name */
    private final b f5903b;

    /* renamed from: c  reason: collision with root package name */
    private final a f5904c;

    /* renamed from: d  reason: collision with root package name */
    private long f5905d;

    /* renamed from: e  reason: collision with root package name */
    private long f5906e;

    /* renamed from: f  reason: collision with root package name */
    private long f5907f;

    /* renamed from: g  reason: collision with root package name */
    private long f5908g;

    /* renamed from: h  reason: collision with root package name */
    private long f5909h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5910i;

    /* renamed from: j  reason: collision with root package name */
    private long f5911j;

    /* renamed from: k  reason: collision with root package name */
    private long f5912k;
    private long l;

    /* access modifiers changed from: private */
    @TargetApi(17)
    /* compiled from: VideoFrameReleaseTimeHelper */
    public final class a implements DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayManager f5913a;

        public a(DisplayManager displayManager) {
            this.f5913a = displayManager;
        }

        public void a() {
            this.f5913a.registerDisplayListener(this, null);
        }

        public void b() {
            this.f5913a.unregisterDisplayListener(this);
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            if (i2 == 0) {
                n.this.h();
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: VideoFrameReleaseTimeHelper */
    public static final class b implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: g  reason: collision with root package name */
        private static final b f5915g = new b();

        /* renamed from: b  reason: collision with root package name */
        public volatile long f5916b = -9223372036854775807L;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f5917c;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f5918d;

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f5919e;

        /* renamed from: f  reason: collision with root package name */
        private int f5920f;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f5918d = handlerThread;
            handlerThread.start();
            Handler r = d0.r(handlerThread.getLooper(), this);
            this.f5917c = r;
            r.sendEmptyMessage(0);
        }

        private void b() {
            int i2 = this.f5920f + 1;
            this.f5920f = i2;
            if (i2 == 1) {
                this.f5919e.postFrameCallback(this);
            }
        }

        private void c() {
            this.f5919e = Choreographer.getInstance();
        }

        public static b d() {
            return f5915g;
        }

        private void f() {
            int i2 = this.f5920f - 1;
            this.f5920f = i2;
            if (i2 == 0) {
                this.f5919e.removeFrameCallback(this);
                this.f5916b = -9223372036854775807L;
            }
        }

        public void a() {
            this.f5917c.sendEmptyMessage(1);
        }

        public void doFrame(long j2) {
            this.f5916b = j2;
            this.f5919e.postFrameCallbackDelayed(this, 500);
        }

        public void e() {
            this.f5917c.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c();
                return true;
            } else if (i2 == 1) {
                b();
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public n(Context context) {
        a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f5902a = (WindowManager) context.getSystemService("window");
        } else {
            this.f5902a = null;
        }
        if (this.f5902a != null) {
            this.f5904c = d0.f7006a >= 17 ? g(context) : aVar;
            this.f5903b = b.d();
        } else {
            this.f5904c = null;
            this.f5903b = null;
        }
        this.f5905d = -9223372036854775807L;
        this.f5906e = -9223372036854775807L;
    }

    private static long c(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            j6 = j4 + j6;
            j5 = j6;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    private boolean f(long j2, long j3) {
        return Math.abs((j3 - this.f5911j) - (j2 - this.f5912k)) > 20000000;
    }

    @TargetApi(17)
    private a g(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        Display defaultDisplay = this.f5902a.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = (double) defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            long j2 = (long) (1.0E9d / refreshRate);
            this.f5905d = j2;
            this.f5906e = (j2 * 80) / 100;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r11, long r13) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h0.n.b(long, long):long");
    }

    public void d() {
        if (this.f5902a != null) {
            a aVar = this.f5904c;
            if (aVar != null) {
                aVar.b();
            }
            this.f5903b.e();
        }
    }

    public void e() {
        this.f5910i = false;
        if (this.f5902a != null) {
            this.f5903b.a();
            a aVar = this.f5904c;
            if (aVar != null) {
                aVar.a();
            }
            h();
        }
    }
}
