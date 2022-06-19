package c.e.a.b.a0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import c.e.a.b.c0.g;
import c.e.a.b.c0.k;
import c.e.a.b.c0.n;

/* compiled from: RippleDrawableCompat */
public class a extends Drawable implements n, androidx.core.graphics.drawable.b {

    /* renamed from: b  reason: collision with root package name */
    private b f3239b;

    public a a() {
        this.f3239b = new b(this.f3239b);
        return this;
    }

    public void draw(Canvas canvas) {
        b bVar = this.f3239b;
        if (bVar.f3241b) {
            bVar.f3240a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f3239b;
    }

    public int getOpacity() {
        return this.f3239b.f3240a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3239b.f3240a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f3239b.f3240a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e2 = b.e(iArr);
        b bVar = this.f3239b;
        if (bVar.f3241b == e2) {
            return onStateChange;
        }
        bVar.f3241b = e2;
        return true;
    }

    public void setAlpha(int i2) {
        this.f3239b.f3240a.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3239b.f3240a.setColorFilter(colorFilter);
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f3239b.f3240a.setShapeAppearanceModel(kVar);
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        this.f3239b.f3240a.setTint(i2);
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f3239b.f3240a.setTintList(colorStateList);
    }

    @Override // androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3239b.f3240a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* access modifiers changed from: package-private */
    /* compiled from: RippleDrawableCompat */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        g f3240a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3241b;

        public b(g gVar) {
            this.f3240a = gVar;
            this.f3241b = false;
        }

        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f3240a = (g) bVar.f3240a.getConstantState().newDrawable();
            this.f3241b = bVar.f3241b;
        }
    }

    private a(b bVar) {
        this.f3239b = bVar;
    }
}
