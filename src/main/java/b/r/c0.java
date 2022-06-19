package b.r;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import b.h.k.u;

/* access modifiers changed from: package-private */
/* compiled from: ViewUtils */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final i0 f2856a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f2857b = new a(Float.class, "translationAlpha");

    /* compiled from: ViewUtils */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(c0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            c0.g(view, f2.floatValue());
        }
    }

    /* compiled from: ViewUtils */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return u.u(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            u.t0(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f2856a = new h0();
        } else if (i2 >= 23) {
            f2856a = new g0();
        } else if (i2 >= 22) {
            f2856a = new f0();
        } else if (i2 >= 21) {
            f2856a = new e0();
        } else if (i2 >= 19) {
            f2856a = new d0();
        } else {
            f2856a = new i0();
        }
        new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f2856a.a(view);
    }

    static b0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new a0(view);
        }
        return z.e(view);
    }

    static float c(View view) {
        return f2856a.c(view);
    }

    static m0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new l0(view);
        }
        return new k0(view.getWindowToken());
    }

    static void e(View view) {
        f2856a.d(view);
    }

    static void f(View view, int i2, int i3, int i4, int i5) {
        f2856a.e(view, i2, i3, i4, i5);
    }

    static void g(View view, float f2) {
        f2856a.f(view, f2);
    }

    static void h(View view, int i2) {
        f2856a.g(view, i2);
    }

    static void i(View view, Matrix matrix) {
        f2856a.h(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        f2856a.i(view, matrix);
    }
}
