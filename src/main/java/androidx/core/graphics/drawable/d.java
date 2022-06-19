package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
/* compiled from: WrappedDrawableApi14 */
public class d extends Drawable implements Drawable.Callback, c, b {

    /* renamed from: h  reason: collision with root package name */
    static final PorterDuff.Mode f1114h = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private int f1115b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1116c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1117d;

    /* renamed from: e  reason: collision with root package name */
    f f1118e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1119f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f1120g;

    d(f fVar, Resources resources) {
        this.f1118e = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.f1118e);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f1118e;
        if (fVar != null && (constantState = fVar.f1123b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f1118e;
        ColorStateList colorStateList = fVar.f1124c;
        PorterDuff.Mode mode = fVar.f1125d;
        if (colorStateList == null || mode == null) {
            this.f1117d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1117d && colorForState == this.f1115b && mode == this.f1116c)) {
                setColorFilter(colorForState, mode);
                this.f1115b = colorForState;
                this.f1116c = mode;
                this.f1117d = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1120g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1120g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f1118e;
            if (fVar != null) {
                fVar.f1123b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable b() {
        return this.f1120g;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f1120g.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f1118e;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f1120g.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        f fVar = this.f1118e;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f1118e.f1122a = getChangingConfigurations();
        return this.f1118e;
    }

    public Drawable getCurrent() {
        return this.f1120g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1120g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1120g.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1120g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1120g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1120g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1120g.getPadding(rect);
    }

    public int[] getState() {
        return this.f1120g.getState();
    }

    public Region getTransparentRegion() {
        return this.f1120g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f1120g.isAutoMirrored();
    }

    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f1118e) == null) ? null : fVar.f1124c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1120g.isStateful();
    }

    public void jumpToCurrentState() {
        this.f1120g.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f1119f && super.mutate() == this) {
            this.f1118e = d();
            Drawable drawable = this.f1120g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f1118e;
            if (fVar != null) {
                Drawable drawable2 = this.f1120g;
                fVar.f1123b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1119f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1120g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f1120g.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f1120g.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.f1120g.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.f1120g.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1120g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1120g.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1120g.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.f1120g.setState(iArr);
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1118e.f1124c = colorStateList;
        f(getState());
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1118e.f1125d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1120g.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f1118e = d();
        a(drawable);
    }
}
