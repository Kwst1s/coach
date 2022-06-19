package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.widget.i;
import b.a.j;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> O = new a(Float.class, "thumbPos");
    private static final int[] P = {16842912};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private final TextPaint G;
    private ColorStateList H;
    private Layout I;
    private Layout J;
    private TransformationMethod K;
    ObjectAnimator L;
    private final s M;
    private final Rect N;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f504b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f505c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f506d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f507e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f508f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f509g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f510h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f511i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f512j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f513k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private CharSequence p;
    private CharSequence q;
    private boolean r;
    private int s;
    private int t;
    private float u;
    private float v;
    private VelocityTracker w;
    private int x;
    float y;
    private int z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.y);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.switchStyle);
    }

    private void a(boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, O, z2 ? 1.0f : Utils.FLOAT_EPSILON);
        this.L = ofFloat;
        ofFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.L.setAutoCancel(true);
        }
        this.L.start();
    }

    private void b() {
        Drawable drawable = this.f504b;
        if (drawable == null) {
            return;
        }
        if (this.f507e || this.f508f) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f504b = mutate;
            if (this.f507e) {
                androidx.core.graphics.drawable.a.o(mutate, this.f505c);
            }
            if (this.f508f) {
                androidx.core.graphics.drawable.a.p(this.f504b, this.f506d);
            }
            if (this.f504b.isStateful()) {
                this.f504b.setState(getDrawableState());
            }
        }
    }

    private void c() {
        Drawable drawable = this.f509g;
        if (drawable == null) {
            return;
        }
        if (this.f512j || this.f513k) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f509g = mutate;
            if (this.f512j) {
                androidx.core.graphics.drawable.a.o(mutate, this.f510h);
            }
            if (this.f513k) {
                androidx.core.graphics.drawable.a.p(this.f509g, this.f511i);
            }
            if (this.f509g.isStateful()) {
                this.f509g.setState(getDrawableState());
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private boolean g(float f2, float f3) {
        if (this.f504b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f504b.getPadding(this.N);
        int i2 = this.D;
        int i3 = this.t;
        int i4 = i2 - i3;
        int i5 = (this.C + thumbOffset) - i3;
        Rect rect = this.N;
        int i6 = this.B + i5 + rect.left + rect.right + i3;
        int i7 = this.F + i3;
        if (f2 <= ((float) i5) || f2 >= ((float) i6) || f3 <= ((float) i4) || f3 >= ((float) i7)) {
            return false;
        }
        return true;
    }

    private boolean getTargetCheckedState() {
        return this.y > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (w0.b(this)) {
            f2 = 1.0f - this.y;
        } else {
            f2 = this.y;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f509g;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.N;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f504b;
        if (drawable2 != null) {
            rect = x.d(drawable2);
        } else {
            rect = x.f804c;
        }
        return ((((this.z - this.B) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        TextPaint textPaint = this.G;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, Utils.FLOAT_EPSILON, true);
    }

    private void k(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        j(typeface, i3);
    }

    private void l(MotionEvent motionEvent) {
        this.s = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.w.computeCurrentVelocity(1000);
            float xVelocity = this.w.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.x)) {
                z2 = getTargetCheckedState();
            } else if (!w0.b(this) ? xVelocity <= Utils.FLOAT_EPSILON : xVelocity >= Utils.FLOAT_EPSILON) {
                z2 = false;
            }
        } else {
            z2 = isChecked;
        }
        if (z2 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z2);
        e(motionEvent);
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.N;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f504b;
        if (drawable != null) {
            rect = x.d(drawable);
        } else {
            rect = x.f804c;
        }
        Drawable drawable2 = this.f509g;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f509g.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f509g.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f504b;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.B + rect2.right;
            this.f504b.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f504b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
        Drawable drawable2 = this.f509g;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f504b;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f509g;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!w0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (w0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.r;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.f504b;
    }

    public int getThumbTextPadding() {
        return this.l;
    }

    public ColorStateList getThumbTintList() {
        return this.f505c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f506d;
    }

    public Drawable getTrackDrawable() {
        return this.f509g;
    }

    public ColorStateList getTrackTintList() {
        return this.f510h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f511i;
    }

    public void i(Context context, int i2) {
        q0 t2 = q0.t(context, i2, j.J2);
        ColorStateList c2 = t2.c(j.N2);
        if (c2 != null) {
            this.H = c2;
        } else {
            this.H = getTextColors();
        }
        int f2 = t2.f(j.K2, 0);
        if (f2 != 0) {
            float f3 = (float) f2;
            if (f3 != this.G.getTextSize()) {
                this.G.setTextSize(f3);
                requestLayout();
            }
        }
        k(t2.k(j.L2, -1), t2.k(j.M2, -1));
        if (t2.a(j.U2, false)) {
            this.K = new b.a.n.a(getContext());
        } else {
            this.K = null;
        }
        t2.w();
    }

    public void j(Typeface typeface, int i2) {
        Typeface typeface2;
        float f2 = Utils.FLOAT_EPSILON;
        boolean z2 = false;
        if (i2 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i2);
            } else {
                typeface2 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(typeface2);
            int style = ((typeface2 != null ? typeface2.getStyle() : 0) ^ -1) & i2;
            TextPaint textPaint = this.G;
            if ((style & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.G;
            if ((style & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.G.setFakeBoldText(false);
        this.G.setTextSkewX(Utils.FLOAT_EPSILON);
        setSwitchTypeface(typeface);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f504b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f509g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.L.end();
            this.L = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, P);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f509g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.D;
        int i4 = this.F;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f504b;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d2 = x.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.I : this.J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.H;
            if (colorStateList != null) {
                this.G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.f504b != null) {
            Rect rect = this.N;
            Drawable drawable = this.f509g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = x.d(this.f504b);
            i6 = Math.max(0, d2.left - rect.left);
            i12 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (w0.b(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.z + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.z) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i11 = this.A;
            i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.A;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.A;
            this.C = i8;
            this.D = i10;
            this.F = i9;
            this.E = i7;
        }
        i9 = i11 + i10;
        this.C = i8;
        this.D = i10;
        this.F = i9;
        this.E = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.r) {
            if (this.I == null) {
                this.I = h(this.p);
            }
            if (this.J == null) {
                this.J = h(this.q);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f504b;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f504b.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f504b.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        this.B = Math.max(this.r ? Math.max(this.I.getWidth(), this.J.getWidth()) + (this.l * 2) : 0, i5);
        Drawable drawable2 = this.f509g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f509g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f504b;
        if (drawable3 != null) {
            Rect d2 = x.d(drawable3);
            i7 = Math.max(i7, d2.left);
            i8 = Math.max(i8, d2.right);
        }
        int max = Math.max(this.m, (this.B * 2) + i7 + i8);
        int max2 = Math.max(i6, i4);
        this.z = max;
        this.A = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !u.S(this)) {
            d();
            setThumbPosition(isChecked ? 1.0f : Utils.FLOAT_EPSILON);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.s(this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.o = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.G.getTypeface() != null && !this.G.getTypeface().equals(typeface)) || (this.G.getTypeface() == null && typeface != null)) {
            this.G.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f504b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f504b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.y = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(b.a.k.a.a.d(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f505c = colorStateList;
        this.f507e = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f506d = mode;
        this.f508f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f509g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f509g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(b.a.k.a.a.d(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f510h = colorStateList;
        this.f512j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f511i = mode;
        this.f513k = true;
        c();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f504b || drawable == this.f509g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f505c = null;
        this.f506d = null;
        this.f507e = false;
        this.f508f = false;
        this.f510h = null;
        this.f511i = null;
        this.f512j = false;
        this.f513k = false;
        this.w = VelocityTracker.obtain();
        this.N = new Rect();
        l0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.G = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = j.u2;
        q0 v2 = q0.v(context, attributeSet, iArr, i2, 0);
        u.k0(this, context, iArr, attributeSet, v2.r(), i2, 0);
        Drawable g2 = v2.g(j.x2);
        this.f504b = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        Drawable g3 = v2.g(j.G2);
        this.f509g = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        this.p = v2.p(j.v2);
        this.q = v2.p(j.w2);
        this.r = v2.a(j.y2, true);
        this.l = v2.f(j.D2, 0);
        this.m = v2.f(j.A2, 0);
        this.n = v2.f(j.B2, 0);
        this.o = v2.a(j.z2, false);
        ColorStateList c2 = v2.c(j.E2);
        if (c2 != null) {
            this.f505c = c2;
            this.f507e = true;
        }
        PorterDuff.Mode e2 = x.e(v2.k(j.F2, -1), null);
        if (this.f506d != e2) {
            this.f506d = e2;
            this.f508f = true;
        }
        if (this.f507e || this.f508f) {
            b();
        }
        ColorStateList c3 = v2.c(j.H2);
        if (c3 != null) {
            this.f510h = c3;
            this.f512j = true;
        }
        PorterDuff.Mode e3 = x.e(v2.k(j.I2, -1), null);
        if (this.f511i != e3) {
            this.f511i = e3;
            this.f513k = true;
        }
        if (this.f512j || this.f513k) {
            c();
        }
        int n2 = v2.n(j.C2, 0);
        if (n2 != 0) {
            i(context, n2);
        }
        s sVar = new s(this);
        this.M = sVar;
        sVar.m(attributeSet, i2);
        v2.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledTouchSlop();
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
