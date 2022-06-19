package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.u;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f8100a = 0;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f8101b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8102c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c.e.a.b.w.a f8103d;

        a(View view, int i2, c.e.a.b.w.a aVar) {
            this.f8101b = view;
            this.f8102c = i2;
            this.f8103d = aVar;
        }

        public boolean onPreDraw() {
            this.f8101b.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f8100a == this.f8102c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                c.e.a.b.w.a aVar = this.f8103d;
                expandableBehavior.H((View) aVar, this.f8101b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    private boolean F(boolean z) {
        if (z) {
            int i2 = this.f8100a;
            return i2 == 0 || i2 == 2;
        } else if (this.f8100a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public c.e.a.b.w.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r = coordinatorLayout.r(view);
        int size = r.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = r.get(i2);
            if (e(coordinatorLayout, view, view2)) {
                return (c.e.a.b.w.a) view2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean H(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        c.e.a.b.w.a aVar = (c.e.a.b.w.a) view2;
        if (!F(aVar.a())) {
            return false;
        }
        this.f8100a = aVar.a() ? 1 : 2;
        return H((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        c.e.a.b.w.a G;
        if (u.S(view) || (G = G(coordinatorLayout, view)) == null || !F(G.a())) {
            return false;
        }
        int i3 = G.a() ? 1 : 2;
        this.f8100a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
