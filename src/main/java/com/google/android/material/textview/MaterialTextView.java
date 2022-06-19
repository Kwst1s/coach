package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.e.a.b.l;
import c.e.a.b.z.b;
import c.e.a.b.z.c;
import com.google.android.material.theme.a.a;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private void f(Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, l.g2);
        int i3 = i(getContext(), obtainStyledAttributes, l.i2, l.j2);
        obtainStyledAttributes.recycle();
        if (i3 >= 0) {
            setLineHeight(i3);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, c.e.a.b.b.textAppearanceLineHeightEnabled, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.k2, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(l.l2, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < iArr.length && i2 < 0; i3++) {
            i2 = c.c(context, typedArray, iArr[i3], -1);
        }
        return i2;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.k2, i2, i3);
        int i4 = i(context, obtainStyledAttributes, l.m2, l.n2);
        obtainStyledAttributes.recycle();
        if (i4 != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (g(context)) {
            f(context.getTheme(), i2);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a.c(context, attributeSet, i2, i3), attributeSet, i2);
        int h2;
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (!j(context2, theme, attributeSet, i2, i3) && (h2 = h(theme, attributeSet, i2, i3)) != -1) {
                f(theme, h2);
            }
        }
    }
}
