package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.j;
import b.a.a;
import b.h.k.t;

public class AppCompatRadioButton extends RadioButton implements j, t {

    /* renamed from: b  reason: collision with root package name */
    private final g f458b;

    /* renamed from: c  reason: collision with root package name */
    private final e f459c;

    /* renamed from: d  reason: collision with root package name */
    private final s f460d;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.G);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f459c;
        if (eVar != null) {
            eVar.b();
        }
        s sVar = this.f460d;
        if (sVar != null) {
            sVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        g gVar = this.f458b;
        return gVar != null ? gVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f459c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f459c;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public ColorStateList getSupportButtonTintList() {
        g gVar = this.f458b;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        g gVar = this.f458b;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f459c;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f459c;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        g gVar = this.f458b;
        if (gVar != null) {
            gVar.f();
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f459c;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f459c;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        g gVar = this.f458b;
        if (gVar != null) {
            gVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        g gVar = this.f458b;
        if (gVar != null) {
            gVar.h(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        g gVar = new g(this);
        this.f458b = gVar;
        gVar.e(attributeSet, i2);
        e eVar = new e(this);
        this.f459c = eVar;
        eVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f460d = sVar;
        sVar.m(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(b.a.k.a.a.d(getContext(), i2));
    }
}
