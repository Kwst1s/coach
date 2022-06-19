package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.f;
import b.a.j;
import b.h.k.u;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f414b;

    /* renamed from: c  reason: collision with root package name */
    private View f415c;

    /* renamed from: d  reason: collision with root package name */
    private View f416d;

    /* renamed from: e  reason: collision with root package name */
    private View f417e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f418f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f419g;

    /* renamed from: h  reason: collision with root package name */
    Drawable f420h;

    /* renamed from: i  reason: collision with root package name */
    boolean f421i;

    /* renamed from: j  reason: collision with root package name */
    boolean f422j;

    /* renamed from: k  reason: collision with root package name */
    private int f423k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u.q0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f1998a);
        this.f418f = obtainStyledAttributes.getDrawable(j.f1999b);
        this.f419g = obtainStyledAttributes.getDrawable(j.f2001d);
        this.f423k = obtainStyledAttributes.getDimensionPixelSize(j.f2007j, -1);
        boolean z = true;
        if (getId() == f.split_action_bar) {
            this.f421i = true;
            this.f420h = obtainStyledAttributes.getDrawable(j.f2000c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f421i ? !(this.f418f == null && this.f419g == null) : this.f420h != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f418f;
        if (drawable != null && drawable.isStateful()) {
            this.f418f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f419g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f419g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f420h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f420h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f415c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f418f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f419g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f420h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f416d = findViewById(f.action_bar);
        this.f417e = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f414b || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f415c;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.f421i) {
            Drawable drawable2 = this.f420h;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f418f != null) {
                if (this.f416d.getVisibility() == 0) {
                    this.f418f.setBounds(this.f416d.getLeft(), this.f416d.getTop(), this.f416d.getRight(), this.f416d.getBottom());
                } else {
                    View view2 = this.f417e;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f418f.setBounds(0, 0, 0, 0);
                    } else {
                        this.f418f.setBounds(this.f417e.getLeft(), this.f417e.getTop(), this.f417e.getRight(), this.f417e.getBottom());
                    }
                }
                z3 = true;
            }
            this.f422j = z4;
            if (!z4 || (drawable = this.f419g) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.f416d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.f423k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f416d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.f415c;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f416d)) {
                    i4 = a(this.f416d);
                } else {
                    i4 = !b(this.f417e) ? a(this.f417e) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + a(this.f415c), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f418f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f418f);
        }
        this.f418f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f416d;
            if (view != null) {
                this.f418f.setBounds(view.getLeft(), this.f416d.getTop(), this.f416d.getRight(), this.f416d.getBottom());
            }
        }
        boolean z = true;
        if (!this.f421i ? !(this.f418f == null && this.f419g == null) : this.f420h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f420h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f420h);
        }
        this.f420h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f421i && (drawable2 = this.f420h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f421i ? this.f418f == null && this.f419g == null : this.f420h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f419g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f419g);
        }
        this.f419g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f422j && (drawable2 = this.f419g) != null) {
                drawable2.setBounds(this.f415c.getLeft(), this.f415c.getTop(), this.f415c.getRight(), this.f415c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f421i ? !(this.f418f == null && this.f419g == null) : this.f420h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(j0 j0Var) {
        View view = this.f415c;
        if (view != null) {
            removeView(view);
        }
        this.f415c = j0Var;
        if (j0Var != null) {
            addView(j0Var);
            ViewGroup.LayoutParams layoutParams = j0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            j0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f414b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f418f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f419g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f420h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f418f && !this.f421i) || (drawable == this.f419g && this.f422j) || ((drawable == this.f420h && this.f421i) || super.verifyDrawable(drawable));
    }
}
