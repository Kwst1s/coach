package fr.castorflex.android.circularprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: CircularProgressDrawable */
public class a extends Drawable implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private final RectF f9680b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager f9681c;

    /* renamed from: d  reason: collision with root package name */
    private final e f9682d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f9683e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9684f;

    /* renamed from: g  reason: collision with root package name */
    private f f9685g;

    /* compiled from: CircularProgressDrawable */
    public static class b {

        /* renamed from: k  reason: collision with root package name */
        private static final Interpolator f9686k = new LinearInterpolator();
        private static final Interpolator l = new c();

        /* renamed from: a  reason: collision with root package name */
        private Interpolator f9687a;

        /* renamed from: b  reason: collision with root package name */
        private Interpolator f9688b;

        /* renamed from: c  reason: collision with root package name */
        private float f9689c;

        /* renamed from: d  reason: collision with root package name */
        private int[] f9690d;

        /* renamed from: e  reason: collision with root package name */
        private float f9691e;

        /* renamed from: f  reason: collision with root package name */
        private float f9692f;

        /* renamed from: g  reason: collision with root package name */
        private int f9693g;

        /* renamed from: h  reason: collision with root package name */
        private int f9694h;

        /* renamed from: i  reason: collision with root package name */
        int f9695i;

        /* renamed from: j  reason: collision with root package name */
        private PowerManager f9696j;

        public b(Context context) {
            this(context, false);
        }

        private void d(Context context, boolean z) {
            this.f9689c = context.getResources().getDimension(j.cpb_default_stroke_width);
            this.f9691e = 1.0f;
            this.f9692f = 1.0f;
            if (z) {
                this.f9690d = new int[]{-16776961};
                this.f9693g = 20;
                this.f9694h = 300;
            } else {
                this.f9690d = new int[]{context.getResources().getColor(i.cpb_default_color)};
                this.f9693g = context.getResources().getInteger(k.cpb_default_min_sweep_angle);
                this.f9694h = context.getResources().getInteger(k.cpb_default_max_sweep_angle);
            }
            this.f9695i = 1;
            this.f9696j = o.g(context);
        }

        public a a() {
            return new a(this.f9696j, new e(this.f9688b, this.f9687a, this.f9689c, this.f9690d, this.f9691e, this.f9692f, this.f9693g, this.f9694h, this.f9695i));
        }

        public b b(int i2) {
            this.f9690d = new int[]{i2};
            return this;
        }

        public b c(int[] iArr) {
            o.b(iArr);
            this.f9690d = iArr;
            return this;
        }

        public b e(int i2) {
            o.a(i2);
            this.f9694h = i2;
            return this;
        }

        public b f(int i2) {
            o.a(i2);
            this.f9693g = i2;
            return this;
        }

        public b g(float f2) {
            o.d(f2);
            this.f9692f = f2;
            return this;
        }

        public b h(float f2) {
            o.c(f2, "StrokeWidth");
            this.f9689c = f2;
            return this;
        }

        public b i(float f2) {
            o.d(f2);
            this.f9691e = f2;
            return this;
        }

        public b(Context context, boolean z) {
            this.f9687a = l;
            this.f9688b = f9686k;
            d(context, z);
        }
    }

    private void c() {
        if (o.f(this.f9681c)) {
            f fVar = this.f9685g;
            if (fVar == null || !(fVar instanceof g)) {
                if (fVar != null) {
                    fVar.stop();
                }
                this.f9685g = new g(this);
                return;
            }
            return;
        }
        f fVar2 = this.f9685g;
        if (fVar2 == null || (fVar2 instanceof g)) {
            if (fVar2 != null) {
                fVar2.stop();
            }
            this.f9685g = new b(this, this.f9682d);
        }
    }

    /* access modifiers changed from: package-private */
    public Paint a() {
        return this.f9683e;
    }

    /* access modifiers changed from: package-private */
    public RectF b() {
        return this.f9680b;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (getCallback() == null) {
            stop();
        }
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (isRunning()) {
            this.f9685g.a(canvas, this.f9683e);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f9684f;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float f2 = this.f9682d.f9719c;
        RectF rectF = this.f9680b;
        float f3 = f2 / 2.0f;
        rectF.left = ((float) rect.left) + f3 + 0.5f;
        rectF.right = (((float) rect.right) - f3) - 0.5f;
        rectF.top = ((float) rect.top) + f3 + 0.5f;
        rectF.bottom = (((float) rect.bottom) - f3) - 0.5f;
    }

    public void setAlpha(int i2) {
        this.f9683e.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f9683e.setColorFilter(colorFilter);
    }

    public void start() {
        c();
        this.f9685g.start();
        this.f9684f = true;
        invalidateSelf();
    }

    public void stop() {
        this.f9684f = false;
        this.f9685g.stop();
        invalidateSelf();
    }

    private a(PowerManager powerManager, e eVar) {
        this.f9680b = new RectF();
        this.f9682d = eVar;
        Paint paint = new Paint();
        this.f9683e = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(eVar.f9719c);
        paint.setStrokeCap(eVar.f9725i == 1 ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        paint.setColor(eVar.f9720d[0]);
        this.f9681c = powerManager;
        c();
    }
}
