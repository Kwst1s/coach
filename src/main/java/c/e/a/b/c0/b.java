package c.e.a.b.c0;

import android.graphics.RectF;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f3270a;

    /* renamed from: b  reason: collision with root package name */
    private final float f3271b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f3270a;
            f2 += ((b) cVar).f3271b;
        }
        this.f3270a = cVar;
        this.f3271b = f2;
    }

    @Override // c.e.a.b.c0.c
    public float a(RectF rectF) {
        return Math.max((float) Utils.FLOAT_EPSILON, this.f3270a.a(rectF) + this.f3271b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f3270a.equals(bVar.f3270a) || this.f3271b != bVar.f3271b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3270a, Float.valueOf(this.f3271b)});
    }
}
