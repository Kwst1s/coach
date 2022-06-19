package b.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.g0;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* compiled from: AppCompatResources */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2009a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0030a>> f2010b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2011c = new Object();

    /* access modifiers changed from: private */
    /* renamed from: b.a.k.a.a$a  reason: collision with other inner class name */
    /* compiled from: AppCompatResources */
    public static class C0030a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f2012a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f2013b;

        C0030a(ColorStateList colorStateList, Configuration configuration) {
            this.f2012a = colorStateList;
            this.f2013b = configuration;
        }
    }

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f2011c) {
            WeakHashMap<Context, SparseArray<C0030a>> weakHashMap = f2010b;
            SparseArray<C0030a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0030a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i2) {
        C0030a aVar;
        synchronized (f2011c) {
            SparseArray<C0030a> sparseArray = f2010b.get(context);
            if (!(sparseArray == null || sparseArray.size() <= 0 || (aVar = sparseArray.get(i2)) == null)) {
                if (aVar.f2013b.equals(context.getResources().getConfiguration())) {
                    return aVar.f2012a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            return b2;
        }
        ColorStateList f2 = f(context, i2);
        if (f2 == null) {
            return b.h.d.a.c(context, i2);
        }
        a(context, i2, f2);
        return f2;
    }

    public static Drawable d(Context context, int i2) {
        return g0.h().j(context, i2);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f2009a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i2) {
        if (g(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return b.h.d.e.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean g(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue e2 = e();
        resources.getValue(i2, e2, true);
        int i3 = e2.type;
        if (i3 < 28 || i3 > 31) {
            return false;
        }
        return true;
    }
}
