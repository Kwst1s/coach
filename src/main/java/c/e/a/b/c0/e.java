package c.e.a.b.c0;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: CutCornerTreatment */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    float f3272a = -1.0f;

    @Override // c.e.a.b.c0.d
    public void a(m mVar, float f2, float f3, float f4) {
        mVar.o(Utils.FLOAT_EPSILON, f4 * f3, 180.0f, 180.0f - f2);
        double sin = Math.sin(Math.toRadians((double) f2));
        double d2 = (double) f4;
        Double.isNaN(d2);
        double d3 = (double) f3;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians((double) (90.0f - f2)));
        Double.isNaN(d2);
        Double.isNaN(d3);
        mVar.m((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }
}
