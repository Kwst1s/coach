package com.chauthai.swipereveallayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b.h.k.u;
import b.j.b.c;
import com.github.mikephil.charting.utils.Utils;

@SuppressLint({"RtlHardcoded"})
public class SwipeRevealLayout extends ViewGroup {
    private final GestureDetector.OnGestureListener A = new a();
    private final c.AbstractC0054c B = new b();

    /* renamed from: b  reason: collision with root package name */
    private View f4390b;

    /* renamed from: c  reason: collision with root package name */
    private View f4391c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f4392d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private Rect f4393e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private Rect f4394f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private Rect f4395g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private int f4396h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4397i = false;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f4398j = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f4399k = false;
    private volatile boolean l = false;
    private int m = 300;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 1;
    private float s = Utils.FLOAT_EPSILON;
    private float t = -1.0f;
    private float u = -1.0f;
    private b.j.b.c v;
    private b.h.k.d w;
    private c x;
    private d y;
    private int z = 0;

    class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        boolean f4400b = false;

        a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            SwipeRevealLayout.this.f4399k = false;
            this.f4400b = false;
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            SwipeRevealLayout.this.f4399k = true;
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z = true;
            SwipeRevealLayout.this.f4399k = true;
            if (SwipeRevealLayout.this.getParent() != null) {
                if (!this.f4400b) {
                    boolean z2 = SwipeRevealLayout.this.getDistToClosestEdge() >= SwipeRevealLayout.this.f4396h;
                    if (z2) {
                        this.f4400b = true;
                    }
                    z = z2;
                }
                SwipeRevealLayout.this.getParent().requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }
    }

    class b extends c.AbstractC0054c {
        b() {
        }

        private float n() {
            float left;
            int width;
            int i2 = SwipeRevealLayout.this.r;
            if (i2 == 1) {
                left = (float) (SwipeRevealLayout.this.f4390b.getLeft() - SwipeRevealLayout.this.f4392d.left);
                width = SwipeRevealLayout.this.f4391c.getWidth();
            } else if (i2 == 2) {
                left = (float) (SwipeRevealLayout.this.f4392d.left - SwipeRevealLayout.this.f4390b.getLeft());
                width = SwipeRevealLayout.this.f4391c.getWidth();
            } else if (i2 == 4) {
                left = (float) (SwipeRevealLayout.this.f4390b.getTop() - SwipeRevealLayout.this.f4392d.top);
                width = SwipeRevealLayout.this.f4391c.getHeight();
            } else if (i2 != 8) {
                return Utils.FLOAT_EPSILON;
            } else {
                left = (float) (SwipeRevealLayout.this.f4392d.top - SwipeRevealLayout.this.f4390b.getTop());
                width = SwipeRevealLayout.this.f4391c.getHeight();
            }
            return left / ((float) width);
        }

        @Override // b.j.b.c.AbstractC0054c
        public int a(View view, int i2, int i3) {
            int i4 = SwipeRevealLayout.this.r;
            if (i4 == 1) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.f4392d.left + SwipeRevealLayout.this.f4391c.getWidth()), SwipeRevealLayout.this.f4392d.left);
            }
            if (i4 != 2) {
                return view.getLeft();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.f4392d.left), SwipeRevealLayout.this.f4392d.left - SwipeRevealLayout.this.f4391c.getWidth());
        }

        @Override // b.j.b.c.AbstractC0054c
        public int b(View view, int i2, int i3) {
            int i4 = SwipeRevealLayout.this.r;
            if (i4 == 4) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.f4392d.top + SwipeRevealLayout.this.f4391c.getHeight()), SwipeRevealLayout.this.f4392d.top);
            }
            if (i4 != 8) {
                return view.getTop();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.f4392d.top), SwipeRevealLayout.this.f4392d.top - SwipeRevealLayout.this.f4391c.getHeight());
        }

        @Override // b.j.b.c.AbstractC0054c
        public void f(int i2, int i3) {
            super.f(i2, i3);
            if (!SwipeRevealLayout.this.l) {
                boolean z = false;
                boolean z2 = SwipeRevealLayout.this.r == 2 && i2 == 1;
                boolean z3 = SwipeRevealLayout.this.r == 1 && i2 == 2;
                boolean z4 = SwipeRevealLayout.this.r == 8 && i2 == 4;
                if (SwipeRevealLayout.this.r == 4 && i2 == 8) {
                    z = true;
                }
                if (z2 || z3 || z4 || z) {
                    SwipeRevealLayout.this.v.c(SwipeRevealLayout.this.f4390b, i3);
                }
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void j(int i2) {
            super.j(i2);
            int i3 = SwipeRevealLayout.this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    SwipeRevealLayout.this.n = 4;
                }
            } else if (SwipeRevealLayout.this.r == 1 || SwipeRevealLayout.this.r == 2) {
                if (SwipeRevealLayout.this.f4390b.getLeft() == SwipeRevealLayout.this.f4392d.left) {
                    SwipeRevealLayout.this.n = 0;
                } else {
                    SwipeRevealLayout.this.n = 2;
                }
            } else if (SwipeRevealLayout.this.f4390b.getTop() == SwipeRevealLayout.this.f4392d.top) {
                SwipeRevealLayout.this.n = 0;
            } else {
                SwipeRevealLayout.this.n = 2;
            }
            if (SwipeRevealLayout.this.x != null && !SwipeRevealLayout.this.f4398j && i3 != SwipeRevealLayout.this.n) {
                SwipeRevealLayout.this.x.a(SwipeRevealLayout.this.n);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void k(View view, int i2, int i3, int i4, int i5) {
            super.k(view, i2, i3, i4, i5);
            boolean z = true;
            if (SwipeRevealLayout.this.o == 1) {
                if (SwipeRevealLayout.this.r == 1 || SwipeRevealLayout.this.r == 2) {
                    SwipeRevealLayout.this.f4391c.offsetLeftAndRight(i4);
                } else {
                    SwipeRevealLayout.this.f4391c.offsetTopAndBottom(i5);
                }
            }
            if (SwipeRevealLayout.this.f4390b.getLeft() == SwipeRevealLayout.this.p && SwipeRevealLayout.this.f4390b.getTop() == SwipeRevealLayout.this.q) {
                z = false;
            }
            if (SwipeRevealLayout.this.y != null && z) {
                if (SwipeRevealLayout.this.f4390b.getLeft() == SwipeRevealLayout.this.f4392d.left && SwipeRevealLayout.this.f4390b.getTop() == SwipeRevealLayout.this.f4392d.top) {
                    SwipeRevealLayout.this.y.a(SwipeRevealLayout.this);
                } else if (SwipeRevealLayout.this.f4390b.getLeft() == SwipeRevealLayout.this.f4393e.left && SwipeRevealLayout.this.f4390b.getTop() == SwipeRevealLayout.this.f4393e.top) {
                    SwipeRevealLayout.this.y.c(SwipeRevealLayout.this);
                } else {
                    SwipeRevealLayout.this.y.b(SwipeRevealLayout.this, n());
                }
            }
            SwipeRevealLayout swipeRevealLayout = SwipeRevealLayout.this;
            swipeRevealLayout.p = swipeRevealLayout.f4390b.getLeft();
            SwipeRevealLayout swipeRevealLayout2 = SwipeRevealLayout.this;
            swipeRevealLayout2.q = swipeRevealLayout2.f4390b.getTop();
            u.d0(SwipeRevealLayout.this);
        }

        @Override // b.j.b.c.AbstractC0054c
        public void l(View view, float f2, float f3) {
            int i2 = (int) f2;
            boolean z = false;
            boolean z2 = SwipeRevealLayout.this.J(i2) >= SwipeRevealLayout.this.m;
            boolean z3 = SwipeRevealLayout.this.J(i2) <= (-SwipeRevealLayout.this.m);
            int i3 = (int) f3;
            boolean z4 = SwipeRevealLayout.this.J(i3) <= (-SwipeRevealLayout.this.m);
            if (SwipeRevealLayout.this.J(i3) >= SwipeRevealLayout.this.m) {
                z = true;
            }
            int halfwayPivotHorizontal = SwipeRevealLayout.this.getHalfwayPivotHorizontal();
            int halfwayPivotVertical = SwipeRevealLayout.this.getHalfwayPivotVertical();
            int i4 = SwipeRevealLayout.this.r;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 4) {
                        if (i4 == 8) {
                            if (z4) {
                                SwipeRevealLayout.this.I(true);
                            } else if (z) {
                                SwipeRevealLayout.this.B(true);
                            } else if (SwipeRevealLayout.this.f4390b.getBottom() < halfwayPivotVertical) {
                                SwipeRevealLayout.this.I(true);
                            } else {
                                SwipeRevealLayout.this.B(true);
                            }
                        }
                    } else if (z4) {
                        SwipeRevealLayout.this.B(true);
                    } else if (z) {
                        SwipeRevealLayout.this.I(true);
                    } else if (SwipeRevealLayout.this.f4390b.getTop() < halfwayPivotVertical) {
                        SwipeRevealLayout.this.B(true);
                    } else {
                        SwipeRevealLayout.this.I(true);
                    }
                } else if (z2) {
                    SwipeRevealLayout.this.B(true);
                } else if (z3) {
                    SwipeRevealLayout.this.I(true);
                } else if (SwipeRevealLayout.this.f4390b.getRight() < halfwayPivotHorizontal) {
                    SwipeRevealLayout.this.I(true);
                } else {
                    SwipeRevealLayout.this.B(true);
                }
            } else if (z2) {
                SwipeRevealLayout.this.I(true);
            } else if (z3) {
                SwipeRevealLayout.this.B(true);
            } else if (SwipeRevealLayout.this.f4390b.getLeft() < halfwayPivotHorizontal) {
                SwipeRevealLayout.this.B(true);
            } else {
                SwipeRevealLayout.this.I(true);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public boolean m(View view, int i2) {
            SwipeRevealLayout.this.f4398j = false;
            if (SwipeRevealLayout.this.l) {
                return false;
            }
            SwipeRevealLayout.this.v.c(SwipeRevealLayout.this.f4390b, i2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public interface c {
        void a(int i2);
    }

    public interface d {
        void a(SwipeRevealLayout swipeRevealLayout);

        void b(SwipeRevealLayout swipeRevealLayout, float f2);

        void c(SwipeRevealLayout swipeRevealLayout);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context, attributeSet);
    }

    private void A(MotionEvent motionEvent) {
        float f2;
        if (motionEvent.getAction() == 0) {
            this.s = Utils.FLOAT_EPSILON;
            return;
        }
        boolean z2 = true;
        if (!(getDragEdge() == 1 || getDragEdge() == 2)) {
            z2 = false;
        }
        if (z2) {
            f2 = Math.abs(motionEvent.getX() - this.t);
        } else {
            f2 = Math.abs(motionEvent.getY() - this.u);
        }
        this.s += f2;
    }

    private boolean C(MotionEvent motionEvent) {
        return H(motionEvent) && !K();
    }

    private int D(int i2) {
        return (int) (((float) i2) * (((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private void E(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f4403a, 0, 0);
            this.r = obtainStyledAttributes.getInteger(a.f4404b, 1);
            this.m = obtainStyledAttributes.getInteger(a.f4405c, 300);
            this.o = obtainStyledAttributes.getInteger(a.f4407e, 0);
            this.f4396h = obtainStyledAttributes.getDimensionPixelSize(a.f4406d, D(1));
        }
        b.j.b.c o2 = b.j.b.c.o(this, 1.0f, this.B);
        this.v = o2;
        o2.L(15);
        this.w = new b.h.k.d(context, this.A);
    }

    private void F() {
        this.f4392d.set(this.f4390b.getLeft(), this.f4390b.getTop(), this.f4390b.getRight(), this.f4390b.getBottom());
        this.f4394f.set(this.f4391c.getLeft(), this.f4391c.getTop(), this.f4391c.getRight(), this.f4391c.getBottom());
        this.f4393e.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.f4390b.getWidth(), getMainOpenTop() + this.f4390b.getHeight());
        this.f4395g.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.f4391c.getWidth(), getSecOpenTop() + this.f4391c.getHeight());
    }

    private boolean H(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        boolean z2 = ((float) this.f4390b.getTop()) <= y2 && y2 <= ((float) this.f4390b.getBottom());
        boolean z3 = ((float) this.f4390b.getLeft()) <= x2 && x2 <= ((float) this.f4390b.getRight());
        if (!z2 || !z3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int J(int i2) {
        return (int) (((float) i2) / (((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private boolean K() {
        return this.s >= ((float) this.v.z());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getDistToClosestEdge() {
        int i2 = this.r;
        if (i2 == 1) {
            return Math.min(this.f4390b.getLeft() - this.f4392d.left, (this.f4392d.left + this.f4391c.getWidth()) - this.f4390b.getLeft());
        } else if (i2 == 2) {
            return Math.min(this.f4390b.getRight() - (this.f4392d.right - this.f4391c.getWidth()), this.f4392d.right - this.f4390b.getRight());
        } else if (i2 == 4) {
            int height = this.f4392d.top + this.f4391c.getHeight();
            return Math.min(this.f4390b.getBottom() - height, height - this.f4390b.getTop());
        } else if (i2 != 8) {
            return 0;
        } else {
            return Math.min(this.f4392d.bottom - this.f4390b.getBottom(), this.f4390b.getBottom() - (this.f4392d.bottom - this.f4391c.getHeight()));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getHalfwayPivotHorizontal() {
        if (this.r == 1) {
            return this.f4392d.left + (this.f4391c.getWidth() / 2);
        }
        return this.f4392d.right - (this.f4391c.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getHalfwayPivotVertical() {
        if (this.r == 4) {
            return this.f4392d.top + (this.f4391c.getHeight() / 2);
        }
        return this.f4392d.bottom - (this.f4391c.getHeight() / 2);
    }

    private int getMainOpenLeft() {
        int i2 = this.r;
        if (i2 == 1) {
            return this.f4392d.left + this.f4391c.getWidth();
        }
        if (i2 == 2) {
            return this.f4392d.left - this.f4391c.getWidth();
        }
        if (i2 == 4) {
            return this.f4392d.left;
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f4392d.left;
    }

    private int getMainOpenTop() {
        int i2 = this.r;
        if (i2 == 1) {
            return this.f4392d.top;
        }
        if (i2 == 2) {
            return this.f4392d.top;
        }
        if (i2 == 4) {
            return this.f4392d.top + this.f4391c.getHeight();
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f4392d.top - this.f4391c.getHeight();
    }

    private int getSecOpenLeft() {
        int i2;
        if (this.o == 0 || (i2 = this.r) == 8 || i2 == 4) {
            return this.f4394f.left;
        }
        if (i2 == 1) {
            return this.f4394f.left + this.f4391c.getWidth();
        }
        return this.f4394f.left - this.f4391c.getWidth();
    }

    private int getSecOpenTop() {
        int i2;
        if (this.o == 0 || (i2 = this.r) == 1 || i2 == 2) {
            return this.f4394f.top;
        }
        if (i2 == 4) {
            return this.f4394f.top + this.f4391c.getHeight();
        }
        return this.f4394f.top - this.f4391c.getHeight();
    }

    public void B(boolean z2) {
        this.f4397i = false;
        this.f4398j = false;
        if (z2) {
            this.n = 1;
            b.j.b.c cVar = this.v;
            View view = this.f4390b;
            Rect rect = this.f4392d;
            cVar.P(view, rect.left, rect.top);
            c cVar2 = this.x;
            if (cVar2 != null) {
                cVar2.a(this.n);
            }
        } else {
            this.n = 0;
            this.v.a();
            View view2 = this.f4390b;
            Rect rect2 = this.f4392d;
            view2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            View view3 = this.f4391c;
            Rect rect3 = this.f4394f;
            view3.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        u.d0(this);
    }

    public boolean G() {
        return this.l;
    }

    public void I(boolean z2) {
        this.f4397i = true;
        this.f4398j = false;
        if (z2) {
            this.n = 3;
            b.j.b.c cVar = this.v;
            View view = this.f4390b;
            Rect rect = this.f4393e;
            cVar.P(view, rect.left, rect.top);
            c cVar2 = this.x;
            if (cVar2 != null) {
                cVar2.a(this.n);
            }
        } else {
            this.n = 2;
            this.v.a();
            View view2 = this.f4390b;
            Rect rect2 = this.f4393e;
            view2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            View view3 = this.f4391c;
            Rect rect3 = this.f4395g;
            view3.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        u.d0(this);
    }

    /* access modifiers changed from: protected */
    public boolean L() {
        return this.z < 2;
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f4398j = true;
        this.v.a();
    }

    public void computeScroll() {
        if (this.v.n(true)) {
            u.d0(this);
        }
    }

    public int getDragEdge() {
        return this.r;
    }

    public int getMinFlingVelocity() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.f4391c = getChildAt(0);
            this.f4390b = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.f4390b = getChildAt(0);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (G()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.v.F(motionEvent);
        this.w.a(motionEvent);
        A(motionEvent);
        boolean C = C(motionEvent);
        boolean z2 = this.v.A() == 2;
        boolean z3 = this.v.A() == 0 && this.f4399k;
        this.t = motionEvent.getX();
        this.u = motionEvent.getY();
        if (C || (!z2 && !z3)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        boolean z4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        this.f4398j = false;
        int i11 = 0;
        while (i11 < getChildCount()) {
            View childAt = getChildAt(i11);
            int paddingLeft = getPaddingLeft();
            int max = Math.max((i4 - getPaddingRight()) - i2, i10);
            int paddingTop = getPaddingTop();
            int max2 = Math.max((i5 - getPaddingBottom()) - i3, i10);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams != null) {
                int i12 = layoutParams.height;
                z3 = i12 == -1 || i12 == -1;
                int i13 = layoutParams.width;
                z4 = i13 == -1 || i13 == -1;
            } else {
                z4 = false;
                z3 = false;
            }
            if (z3) {
                measuredHeight = max2 - paddingTop;
                layoutParams.height = measuredHeight;
            }
            if (z4) {
                measuredWidth = max - paddingLeft;
                layoutParams.width = measuredWidth;
            }
            int i14 = this.r;
            if (i14 == 1) {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i14 == 2) {
                i9 = Math.max(((i4 - measuredWidth) - getPaddingRight()) - i2, paddingLeft);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.max((i4 - getPaddingRight()) - i2, paddingLeft);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i14 == 4) {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i14 != 8) {
                i9 = 0;
                i8 = 0;
                i7 = 0;
                i6 = 0;
            } else {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.max(((i5 - measuredHeight) - getPaddingBottom()) - i3, paddingTop);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.max((i5 - getPaddingBottom()) - i3, paddingTop);
            }
            childAt.layout(i9, i8, i7, i6);
            i11++;
            i10 = 0;
        }
        if (this.o == 1) {
            int i15 = this.r;
            if (i15 == 1) {
                View view = this.f4391c;
                view.offsetLeftAndRight(-view.getWidth());
            } else if (i15 == 2) {
                View view2 = this.f4391c;
                view2.offsetLeftAndRight(view2.getWidth());
            } else if (i15 == 4) {
                View view3 = this.f4391c;
                view3.offsetTopAndBottom(-view3.getHeight());
            } else if (i15 == 8) {
                View view4 = this.f4391c;
                view4.offsetTopAndBottom(view4.getHeight());
            }
        }
        F();
        if (this.f4397i) {
            I(false);
        } else {
            B(false);
        }
        this.p = this.f4390b.getLeft();
        this.q = this.f4390b.getTop();
        this.z++;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (getChildCount() >= 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                measureChild(childAt, i2, i3);
                i4 = Math.max(childAt.getMeasuredWidth(), i4);
                i5 = Math.max(childAt.getMeasuredHeight(), i5);
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, mode);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, mode2);
            int size = View.MeasureSpec.getSize(makeMeasureSpec);
            int size2 = View.MeasureSpec.getSize(makeMeasureSpec2);
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt2 = getChildAt(i7);
                ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                if (layoutParams2 != null) {
                    if (layoutParams2.height == -1) {
                        childAt2.setMinimumHeight(size2);
                    }
                    if (layoutParams2.width == -1) {
                        childAt2.setMinimumWidth(size);
                    }
                }
                measureChild(childAt2, makeMeasureSpec, makeMeasureSpec2);
                i4 = Math.max(childAt2.getMeasuredWidth(), i4);
                i5 = Math.max(childAt2.getMeasuredHeight(), i5);
            }
            int paddingLeft = i4 + getPaddingLeft() + getPaddingRight();
            int paddingTop = i5 + getPaddingTop() + getPaddingBottom();
            if (mode != 1073741824) {
                if (layoutParams.width == -1) {
                    paddingLeft = size;
                }
                if (mode != Integer.MIN_VALUE || paddingLeft <= size) {
                    size = paddingLeft;
                }
            }
            if (mode2 != 1073741824) {
                if (layoutParams.height == -1) {
                    paddingTop = size2;
                }
                if (mode2 != Integer.MIN_VALUE || paddingTop <= size2) {
                    size2 = paddingTop;
                }
            }
            setMeasuredDimension(size, size2);
            return;
        }
        throw new RuntimeException("Layout must have two children");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.w.a(motionEvent);
        this.v.F(motionEvent);
        return true;
    }

    public void setDragEdge(int i2) {
        this.r = i2;
    }

    /* access modifiers changed from: package-private */
    public void setDragStateChangeListener(c cVar) {
        this.x = cVar;
    }

    public void setLockDrag(boolean z2) {
        this.l = z2;
    }

    public void setMinFlingVelocity(int i2) {
        this.m = i2;
    }

    public void setSwipeListener(d dVar) {
        this.y = dVar;
    }
}
