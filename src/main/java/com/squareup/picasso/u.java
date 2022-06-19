package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* access modifiers changed from: package-private */
/* compiled from: PicassoDrawable */
public final class u extends BitmapDrawable {

    /* renamed from: h  reason: collision with root package name */
    private static final Paint f8777h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8778a;

    /* renamed from: b  reason: collision with root package name */
    private final float f8779b;

    /* renamed from: c  reason: collision with root package name */
    private final t.e f8780c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f8781d;

    /* renamed from: e  reason: collision with root package name */
    long f8782e;

    /* renamed from: f  reason: collision with root package name */
    boolean f8783f;

    /* renamed from: g  reason: collision with root package name */
    int f8784g = 255;

    u(Context context, Bitmap bitmap, Drawable drawable, t.e eVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f8778a = z2;
        this.f8779b = context.getResources().getDisplayMetrics().density;
        this.f8780c = eVar;
        if (eVar != t.e.MEMORY && !z) {
            this.f8781d = drawable;
            this.f8783f = true;
            this.f8782e = SystemClock.uptimeMillis();
        }
    }

    private void a(Canvas canvas) {
        Paint paint = f8777h;
        paint.setColor(-1);
        canvas.drawPath(b(0, 0, (int) (this.f8779b * 16.0f)), paint);
        paint.setColor(this.f8780c.f8771b);
        canvas.drawPath(b(0, 0, (int) (this.f8779b * 15.0f)), paint);
    }

    private static Path b(int i2, int i3, int i4) {
        Path path = new Path();
        float f2 = (float) i2;
        float f3 = (float) i3;
        path.moveTo(f2, f3);
        path.lineTo((float) (i2 + i4), f3);
        path.lineTo(f2, (float) (i3 + i4));
        return path;
    }

    static void c(ImageView imageView, Context context, Bitmap bitmap, t.e eVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new u(context, bitmap, drawable, eVar, z, z2));
    }

    static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f8783f) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f8782e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f8783f = false;
                this.f8781d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f8781d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f8784g) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f8784g);
            }
        }
        if (this.f8778a) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8781d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i2) {
        this.f8784g = i2;
        Drawable drawable = this.f8781d;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
        super.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8781d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
