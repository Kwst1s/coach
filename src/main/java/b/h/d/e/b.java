package b.h.d.e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f2449a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f2450b;

    /* renamed from: c  reason: collision with root package name */
    private int f2451c;

    private b(Shader shader, ColorStateList colorStateList, int i2) {
        this.f2449a = shader;
        this.f2450b = colorStateList;
        this.f2451c = i2;
    }

    private static b a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (name.equals("gradient")) {
                return d(d.b(resources, xml, asAttributeSet, theme));
            }
            if (name.equals("selector")) {
                return c(a.b(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }

    static b b(int i2) {
        return new b(null, null, i2);
    }

    static b c(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    static b d(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b g(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    public int e() {
        return this.f2451c;
    }

    public Shader f() {
        return this.f2449a;
    }

    public boolean h() {
        return this.f2449a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f2449a == null && (colorStateList = this.f2450b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f2450b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2451c) {
                this.f2451c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i2) {
        this.f2451c = i2;
    }

    public boolean l() {
        return h() || this.f2451c != 0;
    }
}
