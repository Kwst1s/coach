package c.e.a.b.a0;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import b.h.e.a;

/* compiled from: RippleUtils */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3242a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3243b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3244c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3245d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f3246e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f3247f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f3248g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f3249h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f3250i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f3251j = {16842913};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f3252k = {16842910, 16842919};
    static final String l = b.class.getSimpleName();

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f3242a) {
            return new ColorStateList(new int[][]{f3251j, StateSet.NOTHING}, new int[]{c(colorStateList, f3247f), c(colorStateList, f3243b)});
        }
        int[] iArr = f3247f;
        int[] iArr2 = f3248g;
        int[] iArr3 = f3249h;
        int[] iArr4 = f3250i;
        int[] iArr5 = f3243b;
        int[] iArr6 = f3244c;
        int[] iArr7 = f3245d;
        int[] iArr8 = f3246e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f3251j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i2) {
        return a.d(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f3242a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f3252k, 0)) != 0) {
            Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
