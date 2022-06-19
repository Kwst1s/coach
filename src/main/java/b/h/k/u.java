package b.h.k;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.h.k.a;
import b.h.k.d0.c;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* compiled from: ViewCompat */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f2672a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static Field f2673b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2674c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2675d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2676e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f2677f;

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, y> f2678g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Field f2679h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2680i = false;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal<Rect> f2681j;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f2682k = {b.h.b.accessibility_custom_action_0, b.h.b.accessibility_custom_action_1, b.h.b.accessibility_custom_action_2, b.h.b.accessibility_custom_action_3, b.h.b.accessibility_custom_action_4, b.h.b.accessibility_custom_action_5, b.h.b.accessibility_custom_action_6, b.h.b.accessibility_custom_action_7, b.h.b.accessibility_custom_action_8, b.h.b.accessibility_custom_action_9, b.h.b.accessibility_custom_action_10, b.h.b.accessibility_custom_action_11, b.h.b.accessibility_custom_action_12, b.h.b.accessibility_custom_action_13, b.h.b.accessibility_custom_action_14, b.h.b.accessibility_custom_action_15, b.h.b.accessibility_custom_action_16, b.h.b.accessibility_custom_action_17, b.h.b.accessibility_custom_action_18, b.h.b.accessibility_custom_action_19, b.h.b.accessibility_custom_action_20, b.h.b.accessibility_custom_action_21, b.h.b.accessibility_custom_action_22, b.h.b.accessibility_custom_action_23, b.h.b.accessibility_custom_action_24, b.h.b.accessibility_custom_action_25, b.h.b.accessibility_custom_action_26, b.h.b.accessibility_custom_action_27, b.h.b.accessibility_custom_action_28, b.h.b.accessibility_custom_action_29, b.h.b.accessibility_custom_action_30, b.h.b.accessibility_custom_action_31};

    /* access modifiers changed from: package-private */
    /* compiled from: ViewCompat */
    public class a extends f<Boolean> {
        a(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewCompat */
    public class b extends f<CharSequence> {
        b(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewCompat */
    public class c extends f<CharSequence> {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewCompat */
    public class d extends f<Boolean> {
        d(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: ViewCompat */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2683b = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                u.W(view, z2 ? 16 : 32);
                this.f2683b.put(view, Boolean.valueOf(z2));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f2683b.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewCompat */
    public static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f2684a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f2685b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2686c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2687d;

        f(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f2686c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract T d(View view);

        /* access modifiers changed from: package-private */
        public abstract void e(View view, T t);

        /* access modifiers changed from: package-private */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t = (T) view.getTag(this.f2684a);
            if (this.f2685b.isInstance(t)) {
                return t;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(View view, T t) {
            if (c()) {
                e(view, t);
            } else if (b() && h(f(view), t)) {
                u.E(view);
                view.setTag(this.f2684a, t);
                u.W(view, this.f2687d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h(T t, T t2);

        f(int i2, Class<T> cls, int i3, int i4) {
            this.f2684a = i2;
            this.f2685b = cls;
            this.f2687d = i3;
            this.f2686c = i4;
        }
    }

    /* compiled from: ViewCompat */
    private static class g {

        /* access modifiers changed from: package-private */
        /* compiled from: ViewCompat */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            c0 f2688a = null;

            /* renamed from: b  reason: collision with root package name */
            WindowInsets f2689b = null;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f2690c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ q f2691d;

            a(View view, q qVar) {
                this.f2690c = view;
                this.f2691d = qVar;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                c0 r = c0.r(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    g.a(windowInsets, this.f2690c);
                    if (r.equals(this.f2688a)) {
                        return this.f2689b;
                    }
                    this.f2688a = r;
                }
                c0 a2 = this.f2691d.a(view, r);
                if (i2 >= 30) {
                    return a2.p();
                }
                u.j0(view);
                WindowInsets p = a2.p();
                this.f2689b = p;
                return p;
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(b.h.b.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static c0 b(View view, c0 c0Var, Rect rect) {
            WindowInsets p = c0Var.p();
            if (p != null) {
                return c0.r(view.computeSystemWindowInsets(p, rect), view);
            }
            rect.setEmpty();
            return c0Var;
        }

        static void c(View view, q qVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(b.h.b.tag_on_apply_window_listener, qVar);
            }
            if (qVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(b.h.b.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, qVar));
            }
        }
    }

    /* compiled from: ViewCompat */
    private static class h {
        public static c0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            c0 q = c0.q(rootWindowInsets);
            q.o(q);
            q.d(view.getRootView());
            return q;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ViewCompat */
    public static class i {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    /* compiled from: ViewCompat */
    public interface j {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat */
    static class k {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f2692d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2693a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f2694b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f2695c = null;

        k() {
        }

        static k a(View view) {
            int i2 = b.h.b.tag_unhandled_key_event_manager;
            k kVar = (k) view.getTag(i2);
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k();
            view.setTag(i2, kVar2);
            return kVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2693a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f2694b == null) {
                this.f2694b = new SparseArray<>();
            }
            return this.f2694b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(b.h.b.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((j) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2693a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f2692d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f2693a == null) {
                        this.f2693a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f2692d;
                        View view = arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f2693a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2693a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c2));
                }
            }
            return c2 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f2695c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2695c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> d2 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d2.valueAt(indexOfKey);
                d2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && u.R(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    static {
        new e();
    }

    @SuppressLint({"InlinedApi"})
    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void A0(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void B0(View view, s sVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (sVar != null ? sVar.a() : null));
        }
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2676e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f2675d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2676e = true;
        }
        Field field = f2675d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void C0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f2674c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f2673b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2674c = true;
        }
        Field field = f2673b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void D0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2677f == null) {
            f2677f = new WeakHashMap<>();
        }
        f2677f.put(view, str);
    }

    static a E(View view) {
        a l = l(view);
        if (l == null) {
            l = new a();
        }
        m0(view, l);
        return l;
    }

    @Deprecated
    public static void E0(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static int F(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    private static void F0(View view) {
        if (z(view) == 0) {
            x0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (z((View) parent) == 4) {
                x0(view, 2);
                return;
            }
        }
    }

    public static int G(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    private static f<CharSequence> G0() {
        return new c(b.h.b.tag_state_description, CharSequence.class, 64, 30);
    }

    public static ViewParent H(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static void H0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof k) {
            ((k) view).stopNestedScroll();
        }
    }

    public static c0 I(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return h.a(view);
        }
        return null;
    }

    private static void I0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static final CharSequence J(View view) {
        return G0().f(view);
    }

    public static String K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f2677f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int L(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float M(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getZ() : Utils.FLOAT_EPSILON;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean P(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean Q(View view) {
        Boolean f2 = a().f(view);
        if (f2 == null) {
            return false;
        }
        return f2.booleanValue();
    }

    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof k) {
            return ((k) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean U(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean V(View view) {
        Boolean f2 = l0().f(view);
        if (f2 == null) {
            return false;
        }
        return f2.booleanValue();
    }

    static void W(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = p(view) != null && view.getVisibility() == 0;
            int i3 = 32;
            if (o(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                obtain.setContentChangeTypes(i2);
                if (z) {
                    obtain.getText().add(p(view));
                    F0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void X(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect x = x();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                x.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !x.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            e(view, i2);
            if (z && x.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(x);
            }
        } else {
            e(view, i2);
        }
    }

    public static void Y(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect x = x();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                x.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !x.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, i2);
            if (z && x.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(x);
            }
        } else {
            f(view, i2);
        }
    }

    public static c0 Z(View view, c0 c0Var) {
        WindowInsets p;
        if (Build.VERSION.SDK_INT >= 21 && (p = c0Var.p()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(p);
            if (!onApplyWindowInsets.equals(p)) {
                return c0.r(onApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    private static f<Boolean> a() {
        return new d(b.h.b.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void a0(View view, b.h.k.d0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.D0());
    }

    public static int b(View view, CharSequence charSequence, b.h.k.d0.f fVar) {
        int r = r(view);
        if (r != -1) {
            c(view, new c.a(r, charSequence, fVar));
        }
        return r;
    }

    private static f<CharSequence> b0() {
        return new b(b.h.b.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    private static void c(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            E(view);
            h0(aVar.b(), view);
            q(view).add(aVar);
            W(view, 0);
        }
    }

    public static boolean c0(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static y d(View view) {
        if (f2678g == null) {
            f2678g = new WeakHashMap<>();
        }
        y yVar = f2678g.get(view);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(view);
        f2678g.put(view, yVar2);
        return yVar2;
    }

    public static void d0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    private static void e(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            I0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                I0((View) parent);
            }
        }
    }

    public static void e0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    private static void f(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            I0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                I0((View) parent);
            }
        }
    }

    public static void f0(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static c0 g(View view, c0 c0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? g.b(view, c0Var, rect) : c0Var;
    }

    public static void g0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            h0(i2, view);
            W(view, 0);
        }
    }

    public static c0 h(View view, c0 c0Var) {
        WindowInsets p;
        if (Build.VERSION.SDK_INT >= 21 && (p = c0Var.p()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(p);
            if (!dispatchApplyWindowInsets.equals(p)) {
                return c0.r(dispatchApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    private static void h0(int i2, View view) {
        List<c.a> q = q(view);
        for (int i3 = 0; i3 < q.size(); i3++) {
            if (q.get(i3).b() == i2) {
                q.remove(i3);
                return;
            }
        }
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).b(view, keyEvent);
    }

    public static void i0(View view, c.a aVar, CharSequence charSequence, b.h.k.d0.f fVar) {
        if (fVar == null && charSequence == null) {
            g0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, fVar));
        }
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).f(keyEvent);
    }

    public static void j0(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static int k() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f2672a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static void k0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            i.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static a l(View view) {
        View.AccessibilityDelegate m = m(view);
        if (m == null) {
            return null;
        }
        if (m instanceof a.C0046a) {
            return ((a.C0046a) m).f2594a;
        }
        return new a(m);
    }

    private static f<Boolean> l0() {
        return new a(b.h.b.tag_screen_reader_focusable, Boolean.class, 28);
    }

    private static View.AccessibilityDelegate m(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return n(view);
    }

    public static void m0(View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (m(view) instanceof a.C0046a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.d();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    private static View.AccessibilityDelegate n(View view) {
        if (f2680i) {
            return null;
        }
        if (f2679h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2679h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2680i = true;
                return null;
            }
        }
        try {
            Object obj = f2679h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2680i = true;
            return null;
        }
    }

    public static void n0(View view, boolean z) {
        a().g(view, Boolean.valueOf(z));
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void o0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static CharSequence p(View view) {
        return b0().f(view);
    }

    @Deprecated
    public static void p0(View view, float f2) {
        view.setAlpha(f2);
    }

    private static List<c.a> q(View view) {
        int i2 = b.h.b.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static void q0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static int r(View view) {
        List<c.a> q = q(view);
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int[] iArr = f2682k;
            if (i2 >= iArr.length || i3 != -1) {
                return i3;
            }
            int i4 = iArr[i2];
            boolean z = true;
            for (int i5 = 0; i5 < q.size(); i5++) {
                z &= q.get(i5).b() != i4;
            }
            if (z) {
                i3 = i4;
            }
            i2++;
        }
        return i3;
    }

    public static void r0(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static ColorStateList s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void s0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static PorterDuff.Mode t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void t0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static void u0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static Display v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (R(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    @Deprecated
    public static void v0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static float w(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getElevation() : Utils.FLOAT_EPSILON;
    }

    public static void w0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    private static Rect x() {
        if (f2681j == null) {
            f2681j = new ThreadLocal<>();
        }
        Rect rect = f2681j.get();
        if (rect == null) {
            rect = new Rect();
            f2681j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void y0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void z0(View view, q qVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            g.c(view, qVar);
        }
    }
}
