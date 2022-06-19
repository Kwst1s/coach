package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import b.e.g;
import b.e.h;
import b.s.a.a.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ResourceManagerInternal */
public final class g0 {

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f621h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    private static g0 f622i;

    /* renamed from: j  reason: collision with root package name */
    private static final c f623j = new c(6);

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f624a;

    /* renamed from: b  reason: collision with root package name */
    private g<String, d> f625b;

    /* renamed from: c  reason: collision with root package name */
    private h<String> f626c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, b.e.d<WeakReference<Drawable.ConstantState>>> f627d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f628e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f629f;

    /* renamed from: g  reason: collision with root package name */
    private e f630g;

    /* access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.a.l.a.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.s.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal */
    public static class c extends b.e.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int h(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter i(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i2, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter j(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i2, mode)), porterDuffColorFilter);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal */
    public interface e {
        boolean a(Context context, int i2, Drawable drawable);

        PorterDuff.Mode b(int i2);

        Drawable c(g0 g0Var, Context context, int i2);

        ColorStateList d(Context context, int i2);

        boolean e(Context context, int i2, Drawable drawable);
    }

    /* access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal */
    public static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(String str, d dVar) {
        if (this.f625b == null) {
            this.f625b = new g<>();
        }
        this.f625b.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        b.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f627d.get(context);
        if (dVar == null) {
            dVar = new b.e.d<>();
            this.f627d.put(context, dVar);
        }
        dVar.i(j2, new WeakReference<>(constantState));
        return true;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f624a == null) {
            this.f624a = new WeakHashMap<>();
        }
        h<ColorStateList> hVar = this.f624a.get(context);
        if (hVar == null) {
            hVar = new h<>();
            this.f624a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    private void d(Context context) {
        if (!this.f629f) {
            this.f629f = true;
            Drawable j2 = j(context, b.a.m.a.abc_vector_test);
            if (j2 == null || !q(j2)) {
                this.f629f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i2) {
        Drawable drawable;
        if (this.f628e == null) {
            this.f628e = new TypedValue();
        }
        TypedValue typedValue = this.f628e;
        context.getResources().getValue(i2, typedValue, true);
        long e2 = e(typedValue);
        Drawable i3 = i(context, e2);
        if (i3 != null) {
            return i3;
        }
        e eVar = this.f630g;
        if (eVar == null) {
            drawable = null;
        } else {
            drawable = eVar.c(this, context, i2);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e2, drawable);
        }
        return drawable;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized g0 h() {
        g0 g0Var;
        synchronized (g0.class) {
            if (f622i == null) {
                g0 g0Var2 = new g0();
                f622i = g0Var2;
                p(g0Var2);
            }
            g0Var = f622i;
        }
        return g0Var;
    }

    private synchronized Drawable i(Context context, long j2) {
        b.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f627d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> e2 = dVar.e(j2);
        if (e2 != null) {
            Drawable.ConstantState constantState = e2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.j(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter i3;
        synchronized (g0.class) {
            c cVar = f623j;
            i3 = cVar.i(i2, mode);
            if (i3 == null) {
                i3 = new PorterDuffColorFilter(i2, mode);
                cVar.j(i2, mode, i3);
            }
        }
        return i3;
    }

    private ColorStateList n(Context context, int i2) {
        h<ColorStateList> hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f624a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.e(i2);
    }

    private static void p(g0 g0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            g0Var.a("vector", new f());
            g0Var.a("animated-vector", new b());
            g0Var.a("animated-selector", new a());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable r(android.content.Context r11, int r12) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g0.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable v(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList m = m(context, i2);
        if (m != null) {
            if (x.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.o(r, m);
            PorterDuff.Mode o = o(i2);
            if (o == null) {
                return r;
            }
            androidx.core.graphics.drawable.a.p(r, o);
            return r;
        }
        e eVar = this.f630g;
        if ((eVar == null || !eVar.e(context, i2, drawable)) && !x(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, o0 o0Var, int[] iArr) {
        if (!x.a(drawable) || drawable.mutate() == drawable) {
            boolean z = o0Var.f702d;
            if (z || o0Var.f701c) {
                drawable.setColorFilter(g(z ? o0Var.f699a : null, o0Var.f701c ? o0Var.f700b : f621h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i2, boolean z) {
        Drawable r;
        d(context);
        r = r(context, i2);
        if (r == null) {
            r = f(context, i2);
        }
        if (r == null) {
            r = b.h.d.a.d(context, i2);
        }
        if (r != null) {
            r = v(context, i2, z, r);
        }
        if (r != null) {
            x.b(r);
        }
        return r;
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i2) {
        ColorStateList n;
        n = n(context, i2);
        if (n == null) {
            e eVar = this.f630g;
            n = eVar == null ? null : eVar.d(context, i2);
            if (n != null) {
                c(context, i2, n);
            }
        }
        return n;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode o(int i2) {
        e eVar = this.f630g;
        if (eVar == null) {
            return null;
        }
        return eVar.b(i2);
    }

    public synchronized void s(Context context) {
        b.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f627d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, v0 v0Var, int i2) {
        Drawable r = r(context, i2);
        if (r == null) {
            r = v0Var.c(i2);
        }
        if (r == null) {
            return null;
        }
        return v(context, i2, false, r);
    }

    public synchronized void u(e eVar) {
        this.f630g = eVar;
    }

    /* access modifiers changed from: package-private */
    public boolean x(Context context, int i2, Drawable drawable) {
        e eVar = this.f630g;
        return eVar != null && eVar.a(context, i2, drawable);
    }
}
