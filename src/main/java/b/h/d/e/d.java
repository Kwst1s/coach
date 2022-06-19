package b.h.d.e;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import b.h.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat */
final class d {
    private static a a(a aVar, int i2, int i3, boolean z, int i4) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i2, i4, i3);
        }
        return new a(i2, i3);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray k2 = g.k(resources, theme, attributeSet, c.w);
            float f2 = g.f(k2, xmlPullParser, "startX", c.F, Utils.FLOAT_EPSILON);
            float f3 = g.f(k2, xmlPullParser, "startY", c.G, Utils.FLOAT_EPSILON);
            float f4 = g.f(k2, xmlPullParser, "endX", c.H, Utils.FLOAT_EPSILON);
            float f5 = g.f(k2, xmlPullParser, "endY", c.I, Utils.FLOAT_EPSILON);
            float f6 = g.f(k2, xmlPullParser, "centerX", c.A, Utils.FLOAT_EPSILON);
            float f7 = g.f(k2, xmlPullParser, "centerY", c.B, Utils.FLOAT_EPSILON);
            int g2 = g.g(k2, xmlPullParser, "type", c.z, 0);
            int b2 = g.b(k2, xmlPullParser, "startColor", c.x, 0);
            boolean j2 = g.j(xmlPullParser, "centerColor");
            int b3 = g.b(k2, xmlPullParser, "centerColor", c.E, 0);
            int b4 = g.b(k2, xmlPullParser, "endColor", c.y, 0);
            int g3 = g.g(k2, xmlPullParser, "tileMode", c.D, 0);
            float f8 = g.f(k2, xmlPullParser, "gradientRadius", c.C, Utils.FLOAT_EPSILON);
            k2.recycle();
            a a2 = a(c(resources, xmlPullParser, attributeSet, theme), b2, b4, j2, b3);
            if (g2 != 1) {
                if (g2 != 2) {
                    return new LinearGradient(f2, f3, f4, f5, a2.f2462a, a2.f2463b, d(g3));
                }
                return new SweepGradient(f6, f7, a2.f2462a, a2.f2463b);
            } else if (f8 > Utils.FLOAT_EPSILON) {
                return new RadialGradient(f6, f7, f8, a2.f2462a, a2.f2463b, d(g3));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static b.h.d.e.d.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.d.e.d.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):b.h.d.e.d$a");
    }

    private static Shader.TileMode d(int i2) {
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f2462a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f2463b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2462a = new int[size];
            this.f2463b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f2462a[i2] = list.get(i2).intValue();
                this.f2463b[i2] = list2.get(i2).floatValue();
            }
        }

        a(int i2, int i3) {
            this.f2462a = new int[]{i2, i3};
            this.f2463b = new float[]{Utils.FLOAT_EPSILON, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.f2462a = new int[]{i2, i3, i4};
            this.f2463b = new float[]{Utils.FLOAT_EPSILON, 0.5f, 1.0f};
        }
    }
}
