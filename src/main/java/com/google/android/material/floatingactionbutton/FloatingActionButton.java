package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.t;
import b.h.k.u;
import c.e.a.b.c0.n;
import c.e.a.b.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.b;
import com.google.android.material.internal.l;
import java.util.List;

public class FloatingActionButton extends l implements t, androidx.core.widget.l, c.e.a.b.w.a, n, CoordinatorLayout.b {
    private static final int s = k.Widget_Design_FloatingActionButton;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f7751c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f7752d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f7753e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f7754f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f7755g;

    /* renamed from: h  reason: collision with root package name */
    private int f7756h;

    /* renamed from: i  reason: collision with root package name */
    private int f7757i;

    /* renamed from: j  reason: collision with root package name */
    private int f7758j;

    /* renamed from: k  reason: collision with root package name */
    private int f7759k;
    private int l;
    boolean m;
    final Rect n;
    private final Rect o;
    private final androidx.appcompat.widget.k p;
    private final c.e.a.b.w.b q;
    private b r;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements b.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f7763a;

        a(b bVar) {
            this.f7763a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.b.j
        public void a() {
            this.f7763a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.b.j
        public void b() {
            this.f7763a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* access modifiers changed from: private */
    public class c implements c.e.a.b.b0.b {
        c() {
        }

        @Override // c.e.a.b.b0.b
        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.n.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f7759k, i3 + FloatingActionButton.this.f7759k, i4 + FloatingActionButton.this.f7759k, i5 + FloatingActionButton.this.f7759k);
        }

        @Override // c.e.a.b.b0.b
        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // c.e.a.b.b0.b
        public boolean c() {
            return FloatingActionButton.this.m;
        }
    }

    class d<T extends FloatingActionButton> implements b.i {

        /* renamed from: a  reason: collision with root package name */
        private final c.e.a.b.m.k<T> f7766a;

        d(c.e.a.b.m.k<T> kVar) {
            this.f7766a = kVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.e.a.b.m.k<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.b.i
        public void a() {
            this.f7766a.a(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.e.a.b.m.k<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.b.i
        public void b() {
            this.f7766a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f7766a.equals(this.f7766a);
        }

        public int hashCode() {
            return this.f7766a.hashCode();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.floatingActionButtonStyle);
    }

    private b getImpl() {
        if (this.r == null) {
            this.r = h();
        }
        return this.r;
    }

    private b h() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(this, new c());
        }
        return new b(this, new c());
    }

    private int k(int i2) {
        int i3 = this.f7758j;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(c.e.a.b.d.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(c.e.a.b.d.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return k(1);
        } else {
            return k(0);
        }
    }

    private void q(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.n;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void r() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f7753e;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.c(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f7754f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(h.e(colorForState, mode));
        }
    }

    private static int s(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private b.j w(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // c.e.a.b.w.a
    public boolean a() {
        return this.q.c();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void g(c.e.a.b.m.k<? extends FloatingActionButton> kVar) {
        getImpl().f(new d(kVar));
    }

    public ColorStateList getBackgroundTintList() {
        return this.f7751c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f7752d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    public Drawable getContentBackground() {
        return getImpl().k();
    }

    public int getCustomSize() {
        return this.f7758j;
    }

    public int getExpandedComponentIdHint() {
        return this.q.b();
    }

    public c.e.a.b.m.h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f7755g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f7755g;
    }

    public c.e.a.b.c0.k getShapeAppearanceModel() {
        c.e.a.b.c0.k u = getImpl().u();
        b.h.j.h.c(u);
        return u;
    }

    public c.e.a.b.m.h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f7757i;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return k(this.f7757i);
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.f7753e;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f7754f;
    }

    public boolean getUseCompatPadding() {
        return this.m;
    }

    @Deprecated
    public boolean i(Rect rect) {
        if (!u.S(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        q(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        q(rect);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    public void l() {
        m(null);
    }

    public void m(b bVar) {
        n(bVar, true);
    }

    /* access modifiers changed from: package-private */
    public void n(b bVar, boolean z) {
        getImpl().w(w(bVar), z);
    }

    public boolean o() {
        return getImpl().y();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f7759k = (sizeDimension - this.l) / 2;
        getImpl().f0();
        int min = Math.min(s(sizeDimension, i2), s(sizeDimension, i3));
        Rect rect = this.n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c.e.a.b.d0.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c.e.a.b.d0.a aVar = (c.e.a.b.d0.a) parcelable;
        super.onRestoreInstanceState(aVar.g());
        c.e.a.b.w.b bVar = this.q;
        Bundle bundle = aVar.f3363d.get("expandableWidgetHelper");
        b.h.j.h.c(bundle);
        bVar.d(bundle);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        c.e.a.b.d0.a aVar = new c.e.a.b.d0.a(onSaveInstanceState);
        aVar.f3363d.put("expandableWidgetHelper", this.q.e());
        return aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !i(this.o) || this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean p() {
        return getImpl().z();
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f7751c != colorStateList) {
            this.f7751c = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f7752d != mode) {
            this.f7752d = mode;
            getImpl().M(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().N(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().Q(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().U(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.f7758j) {
            this.f7758j = i2;
            requestLayout();
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().g0(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().o()) {
            getImpl().O(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        this.q.f(i2);
    }

    public void setHideMotionSpec(c.e.a.b.m.h hVar) {
        getImpl().P(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(c.e.a.b.m.h.c(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().e0();
            if (this.f7753e != null) {
                r();
            }
        }
    }

    public void setImageResource(int i2) {
        this.p.g(i2);
        r();
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().I();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().I();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().W(z);
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(c.e.a.b.c0.k kVar) {
        getImpl().X(kVar);
    }

    public void setShowMotionSpec(c.e.a.b.m.h hVar) {
        getImpl().Y(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(c.e.a.b.m.h.c(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f7758j = 0;
        if (i2 != this.f7757i) {
            this.f7757i = i2;
            requestLayout();
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f7753e != colorStateList) {
            this.f7753e = colorStateList;
            r();
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f7754f != mode) {
            this.f7754f = mode;
            r();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().J();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().J();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.m != z) {
            this.m = z;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.l
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public void t() {
        u(null);
    }

    public void u(b bVar) {
        v(bVar, true);
    }

    /* access modifiers changed from: package-private */
    public void v(b bVar, boolean z) {
        getImpl().c0(w(bVar), z);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f7760a;

        /* renamed from: b  reason: collision with root package name */
        private b f7761b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7762c;

        public BaseBehavior() {
            this.f7762c = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.n;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
                int i3 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                    i2 = rect.right;
                } else {
                    i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    u.Y(floatingActionButton, i3);
                }
                if (i2 != 0) {
                    u.X(floatingActionButton, i2);
                }
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (this.f7762c && fVar.e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f7760a == null) {
                this.f7760a = new Rect();
            }
            Rect rect = this.f7760a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.n(this.f7761b, false);
                return true;
            }
            floatingActionButton.v(this.f7761b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.n(this.f7761b, false);
                return true;
            }
            floatingActionButton.v(this.f7761b, false);
            return true;
        }

        /* renamed from: E */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!F(view)) {
                return false;
            } else {
                L(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> r = coordinatorLayout.r(floatingActionButton);
            int size = r.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = r.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(floatingActionButton, i2);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1006h == 0) {
                fVar.f1006h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.e.a.b.l.U0);
            this.f7762c = obtainStyledAttributes.getBoolean(c.e.a.b.l.V0, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f7755g != colorStateList) {
            this.f7755g = colorStateList;
            getImpl().V(this.f7755g);
        }
    }
}
