package b.m.a.a;

import android.view.animation.Interpolator;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: LookupTableInterpolator */
abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f2783a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2784b;

    protected d(float[] fArr) {
        this.f2783a = fArr;
        this.f2784b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= Utils.FLOAT_EPSILON) {
            return Utils.FLOAT_EPSILON;
        }
        float[] fArr = this.f2783a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f2), fArr.length - 2);
        float f3 = this.f2784b;
        float f4 = (f2 - (((float) min) * f3)) / f3;
        float[] fArr2 = this.f2783a;
        return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
    }
}
