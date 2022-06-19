package c.e.a.b.m;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import b.m.a.a.b;
import b.m.a.a.c;

/* compiled from: AnimationUtils */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f3375a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f3376b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f3377c = new b.m.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f3378d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f3379e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int b(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
