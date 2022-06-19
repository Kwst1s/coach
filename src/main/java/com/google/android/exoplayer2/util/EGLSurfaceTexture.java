package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

@TargetApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f6990i = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6991b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f6992c;

    /* renamed from: d  reason: collision with root package name */
    private final b f6993d;

    /* renamed from: e  reason: collision with root package name */
    private EGLDisplay f6994e;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f6995f;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f6996g;

    /* renamed from: h  reason: collision with root package name */
    private SurfaceTexture f6997h;

    public static final class GlException extends RuntimeException {
        private GlException(String str) {
            super(str);
        }
    }

    public interface b {
        void a();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f6990i, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (eglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null) {
            return eGLConfigArr[0];
        }
        throw new GlException(d0.s("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new GlException("eglCreateContext failed");
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) {
        EGLSurface eGLSurface;
        int[] iArr;
        if (i2 == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            if (i2 == 2) {
                iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr = new int[]{12375, 1, 12374, 1, 12344};
            }
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr, 0);
            if (eGLSurface == null) {
                throw new GlException("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
            return eGLSurface;
        }
        throw new GlException("eglMakeCurrent failed");
    }

    private void d() {
        b bVar = this.f6993d;
        if (bVar != null) {
            bVar.a();
        }
    }

    private static void e(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new GlException("glGenTextures failed. Error: " + Integer.toHexString(glGetError));
        }
    }

    private static EGLDisplay f() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                return eglGetDisplay;
            }
            throw new GlException("eglInitialize failed");
        }
        throw new GlException("eglGetDisplay failed");
    }

    public SurfaceTexture g() {
        SurfaceTexture surfaceTexture = this.f6997h;
        e.e(surfaceTexture);
        return surfaceTexture;
    }

    public void h(int i2) {
        EGLDisplay f2 = f();
        this.f6994e = f2;
        EGLConfig a2 = a(f2);
        EGLContext b2 = b(this.f6994e, a2, i2);
        this.f6995f = b2;
        this.f6996g = c(this.f6994e, a2, b2, i2);
        e(this.f6992c);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f6992c[0]);
        this.f6997h = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public void i() {
        this.f6991b.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f6997h;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f6992c, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f6994e;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f6994e;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f6996g;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f6994e, this.f6996g);
            }
            EGLContext eGLContext = this.f6995f;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f6994e, eGLContext);
            }
            if (d0.f7006a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f6994e;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f6994e);
            }
            this.f6994e = null;
            this.f6995f = null;
            this.f6996g = null;
            this.f6997h = null;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f6991b.post(this);
    }

    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f6997h;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, b bVar) {
        this.f6991b = handler;
        this.f6993d = bVar;
        this.f6992c = new int[1];
    }
}
