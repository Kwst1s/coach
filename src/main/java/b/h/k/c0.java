package b.h.k;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat */
public class c0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f2597b;

    /* renamed from: a  reason: collision with root package name */
    private final k f2598a;

    /* compiled from: WindowInsetsCompat */
    private static class d extends c {
        d() {
        }

        d(c0 c0Var) {
            super(c0Var);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final c0 f2606a;

        /* renamed from: b  reason: collision with root package name */
        private b.h.e.b[] f2607b;

        e() {
            this(new c0((c0) null));
        }

        /* access modifiers changed from: protected */
        public final void a() {
            b.h.e.b[] bVarArr = this.f2607b;
            if (bVarArr != null) {
                b.h.e.b bVar = bVarArr[l.a(1)];
                b.h.e.b bVar2 = this.f2607b[l.a(2)];
                if (bVar != null && bVar2 != null) {
                    f(b.h.e.b.a(bVar, bVar2));
                } else if (bVar != null) {
                    f(bVar);
                } else if (bVar2 != null) {
                    f(bVar2);
                }
                b.h.e.b bVar3 = this.f2607b[l.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                b.h.e.b bVar4 = this.f2607b[l.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                b.h.e.b bVar5 = this.f2607b[l.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public c0 b() {
            a();
            return this.f2606a;
        }

        /* access modifiers changed from: package-private */
        public void c(b.h.e.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(b.h.e.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void e(b.h.e.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(b.h.e.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void g(b.h.e.b bVar) {
        }

        e(c0 c0Var) {
            this.f2606a = c0Var;
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class h extends g {
        h(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public c0 a() {
            return c0.q(this.f2613c.consumeDisplayCutout());
        }

        @Override // b.h.k.c0.k, b.h.k.c0.f
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!Objects.equals(this.f2613c, hVar.f2613c) || !Objects.equals(this.f2616f, hVar.f2616f)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public c f() {
            return c.a(this.f2613c.getDisplayCutout());
        }

        @Override // b.h.k.c0.k
        public int hashCode() {
            return this.f2613c.hashCode();
        }

        h(c0 c0Var, h hVar) {
            super(c0Var, hVar);
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class j extends i {
        static final c0 o = c0.q(WindowInsets.CONSUMED);

        j(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k, b.h.k.c0.f
        public final void d(View view) {
        }

        j(c0 c0Var, j jVar) {
            super(c0Var, jVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat */
    public static class k {

        /* renamed from: b  reason: collision with root package name */
        static final c0 f2617b = new a().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final c0 f2618a;

        k(c0 c0Var) {
            this.f2618a = c0Var;
        }

        /* access modifiers changed from: package-private */
        public c0 a() {
            return this.f2618a;
        }

        /* access modifiers changed from: package-private */
        public c0 b() {
            return this.f2618a;
        }

        /* access modifiers changed from: package-private */
        public c0 c() {
            return this.f2618a;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(c0 c0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (l() != kVar.l() || k() != kVar.k() || !b.h.j.c.a(i(), kVar.i()) || !b.h.j.c.a(h(), kVar.h()) || !b.h.j.c.a(f(), kVar.f())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public c f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public b.h.e.b g() {
            return i();
        }

        /* access modifiers changed from: package-private */
        public b.h.e.b h() {
            return b.h.e.b.f2471e;
        }

        public int hashCode() {
            return b.h.j.c.b(Boolean.valueOf(l()), Boolean.valueOf(k()), i(), h(), f());
        }

        /* access modifiers changed from: package-private */
        public b.h.e.b i() {
            return b.h.e.b.f2471e;
        }

        /* access modifiers changed from: package-private */
        public c0 j(int i2, int i3, int i4, int i5) {
            return f2617b;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean l() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void m(b.h.e.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void n(c0 c0Var) {
        }
    }

    /* compiled from: WindowInsetsCompat */
    public static final class l {
        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f2597b = j.o;
        } else {
            f2597b = k.f2617b;
        }
    }

    private c0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f2598a = new j(this, windowInsets);
        } else if (i2 >= 29) {
            this.f2598a = new i(this, windowInsets);
        } else if (i2 >= 28) {
            this.f2598a = new h(this, windowInsets);
        } else if (i2 >= 21) {
            this.f2598a = new g(this, windowInsets);
        } else if (i2 >= 20) {
            this.f2598a = new f(this, windowInsets);
        } else {
            this.f2598a = new k(this);
        }
    }

    static b.h.e.b k(b.h.e.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f2472a - i2);
        int max2 = Math.max(0, bVar.f2473b - i3);
        int max3 = Math.max(0, bVar.f2474c - i4);
        int max4 = Math.max(0, bVar.f2475d - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return bVar;
        }
        return b.h.e.b.b(max, max2, max3, max4);
    }

    public static c0 q(WindowInsets windowInsets) {
        return r(windowInsets, null);
    }

    public static c0 r(WindowInsets windowInsets, View view) {
        b.h.j.h.c(windowInsets);
        c0 c0Var = new c0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            c0Var.o(u.I(view));
            c0Var.d(view.getRootView());
        }
        return c0Var;
    }

    @Deprecated
    public c0 a() {
        return this.f2598a.a();
    }

    @Deprecated
    public c0 b() {
        return this.f2598a.b();
    }

    @Deprecated
    public c0 c() {
        return this.f2598a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        this.f2598a.d(view);
    }

    @Deprecated
    public b.h.e.b e() {
        return this.f2598a.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        return b.h.j.c.a(this.f2598a, ((c0) obj).f2598a);
    }

    @Deprecated
    public int f() {
        return this.f2598a.i().f2475d;
    }

    @Deprecated
    public int g() {
        return this.f2598a.i().f2472a;
    }

    @Deprecated
    public int h() {
        return this.f2598a.i().f2474c;
    }

    public int hashCode() {
        k kVar = this.f2598a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f2598a.i().f2473b;
    }

    public c0 j(int i2, int i3, int i4, int i5) {
        return this.f2598a.j(i2, i3, i4, i5);
    }

    public boolean l() {
        return this.f2598a.k();
    }

    @Deprecated
    public c0 m(int i2, int i3, int i4, int i5) {
        a aVar = new a(this);
        aVar.c(b.h.e.b.b(i2, i3, i4, i5));
        return aVar.a();
    }

    /* access modifiers changed from: package-private */
    public void n(b.h.e.b bVar) {
        this.f2598a.m(bVar);
    }

    /* access modifiers changed from: package-private */
    public void o(c0 c0Var) {
        this.f2598a.n(c0Var);
    }

    public WindowInsets p() {
        k kVar = this.f2598a;
        if (kVar instanceof f) {
            return ((f) kVar).f2613c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat */
    private static class b extends e {

        /* renamed from: d  reason: collision with root package name */
        private static Field f2600d = null;

        /* renamed from: e  reason: collision with root package name */
        private static boolean f2601e = false;

        /* renamed from: f  reason: collision with root package name */
        private static Constructor<WindowInsets> f2602f = null;

        /* renamed from: g  reason: collision with root package name */
        private static boolean f2603g = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f2604c;

        b() {
            this.f2604c = h();
        }

        private static WindowInsets h() {
            if (!f2601e) {
                try {
                    f2600d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f2601e = true;
            }
            Field field = f2600d;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f2603g) {
                try {
                    f2602f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f2603g = true;
            }
            Constructor<WindowInsets> constructor = f2602f;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public c0 b() {
            a();
            return c0.q(this.f2604c);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void f(b.h.e.b bVar) {
            WindowInsets windowInsets = this.f2604c;
            if (windowInsets != null) {
                this.f2604c = windowInsets.replaceSystemWindowInsets(bVar.f2472a, bVar.f2473b, bVar.f2474c, bVar.f2475d);
            }
        }

        b(c0 c0Var) {
            this.f2604c = c0Var.p();
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class c extends e {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f2605c;

        c() {
            this.f2605c = new WindowInsets.Builder();
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public c0 b() {
            a();
            return c0.q(this.f2605c.build());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void c(b.h.e.b bVar) {
            this.f2605c.setMandatorySystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void d(b.h.e.b bVar) {
            this.f2605c.setStableInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void e(b.h.e.b bVar) {
            this.f2605c.setSystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void f(b.h.e.b bVar) {
            this.f2605c.setSystemWindowInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.e
        public void g(b.h.e.b bVar) {
            this.f2605c.setTappableElementInsets(bVar.e());
        }

        c(c0 c0Var) {
            WindowInsets.Builder builder;
            WindowInsets p = c0Var.p();
            if (p != null) {
                builder = new WindowInsets.Builder(p);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2605c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class g extends f {
        private b.h.e.b m = null;

        g(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public c0 b() {
            return c0.q(this.f2613c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public c0 c() {
            return c0.q(this.f2613c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public final b.h.e.b h() {
            if (this.m == null) {
                this.m = b.h.e.b.b(this.f2613c.getStableInsetLeft(), this.f2613c.getStableInsetTop(), this.f2613c.getStableInsetRight(), this.f2613c.getStableInsetBottom());
            }
            return this.m;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public boolean k() {
            return this.f2613c.isConsumed();
        }

        g(c0 c0Var, g gVar) {
            super(c0Var, gVar);
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class i extends h {
        private b.h.e.b n = null;

        i(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public b.h.e.b g() {
            if (this.n == null) {
                this.n = b.h.e.b.d(this.f2613c.getMandatorySystemGestureInsets());
            }
            return this.n;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k, b.h.k.c0.f
        public c0 j(int i2, int i3, int i4, int i5) {
            return c0.q(this.f2613c.inset(i2, i3, i4, i5));
        }

        i(c0 c0Var, i iVar) {
            super(c0Var, iVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat */
    public static class f extends k {

        /* renamed from: g  reason: collision with root package name */
        private static boolean f2608g = false;

        /* renamed from: h  reason: collision with root package name */
        private static Method f2609h;

        /* renamed from: i  reason: collision with root package name */
        private static Class<?> f2610i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f2611j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f2612k;
        private static Field l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f2613c;

        /* renamed from: d  reason: collision with root package name */
        private b.h.e.b f2614d;

        /* renamed from: e  reason: collision with root package name */
        private c0 f2615e;

        /* renamed from: f  reason: collision with root package name */
        b.h.e.b f2616f;

        f(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var);
            this.f2614d = null;
            this.f2613c = windowInsets;
        }

        private b.h.e.b o(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f2608g) {
                    p();
                }
                Method method = f2609h;
                if (!(method == null || f2611j == null || f2612k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f2612k.get(l.get(invoke));
                        if (rect != null) {
                            return b.h.e.b.c(rect);
                        }
                        return null;
                    } catch (IllegalAccessException e2) {
                        q(e2);
                    } catch (InvocationTargetException e3) {
                        q(e3);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void p() {
            try {
                f2609h = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f2610i = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2611j = cls;
                f2612k = cls.getDeclaredField("mVisibleInsets");
                l = f2610i.getDeclaredField("mAttachInfo");
                f2612k.setAccessible(true);
                l.setAccessible(true);
            } catch (ClassNotFoundException e2) {
                q(e2);
            } catch (NoSuchMethodException e3) {
                q(e3);
            } catch (NoSuchFieldException e4) {
                q(e4);
            }
            f2608g = true;
        }

        private static void q(Exception exc) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + exc.getMessage(), exc);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public void d(View view) {
            b.h.e.b o = o(view);
            if (o == null) {
                o = b.h.e.b.f2471e;
            }
            m(o);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public void e(c0 c0Var) {
            c0Var.o(this.f2615e);
            c0Var.n(this.f2616f);
        }

        @Override // b.h.k.c0.k
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f2616f, ((f) obj).f2616f);
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public final b.h.e.b i() {
            if (this.f2614d == null) {
                this.f2614d = b.h.e.b.b(this.f2613c.getSystemWindowInsetLeft(), this.f2613c.getSystemWindowInsetTop(), this.f2613c.getSystemWindowInsetRight(), this.f2613c.getSystemWindowInsetBottom());
            }
            return this.f2614d;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public c0 j(int i2, int i3, int i4, int i5) {
            a aVar = new a(c0.q(this.f2613c));
            aVar.c(c0.k(i(), i2, i3, i4, i5));
            aVar.b(c0.k(h(), i2, i3, i4, i5));
            return aVar.a();
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public boolean l() {
            return this.f2613c.isRound();
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public void m(b.h.e.b bVar) {
            this.f2616f = bVar;
        }

        /* access modifiers changed from: package-private */
        @Override // b.h.k.c0.k
        public void n(c0 c0Var) {
            this.f2615e = c0Var;
        }

        f(c0 c0Var, f fVar) {
            this(c0Var, new WindowInsets(fVar.f2613c));
        }
    }

    /* compiled from: WindowInsetsCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final e f2599a;

        public a() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f2599a = new d();
            } else if (i2 >= 29) {
                this.f2599a = new c();
            } else if (i2 >= 20) {
                this.f2599a = new b();
            } else {
                this.f2599a = new e();
            }
        }

        public c0 a() {
            return this.f2599a.b();
        }

        @Deprecated
        public a b(b.h.e.b bVar) {
            this.f2599a.d(bVar);
            return this;
        }

        @Deprecated
        public a c(b.h.e.b bVar) {
            this.f2599a.f(bVar);
            return this;
        }

        public a(c0 c0Var) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f2599a = new d(c0Var);
            } else if (i2 >= 29) {
                this.f2599a = new c(c0Var);
            } else if (i2 >= 20) {
                this.f2599a = new b(c0Var);
            } else {
                this.f2599a = new e(c0Var);
            }
        }
    }

    public c0(c0 c0Var) {
        if (c0Var != null) {
            k kVar = c0Var.f2598a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (kVar instanceof j)) {
                this.f2598a = new j(this, (j) kVar);
            } else if (i2 >= 29 && (kVar instanceof i)) {
                this.f2598a = new i(this, (i) kVar);
            } else if (i2 >= 28 && (kVar instanceof h)) {
                this.f2598a = new h(this, (h) kVar);
            } else if (i2 >= 21 && (kVar instanceof g)) {
                this.f2598a = new g(this, (g) kVar);
            } else if (i2 < 20 || !(kVar instanceof f)) {
                this.f2598a = new k(this);
            } else {
                this.f2598a = new f(this, (f) kVar);
            }
            kVar.e(this);
            return;
        }
        this.f2598a = new k(this);
    }
}
