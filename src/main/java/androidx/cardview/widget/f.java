package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
/* compiled from: RoundRectDrawable */
public class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f833a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f834b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f835c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f836d;

    /* renamed from: e  reason: collision with root package name */
    private float f837e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f838f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f839g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f840h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f841i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f842j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f843k = PorterDuff.Mode.SRC_IN;

    f(ColorStateList colorStateList, float f2) {
        this.f833a = f2;
        this.f834b = new Paint(5);
        e(colorStateList);
        this.f835c = new RectF();
        this.f836d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f840h = colorStateList;
        this.f834b.setColor(colorStateList.getColorForState(getState(), this.f840h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f835c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f836d.set(rect);
        if (this.f838f) {
            float d2 = g.d(this.f837e, this.f833a, this.f839g);
            this.f836d.inset((int) Math.ceil((double) g.c(this.f837e, this.f833a, this.f839g)), (int) Math.ceil((double) d2));
            this.f835c.set(this.f836d);
        }
    }

    public ColorStateList b() {
        return this.f840h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f837e;
    }

    public float d() {
        return this.f833a;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f834b;
        if (this.f841i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f841i);
            z = true;
        }
        RectF rectF = this.f835c;
        float f2 = this.f833a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f2, boolean z, boolean z2) {
        if (f2 != this.f837e || this.f838f != z || this.f839g != z2) {
            this.f837e = f2;
            this.f838f = z;
            this.f839g = z2;
            i(null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f836d, this.f833a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        if (f2 != this.f833a) {
            this.f833a = f2;
            i(null);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f842j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f840h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f840h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f834b.getColor();
        if (z) {
            this.f834b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f842j;
        if (colorStateList2 == null || (mode = this.f843k) == null) {
            return z;
        }
        this.f841i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f834b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f834b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f842j = colorStateList;
        this.f841i = a(colorStateList, this.f843k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f843k = mode;
        this.f841i = a(this.f842j, mode);
        invalidateSelf();
    }
}
