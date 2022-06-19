package at.grabner.circleprogress;

import android.graphics.Color;

/* compiled from: ColorUtils */
public class f {
    public static int a(int i2, int i3, float f2) {
        int[] iArr = {b((float) Color.red(i2), (float) Color.red(i3), f2), b((float) Color.green(i2), (float) Color.green(i3), f2), b((float) Color.blue(i2), (float) Color.blue(i3), f2)};
        return Color.argb(255, iArr[0], iArr[1], iArr[2]);
    }

    private static int b(float f2, float f3, float f4) {
        return Math.round((f2 * f4) + (f3 * (1.0f - f4)));
    }
}
