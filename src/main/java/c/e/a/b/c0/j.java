package c.e.a.b.c0;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: RoundedCornerTreatment */
public class j extends d {

    /* renamed from: a  reason: collision with root package name */
    float f3297a = -1.0f;

    @Override // c.e.a.b.c0.d
    public void a(m mVar, float f2, float f3, float f4) {
        mVar.o(Utils.FLOAT_EPSILON, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        mVar.a(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, f5, f5, 180.0f, f2);
    }
}
