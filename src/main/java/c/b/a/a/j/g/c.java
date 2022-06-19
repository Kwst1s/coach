package c.b.a.a.j.g;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: ResizingTextureView */
public class c extends TextureView implements a {
    private static final int[] l = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};
    private static final int[] m = {12440, 2, 12344};

    /* renamed from: b  reason: collision with root package name */
    protected d f3126b;

    /* renamed from: c  reason: collision with root package name */
    protected Point f3127c = new Point(0, 0);

    /* renamed from: d  reason: collision with root package name */
    protected Point f3128d = new Point(0, 0);

    /* renamed from: e  reason: collision with root package name */
    protected c.b.a.a.j.g.d.a f3129e = new c.b.a.a.j.g.d.a();

    /* renamed from: f  reason: collision with root package name */
    protected b f3130f = new b();

    /* renamed from: g  reason: collision with root package name */
    protected ViewTreeObserver$OnGlobalLayoutListenerC0070c f3131g = new ViewTreeObserver$OnGlobalLayoutListenerC0070c();

    /* renamed from: h  reason: collision with root package name */
    protected final ReentrantLock f3132h = new ReentrantLock(true);

    /* renamed from: i  reason: collision with root package name */
    protected int f3133i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected int f3134j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f3135k;

    /* access modifiers changed from: private */
    /* compiled from: ResizingTextureView */
    public class b implements View.OnAttachStateChangeListener {
        private b() {
        }

        public void onViewAttachedToWindow(View view) {
            c.this.f3132h.lock();
            c.this.getViewTreeObserver().addOnGlobalLayoutListener(c.this.f3131g);
            c.this.removeOnAttachStateChangeListener(this);
            c.this.f3132h.unlock();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c.b.a.a.j.g.c$c  reason: collision with other inner class name */
    /* compiled from: ResizingTextureView */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0070c implements ViewTreeObserver.OnGlobalLayoutListener {
        private ViewTreeObserver$OnGlobalLayoutListenerC0070c() {
        }

        public void onGlobalLayout() {
            c cVar = c.this;
            cVar.setScaleType(cVar.f3129e.g());
            if (Build.VERSION.SDK_INT >= 16) {
                c.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                c.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: ResizingTextureView */
    public interface d {
        void a(int i2, int i3);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void f(int i2, boolean z) {
        int i3 = z ? i2 : this.f3133i;
        if (z) {
            i2 = this.f3134j;
        }
        k(i3, i2);
    }

    public c.b.a.a.j.g.d.b getScaleType() {
        return this.f3129e.g();
    }

    @Override // c.b.a.a.j.g.a
    public void i() {
        if (getSurfaceTexture() != null) {
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, null);
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eglGetDisplay, l, eGLConfigArr, 1, new int[1]);
                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, m);
                EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], getSurfaceTexture(), new int[]{12344});
                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                egl10.eglTerminate(eglGetDisplay);
            } catch (Exception e2) {
                Log.e("ResizingTextureView", "Error clearing surface", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j(int i2, int i3) {
        Point point = this.f3127c;
        if (point.x != i2 || point.y != i3) {
            point.x = i2;
            point.y = i3;
            l();
            d dVar = this.f3126b;
            if (dVar != null) {
                dVar.a(i2, i3);
            }
        }
    }

    public void k(int i2, int i3) {
        this.f3133i = i2;
        this.f3134j = i3;
        this.f3129e.i(this, (i2 + i3) % 360);
    }

    /* access modifiers changed from: protected */
    public void l() {
        this.f3132h.lock();
        if (getWindowToken() == null) {
            addOnAttachStateChangeListener(this.f3130f);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f3131g);
        }
        this.f3132h.unlock();
    }

    /* access modifiers changed from: protected */
    public boolean m(int i2, int i3) {
        this.f3129e.k(i2, i3);
        l();
        Point point = this.f3128d;
        point.x = i2;
        point.y = i3;
        if (i2 == 0 || i3 == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15) {
            return true;
        }
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture == null) {
            return false;
        }
        surfaceTexture.setDefaultBufferSize(i2, i3);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        l();
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (!this.f3135k) {
            super.onMeasure(i2, i3);
            j(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        int defaultSize = TextureView.getDefaultSize(this.f3128d.x, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.f3128d.y, i3);
        Point point = this.f3128d;
        if (point.x <= 0 || point.y <= 0) {
            setMeasuredDimension(defaultSize, defaultSize2);
            j(defaultSize, defaultSize2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824 && mode2 == 1073741824) {
            Point point2 = this.f3128d;
            int i5 = point2.x;
            int i6 = i5 * size2;
            int i7 = point2.y;
            if (i6 < size * i7) {
                size = (i5 * size2) / i7;
            } else if (i5 * size2 > size * i7) {
                size2 = (i7 * size) / i5;
            }
        } else if (mode == 1073741824) {
            Point point3 = this.f3128d;
            int i8 = (point3.y * size) / point3.x;
            if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                size2 = i8;
            }
        } else if (mode2 == 1073741824) {
            Point point4 = this.f3128d;
            int i9 = (point4.x * size2) / point4.y;
            if (mode != Integer.MIN_VALUE || i9 <= size) {
                size = i9;
            }
        } else {
            Point point5 = this.f3128d;
            int i10 = point5.x;
            int i11 = point5.y;
            if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                size2 = i11;
                i4 = i10;
            } else {
                i4 = (size2 * i10) / i11;
            }
            if (mode != Integer.MIN_VALUE || i4 <= size) {
                size = i4;
            } else {
                size2 = (i11 * size) / i10;
            }
        }
        setMeasuredDimension(size, size2);
        j(size, size2);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.f3135k = z;
        requestLayout();
    }

    public void setOnSizeChangeListener(d dVar) {
        this.f3126b = dVar;
    }

    public void setScaleType(c.b.a.a.j.g.d.b bVar) {
        this.f3129e.j(this, bVar);
    }
}
