package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.l;
import b.h.k.t;

public class AppCompatImageView extends ImageView implements t, l {

    /* renamed from: b  reason: collision with root package name */
    private final e f456b;

    /* renamed from: c  reason: collision with root package name */
    private final k f457c;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f456b;
        if (eVar != null) {
            eVar.b();
        }
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // b.h.k.t
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f456b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f456b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        k kVar = this.f457c;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        k kVar = this.f457c;
        if (kVar != null) {
            return kVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f457c.e() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f456b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f456b;
        if (eVar != null) {
            eVar.g(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void setImageResource(int i2) {
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.g(i2);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f456b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // b.h.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f456b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.h(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        k kVar = this.f457c;
        if (kVar != null) {
            kVar.i(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        e eVar = new e(this);
        this.f456b = eVar;
        eVar.e(attributeSet, i2);
        k kVar = new k(this);
        this.f457c = kVar;
        kVar.f(attributeSet, i2);
    }
}
