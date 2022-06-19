package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.d;

/* compiled from: ScaleAnimation */
public class f extends c {

    /* renamed from: g  reason: collision with root package name */
    int f8545g;

    /* renamed from: h  reason: collision with root package name */
    float f8546h;

    /* renamed from: i  reason: collision with root package name */
    private d f8547i = new d();

    /* access modifiers changed from: package-private */
    /* compiled from: ScaleAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.j(valueAnimator);
        }
    }

    public f(b.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        this.f8547i.c(intValue);
        this.f8547i.d(intValue2);
        this.f8547i.g(intValue3);
        this.f8547i.h(intValue4);
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8547i);
        }
    }

    private boolean o(int i2, int i3, int i4, float f2) {
        if (this.f8525e == i2 && this.f8526f == i3 && this.f8545g == i4 && this.f8546h == f2) {
            return false;
        }
        return true;
    }

    @Override // com.rd.b.d.c
    /* renamed from: g */
    public ValueAnimator a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    /* access modifiers changed from: protected */
    public PropertyValuesHolder n(boolean z) {
        int i2;
        String str;
        int i3;
        if (z) {
            i2 = this.f8545g;
            i3 = (int) (((float) i2) * this.f8546h);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i3 = this.f8545g;
            i2 = (int) (((float) i3) * this.f8546h);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    public f p(int i2, int i3, int i4, float f2) {
        if (this.f8523c != null && o(i2, i3, i4, f2)) {
            this.f8525e = i2;
            this.f8526f = i3;
            this.f8545g = i4;
            this.f8546h = f2;
            ((ValueAnimator) this.f8523c).setValues(h(false), h(true), n(false), n(true));
        }
        return this;
    }
}
