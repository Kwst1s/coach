package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.i;
import b.h.k.u;
import c.e.a.b.d;
import c.e.a.b.m.b;
import c.e.a.b.z.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: IndicatorViewController */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8044a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f8045b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f8046c;

    /* renamed from: d  reason: collision with root package name */
    private int f8047d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f8048e;

    /* renamed from: f  reason: collision with root package name */
    private Animator f8049f;

    /* renamed from: g  reason: collision with root package name */
    private final float f8050g;

    /* renamed from: h  reason: collision with root package name */
    private int f8051h;

    /* renamed from: i  reason: collision with root package name */
    private int f8052i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f8053j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8054k;
    private TextView l;
    private CharSequence m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    /* access modifiers changed from: package-private */
    /* compiled from: IndicatorViewController */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8055b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8056c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8057d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f8058e;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.f8055b = i2;
            this.f8056c = textView;
            this.f8057d = i3;
            this.f8058e = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            f.this.f8051h = this.f8055b;
            f.this.f8049f = null;
            TextView textView = this.f8056c;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8057d == 1 && f.this.l != null) {
                    f.this.l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f8058e;
            if (textView2 != null) {
                textView2.setTranslationY(Utils.FLOAT_EPSILON);
                this.f8058e.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8058e;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f8044a = context;
        this.f8045b = textInputLayout;
        this.f8050g = (float) context.getResources().getDimensionPixelSize(d.design_textinput_caption_translate_y);
    }

    private void A(int i2, int i3) {
        TextView l2;
        TextView l3;
        if (i2 != i3) {
            if (!(i3 == 0 || (l3 = l(i3)) == null)) {
                l3.setVisibility(0);
                l3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (l2 = l(i2)) == null)) {
                l2.setVisibility(4);
                if (i2 == 1) {
                    l2.setText((CharSequence) null);
                }
            }
            this.f8051h = i3;
        }
    }

    private void I(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void K(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(TextView textView, CharSequence charSequence) {
        return u.S(this.f8045b) && this.f8045b.isEnabled() && (this.f8052i != this.f8051h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void O(int i2, int i3, boolean z) {
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f8049f = animatorSet;
                ArrayList arrayList = new ArrayList();
                h(arrayList, this.q, this.r, 2, i2, i3);
                h(arrayList, this.f8054k, this.l, 1, i2, i3);
                b.a(animatorSet, arrayList);
                animatorSet.addListener(new a(i3, l(i2), i2, l(i3)));
                animatorSet.start();
            } else {
                A(i2, i3);
            }
            this.f8045b.r0();
            this.f8045b.u0(z);
            this.f8045b.E0();
        }
    }

    private boolean f() {
        return (this.f8046c == null || this.f8045b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                list.add(i(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(j(textView));
                }
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : Utils.FLOAT_EPSILON);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3375a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f8050g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(c.e.a.b.m.a.f3378d);
        return ofFloat;
    }

    private TextView l(int i2) {
        if (i2 == 1) {
            return this.l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    private int s(boolean z, int i2, int i3) {
        return z ? this.f8044a.getResources().getDimensionPixelSize(i2) : i3;
    }

    private boolean v(int i2) {
        if (i2 != 1 || this.l == null || TextUtils.isEmpty(this.f8053j)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void B(CharSequence charSequence) {
        this.m = charSequence;
        TextView textView = this.l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(boolean z) {
        if (this.f8054k != z) {
            g();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8044a);
                this.l = appCompatTextView;
                appCompatTextView.setId(c.e.a.b.f.textinput_error);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.l.setTextAlignment(5);
                }
                Typeface typeface = this.u;
                if (typeface != null) {
                    this.l.setTypeface(typeface);
                }
                D(this.n);
                E(this.o);
                B(this.m);
                this.l.setVisibility(4);
                u.o0(this.l, 1);
                d(this.l, 0);
            } else {
                t();
                z(this.l, 0);
                this.l = null;
                this.f8045b.r0();
                this.f8045b.E0();
            }
            this.f8054k = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void D(int i2) {
        this.n = i2;
        TextView textView = this.l;
        if (textView != null) {
            this.f8045b.e0(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(int i2) {
        this.s = i2;
        TextView textView = this.r;
        if (textView != null) {
            i.q(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(boolean z) {
        if (this.q != z) {
            g();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8044a);
                this.r = appCompatTextView;
                appCompatTextView.setId(c.e.a.b.f.textinput_helper_text);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.r.setTextAlignment(5);
                }
                Typeface typeface = this.u;
                if (typeface != null) {
                    this.r.setTypeface(typeface);
                }
                this.r.setVisibility(4);
                u.o0(this.r, 1);
                F(this.s);
                H(this.t);
                d(this.r, 1);
            } else {
                u();
                z(this.r, 1);
                this.r = null;
                this.f8045b.r0();
                this.f8045b.E0();
            }
            this.q = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            I(this.l, typeface);
            I(this.r, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.f8053j = charSequence;
        this.l.setText(charSequence);
        int i2 = this.f8051h;
        if (i2 != 1) {
            this.f8052i = 1;
        }
        O(i2, this.f8052i, L(this.l, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void N(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i2 = this.f8051h;
        if (i2 != 2) {
            this.f8052i = 2;
        }
        O(i2, this.f8052i, L(this.r, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void d(TextView textView, int i2) {
        if (this.f8046c == null && this.f8048e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f8044a);
            this.f8046c = linearLayout;
            linearLayout.setOrientation(0);
            this.f8045b.addView(this.f8046c, -1, -2);
            this.f8048e = new FrameLayout(this.f8044a);
            this.f8046c.addView(this.f8048e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f8045b.getEditText() != null) {
                e();
            }
        }
        if (w(i2)) {
            this.f8048e.setVisibility(0);
            this.f8048e.addView(textView);
        } else {
            this.f8046c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f8046c.setVisibility(0);
        this.f8047d++;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            EditText editText = this.f8045b.getEditText();
            boolean g2 = c.g(this.f8044a);
            LinearLayout linearLayout = this.f8046c;
            int i2 = d.material_helper_text_font_1_3_padding_horizontal;
            u.A0(linearLayout, s(g2, i2, u.G(editText)), s(g2, d.material_helper_text_font_1_3_padding_top, 0), s(g2, i2, u.F(editText)), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Animator animator = this.f8049f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return v(this.f8052i);
    }

    /* access modifiers changed from: package-private */
    public CharSequence m() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f8053j;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList p() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence q() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f8053j = null;
        g();
        if (this.f8051h == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.f8052i = 0;
            } else {
                this.f8052i = 2;
            }
        }
        O(this.f8051h, this.f8052i, L(this.l, null));
    }

    /* access modifiers changed from: package-private */
    public void u() {
        g();
        int i2 = this.f8051h;
        if (i2 == 2) {
            this.f8052i = 0;
        }
        O(i2, this.f8052i, L(this.r, null));
    }

    /* access modifiers changed from: package-private */
    public boolean w(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f8054k;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void z(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f8046c != null) {
            if (!w(i2) || (frameLayout = this.f8048e) == null) {
                this.f8046c.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.f8047d - 1;
            this.f8047d = i3;
            K(this.f8046c, i3);
        }
    }
}
