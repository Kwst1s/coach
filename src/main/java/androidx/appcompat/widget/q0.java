package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.a.k.a.a;
import b.h.d.e.f;

/* compiled from: TintTypedArray */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f732a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f733b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f734c;

    private q0(Context context, TypedArray typedArray) {
        this.f732a = context;
        this.f733b = typedArray;
    }

    public static q0 t(Context context, int i2, int[] iArr) {
        return new q0(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static q0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new q0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static q0 v(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new q0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z) {
        return this.f733b.getBoolean(i2, z);
    }

    public int b(int i2, int i3) {
        return this.f733b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList c2;
        if (!this.f733b.hasValue(i2) || (resourceId = this.f733b.getResourceId(i2, 0)) == 0 || (c2 = a.c(this.f732a, resourceId)) == null) {
            return this.f733b.getColorStateList(i2);
        }
        return c2;
    }

    public float d(int i2, float f2) {
        return this.f733b.getDimension(i2, f2);
    }

    public int e(int i2, int i3) {
        return this.f733b.getDimensionPixelOffset(i2, i3);
    }

    public int f(int i2, int i3) {
        return this.f733b.getDimensionPixelSize(i2, i3);
    }

    public Drawable g(int i2) {
        int resourceId;
        if (!this.f733b.hasValue(i2) || (resourceId = this.f733b.getResourceId(i2, 0)) == 0) {
            return this.f733b.getDrawable(i2);
        }
        return a.d(this.f732a, resourceId);
    }

    public Drawable h(int i2) {
        int resourceId;
        if (!this.f733b.hasValue(i2) || (resourceId = this.f733b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return h.b().d(this.f732a, resourceId, true);
    }

    public float i(int i2, float f2) {
        return this.f733b.getFloat(i2, f2);
    }

    public Typeface j(int i2, int i3, f.a aVar) {
        int resourceId = this.f733b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f734c == null) {
            this.f734c = new TypedValue();
        }
        return f.c(this.f732a, resourceId, this.f734c, i3, aVar);
    }

    public int k(int i2, int i3) {
        return this.f733b.getInt(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f733b.getInteger(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f733b.getLayoutDimension(i2, i3);
    }

    public int n(int i2, int i3) {
        return this.f733b.getResourceId(i2, i3);
    }

    public String o(int i2) {
        return this.f733b.getString(i2);
    }

    public CharSequence p(int i2) {
        return this.f733b.getText(i2);
    }

    public CharSequence[] q(int i2) {
        return this.f733b.getTextArray(i2);
    }

    public TypedArray r() {
        return this.f733b;
    }

    public boolean s(int i2) {
        return this.f733b.hasValue(i2);
    }

    public void w() {
        this.f733b.recycle();
    }
}
