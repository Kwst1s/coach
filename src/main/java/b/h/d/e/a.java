package b.h.d.e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import b.h.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ColorStateListInflaterCompat */
public final class a {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i2 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i3 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i2 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                int[] iArr3 = new int[i3];
                int[][] iArr4 = new int[i3][];
                System.arraycopy(iArr2, 0, iArr3, 0, i3);
                System.arraycopy(iArr, 0, iArr4, 0, i3);
            } else {
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    TypedArray f2 = f(resources, theme, attributeSet, c.f2430a);
                    int color = f2.getColor(c.f2431b, -65281);
                    float f3 = 1.0f;
                    int i4 = c.f2432c;
                    if (f2.hasValue(i4)) {
                        f3 = f2.getFloat(i4, 1.0f);
                    } else {
                        int i5 = c.f2433d;
                        if (f2.hasValue(i5)) {
                            f3 = f2.getFloat(i5, 1.0f);
                        }
                    }
                    f2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr5 = new int[attributeCount];
                    int i6 = 0;
                    for (int i7 = 0; i7 < attributeCount; i7++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                        if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == b.h.a.alpha)) {
                            int i8 = i6 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i7, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr5[i6] = attributeNameResource;
                            i6 = i8;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr5, i6);
                    iArr2 = e.a(iArr2, i3, e(color, f3));
                    iArr = (int[][]) e.b(iArr, i3, trimStateSet);
                    i3++;
                }
                i2 = 1;
            }
        }
        int[] iArr32 = new int[i3];
        int[][] iArr42 = new int[i3][];
        System.arraycopy(iArr2, 0, iArr32, 0, i3);
        System.arraycopy(iArr, 0, iArr42, 0, i3);
        return new ColorStateList(iArr42, iArr32);
    }

    private static int e(int i2, float f2) {
        return (i2 & 16777215) | (Math.round(((float) Color.alpha(i2)) * f2) << 24);
    }

    private static TypedArray f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
