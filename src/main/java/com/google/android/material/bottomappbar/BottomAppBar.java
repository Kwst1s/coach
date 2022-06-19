package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.u;
import c.e.a.b.m.k;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private final int Q;
    private final c.e.a.b.c0.g R;
    private Animator S;
    private Animator T;
    private int U;
    private int V;
    private boolean W;
    private int a0;
    private ArrayList<g> b0;
    private int c0;
    private boolean d0;
    private boolean e0;
    private Behavior f0;
    private int g0;
    private int h0;
    private int i0;
    AnimatorListenerAdapter j0;
    k<FloatingActionButton> k0;

    /* access modifiers changed from: package-private */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.l0();
            BottomAppBar.this.S = null;
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.m0();
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends FloatingActionButton.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7555a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.l0();
            }
        }

        b(int i2) {
            this.f7555a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.q0(this.f7555a));
            floatingActionButton.u(new a());
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.l0();
            BottomAppBar.this.d0 = false;
            BottomAppBar.this.T = null;
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.m0();
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f7559b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f7560c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7561d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f7562e;

        d(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f7560c = actionMenuView;
            this.f7561d = i2;
            this.f7562e = z;
        }

        public void onAnimationCancel(Animator animator) {
            this.f7559b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f7559b) {
                boolean z = BottomAppBar.this.c0 != 0;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.u0(bottomAppBar.c0);
                BottomAppBar.this.A0(this.f7560c, this.f7561d, this.f7562e, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f7564b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f7565c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f7566d;

        e(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f7564b = actionMenuView;
            this.f7565c = i2;
            this.f7566d = z;
        }

        public void run() {
            ActionMenuView actionMenuView = this.f7564b;
            actionMenuView.setTranslationX((float) BottomAppBar.this.p0(actionMenuView, this.f7565c, this.f7566d));
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.j0.onAnimationStart(animator);
            FloatingActionButton n0 = BottomAppBar.this.n0();
            if (n0 != null) {
                n0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    /* access modifiers changed from: package-private */
    public static class h extends b.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f7569d;

        /* renamed from: e  reason: collision with root package name */
        boolean f7570e;

        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* renamed from: c */
            public h[] newArray(int i2) {
                return new h[i2];
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7569d);
            parcel.writeInt(this.f7570e ? 1 : 0);
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7569d = parcel.readInt();
            this.f7570e = parcel.readInt() != 0;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void A0(ActionMenuView actionMenuView, int i2, boolean z, boolean z2) {
        e eVar = new e(actionMenuView, i2, z);
        if (z2) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.j0);
        floatingActionButton.f(new f());
        floatingActionButton.g(this.k0);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getBottomInset() {
        return this.g0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getFabTranslationX() {
        return q0(this.U);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getLeftInset() {
        return this.i0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getRightInset() {
        return this.h0;
    }

    private a getTopEdgeTreatment() {
        return (a) this.R.C().p();
    }

    private void h0() {
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.S;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void j0(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(n0(), "translationX", q0(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void k0(int i2, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - ((float) p0(actionMenuView, i2, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new d(actionMenuView, i2, z));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(ofFloat2, ofFloat);
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l0() {
        ArrayList<g> arrayList;
        int i2 = this.a0 - 1;
        this.a0 = i2;
        if (i2 == 0 && (arrayList = this.b0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m0() {
        ArrayList<g> arrayList;
        int i2 = this.a0;
        this.a0 = i2 + 1;
        if (i2 == 0 && (arrayList = this.b0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private FloatingActionButton n0() {
        View o0 = o0();
        if (o0 instanceof FloatingActionButton) {
            return (FloatingActionButton) o0;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View o0() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.s(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.o0():android.view.View");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float q0(int i2) {
        boolean d2 = com.google.android.material.internal.k.d(this);
        int i3 = 1;
        if (i2 != 1) {
            return Utils.FLOAT_EPSILON;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.Q + (d2 ? this.i0 : this.h0));
        if (d2) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    private boolean r0() {
        FloatingActionButton n0 = n0();
        return n0 != null && n0.p();
    }

    private void s0(int i2, boolean z) {
        if (!u.S(this)) {
            u0(this.c0);
            return;
        }
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!r0()) {
            i2 = 0;
            z = false;
        }
        k0(i2, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.T = animatorSet;
        animatorSet.addListener(new c());
        this.T.start();
    }

    private void t0(int i2) {
        if (this.U != i2 && u.S(this)) {
            Animator animator = this.S;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.V == 1) {
                j0(i2, arrayList);
            } else {
                i0(i2, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.S = animatorSet;
            animatorSet.addListener(new a());
            this.S.start();
        }
    }

    private void v0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.T == null) {
            actionMenuView.setAlpha(1.0f);
            if (!r0()) {
                z0(actionMenuView, 0, false);
            } else {
                z0(actionMenuView, this.U, this.e0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w0() {
        getTopEdgeTreatment().k(getFabTranslationX());
        View o0 = o0();
        this.R.Y((!this.e0 || !r0()) ? Utils.FLOAT_EPSILON : 1.0f);
        if (o0 != null) {
            o0.setTranslationY(getFabTranslationY());
            o0.setTranslationX(getFabTranslationX());
        }
    }

    private void z0(ActionMenuView actionMenuView, int i2, boolean z) {
        A0(actionMenuView, i2, z, false);
    }

    public ColorStateList getBackgroundTint() {
        return this.R.E();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.U;
    }

    public int getFabAnimationMode() {
        return this.V;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().e();
    }

    public boolean getHideOnScroll() {
        return this.W;
    }

    /* access modifiers changed from: protected */
    public void i0(int i2, List<Animator> list) {
        FloatingActionButton n0 = n0();
        if (n0 != null && !n0.o()) {
            m0();
            n0.m(new b(i2));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.e.a.b.c0.h.f(this, this.R);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            h0();
            w0();
        }
        v0();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.g());
        this.U = hVar.f7569d;
        this.e0 = hVar.f7570e;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f7569d = this.U;
        hVar.f7570e = this.e0;
        return hVar;
    }

    /* access modifiers changed from: protected */
    public int p0(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean d2 = com.google.android.material.internal.k.d(this);
        int measuredWidth = d2 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f159a & 8388615) == 8388611) {
                if (d2) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((d2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (d2 ? this.h0 : -this.i0));
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.R, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().g(f2);
            this.R.invalidateSelf();
            w0();
        }
    }

    public void setElevation(float f2) {
        this.R.W(f2);
        getBehavior().G(this, this.R.B() - this.R.A());
    }

    public void setFabAlignmentMode(int i2) {
        x0(i2, 0);
    }

    public void setFabAnimationMode(int i2) {
        this.V = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().h(f2);
            this.R.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().i(f2);
            this.R.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.W = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void u0(int i2) {
        if (i2 != 0) {
            this.c0 = 0;
            getMenu().clear();
            x(i2);
        }
    }

    public void x0(int i2, int i3) {
        this.c0 = i3;
        s0(i2, this.e0);
        t0(i2);
        this.U = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean y0(int i2) {
        float f2 = (float) i2;
        if (f2 == getTopEdgeTreatment().f()) {
            return false;
        }
        getTopEdgeTreatment().j(f2);
        this.R.invalidateSelf();
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f0 == null) {
            this.f0 = new Behavior();
        }
        return this.f0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e  reason: collision with root package name */
        private final Rect f7549e = new Rect();

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<BottomAppBar> f7550f;

        /* renamed from: g  reason: collision with root package name */
        private int f7551g;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnLayoutChangeListener f7552h = new a();

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f7550f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.j(Behavior.this.f7549e);
                int height = Behavior.this.f7549e.height();
                bottomAppBar.y0(height);
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f7551g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(c.e.a.b.d.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (com.google.android.material.internal.k.d(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.Q;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.Q;
                    }
                }
            }
        }

        public Behavior() {
        }

        /* renamed from: M */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            this.f7550f = new WeakReference<>(bottomAppBar);
            View o0 = bottomAppBar.o0();
            if (o0 != null && !u.S(o0)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) o0.getLayoutParams();
                fVar.f1002d = 49;
                this.f7551g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (o0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) o0;
                    floatingActionButton.addOnLayoutChangeListener(this.f7552h);
                    bottomAppBar.g0(floatingActionButton);
                }
                bottomAppBar.w0();
            }
            coordinatorLayout.I(bottomAppBar, i2);
            return super.l(coordinatorLayout, bottomAppBar, i2);
        }

        /* renamed from: N */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
