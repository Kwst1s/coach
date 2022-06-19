package com.rd.b.d;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.b.b.b;

/* compiled from: ColorAnimation */
public class c extends b<ValueAnimator> {

    /* renamed from: d  reason: collision with root package name */
    private com.rd.b.c.b.a f8524d = new com.rd.b.c.b.a();

    /* renamed from: e  reason: collision with root package name */
    int f8525e;

    /* renamed from: f  reason: collision with root package name */
    int f8526f;

    /* access modifiers changed from: package-private */
    /* compiled from: ColorAnimation */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.j(valueAnimator);
        }
    }

    public c(b.a aVar) {
        super(aVar);
    }

    private boolean i(int i2, int i3) {
        if (this.f8525e == i2 && this.f8526f == i3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        this.f8524d.c(intValue);
        this.f8524d.d(intValue2);
        b.a aVar = this.f8522b;
        if (aVar != null) {
            aVar.a(this.f8524d);
        }
    }

    @Override // com.rd.b.d.b
    public /* bridge */ /* synthetic */ b d(float f2) {
        k(f2);
        return this;
    }

    /* renamed from: g */
    public ValueAnimator a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    /* access modifiers changed from: package-private */
    public PropertyValuesHolder h(boolean z) {
        int i2;
        String str;
        int i3;
        if (z) {
            i2 = this.f8526f;
            i3 = this.f8525e;
            str = "ANIMATION_COLOR_REVERSE";
        } else {
            i2 = this.f8525e;
            i3 = this.f8526f;
            str = "ANIMATION_COLOR";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    public c k(float f2) {
        T t = this.f8523c;
        if (t != null) {
            long j2 = (long) (f2 * ((float) this.f8521a));
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.f8523c).getValues().length > 0) {
                ((ValueAnimator) this.f8523c).setCurrentPlayTime(j2);
            }
        }
        return this;
    }

    public c l(int i2, int i3) {
        if (this.f8523c != null && i(i2, i3)) {
            this.f8525e = i2;
            this.f8526f = i3;
            ((ValueAnimator) this.f8523c).setValues(h(false), h(true));
        }
        return this;
    }
}
