package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.widget.l;
import b.a.a;
import b.h.k.t;

/* compiled from: AppCompatImageButton */
public class j extends ImageButton implements t, l {

    /* renamed from: b  reason: collision with root package name */
    private final e f649b;

    /* renamed from: c  reason: collision with root package name */
    private final k f650c;

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f649b;
        if (eVar != null) {
            eVar.b();
        }
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f649b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f649b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        k kVar = this.f650c;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        k kVar = this.f650c;
        if (kVar != null) {
            return kVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f650c.e() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f649b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f649b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void setImageResource(int i2) {
        this.f650c.g(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f649b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f649b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.h(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        k kVar = this.f650c;
        if (kVar != null) {
            kVar.i(mode);
        }
    }

    public j(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        e eVar = new e(this);
        this.f649b = eVar;
        eVar.e(attributeSet, i2);
        k kVar = new k(this);
        this.f650c = kVar;
        kVar.f(attributeSet, i2);
    }
}
