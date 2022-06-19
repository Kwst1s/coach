package c.e.a.b.b0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ShadowRenderer */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f3258i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f3259j = {Utils.FLOAT_EPSILON, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f3260k = new int[4];
    private static final float[] l = {Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f3261a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f3262b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f3263c;

    /* renamed from: d  reason: collision with root package name */
    private int f3264d;

    /* renamed from: e  reason: collision with root package name */
    private int f3265e;

    /* renamed from: f  reason: collision with root package name */
    private int f3266f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f3267g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f3268h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < Utils.FLOAT_EPSILON;
        Path path = this.f3267g;
        if (z) {
            int[] iArr = f3260k;
            iArr[0] = 0;
            iArr[1] = this.f3266f;
            iArr[2] = this.f3265e;
            iArr[3] = this.f3264d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = (float) (-i2);
            rectF.inset(f4, f4);
            int[] iArr2 = f3260k;
            iArr2[0] = 0;
            iArr2[1] = this.f3264d;
            iArr2[2] = this.f3265e;
            iArr2[3] = this.f3266f;
        }
        float width = rectF.width() / 2.0f;
        if (width > Utils.FLOAT_EPSILON) {
            float f5 = 1.0f - (((float) i2) / width);
            float[] fArr = l;
            fArr[1] = f5;
            fArr[2] = ((1.0f - f5) / 2.0f) + f5;
            this.f3262b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f3260k, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, this.f3268h);
            }
            canvas.drawArc(rectF, f2, f3, true, this.f3262b);
            canvas.restore();
        }
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += (float) i2;
        rectF.offset(Utils.FLOAT_EPSILON, (float) (-i2));
        int[] iArr = f3258i;
        iArr[0] = this.f3266f;
        iArr[1] = this.f3265e;
        iArr[2] = this.f3264d;
        Paint paint = this.f3263c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f3259j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f3263c);
        canvas.restore();
    }

    public Paint c() {
        return this.f3261a;
    }

    public void d(int i2) {
        this.f3264d = b.h.e.a.d(i2, 68);
        this.f3265e = b.h.e.a.d(i2, 20);
        this.f3266f = b.h.e.a.d(i2, 0);
        this.f3261a.setColor(this.f3264d);
    }

    public a(int i2) {
        this.f3267g = new Path();
        this.f3268h = new Paint();
        this.f3261a = new Paint();
        d(i2);
        this.f3268h.setColor(0);
        Paint paint = new Paint(4);
        this.f3262b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3263c = new Paint(paint);
    }
}
