package c.b.a.a.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.widget.h;
import androidx.core.graphics.drawable.a;

/* compiled from: ResourceUtil */
public class d {
    public static ColorStateList a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColorStateList(i2, context.getTheme());
        }
        return context.getResources().getColorStateList(i2);
    }

    public static Drawable b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(i2, context.getTheme());
        }
        return h.b().c(context, i2);
    }

    public static Drawable c(Context context, int i2, int i3) {
        return d(context, b(context, i2).mutate(), i3);
    }

    public static Drawable d(Context context, Drawable drawable, int i2) {
        Drawable r = a.r(drawable);
        a.o(r, a(context, i2));
        return r;
    }
}
