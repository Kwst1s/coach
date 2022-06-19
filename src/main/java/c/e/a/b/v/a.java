package c.e.a.b.v;

import android.content.Context;
import android.graphics.Color;
import c.e.a.b.z.b;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: ElevationOverlayProvider */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3438a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3439b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3440c;

    /* renamed from: d  reason: collision with root package name */
    private final float f3441d;

    public a(Context context) {
        this.f3438a = b.b(context, c.e.a.b.b.elevationOverlayEnabled, false);
        this.f3439b = c.e.a.b.s.a.a(context, c.e.a.b.b.elevationOverlayColor, 0);
        this.f3440c = c.e.a.b.s.a.a(context, c.e.a.b.b.colorSurface, 0);
        this.f3441d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i2) {
        return b.h.e.a.d(i2, 255) == this.f3440c;
    }

    public float a(float f2) {
        float f3 = this.f3441d;
        if (f3 <= Utils.FLOAT_EPSILON || f2 <= Utils.FLOAT_EPSILON) {
            return Utils.FLOAT_EPSILON;
        }
        return Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i2, float f2) {
        float a2 = a(f2);
        return b.h.e.a.d(c.e.a.b.s.a.f(b.h.e.a.d(i2, 255), this.f3439b, a2), Color.alpha(i2));
    }

    public int c(int i2, float f2) {
        return (!this.f3438a || !e(i2)) ? i2 : b(i2, f2);
    }

    public boolean d() {
        return this.f3438a;
    }
}
