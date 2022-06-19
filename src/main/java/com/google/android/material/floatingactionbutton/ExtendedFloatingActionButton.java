package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.u;
import c.e.a.b.l;
import c.e.a.b.m.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private boolean A;
    private final d t;
    private final d u;
    private final d v;
    private final d w;
    private final int x;
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> y;
    private boolean z;

    /* access modifiers changed from: package-private */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7748b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f7749c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f7750d;

        a(ExtendedFloatingActionButton extendedFloatingActionButton, d dVar, f fVar) {
            this.f7749c = dVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f7748b = true;
            this.f7749c.b();
        }

        public void onAnimationEnd(Animator animator) {
            this.f7749c.a();
            if (!this.f7748b) {
                this.f7749c.h(this.f7750d);
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f7749c.onAnimationStart(animator);
            this.f7748b = false;
        }
    }

    static class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    }

    static class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    }

    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) u.G(view));
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            u.A0(view, f2.intValue(), view.getPaddingTop(), u.F(view), view.getPaddingBottom());
        }
    }

    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) u.F(view));
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            u.A0(view, u.G(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class f {
    }

    static {
        new b(Float.class, "width");
        new c(Float.class, "height");
        new d(Float.class, "paddingStart");
        new e(Float.class, "paddingEnd");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(d dVar, f fVar) {
        if (!dVar.i()) {
            if (!s()) {
                dVar.d();
                dVar.h(fVar);
                return;
            }
            measure(0, 0);
            AnimatorSet f2 = dVar.f();
            f2.addListener(new a(this, dVar, fVar));
            for (Animator.AnimatorListener animatorListener : dVar.g()) {
                f2.addListener(animatorListener);
            }
            f2.start();
        }
    }

    private void r() {
        getTextColors();
    }

    private boolean s() {
        return u.S(this) && !isInEditMode();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedSize() {
        int i2 = this.x;
        return i2 < 0 ? (Math.min(u.G(this), u.F(this)) * 2) + getIconSize() : i2;
    }

    public h getExtendMotionSpec() {
        return this.u.e();
    }

    public h getHideMotionSpec() {
        return this.w.e();
    }

    public h getShowMotionSpec() {
        return this.v.e();
    }

    public h getShrinkMotionSpec() {
        return this.t.e();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.z && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.z = false;
            this.t.d();
        }
    }

    public void setExtendMotionSpec(h hVar) {
        this.u.c(hVar);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(h.c(getContext(), i2));
    }

    public void setExtended(boolean z2) {
        if (this.z != z2) {
            d dVar = z2 ? this.u : this.t;
            if (!dVar.i()) {
                dVar.d();
            }
        }
    }

    public void setHideMotionSpec(h hVar) {
        this.w.c(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.c(getContext(), i2));
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (this.z && !this.A) {
            u.G(this);
            u.F(this);
        }
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (this.z) {
            boolean z2 = this.A;
        }
    }

    public void setShowMotionSpec(h hVar) {
        this.v.c(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.c(getContext(), i2));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.t.c(hVar);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(h.c(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        r();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f7743a;

        /* renamed from: b  reason: collision with root package name */
        private f f7744b;

        /* renamed from: c  reason: collision with root package name */
        private f f7745c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7746d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7747e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f7746d = false;
            this.f7747e = true;
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams();
            if ((this.f7746d || this.f7747e) && fVar.e() == view.getId()) {
                return true;
            }
            return false;
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f7743a == null) {
                this.f7743a = new Rect();
            }
            Rect rect = this.f7743a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            d dVar;
            boolean z = this.f7747e;
            f fVar = z ? this.f7745c : this.f7744b;
            if (z) {
                dVar = extendedFloatingActionButton.u;
            } else {
                dVar = extendedFloatingActionButton.v;
            }
            extendedFloatingActionButton.q(dVar, fVar);
        }

        /* renamed from: F */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!G(view)) {
                return false;
            } else {
                M(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> r = coordinatorLayout.r(extendedFloatingActionButton);
            int size = r.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = r.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i2);
            return true;
        }

        /* access modifiers changed from: protected */
        public void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            d dVar;
            boolean z = this.f7747e;
            f fVar = z ? this.f7745c : this.f7744b;
            if (z) {
                dVar = extendedFloatingActionButton.t;
            } else {
                dVar = extendedFloatingActionButton.w;
            }
            extendedFloatingActionButton.q(dVar, fVar);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1006h == 0) {
                fVar.f1006h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.B0);
            this.f7746d = obtainStyledAttributes.getBoolean(l.C0, false);
            this.f7747e = obtainStyledAttributes.getBoolean(l.D0, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        r();
    }
}
