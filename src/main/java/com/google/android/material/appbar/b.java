package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.g.a;
import b.h.k.c0;
import b.h.k.e;
import b.h.k.u;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior */
abstract class b extends c<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f7513d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    final Rect f7514e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private int f7515f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f7516g;

    public b() {
    }

    private static int N(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void F(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View H = H(coordinatorLayout.r(view));
        if (H != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f7513d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            c0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.y(coordinatorLayout) && !u.y(view)) {
                rect.left += lastWindowInsets.g();
                rect.right -= lastWindowInsets.h();
            }
            Rect rect2 = this.f7514e;
            e.a(N(fVar.f1001c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f7515f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view, i2);
        this.f7515f = 0;
    }

    /* access modifiers changed from: package-private */
    public abstract View H(List<View> list);

    /* access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f7516g == 0) {
            return 0;
        }
        float J = J(view);
        int i2 = this.f7516g;
        return a.b((int) (J * ((float) i2)), 0, i2);
    }

    /* access modifiers changed from: package-private */
    public abstract float J(View view);

    public final int K() {
        return this.f7516g;
    }

    /* access modifiers changed from: package-private */
    public int L(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int M() {
        return this.f7515f;
    }

    public final void O(int i2) {
        this.f7516g = i2;
    }

    /* access modifiers changed from: protected */
    public boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View H;
        c0 lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (H = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (u.y(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.i() + lastWindowInsets.f();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            L -= measuredHeight;
        }
        coordinatorLayout.J(view, i2, i3, View.MeasureSpec.makeMeasureSpec(L, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
