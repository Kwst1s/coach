package c.e.a.b.c0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AbsoluteCornerSize */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f3269a;

    public a(float f2) {
        this.f3269a = f2;
    }

    @Override // c.e.a.b.c0.c
    public float a(RectF rectF) {
        return this.f3269a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && this.f3269a == ((a) obj).f3269a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3269a)});
    }
}
