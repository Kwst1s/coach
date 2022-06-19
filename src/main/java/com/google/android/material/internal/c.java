package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b.h.k.h;
import b.h.k.u;
import c.e.a.b.f;
import c.e.a.b.l;

/* compiled from: FlowLayout */
public class c extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f7830b;

    /* renamed from: c  reason: collision with root package name */
    private int f7831c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7832d;

    /* renamed from: e  reason: collision with root package name */
    private int f7833e;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l.W0, 0, 0);
        this.f7830b = obtainStyledAttributes.getDimensionPixelSize(l.Y0, 0);
        this.f7831c = obtainStyledAttributes.getDimensionPixelSize(l.X0, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(f.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean c() {
        return this.f7832d;
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.f7831c;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.f7830b;
    }

    /* access modifiers changed from: protected */
    public int getRowCount() {
        return this.f7833e;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (getChildCount() == 0) {
            this.f7833e = 0;
            return;
        }
        this.f7833e = 1;
        boolean z2 = u.B(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i8 = (i4 - i2) - paddingLeft;
        int i9 = paddingRight;
        int i10 = paddingTop;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(f.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = h.b(marginLayoutParams);
                    i7 = h.a(marginLayoutParams);
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                int measuredWidth = i9 + i6 + childAt.getMeasuredWidth();
                if (!this.f7832d && measuredWidth > i8) {
                    i10 = this.f7830b + paddingTop;
                    this.f7833e++;
                    i9 = paddingRight;
                }
                childAt.setTag(f.row_index_key, Integer.valueOf(this.f7833e - 1));
                int i12 = i9 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (z2) {
                    childAt.layout(i8 - measuredWidth2, i10, (i8 - i9) - i6, measuredHeight);
                } else {
                    childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                }
                i9 += i6 + i7 + childAt.getMeasuredWidth() + this.f7831c;
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                if (paddingLeft + i5 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    i6 = paddingLeft;
                } else {
                    i6 = getPaddingLeft();
                    i8 = this.f7830b + paddingTop;
                }
                int measuredWidth = i6 + i5 + childAt.getMeasuredWidth();
                int measuredHeight = i8 + childAt.getMeasuredHeight();
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                paddingLeft = i6 + i5 + i4 + childAt.getMeasuredWidth() + this.f7831c;
                if (i10 == getChildCount() - 1) {
                    i9 += i4;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i9 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.f7831c = i2;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.f7830b = i2;
    }

    public void setSingleLine(boolean z) {
        this.f7832d = z;
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7832d = false;
        d(context, attributeSet);
    }
}
