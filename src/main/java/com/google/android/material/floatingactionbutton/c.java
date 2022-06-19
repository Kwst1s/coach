package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import b.h.j.h;
import c.e.a.b.b0.b;
import c.e.a.b.c0.g;
import c.e.a.b.c0.k;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImplLollipop */
public class c extends b {

    /* access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImplLollipop */
    public static class a extends g {
        a(k kVar) {
            super(kVar);
        }

        @Override // c.e.a.b.c0.g
        public boolean isStateful() {
            return true;
        }
    }

    c(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator j0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(b.F);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void A() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void C() {
        f0();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.y.isEnabled()) {
            this.y.setElevation(this.f7787h);
            if (this.y.isPressed()) {
                this.y.setTranslationZ(this.f7789j);
            } else if (this.y.isFocused() || this.y.isHovered()) {
                this.y.setTranslationZ(this.f7788i);
            } else {
                this.y.setTranslationZ(Utils.FLOAT_EPSILON);
            }
        } else {
            this.y.setElevation(Utils.FLOAT_EPSILON);
            this.y.setTranslationZ(Utils.FLOAT_EPSILON);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void F(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(b.G, j0(f2, f4));
            stateListAnimator.addState(b.H, j0(f2, f3));
            stateListAnimator.addState(b.I, j0(f2, f3));
            stateListAnimator.addState(b.J, j0(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(b.F);
            stateListAnimator.addState(b.K, animatorSet);
            stateListAnimator.addState(b.L, j0(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (Z()) {
            f0();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public boolean K() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f7782c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(c.e.a.b.a0.b.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public boolean Z() {
        return this.z.c() || !b0();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void d0() {
    }

    /* access modifiers changed from: package-private */
    public a i0(int i2, ColorStateList colorStateList) {
        Context context = this.y.getContext();
        k kVar = this.f7780a;
        h.c(kVar);
        a aVar = new a(kVar);
        aVar.e(b.h.d.a.b(context, c.e.a.b.c.design_fab_stroke_top_outer_color), b.h.d.a.b(context, c.e.a.b.c.design_fab_stroke_top_inner_color), b.h.d.a.b(context, c.e.a.b.c.design_fab_stroke_end_inner_color), b.h.d.a.b(context, c.e.a.b.c.design_fab_stroke_end_outer_color));
        aVar.d((float) i2);
        aVar.c(colorStateList);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public g j() {
        k kVar = this.f7780a;
        h.c(kVar);
        return new a(kVar);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public float n() {
        return this.y.getElevation();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void s(Rect rect) {
        if (this.z.c()) {
            super.s(rect);
        } else if (!b0()) {
            int sizeDimension = (this.f7790k - this.y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        g j2 = j();
        this.f7781b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.f7781b.setTintMode(mode);
        }
        this.f7781b.M(this.y.getContext());
        if (i2 > 0) {
            this.f7783d = i0(i2, colorStateList);
            a aVar = this.f7783d;
            h.c(aVar);
            g gVar = this.f7781b;
            h.c(gVar);
            drawable = new LayerDrawable(new Drawable[]{aVar, gVar});
        } else {
            this.f7783d = null;
            drawable = this.f7781b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(c.e.a.b.a0.b.d(colorStateList2), drawable, null);
        this.f7782c = rippleDrawable;
        this.f7784e = rippleDrawable;
    }
}
