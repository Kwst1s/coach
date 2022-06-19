package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.c0;
import b.h.k.d0.c;
import b.h.k.d0.f;
import b.h.k.k;
import b.h.k.u;
import c.e.a.b.c0.g;
import c.e.a.b.c0.h;
import c.e.a.b.d;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: b  reason: collision with root package name */
    private int f7476b;

    /* renamed from: c  reason: collision with root package name */
    private int f7477c;

    /* renamed from: d  reason: collision with root package name */
    private int f7478d;

    /* renamed from: e  reason: collision with root package name */
    private int f7479e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7480f;

    /* renamed from: g  reason: collision with root package name */
    private int f7481g;

    /* renamed from: h  reason: collision with root package name */
    private c0 f7482h;

    /* renamed from: i  reason: collision with root package name */
    private List<b> f7483i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7484j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7485k;
    private boolean l;
    private boolean m;
    private int n;
    private WeakReference<View> o;
    private ValueAnimator p;
    private int[] q;
    private Drawable r;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends b {
        public ScrollingViewBehavior() {
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f2 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                return ((BaseBehavior) f2).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c f2 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                u.Y(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f2).f7486k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.j()) {
                    appBarLayout.p(appBarLayout.r(view));
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public float J(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) R) / ((float) i2)) + 1.0f;
                }
            }
            return Utils.FLOAT_EPSILON;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int L(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.L(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Q */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                u.g0(coordinatorLayout, c.a.f2643h.b());
                u.g0(coordinatorLayout, c.a.f2644i.b());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout Q = H(coordinatorLayout.r(view));
            if (Q != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f7513d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    Q.m(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.s2);
            O(obtainStyledAttributes.getDimensionPixelSize(l.t2, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f7500b;

        a(AppBarLayout appBarLayout, g gVar) {
            this.f7500b = gVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7500b.W(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    private void a() {
        WeakReference<View> weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    private View b(View view) {
        int i2;
        if (this.o == null && (i2 = this.n) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.n);
            }
            if (findViewById != null) {
                this.o = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((c) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        this.f7477c = -1;
        this.f7478d = -1;
        this.f7479e = -1;
    }

    private void n(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.f7481g = i3 | i2;
        requestLayout();
    }

    private boolean o(boolean z) {
        if (this.f7485k == z) {
            return false;
        }
        this.f7485k = z;
        refreshDrawableState();
        return true;
    }

    private boolean q() {
        return this.r != null && getTopInset() > 0;
    }

    private boolean s() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || u.y(childAt)) {
            return false;
        }
        return true;
    }

    private void t(g gVar, boolean z) {
        float dimension = getResources().getDimension(d.design_appbar_elevation);
        float f2 = z ? Utils.FLOAT_EPSILON : dimension;
        if (!z) {
            dimension = Utils.FLOAT_EPSILON;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
        this.p = ofFloat;
        ofFloat.setDuration((long) getResources().getInteger(c.e.a.b.g.app_bar_elevation_anim_duration));
        this.p.setInterpolator(c.e.a.b.m.a.f3375a);
        this.p.addUpdateListener(new a(this, gVar));
        this.p.start();
    }

    private void u() {
        setWillNotDraw(!q());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public c generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* renamed from: d */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (q()) {
            int save = canvas.save();
            canvas.translate(Utils.FLOAT_EPSILON, (float) (-this.f7476b));
            this.r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new c((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f7480f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int C;
        int i3 = this.f7478d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.f7501a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    C = u.C(childAt);
                } else if ((i5 & 2) != 0) {
                    C = measuredHeight - u.C(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && u.y(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + C;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f7478d = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f7479e;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            int i5 = cVar.f7501a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= u.C(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f7479e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int C = u.C(this);
        if (C == 0) {
            int childCount = getChildCount();
            C = childCount >= 1 ? u.C(getChildAt(childCount - 1)) : 0;
            if (C == 0) {
                return getHeight() / 3;
            }
        }
        return (C * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f7481g;
    }

    public Drawable getStatusBarForeground() {
        return this.r;
    }

    @Deprecated
    public float getTargetElevation() {
        return Utils.FLOAT_EPSILON;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        c0 c0Var = this.f7482h;
        if (c0Var != null) {
            return c0Var.i();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f7477c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.f7501a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            if (i3 == 0 && u.y(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= u.C(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f7477c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return getTotalScrollRange() != 0;
    }

    public boolean j() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public void k(int i2) {
        this.f7476b = i2;
        if (!willNotDraw()) {
            u.d0(this);
        }
        List<b> list = this.f7483i;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f7483i.get(i3);
                if (bVar != null) {
                    bVar.a(this, i2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f7481g = 0;
    }

    public void m(boolean z, boolean z2) {
        n(z, z2, true);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.q == null) {
            this.q = new int[4];
        }
        int[] iArr = this.q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f7485k;
        int i3 = c.e.a.b.b.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (!z || !this.l) ? -c.e.a.b.b.state_lifted : c.e.a.b.b.state_lifted;
        int i4 = c.e.a.b.b.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (!z || !this.l) ? -c.e.a.b.b.state_collapsed : c.e.a.b.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (u.y(this) && s()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                u.Y(getChildAt(childCount), topInset);
            }
        }
        i();
        this.f7480f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((c) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f7480f = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f7484j) {
            if (!this.m && !g()) {
                z2 = false;
            }
            o(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && u.y(this) && s()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = b.h.g.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        i();
    }

    /* access modifiers changed from: package-private */
    public boolean p(boolean z) {
        if (this.l == z) {
            return false;
        }
        this.l = z;
        refreshDrawableState();
        if (!this.m || !(getBackground() instanceof g)) {
            return true;
        }
        t((g) getBackground(), z);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        View b2 = b(view);
        if (b2 != null) {
            view = b2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        h.d(this, f2);
    }

    public void setExpanded(boolean z) {
        m(z, u.S(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.m = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.n = i2;
        a();
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.r, u.B(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            u();
            u.d0(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(b.a.k.a.a.d(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, f2);
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    /* access modifiers changed from: protected */
    public static class BaseBehavior<T extends AppBarLayout> extends a<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f7486k;
        private int l;
        private ValueAnimator m;
        private int n = -1;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private d r;

        /* access modifiers changed from: package-private */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f7487b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f7488c;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f7487b = coordinatorLayout;
                this.f7488c = appBarLayout;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f7487b, this.f7488c, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* access modifiers changed from: package-private */
        public class b implements f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f7490a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f7491b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f7492c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f7493d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.f7490a = coordinatorLayout;
                this.f7491b = appBarLayout;
                this.f7492c = view;
                this.f7493d = i2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.h.k.d0.f
            public boolean a(View view, f.a aVar) {
                BaseBehavior.this.q(this.f7490a, this.f7491b, this.f7492c, 0, this.f7493d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public class c implements f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f7495a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f7496b;

            c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
                this.f7495a = appBarLayout;
                this.f7496b = z;
            }

            @Override // b.h.k.d0.f
            public boolean a(View view, f.a aVar) {
                this.f7495a.setExpanded(this.f7496b);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
        }

        private void S(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (M() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                T(coordinatorLayout, t, c.a.f2643h, false);
            }
            if (M() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                int i2 = -t.getDownNestedPreScrollRange();
                if (i2 != 0) {
                    u.i0(coordinatorLayout, c.a.f2644i, null, new b(coordinatorLayout, t, view, i2));
                    return;
                }
                return;
            }
            T(coordinatorLayout, t, c.a.f2644i, true);
        }

        private void T(CoordinatorLayout coordinatorLayout, T t, c.a aVar, boolean z) {
            u.i0(coordinatorLayout, aVar, null, new c(this, t, z));
        }

        private void U(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int i3;
            int abs = Math.abs(M() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > Utils.FLOAT_EPSILON) {
                i3 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i3 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            V(coordinatorLayout, t, i2, i3);
        }

        private void V(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int M = M();
            if (M == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(c.e.a.b.m.a.f3379e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(i3, 600));
            this.m.setIntValues(M, i2);
            this.m.start();
        }

        private boolean X(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.h() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean Y(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private View Z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof k) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View a0(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int b0(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if (Y(cVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private int e0(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                c cVar = (c) childAt.getLayoutParams();
                Interpolator b2 = cVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = cVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= u.C(childAt);
                        }
                    }
                    if (u.y(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        private boolean p0(CoordinatorLayout coordinatorLayout, T t) {
            List<View> s = coordinatorLayout.s(t);
            int size = s.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.c f2 = ((CoordinatorLayout.f) s.get(i2).getLayoutParams()).f();
                if (f2 instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) f2).K() != 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }

        private void q0(CoordinatorLayout coordinatorLayout, T t) {
            int M = M();
            int b0 = b0(t, M);
            if (b0 >= 0) {
                View childAt = t.getChildAt(b0);
                c cVar = (c) childAt.getLayoutParams();
                int a2 = cVar.a();
                if ((a2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (b0 == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (Y(a2, 2)) {
                        i3 += u.C(childAt);
                    } else if (Y(a2, 5)) {
                        int C = u.C(childAt) + i3;
                        if (M < C) {
                            i2 = C;
                        } else {
                            i3 = C;
                        }
                    }
                    if (Y(a2, 32)) {
                        i2 += ((LinearLayout.LayoutParams) cVar).topMargin;
                        i3 -= ((LinearLayout.LayoutParams) cVar).bottomMargin;
                    }
                    if (M < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    U(coordinatorLayout, t, b.h.g.a.b(i2, -t.getTotalScrollRange(), 0), Utils.FLOAT_EPSILON);
                }
            }
        }

        private void r0(CoordinatorLayout coordinatorLayout, T t) {
            u.g0(coordinatorLayout, c.a.f2643h.b());
            u.g0(coordinatorLayout, c.a.f2644i.b());
            View Z = Z(coordinatorLayout);
            if (Z != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) Z.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                S(coordinatorLayout, t, Z);
            }
        }

        private void s0(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View a0 = a0(t, i2);
            if (a0 != null) {
                int a2 = ((c) a0.getLayoutParams()).a();
                boolean z2 = false;
                if ((a2 & 1) != 0) {
                    int C = u.C(a0);
                    if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (a0.getBottom() - C) - t.getTopInset()) : (-i2) >= (a0.getBottom() - C) - t.getTopInset()) {
                        z2 = true;
                    }
                }
                if (t.j()) {
                    z2 = t.r(Z(coordinatorLayout));
                }
                boolean p2 = t.p(z2);
                if (z || (p2 && p0(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        public int M() {
            return E() + this.f7486k;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: W */
        public boolean H(T t) {
            d dVar = this.r;
            if (dVar != null) {
                return dVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c0 */
        public int K(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d0 */
        public int L(T t) {
            return t.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f0 */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            q0(coordinatorLayout, t);
            if (t.j()) {
                t.p(t.r(Z(coordinatorLayout)));
            }
        }

        /* renamed from: g0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int i3;
            boolean l2 = super.l(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i4 = this.n;
            if (i4 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i4);
                int i5 = -childAt.getBottom();
                if (this.o) {
                    i3 = u.C(childAt) + t.getTopInset();
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.p);
                }
                P(coordinatorLayout, t, i5 + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i6 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        U(coordinatorLayout, t, i6, Utils.FLOAT_EPSILON);
                    } else {
                        P(coordinatorLayout, t, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        U(coordinatorLayout, t, 0, Utils.FLOAT_EPSILON);
                    } else {
                        P(coordinatorLayout, t, 0);
                    }
                }
            }
            t.l();
            this.n = -1;
            G(b.h.g.a.b(E(), -t.getTotalScrollRange(), 0));
            s0(coordinatorLayout, t, E(), 0, true);
            t.k(E());
            r0(coordinatorLayout, t);
            return l2;
        }

        /* renamed from: h0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t, i2, i3, i4, i5);
            }
            coordinatorLayout.J(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        /* renamed from: i0 */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i6 = i7;
                    i5 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = O(coordinatorLayout, t, i3, i6, i5);
                }
            }
            if (t.j()) {
                t.p(t.r(view));
            }
        }

        /* renamed from: j0 */
        public void t(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = O(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                r0(coordinatorLayout, t);
            }
        }

        /* renamed from: k0 */
        public void x(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof e) {
                e eVar = (e) parcelable;
                super.x(coordinatorLayout, t, eVar.g());
                this.n = eVar.f7497d;
                this.p = eVar.f7498e;
                this.o = eVar.f7499f;
                return;
            }
            super.x(coordinatorLayout, t, parcelable);
            this.n = -1;
        }

        /* renamed from: l0 */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable y = super.y(coordinatorLayout, t);
            int E = E();
            int childCount = t.getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    e eVar = new e(y);
                    eVar.f7497d = i2;
                    if (bottom == u.C(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    eVar.f7499f = z;
                    eVar.f7498e = ((float) bottom) / ((float) childAt.getHeight());
                    return eVar;
                }
            }
            return y;
        }

        /* renamed from: m0 */
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.j() || X(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i3;
            return z;
        }

        /* renamed from: n0 */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.l == 0 || i2 == 1) {
                q0(coordinatorLayout, t);
                if (t.j()) {
                    t.p(t.r(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o0 */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int M = M();
            int i5 = 0;
            if (i3 == 0 || M < i3 || M > i4) {
                this.f7486k = 0;
            } else {
                int b2 = b.h.g.a.b(i2, i3, i4);
                if (M != b2) {
                    int e0 = t.f() ? e0(t, b2) : b2;
                    boolean G = G(e0);
                    i5 = M - b2;
                    this.f7486k = b2 - e0;
                    if (!G && t.f()) {
                        coordinatorLayout.f(t);
                    }
                    t.k(E());
                    s0(coordinatorLayout, t, b2, b2 < M ? -1 : 1, false);
                }
            }
            r0(coordinatorLayout, t);
            return i5;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public static class e extends b.j.a.a {
            public static final Parcelable.Creator<e> CREATOR = new a();

            /* renamed from: d  reason: collision with root package name */
            int f7497d;

            /* renamed from: e  reason: collision with root package name */
            float f7498e;

            /* renamed from: f  reason: collision with root package name */
            boolean f7499f;

            static class a implements Parcelable.ClassLoaderCreator<e> {
                a() {
                }

                /* renamed from: a */
                public e createFromParcel(Parcel parcel) {
                    return new e(parcel, null);
                }

                /* renamed from: b */
                public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new e(parcel, classLoader);
                }

                /* renamed from: c */
                public e[] newArray(int i2) {
                    return new e[i2];
                }
            }

            public e(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f7497d = parcel.readInt();
                this.f7498e = parcel.readFloat();
                this.f7499f = parcel.readByte() != 0;
            }

            @Override // b.j.a.a
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f7497d);
                parcel.writeFloat(this.f7498e);
                parcel.writeByte(this.f7499f ? (byte) 1 : 0);
            }

            public e(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class c extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f7501a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f7502b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f3364a);
            this.f7501a = obtainStyledAttributes.getInt(l.f3365b, 0);
            int i2 = l.f3366c;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f7502b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f7501a;
        }

        public Interpolator b() {
            return this.f7502b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i2 = this.f7501a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
