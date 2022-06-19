package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.text.DecimalFormat;

public class CircleProgressView extends View {
    a A = new a(this);
    private boolean A0;
    c B = c.IDLE;
    private int B0;
    d C;
    private float C0;
    private int D = 40;
    private float D0;
    private int E = 40;
    private float E0;
    private int F = 270;
    private boolean F0;
    private float G = 1.0f;
    private boolean G0;
    private float H = 1.0f;
    private int H0;
    private int I = 0;
    private b I0;
    private e J = e.NONE;
    private float J0;
    private int K = -1442840576;
    private DecimalFormat K0;
    private float L = 10.0f;
    private Typeface L0;
    private int M = 10;
    private Typeface M0;
    private int N = 10;
    private float O = 1.0f;
    private float P = 1.0f;
    private int Q = -1442840576;
    private int R = -1442840576;
    private int S = -16738680;
    private int T = 0;
    private int U = -1434201911;
    private int V = -16777216;
    private int W = -16777216;
    private boolean a0 = false;

    /* renamed from: b  reason: collision with root package name */
    protected int f1922b = 0;
    private int[] b0 = {-16738680};

    /* renamed from: c  reason: collision with root package name */
    protected int f1923c = 0;
    private Paint.Cap c0;

    /* renamed from: d  reason: collision with root package name */
    protected RectF f1924d = new RectF();
    private Paint.Cap d0;

    /* renamed from: e  reason: collision with root package name */
    protected RectF f1925e = new RectF();
    private Paint e0;

    /* renamed from: f  reason: collision with root package name */
    protected PointF f1926f;
    private Paint f0;

    /* renamed from: g  reason: collision with root package name */
    protected RectF f1927g = new RectF();
    private Paint g0;

    /* renamed from: h  reason: collision with root package name */
    protected RectF f1928h = new RectF();
    private Paint h0;

    /* renamed from: i  reason: collision with root package name */
    protected RectF f1929i = new RectF();
    private Paint i0;

    /* renamed from: j  reason: collision with root package name */
    protected RectF f1930j = new RectF();
    private Paint j0;

    /* renamed from: k  reason: collision with root package name */
    protected RectF f1931k = new RectF();
    private Paint k0;
    g l = g.CW;
    private Paint l0;
    float m = Utils.FLOAT_EPSILON;
    private Paint m0;
    float n = Utils.FLOAT_EPSILON;
    private Paint n0;
    float o = Utils.FLOAT_EPSILON;
    private String o0;
    float p = 100.0f;
    private int p0;
    float q = Utils.FLOAT_EPSILON;
    private String q0;
    float r = -1.0f;
    private k r0;
    float s = Utils.FLOAT_EPSILON;
    private j s0;
    float t = 42.0f;
    private boolean t0;
    float u = Utils.FLOAT_EPSILON;
    private boolean u0;
    float v = 2.8f;
    private Bitmap v0;
    boolean w = false;
    private Paint w0;
    double x = 900.0d;
    private float x0;
    int y = 10;
    private boolean y0;
    boolean z;
    private boolean z0;

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1932a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1933b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        static {
            /*
            // Method dump skipped, instructions count: 111
            */
            throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.a.<clinit>():void");
        }
    }

    public interface b {
        void a(float f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0414 A[SYNTHETIC, Splitter:B:62:0x0414] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0430 A[SYNTHETIC, Splitter:B:67:0x0430] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x044c A[SYNTHETIC, Splitter:B:72:0x044c] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CircleProgressView(android.content.Context r13, android.util.AttributeSet r14) {
        /*
        // Method dump skipped, instructions count: 1176
        */
        throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static double a(PointF pointF, PointF pointF2) {
        double degrees = Math.toDegrees(Math.atan2((double) (pointF2.y - pointF.y), (double) (pointF2.x - pointF.x)));
        return degrees < Utils.DOUBLE_EPSILON ? degrees + 360.0d : degrees;
    }

    private static RectF b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        float width = (float) (rect.left + rect.width());
        float height = ((float) rect.bottom) + (((float) rect.height()) * 0.93f);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + ((rectF.width() - width) / 2.0f);
        float height2 = rectF.top + ((rectF.height() - height) / 2.0f);
        rectF2.top = height2;
        rectF2.right = rectF2.left + width;
        rectF2.bottom = height2 + height;
        return rectF2;
    }

    private int c(double d2) {
        int[] iArr = this.b0;
        int i2 = 0;
        if (iArr.length > 1) {
            double maxValue = (double) (1.0f / getMaxValue());
            Double.isNaN(maxValue);
            double d3 = maxValue * d2;
            double length = (double) (this.b0.length - 1);
            Double.isNaN(length);
            int floor = (int) Math.floor(length * d3);
            int i3 = floor + 1;
            if (floor < 0) {
                i3 = 1;
            } else {
                int[] iArr2 = this.b0;
                if (i3 >= iArr2.length) {
                    floor = iArr2.length - 2;
                    i3 = iArr2.length - 1;
                }
                i2 = floor;
            }
            int[] iArr3 = this.b0;
            int i4 = iArr3[i2];
            int i5 = iArr3[i3];
            double length2 = (double) (iArr3.length - 1);
            Double.isNaN(length2);
            return f.a(i4, i5, (float) (1.0d - ((length2 * d3) % 1.0d)));
        } else if (iArr.length == 1) {
            return iArr[0];
        } else {
            return -16777216;
        }
    }

    private static float d(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        String replace = str.replace('1', '0');
        paint.getTextBounds(replace, 0, replace.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    private void e(Canvas canvas, RectF rectF, float f2, float f3, Paint paint) {
        float f4 = Utils.FLOAT_EPSILON;
        while (f4 < f3) {
            canvas.drawArc(rectF, f2 + f4, Math.min(this.E0, f3 - f4), false, paint);
            f4 += this.D0;
        }
    }

    private void f(Canvas canvas) {
        float f2;
        float f3;
        if (this.s < Utils.FLOAT_EPSILON) {
            this.s = 1.0f;
        }
        if (this.l == g.CW) {
            f3 = ((float) this.F) + this.u;
            f2 = this.s;
        } else {
            f3 = (float) this.F;
            f2 = this.u;
        }
        canvas.drawArc(this.f1924d, f3 - f2, this.s, false, this.g0);
    }

    private RectF g(RectF rectF) {
        float f2;
        double width = (double) (((rectF.width() - ((float) Math.max(this.D, this.E))) - this.G) - this.H);
        Double.isNaN(width);
        float width2 = (rectF.width() - ((float) ((width / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        float f3 = 1.0f;
        if (i()) {
            switch (a.f1932a[this.r0.ordinal()]) {
                case 1:
                case 2:
                    f3 = 1.1f;
                    f2 = 0.88f;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    f3 = 0.77f;
                    f2 = 1.33f;
                    break;
            }
            float f4 = f3 * width2;
            float f5 = width2 * f2;
            return new RectF(rectF.left + f4, rectF.top + f5, rectF.right - f4, rectF.bottom - f5);
        }
        f2 = 1.0f;
        float f42 = f3 * width2;
        float f52 = width2 * f2;
        return new RectF(rectF.left + f42, rectF.top + f52, rectF.right - f42, rectF.bottom - f52);
    }

    private float h(PointF pointF) {
        long round = Math.round(a(this.f1926f, pointF));
        return j(this.l == g.CW ? (float) (round - ((long) this.F)) : (float) (((long) this.F) - round));
    }

    private static float j(float f2) {
        return ((f2 % 360.0f) + 360.0f) % 360.0f;
    }

    private void n() {
        int[] iArr = this.b0;
        if (iArr.length > 1) {
            this.e0.setShader(new SweepGradient(this.f1924d.centerX(), this.f1924d.centerY(), this.b0, (float[]) null));
            Matrix matrix = new Matrix();
            this.e0.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.f1924d.centerX(), -this.f1924d.centerY());
            matrix.postRotate((float) this.F);
            matrix.postTranslate(this.f1924d.centerX(), this.f1924d.centerY());
            this.e0.getShader().setLocalMatrix(matrix);
            this.e0.setColor(this.b0[0]);
        } else if (iArr.length == 1) {
            this.e0.setColor(iArr[0]);
            this.e0.setShader(null);
        } else {
            this.e0.setColor(-16738680);
            this.e0.setShader(null);
        }
        this.e0.setAntiAlias(true);
        this.e0.setStrokeCap(this.c0);
        this.e0.setStyle(Paint.Style.STROKE);
        this.e0.setStrokeWidth((float) this.D);
        if (this.c0 != Paint.Cap.BUTT) {
            Paint paint = new Paint(this.e0);
            this.f0 = paint;
            paint.setShader(null);
            this.f0.setColor(this.b0[0]);
        }
    }

    private void q(float f2) {
        b bVar = this.I0;
        if (bVar != null && f2 != this.J0) {
            bVar.a(f2);
            this.J0 = f2;
        }
    }

    private void r() {
        this.p0 = -1;
        this.f1927g = g(this.f1924d);
        invalidate();
    }

    private void setSpin(boolean z2) {
        this.w = z2;
    }

    private void setTextSizeAndTextBoundsWithFixedTextSize(String str) {
        this.k0.setTextSize((float) this.N);
        this.f1928h = b(str, this.k0, this.f1924d);
    }

    public int[] getBarColors() {
        return this.b0;
    }

    public e getBarStartEndLine() {
        return this.J;
    }

    public Paint.Cap getBarStrokeCap() {
        return this.c0;
    }

    public int getBarWidth() {
        return this.D;
    }

    public int getBlockCount() {
        return this.B0;
    }

    public float getBlockScale() {
        return this.C0;
    }

    public float getCurrentValue() {
        return this.m;
    }

    public DecimalFormat getDecimalFormat() {
        return this.K0;
    }

    public int getDelayMillis() {
        return this.y;
    }

    public int getFillColor() {
        return this.i0.getColor();
    }

    public int getInnerContourColor() {
        return this.R;
    }

    public float getInnerContourSize() {
        return this.H;
    }

    public float getMaxValue() {
        return this.p;
    }

    public float getMaxValueAllowed() {
        return this.r;
    }

    public float getMinValueAllowed() {
        return this.q;
    }

    public int getOuterContourColor() {
        return this.Q;
    }

    public float getOuterContourSize() {
        return this.G;
    }

    public float getRelativeUniteSize() {
        return this.x0;
    }

    public int getRimColor() {
        return this.U;
    }

    public Shader getRimShader() {
        return this.j0.getShader();
    }

    public int getRimWidth() {
        return this.E;
    }

    public boolean getRoundToBlock() {
        return this.F0;
    }

    public boolean getRoundToWholeNumber() {
        return this.G0;
    }

    public float getSpinSpeed() {
        return this.v;
    }

    public Paint.Cap getSpinnerStrokeCap() {
        return this.d0;
    }

    public int getStartAngle() {
        return this.F;
    }

    public float getTextScale() {
        return this.O;
    }

    public int getTextSize() {
        return this.N;
    }

    public String getUnit() {
        return this.q0;
    }

    public float getUnitScale() {
        return this.P;
    }

    public int getUnitSize() {
        return this.M;
    }

    public boolean i() {
        return this.u0;
    }

    public void k(int i2, e eVar, int i3, float f2) {
        this.I = i2;
        this.J = eVar;
        this.K = i3;
        this.L = f2;
    }

    public void l(float f2, float f3, long j2) {
        if (this.A0 && this.F0) {
            float f4 = this.p / ((float) this.B0);
            f3 = ((float) Math.round(f3 / f4)) * f4;
        } else if (this.G0) {
            f3 = (float) Math.round(f3);
        }
        float max = Math.max(this.q, f3);
        float f5 = this.r;
        if (f5 >= Utils.FLOAT_EPSILON) {
            max = Math.min(f5, max);
        }
        this.x = (double) j2;
        Message message = new Message();
        message.what = b.f1947e - 1;
        message.obj = new float[]{f2, max};
        this.A.sendMessage(message);
        q(max);
    }

    public void m(float f2, long j2) {
        l(this.m, f2, j2);
    }

    public void o() {
        n();
        this.g0.setAntiAlias(true);
        this.g0.setStrokeCap(this.d0);
        this.g0.setStyle(Paint.Style.STROKE);
        this.g0.setStrokeWidth((float) this.D);
        this.g0.setColor(this.S);
        this.m0.setColor(this.Q);
        this.m0.setAntiAlias(true);
        this.m0.setStyle(Paint.Style.STROKE);
        this.m0.setStrokeWidth(this.G);
        this.n0.setColor(this.R);
        this.n0.setAntiAlias(true);
        this.n0.setStyle(Paint.Style.STROKE);
        this.n0.setStrokeWidth(this.H);
        this.l0.setStyle(Paint.Style.FILL);
        this.l0.setAntiAlias(true);
        Typeface typeface = this.M0;
        if (typeface != null) {
            this.l0.setTypeface(typeface);
        }
        this.k0.setSubpixelText(true);
        this.k0.setLinearText(true);
        this.k0.setTypeface(Typeface.MONOSPACE);
        this.k0.setColor(this.V);
        this.k0.setStyle(Paint.Style.FILL);
        this.k0.setAntiAlias(true);
        this.k0.setTextSize((float) this.N);
        Typeface typeface2 = this.L0;
        if (typeface2 != null) {
            this.k0.setTypeface(typeface2);
        } else {
            this.k0.setTypeface(Typeface.MONOSPACE);
        }
        this.i0.setColor(this.T);
        this.i0.setAntiAlias(true);
        this.i0.setStyle(Paint.Style.FILL);
        this.j0.setColor(this.U);
        this.j0.setAntiAlias(true);
        this.j0.setStyle(Paint.Style.STROKE);
        this.j0.setStrokeWidth((float) this.E);
        this.h0.setColor(this.K);
        this.h0.setAntiAlias(true);
        this.h0.setStyle(Paint.Style.STROKE);
        this.h0.setStrokeWidth((float) this.I);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        if (r17.z0 != false) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        if (r17.z0 != false) goto L_0x0114;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
        // Method dump skipped, instructions count: 1110
        */
        throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.CircleProgressView.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft > paddingTop) {
            paddingLeft = paddingTop;
        }
        setMeasuredDimension(getPaddingLeft() + paddingLeft + getPaddingRight(), paddingLeft + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f1923c = i2;
        this.f1922b = i3;
        int min = Math.min(i2, i3);
        int i6 = this.f1923c - min;
        int i7 = (this.f1922b - min) / 2;
        float paddingTop = (float) (getPaddingTop() + i7);
        float paddingBottom = (float) (getPaddingBottom() + i7);
        int i8 = i6 / 2;
        float paddingLeft = (float) (getPaddingLeft() + i8);
        float paddingRight = (float) (getPaddingRight() + i8);
        int width = getWidth();
        int height = getHeight();
        int i9 = this.D;
        int i10 = this.E;
        float f2 = this.G;
        float f3 = ((float) i9) / 2.0f > (((float) i10) / 2.0f) + f2 ? ((float) i9) / 2.0f : (((float) i10) / 2.0f) + f2;
        float f4 = ((float) width) - paddingRight;
        float f5 = ((float) height) - paddingBottom;
        this.f1924d = new RectF(paddingLeft + f3, paddingTop + f3, f4 - f3, f5 - f3);
        int i11 = this.D;
        this.f1925e = new RectF(paddingLeft + ((float) i11), paddingTop + ((float) i11), f4 - ((float) i11), f5 - ((float) i11));
        this.f1927g = g(this.f1924d);
        RectF rectF = this.f1924d;
        float f6 = rectF.left;
        int i12 = this.E;
        float f7 = this.H;
        this.f1931k = new RectF(f6 + (((float) i12) / 2.0f) + (f7 / 2.0f), rectF.top + (((float) i12) / 2.0f) + (f7 / 2.0f), (rectF.right - (((float) i12) / 2.0f)) - (f7 / 2.0f), (rectF.bottom - (((float) i12) / 2.0f)) - (f7 / 2.0f));
        RectF rectF2 = this.f1924d;
        float f8 = rectF2.left;
        int i13 = this.E;
        float f9 = this.G;
        this.f1930j = new RectF((f8 - (((float) i13) / 2.0f)) - (f9 / 2.0f), (rectF2.top - (((float) i13) / 2.0f)) - (f9 / 2.0f), rectF2.right + (((float) i13) / 2.0f) + (f9 / 2.0f), rectF2.bottom + (((float) i13) / 2.0f) + (f9 / 2.0f));
        this.f1926f = new PointF(this.f1924d.centerX(), this.f1924d.centerY());
        n();
        Bitmap bitmap = this.v0;
        if (bitmap != null) {
            this.v0 = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.y0) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            this.H0 = 0;
            m((this.p / 360.0f) * h(new PointF(motionEvent.getX(), motionEvent.getY())), 800);
            return true;
        } else if (actionMasked == 2) {
            int i2 = this.H0 + 1;
            this.H0 = i2;
            if (i2 <= 5) {
                return false;
            }
            setValue((this.p / 360.0f) * h(new PointF(motionEvent.getX(), motionEvent.getY())));
            return true;
        } else if (actionMasked != 3) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.H0 = 0;
            return false;
        }
    }

    public void p() {
        setSpin(true);
        this.A.sendEmptyMessage(b.f1944b - 1);
    }

    public void setAutoTextSize(boolean z2) {
        this.t0 = z2;
    }

    public void setBarColor(int... iArr) {
        this.b0 = iArr;
        n();
    }

    public void setBarStrokeCap(Paint.Cap cap) {
        this.c0 = cap;
        this.e0.setStrokeCap(cap);
        if (this.c0 != Paint.Cap.BUTT) {
            Paint paint = new Paint(this.e0);
            this.f0 = paint;
            paint.setShader(null);
            this.f0.setColor(this.b0[0]);
        }
    }

    public void setBarWidth(int i2) {
        this.D = i2;
        float f2 = (float) i2;
        this.e0.setStrokeWidth(f2);
        this.g0.setStrokeWidth(f2);
    }

    public void setBlockCount(int i2) {
        if (i2 > 1) {
            this.A0 = true;
            this.B0 = i2;
            float f2 = 360.0f / ((float) i2);
            this.D0 = f2;
            this.E0 = f2 * this.C0;
            return;
        }
        this.A0 = false;
    }

    public void setBlockScale(float f2) {
        if (f2 >= Utils.FLOAT_EPSILON && f2 <= 1.0f) {
            this.C0 = f2;
            this.E0 = this.D0 * f2;
        }
    }

    @TargetApi(11)
    public void setClippingBitmap(Bitmap bitmap) {
        if (getWidth() <= 0 || getHeight() <= 0) {
            this.v0 = bitmap;
        } else {
            this.v0 = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        if (this.v0 == null) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        if (decimalFormat != null) {
            this.K0 = decimalFormat;
            return;
        }
        throw new IllegalArgumentException("decimalFormat must not be null!");
    }

    public void setDelayMillis(int i2) {
        this.y = i2;
    }

    public void setDirection(g gVar) {
        this.l = gVar;
    }

    public void setFillCircleColor(int i2) {
        this.T = i2;
        this.i0.setColor(i2);
    }

    public void setInnerContourColor(int i2) {
        this.R = i2;
        this.n0.setColor(i2);
    }

    public void setInnerContourSize(float f2) {
        this.H = f2;
        this.n0.setStrokeWidth(f2);
    }

    public void setLengthChangeInterpolator(TimeInterpolator timeInterpolator) {
        this.A.e(timeInterpolator);
    }

    public void setMaxValue(float f2) {
        this.p = f2;
    }

    public void setMaxValueAllowed(float f2) {
        this.r = f2;
    }

    public void setMinValueAllowed(float f2) {
        this.q = f2;
    }

    public void setOnAnimationStateChangedListener(d dVar) {
        this.C = dVar;
    }

    public void setOnProgressChangedListener(b bVar) {
        this.I0 = bVar;
    }

    public void setOuterContourColor(int i2) {
        this.Q = i2;
        this.m0.setColor(i2);
    }

    public void setOuterContourSize(float f2) {
        this.G = f2;
        this.m0.setStrokeWidth(f2);
    }

    public void setRimColor(int i2) {
        this.U = i2;
        this.j0.setColor(i2);
    }

    public void setRimShader(Shader shader) {
        this.j0.setShader(shader);
    }

    public void setRimWidth(int i2) {
        this.E = i2;
        this.j0.setStrokeWidth((float) i2);
    }

    public void setRoundToBlock(boolean z2) {
        this.F0 = z2;
    }

    public void setRoundToWholeNumber(boolean z2) {
        this.G0 = z2;
    }

    public void setSeekModeEnabled(boolean z2) {
        this.y0 = z2;
    }

    public void setShowBlock(boolean z2) {
        this.A0 = z2;
    }

    public void setShowTextWhileSpinning(boolean z2) {
        this.z0 = z2;
    }

    public void setSpinBarColor(int i2) {
        this.S = i2;
        this.g0.setColor(i2);
    }

    public void setSpinSpeed(float f2) {
        this.v = f2;
    }

    public void setSpinnerStrokeCap(Paint.Cap cap) {
        this.d0 = cap;
        this.g0.setStrokeCap(cap);
    }

    public void setSpinningBarLength(float f2) {
        this.t = f2;
        this.s = f2;
    }

    public void setStartAngle(int i2) {
        this.F = (int) j((float) i2);
    }

    public void setText(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.o0 = str;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.V = i2;
        this.k0.setColor(i2);
    }

    public void setTextColorAuto(boolean z2) {
        this.a0 = z2;
    }

    public void setTextMode(j jVar) {
        this.s0 = jVar;
    }

    public void setTextScale(float f2) {
        this.O = f2;
    }

    public void setTextSize(int i2) {
        this.k0.setTextSize((float) i2);
        this.N = i2;
        this.t0 = false;
    }

    public void setTextTypeface(Typeface typeface) {
        this.k0.setTypeface(typeface);
    }

    public void setUnit(String str) {
        if (str == null) {
            this.q0 = BuildConfig.FLAVOR;
        } else {
            this.q0 = str;
        }
        invalidate();
    }

    public void setUnitColor(int i2) {
        this.W = i2;
        this.l0.setColor(i2);
        this.a0 = false;
    }

    public void setUnitPosition(k kVar) {
        this.r0 = kVar;
        r();
    }

    public void setUnitScale(float f2) {
        this.P = f2;
    }

    public void setUnitSize(int i2) {
        this.M = i2;
        this.l0.setTextSize((float) i2);
    }

    public void setUnitTextTypeface(Typeface typeface) {
        this.l0.setTypeface(typeface);
    }

    public void setUnitToTextScale(float f2) {
        this.x0 = f2;
        r();
    }

    public void setUnitVisible(boolean z2) {
        if (z2 != this.u0) {
            this.u0 = z2;
            r();
        }
    }

    public void setValue(float f2) {
        if (this.A0 && this.F0) {
            float f3 = this.p / ((float) this.B0);
            f2 = ((float) Math.round(f2 / f3)) * f3;
        } else if (this.G0) {
            f2 = (float) Math.round(f2);
        }
        float max = Math.max(this.q, f2);
        float f4 = this.r;
        if (f4 >= Utils.FLOAT_EPSILON) {
            max = Math.min(f4, max);
        }
        Message message = new Message();
        message.what = b.f1946d - 1;
        message.obj = new float[]{max, max};
        this.A.sendMessage(message);
        q(max);
    }

    public void setValueAnimated(float f2) {
        m(f2, 1200);
    }

    public void setValueInterpolator(TimeInterpolator timeInterpolator) {
        this.A.g(timeInterpolator);
    }
}
