package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.b;
import androidx.core.widget.i;
import androidx.core.widget.k;
import b.a.a;
import b.h.k.t;

public class AppCompatButton extends Button implements t, b, k {

    /* renamed from: b  reason: collision with root package name */
    private final e f448b;

    /* renamed from: c  reason: collision with root package name */
    private final s f449c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f448b;
        if (eVar != null) {
            eVar.b();
        }
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f1167a) {
            return super.getAutoSizeMaxTextSize();
        }
        s sVar = this.f449c;
        if (sVar != null) {
            return sVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f1167a) {
            return super.getAutoSizeMinTextSize();
        }
        s sVar = this.f449c;
        if (sVar != null) {
            return sVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f1167a) {
            return super.getAutoSizeStepGranularity();
        }
        s sVar = this.f449c;
        if (sVar != null) {
            return sVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1167a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        s sVar = this.f449c;
        return sVar != null ? sVar.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!b.f1167a) {
            s sVar = this.f449c;
            if (sVar != null) {
                return sVar.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f448b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f448b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f449c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f449c.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.o(z, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        s sVar = this.f449c;
        if (sVar != null && !b.f1167a && sVar.l()) {
            this.f449c.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.s(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.t(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.f1167a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.u(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f448b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f448b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.r(z);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f448b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f448b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f449c.v(colorStateList);
        this.f449c.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f449c.w(mode);
        this.f449c.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        if (b.f1167a) {
            super.setTextSize(i2, f2);
            return;
        }
        s sVar = this.f449c;
        if (sVar != null) {
            sVar.z(i2, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        e eVar = new e(this);
        this.f448b = eVar;
        eVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f449c = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
    }
}
