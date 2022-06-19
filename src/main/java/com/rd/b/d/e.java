package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;
import com.rd.b.c.b.c;

/* compiled from: FillAnimation */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    private c f8541g = new c();

    /* renamed from: h  reason: collision with root package name */
    private int f8542h;

    /* renamed from: i  reason: collision with root package name */
    private int f8543i;

    /* access modifiers changed from: package-private */
    /* compiled from: FillAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.j(valueAnimator);
        }
    }

    public e(b.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
        this.f8541g.c(intValue);
        this.f8541g.d(intValue2);
        this.f8541g.i(intValue3);
        this.f8541g.j(intValue4);
        this.f8541g.k(intValue5);
        this.f8541g.l(intValue6);
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8541g);
        }
    }

    private PropertyValuesHolder n(boolean z) {
        int i2;
        String str;
        int i3;
        if (z) {
            i2 = this.f8542h;
            i3 = i2 / 2;
            str = "ANIMATION_RADIUS_REVERSE";
        } else {
            i3 = this.f8542h;
            i2 = i3 / 2;
            str = "ANIMATION_RADIUS";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i3, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private PropertyValuesHolder o(boolean z) {
        int i2;
        String str;
        int i3;
        if (z) {
            i2 = this.f8542h;
            str = "ANIMATION_STROKE_REVERSE";
            i3 = 0;
        } else {
            str = "ANIMATION_STROKE";
            i3 = this.f8542h;
            i2 = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean p(int i2, int i3, int i4, int i5) {
        if (this.f8525e == i2 && this.f8526f == i3 && this.f8542h == i4 && this.f8543i == i5) {
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

    public e q(int i2, int i3, int i4, int i5) {
        if (this.f8523c != null && p(i2, i3, i4, i5)) {
            this.f8525e = i2;
            this.f8526f = i3;
            this.f8542h = i4;
            this.f8543i = i5;
            ((ValueAnimator) this.f8523c).setValues(h(false), h(true), n(false), n(true), o(false), o(true));
        }
        return this;
    }
}
