package com.google.android.exoplayer2.h0;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;

@TargetApi(17)
/* compiled from: DummySurface */
public final class j extends Surface {

    /* renamed from: d  reason: collision with root package name */
    private static int f5887d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f5888e;

    /* renamed from: b  reason: collision with root package name */
    private final b f5889b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5890c;

    /* access modifiers changed from: private */
    /* compiled from: DummySurface */
    public static class b extends HandlerThread implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private EGLSurfaceTexture f5891b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f5892c;

        /* renamed from: d  reason: collision with root package name */
        private Error f5893d;

        /* renamed from: e  reason: collision with root package name */
        private RuntimeException f5894e;

        /* renamed from: f  reason: collision with root package name */
        private j f5895f;

        public b() {
            super("dummySurface");
        }

        private void b(int i2) {
            e.e(this.f5891b);
            this.f5891b.h(i2);
            this.f5895f = new j(this, this.f5891b.g(), i2 != 0);
        }

        private void d() {
            e.e(this.f5891b);
            this.f5891b.i();
        }

        public j a(int i2) {
            boolean z;
            start();
            this.f5892c = new Handler(getLooper(), this);
            this.f5891b = new EGLSurfaceTexture(this.f5892c);
            synchronized (this) {
                z = false;
                this.f5892c.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f5895f == null && this.f5894e == null && this.f5893d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f5894e;
            if (runtimeException == null) {
                Error error = this.f5893d;
                if (error == null) {
                    j jVar = this.f5895f;
                    e.e(jVar);
                    return jVar;
                }
                throw error;
            }
            throw runtimeException;
        }

        public void c() {
            e.e(this.f5892c);
            this.f5892c.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    m.d("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f5894e = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    try {
                        m.d("DummySurface", "Failed to initialize dummy surface", e3);
                        this.f5893d = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i2 != 2) {
                return true;
            } else {
                try {
                    d();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }
    }

    private static void g() {
        if (d0.f7006a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static int k(Context context) {
        String eglQueryString;
        int i2 = d0.f7006a;
        if (i2 < 26 && ("samsung".equals(d0.f7008c) || "XT1650".equals(d0.f7009d))) {
            return 0;
        }
        if ((i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")) {
            return eglQueryString.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean l(Context context) {
        boolean z;
        synchronized (j.class) {
            z = true;
            if (!f5888e) {
                f5887d = d0.f7006a < 24 ? 0 : k(context);
                f5888e = true;
            }
            if (f5887d == 0) {
                z = false;
            }
        }
        return z;
    }

    public static j m(Context context, boolean z) {
        g();
        int i2 = 0;
        e.f(!z || l(context));
        b bVar = new b();
        if (z) {
            i2 = f5887d;
        }
        return bVar.a(i2);
    }

    public void release() {
        super.release();
        synchronized (this.f5889b) {
            if (!this.f5890c) {
                this.f5889b.c();
                this.f5890c = true;
            }
        }
    }

    private j(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f5889b = bVar;
    }
}
