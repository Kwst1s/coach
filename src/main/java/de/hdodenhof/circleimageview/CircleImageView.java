package de.hdodenhof.circleimageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.github.mikephil.charting.utils.Utils;

public class CircleImageView extends ImageView {
    private static final ImageView.ScaleType v = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config w = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f8824b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f8825c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f8826d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f8827e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f8828f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f8829g;

    /* renamed from: h  reason: collision with root package name */
    private int f8830h;

    /* renamed from: i  reason: collision with root package name */
    private int f8831i;

    /* renamed from: j  reason: collision with root package name */
    private int f8832j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f8833k;
    private BitmapShader l;
    private int m;
    private int n;
    private float o;
    private float p;
    private ColorFilter q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;

    /* access modifiers changed from: private */
    public class b extends ViewOutlineProvider {
        private b() {
        }

        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.u) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.f8825c.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        Paint paint = this.f8827e;
        if (paint != null) {
            paint.setColorFilter(this.q);
        }
    }

    private RectF d() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f2 = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private Bitmap e(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, w);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), w);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean f(float f2, float f3) {
        if (!this.f8825c.isEmpty() && Math.pow((double) (f2 - this.f8825c.centerX()), 2.0d) + Math.pow((double) (f3 - this.f8825c.centerY()), 2.0d) > Math.pow((double) this.p, 2.0d)) {
            return false;
        }
        return true;
    }

    private void g() {
        super.setScaleType(v);
        this.r = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
        if (this.s) {
            i();
            this.s = false;
        }
    }

    private void h() {
        if (this.u) {
            this.f8833k = null;
        } else {
            this.f8833k = e(getDrawable());
        }
        i();
    }

    private void i() {
        int i2;
        if (!this.r) {
            this.s = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f8833k == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.f8833k;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.l = new BitmapShader(bitmap, tileMode, tileMode);
            this.f8827e.setAntiAlias(true);
            this.f8827e.setDither(true);
            this.f8827e.setFilterBitmap(true);
            this.f8827e.setShader(this.l);
            this.f8828f.setStyle(Paint.Style.STROKE);
            this.f8828f.setAntiAlias(true);
            this.f8828f.setColor(this.f8830h);
            this.f8828f.setStrokeWidth((float) this.f8831i);
            this.f8829g.setStyle(Paint.Style.FILL);
            this.f8829g.setAntiAlias(true);
            this.f8829g.setColor(this.f8832j);
            this.n = this.f8833k.getHeight();
            this.m = this.f8833k.getWidth();
            this.f8825c.set(d());
            this.p = Math.min((this.f8825c.height() - ((float) this.f8831i)) / 2.0f, (this.f8825c.width() - ((float) this.f8831i)) / 2.0f);
            this.f8824b.set(this.f8825c);
            if (!this.t && (i2 = this.f8831i) > 0) {
                this.f8824b.inset(((float) i2) - 1.0f, ((float) i2) - 1.0f);
            }
            this.o = Math.min(this.f8824b.height() / 2.0f, this.f8824b.width() / 2.0f);
            c();
            j();
            invalidate();
        }
    }

    private void j() {
        float f2;
        float f3;
        this.f8826d.set(null);
        float height = ((float) this.m) * this.f8824b.height();
        float width = this.f8824b.width() * ((float) this.n);
        float f4 = Utils.FLOAT_EPSILON;
        if (height > width) {
            f3 = this.f8824b.height() / ((float) this.n);
            f4 = (this.f8824b.width() - (((float) this.m) * f3)) * 0.5f;
            f2 = Utils.FLOAT_EPSILON;
        } else {
            f3 = this.f8824b.width() / ((float) this.m);
            f2 = (this.f8824b.height() - (((float) this.n) * f3)) * 0.5f;
        }
        this.f8826d.setScale(f3, f3);
        Matrix matrix = this.f8826d;
        RectF rectF = this.f8824b;
        matrix.postTranslate(((float) ((int) (f4 + 0.5f))) + rectF.left, ((float) ((int) (f2 + 0.5f))) + rectF.top);
        this.l.setLocalMatrix(this.f8826d);
    }

    public int getBorderColor() {
        return this.f8830h;
    }

    public int getBorderWidth() {
        return this.f8831i;
    }

    public int getCircleBackgroundColor() {
        return this.f8832j;
    }

    public ColorFilter getColorFilter() {
        return this.q;
    }

    public ImageView.ScaleType getScaleType() {
        return v;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.u) {
            super.onDraw(canvas);
        } else if (this.f8833k != null) {
            if (this.f8832j != 0) {
                canvas.drawCircle(this.f8824b.centerX(), this.f8824b.centerY(), this.o, this.f8829g);
            }
            canvas.drawCircle(this.f8824b.centerX(), this.f8824b.centerY(), this.o, this.f8827e);
            if (this.f8831i > 0) {
                canvas.drawCircle(this.f8825c.centerX(), this.f8825c.centerY(), this.p, this.f8828f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        i();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.u) {
            return super.onTouchEvent(motionEvent);
        }
        return f(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i2) {
        if (i2 != this.f8830h) {
            this.f8830h = i2;
            this.f8828f.setColor(i2);
            invalidate();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.t) {
            this.t = z;
            i();
        }
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.f8831i) {
            this.f8831i = i2;
            i();
        }
    }

    public void setCircleBackgroundColor(int i2) {
        if (i2 != this.f8832j) {
            this.f8832j = i2;
            this.f8829g.setColor(i2);
            invalidate();
        }
    }

    public void setCircleBackgroundColorResource(int i2) {
        setCircleBackgroundColor(getContext().getResources().getColor(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.q) {
            this.q = colorFilter;
            c();
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.u != z) {
            this.u = z;
            h();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        h();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        i();
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        i();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != v) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8824b = new RectF();
        this.f8825c = new RectF();
        this.f8826d = new Matrix();
        this.f8827e = new Paint();
        this.f8828f = new Paint();
        this.f8829g = new Paint();
        this.f8830h = -16777216;
        this.f8831i = 0;
        this.f8832j = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f8835a, i2, 0);
        this.f8831i = obtainStyledAttributes.getDimensionPixelSize(a.f8838d, 0);
        this.f8830h = obtainStyledAttributes.getColor(a.f8836b, -16777216);
        this.t = obtainStyledAttributes.getBoolean(a.f8837c, false);
        this.f8832j = obtainStyledAttributes.getColor(a.f8839e, 0);
        obtainStyledAttributes.recycle();
        g();
    }
}
