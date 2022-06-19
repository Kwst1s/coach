package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.w0;
import androidx.appcompat.widget.z;
import androidx.lifecycle.e;
import b.a.o.b;
import b.a.o.f;
import b.h.d.e.f;
import b.h.k.a0;
import b.h.k.c0;
import b.h.k.f;
import b.h.k.u;
import b.h.k.y;
import com.github.mikephil.charting.utils.Utils;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* access modifiers changed from: package-private */
/* compiled from: AppCompatDelegateImpl */
public class f extends e implements g.a, LayoutInflater.Factory2 {
    private static final b.e.g<String, Integer> b0 = new b.e.g<>();
    private static final boolean c0;
    private static final int[] d0 = {16842836};
    private static final boolean e0 = (!"robolectric".equals(Build.FINGERPRINT));
    private static final boolean f0;
    private static boolean g0 = true;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private s[] H;
    private s I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private l S;
    private l T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;
    private h a0;

    /* renamed from: e  reason: collision with root package name */
    final Object f166e;

    /* renamed from: f  reason: collision with root package name */
    final Context f167f;

    /* renamed from: g  reason: collision with root package name */
    Window f168g;

    /* renamed from: h  reason: collision with root package name */
    private j f169h;

    /* renamed from: i  reason: collision with root package name */
    final d f170i;

    /* renamed from: j  reason: collision with root package name */
    a f171j;

    /* renamed from: k  reason: collision with root package name */
    MenuInflater f172k;
    private CharSequence l;
    private v m;
    private h n;
    private t o;
    b.a.o.b p;
    ActionBarContextView q;
    PopupWindow r;
    Runnable s;
    y t;
    private boolean u;
    private boolean v;
    ViewGroup w;
    private TextView x;
    private View y;
    private boolean z;

    /* compiled from: AppCompatDelegateImpl */
    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f173a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f173a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f173a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f173a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    class b implements Runnable {
        b() {
        }

        public void run() {
            f fVar = f.this;
            if ((fVar.V & 1) != 0) {
                fVar.V(0);
            }
            f fVar2 = f.this;
            if ((fVar2.V & 4096) != 0) {
                fVar2.V(androidx.constraintlayout.widget.i.H0);
            }
            f fVar3 = f.this;
            fVar3.U = false;
            fVar3.V = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class c implements b.h.k.q {
        c() {
        }

        @Override // b.h.k.q
        public c0 a(View view, c0 c0Var) {
            int i2 = c0Var.i();
            int M0 = f.this.M0(c0Var, null);
            if (i2 != M0) {
                c0Var = c0Var.m(c0Var.g(), M0, c0Var.h(), c0Var.f());
            }
            return u.Z(view, c0Var);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class d implements z.a {
        d() {
        }

        @Override // androidx.appcompat.widget.z.a
        public void a(Rect rect) {
            rect.top = f.this.M0(null, rect);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.T();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.f$f  reason: collision with other inner class name */
    /* compiled from: AppCompatDelegateImpl */
    public class RunnableC0009f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        /* compiled from: AppCompatDelegateImpl */
        class a extends a0 {
            a() {
            }

            @Override // b.h.k.z
            public void b(View view) {
                f.this.q.setAlpha(1.0f);
                f.this.t.f(null);
                f.this.t = null;
            }

            @Override // b.h.k.z, b.h.k.a0
            public void c(View view) {
                f.this.q.setVisibility(0);
            }
        }

        RunnableC0009f() {
        }

        public void run() {
            f fVar = f.this;
            fVar.r.showAtLocation(fVar.q, 55, 0, 0);
            f.this.W();
            if (f.this.E0()) {
                f.this.q.setAlpha(Utils.FLOAT_EPSILON);
                f fVar2 = f.this;
                y d2 = u.d(fVar2.q);
                d2.a(1.0f);
                fVar2.t = d2;
                f.this.t.f(new a());
                return;
            }
            f.this.q.setAlpha(1.0f);
            f.this.q.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class g extends a0 {
        g() {
        }

        @Override // b.h.k.z
        public void b(View view) {
            f.this.q.setAlpha(1.0f);
            f.this.t.f(null);
            f.this.t = null;
        }

        @Override // b.h.k.z, b.h.k.a0
        public void c(View view) {
            f.this.q.setVisibility(0);
            f.this.q.sendAccessibilityEvent(32);
            if (f.this.q.getParent() instanceof View) {
                u.j0((View) f.this.q.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl */
    public final class h implements m.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            f.this.M(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback g0 = f.this.g0();
            if (g0 == null) {
                return true;
            }
            g0.onMenuOpened(androidx.constraintlayout.widget.i.H0, gVar);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f182a;

        /* compiled from: AppCompatDelegateImpl */
        class a extends a0 {
            a() {
            }

            @Override // b.h.k.z
            public void b(View view) {
                f.this.q.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.q.getParent() instanceof View) {
                    u.j0((View) f.this.q.getParent());
                }
                f.this.q.removeAllViews();
                f.this.t.f(null);
                f fVar2 = f.this;
                fVar2.t = null;
                u.j0(fVar2.w);
            }
        }

        public i(b.a aVar) {
            this.f182a = aVar;
        }

        @Override // b.a.o.b.a
        public boolean a(b.a.o.b bVar, Menu menu) {
            u.j0(f.this.w);
            return this.f182a.a(bVar, menu);
        }

        @Override // b.a.o.b.a
        public void b(b.a.o.b bVar) {
            this.f182a.b(bVar);
            f fVar = f.this;
            if (fVar.r != null) {
                fVar.f168g.getDecorView().removeCallbacks(f.this.s);
            }
            f fVar2 = f.this;
            if (fVar2.q != null) {
                fVar2.W();
                f fVar3 = f.this;
                y d2 = u.d(fVar3.q);
                d2.a(Utils.FLOAT_EPSILON);
                fVar3.t = d2;
                f.this.t.f(new a());
            }
            f fVar4 = f.this;
            d dVar = fVar4.f170i;
            if (dVar != null) {
                dVar.l(fVar4.p);
            }
            f fVar5 = f.this;
            fVar5.p = null;
            u.j0(fVar5.w);
        }

        @Override // b.a.o.b.a
        public boolean c(b.a.o.b bVar, MenuItem menuItem) {
            return this.f182a.c(bVar, menuItem);
        }

        @Override // b.a.o.b.a
        public boolean d(b.a.o.b bVar, Menu menu) {
            return this.f182a.d(bVar, menu);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl */
    public class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f186c;

        k(Context context) {
            super();
            this.f186c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.appcompat.app.f.l
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            if (Build.VERSION.SDK_INT < 21 || !this.f186c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.G();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f188a;

        /* access modifiers changed from: package-private */
        /* compiled from: AppCompatDelegateImpl */
        public class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                l.this.d();
            }
        }

        l() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f188a;
            if (broadcastReceiver != null) {
                try {
                    f.this.f167f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f188a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f188a == null) {
                    this.f188a = new a();
                }
                f.this.f167f.registerReceiver(this.f188a, b2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl */
    public class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final l f191c;

        m(l lVar) {
            super();
            this.f191c = lVar;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.appcompat.app.f.l
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return this.f191c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.G();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.colorMode & 3;
            int i3 = configuration2.colorMode;
            if (i2 != (i3 & 3)) {
                configuration3.colorMode |= i3 & 3;
            }
            int i4 = configuration.colorMode & 12;
            int i5 = configuration2.colorMode;
            if (i4 != (i5 & 12)) {
                configuration3.colorMode |= i5 & 12;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    private static class q {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl */
    public class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        private boolean c(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.O(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(b.a.k.a.a.d(getContext(), i2));
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: AppCompatDelegateImpl */
    public static final class s {

        /* renamed from: a  reason: collision with root package name */
        int f194a;

        /* renamed from: b  reason: collision with root package name */
        int f195b;

        /* renamed from: c  reason: collision with root package name */
        int f196c;

        /* renamed from: d  reason: collision with root package name */
        int f197d;

        /* renamed from: e  reason: collision with root package name */
        int f198e;

        /* renamed from: f  reason: collision with root package name */
        int f199f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f200g;

        /* renamed from: h  reason: collision with root package name */
        View f201h;

        /* renamed from: i  reason: collision with root package name */
        View f202i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.g f203j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.e f204k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        s(int i2) {
            this.f194a = i2;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f203j == null) {
                return null;
            }
            if (this.f204k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, b.a.g.abc_list_menu_item_layout);
                this.f204k = eVar;
                eVar.k(aVar);
                this.f203j.b(this.f204k);
            }
            return this.f204k.c(this.f200g);
        }

        public boolean b() {
            if (this.f201h == null) {
                return false;
            }
            if (this.f202i == null && this.f204k.a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f203j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.O(this.f204k);
                }
                this.f203j = gVar;
                if (gVar != null && (eVar = this.f204k) != null) {
                    gVar.b(eVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(b.a.a.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(b.a.a.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(b.a.i.Theme_AppCompat_CompactMenu, true);
            }
            b.a.o.d dVar = new b.a.o.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(b.a.j.u0);
            this.f195b = obtainStyledAttributes.getResourceId(b.a.j.x0, 0);
            this.f199f = obtainStyledAttributes.getResourceId(b.a.j.w0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl */
    public final class t implements m.a {
        t() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g D = gVar.D();
            boolean z2 = D != gVar;
            f fVar = f.this;
            if (z2) {
                gVar = D;
            }
            s Z = fVar.Z(gVar);
            if (Z == null) {
                return;
            }
            if (z2) {
                f.this.L(Z.f194a, Z, D);
                f.this.P(Z, true);
                return;
            }
            f.this.P(Z, z);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback g0;
            if (gVar != gVar.D()) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.B || (g0 = fVar.g0()) == null || f.this.N) {
                return true;
            }
            g0.onMenuOpened(androidx.constraintlayout.widget.i.H0, gVar);
            return true;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = false;
        boolean z3 = i2 < 21;
        c0 = z3;
        if (i2 >= 17) {
            z2 = true;
        }
        f0 = z2;
        if (z3 && !g0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    f(Activity activity, d dVar) {
        this(activity, null, dVar, activity);
    }

    private boolean A0(s sVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((sVar.m || B0(sVar, keyEvent)) && (gVar = sVar.f203j) != null) {
            z2 = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.m == null) {
            P(sVar, true);
        }
        return z2;
    }

    private boolean B0(s sVar, KeyEvent keyEvent) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        if (this.N) {
            return false;
        }
        if (sVar.m) {
            return true;
        }
        s sVar2 = this.I;
        if (!(sVar2 == null || sVar2 == sVar)) {
            P(sVar2, false);
        }
        Window.Callback g02 = g0();
        if (g02 != null) {
            sVar.f202i = g02.onCreatePanelView(sVar.f194a);
        }
        int i2 = sVar.f194a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (vVar4 = this.m) != null) {
            vVar4.c();
        }
        if (sVar.f202i == null && (!z2 || !(z0() instanceof j))) {
            androidx.appcompat.view.menu.g gVar = sVar.f203j;
            if (gVar == null || sVar.r) {
                if (gVar == null && (!k0(sVar) || sVar.f203j == null)) {
                    return false;
                }
                if (z2 && (vVar3 = this.m) != null) {
                    if (this.n == null) {
                        this.n = new h();
                    }
                    vVar3.a(sVar.f203j, this.n);
                }
                sVar.f203j.d0();
                if (!g02.onCreatePanelMenu(sVar.f194a, sVar.f203j)) {
                    sVar.c(null);
                    if (z2 && (vVar2 = this.m) != null) {
                        vVar2.a(null, this.n);
                    }
                    return false;
                }
                sVar.r = false;
            }
            sVar.f203j.d0();
            Bundle bundle = sVar.s;
            if (bundle != null) {
                sVar.f203j.P(bundle);
                sVar.s = null;
            }
            if (!g02.onPreparePanel(0, sVar.f202i, sVar.f203j)) {
                if (z2 && (vVar = this.m) != null) {
                    vVar.a(null, this.n);
                }
                sVar.f203j.c0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            sVar.p = z3;
            sVar.f203j.setQwertyMode(z3);
            sVar.f203j.c0();
        }
        sVar.m = true;
        sVar.n = false;
        this.I = sVar;
        return true;
    }

    private void C0(boolean z2) {
        v vVar = this.m;
        if (vVar == null || !vVar.g() || (ViewConfiguration.get(this.f167f).hasPermanentMenuKey() && !this.m.d())) {
            s e02 = e0(0, true);
            e02.q = true;
            P(e02, false);
            y0(e02, null);
            return;
        }
        Window.Callback g02 = g0();
        if (this.m.b() && z2) {
            this.m.e();
            if (!this.N) {
                g02.onPanelClosed(androidx.constraintlayout.widget.i.H0, e0(0, true).f203j);
            }
        } else if (g02 != null && !this.N) {
            if (this.U && (this.V & 1) != 0) {
                this.f168g.getDecorView().removeCallbacks(this.W);
                this.W.run();
            }
            s e03 = e0(0, true);
            androidx.appcompat.view.menu.g gVar = e03.f203j;
            if (gVar != null && !e03.r && g02.onPreparePanel(0, e03.f202i, gVar)) {
                g02.onMenuOpened(androidx.constraintlayout.widget.i.H0, e03.f203j);
                this.m.f();
            }
        }
    }

    private int D0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return androidx.constraintlayout.widget.i.H0;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return androidx.constraintlayout.widget.i.I0;
        }
    }

    private boolean F0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f168g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || u.R((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean H(boolean z2) {
        if (this.N) {
            return false;
        }
        int K2 = K();
        boolean K0 = K0(o0(this.f167f, K2), z2);
        if (K2 == 0) {
            d0(this.f167f).e();
        } else {
            l lVar = this.S;
            if (lVar != null) {
                lVar.a();
            }
        }
        if (K2 == 3) {
            c0(this.f167f).e();
        } else {
            l lVar2 = this.T;
            if (lVar2 != null) {
                lVar2.a();
            }
        }
        return K0;
    }

    private void I() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(16908290);
        View decorView = this.f168g.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f167f.obtainStyledAttributes(b.a.j.u0);
        obtainStyledAttributes.getValue(b.a.j.G0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(b.a.j.H0, contentFrameLayout.getMinWidthMinor());
        int i2 = b.a.j.E0;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = b.a.j.F0;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = b.a.j.C0;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = b.a.j.D0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void I0() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void J(Window window) {
        if (this.f168g == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof j)) {
                j jVar = new j(callback);
                this.f169h = jVar;
                window.setCallback(jVar);
                q0 u2 = q0.u(this.f167f, null, d0);
                Drawable h2 = u2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                u2.w();
                this.f168g = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private c J0() {
        for (Context context = this.f167f; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof c) {
                return (c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int K() {
        int i2 = this.O;
        return i2 != -100 ? i2 : e.j();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean K0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f167f
            r1 = 0
            android.content.res.Configuration r0 = r6.Q(r0, r7, r1)
            boolean r2 = r6.m0()
            android.content.Context r3 = r6.f167f
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L_0x0047
            if (r8 == 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            boolean r8 = r6.K
            if (r8 == 0) goto L_0x0047
            boolean r8 = androidx.appcompat.app.f.e0
            if (r8 != 0) goto L_0x0030
            boolean r8 = r6.L
            if (r8 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r8 = r6.f166e
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0047
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L_0x0047
            java.lang.Object r8 = r6.f166e
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.a.k(r8)
            r8 = 1
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 != 0) goto L_0x0050
            if (r3 == r0) goto L_0x0050
            r6.L0(r0, r2, r1)
            goto L_0x0051
        L_0x0050:
            r4 = r8
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            java.lang.Object r8 = r6.f166e
            boolean r0 = r8 instanceof androidx.appcompat.app.c
            if (r0 == 0) goto L_0x005e
            androidx.appcompat.app.c r8 = (androidx.appcompat.app.c) r8
            r8.O(r7)
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.K0(int, boolean):boolean");
    }

    private void L0(int i2, boolean z2, Configuration configuration) {
        Resources resources = this.f167f.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            i.a(resources);
        }
        int i4 = this.P;
        if (i4 != 0) {
            this.f167f.setTheme(i4);
            if (i3 >= 23) {
                this.f167f.getTheme().applyStyle(this.P, true);
            }
        }
        if (z2) {
            Object obj = this.f166e;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.i) {
                    if (((androidx.lifecycle.i) activity).c().b().a(e.b.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.M) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void N() {
        l lVar = this.S;
        if (lVar != null) {
            lVar.a();
        }
        l lVar2 = this.T;
        if (lVar2 != null) {
            lVar2.a();
        }
    }

    private void N0(View view) {
        int i2;
        if ((u.L(view) & 8192) != 0) {
            i2 = b.h.d.a.b(this.f167f, b.a.c.abc_decor_view_status_guard_light);
        } else {
            i2 = b.h.d.a.b(this.f167f, b.a.c.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i2);
    }

    private Configuration Q(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = Utils.FLOAT_EPSILON;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    private ViewGroup R() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f167f.obtainStyledAttributes(b.a.j.u0);
        int i2 = b.a.j.z0;
        if (obtainStyledAttributes.hasValue(i2)) {
            if (obtainStyledAttributes.getBoolean(b.a.j.I0, false)) {
                z(1);
            } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                z(androidx.constraintlayout.widget.i.H0);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.A0, false)) {
                z(androidx.constraintlayout.widget.i.I0);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.B0, false)) {
                z(10);
            }
            this.E = obtainStyledAttributes.getBoolean(b.a.j.v0, false);
            obtainStyledAttributes.recycle();
            Y();
            this.f168g.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f167f);
            if (this.F) {
                viewGroup = this.D ? (ViewGroup) from.inflate(b.a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(b.a.g.abc_screen_simple, (ViewGroup) null);
            } else if (this.E) {
                viewGroup = (ViewGroup) from.inflate(b.a.g.abc_dialog_title_material, (ViewGroup) null);
                this.C = false;
                this.B = false;
            } else if (this.B) {
                TypedValue typedValue = new TypedValue();
                this.f167f.getTheme().resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new b.a.o.d(this.f167f, typedValue.resourceId);
                } else {
                    context = this.f167f;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(b.a.g.abc_screen_toolbar, (ViewGroup) null);
                v vVar = (v) viewGroup.findViewById(b.a.f.decor_content_parent);
                this.m = vVar;
                vVar.setWindowCallback(g0());
                if (this.C) {
                    this.m.k(androidx.constraintlayout.widget.i.I0);
                }
                if (this.z) {
                    this.m.k(2);
                }
                if (this.A) {
                    this.m.k(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    u.z0(viewGroup, new c());
                } else if (viewGroup instanceof z) {
                    ((z) viewGroup).setOnFitSystemWindowsListener(new d());
                }
                if (this.m == null) {
                    this.x = (TextView) viewGroup.findViewById(b.a.f.title);
                }
                w0.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f168g.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f168g.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void X() {
        if (!this.v) {
            this.w = R();
            CharSequence f02 = f0();
            if (!TextUtils.isEmpty(f02)) {
                v vVar = this.m;
                if (vVar != null) {
                    vVar.setWindowTitle(f02);
                } else if (z0() != null) {
                    z0().B(f02);
                } else {
                    TextView textView = this.x;
                    if (textView != null) {
                        textView.setText(f02);
                    }
                }
            }
            I();
            x0(this.w);
            this.v = true;
            s e02 = e0(0, false);
            if (this.N) {
                return;
            }
            if (e02 == null || e02.f203j == null) {
                l0(androidx.constraintlayout.widget.i.H0);
            }
        }
    }

    private void Y() {
        if (this.f168g == null) {
            Object obj = this.f166e;
            if (obj instanceof Activity) {
                J(((Activity) obj).getWindow());
            }
        }
        if (this.f168g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration a0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = Utils.FLOAT_EPSILON;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                o.a(configuration, configuration2, configuration3);
            } else if (!b.h.j.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                p.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            if (i6 >= 17) {
                n.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private l c0(Context context) {
        if (this.T == null) {
            this.T = new k(context);
        }
        return this.T;
    }

    private l d0(Context context) {
        if (this.S == null) {
            this.S = new m(l.a(context));
        }
        return this.S;
    }

    private void h0() {
        X();
        if (this.B && this.f171j == null) {
            Object obj = this.f166e;
            if (obj instanceof Activity) {
                this.f171j = new m((Activity) this.f166e, this.C);
            } else if (obj instanceof Dialog) {
                this.f171j = new m((Dialog) this.f166e);
            }
            a aVar = this.f171j;
            if (aVar != null) {
                aVar.r(this.X);
            }
        }
    }

    private boolean i0(s sVar) {
        View view = sVar.f202i;
        if (view != null) {
            sVar.f201h = view;
            return true;
        } else if (sVar.f203j == null) {
            return false;
        } else {
            if (this.o == null) {
                this.o = new t();
            }
            View view2 = (View) sVar.a(this.o);
            sVar.f201h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean j0(s sVar) {
        sVar.d(b0());
        sVar.f200g = new r(sVar.l);
        sVar.f196c = 81;
        return true;
    }

    private boolean k0(s sVar) {
        Context context = this.f167f;
        int i2 = sVar.f194a;
        if ((i2 == 0 || i2 == 108) && this.m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                b.a.o.d dVar = new b.a.o.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        sVar.c(gVar);
        return true;
    }

    private void l0(int i2) {
        this.V = (1 << i2) | this.V;
        if (!this.U) {
            u.e0(this.f168g.getDecorView(), this.W);
            this.U = true;
        }
    }

    private boolean m0() {
        if (!this.R && (this.f166e instanceof Activity)) {
            PackageManager packageManager = this.f167f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f167f, this.f166e.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private boolean r0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        s e02 = e0(i2, true);
        if (!e02.o) {
            return B0(e02, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean u0(int r5, android.view.KeyEvent r6) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.u0(int, android.view.KeyEvent):boolean");
    }

    private void y0(s sVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!sVar.o && !this.N) {
            if (sVar.f194a == 0) {
                if ((this.f167f.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback g02 = g0();
            if (g02 == null || g02.onMenuOpened(sVar.f194a, sVar.f203j)) {
                WindowManager windowManager = (WindowManager) this.f167f.getSystemService("window");
                if (windowManager != null && B0(sVar, keyEvent)) {
                    ViewGroup viewGroup = sVar.f200g;
                    if (viewGroup == null || sVar.q) {
                        if (viewGroup == null) {
                            if (!j0(sVar) || sVar.f200g == null) {
                                return;
                            }
                        } else if (sVar.q && viewGroup.getChildCount() > 0) {
                            sVar.f200g.removeAllViews();
                        }
                        if (!i0(sVar) || !sVar.b()) {
                            sVar.q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = sVar.f201h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        sVar.f200g.setBackgroundResource(sVar.f195b);
                        ViewParent parent = sVar.f201h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(sVar.f201h);
                        }
                        sVar.f200g.addView(sVar.f201h, layoutParams2);
                        if (!sVar.f201h.hasFocus()) {
                            sVar.f201h.requestFocus();
                        }
                    } else {
                        View view = sVar.f202i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i2 = -1;
                            sVar.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, sVar.f197d, sVar.f198e, 1002, 8519680, -3);
                            layoutParams3.gravity = sVar.f196c;
                            layoutParams3.windowAnimations = sVar.f199f;
                            windowManager.addView(sVar.f200g, layoutParams3);
                            sVar.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    sVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, sVar.f197d, sVar.f198e, 1002, 8519680, -3);
                    layoutParams32.gravity = sVar.f196c;
                    layoutParams32.windowAnimations = sVar.f199f;
                    windowManager.addView(sVar.f200g, layoutParams32);
                    sVar.o = true;
                    return;
                }
                return;
            }
            P(sVar, true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void A(int i2) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f167f).inflate(i2, viewGroup);
        this.f169h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void B(View view) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f169h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f169h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void D(Toolbar toolbar) {
        if (this.f166e instanceof Activity) {
            a m2 = m();
            if (!(m2 instanceof m)) {
                this.f172k = null;
                if (m2 != null) {
                    m2.n();
                }
                if (toolbar != null) {
                    j jVar = new j(toolbar, f0(), this.f169h);
                    this.f171j = jVar;
                    this.f168g.setCallback(jVar.E());
                } else {
                    this.f171j = null;
                    this.f168g.setCallback(this.f169h);
                }
                o();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // androidx.appcompat.app.e
    public void E(int i2) {
        this.P = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean E0() {
        ViewGroup viewGroup;
        return this.v && (viewGroup = this.w) != null && u.S(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public final void F(CharSequence charSequence) {
        this.l = charSequence;
        v vVar = this.m;
        if (vVar != null) {
            vVar.setWindowTitle(charSequence);
        } else if (z0() != null) {
            z0().B(charSequence);
        } else {
            TextView textView = this.x;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public boolean G() {
        return H(true);
    }

    public b.a.o.b G0(b.a aVar) {
        d dVar;
        if (aVar != null) {
            b.a.o.b bVar = this.p;
            if (bVar != null) {
                bVar.c();
            }
            i iVar = new i(aVar);
            a m2 = m();
            if (m2 != null) {
                b.a.o.b C2 = m2.C(iVar);
                this.p = C2;
                if (!(C2 == null || (dVar = this.f170i) == null)) {
                    dVar.j(C2);
                }
            }
            if (this.p == null) {
                this.p = H0(iVar);
            }
            return this.p;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b.a.o.b H0(b.a.o.b.a r8) {
        /*
        // Method dump skipped, instructions count: 367
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.H0(b.a.o.b$a):b.a.o.b");
    }

    /* access modifiers changed from: package-private */
    public void L(int i2, s sVar, Menu menu) {
        if (menu == null) {
            if (sVar == null && i2 >= 0) {
                s[] sVarArr = this.H;
                if (i2 < sVarArr.length) {
                    sVar = sVarArr[i2];
                }
            }
            if (sVar != null) {
                menu = sVar.f203j;
            }
        }
        if ((sVar == null || sVar.o) && !this.N) {
            this.f169h.a().onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void M(androidx.appcompat.view.menu.g gVar) {
        if (!this.G) {
            this.G = true;
            this.m.l();
            Window.Callback g02 = g0();
            if (g02 != null && !this.N) {
                g02.onPanelClosed(androidx.constraintlayout.widget.i.H0, gVar);
            }
            this.G = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int M0(c0 c0Var, Rect rect) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i5;
        int i6 = 0;
        if (c0Var != null) {
            i2 = c0Var.i();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            boolean z4 = true;
            if (this.q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect2 = this.Y;
                Rect rect3 = this.Z;
                if (c0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c0Var.g(), c0Var.i(), c0Var.h(), c0Var.f());
                }
                w0.a(this.w, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                c0 I2 = u.I(this.w);
                if (I2 == null) {
                    i3 = 0;
                } else {
                    i3 = I2.g();
                }
                if (I2 == null) {
                    i4 = 0;
                } else {
                    i4 = I2.h();
                }
                if (marginLayoutParams2.topMargin == i7 && marginLayoutParams2.leftMargin == i8 && marginLayoutParams2.rightMargin == i9) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i7;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i9;
                    z3 = true;
                }
                if (i7 <= 0 || this.y != null) {
                    View view = this.y;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i5 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4))) {
                        marginLayoutParams.height = i5;
                        marginLayoutParams.leftMargin = i3;
                        marginLayoutParams.rightMargin = i4;
                        this.y.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f167f);
                    this.y = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i3;
                    layoutParams.rightMargin = i4;
                    this.w.addView(this.y, -1, layoutParams);
                }
                View view3 = this.y;
                if (view3 == null) {
                    z4 = false;
                }
                if (z4 && view3.getVisibility() != 0) {
                    N0(this.y);
                }
                if (!this.D && z4) {
                    i2 = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.q.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.y;
        if (view4 != null) {
            if (!z2) {
                i6 = 8;
            }
            view4.setVisibility(i6);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void O(int i2) {
        P(e0(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void P(s sVar, boolean z2) {
        ViewGroup viewGroup;
        v vVar;
        if (!z2 || sVar.f194a != 0 || (vVar = this.m) == null || !vVar.b()) {
            WindowManager windowManager = (WindowManager) this.f167f.getSystemService("window");
            if (!(windowManager == null || !sVar.o || (viewGroup = sVar.f200g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    L(sVar.f194a, sVar, null);
                }
            }
            sVar.m = false;
            sVar.n = false;
            sVar.o = false;
            sVar.f201h = null;
            sVar.q = true;
            if (this.I == sVar) {
                this.I = null;
                return;
            }
            return;
        }
        M(sVar.f203j);
    }

    public View S(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.a0 == null) {
            String string = this.f167f.obtainStyledAttributes(b.a.j.u0).getString(b.a.j.y0);
            if (string == null) {
                this.a0 = new h();
            } else {
                try {
                    this.a0 = (h) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.a0 = new h();
                }
            }
        }
        boolean z4 = c0;
        if (z4) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = F0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.a0.q(view, str, context, attributeSet, z2, z4, true, v0.b());
    }

    /* access modifiers changed from: package-private */
    public void T() {
        androidx.appcompat.view.menu.g gVar;
        v vVar = this.m;
        if (vVar != null) {
            vVar.l();
        }
        if (this.r != null) {
            this.f168g.getDecorView().removeCallbacks(this.s);
            if (this.r.isShowing()) {
                try {
                    this.r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.r = null;
        }
        W();
        s e02 = e0(0, false);
        if (e02 != null && (gVar = e02.f203j) != null) {
            gVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean U(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f166e;
        boolean z2 = true;
        if (((obj instanceof f.a) || (obj instanceof g)) && (decorView = this.f168g.getDecorView()) != null && b.h.k.f.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f169h.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? q0(keyCode, keyEvent) : t0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void V(int i2) {
        s e02;
        s e03 = e0(i2, true);
        if (e03.f203j != null) {
            Bundle bundle = new Bundle();
            e03.f203j.Q(bundle);
            if (bundle.size() > 0) {
                e03.s = bundle;
            }
            e03.f203j.d0();
            e03.f203j.clear();
        }
        e03.r = true;
        e03.q = true;
        if ((i2 == 108 || i2 == 0) && this.m != null && (e02 = e0(0, false)) != null) {
            e02.m = false;
            B0(e02, null);
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        y yVar = this.t;
        if (yVar != null) {
            yVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public s Z(Menu menu) {
        s[] sVarArr = this.H;
        int length = sVarArr != null ? sVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            s sVar = sVarArr[i2];
            if (sVar != null && sVar.f203j == menu) {
                return sVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        s Z2;
        Window.Callback g02 = g0();
        if (g02 == null || this.N || (Z2 = Z(gVar.D())) == null) {
            return false;
        }
        return g02.onMenuItemSelected(Z2.f194a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        C0(true);
    }

    /* access modifiers changed from: package-private */
    public final Context b0() {
        a m2 = m();
        Context k2 = m2 != null ? m2.k() : null;
        return k2 == null ? this.f167f : k2;
    }

    @Override // androidx.appcompat.app.e
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ((ViewGroup) this.w.findViewById(16908290)).addView(view, layoutParams);
        this.f169h.a().onContentChanged();
    }

    /* access modifiers changed from: protected */
    public s e0(int i2, boolean z2) {
        s[] sVarArr = this.H;
        if (sVarArr == null || sVarArr.length <= i2) {
            s[] sVarArr2 = new s[(i2 + 1)];
            if (sVarArr != null) {
                System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
            }
            this.H = sVarArr2;
            sVarArr = sVarArr2;
        }
        s sVar = sVarArr[i2];
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(i2);
        sVarArr[i2] = sVar2;
        return sVar2;
    }

    @Override // androidx.appcompat.app.e
    public Context f(Context context) {
        boolean z2 = true;
        this.K = true;
        int o0 = o0(context, K());
        Configuration configuration = null;
        if (f0 && (context instanceof ContextThemeWrapper)) {
            try {
                q.a((ContextThemeWrapper) context, Q(context, o0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof b.a.o.d) {
            try {
                ((b.a.o.d) context).a(Q(context, o0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!e0) {
            super.f(context);
            return context;
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = a0(configuration2, configuration3);
            }
            Configuration Q2 = Q(context, o0, configuration);
            b.a.o.d dVar = new b.a.o.d(context, b.a.i.Theme_AppCompat_Empty);
            dVar.a(Q2);
            boolean z3 = false;
            try {
                if (context.getTheme() == null) {
                    z2 = false;
                }
                z3 = z2;
            } catch (NullPointerException unused3) {
            }
            if (z3) {
                f.b.a(dVar.getTheme());
            }
            super.f(dVar);
            return dVar;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence f0() {
        Object obj = this.f166e;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback g0() {
        return this.f168g.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T i(int i2) {
        X();
        return (T) this.f168g.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public int k() {
        return this.O;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater l() {
        if (this.f172k == null) {
            h0();
            a aVar = this.f171j;
            this.f172k = new b.a.o.g(aVar != null ? aVar.k() : this.f167f);
        }
        return this.f172k;
    }

    @Override // androidx.appcompat.app.e
    public a m() {
        h0();
        return this.f171j;
    }

    @Override // androidx.appcompat.app.e
    public void n() {
        LayoutInflater from = LayoutInflater.from(this.f167f);
        if (from.getFactory() == null) {
            b.h.k.g.b(from, this);
        } else if (!(from.getFactory2() instanceof f)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public boolean n0() {
        return this.u;
    }

    @Override // androidx.appcompat.app.e
    public void o() {
        a m2 = m();
        if (m2 == null || !m2.l()) {
            l0(0);
        }
    }

    /* access modifiers changed from: package-private */
    public int o0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        return c0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return d0(context).c();
            } else {
                return -1;
            }
        }
        return i2;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return S(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public void p(Configuration configuration) {
        a m2;
        if (this.B && this.v && (m2 = m()) != null) {
            m2.m(configuration);
        }
        androidx.appcompat.widget.h.b().g(this.f167f);
        H(false);
    }

    /* access modifiers changed from: package-private */
    public boolean p0() {
        b.a.o.b bVar = this.p;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a m2 = m();
        if (m2 == null || !m2.h()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void q(Bundle bundle) {
        this.K = true;
        H(false);
        Y();
        Object obj = this.f166e;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a z0 = z0();
                if (z0 == null) {
                    this.X = true;
                } else {
                    z0.r(true);
                }
            }
            e.c(this);
        }
        this.L = true;
    }

    /* access modifiers changed from: package-private */
    public boolean q0(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.J = z2;
        } else if (i2 == 82) {
            r0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    @Override // androidx.appcompat.app.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f166e
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.e.x(r3)
        L_0x0009:
            boolean r0 = r3.U
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f168g
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.W
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 0
            r3.M = r0
            r0 = 1
            r3.N = r0
            int r0 = r3.O
            r1 = -100
            if (r0 == r1) goto L_0x0048
            java.lang.Object r0 = r3.f166e
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0048
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0048
            b.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.b0
            java.lang.Object r1 = r3.f166e
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.O
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0057
        L_0x0048:
            b.e.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.b0
            java.lang.Object r1 = r3.f166e
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0057:
            androidx.appcompat.app.a r0 = r3.f171j
            if (r0 == 0) goto L_0x005e
            r0.n()
        L_0x005e:
            r3.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.r():void");
    }

    @Override // androidx.appcompat.app.e
    public void s(Bundle bundle) {
        X();
    }

    /* access modifiers changed from: package-private */
    public boolean s0(int i2, KeyEvent keyEvent) {
        a m2 = m();
        if (m2 != null && m2.o(i2, keyEvent)) {
            return true;
        }
        s sVar = this.I;
        if (sVar == null || !A0(sVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.I == null) {
                s e02 = e0(0, true);
                B0(e02, keyEvent);
                boolean A0 = A0(e02, keyEvent.getKeyCode(), keyEvent, 1);
                e02.m = false;
                if (A0) {
                    return true;
                }
            }
            return false;
        }
        s sVar2 = this.I;
        if (sVar2 != null) {
            sVar2.n = true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        a m2 = m();
        if (m2 != null) {
            m2.y(true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean t0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.J;
            this.J = false;
            s e02 = e0(0, false);
            if (e02 != null && e02.o) {
                if (!z2) {
                    P(e02, true);
                }
                return true;
            } else if (p0()) {
                return true;
            }
        } else if (i2 == 82) {
            u0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void u(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        this.M = true;
        G();
    }

    /* access modifiers changed from: package-private */
    public void v0(int i2) {
        a m2;
        if (i2 == 108 && (m2 = m()) != null) {
            m2.i(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void w() {
        this.M = false;
        a m2 = m();
        if (m2 != null) {
            m2.y(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void w0(int i2) {
        if (i2 == 108) {
            a m2 = m();
            if (m2 != null) {
                m2.i(false);
            }
        } else if (i2 == 0) {
            s e02 = e0(i2, true);
            if (e02.o) {
                P(e02, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public boolean z(int i2) {
        int D0 = D0(i2);
        if (this.F && D0 == 108) {
            return false;
        }
        if (this.B && D0 == 1) {
            this.B = false;
        }
        if (D0 == 1) {
            I0();
            this.F = true;
            return true;
        } else if (D0 == 2) {
            I0();
            this.z = true;
            return true;
        } else if (D0 == 5) {
            I0();
            this.A = true;
            return true;
        } else if (D0 == 10) {
            I0();
            this.D = true;
            return true;
        } else if (D0 == 108) {
            I0();
            this.B = true;
            return true;
        } else if (D0 != 109) {
            return this.f168g.requestFeature(D0);
        } else {
            I0();
            this.C = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final a z0() {
        return this.f171j;
    }

    f(Dialog dialog, d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private f(Context context, Window window, d dVar, Object obj) {
        b.e.g<String, Integer> gVar;
        Integer num;
        c J0;
        this.t = null;
        this.u = true;
        this.O = -100;
        this.W = new b();
        this.f167f = context;
        this.f170i = dVar;
        this.f166e = obj;
        if ((obj instanceof Dialog) && (J0 = J0()) != null) {
            this.O = J0.L().k();
        }
        if (this.O == -100 && (num = (gVar = b0).get(obj.getClass().getName())) != null) {
            this.O = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            J(window);
        }
        androidx.appcompat.widget.h.h();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl */
    public class j extends b.a.o.i {
        j(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.f167f, callback);
            b.a.o.b G0 = f.this.G0(aVar);
            if (G0 != null) {
                return aVar.e(G0);
            }
            return null;
        }

        @Override // b.a.o.i
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // b.a.o.i
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.s0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // b.a.o.i
        public void onContentChanged() {
        }

        @Override // b.a.o.i
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // b.a.o.i
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            f.this.v0(i2);
            return true;
        }

        @Override // b.a.o.i
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            f.this.w0(i2);
        }

        @Override // b.a.o.i
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.a0(false);
            }
            return onPreparePanel;
        }

        @Override // b.a.o.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            androidx.appcompat.view.menu.g gVar;
            s e0 = f.this.e0(0, true);
            if (e0 == null || (gVar = e0.f203j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i2);
            }
        }

        @Override // b.a.o.i
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (f.this.n0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // b.a.o.i
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!f.this.n0() || i2 != 0) {
                return super.onWindowStartingActionMode(callback, i2);
            }
            return b(callback);
        }
    }
}
