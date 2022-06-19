package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.u;

/* compiled from: HeaderBehavior */
abstract class a<V extends View> extends c<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f7503d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f7504e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7505f;

    /* renamed from: g  reason: collision with root package name */
    private int f7506g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f7507h;

    /* renamed from: i  reason: collision with root package name */
    private int f7508i = -1;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f7509j;

    /* JADX WARN: Field signature parse error: c */
    /* access modifiers changed from: private */
    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    /* compiled from: HeaderBehavior */
    public class RunnableC0149a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CoordinatorLayout f7510b;

        /* renamed from: c  reason: collision with root package name */
        private final View f7511c;

        RunnableC0149a(CoordinatorLayout coordinatorLayout, V v) {
            this.f7510b = coordinatorLayout;
            this.f7511c = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.google.android.material.appbar.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.google.android.material.appbar.a */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            OverScroller overScroller;
            if (this.f7511c != null && (overScroller = a.this.f7504e) != null) {
                if (overScroller.computeScrollOffset()) {
                    a aVar = a.this;
                    aVar.P(this.f7510b, this.f7511c, aVar.f7504e.getCurrY());
                    u.e0(this.f7511c, this);
                    return;
                }
                a.this.N(this.f7510b, this.f7511c);
            }
        }
    }

    public a() {
    }

    private void I() {
        if (this.f7509j == null) {
            this.f7509j = VelocityTracker.obtain();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract boolean H(V v);

    /* access modifiers changed from: package-private */
    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.f7503d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f7503d = null;
        }
        if (this.f7504e == null) {
            this.f7504e = new OverScroller(v.getContext());
        }
        this.f7504e.fling(0, E(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f7504e.computeScrollOffset()) {
            RunnableC0149a aVar = new RunnableC0149a(coordinatorLayout, v);
            this.f7503d = aVar;
            u.e0(v, aVar);
            return true;
        }
        N(coordinatorLayout, v);
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract int K(V v);

    /* access modifiers changed from: package-private */
    public abstract int L(V v);

    /* access modifiers changed from: package-private */
    public abstract int M();

    /* access modifiers changed from: package-private */
    public abstract void N(CoordinatorLayout coordinatorLayout, V v);

    /* access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return Q(coordinatorLayout, v, M() - i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return Q(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public abstract int Q(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f7508i < 0) {
            this.f7508i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f7505f) {
            int i2 = this.f7506g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f7507h) > this.f7508i) {
                this.f7507h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f7506g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = H(v) && coordinatorLayout.B(v, x, y2);
            this.f7505f = z;
            if (z) {
                this.f7507h = y2;
                this.f7506g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f7504e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f7504e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f7509j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
