package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ZoomView */
public class j0 extends FrameLayout {
    private float A;
    private final Matrix B = new Matrix();
    private final Paint C = new Paint();
    a D;
    private Bitmap E;

    /* renamed from: b  reason: collision with root package name */
    float f10114b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    float f10115c = 2.0f;

    /* renamed from: d  reason: collision with root package name */
    float f10116d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    float f10117e;

    /* renamed from: f  reason: collision with root package name */
    float f10118f;

    /* renamed from: g  reason: collision with root package name */
    float f10119g;

    /* renamed from: h  reason: collision with root package name */
    float f10120h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10121i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10122j = false;

    /* renamed from: k  reason: collision with root package name */
    private int f10123k = -16777216;
    private int l = -1;
    private String m;
    private float n = 10.0f;
    private int o = -1;
    private long p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* compiled from: ZoomView */
    public interface a {
        void a(float f2, float f3, float f4);

        void b(float f2, float f3, float f4);
    }

    public j0(Context context) {
        super(context);
    }

    private float a(float f2, float f3, float f4) {
        float f5 = f3 - f2;
        return Math.abs(f5) >= f4 ? f2 + (f4 * Math.signum(f5)) : f3;
    }

    private float b(float f2, float f3, float f4) {
        return Math.max(f2, Math.min(f3, f4));
    }

    private float c(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void d(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0);
        float f2 = x2 - this.x;
        this.x = x2;
        float y2 = motionEvent.getY(0);
        float f3 = y2 - this.y;
        this.y = y2;
        float x3 = motionEvent.getX(1);
        float f4 = x3 - this.z;
        this.z = x3;
        float y3 = motionEvent.getY(1);
        float f5 = y3 - this.A;
        this.A = y3;
        double d2 = (double) (x3 - x2);
        double d3 = (double) (y3 - y2);
        float hypot = (float) Math.hypot(d2, d3);
        float f6 = hypot - this.w;
        this.w = hypot;
        float abs = Math.abs(hypot - this.u);
        Math.atan2(d3, d2);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = hypot;
            this.v = false;
        } else if (action != 2) {
            this.v = false;
        } else if (this.v || abs > 30.0f) {
            this.v = true;
            float max = Math.max(1.0f, (this.f10114b * hypot) / (hypot - f6));
            float f7 = this.f10117e;
            float f8 = this.f10114b;
            h(max, f7 - (((f2 + f4) * 0.5f) / f8), this.f10118f - (((f3 + f5) * 0.5f) / f8));
        }
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
    }

    private void e(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        boolean z2 = x2 >= 10.0f && x2 <= ((((float) this.l) * ((float) getWidth())) / ((float) getHeight())) + 10.0f && y2 >= 10.0f && y2 <= ((float) this.l) + 10.0f;
        if (!this.f10122j || this.f10116d <= 1.0f || !z2) {
            g(motionEvent);
        } else {
            f(motionEvent);
        }
    }

    private void f(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        h(this.f10116d, ((x2 - 10.0f) / ((((float) this.l) * ((float) getWidth())) / ((float) getHeight()))) * ((float) getWidth()), ((y2 - 10.0f) / ((float) this.l)) * ((float) getHeight()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r5 != 4) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(android.view.MotionEvent r12) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: gov.va.mobilehealth.ncptsd.covid.CComp.j0.g(android.view.MotionEvent):void");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        a aVar;
        this.f10114b = c(a(this.f10114b, this.f10116d, 0.05f), this.f10116d, 0.2f);
        this.f10119g = b((((float) getWidth()) * 0.5f) / this.f10116d, this.f10119g, ((float) getWidth()) - ((((float) getWidth()) * 0.5f) / this.f10116d));
        this.f10120h = b((((float) getHeight()) * 0.5f) / this.f10116d, this.f10120h, ((float) getHeight()) - ((((float) getHeight()) * 0.5f) / this.f10116d));
        this.f10117e = c(a(this.f10117e, this.f10119g, 0.1f), this.f10119g, 0.35f);
        float c2 = c(a(this.f10118f, this.f10120h, 0.1f), this.f10120h, 0.35f);
        this.f10118f = c2;
        float f2 = this.f10114b;
        if (!(f2 == this.f10116d || (aVar = this.D) == null)) {
            aVar.a(f2, this.f10117e, c2);
        }
        boolean z2 = Math.abs(this.f10114b - this.f10116d) > 1.0E-7f || Math.abs(this.f10117e - this.f10119g) > 1.0E-7f || Math.abs(this.f10118f - this.f10120h) > 1.0E-7f;
        if (getChildCount() != 0) {
            this.B.setTranslate(((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
            Matrix matrix = this.B;
            float f3 = this.f10114b;
            matrix.preScale(f3, f3);
            this.B.preTranslate(-b((((float) getWidth()) * 0.5f) / this.f10114b, this.f10117e, ((float) getWidth()) - ((((float) getWidth()) * 0.5f) / this.f10114b)), -b((((float) getHeight()) * 0.5f) / this.f10114b, this.f10118f, ((float) getHeight()) - ((((float) getHeight()) * 0.5f) / this.f10114b)));
            View childAt = getChildAt(0);
            this.B.preTranslate((float) childAt.getLeft(), (float) childAt.getTop());
            if (z2 && this.E == null && isAnimationCacheEnabled()) {
                childAt.setDrawingCacheEnabled(true);
                this.E = childAt.getDrawingCache();
            }
            if (!z2 || !isAnimationCacheEnabled() || this.E == null) {
                this.E = null;
                canvas.save();
                canvas.concat(this.B);
                childAt.draw(canvas);
                canvas.restore();
            } else {
                this.C.setColor(-1);
                canvas.drawBitmap(this.E, this.B, this.C);
            }
            if (this.f10122j) {
                if (this.l < 0) {
                    this.l = getHeight() / 4;
                }
                canvas.translate(10.0f, 10.0f);
                this.C.setColor((this.f10123k & 16777215) | Integer.MIN_VALUE);
                float width = (((float) this.l) * ((float) getWidth())) / ((float) getHeight());
                float f4 = (float) this.l;
                canvas.drawRect(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, width, f4, this.C);
                String str = this.m;
                if (str != null && str.length() > 0) {
                    this.C.setTextSize(this.n);
                    this.C.setColor(this.o);
                    this.C.setAntiAlias(true);
                    canvas.drawText(this.m, 10.0f, this.n + 10.0f, this.C);
                    this.C.setAntiAlias(false);
                }
                this.C.setColor((this.f10123k & 16777215) | Integer.MIN_VALUE);
                float width2 = (this.f10117e * width) / ((float) getWidth());
                float height = (this.f10118f * f4) / ((float) getHeight());
                float f5 = width * 0.5f;
                float f6 = this.f10114b;
                float f7 = f4 * 0.5f;
                canvas.drawRect(width2 - (f5 / f6), height - (f7 / f6), width2 + (f5 / f6), height + (f7 / f6), this.C);
                canvas.translate(-10.0f, -10.0f);
            }
            getRootView().invalidate();
            invalidate();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            e(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            d(motionEvent);
        }
        getRootView().invalidate();
        invalidate();
        return true;
    }

    public a getListener() {
        return this.D;
    }

    public float getMaxZoom() {
        return this.f10115c;
    }

    public String getMiniMapCaption() {
        return this.m;
    }

    public int getMiniMapCaptionColor() {
        return this.o;
    }

    public float getMiniMapCaptionSize() {
        return this.n;
    }

    public int getMiniMapColor() {
        return this.f10123k;
    }

    public int getMiniMapHeight() {
        return this.l;
    }

    public float getZoom() {
        return this.f10114b;
    }

    public float getZoomFocusX() {
        return this.f10117e * this.f10114b;
    }

    public float getZoomFocusY() {
        return this.f10118f * this.f10114b;
    }

    public void h(float f2, float f3, float f4) {
        float b2 = b(1.0f, f2, this.f10115c);
        this.f10116d = b2;
        this.f10119g = f3;
        this.f10120h = f4;
        a aVar = this.D;
        if (aVar != null) {
            aVar.b(b2, f3, f4);
        }
    }

    public void setListner(a aVar) {
        this.D = aVar;
    }

    public void setMaxZoom(float f2) {
        if (f2 >= 1.0f) {
            this.f10115c = f2;
        }
    }

    public void setMiniMapCaption(String str) {
        this.m = str;
    }

    public void setMiniMapCaptionColor(int i2) {
        this.o = i2;
    }

    public void setMiniMapCaptionSize(float f2) {
        this.n = f2;
    }

    public void setMiniMapColor(int i2) {
        this.f10123k = i2;
    }

    public void setMiniMapEnabled(boolean z2) {
        this.f10122j = z2;
    }

    public void setMiniMapHeight(int i2) {
        if (i2 >= 0) {
            this.l = i2;
        }
    }
}
