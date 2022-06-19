package c.e.a.b.p;

import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import c.e.a.b.b;
import c.e.a.b.c0.k;
import c.e.a.b.c0.n;

/* compiled from: MaterialCardView */
public class a extends CardView implements Checkable, n {
    private static final int[] p = {16842911};
    private static final int[] q = {16842912};
    private static final int[] r = {b.state_dragged};

    /* renamed from: k  reason: collision with root package name */
    private final b f3419k;
    private boolean l;
    private boolean m;
    private boolean n;
    private AbstractC0080a o;

    /* renamed from: c.e.a.b.p.a$a  reason: collision with other inner class name */
    /* compiled from: MaterialCardView */
    public interface AbstractC0080a {
        void a(a aVar, boolean z);
    }

    private void g() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f3419k.a();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f3419k.b().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f3419k.c();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f3419k.d();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f3419k.e();
    }

    public int getCheckedIconMargin() {
        return this.f3419k.f();
    }

    public int getCheckedIconSize() {
        return this.f3419k.g();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f3419k.h();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f3419k.p().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f3419k.p().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f3419k.p().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f3419k.p().top;
    }

    public float getProgress() {
        return this.f3419k.j();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f3419k.i();
    }

    public ColorStateList getRippleColor() {
        return this.f3419k.k();
    }

    public k getShapeAppearanceModel() {
        return this.f3419k.l();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f3419k.m();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f3419k.n();
    }

    public int getStrokeWidth() {
        return this.f3419k.o();
    }

    public boolean h() {
        b bVar = this.f3419k;
        return bVar != null && bVar.r();
    }

    public boolean i() {
        return this.n;
    }

    public boolean isChecked() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3419k.b();
        throw null;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (h()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (i()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(h());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.cardview.widget.CardView
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f3419k.s(getMeasuredWidth(), getMeasuredHeight());
        throw null;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.l) {
            if (!this.f3419k.q()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f3419k.t(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i2) {
        this.f3419k.u(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f3419k.J();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f3419k.v(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f3419k.w(z);
    }

    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f3419k.x(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f3419k.y(i2);
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f3419k.y(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f3419k.x(b.a.k.a.a.d(getContext(), i2));
        throw null;
    }

    public void setCheckedIconSize(int i2) {
        this.f3419k.z(i2);
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f3419k.z(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f3419k.A(colorStateList);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        b bVar = this.f3419k;
        if (bVar != null) {
            bVar.H();
        }
    }

    public void setDragged(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
            g();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f3419k.K();
    }

    public void setOnCheckedChangeListener(AbstractC0080a aVar) {
        this.o = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f3419k.K();
        this.f3419k.I();
    }

    public void setProgress(float f2) {
        this.f3419k.C(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f3419k.B(f2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f3419k.D(colorStateList);
    }

    public void setRippleColorResource(int i2) {
        this.f3419k.D(b.a.k.a.a.c(getContext(), i2));
        throw null;
    }

    @Override // c.e.a.b.c0.n
    public void setShapeAppearanceModel(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(kVar.u(getBoundsAsRectF()));
        }
        this.f3419k.E(kVar);
        throw null;
    }

    public void setStrokeColor(int i2) {
        this.f3419k.F(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(int i2) {
        this.f3419k.G(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f3419k.K();
        this.f3419k.I();
    }

    public void toggle() {
        if (h() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            g();
            AbstractC0080a aVar = this.o;
            if (aVar != null) {
                aVar.a(this, this.m);
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f3419k.u(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f3419k.F(colorStateList);
    }
}
