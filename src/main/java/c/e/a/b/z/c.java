package c.e.a.b.z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.q0;
import b.a.k.a.a;

/* compiled from: MaterialResources */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int color;
        int resourceId;
        ColorStateList c2;
        if (typedArray.hasValue(i2) && (resourceId = typedArray.getResourceId(i2, 0)) != 0 && (c2 = a.c(context, resourceId)) != null) {
            return c2;
        }
        if (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i2, -1)) == -1) {
            return typedArray.getColorStateList(i2);
        }
        return ColorStateList.valueOf(color);
    }

    public static ColorStateList b(Context context, q0 q0Var, int i2) {
        int b2;
        int n;
        ColorStateList c2;
        if (q0Var.s(i2) && (n = q0Var.n(i2, 0)) != 0 && (c2 = a.c(context, n)) != null) {
            return c2;
        }
        if (Build.VERSION.SDK_INT > 15 || (b2 = q0Var.b(i2, -1)) == -1) {
            return q0Var.c(i2);
        }
        return ColorStateList.valueOf(b2);
    }

    public static int c(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable d2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (d2 = a.d(context, resourceId)) == null) {
            return typedArray.getDrawable(i2);
        }
        return d2;
    }

    static int e(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }

    public static d f(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
