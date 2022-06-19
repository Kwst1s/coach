package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.i;
import b.h.k.u;
import c.e.a.b.c0.h;
import c.e.a.b.c0.n;
import c.e.a.b.k;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, n {
    private static final int[] q = {16842911};
    private static final int[] r = {16842912};
    private static final int s = k.Widget_MaterialComponents_Button;

    /* renamed from: d  reason: collision with root package name */
    private final a f7604d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<a> f7605e;

    /* renamed from: f  reason: collision with root package name */
    private b f7606f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f7607g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f7608h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f7609i;

    /* renamed from: j  reason: collision with root package name */
    private int f7610j;

    /* renamed from: k  reason: collision with root package name */
    private int f7611k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    /* access modifiers changed from: package-private */
    public static class c extends b.j.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        boolean f7612d;

        static class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            /* renamed from: b */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            /* renamed from: c */
            public c[] newArray(int i2) {
                return new c[i2];
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private void k(Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f7612d = z;
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7612d ? 1 : 0);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            k(parcel);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.materialButtonStyle);
    }

    private boolean c() {
        int i2 = this.p;
        return i2 == 3 || i2 == 4;
    }

    private boolean d() {
        int i2 = this.p;
        return i2 == 1 || i2 == 2;
    }

    private boolean e() {
        int i2 = this.p;
        return i2 == 16 || i2 == 32;
    }

    private boolean f() {
        return u.B(this) == 1;
    }

    private boolean g() {
        a aVar = this.f7604d;
        return aVar != null && !aVar.o();
    }

    private String getA11yClassName() {
        return (b() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private void i() {
        if (d()) {
            i.l(this, this.f7609i, null, null, null);
        } else if (c()) {
            i.l(this, null, null, this.f7609i, null);
        } else if (e()) {
            i.l(this, null, this.f7609i, null, null);
        }
    }

    private void j(boolean z) {
        Drawable drawable = this.f7609i;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f7609i = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f7608h);
            PorterDuff.Mode mode = this.f7607g;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f7609i, mode);
            }
            int i2 = this.f7610j;
            if (i2 == 0) {
                i2 = this.f7609i.getIntrinsicWidth();
            }
            int i3 = this.f7610j;
            if (i3 == 0) {
                i3 = this.f7609i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f7609i;
            int i4 = this.f7611k;
            int i5 = this.l;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            i();
            return;
        }
        Drawable[] a2 = i.a(this);
        boolean z2 = false;
        Drawable drawable3 = a2[0];
        Drawable drawable4 = a2[1];
        Drawable drawable5 = a2[2];
        if ((d() && drawable3 != this.f7609i) || ((c() && drawable5 != this.f7609i) || (e() && drawable4 != this.f7609i))) {
            z2 = true;
        }
        if (z2) {
            i();
        }
    }

    private void k(int i2, int i3) {
        if (this.f7609i != null && getLayout() != null) {
            if (d() || c()) {
                this.l = 0;
                int i4 = this.p;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.f7611k = 0;
                    j(false);
                    return;
                }
                int i5 = this.f7610j;
                if (i5 == 0) {
                    i5 = this.f7609i.getIntrinsicWidth();
                }
                int textWidth = (((((i2 - getTextWidth()) - u.F(this)) - i5) - this.m) - u.G(this)) / 2;
                boolean f2 = f();
                if (this.p != 4) {
                    z = false;
                }
                if (f2 != z) {
                    textWidth = -textWidth;
                }
                if (this.f7611k != textWidth) {
                    this.f7611k = textWidth;
                    j(false);
                }
            } else if (e()) {
                this.f7611k = 0;
                if (this.p == 16) {
                    this.l = 0;
                    j(false);
                    return;
                }
                int i6 = this.f7610j;
                if (i6 == 0) {
                    i6 = this.f7609i.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.m) - getPaddingBottom()) / 2;
                if (this.l != textHeight) {
                    this.l = textHeight;
                    j(false);
                }
            }
        }
    }

    public void a(a aVar) {
        this.f7605e.add(aVar);
    }

    public boolean b() {
        a aVar = this.f7604d;
        return aVar != null && aVar.p();
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (g()) {
            return this.f7604d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f7609i;
    }

    public int getIconGravity() {
        return this.p;
    }

    public int getIconPadding() {
        return this.m;
    }

    public int getIconSize() {
        return this.f7610j;
    }

    public ColorStateList getIconTint() {
        return this.f7608h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f7607g;
    }

    public int getInsetBottom() {
        return this.f7604d.c();
    }

    public int getInsetTop() {
        return this.f7604d.d();
    }

    public ColorStateList getRippleColor() {
        if (g()) {
            return this.f7604d.h();
        }
        return null;
    }

    public c.e.a.b.c0.k getShapeAppearanceModel() {
        if (g()) {
            return this.f7604d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (g()) {
            return this.f7604d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (g()) {
            return this.f7604d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        if (g()) {
            return this.f7604d.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (g()) {
            return this.f7604d.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void h(a aVar) {
        this.f7605e.remove(aVar);
    }

    public boolean isChecked() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g()) {
            h.f(this, this.f7604d.f());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (b()) {
            Button.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(b());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f7604d) != null) {
            aVar.H(i5 - i3, i4 - i2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.g());
        setChecked(cVar.f7612d);
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f7612d = this.n;
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        k(i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        k(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (g()) {
            this.f7604d.r(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundDrawable(Drawable drawable) {
        if (!g()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            this.f7604d.s();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (g()) {
            this.f7604d.t(z);
        }
    }

    public void setChecked(boolean z) {
        if (b() && isEnabled() && this.n != z) {
            this.n = z;
            refreshDrawableState();
            if (!this.o) {
                this.o = true;
                Iterator<a> it = this.f7605e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.n);
                }
                this.o = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (g()) {
            this.f7604d.u(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (g()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (g()) {
            this.f7604d.f().W(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f7609i != drawable) {
            this.f7609i = drawable;
            j(true);
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.p != i2) {
            this.p = i2;
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i2) {
        if (this.m != i2) {
            this.m = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f7610j != i2) {
            this.f7610j = i2;
            j(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f7608h != colorStateList) {
            this.f7608h = colorStateList;
            j(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f7607g != mode) {
            this.f7607g = mode;
            j(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(b.a.k.a.a.c(getContext(), i2));
    }

    public void setInsetBottom(int i2) {
        this.f7604d.v(i2);
    }

    public void setInsetTop(int i2) {
        this.f7604d.w(i2);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f7606f = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f7606f;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (g()) {
            this.f7604d.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (g()) {
            setRippleColor(b.a.k.a.a.c(getContext(), i2));
        }
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(c.e.a.b.c0.k kVar) {
        if (g()) {
            this.f7604d.y(kVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (g()) {
            this.f7604d.z(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (g()) {
            this.f7604d.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (g()) {
            setStrokeColor(b.a.k.a.a.c(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (g()) {
            this.f7604d.B(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (g()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (g()) {
            this.f7604d.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (g()) {
            this.f7604d.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void toggle() {
        setChecked(!this.n);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
