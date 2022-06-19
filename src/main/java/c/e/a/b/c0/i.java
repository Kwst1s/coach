package c.e.a.b.c0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize */
public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f3296a;

    public i(float f2) {
        this.f3296a = f2;
    }

    @Override // c.e.a.b.c0.c
    public float a(RectF rectF) {
        return this.f3296a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof i) && this.f3296a == ((i) obj).f3296a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3296a)});
    }
}
