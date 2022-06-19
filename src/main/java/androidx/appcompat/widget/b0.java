package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import b.a.j;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: LinearLayoutCompat */
public class b0 extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private boolean f561b;

    /* renamed from: c  reason: collision with root package name */
    private int f562c;

    /* renamed from: d  reason: collision with root package name */
    private int f563d;

    /* renamed from: e  reason: collision with root package name */
    private int f564e;

    /* renamed from: f  reason: collision with root package name */
    private int f565f;

    /* renamed from: g  reason: collision with root package name */
    private int f566g;

    /* renamed from: h  reason: collision with root package name */
    private float f567h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f568i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f569j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f570k;
    private Drawable l;
    private int m;
    private int n;
    private int o;
    private int p;

    public b0(Context context) {
        this(context, null);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void k(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = s.getMeasuredWidth();
                    measureChildWithMargins(s, i3, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void l(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = s.getMeasuredHeight();
                    measureChildWithMargins(s, makeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i5;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int virtualChildCount = getVirtualChildCount();
        boolean b2 = w0.b(this);
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View s = s(i6);
            if (!(s == null || s.getVisibility() == 8 || !t(i6))) {
                a aVar = (a) s.getLayoutParams();
                if (b2) {
                    i5 = s.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                } else {
                    i5 = (s.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.m;
                }
                j(canvas, i5);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 != null) {
                a aVar2 = (a) s2.getLayoutParams();
                if (b2) {
                    i4 = s2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i3 = this.m;
                } else {
                    i2 = s2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                    j(canvas, i2);
                }
            } else if (b2) {
                i2 = getPaddingLeft();
                j(canvas, i2);
            } else {
                i4 = getWidth() - getPaddingRight();
                i3 = this.m;
            }
            i2 = i4 - i3;
            j(canvas, i2);
        }
    }

    public int getBaseline() {
        int i2;
        if (this.f562c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f562c;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f563d;
                if (this.f564e == 1 && (i2 = this.f565f & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f566g) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f566g;
                    }
                }
                return i4 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.f562c == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f562c;
    }

    public Drawable getDividerDrawable() {
        return this.l;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f565f;
    }

    public int getOrientation() {
        return this.f564e;
    }

    public int getShowDividers() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f567h;
    }

    /* access modifiers changed from: package-private */
    public void h(Canvas canvas) {
        int i2;
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View s = s(i3);
            if (!(s == null || s.getVisibility() == 8 || !t(i3))) {
                i(canvas, (s.getTop() - ((ViewGroup.MarginLayoutParams) ((a) s.getLayoutParams())).topMargin) - this.n);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 == null) {
                i2 = (getHeight() - getPaddingBottom()) - this.n;
            } else {
                i2 = s2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) s2.getLayoutParams())).bottomMargin;
            }
            i(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Canvas canvas, int i2) {
        this.l.setBounds(getPaddingLeft() + this.p, i2, (getWidth() - getPaddingRight()) - this.p, this.n + i2);
        this.l.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void j(Canvas canvas, int i2) {
        this.l.setBounds(i2, getPaddingTop() + this.p, this.m + i2, (getHeight() - getPaddingBottom()) - this.p);
        this.l.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public a generateDefaultLayoutParams() {
        int i2 = this.f564e;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: n */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.l != null) {
            if (this.f564e == 1) {
                h(canvas);
            } else {
                g(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f564e == 1) {
            v(i2, i3, i4, i5);
        } else {
            u(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f564e == 1) {
            z(i2, i3);
        } else {
            x(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public int p(View view, int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int q(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int r(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View s(int i2) {
        return getChildAt(i2);
    }

    public void setBaselineAligned(boolean z) {
        this.f561b = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f562c = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.l) {
            this.l = drawable;
            boolean z = false;
            if (drawable != null) {
                this.m = drawable.getIntrinsicWidth();
                this.n = drawable.getIntrinsicHeight();
            } else {
                this.m = 0;
                this.n = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.p = i2;
    }

    public void setGravity(int i2) {
        if (this.f565f != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f565f = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f565f;
        if ((8388615 & i4) != i3) {
            this.f565f = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f568i = z;
    }

    public void setOrientation(int i2) {
        if (this.f564e != i2) {
            this.f564e = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.o) {
            requestLayout();
        }
        this.o = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f565f;
        if ((i4 & 112) != i3) {
            this.f565f = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f567h = Math.max((float) Utils.FLOAT_EPSILON, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean t(int i2) {
        if (i2 == 0) {
            return (this.o & 1) != 0;
        }
        if (i2 == getChildCount()) {
            if ((this.o & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.o & 2) == 0) {
            return false;
        } else {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u(int r25, int r26, int r27, int r28) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.u(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(int r18, int r19, int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.v(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void w(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(int r38, int r39) {
        /*
        // Method dump skipped, instructions count: 1288
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.x(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int y(int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0323  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z(int r34, int r35) {
        /*
        // Method dump skipped, instructions count: 911
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.z(int, int):void");
    }

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f561b = true;
        this.f562c = -1;
        this.f563d = 0;
        this.f565f = 8388659;
        int[] iArr = j.Q0;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        u.k0(this, context, iArr, attributeSet, v.r(), i2, 0);
        int k2 = v.k(j.S0, -1);
        if (k2 >= 0) {
            setOrientation(k2);
        }
        int k3 = v.k(j.R0, -1);
        if (k3 >= 0) {
            setGravity(k3);
        }
        boolean a2 = v.a(j.T0, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.f567h = v.i(j.V0, -1.0f);
        this.f562c = v.k(j.U0, -1);
        this.f568i = v.a(j.Y0, false);
        setDividerDrawable(v.g(j.W0));
        this.o = v.k(j.Z0, 0);
        this.p = v.f(j.X0, 0);
        v.w();
    }

    /* compiled from: LinearLayoutCompat */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public float f571a;

        /* renamed from: b  reason: collision with root package name */
        public int f572b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f572b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.a1);
            this.f571a = obtainStyledAttributes.getFloat(j.c1, Utils.FLOAT_EPSILON);
            this.f572b = obtainStyledAttributes.getInt(j.b1, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f572b = -1;
            this.f571a = Utils.FLOAT_EPSILON;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f572b = -1;
        }
    }
}
