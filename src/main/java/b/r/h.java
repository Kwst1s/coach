package b.r;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* access modifiers changed from: package-private */
/* compiled from: PathProperty */
public class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f2875a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f2876b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2877c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f2878d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f2879e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f2880f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2875a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f2876b = pathMeasure;
        this.f2877c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f2880f);
    }

    /* renamed from: b */
    public void set(T t, Float f2) {
        this.f2880f = f2.floatValue();
        this.f2876b.getPosTan(this.f2877c * f2.floatValue(), this.f2878d, null);
        PointF pointF = this.f2879e;
        float[] fArr = this.f2878d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2875a.set(t, pointF);
    }
}
