package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.c0;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler t = new Handler(Looper.getMainLooper(), new j());
    private static final boolean u;
    private static final int[] v = {c.e.a.b.b.snackbarStyle};
    private static final String w = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f7868a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7869b;

    /* renamed from: c  reason: collision with root package name */
    protected final v f7870c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7871d;

    /* renamed from: e  reason: collision with root package name */
    private int f7872e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7873f;

    /* renamed from: g  reason: collision with root package name */
    private View f7874g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7875h = false;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f7876i = new k();

    /* renamed from: j  reason: collision with root package name */
    private Rect f7877j;

    /* renamed from: k  reason: collision with root package name */
    private int f7878k;
    private int l;
    private int m;
    private int n;
    private int o;
    private List<r<B>> p;
    private Behavior q;
    private final AccessibilityManager r;
    b.AbstractC0156b s = new n();

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k  reason: collision with root package name */
        private final s f7879k = new s(this);

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f7879k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f7879k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f7879k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public void run() {
            v vVar = BaseTransientBottomBar.this.f7870c;
            if (vVar != null) {
                vVar.setVisibility(0);
                if (BaseTransientBottomBar.this.f7870c.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.P();
                } else {
                    BaseTransientBottomBar.this.R();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7882b;

        c(int i2) {
            this.f7882b = i2;
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.f7882b);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f7870c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f7870c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f7870c.setScaleY(floatValue);
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f7871d.a(70, 180);
        }
    }

    /* access modifiers changed from: package-private */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private int f7887b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f7888c;

        g(int i2) {
            this.f7888c = i2;
            this.f7887b = i2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                b.h.k.u.Y(BaseTransientBottomBar.this.f7870c, intValue - this.f7887b);
            } else {
                BaseTransientBottomBar.this.f7870c.setTranslationY((float) intValue);
            }
            this.f7887b = intValue;
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7890b;

        h(int i2) {
            this.f7890b = i2;
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.f7890b);
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f7871d.b(0, 180);
        }
    }

    /* access modifiers changed from: package-private */
    public class i implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private int f7892b = 0;

        i() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                b.h.k.u.Y(BaseTransientBottomBar.this.f7870c, intValue - this.f7892b);
            } else {
                BaseTransientBottomBar.this.f7870c.setTranslationY((float) intValue);
            }
            this.f7892b = intValue;
        }
    }

    static class j implements Handler.Callback {
        j() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).N();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).D(message.arg1);
                return true;
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            int y;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f7870c != null && baseTransientBottomBar.f7869b != null && (y = (BaseTransientBottomBar.this.y() - BaseTransientBottomBar.this.B()) + ((int) BaseTransientBottomBar.this.f7870c.getTranslationY())) < BaseTransientBottomBar.this.n) {
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f7870c.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(BaseTransientBottomBar.w, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.n - y;
                BaseTransientBottomBar.this.f7870c.requestLayout();
            }
        }
    }

    class l implements b.h.k.q {
        l() {
        }

        @Override // b.h.k.q
        public c0 a(View view, c0 c0Var) {
            BaseTransientBottomBar.this.f7878k = c0Var.f();
            BaseTransientBottomBar.this.l = c0Var.g();
            BaseTransientBottomBar.this.m = c0Var.h();
            BaseTransientBottomBar.this.T();
            return c0Var;
        }
    }

    class m extends b.h.k.a {
        m() {
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            cVar.a(1048576);
            cVar.f0(true);
        }

        @Override // b.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.j(view, i2, bundle);
            }
            BaseTransientBottomBar.this.s();
            return true;
        }
    }

    class n implements b.AbstractC0156b {
        n() {
        }

        @Override // com.google.android.material.snackbar.b.AbstractC0156b
        public void a() {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.AbstractC0156b
        public void b(int i2) {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    }

    /* access modifiers changed from: package-private */
    public class o implements t {

        class a implements Runnable {
            a() {
            }

            public void run() {
                BaseTransientBottomBar.this.G(3);
            }
        }

        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f7870c.getRootWindowInsets()) != null) {
                BaseTransientBottomBar.this.n = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                BaseTransientBottomBar.this.T();
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.E()) {
                BaseTransientBottomBar.t.post(new a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class p implements u {
        p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.f7870c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.O();
        }
    }

    /* access modifiers changed from: package-private */
    public class q implements SwipeDismissBehavior.c {
        q() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(int i2) {
            if (i2 == 0) {
                b.c().k(BaseTransientBottomBar.this.s);
            } else if (i2 == 1 || i2 == 2) {
                b.c().j(BaseTransientBottomBar.this.s);
            }
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.t(0);
        }
    }

    public static abstract class r<B> {
        public void a(B b2, int i2) {
        }

        public void b(B b2) {
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        private b.AbstractC0156b f7902a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    b.c().k(this.f7902a);
                }
            } else if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                b.c().j(this.f7902a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f7902a = baseTransientBottomBar.s;
        }
    }

    /* access modifiers changed from: protected */
    public interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* access modifiers changed from: protected */
    public interface u {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    /* access modifiers changed from: protected */
    public static class v extends FrameLayout {

        /* renamed from: i  reason: collision with root package name */
        private static final View.OnTouchListener f7903i = new a();

        /* renamed from: b  reason: collision with root package name */
        private u f7904b;

        /* renamed from: c  reason: collision with root package name */
        private t f7905c;

        /* renamed from: d  reason: collision with root package name */
        private int f7906d;

        /* renamed from: e  reason: collision with root package name */
        private final float f7907e;

        /* renamed from: f  reason: collision with root package name */
        private final float f7908f;

        /* renamed from: g  reason: collision with root package name */
        private ColorStateList f7909g;

        /* renamed from: h  reason: collision with root package name */
        private PorterDuff.Mode f7910h;

        static class a implements View.OnTouchListener {
            a() {
            }

            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected v(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, c.e.a.b.l.F2);
            int i2 = c.e.a.b.l.M2;
            if (obtainStyledAttributes.hasValue(i2)) {
                b.h.k.u.u0(this, (float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.f7906d = obtainStyledAttributes.getInt(c.e.a.b.l.I2, 0);
            this.f7907e = obtainStyledAttributes.getFloat(c.e.a.b.l.J2, 1.0f);
            setBackgroundTintList(c.e.a.b.z.c.a(context2, obtainStyledAttributes, c.e.a.b.l.K2));
            setBackgroundTintMode(com.google.android.material.internal.k.e(obtainStyledAttributes.getInt(c.e.a.b.l.L2, -1), PorterDuff.Mode.SRC_IN));
            this.f7908f = obtainStyledAttributes.getFloat(c.e.a.b.l.H2, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f7903i);
            setFocusable(true);
            if (getBackground() == null) {
                b.h.k.u.q0(this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(c.e.a.b.d.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(c.e.a.b.s.a.g(this, c.e.a.b.b.colorSurface, c.e.a.b.b.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f7909g == null) {
                return androidx.core.graphics.drawable.a.r(gradientDrawable);
            }
            Drawable r = androidx.core.graphics.drawable.a.r(gradientDrawable);
            androidx.core.graphics.drawable.a.o(r, this.f7909g);
            return r;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.f7908f;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.f7906d;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.f7907e;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.f7905c;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            b.h.k.u.j0(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.f7905c;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            u uVar = this.f7904b;
            if (uVar != null) {
                uVar.a(this, i2, i3, i4, i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i2) {
            this.f7906d = i2;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f7909g == null)) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.f7909g);
                androidx.core.graphics.drawable.a.p(drawable, this.f7910h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f7909g = colorStateList;
            if (getBackground() != null) {
                Drawable r = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(r, colorStateList);
                androidx.core.graphics.drawable.a.p(r, this.f7910h);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f7910h = mode;
            if (getBackground() != null) {
                Drawable r = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(r, mode);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(t tVar) {
            this.f7905c = tVar;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f7903i);
            super.setOnClickListener(onClickListener);
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(u uVar) {
            this.f7904b = uVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        u = i2 >= 16 && i2 <= 19;
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f7868a = viewGroup;
            this.f7871d = aVar;
            Context context = viewGroup.getContext();
            this.f7869b = context;
            com.google.android.material.internal.j.a(context);
            v vVar = (v) LayoutInflater.from(context).inflate(z(), viewGroup, false);
            this.f7870c = vVar;
            if (view instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) view).c(vVar.getActionTextColorAlpha());
            }
            vVar.addView(view);
            ViewGroup.LayoutParams layoutParams = vVar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f7877j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            b.h.k.u.o0(vVar, 1);
            b.h.k.u.x0(vVar, 1);
            b.h.k.u.v0(vVar, true);
            b.h.k.u.z0(vVar, new l());
            b.h.k.u.m0(vVar, new m());
            this.r = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private int A() {
        int height = this.f7870c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f7870c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int B() {
        int[] iArr = new int[2];
        this.f7870c.getLocationOnScreen(iArr);
        return iArr[1] + this.f7870c.getHeight();
    }

    private boolean F() {
        ViewGroup.LayoutParams layoutParams = this.f7870c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void J(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.q;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = w();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).P(this);
        }
        swipeDismissBehavior.K(new q());
        fVar.o(swipeDismissBehavior);
        if (this.f7874g == null) {
            fVar.f1005g = 80;
        }
    }

    private boolean L() {
        return this.n > 0 && !this.f7873f && F();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void O() {
        if (K()) {
            p();
            return;
        }
        this.f7870c.setVisibility(0);
        H();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void P() {
        ValueAnimator u2 = u(Utils.FLOAT_EPSILON, 1.0f);
        ValueAnimator x = x(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(u2, x);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private void Q(int i2) {
        ValueAnimator u2 = u(1.0f, Utils.FLOAT_EPSILON);
        u2.setDuration(75L);
        u2.addListener(new c(i2));
        u2.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void R() {
        int A = A();
        if (u) {
            b.h.k.u.Y(this.f7870c, A);
        } else {
            this.f7870c.setTranslationY((float) A);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(A, 0);
        valueAnimator.setInterpolator(c.e.a.b.m.a.f3376b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f());
        valueAnimator.addUpdateListener(new g(A));
        valueAnimator.start();
    }

    private void S(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, A());
        valueAnimator.setInterpolator(c.e.a.b.m.a.f3376b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new h(i2));
        valueAnimator.addUpdateListener(new i());
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void T() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f7870c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.f7877j) == null) {
            Log.w(w, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.f7874g != null ? this.o : this.f7878k);
        marginLayoutParams.leftMargin = rect.left + this.l;
        marginLayoutParams.rightMargin = rect.right + this.m;
        this.f7870c.requestLayout();
        if (Build.VERSION.SDK_INT >= 29 && L()) {
            this.f7870c.removeCallbacks(this.f7876i);
            this.f7870c.post(this.f7876i);
        }
    }

    private void q(int i2) {
        if (this.f7870c.getAnimationMode() == 1) {
            Q(i2);
        } else {
            S(i2);
        }
    }

    private int r() {
        View view = this.f7874g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.f7868a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f7868a.getHeight()) - i2;
    }

    private ValueAnimator u(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3375a);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    private ValueAnimator x(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3378d);
        ofFloat.addUpdateListener(new e());
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f7869b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: protected */
    public boolean C() {
        TypedArray obtainStyledAttributes = this.f7869b.obtainStyledAttributes(v);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void D(int i2) {
        if (!K() || this.f7870c.getVisibility() != 0) {
            G(i2);
        } else {
            q(i2);
        }
    }

    public boolean E() {
        return b.c().e(this.s);
    }

    /* access modifiers changed from: package-private */
    public void G(int i2) {
        b.c().h(this.s);
        List<r<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f7870c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f7870c);
        }
    }

    /* access modifiers changed from: package-private */
    public void H() {
        b.c().i(this.s);
        List<r<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).b(this);
            }
        }
    }

    public B I(int i2) {
        this.f7872e = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.r.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void M() {
        b.c().m(v(), this.s);
    }

    /* access modifiers changed from: package-private */
    public final void N() {
        this.f7870c.setOnAttachStateChangeListener(new o());
        if (this.f7870c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f7870c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                J((CoordinatorLayout.f) layoutParams);
            }
            this.o = r();
            T();
            this.f7870c.setVisibility(4);
            this.f7868a.addView(this.f7870c);
        }
        if (b.h.k.u.S(this.f7870c)) {
            O();
        } else {
            this.f7870c.setOnLayoutChangeListener(new p());
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f7870c.post(new a());
    }

    public void s() {
        t(3);
    }

    /* access modifiers changed from: protected */
    public void t(int i2) {
        b.c().b(this.s, i2);
    }

    public int v() {
        return this.f7872e;
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> w() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    public int z() {
        return C() ? c.e.a.b.h.mtrl_layout_snackbar : c.e.a.b.h.design_layout_snackbar;
    }
}
