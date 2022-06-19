package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import b.s.a.a.b;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.o.g.g;
import com.bumptech.glide.r.j;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: GifDrawable */
public class c extends Drawable implements g.b, Animatable {

    /* renamed from: b  reason: collision with root package name */
    private final a f4114b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4115c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4116d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4117e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4118f;

    /* renamed from: g  reason: collision with root package name */
    private int f4119g;

    /* renamed from: h  reason: collision with root package name */
    private int f4120h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4121i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f4122j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f4123k;
    private List<b> l;

    /* access modifiers changed from: package-private */
    /* compiled from: GifDrawable */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f4124a;

        a(g gVar) {
            this.f4124a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, com.bumptech.glide.l.a aVar, l<Bitmap> lVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.c(context), aVar, i2, i3, lVar, bitmap)));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f4123k == null) {
            this.f4123k = new Rect();
        }
        return this.f4123k;
    }

    private Paint h() {
        if (this.f4122j == null) {
            this.f4122j = new Paint(2);
        }
        return this.f4122j;
    }

    private void j() {
        List<b> list = this.l;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(this);
            }
        }
    }

    private void l() {
        this.f4119g = 0;
    }

    private void n() {
        j.a(!this.f4117e, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4114b.f4124a.f() == 1) {
            invalidateSelf();
        } else if (!this.f4115c) {
            this.f4115c = true;
            this.f4114b.f4124a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f4115c = false;
        this.f4114b.f4124a.s(this);
    }

    @Override // com.bumptech.glide.load.o.g.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f4119g++;
        }
        int i2 = this.f4120h;
        if (i2 != -1 && this.f4119g >= i2) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f4114b.f4124a.b();
    }

    public void draw(Canvas canvas) {
        if (!this.f4117e) {
            if (this.f4121i) {
                Gravity.apply(b.a.j.D0, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.f4121i = false;
            }
            canvas.drawBitmap(this.f4114b.f4124a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f4114b.f4124a.e();
    }

    public int f() {
        return this.f4114b.f4124a.f();
    }

    public int g() {
        return this.f4114b.f4124a.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f4114b;
    }

    public int getIntrinsicHeight() {
        return this.f4114b.f4124a.h();
    }

    public int getIntrinsicWidth() {
        return this.f4114b.f4124a.k();
    }

    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f4114b.f4124a.j();
    }

    public boolean isRunning() {
        return this.f4115c;
    }

    public void k() {
        this.f4117e = true;
        this.f4114b.f4124a.a();
    }

    public void m(l<Bitmap> lVar, Bitmap bitmap) {
        this.f4114b.f4124a.o(lVar, bitmap);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4121i = true;
    }

    public void setAlpha(int i2) {
        h().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        j.a(!this.f4117e, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f4118f = z;
        if (!z) {
            o();
        } else if (this.f4116d) {
            n();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f4116d = true;
        l();
        if (this.f4118f) {
            n();
        }
    }

    public void stop() {
        this.f4116d = false;
        o();
    }

    c(a aVar) {
        this.f4118f = true;
        this.f4120h = -1;
        j.d(aVar);
        this.f4114b = aVar;
    }
}
