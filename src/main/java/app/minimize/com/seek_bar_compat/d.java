package app.minimize.com.seek_bar_compat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.m.b.f;

/* compiled from: SeekBarBackgroundDrawable.kt */
public final class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1917a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1918b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1919c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1920d;

    /* renamed from: e  reason: collision with root package name */
    private final float f1921e;

    public d(Context context, int i2, int i3, float f2, float f3) {
        f.f(context, "ctx");
        this.f1920d = f2;
        this.f1921e = f3;
        Paint paint = new Paint();
        this.f1917a = paint;
        Paint paint2 = new Paint();
        this.f1918b = paint2;
        paint.setColor(i2);
        paint2.setColor(i3);
        this.f1919c = context.getResources().getDimension(b.one_dp);
    }

    public void draw(Canvas canvas) {
        f.f(canvas, "canvas");
        canvas.drawRect((float) getBounds().left, (float) getBounds().top, (float) getBounds().right, (float) getBounds().bottom, this.f1918b);
        float f2 = (float) 2;
        canvas.drawRect(((float) getBounds().left) + this.f1920d, ((float) getBounds().centerY()) - (this.f1919c / f2), ((float) getBounds().right) - this.f1921e, ((float) getBounds().centerY()) + (this.f1919c / f2), this.f1917a);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
