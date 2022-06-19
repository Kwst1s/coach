package com.flipboard.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

public class BottomSheetLayout extends FrameLayout {
    private static final Property<BottomSheetLayout, Float> J = new a(Float.class, "sheetTranslation");
    private int A;
    private final boolean B;
    private final int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private k I;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f4676b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f4677c;

    /* renamed from: d  reason: collision with root package name */
    private k f4678d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4679e;

    /* renamed from: f  reason: collision with root package name */
    private TimeInterpolator f4680f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4681g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4682h;

    /* renamed from: i  reason: collision with root package name */
    private float f4683i;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f4684j;

    /* renamed from: k  reason: collision with root package name */
    private float f4685k;
    private float l;
    private c m;
    private c n;
    private boolean o;
    private boolean p;
    private Animator q;
    private CopyOnWriteArraySet<b> r;
    private CopyOnWriteArraySet<j> s;
    private View.OnLayoutChangeListener t;
    private View u;
    private boolean v;
    private int w;
    private boolean x;
    private float y;
    private float z;

    static class a extends Property<BottomSheetLayout, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(BottomSheetLayout bottomSheetLayout) {
            return Float.valueOf(bottomSheetLayout.f4683i);
        }

        /* renamed from: b */
        public void set(BottomSheetLayout bottomSheetLayout, Float f2) {
            bottomSheetLayout.setSheetTranslation(f2.floatValue());
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends h {
        b() {
            super(null);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4696b) {
                BottomSheetLayout.this.q = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends h {
        c() {
            super(null);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4696b) {
                BottomSheetLayout.this.q = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f4688b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f4689c;

        d(View view, c cVar) {
            this.f4688b = view;
            this.f4689c = cVar;
        }

        public void run() {
            BottomSheetLayout.this.D(this.f4688b, this.f4689c);
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements ViewTreeObserver.OnPreDrawListener {

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (BottomSheetLayout.this.getSheetView() != null) {
                    BottomSheetLayout.this.B();
                }
            }
        }

        e() {
        }

        public boolean onPreDraw() {
            BottomSheetLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            BottomSheetLayout.this.post(new a());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements View.OnLayoutChangeListener {
        f() {
        }

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            int measuredHeight = view.getMeasuredHeight();
            if (BottomSheetLayout.this.f4678d != k.HIDDEN && measuredHeight < BottomSheetLayout.this.w) {
                if (BottomSheetLayout.this.f4678d == k.EXPANDED) {
                    BottomSheetLayout.this.setState(k.PEEKED);
                }
                BottomSheetLayout.this.setSheetTranslation((float) measuredHeight);
            }
            BottomSheetLayout.this.w = measuredHeight;
        }
    }

    /* access modifiers changed from: package-private */
    public class g extends h {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f4694c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(View view) {
            super(null);
            this.f4694c = view;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4696b) {
                BottomSheetLayout.this.q = null;
                BottomSheetLayout.this.setState(k.HIDDEN);
                BottomSheetLayout.this.setSheetLayerTypeIfEnabled(0);
                BottomSheetLayout.this.removeView(this.f4694c);
                Iterator it = BottomSheetLayout.this.r.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(BottomSheetLayout.this);
                }
                BottomSheetLayout.this.n = null;
                if (BottomSheetLayout.this.f4676b != null) {
                    BottomSheetLayout.this.f4676b.run();
                    BottomSheetLayout.this.f4676b = null;
                }
            }
        }
    }

    private static class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        protected boolean f4696b;

        private h() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f4696b = true;
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    private static class i extends a {
        private i() {
        }

        @Override // com.flipboard.bottomsheet.c
        public void a(float f2, float f3, float f4, BottomSheetLayout bottomSheetLayout, View view) {
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    public interface j {
        void a(k kVar);
    }

    public enum k {
        HIDDEN,
        PREPARING,
        PEEKED,
        EXPANDED
    }

    public BottomSheetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean A(float f2) {
        return !this.B || (f2 >= ((float) this.D) && f2 <= ((float) this.E));
    }

    private void E(float f2) {
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(f2, getMaxSheetTranslation(), getPeekSheetTranslation(), this, getContentView());
            return;
        }
        c cVar2 = this.m;
        if (cVar2 != null) {
            cVar2.a(f2, getMaxSheetTranslation(), getPeekSheetTranslation(), this, getContentView());
        }
    }

    private float getDefaultPeekTranslation() {
        return v() ? this.y : (float) getSheetView().getHeight();
    }

    private boolean n(View view, float f2, float f3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f4 = (float) left;
                if ((f2 > f4 && f2 < ((float) (childAt.getRight() - view.getScrollX())) && f3 > ((float) top) && f3 < ((float) (childAt.getBottom() - view.getScrollY()))) && n(childAt, f2 - f4, f3 - ((float) top))) {
                    return true;
                }
            }
        }
        return view.canScrollVertically(-1);
    }

    private void o() {
        Animator animator = this.q;
        if (animator != null) {
            animator.cancel();
        }
    }

    private static <T> T p(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    private void r(Runnable runnable) {
        if (this.f4678d == k.HIDDEN) {
            this.f4676b = null;
            return;
        }
        this.f4676b = runnable;
        View sheetView = getSheetView();
        sheetView.removeOnLayoutChangeListener(this.t);
        o();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, J, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(this.f4680f);
        ofFloat.addListener(new g(sheetView));
        ofFloat.start();
        this.q = ofFloat;
        this.D = 0;
        this.E = this.A;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSheetLayerTypeIfEnabled(int i2) {
        if (this.p) {
            getSheetView().setLayerType(i2, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSheetTranslation(float f2) {
        this.f4683i = Math.min(f2, getMaxSheetTranslation());
        double height = (double) getHeight();
        double ceil = Math.ceil((double) this.f4683i);
        Double.isNaN(height);
        int i2 = (int) (height - ceil);
        int i3 = 0;
        this.f4677c.set(0, 0, getWidth(), i2);
        getSheetView().setTranslationY(((float) getHeight()) - this.f4683i);
        E(this.f4683i);
        if (this.o) {
            float t2 = t(this.f4683i);
            this.u.setAlpha(t2);
            View view = this.u;
            if (t2 <= Utils.FLOAT_EPSILON) {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setState(k kVar) {
        if (kVar != this.f4678d) {
            this.f4678d = kVar;
            Iterator<j> it = this.s.iterator();
            while (it.hasNext()) {
                it.next().a(kVar);
            }
        }
    }

    private float t(float f2) {
        c cVar = this.n;
        if (cVar != null) {
            return cVar.b(f2, getMaxSheetTranslation(), getPeekSheetTranslation(), this, getContentView());
        }
        c cVar2 = this.m;
        return cVar2 != null ? cVar2.b(f2, getMaxSheetTranslation(), getPeekSheetTranslation(), this, getContentView()) : Utils.FLOAT_EPSILON;
    }

    private boolean u() {
        return getSheetView() == null || getSheetView().getHeight() == getHeight();
    }

    private boolean v() {
        return getSheetView() == null || ((float) getSheetView().getHeight()) > this.y;
    }

    private void w() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f4685k = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.l = (float) viewConfiguration.getScaledTouchSlop();
        View view = new View(getContext());
        this.u = view;
        view.setBackgroundColor(-16777216);
        this.u.setAlpha(Utils.FLOAT_EPSILON);
        this.u.setVisibility(4);
        setFocusableInTouchMode(true);
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
        int i2 = point.x;
        this.A = i2;
        this.E = i2;
        this.z = Utils.FLOAT_EPSILON;
        this.y = ((float) point.y) - (((float) i2) / 1.7777778f);
    }

    private void x() {
        this.f4683i = Utils.FLOAT_EPSILON;
        this.f4677c.set(0, 0, getWidth(), getHeight());
        getSheetView().setTranslationY((float) getHeight());
        this.u.setAlpha(Utils.FLOAT_EPSILON);
        this.u.setVisibility(4);
    }

    private boolean y() {
        return this.q != null;
    }

    public void B() {
        o();
        setSheetLayerTypeIfEnabled(2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, J, getPeekSheetTranslation());
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(this.f4680f);
        ofFloat.addListener(new c());
        ofFloat.start();
        this.q = ofFloat;
        setState(k.PEEKED);
    }

    public void C(View view) {
        D(view, null);
    }

    public void D(View view, c cVar) {
        if (this.f4678d != k.HIDDEN) {
            r(new d(view, cVar));
            return;
        }
        setState(k.PREPARING);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(this.B ? -2 : -1, -2, 1);
        }
        if (this.B && layoutParams.width == -2) {
            if (layoutParams.gravity == -1) {
                layoutParams.gravity = 1;
            }
            int i2 = this.C;
            layoutParams.width = i2;
            int i3 = this.A;
            int i4 = (i3 - i2) / 2;
            this.D = i4;
            this.E = i3 - i4;
        }
        super.addView(view, -1, layoutParams);
        x();
        this.n = cVar;
        getViewTreeObserver().addOnPreDrawListener(new e());
        this.w = view.getMeasuredHeight();
        f fVar = new f();
        this.t = fVar;
        view.addOnLayoutChangeListener(fVar);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            setContentView(view);
            return;
        }
        throw new IllegalArgumentException("You may not declare more then one child of bottom sheet. The sheet view must be added dynamically with showWithSheetView()");
    }

    public View getContentView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public boolean getInterceptContentTouch() {
        return this.v;
    }

    public float getMaxSheetTranslation() {
        return (float) (u() ? getHeight() - getPaddingTop() : getSheetView().getHeight());
    }

    public boolean getPeekOnDismiss() {
        return this.f4679e;
    }

    public float getPeekSheetTranslation() {
        float f2 = this.z;
        return f2 == Utils.FLOAT_EPSILON ? getDefaultPeekTranslation() : f2;
    }

    public View getSheetView() {
        if (getChildCount() > 2) {
            return getChildAt(2);
        }
        return null;
    }

    public k getState() {
        return this.f4678d;
    }

    public void m(j jVar) {
        p(jVar, "onSheetStateChangeListener == null");
        this.s.add(jVar);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4684j = VelocityTracker.obtain();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4684j.clear();
        o();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2 = true;
        boolean z3 = motionEvent.getActionMasked() == 0;
        if (z3) {
            this.x = false;
        }
        if (this.v || (motionEvent.getY() > ((float) getHeight()) - this.f4683i && A(motionEvent.getX()))) {
            if (!z3 || !z()) {
                z2 = false;
            }
            this.x = z2;
        } else {
            this.x = false;
        }
        return this.x;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && z()) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (z() && keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    if (this.f4678d != k.EXPANDED || !this.f4679e) {
                        q();
                    } else {
                        B();
                    }
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        double height = (double) getHeight();
        double ceil = Math.ceil((double) this.f4683i);
        Double.isNaN(height);
        this.f4677c.set(0, 0, getWidth(), (int) (height - ceil));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = false;
        if (!z() || y()) {
            return false;
        }
        if (!this.x) {
            return onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f4681g = false;
            this.f4682h = false;
            this.F = motionEvent.getY();
            this.G = motionEvent.getX();
            this.H = this.f4683i;
            this.I = this.f4678d;
            this.f4684j.clear();
        }
        this.f4684j.addMovement(motionEvent);
        float maxSheetTranslation = getMaxSheetTranslation();
        float peekSheetTranslation = getPeekSheetTranslation();
        float y2 = this.F - motionEvent.getY();
        float x2 = this.G - motionEvent.getX();
        boolean z3 = this.f4681g;
        float f2 = Utils.FLOAT_EPSILON;
        if (!z3 && !this.f4682h) {
            this.f4681g = Math.abs(y2) > this.l;
            this.f4682h = Math.abs(x2) > this.l;
            if (this.f4681g) {
                if (this.f4678d == k.PEEKED) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(Utils.FLOAT_EPSILON, this.f4683i - ((float) getHeight()));
                    obtain.setAction(3);
                    getSheetView().dispatchTouchEvent(obtain);
                    obtain.recycle();
                }
                this.f4682h = false;
                this.F = motionEvent.getY();
                this.G = motionEvent.getX();
                y2 = Utils.FLOAT_EPSILON;
            }
        }
        float f3 = this.H + y2;
        if (this.f4681g) {
            boolean z4 = y2 < Utils.FLOAT_EPSILON;
            boolean n2 = n(getSheetView(), motionEvent.getX(), motionEvent.getY() + (this.f4683i - ((float) getHeight())));
            k kVar = this.f4678d;
            k kVar2 = k.EXPANDED;
            if (kVar == kVar2 && z4 && !n2) {
                this.F = motionEvent.getY();
                this.H = this.f4683i;
                this.f4684j.clear();
                setState(k.PEEKED);
                setSheetLayerTypeIfEnabled(2);
                f3 = this.f4683i;
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                obtain2.setAction(3);
                getSheetView().dispatchTouchEvent(obtain2);
                obtain2.recycle();
            }
            if (this.f4678d == k.PEEKED && f3 > maxSheetTranslation) {
                setSheetTranslation(maxSheetTranslation);
                f3 = Math.min(maxSheetTranslation, f3);
                MotionEvent obtain3 = MotionEvent.obtain(motionEvent);
                obtain3.setAction(0);
                getSheetView().dispatchTouchEvent(obtain3);
                obtain3.recycle();
                setState(kVar2);
                setSheetLayerTypeIfEnabled(0);
            }
            if (this.f4678d == kVar2) {
                motionEvent.offsetLocation(Utils.FLOAT_EPSILON, this.f4683i - ((float) getHeight()));
                getSheetView().dispatchTouchEvent(motionEvent);
            } else {
                if (f3 < peekSheetTranslation) {
                    f3 = peekSheetTranslation - ((peekSheetTranslation - f3) / 4.0f);
                }
                setSheetTranslation(f3);
                if (motionEvent.getAction() == 3) {
                    if (this.I == kVar2) {
                        s();
                    } else {
                        B();
                    }
                }
                if (motionEvent.getAction() == 1) {
                    if (f3 < peekSheetTranslation) {
                        q();
                    } else {
                        this.f4684j.computeCurrentVelocity(1000);
                        float yVelocity = this.f4684j.getYVelocity();
                        if (Math.abs(yVelocity) < this.f4685k) {
                            if (this.f4683i > ((float) (getHeight() / 2))) {
                                s();
                            } else {
                                B();
                            }
                        } else if (yVelocity < Utils.FLOAT_EPSILON) {
                            s();
                        } else {
                            B();
                        }
                    }
                }
            }
        } else {
            if (motionEvent.getY() < ((float) getHeight()) - this.f4683i || !A(motionEvent.getX())) {
                z2 = true;
            }
            if (motionEvent.getAction() != 1 || !z2 || !this.v) {
                if (this.B) {
                    f2 = getX() - ((float) this.D);
                }
                motionEvent.offsetLocation(f2, this.f4683i - ((float) getHeight()));
                getSheetView().dispatchTouchEvent(motionEvent);
            } else {
                q();
                return true;
            }
        }
        return true;
    }

    public void q() {
        r(null);
    }

    public void s() {
        o();
        setSheetLayerTypeIfEnabled(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, J, getMaxSheetTranslation());
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(this.f4680f);
        ofFloat.addListener(new b());
        ofFloat.start();
        this.q = ofFloat;
        setState(k.EXPANDED);
    }

    public void setContentView(View view) {
        super.addView(view, -1, generateDefaultLayoutParams());
        super.addView(this.u, -1, generateDefaultLayoutParams());
    }

    public void setDefaultViewTransformer(c cVar) {
        this.m = cVar;
    }

    public void setInterceptContentTouch(boolean z2) {
        this.v = z2;
    }

    public void setPeekOnDismiss(boolean z2) {
        this.f4679e = z2;
    }

    public void setPeekSheetTranslation(float f2) {
        this.z = f2;
    }

    public void setShouldDimContentView(boolean z2) {
        this.o = z2;
    }

    public void setUseHardwareLayerWhileAnimating(boolean z2) {
        this.p = z2;
    }

    public boolean z() {
        return this.f4678d != k.HIDDEN;
    }

    public BottomSheetLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4677c = new Rect();
        this.f4678d = k.HIDDEN;
        this.f4679e = false;
        this.f4680f = new DecelerateInterpolator(1.6f);
        this.m = new i(null);
        this.o = true;
        this.p = true;
        this.r = new CopyOnWriteArraySet<>();
        this.s = new CopyOnWriteArraySet<>();
        this.v = true;
        this.A = 0;
        this.B = getResources().getBoolean(d.a.a.bottomsheet_is_tablet);
        this.C = getResources().getDimensionPixelSize(d.a.b.bottomsheet_default_sheet_width);
        this.D = 0;
        this.E = 0;
        w();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        addView(view);
    }
}
