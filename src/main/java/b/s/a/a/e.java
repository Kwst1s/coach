package b.s.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import b.h.d.e.g;
import b.h.e.c;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat */
public class e {

    /* access modifiers changed from: private */
    /* compiled from: AnimatorInflaterCompat */
    public static class a implements TypeEvaluator<c.b[]> {

        /* renamed from: a  reason: collision with root package name */
        private c.b[] f2978a;

        a() {
        }

        /* renamed from: a */
        public c.b[] evaluate(float f2, c.b[] bVarArr, c.b[] bVarArr2) {
            if (c.b(bVarArr, bVarArr2)) {
                if (!c.b(this.f2978a, bVarArr)) {
                    this.f2978a = c.f(bVarArr);
                }
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    this.f2978a[i2].d(bVarArr[i2], bVarArr2[i2], f2);
                }
                return this.f2978a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.Animator b(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: b.s.a.a.e.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe c(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    private static void d(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((float) ((i3 - i2) + 2));
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i2, int i3, int i4, String str) {
        int i5;
        int i6;
        int i7;
        PropertyValuesHolder propertyValuesHolder;
        float f2;
        float f3;
        float f4;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i8 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i9 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((!z || !h(i8)) && (!z2 || !h(i9))) ? 0 : 3;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            c.b[] d2 = c.d(string);
            c.b[] d3 = c.d(string2);
            if (d2 == null && d3 == null) {
                return null;
            }
            if (d2 != null) {
                a aVar = new a();
                if (d3 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, d2);
                } else if (c.b(d2, d3)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, d2, d3);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder2;
            } else if (d3 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new a(), d3);
            }
        } else {
            f a2 = i2 == 3 ? f.a() : null;
            if (z3) {
                if (z) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, Utils.FLOAT_EPSILON);
                    } else {
                        f3 = typedArray.getFloat(i3, Utils.FLOAT_EPSILON);
                    }
                    if (z2) {
                        if (i9 == 5) {
                            f4 = typedArray.getDimension(i4, Utils.FLOAT_EPSILON);
                        } else {
                            f4 = typedArray.getFloat(i4, Utils.FLOAT_EPSILON);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3, f4);
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3);
                    }
                } else {
                    if (i9 == 5) {
                        f2 = typedArray.getDimension(i4, Utils.FLOAT_EPSILON);
                    } else {
                        f2 = typedArray.getFloat(i4, Utils.FLOAT_EPSILON);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
                }
                propertyValuesHolder3 = propertyValuesHolder;
            } else if (z) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, Utils.FLOAT_EPSILON);
                } else if (h(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                if (z2) {
                    if (i9 == 5) {
                        i7 = (int) typedArray.getDimension(i4, Utils.FLOAT_EPSILON);
                    } else if (h(i9)) {
                        i7 = typedArray.getColor(i4, 0);
                    } else {
                        i7 = typedArray.getInt(i4, 0);
                    }
                    propertyValuesHolder3 = PropertyValuesHolder.ofInt(str, i6, i7);
                } else {
                    propertyValuesHolder3 = PropertyValuesHolder.ofInt(str, i6);
                }
            } else if (z2) {
                if (i9 == 5) {
                    i5 = (int) typedArray.getDimension(i4, Utils.FLOAT_EPSILON);
                } else if (h(i9)) {
                    i5 = typedArray.getColor(i4, 0);
                } else {
                    i5 = typedArray.getInt(i4, 0);
                }
                propertyValuesHolder3 = PropertyValuesHolder.ofInt(str, i5);
            }
            if (propertyValuesHolder3 == null || a2 == null) {
                return propertyValuesHolder3;
            }
            propertyValuesHolder3.setEvaluator(a2);
            return propertyValuesHolder3;
        }
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = true;
        boolean z2 = peekValue != null;
        int i4 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        if (peekValue2 == null) {
            z = false;
        }
        int i5 = z ? peekValue2.type : 0;
        if ((!z2 || !h(i4)) && (!z || !h(i5))) {
            return 0;
        }
        return 3;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k2 = g.k(resources, theme, attributeSet, a.f2965j);
        int i2 = 0;
        TypedValue l = g.l(k2, xmlPullParser, "value", 0);
        if ((l != null) && h(l.type)) {
            i2 = 3;
        }
        k2.recycle();
        return i2;
    }

    private static boolean h(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static Animator i(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i2);
        }
        return j(context, context.getResources(), context.getTheme(), i2);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i2) {
        return k(context, resources, theme, i2, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i2, float f2) {
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i2);
            Animator a2 = a(context, resources, theme, xmlResourceParser, f2);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a2;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray k2 = g.k(resources, theme, attributeSet, a.f2962g);
        TypedArray k3 = g.k(resources, theme, attributeSet, a.f2966k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, k2, k3, f2, xmlPullParser);
        int h2 = g.h(k2, xmlPullParser, "interpolator", 0, 0);
        if (h2 > 0) {
            valueAnimator.setInterpolator(d.b(context, h2));
        }
        k2.recycle();
        if (k3 != null) {
            k3.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) {
        Keyframe keyframe;
        TypedArray k2 = g.k(resources, theme, attributeSet, a.f2965j);
        float f2 = g.f(k2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue l = g.l(k2, xmlPullParser, "value", 0);
        boolean z = l != null;
        if (i2 == 4) {
            i2 = (!z || !h(l.type)) ? 0 : 3;
        }
        if (z) {
            if (i2 == 0) {
                keyframe = Keyframe.ofFloat(f2, g.f(k2, xmlPullParser, "value", 0, Utils.FLOAT_EPSILON));
            } else if (i2 == 1 || i2 == 3) {
                keyframe = Keyframe.ofInt(f2, g.g(k2, xmlPullParser, "value", 0, 0));
            } else {
                keyframe = null;
            }
        } else if (i2 == 0) {
            keyframe = Keyframe.ofFloat(f2);
        } else {
            keyframe = Keyframe.ofInt(f2);
        }
        int h2 = g.h(k2, xmlPullParser, "interpolator", 1, 0);
        if (h2 > 0) {
            keyframe.setInterpolator(d.b(context, h2));
        }
        k2.recycle();
        return keyframe;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder o(android.content.Context r9, android.content.res.Resources r10, android.content.res.Resources.Theme r11, org.xmlpull.v1.XmlPullParser r12, java.lang.String r13, int r14) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: b.s.a.a.e.o(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, java.lang.String, int):android.animation.PropertyValuesHolder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder[] p(android.content.Context r17, android.content.res.Resources r18, android.content.res.Resources.Theme r19, org.xmlpull.v1.XmlPullParser r20, android.util.AttributeSet r21) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: b.s.a.a.e.p(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet):android.animation.PropertyValuesHolder[]");
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long g2 = (long) g.g(typedArray, xmlPullParser, "duration", 1, 300);
        long g3 = (long) g.g(typedArray, xmlPullParser, "startOffset", 2, 0);
        int g4 = g.g(typedArray, xmlPullParser, "valueType", 7, 4);
        if (g.j(xmlPullParser, "valueFrom") && g.j(xmlPullParser, "valueTo")) {
            if (g4 == 4) {
                g4 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e2 = e(typedArray, g4, 5, 6, BuildConfig.FLAVOR);
            if (e2 != null) {
                valueAnimator.setValues(e2);
            }
        }
        valueAnimator.setDuration(g2);
        valueAnimator.setStartDelay(g3);
        valueAnimator.setRepeatCount(g.g(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(g.g(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, g4, f2, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String i3 = g.i(typedArray, xmlPullParser, "pathData", 1);
        if (i3 != null) {
            String i4 = g.i(typedArray, xmlPullParser, "propertyXName", 2);
            String i5 = g.i(typedArray, xmlPullParser, "propertyYName", 3);
            if (i2 != 2) {
            }
            if (i4 == null && i5 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            s(c.e(i3), objectAnimator, f2 * 0.5f, i4, i5);
            return;
        }
        objectAnimator.setPropertyName(g.i(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f3 = Utils.FLOAT_EPSILON;
        arrayList.add(Float.valueOf((float) Utils.FLOAT_EPSILON));
        float f4 = Utils.FLOAT_EPSILON;
        do {
            f4 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f4));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f4 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f5 = f4 / ((float) (min - 1));
        int i2 = 0;
        int i3 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f3 += f5;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        if (str2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else if (propertyValuesHolder == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, propertyValuesHolder);
        }
    }
}
