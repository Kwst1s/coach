package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import c.e.a.b.j;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

/* access modifiers changed from: package-private */
/* compiled from: ClearTextEndIconDelegate */
public class a extends e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f8005d = new C0157a();

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f8006e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.f f8007f = new c();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.g f8008g = new d();

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f8009h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f8010i;

    /* renamed from: com.google.android.material.textfield.a$a  reason: collision with other inner class name */
    /* compiled from: ClearTextEndIconDelegate */
    class C0157a implements TextWatcher {
        C0157a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.f8041a.getSuffixText() == null) {
                a.this.i(a.l(editable));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.i(z2);
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f8006e);
            editText.removeTextChangedListener(a.this.f8005d);
            editText.addTextChangedListener(a.this.f8005d);
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    class d implements TextInputLayout.g {
        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.removeTextChangedListener(a.this.f8005d);
                if (editText.getOnFocusChangeListener() == a.this.f8006e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Editable text = a.this.f8041a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f8041a.V();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        public void onAnimationStart(Animator animator) {
            a.this.f8041a.setEndIconVisible(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f8041a.setEndIconVisible(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f8043c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f8043c.setScaleX(floatValue);
            a.this.f8043c.setScaleY(floatValue);
        }
    }

    a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(boolean z) {
        boolean z2 = this.f8041a.K() == z;
        if (z) {
            this.f8010i.cancel();
            this.f8009h.start();
            if (z2) {
                this.f8009h.end();
                return;
            }
            return;
        }
        this.f8009h.cancel();
        this.f8010i.start();
        if (z2) {
            this.f8010i.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3375a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3378d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public static boolean l(Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator k2 = k();
        ValueAnimator j2 = j(Utils.FLOAT_EPSILON, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8009h = animatorSet;
        animatorSet.playTogether(k2, j2);
        this.f8009h.addListener(new f());
        ValueAnimator j3 = j(1.0f, Utils.FLOAT_EPSILON);
        this.f8010i = j3;
        j3.addListener(new g());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f8041a.setEndIconDrawable(b.a.k.a.a.d(this.f8042b, c.e.a.b.e.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f8041a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.clear_text_end_icon_content_description));
        this.f8041a.setEndIconOnClickListener(new e());
        this.f8041a.e(this.f8007f);
        this.f8041a.f(this.f8008g);
        m();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void c(boolean z) {
        if (this.f8041a.getSuffixText() != null) {
            i(z);
        }
    }
}
