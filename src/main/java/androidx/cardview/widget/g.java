package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import b.d.b;
import b.d.c;
import com.github.mikephil.charting.utils.Utils;

/* access modifiers changed from: package-private */
/* compiled from: RoundRectDrawableWithShadow */
public class g extends Drawable {
    private static final double q = Math.cos(Math.toRadians(45.0d));
    static a r;

    /* renamed from: a  reason: collision with root package name */
    private final int f844a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f845b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f846c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f847d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f848e;

    /* renamed from: f  reason: collision with root package name */
    private float f849f;

    /* renamed from: g  reason: collision with root package name */
    private Path f850g;

    /* renamed from: h  reason: collision with root package name */
    private float f851h;

    /* renamed from: i  reason: collision with root package name */
    private float f852i;

    /* renamed from: j  reason: collision with root package name */
    private float f853j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f854k;
    private boolean l = true;
    private final int m;
    private final int n;
    private boolean o = true;
    private boolean p = false;

    /* compiled from: RoundRectDrawableWithShadow */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.m = resources.getColor(b.cardview_shadow_start_color);
        this.n = resources.getColor(b.cardview_shadow_end_color);
        this.f844a = resources.getDimensionPixelSize(c.cardview_compat_inset_shadow);
        this.f845b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f846c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f849f = (float) ((int) (f2 + 0.5f));
        this.f848e = new RectF();
        Paint paint2 = new Paint(this.f846c);
        this.f847d = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.f851h;
        float f3 = 1.5f * f2;
        this.f848e.set(((float) rect.left) + f2, ((float) rect.top) + f3, ((float) rect.right) - f2, ((float) rect.bottom) - f3);
        b();
    }

    private void b() {
        float f2 = this.f849f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f852i;
        rectF2.inset(-f3, -f3);
        Path path = this.f850g;
        if (path == null) {
            this.f850g = new Path();
        } else {
            path.reset();
        }
        this.f850g.setFillType(Path.FillType.EVEN_ODD);
        this.f850g.moveTo(-this.f849f, Utils.FLOAT_EPSILON);
        this.f850g.rLineTo(-this.f852i, Utils.FLOAT_EPSILON);
        this.f850g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f850g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f850g.close();
        float f4 = this.f849f;
        float f5 = f4 / (this.f852i + f4);
        Paint paint = this.f846c;
        float f6 = this.f849f + this.f852i;
        int i2 = this.m;
        paint.setShader(new RadialGradient((float) Utils.FLOAT_EPSILON, (float) Utils.FLOAT_EPSILON, f6, new int[]{i2, i2, this.n}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f847d;
        float f7 = this.f849f;
        float f8 = this.f852i;
        int i3 = this.m;
        paint2.setShader(new LinearGradient((float) Utils.FLOAT_EPSILON, (-f7) + f8, (float) Utils.FLOAT_EPSILON, (-f7) - f8, new int[]{i3, i3, this.n}, new float[]{Utils.FLOAT_EPSILON, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f847d.setAntiAlias(false);
    }

    static float c(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = (double) f2;
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - q) * d3));
    }

    static float d(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = (double) (f2 * 1.5f);
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - q) * d3));
    }

    private void e(Canvas canvas) {
        float f2 = this.f849f;
        float f3 = (-f2) - this.f852i;
        float f4 = f2 + ((float) this.f844a) + (this.f853j / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f848e.width() - f5 > Utils.FLOAT_EPSILON;
        boolean z2 = this.f848e.height() - f5 > Utils.FLOAT_EPSILON;
        int save = canvas.save();
        RectF rectF = this.f848e;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f850g, this.f846c);
        if (z) {
            canvas.drawRect(Utils.FLOAT_EPSILON, f3, this.f848e.width() - f5, -this.f849f, this.f847d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f848e;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f850g, this.f846c);
        if (z) {
            canvas.drawRect(Utils.FLOAT_EPSILON, f3, this.f848e.width() - f5, (-this.f849f) + this.f852i, this.f847d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f848e;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f850g, this.f846c);
        if (z2) {
            canvas.drawRect(Utils.FLOAT_EPSILON, f3, this.f848e.height() - f5, -this.f849f, this.f847d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f848e;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f850g, this.f846c);
        if (z2) {
            canvas.drawRect(Utils.FLOAT_EPSILON, f3, this.f848e.height() - f5, -this.f849f, this.f847d);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f854k = colorStateList;
        this.f845b.setColor(colorStateList.getColorForState(getState(), this.f854k.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < Utils.FLOAT_EPSILON) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= Utils.FLOAT_EPSILON) {
            float t = (float) t(f2);
            float t2 = (float) t(f3);
            if (t > t2) {
                if (!this.p) {
                    this.p = true;
                }
                t = t2;
            }
            if (this.f853j != t || this.f851h != t2) {
                this.f853j = t;
                this.f851h = t2;
                this.f852i = (float) ((int) ((t * 1.5f) + ((float) this.f844a) + 0.5f));
                this.l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        canvas.translate(Utils.FLOAT_EPSILON, this.f853j / 2.0f);
        e(canvas);
        canvas.translate(Utils.FLOAT_EPSILON, (-this.f853j) / 2.0f);
        r.a(canvas, this.f848e, this.f849f, this.f845b);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f854k;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f849f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.f851h, this.f849f, this.o));
        int ceil2 = (int) Math.ceil((double) c(this.f851h, this.f849f, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f851h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f854k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: package-private */
    public float j() {
        float f2 = this.f851h;
        return (Math.max(f2, this.f849f + ((float) this.f844a) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f851h * 1.5f) + ((float) this.f844a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float k() {
        float f2 = this.f851h;
        return (Math.max(f2, this.f849f + ((float) this.f844a) + (f2 / 2.0f)) * 2.0f) + ((this.f851h + ((float) this.f844a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f853j;
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f854k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f845b.getColor() == colorForState) {
            return false;
        }
        this.f845b.setColor(colorForState);
        this.l = true;
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p(float f2) {
        if (f2 >= Utils.FLOAT_EPSILON) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.f849f != f3) {
                this.f849f = f3;
                this.l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public void q(float f2) {
        s(this.f853j, f2);
    }

    /* access modifiers changed from: package-private */
    public void r(float f2) {
        s(f2, this.f851h);
    }

    public void setAlpha(int i2) {
        this.f845b.setAlpha(i2);
        this.f846c.setAlpha(i2);
        this.f847d.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f845b.setColorFilter(colorFilter);
    }
}
