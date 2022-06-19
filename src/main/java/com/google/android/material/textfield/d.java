package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b.h.k.u;
import c.e.a.b.c0.k;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

/* access modifiers changed from: package-private */
/* compiled from: DropdownMenuEndIconDelegate */
public class d extends e {
    private static final boolean q = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f8020d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f8021e = new c();

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.e f8022f = new C0159d(this.f8041a);

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.f f8023g = new e();
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.g f8024h = new f();

    /* renamed from: i  reason: collision with root package name */
    private boolean f8025i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8026j = false;

    /* renamed from: k  reason: collision with root package name */
    private long f8027k = Long.MAX_VALUE;
    private StateListDrawable l;
    private c.e.a.b.c0.g m;
    private AccessibilityManager n;
    private ValueAnimator o;
    private ValueAnimator p;

    /* compiled from: DropdownMenuEndIconDelegate */
    class a extends com.google.android.material.internal.i {

        /* renamed from: com.google.android.material.textfield.d$a$a  reason: collision with other inner class name */
        /* compiled from: DropdownMenuEndIconDelegate */
        class RunnableC0158a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f8029b;

            RunnableC0158a(AutoCompleteTextView autoCompleteTextView) {
                this.f8029b = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.f8029b.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f8025i = isPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.i
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y = d.y(d.this.f8041a.getEditText());
            if (d.this.n.isTouchExplorationEnabled() && d.D(y) && !d.this.f8043c.hasFocus()) {
                y.dismissDropDown();
            }
            y.post(new RunnableC0158a(y));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f8043c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        public void onFocusChange(View view, boolean z) {
            d.this.f8041a.setEndIconActivated(z);
            if (!z) {
                d.this.E(false);
                d.this.f8025i = false;
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d  reason: collision with other inner class name */
    /* compiled from: DropdownMenuEndIconDelegate */
    class C0159d extends TextInputLayout.e {
        C0159d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            if (!d.D(d.this.f8041a.getEditText())) {
                cVar.a0(Spinner.class.getName());
            }
            if (cVar.L()) {
                cVar.l0(null);
            }
        }

        @Override // b.h.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView y = d.y(d.this.f8041a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.n.isTouchExplorationEnabled() && !d.D(d.this.f8041a.getEditText())) {
                d.this.H(y);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView y = d.y(textInputLayout.getEditText());
            d.this.F(y);
            d.this.v(y);
            d.this.G(y);
            y.setThreshold(0);
            y.removeTextChangedListener(d.this.f8020d);
            y.addTextChangedListener(d.this.f8020d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y)) {
                u.x0(d.this.f8043c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f8022f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    class f implements TextInputLayout.g {
        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i2 == 3) {
                autoCompleteTextView.removeTextChangedListener(d.this.f8020d);
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f8021e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (d.q) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.f8041a.getEditText());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class h implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f8037b;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f8037b = autoCompleteTextView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f8025i = false;
                }
                d.this.H(this.f8037b);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        public void onDismiss() {
            d.this.f8025i = true;
            d.this.f8027k = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f8043c.setChecked(dVar.f8026j);
            d.this.p.start();
        }
    }

    d(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    private c.e.a.b.c0.g A(float f2, float f3, float f4, int i2) {
        k.b a2 = k.a();
        a2.A(f2);
        a2.E(f2);
        a2.s(f3);
        a2.w(f3);
        k m2 = a2.m();
        c.e.a.b.c0.g m3 = c.e.a.b.c0.g.m(this.f8042b, f4);
        m3.setShapeAppearanceModel(m2);
        m3.Z(0, i2, 0, i2);
        return m3;
    }

    private void B() {
        this.p = z(67, Utils.FLOAT_EPSILON, 1.0f);
        ValueAnimator z = z(50, 1.0f, Utils.FLOAT_EPSILON);
        this.o = z;
        z.addListener(new j());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f8027k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public static boolean D(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void E(boolean z) {
        if (this.f8026j != z) {
            this.f8026j = z;
            this.p.cancel();
            this.o.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void F(AutoCompleteTextView autoCompleteTextView) {
        if (q) {
            int boxBackgroundMode = this.f8041a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.l);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"ClickableViewAccessibility"})
    private void G(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f8021e);
        if (q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void H(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (C()) {
                this.f8025i = false;
            }
            if (!this.f8025i) {
                if (q) {
                    E(!this.f8026j);
                } else {
                    this.f8026j = !this.f8026j;
                    this.f8043c.toggle();
                }
                if (this.f8026j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.f8025i = false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v(AutoCompleteTextView autoCompleteTextView) {
        if (!D(autoCompleteTextView)) {
            int boxBackgroundMode = this.f8041a.getBoxBackgroundMode();
            c.e.a.b.c0.g boxBackground = this.f8041a.getBoxBackground();
            int c2 = c.e.a.b.s.a.c(autoCompleteTextView, c.e.a.b.b.f3256h);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                x(autoCompleteTextView, c2, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                w(autoCompleteTextView, c2, iArr, boxBackground);
            }
        }
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, c.e.a.b.c0.g gVar) {
        int boxBackgroundColor = this.f8041a.getBoxBackgroundColor();
        int[] iArr2 = {c.e.a.b.s.a.f(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (q) {
            u.q0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        c.e.a.b.c0.g gVar2 = new c.e.a.b.c0.g(gVar.C());
        gVar2.X(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int G = u.G(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int F = u.F(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        u.q0(autoCompleteTextView, layerDrawable);
        u.A0(autoCompleteTextView, G, paddingTop, F, paddingBottom);
    }

    private void x(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, c.e.a.b.c0.g gVar) {
        LayerDrawable layerDrawable;
        int c2 = c.e.a.b.s.a.c(autoCompleteTextView, c.e.a.b.b.colorSurface);
        c.e.a.b.c0.g gVar2 = new c.e.a.b.c0.g(gVar.C());
        int f2 = c.e.a.b.s.a.f(i2, c2, 0.1f);
        gVar2.X(new ColorStateList(iArr, new int[]{f2, 0}));
        if (q) {
            gVar2.setTint(c2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{f2, c2});
            c.e.a.b.c0.g gVar3 = new c.e.a.b.c0.g(gVar.C());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        u.q0(autoCompleteTextView, layerDrawable);
    }

    /* access modifiers changed from: private */
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3375a);
        ofFloat.setDuration((long) i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = (float) this.f8042b.getResources().getDimensionPixelOffset(c.e.a.b.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f8042b.getResources().getDimensionPixelOffset(c.e.a.b.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f8042b.getResources().getDimensionPixelOffset(c.e.a.b.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        c.e.a.b.c0.g A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        c.e.a.b.c0.g A2 = A(Utils.FLOAT_EPSILON, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.l.addState(new int[0], A2);
        this.f8041a.setEndIconDrawable(b.a.k.a.a.d(this.f8042b, q ? c.e.a.b.e.mtrl_dropdown_arrow : c.e.a.b.e.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f8041a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.e.a.b.j.exposed_dropdown_menu_content_description));
        this.f8041a.setEndIconOnClickListener(new g());
        this.f8041a.e(this.f8023g);
        this.f8041a.f(this.f8024h);
        B();
        this.n = (AccessibilityManager) this.f8042b.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
