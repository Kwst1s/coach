package b.a.l.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

/* compiled from: DrawableWrapper */
public class c extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    private Drawable f2044b;

    public c(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.f2044b;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f2044b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2044b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f2044b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f2044b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f2044b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2044b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2044b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f2044b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2044b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2044b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2044b.getPadding(rect);
    }

    public int[] getState() {
        return this.f2044b.getState();
    }

    public Region getTransparentRegion() {
        return this.f2044b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h(this.f2044b);
    }

    public boolean isStateful() {
        return this.f2044b.isStateful();
    }

    public void jumpToCurrentState() {
        this.f2044b.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f2044b.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f2044b.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f2044b.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        a.j(this.f2044b, z);
    }

    public void setChangingConfigurations(int i2) {
        this.f2044b.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2044b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2044b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2044b.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        a.k(this.f2044b, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        a.l(this.f2044b, i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.f2044b.setState(iArr);
    }

    public void setTint(int i2) {
        a.n(this.f2044b, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.o(this.f2044b, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.p(this.f2044b, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2044b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
