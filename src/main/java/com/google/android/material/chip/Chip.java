package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import b.h.k.d0.c;
import b.h.k.u;
import c.e.a.b.c0.n;
import c.e.a.b.j;
import c.e.a.b.k;
import c.e.a.b.l;
import c.e.a.b.m.h;
import c.e.a.b.z.d;
import c.e.a.b.z.f;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.chip.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements a.AbstractC0150a, n {
    private static final int u = k.Widget_MaterialComponents_Chip_Action;
    private static final Rect v = new Rect();
    private static final int[] w = {16842913};
    private static final int[] x = {16842911};

    /* renamed from: e  reason: collision with root package name */
    private a f7643e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f7644f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f7645g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f7646h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f7647i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7648j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7649k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final c q;
    private final Rect r;
    private final RectF s;
    private final f t;

    class a extends f {
        a() {
        }

        @Override // c.e.a.b.z.f
        public void a(int i2) {
        }

        @Override // c.e.a.b.z.f
        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.f7643e.L2() ? Chip.this.f7643e.h1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f7643e != null) {
                Chip.this.f7643e.getOutline(outline);
            } else {
                outline.setAlpha(Utils.FLOAT_EPSILON);
            }
        }
    }

    /* access modifiers changed from: private */
    public class c extends b.j.b.a {
        c(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public int B(float f2, float f3) {
            return (!Chip.this.n() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f7646h != null) {
                list.add(1);
            }
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public boolean J(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public void M(b.h.k.d0.c cVar) {
            cVar.Y(Chip.this.r());
            cVar.b0(Chip.this.isClickable());
            if (Chip.this.r() || Chip.this.isClickable()) {
                cVar.a0(Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                cVar.a0("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.A0(text);
            } else {
                cVar.e0(text);
            }
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public void N(int i2, b.h.k.d0.c cVar) {
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.e0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = j.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    cVar.e0(context.getString(i3, objArr).trim());
                }
                cVar.W(Chip.this.getCloseIconTouchBoundsInt());
                cVar.b(c.a.f2642g);
                cVar.g0(Chip.this.isEnabled());
                return;
            }
            cVar.e0(charSequence);
            cVar.W(Chip.v);
        }

        /* access modifiers changed from: protected */
        @Override // b.j.b.a
        public void O(int i2, boolean z) {
            if (i2 == 1) {
                Chip.this.m = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.chipStyle);
    }

    private void A() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f7643e) != null) {
            int J0 = (int) (aVar.J0() + this.f7643e.j1() + this.f7643e.q0());
            int O0 = (int) (this.f7643e.O0() + this.f7643e.k1() + this.f7643e.m0());
            if (this.f7644f != null) {
                Rect rect = new Rect();
                this.f7644f.getPadding(rect);
                O0 += rect.left;
                J0 += rect.right;
            }
            u.A0(this, O0, getPaddingTop(), J0, getPaddingBottom());
        }
    }

    private void B() {
        TextPaint paint = getPaint();
        a aVar = this.f7643e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i(getContext(), paint, this.t);
        }
    }

    private void C(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (n()) {
            this.f7643e.Y0(this.s);
        }
        return this.s;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    private d getTextAppearance() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.i1();
        }
        return null;
    }

    private void i(a aVar) {
        aVar.p2(this);
    }

    private int[] j() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.m) {
            i3++;
        }
        if (this.l) {
            i3++;
        }
        if (this.f7649k) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.m) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.l) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f7649k) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.f7644f && this.f7643e.getCallback() == null) {
            this.f7643e.setCallback(this.f7644f);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean m(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = b.j.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = b.j.b.a.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.q, Integer.MIN_VALUE);
                    return true;
                }
            } catch (NoSuchMethodException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (IllegalAccessException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (NoSuchFieldException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean n() {
        a aVar = this.f7643e;
        return (aVar == null || aVar.R0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i2) {
        TypedArray h2 = com.google.android.material.internal.j.h(context, attributeSet, l.y, i2, u, new int[0]);
        this.n = h2.getBoolean(l.f0, false);
        this.p = (int) Math.ceil((double) h2.getDimension(l.T, (float) Math.ceil((double) com.google.android.material.internal.k.b(getContext(), 48))));
        h2.recycle();
    }

    private void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void q(int i2, int i3, int i4, int i5) {
        this.f7644f = new InsetDrawable((Drawable) this.f7643e, i2, i3, i4, i5);
    }

    private void setCloseIconHovered(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f7649k != z) {
            this.f7649k = z;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.f7644f != null) {
            this.f7644f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(a aVar) {
        if (aVar != null) {
            aVar.p2(null);
        }
    }

    private void x() {
        if (!n() || !s() || this.f7646h == null) {
            u.m0(this, null);
        } else {
            u.m0(this, this.q);
        }
    }

    private void y() {
        if (c.e.a.b.a0.b.f3242a) {
            z();
            return;
        }
        this.f7643e.K2(true);
        u.q0(this, getBackgroundDrawable());
        A();
        l();
    }

    private void z() {
        this.f7645g = new RippleDrawable(c.e.a.b.a0.b.d(this.f7643e.f1()), getBackgroundDrawable(), null);
        this.f7643e.K2(false);
        u.q0(this, this.f7645g);
        A();
    }

    @Override // com.google.android.material.chip.a.AbstractC0150a
    public void a() {
        k(this.p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m(motionEvent) || this.q.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.q.w(keyEvent) || this.q.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f7643e;
        if ((aVar == null || !aVar.p1()) ? false : this.f7643e.l2(j())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f7644f;
        return insetDrawable == null ? this.f7643e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        a aVar = this.f7643e;
        return aVar != null ? Math.max((float) Utils.FLOAT_EPSILON, aVar.I0()) : Utils.FLOAT_EPSILON;
    }

    public Drawable getChipDrawable() {
        return this.f7643e;
    }

    public float getChipEndPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.J0() : Utils.FLOAT_EPSILON;
    }

    public Drawable getChipIcon() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public float getChipIconSize() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.L0() : Utils.FLOAT_EPSILON;
    }

    public ColorStateList getChipIconTint() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.M0();
        }
        return null;
    }

    public float getChipMinHeight() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.N0() : Utils.FLOAT_EPSILON;
    }

    public float getChipStartPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.O0() : Utils.FLOAT_EPSILON;
    }

    public ColorStateList getChipStrokeColor() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.P0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.Q0() : Utils.FLOAT_EPSILON;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.R0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.T0() : Utils.FLOAT_EPSILON;
    }

    public float getCloseIconSize() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.U0() : Utils.FLOAT_EPSILON;
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.V0() : Utils.FLOAT_EPSILON;
    }

    public ColorStateList getCloseIconTint() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.q.A() == 1 || this.q.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.c1();
        }
        return null;
    }

    public float getIconEndPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.d1() : Utils.FLOAT_EPSILON;
    }

    public float getIconStartPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.e1() : Utils.FLOAT_EPSILON;
    }

    public ColorStateList getRippleColor() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public c.e.a.b.c0.k getShapeAppearanceModel() {
        return this.f7643e.C();
    }

    public h getShowMotionSpec() {
        a aVar = this.f7643e;
        if (aVar != null) {
            return aVar.g1();
        }
        return null;
    }

    public float getTextEndPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.j1() : Utils.FLOAT_EPSILON;
    }

    public float getTextStartPadding() {
        a aVar = this.f7643e;
        return aVar != null ? aVar.k1() : Utils.FLOAT_EPSILON;
    }

    public boolean k(int i2) {
        this.p = i2;
        int i3 = 0;
        if (!v()) {
            if (this.f7644f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.f7643e.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.f7643e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i4 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i3 = max / 2;
            }
            if (this.f7644f != null) {
                Rect rect = new Rect();
                this.f7644f.getPadding(rect);
                if (rect.top == i3 && rect.bottom == i3 && rect.left == i4 && rect.right == i4) {
                    y();
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (getMinHeight() != i2) {
                    setMinHeight(i2);
                }
                if (getMinWidth() != i2) {
                    setMinWidth(i2);
                }
            } else {
                setMinHeight(i2);
                setMinWidth(i2);
            }
            q(i4, i3, i4, i3);
            y();
            return true;
        }
        if (this.f7644f != null) {
            u();
        } else {
            y();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.e.a.b.c0.h.f(this, this.f7643e);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, x);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.q.I(z, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (r() || isClickable()) {
            accessibilityNodeInfo.setClassName(r() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            b.h.k.d0.c.E0(accessibilityNodeInfo).d0(c.C0048c.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.o(this) : -1, 1, false, isChecked()));
        }
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.o != i2) {
            this.o = i2;
            A();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.f7649k
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.f7649k
            if (r0 == 0) goto L_0x0034
            r5.t()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        a aVar = this.f7643e;
        return aVar != null && aVar.o1();
    }

    public boolean s() {
        a aVar = this.f7643e;
        return aVar != null && aVar.q1();
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7645g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7645g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.x1(z);
        }
    }

    public void setCheckableResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.y1(i2);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        a aVar = this.f7643e;
        if (aVar == null) {
            this.f7648j = z;
        } else if (aVar.o1()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.f7647i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.z1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.A1(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.B1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.C1(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.D1(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.F1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.G1(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.H1(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.I1(i2);
        }
    }

    public void setChipDrawable(a aVar) {
        a aVar2 = this.f7643e;
        if (aVar2 != aVar) {
            w(aVar2);
            this.f7643e = aVar;
            aVar.A2(false);
            i(this.f7643e);
            k(this.p);
        }
    }

    public void setChipEndPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.J1(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.K1(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.L1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.M1(i2);
        }
    }

    public void setChipIconSize(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.N1(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.O1(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.P1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.Q1(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.R1(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.T1(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.U1(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.V1(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.W1(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.X1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.Y1(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.Z1(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.a2(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.c2(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.d2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.e2(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.f2(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.g2(i2);
        }
        x();
    }

    public void setCloseIconSize(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.h2(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.i2(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.j2(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.k2(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.m2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.n2(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.W(f2);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f7643e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                a aVar = this.f7643e;
                if (aVar != null) {
                    aVar.q2(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        k(this.p);
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(h hVar) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.r2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.s2(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.t2(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.u2(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.v2(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.w2(i2);
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f7643e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.x2(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f7647i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f7646h = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.y2(colorStateList);
        }
        if (!this.f7643e.m1()) {
            z();
        }
    }

    public void setRippleColorResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.z2(i2);
            if (!this.f7643e.m1()) {
                z();
            }
        }
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(c.e.a.b.c0.k kVar) {
        this.f7643e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.B2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.C2(i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        a aVar = this.f7643e;
        if (aVar != null) {
            if (charSequence == null) {
                charSequence = BuildConfig.FLAVOR;
            }
            super.setText(aVar.L2() ? null : charSequence, bufferType);
            a aVar2 = this.f7643e;
            if (aVar2 != null) {
                aVar2.D2(charSequence);
            }
        }
    }

    public void setTextAppearance(d dVar) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.E2(dVar);
        }
        B();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.G2(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.H2(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.I2(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.J2(i2);
        }
    }

    public boolean t() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f7646h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.q.U(1, 1);
        return z;
    }

    public boolean v() {
        return this.n;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCloseIconVisible(boolean z) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.o2(z);
        }
        x();
    }

    public void setCheckedIconVisible(boolean z) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.E1(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.S1(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.F2(i2);
        }
        B();
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        a aVar = this.f7643e;
        if (aVar != null) {
            aVar.F2(i2);
        }
        B();
    }
}
