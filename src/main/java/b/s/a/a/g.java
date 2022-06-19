package b.s.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import b.h.e.c;
import com.github.mikephil.charting.utils.Utils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat */
public class g implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float[] f2980a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f2981b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f2980a = new float[min];
            this.f2981b = new float[min];
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < min; i3++) {
                pathMeasure.getPosTan((((float) i3) * length) / ((float) (min - 1)), fArr, null);
                this.f2980a[i3] = fArr[0];
                this.f2981b[i3] = fArr[1];
            }
            if (((double) Math.abs(this.f2980a[0])) <= 1.0E-5d && ((double) Math.abs(this.f2981b[0])) <= 1.0E-5d) {
                int i4 = min - 1;
                if (((double) Math.abs(this.f2980a[i4] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f2981b[i4] - 1.0f)) <= 1.0E-5d) {
                    float f2 = Utils.FLOAT_EPSILON;
                    int i5 = 0;
                    while (i2 < min) {
                        float[] fArr2 = this.f2980a;
                        int i6 = i5 + 1;
                        float f3 = fArr2[i5];
                        if (f3 >= f2) {
                            fArr2[i2] = f3;
                            i2++;
                            f2 = f3;
                            i5 = i6;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f2980a[0]);
            sb.append(",");
            sb.append(this.f2981b[0]);
            sb.append(" end:");
            int i7 = min - 1;
            sb.append(this.f2980a[i7]);
            sb.append(",");
            sb.append(this.f2981b[i7]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void c(float f2, float f3) {
        Path path = new Path();
        path.moveTo(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (b.h.d.e.g.j(xmlPullParser, "pathData")) {
            String i2 = b.h.d.e.g.i(typedArray, xmlPullParser, "pathData", 4);
            Path e2 = c.e(i2);
            if (e2 != null) {
                b(e2);
                return;
            }
            throw new InflateException("The path is null, which is created from " + i2);
        } else if (!b.h.d.e.g.j(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (b.h.d.e.g.j(xmlPullParser, "controlY1")) {
            float f2 = b.h.d.e.g.f(typedArray, xmlPullParser, "controlX1", 0, Utils.FLOAT_EPSILON);
            float f3 = b.h.d.e.g.f(typedArray, xmlPullParser, "controlY1", 1, Utils.FLOAT_EPSILON);
            boolean j2 = b.h.d.e.g.j(xmlPullParser, "controlX2");
            if (j2 != b.h.d.e.g.j(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!j2) {
                c(f2, f3);
            } else {
                a(f2, f3, b.h.d.e.g.f(typedArray, xmlPullParser, "controlX2", 2, Utils.FLOAT_EPSILON), b.h.d.e.g.f(typedArray, xmlPullParser, "controlY2", 3, Utils.FLOAT_EPSILON));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    public float getInterpolation(float f2) {
        if (f2 <= Utils.FLOAT_EPSILON) {
            return Utils.FLOAT_EPSILON;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f2980a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f2980a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f2980a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == Utils.FLOAT_EPSILON) {
            return this.f2981b[i2];
        }
        float[] fArr2 = this.f2981b;
        float f4 = fArr2[i2];
        return f4 + (((f2 - fArr[i2]) / f3) * (fArr2[length] - f4));
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k2 = b.h.d.e.g.k(resources, theme, attributeSet, a.l);
        d(k2, xmlPullParser);
        k2.recycle();
    }
}
