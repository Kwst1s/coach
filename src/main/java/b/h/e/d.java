package b.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import b.e.e;
import b.h.d.e.c;
import b.h.d.e.f;
import b.h.h.b;

@SuppressLint({"NewApi"})
/* compiled from: TypefaceCompat */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f2480a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f2481b = new e<>(16);

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f2480a = new i();
        } else if (i2 >= 28) {
            f2480a = new h();
        } else if (i2 >= 26) {
            f2480a = new g();
        } else if (i2 >= 24 && f.m()) {
            f2480a = new f();
        } else if (i2 >= 21) {
            f2480a = new e();
        } else {
            f2480a = new j();
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        Typeface g2;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (Build.VERSION.SDK_INT >= 21 || (g2 = g(context, typeface, i2)) == null) {
            return Typeface.create(typeface, i2);
        } else {
            return g2;
        }
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        return f2480a.c(context, cancellationSignal, fVarArr, i2);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typeface = b.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i3);
        } else {
            typeface = f2480a.b(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.b(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f2481b.d(e(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        Typeface e2 = f2480a.e(context, resources, i2, str, i3);
        if (e2 != null) {
            f2481b.d(e(resources, i2, i3), e2);
        }
        return e2;
    }

    private static String e(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface f(Resources resources, int i2, int i3) {
        return f2481b.c(e(resources, i2, i3));
    }

    private static Typeface g(Context context, Typeface typeface, int i2) {
        j jVar = f2480a;
        c.b i3 = jVar.i(typeface);
        if (i3 == null) {
            return null;
        }
        return jVar.b(context, i3, context.getResources(), i2);
    }
}
