package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import b.d.b;
import b.d.d;
import b.d.e;
import com.github.mikephil.charting.utils.Utils;

public class CardView extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f820i = {16842801};

    /* renamed from: j  reason: collision with root package name */
    private static final e f821j;

    /* renamed from: b  reason: collision with root package name */
    private boolean f822b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f823c;

    /* renamed from: d  reason: collision with root package name */
    int f824d;

    /* renamed from: e  reason: collision with root package name */
    int f825e;

    /* renamed from: f  reason: collision with root package name */
    final Rect f826f;

    /* renamed from: g  reason: collision with root package name */
    final Rect f827g;

    /* renamed from: h  reason: collision with root package name */
    private final d f828h;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f829a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.f827g.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.f826f;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public View b() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.d
        public void c(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f824d) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f825e) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.d
        public void d(Drawable drawable) {
            this.f829a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean f() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable g() {
            return this.f829a;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f821j = new b();
        } else if (i2 >= 17) {
            f821j = new a();
        } else {
            f821j = new c();
        }
        f821j.f();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.d.a.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return f821j.b(this.f828h);
    }

    public float getCardElevation() {
        return f821j.e(this.f828h);
    }

    public int getContentPaddingBottom() {
        return this.f826f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f826f.left;
    }

    public int getContentPaddingRight() {
        return this.f826f.right;
    }

    public int getContentPaddingTop() {
        return this.f826f.top;
    }

    public float getMaxCardElevation() {
        return f821j.a(this.f828h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f823c;
    }

    public float getRadius() {
        return f821j.g(this.f828h);
    }

    public boolean getUseCompatPadding() {
        return this.f822b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        e eVar = f821j;
        if (!(eVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.i(this.f828h)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.h(this.f828h)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f821j.m(this.f828h, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f821j.k(this.f828h, f2);
    }

    public void setMaxCardElevation(float f2) {
        f821j.n(this.f828h, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f825e = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f824d = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f823c) {
            this.f823c = z;
            f821j.l(this.f828h);
        }
    }

    public void setRadius(float f2) {
        f821j.d(this.f828h, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f822b != z) {
            this.f822b = z;
            f821j.j(this.f828h);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f826f = rect;
        this.f827g = new Rect();
        a aVar = new a();
        this.f828h = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f2146a, i2, d.CardView);
        int i4 = e.f2149d;
        if (obtainStyledAttributes.hasValue(i4)) {
            valueOf = obtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f820i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(b.cardview_light_background);
            } else {
                i3 = getResources().getColor(b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        float dimension = obtainStyledAttributes.getDimension(e.f2150e, Utils.FLOAT_EPSILON);
        float dimension2 = obtainStyledAttributes.getDimension(e.f2151f, Utils.FLOAT_EPSILON);
        float dimension3 = obtainStyledAttributes.getDimension(e.f2152g, Utils.FLOAT_EPSILON);
        this.f822b = obtainStyledAttributes.getBoolean(e.f2154i, false);
        this.f823c = obtainStyledAttributes.getBoolean(e.f2153h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.f2155j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(e.l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(e.n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(e.m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(e.f2156k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f824d = obtainStyledAttributes.getDimensionPixelSize(e.f2147b, 0);
        this.f825e = obtainStyledAttributes.getDimensionPixelSize(e.f2148c, 0);
        obtainStyledAttributes.recycle();
        f821j.c(aVar, context, valueOf, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f821j.m(this.f828h, colorStateList);
    }
}
