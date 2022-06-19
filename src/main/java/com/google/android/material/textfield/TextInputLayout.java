package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.x;
import androidx.core.widget.i;
import b.h.k.u;
import c.e.a.b.j;
import c.e.a.b.k;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    private static final int K0 = k.Widget_Design_TextInputLayout;
    private CharSequence A;
    private int A0;
    private boolean B;
    private int B0;
    private c.e.a.b.c0.g C;
    private int C0;
    private c.e.a.b.c0.g D;
    private boolean D0;
    private c.e.a.b.c0.k E;
    final com.google.android.material.internal.a E0;
    private final int F;
    private boolean F0;
    private int G;
    private boolean G0;
    private int H;
    private ValueAnimator H0;
    private int I;
    private boolean I0;
    private int J;
    private boolean J0;
    private int K;
    private int L;
    private int M;
    private final Rect N;
    private final Rect O;
    private final RectF P;
    private Typeface Q;
    private final CheckableImageButton R;
    private ColorStateList S;
    private boolean T;
    private PorterDuff.Mode U;
    private boolean V;
    private Drawable W;
    private int a0;

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f7985b;
    private View.OnLongClickListener b0;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f7986c;
    private final LinkedHashSet<f> c0;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f7987d;
    private int d0;

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f7988e;
    private final SparseArray<e> e0;

    /* renamed from: f  reason: collision with root package name */
    EditText f7989f;
    private final CheckableImageButton f0;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f7990g;
    private final LinkedHashSet<g> g0;

    /* renamed from: h  reason: collision with root package name */
    private final f f7991h;
    private ColorStateList h0;

    /* renamed from: i  reason: collision with root package name */
    boolean f7992i;
    private boolean i0;

    /* renamed from: j  reason: collision with root package name */
    private int f7993j;
    private PorterDuff.Mode j0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7994k;
    private boolean k0;
    private TextView l;
    private Drawable l0;
    private int m;
    private int m0;
    private int n;
    private Drawable n0;
    private CharSequence o;
    private View.OnLongClickListener o0;
    private boolean p;
    private View.OnLongClickListener p0;
    private TextView q;
    private final CheckableImageButton q0;
    private ColorStateList r;
    private ColorStateList r0;
    private int s;
    private ColorStateList s0;
    private ColorStateList t;
    private ColorStateList t0;
    private ColorStateList u;
    private int u0;
    private CharSequence v;
    private int v0;
    private final TextView w;
    private int w0;
    private CharSequence x;
    private ColorStateList x0;
    private final TextView y;
    private int y0;
    private boolean z;
    private int z0;

    /* access modifiers changed from: package-private */
    public class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u0(!textInputLayout.J0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f7992i) {
                textInputLayout2.n0(editable.length());
            }
            if (TextInputLayout.this.p) {
                TextInputLayout.this.y0(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TextInputLayout.this.f0.performClick();
            TextInputLayout.this.f0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            TextInputLayout.this.f7989f.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.V(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends b.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f7999d;

        public e(TextInputLayout textInputLayout) {
            this.f7999d = textInputLayout;
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f7999d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f7999d.getHint();
            CharSequence error = this.f7999d.getError();
            int counterMaxLength = this.f7999d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f7999d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : BuildConfig.FLAVOR;
            if (z) {
                cVar.A0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                cVar.A0(charSequence);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.l0(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    cVar.A0(charSequence);
                }
                cVar.w0(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.n0(counterMaxLength);
            if (z4) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.h0(error);
            }
            if (Build.VERSION.SDK_INT >= 17 && editText != null) {
                editText.setLabelFor(c.e.a.b.f.textinput_helper_text);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i2);
    }

    /* access modifiers changed from: package-private */
    public static class h extends b.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        CharSequence f8000d;

        /* renamed from: e  reason: collision with root package name */
        boolean f8001e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f8002f;

        /* renamed from: g  reason: collision with root package name */
        CharSequence f8003g;

        /* renamed from: h  reason: collision with root package name */
        CharSequence f8004h;

        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* renamed from: c */
            public h[] newArray(int i2) {
                return new h[i2];
            }
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f8000d) + " hint=" + ((Object) this.f8002f) + " helperText=" + ((Object) this.f8003g) + " placeholderText=" + ((Object) this.f8004h) + "}";
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f8000d, parcel, i2);
            parcel.writeInt(this.f8001e ? 1 : 0);
            TextUtils.writeToParcel(this.f8002f, parcel, i2);
            TextUtils.writeToParcel(this.f8003g, parcel, i2);
            TextUtils.writeToParcel(this.f8004h, parcel, i2);
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8000d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8001e = parcel.readInt() != 1 ? false : true;
            this.f8002f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8003g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8004h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.e.a.b.b.textInputStyle);
    }

    private boolean A() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof c);
    }

    private void A0() {
        this.w.setVisibility((this.v == null || N()) ? 8 : 0);
        q0();
    }

    private void B() {
        Iterator<f> it = this.c0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void B0(boolean z2, boolean z3) {
        int defaultColor = this.x0.getDefaultColor();
        int colorForState = this.x0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.x0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.L = colorForState2;
        } else if (z3) {
            this.L = colorForState;
        } else {
            this.L = defaultColor;
        }
    }

    private void C(int i2) {
        Iterator<g> it = this.g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private void C0() {
        if (this.f7989f != null) {
            u.A0(this.y, 0, this.f7989f.getPaddingTop(), (K() || L()) ? 0 : u.F(this.f7989f), this.f7989f.getPaddingBottom());
        }
    }

    private void D(Canvas canvas) {
        c.e.a.b.c0.g gVar = this.D;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    private void D0() {
        int visibility = this.y.getVisibility();
        int i2 = 0;
        boolean z2 = this.x != null && !N();
        TextView textView = this.y;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.y.getVisibility()) {
            getEndIconDelegate().c(z2);
        }
        q0();
    }

    private void E(Canvas canvas) {
        if (this.z) {
            this.E0.j(canvas);
        }
    }

    private void F(boolean z2) {
        ValueAnimator valueAnimator = this.H0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H0.cancel();
        }
        if (!z2 || !this.G0) {
            this.E0.V(Utils.FLOAT_EPSILON);
        } else {
            i(Utils.FLOAT_EPSILON);
        }
        if (A() && ((c) this.C).k0()) {
            y();
        }
        this.D0 = true;
        J();
        A0();
        D0();
    }

    private int G(int i2, boolean z2) {
        int compoundPaddingLeft = i2 + this.f7989f.getCompoundPaddingLeft();
        return (this.v == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    private int H(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f7989f.getCompoundPaddingRight();
        return (this.v == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    private boolean I() {
        return this.d0 != 0;
    }

    private void J() {
        TextView textView = this.q;
        if (textView != null && this.p) {
            textView.setText((CharSequence) null);
            this.q.setVisibility(4);
        }
    }

    private boolean L() {
        return this.q0.getVisibility() == 0;
    }

    private boolean P() {
        if (this.G != 1 || (Build.VERSION.SDK_INT >= 16 && this.f7989f.getMinLines() > 1)) {
            return false;
        }
        return true;
    }

    private int[] R(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void S() {
        p();
        a0();
        E0();
        k0();
        h();
        if (this.G != 0) {
            t0();
        }
    }

    private void T() {
        if (A()) {
            RectF rectF = this.P;
            this.E0.m(rectF, this.f7989f.getWidth(), this.f7989f.getGravity());
            l(rectF);
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            ((c) this.C).q0(rectF);
        }
    }

    private static void U(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                U((ViewGroup) childAt, z2);
            }
        }
    }

    private void X(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(R(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void Z() {
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void a0() {
        if (h0()) {
            u.q0(this.f7989f, this.C);
        }
    }

    private static void b0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean N2 = u.N(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (N2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(N2);
        checkableImageButton.setPressable(N2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        u.x0(checkableImageButton, i2);
    }

    private static void c0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        b0(checkableImageButton, onLongClickListener);
    }

    private static void d0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        b0(checkableImageButton, onLongClickListener);
    }

    private boolean f0() {
        return (this.q0.getVisibility() == 0 || ((I() && K()) || this.x != null)) && this.f7987d.getMeasuredWidth() > 0;
    }

    private void g() {
        TextView textView = this.q;
        if (textView != null) {
            this.f7985b.addView(textView);
            this.q.setVisibility(0);
        }
    }

    private boolean g0() {
        return !(getStartIconDrawable() == null && this.v == null) && this.f7986c.getMeasuredWidth() > 0;
    }

    private e getEndIconDelegate() {
        e eVar = this.e0.get(this.d0);
        return eVar != null ? eVar : this.e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.q0.getVisibility() == 0) {
            return this.q0;
        }
        if (!I() || !K()) {
            return null;
        }
        return this.f0;
    }

    private void h() {
        if (this.f7989f != null && this.G == 1) {
            if (c.e.a.b.z.c.h(getContext())) {
                EditText editText = this.f7989f;
                u.A0(editText, u.G(editText), getResources().getDimensionPixelSize(c.e.a.b.d.material_filled_edittext_font_2_0_padding_top), u.F(this.f7989f), getResources().getDimensionPixelSize(c.e.a.b.d.material_filled_edittext_font_2_0_padding_bottom));
            } else if (c.e.a.b.z.c.g(getContext())) {
                EditText editText2 = this.f7989f;
                u.A0(editText2, u.G(editText2), getResources().getDimensionPixelSize(c.e.a.b.d.material_filled_edittext_font_1_3_padding_top), u.F(this.f7989f), getResources().getDimensionPixelSize(c.e.a.b.d.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private boolean h0() {
        EditText editText = this.f7989f;
        return (editText == null || this.C == null || editText.getBackground() != null || this.G == 0) ? false : true;
    }

    private void i0() {
        TextView textView = this.q;
        if (textView != null && this.p) {
            textView.setText(this.o);
            this.q.setVisibility(0);
            this.q.bringToFront();
        }
    }

    private void j() {
        c.e.a.b.c0.g gVar = this.C;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(this.E);
            if (w()) {
                this.C.d0((float) this.I, this.L);
            }
            int q2 = q();
            this.M = q2;
            this.C.X(ColorStateList.valueOf(q2));
            if (this.d0 == 3) {
                this.f7989f.getBackground().invalidateSelf();
            }
            k();
            invalidate();
        }
    }

    private void j0(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            m();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.n(mutate, this.f7991h.o());
        this.f0.setImageDrawable(mutate);
    }

    private void k() {
        if (this.D != null) {
            if (x()) {
                this.D.X(ColorStateList.valueOf(this.L));
            }
            invalidate();
        }
    }

    private void k0() {
        if (this.G != 1) {
            return;
        }
        if (c.e.a.b.z.c.h(getContext())) {
            this.H = getResources().getDimensionPixelSize(c.e.a.b.d.material_font_2_0_box_collapsed_padding_top);
        } else if (c.e.a.b.z.c.g(getContext())) {
            this.H = getResources().getDimensionPixelSize(c.e.a.b.d.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void l(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.F;
        rectF.left = f2 - ((float) i2);
        rectF.top -= (float) i2;
        rectF.right += (float) i2;
        rectF.bottom += (float) i2;
    }

    private void l0(Rect rect) {
        c.e.a.b.c0.g gVar = this.D;
        if (gVar != null) {
            int i2 = rect.bottom;
            gVar.setBounds(rect.left, i2 - this.K, rect.right, i2);
        }
    }

    private void m() {
        n(this.f0, this.i0, this.h0, this.k0, this.j0);
    }

    private void m0() {
        if (this.l != null) {
            EditText editText = this.f7989f;
            n0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void n(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (z2) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
            if (z3) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void o() {
        n(this.R, this.T, this.S, this.V, this.U);
    }

    private static void o0(Context context, TextView textView, int i2, int i3, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? j.character_counter_overflowed_content_description : j.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private void p() {
        int i2 = this.G;
        if (i2 == 0) {
            this.C = null;
            this.D = null;
        } else if (i2 == 1) {
            this.C = new c.e.a.b.c0.g(this.E);
            this.D = new c.e.a.b.c0.g();
        } else if (i2 == 2) {
            if (!this.z || (this.C instanceof c)) {
                this.C = new c.e.a.b.c0.g(this.E);
            } else {
                this.C = new c(this.E);
            }
            this.D = null;
        } else {
            throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private void p0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.l;
        if (textView != null) {
            e0(textView, this.f7994k ? this.m : this.n);
            if (!this.f7994k && (colorStateList2 = this.t) != null) {
                this.l.setTextColor(colorStateList2);
            }
            if (this.f7994k && (colorStateList = this.u) != null) {
                this.l.setTextColor(colorStateList);
            }
        }
    }

    private int q() {
        return this.G == 1 ? c.e.a.b.s.a.e(c.e.a.b.s.a.d(this, c.e.a.b.b.colorSurface, 0), this.M) : this.M;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean q0() {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q0():boolean");
    }

    private Rect r(Rect rect) {
        if (this.f7989f != null) {
            Rect rect2 = this.O;
            boolean z2 = u.B(this) == 1;
            rect2.bottom = rect.bottom;
            int i2 = this.G;
            if (i2 == 1) {
                rect2.left = G(rect.left, z2);
                rect2.top = rect.top + this.H;
                rect2.right = H(rect.right, z2);
                return rect2;
            } else if (i2 != 2) {
                rect2.left = G(rect.left, z2);
                rect2.top = getPaddingTop();
                rect2.right = H(rect.right, z2);
                return rect2;
            } else {
                rect2.left = rect.left + this.f7989f.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f7989f.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int s(Rect rect, Rect rect2, float f2) {
        if (P()) {
            return (int) (((float) rect2.top) + f2);
        }
        return rect.bottom - this.f7989f.getCompoundPaddingBottom();
    }

    private boolean s0() {
        int max;
        if (this.f7989f == null || this.f7989f.getMeasuredHeight() >= (max = Math.max(this.f7987d.getMeasuredHeight(), this.f7986c.getMeasuredHeight()))) {
            return false;
        }
        this.f7989f.setMinimumHeight(max);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.f7989f == null) {
            if (this.d0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f7989f = editText;
            S();
            setTextInputAccessibilityDelegate(new e(this));
            this.E0.b0(this.f7989f.getTypeface());
            this.E0.T(this.f7989f.getTextSize());
            int gravity = this.f7989f.getGravity();
            this.E0.L((gravity & -113) | 48);
            this.E0.S(gravity);
            this.f7989f.addTextChangedListener(new a());
            if (this.s0 == null) {
                this.s0 = this.f7989f.getHintTextColors();
            }
            if (this.z) {
                if (TextUtils.isEmpty(this.A)) {
                    CharSequence hint = this.f7989f.getHint();
                    this.f7990g = hint;
                    setHint(hint);
                    this.f7989f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.l != null) {
                n0(this.f7989f.getText().length());
            }
            r0();
            this.f7991h.e();
            this.f7986c.bringToFront();
            this.f7987d.bringToFront();
            this.f7988e.bringToFront();
            this.q0.bringToFront();
            B();
            z0();
            C0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            v0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.q0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f7988e;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        C0();
        if (!I()) {
            q0();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.A)) {
            this.A = charSequence;
            this.E0.Z(charSequence);
            if (!this.D0) {
                T();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.p != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.q = appCompatTextView;
                appCompatTextView.setId(c.e.a.b.f.textinput_placeholder);
                u.o0(this.q, 1);
                setPlaceholderTextAppearance(this.s);
                setPlaceholderTextColor(this.r);
                g();
            } else {
                Z();
                this.q = null;
            }
            this.p = z2;
        }
    }

    private int t(Rect rect, float f2) {
        if (P()) {
            return (int) (((float) rect.centerY()) - (f2 / 2.0f));
        }
        return rect.top + this.f7989f.getCompoundPaddingTop();
    }

    private void t0() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7985b.getLayoutParams();
            int v2 = v();
            if (v2 != layoutParams.topMargin) {
                layoutParams.topMargin = v2;
                this.f7985b.requestLayout();
            }
        }
    }

    private Rect u(Rect rect) {
        if (this.f7989f != null) {
            Rect rect2 = this.O;
            float u2 = this.E0.u();
            rect2.left = rect.left + this.f7989f.getCompoundPaddingLeft();
            rect2.top = t(rect, u2);
            rect2.right = rect.right - this.f7989f.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, u2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int v() {
        float o2;
        if (!this.z) {
            return 0;
        }
        int i2 = this.G;
        if (i2 == 0 || i2 == 1) {
            o2 = this.E0.o();
        } else if (i2 != 2) {
            return 0;
        } else {
            o2 = this.E0.o() / 2.0f;
        }
        return (int) o2;
    }

    private void v0(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f7989f;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f7989f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean k2 = this.f7991h.k();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            this.E0.K(colorStateList2);
            this.E0.R(this.s0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.s0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.K(ColorStateList.valueOf(colorForState));
            this.E0.R(ColorStateList.valueOf(colorForState));
        } else if (k2) {
            this.E0.K(this.f7991h.p());
        } else if (this.f7994k && (textView = this.l) != null) {
            this.E0.K(textView.getTextColors());
        } else if (z5 && (colorStateList = this.t0) != null) {
            this.E0.K(colorStateList);
        }
        if (z4 || !this.F0 || (isEnabled() && z5)) {
            if (z3 || this.D0) {
                z(z2);
            }
        } else if (z3 || !this.D0) {
            F(z2);
        }
    }

    private boolean w() {
        return this.G == 2 && x();
    }

    private void w0() {
        EditText editText;
        if (this.q != null && (editText = this.f7989f) != null) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f7989f.getCompoundPaddingLeft(), this.f7989f.getCompoundPaddingTop(), this.f7989f.getCompoundPaddingRight(), this.f7989f.getCompoundPaddingBottom());
        }
    }

    private boolean x() {
        return this.I > -1 && this.L != 0;
    }

    private void x0() {
        EditText editText = this.f7989f;
        y0(editText == null ? 0 : editText.getText().length());
    }

    private void y() {
        if (A()) {
            ((c) this.C).n0();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y0(int i2) {
        if (i2 != 0 || this.D0) {
            J();
        } else {
            i0();
        }
    }

    private void z(boolean z2) {
        ValueAnimator valueAnimator = this.H0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H0.cancel();
        }
        if (!z2 || !this.G0) {
            this.E0.V(1.0f);
        } else {
            i(1.0f);
        }
        this.D0 = false;
        if (A()) {
            T();
        }
        x0();
        A0();
        D0();
    }

    private void z0() {
        if (this.f7989f != null) {
            u.A0(this.w, Q() ? 0 : u.G(this.f7989f), this.f7989f.getCompoundPaddingTop(), 0, this.f7989f.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void E0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C != null && this.G != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.f7989f) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.f7989f) != null && editText.isHovered());
            if (!isEnabled()) {
                this.L = this.C0;
            } else if (this.f7991h.k()) {
                if (this.x0 != null) {
                    B0(z3, z4);
                } else {
                    this.L = this.f7991h.o();
                }
            } else if (!this.f7994k || (textView = this.l) == null) {
                if (z3) {
                    this.L = this.w0;
                } else if (z4) {
                    this.L = this.v0;
                } else {
                    this.L = this.u0;
                }
            } else if (this.x0 != null) {
                B0(z3, z4);
            } else {
                this.L = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null && this.f7991h.x() && this.f7991h.k()) {
                z2 = true;
            }
            setErrorIconVisible(z2);
            W();
            Y();
            V();
            if (getEndIconDelegate().d()) {
                j0(this.f7991h.k());
            }
            if (!z3 || !isEnabled()) {
                this.I = this.J;
            } else {
                this.I = this.K;
            }
            if (this.G == 1) {
                if (!isEnabled()) {
                    this.M = this.z0;
                } else if (z4 && !z3) {
                    this.M = this.B0;
                } else if (z3) {
                    this.M = this.A0;
                } else {
                    this.M = this.y0;
                }
            }
            j();
        }
    }

    public boolean K() {
        return this.f7988e.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    public boolean M() {
        return this.f7991h.y();
    }

    /* access modifiers changed from: package-private */
    public final boolean N() {
        return this.D0;
    }

    public boolean O() {
        return this.B;
    }

    public boolean Q() {
        return this.R.getVisibility() == 0;
    }

    public void V() {
        X(this.f0, this.h0);
    }

    public void W() {
        X(this.q0, this.r0);
    }

    public void Y() {
        X(this.R, this.S);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f7985b.addView(view, layoutParams2);
            this.f7985b.setLayoutParams(layoutParams);
            t0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f7989f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f7990g != null) {
            boolean z2 = this.B;
            this.B = false;
            CharSequence hint = editText.getHint();
            this.f7989f.setHint(this.f7990g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.f7989f.setHint(hint);
                this.B = z2;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.f7985b.getChildCount());
            for (int i3 = 0; i3 < this.f7985b.getChildCount(); i3++) {
                View childAt = this.f7985b.getChildAt(i3);
                ViewStructure newChild = viewStructure.newChild(i3);
                childAt.dispatchProvideAutofillStructure(newChild, i2);
                if (childAt == this.f7989f) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.J0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.J0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.I0) {
            boolean z2 = true;
            this.I0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            com.google.android.material.internal.a aVar = this.E0;
            boolean Y = aVar != null ? aVar.Y(drawableState) | false : false;
            if (this.f7989f != null) {
                if (!u.S(this) || !isEnabled()) {
                    z2 = false;
                }
                u0(z2);
            }
            r0();
            E0();
            if (Y) {
                invalidate();
            }
            this.I0 = false;
        }
    }

    public void e(f fVar) {
        this.c0.add(fVar);
        if (this.f7989f != null) {
            fVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void e0(TextView textView, int i2) {
        boolean z2 = true;
        try {
            i.q(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            i.q(textView, k.TextAppearance_AppCompat_Caption);
            textView.setTextColor(b.h.d.a.b(getContext(), c.e.a.b.c.design_error));
        }
    }

    public void f(g gVar) {
        this.g0.add(gVar);
    }

    public int getBaseline() {
        EditText editText = this.f7989f;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public c.e.a.b.c0.g getBoxBackground() {
        int i2 = this.G;
        if (i2 == 1 || i2 == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.M;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.C.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.C.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.C.G();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.F();
    }

    public int getBoxStrokeColor() {
        return this.w0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.x0;
    }

    public int getBoxStrokeWidth() {
        return this.J;
    }

    public int getBoxStrokeWidthFocused() {
        return this.K;
    }

    public int getCounterMaxLength() {
        return this.f7993j;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f7992i || !this.f7994k || (textView = this.l) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.t;
    }

    public ColorStateList getCounterTextColor() {
        return this.t;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.s0;
    }

    public EditText getEditText() {
        return this.f7989f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.d0;
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f0;
    }

    public CharSequence getError() {
        if (this.f7991h.x()) {
            return this.f7991h.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f7991h.m();
    }

    public int getErrorCurrentTextColors() {
        return this.f7991h.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.q0.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.f7991h.o();
    }

    public CharSequence getHelperText() {
        if (this.f7991h.y()) {
            return this.f7991h.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f7991h.r();
    }

    public CharSequence getHint() {
        if (this.z) {
            return this.A;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.E0.o();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.E0.r();
    }

    public ColorStateList getHintTextColor() {
        return this.t0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.p) {
            return this.o;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.s;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.r;
    }

    public CharSequence getPrefixText() {
        return this.v;
    }

    public ColorStateList getPrefixTextColor() {
        return this.w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.w;
    }

    public CharSequence getStartIconContentDescription() {
        return this.R.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.R.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.y;
    }

    public Typeface getTypeface() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public void i(float f2) {
        if (this.E0.v() != f2) {
            if (this.H0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.H0 = valueAnimator;
                valueAnimator.setInterpolator(c.e.a.b.m.a.f3376b);
                this.H0.setDuration(167L);
                this.H0.addUpdateListener(new d());
            }
            this.H0.setFloatValues(this.E0.v(), f2);
            this.H0.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void n0(int i2) {
        boolean z2 = this.f7994k;
        int i3 = this.f7993j;
        if (i3 == -1) {
            this.l.setText(String.valueOf(i2));
            this.l.setContentDescription(null);
            this.f7994k = false;
        } else {
            this.f7994k = i2 > i3;
            o0(getContext(), this.l, i2, this.f7993j, this.f7994k);
            if (z2 != this.f7994k) {
                p0();
            }
            this.l.setText(b.h.i.a.c().j(getContext().getString(j.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f7993j))));
        }
        if (this.f7989f != null && z2 != this.f7994k) {
            u0(false);
            E0();
            r0();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f7989f;
        if (editText != null) {
            Rect rect = this.N;
            com.google.android.material.internal.b.a(this, editText, rect);
            l0(rect);
            if (this.z) {
                this.E0.T(this.f7989f.getTextSize());
                int gravity = this.f7989f.getGravity();
                this.E0.L((gravity & -113) | 48);
                this.E0.S(gravity);
                this.E0.H(r(rect));
                this.E0.P(u(rect));
                this.E0.E();
                if (A() && !this.D0) {
                    T();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean s02 = s0();
        boolean q02 = q0();
        if (s02 || q02) {
            this.f7989f.post(new c());
        }
        w0();
        z0();
        C0();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.g());
        setError(hVar.f8000d);
        if (hVar.f8001e) {
            this.f0.post(new b());
        }
        setHint(hVar.f8002f);
        setHelperText(hVar.f8003g);
        setPlaceholderText(hVar.f8004h);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f7991h.k()) {
            hVar.f8000d = getError();
        }
        hVar.f8001e = I() && this.f0.isChecked();
        hVar.f8002f = getHint();
        hVar.f8003g = getHelperText();
        hVar.f8004h = getPlaceholderText();
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public void r0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f7989f;
        if (editText != null && this.G == 0 && (background = editText.getBackground()) != null) {
            if (x.a(background)) {
                background = background.mutate();
            }
            if (this.f7991h.k()) {
                background.setColorFilter(androidx.appcompat.widget.h.e(this.f7991h.o(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f7994k || (textView = this.l) == null) {
                androidx.core.graphics.drawable.a.c(background);
                this.f7989f.refreshDrawableState();
            } else {
                background.setColorFilter(androidx.appcompat.widget.h.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.M != i2) {
            this.M = i2;
            this.y0 = i2;
            this.A0 = i2;
            this.B0 = i2;
            j();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(b.h.d.a.b(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.y0 = defaultColor;
        this.M = defaultColor;
        this.z0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.B0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.G) {
            this.G = i2;
            if (this.f7989f != null) {
                S();
            }
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.u0 = colorStateList.getDefaultColor();
            this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.v0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.w0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.w0 != colorStateList.getDefaultColor()) {
            this.w0 = colorStateList.getDefaultColor();
        }
        E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            E0();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.J = i2;
        E0();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.K = i2;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f7992i != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.l = appCompatTextView;
                appCompatTextView.setId(c.e.a.b.f.textinput_counter);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.l.setTypeface(typeface);
                }
                this.l.setMaxLines(1);
                this.f7991h.d(this.l, 2);
                b.h.k.h.d((ViewGroup.MarginLayoutParams) this.l.getLayoutParams(), getResources().getDimensionPixelOffset(c.e.a.b.d.mtrl_textinput_counter_margin_start));
                p0();
                m0();
            } else {
                this.f7991h.z(this.l, 2);
                this.l = null;
            }
            this.f7992i = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f7993j != i2) {
            if (i2 > 0) {
                this.f7993j = i2;
            } else {
                this.f7993j = -1;
            }
            if (this.f7992i) {
                m0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.m != i2) {
            this.m = i2;
            p0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            p0();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.n != i2) {
            this.n = i2;
            p0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            p0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.s0 = colorStateList;
        this.t0 = colorStateList;
        if (this.f7989f != null) {
            u0(false);
        }
    }

    public void setEnabled(boolean z2) {
        U(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f0.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.d0;
        this.d0 = i2;
        C(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.G)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.G + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.f0, onClickListener, this.o0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        d0(this.f0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.h0 != colorStateList) {
            this.h0 = colorStateList;
            this.i0 = true;
            m();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.j0 != mode) {
            this.j0 = mode;
            this.k0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (K() != z2) {
            this.f0.setVisibility(z2 ? 0 : 8);
            C0();
            q0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f7991h.x()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f7991h.M(charSequence);
        } else {
            this.f7991h.t();
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f7991h.B(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.f7991h.C(z2);
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
        W();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.q0, onClickListener, this.p0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.p0 = onLongClickListener;
        d0(this.q0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.r0 = colorStateList;
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.f7991h.D(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f7991h.E(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.F0 != z2) {
            this.F0 = z2;
            u0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.f7991h.N(charSequence);
        } else if (M()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f7991h.H(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f7991h.G(z2);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f7991h.F(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.G0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.z) {
            this.z = z2;
            if (!z2) {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f7989f.getHint())) {
                    this.f7989f.setHint(this.A);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f7989f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f7989f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f7989f != null) {
                t0();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.E0.I(i2);
        this.t0 = this.E0.n();
        if (this.f7989f != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                this.E0.K(colorStateList);
            }
            this.t0 = colorStateList;
            if (this.f7989f != null) {
                u0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.d0 != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        this.i0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.j0 = mode;
        this.k0 = true;
        m();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.p || !TextUtils.isEmpty(charSequence)) {
            if (!this.p) {
                setPlaceholderTextEnabled(true);
            }
            this.o = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        x0();
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.s = i2;
        TextView textView = this.q;
        if (textView != null) {
            i.q(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            TextView textView = this.q;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.w.setText(charSequence);
        A0();
    }

    public void setPrefixTextAppearance(int i2) {
        i.q(this.w, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.R.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? b.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        c0(this.R, onClickListener, this.b0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b0 = onLongClickListener;
        d0(this.R, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            o();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z2) {
        if (Q() != z2) {
            this.R.setVisibility(z2 ? 0 : 8);
            z0();
            q0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        D0();
    }

    public void setSuffixTextAppearance(int i2) {
        i.q(this.y, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f7989f;
        if (editText != null) {
            u.m0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.b0(typeface);
            this.f7991h.J(typeface);
            TextView textView = this.l;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u0(boolean z2) {
        v0(z2, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r24, android.util.AttributeSet r25, int r26) {
        /*
        // Method dump skipped, instructions count: 1538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
        V();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.R.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.R.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            Y();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.q0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f7991h.x());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    public void setHint(int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}
