package fr.castorflex.android.circularprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import fr.castorflex.android.circularprogressbar.a;

public class CircularProgressBar extends ProgressBar {
    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.cpbStyle);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (isInEditMode()) {
            setIndeterminateDrawable(new a.b(context, true).a());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f9731a, i2, 0);
        int color = obtainStyledAttributes.getColor(m.f9732b, resources.getColor(i.cpb_default_color));
        float dimension = obtainStyledAttributes.getDimension(m.f9737g, resources.getDimension(j.cpb_default_stroke_width));
        float f2 = obtainStyledAttributes.getFloat(m.f9738h, Float.parseFloat(resources.getString(l.cpb_default_sweep_speed)));
        float f3 = obtainStyledAttributes.getFloat(m.f9736f, Float.parseFloat(resources.getString(l.cpb_default_rotation_speed)));
        int resourceId = obtainStyledAttributes.getResourceId(m.f9733c, 0);
        int integer = obtainStyledAttributes.getInteger(m.f9735e, resources.getInteger(k.cpb_default_min_sweep_angle));
        int integer2 = obtainStyledAttributes.getInteger(m.f9734d, resources.getInteger(k.cpb_default_max_sweep_angle));
        obtainStyledAttributes.recycle();
        int[] iArr = resourceId != 0 ? resources.getIntArray(resourceId) : null;
        a.b bVar = new a.b(context);
        bVar.i(f2);
        bVar.g(f3);
        bVar.h(dimension);
        bVar.f(integer);
        bVar.e(integer2);
        if (iArr == null || iArr.length <= 0) {
            bVar.b(color);
        } else {
            bVar.c(iArr);
        }
        setIndeterminateDrawable(bVar.a());
    }
}
